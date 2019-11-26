/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.withdrawrecord.impl.WithdrawRecordServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Elias Zheng
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年9月8日    Elias Zheng  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.withdrawrecord.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.controller.withdraw.WithdrawController;
import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountlevel.AccountLevelMapper;
import com.xed.financing.wxgzh.mapper.accountwithdraw.AccountWithdrawMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.coupon.CouponMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.mapper.revenueSettlement.RevenueSettlementMapper;
import com.xed.financing.wxgzh.mapper.withdrawrecord.WithdrawRecordMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountwithdraw.AccountWithdrawBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.message.CompanyMessageBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.withdrawrecord.WithdrawRecordBean;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.messagecode.MessageCodeService;
import com.xed.financing.wxgzh.service.withdrawrecord.WithdrawRecordService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.LevelParam;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * @className:com.xed.financing.wxgzh.service.withdrawrecord.impl.WithdrawRecordServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年9月8日 下午3:30:55
 * @author:Elias Zheng
 */
@Service
public class WithdrawRecordServiceImpl implements WithdrawRecordService
{
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(WithdrawRecordServiceImpl.class);

	@Resource
	private WithdrawRecordMapper withdrawRecordMapper;
	
	@Resource
	private CapitalMapper capitalMapper;
	
	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private RevenueSettlementMapper revenueSettlementMapper;
	
	@Resource
	private ParamMapper paramMapper;
	
	@Resource
	private AccountLevelMapper accountLevelMapper;
	
	@Autowired
	private MessageCodeService messageCodeService;
	
	@Resource
	private CouponMapper couponMapper;
	
	@Resource
	private BondTransferMapper bondTransferMapper;
	
	@Autowired
	private AccountLevelService accountLevelService;
	
	@Resource
	private CapitalMapper capMapper;

	@Resource
	private AccountWithdrawMapper accountWithdrawMapper;
	
