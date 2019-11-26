/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.accountInfo.AccountInfoController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月23日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.accountInfo;

import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.city.CityBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountbankcard.AccountBankcardService;
import com.xed.financing.wxgzh.service.city.CityService;
import com.xed.financing.wxgzh.service.fuiou.FuiouService;
import com.xed.financing.wxgzh.service.integralscore.IntegralScoreService;
import com.xed.financing.wxgzh.service.messagecode.MessageCodeService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.MobileMessageCheck;
import com.xed.financing.wxgzh.util.MobileMessageSend;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.accountInfo.AccountInfoController
 * @description:
 * @version:v1.0.0
 * @date:2017年3月23日 下午2:14:50
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/accountinfo")
public class AccountInfoController
{
	@Autowired
	private AccountInfoService service;

	@Autowired
	private CityService cityService;

	@Autowired
	private AccountBankcardService accountBankcardService;

	@Autowired
	private IntegralScoreService integralScoreService;
	
	@Autowired
	private MessageCodeService messageCodeService;
	
	@Autowired
	private FuiouService fuiouService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AccountInfoController.class);

	/**
	 * 去个人信息设置
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 下午3:46:35
	 */
	@RequestMapping("/personalSettings")
	public String personalSettings(HttpServletRequest request)
	{
		// 跳转页面
		try
		{
			AccountInfo accountInfo = service.getLoginAccountInfo(request);
			if (accountInfo == null)
			{
				// 未登录 去登录页面
				return "/loginregister/login";
			}
			else
			{
				Integer bankCount = accountBankcardService.getBankcardCount(accountInfo.getAccountId());
				request.setAttribute("accountInfo", accountInfo);
				request.setAttribute("bankCount", bankCount);
			}
		}
		catch (SQLException e)
		{
			logger.error("获得账号信息异常", e);
		}
		return "/accountInfo/settings";
	}

	/**
	 * 去修改用户名页面
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 下午3:47:27
	 */
	@RequestMapping("/toChangeName")
	public String toChangeName(HttpServletRequest request)
	{

		return "/accountInfo/changeAccountName";
	}

	/**
	 * 去修改用户头像页面
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 下午3:47:27
	 */
	@RequestMapping("/toChangeIcon")
	public String toChangeIcon(HttpServletRequest request)
	{

		return "/accountInfo/changeAccountIcon";
	}

	/**
	 * 检查用户名是否存在
	 * 
	 * @Description:
	 * @param accountName
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 下午3:47:03
	 */
	/*@RequestMapping("/checkName")*/
	@ResponseBody
	@RequestMapping(value="/checkName",method=RequestMethod.POST)
	public void checkName(String accountName, HttpServletRequest request, HttpServletResponse response)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		// 检查用户名是否存在
		try
		{
			accountName = URLDecoder.decode(accountName, "UTF-8");
			Integer falg = service.checkAccountName(accountName);
			if (falg == null)
			{
				result = "{\"result\":\"undefind\"}";
			}
			else if (falg == 0)
			{
				result = "{\"result\":\"success\"}";
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("检查用户名是否唯一异常", e);
		}

	}

	/**
	 * 修改用户名
	 * 
	 * @Description:
	 * @param accountInfo
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 下午3:48:21
	 */
	/*@RequestMapping("/changeName")*/
	@ResponseBody
	@RequestMapping(value="/changeName",method=RequestMethod.POST)
	public void changeName(String accountName, HttpServletRequest request, HttpServletResponse response)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";

		try
		{
			accountName = URLDecoder.decode(accountName, "UTF-8");
			// accountName =new
			// String(accountName.getBytes("ISO-8859-1"),"utf-8");
			Integer falg = service.changeAccountName(request, accountName);
			if (falg == null)
			{
				result = "{\"result\":\"noLogin\"}";
			}
			else if (falg == 1)
			{
				result = "{\"result\":\"success\"}";
				integralScoreService.perfectInformationIntegralReward(request);
			}
			else
			{
				result = "{\"result\":\"error\"}";
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("更改用户名异常", e);
		}

	}

	/**
	 * 去修改登录密码页面
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 下午4:59:14
	 */
	@RequestMapping("/toChangeLoginPassword")
	public String toChangeLoginPassword(HttpServletRequest request, HttpServletResponse response)
	{
		return "/accountInfo/changeLoginPassword";
	}

	/**
	 * 修改登录密码
	 * 
	 * @Description:
	 * @param password
	 * @param oldPassword
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月24日 下午3:08:37
	 */
	/*@RequestMapping("/changePassword")*/
	@ResponseBody
	@RequestMapping(value="/changePassword",method=RequestMethod.POST)
	public void changePassword(String password, String oldPassword, HttpServletRequest request,
			HttpServletResponse response)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setPassword(oldPassword);

		try
		{
			// 判断原登录密码是否正确
			Integer falg = service.checkLoginPassword(request, accountInfo);
			if (falg == null)
			{
				// 未登录
				result = "{\"result\":\"unLogin\"}";
			}
			else if (falg == 0)
			{
				// 密码错误
				result = "{\"result\":\"worry\"}";
			}
			else
			{
				// 修改密码
				accountInfo.setPassword(password);
				Integer falg2 = service.changeLoginPassword(request, accountInfo);
				if (falg2 == 1)
				{
					result = "{\"result\":\"success\"}";
				}
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("修改登录密码异常", e);
		}

	}

	/**
	 * 去修改交易密码
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月24日 下午3:06:06
	 */
	@RequestMapping("/toChangeDealPassword")
	public String toChangeDealPassword(HttpServletRequest request, HttpServletResponse response)
	{

		return "/accountInfo/changeDealPassword";
	}

	/**
	 * 去设置交易密码
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月24日 下午3:07:17
	 */
	@RequestMapping("/toSetDealPassword")
	public String toSetDealPassword(HttpServletRequest request, HttpServletResponse response)
	{

		return "/accountInfo/setDealPassword";
	}

	/**
	 * 设置交易密码
	 * 
	 * @Description:
	 * @param dealPassword
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月28日 上午9:51:46
	 */
	/*@RequestMapping("/setDealPassword")*/
	@ResponseBody
	@RequestMapping(value="/setDealPassword",method=RequestMethod.POST)
	public void setDealPassword(String dealPassword, HttpServletRequest request, HttpServletResponse response)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
		try
		{

			if (accountInfo == null)
			{
				// 未登录
				result = "{\"result\":\"unLogin\"}";
			}
			else
			{
				// 设置交易密码
				accountInfo.setDealPassword(dealPassword);
				if (service.setDealPassword(accountInfo))
				{
					result = "{\"result\":\"success\"}";
				}
				else
				{
					result = "{\"result\":\"error\"}";
				}
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("修改交易密码异常", e);
		}

	}

	/**
	 * 修改交易密码
	 * 
	 * @Description:
	 * @param dealPassword
	 * @param oldDealPassword
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月24日 下午3:11:20
	 */
	/*@RequestMapping("/changeDealPassword")*/
	@ResponseBody
	@RequestMapping(value="/changeDealPassword",method=RequestMethod.POST)
	public void changeDealPassword(String dealPassword, String oldDealPassword, HttpServletRequest request,
			HttpServletResponse response)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setDealPassword(oldDealPassword);
		try
		{
			// 判断原交易密码是否正确
			Integer falg = service.checkDealPassword(request, accountInfo);
			if (falg == null)
			{
				// 未登录
				result = "{\"result\":\"unLogin\"}";
			}
			else if (falg == 0)
			{
				// 密码错误
				result = "{\"result\":\"worry\"}";
			}
			else
			{
				// 修改交易密码
				accountInfo.setDealPassword(dealPassword);
				Integer falg2 = service.changeDealPassword(request, accountInfo);
				if (falg2 == 1)
				{
					result = "{\"result\":\"success\"}";
				}
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("修改交易密码异常", e);
		}

	}

	/**
	 * 去找回交易密码页面
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月29日 上午9:42:10
	 */
	@RequestMapping("/toGetBackDealPassword")
	public String toGetBackDealPassword(HttpServletRequest request, HttpServletResponse response)
	{

		return "/accountInfo/getBackDealPassword";
	}

	/**
	 * 判断手机号是否为登录手机号 发送短信验证码
	 * 
	 * @Description:
	 * @param telephone
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月24日 下午5:41:52
	 */
	/*@RequestMapping("/sendMobileCode")*/
	@ResponseBody
	@RequestMapping(value="/sendMobileCode",method=RequestMethod.POST)
	public void sendMobileCode(String telephone, HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";
		try
		{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			if (accountInfo != null)
			{
				if (service.checkAccountTelephone(request, telephone))
				{
					String str = "";
					// 调用发送验证码功能，返回成功与否的结果
					if(messageCodeService.checkCount(telephone)){
						str = MobileMessageSend.sendMsg(telephone);
						messageCodeService.addMessage(telephone, "4");
					}else{
						str = "limit";
					}
					
					result = "{\"result\":\"" + str + "\"}";
				}
				else
				{
					result = "{\"result\":\"different\"}";
				}
			}
			else
			{
				result = "{\"result\":\"noLogin\"}";
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("手机验证码发送异常", e);
		}

	}

	/**
	 * 重置交易密码
	 * 
	 * @Description:
	 * @param password
	 * @param yzm
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月11日 上午11:18:53
	 */
	/*@RequestMapping("/reappearSetDealPassword")*/
	@ResponseBody
	@RequestMapping(value="/reappearSetDealPassword",method=RequestMethod.POST)
	public void reappearSetDealPassword(String password, String yzm, HttpServletRequest request,
			HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";

		try
		{
			AccountInfo accountInfo = service.getLoginAccountInfo(request);
			String flag = MobileMessageCheck.checkMsg(accountInfo.getTelephone(), yzm);
			// 短信验证码验证成功
			if ("success".equals(flag))
			{
				accountInfo.setDealPassword(password);
				// 修改密码
				Integer falg2 = service.changeDealPassword(request, accountInfo);
				if (falg2 != null && falg2 == 1)
				{
					result = "{\"result\":\"success\"}";
				}
				else
				{
					result = "{\"result\":\"error\"}";
				}
			}
			else
			{
				result = "{\"result\":\"different\"}";
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("重置交易密码异常", e);
		}

	}

	/**
	 * 去风险能力测试页面
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 下午3:47:27
	 */
	@RequestMapping("/torisktest")
	public String toRiskTest(HttpServletRequest request, String url)
	{
		try
		{
			AccountInfo accountInfo = service.getLoginAccountInfo(request);
			request.setAttribute("isRisk", accountInfo.getIsRisk());
			request.setAttribute("accountInfo", accountInfo);
			if(!StringTools.isEmpty(url)){
				request.setAttribute("backurl", url);
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "/accountInfo/risktest";
	}

	/**
	 * 去风险能力测试页面(重新测试)
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 下午3:47:27
	 */
	@RequestMapping("/torisktestreset")
	public String toRiskTestReset(HttpServletRequest request)
	{
		try
		{
			AccountInfo accountInfo = service.getLoginAccountInfo(request);
			request.setAttribute("isRisk", accountInfo.getIsRisk());
			accountInfo.setRiskResult("");
			accountInfo.setIsRisk(Constants.DEVIL_NUM_ZERO);
			request.setAttribute("accountInfo", accountInfo);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "/accountInfo/risktest";
	}

	/**
	 *  记录风险能力测试结果
	 * @Description:
	 * @param riskResult
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年8月9日 下午3:06:47
	 */
	/*@RequestMapping("/risktestover")*/
	@ResponseBody
	@RequestMapping(value="/risktestover",method=RequestMethod.POST)
	public void riskTestOver(String riskResult, HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";
		int flag = 0;
		try
		{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			if (accountInfo != null)
			{
				if(accountInfo.getIsRisk().equals(Constants.DEVIL_NUM_ZERO)){
					flag = 1;
					integralScoreService.perfectInformationIntegralReward(request);
				}
				accountInfo.setRiskResult(riskResult);
				accountInfo.setIsRisk(Constants.DEVIL_NUM_ONE);
				//设置投资风险金
				accountInfo.setRiskAmount(MoneyUtils.changeYToF(Constants.DEFAULTRISKAMOUNT));
				if (service.bindInfo(accountInfo))
				{
					if(flag == 1){
						
						result = "{\"result\":\"successOne\"}";
					}else{
						result = "{\"result\":\"success\"}";
					}
				}
			}
			else
			{
				result = "{\"result\":\"noLogin\"}";
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("记录风险能力测试结果异常", e);
		}
	}

	/**
	 * 去实名认证页面
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月11日 上午11:18:33
	 */
	@RequestMapping("/toCertification")
	public String toCertification(HttpServletRequest request)
	{
		return "/accountInfo/certification";
	}

	/**
	 * 实名认证
	 * 
	 * @Description:
	 * @param idCard
	 * @param realName
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月11日 下午1:38:31
	 */
	/*@RequestMapping("/certification")*/
	@ResponseBody
	@RequestMapping(value="/certification",method=RequestMethod.POST)
	public void certification(String idCard, String realName, String accountSex, HttpServletRequest request,
			HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";
		try
		{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			if (accountInfo != null)
			{
				//判断实名的身份证是否已绑定过
				if(service.countAccountInfoByIdCard(idCard)>0){
					result = "{\"result\":\"haveIdCard\"}";
				}else{
					accountInfo.setIdCard(idCard);
					accountInfo.setRealName(realName);
					accountInfo.setAccountSex(accountSex);
					if (service.certification(accountInfo))
					{
						result = "{\"result\":\"success\"}";
						integralScoreService.perfectInformationIntegralReward(request);
					}
				}
			}
			else
			{
				result = "{\"result\":\"noLogin\"}";
			}
			request.getSession().setAttribute("account", accountInfo);
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("实名认证异常", e);
		}
	}

	/**
	 * 去找回登录密码页面
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月15日 上午9:33:34
	 */
	@RequestMapping("/s/toGetBackLoginPassword")
	public String toGetBackLoginPassword(HttpServletRequest request, HttpServletResponse response)
	{

		return "/accountInfo/getBackLoginPassword";
	}

	/**
	 * 检查电话号码是否注册过，给该号码发送短信验证
	 * 
	 * @Description:
	 * @param telephone
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月15日 上午10:52:48
	 */
	/*@RequestMapping("/s/sendMobileCodeCheck")*/
	@ResponseBody
	@RequestMapping(value="/s/sendMobileCodeCheck",method=RequestMethod.POST)
	public void sendMobileCodeCheck(String telephone, HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";
		try
		{
			// 判断是否存在手机号注册
			if (service.checkTelephone(telephone))
			{
				
				String str = "";
				// 调用发送验证码功能，返回成功与否的结果
				if(messageCodeService.checkCount(telephone)){
					str = MobileMessageSend.sendMsg(telephone);
					messageCodeService.addMessage(telephone, "4");
				}else{
					str = "limit";
				}
				
				result = "{\"result\":\"" + str + "\"}";
			}
			else
			{
				result = "{\"result\":\"none\"}";
			}

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("手机验证码发送异常", e);
		}

	}

	/**
	 * 找回登录密码
	 * 
	 * @Description:
	 * @param password
	 * @param yzm
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月15日 上午10:16:09
	 */
	/*@RequestMapping("/s/reappearSetLoginPassword")*/
	@ResponseBody
	@RequestMapping(value="/s/reappearSetLoginPassword",method=RequestMethod.POST)
	public void reappearSetLoginPassword(String telephone, String password, String yzm, HttpServletRequest request,
			HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";

		try
		{
			String flag = MobileMessageCheck.checkMsg(telephone, yzm);
			// 短信验证码验证成功
			if ("success".equals(flag))
			{
				AccountInfo accountInfo = service.getAccountInfoByPhone(telephone);
				accountInfo.setPassword(password);
				// 修改密码
				if (service.getBackLoginPassword(accountInfo))
				{
					result = "{\"result\":\"success\"}";
				}
				else
				{
					result = "{\"result\":\"error\"}";
				}
			}
			else
			{
				result = "{\"result\":\"different\"}";
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("重置交易密码异常", e);
		}

	}

	/**
	 * 去绑定银行卡
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月26日 下午6:02:54
	 */
	@RequestMapping("/toBindBankCard")
	public String toBindBankCard(AccountBankcardBean bankcardBean, HttpServletRequest request,
			HttpServletResponse response)
	{
		// 跳转页面
		try
		{
			// 获得省份信息
			List<CityBean> provinceList = cityService.queryCityBySubCode("-1");
			request.setAttribute("provinceList", provinceList);
			AccountBankcardBean bankcard = (AccountBankcardBean) request.getSession().getAttribute("bankcard");
			if (bankcard != null)
			{
				bankcard.setBankCode(bankcardBean.getBankCode());
				bankcard.setBankPic(bankcardBean.getBankPic());
				bankcard.setBankName(bankcardBean.getBankName());
				if (bankcard.getProvince() != null)
				{
					List<CityBean> cityList = cityService.queryCityBySubCode(bankcard.getProvince());
					request.setAttribute("cityList", cityList);
				}
				request.setAttribute("bankcard", bankcard);
			}

		}
		catch (SQLException e)
		{
			logger.error("去绑定银行卡异常", e);
		}
		return "/accountInfo/bindBankCard";
	}

	/**
	 * 查看银行卡
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月26日 下午6:03:05
	 */
	@RequestMapping("/bankCard")
	public String bankCard(HttpServletRequest request, HttpServletResponse response)
	{
		// 跳转页面
		try
		{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			AccountBankcardBean accountBankcardBean = accountBankcardService.getAccountBankcardByAccountId(accountInfo
					.getAccountId());
			
			AccountInfo account = service.getLoginAccountInfo(request);
			request.setAttribute("accountInfo", account);
			
			if (accountBankcardBean != null)
			{
				String bankCard = accountBankcardBean.getBankCard().substring(0, 4);
				Integer length = accountBankcardBean.getBankCard().length() % 4 == 0 ? 4 : accountBankcardBean
						.getBankCard().length() % 4;
				for (int i = 3; i < accountBankcardBean.getBankCard().length(); i++)
				{
					if ((i + 1) % 4 == 0)
					{
						bankCard += " ";
					}
					if (i < accountBankcardBean.getBankCard().length() - length - 1)
					{
						bankCard += "*";
					}
				}
				bankCard += accountBankcardBean.getBankCard()
						.substring(accountBankcardBean.getBankCard().length() - length,
								accountBankcardBean.getBankCard().length());
				accountBankcardBean.setBankCard(bankCard);
				request.setAttribute("accountBankcardBean", accountBankcardBean);
			}
			else
			{
				//先判断是否实名
				if (account.getRealName() == null || "".equals(account.getRealName()))
				{
					// 未实名认证
					return "pay/certification";
				}
				else
				{
					// 未绑定银行卡
					return "/accountInfo/nobankCard";
				}
			}

		}
		catch (SQLException e)
		{
			logger.error("查看银行卡", e);
		}
		// 已有绑定的银行卡
		return "/accountInfo/bankCard";
	}

	/**
	 * 绑定银行卡
	 * 
	 * @Description:
	 * @param accountBankcardBean
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月28日 上午9:52:49
	 */
	/*@RequestMapping("/bindBankCard")*/
	@ResponseBody
	@RequestMapping(value="/bindBankCard",method=RequestMethod.POST)
	public void bindBankCard(AccountBankcardBean accountBankcardBean, HttpServletRequest request,
			HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";

		try
		{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			AccountBankcardBean bankcardBean = accountBankcardService.getAccountBankcardByAccountId(accountInfo
					.getAccountId());
			accountBankcardBean.setAccountId(accountInfo.getAccountId());
			if (bankcardBean != null)
			{

				accountBankcardService.updateAccountBankcard(accountBankcardBean);
				result = "{\"result\":\"success\"}";
			}
			else
			{
				accountBankcardService.addAccountBankcard(accountBankcardBean);
				result = "{\"result\":\"score\"}";
				integralScoreService.perfectInformationIntegralReward(request);
				
				
				//判断时候开户，没开户去开户
				if("pass".equals(fuiouService.checkRealNameAndBankCard(accountInfo.getAccountId()).get("result"))){
					fuiouService.reg(accountInfo.getAccountId());
				}
				//实名认证后该用户为新用户(身份证为第一次注册),其邀请人获得5元现金奖励
				//判断用户是否为新用户
				/*if(service.checkIdCard(accountInfo) == 1){
					//发放5元现金奖励
					if(!StringTools.isNullOrEmpty(accountInfo.getRecommendTelephone())){
						AccountInfo account = service.getAccountInfoByPhone(accountInfo.getRecommendTelephone());						
						service.sendRecommendReward(account,0,"500");
					}					
				}*/
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("绑定银行卡异常", e);
		}

	}

	/**
	 * 根据省，获得市
	 * 
	 * @Description:
	 * @param province
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月28日 上午9:53:06
	 */
	/*@RequestMapping("/getCity")*/
	@ResponseBody
	@RequestMapping(value={"/getCity","/s/getCity"},method=RequestMethod.POST) 
	public void getCity(String province, HttpServletRequest request, HttpServletResponse response)
	{

		try
		{
			List<CityBean> cityBean = cityService.queryCityBySubCode(province);
			request.setAttribute("provinceList", cityBean);

			response.setContentType("application/json");
			PrintWriter write = response.getWriter();
			String jsonarr = JsonUtil.listToJson(cityBean);
			write.print(jsonarr);
			write.flush();
			write.close();
		}
		catch (Exception e)
		{
			logger.error("根据省，获得市异常", e);
		}

	}

	/**
	 * 去选择银行页面
	 * 
	 * @Description:
	 * @param accountBankcardBean
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月1日 下午3:44:15
	 */
	@RequestMapping("/chooseBank")
	public String chooseBank(AccountBankcardBean accountBankcardBean, HttpServletRequest request,
			HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		session.setAttribute("bankcard", accountBankcardBean);
		try
		{
			List<AccountBankcardBean> list = accountBankcardService.getAllBankInfo();
			request.setAttribute("bankCardList", list);
		}
		catch (Exception e)
		{
			logger.error("去选择银行页面异常", e);
		}
		return "/accountInfo/chooseBank";
	}

	/**
	 * 去更多信息
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午5:20:17
	 */
	@RequestMapping("/moreInfo")
	public String moreInfo(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			AccountInfo accountInfo = service.getLoginAccountInfo(request);
			request.setAttribute("accountInfo", accountInfo);
		}
		catch (SQLException e)
		{
			logger.error("去更多信息异常", e);
		}
		return "/accountInfo/moreInfo";
	}

	/**
	 * 去密码管理
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午5:20:41
	 */
	@RequestMapping("/pwdManager")
	public String pwdManager(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			AccountInfo accountInfo = service.getLoginAccountInfo(request);
			request.setAttribute("accountInfo", accountInfo);
		}
		catch (SQLException e)
		{
			logger.error("去密码管理异常", e);
		}
		return "/accountInfo/pwdManager";
	}

	/**
	 * 去绑定QQ页面
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午5:20:49
	 */
	@RequestMapping("/toBindQQ")
	public String toBindQQ(HttpServletRequest request, HttpServletResponse response)
	{
		AccountInfo accountInfo;
		try
		{
			accountInfo = service.getLoginAccountInfo(request);
			request.setAttribute("accountInfo", accountInfo);
		}
		catch (SQLException e)
		{
			logger.error("去绑定QQ页面异常", e);
		}
		return "/accountInfo/bindQQ";
	}

	/**
	 * 绑定QQ
	 * 
	 * @Description:
	 * @param accountQQ
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午5:21:01
	 */
	/*@RequestMapping("/bindQQ")*/
	@ResponseBody
	@RequestMapping(value="/bindQQ",method=RequestMethod.POST)
	public void bindQQ(String accountQQ, HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";

		try
		{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			accountInfo = service.getLoginAccountInfo(request);
			if (accountInfo.getAccountQQ() != null && !"".equals(accountInfo.getAccountQQ()))
			{
				accountInfo.setAccountQQ(accountQQ);
				result = service.bindInfo(accountInfo) ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
			}
			else
			{
				accountInfo.setAccountQQ(accountQQ);
				result = service.bindInfo(accountInfo) ? "{\"result\":\"score\"}" : "{\"result\":\"error\"}";
				integralScoreService.perfectInformationIntegralReward(request);
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("绑定QQ", e);
		}

	}

	/**
	 * 去绑定微博
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午5:21:09
	 */
	@RequestMapping("/toBindWB")
	public String toBindWB(HttpServletRequest request, HttpServletResponse response)
	{
		AccountInfo accountInfo;
		try
		{
			accountInfo = service.getLoginAccountInfo(request);
			request.setAttribute("accountInfo", accountInfo);
		}
		catch (SQLException e)
		{
			logger.error("去绑定微博", e);
		}
		return "/accountInfo/bindWB";
	}

	/**
	 * 绑定微博
	 * 
	 * @Description:
	 * @param accountWB
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午5:21:19
	 */
	/*@RequestMapping("/bindWB")*/
	@ResponseBody
	@RequestMapping(value="/bindWB",method=RequestMethod.POST)
	public void bindWB(String accountWB, HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";

		try
		{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			accountInfo = service.getLoginAccountInfo(request);
			if (accountInfo.getAccountWB() != null && !"".equals(accountInfo.getAccountWB()))
			{
				accountInfo.setAccountWB(accountWB);
				result = service.bindInfo(accountInfo) ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
			}
			else
			{
				accountInfo.setAccountWB(accountWB);
				result = service.bindInfo(accountInfo) ? "{\"result\":\"score\"}" : "{\"result\":\"error\"}";
				integralScoreService.perfectInformationIntegralReward(request);
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("绑定微博异常", e);
		}

	}

	/**
	 * 去绑定微信
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午5:21:38
	 */
	@RequestMapping("/toBindWX")
	public String toBindWX(HttpServletRequest request, HttpServletResponse response)
	{
		AccountInfo accountInfo;
		try
		{
			accountInfo = service.getLoginAccountInfo(request);
			request.setAttribute("accountInfo", accountInfo);
		}
		catch (SQLException e)
		{
			logger.error("去绑定微信", e);
		}
		return "/accountInfo/bindWX";
	}

	/**
	 * 绑定微信
	 * 
	 * @Description:
	 * @param accountWX
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午5:22:34
	 */
	/*@RequestMapping("/bindWX")*/
	@ResponseBody
	@RequestMapping(value="/bindWX",method=RequestMethod.POST)
	public void bindWX(String accountWX, HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";

		try
		{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			accountInfo = service.getLoginAccountInfo(request);
			if (accountInfo.getAccountWX() != null && !"".equals(accountInfo.getAccountWX()))
			{
				accountInfo.setAccountWX(accountWX);
				result = service.bindInfo(accountInfo) ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
			}
			else
			{
				accountInfo.setAccountWX(accountWX);
				result = service.bindInfo(accountInfo) ? "{\"result\":\"score\"}" : "{\"result\":\"error\"}";
				integralScoreService.perfectInformationIntegralReward(request);
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("绑定微信异常", e);
		}

	}

	/**
	 * 去绑定其他联系方式
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月6日 下午5:21:47
	 */
	@RequestMapping("/toBindContact")
	public String toBindContact(HttpServletRequest request, HttpServletResponse response)
	{
		AccountInfo accountInfo;
		try
		{
			accountInfo = service.getLoginAccountInfo(request);
			request.setAttribute("accountInfo", accountInfo);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		return "/accountInfo/bindContact";
	}

	/**
	 * 绑定其他联系人信息
	 * 
	 * @Description:
	 * @param accountContactType
	 * @param accountContactName
	 * @param accountContactPhone
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月10日 下午2:30:44
	 */
	/*@RequestMapping("/bindContact")*/
	@ResponseBody
	@RequestMapping(value="/bindContact",method=RequestMethod.POST)
	public void bindContact(String accountContactType, String accountContactName, String accountContactPhone,
			HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";

		try
		{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			accountInfo = service.getLoginAccountInfo(request);
			// 3个参数都必填,所以判断其中一个原参数不为空 就表示其其他原参数不为空
			// 为空则无需奖励积分
			if (accountInfo.getAccountContactPhone() != null && !"".equals(accountInfo.getAccountContactPhone()))
			{
				accountInfo.setAccountContactType(accountContactType);
				accountInfo.setAccountContactName(accountContactName);
				accountInfo.setAccountContactPhone(accountContactPhone);
				result = service.bindInfo(accountInfo) ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
			}
			else
			{
				accountInfo.setAccountContactType(accountContactType);
				accountInfo.setAccountContactName(accountContactName);
				accountInfo.setAccountContactPhone(accountContactPhone);
				result = service.bindInfo(accountInfo) ? "{\"result\":\"score\"}" : "{\"result\":\"error\"}";
				integralScoreService.perfectInformationIntegralReward(request);
			}
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("绑定其他联系方式异常", e);
		}

	}
	
	@ResponseBody
	@RequestMapping(value="/checkGold",method=RequestMethod.POST)
	public Map<String, String> checkGold(HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		Map<String, String> map = new HashMap<String, String>();

		
		AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("account");
		try
		{
			//判断时候开户，没开户去开户  result
			map = fuiouService.checkRealNameAndBankCard(accountInfo.getAccountId());
			
			if("pass".equals(map.get("result"))){
				map = fuiouService.reg(accountInfo.getAccountId());
			}
		}
		catch (Exception e)
		{
			logger.error("绑定其他联系方式异常", e);
		}
		return map;

	}
	

}
