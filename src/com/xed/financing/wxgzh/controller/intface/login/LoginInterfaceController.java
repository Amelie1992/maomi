/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.login.LoginInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:penggang
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月18日    penggang  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import com.xed.financing.wxgzh.controller.loginRegister.LoginRegisterController;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.category.CategoryBean;
import com.xed.financing.wxgzh.model.savings.SavingsBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.category.CategoryService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.loginRegister.LoginRegisterService;
import com.xed.financing.wxgzh.service.messagecode.MessageCodeService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.savings.SavingsService;
import com.xed.financing.wxgzh.util.AuthUtil;
import com.xed.financing.wxgzh.util.IosAuthUtil;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.MobileMessageCheck;
import com.xed.financing.wxgzh.util.MobileMessageSend;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.RandomValidateCode;
import com.xed.financing.wxgzh.util.SignUtil;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.intface.login.LoginInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月18日 上午10:56:32
 * @author:QT
 */
@Controller
@RequestMapping("/ios/login")
public class LoginInterfaceController
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

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(LoginRegisterController.class);

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
	@RequestMapping(value = "/login")
	public JSONObject login(String password, String accountName)
	{
		JSONObject obj = new JSONObject();
		String msg="密码错误";
		int code=300;
		// 创建标识
		
		// 创建账户对象 赋值
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountName(accountName);
		accountInfo.setPassword(password);
		accountInfo.setTelephone(accountName);
		// 判断验证码是否正确

		try
		{
			if(!service.checkTelephoneOnly(accountName)){
				if (service.checkLogin(accountInfo))
				{
					// 登录成功 设置标记
					// 将登录成功的用户AccountId信息放到session
					AccountInfo info = accountInfoService.getAccountInfo(accountInfo.getAccountId());
					info.setAccountId(accountInfo.getAccountId());
					obj.put("account", JsonUtil.beanToJson(info));
					msg="校验成功";
					code=200;
				}
				if(service.checkLoginIsFrozen(accountInfo)){
					msg="账号被冻结";
					code=301;
				}
			}
			else
			{
				msg="账号未注册";
				code=302;
			}
			
		}
		catch (Exception e)
		{
			logger.error("登录异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
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
//	@RequestMapping("/s/toRegister")
//	public String toRegister(@RequestParam(value = "telephone", required = false, defaultValue = "defaultValue") String telephone, HttpServletRequest request, String recommend)
//	{
//		AccountInfo accountInfo;
//		
//		try
//		{
//			if (recommend != null && !recommend.equals(""))
//			{
//				accountInfo = accountInfoService.getAccountInfo(recommend);
//				request.setAttribute("recommendTelephone", accountInfo.getTelephone());
//			}
//		}
//		catch (SQLException e)
//		{
//			e.printStackTrace();
//		}
//		if(!telephone.equals("defaultValue")){
//			request.setAttribute("telephone", telephone);
//		}
//		
//		return "/loginregister/register";
//	}

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
	@RequestMapping("/checkPhone")
	public JSONObject checkTelephoneOnly(String telephone)
	{
		JSONObject obj = new JSONObject();
		String msg="手机号已注册";
		int code=300;
		try
		{
			if (service.checkTelephoneOnly(telephone))
			{
				code=200;
				msg="手机号可以注册";
			}
		}
		catch (SQLException e)
		{
			logger.error("检查手机号是否唯一异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
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
	@RequestMapping("/register")
	public JSONObject register(String telephone, String yzm, String recommendTelephone, String password, String recommendCode,String unionid)
	{
		JSONObject obj = new JSONObject();
		String msg="注册失败";
		int code=300;
		try
		{
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setTelephone(telephone);
			accountInfo.setYzm(yzm);
			accountInfo.setRecommendTelephone(recommendTelephone);
			/* accountInfo.setDealPassword(dealPassword); */
			accountInfo.setPassword(password);
			accountInfo.setUnionid(unionid);
			// 判断手机验证码 创建标识
			String message = MobileMessageCheck.checkMsg(telephone,yzm);

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
						
						
						//邀请码送8.8元现金
						if(!StringTools.isNullOrEmpty(recommendCode)){
							//accountInfoService.sendRecommendReward(info,3,"200");
							couponService.registeredCashCoupon(accountInfo);
							
						}
						
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
						obj.put("account", info);
						code=200;
						msg="注册成功";
					}
					else
					{
						// 出错
						code=301;
						msg="推荐码填写错误";
								
					}
				}
				else
				{
					// 已注册
					code=302;
					msg="账号已注册";
				}

			}
			else
			{
				// 验证码错误
				code=303;
				msg="短信验证码错误";
			}
			
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
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
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
	@RequestMapping("/sendMobileCode")
	public JSONObject sendMobileCode(String telephone)
	{
		JSONObject obj = new JSONObject();
		String msg="发送失败";
		int code=300;
		try
		{
			String str = "";
			// 调用发送验证码功能，返回成功与否的结果
			if(messageCodeService.checkCount(telephone)){
				str = MobileMessageSend.sendMsg(telephone);
				if("success".equals(str))
				{
					messageCodeService.addMessage(telephone, "1");
					code=200;
					msg="发送成功";
				}
			}else{
				code=301;
				msg="当日短信已达上限";
			}
		}
		catch (Exception e)
		{
			logger.error("手机验证码发送异常", e);
		}
		obj.put("msg", msg);
		obj.put("code",code);
		return obj;
	}

	/**
	 * 邀请好友
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/login/invitingfriends?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月1日 下午3:14:25
	 */
	@ResponseBody
	@RequestMapping("/invitingfriends")
	public JSONObject invitingFriends(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		AccountInfo accountInfo;
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			JSONObject objs = new JSONObject();
			//已邀请好友人数
			objs.put("friendsCount", service.queryFriendsCount(accountInfo));
			//获得的好友奖励次数
			objs.put("friendsCoupon", service.queryFriendsCoupon(accountInfo));
			//已获得加息券
			objs.put("friendsPercent", service.queryFriendsPercent(accountInfo));
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
			//好友累计投资
			objs.put("friendsInvest", invest);
			//已获得现金奖励
			objs.put("friendsMoney", money);

//			request.setAttribute("qrCode", paramService.getParamVal("MAKE_PROJECT_URL")
//					+ "loginregister/s/toRegister?recommend=" + accountInfo.getAccountId());
			obj.put("data", objs);
			msg = "";
			code = "200";
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		obj.put("msg", msg);
		obj.put("code",code);
		return obj;

	}
	
	/**
	 * 查看邀请的好友
	 * @Description:ios/login/checkFriends?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年7月10日 下午3:33:39
	 */
	@ResponseBody
	@RequestMapping("/checkFriends")
	public Map<String, Object> checkFriends(String accountId)
	{
		Map<String, Object> obj = new HashMap<>();
		Map<String, Object> objs = new HashMap<>();
		String msg = "系统异常";
		String code = "500";
		AccountInfo accountInfo = null;
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			objs.put("friends", service.checkFriends(accountInfo));
			msg = "";
			code = "200";
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally {
			obj.put("msg", msg);
			obj.put("code", code);
			obj.put("data", objs);
		}
		return obj;
	}
	
	
	/**
	 * IOS微信登录
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午6:18:14
	 */
	@ResponseBody
	@RequestMapping("/wxCallBack")
	public Map<String, Object> wxCallBack(HttpServletRequest request){
		Map<String, Object> obj = new HashMap<>();
		Map<String, Object> objs = new HashMap<>();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		
		JSONObject jsonObject = null;
		try
		{
			jsonObject = IosAuthUtil.getUnionid(request);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//判断jsonObject中是否有unionid属性
		String unionid = null;
		if(jsonObject.has("unionid")){
			unionid = jsonObject.getString("unionid");
			try
			{
				AccountInfo accountInfo = accountInfoService.getAccountInfoByUnionid(unionid);
				if (accountInfo == null)
				{
					msg = "用户暂未绑定unionid";
					code = "300";
				} else {
					msg = "";
					code = "200";				
				}
				objs.put("unionid", unionid);
				objs.put("accountInfo", accountInfo);
				obj.put("data", objs);
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		obj.put("msg", msg);
		obj.put("code",code);
		return obj;
	}
	
	/**
	 * IOS绑定unionid
	 * @Description:
	 * @param unionid
	 * @param telephone
	 * @param yzm
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午6:18:40
	 */
	@ResponseBody
	@RequestMapping("/bindUnionid")
	public Map<String, Object> bindUnionid(String unionid,String telephone,String yzm){
		Map<String, Object> obj = new HashMap<>();
		Map<String, Object> objs = new HashMap<>();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		
		String isVerified = "";
		try
		{
			isVerified = MobileMessageCheck.checkMsg(telephone,yzm);
		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}
		if ("success".equals(isVerified))
		{
			try
			{
				AccountInfo accountInfo = accountInfoService.getAccountInfoByPhone(telephone);
				if (accountInfo == null)
				{
					msg = "尚未注册";
					code = "300";
				} else {
					accountInfo.setUnionid(unionid);
					accountInfoService.bindInfo(accountInfo);
					msg = "";
					code = "200";
				}
				objs.put("unionid", unionid);
				objs.put("accountInfo", accountInfo);
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		} else {
			msg = "验证码错误";
			code = "400";
		}
		obj.put("data", objs);
		obj.put("msg", msg);
		obj.put("code",code);
		return obj;
	}
}
