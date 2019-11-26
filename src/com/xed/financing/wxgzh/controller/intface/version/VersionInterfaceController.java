/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.version.VersionInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年6月7日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xed.financing.wxgzh.model.version.VersionBean;
import com.xed.financing.wxgzh.service.version.VersionService;

/**
 * @className:com.xed.financing.wxgzh.controller.intface.version.VersionInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年6月7日 下午4:22:02
 * @author:QT
 */
@Controller
@RequestMapping("/ios/version")
public class VersionInterfaceController
{
	@Autowired
	private VersionService versionService;
	
	/**
	 * 
	 * @Description:
	 * @param accountId
	 * @param flag
	 * @param subjectType
	 * @param fromNum
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年6月7日 下午4:33:09
	 */
	@ResponseBody
	@RequestMapping("/toversion")
	public JSONObject queryNewSubject(String verType,String verCode)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "查询版本号异常";
		int code = 300;
		VersionBean vBean=new VersionBean();
		//版本类型(0安卓 1 ios)
		vBean.setVerType(verType);
		try
		{
			vBean=versionService.queryNewVersion(vBean);
			if(verCode.equals(vBean.getVerCode()))
			{
				msg="当前是最新版本";
				code=301;
			}
			else
			{
				msg="有版本更新";
				code=200;
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		obj.put("msg", msg);
		obj.put("code", code);
		obj.put("vBean", vBean);
		return obj;
	}
}
