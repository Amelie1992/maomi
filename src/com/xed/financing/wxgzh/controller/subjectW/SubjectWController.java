/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.subjectW.SubjectWController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年6月3日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.subjectW;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xed.financing.wxgzh.controller.subject.SubjectController;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.investrecord.InvestRecordService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.service.userlevel.UserLevelService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 微信菜单配置标列表  只做展示
 * @className:com.xed.financing.wxgzh.controller.subjectW.SubjectWController
 * @description:
 * @version:v1.0.0 
 * @date:2017年6月3日 下午2:18:58
 * @author:Qian Tao
 */
@Controller
@RequestMapping("/subjectW")
public class SubjectWController
{
	@Autowired
	private SubjectService subjectService;

	@Autowired
	private CapitalService capitalService;

	@Autowired
	private ParamService paramService;

	@Autowired
	private CouponService couponService;
	
	@Autowired
	private UserLevelService userLevelService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Autowired
	private InvestRecordService investRecordService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(SubjectController.class);

	/**
	 * 
	 * 查询新手标列表
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月16日 上午11:09:39
	 */
	@RequestMapping("/s/querynewsubject")
	public String queryNewSubject(HttpServletRequest request,String flag,SubjectBean subjectBean)
	{
		//如果不是下拉框选择标类型  点击个人中心的话 bean为空
		if(StringTools.isNullOrEmpty(subjectBean.getSubjectType()))
		{
			subjectBean.setSubjectType(Constants.DEVIL_NUM_ZERO);
		}
		
		//页面传什么排序字段 1利率、2金额、3期限
		if(!StringTools.isNullOrEmpty(flag))
		{
			if(Constants.DEVIL_NUM_ONE.equals(flag))
			{
				//这里随便塞值 后台不为空则会排序
				subjectBean.setSubjectRate("1");
			}
			else if(Constants.DEVIL_NUM_TWO.equals(flag))
			{
				subjectBean.setSubjectOverplusMoney("1");
			}
			else if(Constants.DEVIL_NUM_THREE.equals(flag))
			{
				subjectBean.setSubjectPeriods(1);
			}
		}
		else
		{
			flag="";
		}
		List<SubjectBean> querySubject = null;
		try
		{
			querySubject = subjectService.querySubject(subjectBean);
			
			// 集合传入页面
			request.setAttribute("subjectList", querySubject);
			request.setAttribute("types", subjectBean.getSubjectType());
			request.setAttribute("flag", flag);
		}
		catch (SQLException e)
		{
			logger.error("查询标列表异常", e);
		}

		// 跳转页面
		return "subject/subjectWlist";
	}

	/**
	 * 查询爆款标列表
	 * @Description:
	 * @param request
	 * @param flag
	 * @param subjectBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月22日 下午2:59:17
	 */
	@RequestMapping("/s/queryhighsubject")
	public String queryHighSubject(HttpServletRequest request,String flag,SubjectBean subjectBean)
	{
		//如果不是下拉框选择标类型  点击个人中心的话 bean为空
		if(StringTools.isNullOrEmpty(subjectBean.getSubjectType()))
		{
			subjectBean.setSubjectType(Constants.DEVIL_NUM_FOUR);
		}
		
		//页面传什么排序字段 1利率、2金额、3期限
		if(!StringTools.isNullOrEmpty(flag))
		{
			if(Constants.DEVIL_NUM_ONE.equals(flag))
			{
				//这里随便塞值 后台不为空则会排序
				subjectBean.setSubjectRate("1");
			}
			else if(Constants.DEVIL_NUM_TWO.equals(flag))
			{
				subjectBean.setSubjectOverplusMoney("1");
			}
			else if(Constants.DEVIL_NUM_THREE.equals(flag))
			{
				subjectBean.setSubjectPeriods(1);
			}
		}
		else
		{
			flag="";
		}
		List<SubjectBean> querySubject = null;
		try
		{
			querySubject = subjectService.querySubject(subjectBean);
			
			// 集合传入页面
			request.setAttribute("subjectList", querySubject);
			request.setAttribute("types", subjectBean.getSubjectType());
			request.setAttribute("flag", flag);
		}
		catch (SQLException e)
		{
			logger.error("查询标列表异常", e);
		}

		// 跳转页面
		return "subject/subjectWlist";
	}
	/**
	 * 跳转普通标
	 * @Description:
	 * @param request
	 * @param flag
	 * @param subjectBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月17日 下午5:07:30
	 */
	@RequestMapping("/s/querysubject")
	public String querySubject(HttpServletRequest request,String flag,SubjectBean subjectBean)
	{
		//如果不是下拉框选择标类型  点击个人中心的话 bean为空
		if(StringTools.isNullOrEmpty(subjectBean.getSubjectType()))
		{
			subjectBean.setSubjectType(Constants.DEVIL_NUM_ONE);
		}
		
		//页面传什么排序字段 1利率、2金额、3期限
		if(!StringTools.isNullOrEmpty(flag))
		{
			if(Constants.DEVIL_NUM_ONE.equals(flag))
			{
				//这里随便塞值 后台不为空则会排序
				subjectBean.setSubjectRate("1");
			}
			else if(Constants.DEVIL_NUM_TWO.equals(flag))
			{
				subjectBean.setSubjectOverplusMoney("1");
			}
			else if(Constants.DEVIL_NUM_THREE.equals(flag))
			{
				subjectBean.setSubjectPeriods(1);
			}
		}
		else
		{
			flag="";
		}
		List<SubjectBean> querySubject = null;
		try
		{
			querySubject = subjectService.querySubject(subjectBean);
			
			// 集合传入页面
			request.setAttribute("subjectList", querySubject);
			request.setAttribute("types", subjectBean.getSubjectType());
			request.setAttribute("flag", flag);
		}
		catch (SQLException e)
		{
			logger.error("查询标列表异常", e);
		}

		// 跳转页面
		return "subject/subjectWlist";
	}
	
