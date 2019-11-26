/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.integralscore.IntegralScoreController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月14日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.integralscore;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.service.activityrecord.ActivityRecordService;
import com.xed.financing.wxgzh.service.integralscore.IntegralScoreService;
import com.xed.financing.wxgzh.service.userlevel.UserLevelService;
import com.xed.financing.wxgzh.util.InterfaceUtil;

/**
 * 鱼干充值
 * @className:com.xed.financing.wxgzh.controller.integralscore.IntegralScoreController
 * @description:
 * @version:v1.0.0
 * @date:2017年4月14日 下午5:02:21
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/integralscore")
public class IntegralScoreController
{

	@Autowired
	private UserLevelService userLevelService;

	@Autowired
	private IntegralScoreService integralScoreService;
	
	@Autowired
	private ActivityRecordService activityRecordService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(IntegralScoreController.class);

	/**
	 * 去鱼干充值页面
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月17日 下午3:05:37
	 */
	@RequestMapping("/toIntegral")
	public String toIntegral(HttpSession session,ModelMap map)
	{
		try
		{
			Map<String, Object> resultMap = integralScoreService.getBalance(session);
			map.addAttribute("balance", resultMap.get("balance"));
			map.addAttribute("accountInfo", resultMap.get("accountInfo"));
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//查询用户总余额传值页面
		return "integralscore/integralscore";
	}

	/*@RequestMapping("/recharge")*/
	@ResponseBody
	@RequestMapping(value="/recharge",method=RequestMethod.POST)
	public void recharge(String money ,HttpServletRequest request, HttpServletResponse response)
	{
		String result = "{\"result\":\"error\"}";
		try
		{
			result = "{\"result\":\"" + integralScoreService.recharge(money, request) + "\"}";
			//userLevelService.changeUserLevel(request);
			//----------------------------------七夕集字活动--------------------------------------------
			/*String result2 = activityRecordService.activityCalligraphy(request, "3");
			if(!"".equals(result2)){
				result = "{\"result\":\"success\", \"jizi\":\""+result2+"\"}";
			}*/
			//----------------------------------------------------------------------------------------
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("IO异常", e);
		}
	}

}
