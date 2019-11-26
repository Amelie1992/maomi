/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.messagecode.impl.MessageCodeServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年3月19日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.messagecode.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.messagecode.MessageCodeMapper;
import com.xed.financing.wxgzh.model.messagecode.MessageCodeBean;
import com.xed.financing.wxgzh.service.messagecode.MessageCodeService;

/**
 * @className:com.xed.financing.wxgzh.service.messagecode.impl.MessageCodeServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2018年3月19日 上午11:18:00
 * @author:ZhangJun
 */
@Service
public class MessageCodeServiceImpl implements MessageCodeService
{
	@Resource
	private MessageCodeMapper messageCodeMapper;
	

	@Override
	public Integer addMessage(String phone, String type) throws Exception
	{
		MessageCodeBean messageCodeBean = new MessageCodeBean();
		messageCodeBean.setPhone(phone);
		messageCodeBean.setType(type);
		return messageCodeMapper.addMessage(messageCodeBean);
	}


	@Override
	public Boolean checkCount(String phone) throws Exception
	{
		
		return 10>messageCodeMapper.checkCount(phone);
	}

}
