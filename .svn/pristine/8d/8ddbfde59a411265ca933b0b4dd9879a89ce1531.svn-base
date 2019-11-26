/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.accountaddress.AccountInfoAddressController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月22日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.accountaddress;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountaddress.AccountAddressBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.city.CityBean;
import com.xed.financing.wxgzh.service.accountaddress.AccountAddressService;
import com.xed.financing.wxgzh.service.city.CityService;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 收货地址控制层
 * @className:com.xed.financing.wxgzh.controller.accountaddress.AccountInfoAddressController
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月22日 下午3:40:45
 * @author:QT
 */
@Controller
@RequestMapping("/accountaddress")
public class AccountInfoAddressController
{
	@Autowired
	private AccountAddressService accountAddressService;
	
	@Autowired
	private CityService cityService;
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AccountInfoAddressController.class);
	
	/**
	 * 跳转个人收货地址
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月22日 下午3:43:12
	 */
	@RequestMapping("/toaccountaddress")
	public String toAccountAddress(HttpServletRequest request)
	{
		try
		{
			
			String flag="edit";
			String accountId=((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			AccountAddressBean accountAddressBean=new AccountAddressBean();
			accountAddressBean.setAccountId(accountId);
			accountAddressBean=accountAddressService.queryAccountAddressDefaultById(accountAddressBean);
			request.setAttribute("aBean", accountAddressBean);
			if(StringTools.isNullOrEmpty(accountAddressBean))
			{
				flag="save";
			}
			else
			{
				//市
				List<CityBean> cityList= cityService.queryCityBySubCode(accountAddressBean.getProvince());
				request.setAttribute("cityList", cityList);
				
				//区
				List<CityBean> quList= cityService.queryCityBySubCode(accountAddressBean.getCity());
				request.setAttribute("quList", quList);
			}
			request.setAttribute("flag", flag);
			
			// 获得省份信息
			List<CityBean> provinceList= cityService.queryCityBySubCode("-1");
			request.setAttribute("provinceList", provinceList);
			
			
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "loginregister/accountaddress";
	}
	
	/**
	 * 保存地址
	 * @Description:
	 * @param accountAddressBean
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月22日 下午3:58:57
	 */
	@ResponseBody
	@RequestMapping(value="/saveAddress",method=RequestMethod.POST)
	public void saveAddress(HttpServletRequest request, HttpServletResponse response,AccountAddressBean aAddressBean)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		response.setContentType("application/json");
		String accountId=((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		try
		{
			AccountAddressBean accountAddressBean=new AccountAddressBean();
			accountAddressBean.setAccountId(accountId);
			accountAddressBean=accountAddressService.queryAccountAddressDefaultById(accountAddressBean);
			aAddressBean.setAccountId(accountId);
			if(StringTools.isNullOrEmpty(accountAddressBean))
			{
				//保存
				aAddressBean.setIsDefault("1");
				accountAddressService.insertAccountAddress(aAddressBean);
				result = "{\"result\":\"successsave\"}";
			}
			else
			{
				//修改
				accountAddressService.editAccountAddress(aAddressBean);
				result = "{\"result\":\"successedit\"}";
			}
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
