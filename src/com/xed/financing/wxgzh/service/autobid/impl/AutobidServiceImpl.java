/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.accountInfo.impl.AccountInfoServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月23日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.autobid.impl;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountlevel.AccountLevelMapper;
import com.xed.financing.wxgzh.mapper.autobid.AutoBidMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.goldDetails.GoldDetailsMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.autobid.AutobidInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.golddetails.GoldDetailsBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.autobid.AutobidService;
import com.xed.financing.wxgzh.service.fuiou.FuiouService;
import com.xed.financing.wxgzh.util.InterfaceUtil;

/**
 * @className:com.xed.financing.wxgzh.service.accountInfo.impl.AccountInfoServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年3月23日 上午11:35:35
 * @author:ZhangJun
 */
@Service
public class AutobidServiceImpl implements AutobidService
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AutobidServiceImpl.class);

	@Autowired
	private FuiouService fuiouService;
	
	@Resource
	public AutoBidMapper autoBidmapper;

	@Resource
	public AccountLevelMapper accountLevelMapper;
	
	@Resource
	public BondTransferMapper bondTransferMapper;
	
	@Resource
	public MessageMapper messageMapper;
	
	@Resource
	private CapitalMapper capitalMapper;
	
	@Resource
	private ParamMapper paramMapper;

	@Resource
	private AccountInfoMapper accountInfoMapper;
	
	@Resource
	private GoldDetailsMapper goldDetailsMapper;

	@Override
	public void getAutobid(HttpServletRequest request) throws Exception
	{
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
		try
		{
			AutobidInfo autobid = autoBidmapper.getAccountAutobid(accountInfo.getAccountId());
			String accountLevel = accountLevelMapper.queryAccountLevel(accountInfo).getAccountLevel();
			CapitalBean capitalBean= new CapitalBean();
			capitalBean.setAccountId(accountInfo.getAccountId());
			CapitalBean cap = capitalMapper.queryCapitalById(capitalBean);
			request.setAttribute("cap", cap.getWithdrawMoney()+cap.getNoWithdrawMoney());
			request.setAttribute("autobid", autobid);
			request.setAttribute("accountLevel", accountLevel);
		}
		catch (Exception e)
		{
			logger.error("查询用户自动投标信息异常", e);
		}
	}

	@Override
	public void addAutobid(String accountId,AutobidInfo autobidInfo,Map<String, Object> map) throws Exception
	{
		try
		{
			AutobidInfo autobid = autoBidmapper.getAccountAutobid(accountId);
			
			
			if(autobid!=null){
				map.put("result", "haveBid");
				return;
			}
			//查询账户余额
			AccountCapital cap =  bondTransferMapper.getBalances(accountId);
			// 可用余额
			Integer withdrawMoney= Integer.parseInt(cap.getWithdrawMoney());
			// 不可提现金额（金账户金额）
			Integer noWithdrawMoney = Integer.parseInt(cap.getNoWithdrawMoney());
			// 设置自动投标金额
			Integer money = Integer.parseInt(autobidInfo.getMoney())*100;
			// 自动投标金额
			Integer freezeMoney = Integer.parseInt(cap.getFreezeMoney());
			// 自动投标金账户金额
			Integer autobidGoldMoney = 0;
			//检查余额
			if(money<=withdrawMoney+noWithdrawMoney){
				
				//修改金额
				if(money<=withdrawMoney){
					withdrawMoney = withdrawMoney-money;
				}else{
					/*AccountInfo account =  accountInfoMapper.getAccountInfo(accountId);*/
					noWithdrawMoney = noWithdrawMoney - money + withdrawMoney;
					
					autobidGoldMoney = money-withdrawMoney;
					withdrawMoney = 0;
					
					
					
					
					/*String shopNo = paramMapper.getParamVal("JZH_SHOP");
					Map<String, String> managementMap =InterfaceUtil.shopToCust(account.getTelephone(), shopNo, String.valueOf(money - withdrawMoney));
					
					fuiouService.addGoldTransfer(managementMap, account.getTelephone(), shopNo);
					
					if("0000".equals(managementMap.get("resp_code"))){
						//投资人-->商户[金账户明细]
						GoldDetailsBean goldDetail = new GoldDetailsBean();
						goldDetail.setInCustNo(shopNo);
						goldDetail.setOutCustNo(account.getTelephone());
						goldDetail.setMoney(String.valueOf(money - withdrawMoney));
						goldDetail.setTransferType("1");
						goldDetail.setPurpose("10");
						goldDetail.setRemark("投资人:"+account.getTelephone()+",设置自动投标,"+(money/100.0)+"元,金账户转帐"+(money - withdrawMoney)/100.0+"元");
						goldDetailsMapper.addGoldDetail(goldDetail);
					}*/
					
				}
				
				freezeMoney = freezeMoney+money;
				cap.setWithdrawMoney(String.valueOf(withdrawMoney));
				cap.setNoWithdrawMoney(String.valueOf(noWithdrawMoney));
				cap.setFreezeMoney(String.valueOf(freezeMoney));
				bondTransferMapper.changeFunds(cap);
				
				//发送消息
				MessageBean outMessageBean =new MessageBean();
				outMessageBean.setAccountId(accountId);
				outMessageBean.setMsgTitle("自动投标设置成功");
				outMessageBean.setMsgContent("您设置的自动投标成功，金额"+autobidInfo.getMoney()+"元。");
				messageMapper.addMessageInfo(outMessageBean);
				
				//添加自动投标记录
				autobidInfo.setAccountId(accountId);
				autobidInfo.setMoney(String.valueOf(money));
				autobidInfo.setAutobidGoldMoney(String.valueOf(autobidGoldMoney));
				autoBidmapper.addAutobidInfo(autobidInfo);
				
				
				map.put("result", "success");
			}else{
				map.put("result", "notEnough");
			}
			
		}
		catch (Exception e)
		{
			logger.error("用户设置自动投标异常", e);
		}

	}

	@Override
	public void cancelAutobid(String accountId,Map<String, Object> map) throws Exception
	{
		try
		{
			//查询最后
			AutobidInfo autobid = autoBidmapper.getAccountAutobid(accountId);
			
			if(autobid==null){
				map.put("result", "isCancel");
				return;
			}
			
			//查询账户余额
			AccountCapital cap =  bondTransferMapper.getBalances(accountId);
			//用户账户  金账户金额
			int noWithdrawMoney= Integer.parseInt(cap.getNoWithdrawMoney());
			int withdrawMoney = Integer.parseInt(cap.getWithdrawMoney());
			//自动投标设置的金额
			String money = String.valueOf(Double.parseDouble(autobid.getMoney())*100);
			money = money.substring(0, money.indexOf("."));
			int m = Integer.parseInt(money);
			//自动投标设置的金账户金额
			int autobidGoldMoney = Integer.parseInt(autobid.getAutobidGoldMoney());
			
			
			//自动投资金额
			int freezeMoney = Integer.parseInt(cap.getFreezeMoney());
			
			
			
			//检查余额
			if(m==freezeMoney){
				/*AccountInfo account =  accountInfoMapper.getAccountInfo(accountId);
				String shopNo = paramMapper.getParamVal("JZH_SHOP");
				
				Map<String, String> managementMap =InterfaceUtil.shopToCust(shopNo, account.getTelephone(),money);
				
				fuiouService.addGoldTransfer(managementMap, shopNo, account.getTelephone());
				
				if("0000".equals(managementMap.get("resp_code"))){
					//投资人-->商户[金账户明细]
					GoldDetailsBean goldDetail = new GoldDetailsBean();
					goldDetail.setInCustNo(account.getTelephone());
					goldDetail.setOutCustNo(shopNo);
					goldDetail.setMoney(money);
					goldDetail.setTransferType("0");
					goldDetail.setPurpose("11");
					goldDetail.setRemark("投资人:"+account.getTelephone()+",取消自动投标,"+(m/100.0)+"元");
					goldDetailsMapper.addGoldDetail(goldDetail);
				}*/
				
				// 金账户金额 = 金账户金额 + 自动投标设置的金账户金额
				noWithdrawMoney = noWithdrawMoney+autobidGoldMoney;
				// 自动投标金额 = 自动投标金额 - 自动投标设置金额
				freezeMoney = freezeMoney-m;
				// 可用余额 = 可用余额 + 自动投标设置金额 - 自动投标设置金账户金额
				withdrawMoney = withdrawMoney+m-autobidGoldMoney;
				
				cap.setWithdrawMoney(String.valueOf(withdrawMoney));
				cap.setNoWithdrawMoney(String.valueOf(noWithdrawMoney));
				cap.setFreezeMoney(String.valueOf(freezeMoney));
				bondTransferMapper.changeFunds(cap);
				
				MessageBean outMessageBean =new MessageBean();
				outMessageBean.setAccountId(accountId);
				outMessageBean.setMsgTitle("自动投标取消成功");
				outMessageBean.setMsgContent("您设置的自动投标已取消，金额"+autobid.getMoney()+"元。");
				messageMapper.addMessageInfo(outMessageBean);
				
				
				autoBidmapper.cancelAutobid(autobid);
				map.put("result", "success");
			}else{
				map.put("result", "notEnough");
			}
			
		}
		catch (Exception e)
		{
			logger.error("用户设置自动投标异常", e);
		}
	}

}
