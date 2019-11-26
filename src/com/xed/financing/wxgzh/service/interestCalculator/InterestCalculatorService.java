package com.xed.financing.wxgzh.service.interestCalculator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xed.financing.wxgzh.model.subject.SubjectBean;


public interface InterestCalculatorService {
	/**
	 * 查询还款计划
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2018年2月23日 下午3:32:50
	 */
	public void queryRepaymentPlan(HttpServletRequest request,SubjectBean subjectBean,String accountLevel,Map<String,Object> resultMap) throws Exception;
}
