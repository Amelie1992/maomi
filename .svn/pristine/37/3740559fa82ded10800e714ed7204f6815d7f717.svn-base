package com.xed.financing.wxgzh.controller.timingProcessing;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xed.financing.wxgzh.service.savings.SavingsService;

/**
 * 猫咪储蓄
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.savingsTime
 * @description:
 * @version:v1.0.0 
 * @date:2018年1月15日 上午10:01:26
 * @author:Peng Gang
 */
@Component
public class savingsTime
{
	@Autowired
	private SavingsService savingservice;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(savingsTime.class);
	
	/**
	 * 猫咪储蓄红包 是否过期
	 * @Description:
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月15日 上午10:02:21
	 */
	@Scheduled(cron = "0 0 1 * * ? ")
	public void updateSavingsType(){
		
		try
		{
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			System.out.println("猫咪储蓄红包过期执行开始" + df.format(new Date()));
			savingservice.updateSavingsValidaty();
			System.out.println("猫咪储蓄红包过期执行结束" + df.format(new Date()));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("猫咪储蓄红包过期执行异常");
		}
	}

}
