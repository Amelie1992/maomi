package com.xed.financing.wxgzh.controller.timingProcessing;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
@Component
public class AccountLevel
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(DataSplit.class);
	
	@Autowired
	private AccountLevelService accountLevelService;
	
	
	
	
	/**
	 * 
	 * @Description:查询上个月用户的签到次数并发加息券
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月9日 下午6:46:52
	 */
	@Scheduled(cron="0 0 6 1 * ?")//cron="0 0 6 1 * ?"
	public void accountLastMonthSigns()
	{
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("查询上个月用户签到次数开始："+df.format(new Date()));
			accountLevelService.queryAccountLastMonthSigns();
			System.out.println("查询上个月用户签到次数结束："+df.format(new Date()));
		}
		catch (Exception e)
		{
			logger.error("查询异常", e);
		}
	}
	
	/**
	 * 
	 * @Description:用户生日送现金券
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月10日 上午10:58:26
	 */
	@Scheduled(cron="0 5 6 * * ?")//cron="0 5 6 * * ?"
	public void accountBirthdayGiveCash()
	{
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("查询前7天的用户生日投资金额开始："+df.format(new Date()));
			accountLevelService.accountBirthdayGiveCash();
			System.out.println("查询前7天的用户生日投资金额结束："+df.format(new Date()));
		}
		catch (Exception e)
		{
			logger.error("查询异常", e);
		}
	}
	
	/**
	 * 
	 * @Description:用户降级
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月13日 上午11:47:31
	 */
	@Scheduled(cron="0 50 5 1 * ?")//cron="0 50 5 1 * ?"
	public void accountDowngrade()
	{
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("用户降级查询用户投资金额开始："+df.format(new Date()));
			accountLevelService.accountDowngrade();
			System.out.println("用户降级查询用户投资金额结束："+df.format(new Date()));
		}
		catch (Exception e)
		{
			logger.error("用户降级查询用户投资金额异常", e);
		}
	}
	
	
	/**
	 * 
	 * @Description:月初扫描刷新用户特权
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月14日 下午2:37:22
	 */
	@Scheduled(cron="0 55 5 1 * ?")//cron="0 55 5 1 * ?"
	public void refeshPower()
	{
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("月初扫描刷新用户特权开始："+df.format(new Date()));
			accountLevelService.refeshPower();
			System.out.println("月初扫描刷新用户特权结束："+df.format(new Date()));
		}
		catch (Exception e)
		{
			logger.error("月初扫描刷新用户特权异常", e);
		}
	}
	
	/**
	 * 
	 * @Description:等级上线扫描一次根据用户投资金额刷新用户等级
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月15日 上午10:28:30
	 */
	/*@Scheduled(cron="0 25 19 5 12 ?")
	public void refeshLevelOnlyOneTime()
	{
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("等级上线扫描一次刷新用户等级开始："+df.format(new Date()));
			accountLevelService.refeshLevelOnlyOneTime();
			System.out.println("等级上线扫描一次刷新用户等级结束："+df.format(new Date()));
		}
		catch (Exception e)
		{
			logger.error("等级上线扫描一次刷新用户等级异常", e);
		}
	}*/
}
