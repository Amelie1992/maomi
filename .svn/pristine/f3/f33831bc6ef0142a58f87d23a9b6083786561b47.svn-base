/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.creatWordContract
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Elias Zheng
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年6月20日    Elias Zheng  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import freemarker.cache.FileTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 创建合同模板
 * 
 * @className:com.xed.financing.wxgzh.util.creatWordContract
 * @description:
 * @version:v1.0.0
 * @date:2017年6月20日 下午4:38:23
 * @author:Elias Zheng
 */
public class CreatContract
{

	/**
	 * 生成借款模板并需要
	 * @Description:MAP参数:subjectCode,userName,userIdCard,investTime,realName,accountIdCard,investMoney,endTime,accountId
	 * @param contract
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月20日 下午4:52:27
	 */
	public String creatInvestContract(HttpServletRequest request,Map<String, Object> contract)
	{
		String url = "";
		String rootUrl = "";
		try
		{
//			rootUrl = request.getContextPath() + "/templet";
			
			rootUrl = "E:/";
			
			// 模板的路径
			File fir = new File(rootUrl);
			
			url = "猫咪财富借款协议书_" + contract.get("accountId") + new SimpleDateFormat("yyMMddHHmmss").format(new Date()) + ".html";

			// 生成文件的路径及文件名。
			File outFile = new File(rootUrl + url);

			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

			// 使用FileTemplateLoader
			// 指定模板路径
			TemplateLoader templateLoader = null;
			templateLoader = new FileTemplateLoader(fir);
			String tempname = "InvestContract.xml";

			Configuration cfg = new Configuration();
			cfg.setTemplateLoader(templateLoader);
			Template t = cfg.getTemplate(tempname, "UTF-8");

			t.process(contract, out);
			out.flush();
			out.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return url;
	}
	
//	public static void main(String[] args)
//	{
//		Map<String, Object> contract = new HashMap<String, Object>();
//		contract.put("subjectCode", "12313");
//		contract.put("userName", "啊哦");
//		contract.put("userIdCard", "111111111222222222");
//		contract.put("investTime", "2017-06-20");
//		contract.put("realName", "fuck");
//		contract.put("accountIdCard", "999999999777777777");
//		contract.put("investMoney", "7000");
//		contract.put("endTime", "2017-12-20");
//		contract.put("accountId", "2");
//
//		String url = "";
//		try
//		{
//			// 模板的路径
//			File fir = new File("E:/");
//			
//			url = "猫咪财富借款协议书_" + contract.get("accountId") + new SimpleDateFormat("yyMMddHHmmss").format(new Date()) + ".doc";
//
//			// 生成文件的路径及文件名。
//			File outFile = new File("E:/" + url);
//
//			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
//
//			// 使用FileTemplateLoader
//			// 指定模板路径
//			TemplateLoader templateLoader = null;
//			templateLoader = new FileTemplateLoader(fir);
//			String tempname = "InvestContract.xml";
//
//			Configuration cfg = new Configuration();
//			cfg.setTemplateLoader(templateLoader);
//			Template t = cfg.getTemplate(tempname, "UTF-8");
//
//			t.process(contract, out);
//			out.flush();
//			out.close();
//
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
}
