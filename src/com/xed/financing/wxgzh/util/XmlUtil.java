package com.xed.financing.wxgzh.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.xed.financing.wxgzh.model.pay.CardResultBean;
import com.xed.financing.wxgzh.model.pay.PayExportInfoBean;
import com.xed.financing.wxgzh.model.pay.PayResultInfo;

public class XmlUtil
{
	public void readStringXml(String xml)
	{
		Document doc = null;
		try
		{

			// 读取并解析XML文档
			// SAXReader就是一个管道，用一个流的方式，把xml文件读出来
			//
			// SAXReader reader = new SAXReader(); //User.hbm.xml表示你要解析的xml文档
			// Document document = reader.read(new File("User.hbm.xml"));
			// 下面的是通过解析xml字符串的
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML

			Element rootElt = doc.getRootElement(); // 获取根节点
			System.out.println("根节点：" + rootElt.getName()); // 拿到根节点的名称

			Iterator iter = rootElt.elementIterator("ap"); // 获取根节点下的子节点ap

			// 遍历head节点
			while (iter.hasNext())
			{

				Element recordEle = (Element) iter.next();
				String title = recordEle.elementTextTrim("plain"); // 拿到head节点下的子节点title值
				System.out.println("plain:" + title);

				Iterator iters = recordEle.elementIterator("plain"); // 获取子节点head下的子节点script

				// 遍历Header节点下的Response节点
				while (iters.hasNext())
				{

					Element itemEle = (Element) iters.next();

					String username = itemEle.elementTextTrim("order_pay_code"); // 拿到head下的子节点script下的字节点username的值
					String password = itemEle.elementTextTrim("order_id");

					System.out.println("order_pay_code:" + username);
					System.out.println("order_id:" + password);
				}
			}
			Iterator iterss = rootElt.elementIterator("body"); // /获取根节点下的子节点body
			// 遍历body节点
			while (iterss.hasNext())
			{

				Element recordEless = (Element) iterss.next();
				String result = recordEless.elementTextTrim("result"); // 拿到body节点下的子节点result值
				System.out.println("result:" + result);

				Iterator itersElIterator = recordEless.elementIterator("form"); // 获取子节点body下的子节点form
				// 遍历Header节点下的Response节点
				while (itersElIterator.hasNext())
				{

					Element itemEle = (Element) itersElIterator.next();

					String banlce = itemEle.elementTextTrim("banlce"); // 拿到body下的子节点form下的字节点banlce的值
					String subID = itemEle.elementTextTrim("subID");

					System.out.println("banlce:" + banlce);
					System.out.println("subID:" + subID);
				}
			}
		}
		catch (DocumentException e)
		{
			e.printStackTrace();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
	}

	/**
	 * @description 将xml字符串转换成map
	 * @param xml
	 * @return Map
	 */
	public static PayResultInfo readStringXmlOut(String xml, PayExportInfoBean ben)
	{
		PayResultInfo bean = new PayResultInfo();
		String Rcd = "";
		String RDesc = "";
		String Sign = "";
		Document doc = null;
		try
		{
			// 将字符串转为XML
			doc = DocumentHelper.parseText(xml);
			// 获取根节点
			Element rootElt = doc.getRootElement();
			// 拿到根节点的名称
			System.out.println("根节点：" + rootElt.getName());

			// 拿到head节点下的子节点title值
			Rcd = rootElt.elementTextTrim("Rcd");
			RDesc = rootElt.elementTextTrim("RDesc");
			Sign = rootElt.elementTextTrim("Sign");

			bean.setRcd(Rcd);
			bean.setRdesc(RDesc);
			bean.setSign(Sign);

		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bean;
	}

	public static CardResultBean readStringXmlPut(String xml)
	{
		CardResultBean bean = new CardResultBean();
		String Rcd = "";
		String RDesc = "";
		String Sign = "";
		String Ctp = "";
		String Cnm = "";
		String InsCd = "";
		Document doc = null;
		try
		{
			// 将字符串转为XML
			doc = DocumentHelper.parseText(xml);
			// 获取根节点
			Element rootElt = doc.getRootElement();
			// 拿到根节点的名称
			System.out.println("根节点：" + rootElt.getName());
			System.out.println("返回码：" + rootElt.elementTextTrim("Rcd"));
			Rcd = rootElt.elementTextTrim("Rcd");
			RDesc = rootElt.elementTextTrim("RDesc");
			Sign = rootElt.elementTextTrim("Sign");
			if (Rcd.equals("0000"))
			{
				Ctp = rootElt.elementTextTrim("Ctp");
				Cnm = rootElt.elementTextTrim("Cnm");
				InsCd = rootElt.elementTextTrim("InsCd");

			}

			bean.setRcd(Rcd);
			bean.setRdesc(RDesc);
			bean.setSign(Sign);
			bean.setCtp(Ctp);
			bean.setCnm(Cnm);
			bean.setInsCd(InsCd);
		}
		catch (DocumentException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bean;
	}

	public static Map<String, String> xml2Map(String xml)
	{
		Map<String, String> map = new HashMap<String, String>();
		try
		{
			Document doc = DocumentHelper.parseText(xml);// 将xml转为dom对象
			Element root = doc.getRootElement();// 获取根节点
			Element element = root.element("plain");// 获取名称为queryRequest的子节点
			Element element1 = element.element("results");
			Element element2 = element1.element("result");
			List<Element> elements = element.elements();// 获取这个子节点里面的所有子元素，也可以element.elements("userList")指定获取子元素
			for (Object obj : elements)
			{ // 遍历子元素
				element = (Element) obj;
				map.put(element.getName(), element.getTextTrim());
				System.out.println(element.getName() + "--" + element.getTextTrim());
			}
			List<Element> elements1 = element2.elements();
			for (Object obj : elements1)
			{
				element2 = (Element) obj;
				map.put(element2.getName(), element2.getTextTrim());
				System.out.println(element2.getName() + "--" + element2.getTextTrim());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}

	public static Map<String, String> xml4Map(String xml)
	{
		Map<String, String> map = new HashMap<String, String>();
		try
		{
			Document doc = DocumentHelper.parseText(xml);// 将xml转为dom对象
			Element root = doc.getRootElement();// 获取根节点
			Element element = root.element("plain");// 获取名称为queryRequest的子节点
			List<Element> elements = element.elements();// 获取这个子节点里面的所有子元素，也可以element.elements("userList")指定获取子元素
			for (Object obj : elements)
			{ // 遍历子元素
				element = (Element) obj;
				map.put(element.getName(), element.getTextTrim());
				System.out.println(element.getName() + "--" + element.getTextTrim());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
}
