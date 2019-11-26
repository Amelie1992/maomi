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
package com.xed.financing.wxgzh.service.message.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.model.message.CompanyMessageBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.message.MessageService;

/**
 * @className:com.xed.financing.wxgzh.service.message.MessageServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月14日 下午4:02:51
 * @author:Qian Tao
 */
@Service
public class MessageServiceImpl implements MessageService
{

	@Resource
	private MessageMapper messageMapper;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(MessageServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.message.MessageService#queryAccountMessage(com.xed.financing.wxgzh.model.message.MessageBean)
	 */
	@Override
	public List<MessageBean> queryAccountMessage(MessageBean messageBean) throws SQLException
	{
		return messageMapper.queryAccountMessage(messageBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.message.MessageService#updateMessageStatus(com.xed.financing.wxgzh.model.message.MessageBean)
	 */
	@Override
	public void updateMessageStatus(MessageBean messageBean) throws SQLException
	{
		messageMapper.updateMessageStatus(messageBean);
	}

	@Override
	public void delAccountMessage(MessageBean messageBean) throws SQLException
	{
		messageMapper.delAccountMessage(messageBean);
	}

	@Override
	public Integer countNoRead(MessageBean messageBean) throws SQLException
	{
		return messageMapper.countNoRead(messageBean);
	}

	@Override
	public MessageBean queryAccountMessageById(MessageBean messageBean) throws SQLException
	{
		return messageMapper.queryAccountMessageById(messageBean);
	}

	@Override
	public void addCompanyMessage(CompanyMessageBean companyMessageBean) throws SQLException
	{
		messageMapper.addCompanyMessage(companyMessageBean);
	}

	@Override
	public void addMessageInfo(MessageBean messageBean) throws SQLException
	{
		messageMapper.addMessageInfo(messageBean);
	}

	@Override
	public Integer countRecordByTitle(MessageBean messageBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return messageMapper.countRecordByTitle(messageBean);
	}

}
