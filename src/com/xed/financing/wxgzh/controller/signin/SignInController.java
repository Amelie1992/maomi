/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.signin.SignInController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月13日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.signin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.signin.SignInBean;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.activityrecord.ActivityRecordService;
import com.xed.financing.wxgzh.service.material.MaterialService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.sendcash.SendCashCouponService;
import com.xed.financing.wxgzh.service.signin.SignInService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.service.userlevel.UserLevelService;
import com.xed.financing.wxgzh.util.Constants;

/**
 * 签到
 * 
 * @className:com.xed.financing.wxgzh.controller.signin.SignInController
 * @description:签到控制器
 * @version:v1.0.0
 * @date:2017年4月13日 下午3:36:27
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/signin")
public class SignInController
{
	@Autowired
	private SignInService service;

	@Autowired
	private UserLevelService userLevelService;
	
	@Autowired
	private ActivityRecordService activityRecordService;
	
	@Autowired
	private SendCashCouponService sendCashCouponService;
	
	@Autowired
	private ParamService paramService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private AccountLevelService accountLevelService;
	
	@Autowired
	private MaterialService materialService;
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(SignInController.class);

	/**
	 * 去签到页面
	 * @Description:查询当前用户当前月签到日期，今日是否签到，本月签到累计天数
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月14日 上午10:13:22
	 */
	@RequestMapping("/toSignIn")
	public String toSignIn(HttpServletRequest request)
	{
		
		try
		{
			//获得当前登录用户
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			String accountId = accountInfo.getAccountId();
			//获得当前用户本月累计签到天数
			Integer countDay = service.queryCurrentMonthSignInDayCount(accountId);
			//获得当前用户本月累计获得鱼干
			Integer countScore = service.queryCurrentMonthSignInScoreCount(accountId);
			//获得当前用户今日签到情况
			Integer isSignIn = service.checkSignIn(accountId);
			//获得当前用户本月签到日期
			List<SignInBean> signInBean = service.queryCurrentMonthSignInList(accountId);
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
			String signY = "0";
			AccountInfo info = accountLevelService.queryAccountLevel(accountInfo);
			if(Integer.parseInt(info.getRepairSignNumber())>0 && service.changeYesterdaySign(accountInfo)==0){
				signY = "1";
			}
			//通过request传去前台
			request.setAttribute("isSignIn", isSignIn);
			request.setAttribute("countDay", countDay);
			request.setAttribute("countScore", countScore);
			request.setAttribute("signInDay", signInDay);
			request.setAttribute("signY", signY);
		}
		catch (Exception e)
		{
			logger.error("签到模块，查询签到历史", e);
		}

		return "signin/signIn";
	}

	/**
	 * 签到
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @throws Exception 
	 * @date:2017年4月14日 上午10:22:04
	 */
	/*@RequestMapping("/signIn")*/
	@ResponseBody
	@RequestMapping(value="/signIn",method=RequestMethod.POST)
	public Map<String, Object> signIn(HttpServletRequest request) throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();

		//获得当前用户及等级
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		
		//创建签到对象
		SignInBean signInBean = new SignInBean();
		signInBean.setAccountId(accountId);
		
		//获取今天是否签到过
		Integer isSignIn = service.checkSignIn(signInBean.getAccountId());
		
		if(isSignIn==0){
			//添加签到记录
			service.addSignIn(signInBean);
			service.addBonusPoints(request, accountId, map); 
			map.put("msg", "0");
			
//			String beginDate=paramService.getParamVal("SIGN_BEGIN_DATE");
//			String endDate=paramService.getParamVal("SIGN_END_DATE");
//			signInBean.setBeginDate(beginDate);
//			signInBean.setEndDate(endDate);
//			int days=service.countSignOn(signInBean);
//			//满签成功
//			if(days>=Constants.MID_MOON_FULL_SIGN_DAYS)
//			{
//				materialService.sendMoon(1, "2", accountId, "", "");
//			}
		}else{
			//已签到
			map.put("msg", "1");
		}
		return map;
	}
	
	/**
	 * 补签昨日
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月13日 下午3:01:01
	 */
	@ResponseBody
	@RequestMapping(value="/signInYesterday",method=RequestMethod.POST)
	public Map<String, String> signingYesterday(HttpServletRequest request){
		Map<String, String> resultMap = new HashMap<String, String>();
		try
		{
			AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("account");
			//判断，补签  notEnough:次数不足 isSign:昨日已签 success:补签成功
			String result = service.signingYesterday(accountInfo);
			if("success".equals(result)){
				result = service.addBonusPointsYesterDay(accountInfo);
			}
			resultMap.put("result", result);
		}
		catch (Exception e)
		{
			logger.error("补签昨日异常", e);
		}
		return resultMap;
	}
	
}
