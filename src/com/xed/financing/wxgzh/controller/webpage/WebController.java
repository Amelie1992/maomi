package com.xed.financing.wxgzh.controller.webpage;

/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.loginRegister.LoginRegisterController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月15日    ZhangJun  v1.0.0        create
 *
 *
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService;
import com.xed.financing.wxgzh.service.messagecode.MessageCodeService;
import com.xed.financing.wxgzh.service.savings.SavingsService;
import com.xed.financing.wxgzh.util.MobileMessageCheck;
import com.xed.financing.wxgzh.util.MobileMessageSend;



/**
 * 登录注册controller
 * 
 * @className:com.xed.financing.wxgzh.controller.loginRegister.LoginRegisterController
 * @description:
 * @version:v1.0.0
 * @date:2017年3月15日 下午2:50:27
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/weblogin")
public class WebController
{
	@Autowired
	private LoginRegisterService service;

	@Autowired
	private AccountInfoService accountInfoService;

	@Autowired
	private CouponService couponService;
	
	@Autowired
	private SavingsService savingsService;
	
	@Autowired
	private CapitalService capitalService;
	
	@Autowired
	private MessageCodeService messageCodeService;
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(WebController.class);

	/**
	 * 登录方法
	 * 
	 * @Description:
	 * @param password
	 * @param accountName
	 * @param yzm
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月16日 上午11:30:00
	 */
	@ResponseBody
	@RequestMapping("/s/login")
	public void login(String password, String accountName, HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";
		// 创建账户对象 赋值
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountName(accountName);
		accountInfo.setPassword(password);
		accountInfo.setTelephone(accountName);
		// 获取session
		HttpSession session = request.getSession();
		// 判断验证码是否正确

		try
		{
			/*
			 * if (!((String)
			 * session.getAttribute(RandomValidateCode.RANDOMCODEKEY
			 * )).toLowerCase().equals( yzm.toLowerCase())) { // 不正确 设置标记 result
			 * = "{\"result\":\"yzm\"}"; } else
			 */if (service.checkLogin(accountInfo))
			{
				// 登录成功 设置标记
				result = "{\"result\":\"success\"}";
				// 将登录成功的用户AccountId信息放到session
				AccountInfo info = accountInfoService.getAccountInfo(accountInfo.getAccountId());
				info.setAccountId(accountInfo.getAccountId());
				session.setAttribute("account", info);
			}
			// 传递标识
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("检查登录异常", e);
		}
	}

	/**
	 * 跳转注册页面
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 下午3:12:21
	 */
	@RequestMapping("/s/toRegister")
	public String toRegister(@RequestParam(value = "telephone", required = false, defaultValue = "defaultValue") String telephone, HttpServletRequest request, String recommend)
	{
		AccountInfo accountInfo;
		
		try
		{
			if (recommend != null && !recommend.equals(""))
			{
				accountInfo = accountInfoService.getAccountInfo(recommend);
				request.setAttribute("recommendTelephone", accountInfo.getTelephone());
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		if(!telephone.equals("defaultValue")){
			request.setAttribute("telephone", telephone);
		}
		
		return "/loginregister/register";
	}

	/**
	 * 判断手机号是否已注册
	 * 
	 * @Description:注册过result=error 未注册过result=success
	 * @param telephone
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 下午3:17:05
	 */
	@ResponseBody
	@RequestMapping("/s/checkPhone")
	public void checkTelephoneOnly(String telephone, HttpServletRequest request, HttpServletResponse response)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		// 检查手机号是否存在
		try
		{
			if (service.checkTelephoneOnly(telephone))
			{
				result = "{\"result\":\"success\"}";
			}
		}
		catch (SQLException e)
		{
			logger.error("检查手机号是否唯一异常", e);
		}
		response.setContentType("application/json");
		try
		{
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (IOException e)
		{
			logger.error("IO异常", e);
		}

	}

	/**
	 * 注册
	 * 
	 * @Description:
	 * @param accountInfo
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月16日 下午4:17:42
	 */
	@ResponseBody
	@RequestMapping("/s/register")
	public void register(String telephone, String yzm, String recommendTelephone, String password,
			HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";
		// 获取session
		HttpSession session = request.getSession();
		try
		{
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setTelephone(telephone);
			accountInfo.setYzm(yzm);
			accountInfo.setPassword(password);
			accountInfo.setRecommendTelephone(recommendTelephone);
			
			// 判断手机验证码 创建标识
			String message = MobileMessageCheck.checkMsg(accountInfo.getTelephone(), accountInfo.getYzm());

			// 如果验证码正确，添加账户信息
			if ("success".equals(message))
			{
				if (service.checkTelephoneOnly(telephone))
				{
					if (service.addAccountInfo(accountInfo))
					{
						// 注册成功
						CapitalBean capitalBean = new CapitalBean();
						capitalBean.setAccountId(accountInfo.getAccountId());
						// 添加用户资金表
						capitalService.addAccountCapital(capitalBean);
						//添加用户等级
						service.addAccountLevel(accountInfo);
						// 发送888体验金
						couponService.registeredExperienceGold(accountInfo);

						AccountInfo info = accountInfoService.getAccountInfo(accountInfo.getAccountId());
						info.setAccountId(accountInfo.getAccountId());
						session.setAttribute("account", info);
						
						//注册送0.5元猫咪储蓄金额
						savingsService.addSavingsRecord(accountInfo.getAccountId(), "50", "1", 1);

						result = "{\"result\":\"success\"}";
					}
					else
					{
						// 出错
						result = "{\"result\":\"error\"}";
					}
				}
				else
				{
					// 已注册
					result = "{\"result\":\"repeat\"}";
				}

			}
			else
			{
				// 验证码错误
				result = "{\"result\":\"yzm\"}";
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("注册异常", e);
		}
	}

	/**
	 * 发送手机验证码
	 * 
	 * @Description:
	 * @param telephone
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月16日 下午2:53:01
	 */
	@ResponseBody
	@RequestMapping("/s/sendMobileCode")
	public void sendMobileCode(String telephone, HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";
		try
		{
			String str = "";
			// 调用发送验证码功能，返回成功与否的结果
			if(messageCodeService.checkCount(telephone)){
				str = MobileMessageSend.sendMsg(telephone);
				messageCodeService.addMessage(telephone, "1");
			}else{
				str = "limit";
			}
			result = "{\"result\":\"" + str + "\"}";
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("手机验证码发送异常", e);
		}
	}
	
	@RequestMapping("/s/webPage")
	public String webPage(){
		return "z-webpage/weblogin";
	}
}
