package com.xed.financing.wxgzh.util;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.fuiou.util.SecurityUtils;

public class InterfaceUtil
{
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("interfaces");

	public static void main(String[] args) throws SQLException
	{
		balance("jzh04");
		// balance("jzh09");
		// Map<String, String> map=shopToCust("jzh04",
		// "13770581871","10000000");
		// System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		// System.out.println(map);
		// System.out.println(map.toString());
		// custToCust("15895462414", "15295032859", "10000");
	}

	/**
	 * 
	 * @Description: 余额查询接口
	 * @param custNo
	 * @return map,ct_balance 账面总余额，ca_balance 可用余额， cf_balance 冻结余额，cu_balance
	 *         未转结余额
	 * @version:v1.0
	 * @author:wangjun
	 * @date:2018年5月2日 下午1:50:37
	 */
	public static Map<String, String> balance(String custNo)
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		Map<String, String> createMap = new HashMap<String, String>();
		String url = RESOURCE_BUNDLE.getString("balanceUrl");// 余额查询url
		String mchnt_cd = RESOURCE_BUNDLE.getString("mchntCd");// 商户号
		String mchnt_txn_ssn = GetUUID.getUsefulID("");// 流水号
		String mchnt_txn_dt = sdf.format(date);
		String cust_no = custNo;// 用户名or手机
		String signature = cust_no + "|" + mchnt_cd + "|" + mchnt_txn_dt + "|" + mchnt_txn_ssn;
		signature = SecurityUtils.sign(signature);
		createMap.put("mchnt_cd", mchnt_cd);
		createMap.put("mchnt_txn_ssn", mchnt_txn_ssn);
		createMap.put("mchnt_txn_dt", mchnt_txn_dt);
		createMap.put("cust_no", cust_no);
		createMap.put("signature", signature);
		// post请求
		String httpOrgCreateTestRtn = HttpClientUtil.doPost(url, createMap, "utf-8");
		Map<String, String> map = XmlUtil.xml2Map(httpOrgCreateTestRtn);
		return map;
	}

	/**
	 * 
	 * @Description:商户对个人转账
	 * @param outCustNo
	 * @param inCustNo
	 * @param amt
	 * @return
	 * @version:v1.0
	 * @author:wangjun
	 * @date:2018年5月2日 下午2:55:42
	 */
	public static Map<String, String> shopToCust(String outCustNo, String inCustNo, String amt)
	{
		Map<String, String> createMap = new HashMap<String, String>();
		String url = RESOURCE_BUNDLE.getString("shapToCust");// 个人转账给个人url
		String ver = "0.55";
		String mchnt_cd = RESOURCE_BUNDLE.getString("mchntCd");// 商户号
		String mchnt_txn_ssn = GetUUID.getUsefulID("");// 流水号
		String out_cust_no = outCustNo;// 付款登录账户
		String in_cust_no = inCustNo;// 收款登录账户
		String contract_no = "";
		String rem = "";
		String signature = amt + "|" + contract_no + "|" + in_cust_no + "|" + mchnt_cd + "|" + mchnt_txn_ssn + "|"
				+ out_cust_no + "|" + rem + "|" + ver;
		// 签名
		signature = SecurityUtils.sign(signature);

		createMap.put("ver", ver);
		createMap.put("mchnt_cd", mchnt_cd);
		createMap.put("mchnt_txn_ssn", mchnt_txn_ssn);
		createMap.put("out_cust_no", out_cust_no);
		createMap.put("in_cust_no", in_cust_no);
		createMap.put("amt", amt);
		createMap.put("signature", signature);

		String httpOrgCreateTestRtn = HttpClientUtil.doPost(url, createMap, "utf-8");
		Map<String, String> map = XmlUtil.xml4Map(httpOrgCreateTestRtn);
		return map;
	}

	/**
	 * 
	 * @Description:个人对个人转账
	 * @param outCustNo
	 * @param inCustNo
	 * @param amt
	 * @return
	 * @version:v1.0
	 * @author:wangjun
	 * @date:2018年5月2日 下午3:16:06
	 */
	public static Map<String, String> custToCust(String outCustNo, String inCustNo, String amt)
	{
		Map<String, String> createMap = new HashMap<String, String>();
		String url = RESOURCE_BUNDLE.getString("custToCust");// 个人转账给个人url
		String ver = "0.55";
		String mchnt_cd = RESOURCE_BUNDLE.getString("mchntCd");// 商户号
		String mchnt_txn_ssn = GetUUID.getUsefulID("");// 流水号
		String out_cust_no = outCustNo;// 付款登录账户
		String in_cust_no = inCustNo;// 收款登录账户
		String contract_no = "";
		String rem = "";
		String signature = amt + "|" + contract_no + "|" + in_cust_no + "|" + mchnt_cd + "|" + mchnt_txn_ssn + "|"
				+ out_cust_no + "|" + rem + "|" + ver;
		// 签名
		signature = SecurityUtils.sign(signature);

		createMap.put("ver", ver);
		createMap.put("mchnt_cd", mchnt_cd);
		createMap.put("mchnt_txn_ssn", mchnt_txn_ssn);
		createMap.put("out_cust_no", out_cust_no);
		createMap.put("in_cust_no", in_cust_no);
		createMap.put("amt", amt);
		createMap.put("signature", signature);

		String httpOrgCreateTestRtn = HttpClientUtil.doPost(url, createMap, "utf-8");
		Map<String, String> map = XmlUtil.xml4Map(httpOrgCreateTestRtn);
		return map;
	}

	/**
	 * 开户
	 * 
	 * @Description:
	 * @param cust_nm
	 *            客户姓名
	 * @param certif_id
	 *            身份证号码
	 * @param mobile_no
	 *            手机号码
	 * @param city_id
	 *            开户行地区代码
	 * @param parent_bank_id
	 *            开户行行别
	 * @param capAcntNo
	 *            卡号
	 * @return resp_code
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月2日 下午5:45:38
	 */
	public static Map<String, String> regFy(String cust_nm, String certif_id, String mobile_no, String city_id,
			String parent_bank_id, String capAcntNo)
	{
		Map<String, String> createMap = new HashMap<String, String>();
		String url = RESOURCE_BUNDLE.getString("reg");
		String mchnt_cd = RESOURCE_BUNDLE.getString("mchntCd");// 商户代码
		String mchnt_txn_ssn = GetUUID.getUsefulID("KH");// 流水号
		String certif_tp = "0";// 证件类型
		String email = "";// 邮箱地址
		String bank_nm = "";// 开户行支行名称
		String capAcntNm = "";// 户名
		String password = "";// 提现密码
		String lpassword = "";// 登录密码
		String rem = "";// 备注
		String ver = "0.55";
		String signature = bank_nm + "|" + capAcntNm + "|" + capAcntNo + "|" + certif_id + "|" + city_id + "|" + cust_nm
				+ "|" + email + "|" + lpassword + "|" + mchnt_cd + "|" + mchnt_txn_ssn + "|" + mobile_no + "|"
				+ parent_bank_id + "|" + password + "|" + rem + "|" + ver;

		signature = SecurityUtils.sign(signature);

		createMap.put("bank_nm", bank_nm);
		createMap.put("capAcntNm", capAcntNm);
		createMap.put("capAcntNo", capAcntNo);
		createMap.put("certif_id", certif_id);
		createMap.put("city_id", city_id);
		createMap.put("cust_nm", cust_nm);
		createMap.put("email", email);
		createMap.put("lpassword", lpassword);
		createMap.put("mchnt_cd", mchnt_cd);
		createMap.put("mchnt_txn_ssn", mchnt_txn_ssn);
		createMap.put("mobile_no", mobile_no);
		createMap.put("parent_bank_id", parent_bank_id);
		createMap.put("password", password);
		createMap.put("rem", rem);
		createMap.put("certif_tp", certif_tp);
		createMap.put("ver", ver);
		createMap.put("signature", signature);

		String httpOrgCreateTestRtn = HttpClientUtil.doPost(url, createMap, "utf-8");
		System.out.println(httpOrgCreateTestRtn);
		Map<String, String> map = XmlUtil.xml4Map(httpOrgCreateTestRtn);
		return map;
	}

	/**
	 * 
	 * @Description:
	 * @param login_id
	 *            用户登录名
	 * @param amt
	 *            充值金额 以分为单位 (无小数位)
	 * @param iss_ins_cd
	 *            银行代码
	 * @param page_notify_url
	 *            商户返回地址
	 * @param back_notify_url
	 *            商户后台通知地址
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月10日 上午10:03:05
	 */
	public static Map<String, String> payment(String login_id, String amt, String page_notify_url,
			String back_notify_url)
	{
		Map<String, String> map = new HashMap<String, String>();
		String mchnt_cd = RESOURCE_BUNDLE.getString("mchntCd");// 商户代码
		String mchnt_txn_ssn = GetUUID.getUsefulID("CZ");// 流水号

		String signature = amt + "|" + back_notify_url + "|" + login_id + "|" + mchnt_cd + "|" + mchnt_txn_ssn + "|"
				+ page_notify_url;

		signature = SecurityUtils.sign(signature);
		map.put("amt", amt);
		map.put("back_notify_url", back_notify_url);
		map.put("login_id", login_id);
		map.put("mchnt_cd", mchnt_cd);
		map.put("mchnt_txn_ssn", mchnt_txn_ssn);
		map.put("page_notify_url", page_notify_url);
		map.put("signature", signature);
		return map;
	}

	public static Map<String, String> payment(String login_id, String amt, String iss_ins_cd, String page_notify_url,
			String back_notify_url)
	{
		Map<String, String> map = new HashMap<String, String>();
		String mchnt_cd = RESOURCE_BUNDLE.getString("mchntCd");// 商户代码
		String mchnt_txn_ssn = GetUUID.getUsefulID("CZ");// 流水号
		String order_pay_type = "B2C";

		String signature = amt + "|" + back_notify_url + "|" + iss_ins_cd + "|" + login_id + "|" + mchnt_cd + "|"
				+ mchnt_txn_ssn + "|" + order_pay_type + "|" + page_notify_url;

		signature = SecurityUtils.sign(signature);
		map.put("amt", amt);
		map.put("back_notify_url", back_notify_url);
		map.put("iss_ins_cd", iss_ins_cd);
		map.put("login_id", login_id);
		map.put("mchnt_cd", mchnt_cd);
		map.put("mchnt_txn_ssn", mchnt_txn_ssn);
		map.put("order_pay_type", order_pay_type);
		map.put("page_notify_url", page_notify_url);
		map.put("signature", signature);
		return map;
	}
}
