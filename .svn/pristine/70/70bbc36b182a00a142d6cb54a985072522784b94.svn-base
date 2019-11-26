/**
 * Copyright (C) 2017 FZJT Co.Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.emailcheck.EmaiCheckController
 * @description:邮箱激活控制器
 * 
 * @version:v1.0.0 
 * @author:WangLin
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月20日    WangLin  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.emailcheck;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.emailcheck.EmailCheck;
import com.xed.financing.wxgzh.service.emailcheck.EmailCheckService;
import com.xed.financing.wxgzh.service.integralscore.IntegralScoreService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.EmailUtil;
import com.xed.financing.wxgzh.util.GetUUID;

/**
 * @className:com.xed.financing.wxgzh.controller.emailcheck.EmaiCheckController
 * @description:邮箱激活控制器
 * @version:v1.0.0
 * @date:2017年3月20日 上午11:42:13
 * @author:WangLin
 */
@Controller
@RequestMapping("/emailcheck")
public class EmailCheckController
{
	@Autowired
	private EmailCheckService emailCheckService;
	
	@Autowired
	private IntegralScoreService integralScoreService;

	@Autowired
	private ParamService paramService;

	/**
	 * 日子
	 */
	private Logger logger = Logger.getLogger(EmailCheckController.class);

	/**
	 * 
	 * @Description:判断用户是否认证过
	 * @param model
	 * @param accountId
	 * @return 已认证去已认证页面，未认证，去认证页面
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月20日 下午2:50:39
	 */
	@RequestMapping("/judgeEmailIsVerification")
	public String judgeEmailIsVerification(HttpServletRequest request, Model model)
	{

		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();

		Integer status = -1;
		try
		{
			status = emailCheckService.getAccountById(accountId).getIsEmailValidate();
			model.addAttribute("accountEmail", emailCheckService.getAccountById(accountId).getAccountEmail());
			model.addAttribute("emailStatus", status);
		}
		catch (SQLException e)
		{
			logger.error("获取验证状态异常!", e);
		}
		String resu = "";
		if (status == 1)
		{
			resu = "EmailCheck/alreadyVerification";
		}
		else
		{
			resu = "EmailCheck/verification";
		}
		return resu;
	}

	/**
	 * 
	 * @Description:添加邮箱认证信息
	 * @param emailCheck
	 * @version:v1.0
	 * @author:WangLin
	 * @throws Exception
	 * @date:2017年3月20日 下午5:16:59
	 */
	/*@RequestMapping("/saveVerInfo")*/
	@ResponseBody
	@RequestMapping(value="/saveVerInfo",method=RequestMethod.POST)
	public Map<String, Object> saveVerInfo(HttpServletRequest request, String email) throws Exception
	{
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();

		EmailCheck emailCheck = new EmailCheck();
		emailCheck.setAccountEmail(email);
		emailCheck.setAccountId(accountId);
		// accountId预留------------------------------------------

		// 获取4位邮箱认证码
		String code = GetUUID.getMath();

		// 验证码内容
		emailCheck.setCodeContent("您的邮箱验证码为:" + code);

		// 验证码类型默认0：邮箱认证
		emailCheck.setCodeType(Constants.DEVIL_NUM_ZERO);

		// 验证码
		emailCheck.setCodeMsg(code);
		String codeId = "";
		try
		{
			emailCheckService.saveVerInfo(emailCheck);
			codeId = String.valueOf(emailCheckService.getCodeIdByMsg(emailCheck));
		}
		catch (SQLException e)
		{
			logger.error("添加认证信息异常!", e);
		}

		// 使用邮箱发送验证码
		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", paramService.getParamVal("EMAIL_SMTP")); // 发件人的邮箱的SMTP服务器地址
		props.setProperty("mail.smtp.auth", "true"); // 需要请求认证
		props.setProperty("mail.smtp.port", "587");

		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log

		// 3. 创建一封邮件
		String msg = "尊贵的猫咪财富用户,您的邮箱验证码为:" + code + ", 请于" + paramService.getParamVal("EMAIL_CODE_TIME") + "分钟内验证, 谢谢!";
		MimeMessage message = EmailUtil.createMimeMessage(session, paramService.getParamVal("EMAIL_NAME"), email,
				"尊贵的猫咪财富用户", "猫咪财富邮箱确认", msg);

		// 4. 根据 Session 获取邮件传输对象
		Transport transport = session.getTransport();

		// 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
		transport.connect(paramService.getParamVal("EMAIL_NAME"), paramService.getParamVal("EMAIL_CODE"));

		// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人,
		// 抄送人, 密送人
		transport.sendMessage(message, message.getAllRecipients());

		// 7. 关闭连接
		transport.close();

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("codeId", codeId);
		resultMap.put("codeTime", paramService.getParamVal("EMAIL_CODE_TIME"));
		return resultMap;
	}

	/**
	 * 
	 * @Description:验证码失效
	 * @param codeId
	 * @param model
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月20日 下午8:38:17
	 */
	public Integer getDateDiff(EmailCheck emailCheck, String enterCode)
	{
		int flag = -1;// 默认验证码不匹配
		Integer s = -1;
		try
		{
			// 先验证是否超时
			s = emailCheckService.getTimeDiff(Integer.parseInt(emailCheck.getCodeId()));
			if (s > Integer.parseInt(paramService.getParamVal("EMAIL_CODE_TIME")))
			{
				flag = -2;// 超时
			}
			else
			{
				// 验证码一致匹配
				if (enterCode.equals(String.valueOf(emailCheckService.getCodeMsg(emailCheck))))
				{
					flag = 0;
				}
			}
		}
		catch (SQLException e)
		{
			logger.error("获取验证码ID异常!", e);
			flag = -3;
		}
		return flag;
	}

	/**
	 * 
	 * @Description:验证码比较
	 * @param codeId
	 *            ：验证码ID
	 * @param codeMsg
	 *            : 用户输入的验证码
	 * @param model
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月21日 下午3:52:58
	 */
	/*@RequestMapping("/judgmentCodeMsg")*/
	@ResponseBody
	@RequestMapping(value="/judgmentCodeMsg",method=RequestMethod.POST)
	public Map<String, Object> judgmentCodeMsg(HttpServletRequest request, String enterCode, String accountEmail,
			String codeId)
	{

		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();

		// 判断标识
		int flag = -1;
		// 比较验证码
		EmailCheck emailCheck = new EmailCheck();

		emailCheck.setIsEmailValidate(1);
		emailCheck.setAccountEmail(accountEmail);
		emailCheck.setAccountId(accountId);
		emailCheck.setCodeId(codeId);
		try
		{
			emailCheck.setCodeMsg(String.valueOf(enterCode));

			flag = getDateDiff(emailCheck, enterCode);
			
			if(flag == 0){
				emailCheckService.updateIsEmailValidate(emailCheck);
				emailCheckService.updateAccountEmail(emailCheck);
				integralScoreService.perfectInformationIntegralReward(request);
			}
		}
		catch (Exception e)
		{
			logger.error("邮箱更新状态异常!", e);
			flag = -3;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("flag", flag);
		return resultMap;
	}

}
