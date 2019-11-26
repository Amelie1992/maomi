/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.accountInfo.AccountInfoController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月23日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.autobid;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.autobid.AutobidInfo;
import com.xed.financing.wxgzh.service.autobid.AutobidService;

/**
 * 
 * @className:com.xed.financing.wxgzh.controller.autobid.AutoBidController
 * @description:
 * @version:v1.0.0
 * @date:2017年4月10日 上午10:14:59
 * @author:WangJun
 */
@Controller
@RequestMapping("/autobid")
public class AutoBidController
{
	@Autowired
	private AutobidService autobidService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AutoBidController.class);

	/**
	 * 去自动投标页
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年4月11日 下午1:33:37
	 */
	@RequestMapping("/toautobid")
	public String toautobid(HttpServletRequest request)
	{
		try
		{
			autobidService.getAutobid(request);

		}
		catch (Exception e)
		{
			logger.error("查询用户自动投标异常", e);
		}

		// 跳转页面
		return "autobid/autobid";
	}
	
	
	/**
	 * 设置自动投标
	 * @Description:
	 * @param request
	 * @param autobidInfo
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月11日 上午9:46:54
	 */
	@ResponseBody
	@RequestMapping(value="/addAutobid",method=RequestMethod.POST)
	public Map<String, Object> addAutobid(HttpServletRequest request,AutobidInfo autobidInfo)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		AccountInfo accountInfo= (AccountInfo) request.getSession().getAttribute("account");
		try
		{
			 autobidService.addAutobid(accountInfo.getAccountId(),autobidInfo, map);

		}
		catch (Exception e)
		{
			logger.error("查询用户自动投标异常", e);
		}
		
		
		return map;
	}
	/**
	 * 去查看规则页面
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年4月11日 下午1:33:57
	 */
	@RequestMapping("/goRule")
	public String goRule(HttpServletRequest request)
	{
		
		return "autobid/rule";
	}
	
	
	/**
	 * 取消自动投标
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月11日 上午9:47:16
	 */
	@ResponseBody
	@RequestMapping(value="/cancelAutobid",method=RequestMethod.POST)
	public Map<String, Object> cancelAutobid(HttpServletRequest request)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		AccountInfo accountInfo= (AccountInfo) request.getSession().getAttribute("account");
		try
		{
			autobidService.cancelAutobid(accountInfo.getAccountId(), map);
		}
		catch (Exception e)
		{
			logger.error("取消用户自动投标异常", e);
		}
		
		
		return map;
	}
	
	/**
	 * 去个人信息设置
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月23日 下午3:46:35
	 *//*
	@RequestMapping("/saveAutoBid")	
	public String saveAutoBid(HttpServletRequest request, AutobidInfo autoBidBean, String money)
	{
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		try
		{

			// 查询数据库是否存在
			Integer num = service.getAutobidList(accountId);
			autoBidBean.setAccountId(accountId);
			// 存在修改不存在添加
			if (num > Integer.parseInt(Constants.DEVIL_NUM_ZERO))
			{
				service.delete(autoBidBean);

			}
			// 不存在则添加
			service.saveAutobid(autoBidBean);
			service.updateAutobidInfo(autoBidBean);

			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			CapitalBean capBean = capMapper.queryCapitalById(capitalBean);

			AccountCapital accountBean = new AccountCapital();

			accountBean.setFreezeMoney(MoneyUtils.removeDecimalPoint(Double.parseDouble(money) * 100).toString());
			int widMoney = MoneyUtils.removeDecimalPoint(capBean.getWithdrawMoney())
					+ MoneyUtils.removeDecimalPoint(capBean.getFreezeMoney())
					- MoneyUtils.removeDecimalPoint((Double.parseDouble(money)));
			accountBean.setWithdrawMoney(String.valueOf(widMoney * 100));
			accountBean.setAccountId(accountId);
			capMapper.updateCapInfo(accountBean);

		}
		catch (SQLException e)
		{
			logger.error("获得账号信息异常", e);
		}
		return querySubject(request);
	}*/

}
