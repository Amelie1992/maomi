/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.fontpage.FontpageInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:penggang
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月12日    penggang  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.fontpage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.controller.fontpage.FontPageController;
import com.xed.financing.wxgzh.model.appconfig.AppconfigBean;
import com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.appconfig.AppconfigService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.crowdfund.CrowdfundService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 首页
 * @className:com.xed.financing.wxgzh.controller.intface.fontpage.FontpageInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月12日 上午10:04:14
 * @author:penggang
 */
@Controller
@RequestMapping("/ios/fontpage")
public class FontpageInterfaceController
{
	@Autowired
	private SubjectService subjectService;
	
	@Autowired 
	private AccountInfoService accountInfoService;
	
	@Autowired 
	private CrowdfundService crowdfundService; 
	
	@Autowired
	private ParamService paramService;
	
	@Autowired
	private CouponService couponService;

	@Autowired
	private AppconfigService appconfigService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(FontPageController.class);
	
	/**
	 * 访问首页
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年4月12日 上午10:09:19
	 */
	@RequestMapping("/fontpages")
	@ResponseBody
	public JSONObject queryFontPageSubject(String accountId)
	{
		JSONArray jsonArray = new JSONArray();
		JSONObject obj = new JSONObject();
		
		SubjectBean subjectBean = new SubjectBean();
		CrowdfundBean crowdfundBean=new CrowdfundBean();
		//新手标可投次数
		int newCount;
		try
		{
			//没有登录
			if(StringTools.isNullOrEmpty(accountId))
			{
				newCount=2;
			}
			else
			{
				subjectBean.setAccountId(accountId);
				int newCounts=Integer.parseInt(accountInfoService.iosGetLoginAccountInfo(accountId).getNewSubjectCount());
				// 查询该用户投了多少新手专享标
				int counts = subjectService.countNewSubject(subjectBean);
				newCount=newCounts - counts;
			}
			
			// 新手标集合
			subjectBean.setSubjectType(Constants.DEVIL_NUM_ZERO);
			List<SubjectBean> newsList=subjectService.queryFontPageSubject(subjectBean);

			// 中期理财集合
			subjectBean.setSubjectType(Constants.DEVIL_NUM_ONE);
			List<SubjectBean> commonsList=subjectService.queryFontPageSubject(subjectBean);

			// 爆款标集合
			subjectBean.setSubjectType(Constants.DEVIL_NUM_FOUR);
			List<SubjectBean> highsList=subjectService.queryFontPageSubject(subjectBean);
			
			//众筹 查询一条数据
			crowdfundBean.setLimit(Constants.DEVIL_NUM_ONE);
			List<CrowdfundBean> crowdList=crowdfundService.queryCrowfundList(crowdfundBean);
			
			//首页bannner图
			AppconfigBean appconfigBean=new AppconfigBean();
			//appconfigBean.setPicFlag(Constants.DEVIL_NUM_ZERO);
			List<AppconfigBean> appPicList=appconfigService.queryAppConfig(appconfigBean);
			
			// 次日标集合
			subjectBean.setSubjectType(Constants.DEVIL_NUM_THREE);
			List<SubjectBean>  tomorrowSubjcet = subjectService.queryFontNextSubject(subjectBean);
			
			obj.put("msg", "");
			obj.put("code", 200);
			JSONObject objs = new JSONObject();
			objs.put("newsList", newsList);
			objs.put("commonsList", commonsList);
			objs.put("highsList", highsList);
			objs.put("crowdList", crowdList);
			objs.put("appPicList", appPicList);
			objs.put("tomorrowSubjcet", tomorrowSubjcet);
			objs.put("newCount", newCount);
			obj.put("data",objs);
		}
		catch (SQLException e)
		{
			logger.error("查询首页标数据异常", e);
		}

		return obj;
	}
	
	/**
	 * 新手四重礼
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年1月19日 下午2:33:50
	 */
//	@RequestMapping("/s/queryNewUserPage")
//	public String queryNewUserPage(HttpServletRequest request)
//	{
//		String rst="isOk";
//		try
//		{
//			if(!StringTools.isNullOrEmpty(request.getSession().getAttribute("account")))
//			{
//				CouponBean couponBean=new CouponBean();
//				couponBean.setAccountId(((AccountInfo) request.getSession().getAttribute("account")).getAccountId());
//				couponBean.setCouponId(paramService.getParamVal("REGISTER_COUPON_ID"));
//				int a=couponService.countIsOwnerById(couponBean);
//				if(a==0)
//				{
//					rst="isown";
//				}
//			}
//			request.setAttribute("rst", rst);
//		}
//		catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "fontpage/newuserpage";
//	}
	
	
}
