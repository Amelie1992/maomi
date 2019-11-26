/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年8月22日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.freedomsubject.impl;

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
import com.xed.financing.wxgzh.mapper.accountlevel.AccountLevelMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.freesubject.FreedomSubjectMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.mapper.revenueSettlement.RevenueSettlementMapper;
import com.xed.financing.wxgzh.mapper.withdrawrecord.WithdrawRecordMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;
import com.xed.financing.wxgzh.model.message.CompanyMessageBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.LevelParam;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * 猫咪宝service实现类
 * @className:com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年8月22日 下午2:02:18
 * @author:Qian Tao
 */
@Service
public class FreedomSubjectServiceImpl implements FreedomSubjectService
{
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(FreedomSubjectServiceImpl.class);
	
	@Autowired
	private FreedomSubjectMapper freedomSubjectMapper;

	@Autowired
	private CapitalMapper capitalMapper;
	
	/**
	 * 转让mapper
	 */
	@Resource
	private BondTransferMapper bondTransferMapper;
	
	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private RevenueSettlementMapper revenueSettlementMapper;
	
	@Resource
	private ParamMapper paramMapper;
	
	@Resource
	private CapitalMapper CapitalMapper;
	
	@Autowired
	private WithdrawRecordMapper withdrawRecordMapper;
	
