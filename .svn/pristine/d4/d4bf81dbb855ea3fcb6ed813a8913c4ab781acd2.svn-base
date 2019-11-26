package com.xed.financing.wxgzh.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @className:com.xed.financing.manager.web.util.IpUtil
 * @description:IP工具类
 * @version:v1.0.0
 * @date:2016-11-2 下午2:11:21
 * @author:WangJun
 */
public class IpUtil
{

	/**
	 * 
	 * @Description:获取用户真实IP
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:WangJun
	 * @date:2016-11-2 下午2:13:08
	 */
	public static String getClientIp(HttpServletRequest request)
	{

		String ip = request.getHeader("x-forwarded-for");

		// String ip = request.getHeader("X-real-ip");
//		System.out.println("RemoteAddr_ip="+request.getRemoteAddr());
//		System.out.println("Proxy-Client-IP="+request.getHeader("Proxy-Client-IP"));
//		System.out.println("WL-Proxy-Client-IP="+request.getHeader("WL-Proxy-Client-IP"));

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;

	}
	
	
	public static String getMACAddress(String ip) {  
        String str = "";  
        String macAddress = "";  
        try {  
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);  
            InputStreamReader ir = new InputStreamReader(p.getInputStream());  
            LineNumberReader input = new LineNumberReader(ir);  
            for (int i = 1; i < 100; i++) {  
                str = input.readLine();  
                if (str != null) {  
                    if (str.indexOf("MAC Address") > 1) {  
                        macAddress = str.substring(  
                                str.indexOf("MAC Address") + 14, str.length());  
                        break;  
                    }  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace(System.out);  
        }  
        return macAddress;  
    }  
	
	
	

	/**
	 * 获取操作系统名称
	 */
	public static String getOsName()
	{
		String os = "";
		os = System.getProperty("os.name");
		return os;
	}

}
