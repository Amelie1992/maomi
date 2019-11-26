/**
 * Copyright (C) 2015 FZJT-IOT
 *
 *
 * @className:com.fzjt.xiao6.manager.util.GetUUID
 * @description:
 * 
 * @version:v1.0.0 
 * @author:hanxiaotao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2015-11-12     hanxiaotao       v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class GetUUID
{
	public static String[] chars = new String[]
	{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
			"w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	/**
	 * 
	 * @Description:
	 * @param type
	 * @return
	 * @version:v1.0
	 * @author:hanxiaotao
	 * @date:2015-11-13 下午2:36:54
	 */
	public static String getUUID(String type)
	{
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 16; i++)
		{
			String str = uuid.substring(i * 2, i * 2 + 2);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return type + shortBuffer.toString();
	}
	
	/**
	 * 生成四位随机数（字母加数字）
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月20日 下午1:57:13
	 */
	public static String getRandom()
	{
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 4; i++)
		{
			String str = uuid.substring(i * 2, i * 2 + 2);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();
	}
	
	/**
	 * 
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月20日 下午1:58:29
	 */
	public static String getMath()
	{
		 int x;//定义两变量
	     Random ne=new Random();//实例化一个random的对象ne
	     x=ne.nextInt(9999-1000+1)+1000;//为变量赋随机值1000-9999\
	     String a = String.valueOf(x);
	     return a;
	}
	/**
	 * 
	 * @Description:
	 * @param type
	 * @return
	 * @version:v1.0
	 * @author:hanxiaotao
	 * @date:2015-11-13 下午2:36:54
	 */
	public static String getRom(int count)
	{
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < count; i++)
		{
			String str = uuid.substring(i * 2, i * 2 + 2);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();
	}

	/**
	 * 获取key生产规则
	 * 
	 * @Description:
	 * @param type
	 * @return
	 * @version:v1.0
	 * @author:LiChangjiang
	 * @date:2016年8月5日 下午8:27:37
	 */
	public static String getUUIDs(String type)
	{
		return type + DateUtils.getUserDate("yyMMddhhmmssSSS") + getRom(6);
	}
	
	/**
	 * 前缀+年与日+6位随机数
	 * @Description:
	 * @param type
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月16日 下午4:50:07
	 */
	public static String getUsefulID(String type)
	{
		Random jjj = new Random();
		Date currentTime = new Date();

		String randomNum = "";

		// 获取当前时间
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmm");
		String dateString = formatter.format(currentTime);

		// 取四位随机数
		for (int k = 0; k < 6; k++)
		{
			randomNum = randomNum + jjj.nextInt(9);
		}

		return type+dateString + randomNum;
	}
	
	/**
	 * 获得nonceStr 分享用
	 * @Description:
	 * @param length
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月24日 下午6:18:59
	 */
	public static String getNonceStr(int length){
		String nonceStr = "";
		for(int i = 1; i <= length; i++){
			int index = (int)(Math.random() * 62);
			nonceStr += chars[index];
		}
		return nonceStr;
	}
}
