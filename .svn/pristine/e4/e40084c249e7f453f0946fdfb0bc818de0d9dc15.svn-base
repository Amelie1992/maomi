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
package com.xed.financing.wxgzh.controller.loginRegister;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.category.CategoryBean;
import com.xed.financing.wxgzh.model.savings.SavingsBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.category.CategoryService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.fuiou.FuiouService;
import com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService;
import com.xed.financing.wxgzh.service.messagecode.MessageCodeService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.savings.SavingsService;
import com.xed.financing.wxgzh.util.AuthUtil;
import com.xed.financing.wxgzh.util.MobileMessageCheck;
import com.xed.financing.wxgzh.util.MobileMessageSend;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.RandomValidateCode;
import com.xed.financing.wxgzh.util.SignUtil;
import com.xed.financing.wxgzh.util.StringTools;

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
@RequestMapping("/loginregister")
public class LoginRegisterController
{
	@Autowired
	private LoginRegisterService service;

	@Autowired
	private CapitalService capitalService;

	@Autowired
	private CouponService couponService;

	@Autowired
	private AccountInfoService accountInfoService;

	@Autowired
	private ParamService paramService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SavingsService savingsService;
	
	@Autowired
	private MessageCodeService messageCodeService;
	
	@Autowired
	private FuiouService fuiouService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(LoginRegisterController.class);

