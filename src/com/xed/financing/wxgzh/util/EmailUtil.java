/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.EmailUtil
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Elias Zheng
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月24日    Elias Zheng  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.util.Date;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @className:com.xed.financing.wxgzh.util.EmailUtil
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月24日 上午10:16:01
 * @author:Elias Zheng
 */
public class EmailUtil
{
	/**
	 * * 创建一封只包含文本的简单邮件
     *
	 * @Description:
	 * @param session 和服务器交互的会话
	 * @param sendMail 发送人邮箱
	 * @param receiveMail 收件人邮箱
	 * @param userName 收件人姓名
	 * @param title	邮件标题
	 * @param msg 邮件内容
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年3月24日 下午4:15:55
	 */
    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,String userName,String title,String msg) throws Exception {
    	
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人
        message.setFrom(new InternetAddress(sendMail, "猫咪财富", "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, userName, "UTF-8"));

        // 4. Subject: 邮件主题
        message.setSubject(title, "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）
        message.setContent(msg, "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();

        return message;
    }
}
