/**
 * Copyright (C) 2017 FZJT Co.Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.capital.CapitalController
 * @description:个人中心金额总览
 * 
 * @version:v1.0.0 
 * @author:WangLin
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月28日    WangLin  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.scorecenter;

import java.io.IOException;
import java.sql.SQLException;
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

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.scorecenter.ScoreCenterService;

/**
 * @className:com.xed.financing.wxgzh.controller.capital.CapitalController
 * @description:个人中心金额总览
 * @version:v1.0.0
 * @date:2017年3月28日 下午4:09:05
 * @author:WangLin
 */
@Controller
@RequestMapping("/scorecenter")
public class ScoreCenterController
{
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Autowired
	private ScoreCenterService scoreCenterService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(ScoreCenterController.class);
	
	/**
	 * 进入鱼干中心页面
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月9日 上午10:25:47
	 */
	@RequestMapping("/gotoscorecenter")
	public String goToScoreCenter(HttpServletRequest request){
		try
		{
			AccountInfo accountInfo = accountInfoService.getLoginAccountInfo(request);
			request.setAttribute("accountInfo", accountInfo);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "scorecenter/scoreCenter";
	}
	
	/**
	 * 查询鱼干明细
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @throws Exception 
	 * @date:2017年6月9日 上午10:25:47
	 */
	@RequestMapping("/queryscoredetail")
	public String queryScoreDetail(HttpServletRequest request) throws Exception{
		
		List<AccountScoreBean> getAll;
		try
		{
			AccountScoreBean accountScoreBean =new AccountScoreBean();
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			
			accountScoreBean.setAccountId(accountId);
			getAll = scoreCenterService.queryAccountScore(accountScoreBean);
			request.setAttribute("accountScoreList", getAll);
		}
		catch (SQLException e)
		{
			logger.error("查询鱼干明细列表异常", e);
		}
		return "scorecenter/scoreDetail";
	}
	
	/**
	 * 
	 * @Description:ajax异步提交
	 * @param type
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:WangLin
	 * @throws Exception 
	 * @date:2017年3月20日 下午4:45:06
	 */
	/*@RequestMapping("/getTypeQurey")*/
	@ResponseBody
	@RequestMapping(value="/getTypeQurey",method=RequestMethod.POST)
	public Map<String, Object> getTypeQurey(String type, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		List<AccountScoreBean> typeList = null;
		try
		{
			AccountScoreBean accountScoreBean =new AccountScoreBean();
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			
			accountScoreBean.setAccountId(accountId);
			accountScoreBean.setInExpend(type);	
			
			typeList = scoreCenterService.queryAccountScore(accountScoreBean);
			request.setAttribute("accountScoreList", typeList);
		}
		catch (SQLException e1)
		{
			logger.error("获取查询类型异常", e1);
		}catch (IOException e)
		{
			logger.error("获取查询类型IO异常", e);
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("typeList", typeList);
		return resultMap;
	}
	
	/**
	 * 进入鱼干中心页面
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月9日 上午10:25:47
	 */
	@RequestMapping("/gotoscoreexplain")
	public String goToScoreExplain(HttpServletRequest request){
		
		return "scorecenter/scoreExplain";
	}
}