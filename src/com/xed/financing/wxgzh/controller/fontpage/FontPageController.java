/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.fontpage.FontPageController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年6月1日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.fontpage;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.appconfig.AppconfigBean;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.appconfig.AppconfigService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.crowdfund.CrowdfundService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.fontpage.FontPageController
 * @description:
 * @version:v1.0.0 
 * @date:2017年6月1日 下午2:23:30
 * @author:Qian Tao
 */
@Controller
@RequestMapping("/fontpage")
public class FontPageController
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
	
	@RequestMapping("/s/queryFontPage")
	public String queryFontPageSubject(HttpServletRequest request)
	{
		SubjectBean subjectBean = new SubjectBean();
		CrowdfundBean crowdfundBean=new CrowdfundBean();
		try
		{
			//没有登录
			if(StringTools.isNullOrEmpty(request.getSession().getAttribute("account")))
			{
				request.setAttribute("newCount", (2));
			}
			else
			{
				// 从session中查询出账户ID
				String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
				
				subjectBean.setAccountId(accountId);
				int newCounts=Integer.parseInt(accountInfoService.getLoginAccountInfo(request).getNewSubjectCount());
				// 查询该用户投了多少新手专享标
				int counts = subjectService.countNewSubject(subjectBean);
				request.setAttribute("newCount", (newCounts - counts));
			}
			
			// 新手标集合
			subjectBean.setSubjectType(Constants.DEVIL_NUM_ZERO);
			request.setAttribute("newSubject", subjectService.queryFontPageSubject(subjectBean));

			// 中期理财集合
			subjectBean.setSubjectType(Constants.DEVIL_NUM_ONE);
			request.setAttribute("commonSubjcet", subjectService.queryFontPageSubject(subjectBean));

			// 实物标集合
			request.setAttribute("goodsSubjcet", subjectService.queryFontHotSubject(subjectBean));

			// 次日标集合
			subjectBean.setSubjectType(Constants.DEVIL_NUM_THREE);
			List<SubjectBean> tomorrowSubjcet=new ArrayList<SubjectBean>();
			tomorrowSubjcet=subjectService.queryFontNextSubject(subjectBean);
			for (SubjectBean subjectBean2 : tomorrowSubjcet)
			{
				//chooseFlag>0 明日  =0 今日
				if(DateUtils.daysBetween(subjectBean2.getEffectTime(), subjectBean2.getCurrentTime())==0)
				{
					subjectBean2.setChooseFlag("0");
				}
				else
				{
					subjectBean2.setChooseFlag("1");
				}
				if(DateUtils.isMorningOrAfter(subjectBean2.getEffectTime())<10)
				{
					subjectBean2.setFlag("0"+String.valueOf(DateUtils.isMorningOrAfter(subjectBean2.getEffectTime()))+":00");
				}
				else
				{
					subjectBean2.setFlag(String.valueOf(DateUtils.isMorningOrAfter(subjectBean2.getEffectTime()))+":00");
				}
				
			}
			request.setAttribute("tomorrowSubjcet", tomorrowSubjcet);

			// 爆款标集合
			subjectBean.setSubjectType(Constants.DEVIL_NUM_FOUR);
			request.setAttribute("highSubjcet", subjectService.queryFontPageSubject(subjectBean));
			
			//众筹 查询一条数据
			crowdfundBean.setLimit(Constants.DEVIL_NUM_ONE);
			request.setAttribute("crowdfund", crowdfundService.queryCrowfundList(crowdfundBean));
			
			//查询首页banner
			AppconfigBean appConfigBean=new AppconfigBean();
			appConfigBean.setPicFlag("-1");
			request.setAttribute("bannerList", appconfigService.queryAppConfig(appConfigBean));
		}
		catch (SQLException e)
		{
			logger.error("查询首页标数据异常", e);
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "fontpage/fontpage";
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
	@RequestMapping("/s/queryNewUserPage")
	public String queryNewUserPage(HttpServletRequest request)
	{
		String rst="isOk";
		try
		{
			if(!StringTools.isNullOrEmpty(request.getSession().getAttribute("account")))
			{
				CouponBean couponBean=new CouponBean();
				couponBean.setAccountId(((AccountInfo) request.getSession().getAttribute("account")).getAccountId());
				couponBean.setCouponId(paramService.getParamVal("REGISTER_COUPON_ID"));
				int a=couponService.countIsOwnerById(couponBean);
				if(a==0)
				{
					rst="isown";
				}
			}
			request.setAttribute("rst", rst);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "fontpage/newuserpage";
	}
	
	/**
	 * 跳转三级等保页面
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月26日 下午4:16:18
	 */
	@RequestMapping("/s/toThreePaul")
	public String toThreePaul(){
		
		return "fontpage/threePaul";
	}
}
