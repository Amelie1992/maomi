/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.investrecord.impl.InvestRecordServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月23日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.investrecord.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.investrecord.InvestRecordMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.creditrecord.CreditRecord;
import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.investrecord.InvestRecordService;
import com.xed.financing.wxgzh.service.revenueSettlement.RevenueSettlementService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * @className:com.xed.financing.wxgzh.service.investrecord.impl.InvestRecordServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月23日 下午5:01:19
 * @author:Qian Tao
 */
@Service
@Transactional
public class InvestRecordServiceImpl implements InvestRecordService
{
	
	@Resource
	private InvestRecordMapper investRecordMapper;
	
	@Resource
	private ParamMapper paramMapper;
	
	@Resource
	private CapitalMapper capitalMapper;
	
	@Resource
	private BondTransferMapper bondTransferMapper;
	
	/**
	 * 消息mapper
	 */
	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private AccountScoreMapper accountScoreMapper;
	
	@Autowired
	private RevenueSettlementService revenueSettlementService;

	private Logger logger = Logger.getLogger(InvestRecordServiceImpl.class);
	
	@Override
	public List<InvestRecordBean> queryInvestRecord(InvestRecordBean investRecordBean) throws SQLException
	{
		return investRecordMapper.queryInvestRecord(investRecordBean);
	}

	@Override
	public List<InvestRecordBean> queryCreditRecord(InvestRecordBean investRecordBean) throws SQLException
	{
		return investRecordMapper.queryCreditRecord(investRecordBean);
	}

