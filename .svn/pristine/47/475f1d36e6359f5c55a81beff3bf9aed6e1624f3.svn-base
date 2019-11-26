/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.DataSplit
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年10月13日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.timingProcessing;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;
import com.xed.financing.wxgzh.service.datasplit.DataSplitService;

/**
 * 分散标定时器
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.DataSplit
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月13日 上午10:27:08
 * @author:ZhangJun
 */
@Component
public class DataSplit
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(DataSplit.class);
	
	
	@Autowired
	private DataSplitService dataSplitService;
	
	
	/**
	 * 
	 * @Description:
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月13日 下午1:29:00
	 */
	/*@Scheduled(cron = "0 0 0/6 * * ? ")
	public void dataSplit() 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String nowDate = sdf.format(date);
		System.out.println("数据拆分开始:" + nowDate);
		try
		{
			// 获取猫咪宝当前所有投资人的投资时间和投资总金额
			List<FreedomSubjectBean> freedomSubjectBeans = dataSplitService.getFreedomInvestInfo();
			
			// 删除投资用户的分团记录
			dataSplitService.deleteDispersedRecord(freedomSubjectBeans);
			
			dataSplitService.addInvestRecord(freedomSubjectBeans);
			
		}
		catch (Exception e)
		{
			logger.error("数据拆分异常", e);
		}
	
		System.out.println("数据拆分结束:" + nowDate);
	}*/
	
}
