package com.xed.financing.wxgzh.controller.subjectdispersed;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xed.financing.wxgzh.model.subjectdispersed.SubjectDispersedBean;
import com.xed.financing.wxgzh.service.subjectdispersed.SubjectDispersedService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 分散标控制器
 * @className:com.xed.financing.wxgzh.controller.subjectdispersed.SubjectDispersedController
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月12日 下午1:45:42
 * @author:Peng Gang
 */

@Controller
@RequestMapping("/subjectdispersed")
public class SubjectDispersedController
{
	@Autowired
	private SubjectDispersedService subjectDispersedService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(SubjectDispersedController.class);
	/**
	 * 跳转分散标主页
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月12日 下午1:48:25
	 */
	@RequestMapping("/querySubjectDispersedHomepage")
	public String querySubjectDispersedHomepage(Model model,String freedomSubjectId){
		
		//跟踪状态为0的标
		int count = 0;
		
		//跟踪所有类型标的数量 和 金额
		SubjectDispersedBean s0=new SubjectDispersedBean();
		SubjectDispersedBean s1=new SubjectDispersedBean();
		SubjectDispersedBean s2=new SubjectDispersedBean();
		//(0:质押标 1:抵押标 2:信用贷)
		s0.setSubjectType(Constants.DEVIL_NUM_ZERO);
		s1.setSubjectType(Constants.DEVIL_NUM_ONE);
		s2.setSubjectType(Constants.DEVIL_NUM_TWO);
		try
		{
			
			//获取所有标的状态为0的标  筹标中 的数量
			count = subjectDispersedService.queryiIsStatus();
			
			//质押标
			s0 = subjectDispersedService.querySubjectOnTypesAndMonry(s0);
			s0.setTypeCountPercentage(MoneyUtils.formatFloatNumber(Double.parseDouble(s0.getTypeCount())*100/count));
			
			//抵押标
			s1 = subjectDispersedService.querySubjectOnTypesAndMonry(s1);
			s1.setTypeCountPercentage(MoneyUtils.formatFloatNumber(Double.parseDouble(s1.getTypeCount())*100/count));
			
			//信用贷
			s2 = subjectDispersedService.querySubjectOnTypesAndMonry(s2);
			s2.setTypeCountPercentage(MoneyUtils.formatFloatNumber(Double.parseDouble(s2.getTypeCount())*100/count));
			
		}
		catch (SQLException e)
		{
			logger.error("查询跳转分散标详情异常！", e);
		}
		model.addAttribute("count", count);
		model.addAttribute("s0", s0);
		model.addAttribute("s1", s1);
		model.addAttribute("s2", s2);
		model.addAttribute("freedomSubjectId", freedomSubjectId);
		
		return "freedomsubject/dispersionsubject";
	}
	
	/**
	 * 跳转分散标列表
	 * @Description:
	 * @param model
	 * @param subjectDispersedBean
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月12日 下午6:10:47
	 */
	@RequestMapping("/querySubjectDispered")
	public String querySubjectDispered(Model model,SubjectDispersedBean subjectDispersedBean,String freedomSubjectId)
	{
		List<SubjectDispersedBean> rspList=null;
		try
		{
			if(StringTools.isNullOrEmpty(subjectDispersedBean.getSubjectType()))
			{
				//第一次默认进I类标
				subjectDispersedBean.setSubjectType(Constants.DEVIL_NUM_ZERO);
			}
			rspList = subjectDispersedService.queryDispersedSubjectList(subjectDispersedBean);
			for (SubjectDispersedBean sBean : rspList)
			{
				if(sBean.getmCount()>sBean.getSubjectPeriods())
				{
					sBean.setmCount(sBean.getSubjectPeriods());
					sBean.setSubjectStatus("1");
				}
			}
			model.addAttribute("subjectList", rspList);
			model.addAttribute("types", subjectDispersedBean.getSubjectType());
			model.addAttribute("freedomSubjectId", freedomSubjectId);
		}
		catch (SQLException e)
		{
			logger.error("查询分散标列表异常！", e);
		}
		
		return "freedomsubject/dispersionsubjectlist";
	}
	
	/**
	 * 详情
	 * @Description:
	 * @param model
	 * @param subjectDispersedBean
	 * @param freedomSubjectId
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月13日 下午2:45:24
	 */
	@RequestMapping("/detailSubjectDispered")
	public String detailSubjectDispered(Model model,SubjectDispersedBean subjectDispersedBean,String freedomSubjectId)
	{
		try
		{
			//详情
			subjectDispersedBean=subjectDispersedService.queryDispersedSubjectListById(subjectDispersedBean);
			
			
			//分散标投资记录
			List<SubjectDispersedBean> rspList=subjectDispersedService.queryFreedomInvest(subjectDispersedBean);
			
			
			model.addAttribute("aMoney", subjectDispersedService.countInvestMoneyById(subjectDispersedBean));
			model.addAttribute("listSubjectAccount", rspList);
			model.addAttribute("subjectBeans", subjectDispersedBean);
			model.addAttribute("freedomSubjectId", freedomSubjectId);
		}
		catch (SQLException e)
		{
			logger.error("查询分散标列表异常！", e);
		}
		
		return "freedomsubject/dispersionsubjectdetail";
	}
}