	@Override
	@Transactional
	public void transferBond(HttpServletRequest request,String investId,String creditRate) 
	{
		String projectUrl=paramMapper.getParamVal("MAKE_PROJECT_URL");
		//获取用户id
		String accountId = ((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
		try
		{
			//--------------------------查询投标信息 创建新的投标信息----------------------------------------------
			AccountInvest accountInvest = bondTransferMapper.getInvestByID(investId);
			//将转让金额转换类型
			//判断是否全部转让 不全部转让修改原标信息，添加新的投标记录
			/*if(money < Integer.valueOf(accountInvest.getInvestMoney())){
				//修改原标的投资金额，月化收益，年化收益
				accountInvest.setInvestMoney(String.valueOf(Integer.valueOf(accountInvest.getInvestMoney())-money));
				Integer oldYearProfit = MoneyUtils.removeDecimalPoint(Double.valueOf(accountInvest.getInvestMoney()) * Double.valueOf(accountInvest.getSubjectRate()) / 100.0);
				accountInvest.setYearProfit(String.valueOf(oldYearProfit));
				Integer oldMonthProfit = MoneyUtils.removeDecimalPoint(oldYearProfit / 12.0);
				accountInvest.setMonthProfit(String.valueOf(oldMonthProfit));
				bondTransferMapper.updateInvestIncome(accountInvest);
				//添加新的投标信息
				accountInvest.setInvestMoney(String.valueOf(money));
				accountInvest.setCouponMoney(Constants.DEVIL_NUM_ZERO);
				Integer newYearProfit = MoneyUtils.removeDecimalPoint(money * Double.valueOf(accountInvest.getSubjectRate()) / 100.0);
				accountInvest.setYearProfit(String.valueOf(newYearProfit));
				Integer newMonthProfit = MoneyUtils.removeDecimalPoint(newYearProfit / 12.0);
				accountInvest.setMonthProfit(String.valueOf(newMonthProfit));
				accountInvest.setIsCredit(Constants.DEVIL_NUM_ONE);
				bondTransferMapper.addInvest(accountInvest);
			}else{*/
				InvestRecordBean investRecord = new InvestRecordBean();
				investRecord.setInvestId(investId);
				investRecord.setIsCredit(Constants.DEVIL_NUM_ONE);
				investRecordMapper.updateInvestStatus(investRecord);
		//	}
			
			
			//是否转让债权(0:否 1:是)
			//investRecordBean.setIsCredit(Constants.DEVIL_NUM_ONE);
			
			//更改投标状态
			//investRecordMapper.updateInvestStatus(investRecordBean);
			//----------------------------------查询投标信息，添加转让记录----------------------------------------------
			InvestRecordBean investRecordBean = new InvestRecordBean();
			investRecordBean.setInvestId(investId);
			investRecordBean = investRecordMapper.selectOneInvestRecordById(investRecordBean);
			
			//债权转让表插入一条记录
			//获取转让人id
			investRecordBean.setOutAccountId(investRecordBean.getAccountId());
			investRecordBean.setCreditMoney(investRecordBean.getSurplusMoney());
			
			//转让方式    转让方式(0:普通 1:加急 2:平台接盘)  默认普通
			investRecordBean.setCreditType(Constants.DEVIL_NUM_ZERO);
			investRecordBean.setInvestId(accountInvest.getInvestId());
			//转让利率  
			investRecordBean.setCreditRate(creditRate);
			
			//调其他Service  获取deal_money垫付金额   out_money收益金额
			CreditRecord creditRecord = new CreditRecord();
			creditRecord.setCreditRate(creditRate);
			
			AccountInvest accountInvest1 = new AccountInvest();
			accountInvest1.setSurplusMoney(investRecordBean.getSurplusMoney());
			accountInvest1.setInvestMoney(investRecordBean.getInvestMoney());
			accountInvest1.setInvestTime(investRecordBean.getInvestTime());
			accountInvest1.setEndTime(investRecordBean.getEndTime());
			accountInvest1.setLastProfitTime(investRecordBean.getLastProfitTime());
			accountInvest1.setNextProfitTime(investRecordBean.getNextProfitTime());
			//  标利率
			accountInvest1.setSubjectRate(investRecordBean.getSubjectRates());	
			accountInvest1.setRepeatType(investRecordBean.getRepeatType());
			accountInvest1.setIsDayProfit(investRecordBean.getIsDayProfit());
			creditRecord.setAccountInvest(accountInvest1);
			
			creditRecord = revenueSettlementService.updateTransferAmount(creditRecord);

			investRecordBean.setDealMoney(creditRecord.getDealMoney());
			investRecordBean.setOutMoney(creditRecord.getOutMoney());
			
			//转让利率
			double crate = Double.parseDouble(creditRate);
			
			//投标利率
			double yrate = Double.parseDouble(investRecordBean.getSubjectRate());
			
			//收益方式(0:平台支付转让人收益 1:转让人支付接收人收益)
			if(crate >= yrate)
			{
				investRecordBean.setDealType(Constants.DEVIL_NUM_ONE);
			}
			else
			{
				investRecordBean.setDealType(Constants.DEVIL_NUM_ZERO);
			}
			
			investRecordBean.setIsCancel(Constants.DEVIL_NUM_ZERO);
			investRecordMapper.addCreditRecord(investRecordBean);
			
			//扣除积分
			AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(accountId);
			//获取加急所扣鱼干
			String fastScore =paramMapper.getParamVal("TRANSFER_COMMON");
			accountInfo.setAccountScore(String.valueOf(Integer.valueOf(accountInfo.getAccountScore())-Integer.valueOf(fastScore)));
			//修改用户积分和经验 传参：用户信息Bean
			accountScoreMapper.changeScoreAndExp(accountInfo);
			
			// 创建鱼干明细
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountId);
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ONE);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_EIGHT);
			accountScoreBean.setModReason("债权转让,扣除20鱼干");
					
			// 鱼干明细输入奖励鱼干数量
			accountScoreBean.setScore(String.valueOf(fastScore));
			// 添加用户鱼干明细
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);	
			
			//添加消息
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(investRecordBean.getAccountId());
			messageBean.setMsgTitle("转让成功");
			messageBean.setMsgContent(investRecordBean.getSubjectName()+"成功转让"+MoneyUtils.changeFToY(investRecordBean.getSurplusMoney())+"元,详情可至<a href='javascript:void(0)' onclick='goDetails(6)'>我的转让</a>查看");
			//("您的"+investMoney+"元投标转让成功！详情可至我的投资查看");
			
