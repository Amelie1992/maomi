/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.recharge.RechargeController
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
package com.xed.financing.wxgzh.controller.intface.recharge;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xed.financing.wxgzh.mapper.accountbankcard.AccountBankcardMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.goldDetails.GoldDetailsMapper;
import com.xed.financing.wxgzh.mapper.goldpayInfo.GoldpayInfoMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.golddetails.GoldDetailsBean;
import com.xed.financing.wxgzh.model.goldpayinfo.GoldpayInfoBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.pay.PayEntryInfoBean;
import com.xed.financing.wxgzh.model.pay.PayEntryResult;
import com.xed.financing.wxgzh.model.pay.PayExportInfoBean;
import com.xed.financing.wxgzh.model.pay.PayResultInfo;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountbankcard.AccountBankcardService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.pay.PayExportInfoService;
import com.xed.financing.wxgzh.service.payentry.PayEntryInfoService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.GetUUID;
import com.xed.financing.wxgzh.util.HttpClientUtil;
import com.xed.financing.wxgzh.util.InterfaceUtil;
import com.xed.financing.wxgzh.util.MD5;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.SecurityUtils;
import com.xed.financing.wxgzh.util.StringTools;
import com.xed.financing.wxgzh.util.XmlUtil;

import net.sf.json.JSONObject;

