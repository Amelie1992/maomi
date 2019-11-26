/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.revenueSettlement.RevenueSettlement
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月28日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.timingProcessing;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xed.financing.wxgzh.service.revenueSettlement.RevenueSettlementService;
import com.xed.financing.wxgzh.util.DateUtils;

/**
 * 收益结算
 * 
 * @className:com.xed.financing.wxgzh.controller.revenueSettlement.RevenueSettlement
 * @description:
 * @version:v1.0.0
 * @date:2017年4月28日 下午4:09:16
 * @author:ZhangJun
 */
@Component
public class RevenueSettlement
{
	@Autowired
	private RevenueSettlementService revenueSettlementService;

	/**
	 * 每天结算收益
	 * 
	 * @Description:
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月13日 下午4:15:27
	 * @Scheduled(cron = "0 45 16,18 * * ? ")
	 * Scheduled(cron = "0 3/15 * * * ? ")
	 */
	@Scheduled(cron = "0 45 16,18 * * ? ")
	public void revenueSettlement() throws Exception
	{
		revenueSettlementService.revenueSettlement();

		revenueSettlementService.updateTransferRecord();
		// 转让债权记录更新转让金额、垫付金额和利率修正金额
		// 查出未撤销is_cancel,标的状态为正常的invest_status,转让中的is_credit

		// -------------------------------查找出当日结束的标，爆款标分开------------------------------------------------
		// List<SubjectBean> otherSubjects =
		// revenueSettlementMapper.queryEndOthersSubjects();

		// ------------------------------循环查出当日结束标的投标信息---------------------------------------------------
		/*
		 * for (SubjectBean subjectBean : otherSubjects) { List<AccountInvest>
		 * list =
		 * revenueSettlementMapper.selectInvestBySubjectId(subjectBean.getSubjectId
		 * ()); // 计算收益 for (AccountInvest accountInvest : list) { Integer
		 * investMoney = Integer.valueOf(accountInvest.getInvestMoney()); Double
		 * couponMney = Double.valueOf(accountInvest.getCouponMoney()) +
		 * investMoney; // 收益金额 Integer incomes = 0; //
		 * 判断投标时间和满标时间那个离现在近，用近的日期计算收益 if
		 * (DateUtils.compareDateLong(accountInvest.getFullTime(),
		 * accountInvest.getInvestTime())) { incomes =
		 * CalculateUtils.CalculatedIncomes(couponMney,
		 * Double.valueOf(accountInvest.getSubjectRate()),
		 * accountInvest.getFullTime(), subjectBean.getEndTime()); } else {
		 * incomes = CalculateUtils.CalculatedIncomes(couponMney,
		 * Double.valueOf(accountInvest.getSubjectRate()),
		 * accountInvest.getInvestTime(), subjectBean.getEndTime()); } //
		 * 查询出账户金额 修改金额 AccountCapital accountCapital =
		 * revenueSettlementMapper.getBalances(accountInvest.getAccountId());
		 * Integer investmentMoney =
		 * Integer.valueOf(accountCapital.getInvestmentMoney()) - investMoney;
		 * Integer withdrawMoney =
		 * Integer.valueOf(accountCapital.getWithdrawMoney()) + investMoney +
		 * incomes;
		 * accountCapital.setInvestmentMoney(String.valueOf(investmentMoney));
		 * accountCapital.setWithdrawMoney(String.valueOf(withdrawMoney));
		 * revenueSettlementMapper.changeFunds(accountCapital);
		 * 
		 * // 资金明细：投资金额- CapitalDetail investMent = new CapitalDetail();
		 * investMent.setAccountId(accountInvest.getAccountId());
		 * investMent.setMoney(String.valueOf(investMoney));
		 * investMent.setType(Constants.DEVIL_NUM_NINE);
		 * investMent.setInExpend(Constants.DEVIL_NUM_ONE);
		 * investMent.setRemark("投标结束，支出投资金额：" + investMoney);
		 * revenueSettlementMapper.addCapital(investMent);
		 * 
		 * // 资金明细：本金+ CapitalDetail principal = new CapitalDetail();
		 * principal.setAccountId(accountInvest.getAccountId());
		 * principal.setMoney(String.valueOf(investMoney));
		 * principal.setType(Constants.DEVIL_NUM_NINE);
		 * principal.setInExpend(Constants.DEVIL_NUM_ZERO);
		 * principal.setRemark("投标结束，收入本金：" + investMoney);
		 * revenueSettlementMapper.addCapital(principal);
		 * 
		 * // 资金明细：收益+ CapitalDetail income = new CapitalDetail();
		 * income.setAccountId(accountInvest.getAccountId());
		 * income.setMoney(String.valueOf(incomes));
		 * income.setType(Constants.DEVIL_NUM_FOUR);
		 * income.setInExpend(Constants.DEVIL_NUM_ZERO);
		 * income.setRemark("投标结束，收入收益：" + incomes);
		 * revenueSettlementMapper.addCapital(income); // 发送消息 MessageBean
		 * outMessageBean = new MessageBean();
		 * outMessageBean.setAccountId(accountInvest.getAccountId());
		 * outMessageBean.setMsgTitle("投资到期");
		 * outMessageBean.setMsgContent("您投资的标，" + subjectBean.getSubjectName()
		 * + "，已结束！详情请在我的投资查看。"); messageMapper.addMessageInfo(outMessageBean);
		 * 
		 * // 修改投标记录状态 accountInvest.setInvestStatus(Constants.DEVIL_NUM_ONE);
		 * revenueSettlementMapper.updateInvestStatus(accountInvest); } //
		 * 修改标的状态 subjectBean.setSubjectStatus(Constants.DEVIL_NUM_FIVE);
		 * revenueSettlementMapper.updateSubjectStatus(subjectBean); }
		 * 
		 * //
		 * -----------------------------------------------------循环查出当日结束爆款标的投标信息
		 * -------------------------------------------------------
		 * 
		 * // 查询结束爆款标的投标信息 List<AccountInvest> list =
		 * revenueSettlementMapper.queryEndGoodsInvest(); for (AccountInvest
		 * accountInvest : list) { SubjectBean subjectBean =
		 * revenueSettlementMapper.selectSubjectInfoByInvestInfo(accountInvest);
		 * 
		 * // 投资金额 Integer investMoney =
		 * Integer.valueOf(accountInvest.getInvestMoney()); // 查询账户信息，修改账户金额
		 * AccountCapital accountCapital =
		 * revenueSettlementMapper.getBalances(accountInvest.getAccountId());
		 * Integer investmentMoney =
		 * Integer.valueOf(accountCapital.getInvestmentMoney()) - investMoney;
		 * Integer withdrawMoney =
		 * Integer.valueOf(accountCapital.getWithdrawMoney()) + investMoney;
		 * accountCapital.setInvestmentMoney(String.valueOf(investmentMoney));
		 * accountCapital.setWithdrawMoney(String.valueOf(withdrawMoney));
		 * revenueSettlementMapper.changeFunds(accountCapital);
		 * 
		 * // 资金明细：投资金额- CapitalDetail investMent = new CapitalDetail();
		 * investMent.setAccountId(accountInvest.getAccountId());
		 * investMent.setMoney(String.valueOf(investMoney));
		 * investMent.setType(Constants.DEVIL_NUM_NINE);
		 * investMent.setInExpend(Constants.DEVIL_NUM_ONE);
		 * investMent.setRemark("投标结束，支出投资金额：" + investMoney);
		 * revenueSettlementMapper.addCapital(investMent);
		 * 
		 * // 资金明细：本金+ CapitalDetail principal = new CapitalDetail();
		 * principal.setAccountId(accountInvest.getAccountId());
		 * principal.setMoney(String.valueOf(investMoney));
		 * principal.setType(Constants.DEVIL_NUM_NINE);
		 * principal.setInExpend(Constants.DEVIL_NUM_ZERO);
		 * principal.setRemark("投标结束，收入本金：" + investMoney);
		 * revenueSettlementMapper.addCapital(principal);
		 * 
		 * // 发送消息 MessageBean outMessageBean = new MessageBean();
		 * outMessageBean.setAccountId(accountInvest.getAccountId());
		 * outMessageBean.setMsgTitle("投资到期");
		 * outMessageBean.setMsgContent("您投资的标，" + subjectBean.getSubjectName()
		 * + "，已结束！详情请在我的投资查看。"); messageMapper.addMessageInfo(outMessageBean);
		 * 
		 * // 修改投标记录状态 accountInvest.setInvestStatus(Constants.DEVIL_NUM_ONE);
		 * revenueSettlementMapper.updateInvestStatus(accountInvest); }
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String nowDate = sdf.format(date);
		System.out.println("计算收益结束" + nowDate);
	}

	/**
	 * 猫咪宝收益结算
	 * @Description:
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月30日 上午11:49:58
	 */
	@Scheduled(cron = "0 0 6 * * ? ")
	public void grantProfit() throws Exception
	{
		//合并记录
		revenueSettlementService.mergeRecord();
		//发放收益
		revenueSettlementService.grantProfit();
		System.out.println("11");
	}
	
	
	
	public static void main(String a[]) throws Exception
	{

		System.out.println(DateUtils.getMinDayByDate("2017-07-01"));

	}
}
