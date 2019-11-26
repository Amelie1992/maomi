/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.message.MessageServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月14日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.msgPrompt.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.msgPrompt.MessagePromptMapper;
import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.messagecode.MessageCodeService;
import com.xed.financing.wxgzh.service.msgPrompt.MessagePromptService;
import com.xed.financing.wxgzh.util.MobileMessagePrompt;

/**
 * @className:com.xed.financing.wxgzh.service.message.MessageServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月14日 下午4:02:51
 * @author:Qian Tao
 */
@Service
public class MessagePromptServiceImpl implements MessagePromptService
{

	@Resource
	private MessagePromptMapper messagePromptMapper;

	@Autowired
	private MessageCodeService messageCodeService;
	
	
	public void promptSettlement() throws Exception
	{
		
			//-------------------------------查找提前3天的提示的投标信息----------------------------------
			//标的结算日期前3天提示前5天未登录的用户
			List<AccountInvest> advancePrompt =  messagePromptMapper.advancePrompt();
			

			//-------------------------------查找当天提示的投标信息----------------------------------
			//标的结算日当天提示
			List<AccountInvest> sameDayPrompt =  messagePromptMapper.sameDayPrompt();
			

			//-------------------------------查找结算日后提示的投标信息----------------------------------
			//结算后还是未登录的用户,在7、15、30、60 天发送短信提示
			List<AccountInvest> afterwardsPrompt = messagePromptMapper.afterwardsPrompt();
			
			
			//-------------------------------调用发送短信功能----------------------------------------
			
			for (AccountInvest accountInvest : advancePrompt)
			{
				MobileMessagePrompt.msgPrompt(accountInvest.getAccountId(), accountInvest.getSurplusMoney(), accountInvest.getEndTime());
				messageCodeService.addMessage(accountInvest.getAccountId(), "3");
			}
			for (AccountInvest accountInvest : sameDayPrompt)
			{
				MobileMessagePrompt.msgPrompt(accountInvest.getAccountId(), accountInvest.getSurplusMoney(), accountInvest.getEndTime());
				messageCodeService.addMessage(accountInvest.getAccountId(), "3");
			}
			for (AccountInvest accountInvest : afterwardsPrompt)
			{
				MobileMessagePrompt.msgPrompt(accountInvest.getAccountId(), accountInvest.getSurplusMoney(), accountInvest.getEndTime());
				messageCodeService.addMessage(accountInvest.getAccountId(), "3");
			}
			
			
			
			List<SubjectBean> early = messagePromptMapper.getEarlyPrompt();
			
			for (SubjectBean subjectBean : early)
			{
				MobileMessagePrompt.msgEarly(subjectBean.getTelephone(), subjectBean.getSubjectCode(), subjectBean.getRealName());
				messageCodeService.addMessage(subjectBean.getAccountId(), "7");
			}
			
			
			
	}
	
	

}
