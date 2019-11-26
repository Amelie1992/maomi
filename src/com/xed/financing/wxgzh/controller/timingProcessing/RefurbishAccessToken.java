package com.xed.financing.wxgzh.controller.timingProcessing;

import org.springframework.beans.factory.annotation.Autowired;

import com.xed.financing.wxgzh.service.param.ParamService;

/**
 * 刷新全局access_token
 * @className:com.xed.financing.wxgzh.controller.timingProcessing.RefurbishAccessToken
 * @description:
 * @version:v1.0.0 
 * @date:2017年12月12日 上午11:54:26
 * @author:Peng Gang
 */
public class RefurbishAccessToken
{

	@Autowired
	private ParamService paramService;
	
	public void refurbish() throws Exception
	{
		/*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String exprise_in_time = formatter.format(System.currentTimeMillis());
		System.out.println("开始刷新token" + exprise_in_time);	*/
		paramService.refurbishAccessToken();
		/*System.out.println("刷新token结束");
		
		System.out.println("开始刷新jsapi_ticket");*/
		paramService.refurbishJsapiTicket();
		/*System.out.println("刷新jsapi_ticket结束");*/
	}
}
