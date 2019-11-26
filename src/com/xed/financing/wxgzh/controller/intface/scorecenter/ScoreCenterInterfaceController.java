package com.xed.financing.wxgzh.controller.intface.scorecenter;

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

import com.xed.financing.wxgzh.controller.scorecenter.ScoreCenterController;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.scorecenter.ScoreCenterService;
import com.xed.financing.wxgzh.util.JsonUtil;

import net.sf.json.JSONObject;

/**
 * 鱼干中心
 * @className:com.xed.financing.wxgzh.controller.intface.scorecenter.ScoreCenterInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月24日 上午11:21:03
 * @author:zheng shuai
 */
@Controller
@RequestMapping("/ios/scorecenter")
public class ScoreCenterInterfaceController
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
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/scorecenter/gotoscorecenter?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月24日 上午9:42:28
	 */
	@ResponseBody
	@RequestMapping("/gotoscorecenter")
	public JSONObject goToScoreCenter(String accountId){
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			JSONObject objs = new JSONObject();
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			msg = "";
			code = "200";
			objs.put("accountInfo", JsonUtil.beanToJson(accountInfo));
			obj.put("data",objs);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 查询鱼干明细
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/scorecenter/queryscoredetail?accountId=
	 * @param accountId
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月24日 上午9:48:24
	 */
	@ResponseBody
	@RequestMapping("/queryscoredetail")
	public JSONObject queryScoreDetail(String accountId) throws Exception{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			JSONObject objs = new JSONObject();
			AccountScoreBean accountScoreBean =new AccountScoreBean();
			accountScoreBean.setAccountId(accountId);
			List<AccountScoreBean>  getAll = scoreCenterService.queryAccountScore(accountScoreBean);
			msg = "";
			code = "200";
			objs.put("accountScoreList", JsonUtil.listToJson(getAll));
			obj.put("data",objs);
		}
		catch (SQLException e)
		{
			logger.error("查询鱼干明细列表异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 根据鱼干交易类型查询鱼干明细
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/scorecenter/getTypeQurey?accountId=&type=
	 * @param accountId
	 * @param type
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月24日 上午11:41:33
	 */
	@ResponseBody
	@RequestMapping("/getTypeQurey")
	public JSONObject getTypeQurey(String accountId,String type) throws Exception
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			JSONObject objs = new JSONObject();
			AccountScoreBean accountScoreBean =new AccountScoreBean();
			accountScoreBean.setAccountId(accountId);
			accountScoreBean.setInExpend(type);	
			List<AccountScoreBean> typeList = scoreCenterService.queryAccountScore(accountScoreBean);
			msg = "";
			code = "200";
			objs.put("typeList", JsonUtil.listToJson(typeList));
			obj.put("data",objs);
		}
		catch (SQLException e1)
		{
			logger.error("获取查询类型异常", e1);
		}catch (IOException e)
		{
			logger.error("获取查询类型IO异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
}
