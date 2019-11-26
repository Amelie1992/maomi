/**
 * Copyright (C) 2015 ALLNET-IOT
 *
 *
 * @className:com.fzjt.xiao6.manager.util.DWZRespUtil
 * @description:TODO
 * 
 * @version:v1.0.0 
 * @author:GuoXiaoHu
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2015-11-17     GuoXiaoHu       v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


/**
 * DWZ帮助类
 * 
 * @className:com.fzjt.xiao6.manager.util.ViewJsonUtil
 * @description:当前主要是实现DWZ与后台交互提示信息，如添加成功、修改成功等；
 * @version:v1.0.0
 * @date:2015-11-17 下午2:21:29
 * @author:GuoXiaoHu
 */
public class ViewJsonUtil
{

	/**
	 * DWZ与后台交互提示
	 * 
	 * @Description: DWZ与后台交互提示
	 * @param statusCode
	 *            状态码 成功200，错误300，超时301
	 * @param message
	 *            提示信息
	 * @param navTabId
	 *            tabId
	 * @param callbackType
	 *            为空保持原样，关闭窗口closeCurrent，跳转forward，确认是否跳转forwardConfirm
	 * @param forwardUrl
	 *            跳转url
	 * @version:v1.0.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:35:52
	 */
	public static ModelAndView prompt(String statusCode, String message, String navTabId, String callbackType,
			String forwardUrl, String respJson)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("statusCode", statusCode);
		map.put("message", message);
		map.put("navTabId", navTabId);
		map.put("rel", "");
		map.put("callbackType", callbackType);
		map.put("forwardUrl", forwardUrl);
		map.put("respJson", respJson);
		
