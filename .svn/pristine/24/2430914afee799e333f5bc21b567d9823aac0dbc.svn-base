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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xed.financing.wxgzh.service.msgPrompt.MessagePromptService;
import com.xed.financing.wxgzh.util.MobileMessagePrompt;

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
public class MessagePrompt
{
	
	@Autowired
	private MessagePromptService messagePromptService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(MessagePrompt.class);
	
	/**
	 * 每天发送短信提示投标结算
	 * 
	 * @Description:
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月13日 下午4:15:27
	 */
	@Scheduled(cron = "0 40 16 * * ? ")
	public void promptSettlement() 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String nowDate = sdf.format(date);
		System.out.println("收益结算提示" + nowDate);
		try
		{
			messagePromptService.promptSettlement();
		}
		catch (Exception e)
		{
			logger.error("收益结算提示异常", e);
		}
	
		System.out.println("收益结算提示" + nowDate);
	}


	

	public static void main(String a[]) throws Exception
	{
		MobileMessagePrompt.msgPrompt("15895462414","200","2017年07月18日");
		

	}
}
