package com.xed.financing.wxgzh.controller.timingProcessing;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.model.runinfo.RunInfoBean;
import com.xed.financing.wxgzh.service.runinfo.RunInfoService;

/**
 * 更新信息披露内容
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.RunInfoTime
 * @description:
 * @version:v1.0.0 
 * @date:2018年2月23日 上午11:21:52
 * @author:penggang
 */
//@Component
public class RunInfoTime
{
	@Autowired
	private RunInfoService runInfoService;
	
	private Logger logger = Logger.getLogger(RunInfoTime.class);
	
	//@Scheduled(cron = "0 10 0 1 * ? ")
	//@Scheduled(cron = "0 */1 * * * ? ")
	public void addRunInfo() {
		System.out.println("记录披露信息开始");
		try
		{
			SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd");  
			String date = format0.format(new Date().getTime());
			String totaltransaction = MoneyUtils.formatFloatNumber((Double.parseDouble(runInfoService.getTotaltransaction(date))+Double.parseDouble(runInfoService.queryXuNiUserMoney(date))));
			int accumulativeTransaction = runInfoService.getAccumulativeTransaction(date);
			String loanBalance = runInfoService.getLoanBalance(date);
			int accumulativeBorrower = runInfoService.getAccumulativeBorrower(date);
			int accumulativeLenders = runInfoService.getAccumulativeLenders(date);
			int loanBalanceCount = runInfoService.getLoanBalanceCount(date);
			int currentBorrowerCount = runInfoService.getCurrentBorrowerCount(date);
			int currentLendersCount = runInfoService.getCurrentLendersCount(date);
			//int getRelatedLoanBalance = runInfoService.getRelatedLoanBalance(date);
			int relatedLoanBalance = 0;
			String theProportionOne = runInfoService.geTheProportionOne(date);
			String theProportionTen = runInfoService.geTheProportionTen(date);
			int loanBalances = runInfoService.getLoanBalances(date);
			String registrations = runInfoService.getRegistrationsCount();
			
			int transactionCount = runInfoService.getTransactionCount();
			String allProfit = runInfoService.getAllProfit();
			
			RunInfoBean runInfoBean = new RunInfoBean(date, totaltransaction, accumulativeTransaction, loanBalance,
					accumulativeBorrower, accumulativeLenders, loanBalanceCount, currentBorrowerCount, currentLendersCount,
					relatedLoanBalance, theProportionOne, theProportionTen, loanBalances, registrations,transactionCount,allProfit);
			
			int count = runInfoService.addRunInfo(runInfoBean);
			
			if(count == 0){
				logger.debug("插入信息披露异常！");
			}
			
			System.out.println("记录披露信息结束");
		}
		catch (SQLException e)
		{
			logger.debug("插入信息披露异常！", e);
		}
	}
}
