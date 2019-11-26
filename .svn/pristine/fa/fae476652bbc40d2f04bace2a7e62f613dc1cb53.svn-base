package com.xed.financing.wxgzh.controller.interestCalculator;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.interestCalculator.InterestCalculatorService;

/**
 * 利息计算器controller
 * @className:com.xed.financing.pc.controller.interestCalculator.InterestCalculatorController
 * @description:
 * @version:v1.0.0 
 * @date:2018年2月23日 上午11:26:56
 * @author:Zhouweinan
 */
@Controller
@RequestMapping("/interestCalculator")
public class InterestCalculatorController {
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(InterestCalculatorController.class);
	
	@Autowired
	private InterestCalculatorService interestCalculatorService;
	
	
	/**
	 * 跳转利息计算器页面
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2018年2月23日 上午11:29:28
	 */
	@RequestMapping("/s/toInterestCalculator")
	public String toInterestCalculator(HttpServletRequest request){
		try 
		{
			
		} catch (Exception e) {
			logger.error("跳转利息计算器页面异常", e);
		}
		return "interestcalculator/interestCalculator";
	}
	
	/**
	 * 计算结果
	 * @Description:
	 * @param request
	 * @param subjectBean
	 * @param accountLevel
	 * @return
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2018年2月24日 上午9:54:22
	 */
	@ResponseBody
	@RequestMapping("/s/jisuan")
	public Map<String, Object> jisuan(HttpServletRequest request,SubjectBean subjectBean,String accountLevel){
		Map<String, Object> resultMap = new HashMap<String , Object>();
		try 
		{
			interestCalculatorService.queryRepaymentPlan(request, subjectBean, accountLevel, resultMap);
			
		} catch (Exception e) {
			logger.error("利息结果异常", e);
		}
		return resultMap;
	}
	
	/**
	 * 查看还款计划
	 * @Description:
	 * @param request
	 * @param subjectBean
	 * @param accountLevel
	 * @return
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2018年3月14日 下午3:29:20
	 */
	@RequestMapping("/s/toRepaymentPlan")
	public String toRepaymentPlan(HttpServletRequest request,SubjectBean subjectBean,String accountLevel){
		Map<String, Object> resultMap = new HashMap<String , Object>();
		try 
		{
			interestCalculatorService.queryRepaymentPlan(request, subjectBean, accountLevel, resultMap);
			//将参数传到前台
			request.setAttribute("resultMap", resultMap);
			
		} catch (Exception e) {
			logger.error("跳转还款计划异常", e);
		}
		
		return "interestcalculator/repaymentPlan";
	}
	
}
