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

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.GsonBuilder;

/**
 * JSON工具类
 *
 * @className:com.xtwl.manager.util.JsonUtil
 * @version:v1.0.0
 * @date:2014-10-20 下午4:13:44
 * @author:Bing Lu
 */
public class JsonUtil
{

	public static String objectToJson(Object object)
	{
		StringBuilder json = new StringBuilder();
		if (object == null)
		{
			json.append("\"\"");
		}
		else if (object instanceof String || object instanceof Integer)
		{
			// json.append("\"").append((String) object).append("\"");
			// //此语当哦bject为Integer类型会导致异常
			// json = string2Json(json.toString());
			String obj = (String) object;
			/*
			 * if (object instanceof String && object !=null)
			 * obj=obj.replace("\"", "“");
			 */
			json.append("\"").append(obj).append("\""); // xjliu modified , at
			// 2015/3/6
		}
		else if (object instanceof List)
		{
			json.append(listToJson((List<?>) object));
		}
		else
		{
			json.append(beanToJson(object));
		}
		return json.toString();
	}

	/**
	 * 功能描述:传入任意一个 javabean 对象生成一个指定规格的字符串
	 *
	 * @param bean
	 *            bean对象
	 * @return String
	 */
	public static String beanToJson(Object bean)
	{
		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try
		{
			props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();
		}
		catch (IntrospectionException e)
		{
		}
		if (props != null)
		{
			for (int i = 0; i < props.length; i++)
			{
				try
				{
					String name = objectToJson(props[i].getName());
					String value = objectToJson(props[i].getReadMethod().invoke(bean));
					json.append(name);
					json.append(":");
					json.append(value);
					json.append(",");
				}
				catch (Exception e)
				{
				}
			}
			json.setCharAt(json.length() - 1, '}');
		}
		else
		{
			json.append("}");
		}
		return json.toString();
	}

	/**
	 * 功能描述:通过传入一个列表对象,调用指定方法将列表中的数据生成一个JSON规格指定字符串
	 *
	 * @param list
	 *            列表对象
	 * @return java.lang.String
	 */
	public static String listToJson(List<?> list)
	{
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0)
		{
			for (Object obj : list)
			{
				json.append(objectToJson(obj));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		}
		else
		{
			json.append("]");
		}
		return json.toString();
	}

	// 转换成String
	public static String stringtojson(String s)
	{
		if (s == null)
			return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
		{
			char ch = s.charAt(i);
			switch (ch)
			{
				case '\"':
					sb.append("\\\"");
					break;
				case '\\':
					sb.append("\\\\");
					break;
				case '\b':
					sb.append("\\b");
					break;
				case '\f':
					sb.append("\\f");
					break;
				case '\n':
					sb.append("\\n");
					break;
				case '\r':
					sb.append("\\r");
					break;
				case '\t':
					sb.append("\\t");
					break;
				case '/':
					sb.append("\\/");
					break;
				default:
					if (ch >= '\u0000' && ch <= '\u001F')
					{
						String ss = Integer.toHexString(ch);
						sb.append("\\u");
						for (int k = 0; k < 4 - ss.length(); k++)
						{
							sb.append('0');
						}
						sb.append(ss.toUpperCase());
					}
					else
					{
						sb.append(ch);
					}
			}
		}
		return sb.toString();
	}

	/**
	 * MAP转JSON
	 *
	 * @Description:
	 * @param m
	 * @return String
	 * @version:v1.0
	 * @author:booslu
	 * @date:2013-7-26 下午03:31:50
	 */
	public static String mapToJson(Map<?, ?> m)
	{
		String mapStr = "";
		mapStr = JSONArray.fromObject(m).toString();
		return mapStr;
	}

	/**
	 * MAP转JSON
	 *
	 * @Description:
	 * @param m
	 * @return String
	 * @version:v1.0
	 * @author:liuchang
	 * @data:2014-10-28
	 */
	public static String listToJson(List<?> list, List<String> columns)
	{
		StringBuilder json = new StringBuilder();
		json.append("[");
		if (list != null && list.size() > 0)
		{
			for (Object obj : list)
			{
				json.append(objectToJson(obj, columns));
				json.append(",");
			}
			json.setCharAt(json.length() - 1, ']');
		}
		else
		{
			json.append("]");
		}
		return json.toString();
	}

	public static StringBuilder string2Json(String s)
	{
		if (StringTools.isNullOrEmpty(s))
			return new StringBuilder(s);
		StringBuilder sb = new StringBuilder();
		sb.append("\"");
		for (int i = 1; i < s.length() - 1; i++)
		{
			char c = s.charAt(i);
			switch (c)
			{
				case '\"':
					sb.append("\\\"");
					break;
				case '\\':
					sb.append("\\\\");
					break;
				case '/':
					sb.append("\\/");
					break;
				case '\b':
					sb.append("\\b");
					break;
				case '\f':
					sb.append("\\f");
					break;
				case '\n':
					sb.append("\\n");
					break;
				case '\r':
					sb.append("\\r");
					break;
				case '\t':
					sb.append("\\t");
					break;
				default:
					sb.append(c);
			}
		}
		sb.append("\"");
		return sb;
	}

