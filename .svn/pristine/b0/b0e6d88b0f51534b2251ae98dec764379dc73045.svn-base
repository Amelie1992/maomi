package com.xed.financing.wxgzh.service.savings.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.savings.SavingsMapper;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.savings.SavingsBean;
import com.xed.financing.wxgzh.service.savings.SavingsService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.MathRandom;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

@Service
@Transactional
public class SavingsServiceImpl implements SavingsService
{
	@Autowired
	private AccountInfoMapper accountInfoMapper;
	
	@Autowired
	private SavingsMapper savingsMapper;
	
	@Autowired
	private MessageMapper messageMapper;
	
	@Override
	public SavingsBean findAllMonetById(SavingsBean savingsBean) throws SQLException
	{
		return savingsMapper.findAllMonetById(savingsBean);
	}

	@Override
	public String addSavingsRecord(String accountId, String money, String type, Integer multiple) throws SQLException
	{
		//添加猫咪储蓄记录
		SavingsBean savingsBean = new SavingsBean();
		savingsBean.setAccountId(accountId);
		//添加消息
		MessageBean outMessageBean = new MessageBean();
		
		//猫咪优惠券有效期
		String savingsValidity = Constants.SAVINGSVALIDITY;
		
		//投资金额
		int imoney;
		String savingsMoney = "";
		if(StringTools.isNullOrEmpty(money))
			imoney=0;
		else
			imoney=Integer.parseInt(money);
		
		if(type.equals("0")){
			if(imoney < 1000 && imoney >= 0){
				savingsMoney = "" + (MathRandom.getRandom(4, 8) * multiple);
			}else if(imoney < 10000 && imoney >= 1000){
				savingsMoney = "" + (MathRandom.getRandom(30, 70) * multiple);
			}else if(imoney >= 10000){
				savingsMoney = "" + (MathRandom.getRandom(400, 800) * multiple);
			}
			
			String telephone = (accountInfoMapper.getAccountInfo(accountId)).getTelephone();
			
			savingsBean.setSavingsMoney(savingsMoney);	
			savingsBean.setRemark("用户" + telephone + "投资" + money + "元，获得猫咪储蓄金" + MoneyUtils.changeFToY(savingsMoney) + "元");
			savingsBean.setSavingsFrom("0");
			savingsBean.setSavingsType("0");
			savingsBean.setSavingsValidity(savingsValidity);
			
			//添加消息
			outMessageBean.setAccountId(accountId);
			outMessageBean.setMsgTitle("猫咪储蓄");
			outMessageBean.setMsgContent("您获得" + MoneyUtils.changeFToY(savingsMoney) + "元猫咪储蓄金额。");
		}else if(type.equals("1")){
			savingsBean.setSavingsMoney(money);	
			savingsBean.setRemark("注册送猫咪储蓄金" + MoneyUtils.changeFToY(money) + "元");
			savingsBean.setSavingsFrom("1");
			//标记为已使用过的
			savingsBean.setSavingsType("1");
			savingsBean.setSavingsValidity(savingsValidity);
			
			//添加消息
			outMessageBean.setAccountId(accountId);
			outMessageBean.setMsgTitle("猫咪储蓄注册");
			outMessageBean.setMsgContent("注册成功，您获得" + MoneyUtils.changeFToY(money) + "元猫咪储蓄金额，已存入猫咪储蓄罐，请注意查收。");
		}else if(type.equals("2")){
			//赠送
			savingsBean.setSavingsMoney(money);	
			savingsBean.setRemark("获得好友赠送猫咪储蓄金" + MoneyUtils.changeFToY(money) + "元");
			savingsBean.setSavingsFrom("2");
			//标记为已使用过的
			savingsBean.setSavingsType("1");
			savingsBean.setSavingsValidity(savingsValidity);
			
			//添加消息
			outMessageBean.setAccountId(accountId);
			outMessageBean.setMsgTitle("猫咪储蓄好友赠送");
			outMessageBean.setMsgContent("您收到好友赠送的猫咪储蓄金：" + MoneyUtils.changeFToY(money) + "元，已存入猫咪储蓄罐,请注意查收。");
		}
		
		messageMapper.addMessageInfo(outMessageBean);
		
		return savingsMapper.addSavingsRecord(savingsBean) > 0 ? "addsuccess" : "addfail";
	}

	@Override
	public Integer updateGiveAccountId(SavingsBean savingsBean) throws SQLException
	{
		return savingsMapper.updateGiveAccountId(savingsBean);
	}
	
	@Override
	public Integer updateGiveAccountIdno(SavingsBean savingsBean) throws SQLException
	{
		return savingsMapper.updateGiveAccountIdno(savingsBean);
	}


	@Override
	public Integer updateWithdrawalsType(SavingsBean savingsBean) throws SQLException
	{
		return savingsMapper.updateWithdrawalsType(savingsBean);
	}

	@Override
	public Integer updateUseType(SavingsBean savingsBean) throws SQLException
	{
		return savingsMapper.updateUseType(savingsBean);
	}

	@Override
	public SavingsBean findSavingsNearest(SavingsBean savingsBean) throws SQLException
	{
		return savingsMapper.findSavingsNearest(savingsBean);
	}

	@Override
	public List<SavingsBean> findNotUsed(SavingsBean savingsBean) throws SQLException
	{
		return savingsMapper.findNotUsed(savingsBean);
	}

	@Override
	public List<SavingsBean> findSavingsOther(SavingsBean savingsBean) throws SQLException
	{
		return savingsMapper.findSavingsOther(savingsBean);
	}

	@Override
	public SavingsBean findSavingsInfo(SavingsBean savingsBean) throws SQLException
	{
		return savingsMapper.findSavingsInfo(savingsBean);
	}

	@Override
	public Integer updateSavingsValidaty() throws SQLException
	{
		return savingsMapper.updateSavingsValidaty();
	}

	@Override
	public boolean findGivedRedp(String accountId) throws SQLException
	{
		return savingsMapper.findGivedRedp(accountId) > 0;
	}

	@Override
	public List<SavingsBean> findGivedRedpList(String accountId) throws SQLException
	{
		return savingsMapper.findGivedRedpList(accountId);
	}

}
