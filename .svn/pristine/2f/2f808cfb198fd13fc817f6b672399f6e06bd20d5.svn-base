package com.xed.financing.wxgzh.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.omg.CORBA.portable.UnknownException;

public class NetworkUtils
{
	public static Map<String, Object> getLocalInetMac() {

		Map<String, Object> ipMacInfo = null;
		try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface
					.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements()) {
				NetworkInterface networkInterface = networkInterfaces
						.nextElement();
				Enumeration<InetAddress> inetAddresses = networkInterface
						.getInetAddresses();

				while (inetAddresses.hasMoreElements()) {
					InetAddress inetAddress = inetAddresses.nextElement();
					ipMacInfo = pickInetAddress(inetAddress, networkInterface);
					if (ipMacInfo != null) {
						return ipMacInfo;
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Map<String, Object> pickInetAddress(InetAddress inetAddress,
			NetworkInterface ni) {
		try {
			String name = ni.getDisplayName();
			if (name.contains("Adapter")
					|| name.contains("Virtual") || name.contains("VMnet") || name.contains("#")) {
				return null;
			}
			if (ni.isVirtual() || !ni.isUp() || !ni.supportsMulticast()) {
				return null;
			}

			if (inetAddress.isSiteLocalAddress()) {
				Formatter formatter = new Formatter();
				String sMAC = null;
				byte[] macBuf = ni.getHardwareAddress();
				for (int i = 0; i < macBuf.length; i++) {
					sMAC = formatter.format(Locale.getDefault(), "%02X%s",
							macBuf[i], (i < macBuf.length - 1) ? "-" : "")
							.toString();
				}
				formatter.close();
				Map<String, Object> ipMacInfo = new HashMap<String, Object>();
				ipMacInfo.put("hostname", inetAddress.getHostName()); //系统当前hostname
				ipMacInfo.put("ip", inetAddress.getHostAddress()); //ip地址
				ipMacInfo.put("ipnet", inetAddressTypeName(inetAddress)); //网络类型
				ipMacInfo.put("os", System.getProperty("os.name")); //系统名称
				ipMacInfo.put("mac", sMAC); //mac 地址
				ipMacInfo.put("cpu-arch", System.getProperty("os.arch")); //cpu架构
				ipMacInfo.put("network-arch", ni.getDisplayName()); //网卡名称
				return ipMacInfo;
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} 
		return null;
	}

	private static String inetAddressTypeName(InetAddress inetAddress) {
		return (inetAddress instanceof Inet4Address) ? "ipv4" : "ipv6";
	}

	//通过第三方网站http://1111.ip138.com/ic.asp获取ip
    public static Map<String, String> getOpenNetworkIp() 
    {
		
		try {
			URLConnection openConnection = new URL("http://ip138.com/ic.asp").openConnection();
			openConnection.setDoInput(true);
			openConnection.connect();
			InputStream is =  (InputStream) openConnection.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,Charset.forName("GBK")));
			StringBuilder sb = new StringBuilder();
			String str = null;
			while((str=br.readLine())!=null)
			{
				sb.append(str);
			}
			String htmlSrc = sb.toString().toLowerCase(Locale.getDefault());
			String startTag = "<center>";
			String endTag = "</center>";
			htmlSrc = htmlSrc.substring(htmlSrc.indexOf(startTag)+startTag.length(), htmlSrc.lastIndexOf(endTag));
			String openIp = htmlSrc.substring(htmlSrc.indexOf("[")+1, htmlSrc.lastIndexOf("]"));
			String provider = htmlSrc.substring(htmlSrc.lastIndexOf("：")+1);
			
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put("openIp", openIp);
			resultMap.put("provider", provider);
			
			br.close();
			return resultMap;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	 public static String getDNSIp(String url) throws UnknownHostException
	 {
		InetAddress bupt=null;
		try{ 
			bupt = InetAddress.getByName(url);
			return bupt.getHostAddress();
				 
		}catch(UnknownException e) {
				e.printStackTrace();
		 }
			 return null;
	 }

	 /**
	 * 检测http网络连接是否正常
	 * @param urlStr
	 * @return
	 */
	private static boolean httpIsAvaliable(String urlStr) {
		URL url = null;
		InputStream in = null;
		try {
			url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			conn.connect();
			in = conn.getInputStream();
			if (in != null && in.read() >= 0) {
				return true;
			}

		} catch (Exception e) {
			return false;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
		return false;
	}
	
	/**
	 * 检测任意ip:port网络访问是否正常
	 * @param hostname
	 * @param port
	 * @return
	 */
	private static boolean socketIsAvaiable(String hostname,int port)
	{
		Socket socket = null;
		try {
			socket = new Socket();
			socket.setKeepAlive(true);
			socket.setTcpNoDelay(true);
			socket.setTrafficClass(0x08);
			socket.connect(new InetSocketAddress(hostname, port));
			if(!socket.isClosed() && socket.isConnected() && !socket.isInputShutdown() && !socket.isOutputShutdown())
			{
				return true;
			}
		} catch (SocketException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}finally{
			if(socket!=null && !socket.isClosed())
			{
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Map<String, Object> localInetMac = getLocalInetMac();
		System.out.println("111111--"+localInetMac.get("ip"));
		System.out.println("111111--"+localInetMac.get("mac"));
		Map<String, String> openNetworkIp = getOpenNetworkIp();
		System.out.println(openNetworkIp);

	}
}
