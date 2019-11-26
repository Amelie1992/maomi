package com.xed.financing.wxgzh.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @className:com.xed.financing.manager.web.util.MobileMessageSend
 * @description:短信发送工具类
 * @version:v1.0.0
 * @date:2017年3月1日 下午3:58:28
 * @author:WangJun
 */
public class MobileMessagePrompt
{
	private static final String SERVER_URL = "https://api.netease.im/sms/sendtemplate.action";// 发送验证码的请求路径URL
	private static final String APP_KEY = "f890041787ee78309f3123b61e5b08ff";// 网易云信分配的账号
	private static final String APP_SECRET = "73a0e4f1f0f3";// 网易云信分配的密钥
	private static final String NONCE = "123456";// 随机数
	// 短信模板ID
	private static final String TEMPLATEID = "3061700";
	
	/**
	 * 投资到期发送提示短信
	 * @Description:
	 * @param telephone
	 * @param money
	 * @param date
	 * @return
	 * @throws IOException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月13日 下午3:37:41
	 */
	public static String msgPrompt(String telephone, String money,String date) throws IOException
	{

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(SERVER_URL);

		String curTime = String.valueOf((new Date().getTime() / 1000L));
		String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

		// 设置请求的header
		post.addHeader("AppKey", APP_KEY);
		post.addHeader("Nonce", NONCE);
		post.addHeader("CurTime", curTime);
		post.addHeader("CheckSum", checkSum);
		
		// 短信长度

		post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求参数
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		nameValuePairs.add(new BasicNameValuePair("mobiles", "['" + telephone+ "']"));
		nameValuePairs.add(new BasicNameValuePair("templateid", TEMPLATEID));
		nameValuePairs.add(new BasicNameValuePair("params", "['" + money + "','" + date+ "']"));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

		// 执行请求
		HttpResponse response = httpclient.execute(post);
		String responseEntity = EntityUtils.toString(response.getEntity(), "utf-8");

		// 判断是否发送成功，发送成功返回true
		String code = JSON.parseObject(responseEntity).getString("code");
		return code;
	}
	
	/**
	 * 提前还款发送短信
	 * @Description:
	 * @param telephone
	 * @param subjectCode
	 * @param realName
	 * @return
	 * @throws IOException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年6月12日 下午5:06:59
	 */
	public static String msgEarly(String telephone, String subjectCode,String realName) throws IOException
	{

		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(SERVER_URL);

		String curTime = String.valueOf((new Date().getTime() / 1000L));
		String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);

		// 设置请求的header
		post.addHeader("AppKey", APP_KEY);
		post.addHeader("Nonce", NONCE);
		post.addHeader("CurTime", curTime);
		post.addHeader("CheckSum", checkSum);
		
		// 短信长度

		post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

		// 设置请求参数
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		nameValuePairs.add(new BasicNameValuePair("mobiles", "['" + telephone+ "']"));
		nameValuePairs.add(new BasicNameValuePair("templateid", "4093062"));
		nameValuePairs.add(new BasicNameValuePair("params", "['" + realName + "','" + subjectCode+ "']"));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));

		// 执行请求
		HttpResponse response = httpclient.execute(post);
		String responseEntity = EntityUtils.toString(response.getEntity(), "utf-8");

		// 判断是否发送成功，发送成功返回true
		String code = JSON.parseObject(responseEntity).getString("code");
		return code;
	}
	
	
	
}
