package com.xed.financing.wxgzh.service.interestCalculator.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.interestCalculator.InterestCalculatorService;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.LevelParam;
import com.xed.financing.wxgzh.util.MoneyUtils;

@Service
public class InterestCalculatorServiceImpl implements InterestCalculatorService{
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(InterestCalculatorServiceImpl.class);

	@Override
	public void queryRepaymentPlan(HttpServletRequest request,SubjectBean subjectBean, String accountLevel,Map<String, Object> resultMap) throws Exception {
		try 
		{
			//投资金额
			String investMoney=MoneyUtils.formatFloatNumber(Double.valueOf(subjectBean.getInvestMoney()));
			investMoney = investMoney.substring(0, investMoney.indexOf("."));
			//年化利率
			Double subjectRate=Double.valueOf(subjectBean.getSubjectRate())/100;
			//vip利率
			Double vipRate=Double.valueOf(subjectBean.getVipRate())/100;
			//用户等级
			String level=accountLevel.substring(3);
			//利息管理费利率
			Double interestManagement=LevelParam.LEVEL_MANAGEMENT_INTEREST.get(level)/100;
			//借款类型
			String subjectTerm=subjectBean.getSubjectTerm();
			//投资时长
			Integer subjectPeriods=Integer.valueOf(subjectBean.getSubjectPeriods());
			//还款方式
			String repeatType=subjectBean.getRepeatType();
			List<SubjectBean> subjectBeanList=new ArrayList<SubjectBean>();
			
			//当前时间
			Date date=new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String now=df.format(date);
			
			//--------------------VIP奖励-------------------
			String vipMoney=MoneyUtils.formatFloatNumber(Double.valueOf(investMoney)*vipRate);
			resultMap.put("vipMoney", vipMoney);
			
			//利息收入
			String sumlixi;
			//利息管理费
			String sumInterestManagement;
			//实际收益
			String realIncome;
			//等额本息
			if("0".equals(repeatType)){
				//本金(元)=投资金额/投资时长
				String principal= MoneyUtils.formatFloatNumber(Double.valueOf(investMoney)/(subjectPeriods));
				//剩余金额(分)
				String surplus =investMoney;
				Double sumInterest=0.0;
				//循环添加
				for (int i = 0; i < subjectPeriods; i++) {
					SubjectBean subjectBean2=new SubjectBean();
					//最后一期
					if(i+1==subjectPeriods){
						principal = surplus;
					}
					//本金
					subjectBean2.setPrincipal(principal);
					//利息 =剩余金额*(年化利率+vip利率)-利息管理费
					Double lixi=Double.parseDouble(surplus)*(subjectRate+vipRate)/12;
					sumInterest+=Double.valueOf(lixi);
					String interest = MoneyUtils.formatFloatNumber(Double.parseDouble(surplus)*(subjectRate+vipRate)/12*(1-interestManagement));
					//利息
					subjectBean2.setInterest(interest);
					
					//还款总额
					subjectBean2.setTotalRepayment(MoneyUtils.formatFloatNumber(Double.valueOf(principal)+Double.valueOf(interest)));
					//应还时间
					String repaymentTime=DateUtils.GetSysDate("yyyy-MM-dd", now, 0, i+1, 0);
					subjectBean2.setRepaymentTime(repaymentTime);
					//将bean添加到list中
					subjectBeanList.add(subjectBean2);
					//剩余金额=剩余金额-应还本金
					surplus = MoneyUtils.formatFloatNumber(Double.valueOf(surplus)-Double.valueOf(principal));
				}
				//-----------list放入map中------------------
				resultMap.put("subjectBeans", subjectBeanList);
				
				//----------------利息收入---------------
				sumlixi=MoneyUtils.formatFloatNumber(sumInterest);
				resultMap.put("sumlixi", sumlixi);
				
				//----------------利息管理费--------------
				sumInterestManagement=MoneyUtils.formatFloatNumber(sumInterest*interestManagement);
				resultMap.put("interestManagementFee", sumInterestManagement);
				
				//----------------实际收益----------------
				realIncome=MoneyUtils.formatFloatNumber(Double.parseDouble(sumlixi)-Double.parseDouble(sumInterestManagement));
				resultMap.put("realIncome", realIncome);
				
			//先息后本	
			}else if("1".equals(repeatType)){
				//利息(元)=借款金额*贷款利率
				Double interest=Double.parseDouble(investMoney)*(subjectRate+vipRate)/12*(1-interestManagement);
				//循环添加
				for (int i = 0; i < subjectPeriods; i++) {
					SubjectBean subjectBean2=new SubjectBean();
					//应还时间
					String repaymentTime=DateUtils.GetSysDate("yyyy-MM-dd", now, 0, i+1, 0);
					subjectBean2.setRepaymentTime(repaymentTime);
					//最后一期
					if(i+1==subjectPeriods){
						//本金=借款金额
						subjectBean2.setPrincipal(investMoney);
						//利息 
						subjectBean2.setInterest(MoneyUtils.formatFloatNumber(interest));
						//应还总额=借款金额+应还利息
						Double totalRepayment=Double.parseDouble(investMoney)+interest;
						subjectBean2.setTotalRepayment(MoneyUtils.formatFloatNumber(totalRepayment));
					}else{
						//本金=借款金额
						subjectBean2.setPrincipal("0");
						//利息 
						subjectBean2.setInterest(MoneyUtils.formatFloatNumber(interest));
						//应还总额=应还利息
						subjectBean2.setTotalRepayment(MoneyUtils.formatFloatNumber(interest));
					}
					subjectBeanList.add(subjectBean2);
				}
				//-----------list放入map中------------------
				resultMap.put("subjectBeans", subjectBeanList);
				
				//----------------利息收入---------------
				sumlixi=MoneyUtils.formatFloatNumber(Double.parseDouble(investMoney)*(subjectRate+vipRate)/12*subjectPeriods);
				resultMap.put("sumlixi", sumlixi);
				
				//----------------利息管理费--------------
				sumInterestManagement=MoneyUtils.formatFloatNumber(Double.valueOf(sumlixi)*interestManagement);
				resultMap.put("interestManagementFee", sumInterestManagement);
				
				//----------------实际收益----------------
				realIncome=MoneyUtils.formatFloatNumber(Double.parseDouble(sumlixi)-Double.valueOf(sumInterestManagement));
				resultMap.put("realIncome", realIncome);
				
			//到期还本付息	
			}else if("2".equals(repeatType)){
				SubjectBean subjectBean2=new SubjectBean();
				Double interest=0.0;
				//期限类型是天
				if("0".equals(subjectTerm)){
					//应还时间
					String repaymentTime=DateUtils.GetSysDate("yyyy-MM-dd", now, 0, 0, subjectPeriods);
					subjectBean2.setRepaymentTime(repaymentTime);
					//应还本金
					subjectBean2.setPrincipal(investMoney);;
					//应还利息(分)=借款金额*贷款年利率*天数
					interest=Double.parseDouble(investMoney)*(subjectRate+vipRate)/365*subjectPeriods;
					Double money=interest*(1-interestManagement);
					subjectBean2.setInterest(MoneyUtils.formatFloatNumber(money));
					//应还总额=应还本金+应还利息
					Double totalRepayment=Double.parseDouble(investMoney)+money;
					subjectBean2.setTotalRepayment(MoneyUtils.formatFloatNumber(totalRepayment));
					
				}else{
					//应还时间
					String repaymentTime=DateUtils.GetSysDate("yyyy-MM-dd", now, 0, subjectPeriods, 0);
					subjectBean2.setRepaymentTime(repaymentTime);
					//应还本金
					subjectBean2.setPrincipal(investMoney);
					//应还利息(分)=借款金额*贷款利率
					interest=Double.parseDouble(investMoney)*(subjectRate+vipRate)/12*subjectPeriods;
					Double money=interest*(1-interestManagement);
					subjectBean2.setInterest(MoneyUtils.formatFloatNumber(money));
					//应还总额=应还本金+应还利息
					Double totalRepayment=Double.parseDouble(investMoney)+money;
					subjectBean2.setTotalRepayment(MoneyUtils.formatFloatNumber(totalRepayment));
				}
				//执行回款记录添加方法
				subjectBeanList.add(subjectBean2);
				
				//-----------list放入map中------------------
				resultMap.put("subjectBeans", subjectBeanList);
				
				//----------------利息收入---------------
				sumlixi=MoneyUtils.formatFloatNumber(interest);
				resultMap.put("sumlixi", sumlixi);
				
				//----------------利息管理费--------------
				sumInterestManagement=MoneyUtils.formatFloatNumber(interest*interestManagement);
				resultMap.put("interestManagementFee", sumInterestManagement);
				
				//----------------实际收益----------------
				realIncome=MoneyUtils.formatFloatNumber(Double.parseDouble(sumlixi)-Double.valueOf(sumInterestManagement));
				resultMap.put("realIncome", realIncome);
			}
		} catch (Exception e) {
			logger.error("查询还款计划异常");
			throw new RuntimeException();
		}
	}

}
