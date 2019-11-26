package com.xed.financing.wxgzh.controller.pay;

import java.io.UnsupportedEncodingException;
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
import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountbankcard.AccountBankcardMapper;
import com.xed.financing.wxgzh.mapper.goldpayInfo.GoldpayInfoMapper;
import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.bank.BankBean;
import com.xed.financing.wxgzh.model.goldpayinfo.GoldpayInfoBean;
import com.xed.financing.wxgzh.model.pay.CardQueryBean;
import com.xed.financing.wxgzh.model.pay.CardResultBean;
import com.xed.financing.wxgzh.model.pay.PayEntryInfoBean;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.recharge.RechargeService;
import com.xed.financing.wxgzh.util.HttpClientUtil;
import com.xed.financing.wxgzh.util.InterfaceUtil;
import com.xed.financing.wxgzh.util.MD5;
import com.xed.financing.wxgzh.util.XmlUtil;

@Controller
@RequestMapping("/payEntry")
public class PayEntryInfoController
{
	@Autowired
	private ParamService paramService;


	@Autowired
	private RechargeService rechargeService;

	@Resource
	private AccountBankcardMapper accountBankcardMapper;

	@Resource
	private AccountInfoMapper accountInfoMapper;

	@Resource
	private GoldpayInfoMapper goldpayInfoMapper;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(PayEntryInfoController.class);

	private String charset = "utf-8";
	HttpClientUtil httpClientUtil = new HttpClientUtil();

	public Map<String, Object> payInfo(PayEntryInfoBean payEntryBena)
	{
		String mchntCd = paramService.getParamVal("MCHNT_CD");
		String httpOrgCreateTest = paramService.getParamVal("PAY_URL");
		String mchntKey = paramService.getParamVal("MCHNT_KEY");
		String md5 = "";
		md5 = payEntryBena.getTYPE() + "|" + payEntryBena.getVERSION() + "|" + payEntryBena.getMCHNTCD() + "|"
				+ payEntryBena.getMCHNTORDERID() + "|" + payEntryBena.getUSERID() + "|" + payEntryBena.getAMT() + "|"
				+ payEntryBena.getBANKCARD() + "|" + payEntryBena.getBACKURL() + "|" + payEntryBena.getNAME() + "|"
				+ payEntryBena.getIDNO() + "|" + payEntryBena.getIDTYPE() + "|" + payEntryBena.getLOGOTP() + "|"
				+ payEntryBena.getHOMEURL() + "|" + payEntryBena.getREURL() + "|" + mchntKey;
		System.out.println(md5);
		md5 = MD5.MD5Encode(md5);
		payEntryBena.setSIGN(md5);
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(PayEntryInfoBean.class);
		System.out.println(xstream.toXML(payEntryBena));
		String order = xstream.toXML(payEntryBena);
		// order = MD5.MD5Encode(order);
		// System.out.println("加密后"+order);
		Map<String, Object> createMap = new HashMap<String, Object>();
		createMap.put("mchntCd", mchntCd);
		createMap.put("fm", order);
		createMap.put("payUrl", httpOrgCreateTest);
		// String httpOrgCreateTestRtn =
		// httpClientUtil.doPost(httpOrgCreateTest, createMap, charset);
		// System.out.println("result:" + httpOrgCreateTestRtn);
		return createMap;
	}

