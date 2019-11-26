/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.messageInterfaceController.MessageInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:duanjy
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月17日    duanjy  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.message;


import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.controller.message.MessageController;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.message.MessageService;

/**
 * 消息控制层
 * @className:com.xed.financing.wxgzh.controller.intface.messageInterfaceController.MessageInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月17日 上午11:11:17
 * @author:duanjy
 */
@Controller
@RequestMapping("/ios/message")
public class MessageInterfaceController
{
	@Autowired
	private MessageService messageService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(MessageController.class);
	
	/**
	 * 前往消息中心
	 * @Description:/ios/message/querymessage?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 上午10:40:43
	 */
	@RequestMapping("/querymessage")
	@ResponseBody
	public JSONObject queryAccountMessage(String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		
		String msg = "前往消息中心失败";
		Integer code = 300;
		
		MessageBean messageBean =new MessageBean();
		messageBean.setAccountId(accountId);
		try
		{
			List<MessageBean> messageBeans = messageService.queryAccountMessage(messageBean);
			
			for (MessageBean messageBean2 : messageBeans)
			{
				String msgContent = messageBean2.getMsgContent();
				Boolean status = msgContent.contains("<a");
				if(status)
				{
					//截取a标签里面的字符串
					String msg1 = msgContent.substring(0, msgContent.indexOf("<a"));//前
					String msg2 = msgContent.substring(msgContent.indexOf(">")+1,msgContent.lastIndexOf("<"));//中
					String msg3 = msgContent.substring(msgContent.indexOf("/a>")+3,msgContent.length());//后
					//将截取后字符串拼接
					msgContent = msg1+msg2+msg2;
					messageBean2.setMsgContent(msgContent); 
				}
			}
			objs.put("rspList", messageBeans);
			objs.put("noReadMessage",messageService.countNoRead(messageBean));
			obj.put("data", objs);
			msg = "前往消息中心成功";
			code = 200;
		}
		catch (SQLException e)
		{
			logger.error("查询用户消息异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 查看消息详情
	 * @Description:/ios/message/detailmessage?msgId=
	 * @param request
	 * @param msgId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月17日 上午11:24:28
	 */
	@RequestMapping("/detailmessage")
	@ResponseBody
	public JSONObject queryAccountMessageById(String msgId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		
		String msg = "查看消息详情失败";
		Integer code = 300;
		
		MessageBean messageBean = new MessageBean();
  		messageBean.setMsgId(msgId);
		System.out.println("messageBean2222:"+messageBean);
		try
		{
			//查询详情
			messageBean = messageService.queryAccountMessageById(messageBean);
			
			//置为已读
			messageService.updateMessageStatus(messageBean);
			
			//获得消息内容
			String msgContent = messageBean.getMsgContent();
			
			//截取a标签里面的字符串
			if (msgContent.indexOf("<a") > -1)
			{
				String msg1 = msgContent.substring(0, msgContent.indexOf("<a"));//前
				String msg2 = msgContent.substring(msgContent.indexOf(">")+1,msgContent.lastIndexOf("<"));//中
				String msg3 = msgContent.substring(msgContent.indexOf("/a>")+3,msgContent.length());//后
				
				msgContent = msg1+msg2+msg3;
			}
			messageBean.setMsgContent(msgContent);
			
			objs.put("msgBean", messageBean);
			obj.put("data", objs);
			msg = "查看消息详情成功";
			code = 200;
		}
		catch (Exception e)
		{
			// TODO: handle exception
			logger.error("查看消息详情异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 设置一条已读
	 * @Description:/ios/message/updateIsRead?accountId=&&msgId=
	 * @param accountId
	 * @param msgId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月17日 下午3:12:31
	 */
	@RequestMapping("/updateIsRead")
	@ResponseBody
	public JSONObject updateIsRead(String accountId,String msgId)
	{
		JSONObject obj = new JSONObject();
		MessageBean messageBean =new MessageBean();
		
		String msg = "设置已读失败";
		Integer code = 300;
		
		messageBean.setAccountId(accountId);
		messageBean.setMsgId(msgId);
		try
		{
			//置为已读
			messageService.updateMessageStatus(messageBean);
			
			msg = "设置已读成功";
			code = 200;
		}
		catch (Exception e)
		{
			logger.error("置为已读sql异常！", e );
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 全部设置已读
	 * @Description:/ios/message/updateAllIsRead?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月24日 下午4:02:58
	 */
	@RequestMapping("/updateAllIsRead")
	@ResponseBody
	public JSONObject updateAllIsRead(String accountId)
	{
		JSONObject obj = new JSONObject();
		MessageBean messageBean =new MessageBean();
		
		String msg = "全部设置已读失败";
		Integer code = 300;
		messageBean.setAccountId(accountId);
		try
		{
			//置为已读
			messageService.updateMessageStatus(messageBean);
			msg = "全部设置已读成功";
			code = 200;
		}
		catch (Exception e)
		{
			logger.error("全部置为已读sql异常！", e );
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 清空
	 * @Description:/ios/message/delMessage?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月17日 下午3:33:49
	 */
	@RequestMapping("/delMessage")
	@ResponseBody
	public JSONObject delMessage(String accountId)
	{
		JSONObject obj = new JSONObject();
		
		String msg = "清空失败";
		Integer code = 300;
		
		MessageBean messageBean =new MessageBean();
		messageBean.setAccountId(accountId);
		try
		{
			//清空消息
			messageService.delAccountMessage(messageBean);
			
			msg = "清空成功";
			code = 200;
		}
		catch (SQLException e)
		{
			logger.error("清空消息SQL异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
}