/**
 * @className:com.xed.financing.wxgzh.controller.recharge.RechargeController
 * @description:充值控制器
 * @version:v1.0.0
 * @date:2017年4月13日 下午2:15:13
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/ios/recharge")
public class RechargeInterfaceController
{

	@Autowired
	private ParamService paramService;

	@Autowired
	private PayEntryInfoService payEntryInfoService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Resource
	private AccountBankcardMapper accountBankcardMapper;
	
	@Resource
	private CapitalMapper capitalMapper;
	
	@Resource
	private BondTransferMapper bondTransferMapper;
	
	@Autowired
	private PayExportInfoService payExportInfoService;
	
	@Resource
	private MessageMapper messageMapper;
	
	@Autowired
	private AccountBankcardService accountBankcardService;
	
	@Resource
	private GoldpayInfoMapper goldpayInfoMapper;
	
	@Resource
	private GoldDetailsMapper goldDetailsMapper;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(RechargeInterfaceController.class);
	
	/**
	 * (ios)充值页面显示的银行卡信息
	 * @Description:/ios/recharge/toRecharge?accountId= 
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年7月4日 下午5:01:30
	 */
	@ResponseBody
	@RequestMapping("/toRecharge")
	public Map<String, Object> toRecharge(String accountId){
		Map<String, Object> obj = new HashMap<>();
		Map<String, Object> objs = new HashMap<>();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			AccountBankcardBean bankcardBean = accountBankcardService.getAccountBankcardByAccountId(accountId);
			String bankCard = bankcardBean.getBankCard();
			bankcardBean.setBankCard(bankCard.substring(bankCard.length() - 4, bankCard.length()));
			msg = "";
			code = "200";
			objs.put("bankcardBean", bankcardBean);
			obj.put("data", objs);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		} finally {
			obj.put("msg", msg);
			obj.put("code", code);
		}
		return obj;
	}
	
	/**
	 * IOS充值
	 * @Description:/ios/recharge/rechargeInfo
	 * @param amt
	 * @param accountId
	 * @return
	 * @throws UnsupportedEncodingException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年7月6日 下午4:22:12
	 */
	@ResponseBody
	@RequestMapping(value = "/rechargeInfo", method = RequestMethod.POST)
	public Map<String, Object> iosRechargeInfo(Integer amt,String accountId)
			throws UnsupportedEncodingException
	{
		Map<String, Object> obj = new HashMap<>();
		Map<String, String> objs = new HashMap<>();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		// 银行卡银行名称，银行卡号
		try
		{
			// 真实姓名，身份证号，手机号
			AccountInfo account = accountInfoService.iosGetLoginAccountInfo(accountId);
			AccountBankcardBean card = accountBankcardMapper.getAccountBankcardByAccountId(account.getAccountId());
			objs = InterfaceUtil.payment(account.getTelephone(), String.valueOf(amt * 100),
					"https://huidiao", paramService.getParamVal("IOS_BACK_NOTIFY_URL"));
			//正式请求路径
			objs.put("payUrl", "https://jzh.fuiou.com/app/500002.action");
			//测试请求路径
			//objs.put("payUrl", "https://jzh-test.fuiou.com/jzh/app/500002.action");
			GoldpayInfoBean goldpayInfoBean = new GoldpayInfoBean();
			goldpayInfoBean.setAccountId(account.getAccountId());
			goldpayInfoBean.setMchntCd(objs.get("mchnt_cd"));
			goldpayInfoBean.setMchntTxnSsn(objs.get("mchnt_txn_ssn"));
			goldpayInfoBean.setLoginId(account.getTelephone());
			goldpayInfoBean.setAmt(String.valueOf(amt * 100));
			goldpayInfoMapper.addGoldpayInfo(goldpayInfoBean);
			msg = "";
			code = "200";
			obj.put("data", objs);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} finally {
			obj.put("msg", msg);
			obj.put("code", code);
		}
		return obj;
	}
	
	/**
	 * IOS商户后台通知地址
	 * @Description:
	 * @param resp_code
	 * @param mchnt_cd
	 * @param mchnt_txn_ssn
	 * @param login_id
	 * @param amt
	 * @param resp_desc
	 * @param signature
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年7月6日 下午4:41:14
	 */
	@ResponseBody
	@RequestMapping(value = "/toPayExport", method = RequestMethod.POST)
	public void iosToPayExport(String resp_code, String mchnt_cd, String mchnt_txn_ssn,
			String login_id, String amt, String resp_desc, String signature)
	{
		String src = amt + "|" + login_id + "|" + mchnt_cd + "|" + mchnt_txn_ssn + "|" + resp_code + "|" + resp_desc;
		// 验签
		System.out.println("wj++++"+src);
		if (SecurityUtils.verifySign(src, signature))
		{
			try
			{
				GoldpayInfoBean goldpayInfoBean = new GoldpayInfoBean();
				goldpayInfoBean.setMchntTxnSsn(mchnt_txn_ssn);
				goldpayInfoBean.setLoginId(login_id);
				goldpayInfoBean = goldpayInfoMapper.getGoldpayInfo(goldpayInfoBean);
				goldpayInfoBean.setRespCode(resp_code);
				goldpayInfoBean.setBackAmt(amt);
				// 修改充值记录
				goldpayInfoMapper.updateGoldpayInfo(goldpayInfoBean);
				if ("0000".equals(resp_code) && StringTools.isNullOrEmpty(goldpayInfoBean.getRespCode()))
				{
					payExportInfoService.toPayExport(login_id, amt);
					// 金账户明细
					GoldDetailsBean goldDetail = new GoldDetailsBean();
					goldDetail.setInCustNo(login_id);
					goldDetail.setOutCustNo("");
					goldDetail.setMoney(amt);
					goldDetail.setTransferType("6");
					goldDetail.setPurpose("8");
					goldDetail.setRemark("在IOS平台充值：" + Integer.parseInt(amt) / 100 + "元");
					goldDetailsMapper.addGoldDetail(goldDetail);
				}
			}
			catch (Exception e)
			{
				logger.error("添加富有返回值异常！", e);
			}
		}
	}
	
	/**
	 * IOS判断是否充值成功
	 * @Description:/ios/recharge/callback
	 * @param mchnt_txn_ssn
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年7月6日 下午4:49:59
	 */
	@ResponseBody
	@RequestMapping(value = "/callback", method = RequestMethod.POST)
	public Map<String, Object> callback(String mchnt_txn_ssn,String accountId){
		Map<String, Object> obj = new HashMap<>();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			GoldpayInfoBean goldpayInfoBean = new GoldpayInfoBean();
			goldpayInfoBean.setMchntTxnSsn(mchnt_txn_ssn);
			goldpayInfoBean.setLoginId(accountInfo.getTelephone());
			goldpayInfoBean = goldpayInfoMapper.getGoldpayInfo(goldpayInfoBean);
			if ("0000".equals(goldpayInfoBean.getRespCode()))
			{
				msg = "充值成功";
				code = "200";
			} else if("".equals(goldpayInfoBean.getRespCode()) || goldpayInfoBean.getRespCode() == null) {
				msg = "继续等待";
				code = "300";
			} else {
				msg = "充值失败";
				code = "400";
			}
			obj.put("msg", msg);
			obj.put("code", code);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return obj;
	}


}
