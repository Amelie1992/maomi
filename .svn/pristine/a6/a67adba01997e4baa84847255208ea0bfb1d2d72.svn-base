/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.accountInfo.AccountInfoInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:duanjy
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月17日    duanjy  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.accountInfo;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xed.financing.wxgzh.controller.accountInfo.AccountInfoController;
import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.city.CityBean;
import com.xed.financing.wxgzh.model.emailcheck.EmailCheck;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountbankcard.AccountBankcardService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.city.CityService;
import com.xed.financing.wxgzh.service.emailcheck.EmailCheckService;
import com.xed.financing.wxgzh.service.fuiou.FuiouService;
import com.xed.financing.wxgzh.service.integralscore.IntegralScoreService;
import com.xed.financing.wxgzh.service.messagecode.MessageCodeService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.EmailUtil;
import com.xed.financing.wxgzh.util.GetUUID;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.LevelParam;
import com.xed.financing.wxgzh.util.MobileMessageCheck;
import com.xed.financing.wxgzh.util.MobileMessageSend;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 个人设置
 * @className:com.xed.financing.wxgzh.controller.intface.accountInfo.AccountInfoInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月17日 下午3:39:35
 * @author:duanjy
 */
@Controller
@RequestMapping("/ios/accountInfo")
public class AccountInfoInterfaceController
{
	@Autowired
	private AccountInfoService accountInfoService;

	@Autowired
	private CityService cityService;

	@Autowired
	private AccountBankcardService accountBankcardService;

	@Autowired
	private IntegralScoreService integralScoreService;

	@Autowired
	private MessageCodeService messageCodeService;

	@Autowired
	private CapitalService capitalService;

	@Autowired
	private EmailCheckService emailCheckService;

	@Autowired
	private ParamService paramService;
	
