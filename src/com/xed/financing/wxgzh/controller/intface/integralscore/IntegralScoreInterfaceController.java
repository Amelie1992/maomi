package com.xed.financing.wxgzh.controller.intface.integralscore;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.controller.integralscore.IntegralScoreController;
import com.xed.financing.wxgzh.service.integralscore.IntegralScoreService;

import net.sf.json.JSONObject;

/**
 * 鱼干充值
 * @className:com.xed.financing.wxgzh.controller.intface.integralscore.IntegralScoreInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月24日 上午11:19:45
 * @author:zheng shuai
 */
@Controller
@RequestMapping("/ios/integralscore")
public class IntegralScoreInterfaceController
{
	
	@Autowired
	private IntegralScoreService integralScoreService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(IntegralScoreController.class);
	
	/**
	 * 去鱼干充值页面
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/integralscore/toIntegral?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月24日 上午10:36:51
	 */
	@ResponseBody
	@RequestMapping("/toIntegral")
	public JSONObject toIntegral(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			integralScoreService.iosSendMessage(accountId,obj);
			msg = "";
			code = "200";
		}
		catch (SQLException e)
		{
			logger.error("去鱼干充值异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 购买鱼干
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/integralscore/recharge?money=&accountId=
	 * @param money
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月24日 上午11:14:35
	 */
	@ResponseBody
	@RequestMapping("/recharge")
	public JSONObject recharge(String money ,String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			String result = integralScoreService.iosRecharge(money, accountId);
			if ("insufficient".equals(result)){
				msg = "余额不足";
				code = "201";
			} else if ("miserror".equals(result)) {
				msg = "购买金额异常";
				code = "203";
			} else if ("success".equals(result)) {
				msg = "购买成功";
				code = "200";
			} else if ("error".equals(result)) {
				msg = "系统异常";
				code = "500";
			}
		}
		catch (Exception e)
		{
			logger.error("IO异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
}
