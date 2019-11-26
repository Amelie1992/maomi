/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.CrowdfundTime
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月21日       QT          v1.0.0        create
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

import com.xed.financing.wxgzh.service.crowdfund.CrowdfundService;

/**
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.CrowdfundTime
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月21日 下午4:31:24
 * @author:QT
 */
@Component
public class CrowdfundTime
{
	@Autowired
	private CrowdfundService crowdfundService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(CrowdfundTime.class);
	
	@Scheduled(cron = "0 0 8 * * ? ")
	public void checkCrowdfund() 
	{
		try
		{
			//----------------------------众筹活动上架-------------------------------------------
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("扫描众筹活动是否有上架："+df.format(new Date()));
			int a=crowdfundService.startCrowdfund();
			System.out.println("扫描众筹活动是否有上架结束："+df.format(new Date())+"共计上架"+a+"个众筹活动");
			
			//----------------------------众筹活动集资结束-------------------------------------------
			crowdfundService.froupCrowdfund();
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Scheduled(cron = "0 0 17 * * ? ")
	public void revenueSettlement() 
	{
		try
		{
			//----------------------------众筹结束  发放收益-------------------------------------------
			crowdfundService.endCrowdfund();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
