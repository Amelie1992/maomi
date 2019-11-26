package com.xed.financing.wxgzh.util;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * 工具类
 * 
 * @author penggang
 *
 */
public class AuthUtil
{

	//测试
	//	public static final String APPID = "wx10f3c68aa671e9b0"; 
	//	public static final String APPSECRET = "7d48171be5bd57d347582b87dc3d1bc1"; 
	//正式
	public static final String APPID = "wxb89f90766a9bf8a2";
	public static final String APPSECRET = "344b7a372e9fb993ee23809f4fe07c41";

	public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException
	{
		JSONObject jsonObject = null;
		CloseableHttpClient httpclient = SSLClientDefault.createSSLClientDefault();
		//HttpClients.createDefault();
		
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
	 * @date:2017年10月27日 上午9:47:29
	 */
	public static void getCode(String wxurl, String type, HttpServletResponse resp){
		
		String backUrl = wxurl + "loginregister/s/wxCallBack/" + type;
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" 
				+ "appid=" + APPID
				+ "&redirect_uri=" + URLEncoder.encode(backUrl) 
				+ "&response_type=code" 
				+ "&scope=snsapi_userinfo"
				+ "&state=STATE" 
				+ "#wechat_redirect";
		try
		{
			resp.sendRedirect(url);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取微信授权的AccessToken
	 * 先刷新
	 * @Description:
	 * @param req
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月27日 上午10:00:14
	 */
	
	public static JSONObject getAccessToken(HttpServletRequest req){
		String code = req.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" 
					+ "appid=" + APPID 
					+ "&secret=" + APPSECRET 
					+ "&code=" + code 
					+ "&grant_type=authorization_code";
		JSONObject jsonObject = null;
		try
		{
			jsonObject = AuthUtil.doGetJson(url);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	/**
	 * 获取用户信息unionid
	 * @Description:
	 * @param req
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年11月7日 上午10:36:01
	 */
	public static JSONObject getUnionid(HttpServletRequest req){
		JSONObject jsonObject = getAccessToken(req);
		String access_token = jsonObject.getString("access_token");
		String openid = jsonObject.getString("openid");
		String url = "https://api.weixin.qq.com/sns/userinfo"
				+ "?access_token=" + access_token
				+ "&openid=" + openid
				+ "&lang=zh_CN";
		JSONObject jsonObject1 = null;
		try
		{
			jsonObject1 = AuthUtil.doGetJson(url);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return jsonObject1;	
	}
}