	@Resource
	public AccountInfoMapper accountInfoMapper;
	
	
	@Override
	public List<WithdrawRecordBean> queryWithdrawRecords(WithdrawRecordBean withdrawRecordBean) throws Exception
	{
		return withdrawRecordMapper.queryWithdrawRecords(withdrawRecordBean);
	}

	
	@Override
	public WithdrawRecordBean queryWithdrawRecord(WithdrawRecordBean withdrawRecordBean) throws Exception
	{
		return withdrawRecordMapper.queryWithdrawRecord(withdrawRecordBean);
	}

	
	@Override
	public void addWithdrawRecord(WithdrawRecordBean withdrawRecordBean) throws Exception
	{
		withdrawRecordMapper.addWithdrawRecord(withdrawRecordBean);
	}

	
	@Override
	public void updateWithdrawRecord(WithdrawRecordBean withdrawRecordBean) throws Exception
	{
		withdrawRecordMapper.updateWithdrawRecord(withdrawRecordBean);
	}

	
	@Override
	public void deleteWithdrawRecord(WithdrawRecordBean withdrawRecordBean) throws Exception
	{
		withdrawRecordMapper.deleteWithdrawRecord(withdrawRecordBean);
	}

	
	@Override
	public void doWithdrawTiming() throws Exception
	{
		WithdrawRecordBean withdrawRecordBean = new WithdrawRecordBean();
		withdrawRecordBean.setWithdrawStatus(Constants.DEVIL_NUM_ONE); // 查询所有提现中的状态,进行操作
		List<WithdrawRecordBean> wdrList = null;
		try
		{
			System.out.println("<------------------猫咪宝提现到账操作开始---------------------->");
			wdrList = withdrawRecordMapper.queryWithdrawRecords(withdrawRecordBean);
			for (WithdrawRecordBean withdrawRecord : wdrList)
			{
				// 1.资金表更新
				AccountCapital accountCapital = revenueSettlementMapper.getBalances(withdrawRecord.getAccountId());
				
				//提现中金额减        可用余额加
				String nowWithdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(accountCapital.getNowWithdrawMoney()) - Double.parseDouble(withdrawRecord.getMoney()));
				String withdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(accountCapital.getWithdrawMoney()) + Double.parseDouble(withdrawRecord.getMoney()));
				withdrawMoney = withdrawMoney.substring(0, withdrawMoney.indexOf("."));
				nowWithdrawMoney = nowWithdrawMoney.substring(0, nowWithdrawMoney.indexOf("."));
				accountCapital.setNowWithdrawMoney(String.valueOf(nowWithdrawMoney));
				accountCapital.setWithdrawMoney(String.valueOf(withdrawMoney));
				
				// 修改金额
				revenueSettlementMapper.changeFunds(accountCapital);

				// 2.提现表更新
				withdrawRecord.setWithdrawStatus(Constants.DEVIL_NUM_ZERO);
				withdrawRecord.setRemark("用户提现到账~");
				withdrawRecord.setIsArrival(Constants.DEVIL_NUM_ONE);
				withdrawRecordMapper.updateWithdrawRecord(withdrawRecord);

				// 3.消息表
				MessageBean messageBean = new MessageBean();
				messageBean.setAccountId(withdrawRecord.getAccountId());
				messageBean.setMsgTitle("猫咪宝资金转出(已到帐)");
				messageBean.setMsgContent("猫咪宝转出" + Double.parseDouble(withdrawRecord.getMoney()) / 100 + "元已到帐,请关注您的余额.详情请在我的<a href='javascript:void(0)' onclick='goDetails(8)'>我的猫咪宝</a>中查看。");
				messageMapper.addMessageInfo(messageBean);
				
				System.out.println("用户:" + accountCapital.getAccountId() + "提现到账");
				
			}
			System.out.println("<------------------猫咪宝提现到账操作结束---------------------->");
		}
		catch (Exception e)
		{
			logger.error("猫咪宝提现到账提示异常", e);
			System.out.println("<------------------猫咪宝提现到账操作异常---------------------->");
		}
	}

	@Override
	@Transactional
	public String withdrawMon(HttpServletRequest request, HttpServletResponse response,
			String accountName, String bankCard, Double money, String bankName, String isComp, String count,Boolean tq,Boolean txq) throws Exception
	{
		String result = "error";
		String phone = paramMapper.getParamVal("WITHDRAW_PHONE");
		AccountInfo account = (AccountInfo) request.getSession().getAttribute("account");
		try
		{
			if (money < 0)
			{
				return result;
			}
			//查询资金表信息
			AccountCapital accountCapital = revenueSettlementMapper.getBalances(account.getAccountId());
			//可用余额
			Integer withMoney = Integer.parseInt(accountCapital.getWithdrawMoney());
			//金账户金额
			Integer noWithMoney = Integer.parseInt(accountCapital.getNoWithdrawMoney());
			
			//本次提现金额
			Integer txje =Integer.parseInt(MoneyUtils.changeYToF(String.valueOf(money)));
			
			//提现后账户所剩金额
			Integer mon = withMoney + noWithMoney - txje;
			String code = "";
			// 判断是否可提现
			if (mon < 0)
			{
				code = "error";
			}
			else
			{
				Integer txMoney = txje;
				Integer jzhtxMoney = 0;
				if(withMoney<txMoney){
					jzhtxMoney = txMoney - withMoney;
					noWithMoney = noWithMoney +withMoney - txMoney;
					
					txMoney = withMoney;
					withMoney = 0;
				}else{
					withMoney = withMoney-txMoney;
				}
				accountCapital.setWithdrawMoney(String.valueOf(withMoney));
				accountCapital.setNoWithdrawMoney(String.valueOf(noWithMoney));
				
				

				AccountInfo accountInfo= accountLevelMapper.queryAccountLevel(account);
				//是否是特权提现
				if(tq){
					
					Integer wCount = Integer.parseInt(accountInfo.getWithdrawalsNumber());
					if(wCount>0){
						Integer xemoney = LevelParam.WITHDRAWALS_MONEY.get(Integer.parseInt(accountInfo.getAccountLevel()));
						if(xemoney>=money){
							accountInfo.setWithdrawalsNumber(String.valueOf(wCount-1));
						}else{
							
							return "overtop";
						}
					}else{
						return "notEnough";
					}
					
				}
				
				Integer freeCount = Integer.parseInt(accountInfo.getFreeWithdrawalsNumber());
				if(freeCount<=0 && !txq){
					//扣除2元提现费
					money = money -2;
					if(txMoney>200){
						txMoney = txMoney-200;
					}else{
						jzhtxMoney = jzhtxMoney+txMoney -200;
						txMoney = 0;
					}
				}
				//是否特权提现
				if(tq){
					WithdrawController.msgSend(account.getRealName(), bankName, String.valueOf(money), bankCard, phone,tq);
				}
				code = "200";
				messageCodeService.addMessage(phone, "6");
			
					if (code.equals("200"))
					{
						
						if(freeCount>0){
							//消耗免费提现次数
							freeCount--;
							accountInfo.setFreeWithdrawalsNumber(String.valueOf(freeCount));
						}else if (txq){
							//消耗提现券
							CouponBean couponBean = new CouponBean();
							couponBean.setAccountId(account.getAccountId());
							couponBean.setCouponType("4");
							couponBean = couponMapper.selectNotUsedByType(couponBean);
							couponMapper.updateCouponStatus(couponBean);
						}else{
							//提现费明细
							CapitalDetail capitalDetail = new CapitalDetail();
							capitalDetail.setAccountId(account.getAccountId());
							capitalDetail.setMoney("200");

							// 交易类型(0:储蓄卡充值 1:微信充值 2:信用卡充值 3:投资投标 4:投资投标收益 5:提现)
							capitalDetail.setType("21");

							// 金额收支(0:收入 1:支出)
							capitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
							capitalDetail.setRemark("提现手续费2元");
							bondTransferMapper.addCapital(capitalDetail);
						}
						accountLevelService.updateAccountVIP(accountInfo);
						
						
						
						Boolean mum = revenueSettlementMapper.changeFunds(accountCapital);
						CapitalDetail capitalDetail=new CapitalDetail();
						if (!mum)
						{
							//修改资金表失败
							MessageBean messageBean = new MessageBean();
							messageBean.setAccountId(account.getAccountId());
							messageBean.setMsgTitle("提现失败");
							messageBean.setMsgContent("您于" + new SimpleDateFormat("yyyy.MM.dd").format(new Date()) + "申请提现"
									+ String.valueOf(money) + "元.<br/>资金提现失败,若有问题,请及时联系客服.");
							messageMapper.addMessageInfo(messageBean);
						}else{
							//提现发送给用户
							WithdrawController.msgSendYh(account, String.valueOf(money));
							messageCodeService.addMessage(account.getTelephone(), "2");
							
							//添加资金明细
							capitalDetail.setAccountId(account.getAccountId());
							capitalDetail.setMoney(String.valueOf(money));
							capitalDetail.setFlag(tq);
							capitalDetail=addCapitalDetail(capitalDetail);
							
							//发送消息
							MessageBean messageBean = new MessageBean();
							messageBean.setAccountId(account.getAccountId());
							messageBean.setMsgTitle("提现成功");
							messageBean.setMsgContent("您于" + new SimpleDateFormat("yyyy.MM.dd").format(new Date()) + "申请提现"
									+ String.valueOf(money) + "元.<br/>资金将于1-3个工作日内提现至您的银行卡账户内,若1-3个工作日未到账,请及时联系客服.");
							messageMapper.addMessageInfo(messageBean);
							if (count.equals(Constants.DEVIL_NUM_ZERO) && isComp.equals(Constants.DEVIL_NUM_ONE))
							{
								String contents = "企业用户首次提现，将获得10元奖励金，自动转入到您绑定的银行卡，将在1~3个工作日到账";
								CompanyMessageBean companyMessageBean = new CompanyMessageBean();
								companyMessageBean.setAccountId(account.getAccountId());
								companyMessageBean.setMsgContent(contents);
								// 通知类型（0首次充值奖励，1首次投标奖励）
								companyMessageBean.setMsgType(Constants.DEVIL_NUM_ZERO);
								// 是否发送（0未发送，1已发送）
								companyMessageBean.setIsSend(Constants.DEVIL_NUM_ZERO);

								// 添加企业用户消息通知
								messageMapper.addCompanyMessage(companyMessageBean);

								MessageBean messageBeans = new MessageBean();
								messageBeans.setAccountId(account.getAccountId());
								messageBeans.setMsgTitle("企业用户首次提现奖励");
								messageBeans.setMsgContent(contents);

								// 添加系统消息
								messageMapper.addMessageInfo(messageBeans);

							}
						}
						if(txMoney!=0){
							AccountWithdrawBean accountWithdrawBean = new AccountWithdrawBean();
							accountWithdrawBean.setAccountId(account.getAccountId());
							accountWithdrawBean.setMoney(String.valueOf(txMoney));
							accountWithdrawBean.setType("1");
							accountWithdrawBean.setCapitalDetailId(capitalDetail.getId());
							accountWithdrawMapper.addAccountWithdraw(accountWithdrawBean);
						}
						if(jzhtxMoney!=0){
							AccountWithdrawBean accountWithdrawBean = new AccountWithdrawBean();
							accountWithdrawBean.setAccountId(account.getAccountId());
							accountWithdrawBean.setMoney(String.valueOf(jzhtxMoney));
							accountWithdrawBean.setType("2");
							accountWithdrawBean.setCapitalDetailId(capitalDetail.getId());
							accountWithdrawMapper.addAccountWithdraw(accountWithdrawBean);
						}
				}
				
			}
			result =  code;
		}
		catch (Exception e)
		{
			logger.error("提现模块，查询个人账户异常", e);
			e.printStackTrace();
			throw new RuntimeException();
		}
		return result;
	}
	
	private CapitalDetail addCapitalDetail(CapitalDetail detail) throws SQLException
	{
		CapitalDetail capitalDetail = new CapitalDetail();
		capitalDetail.setAccountId(detail.getAccountId());
		capitalDetail.setMoney(String.valueOf(Double.parseDouble(detail.getMoney()) * 100));

		// 交易类型(0:储蓄卡充值 1:微信充值 2:信用卡充值 3:投资投标 4:投资投标收益 5:提现)
		capitalDetail.setType(Constants.DEVIL_NUM_FIVE);

		// 金额收支(0:收入 1:支出)
		capitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
		if(detail.getFlag()){
			capitalDetail.setRemark("特权提现" + detail.getMoney() + "元");
		}else{
			capitalDetail.setRemark("提现" + detail.getMoney() + "元");
		}
		bondTransferMapper.addCapital(capitalDetail);
		return capitalDetail;
	}


	@Override
	@Transactional
	public String iosWithdrawMon(String accountId,String accountName, String bankCard, Double money, String bankName, String isComp,
			String count, Boolean tq, Boolean txq) throws Exception
	{
		String result = "error";
		String phone = paramMapper.getParamVal("WITHDRAW_PHONE");
		AccountInfo account = accountInfoMapper.getLoginAccountInfo(accountId);
		try
		{
			if (money < 0)
			{
				return result;
			}
			//查询资金表信息
			AccountCapital accountCapital = revenueSettlementMapper.getBalances(account.getAccountId());
			//可用余额
			Integer withMoney = Integer.parseInt(accountCapital.getWithdrawMoney());
			//金账户金额
			Integer noWithMoney = Integer.parseInt(accountCapital.getNoWithdrawMoney());
			
			//本次提现金额
			Integer txje =Integer.parseInt(MoneyUtils.changeYToF(String.valueOf(money)));
			
			//提现后账户所剩金额
			Integer mon = withMoney + noWithMoney - txje;
			String code = "";
			// 判断是否可提现
			if (mon < 0)
			{
				code = "error";
			}
			else
			{
				Integer txMoney = txje;
				Integer jzhtxMoney = 0;
				if(withMoney<txMoney){
					jzhtxMoney = txMoney - withMoney;
					noWithMoney = noWithMoney +withMoney - txMoney;
					
					txMoney = withMoney;
					withMoney = 0;
				}else{
					withMoney = withMoney-txMoney;
				}
				accountCapital.setWithdrawMoney(String.valueOf(withMoney));
				accountCapital.setNoWithdrawMoney(String.valueOf(noWithMoney));
				
				

				AccountInfo accountInfo= accountLevelMapper.queryAccountLevel(account);
				//是否是特权提现
				if(tq){
					
					Integer wCount = Integer.parseInt(accountInfo.getWithdrawalsNumber());
					if(wCount>0){
						Integer xemoney = LevelParam.WITHDRAWALS_MONEY.get(Integer.parseInt(accountInfo.getAccountLevel()));
						if(xemoney>=money){
							accountInfo.setWithdrawalsNumber(String.valueOf(wCount-1));
						}else{
							
							return "overtop";
						}
					}else{
						return "notEnough";
					}
					
				}
				
				Integer freeCount = Integer.parseInt(accountInfo.getFreeWithdrawalsNumber());
				if(freeCount<=0 && !txq){
					//扣除2元提现费
					money = money -2;
					if(txMoney>200){
						txMoney = txMoney-200;
					}else{
						jzhtxMoney = jzhtxMoney+txMoney -200;
						txMoney = 0;
					}
				}
				//code = WithdrawController.msgSend(account.getRealName(), bankName, String.valueOf(money), bankCard, phone,tq);
				code = "200";
				messageCodeService.addMessage(phone, "6");
			
					if (code.equals("200"))
					{
						if(freeCount>0){
							//消耗免费提现次数
							freeCount--;
							accountInfo.setFreeWithdrawalsNumber(String.valueOf(freeCount));
						}else if (txq){
							//消耗提现券
							CouponBean couponBean = new CouponBean();
							couponBean.setAccountId(account.getAccountId());
							couponBean.setCouponType("4");
							couponBean = couponMapper.selectNotUsedByType(couponBean);
							couponMapper.updateCouponStatus(couponBean);
						}else{
							//提现费明细
							
							CapitalDetail capitalDetail = new CapitalDetail();
							capitalDetail.setAccountId(account.getAccountId());
							capitalDetail.setMoney("200");

							// 交易类型(0:储蓄卡充值 1:微信充值 2:信用卡充值 3:投资投标 4:投资投标收益 5:提现)
							capitalDetail.setType("21");

							// 金额收支(0:收入 1:支出)
							capitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
							capitalDetail.setRemark("提现手续费2元");
							bondTransferMapper.addCapital(capitalDetail);
						}
						accountLevelService.updateAccountVIP(accountInfo);
						
						
						
						Boolean mum = revenueSettlementMapper.changeFunds(accountCapital);
						CapitalDetail capitalDetail=new CapitalDetail();
						if (!mum)
						{
							//修改资金表失败
							MessageBean messageBean = new MessageBean();
							messageBean.setAccountId(account.getAccountId());
							messageBean.setMsgTitle("提现失败");
							messageBean.setMsgContent("您于" + new SimpleDateFormat("yyyy.MM.dd").format(new Date()) + "申请提现"
									+ String.valueOf(money) + "元.<br/>资金提现失败,若有问题,请及时联系客服.");
							messageMapper.addMessageInfo(messageBean);
						}else{
							//提现发送给用户
							WithdrawController.msgSendYh(account, String.valueOf(money));
							messageCodeService.addMessage(account.getTelephone(), "2");
							
							//添加资金明细
							capitalDetail.setAccountId(account.getAccountId());
							capitalDetail.setMoney(String.valueOf(money));
							capitalDetail.setFlag(tq);
							capitalDetail=addCapitalDetail(capitalDetail);
							
							MessageBean messageBean = new MessageBean();
							messageBean.setAccountId(account.getAccountId());
							messageBean.setMsgTitle("提现成功");
							messageBean.setMsgContent("您于" + new SimpleDateFormat("yyyy.MM.dd").format(new Date()) + "申请提现"
									+ String.valueOf(money) + "元.<br/>资金将于1-3个工作日内提现至您的银行卡账户内,若1-3个工作日未到账,请及时联系客服.");
							messageMapper.addMessageInfo(messageBean);
							if (count.equals(Constants.DEVIL_NUM_ZERO) && isComp.equals(Constants.DEVIL_NUM_ONE))
							{
								String contents = "企业用户首次提现，将获得10元奖励金，自动转入到您绑定的银行卡，将在1~3个工作日到账";
								CompanyMessageBean companyMessageBean = new CompanyMessageBean();
								companyMessageBean.setAccountId(account.getAccountId());
								companyMessageBean.setMsgContent(contents);
								// 通知类型（0首次充值奖励，1首次投标奖励）
								companyMessageBean.setMsgType(Constants.DEVIL_NUM_ZERO);
								// 是否发送（0未发送，1已发送）
								companyMessageBean.setIsSend(Constants.DEVIL_NUM_ZERO);

								// 添加企业用户消息通知
								messageMapper.addCompanyMessage(companyMessageBean);

								MessageBean messageBeans = new MessageBean();
								messageBeans.setAccountId(account.getAccountId());
								messageBeans.setMsgTitle("企业用户首次提现奖励");
								messageBeans.setMsgContent(contents);

								// 添加系统消息
								messageMapper.addMessageInfo(messageBeans);

							}
						}
						if(txMoney!=0){
							AccountWithdrawBean accountWithdrawBean = new AccountWithdrawBean();
							accountWithdrawBean.setAccountId(account.getAccountId());
							accountWithdrawBean.setMoney(String.valueOf(txMoney));
							accountWithdrawBean.setType("1");
							accountWithdrawBean.setCapitalDetailId(capitalDetail.getId());
							accountWithdrawMapper.addAccountWithdraw(accountWithdrawBean);
						}
						if(jzhtxMoney!=0){
							AccountWithdrawBean accountWithdrawBean = new AccountWithdrawBean();
							accountWithdrawBean.setAccountId(account.getAccountId());
							accountWithdrawBean.setMoney(String.valueOf(jzhtxMoney));
							accountWithdrawBean.setType("2");
							accountWithdrawBean.setCapitalDetailId(capitalDetail.getId());
							accountWithdrawMapper.addAccountWithdraw(accountWithdrawBean);
						}
				}
				
			}
			result =  code;
		}
		catch (Exception e)
		{
			logger.error("提现模块，查询个人账户异常", e);
			e.printStackTrace();
			throw new RuntimeException();
		}
		return result;
	}
}
