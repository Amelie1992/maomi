/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.pay.PayExportInfoServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年5月26日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.pay.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.pay.PayExportInfoMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.pay.PayExportInfoBean;
import com.xed.financing.wxgzh.service.pay.PayExportInfoService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * @className:com.xed.financing.wxgzh.service.pay.PayExportInfoServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月26日 下午1:58:45
 * @author:Qian Tao
 */
@Service
public class PayExportInfoServiceImpl implements PayExportInfoService
{
	@Autowired
	private PayExportInfoMapper payExportInfoMapper;
	
	@Resource
	private CapitalMapper capitalMapper;
	/**
	 * 消息mapper
	 */
	@Resource
	private MessageMapper messageMapper;

	@Resource
	private BondTransferMapper bondTransferMapper;
	
	@Resource
	private AccountInfoMapper accountInfoMapper;
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.pay.PayExportInfoService#savePayExport(com.xed.financing.wxgzh.model.pay.PayExportInfoBean)
	 */
	@Override
	public int savePayExport(PayExportInfoBean payExportInfoBean) throws SQLException
	{
		return payExportInfoMapper.savePayExport(payExportInfoBean);
	}
	@Override
	public boolean updatePayExportStatus(PayExportInfoBean payExportInfoBean) throws SQLException
	{
		return payExportInfoMapper.updatePayExportStatus(payExportInfoBean);
	}
	@Override
	public List<PayExportInfoBean> queryPayExportAll() throws SQLException
	{
		// TODO Auto-generated method stub
		return payExportInfoMapper.queryPayExportAll();
	}
	@Override
	public String queryAccountId(PayExportInfoBean payExportInfoBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return payExportInfoMapper.queryAccountId(payExportInfoBean);
	}
	
	@Transactional
	@Override
	public Boolean toPayExport(String telephones, String amt) throws Exception
	{
		try
		{
			AccountInfo account = accountInfoMapper.getAccountInfoByPhone(telephones);
			
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(account.getAccountId());
			// 查询用户总金额
			capitalBean = capitalMapper.queryCapitalById(capitalBean);
			AccountCapital acapt = new AccountCapital();
			// 金账户金额 分
			int wMoney = MoneyUtils.removeDecimalPoint(capitalBean.getNoWithdrawMoney() * 100);

			System.out.println("用户总金额为" + wMoney);
			acapt.setFreezeMoney(String.valueOf(MoneyUtils.removeDecimalPoint(capitalBean.getFreezeMoney()*100)));
			acapt.setInvestmentMoney(String.valueOf(MoneyUtils.removeDecimalPoint(capitalBean.getInvestmentMoney()*100)));
			acapt.setWithdrawMoney(String.valueOf(MoneyUtils.removeDecimalPoint(capitalBean.getWithdrawMoney()*100)));
			acapt.setNoWithdrawMoney(String.valueOf(wMoney + Integer.parseInt(amt)));
			acapt.setAccountId(account.getAccountId());

			System.out.println("充值后的总金额为：" + acapt.getNoWithdrawMoney());
			capitalMapper.editAccountCapitalById(acapt);
			System.out.println("修改执行完毕");
			// 添加金额明细***********************
			CapitalDetail capitalDetail = new CapitalDetail();
			capitalDetail.setAccountId(account.getAccountId());
			capitalDetail.setMoney(amt);

			// 交易类型(0:储蓄卡充值 1:微信充值 2:信用卡充值 3:投资投标 4:投资投标收益 5:提现)
			capitalDetail.setType(Constants.DEVIL_NUM_ZERO);

			// 金额收支(0:收入 1:支出)
			capitalDetail.setInExpend(Constants.DEVIL_NUM_ZERO);
			capitalDetail.setRemark("充值" + (Double.parseDouble(amt) / 100) + "元");
			bondTransferMapper.addCapital(capitalDetail);

			// 添加消息
			MessageBean messageBean = new MessageBean();
			messageBean.setAccountId(account.getAccountId());
			messageBean.setMsgTitle("充值成功");
			messageBean.setMsgContent("您成功充值" + (Double.parseDouble(amt) / 100) + "元");
			messageMapper.addMessageInfo(messageBean);
		}
		catch (Exception e)
		{
			
		}
		return null;
	}

	
	
	
}
