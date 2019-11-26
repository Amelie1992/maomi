/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.freedomsubjectinvest.impl.FreedomSubjectInvestServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年10月30日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.freedomsubjectinvest.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.service.freedomsubjectinvest.FreedomSubjectInvestService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * @className:com.xed.financing.wxgzh.service.freedomsubjectinvest.impl.FreedomSubjectInvestServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月30日 上午11:47:33
 * @author:QT
 */
@Service
public class FreedomSubjectInvestServiceImpl implements FreedomSubjectInvestService
{

	@Resource
	private AccountInfoMapper accountInfoMapper;
	
	@Resource
	private CapitalMapper capitalMapper;
	
	@Override
	public void resetFreedomSubjectCoupon() throws Exception
	{
		AccountInfo accountInfo=new AccountInfo();
		List<String> rspList=new ArrayList<String>();
		//查询累计天数[1,11)并且猫咪宝金额大于1万元的用户
		accountInfo.setIsReward("0");
		List<AccountInfo> aList=accountInfoMapper.queryMeetThanOne(accountInfo);
		for (AccountInfo a1 : aList)
		{
			if(Integer.parseInt(a1.getAccountId())>0)
			{
				rspList.add(a1.getAccountId());
			}
		}
		System.out.println(rspList);
		if(aList.size()>0){
			accountInfoMapper.editResetIsReward(rspList);
		}
	}

	@Override
	public void setFreedomSubjectCoupon() throws Exception
	{
		AccountInfo accountInfo=new AccountInfo();
		List<String> rspList=new ArrayList<String>();
		//查询累计天数小于11并且猫咪宝金额大于1万元的用户
		accountInfo.setIsReward("10");
		List<AccountInfo> aList=accountInfoMapper.queryMeetThanOne(accountInfo);
		for (AccountInfo a1 : aList)
		{
			if(Integer.parseInt(a1.getAccountId())>0)
			{
				rspList.add(a1.getAccountId());
			}
		}
		System.out.println(rspList);
		if(aList.size()>0){
			accountInfoMapper.editPlusIsReward(rspList);
		}
	}

	@Override
	public void setFreedomsubjectOverZero() throws Exception
	{
		//查询所有猫咪宝余额大于0的用户
		AccountInfo accountInfo=new AccountInfo();
		List<AccountInfo> rspList=accountInfoMapper.queryAllUser(accountInfo);
		if(rspList.size()>0)
		{
			//查询bean
			CapitalBean capitalBean=new CapitalBean();
			//修改bean
			AccountCapital cBean=new AccountCapital();
			for (AccountInfo aBean : rspList)
			{
				capitalBean.setAccountId(aBean.getAccountId());
				//------------------将猫咪宝余额转到用户余额------------------
				//查询用户金额
				capitalBean=capitalMapper.queryCapitalById(capitalBean);
				//cBean.setInvestmentMoney(MoneyUtils.formatFloatNumber((iMoney+yMoney)*100));
				double w=(capitalBean.getFreedomMoney()+capitalBean.getWithdrawMoney())*100;
				cBean.setWithdrawMoney((MoneyUtils.formatFloatNumber(w)));
				cBean.setFreedomMoney(Constants.DEVIL_NUM_ZERO);
				cBean.setAccountId(aBean.getAccountId());
				capitalMapper.editAccountCapitalById(cBean);
			}
		}
		
	}

}
