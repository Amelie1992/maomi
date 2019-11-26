/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.FreedomSubjectInvest
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年10月27日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.timingProcessing;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xed.financing.wxgzh.service.freedomsubjectinvest.FreedomSubjectInvestService;

/**
 * 猫咪宝投资10000满十天送加息券
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.FreedomSubjectInvest
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月27日 上午10:34:57
 * @author:QT
 */
@Component
public class FreedomSubjectInvest
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(DataSplit.class);
	
	
	@Autowired
	private FreedomSubjectInvestService freedomSubjectInvestService;
	
	/**
	 * 重置不满足十天条件的用户  
	 * @Description:
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月30日 上午11:42:19
	 */
	/*@Scheduled(cron = "0 0 0/1 10-28 11 ?")//0 0 0/1 10-28 11 ?
	public void resetFreedomSubjectCoupon() 
	{
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("筛选猫咪宝用户开始："+df.format(new Date()));
			freedomSubjectInvestService.resetFreedomSubjectCoupon();
			System.out.println("筛选猫咪宝用户结束："+df.format(new Date()));
		}
		catch (Exception e)
		{
			logger.error("筛选异常", e);
		}
	}
	
	*//**
	 * 设置当天满足条件的所有用户+1
	 * @Description:
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月30日 上午11:43:05
	 *//*
	@Scheduled(cron = "0 30 23 9-28 11 ?") //0 50 23 9-28 11 ?
	public void setFreedomSubjectCoupon() 
	{
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("设置开始："+df.format(new Date()));
			freedomSubjectInvestService.setFreedomSubjectCoupon();
			System.out.println("设置结束："+df.format(new Date()));
		}
		catch (Exception e)
		{
			logger.error("设置异常", e);
		}
	}*/
	
	/**
	 * 转移猫咪宝
	 * @Description:
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年1月10日 下午4:00:23
	 *//*
	@Scheduled(cron = "0 0 20 15 1 ?") //0 50 23 9-28 11 ?
	public void setFreedomSubjectCoupon() 
	{
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("猫咪宝转移开始："+df.format(new Date()));
			freedomSubjectInvestService.setFreedomsubjectOverZero();
			System.out.println("猫咪宝转移结束："+df.format(new Date()));
		}
		catch (Exception e)
		{
			logger.error("猫咪宝转移异常", e);
		}
	}*/
	
}
