/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.fuiou.impl.FuiouServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月25日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.fuiou.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountbankcard.AccountBankcardMapper;
import com.xed.financing.wxgzh.mapper.city.CityMapper;
import com.xed.financing.wxgzh.mapper.goldtransfer.GoldTransferMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.mapper.reggold.RegGoldMapper;
import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.goldtransfer.GoldTransferBean;
import com.xed.financing.wxgzh.model.reggold.RegGoldBean;
import com.xed.financing.wxgzh.service.fuiou.FuiouService;
import com.xed.financing.wxgzh.util.InterfaceUtil;

/**
 * @className:com.xed.financing.wxgzh.service.fuiou.impl.FuiouServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月25日 下午2:46:21
 * @author:ZhangJun
 */
@Service
public class FuiouServiceImpl implements FuiouService
{

	/*@Resource
	private CapitalMapper capitalMapper;*/
	
	@Resource
	private ParamMapper paramMapper;
	
	@Resource
	private AccountInfoMapper accountInfoMapper;

	@Resource
	private AccountBankcardMapper accountBankcardMapper;
	
	@Resource
	private CityMapper cityMapper;
	
	@Resource
	private RegGoldMapper regGoldMapper;

	@Resource
	private GoldTransferMapper goldTransferMapper;
	
	@Override
	public Map<String,String> reg(String accountId) throws Exception
	{
		Map<String,String> map = new HashMap<String, String>();
		
		//真实姓名，身份证号，手机号
		AccountInfo account =  accountInfoMapper.getAccountInfo(accountId);
		
		if("0".equals(account.getHaveGold())){
			
			
			//银行卡银行名称，银行卡号
			AccountBankcardBean card = accountBankcardMapper.getAccountBankcardByAccountId(accountId);
			
			//银行所属地
			String fuiouCityCode = cityMapper.getFuiouCityCode(card.getBankCity());
			
			map = InterfaceUtil.regFy(account.getRealName(), account.getIdCard(), account.getTelephone(), fuiouCityCode, card.getParentBankId(), card.getBankCard());
			
			String resp_code = map.get("resp_code");
			//添加开户记录
			RegGoldBean goldBean = new RegGoldBean();
			goldBean.setAccountId(accountId);
			goldBean.setAccountName(account.getRealName());
			goldBean.setCertifId(account.getIdCard());
			goldBean.setMobileNo(account.getTelephone());
			goldBean.setCityId(fuiouCityCode);
			goldBean.setParentBankId(card.getParentBankId());
			goldBean.setCapAcntNo(card.getBankCard());
			goldBean.setMchntTxnSsn(map.get("mchnt_txn_ssn"));
			goldBean.setRespCode(map.get("resp_code"));
			goldBean.setRespDesc(map.get("resp_desc"));
			
			regGoldMapper.insertRegGold(goldBean);
			
			if("0000".equals(resp_code)){
				accountInfoMapper.changeHaveGold(accountId);
				map.put("result", "success");
			}else{
				map.put("result", "error");
			}
			
		}else{
			map.put("result", "has");
		}
		
		
		
		return map;
	}
	
	
	public static void main(String[] args) throws  Exception
	{
		String cust_nm="张俊";//客户姓名 
		String certif_id= "321102199308011019";//身份证号码
		String mobile_no="15811511151";//手机号码
		String city_id="3052";//开户行地区代码
		String parent_bank_id="0105";//开户行行别
		String capAcntNo="6217002000021875564";//帐号
		Map<String, String> map = InterfaceUtil.regFy(cust_nm, certif_id, mobile_no, city_id, parent_bank_id, capAcntNo);
		String resp_code = map.get("resp_code");
		String mchnt_cd = map.get("mchnt_cd");
		String mchnt_txn_ssn = map.get("mchnt_txn_ssn");
		String signature = map.get("signature");
		System.out.println(resp_code);
		System.out.println(mchnt_cd);
		System.out.println(mchnt_txn_ssn);
		System.out.println(signature);
	}


	@Override
	public Map<String, String> checkRealNameAndBankCard(String accountId) throws Exception
	{
		Map<String,String> map = new HashMap<String, String>();
		
		//真实姓名，身份证号，手机号
		AccountInfo account =  accountInfoMapper.getAccountInfo(accountId);
		
		//银行卡银行名称，银行卡号
		AccountBankcardBean card = accountBankcardMapper.getAccountBankcardByAccountId(accountId);
		
		if("".equals(account.getRealName()) || account.getRealName()==null){
			map.put("result", "noRealName");
		}else if(card==null){
			map.put("result", "noBankCard");
		}else{
			map.put("result", "pass");
		}
		return map;
	}

	
	public void addGoldTransfer(Map<String, String> repayMap,String outCustNo,String inCustNo)throws SQLException
	{
		GoldTransferBean goldTransferBean=new GoldTransferBean();
		goldTransferBean.setMchntCd(repayMap.get("mchnt_cd"));
		goldTransferBean.setMchntTxnSsn(repayMap.get("mchnt_txn_ssn"));
		goldTransferBean.setSignature(repayMap.toString());
		goldTransferBean.setInCustNo(inCustNo);
		goldTransferBean.setOutCustNo(outCustNo);
		goldTransferBean.setRespCode(repayMap.get("resp_code"));
		goldTransferMapper.addGoldTransfer(goldTransferBean);
	}

	
}