		return new ModelAndView(new MappingJackson2JsonView(),map);
	}

	/**
	 * 提示添加成功
	 * 
	 * @Description: DWZ提示添加成功
	 * @param navTabId
	 *            TabId
	 * @version:v1.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:54:22
	 */
	public static ModelAndView promptAddSuccess(String navTabId)
	{
		return ViewJsonUtil.prompt(Constants.DWZ_STATUS_SUCCESS, "添加成功！", navTabId, Constants.DWZ_CALLBACKTYPE_CLOSECURRENT, "", "");
	}

	/**
	 * DWZ提示添加失败
	 * 
	 * @Description: DWZ提示添加失败
	 * @param navTabId
	 *            TabId
	 * @version:v1.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:54:22
	 */
	public static ModelAndView promptAddFail(String navTabId)
	{
		return ViewJsonUtil.prompt(Constants.DWZ_STATUS_ERROR, "添加失败！", navTabId, "", "", "");
	}
	/** 
	 * @Title: promptAddFailcard 
	 * @Description: TODO
	 * @param navTabId
	 * @param msg
	 * @return
	 * @return: ModelAndView
	 */
	public static ModelAndView promptAddFailcard(String navTabId,String msg)
	{
		return ViewJsonUtil.prompt(Constants.DWZ_STATUS_ERROR, msg, navTabId, "", "", "");
	}
	public static ModelAndView promptAddFails(String navTabId)
	{
		return ViewJsonUtil.prompt(Constants.DWZ_STATUS_ERRORS, "添加失败！", navTabId, "", "", "");
	}
	
	/**
	 * DWZ提示添加失败
	 * 
	 * @Description: DWZ提示添加失败
	 * @param navTabId
	 *            TabId
	 * @version:v1.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:54:22
	 */
	public static ModelAndView promptAdd(Boolean isFlag, String navTabId)
	{
		return isFlag ? promptAddSuccess(navTabId):promptAddFail(navTabId);
	}
	
	public static ModelAndView promptAdd(Boolean isFlag)
	{
		return isFlag ? promptAddSuccess(""):promptAddFail("");
	}
	/** 
	 * @Title: promptAddFailType 
	 * @Description: TODO
	 * @param isFlag
	 * @return
	 * @return: ModelAndView
	 */
	public static ModelAndView promptAddFailType(String isFlag)
	{
		if("1".equals(isFlag)){
			return promptAddSuccess("");
		}
		if("2".equals(isFlag)){
			return promptAddFailcard("","此公司该类型卡已经存在");
		}
		//失败
		if("3".equals(isFlag)){
			return promptAddFail("");
		}
		return null;
	}
	
	/** 
	 * @Title: promptAddFailType 
	 * @Description: TODO
	 * @param isFlag
	 * @return
	 * @return: ModelAndView
	 */
	public static ModelAndView promptExitFailType(String isFlag)
	{
		if("1".equals(isFlag)){
			return promptEditSuccess("");
		}
		if("2".equals(isFlag)){
			return promptAddFailcard("","此公司该类型卡已经存在");
		}
		//失败
		if("3".equals(isFlag)){
			return promptEditFail("");
		}
		return null;
	}
	
	
	
	
	
	public static ModelAndView promptAdds(Boolean isFlag)
	{
		return isFlag ? promptAddSuccess(""):promptAddFails("");
	}
	/**
	 * DWZ提示修改成功
	 * 
	 * @Description: DWZ提示修改成功
	 * @param navTabId
	 *            TabId
	 * @version:v1.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:54:22
	 */
	public static ModelAndView promptEditSuccess(String navTabId)
	{
		return ViewJsonUtil.prompt(Constants.DWZ_STATUS_SUCCESS, "修改成功！", navTabId, Constants.DWZ_CALLBACKTYPE_CLOSECURRENT, "", "");
	}

	/**
	 * DWZ提示修改失败
	 * 
	 * @Description: DWZ提示修改失败
	 * @param navTabId
	 *            TabId
	 * @version:v1.0.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:54:22
	 */
	public static ModelAndView promptEditFail(String navTabId)
	{
		return ViewJsonUtil.prompt(Constants.DWZ_STATUS_ERROR, "修改失败！", navTabId, "", "", "");
	}

	/**
	 * DWZ提示删除成功
	 * 
	 * @Description: DWZ提示修改成功
	 * @param navTabId
	 *            TabId
	 * @version:v1.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:54:22
	 */
	public static ModelAndView promptDeleteSuccess(String navTabId)
	{
		return ViewJsonUtil.prompt(Constants.DWZ_STATUS_SUCCESS, "删除成功！", navTabId, "", "", "");
	}

	/**
	 * DWZ提示修改失败
	 * 
	 * @Description: DWZ提示修改失败
	 * @param navTabId
	 *            TabId
	 * @version:v1.0.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:54:22
	 */
	public static ModelAndView promptDeleteFail(String navTabId)
	{
		return ViewJsonUtil.prompt(Constants.DWZ_STATUS_ERROR, "删除失败！", navTabId, "", "", "");
	}

	/**
	 * DWZ修改提示
	 * 
	 * @Description: DWZ修改提示
	 * @param navTabId
	 *            TabId
	 * @param isFlag
	 *            true修改成功，false修改失败
	 * @version:v1.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:54:22
	 */
	public static ModelAndView promptEdit(String navTabId, Boolean isFlag)
	{
		return isFlag ? promptEditSuccess(navTabId) : promptEditFail(navTabId);
	}
	
	public static ModelAndView promptEdit(Boolean isFlag)
	{
		return isFlag ? promptEditSuccess("") : promptEditFail("");
	}

	/**
	 * DWZ删除提示
	 * 
	 * @Description: DWZ删除提示
	 * @param navTabId
	 *            TabId
	 * @param isFlag
	 *            true修改成功，false修改失败
	 * @version:v1.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:54:22
	 */
	public static ModelAndView promptDelete(String navTabId, Boolean isFlag)
	{
		return isFlag ? promptDeleteSuccess(navTabId) : promptDeleteFail(navTabId);
	}
	
	public static ModelAndView promptDelete(Boolean isFlag)
	{
		return isFlag ? promptDeleteSuccess("") : promptDeleteFail("");
	}
	
	/**
	 * DWZ错误提示
	 * 
	 * @Description: DWZ错误提示
	 * @param navTabId
	 *            TabId
	 * @param message
	 *            提示信息
	 * @version:v1.0.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:57:10
	 */
	public static ModelAndView promptError(String navTabId, String message)
	{
		return ViewJsonUtil.prompt(Constants.DWZ_STATUS_ERROR, message, navTabId, "", "", "");
	}

	/**
	 * 页面提示操作信息
	 * 
	 * @Description:
	 * @param isFlag
	 *            true成功，false失败
	 * @param message
	 *            提示信息
	 * @version:v1.0.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-23 上午10:19:36
	 */
	public static ModelAndView promptMessage(Boolean isFlag, String message)
	{
		return ViewJsonUtil.prompt(isFlag ? Constants.DWZ_STATUS_SUCCESS : Constants.DWZ_STATUS_ERROR, message, "",
				Constants.DWZ_CALLBACKTYPE_CLOSECURRENT, "", "");
	}

	/**
	 * 页面提示操作信息
	 * 
	 * @Description:
	 * @param isFlag
	 *            true成功，false失败
	 * @param message
	 *            提示信息
	 * @version:v1.0.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-23 上午10:19:36
	 */
	public static ModelAndView promptMessage(Boolean isFlag, String message, String respJson)
	{
		return ViewJsonUtil.prompt(isFlag ? Constants.DWZ_STATUS_SUCCESS : Constants.DWZ_STATUS_ERROR, message, "",
				Constants.DWZ_CALLBACKTYPE_CLOSECURRENT, "", respJson);
	}
	
	public static ModelAndView promptMessage(Boolean isFlag, String state, String message, String respJson)
	{
		return ViewJsonUtil.prompt(isFlag ? Constants.DWZ_STATUS_SUCCESS : state, message, "",
				Constants.DWZ_CALLBACKTYPE_CLOSECURRENT, "", respJson);
	}


	/**
	 * DWZ与后台交互提示
	 *
	 * @Description: DWZ与后台交互提示
	 * @param statusCode
	 *            状态码 成功200，错误300，超时301
	 * @param message
	 *            提示信息
	 * @param navTabId
	 *            tabId
	 * @param callbackType
	 *            为空保持原样，关闭窗口closeCurrent，跳转forward，确认是否跳转forwardConfirm
	 * @param forwardUrl
	 *            跳转url
	 * @version:v1.0.0
	 * @author:GuoXiaoHu
	 * @date:2015-11-17 下午2:35:52
	 */
	public static ModelAndView promptByQt(Boolean statusCode, String message, String navTabId, String callbackType,
									  String forwardUrl, String respJson)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("statusCode", statusCode?Constants.DWZ_STATUS_SUCCESS : Constants.DWZ_STATUS_ERROR);
		map.put("message", message);
		map.put("navTabId", navTabId);
		map.put("callbackType", callbackType);
		map.put("forwardUrl", forwardUrl);
		map.put("respJson", respJson);

		return new ModelAndView(new MappingJackson2JsonView(),map);
	}
}