	/**
	 *
	 * @Description:
	 * @param object
	 * @param hideColumn
	 *            隐藏列
	 * @return
	 * @version:v1.0
	 * @author:LiuChang
	 * @date:2014-10-28 下午12:58:09
	 */
	private static Object objectToJson(Object object, List<String> columns)
	{
		StringBuilder json = new StringBuilder();
		if (object == null)
		{
			json.append("\"\"");
		}
		else if (object instanceof String || object instanceof Integer)
		{
			/*
			 * if((columns.contains((String) object)&&!tOrf)
			 * ||(!columns.contains((String) object)&&tOrf))
			 * json.append("\"").append((String) object).append("#\""); else
			 */
			String obj = (String) object;
			/*
			 * if (object instanceof String && object !=null) {
			 * obj.replace("\"", "“"); }
			 */
			json.append("\"").append(obj).append("\"");
		}
		else if (object instanceof List)
		{
			json.append(listToJson((List<?>) object));
		}
		else
		{
			json.append(beanToJson(object, columns));
		}
		return json.toString();
	}

	/**
	 * 二维数据转换json
	 *
	 * @Description:
	 * @param arry
	 * @return
	 * @version:v1.0
	 * @author:HanXiaoTao
	 * @date:2015-11-27 下午2:06:46
	 */
	public static String arrayToJson(String[][] arry)
	{
		StringBuffer sb = new StringBuffer();
		boolean first = true;
		sb.append("[");
		for (int i = 0; i < arry.length; i++)
		{
			String[] blogItem = arry[i];
			if (!first)
			{
				sb.append(",");
			}
			sb.append("{");
			sb.append("postdate: '" + blogItem[0] + "', ");
			sb.append("title: '" + blogItem[1] + "', ");
			sb.append("}");
			first = false;
		}
		sb.append("]");
		System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 *
	 * @Description:
	 * @param bean
	 * @return
	 * @version:v1.0
	 * @author:LiuChang
	 * @date:2014-10-28 下午1:28:43
	 */
	public static String beanToJson(Object bean, List<String> columns)
	{
		StringBuilder json = new StringBuilder();
		json.append("{");
		PropertyDescriptor[] props = null;
		try
		{
			props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();
		}
		catch (IntrospectionException e)
		{
		}
		if (props != null)
		{
			for (int j = 0; j < columns.size(); j++)
			{
				for (int i = 0; i < props.length; i++)
				{
					if (columns.get(j).equalsIgnoreCase(props[i].getName()))
					{
						PropertyDescriptor pd = props[j];
						props[j] = props[i];
						props[i] = pd;
						break;
					}

				}
			}
			for (int i = 0; i < props.length; i++)
			{
				try
				{
					String name = objectToJson(props[i].getName());
					if (!ListTools.isContain(columns, props[i].getName()))
						name = objectToJson(props[i].getName() + "#");
					String value = objectToJson(props[i].getReadMethod().invoke(bean));
					StringBuilder sb = new StringBuilder();
					sb = string2Json(value);
					json.append(name);
					json.append(":");
					json.append(sb.toString());
					json.append(",");
				}
				catch (Exception e)
				{
				}
			}
			json.setCharAt(json.length() - 1, '}');
		}
		else
		{
			json.append("}");
		}
		return json.toString();
	}

	/**
	 * JsonBuilder静态实例
	 */
	private static GsonBuilder gsonBuilder = null;
	static
	{
		gsonBuilder = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 序列化对象为json
	 *
	 * @Description:
	 * @param t
	 * @return
	 * @version:v1.0
	 * @author: xjliu
	 * @date:Mar 21, 2015 4:13:20 PM
	 */
	public static <T> String parseToJson(T t)
	{
		return gsonBuilder.create().toJson(t);
	}

	/**
	 * @Description:Parse From Json
	 * @param json
	 * @param clazz
	 * @return
	 * @version:v1.0
	 * @author: xjliu
	 * @date:Apr 30, 2015 1:55:30 PM
	 */
	public static <T> T parseFromJson(String json, Class<T> clazz)
	{
		return gsonBuilder.create().fromJson(json, clazz);
	}

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 *
	 * @param jsonString
	 * @param beanCalss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToBean(String jsonString, Class<T> beanCalss)
	{

		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		T bean = (T) JSONObject.toBean(jsonObject, beanCalss);
		return bean;

	}

	/**
	* @Description:从json对象集合表达式中得到一个java对象列表
	* @param
	* @throws
	* @version:v1.0
	* @author:QIANTAO
	* @date:2016/8/31 15:48
	*/
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonToBeanList(String jsonString, Class<T> beanClass)
	{

		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject;
		T bean;
		int size = jsonArray.size();
		List<T> list = new ArrayList<T>(size);

		for (int i = 0; i < size; i++)
		{

			jsonObject = jsonArray.getJSONObject(i);
			bean = (T) JSONObject.toBean(jsonObject, beanClass);
			list.add(bean);

		}

		return list;

	}

}
