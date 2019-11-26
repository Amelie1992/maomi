/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.accountInfoAddress.AccountInfoAddressInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:duanjy
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月13日    duanjy  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.accountInfoAddress;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Pattern;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.controller.accountaddress.AccountInfoAddressController;
import com.xed.financing.wxgzh.model.accountaddress.AccountAddressBean;
import com.xed.financing.wxgzh.model.city.CityBean;
import com.xed.financing.wxgzh.service.accountaddress.AccountAddressService;
import com.xed.financing.wxgzh.service.city.CityService;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 收货地址控制层接口
 * @className:com.xed.financing.wxgzh.controller.intface.accountInfoAddress.AccountInfoAddressInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月13日 下午2:24:56
 * @author:duanjy
 */
@Controller
@RequestMapping("/ios/AccountInfoAddress")
public class AccountInfoAddressInterfaceController
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
	 * @Description:/ios/AccountInfoAddress/toaccountaddress?accountId=
	 * @param request
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月13日 下午2:58:06
	 */
	@RequestMapping("/toaccountaddress")
	@ResponseBody
	public JSONObject toAccountAddress(String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();

		String msg = "获得个人地址失败";
		Integer code = 300;
		try
		{
			String flag = "edit";
			AccountAddressBean addressBean = new AccountAddressBean();
			addressBean.setAccountId(accountId);
			addressBean = accountAddressService.queryAccountAddressDefaultById(addressBean);
			
			if(StringTools.isNullOrEmpty(addressBean))
			{
				flag = "save";
			}
			else
			{
				CityBean cityBean = new CityBean();
				//省
				cityBean.setCityCode(addressBean.getProvince());
				List<CityBean> provinceList= cityService.queryCity(cityBean);
				//市
				cityBean.setCityCode(addressBean.getCity());
				List<CityBean> cityList = cityService.queryCity(cityBean);
				//区
				cityBean.setCityCode(addressBean.getClassify());
				List<CityBean> quList= cityService.queryCity(cityBean);
				
				objs.put("provinceList", JsonUtil.listToJson(provinceList));
				objs.put("cityList", JsonUtil.listToJson(cityList));
				objs.put("quList", JsonUtil.listToJson(quList));
				objs.put("addressBean", addressBean);
			}
			msg = "获得个人地址成功";
			code = 200;
			obj.put("flag", flag);
			obj.put("data", objs);
		}
		catch (Exception e)
		{
			// TODO: handle exception
			logger.error("查询首页标数据异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 *  修改收货地址
	 * @Description:/ios/AccountInfoAddress/updateAccountAddress?accountId=&&userName=&&userTelephone=&&
	 * 												province=&&city=&&classify=&&userAddress=&&remark=
	 * @param accountId
	 * @param userName
	 * @param userTelephone
	 * @param province
	 * @param city
	 * @param classify
	 * @param userAddress
	 * @param remark
	 * @return
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年4月18日 上午9:46:25
	 */
	@RequestMapping("/updateAccountAddress")
	@ResponseBody
	public JSONObject updateAccountAddress(String accountId,String userName,String userTelephone,
			String province,String city,String classify,String userAddress,String remark)
	{
		JSONObject obj = new JSONObject();
		
		String msg = "修改收货地址异常";
		Integer code = 300;
		// 字符串转码
		try
		{
			userName = new String(userName.getBytes("iso8859-1"), "utf-8");
			province = new String(province.getBytes("iso8859-1"), "utf-8");
			city = new String(city.getBytes("iso8859-1"), "utf-8");
			classify = new String(classify.getBytes("iso8859-1"), "utf-8");
			userAddress = new String(userAddress.getBytes("iso8859-1"), "utf-8");
			remark = new String(remark.getBytes("iso8859-1"), "utf-8");
		}
		catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			AccountAddressBean accountAddressBean = new AccountAddressBean();
			accountAddressBean.setAccountId(accountId);
			//根据accountId获得对象，查询用户默认地址信息
			accountAddressBean = accountAddressService.queryAccountAddressDefaultById(accountAddressBean);
			//创建一个新的用户地址
			AccountAddressBean aAddressBean = new AccountAddressBean();
			aAddressBean.setAccountId(accountId);
			aAddressBean.setUserName(userName);
			//手机号正则验证
			String regex = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$"; 
			Pattern p = Pattern.compile(regex);
		    //返回Boolean
		    System.out.println(p.matcher(userTelephone).matches());
			if(p.matcher(userTelephone).matches())
			{
				aAddressBean.setUserTelephone(userTelephone);
				aAddressBean.setProvince(province);
				aAddressBean.setCity(city);
				aAddressBean.setClassify(classify);
				aAddressBean.setUserAddress(userAddress);
				aAddressBean.setRemark(remark);
				if(StringTools.isNullOrEmpty(accountAddressBean))
				{
					//保存
					aAddressBean.setIsDefault("1");
					accountAddressService.insertAccountAddress(aAddressBean);
					msg = "新增地址成功";
					code = 200;
				}
				else
				{
					//修改
					accountAddressService.editAccountAddress(aAddressBean);
					msg = "修改地址成功";
					code = 200;
				}
			}
			else
			{
				msg = "手机号异常";
				code = 203;
			}
		}
		catch (Exception e)
		{
			logger.error("修改收货地址异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
}
