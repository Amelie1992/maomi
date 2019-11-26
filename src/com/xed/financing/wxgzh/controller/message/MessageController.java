/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.MessageController
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
package com.xed.financing.wxgzh.controller.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.message.MessageService;

/**
 * @className:com.xed.financing.wxgzh.controller.MessageController
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月14日 下午4:04:50
 * @author:Qian Tao
 */
@Controller
@RequestMapping("/message")
public class MessageController
{
	@Autowired
	private MessageService messageService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(MessageController.class);
	
	/**
	 * 查询用户信息
	 * @Description:
	 * @param messageBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月14日 下午4:06:32
	 */
	@RequestMapping("/querymessage")
	public String queryAccountMessage(HttpServletRequest request)
	{
		//从session中查询出账户ID
		String accountId = ((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
		MessageBean messageBean =new MessageBean();
		messageBean.setAccountId(accountId);
		try
		{
			request.setAttribute("rspList", messageService.queryAccountMessage(messageBean));
			request.setAttribute("noReadMessage",messageService.countNoRead(messageBean) );
		}
		catch (SQLException e)
		{
			logger.error("查询用户消息异常", e);
		}
		return "message/messagelist";
	}
	
	/**
	 * 详情
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月6日 下午5:12:39
	 */
	@RequestMapping("/detailmessage")
	public String queryAccountMessageById(HttpServletRequest request,String msgId)
	{
		MessageBean messageBean =new MessageBean();
		messageBean.setMsgId(msgId);
		try
		{
			//查询详情
			request.setAttribute("msgBean", messageService.queryAccountMessageById(messageBean));
			
			//置为已读
			messageService.updateMessageStatus(messageBean);
		}
		catch (SQLException e)
		{
			logger.error("查询用户消息异常", e);
		}
		return "message/messagedetail";
	}
	/**
	 * 置为已读
	 * @Description:
	 * @param request
	 * @param creditId
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月14日 下午4:15:41
	 */
	/*@RequestMapping("/updateIsRead")*/
	@ResponseBody
	@RequestMapping(value="/updateIsRead",method=RequestMethod.POST)
	public void updateIsRead(HttpServletResponse response,HttpServletRequest request,String msgId)
	{
		// 设置标识
		String result = "{\"result\":\"-1\"}";
		try
		{
			
			MessageBean messageBean =new MessageBean();
			messageBean.setMsgId(msgId);
			
			//置为已读
			messageService.updateMessageStatus(messageBean);
			result = "{\"result\":"+msgId+"}";
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
			
		}
		catch (SQLException e)
		{
			logger.error("置为已读sql异常！", e );
		}
		catch (IOException e)
		{
			logger.error("置为已读IO异常！", e );
		}
	}
	
	/**
	 * 全部置为已读
	 * @Description:
	 * @param response
	 * @param request
	 * @param accountId
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年7月26日 下午1:54:30
	 */
	/*@RequestMapping("/updateAllIsRead")*/
	@ResponseBody
	@RequestMapping(value="/updateAllIsRead",method=RequestMethod.POST)
	public void updateAllIsRead(HttpServletResponse response,HttpServletRequest request)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		//从session中查询出账户ID
		String accountId = ((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
		try
		{
			
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(accountId);
			
			//置为已读
			messageService.updateMessageStatus(messageBean);
			result = "{\"result\":\"success\"}";
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
			
		}
		catch (SQLException e)
		{
			logger.error("全部置为已读sql异常！", e );
		}
		catch (IOException e)
		{
			logger.error("全部置为已读IO异常！", e );
		}
	}
	
	/**
	 * 清空消息
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月14日 下午4:44:15
	 */
	@RequestMapping("/delMessage")
	public void delMessage(HttpServletResponse response,HttpServletRequest request)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		try
		{
			//从session中查询出账户ID
			String accountId = ((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(accountId);
			messageService.delAccountMessage(messageBean);
			result = "{\"result\":\"success\"}";
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (SQLException e)
		{
			logger.error("清空消息SQL异常", e);
		}
		catch (IOException e)
		{
			logger.error("清空消息IO异常", e);
		}
	}
}
