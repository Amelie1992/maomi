/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.analysis.AnalysisInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年6月8日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.analysis;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.analysis.AnalysisBean;
import com.xed.financing.wxgzh.service.analysis.AnalysisService;

/**
 * @className:com.xed.financing.wxgzh.controller.intface.analysis.AnalysisInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年6月8日 上午10:58:56
 * @author:QT
 */
@Controller
@RequestMapping("/ios/analysis")
public class AnalysisInterfaceController
{
	@Autowired
	private AnalysisService analysisService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AnalysisInterfaceController.class);

	/**
	 * ios添加用户分析
	 * @Description:
	 * @param accountId
	 * @param isUsed
	 * @param isBad
	 * @param couponType
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年6月8日 上午10:59:47
	 */
	@ResponseBody
	@RequestMapping("/addAnalysis")
	public JSONObject addAnalysis(String accountId, String verCode, String beginTime, String endTime)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "添加用户分析数据异常";
		String code = "500";
		// 跳转页面
		try
		{
			AnalysisBean aBean=new AnalysisBean();
			aBean.setAccountId(accountId);
			aBean.setVerCode(verCode);
			aBean.setBeginTime(beginTime);
			aBean.setEndTime(endTime);
			if (!"".equals(accountId)||accountId != null)
			{
				analysisService.addAccountAnalysis(aBean);
			}
			msg = "添加成功";
			code = "200";
		}
		catch (Exception e)
		{
			logger.error("添加ios用户数据分析异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
}