	/**
	 * 查询次日标列表
	 * @Description:
	 * @param request
	 * @param flag
	 * @param subjectBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月31日 下午2:16:10
	 */
	@RequestMapping("/s/querynextsubject")
	public String queryNexrSubject(HttpServletRequest request,String flag,SubjectBean subjectBean)
	{
		
		//标的类型(0:新手专享标 1:普通标 2:兑换标 3:预售标 4:爆款标)
		subjectBean.setSubjectType(Constants.DEVIL_NUM_THREE);
		
		//页面传什么排序字段 1利率、2金额、3期限
		if(!StringTools.isNullOrEmpty(flag))
		{
			if(Constants.DEVIL_NUM_ONE.equals(flag))
			{
				//这里随便塞值 后台不为空则会排序
				subjectBean.setSubjectRate("1");
			}
			else if(Constants.DEVIL_NUM_TWO.equals(flag))
			{
				subjectBean.setSubjectOverplusMoney("1");
			}
			else if(Constants.DEVIL_NUM_THREE.equals(flag))
			{
				subjectBean.setSubjectPeriods(1);
			}
		}
		else
		{
			flag="";
		}
		List<SubjectBean> querySubject = null;
		try
		{
			querySubject = subjectService.querySubject(subjectBean);
			
			// 集合传入页面
			request.setAttribute("subjectList", querySubject);
			request.setAttribute("types", subjectBean.getSubjectType());
			request.setAttribute("flag", flag);
		}
		catch (SQLException e)
		{
			logger.error("查询标列表异常", e);
		}

		// 跳转页面
		return "subject/subjectnextlist";
	}
	
	/**
	 * 详情
	 * 
	 * @Description:
	 * @param request
	 * @param id
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月20日 上午9:41:14
	 */
	@RequestMapping("/s/detailsubjectW")
	public String querySubjectById(HttpServletRequest request, String id)
	{
		SubjectBean subjectBean = new SubjectBean();

		// 获取页面Id
		subjectBean.setSubjectId(id);

		List<SubjectBean> listSubjectAccount = null;
		try
		{
			// 查询标详情
			subjectBean = subjectService.querySubjectById(subjectBean);

			// 根据标ID查询投资者记录
			listSubjectAccount = subjectService.querySubjectAccount(subjectBean);

			// 查询已投资金额
			String investedMmoney = subjectService.queryInvestMoney(subjectBean).getInvestMoney();

			// 传至前台
			request.setAttribute("investedMoney", investedMmoney);
			request.setAttribute("subjectBean", subjectBean);
			request.setAttribute("listSubjectAccount", listSubjectAccount);

			CapitalBean capitalBean = new CapitalBean();
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			// 获取用户余额
			request.setAttribute("balance", (capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
			
			//查完列表初始化bean
			SubjectBean sBean = new SubjectBean();
			sBean.setAccountId(accountId);
			
			//查询该用户投了多少新手专享标
			int counts = subjectService.countNewSubject(sBean);
			if(counts>=2 && Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()))
			{
				request.setAttribute("count","over");
			}
		}
		catch (SQLException e)
		{
			logger.error("查看标详情失败", e);
		}
		return "subject/subjectdetail";
	}

}
