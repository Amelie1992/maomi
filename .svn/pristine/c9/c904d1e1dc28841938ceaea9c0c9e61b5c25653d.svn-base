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
package com.xed.financing.wxgzh.mapper.message;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.message.CompanyMessageBean;
import com.xed.financing.wxgzh.model.message.MessageBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.message.MessageMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月14日 下午3:51:37
 * @author:Qian Tao
 */
public interface MessageMapper
{
	/**
	 * 查询用户消息列表
	 * @Description:
	 * @param messageBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月14日 下午3:54:12
	 */
	public List<MessageBean> queryAccountMessage(MessageBean messageBean) throws SQLException;
	
	/**
	 * 查询用户消息详情
	 * @Description:
	 * @param messageBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月14日 下午3:54:12
	 */
	public MessageBean queryAccountMessageById(MessageBean messageBean) throws SQLException;
	
	/**
	 * 将消息置为已读
	 * @Description:
	 * @param messageBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月14日 下午4:01:50
	 */
	public void updateMessageStatus(MessageBean messageBean) throws SQLException;
	
	/**
	 * 清空消息
	 * @Description:
	 * @param messageBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月14日 下午4:42:03
	 */
	public void delAccountMessage(MessageBean messageBean) throws SQLException;
	
	/**
	 * 添加消息
	 * @Description:
	 * @param messageBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月18日 下午3:40:19
	 */
	public void addMessageInfo(MessageBean messageBean) throws SQLException;
	
	/**
	 * 添加企业用户消息记录
	 * @Description:
	 * @param companyMessageBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年7月20日 上午11:09:31
	 */
	public void addCompanyMessage(CompanyMessageBean companyMessageBean)throws SQLException;
	
	/**
	 * 查询用户未读消息数量
	 * @Description:
	 * @param messageBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月18日 下午4:48:09
	 */
	public Integer countNoRead(MessageBean messageBean) throws SQLException;
	
	/**
	 * 
	 * 根据消息标题查询用户记录
	 * @Description:
	 * @param messageBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年12月21日 下午7:15:36
	 */
	public Integer countRecordByTitle(MessageBean messageBean) throws SQLException;
}
