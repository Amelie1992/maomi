/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.playRecord.PlayRecordController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月15日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.playRecord;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;
import com.xed.financing.wxgzh.model.playRecord.PlayRecordBean;
import com.xed.financing.wxgzh.service.playRecord.PlayRecordService;

/**
 * 游戏记录controller
 * 
 * @className:com.xed.financing.wxgzh.controller.playRecord.PlayRecordController
 * @description:
 * @version:v1.0.0
 * @date:2017年3月15日 下午2:50:27
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/playRecord")
public class PlayRecordController
{
	@Autowired
	private PlayRecordService playRecordService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(PlayRecordController.class);

	
	@RequestMapping("/s/goxiongchumo")
	public String queryFreedomSubject(HttpServletRequest request,FreedomSubjectBean freedomSubjectBean)
	{
		return "xiongchumo/index";
	}
	
	/*@RequestMapping("/s/submit")
	@ResponseBody
	public Map<String, Object> submit(HttpServletRequest request, HttpServletResponse response, String name,String telephone){
		Map<String, Object> resutMap = new HashMap<String, Object>();
		Integer result = 0 ;
		try
		{
			PlayRecordBean playRecord = new PlayRecordBean();
			playRecord.setName(name);
			playRecord.setTelephone(telephone);
			request.getSession().setAttribute("playRecord", playRecord);
			result = 1 ;
			resutMap.put("result", result);
		}
		catch (Exception e)
		{
			logger.error("猫咪宝提现模块异常", e);
		}
		return resutMap;
	}*/
	
	
	
	/**
	 * 成绩提交
	 * @Description:
	 * @param request
	 * @param response
	 * @param bestScore
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年9月8日 下午2:21:58
	 */
	/*@RequestMapping("/s/subResults")*/
	@ResponseBody
	@RequestMapping(value="/s/subResults",method=RequestMethod.POST)
	public Map<String, Object> subResults(HttpServletRequest request, HttpServletResponse response, String bestScore,String name,String telephone){
		Map<String, Object> resutMap = new HashMap<String, Object>();
		Integer result = 0 ;
		try
		{
			if(name!= null && !"".equals(name) && telephone!= null && !"".equals(telephone)){
				PlayRecordBean playRecord = new PlayRecordBean();
				playRecord.setName(name);
				playRecord.setTelephone(telephone);
				playRecord.setScore(bestScore);
				result = playRecordService.addPlayRecord(playRecord);
			}
			resutMap.put("result", result);
		}
		catch (Exception e)
		{
			logger.error("猫咪宝提现模块异常", e);
		}
		return resutMap;
	}
	
	/**
	 * 转排行榜
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月19日 上午11:24:39
	 */
	@ResponseBody
	@RequestMapping(value="/s/sortingScore",method=RequestMethod.POST)
	public Map<String, Object> SortingScore(HttpServletRequest request, HttpServletResponse response,PlayRecordBean playRecordBean){
		List<PlayRecordBean> playRecordBeanList = null;
		Map<String, Object> resutMap = new HashMap<String, Object>();
		try
		{
			playRecordBeanList = playRecordService.queryPlayRecordBeanList();
			if(!"".equals(playRecordBean.getTelephone())&&!"".equals(playRecordBean.getName())){
				playRecordBean = playRecordService.selPlayRecordBean(playRecordBean);
				resutMap.put("playRecordBean", playRecordBean);
			}
			resutMap.put("playRecordBeanList", playRecordBeanList);
		}
		catch (Exception e)
		{
			logger.error("游戏排行榜模块异常", e);
		}
		return resutMap;
	}
	
	
}
