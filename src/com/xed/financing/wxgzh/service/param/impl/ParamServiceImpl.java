/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.param.impl.ParamServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月21日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.param.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.param.ParamBean;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.util.AuthUtil;

/**
 * @className:com.xed.financing.wxgzh.service.param.impl.ParamServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月21日 下午3:38:02
 * @author:Qian Tao
 */
@Service
@Transactional
public class ParamServiceImpl implements ParamService
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(ParamServiceImpl.class);
	
	@Resource
	private ParamMapper paramMapper;
	
	@Override
	public String getParamVal(String key)
	{
		return paramMapper.getParamVal(key);
	}

	@Override
	public ParamBean getCurrentTime()
	{
		// TODO Auto-generated method stub
		return paramMapper.getCurrentTime();
	}

	@Override
	@Transactional
	public void refurbishAccessToken() throws Exception
	{		
		try{			
			String url = "https://api.weixin.qq.com/cgi-bin/token"
					+ "?grant_type=client_credential"
					+ "&appid=" + AuthUtil.APPID
					+ "&secret=" + AuthUtil.APPSECRET;
			
			JSONObject jsonObject = null;
			try
			{
				jsonObject = AuthUtil.doGetJson(url);
				System.out.println(jsonObject);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("access_token异常");
			}
			String accessToken = jsonObject.getString("access_token");
			//System.out.println(accessToken);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String exprise_in_time = formatter.format(System.currentTimeMillis() + 7000000);		
			paramMapper.refurbishAccessToken(accessToken);
			paramMapper.refurbishAccessTokenExpriseInTime(exprise_in_time);
		}catch(Exception e){
			logger.error("刷新accessToken异常");
			throw new RuntimeException();
		}
	}
	
	@Override
	@Transactional
	public void refurbishJsapiTicket() throws Exception
	{		
		try{
			String access_token = paramMapper.getParamVal("ACCESS_TOKEN");
			String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?"
					+ "access_token=" + access_token + "&type=jsapi";			
			JSONObject jsonObject = null;
			try
			{
				jsonObject = AuthUtil.doGetJson(url);
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("jsapi_ticket异常");
			}
			String jsapi_ticket = jsonObject.getString("ticket");
			//System.out.println(accessToken);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String exprise_in_time = formatter.format(System.currentTimeMillis() + 7000000);
			paramMapper.refurbishJsapiTicket(jsapi_ticket);
			paramMapper.refurbishJsapiTicketExpriseInTime(exprise_in_time);
		}catch(Exception e){
			logger.error("刷新jsapi_ticket异常");
			throw new RuntimeException();
		}
	}
}