	// public TestMain(){
	// httpClientUtil = new HttpClientUtil();
	// }
	//
	/**
	 * 充值
	 * 
	 * @Description:
	 * @param payEntryBean
	 * @version:v1.0
	 * @author:Qian Tao
	 * @throws UnsupportedEncodingException
	 * @date:2017年5月27日 上午11:59:02
	 */
	/* @RequestMapping("/rechargeInfo") */
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping(value="/rechargeInfo",method=RequestMethod.POST) public
	 * Map<String, Object> rechargeInfo(HttpServletRequest request,
	 * PayEntryInfoBean payEntryBean, Integer amt, String bankCard,String
	 * idNo,String name) throws UnsupportedEncodingException { // name = new
	 * String(name.getBytes("ISO-8859-1"), "UTF-8"); Map<String, Object>
	 * resutMap = new HashMap<String, Object>(); // 从session中查询出账户ID String
	 * accountId = ((AccountInfo)
	 * request.getSession().getAttribute("account")).getAccountId();
	 * payEntryBean.setACCOUNTID(Integer.parseInt(accountId)); // 生成订单编号
	 * payEntryBean.setMCHNTORDERID(GetUUID.getUsefulID("")); // 金额元转分
	 * payEntryBean.setAMT(amt * 100); // 商户代码
	 * payEntryBean.setMCHNTCD(paramService.getParamVal("MCHNT_CD"));
	 * payEntryBean.setUSERID(accountId); payEntryBean.setTYPE("10");
	 * payEntryBean.setVERSION("2.0"); payEntryBean.setLOGOTP("0");
	 * payEntryBean.setBANKCARD(bankCard);
	 * 
	 * // 页面跳转url
	 * payEntryBean.setHOMEURL(paramService.getParamVal("PAGE_NOTIFY_URL")); //
	 * 后台通知url
	 * payEntryBean.setBACKURL(paramService.getParamVal("BACK_NOTIFY_URL"));
	 * payEntryBean.setREURL(paramService.getParamVal("PAY_ERROR_URL"));
	 * payEntryBean.setNAME(name); payEntryBean.setIDTYPE("0");
	 * payEntryBean.setIDNO(idNo); payEntryBean.setSIGNTP("md5"); try { //
	 * 生成充值订单 boolean isFlag = payEntryInfoService.savePayEntry(payEntryBean);
	 * // 充值成功后 调用第三方接口 if (isFlag == true) { resutMap = payInfo(payEntryBean);
	 * } } catch (SQLException e) { logger.error("充值异常！", e); } return resutMap;
	 * }
	 */

	/* @RequestMapping("/cardQuery") */

	@ResponseBody
	@RequestMapping(value = "/rechargeInfo", method = RequestMethod.POST)
	public Map<String, String> rechargeInfo(HttpServletRequest request, Integer amt, String rdv)
			throws UnsupportedEncodingException
	{
		Map<String, String> map = new HashMap<String, String>();
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
		// 银行卡银行名称，银行卡号
		try
		{
			// 真实姓名，身份证号，手机号
			AccountInfo account = accountInfoMapper.getAccountInfo(accountInfo.getAccountId());

			AccountBankcardBean card = accountBankcardMapper.getAccountBankcardByAccountId(accountInfo.getAccountId());
			// map = InterfaceUtil.payment(account.getTelephone(),
			// String.valueOf(amt*100), "0803090000",
			// paramService.getParamVal("PAGE_NOTIFY_URL"),"http://cash.maomibank.com:9082/xed_cash_wxgzh/s/payInfo/save"
			// );
			if (rdv.equals("0"))
			{
				map = InterfaceUtil.payment(account.getTelephone(), String.valueOf(amt * 100),
						paramService.getParamVal("PAGE_NOTIFY_URL"), paramService.getParamVal("BACK_NOTIFY_URL"));
				map.put("payUrl", "https://jzh.fuiou.com/500405.action");
			}
			else
			{
				map = InterfaceUtil.payment(account.getTelephone(), String.valueOf(amt * 100), card.getBankId(),
						paramService.getParamVal("PAGE_NOTIFY_URL"), paramService.getParamVal("BACK_NOTIFY_NET_URL"));
				map.put("payUrl", "https://jzh.fuiou.com/500012.action");
			}
			GoldpayInfoBean goldpayInfoBean = new GoldpayInfoBean();
			goldpayInfoBean.setAccountId(accountInfo.getAccountId());
			goldpayInfoBean.setMchntCd(map.get("mchnt_cd"));
			goldpayInfoBean.setMchntTxnSsn(map.get("mchnt_txn_ssn"));
			goldpayInfoBean.setLoginId(account.getTelephone());
			goldpayInfoBean.setAmt(String.valueOf(amt * 100));
			goldpayInfoMapper.addGoldpayInfo(goldpayInfoBean);
			// map.put("payUrl",
			// "https://jzh-test.fuiou.com/jzh/500405.action");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/cardQuery", method = RequestMethod.POST)
	public Map<String, Object> cardQuery(HttpServletRequest request, String bankCard)
	{
		String mchntCd = paramService.getParamVal("MCHNT_CD");
		String mchntKey = paramService.getParamVal("MCHNT_KEY");
		String url = paramService.getParamVal("PAY_CARD_URL");

		Map<String, Object> resutMap = new HashMap<String, Object>();
		CardQueryBean cqBean = new CardQueryBean();

		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(CardQueryBean.class);

		String sign = mchntCd + "|" + bankCard + "|" + mchntKey;
		sign = MD5.MD5Encode(sign);
		cqBean.setMchntCd(mchntCd);
		cqBean.setOno(bankCard);
		cqBean.setSign(sign);
		String fm = xstream.toXML(cqBean);
		Map<String, String> createMap = new HashMap<String, String>();
		createMap.put("FM", fm);
		String httpOrgCreateTestRtn = httpClientUtil.doPost(url, createMap, charset);
		CardResultBean crBean = new CardResultBean();
		crBean = XmlUtil.readStringXmlPut(httpOrgCreateTestRtn);
		resutMap.put("rcd", crBean.getRcd());
		if (crBean.getRcd().equals("0000"))
		{
			resutMap.put("ctp", crBean.getCtp());
			resutMap.put("cnm", crBean.getCnm());
			String rcd = crBean.getInsCd().substring(0, 6) + "%";
			BankBean bkbean = rechargeService.queryByCode(rcd);
			resutMap.put("img", "images/" + bkbean.getBankPic());
			resutMap.put("id", bkbean.getBankCode());
		}
		return resutMap;

	}

}
