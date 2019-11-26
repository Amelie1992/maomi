/**
 * Copyright (C) 2014 XUNTIAN NETWORK
 *
 *
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Bing Lu
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2014-10-20     Bing Lu       v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.util.List;

/**
 * LIST工具类
 * 
 * @className:com.xtwl.manager.util.ListTools
 * @version:v1.0.0
 * @date:2014-10-20 下午4:14:12
 * @author:Bing Lu
 */
public class ListTools
{

	/**
	 * 判断list是否为空
	 * 
	 * @Description:空则返回true
	 * @param list
	 * @return
	 * @version:v1.0
	 * @author:LiChangjiang
	 * @date:2012-11-27 下午02:25:44
	 */
	public static boolean isNullOrEmpty(List<?> list)
	{
		if (null == list || list.size() == 0)
		{
			return true;
		}
		if (list.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	public static boolean isContain (List<String> list ,String value)
	{
	    for(String s:list)
	    {
	        if(s.toString().equalsIgnoreCase(value))
	            return true;
	    }
	    return false;
	}
}
