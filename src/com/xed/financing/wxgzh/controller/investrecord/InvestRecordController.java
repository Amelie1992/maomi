/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.investrecord.InvestRecordController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月23日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.investrecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.couponDetail.CouponDetail;
import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.investrecord.InvestRecordService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.revenueSettlement.RevenueSettlementService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.investrecord.InvestRecordController
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月23日 下午5:06:10
 * @author:Qian Tao
 */
@Controller 
@RequestMapping("/investrecord")
public class InvestRecordController
{
	@Autowired
	private InvestRecordService investRecordService;
	
	@Autowired
	private ParamService paramService;
	
	@Autowired
	private AccountInfoService accountInfoService; 
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private RevenueSettlementService revenueSettlementService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(InvestRecordController.class);
	
	/**
	 * 查询我的投标列表
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月23日 下午5:08:56
	 */
	@RequestMapping("/queryinvest")
	public String queryInvestRecord(HttpServletRequest request,String flag,String investStatus)
	{
		
		try
		{
			//从session中查询出账户ID
			String accountId = ((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
			InvestRecordBean investRecordBean = new InvestRecordBean();
			investRecordBean.setAccountId(accountId);
			List<InvestRecordBean> rspList = null;
			if(Constants.DEVIL_NUM_ONE.equals(flag) || StringTools.isNullOrEmpty(flag))
			{
				if(StringTools.isNullOrEmpty(investStatus))
				{
					investStatus="9";
				}
				investRecordBean.setInvestStatus(investStatus);
				rspList = investRecordService.queryInvestRecord(investRecordBean);
				flag = "1";
			}
			else if(Constants.DEVIL_NUM_TWO.equals(flag))
			{
				rspList = investRecordService.queryCreditRecord(investRecordBean);
			}
			request.setAttribute("rspList", rspList);
			request.setAttribute("flag",flag);
			request.setAttribute("userScore", accountInfoService.getLoginAccountInfo(request).getAccountScore());
			//加急所扣鱼干
			request.setAttribute("fastscore",Integer.parseInt(paramService.getParamVal("TRANSFER_FAST")));
			//转让所扣鱼干
			request.setAttribute("transferScore",Integer.parseInt(paramService.getParamVal("TRANSFER_COMMON")));
			//取消转让所扣鱼干
			//request.setAttribute("cancelScore",Integer.parseInt(paramService.getParamVal("CANCEL_TRANSFER")));
			
			request.setAttribute("investStatus",investStatus);
			
			
			request.setAttribute("countSumInvestSubject",investRecordService.countSumInvestSubject(investRecordBean));
		}
		catch (SQLException e)
		{
			logger.error("查询投标记录列表异常", e);
		}
		return "investrecord/investrecordlist";
	}
	
	/**
	 * 跳转我的投资详情
	 * @Description:
	 * @param request
	 * @param investId
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年9月22日 下午4:23:32
	 */
	@RequestMapping("/tomyinvest")
	public String toMyInvest(HttpServletRequest request,String investId)
	{
		try
		{
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			
			AccountInvest accountInvests=revenueSettlementService.getSettlementIncomeInvestInfoById(investId);
			SubjectBean subjectBean =new SubjectBean();
			subjectBean.setSubjectId(accountInvests.getSubjectId());
			request.setAttribute("subjectBeans", subjectService.querySubjectById(subjectBean));
			
			// 根据标ID查询投资者记录
			List<SubjectBean> listSubjectAccount=null;
			listSubjectAccount = subjectService.querySubjectAccount(subjectBean);
			List<SubjectBean> sList= new ArrayList<SubjectBean>();
			//for (int i = 0; i < listSubjectAccount.size(); i++)
			for(SubjectBean sBean:listSubjectAccount)
			{
				String aId=sBean.getAccountId();
				double iMoney=Double.parseDouble(sBean.getInvestMoney());
				sBean.setTelephone(sBean.getTelephone().substring(0,3)+"****"+sBean.getTelephone().substring(7));
				//投资金额为0表示用户使用了体验金
				if(iMoney<=0)
				{
					//不是当前用户所只使用的体验金记录去除 仅展示当前用户使用记录
					if(accountId.equals(aId))
					{
						sBean.setInvestMoney(sBean.getInvestMoney()+"("+sBean.getRealMoney()+"体验金)");
						sList.add(sBean);
					}
					
				}
				else
				{
					sList.add(sBean);
				}
			}
			request.setAttribute("listSubjectAccount", sList);
			
			//标已结束 进度条直接显示
			if(Constants.DEVIL_NUM_ONE.equals(accountInvests.getInvestStatus()))
			{
				request.setAttribute("percenter", accountInvests.getSubjectPeriods());
			}
			else
			{
				//上次计算收益时间和投标时间月份差
				int m=DateUtils.GetTwoDatesMonths(accountInvests.getLastProfitTime(), accountInvests.getInvestTime());
				request.setAttribute("percenter", m);
			}
			List<InvestRecordBean> rspList=new ArrayList<InvestRecordBean>();
			
			//优惠券标记(-1:未使用优惠券  1:无限制（满期限） 2：未过期 3：刚好到期 4：已到期)
			Integer flag = -1;
			flag = couponPeriod(accountInvests);
			
 			InvestRecordBean iBean = new InvestRecordBean();
			
			//投标金额(元)
			int inMoney=Integer.parseInt(accountInvests.getInvestMoney());
			
			//优惠金额（元）
			int cMoney=Integer.parseInt(accountInvests.getCouponMoney());
			
			//投标利率(可能使用加息券)
			double rate=Double.parseDouble(accountInvests.getSubjectRate());
			
			//标利率
			double srate=Double.parseDouble(accountInvests.getSubjectRates())+Double.parseDouble(accountInvests.getVipRate());
			
			String currentTime=accountInvests.getCurrentTime();
			
			Double ExpenseRate =  Double.parseDouble(accountInvests.getExpenseRate())/100;
			
			//收益总额
			String profitSum="0.0";
			
			//管理费总额
			String manageSum="0.0";
			
			//提前还款收益总额（算利息管理费）
			String goP=accountInvests.getEarlyRepaymentMoney();
			
		
			//天标
			if(Constants.DEVIL_NUM_ZERO.equals(accountInvests.getSubjectTerm()))
			{
				
				//收益
				String p="";
				//已投天数
				int d=0;
				//天标天数
				int day=Integer.parseInt(accountInvests.getSubjectPeriods());
				//是否提前还款(1否  2是)    
				if(Constants.DEVIL_NUM_ONE.equals(accountInvests.getIsEarly()))
				{
					
					d=DateUtils.daysBetween(accountInvests.getCurrentTime(),accountInvests.getInvestTime());
					
					if(d>=day)
					{
						d=day;
					}
					//计算收益  投标金额*利率/360 *天数
					
					//未使用优惠券
					if(flag==-1)
					{
						p=MoneyUtils.doubleToString((inMoney*rate*day)/(100*365),4);
						
					}
					//使用了优惠券
					else
					{
						//优惠券计息天数
						int interestDays = Integer.parseInt(accountInvests.getCouponDetail().getInterestDays());
						
						//优惠券类型
						String cType=accountInvests.getCouponDetail().getCouponType();
						
						double four=0;
						//使用加息券
						if("1".equals(cType))
						{
							//计息期限<标天数
							if(flag==4)
							{
								four=(inMoney*rate*interestDays)/(100*365)+(inMoney*srate*(day-interestDays))/(100*365);
								p=MoneyUtils.doubleToString(four,4);
							}
							//计息期限>=标天数
							else
							{
								p=MoneyUtils.doubleToString((inMoney*rate*day)/(100*365),4);
							}
						}
						//使用现金券或者体验金
						else
						{
							//计息期限<标天数
							if(flag==4)
							{
								four=((inMoney+cMoney)*srate*interestDays)/(100*365)+(inMoney*srate*(day-interestDays))/(100*365);
								p=MoneyUtils.doubleToString(four,4);
							}
							//计息期限>=标天数
							else
							{
								p=MoneyUtils.doubleToString(((inMoney+cMoney)*srate*day)/(100*365),4);
							}
						}
					}
					//结算时间
					iBean.setEndTime(accountInvests.getEndTime());
				}
				//提前还款
				else
				{
					p=goP;
					d=day;
					//结算时间
					iBean.setEndTime(accountInvests.getEarlyTime());
				}
				
				
				
				
				manageSum =MoneyUtils.doubleToString( Double.parseDouble(p)*ExpenseRate,2);
				
				p = MoneyUtils.doubleToString( Double.parseDouble(p)-Double.parseDouble(manageSum),2);
				
				
				profitSum = p;
				
				//期数
				iBean.setRn("1");
				iBean.setSurplusMoney(accountInvests.getInvestMoney());
				iBean.setShowProfit(p);
				rspList.add(iBean);
				
				request.setAttribute("profitSum", profitSum);
				request.setAttribute("manageSum", manageSum);
				request.setAttribute("day", d);
				request.setAttribute("days", day);
			}
			//月标
			else if(Constants.DEVIL_NUM_ONE.equals(accountInvests.getSubjectTerm()))
			{
				//提前还款和投资时间的月份差
				int tday=0;
				//期限
				int term=Integer.parseInt(accountInvests.getSubjectPeriods());
				//投资金额
				double total=Double.parseDouble(accountInvests.getInvestMoney());
				
				double ctotal=Double.parseDouble(accountInvests.getCouponMoney());
				//总投资金额
				double totals=Double.parseDouble(accountInvests.getInvestMoney())+ Double.parseDouble(accountInvests.getCouponMoney());
				
				//优惠券计息月份
				int interestDays;
				String cType;
				if(!StringTools.isNullOrEmpty(accountInvests.getCouponDetail()))
				{
					interestDays = Integer.parseInt(accountInvests.getCouponDetail().getInterestDays());
					//优惠券类型
					cType=accountInvests.getCouponDetail().getCouponType();
				}
				else
				{
					interestDays=0;
					cType="";
				}
				
				//当前时间和投标时间相差月份
				int m=DateUtils.GetTwoDatesMonths(currentTime, accountInvests.getInvestTime());
				if(Constants.DEVIL_NUM_TWO.equals(accountInvests.getIsEarly()))
				{
					m=term;
				}
				else
				{
					if(m==0)
					{
						m+=1;
					}
					else if(m>term)
					{
						m=term;
					}
					//对比当前时间所在月份与当月结算时间  大于为true 表示为已结算
					boolean isSetter=DateUtils.compareDateDay(currentTime, DateUtils.subMonth(accountInvests.getInvestTime(),m));
					if(!isSetter)
					{
						m=m-1;
					}
				}
				
				//----------------------------------------等额本息（多条记录）----------------------
				if(Constants.DEVIL_NUM_ZERO.equals(accountInvests.getRepeatType()))
				{
					//每次返还本金
					double every=0;
					double profi=0;
					
					//优惠券每次返还
					double cevery=0;
					
					int terms=term;
					//是否提前还款(1否  2是)    
					if(Constants.DEVIL_NUM_TWO.equals(accountInvests.getIsEarly()))
					{
						//提前还款时间和投资时间相差几个月
						tday=DateUtils.GetTwoDatesMonths(accountInvests.getLastProfitTime(), accountInvests.getInvestTime());
						terms=tday;
					}
					
					for (int i = 0; i < terms; i++)
					{
						iBean=new InvestRecordBean();
						//投资本金刚好能整除  每个月返还本金一致
						if(total%term==0)
						{
							//本金
							every=total/term;
							
							//使用了优惠券
							if(flag!=-1)
							{
								cevery=ctotal/term;
								//计息期限<标天数
								if(flag==4)
								{
									//优惠券计息
									if(interestDays>=(i+1))
									{
										//使用加息券
										if("1".equals(cType))
										{
											profi=(total-i*every)*rate/1200;
										}
										else
										{
											//等额本息每期需要扣除优惠券
											profi=(totals-i*(every+cevery))*srate/1200;
										}
										
									}
									//已到期
									else
									{
										profi=(total-i*every)*srate/1200;
									}
								}
								//计息期限>=标天数
								else
								{
									//使用加息券
									if("1".equals(cType))
									{
										profi=(total-i*every)*rate/1200;
									}
									else
									{
										//等额本息每期需要扣除优惠券
										profi=(totals-i*(every+cevery))*srate/1200;
									}
								}
							}
							//未使用优惠券
							else
							{
								profi=(total-i*every)*srate/1200;
							}
						}
						//不能整除
						else
						{
							if(i<(term-1))
							{
								every=Math.floor((total*100)/term)/100;
								
								//使用了优惠券(体验金或者增值券)
								if(flag!=-1)
								{
									cevery=ctotal/term;
									//计息期限<标天数
									if(flag==4)
									{
										//优惠券计息
										if(interestDays>=(i+1))
										{
											//使用加息券
											if("1".equals(cType))
											{
												profi=(total-i*every)*rate/1200;
											}
											else
											{
												//等额本息每期需要扣除优惠券
												profi=(totals-i*(every+cevery))*srate/1200;
											}
										}
										//已到期
										else
										{
											profi=(total-i*every)*srate/1200;
										}
									}
									//计息期限>=标天数
									else
									{
										if("1".equals(cType))
										{
											profi=(totals-i*every)*rate/1200;
										}
										else
										{
											//等额本息每期需要扣除优惠券
											profi=(totals-i*(every+cevery))*rate/1200;
										}
									}
								}
								else
								{
									profi=(total-i*every)*srate/1200;
								}
								
							}
							else
							{
								every=Math.ceil((total*100)/term)/100;
								profi=every*10/1200;
							}
						}
						
						
						manageSum =MoneyUtils.doubleToString( Double.parseDouble(manageSum)+profi*ExpenseRate,2);
						
						profi =  profi-profi*ExpenseRate;
						
						profitSum = MoneyUtils.doubleToString( Double.parseDouble(profitSum)+profi,2);
						
						
						iBean.setRn(String.valueOf(i+1));
						//未满标
						if(!accountInvests.getSubjectStatus().equals("0"))
						{
							iBean.setEndTime(DateUtils.subMonth(accountInvests.getFullTime(), i+1));
						}
						iBean.setSurplusMoney(MoneyUtils.doubleToString(every,2));
						iBean.setShowProfit(MoneyUtils.doubleToString(profi,2));
						rspList.add(iBean);
					}
					
					//是否提前还款(1否  2是)    
					if(Constants.DEVIL_NUM_TWO.equals(accountInvests.getIsEarly()))
					{
						iBean=new InvestRecordBean();
						manageSum =MoneyUtils.doubleToString( Double.parseDouble(manageSum)+Double.parseDouble(goP)*ExpenseRate,2);
						//纯收益
						goP=MoneyUtils.doubleToString( Double.parseDouble(goP)*((100-Double.parseDouble(accountInvests.getExpenseRate()))/100),2);
						
						iBean.setRn(String.valueOf(tday+1));
						iBean.setEndTime(accountInvests.getEarlyTime());
						iBean.setSurplusMoney(accountInvests.getEarlySurplusMoney());
						iBean.setShowProfit(goP);
						rspList.add(iBean);
						profitSum=MoneyUtils.doubleToString(Double.parseDouble(goP)+(terms*profi),2);
						term=m;

						
					}
					
					request.setAttribute("day", m);
					request.setAttribute("days",term);
					request.setAttribute("profitSum", profitSum);
					request.setAttribute("manageSum", manageSum);
					
				}
				
				//---------------------------------------------先息后本(多条记录)--------------------------------------
				else if(Constants.DEVIL_NUM_ONE.equals(accountInvests.getRepeatType()))
				{
					//总返还收益（包含加息券）
					double profi=total*rate*term/1200;
					//总返还收益(使用优惠券)
					double profis=totals*srate*term/1200;
					//总返还收益（未使用优惠券）
					double profino=total*srate*term/1200;
					
					double everyP=0;
					int terms=term;
					//是否提前还款(1否  2是)    
					if(Constants.DEVIL_NUM_TWO.equals(accountInvests.getIsEarly()))
					{
						//上次结算时间和投资时间相差几个月  已结算几次
						tday=DateUtils.GetTwoDatesMonths(accountInvests.getLastProfitTime(), accountInvests.getInvestTime());
						terms=tday;
					}
					for (int i = 0; i < terms; i++)
					{
						iBean=new InvestRecordBean();
						//投资本金刚好能整除  每个月返还本金一致
						if(profi%term==0)
						{
							if(i<(term-1))
							{
								iBean.setSurplusMoney("0");
							}
							else
							{
								//如果是双十二活动标  本金需要减去
								if(Constants.TWELVE_ACTIVITY_IPHONEX.equals(accountInvests.getSubjectId()))
								{
									//两万档减去7700
									if(Constants.TWELVE_ACTIVITY_INVEST_TWO.equals(accountInvests.getInvestMoney()))
									{
										iBean.setSurplusMoney(String.valueOf(Integer.parseInt(accountInvests.getInvestMoney())-Integer.parseInt(Constants.TWELVE_ACTIVITY_BUY_TWO_YUAN)));
									}
									//三万档减去7000
									else
									{
										iBean.setSurplusMoney(String.valueOf(Integer.parseInt(accountInvests.getInvestMoney())-Integer.parseInt(Constants.TWELVE_ACTIVITY_BUY_THREE_YUAM)));
									}
								}
								else
								{
									if(Constants.DEVIL_NUM_TWO.equals(accountInvests.getIsEarly()))
									{
										iBean.setSurplusMoney("0");
									}
									else
									{
										iBean.setSurplusMoney(accountInvests.getInvestMoney());
									}
									
									
								}
							}
							
							//计算收益
							//使用了优惠券
							if(flag!=-1)
							{
								//计息期限<标天数
								if(flag==4)
								{
									//优惠券计息
									if(interestDays>=(i+1))
									{
										//使用加息券
										if("1".equals(cType))
										{
											everyP=profi/term;
										}
										else
										{
											everyP=profis/term;
										}
										
									}
									//已到期
									else
									{
										everyP=profino/term;
									}
								}
								//计息期限>=标天数
								else
								{
									//使用加息券
									if("1".equals(cType))
									{
										everyP=profi/term;
									}
									else
									{
										everyP=profis/term;
									}
								}
							}
							//未使用优惠券
							else
							{
								everyP=profino/term;
							}
							
						}
						//不能整除
						else
						{
							if(i<(term-1))
							{
								
								//计算收益
								//使用了优惠券(体验金或者增值券)
								if(flag!=-1)
								{
									//计息期限<标天数
									if(flag==4)
									{
										//优惠券计息
										if(interestDays>=(i+1))
										{
											//使用加息券
											if("1".equals(cType))
											{
												everyP=Math.floor((profi*100)/term)/100;
											}
											else
											{
												everyP=Math.floor((profis*100)/term)/100;
											}
											
										}
										//已到期
										else
										{
											everyP=Math.floor((profino*100)/term)/100;
										}
									}
									//计息期限>=标天数
									else
									{
										//使用加息券
										if("1".equals(cType))
										{
											everyP=Math.floor((profi*100)/term)/100;
										}
										else
										{
											everyP=Math.floor((profis*100)/term)/100;
										}
										
									}
								}
								//未使用优惠券
								else
								{
									everyP=Math.floor((profino*100)/term)/100;
								}
								iBean.setSurplusMoney("0");
							}
							else
							{
								//计算收益
								//使用了优惠券(体验金或者增值券)
								if(flag!=-1)
								{
									//计息期限<标天数
									if(flag==4)
									{
										//优惠券计息
										if(interestDays>=(i+1))
										{
											//使用加息券
											if("1".equals(cType))
											{
												everyP=Math.ceil((profi*100)/term)/100;
											}
											else
											{
												everyP=Math.ceil((profis*100)/term)/100;
											}
											
										}
										//已到期
										else
										{
											everyP=Math.ceil((profino*100)/term)/100;
										}
									}
									//计息期限>=标天数
									else
									{
										//使用加息券
										if("1".equals(cType))
										{
											everyP=Math.ceil((profi*100)/term)/100;
										}
										else
										{
											everyP=Math.ceil((profis*100)/term)/100;
										}
									}
								}
								//未使用优惠券
								else
								{
									everyP=Math.ceil((profino*100)/term)/100;
								}
								//如果是双十二活动标  本金需要减去
								if(Constants.TWELVE_ACTIVITY_IPHONEX.equals(accountInvests.getSubjectId()))
								{
									//两万档减去7700
									if(Constants.TWELVE_ACTIVITY_INVEST_TWO.equals(accountInvests.getInvestMoney()))
									{
										iBean.setSurplusMoney(String.valueOf(Integer.parseInt(accountInvests.getInvestMoney())-Integer.parseInt(Constants.TWELVE_ACTIVITY_BUY_TWO_YUAN)));
									}
									//三万档减去7000
									else
									{
										iBean.setSurplusMoney(String.valueOf(Integer.parseInt(accountInvests.getInvestMoney())-Integer.parseInt(Constants.TWELVE_ACTIVITY_BUY_THREE_YUAM)));
									}
								}
								else
								{
									iBean.setSurplusMoney(accountInvests.getInvestMoney());
								}
								
							}
						}
						
						manageSum =MoneyUtils.doubleToString( Double.parseDouble(manageSum)+everyP*ExpenseRate,2);
						
						everyP =  everyP-everyP*ExpenseRate;
						
						profitSum = MoneyUtils.doubleToString( Double.parseDouble(profitSum)+everyP,2);
						
						iBean.setRn(String.valueOf(i+1));
						//未满标
						if(!accountInvests.getSubjectStatus().equals("0"))
						{
							iBean.setEndTime(DateUtils.subMonth(accountInvests.getFullTime(), i+1));
						}
						iBean.setShowProfit(MoneyUtils.doubleToString(everyP,2));
						rspList.add(iBean);
					}
					
					//是否提前还款(1否  2是)    
					if(Constants.DEVIL_NUM_TWO.equals(accountInvests.getIsEarly()))
					{
						iBean=new InvestRecordBean();
						manageSum =MoneyUtils.doubleToString( Double.parseDouble(manageSum)+Double.parseDouble(goP)*ExpenseRate,2);
						//纯收益
						
						goP=MoneyUtils.doubleToString( Double.parseDouble(goP)*((100-Double.parseDouble(accountInvests.getExpenseRate()))/100),2);
						
						iBean.setRn(String.valueOf(tday+1));
						iBean.setEndTime(accountInvests.getEarlyTime());
						iBean.setSurplusMoney(accountInvests.getEarlySurplusMoney());
						iBean.setShowProfit(goP);
						rspList.add(iBean);
						profitSum=MoneyUtils.doubleToString(Double.parseDouble(goP)+(terms*everyP),2);
						term=m;
					}
					request.setAttribute("day", m);
					request.setAttribute("days",term);
					request.setAttribute("profitSum", profitSum);
					request.setAttribute("manageSum", manageSum);
				}
				//到期还本付息（一条记录）
				else if(Constants.DEVIL_NUM_TWO.equals(accountInvests.getRepeatType()))
				{
					//是否提前还款(1否  2是)    
					if(Constants.DEVIL_NUM_ONE.equals(accountInvests.getIsEarly()))
					{
						//收益
						double everyP=total*rate*term/1200;
						
						manageSum =MoneyUtils.doubleToString( Double.parseDouble(manageSum)+everyP*ExpenseRate,2);
						
						everyP =  everyP-everyP*ExpenseRate;
						
						profitSum = MoneyUtils.doubleToString( Double.parseDouble(profitSum)+everyP,2);
						
						
						iBean.setRn("1");
						iBean.setEndTime(accountInvests.getEndTime());
						iBean.setSurplusMoney(accountInvests.getInvestMoney());
						iBean.setShowProfit(MoneyUtils.doubleToString(everyP,2));
						
						boolean isSetter=DateUtils.compareDateDay(accountInvests.getCurrentTime(),accountInvests.getEndTime());
						if(isSetter)
						{
							//已结算
							request.setAttribute("day", 1);
						}
						else
						{
							//未结算
							request.setAttribute("day", 0);
						}
					}
					else
					{
						manageSum =MoneyUtils.doubleToString( Double.parseDouble(goP)*ExpenseRate,2);
						iBean.setRn("1");
						iBean.setEndTime(accountInvests.getEarlyTime());
						iBean.setSurplusMoney(accountInvests.getInvestMoney());
						iBean.setShowProfit(MoneyUtils.doubleToString( Double.parseDouble(goP)-Double.parseDouble(manageSum),2));
						request.setAttribute("day", 1);
					}
					request.setAttribute("days",term);
					request.setAttribute("profitSum", profitSum);
					request.setAttribute("manageSum", manageSum);

				}
			}
			//未满标
			if(accountInvests.getSubjectStatus().equals("0"))
			{
				rspList=null;
			}
			request.setAttribute("rspList", rspList);
			request.setAttribute("iBean", accountInvests);
			//用户预感
			request.setAttribute("userScore", accountInfoService.getLoginAccountInfo(request).getAccountScore());
			//转让所扣鱼干
			request.setAttribute("transferScore",Integer.parseInt(paramService.getParamVal("TRANSFER_COMMON")));
			
			//是否提前还款(1否  2是)    补偿0.2%现金券
			request.setAttribute("makeup",accountInvests.getEqualizeMoney());
		}
		catch (SQLException e)
		{
			logger.error("查询我的投资异常",e);
		}
		catch (ParseException e)
		{
			logger.error("查询我的投资异常",e);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "investrecord/myinvestdetail";
	}
	/**
	 * 加急转让
	 * @Description:
	 * @param request
	 * @param creditId
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月6日 下午9:53:49
	 */
	@RequestMapping("/fastTransfer")
	public void fastTransfer(HttpServletRequest request,HttpServletResponse response,String creditId,String investId)
	{	
		// 创建标识
		String result = "{\"result\":\"error\"}";
		InvestRecordBean investRecordBean = new InvestRecordBean();
		try
		{
			//获取用户积分
			String score = accountInfoService.getLoginAccountInfo(request).getAccountScore();
			int scores =Integer.parseInt(score);
			int fastscore= Integer.parseInt(paramService.getParamVal("TRANSFER_FAST"));
			if(scores<fastscore)
			{
				result = "{\"result\":\"errorscore\"}";
			}else
			{
				investRecordBean.setCreditId(creditId);
				investRecordBean.setInvestId(investId);
				investRecordService.fastTransfer(request,investRecordBean);
				result = "{\"result\":\"success\"}";
			}
			
			// 传递标识
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (SQLException e)
		{
			logger.error("加急转让异常！", e);
		}
		catch (IOException e)
		{
			logger.error("加急转让异常！", e);
		}
		
	}
	
	/**
	 * 平台接盘
	 * @Description:
	 * @param request
	 * @param creditId
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月7日 上午10:17:20
	 */
	@RequestMapping("/sysTransfer")
	public void sysTransfer(HttpServletRequest request,HttpServletResponse response,String creditId,String investId)
	{	
		// 创建标识
		String result = "{\"result\":\"error\"}";
		//从session中查询出账户ID
		String accountId = ((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
		InvestRecordBean investRecordBean = new InvestRecordBean();
		try
		{
			investRecordBean.setCreditId(creditId);
			investRecordBean.setInvestId(investId);
			investRecordBean.setAccountId(accountId);
			investRecordService.sysTransfer(investRecordBean);
			result = "{\"result\":\"success\"}";
			// 传递标识
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (SQLException e)
		{
			logger.error("加急转让异常！", e);
		}
		catch (IOException e)
		{
			logger.error("加急转让异常！", e);
		}
	}
	/**
	 * 跳转转让页面
	 * @Description:
	 * @param request
	 * @param investId
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月6日 下午7:02:29
	 */
	@RequestMapping("/toTransfer")
	public String transferNow(HttpServletRequest request,String investId,String investMoney,String totalCreditMoney,String subjectRate)
	{
		//获取项目路径
		String projectUrl=paramService.getParamVal("MAKE_PROJECT_URL");
		request.setAttribute("investId", investId);
		request.setAttribute("investMoney", investMoney);
		/*request.setAttribute("minRate", minRate);
		request.setAttribute("maxRate", maxRate);*/
		return "investrecord/transferNow";
	}
	
	/**
	 * 立即转让
	 * @Description:
	 * @param investId
	 * @param investMoney
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月24日 下午5:57:51
	 */
	@RequestMapping("/transferBond")
	public void transferBond(HttpServletRequest request, HttpServletResponse response,String investId,String creditRate)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		response.setContentType("application/json");
		try
		{
			investRecordService.transferBond(request,investId,creditRate);
			result = "{\"result\":\"success\"}";
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (SQLException e)
		{
			logger.error("SQL转让债权异常！",e);
		}
		catch (IOException e)
		{
			logger.error("IO转让债权异常！",e);
		}
		
	}

	/**
	 * 取消转让
	 * @Description:
	 * @param request
	 * @param response
	 * @param creditId
	 * @param investId
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月19日 上午10:24:34
	 */
	@RequestMapping("/canceltransfer")
	public void cancelTransfer(HttpServletRequest request,HttpServletResponse response,String creditId,String investId)
	{	
		// 创建标识
		String result = "{\"result\":\"error\"}";
		InvestRecordBean investRecordBean = new InvestRecordBean();
		try
		{
			/*
			//获取用户积分
			String score = accountInfoService.getLoginAccountInfo(request).getAccountScore();
			int scores =Integer.parseInt(score);
			
			//取消转让所扣积分
			int cancelTransfer= Integer.parseInt(paramService.getParamVal("CANCEL_TRANSFER"));
			if(scores<cancelTransfer)
			{
				result = "{\"result\":\"errorscore\"}";
			}else
			{*/
				investRecordBean.setCreditId(creditId);
				investRecordBean.setInvestId(investId);
				//是否撤销(0:否 1:是)
				investRecordBean.setIsCancel(Constants.DEVIL_NUM_ONE);
				investRecordBean.setIsCredit(Constants.DEVIL_NUM_ZERO);
				investRecordService.cancelTransfer(request,investRecordBean);
				
				
				result = "{\"result\":\"success\"}";
			//}
			
			// 传递标识
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (SQLException e)
		{
			logger.error("加急转让异常！", e);
		}
		catch (IOException e)
		{
			logger.error("加急转让异常！", e);
		}
		
	}
	
	/**
	 * 查看合同
	 * @Description:
	 * @param investId
	 * @param subjectId
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月21日 下午5:40:56
	 */
	@RequestMapping("/toContract")
	public String toContract(HttpServletRequest request,String investId,String subjectId)
	{
		SubjectBean sBean =new SubjectBean();
		sBean.setSubjectId(subjectId);
		InvestRecordBean iBean = new InvestRecordBean();
		iBean.setInvestId(investId);
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		AccountInfo aBean =new AccountInfo();
		try
		{
			//sBean=subjectService.querySubjectById(sBean);
			iBean=investRecordService.selectOneInvestRecordById(iBean);
			iBean.setInvestMoney(MoneyUtils.changeFToY(iBean.getInvestMoney()));
			//aBean=accountInfoService.getAccountInfo(accountId);
			request.setAttribute("sBean", subjectService.querySubjectById(sBean));
			request.setAttribute("iBean", iBean);
			request.setAttribute("aBean", accountInfoService.getAccountInfo(accountId));
		}
		catch (SQLException e)
		{
			logger.error("查看合同异常！", e);
		}
		return "investrecord/investcontract";
	}
	
	/**
	 * 跳转债权转让协议
	 * @Description:
	 * @param request
	 * @param subjectBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月10日 上午10:42:59
	 */
	@RequestMapping("/transfercontract")
	public String queryTransferContract(HttpServletRequest request,InvestRecordBean investRecordBean,String type)
	{
		SubjectBean subjectBean= new SubjectBean();
		try
		{
			//需要查询信息
			if(!Constants.DEVIL_NUM_ZERO.equals(type))
			{
				investRecordBean=investRecordService.queryInvestRecordById(investRecordBean);
				request.setAttribute("iBean", investRecordBean);
				subjectBean.setSubjectId(investRecordBean.getSubjectId());
				request.setAttribute("sBean", subjectService.querySubjectById(subjectBean));
			}
			request.setAttribute("type", type);
			
		}
		catch (SQLException e)
		{
			logger.error("查询债权转让协议异常", e);
		}
		return "investrecord/transfercontract";
	}
	
	/**
	 * 判断投标使用优惠券期限
	 * @Description:
	 * @param accountInvest
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年9月26日 下午2:20:12
	 */
	private Integer couponPeriod(AccountInvest accountInvest)throws Exception{
		Integer flag = -1;
		// 判断是否使用优惠券，使用的优惠券期限
		CouponDetail couponDetail = accountInvest.getCouponDetail();
		if(couponDetail!=null&&couponDetail.getCouDetailId()!=null){
			//判断是否过期
			
			//优惠券期限
			String interestDays = couponDetail.getInterestDays();
			
			Integer term = Integer.parseInt(accountInvest.getSubjectPeriods());
			if("-1".equals(interestDays)){
				//无限制
				flag = 1;
			}else if(Integer.parseInt(interestDays)>=term){
				//满期限
				flag = 1;
			}else{
				//不满期限
				//投资期限判断天还是月
					//不满期
					flag = 4;
			}
		}else{
			//未使用优惠券
			flag = -1;
		}
		return flag ;
	}
	
	/**
	 * 查询我的投资订单
	 * @Description:
	 * @param request
	 * @param investId
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月6日 下午5:56:42
	 */
	@RequestMapping("/detailorder")
	public String detailOrder(HttpServletRequest request,String investId)
	{
		try
		{
			InvestRecordBean iBean=investRecordService.queryIphoneById(investId);
			request.setAttribute("iBean", iBean);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "investrecord/detailorder";
	}
}
