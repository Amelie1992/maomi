/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.signin.SigninInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月23日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.signin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.signin.SignInBean;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.signin.SignInService;
import com.xed.financing.wxgzh.util.JsonUtil;

/**
 * @className:com.xed.financing.wxgzh.controller.intface.signin.SigninInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月23日 上午9:31:06
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/ios/signin")
public class SigninInterfaceController
{
	
	@Autowired
	private SignInService signInService;
	
	@Autowired
	private AccountLevelService accountLevelService;
	
	private Logger logger = Logger.getLogger(SigninInterfaceController.class);
	
	/**
	 * 前往签到页面
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/signin/toSignIn?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年4月23日 上午9:40:05
	 */
	@ResponseBody
	@RequestMapping("/toSignIn")
	public JSONObject toSignIn(String accountId){
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		// 跳转页面
		try
		{
			
			
			//获得当前用户本月累计签到天数
			Integer countDay = signInService.queryCurrentMonthSignInDayCount(accountId);
			//获得当前用户本月累计获得鱼干
			Integer countScore = signInService.queryCurrentMonthSignInScoreCount(accountId);
			//获得当前用户今日签到情况
			Integer isSignIn = signInService.checkSignIn(accountId);
			//获得当前用户本月签到日期
			List<SignInBean> signInBean = signInService.queryCurrentMonthSignInList(accountId);
			//拼接签到时间('yyyyMMdd,yyyyMMdd...,yyyyMMdd')
			String signInDay= "";
			if(signInBean.size()>0){
				signInDay = signInBean.get(0).getSigninDate();
				for (int i = 1; i < signInBean.size(); i++)
				{
					signInDay += "," + signInBean.get(i).getSigninDate();
				}
			}
			//获取用户等级和可补签次数
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setAccountId(accountId);
			String signY = "0";
			AccountInfo info = accountLevelService.queryAccountLevel(accountInfo);
			if(Integer.parseInt(info.getRepairSignNumber())>0 && signInService.changeYesterdaySign(accountInfo)==0){
				signY = "1";
			}
			//通过request传去前台
			
			
			
			JSONObject objs = new JSONObject();
			
			
			objs.put("isSignIn", isSignIn);
			objs.put("countDay", countDay);
			objs.put("countScore", countScore);
			objs.put("signInDay", signInDay);
			objs.put("signY", signY);
			
			msg = "";
			code = "200";
			obj.put("data", objs);
		}
		catch (SQLException e)
		{
			logger.error("获得账号信息异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	
	/**
	 * 签到
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/signin/signIn?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年4月23日 下午2:33:21
	 */
	@ResponseBody
	@RequestMapping("/signIn")
	public JSONObject signIn(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		
		JSONObject objs = new JSONObject();
		// 跳转页面
		try
		{
			
			//创建签到对象
			SignInBean signInBean = new SignInBean();
			signInBean.setAccountId(accountId);
			
			//获取今天是否签到过
			Integer isSignIn = signInService.checkSignIn(signInBean.getAccountId());
			
			if(isSignIn==0){
				//添加签到记录
				Map<String, Object> map = new HashMap<String, Object>();
				
				signInService.addSignIn(signInBean);
				signInService.addBonusPoints(null, accountId, map);
				
				objs.put("accountInfo", JsonUtil.beanToJson(map.get("accountInfo")));
				objs.put("count", map.get("count"));
				objs.put("rate",map.get("rate"));
				objs.put("rateAll",map.get("rateAll"));
				
				
				msg = "签到成功";
				code = "200";
				
			}else{
				//已签到
				msg = "重复签到";
				code = "201";
			}
			obj.put("data", objs);
			
		}
		catch (Exception e)
		{
			logger.error("签到异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	
	}
	
	
	
	
	/**
	 * 补签昨日
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/signin/signingYesterday?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年4月23日 下午2:42:29
	 */
	@ResponseBody
	@RequestMapping("/signingYesterday")
	public JSONObject signingYesterday(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		
		// 跳转页面
		try
		{
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setAccountId(accountId);
			
			//判断，补签  notEnough:次数不足 isSign:昨日已签 success:补签成功
			String result = signInService.signingYesterday(accountInfo);
			if("success".equals(result)){
				result = signInService.addBonusPointsYesterDay(accountInfo);
				msg = "补签成功";
				code = "200";
			}else if("notEnough".equals(result)){
				msg = "次数不足";
				code = "201";
			}else if("isSign".equals(result)){
				msg = "昨日已签";
				code = "202";
			}
		}
		catch (Exception e)
		{
			logger.error("签到异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	
	}
}
