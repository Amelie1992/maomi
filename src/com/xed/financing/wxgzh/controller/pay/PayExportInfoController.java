package com.xed.financing.wxgzh.controller.pay;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.goldDetails.GoldDetailsMapper;
import com.xed.financing.wxgzh.mapper.goldpayInfo.GoldpayInfoMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.model.golddetails.GoldDetailsBean;
import com.xed.financing.wxgzh.model.goldpayinfo.GoldpayInfoBean;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.pay.PayExportInfoService;
import com.xed.financing.wxgzh.util.SecurityUtils;
import com.xed.financing.wxgzh.util.StringTools;

@Controller
@RequestMapping("/payExport")
public class PayExportInfoController
{
	@Autowired
	private PayExportInfoService payExportInfoService;

	@Autowired
	private ParamService paramService;

	@Resource
	private CapitalMapper capitalMapper;
	/* private HttpClientUtil httpClientUtil = new HttpClientUtil(); */
	/**
	 * 消息mapper
	 */
	@Resource
	private MessageMapper messageMapper;

	@Resource
	private BondTransferMapper bondTransferMapper;

	@Resource
	private AccountInfoMapper accountInfoMapper;

	/* private String charset = "utf-8"; */
	@Resource
	private GoldpayInfoMapper goldpayInfoMapper;

	@Resource
	private GoldDetailsMapper goldDetailsMapper;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(PayExportInfoController.class);

	/**
	 * 充值借款回调
	 * 
	 * @Description:
	 * @param request
	 * @param resp_code
	 * @param mchnt_cd
	 * @param mchnt_txn_ssn
	 * @param login_id
	 * @param amt
	 * @param rem
	 * @param signature
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月10日 下午3:01:30
	 */
	@ResponseBody
	@RequestMapping(value = "/toPayExport", method = RequestMethod.POST)
	public void toPayExport(HttpServletRequest request, String resp_code, String mchnt_cd, String mchnt_txn_ssn,
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

				if ("0000".equals(resp_code) && StringTools.isNullOrEmpty(goldpayInfoBean.getRespCode()))
				{
					goldpayInfoBean.setRespCode(resp_code);
					goldpayInfoBean.setBackAmt(amt);
					payExportInfoService.toPayExport(login_id, amt);
					// 修改充值记录
					goldpayInfoMapper.updateGoldpayInfo(goldpayInfoBean);
					// 金账户明细
					GoldDetailsBean goldDetail = new GoldDetailsBean();
					goldDetail.setInCustNo(login_id);
					goldDetail.setOutCustNo("");
					goldDetail.setMoney(amt);
					goldDetail.setTransferType("6");
					goldDetail.setPurpose("8");
					goldDetail.setRemark("充值：" + Integer.parseInt(amt) / 100 + "元");
					goldDetailsMapper.addGoldDetail(goldDetail);

				}
			}
			catch (Exception e)
			{
				logger.error("添加富有返回值异常！", e);
			}
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/toPayNetExport",method=RequestMethod.POST)
	public void toPayNetExport(HttpServletRequest request,String resp_code,String mchnt_cd,String mchnt_txn_ssn,String login_id,String amt,String rem,String signature)
	{
		String src = amt+"|"+ login_id + "|"+ mchnt_cd +"|" +mchnt_txn_ssn+"|"+rem +"|" +resp_code;
		System.out.println("net++++"+src);
		// 验签
		if(SecurityUtils.verifySign(src, signature)){
			try
			{
				GoldpayInfoBean goldpayInfoBean = new GoldpayInfoBean();
				goldpayInfoBean.setMchntTxnSsn(mchnt_txn_ssn);
				goldpayInfoBean.setLoginId(login_id);
				goldpayInfoBean = goldpayInfoMapper.getGoldpayInfo(goldpayInfoBean);
				
				if("0000".equals(resp_code) && StringTools.isNullOrEmpty(goldpayInfoBean.getRespCode())){
					goldpayInfoBean.setRespCode(resp_code);
					goldpayInfoBean.setBackAmt(amt);
					goldpayInfoBean.setRem(rem);
					payExportInfoService.toPayExport(login_id, amt);
					//修改充值记录
					goldpayInfoMapper.updateGoldpayInfo(goldpayInfoBean);
					//金账户明细
					GoldDetailsBean goldDetail = new GoldDetailsBean();
					goldDetail.setInCustNo(login_id);
					goldDetail.setOutCustNo("");
					goldDetail.setMoney(amt);
					goldDetail.setTransferType("6");
					goldDetail.setPurpose("8");
					goldDetail.setRemark("充值：" + Integer.parseInt(amt)/100 + "元");
					goldDetailsMapper.addGoldDetail(goldDetail);
					
				}
			}
			catch (Exception e)
			{
				logger.error("添加富有返回值异常！", e);
			}
		}
	}

}
