package com.xed.financing.wxgzh.util;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

public class IosAuthUtil
{
	public static final String APPID = "wx08e73787f8a97633";
	public static final String APPSECRET = "0cff930e2c6a81b014b482ca3ccdbf0e";
	public static final String WXURL = "https://www.maomibank.com/";
	//public static final String WXURL = "http://penggang.free.ngrok.cc/xed_financing_pc/";

	public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException
	{
		JSONObject jsonObject = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (entity != null)
		{
			String result = EntityUtils.toString(entity, "UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		httpGet.releaseConnection();
		return jsonObject;
	}
	
	/**
	 * 获得第三方授权的code 不采取静默授权
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @throws IOException 
	 * @date:2017年10月27日 上午9:47:29
	 */
	public static void getCode(HttpServletResponse resp) throws IOException{
		
		String backUrl = WXURL + "loginregister/s/wxCallBack";
		String url = "https://open.weixin.qq.com/connect/qrconnect?"
				+ "appid=" + APPID
				+ "&redirect_uri=" + URLEncoder.encode(backUrl)
				+ "&response_type=code"
				+ "&scope=snsapi_login"
				+ "&state=maomibank"
				+ "#wechat_redirect";
		resp.sendRedirect(url);
	}
	/**
	 * 获取微信授权的AccessToken
	 * @Description:
	 * @param req
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月27日 上午10:00:14
	 */
	
	public static JSONObject getAccessToken(HttpServletRequest req) throws IOException{
		JSONObject jsonObject = null;
		String code = req.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
				+ "appid=" + APPID
				+ "&secret=" + APPSECRET
				+ "&code=" + code
				+ "&grant_type=authorization_code";
		jsonObject = IosAuthUtil.doGetJson(url);	
		return jsonObject;
	}
	
	/**
	 * 获取用户信息unionid
	 * @Description:
	 * @param req
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @throws IOException 
	 * @date:2017年11月7日 上午10:36:01
	 */
	public static JSONObject getUnionid(HttpServletRequest req) throws IOException{
		JSONObject jsonObject = getAccessToken(req);
		String access_token = jsonObject.getString("access_token");
		String openid = jsonObject.getString("openid");
		String url = "https://api.weixin.qq.com/sns/userinfo"
				+ "?access_token=" + access_token
				+ "&openid=" + openid
				+ "&lang=zh_CN";
		JSONObject jsonObject1 = IosAuthUtil.doGetJson(url);
		return jsonObject1;	
	}
}