			messageMapper.addMessageInfo(messageBean);
		}
		catch (Exception e)
		{
 			logger.error("转让异常");
			throw new RuntimeException();
		}
	}

	@Override
	@Transactional
	public void fastTransfer(HttpServletRequest request,InvestRecordBean investRecordBean)
	{
		String projectUrl=paramMapper.getParamVal("MAKE_PROJECT_URL");
		
		//获取用户id
		String accountId = ((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
		try{
			
			investRecordBean=investRecordMapper.queryInvestRecordById(investRecordBean);
			//investRecordBean.setCreditRate(String.valueOf(Double.parseDouble(investRecordBean.getCreditRate())-Double.parseDouble(fastRate)));
			
			//转让方式(0:普通 1:加急 2:平台接盘)
			investRecordBean.setCreditType(Constants.DEVIL_NUM_ONE);
			investRecordMapper.updateCreditStatus(investRecordBean);
			
			//扣除积分
			AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(accountId);
			//获取加急所扣鱼干
			String fastScore =paramMapper.getParamVal("TRANSFER_FAST");
			accountInfo.setAccountScore(String.valueOf(Integer.valueOf(accountInfo.getAccountScore())-Integer.valueOf(fastScore)));
			
			// 创建鱼干明细
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountId);
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ONE);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_NINE);
			accountScoreBean.setModReason("债权转让,扣除20鱼干");
					
			// 鱼干明细输入奖励鱼干数量
			accountScoreBean.setScore(String.valueOf(fastScore));
			// 添加用户鱼干明细
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);	
			
			//修改用户积分和经验 传参：用户信息Bean
			accountScoreMapper.changeScoreAndExp(accountInfo);
			
			//添加消息
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(investRecordBean.getAccountId());
			messageBean.setMsgTitle("加急成功");
			messageBean.setMsgContent("您"+investRecordBean.getCreditMoney()+"元的"+investRecordBean.getSubjectName()+"加急成功！详情可至<a href='javascript:void(0)' onclick='goDetails(7)'>债权转让</a>查看");
			messageMapper.addMessageInfo(messageBean);
		}
		catch (Exception e)
		{
 			logger.error("加急异常");
			throw new RuntimeException();
		}
	}

	@Override
	public void sysTransfer(InvestRecordBean investRecordBean) 
	{
		try
		{
			String accountId =investRecordBean.getAccountId();
			String investId = investRecordBean.getInvestId();
			investRecordBean=investRecordMapper.queryInvestRecordById(investRecordBean);
			
			//转让人转让标接标后天数  平台接盘默认的是点击后就生效  接收时间为空  所以用转让时间对比
			int days = Integer.parseInt(DateUtils.getTwoDay(investRecordBean.getCurrentTime(), investRecordBean.getFullTime()));
			
			//查询转让金额
			double credMoney = Double.parseDouble(investRecordBean.getCreditMoney());
			
			//加急后平台接盘所扣利率
			String sysFRate =paramMapper.getParamVal("TRANSFER_FSYS ");
			//加急后平台接盘转让利率
			double sysFastRates =Double.parseDouble(investRecordBean.getCreditRate())-Double.parseDouble(sysFRate);
			
			//实际收益金额
			String dealMoney;
			
			//获取平台接盘所扣利率
			String sysRate =paramMapper.getParamVal("TRANSFER_SYS ");
			//平台接盘后转让利率
			double sysRates =Double.parseDouble(investRecordBean.getCreditRate())-Double.parseDouble(sysRate);
			
			//如果是加急后选择平台接盘
			if(Constants.DEVIL_NUM_ONE.equals(investRecordBean.getCreditType()))
			{
				investRecordBean.setCreditRate(String.valueOf(sysFastRates));
				//获取转让人实际收益   利率是百分比  所以多除以100
				dealMoney= MoneyUtils.changeYToF(String.valueOf(days*((credMoney*sysFastRates)/36000)));
				investRecordBean.setDealMoney(dealMoney);
			}
			//转让后直接平台接盘
			else
			{
				investRecordBean.setCreditRate(String.valueOf(sysRates));
				//获取转让人实际收益   利率是百分比  所以多除以100
				dealMoney= MoneyUtils.changeYToF(String.valueOf(days*((credMoney*sysRates)/36000)));
				investRecordBean.setDealMoney(dealMoney);
			}
			
			//转让方式(0:普通 1:加急 2:平台接盘)
			investRecordBean.setCreditType(Constants.DEVIL_NUM_TWO);
			
			//接受人 平台默认
			investRecordBean.setInAccountId(paramMapper.getParamVal("IN_ACCOUNT_ID"));
			
			investRecordMapper.updateCreditStatus(investRecordBean);
			
			//修改转让信息-------------------------------------
			//获取转让记录
			InvestRecordBean iBean = new InvestRecordBean();
			iBean.setInvestId(investId);
			iBean = investRecordMapper.queryInvestRecordById(investRecordBean);
			//转让成功后 判断投资金额的余额
			double overInvestMoney =Double.parseDouble(investRecordBean.getInvestMoney())-Double.parseDouble(investRecordBean.getCreditMoney());
			
			//发生转让    承接人生成一条投资记录-------------------------------------------
			iBean.setInvestMoney(MoneyUtils.changeYToF(investRecordBean.getCreditMoney()));
			
			//承接人为平台管理员
			iBean.setAccountId(paramMapper.getParamVal("IN_ACCOUNT_ID"));
			iBean.setSubjectRate(iBean.getSubjectRates());
			//年化收益
			double yPromit=Double.parseDouble(iBean.getCreditMoney())*Double.parseDouble(iBean.getSubjectRates())/100;
			double mPromit=yPromit/12;
			iBean.setYearProfit(String.valueOf(yPromit*100));
			iBean.setMonthProfit(String.valueOf(mPromit*100));
			investRecordMapper.addInvestTransfer(iBean);
			
			//投资金额已经全部转让 修改该条记录状态
			if(overInvestMoney ==0)
			{
				//投标状态(0:正常 1:标的正常结束 2:已转让债权)
				iBean.setInvestStatus(Constants.DEVIL_NUM_TWO);
				investRecordMapper.updateInvestInfo(iBean);
			}
			//投标金额部分转让  剩余部分生成一条记录 原记录修改记录状态  
			else
			{
				//投标状态(0:正常 1:标的正常结束 2:已转让债权)
				investRecordBean.setInvestStatus(Constants.DEVIL_NUM_TWO);
				investRecordBean.setInvestMoney(MoneyUtils.changeYToF(investRecordBean.getCreditMoney()));
				investRecordMapper.updateInvestInfo(investRecordBean);
				
				//转让人生成新投标记录
				investRecordBean.setInvestMoney(MoneyUtils.changeYToF(MoneyUtils.minString(investRecordBean.getInvestMoney(),investRecordBean.getCreditMoney())));
				investRecordBean.setInvestStatus(Constants.DEVIL_NUM_ZERO);
				investRecordBean.setIsCredit(Constants.DEVIL_NUM_ZERO);
				double yearMoney=Double.parseDouble(investRecordBean.getInvestMoney())*Double.parseDouble(investRecordBean.getSubjectRate())/100;
				double monthMoney=yearMoney/12;
				investRecordBean.setYearProfit(String.valueOf(yearMoney*100));
				investRecordBean.setMonthProfit(String.valueOf(monthMoney*100));
				investRecordMapper.addInvestTransfer(iBean);
			}
			
			
			//修改转让人账户金额信息-------------------------------------
			//获取账户id
			CapitalBean capitalBean =new CapitalBean();
			capitalBean.setAccountId(accountId);
			//查询用户资金
			capitalBean = capitalMapper.queryCapitalById(capitalBean);
			//投资金额平台接盘后 投资金额=原投资金额-所转让的金额（分）
			double iMoney =capitalBean.getInvestmentMoney()-Double.parseDouble(investRecordBean.getCreditMoney());
			capitalBean.setInvestmentMoney(iMoney);
			
			//可提现金额=转让金额+实际收益(分)
			double wMoney =Double.parseDouble(investRecordBean.getCreditMoney())+Double.parseDouble(investRecordBean.getDealMoney());
			capitalBean.setWithdrawMoney(capitalBean.getWithdrawMoney()+wMoney);
			
			//修改金额
			capitalMapper.editCapitalById(capitalBean);
			
			//修改平台管理员账户金额信息-------------------------------------
			//获取账户id
			CapitalBean cBean =new CapitalBean();
			cBean.setAccountId(paramMapper.getParamVal("IN_ACCOUNT_ID"));
			//查询平台管理员资金
			cBean = capitalMapper.queryCapitalById(capitalBean);
			
			//投资金额平台接盘后 投资金额=原投资金额+用户所转让的金额（分）
			double investMoney =cBean.getInvestmentMoney()+Double.parseDouble(investRecordBean.getCreditMoney());
			cBean.setInvestmentMoney(investMoney);
			
			//可提现金额-转让金额
			cBean.setWithdrawMoney(capitalBean.getWithdrawMoney()-Double.parseDouble(investRecordBean.getCreditMoney()));
			
			//修改金额
			capitalMapper.editCapitalById(cBean);
			
			//添加资金明细------------------------------------------
			CapitalDetail capitalDetail = new CapitalDetail();
			capitalDetail.setAccountId(accountId);
			
			//添加资金明细  投资金额变动 1------------------------
			//用户投资金额减少
			capitalDetail.setMoney(String.valueOf(iMoney));
			
			//交易类型(0:储蓄卡充值 1:微信充值 2:信用卡充值 3:投资投标 4:投资投标收益 5:提现 6:债权转出 7:债权接收)
			capitalDetail.setType("6");
			
			//金额收支(0:收入 1:支出)
			capitalDetail.setInExpend("1");
			bondTransferMapper.addCapital(capitalDetail);
			
			//添加资金明细  用户可提现金额增加 2--------------------
			capitalDetail.setMoney(String.valueOf(investRecordBean.getCreditMoney()));
			capitalDetail.setType("6");
			capitalDetail.setInExpend("0");
			bondTransferMapper.addCapital(capitalDetail);
			
			//添加资金明细  用户可提现金额增加（ 实际收益） 3--------------------
			capitalDetail.setMoney(String.valueOf(investRecordBean.getDealMoney()));
			capitalDetail.setType("4");
			capitalDetail.setInExpend("0");
			bondTransferMapper.addCapital(capitalDetail);
			
			//添加资金明细  平台可提现金额减少 4--------------------
			CapitalDetail sysCapitalDetail = new CapitalDetail();
			sysCapitalDetail.setAccountId(paramMapper.getParamVal("IN_ACCOUNT_ID"));
			sysCapitalDetail.setMoney(String.valueOf(investRecordBean.getDealMoney()));
			sysCapitalDetail.setType("7");
			sysCapitalDetail.setInExpend("1");
			bondTransferMapper.addCapital(sysCapitalDetail);
			
			//添加资金明细  平台投标金额增加 5--------------------
			sysCapitalDetail.setMoney(String.valueOf(investRecordBean.getDealMoney()));
			sysCapitalDetail.setType("3");
			sysCapitalDetail.setInExpend("0");
			bondTransferMapper.addCapital(sysCapitalDetail);
			
			//添加消息
			String projectUrl=paramMapper.getParamVal("MAKE_PROJECT_URL");
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(investRecordBean.getAccountId());
			messageBean.setMsgTitle("平台接盘成功");
			messageBean.setMsgContent("您"+investRecordBean.getCreditMoney()+"元的"+investRecordBean.getSubjectName()+"平台接盘成功！查询资金可至<a href='javascript:void(0)' onclick='goDetails(1)'>个人中心</a>查看");
			messageMapper.addMessageInfo(messageBean);
		}
		catch (Exception e)
		{
 			logger.error("平台接盘异常");
			throw new RuntimeException();
		}
	}

	@Override
	public Integer countFirstSubject(InvestRecordBean investRecordBean) throws SQLException
	{
		return investRecordMapper.countFirstSubject(investRecordBean);
	}

	@Override
	@Transactional
	public void cancelTransfer(HttpServletRequest request,InvestRecordBean investRecordBean) throws SQLException
	{
		
		//项目前缀
		String projectUrl=paramMapper.getParamVal("MAKE_PROJECT_URL");
		
		//获取用户id
		String accountId = ((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
		try
		{
			investRecordMapper.updateCreditStauts(investRecordBean);
			investRecordMapper.updateInvestStatus(investRecordBean);
		/*	
			//扣除积分
			AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(accountId);
			//获取取消转让所扣鱼干
			String cancelScore =paramMapper.getParamVal("CANCEL_TRANSFER");
			accountInfo.setAccountScore(String.valueOf(Integer.valueOf(accountInfo.getAccountScore())-Integer.valueOf(cancelScore)));
			//修改用户积分和经验 传参：用户信息Bean
			accountScoreMapper.changeScoreAndExp(accountInfo);*/
			
			//添加消息
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(investRecordBean.getAccountId());
			messageBean.setMsgTitle("取消转让成功");
			messageBean.setMsgContent("您"+investRecordBean.getCreditMoney()+"元的"+investRecordBean.getSubjectName()+"取消转让成功！详情可至<a href='javascript:void(0)' onclick='goDetails(7)'>债权转让</a>查看");
			messageMapper.addMessageInfo(messageBean);
		}
		catch (SQLException e)
		{
			logger.error("取消转让异常", e);
			throw new SQLException();
		}
	}

	@Override
	public InvestRecordBean selectOneInvestRecordById(InvestRecordBean investRecordBean) throws SQLException
	{
		return investRecordMapper.selectOneInvestRecordById(investRecordBean);
	}

	@Override
	public InvestRecordBean queryInvestRecordById(InvestRecordBean investRecordBean) throws SQLException
	{
		return investRecordMapper.queryInvestRecordById(investRecordBean);
	}

	@Override
	public String countSumInvestSubject(InvestRecordBean investRecordBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return investRecordMapper.countSumInvestSubject(investRecordBean);
	}

	@Override
	public InvestRecordBean queryIphoneById(String investId) throws SQLException
	{
		// TODO Auto-generated method stub
		return investRecordMapper.queryIphoneById(investId);
	}
}
