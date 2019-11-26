/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.message.MessageMapper
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
package com.xed.financing.wxgzh.mapper.messagecode;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.messagecode.MessageCodeBean;


/**
 * @className:com.xed.financing.wxgzh.mapper.message.MessageMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月14日 下午3:51:37
 * @author:Qian Tao
 */
public interface MessageCodeMapper
{
	/**
	 * 添加短信发送机记录
	 * @Description:
	 * @param messageCodeBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年3月19日 下午2:04:49
	 */
	public Integer addMessage(MessageCodeBean messageCodeBean)throws SQLException;
	
	/**
	 * 检查当天短信发送次数
	 * @Description:
	 * @param phone
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年3月19日 下午2:05:04
	 */
	public Integer checkCount(String phone)throws SQLException;
}