	/**
	 * 跳转登录页面
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月15日 下午3:11:48
	 */
	@RequestMapping("/s/toLogin")
	public String toLogin(HttpServletRequest request)
	{
		// 跳转页面
		return "/loginregister/login";
	}

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
	@RequestMapping(value = "/s/login", method = {RequestMethod.POST})
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
				//判断时候开户，没开户去开户
				if("pass".equals(fuiouService.checkRealNameAndBankCard(accountInfo.getAccountId()).get("result"))){
					fuiouService.reg(accountInfo.getAccountId());
				}
				
			}
			if(service.checkLoginIsFrozen(accountInfo)){
				result = "{\"result\":\"frozen\"}";
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
	public void register(String telephone, String yzm, String recommendTelephone, String dealPassword, String password,
			String accountWX, String recommendCode, HttpServletRequest request, HttpServletResponse response,String code)
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
			accountInfo.setRecommendTelephone(recommendTelephone);
			/* accountInfo.setDealPassword(dealPassword); */
			accountInfo.setPassword(password);
			
			
			if("true".equals(accountWX)){
				String openid = (String)session.getAttribute("openid");
				String unionid = (String)session.getAttribute("unionid");
				if(service.checkAccountWXOnly(openid)){
					accountInfo.setAccountWX(openid);
					accountInfo.setUnionid(unionid);
				}
			}
			
			if ("".equals(code) || code== null || !((String) session.getAttribute(RandomValidateCode.RANDOMCODEKEY)).toLowerCase().equals(
					code.toLowerCase()))			
			{
				// 图形验证码，验证失败
				result = "{\"result\":\"code\"}";
			}else{
				// 判断手机验证码 创建标识
				String message = MobileMessageCheck.checkMsg(accountInfo.getTelephone(), accountInfo.getYzm());

				// 如果验证码正确，添加账户信息
				if ("success".equals(message))
				{
					if (service.checkTelephoneOnly(telephone))
					{
						boolean inviteCode = false;
						List<CategoryBean> categoryBeanlist = categoryService.queryInviteCodeList();
						for(CategoryBean c : categoryBeanlist){
							if(c.getCategoryName().equals(recommendCode)){						
								inviteCode = true;
								break;
							}
						}
						if (!inviteCode){
							result = "{\"result\":\"errorCode\"}";
						}
						//添加邀请码记录
						if (StringTools.isNullOrEmpty(recommendCode)){
							inviteCode = true;
						}
						if(inviteCode){
							accountInfo.setRecommendCode(recommendCode);
						}
						
						if (inviteCode && service.addAccountInfo(accountInfo))
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

							// 新用户注册送体验金3000 --------- (活动)
							// couponService.activityExperienceGold(accountInfo);			
							
							AccountInfo info = accountInfoService.getAccountInfo(accountInfo.getAccountId());
							info.setAccountId(accountInfo.getAccountId());
							session.setAttribute("account", info);
							
							//邀请码送8.8元现金
							/*if(!StringTools.isNullOrEmpty(recommendCode)){
								//accountInfoService.sendRecommendReward(info,3,"200");
								couponService.registeredCashCoupon(accountInfo);
								
							}*/
							
							//注册送0.5元猫咪储蓄金额
							savingsService.addSavingsRecord(accountInfo.getAccountId(), "50", "1", 1);
							//查询用户是否有好友赠送的储蓄红包
							if(savingsService.findGivedRedp(accountInfo.getAccountId())){
								List<SavingsBean> list = savingsService.findGivedRedpList(accountInfo.getAccountId());
								for(Iterator iterator = list.iterator();iterator.hasNext();){                    
									SavingsBean savingsBean = (SavingsBean) iterator.next();                   
									savingsService.addSavingsRecord(accountInfo.getAccountId(), savingsBean.getSavingsMoney(), "2", 1);
									
									savingsBean.setGiveAccountId(accountInfo.getAccountId());
									savingsService.updateGiveAccountIdno(savingsBean);
								}
							}
							
							
							result = "{\"result\":\"success\"}";
						}
						else if(inviteCode)
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
			}
			
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
			/*
			 * if (service.addAccountInfo(accountInfo)) {
			 * request.setAttribute("result", "success"); } else {
			 * request.setAttribute("result", "error"); }
			 */
			// 创建后的账户信息将主键ID映射在Bean里
			// System.out.println(accountInfo.getAccountId());
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
	public void sendMobileCode(String telephone, HttpServletRequest request, HttpServletResponse response,String code)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";
		HttpSession session = request.getSession();
		try
		{
			String str = "";
			if ( "".equals(code) || code== null || !((String) session.getAttribute(RandomValidateCode.RANDOMCODEKEY)).toLowerCase().equals(
					code.toLowerCase()))			
			{
				// 图形验证码，验证失败
				str = "code";
			}else{
				// 调用发送验证码功能，返回成功与否的结果
				if(messageCodeService.checkCount(telephone)){
					str = MobileMessageSend.sendMsg(telephone);
					messageCodeService.addMessage(telephone, "1");
				}else{
					str = "limit";
				}
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

	/**
	 * 跳转客服页面
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月19日 上午10:06:22
	 */
	@RequestMapping("/s/goCustomer")
	public String goCustomer(HttpServletRequest request)
	{
		return "../../kefu";
	}

	/**
	 * 登出
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月7日 下午7:23:39
	 */
	@RequestMapping("/outLogin")
	public String outLogin(HttpServletRequest request)
	{
		Object sessionObj = request.getSession().getAttribute("account");
		Object sessionLastPath = request.getSession().getAttribute("lastPath");
		Object sessionheadimgurl = request.getSession().getAttribute("headimgurl");
		
		if (null != sessionObj)
		{
			request.getSession().removeAttribute("account");
		}
		if(null != sessionLastPath){
			request.getSession().removeAttribute("lastPath");
		}
		if(null != sessionheadimgurl){
			request.getSession().removeAttribute("headimgurl");
		}
		
		return "/loginregister/login";
	}

	/**
	 * 邀请好友
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月15日 下午3:18:36
	 */
	@RequestMapping("/invitingfriends")
	public String invitingFriends(HttpServletRequest request)
	{
		AccountInfo accountInfo;
		try
		{
			accountInfo = accountInfoService.getLoginAccountInfo(request);

			request.setAttribute("friendsCount", service.queryFriendsCount(accountInfo));
			
			request.setAttribute("friendsCoupon", service.queryFriendsCoupon(accountInfo));
			request.setAttribute("friendsPercent", service.queryFriendsPercent(accountInfo));

			// 计算投资额 转换万,亿
			String invest = service.queryFriendsInvest(accountInfo);
			String money = service.queryFriendsMoney(accountInfo);
			if (invest.length() >= 10 && invest.length() < 14)
			{
				invest = MoneyUtils.formatFloatNumber(Double.parseDouble(invest) / 10000) + "万";
			}
			else if (invest.length() >= 14)
			{
				invest = MoneyUtils.formatFloatNumber(Double.parseDouble(invest) / 100000000) + "亿";
			}
			if (money.length() >= 10 && money.length() < 14)
			{
				money = MoneyUtils.formatFloatNumber(Double.parseDouble(money) / 10000) + "万";
			}
			else if (money.length() >= 14)
			{
				money = MoneyUtils.formatFloatNumber(Double.parseDouble(money) / 100000000) + "亿";
			}
			request.setAttribute("friendsInvest", invest);
			request.setAttribute("friendsMoney", money);

			request.setAttribute("qrCode", paramService.getParamVal("MAKE_PROJECT_URL")
					+ "loginregister/s/toRegister?recommend=" + accountInfo.getAccountId());
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "loginregister/invitingfriends";

	}

	/**
	 * 查看邀请的好友
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月29日 上午10:42:09
	 */
	@RequestMapping("/checkFriends")
	public String checkFriends(HttpServletRequest request)
	{
		AccountInfo accountInfo;
		try
		{
			accountInfo = accountInfoService.getLoginAccountInfo(request);

			request.setAttribute("friends", service.checkFriends(accountInfo));
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "loginregister/checkFriends";

	}
	
	
	
	/**
	 * 微信登录授权获取code
	 * 
	 * @Description:
	 * @param req
	 * @param resp
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年9月26日 上午9:21:14
	 */
	@RequestMapping(value = "/s/wxLogin/{type}")
	public void wxLogin(@PathVariable String type, HttpServletRequest req, HttpServletResponse resp)
	{	
		String path = paramService.getParamVal("WX_LOGIN_PATH");
		
		AuthUtil.getCode(path, type, resp);
	}

	/**
	 * 微信回调获取数据
	 * 
	 * @Description:
	 * @param req
	 * @param resp
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年9月26日 上午9:35:48
	 */
	@RequestMapping(value = "/s/wxCallBack/{type}")
	public String wxCallBack(@PathVariable String type, HttpServletRequest req, HttpServletResponse resp)
	{
		JSONObject jsonObject = AuthUtil.getUnionid(req);
		String openid = jsonObject.getString("openid");
		String unionid = jsonObject.getString("unionid");

		String headimgurl = jsonObject.getString("headimgurl");
		
		//将openid存入session中
		HttpSession session = req.getSession();
		session.setAttribute("openid", openid);
		session.setAttribute("unionid", unionid);
		
		if(!StringTools.isNullOrEmpty(headimgurl))
			session.setAttribute("headimgurl", headimgurl);
		
		
		String path = paramService.getParamVal("WX_LOGIN_PATH");
		//判断点击微信登录的途径
		if("wx".equals(type)){
			return "redirect:" + path + "loginregister/s/wxLoginController/" + type;
		}else if("register".equals(type)){
			return "redirect:" + path + "loginregister/s/toRegister";
		}else if("band".equals(type)){
			return "redirect:" + path + "loginregister/s/wxLoginController/" + type;
		}
		
		return "redirect:" + path + "loginregister/s/toRegister";
	}

	/**
	 * 微信登陆后续处理
	 * @Description:
	 * @param accountWX
	 * @return 逻辑视图名
	 * @version:v1.0
	 * @author:Peng Gang
	 * @throws Exception 
	 * @date:2017年10月20日 上午9:51:45
	 */
	@RequestMapping("/s/wxLoginController/{type}")
	public String wxLoginController(@PathVariable String type, HttpServletRequest req, HttpServletResponse resp) throws Exception
	{
		HttpSession session = req.getSession();
		String accountWX = (String)session.getAttribute("openid");
		String unionid = (String)session.getAttribute("unionid");
		String path = paramService.getParamVal("WX_LOGIN_PATH");
		
		if("band".equals(type)){
			AccountInfo account = (AccountInfo)session.getAttribute("account");
			String telephone = account.getTelephone();
			account.setAccountWX(accountWX);
			account.setUnionid(unionid);
			try
			{
				int count = accountInfoService.updateAccountInfoAccountWXByPhone(telephone, account);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			return "redirect:" + path + "accountinfo/moreInfo";
		}else if("wx".equals(type)){

			// 根据用户微信获得用户信息
			AccountInfo accountInfo = null;
			try
			{
				accountInfo = accountInfoService.getAccountInfoByAccountWX(accountWX);
				if(service.checkLoginIsFrozen(accountInfo)){
					resp.setContentType("text/html; charset=utf-8");
					PrintWriter writer = resp.getWriter();
					writer.write("<script>alert('您的账户已被冻结，详情请咨询客服');window.location.href='https://www.maomibank.com/xed_financing_wxgzh/';</script>");
					writer.close();
					writer.flush();
					return "/loginregister/register";
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 判断用户是否存在
			// 不存在 > 跳转绑定手机界面
			if (accountInfo != null)
			{
				if(StringTools.isNullOrEmpty(accountInfo.getUnionid())){
					
					accountInfo.setUnionid(unionid);
					try
					{
						accountInfoService.updateAccountInfoAccountWXByPhone(accountInfo.getTelephone(), accountInfo);
					}
					catch (SQLException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				session.setAttribute("account", accountInfo);
				
				//判断时候开户，没开户去开户
				if("pass".equals(fuiouService.checkRealNameAndBankCard(accountInfo.getAccountId()).get("result"))){
					fuiouService.reg(accountInfo.getAccountId());
				}
				
				return "redirect:" + path + "capital/querycapital";
			}
			else
			{
				// 跳转绑定手机页面 --》输入手机号	
				return "loginregister/validatephone";
			}
		}
		
		return "redirect:" + path + "loginregister/s/toRegister";
	}

	/**
	 * 
	 * @Description:
	 * @param telephone
	 * @param req
	 * @param resp
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月20日 下午2:05:35
	 */
	@RequestMapping("/s/nextCheck")
	public void nextCheck(String telephone,String yzm, HttpServletRequest req, HttpServletResponse resp){
		String result = "{\"result\":\"error\"}";
		AccountInfo accountInfo = null;
		try
		{
			accountInfo = accountInfoService.getAccountInfoByPhone(telephone);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = req.getSession();
		//当前用户openid
		String openid = (String)session.getAttribute("openid");
		String unionid = (String)session.getAttribute("unionid");
		
		if(StringTools.isNullOrEmpty(accountInfo)){
			//新用户 --跳转注册页面
			result = "{\"result\":\"new\"}";
		}else{
			//老用户
			//查询出的用户accountWX
			String accountWX = accountInfo.getAccountWX();
			
			//关键：比较当前的用户id和用户输入telephone获得的operid对比
			if(StringTools.isNullOrEmpty(accountWX)){
				//输入的手机号没有绑定微信
				String message = null;
				try
				{
					//发送短信验证
					message = MobileMessageCheck.checkMsg(telephone, yzm);
					if("success".equals(message)){
						session.setAttribute("account", accountInfo);
						result = "{\"result\":\"success\"}";
					}else{
						result = "{\"result\":\"yzm\"}";
					}
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(!StringTools.isNullOrEmpty(accountWX) && !openid.equals(accountWX)){
				//输入的手机号有绑定微信 且和当前的openid不一致
				//代表输入了别人已经绑定微信的手机号
				result = "{\"result\":\"repeat\"}";
			}
			else{
				result = "{\"result\":\"error\"}";
			}
		}
		try
		{
			if(result.equals("{\"result\":\"success\"}")){
				AccountInfo account = new AccountInfo();
				account.setAccountWX(openid);
				account.setUnionid(unionid);
				int count = accountInfoService.updateAccountInfoAccountWXByPhone(telephone, account);
			}
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.write(result);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 公众号基本配置：url和token的验证
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月19日 下午5:15:17
	 */
	@RequestMapping("/s/coreServlet")
	public void CoreServlet(HttpServletRequest request, HttpServletResponse response)
	{
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce))
		{
			out.print(echostr);
		}
		out.close();
		out = null;
	}
	
}
