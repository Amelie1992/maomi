/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.IphoneParam
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月7日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @className:com.xed.financing.wxgzh.util.IphoneParam
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月7日 上午10:09:28
 * @author:QT
 */
public class IphoneParam
{
	/**
	 * 手机型号
	 */
	public static Map<String, String> IPHONE_TYPE = new HashMap<String, String>();
	
	/**
	 * 颜色
	 */
	public static Map<String, String> IPHONE_COLOR = new HashMap<String, String>();
	
	/**
	 * 套餐
	 */
	public static Map<String, String> IPHONE_PACKAGE = new HashMap<String, String>();
	static
	{
		// 手机型号
		IPHONE_TYPE.put("1", "iphone8 64g");
		IPHONE_TYPE.put("2", "iphone8 256g");
		IPHONE_TYPE.put("3", "iphone8plus 64g");
		IPHONE_TYPE.put("4", "iphone8plus 256g");
		IPHONE_TYPE.put("5", "iphoneX 64g");
		IPHONE_TYPE.put("6", "iphoneX 256g");
		
		// 颜色
		IPHONE_COLOR.put("1", "深空灰");
		IPHONE_COLOR.put("2", "银色");
		IPHONE_COLOR.put("3", "金色");
		
		//套餐
		IPHONE_PACKAGE.put("1", "90000,4");
		IPHONE_PACKAGE.put("2", "60000,6");
		IPHONE_PACKAGE.put("3", "40000,9");
		IPHONE_PACKAGE.put("4", "20000,18");
		
		IPHONE_PACKAGE.put("5", "90000,5");
		IPHONE_PACKAGE.put("6", "50000,9");
		IPHONE_PACKAGE.put("7", "30000,15");
		IPHONE_PACKAGE.put("8", "20000,22");
		
		IPHONE_PACKAGE.put("9", "70000,6");
		IPHONE_PACKAGE.put("10", "50000,8");
		IPHONE_PACKAGE.put("11", "35000,12");
		IPHONE_PACKAGE.put("12", "20000,20");
		
		IPHONE_PACKAGE.put("13", "100000,5");
		IPHONE_PACKAGE.put("14", "80000,6");
		IPHONE_PACKAGE.put("15", "50000,10");
		IPHONE_PACKAGE.put("16", "20000,24");
		
		//iphoneX 套餐
		IPHONE_PACKAGE.put("17", "89000,6");
		IPHONE_PACKAGE.put("18", "67000,8");
		IPHONE_PACKAGE.put("19", "45000,12");
		IPHONE_PACKAGE.put("20", "27000,20");
		
		IPHONE_PACKAGE.put("21", "100000,6");
		IPHONE_PACKAGE.put("22", "78000,8");
		IPHONE_PACKAGE.put("23", "50000,12");
		IPHONE_PACKAGE.put("24", "31000,20");
	}
	
	public static void main(String[] args)
	{
		double a=500;
		double b=0;
		double c=a+b;
		double f=3;
		double d=0.125;
		double e=0.05;
		double z=((c*d*f)/365)*(1-e);

		System.out.println(z);
				
	}
}
