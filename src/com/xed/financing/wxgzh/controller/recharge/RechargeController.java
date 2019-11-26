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
package com.xed.financing.wxgzh.controller.recharge;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.bank.BankBean;
import com.xed.financing.wxgzh.model.city.CityBean;
import com.xed.financing.wxgzh.model.pay.CardQueryBean;
import com.xed.financing.wxgzh.model.pay.CardResultBean;
import com.xed.financing.wxgzh.service.accountbankcard.AccountBankcardService;
import com.xed.financing.wxgzh.service.city.CityService;
import com.xed.financing.wxgzh.service.fuiou.FuiouService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.recharge.RechargeService;
import com.xed.financing.wxgzh.util.HttpClientUtil;
import com.xed.financing.wxgzh.util.MD5;
import com.xed.financing.wxgzh.util.XmlUtil;

/**
 * @className:com.xed.financing.wxgzh.controller.recharge.RechargeController
 * @description:充值控制器
 * @version:v1.0.0
 * @date:2017年4月13日 下午2:15:13
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/recharge")
public class RechargeController
{

	@Autowired
	private RechargeService rechargeService;

	@Autowired
	private AccountBankcardService accountBankcardService;

	@Autowired
	private CityService cityService;

	@Autowired
	private ParamService paramService;
	
	@Autowired
	private FuiouService fuiouService;

	private String charset = "utf-8";

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(RechargeController.class);

	/**
	 * 去充值页面
	 * 
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月13日 下午2:16:49
	 */
	@RequestMapping("/rechargeInfo")
	public String rechargeInfo(HttpServletRequest request, HttpServletResponse response)
	{
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
		AccountBankcardBean bankcardBean;
		try
		{
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
				String bankCard = bankcardBean.getBankCard();

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
				String httpOrgCreateTestRtn = HttpClientUtil.doPost(url, createMap, charset);
				CardResultBean crBean = new CardResultBean();
				crBean = XmlUtil.readStringXmlPut(httpOrgCreateTestRtn);
				resutMap.put("rcd", crBean.getRcd());
				if (crBean.getRcd().equals("0000"))
				{
					resutMap.put("ctp", crBean.getCtp());
					resutMap.put("cnm", crBean.getCnm());
					String rcd = crBean.getInsCd().substring(0, 6)+"%";
					BankBean bkbean = rechargeService.queryByCode(rcd);
					resutMap.put("img", "images/" + bkbean.getBankPic());
					resutMap.put("id", bkbean.getBankCode());
				}
				bankcardBean.setCardId(bankCard.substring(bankCard.length() - 4, bankCard.length()));
				request.setAttribute("bankcardBean", bankcardBean);
				request.setAttribute("resutMap", resutMap);
				
				
				fuiouService.reg(accountInfo.getAccountId());
				
			}
		}
		catch (SQLException e)
		{
			logger.error("获得账号信息异常", e);
		}
		catch (Exception e){
			logger.error("金账户开户异常", e);
		}
		return "pay/recharge";
		// return "recharge/payrecharge";
	}

	@RequestMapping("/paymentSuccess")
	public String recharge(HttpServletRequest request, HttpServletResponse response)
	{

		return "recharge/paymentSuccess";
	}

	@RequestMapping("/paymentError")
	public String paymentError(HttpServletRequest request, HttpServletResponse response)
	{

		return "recharge/paymentError";
	}
	
}