	@Resource
	private AccountLevelMapper accountLevelMapper;
	
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService#queryFreedomSubject(FreedomSubjectBean)
	 */
	@Override
	public List<FreedomSubjectBean> queryFreedomSubject(FreedomSubjectBean freedomSubjectBean) throws SQLException
	{
		return freedomSubjectMapper.queryFreedomSubject(freedomSubjectBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService#countFreedomSubject(FreedomSubjectBean)
	 */
	@Override
	public Integer countFreedomSubject(FreedomSubjectBean freedomSubjectBean) throws SQLException
	{
		return freedomSubjectMapper.countFreedomSubject(freedomSubjectBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService#queryFreedomSubjectById(FreedomSubjectBean)
	 */
	@Override
	public FreedomSubjectBean queryFreedomSubjectById(FreedomSubjectBean freedomSubjectBean) throws SQLException
	{
		return freedomSubjectMapper.queryFreedomSubjectById(freedomSubjectBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService#querySevenRateAndPromit(FreedomSubjectBean)
	 */
	@Override
	public List<FreedomSubjectBean> querySevenRateAndPromit(FreedomSubjectBean freedomSubjectBean) throws SQLException
	{
		return freedomSubjectMapper.querySevenRateAndPromit(freedomSubjectBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService#FreedomSubjectBean(FreedomSubjectBean)
	 */
	@Override
	public Integer countSevenRateAndPromit(FreedomSubjectBean freedomSubjectBean) throws SQLException
	{
		return freedomSubjectMapper.countSevenRateAndPromit(freedomSubjectBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService#queryFreedomRecord(FreedomSubjectBean)
	 */
	@Override
	public List<FreedomSubjectBean> queryFreedomRecord(FreedomSubjectBean freedomSubjectBean) throws SQLException
	{
		return freedomSubjectMapper.queryFreedomRecord(freedomSubjectBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService#countFreedomRecord(FreedomSubjectBean)
	 */
	@Override
	public Integer countFreedomRecord(FreedomSubjectBean freedomSubjectBean)
			throws SQLException
	{
		return freedomSubjectMapper.countFreedomRecord(freedomSubjectBean);
	}

	@Override
	@Transactional
	public void investFreedom(FreedomSubjectBean freedomSubjectBean,String money) throws SQLException
	{
		
			String accountId =freedomSubjectBean.getAccountId();
			//*******************修改可用金额，增加猫咪宝金额***************************
			AccountCapital accountCapital=new AccountCapital();
			accountCapital.setAccountId(accountId);
			
			//查询bean
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			double yMoney = Double.parseDouble(money);
			capitalBean = capitalMapper.queryCapitalById(capitalBean);
	
			//用户猫咪宝总金额
			double freedomMoney = capitalBean.getFreedomMoney(); 
			
			//可提现金额
			double wMoney = capitalBean.getWithdrawMoney();
			
			//不可提现金额
			double nwMoney = capitalBean.getNoWithdrawMoney();
			//不可提现金额大于等于用户投标本金
			if(nwMoney>=yMoney)
			{
				accountCapital.setNoWithdrawMoney(MoneyUtils.formatFloatNumber((nwMoney-yMoney)*100));
				accountCapital.setWithdrawMoney(MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()*100));
			}
			//不可提现金额不够扣  不可提现金额置为0 可提现金额减去
			else
			{
				accountCapital.setNoWithdrawMoney(Constants.DEVIL_NUM_ZERO);
				//用户可使用金额（可提现金额+不可提现金额）
				accountCapital.setWithdrawMoney(MoneyUtils.formatFloatNumber((nwMoney+wMoney-yMoney)*100));
			}
			accountCapital.setFreedomMoney(MoneyUtils.formatFloatNumber((freedomMoney+yMoney)*100));
			accountCapital.setInvestmentMoney(MoneyUtils.formatFloatNumber(capitalBean.getInvestmentMoney()*100));
			accountCapital.setFreezeMoney(MoneyUtils.formatFloatNumber(capitalBean.getFreezeMoney()*100));
			capitalMapper.editAccountCapitalById(accountCapital);
			
			//****************************添加资金明细 1 猫咪宝明细***********************
			CapitalDetail capitalDetail = new CapitalDetail();
			capitalDetail.setAccountId(accountId);
			capitalDetail.setMoney(MoneyUtils.changeYToF(money));
			
			//交易类型(0:储蓄卡充值 1:微信充值 2:信用卡充值 3:投资投标 4:投资投标收益 5:提现 6:债权转出 7:债权承接,8:退款 9:投资本金结算 10:活动获取 11:购买鱼干 12:投猫咪宝)
			capitalDetail.setType(Constants.DEVIL_NUM_TWEVEL);
			
			//金额收支(0:收入 1:支出)
			capitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
			capitalDetail.setRemark("猫咪宝投资"+money+"元");
			bondTransferMapper.addCapital(capitalDetail);
			
			//***************************修改猫咪宝的额度*************************
			//猫咪宝剩余总额（元）
			double fMoney = Double.parseDouble(freedomSubjectBean.getFreedomSurplusMoney())-(yMoney);
			FreedomSubjectBean fBean = new FreedomSubjectBean();
			fBean.setFreedomSubjectId(freedomSubjectBean.getFreedomSubjectId());
			fBean.setFreedomSurplusMoney(MoneyUtils.changeYToF(MoneyUtils.formatFloatNumber(fMoney)));
			//已售罄
			if(fMoney<=0)
			{
				fBean.setFreedomSubjectStatus(Constants.DEVIL_NUM_TWO);
			}
			freedomSubjectMapper.updateFreedomSubject(fBean);
			
			//添加猫咪宝投标记录
			freedomSubjectBean.setFreedomMoney(MoneyUtils.changeYToF(money));
			freedomSubjectBean.setIsMerge(Constants.DEVIL_NUM_ZERO);
			freedomSubjectMapper.addFreedomSubject(freedomSubjectBean);
			
			//消息记录
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(accountId);
			messageBean.setMsgTitle("猫咪宝投资成功");
			messageBean.setMsgContent("猫咪宝投资"+money+"元成功,详情可至<a href='javascript:void(0)' onclick='goDetails(8)'>猫咪宝投资</a>查看");
			messageMapper.addMessageInfo(messageBean);
	}

	/**
	 * 猫咪宝转出至可提现余额
	 */
	@Transactional
	@Override
	public String transferFreedom(String money, HttpServletRequest request) throws Exception
	{
		String result = "{\"result\":\"error\"}";
		try
		{
			//输入金额元转分
			money = String.valueOf(Double.parseDouble(money)*100);
			money = money.substring(0, money.indexOf("."));
			
			//查询用户账户金额
			AccountInfo accountInfo =  (AccountInfo)request.getSession().getAttribute("account");
			AccountCapital accountCapital = revenueSettlementMapper.getBalances(accountInfo.getAccountId());
			
			//判断取出金额小于猫咪宝金额
			if(Integer.valueOf(money)<=Integer.valueOf(accountCapital.getFreedomMoney())){
				/*//获取用户未合并的猫咪宝投资记录
				List<FreedomSubjectBean> freedomSubjectBeans = freedomSubjectMapper.getNoMergeFreedomSubject(accountInfo.getAccountId());
				
				//转出金额
				Integer cashWithdrawal =Integer.parseInt(money); 
				//删除
				for (FreedomSubjectBean freedomSubjectBean : freedomSubjectBeans)
				{
					//猫咪宝投资金额
					Integer freedomMoney = Integer.parseInt(freedomSubjectBean.getFreedomMoney());
					
					if(freedomMoney > cashWithdrawal){
						//投资金额足够转出，并有多余
						freedomMoney = freedomMoney - cashWithdrawal;
						freedomSubjectBean.setFreedomMoney(String.valueOf(freedomMoney));
						freedomSubjectMapper.updateRecordToReduce(freedomSubjectBean);
						break;
					}else if(freedomMoney == cashWithdrawal){
						
						//是否已合并(0否，1是，2删除)
						freedomSubjectBean.setIsMerge(Constants.DEVIL_NUM_THREE);
						//投资金额足够
						freedomSubjectMapper.updateRecordToDelete(freedomSubjectBean);
						break;
					}else{
						
						//是否已合并(0否，1是，2删除)
						freedomSubjectBean.setIsMerge(Constants.DEVIL_NUM_THREE);
						//资金不足
						cashWithdrawal = cashWithdrawal - freedomMoney;
						freedomSubjectMapper.updateRecordToDelete(freedomSubjectBean);
					}
				}*/
				
				delFreedomSubjectRecord(money,accountInfo);
				
				//判断是否特权转出
				/*if(Integer.parseInt(accountInfo.getAccountLevel())>=5){*/
					//账户余额加         猫咪宝金额减
					String withdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(accountCapital.getWithdrawMoney()) + Double.parseDouble(money));
					String freedomMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(accountCapital.getFreedomMoney()) - Double.parseDouble(money));
					freedomMoney = freedomMoney.substring(0, freedomMoney.indexOf("."));
					withdrawMoney = withdrawMoney.substring(0, withdrawMoney.indexOf("."));
					accountCapital.setWithdrawMoney(String.valueOf(withdrawMoney));
					accountCapital.setFreedomMoney(String.valueOf(freedomMoney));
					// 修改金额
					revenueSettlementMapper.changeFunds(accountCapital);
					
					// 资金明细：余额加
					CapitalDetail income = new CapitalDetail();
					income.setAccountId(accountInfo.getAccountId());
					income.setMoney(money);
					income.setType("13");
					income.setInExpend(Constants.DEVIL_NUM_ZERO);
					income.setRemark("猫咪宝转出本金：" + Double.parseDouble(money) / 100);
					revenueSettlementMapper.addCapital(income);

					// 发送消息
					MessageBean outMessageBean = new MessageBean();
					outMessageBean.setAccountId(accountInfo.getAccountId());
					outMessageBean.setMsgTitle("猫咪宝资金转出");
					outMessageBean.setMsgContent("猫咪宝转出"+Double.parseDouble(money) / 100+"元成功！详情请在我的<a href='javascript:void(0)' onclick='goDetails(8)'>猫咪宝投资</a>中查看。");
					messageMapper.addMessageInfo(outMessageBean);
				/*}else{
					*//**
					 * 20170908 Zheng -> 修改猫咪宝转出余额规则:1.转出金额暂存至提现记录表;2.定时器定时执行任务将提现记录表中记录传导至资金表
					 *//*
					//提现中金额加         猫咪宝金额减
					String nowWithdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(accountCapital.getNowWithdrawMoney()) + Double.parseDouble(money));
					String freedomMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(accountCapital.getFreedomMoney()) - Double.parseDouble(money));
					freedomMoney = freedomMoney.substring(0, freedomMoney.indexOf("."));
					nowWithdrawMoney = nowWithdrawMoney.substring(0, nowWithdrawMoney.indexOf("."));
					accountCapital.setNowWithdrawMoney(String.valueOf(nowWithdrawMoney));
					accountCapital.setFreedomMoney(String.valueOf(freedomMoney));
					
					// 修改金额
					revenueSettlementMapper.changeFunds(accountCapital);
					
					WithdrawRecordBean withdrawRecordBean = new WithdrawRecordBean();		
					withdrawRecordBean.setAccountId(accountInfo.getAccountId());
					withdrawRecordBean.setMoney(money);
					withdrawRecordMapper.addWithdrawRecord(withdrawRecordBean);
					
					// 资金明细：余额加
					CapitalDetail income = new CapitalDetail();
					income.setAccountId(accountInfo.getAccountId());
					income.setMoney(money);
					income.setType("13");
					income.setInExpend(Constants.DEVIL_NUM_ZERO);
					income.setRemark("猫咪宝转出本金：" + Double.parseDouble(money) / 100);
					revenueSettlementMapper.addCapital(income);
	
					// 发送消息
					MessageBean outMessageBean = new MessageBean();
					outMessageBean.setAccountId(accountInfo.getAccountId());
					outMessageBean.setMsgTitle("猫咪宝资金转出(转出中)");
					outMessageBean.setMsgContent("猫咪宝转出"+Double.parseDouble(money) / 100+"元成功!该笔资金将于1小时内转出至您的帐户,稍后请关注您的账户余额.");
					messageMapper.addMessageInfo(outMessageBean);
				}*/
				result = "{\"result\":\"success\"}";
			}else{
				//余额不足
				result = "{\"result\":\"notEnough\"}";
			}
		}
		catch (Exception e)
		{
			logger.error("猫咪宝转出异常");
			throw new RuntimeException();
		}
		return result;
	}
	
	

	@Override
	public List<FreedomSubjectBean> queryMyFreedomSubject(FreedomSubjectBean freedomSubjectBean) throws SQLException
	{
		return freedomSubjectMapper.queryMyFreedomSubject(freedomSubjectBean);
	}

	@Override
	public Integer countFightGroups(FreedomSubjectBean freedomSubjectBean) throws SQLException
	{
		return freedomSubjectMapper.countFightGroups(freedomSubjectBean);
	}

	@Override
	public FreedomSubjectBean countPromit(FreedomSubjectBean freedomSubjectBean) throws SQLException
	{
		return freedomSubjectMapper.countPromit(freedomSubjectBean);
	}

	@Override
	public FreedomSubjectBean queryYesterdayRateAndPromitById(FreedomSubjectBean freedomSubjectBean)
			throws SQLException
	{
		return freedomSubjectMapper.queryYesterdayRateAndPromitById(freedomSubjectBean);
	}

	@Override
	@Transactional
	public String withdrawMon(HttpServletRequest request, HttpServletResponse response, String accountName,
			String bankCard, String money, String bankName, String isComp, String count,Boolean tq) throws Exception
	{
		String phone = paramMapper.getParamVal("WITHDRAW_PHONE");
		CapitalBean capitalBean = new CapitalBean();
		capitalBean.setAccountId(((AccountInfo) request.getSession().getAttribute("account")).getAccountId());
		AccountInfo account = (AccountInfo) request.getSession().getAttribute("account");
		String code = null;
		try
		{
			if(Double.parseDouble(money)<=0)
			{
				code="error";
				return code;
			}
			//修改用户资金
			capitalBean = CapitalMapper.queryCapitalById(capitalBean);
			Double freedomMoney = capitalBean.getFreedomMoney() * 100;
			Double mon = freedomMoney - Double.parseDouble(money) * 100;
			AccountCapital aCapt = new AccountCapital();
			aCapt.setFreedomMoney(String.valueOf(MoneyUtils.removeDecimalPoint(mon)));
			aCapt.setAccountId(capitalBean.getAccountId());
			accountName = new String(accountName.getBytes("ISO-8859-1"), "UTF-8");
			bankName = new String(bankName.getBytes("ISO-8859-1"), "UTF-8");
			//是否是特权提现
			if(tq){
				AccountInfo accountInfo= accountLevelMapper.queryAccountLevel(account);
				Integer wCount = Integer.parseInt(accountInfo.getWithdrawalsNumber());
				if(wCount>0){
					Integer xemoney = LevelParam.WITHDRAWALS_MONEY.get(Integer.parseInt(accountInfo.getAccountLevel()));
					if(xemoney>=Double.parseDouble(money)){
						accountInfo.setWithdrawalsNumber(String.valueOf(wCount-1));
						accountLevelMapper.updateAccountVIP(accountInfo);
					}else{
						code = "overtop";
						return code;
					}
				}else{
					code = "notEnough";
					return code;
				}
				
			}
			//发送信息给财务打款
			code = WithdrawController.msgSend(account.getRealName(), bankName, money, bankCard, phone,tq);
			if (code.equals("200"))
			{
				//发送用户短信
				// msgSendYh(account, money);
				String moneys = String.valueOf(MoneyUtils.removeDecimalPoint(Double.parseDouble(money)*100));
				delFreedomSubjectRecord(moneys,account);
				 
				revenueSettlementMapper.changeFunds(aCapt);
				
				//资金明细 (猫咪宝提现)
				CapitalDetail capitalDetail = new CapitalDetail();
				capitalDetail.setAccountId(account.getAccountId());
				capitalDetail.setMoney(moneys);

				// 交易类型(0:储蓄卡充值 1:微信充值 2:信用卡充值 3:投资投标 4:投资投标收益 5:提现15:猫咪宝提现)
				capitalDetail.setType(Constants.DEVIL_NUM_FIFTEEN);

				// 金额收支(0:收入 1:支出)
				capitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
				if(tq){
					capitalDetail.setRemark("猫咪宝特权提现" + money + "元");
				}else{
					capitalDetail.setRemark("猫咪宝提现" + money + "元");
				}
				bondTransferMapper.addCapital(capitalDetail);
				MessageBean messageBean = new MessageBean();
				messageBean.setAccountId(capitalBean.getAccountId());
				messageBean.setMsgTitle("提现成功");
				messageBean.setMsgContent("您于" + new SimpleDateFormat("yyyy.MM.dd").format(new Date()) + "申请提现"
						+ String.valueOf(money) + "元.<br/>资金将于1-3个工作日内提现至您的银行卡账户内,若1-3个工作日未到账,请及时联系客服.");
				messageMapper.addMessageInfo(messageBean);
				
				//判断是否是企业用户，和第一次提现
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
		}
		catch (Exception e)
		{
			logger.error("提现模块，查询个人账户异常", e);
			throw new RuntimeException();
		}
		return code;
	}
	
	
	private void delFreedomSubjectRecord(String money,AccountInfo accountInfo) throws SQLException{
		//获取用户未合并的猫咪宝投资记录
		List<FreedomSubjectBean> freedomSubjectBeans = freedomSubjectMapper.getNoMergeFreedomSubject(accountInfo.getAccountId());
		
		//转出金额
		Integer cashWithdrawal =Integer.parseInt(money); 
		//删除
		for (FreedomSubjectBean freedomSubjectBean : freedomSubjectBeans)
		{
			//猫咪宝投资金额
			Integer freedomMoney = Integer.parseInt(freedomSubjectBean.getFreedomMoney());
			
			if(freedomMoney > cashWithdrawal){
				//投资金额足够转出，并有多余
				freedomMoney = freedomMoney - cashWithdrawal;
				freedomSubjectBean.setFreedomMoney(String.valueOf(freedomMoney));
				freedomSubjectMapper.updateRecordToReduce(freedomSubjectBean);
				break;
			}else if(freedomMoney == cashWithdrawal){
				
				//是否已合并(0否，1是，2删除)
				freedomSubjectBean.setIsMerge(Constants.DEVIL_NUM_THREE);
				//投资金额足够
				freedomSubjectMapper.updateRecordToDelete(freedomSubjectBean);
				break;
			}else{
				
				//是否已合并(0否，1是，2删除)
				freedomSubjectBean.setIsMerge(Constants.DEVIL_NUM_THREE);
				//资金不足
				cashWithdrawal = cashWithdrawal - freedomMoney;
				freedomSubjectMapper.updateRecordToDelete(freedomSubjectBean);
			}
		}
	}

	@Override
	public String querySumTodayMoney(FreedomSubjectBean freedomSubjectBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return freedomSubjectMapper.querySumTodayMoney(freedomSubjectBean);
	}
	
}
