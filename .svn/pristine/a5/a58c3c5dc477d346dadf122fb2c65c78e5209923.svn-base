/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.withdraw.WithdrawController
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
package com.xed.financing.wxgzh.controller.withdraw;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.xed.financing.wxgzh.mapper.coupon.CouponMapper;
import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.bank.BankBean;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.city.CityBean;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountbankcard.AccountBankcardService;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.capitaldetail.CapitaldetailService;
import com.xed.financing.wxgzh.service.city.CityService;
import com.xed.financing.wxgzh.service.recharge.RechargeService;
import com.xed.financing.wxgzh.service.withdrawrecord.WithdrawRecordService;
import com.xed.financing.wxgzh.util.CheckSumBuilder;

/**
 * 账户提现控制器
 * 
 * @className:com.xed.financing.wxgzh.controller.withdraw.WithdrawController
 * @description: 账户提现
 * @version:v1.0.0
 * @date:2017年4月13日 上午10:19:46
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/withdraw")
public class WithdrawController
{

	@Autowired
	private CapitalService capitalService;

	@Autowired
	private RechargeService rechargeService;

	@Autowired
	private CityService cityService;

	@Autowired
	private AccountInfoService accountInfoService;

	@Autowired
	private AccountBankcardService accountBankcardService;

	@Autowired
	private CapitaldetailService capitaldetailService;
	
	@Autowired
	private AccountLevelService accountLevelService;
	
	@Resource
	private CouponMapper couponMapper;
	
	@Resource
	public WithdrawRecordService withdrawRecordService;

	private static final String SERVER_URL = "https://api.netease.im/sms/sendtemplate.action";// 发送验证码的请求路径URL
	private static final String APP_KEY = "f890041787ee78309f3123b61e5b08ff";// 网易云信分配的账号
	private static final String APP_SECRET = "73a0e4f1f0f3";// 网易云信分配的密钥
	private static final String NONCE = "123456";// 随机数

	// 短信模板ID
	private static final String TEMPLATEID = "3059579";
	private static final String TEMPID = "3054727";
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(WithdrawController.class);

	/**
	 * 去提现页面，查询出当前登录用户的资金
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月13日 上午11:41:58
	 */
	@RequestMapping("/toWithdraw")
	public String toWithdraw(HttpServletRequest request)
	{

		try
		{
			List<BankBean> list = rechargeService.queryRechargeAll();
			request.setAttribute("bankList", list);
		}
		catch (SQLException e)
		{
			logger.error("提现模块，查询个人账户异常", e);
		}
		return "withdraw/recharge";
	}

	@RequestMapping("/rechargeInfo")
	public String rechargeInfo(HttpServletRequest request, HttpServletResponse response)
	{
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
		CapitalBean capitalBean = new CapitalBean();
		AccountBankcardBean bankcardBean;
		AccountInfo acc = new AccountInfo();
		Integer count = 0;
		capitalBean.setAccountId(((AccountInfo) request.getSession().getAttribute("account")).getAccountId());
		try
		{
			count = capitaldetailService.queryUserDraw(capitalBean.getAccountId());
			acc = accountInfoService.getLoginAccountInfo(request);
			bankcardBean = accountBankcardService.getAccountBankcardByAccountId(accountInfo.getAccountId());
			// 判断是否实名认证 是否绑定过银行卡
			if (accountInfo.getRealName() == null || "".equals(accountInfo.getRealName()))
			{
				// 未实名认证
				return "pay/certification";
			}
			else if (bankcardBean == null)
			{
				// 未绑定银行卡
				List<CityBean> provinceList = cityService.queryCityBySubCode("-1");
				request.setAttribute("provinceList", provinceList);
				return "pay/bankCard";
			}
			else
			{
				AccountInfo account= accountLevelService.queryAccountLevel(accountInfo);
				
				//提现券数量
				CouponBean coupon = new CouponBean();
				coupon.setAccountId(accountInfo.getAccountId());
				coupon.setCouponType("4");
				Integer couponCount = couponMapper.countNotUsedByType(coupon);
				
				capitalBean = capitalService.queryCapitalById(capitalBean);
				request.setAttribute("withdrawalsNumber", account.getWithdrawalsNumber());
				request.setAttribute("freeWithdrawalsNumber", account.getFreeWithdrawalsNumber());
				request.setAttribute("bankcardBean", bankcardBean);
				request.setAttribute("count", count);
				request.setAttribute("couponCount", couponCount);
				request.setAttribute("isComp", acc.getIsCompany());
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			logger.error("提现模块，查询个人账户异常", e);
		}
		request.setAttribute("capitalBean", capitalBean);
		return "withdraw/withdraw";
	}

	/* @RequestMapping("/queryMoney") */
	@ResponseBody
	@RequestMapping(value = "/queryMoney", method = RequestMethod.POST)
	public Map<String, Object> queryMoney(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		CapitalBean capitalBean = new CapitalBean();
		Map<String, Object> map = new HashMap<String, Object>();
		try
		{
			capitalBean.setAccountId(((AccountInfo) request.getSession().getAttribute("account")).getAccountId());
			capitalBean = capitalService.queryCapitalById(capitalBean);
			map.put("hisMoney", capitalBean.getAvailableBalance());
			map.put("freedomMoney", capitalBean.getFreedomMoney());
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	/* @RequestMapping("/withdrawMon") */
	@ResponseBody
	@RequestMapping(value = "/withdrawMon", method = RequestMethod.POST)
	public Map<String, Object> withdrawMon(HttpServletRequest request, HttpServletResponse response,
			String accountName, String bankCard, Double money, String bankName, String isComp, String count,Boolean tq,Boolean txq)
			throws IOException
	{
		
		Map<String, Object> resutMap = new HashMap<String, Object>();
		
		try
		{
				resutMap.put("code",withdrawRecordService.withdrawMon(request, response, accountName, bankCard, money, bankName, isComp, count, tq, txq) );
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return resutMap;
	}

	@RequestMapping("/toSucc")
	public String toSucc(HttpServletRequest request)
	{

		return "withdraw/paymentSuccess";
	}

	/**
	 * 
	 * @Description:提现发给客服转钱
	 * @param accountName
	 * @param bankName
	 * @param money
	 * @param bankCard
	 * @param phone
	 * @return
	 * @throws IOException
	 * @version:v1.0
	 * @author:WangJun
	 * @date:2017年6月30日 下午3:53:10
	 */
	public static String msgSend(String accountName, String bankName, String money, String bankCard, String phone,boolean flag)
			throws IOException
	{

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(SERVER_URL);

		String curTime = String.valueOf((new Date().getTime() / 1000L));
		String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

		// 设置请求的header
		post.addHeader("AppKey", APP_KEY);
		post.addHeader("Nonce", NONCE);
		post.addHeader("CurTime", curTime);
		post.addHeader("CheckSum", checkSum);
		// 短信模板
		// post.addHeader("templateid", "3052103");
		// 短信长度

		post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求参数
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		nameValuePairs.add(new BasicNameValuePair("mobiles", "['" + phone + "']"));
		if(flag){
			nameValuePairs.add(new BasicNameValuePair("templateid", "3134206"));//3134206
		}else{
			nameValuePairs.add(new BasicNameValuePair("templateid", TEMPLATEID));//
		}
		
		nameValuePairs.add(new BasicNameValuePair("params", "['" + accountName + "','" + money + "','" + bankName
				+ "','" + bankCard + "']"));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

		// 执行请求
		HttpResponse response = httpclient.execute(post);
		String responseEntity = EntityUtils.toString(response.getEntity(), "utf-8");

		// 判断是否发送成功，发送成功返回true
		String code = JSON.parseObject(responseEntity).getString("code");
		return code;
	}

	/**
	 * 
	 * @Description:提现发送给用户
	 * @param account
	 * @param money
	 * @return
	 * @throws IOException
	 * @version:v1.0
	 * @author:WangJun
	 * @date:2017年6月30日 下午3:52:58
	 */
	public static String msgSendYh(AccountInfo account, String money) throws IOException
	{

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(SERVER_URL);

		String curTime = String.valueOf((new Date().getTime() / 1000L));
		String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

		// 设置请求的header
		post.addHeader("AppKey", APP_KEY);
		post.addHeader("Nonce", NONCE);
		post.addHeader("CurTime", curTime);
		post.addHeader("CheckSum", checkSum);
		// 短信模板
		// post.addHeader("templateid", "3052103");
		// 短信长度

		post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求参数
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		nameValuePairs.add(new BasicNameValuePair("mobiles", "['" + account.getTelephone() + "']"));
		nameValuePairs.add(new BasicNameValuePair("templateid", TEMPID));
		nameValuePairs.add(new BasicNameValuePair("params", "['" + account.getAccountName() + "','"
				+ new SimpleDateFormat("yyyy.MM.dd").format(new Date()) + "','" + money + "']"));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

		// 执行请求
		HttpResponse response = httpclient.execute(post);
		String responseEntity = EntityUtils.toString(response.getEntity(), "utf-8");

		// 判断是否发送成功，发送成功返回true
		String code = JSON.parseObject(responseEntity).getString("code");
		return code;
	}
}
