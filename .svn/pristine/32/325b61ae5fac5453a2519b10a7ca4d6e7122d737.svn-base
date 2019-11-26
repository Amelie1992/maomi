/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.bondtransfer.impl.BondTransferServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月17日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.bondtransfer.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.mapper.revenueSettlement.RevenueSettlementMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.creditrecord.CreditRecord;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.bondtransfer.BondTransferService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * @className:com.xed.financing.wxgzh.service.bondtransfer.impl.BondTransferServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年3月17日 下午3:47:47
 * @author:ZhangJun
 */
@Service
public class BondTransferServiceImpl implements BondTransferService
{

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(BondTransferServiceImpl.class);
	
	@Resource
	public BondTransferMapper mapper;

	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private AccountScoreMapper accountScoreMapper;
	
	@Resource
	private ParamMapper paramMapper;
	
	@Resource
	private RevenueSettlementMapper revenueSettlementMapper;
	
	/**
	 * 查询全部集合，根据条件排序
	 * 
	 * @Description: 查询出总条数，和总金额，条件排序的集合,转成json发送给前台
	 * @param creditRecord
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午3:35:38
	 */
	@Override
	public Boolean getSortingList(CreditRecord creditRecord, HttpServletResponse response) throws SQLException
	{
		Boolean falg = false;

		PrintWriter write;
		try
		{
			// 转让债权集合(未承接)
			List<CreditRecord> list = mapper.getSortingList(creditRecord);
			// 转让债权集合(已承接)
			List<CreditRecord> list2 = mapper.getSortingListTransfer(creditRecord);
			
			list.addAll(list2);
			// 总数量
			Integer count = mapper.getBondCount();
			// 总金额
			Integer sum = mapper.getBondMoneySUM();
			// 用一个对象接收集合，总数量，总金额
			CreditRecord record = new CreditRecord();
			record.setCreditRecords(list);
			record.setCount(String.valueOf(count));
			record.setSum(String.valueOf(sum));
			write = response.getWriter();
			// Bean转Json
			String data = JsonUtil.beanToJson(record);
			write.print(data);
			write.flush();
			write.close();
			falg = true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return falg;
	}

	
	/**
	 * 查询全部集合
	 * 
	 * @Description:查询出总条数，和总金额,时间排序的集合
	 * @return 查询出的集合
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午3:37:02
	 */
	public CreditRecord getList(HttpServletRequest request) throws SQLException
	{
		CreditRecord record = new CreditRecord();
		AccountInfo account = (AccountInfo) request.getSession().getAttribute("account");
		if (account != null)
		{
			record.setOutAccountId(account.getAccountId());
		}

		// 转让债权集合
		List<CreditRecord> list = mapper.getSortingList(record);
		// 转让债权集合(已承接)
		List<CreditRecord> list2 = mapper.getSortingListTransfer(record);
					
		list.addAll(list2);
		// 总数量
		Integer count = mapper.getBondCount();
		// 总金额
		Integer sum = mapper.getBondMoneySUM();
		record.setCreditRecords(list);
		record.setCount(String.valueOf(count));
		record.setSum(String.valueOf(sum));

		return record;
	}

	/**
	 * 转让债权
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @param creditId
	 *            转让ID
	 * @return 成功与否
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午3:37:24
	 */
	@Override
	@Transactional
	public Boolean changeTransferBonds(HttpServletRequest request, HttpServletResponse response, String creditId)
	{
		Boolean flag = false;
		try
		{
			
			//--------------------------------信息获取----------------------------------------------------------
			// 从session中查询出接盘人账号ID
			String inAccountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			
			// 根据债权转让条目ID查询 转让信息
			CreditRecord creditRecord = mapper.getCreditRecordByCreditId(creditId);
			
			// 根据投标ID 查询投标信息
			AccountInvest accountInvest = mapper.getInvestByID(creditRecord.getInvestId());
			
			// 债权转让金额
			Integer bondAmount = Integer.parseInt(creditRecord.getCreditMoney());
			
			//总金额
			Integer totalAmount = Integer.parseInt(creditRecord.getCreditMoney())+Integer.parseInt(creditRecord.getDealMoney());
			
			// 计算收益 本金 = 剩余本金 + 红包
			Double money = Double.valueOf(accountInvest.getSurplusMoney())+Double.valueOf(accountInvest.getCouponMoney());
			
			//计算收益 天数 = 当前日期 - 上次结算日期
			Integer days = DateUtils.daysBetween(revenueSettlementMapper.getNow(),accountInvest.getLastProfitTime());
			days = days>1?days-1:0;
			
			//本期天数 = 下次结算日至上次结算日
			Integer currentDays = DateUtils.daysBetween(accountInvest.getNextProfitTime(),accountInvest.getLastProfitTime());
			
			//查询当前登录用户的积分和经验 传参：登录用户ID
			AccountInfo outAccountInfo = accountScoreMapper.findScoreAndExp(creditRecord.getOutAccountId());
			
			// 查询标的信息
			SubjectBean subjectBean = mapper.getSubjectInfo(accountInvest.getSubjectId());
			
			//----------------------------------------添加承接人的新的投标记录----------------------------------------------------------------
			AccountInvest newAccountInvest = new AccountInvest();
			newAccountInvest.setSubjectId(accountInvest.getSubjectId());
			newAccountInvest.setAccountId(inAccountId);
			newAccountInvest.setInvestTime(accountInvest.getInvestTime());
			newAccountInvest.setFullTime(accountInvest.getFullTime());
			newAccountInvest.setEndTime(accountInvest.getEndTime());
			newAccountInvest.setLastProfitTime(accountInvest.getLastProfitTime());
			newAccountInvest.setNextProfitTime(accountInvest.getNextProfitTime());
			newAccountInvest.setInvestMoney(creditRecord.getCreditMoney());
			newAccountInvest.setSurplusMoney(creditRecord.getCreditMoney());
			newAccountInvest.setSubjectRate(creditRecord.getCreditRate());
			// 计算年化收益和月化收益
			String inYearProfit = MoneyUtils.formatFloatNumber(Double.valueOf(MoneyUtils.removeDecimalPoint(bondAmount * Double.valueOf(creditRecord.getCreditRate()) / 100.0)));
			String inMonthProfit = MoneyUtils.formatFloatNumber(Double.valueOf(MoneyUtils.removeDecimalPoint(Double.parseDouble(inYearProfit) / 12.0)));
			inYearProfit = inYearProfit.substring(0, inYearProfit.indexOf("."));
			inMonthProfit = inMonthProfit.substring(0, inMonthProfit.indexOf("."));
			newAccountInvest.setYearProfit(inYearProfit);
			newAccountInvest.setMonthProfit(inMonthProfit);
			newAccountInvest.setIsTeam(accountInvest.getIsTeam());
			newAccountInvest.setIsCredit(Constants.DEVIL_NUM_ZERO);
			newAccountInvest.setInvestStatus(Constants.DEVIL_NUM_THREE);
			newAccountInvest.setInvestType(accountInvest.getInvestType());
			newAccountInvest.setRepeatType(accountInvest.getRepeatType());
			newAccountInvest.setIsDayProfit(accountInvest.getIsDayProfit());
			mapper.addInvest(newAccountInvest);
			
			//-----------------------------------修改原投标信息，结束标------------------------------------------------------------------------
			mapper.updateInvestStatus(accountInvest.getInvestId());
			
			//----------------------------------计算收益------------------------------------------------------------------------------------
			// 转让人收益金额
			String incomes = "";
			//判断是否按天收益
			if("1".equals(accountInvest.getIsDayProfit())){
				//按天收益
				incomes = "0";
			}else{
				//按月收益
				//收益金额 = 本金 * 利率 / 12 / 本期天数 / 计算收益天数
				incomes = MoneyUtils.formatFloatNumber(money*Double.parseDouble(accountInvest.getSubjectRate())/100/12/currentDays*days);
				incomes = incomes.substring(0, incomes.indexOf("."));
			}
			
			//------------------------------------修改转让信息-------------------------------------------------------------------------------
			creditRecord.setInAccountId(inAccountId);
			creditRecord.setDealMoney(incomes);
			mapper.changeCreditRecord(creditRecord);
			
			
			//-------------------------------------修改转让人资金----------------------------------------------------------------------------
			// 查询转让人账户金额
			AccountCapital outAccountCapital = mapper.getBalances(creditRecord.getOutAccountId());
			// 转让人 投资金额 = 原投资金额-转让债权金额
			String outInvestmentMoney = MoneyUtils.formatFloatNumber(Double.valueOf(outAccountCapital.getInvestmentMoney()) - bondAmount);
			// 转让人 可转账金额 = 原可转账金额+转让债权金额 + 转让债权当前收益
			String outWithdrawMoney = MoneyUtils.formatFloatNumber(Double.valueOf(outAccountCapital.getWithdrawMoney()) + bondAmount + Integer.parseInt(incomes));
			//判断转让人是否需要额外支付或获得奖励
			if("1".equals(creditRecord.getDealType())){
				//需支付额外的利率修正金额
				outWithdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(outWithdrawMoney) - Double.parseDouble(creditRecord.getOutMoney()));
				
			}else{
				//获得额外的奖励
				outWithdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(outWithdrawMoney) + (Integer.parseInt(creditRecord.getOutMoney())));
				//扣除额外奖励的20%鱼干
				String driedFish = String.valueOf(Integer.parseInt(creditRecord.getOutMoney())/20*0.2);
				driedFish = driedFish.substring(0, driedFish.indexOf("."));
				if(Integer.parseInt(driedFish)>Integer.parseInt(outAccountInfo.getAccountScore())){
					driedFish = String.valueOf(Integer.parseInt(driedFish)-Integer.parseInt(outAccountInfo.getAccountScore()));
					outAccountInfo.setAccountScore("0");
					outWithdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(outWithdrawMoney) - Integer.parseInt(driedFish) * 20);
					
				}else{
					outAccountInfo.setAccountScore(String.valueOf(Integer.parseInt(outAccountInfo.getAccountScore())-Integer.parseInt(driedFish)));
					
				}
				accountScoreMapper.changeScoreAndExp(outAccountInfo);
			}
			outInvestmentMoney = outInvestmentMoney.substring(0, outInvestmentMoney.indexOf("."));
			outWithdrawMoney = outWithdrawMoney.substring(0, outWithdrawMoney.indexOf("."));
			outAccountCapital.setInvestmentMoney(outInvestmentMoney);
			outAccountCapital.setWithdrawMoney(outWithdrawMoney);
			mapper.changeFunds(outAccountCapital);
			
			
			//--------------------------------------修改承接人资金----------------------------------------------------------------------------
			// 查询接盘人账户金额
			AccountCapital inAccountCapital = mapper.getBalances(inAccountId);
			// 接盘人 投资金额 = 原投资金额+接盘债权金额
			String inInvestmentMoney = MoneyUtils.formatFloatNumber(Double.valueOf(inAccountCapital.getInvestmentMoney()) + bondAmount);
			// 接盘人 可转账金额 = 原可转账金额（不可转账金额）-接盘债权金额
			String inWithdrawMoney = "0";
			if(Double.valueOf(inAccountCapital.getNoWithdrawMoney()) - totalAmount >= 0){
				inWithdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(inAccountCapital.getNoWithdrawMoney()) - totalAmount);
				inAccountCapital.setNoWithdrawMoney(inWithdrawMoney);
			}else{
				
				inWithdrawMoney = MoneyUtils.formatFloatNumber(Double.parseDouble(inAccountCapital.getNoWithdrawMoney())+Double.parseDouble(inAccountCapital.getWithdrawMoney()) - totalAmount);
				inWithdrawMoney = inWithdrawMoney.substring(0, inWithdrawMoney.indexOf("."));
				inAccountCapital.setWithdrawMoney(inWithdrawMoney);
				inAccountCapital.setNoWithdrawMoney("0");
			}
			inInvestmentMoney = inInvestmentMoney.substring(0, inInvestmentMoney.indexOf("."));
			inAccountCapital.setInvestmentMoney(inInvestmentMoney);
			mapper.changeFunds(inAccountCapital);
			
			
			
			//---------------------------------转让人资金明细------------------------------------------------------------------------------
			// 转让人：投资金额-
			CapitalDetail outInvestMent = new CapitalDetail();
			outInvestMent.setAccountId(creditRecord.getOutAccountId());
			outInvestMent.setMoney(String.valueOf(bondAmount));
			outInvestMent.setType(Constants.DEVIL_NUM_SIX);
			outInvestMent.setInExpend(Constants.DEVIL_NUM_ONE);
			outInvestMent.setRemark("债权转让成功，支出投资金额："+(bondAmount/100.0)+"元");
			mapper.addCapital(outInvestMent);
			
			// 转让人：本金+
			CapitalDetail outPrincipal = new CapitalDetail();
			outPrincipal.setAccountId(creditRecord.getOutAccountId());
			outPrincipal.setMoney(String.valueOf(bondAmount));
			outPrincipal.setType(Constants.DEVIL_NUM_SIX);
			outPrincipal.setInExpend(Constants.DEVIL_NUM_ZERO);
			outPrincipal.setRemark("债权转让成功，收入本金："+(bondAmount/100.0)+"元");
			mapper.addCapital(outPrincipal);
			
			// 转让人：收益+
			CapitalDetail outIncome = new CapitalDetail();
			outIncome.setAccountId(creditRecord.getOutAccountId());
			outIncome.setMoney(String.valueOf(incomes));
			outIncome.setType(Constants.DEVIL_NUM_FOUR);
			outIncome.setInExpend(Constants.DEVIL_NUM_ZERO);
			outIncome.setRemark("债权转让成功，收入收益："+(Integer.parseInt(incomes)/100.0)+"元");
			mapper.addCapital(outIncome);
			
			
			//判断转让人是否需要额外支付或获得奖励
			if("1".equals(creditRecord.getDealType())){

				// 转让人：本金-/------------------------------------------------------------------
				CapitalDetail outPrincipal1 = new CapitalDetail();
				outPrincipal1.setAccountId(creditRecord.getOutAccountId());
				outPrincipal1.setMoney(creditRecord.getOutMoney());
				outPrincipal1.setType(Constants.DEVIL_NUM_SIX);
				outPrincipal1.setInExpend(Constants.DEVIL_NUM_ONE);
				outPrincipal1.setRemark("债权转让成功，支付利率修正金额："+(Integer.parseInt(creditRecord.getOutMoney())/100.0)+"元");
				mapper.addCapital(outPrincipal1);
			}else{
				
				// 转让人：收益+ /-----------------------------------------------------------------
				CapitalDetail outIncome1 = new CapitalDetail();
				outIncome1.setAccountId(creditRecord.getOutAccountId());
				outIncome1.setMoney(creditRecord.getOutMoney());
				outIncome1.setType(Constants.DEVIL_NUM_FOUR);
				outIncome1.setInExpend(Constants.DEVIL_NUM_ZERO);
				outIncome1.setRemark("债权转让成功，收入利率修正金额："+(Integer.parseInt(creditRecord.getOutMoney())/100.0)+"元");
				mapper.addCapital(outIncome1);
			}
			
			
			
			//---------------------------------------------承接人资金明细------------------------------------------------------------------------------
			// 承接人：投资金额+
			CapitalDetail inInvestMent = new CapitalDetail();
			inInvestMent.setAccountId(inAccountId);
			inInvestMent.setMoney(String.valueOf(bondAmount));
			inInvestMent.setType(Constants.DEVIL_NUM_SEVEN);
			inInvestMent.setInExpend(Constants.DEVIL_NUM_ZERO);
			inInvestMent.setRemark("债权承接成功，收入投资金额："+(bondAmount/100.0)+"元");
			mapper.addCapital(inInvestMent);
			
			// 承接人：本金-
			CapitalDetail inPrincipal = new CapitalDetail();
			inPrincipal.setAccountId(inAccountId);
			inPrincipal.setMoney(String.valueOf(totalAmount));
			inPrincipal.setType(Constants.DEVIL_NUM_THREE);
			inPrincipal.setInExpend(Constants.DEVIL_NUM_ONE);
			inPrincipal.setRemark("债权承接成功，支出本金+垫付金额共："+(totalAmount/100.0)+"元");
			mapper.addCapital(inPrincipal);
			
			//----------------------------------转让人发送消息-------------------------------------------------------------------------------------
			//转让人发送消息
			MessageBean outMessageBean =new MessageBean();
			outMessageBean.setAccountId(creditRecord.getOutAccountId());
			outMessageBean.setMsgTitle("债权转让成功");
			outMessageBean.setMsgContent("您债权转让的标" +subjectBean.getSubjectName()+ "转让成功！收回本金"+(bondAmount/100.0)+"元,获得收益"+(Integer.parseInt(incomes)/100.0)+"元。");
			messageMapper.addMessageInfo(outMessageBean);
			
			//----------------------------------承接人发送消息-------------------------------------------------------------------------------------
			MessageBean inMessageBean =new MessageBean();
			inMessageBean.setAccountId(creditRecord.getInAccountId());
			inMessageBean.setMsgTitle("债权承接成功");
			inMessageBean.setMsgContent("您债权承接的标" +subjectBean.getSubjectName()+ "承接成功！支付本金+垫付金额共"+(totalAmount/100.0)+"元,利率"+creditRecord.getCreditRate()+"%。");
			messageMapper.addMessageInfo(inMessageBean);
			
			/*//--------------------------------信息获取----------------------------------------------------------
			// 从session中查询出接盘人账号ID
			String inAccountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			
			// 根据债权转让条目ID查询 转让信息
			CreditRecord creditRecord = mapper.getCreditRecordByCreditId(creditId);
			
			// 根据投标ID 查询投标信息
			AccountInvest accountInvest = mapper.getInvestByID(creditRecord.getInvestId());
			
			// 债权转让金额
			Double bondAmount = Double.valueOf(mapper.getBondAmount(creditId));
			
			// 计算收益本金+红包
			Double money = Double.valueOf(accountInvest.getInvestMoney())+Double.valueOf(accountInvest.getCouponMoney());
			
			// 查询标的原始利率
			SubjectBean subjectBean = mapper.getSubjectInfo(accountInvest.getSubjectId());
			
			
			//----------------------------------------添加承接人的新的投标记录----------------------------------------------------------------
			AccountInvest newAccountInvest = new AccountInvest();
			newAccountInvest.setSubjectId(accountInvest.getSubjectId());
			newAccountInvest.setAccountId(inAccountId);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String nowDate = sdf.format(date);
			newAccou``ntInvest.setInvestTime(nowDate);
			newAccountInvest.setFullTime(accountInvest.getFullTime());
			newAccountInvest.setInvestMoney(String.valueOf(bondAmount));
			newAccountInvest.setSubjectRate(subjectBean.getSubjectRate());
			// 计算年化收益和月化收益
			Double inYearProfit = Double.valueOf(MoneyUtils.removeDecimalPoint(money * Double.valueOf(subjectBean.getSubjectRate()) / 100.0));
			newAccountInvest.setYearProfit(String.valueOf(inYearProfit));
			Double inMonthProfit = Double.valueOf(MoneyUtils.removeDecimalPoint(inYearProfit / 12.0));
			newAccountInvest.setMonthProfit(String.valueOf(inMonthProfit));
			newAccountInvest.setIsTeam(accountInvest.getIsTeam());
			newAccountInvest.setIsCredit(Constants.DEVIL_NUM_ZERO);
			newAccountInvest.setInvestStatus(Constants.DEVIL_NUM_THREE);
			mapper.addInvest(newAccountInvest);
			
			
			
			//-----------------------------------修改原投标信息，结束标------------------------------------------------------------------------
			mapper.updateInvestStatus(accountInvest.getInvestId());
			
			
			
			
			//----------------------------------计算收益------------------------------------------------------------------------------------
			// 转让人收益金额
			Double incomes =0.0;
			//判断投标时间和满标时间那个离现在近，用近的日期计算收益
			if(DateUtils.compareDateLong(accountInvest.getFullTime(), accountInvest.getInvestTime())){
				incomes = Double.valueOf(CalculateUtils.CalculatedIncomes(money,Double.valueOf(creditRecord.getCreditRate()), accountInvest.getFullTime(), nowDate));
			}else{
				incomes = Double.valueOf(CalculateUtils.CalculatedIncomes(money,Double.valueOf(creditRecord.getCreditRate()), accountInvest.getInvestTime(), nowDate));
			}
			
			
			//------------------------------------修改转让信息-------------------------------------------------------------------------------
			creditRecord.setInAccountId(inAccountId);
			creditRecord.setDealMoney(String.valueOf(incomes));
			mapper.changeCreditRecord(creditRecord);
			
			
			//-------------------------------------修改转让人资金----------------------------------------------------------------------------
			// 查询转让人账户金额
			AccountCapital outAccountCapital = mapper.getBalances(creditRecord.getOutAccountId());
			// 转让人 投资金额 = 原投资金额-转让债权金额
			Double outInvestmentMoney = Double.valueOf(outAccountCapital.getInvestmentMoney()) - bondAmount;
			// 转让人 可转账金额 = 原可转账金额+转让债权金额+转让债权当前收益
			Double outWithdrawMoney = Double.valueOf(outAccountCapital.getWithdrawMoney()) + bondAmount + incomes;
			outAccountCapital.setInvestmentMoney(String.valueOf(outInvestmentMoney));
			outAccountCapital.setWithdrawMoney(String.valueOf(outWithdrawMoney));
			mapper.changeFunds(outAccountCapital);
			
			
			//--------------------------------------修改承接人资金----------------------------------------------------------------------------
			// 查询接盘人账户金额
			AccountCapital inAccountCapital = mapper.getBalances(inAccountId);
			// 接盘人 投资金额 = 原投资金额+接盘债权金额
			Double inInvestmentMoney = Double.valueOf(inAccountCapital.getInvestmentMoney()) + bondAmount;
			// 接盘人 可转账金额 = 原可转账金额（不可转账金额）-接盘债权金额
			if(Double.valueOf(inAccountCapital.getNoWithdrawMoney()) - bondAmount >= 0){
				Double inWithdrawMoney = Double.parseDouble(inAccountCapital.getNoWithdrawMoney()) - bondAmount;
				inAccountCapital.setNoWithdrawMoney(String.valueOf(inWithdrawMoney));
			}else{
				inAccountCapital.setNoWithdrawMoney("0");
				Double inWithdrawMoney = Double.parseDouble(inAccountCapital.getNoWithdrawMoney())+Double.parseDouble(inAccountCapital.getWithdrawMoney()) - bondAmount;
				inAccountCapital.setWithdrawMoney(String.valueOf(inWithdrawMoney));
			}
			inAccountCapital.setInvestmentMoney(String.valueOf(inInvestmentMoney));
			mapper.changeFunds(inAccountCapital);
			
			
			
			
			//---------------------------------转让人资金明细------------------------------------------------------------------------------
			// 转让人：投资金额-
			CapitalDetail outInvestMent = new CapitalDetail();
			outInvestMent.setAccountId(creditRecord.getOutAccountId());
			outInvestMent.setMoney(String.valueOf(bondAmount));
			outInvestMent.setType(Constants.DEVIL_NUM_SIX);
			outInvestMent.setInExpend(Constants.DEVIL_NUM_ONE);
			outInvestMent.setRemark("债权转让成功，支出投资金额："+(bondAmount/100));
			mapper.addCapital(outInvestMent);
			
			// 转让人：本金+
			CapitalDetail outPrincipal = new CapitalDetail();
			outPrincipal.setAccountId(creditRecord.getOutAccountId());
			outPrincipal.setMoney(String.valueOf(bondAmount));
			outPrincipal.setType(Constants.DEVIL_NUM_SIX);
			outPrincipal.setInExpend(Constants.DEVIL_NUM_ZERO);
			outPrincipal.setRemark("债权转让成功，收入本金："+(bondAmount/100));
			mapper.addCapital(outPrincipal);
			
			// 转让人：收益+
			CapitalDetail outIncome = new CapitalDetail();
			outIncome.setAccountId(creditRecord.getOutAccountId());
			outIncome.setMoney(String.valueOf(incomes));
			outIncome.setType(Constants.DEVIL_NUM_FOUR);
			outIncome.setInExpend(Constants.DEVIL_NUM_ZERO);
			outIncome.setRemark("债权转让成功，收入收益："+(incomes/100));
			mapper.addCapital(outIncome);
			
			
			
			
			
			//---------------------------------------------承接人资金明细------------------------------------------------------------------------------
			// 承接人：投资金额+
			CapitalDetail inInvestMent = new CapitalDetail();
			inInvestMent.setAccountId(inAccountId);
			inInvestMent.setMoney(String.valueOf(bondAmount));
			inInvestMent.setType(Constants.DEVIL_NUM_SEVEN);
			inInvestMent.setInExpend(Constants.DEVIL_NUM_ZERO);
			inInvestMent.setRemark("债权承接成功，收入投资金额："+(bondAmount/100));
			mapper.addCapital(inInvestMent);
			
			// 承接人：本金-
			CapitalDetail inPrincipal = new CapitalDetail();
			inPrincipal.setAccountId(inAccountId);
			inPrincipal.setMoney(String.valueOf(bondAmount));
			inPrincipal.setType(Constants.DEVIL_NUM_THREE);
			inPrincipal.setInExpend(Constants.DEVIL_NUM_ONE);
			inPrincipal.setRemark("债权承接成功，支出本金："+(bondAmount/100));
			mapper.addCapital(inPrincipal);
			
			//---------------------------------------承接人积分-----------------------------------------------------------------------------------
			//查询当前登录用户的积分和经验 传参：登录用户ID
			AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(inAccountId);
			String point = String.valueOf(bondAmount/100.0*Double.valueOf(paramMapper.getParamVal(Constants.TAKE_POINTS)));
			String score = point.substring(0,point.indexOf("."));
			accountInfo.setAccountExp(String.valueOf(Integer.valueOf(accountInfo.getAccountExp())+Integer.valueOf(score)));
			accountInfo.setAccountScore(String.valueOf(Integer.valueOf(accountInfo.getAccountScore())+Integer.valueOf(score)));
			//修改用户积分和经验 传参：用户信息Bean
			accountScoreMapper.changeScoreAndExp(accountInfo);

			//添加积分明细 传参：积分明细Bean
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(inAccountId);
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_TWO);
			accountScoreBean.setModReason((bondAmount/100)+"元债权承接成功，奖励积分"+score);
			accountScoreBean.setScore(String.valueOf(score));
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);
			
			
			
			
			
			//----------------------------------转让人发送消息-------------------------------------------------------------------------------------
			//转让人发送消息
			MessageBean outMessageBean =new MessageBean();
			outMessageBean.setAccountId(creditRecord.getOutAccountId());
			outMessageBean.setMsgTitle("债权转让成功");
			outMessageBean.setMsgContent("您债权转让的标" +subjectBean.getSubjectName()+ "转让成功！收回本金"+(bondAmount/100)+"元,获得收益"+(incomes/100)+"元。");
			messageMapper.addMessageInfo(outMessageBean);
			
			//----------------------------------承接人发送消息-------------------------------------------------------------------------------------
			MessageBean inMessageBean =new MessageBean();
			inMessageBean.setAccountId(creditRecord.getInAccountId());
			inMessageBean.setMsgTitle("债权承接成功");
			inMessageBean.setMsgContent("您债权承接的标" +subjectBean.getSubjectName()+ "承接成功！支付本金"+(bondAmount/100)+"元,利率"+subjectBean.getSubjectRate()+"%。");
			messageMapper.addMessageInfo(inMessageBean);*/
			
			flag=true;
			
			return flag;
		}
		catch (Exception e)
		{
			logger.error("债权转让异常");
			throw new RuntimeException();
		}
		
	}

	/**
	 * 检查承接人余额是否足够支付
	 */
	@Override
	public Boolean checkFunds(HttpServletRequest request, HttpServletResponse response, String creditId)
			throws SQLException
	{
		// 从session中查询出账号ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		// 获得债权转让金额
		Double bondAmount = Double.parseDouble(mapper.getBondAmount(creditId).toString());
		// 查询账户可提现金额
		AccountCapital accountCapital = mapper.getBalances(accountId);
		return Double.valueOf(accountCapital.getWithdrawMoney())+Double.valueOf(accountCapital.getNoWithdrawMoney()) >= bondAmount;
	}


	/**
	 * 获得转让记录详情
	 */
	public CreditRecord getCreditRecordDetail(HttpServletRequest request , String creditId) throws Exception
	{
		CreditRecord creditRecord = mapper.getCreditRecordDetail(creditId);
		AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("account");
		creditRecord.setInAccountId(accountInfo.getAccountId());
		return creditRecord;
	}


	@Override
	public Boolean checkTransferStatus(String creditId) throws Exception
	{
		
		return mapper.checkTransferStatus(creditId)>0;
	}
}