	@Autowired
	private FuiouService fuiouService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AccountInfoController.class);

	/**
	 * 前往个人设置
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/personalSettings?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月20日 上午8:59:51
	 */
	@ResponseBody
	@RequestMapping("/personalSettings")
	public JSONObject personalSettings(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		// 跳转页面
		try
		{
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			Integer bankCount = accountBankcardService.getBankcardCount(accountInfo.getAccountId());
			Integer riskResult = 0;
			String type = "";
			if (accountInfo.getRiskResult() != null)
			{
				riskResult = Integer.valueOf(accountInfo.getRiskResult());
			}
			if (riskResult > 0 && riskResult<=20)
			{
				type = "保守型投资人";
			} else if (riskResult > 20 && riskResult<=40) {
				type = "稳健偏保守型投资人";
			} else if (riskResult > 40 && riskResult<=60) {
				type = "稳健型投资人";
			} else if (riskResult > 60 && riskResult<=80) {
				type = "稳健偏积极型投资人";
			} else if (riskResult > 80 && riskResult<=100) {
				type = "积极型投资人";
			}
			JSONObject objs = new JSONObject();
			objs.put("accountInfo", accountInfo);
			objs.put("bankCount", bankCount);
			objs.put("type", type);
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
	 * 检查用户名是否存在
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/checkName?accountName=MM180202432276
	 * @param accountName
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月17日 下午4:21:45
	 */
	@ResponseBody
	@RequestMapping("/checkName")
	public JSONObject checkName(String accountName)
	{
		//字符串转码
		try
		{
			accountName = new String(accountName.getBytes("iso8859-1"), "utf-8");
		}
		catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		//检查用户名是否合法
		if (StringTools.isAccountName(accountName))
		{
			// 检查用户名是否存在
			try
			{
				Integer falg = accountInfoService.checkAccountName(accountName);
				if (falg == 0)
				{
					msg = "用户名可以使用";
					code = "200";
				} else {
					msg = "用户名已存在";
					code = "203";
				}
			}
			catch (Exception e)
			{
				logger.error("检查用户名是否唯一异常", e);
			}
		} else {
			msg = "用户名不符合规范";
			code = "400";
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 修改用户名
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/changeName?accountName=&accountId=
	 * @param accountName
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月17日 下午5:55:03
	 */
	@ResponseBody
	@RequestMapping("/changeName")
	public JSONObject changeName(String accountName,String accountId)
	{
		//字符串转码
		try
		{
			accountName = new String(accountName.getBytes("iso8859-1"), "utf-8");
		}
		catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		if (StringTools.isAccountName(accountName)) {
			try
			{
				Integer falg = accountInfoService.checkAccountName(accountName);
				if (falg == 0)
				{
					falg = accountInfoService.iosChangeAccountName(accountName,accountId);
					if (falg == 1)
					{
						integralScoreService.iosPerfectInformationIntegralReward(accountId);
						msg = "修改成功";
						code = "200";
					}
				} else {
					msg = "用户名已存在";
					code = "203";
				}
			}
			catch (Exception e)
			{
				logger.error("更改用户名异常", e);
			}
		}else {
			msg = "用户名不符合规范";
			code = "400";
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 用户实名认证
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/certification?accountId=&idCard=&realName=&accountSex=
	 * @param accountId
	 * @param idCard
	 * @param realName
	 * @param accountSex
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月18日 上午10:16:05
	 */
	@ResponseBody
	@RequestMapping("/certification")
	public JSONObject certification(String accountId,String idCard, String realName, String accountSex)
	{
		// 字符串转码
		try
		{
			realName = new String(realName.getBytes("iso8859-1"), "utf-8");
		}
		catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setAccountId(accountId);
			accountInfo.setIdCard(idCard);
			accountInfo.setRealName(realName);
			accountInfo.setAccountSex(accountSex);
			if (accountInfoService.certification(accountInfo))
			{
				integralScoreService.iosPerfectInformationIntegralReward(accountId);
				msg = "实名认证成功";
				code = "200";
			}
		}
		catch (Exception e)
		{
			logger.error("实名认证异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 判断是否有实名认证，是否有绑定银卡
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/bankCard?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月18日 上午11:51:59
	 */
	@ResponseBody
	@RequestMapping("/bankCard")
	public JSONObject bankCard(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			//查询用户绑定的银行卡
			AccountBankcardBean accountBankcardBean = accountBankcardService.getAccountBankcardByAccountId(accountId);
			//根据用户ID获取用户信息
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			msg = "";
			code = "200";
			JSONObject objs = new JSONObject();
			if (accountBankcardBean == null)
			{
				objs.put("accountBankcardBean", new AccountBankcardBean());
			} else {
				objs.put("accountBankcardBean", accountBankcardBean);
			}
			objs.put("accountInfo", accountInfo);
			obj.put("data",objs);
		}
		catch (SQLException e)
		{
			logger.error("查看银行卡", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 获取所有银行信息
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/chooseBank
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月18日 下午2:29:18
	 */
	@ResponseBody
	@RequestMapping("/chooseBank")
	public JSONObject chooseBank()
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			List<AccountBankcardBean> bankInfos = accountBankcardService.getAllBankInfo();
			msg = "";
			code = "200";
			JSONObject objs = new JSONObject();
			objs.put("bankInfos", bankInfos);
			obj.put("data", objs);
		}
		catch (Exception e)
		{
			logger.error("去选择银行页面异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 根据省获取市级
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/getCity?province=
	 * @param province
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月18日 下午2:44:27
	 */
	@ResponseBody
	@RequestMapping("/getCity") 
	public JSONObject getCity(String province)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			List<CityBean> citys= cityService.queryCityBySubCode(province);
			msg = "";
			code = "200";
			JSONObject objs = new JSONObject();
			objs.put("citys", citys);
			obj.put("data", objs);
		}
		catch (Exception e)
		{
			logger.error("根据省，获得市异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 绑定银行卡
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/bindBankCard?accountId=&bankCode=&bankCity=&bankOpening=&bankCard=
	 * @param accountId
	 * @param bankId
	 * @param bankCity
	 * @param bankOpening
	 * @param bankCard
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月18日 下午3:09:09
	 */
	@ResponseBody
	@RequestMapping("/bindBankCard")
	public JSONObject bindBankCard(String accountId,String bankCode,String bankCity,String bankOpening,String bankCard)
	{
		// 字符串转码
		try
		{
			bankOpening = new String(bankOpening.getBytes("iso8859-1"), "utf-8");
		}
		catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			AccountBankcardBean bankcardBean = accountBankcardService.getAccountBankcardByAccountId(accountId);
			AccountBankcardBean accountBankcardBean = new AccountBankcardBean();
			accountBankcardBean.setAccountId(accountId);
			accountBankcardBean.setBankId(bankCode);
			accountBankcardBean.setBankCity(bankCity);
			accountBankcardBean.setBankOpening(bankOpening);
			accountBankcardBean.setBankCard(bankCard);
			if (bankcardBean != null)
			{
				accountBankcardService.updateAccountBankcard(accountBankcardBean);
				msg = "成功修改银行卡信息";
				code = "200";
			}
			else
			{
				accountBankcardService.addAccountBankcard(accountBankcardBean);
				integralScoreService.iosPerfectInformationIntegralReward(accountId);
				msg = "成功添加银行卡信息";
				code = "200";
			}
		}
		catch (Exception e)
		{
			logger.error("绑定银行卡异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 修改登录密码
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/changePassword?accountId=&newPassword=&oldPassword=
	 * @param accountId
	 * @param newPassword
	 * @param oldPassword
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月18日 下午3:53:33
	 */
	@ResponseBody
	@RequestMapping("/changePassword")
	public JSONObject changePassword(String accountId,String newPassword, String oldPassword)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			// 判断原登录密码是否正确
			Integer falg = accountInfoService.iosCheckLoginPassword(accountId,oldPassword);
			if (falg == 0)
			{
				//原密码错误
				msg = "原密码错误";
				code = "203";
			} else {
				//修改密码
				Integer falg2 = accountInfoService.iosChangeLoginPassword(accountId,newPassword);
				if (falg2 == 1)
				{
					msg = "登录密码修改成功";
					code = "200";
				}
			}
		}
		catch (Exception e)
		{
			logger.error("修改登录密码异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 修改交易密码
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/changeDealPassword?accountId=&newDealPassword=&oldDealPassword=
	 * @param accountId
	 * @param newDealPassword
	 * @param oldDealPassword
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月18日 下午4:16:05
	 */
	@ResponseBody
	@RequestMapping("/changeDealPassword")
	public JSONObject changeDealPassword(String accountId, String newDealPassword, String oldDealPassword)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			// 判断原交易密码是否正确
			Integer falg = accountInfoService.iosCheckDealPassword(accountId, oldDealPassword);
			if (falg == 0)
			{
				//原交易密码错误
				msg = "原交易密码错误";
				code = "203";
			} else {
				// 修改交易密码
				Integer falg2 = accountInfoService.iosChangeDealPassword(accountId, newDealPassword);
				if (falg2 == 1)
				{
					msg = "交易密码修改成功";
					code = "200";
				}
			}
		}
		catch (Exception e)
		{
			logger.error("修改交易密码异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 判断手机号是否为登录手机号并发送短信验证码
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/sendMobileCode?accountId=&telephone=
	 * @param accountId
	 * @param telephone
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月18日 下午4:45:35
	 */
	@ResponseBody
	@RequestMapping("/sendMobileCode")
	public JSONObject sendMobileCode(String accountId, String telephone)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "短信发送失败";
		String code = "500";
		try
		{
			if (accountInfoService.iosCheckAccountTelephone(accountId, telephone))
			{
				String str = "";
				// 调用发送验证码功能，返回成功与否的结果
				if(messageCodeService.checkCount(telephone))
				{
					str = MobileMessageSend.sendMsg(telephone);
					messageCodeService.addMessage(telephone, "4");
					if ("success".equals(str))
					{
						msg = "短信发送成功";
						code = "200";
					}
				}else{
					msg = "短信发送次数超额";
					code = "201";
				}
			} else {
				msg = "接受短信手机号与用户手机号不一致";
				code = "203";
			}
		}
		catch (Exception e)
		{
			logger.error("手机验证码发送异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 找回交易密码，验证验证码，修改交易密码
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/reappearSetDealPassword?accountId=&password=&yzm=
	 * @param accountId
	 * @param password
	 * @param yzm
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月18日 下午5:03:59
	 */
	@ResponseBody
	@RequestMapping("/reappearSetDealPassword")
	public JSONObject reappearSetDealPassword(String accountId, String password, String yzm)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "设置交易密码失败";
		String code = "500";
		try
		{
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			String flag = MobileMessageCheck.checkMsg(accountInfo.getTelephone(), yzm);
			// 短信验证码验证成功
			if ("success".equals(flag))
			{
				// 修改密码
				Integer falg2 = accountInfoService.iosChangeDealPassword(accountId, password);
				if (falg2 != null && falg2 == 1)
				{
					msg = "设置交易密码成功";
					code = "200";
				}
			} else {
				msg = "验证码输入错误";
				code = "203";
			}
		}
		catch (Exception e)
		{
			logger.error("重置交易密码异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 去风险能力测试
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/torisktest?accoountId=
	 * @param accoountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月19日 上午9:50:32
	 */
	@ResponseBody
	@RequestMapping("/torisktest")
	public JSONObject toRiskTest(String accoountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accoountId);
			JSONObject objs = new JSONObject();
			objs.put("isRisk", accountInfo.getIsRisk());
			objs.put("accountInfo", JsonUtil.beanToJson(accountInfo));
			obj.put("data",objs);
			msg = "";
			code = "200";
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 去风险能力测试(重新测试)
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/torisktestreset?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月19日 上午9:58:50
	 */
	@ResponseBody
	@RequestMapping("/torisktestreset")
	public JSONObject toRiskTestReset(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			JSONObject objs = new JSONObject();
			objs.put("isRisk", accountInfo.getIsRisk());
			accountInfo.setRiskResult("");
			accountInfo.setIsRisk(Constants.DEVIL_NUM_ZERO);
			objs.put("accountInfo", JsonUtil.beanToJson(accountInfo));
			obj.put("data",objs);
			msg = "";
			code = "200";
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 记录风险能力测试结果
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/risktestover?riskResult=&accountId=
	 * @param riskResult
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月19日 上午10:30:59
	 */
	@ResponseBody
	@RequestMapping("/risktestover")
	public JSONObject riskTestOver(String riskResult, String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		int flag = 0;
		try
		{
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			if(accountInfo.getIsRisk().equals(Constants.DEVIL_NUM_ZERO)){
				flag = 1;
				integralScoreService.iosPerfectInformationIntegralReward(accountId);
			}
			accountInfo.setRiskResult(riskResult);
			accountInfo.setIsRisk(Constants.DEVIL_NUM_ONE);
			//设置投资风险金
			accountInfo.setRiskAmount(MoneyUtils.changeYToF(Constants.DEFAULTRISKAMOUNT));
			if (accountInfoService.bindInfo(accountInfo))
			{
				//前台提示语
				if(flag == 1){
					msg = "首次测试成功";
					code = "200";
				} else {
					msg = "重新测试成功";
					code = "200";
				}
			}
		}
		catch (Exception e)
		{
			logger.error("记录风险能力测试结果异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 抗风险能力测试结果，根据分数的说明
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/risktestoverDocument?riskResult=
	 * @param riskResult
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月16日 下午12:35:36
	 */
	@ResponseBody
	@RequestMapping("/risktestoverDocument")
	public JSONObject risktestoverDocument(Integer riskResult) {
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		//类型
		String type = "";
		//说明
		String advice = "";
		//建议
		String document = "";
		if (riskResult != null)
		{
			if (riskResult>0 && riskResult<=20)
			{
				type = "保守型投资人";
				advice = "低风险级别产品为主";
				document = "您的风险承担能力水平比较低，您关注资产的安全性远超于资产的收益性。低风险的投资品种比较适合您作为主要投资产品。 比如：储蓄、短期国债、债权类等。这类投资的收益相对偏低，"+
						"所以您应该将资产的绝大部分投资于此类低风险产品，另有小部分投资于证券、贵金属现货、证券投资类基金等； 参考投资分配比例：低风险类资产：中等风险类资产 = 8:2";
			} else if (riskResult>20 && riskResult<=40) {
				type = "稳健偏保守型投资人";
				advice = "中低风险级别产品为主";
				document = "您的风险承受能力偏低，对投资收益比较敏感，期望通过长期且持续的投资获得高于平均水平的回报。中低等级风险收益的投资品种比较适合您作为主要投资产品。"+
						"比如：证券投资类基金、长期债权等。为了提高整个资产组合的平均收益率，还可以将小部分资金投资于贵金属现货、贵金属期货等此类资产；" + 
						"参考投资分配比例：低风险类投资：中等风险类投资 = 7:3";
			} else if (riskResult>40 && riskResult<=60) {
				type = "稳健型投资人";
				advice = "中等风险级别产品为主";
				document = "您有一定的风险承受能力，对投资收益比较敏感，期望通过长期且持续的投资获得高于平均水平的回报，通常更注重十年甚至更长期限内的平均收益。所以中等风险收益的投资品种比较适合您作为主要投资产品，"+
						"回避风险的同时有一定的收益保证；" + 
						"参考投资分配比例：低风险类投资：中等风险类投资 = 6:4";
			} else if (riskResult>60 && riskResult<=80) {
				type = "稳健偏积极型投资人";
				advice = "中高风险级别产品为主";
				document = "您有中高的风险承受能力，愿意承担可预见的投资风险去获取更多的收益，一般倾向于进行中短期投资。所以中高等级的风险收益投资品种比较适合您作为主要投资产品，以一定的可预见风险换取超额收益；"+
						"参考投资分配比例：低风险类投资：中等风险类投资：高等风险类投资 = 5:4:1";
			} else if (riskResult>80 && riskResult<=100) {
				type = "积极型投资人";
				advice = "高风险级别产品为主";
				document = "您有较高的风险承受能力，是富有冒险精神的积极型选手。在投资收益波动的情况下，仍然保持积极进取的投资理念。短期内投资收益的下跌被您视为加注投资的利好机会。您适合事灵活、风险与报酬都比较高的投资，"+
						"不过要注意不要因一时的高报酬获利而将全部资金投入高风险操作，务必做好风险管理与资金调配工作；参考投资分配比例：低风险类投资：中等风险类投资：高风险类投资 = 3: 4：3";
			}
			JSONObject objs = new JSONObject();
			objs.put("type", type);
			objs.put("advice", advice);
			objs.put("document", document);
			obj.put("data",objs);
			msg = "";
			code = "200";
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 查询用户等级等一系列信息
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/accountInfo/queryAccountLevel?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月19日 上午10:53:14
	 */
	@ResponseBody
	@RequestMapping("/queryAccountLevel")
	public JSONObject queryAccountLevel(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		// 获取的数据格式化保留两位小数
		DecimalFormat df = new DecimalFormat("0.00");
		CapitalBean capitalBean = new CapitalBean();
		CapitalBean accountBean = new CapitalBean();
		try
		{
			// 获取页面用户登录信息
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			// 获取账户id
			capitalBean.setAccountId(accountInfo.getAccountId());

			// 调用查询方法
			capitalBean = capitalService.queryCapitalById(capitalBean);
			accountBean = capitalService.queryAccountInfo(capitalBean);

			// 获取投资金额
			Double investmentMoney = capitalBean.getInvestmentMoney();

			// 获取用户名
			String accountName = accountBean.getAccountName();

			// 获取用户会员等级
			Integer accountLevel = Integer.parseInt(accountBean.getAccountLevel());

			Double investMoney2=0.0;
			//百分比
			String s2="";
			if(accountLevel==10){
				s2="100";
			} else {
				String investMoney=LevelParam.GRADE_DIVISION.get(accountLevel+1);
				String[] s=investMoney.split(",");
				//差的钱
				investMoney2=(Double.valueOf(s[0])/100)-investmentMoney;
				s2=String.valueOf(investmentMoney/(Double.valueOf(s[0])/100)*100);
				s2 = s2.substring(0, s2.indexOf("."));
			}
			JSONObject objs = new JSONObject();
			objs.put("investMoney2", df.format(investMoney2));
			objs.put("accountLevel", String.valueOf(accountLevel));
			objs.put("accountName", accountName);
			objs.put("s2", s2);
			obj.put("data",objs);
			msg = "";
			code = "200";
		}
		catch (Exception e)
		{
			logger.error("查询等级中心信息总览失败", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 去更多信息
	 * @Description:/ios/accountInfo/moreInfo?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 下午2:48:37
	 */
	@RequestMapping("/moreInfo")
	@ResponseBody
	public JSONObject moreInfo(String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();

		String msg = "去更多信息失败";
		Integer code = 300;

		AccountInfo accountInfo = new AccountInfo();
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			objs.put("accountInfo", accountInfo);
			obj.put("data", objs);
			msg = "去更多信息成功";
			code = 200;
		}
		catch (Exception e)
		{
			logger.error("去更多信息异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 *  去绑定QQ页面
	 * @Description:/ios/accountInfo/toBindQQ?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 下午4:57:52
	 */
	@RequestMapping("/toBindQQ")
	@ResponseBody
	public JSONObject toBindQQ(String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();

		String msg = "去绑定QQ失败";
		Integer code = 300;
		AccountInfo accountInfo = new AccountInfo();
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			objs.put("accountInfo", accountInfo);
			obj.put("data", objs);
			msg = "去绑定QQ成功";
			code = 200;
		}
		catch (Exception e)
		{
			logger.error("去绑定QQ异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 绑定QQ
	 * @Description:/ios/accountInfo/bindQQ?accountId=&&accountQQ=
	 * @param accountWX
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 下午4:59:13
	 */
	@RequestMapping("/bindQQ")
	@ResponseBody
	public JSONObject bindQQ(String accountQQ,String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();

		String msg = "绑定QQ失败";
		Integer code = 300;
		AccountInfo accountInfo = new AccountInfo();

		// 创建标识
		String result = "{\"result\":\"error\"}";
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			//QQ验证
			String regex = "[1-9][0-9]{4,14}"; 
			Pattern p = Pattern.compile(regex);
			//返回Boolean
			System.out.println(p.matcher(accountQQ).matches());
			if(p.matcher(accountQQ).matches())
			{
				if(accountInfo.getAccountQQ() !=null && !"".equals(accountInfo.getAccountQQ()))
				{
					accountInfo.setAccountQQ(accountQQ);
					result = accountInfoService.bindInfo(accountInfo) ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
					objs.put("result", result);
					obj.put("data", objs);
					msg = "修改QQ成功";
					code = 200;
				}
				else
				{
					accountInfo.setAccountQQ(accountQQ);
					result = accountInfoService.bindInfo(accountInfo) ? "{\"result\":\"score\"}" : "{\"result\":\"error\"}";
					integralScoreService.iosPerfectInformationIntegralReward(accountId);
					objs.put("result", result);
					obj.put("data", objs);
					msg = "绑定QQ成功";
					code = 200;
				}
			}
			else
			{
				msg = "QQ号异常";
				code = 203;
			}
		}
		catch (Exception e)
		{
			logger.error("绑定QQ异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}


	/**
	 * 去绑定微信
	 * @Description:/ios/accountInfo/toBindWX?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 下午3:01:52
	 */
	@RequestMapping("/toBindWX")
	@ResponseBody
	public JSONObject toBindWX(String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();

		String msg = "去绑定微信失败";
		Integer code = 300;
		AccountInfo accountInfo = new AccountInfo();
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			objs.put("accountInfo", accountInfo);
			obj.put("data", objs);
			msg = "去绑定微信成功";
			code = 200;
		}
		catch (Exception e)
		{
			logger.error("去绑定微信异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 *  绑定微信
	 * @Description:/ios/accountInfo/bindWX?accountId=&&accountWX=
	 * @param accountWX
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 下午3:59:58
	 */
	@RequestMapping("/bindWX")
	@ResponseBody
	public JSONObject bindWX(String accountWX,String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();

		String msg = "绑定微信失败";
		Integer code = 300;
		AccountInfo accountInfo = new AccountInfo();

		// 创建标识
		String result = "{\"result\":\"error\"}";
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			if(accountInfo.getAccountWX() !=null && !"".equals(accountInfo.getAccountWX()))
			{
				accountInfo.setAccountWX(accountWX);
				result = accountInfoService.bindInfo(accountInfo) ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
				objs.put("result", result);
				obj.put("data", objs);
				msg = "修改微信成功";
				code = 200;
			}
			else
			{
				accountInfo.setAccountWX(accountWX);
				result = accountInfoService.bindInfo(accountInfo) ? "{\"result\":\"score\"}" : "{\"result\":\"error\"}";
				integralScoreService.iosPerfectInformationIntegralReward(accountId);
				objs.put("result", result);
				obj.put("data", objs);
				msg = "绑定微信成功";
				code = 200;
			}
		}
		catch (Exception e)
		{
			logger.error("绑定微信异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 去绑定微博
	 * @Description:/ios/accountInfo/toBindWB?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 下午4:36:59
	 */
	@RequestMapping("/toBindWB")
	@ResponseBody
	public JSONObject toBindWB(String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();

		String msg = "去绑定微博失败";
		Integer code = 300;
		AccountInfo accountInfo = new AccountInfo();
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			objs.put("accountInfo", accountInfo);
			obj.put("data", objs);
			msg = "去绑定微博成功";
			code = 200;
		}
		catch (Exception e)
		{
			logger.error("去绑定微博异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 *  绑定微博
	 * @Description:/ios/accountInfo/bindWB?accountId=&&accountWB=
	 * @param accountWB
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 下午4:38:52
	 */
	@RequestMapping("/bindWB")
	@ResponseBody
	public JSONObject bindWB(String accountWB,String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();

		String msg = "绑定微信失败";
		Integer code = 300;
		AccountInfo accountInfo = new AccountInfo();

		// 创建标识
		String result = "{\"result\":\"error\"}";
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			if(accountInfo.getAccountWB() !=null && !"".equals(accountInfo.getAccountWB()))
			{
				accountInfo.setAccountWB(accountWB);
				result = accountInfoService.bindInfo(accountInfo) ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
				objs.put("result", result);
				obj.put("data", objs);
				msg = "修改微博成功";
				code = 200;
			}
			else
			{
				accountInfo.setAccountWB(accountWB);
				result = accountInfoService.bindInfo(accountInfo) ? "{\"result\":\"score\"}" : "{\"result\":\"error\"}";
				integralScoreService.iosPerfectInformationIntegralReward(accountId);
				objs.put("result", result);
				obj.put("data", objs);
				msg = "绑定微博成功";
				code = 200;
			}
		}
		catch (Exception e)
		{
			logger.error("去绑定微博异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 去绑定其他联系方式
	 * @Description:/ios/accountInfo/toBindContact?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 下午4:19:15
	 */
	@RequestMapping("/toBindContact")
	@ResponseBody
	public JSONObject toBindContact(String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();

		String msg = "去绑定其他联系方式失败";
		Integer code = 300;
		AccountInfo accountInfo = new AccountInfo();
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			objs.put("accountInfo", accountInfo);
			obj.put("data", objs);
			msg = "去绑定其他联系方式成功";
			code = 200;
		}
		catch (Exception e)
		{
			logger.error("去绑定其他联系方式异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 绑定其他联系方式
	 * @Description:/ios/accountInfo/bindContact?accountId=&&accountContactType=&&accountContactName=&&accountContactPhone=
	 * @param accountContactType
	 * @param accountContactName
	 * @param accountContactPhone
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 下午4:22:42
	 */
	@RequestMapping("/bindContact")
	@ResponseBody
	public JSONObject bindContact(String accountId,String accountContactType, String accountContactName, String accountContactPhone)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();

		String msg = "去绑定其他联系方式失败";
		Integer code = 300;
		// 字符串转码
		try
		{
			accountContactName = new String(accountContactName.getBytes("iso8859-1"), "utf-8");
		}
		catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		// 创建标识
		String result = "{\"result\":\"error\"}";
		AccountInfo accountInfo = new AccountInfo();
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			
			//手机号正则验证
			String regex = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$"; 
			Pattern p = Pattern.compile(regex);
		    //返回Boolean
		    System.out.println(p.matcher(accountContactPhone).matches());
			if(p.matcher(accountContactPhone).matches())
			{
				// 3个参数都必填,所以判断其中一个原参数不为空 就表示其其他原参数不为空
				// 为空则无需奖励积分
				if (accountInfo.getAccountContactPhone() != null && !"".equals(accountInfo.getAccountContactPhone()))
				{
					accountInfo.setAccountContactType(accountContactType);
					accountInfo.setAccountContactName(accountContactName);
					accountInfo.setAccountContactPhone(accountContactPhone);
					result = accountInfoService.bindInfo(accountInfo) ? "{\"result\":\"success\"}" : "{\"result\":\"error\"}";
					objs.put("result", result);
					obj.put("data", objs);
					msg = "修改其他联系方式成功";
					code = 200;
				}
				else
				{
					accountInfo.setAccountContactType(accountContactType);
					accountInfo.setAccountContactName(accountContactName);
					accountInfo.setAccountContactPhone(accountContactPhone);
					result = accountInfoService.bindInfo(accountInfo) ? "{\"result\":\"score\"}" : "{\"result\":\"error\"}";
					integralScoreService.iosPerfectInformationIntegralReward(accountId);
					objs.put("result", result);
					obj.put("data", objs);
					msg = "绑定其他联系方式成功";
					code = 200;
				}
			}
			else
			{
				msg = "手机号异常";
				code = 203;
			}
		}
		catch (Exception e)
		{
			logger.error("绑定其他联系方式异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}


	/**
	 * 去验证邮箱
	 * @Description:/ios/accountInfo/judgeEmailIsVerification?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月19日 上午11:02:03
	 */
	@RequestMapping("/judgeEmailIsVerification")
	@ResponseBody
	public JSONObject judgeEmailIsVerification(String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		String msg = "去验证邮箱失败";
		Integer code = 300;
		//初始化邮箱状态
		Integer status = -1;
		try
		{
			//根据用户id查询邮箱是否验证
			status = emailCheckService.getAccountById(accountId).getIsEmailValidate();
			//获得未验证的邮箱号
			String accountEmail = emailCheckService.getAccountById(accountId).getAccountEmail();

			objs.put("status", status);
			objs.put("accountEmail", accountEmail);
			obj.put("data", objs);
			msg = "去验证邮箱成功";
			code = 200;
		}
		catch (Exception e)
		{
			logger.error("去验证邮箱异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 发送邮箱验证
	 * @Description:/ios/accountInfo/sendMailboxVerification?accountId=&&email=
	 * @param accountId
	 * @param email
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月19日 上午11:50:39
	 */
	@RequestMapping("/sendMailboxVerification")
	@ResponseBody
	public JSONObject sendMailboxVerification(String accountId,String email)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		String msg = "发送邮箱验证失败";
		Integer code = 300;

		EmailCheck emailCheck = new EmailCheck();
		//邮箱验证
		String regex = "^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$";
		Pattern p = Pattern.compile(regex);
		//返回Boolean
		System.out.println(p.matcher(email).matches());
		if(p.matcher(email).matches())
		{
			emailCheck.setAccountEmail(email);
			emailCheck.setAccountId(accountId);

			// 获取4位邮箱认证码
			String codes = GetUUID.getMath();

			// 验证码内容
			emailCheck.setCodeContent("您的邮箱验证码为:" + codes);

			// 验证码类型默认0：邮箱认证
			emailCheck.setCodeType(Constants.DEVIL_NUM_ZERO);

			// 验证码
			emailCheck.setCodeMsg(codes);

			//初始化验证码ID
			String codeId = "";
			try
			{
				//添加一条验证码信息
				emailCheckService.saveVerInfo(emailCheck);
				//验证码ID
				codeId = String.valueOf(emailCheckService.getCodeIdByMsg(emailCheck));

				// 使用邮箱发送验证码
				// 1. 创建参数配置, 用于连接邮件服务器的参数配置
				Properties props = new Properties(); // 参数配置
				props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
				props.setProperty("mail.smtp.host", paramService.getParamVal("EMAIL_SMTP")); // 发件人的邮箱的SMTP服务器地址
				props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
				props.setProperty("mail.smtp.port", "587");

				// 2. 根据配置创建会话对象, 用于和邮件服务器交互
				Session session = Session.getDefaultInstance(props);
				session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log

				// 3. 创建一封邮件
				String msgs = "尊贵的猫咪财富用户,您的邮箱验证码为:" + codes + ", 请于" + paramService.getParamVal("EMAIL_CODE_TIME") + "分钟内验证, 谢谢!";
				MimeMessage message = EmailUtil.createMimeMessage(session, paramService.getParamVal("EMAIL_NAME"), email,
						"尊贵的猫咪财富用户", "猫咪财富邮箱确认", msgs);

				// 4. 根据 Session 获取邮件传输对象
				Transport transport = session.getTransport("smtp");

				// 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
				transport.connect(paramService.getParamVal("EMAIL_NAME"), paramService.getParamVal("EMAIL_CODE"));

				// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人,
				// 抄送人, 密送人
				transport.sendMessage(message, message.getAllRecipients());

				// 7. 关闭连接
				transport.close();

				objs.put("codeId", codeId);
				objs.put("codeTime", paramService.getParamVal("EMAIL_CODE_TIME"));
				obj.put("data", objs);
				msg = "发送邮箱验证成功";
				code = 200;
			}
			catch (Exception e)
			{
				logger.error("发送邮箱验证异常", e);
			}
		}
		else
		{
			msg = "邮箱异常";
			code = 201;
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 *  绑定邮箱
	 * @Description:/ios/accountInfo/saveVerInfo?accountId=&&enterCode=&&accountEmail=&&codeId
	 * @param accountId
	 * @param enterCode
	 * @param accountEmail
	 * @param codeId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月19日 下午1:51:52
	 */
	@RequestMapping("/saveVerInfo")
	@ResponseBody
	public JSONObject saveVerInfo(String accountId,String enterCode,String accountEmail,String codeId)
	{
		JSONObject obj = new JSONObject();
		String msg = "绑定邮箱失败";
		Integer code = 300;

		// 判断标识
		int flag;
		// 比较验证码
		EmailCheck emailCheck = new EmailCheck();
		emailCheck.setIsEmailValidate(1);
		emailCheck.setAccountEmail(accountEmail);
		emailCheck.setAccountId(accountId);
		emailCheck.setCodeId(codeId);
		try
		{
			emailCheck.setCodeMsg(String.valueOf(enterCode));

			flag = getDateDiff(emailCheck, enterCode);

			if(flag == 0)
			{
				//修改邮箱验证状态
				emailCheckService.updateIsEmailValidate(emailCheck);
				if("".equals(emailCheck.getAccountEmail()))
				{
					//用户邮箱不存在的话，添加用户邮箱
					emailCheckService.updateAccountEmail(emailCheck);					
					//完善信息，奖励积分
					integralScoreService.iosPerfectInformationIntegralReward(accountId);
					msg = "绑定邮箱成功";
					code = 200;
				}
				else
				{
					//用户邮箱存在的话，修改用户邮箱
					emailCheckService.updateAccountEmail(emailCheck);
					msg = "修改邮箱成功";
					code = 200;
				}
			}
			else
			{
				msg = "验证码失效";
				code = 201;
			}
		}
		catch (Exception e)
		{
			logger.error("绑定邮箱异常", e);
			flag=-3;
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 验证码失效
	 * @Description:
	 * @param emailCheck
	 * @param enterCode
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月24日 下午2:32:19
	 */
	public Integer getDateDiff(EmailCheck emailCheck, String enterCode)
	{
		int flag = -1;// 默认验证码不匹配
		Integer s = -1;
		try
		{
			// 先验证是否超时   获取时效性
			s = emailCheckService.getTimeDiff(Integer.parseInt(emailCheck.getCodeId()));
			//系统邮箱授权时间
			if (s > Integer.parseInt(paramService.getParamVal("EMAIL_CODE_TIME")))
			{
				flag = -2;// 超时
			}
			else
			{
				// 验证码一致匹配
				if (enterCode.equals(String.valueOf(emailCheckService.getCodeMsg(emailCheck))))
				{
					flag = 0;
				}
			}
		}
		catch (SQLException e)
		{
			logger.error("获取验证码ID异常!", e);
			flag = -3;
		}
		return flag;
	}
	
	/**
	 * 忘记密码———>修改密码
	 * @Description:/ios/accountInfo/reappearSetLoginPassword?telephone=&password=&yzm=
	 * @param telephone
	 * @param password
	 * @param yzm
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月26日 下午5:16:16
	 */
	@ResponseBody
	@RequestMapping("/reappearSetLoginPassword")
	public Map<String, Object> reappearSetLoginPassword(String telephone, String password, String yzm)
	{
		Map<String, Object> obj = new HashMap<>();
		Map<String, Object> objs = new HashMap<>();
		// 设置标识
		String msg = "系统异常";
		String code = "500";

		try
		{
			String flag = MobileMessageCheck.checkMsg(telephone, yzm);
			// 短信验证码验证成功
			if ("success".equals(flag))
			{
				AccountInfo accountInfo = accountInfoService.getAccountInfoByPhone(telephone);
				accountInfo.setPassword(password);
				// 修改密码
				if (accountInfoService.getBackLoginPassword(accountInfo))
				{
					msg = "修改成功";
					code = "200";
				}
				else
				{
					msg = "修改失败";
					code = "300";
				}
			}
			else
			{
				msg = "验证码错误";
				code = "400";
			}
		}
		catch (Exception e)
		{
			logger.error("重置交易密码异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 判断是否已开通金账户，是否已绑定银行卡，是否已实名认证
	 * @Description:/ios/accountInfo/checkGold?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年7月3日 上午10:04:05
	 */
	@ResponseBody
	@RequestMapping("/checkGold")
	public Map<String, Object> checkGold(String accountId)
	{
		Map<String, Object> obj = new HashMap<>();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		Map<String, String> map = new HashMap<>();
		AccountInfo accountInfo = null;
		try
		{
			accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
		}
		catch (SQLException e1)
		{
			logger.error("查询用户信息异常", e1);
			e1.printStackTrace();
		} finally {
			obj.put("msg", msg);
			obj.put("code", code);
		}
		try
		{
			//判断时候开户，没开户去开户  result
			map = fuiouService.checkRealNameAndBankCard(accountInfo.getAccountId());
			
			if("pass".equals(map.get("result"))){
				map = fuiouService.reg(accountInfo.getAccountId());
			}
			if ("error".equals(map.get("result"))) {
				msg = "绑定身份信息不正确，或身份信息已绑定过，请联系客服";
				code = "300";
			} else if ("noRealName".equals(map.get("result"))) {
				msg = "请先实名认证";
				code = "301";
			} else if ("noBankCard".equals(map.get("result"))) {
				msg = "请先绑定银行卡";
				code = "302";
			} else {
				msg = "金账户开户成功或已开通金账户";
				code = "200";
			}
		}
		catch (Exception e)
		{
			logger.error("绑定其他联系方式异常", e);
		} finally {
			obj.put("msg", msg);
			obj.put("code", code);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
}
