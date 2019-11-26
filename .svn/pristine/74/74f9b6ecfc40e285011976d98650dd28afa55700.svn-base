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
package com.xed.financing.wxgzh.controller.intface.investrecord;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
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
@RequestMapping("/ios/investrecord")
public class InvestRecordInterfaceController
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
	private Logger logger = Logger.getLogger(InvestRecordInterfaceController.class);
	
	/**
	 * 查询我的投标列表
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/investrecord/queryinvest?accountId=&investStatus=
	 * @param accountId
	 * @param investStatus
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月29日 下午4:10:18
	 */
	@ResponseBody
	@RequestMapping("/queryinvest")
	public JSONObject queryInvestRecord(String accountId,String investStatus)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			//从session中查询出账户ID
			InvestRecordBean investRecordBean = new InvestRecordBean();
			investRecordBean.setAccountId(accountId);
			investRecordBean.setInvestStatus(investStatus);
			List<InvestRecordBean> rspList = investRecordService.queryInvestRecord(investRecordBean);
			JSONObject objs = new JSONObject();
			objs.put("rspList", rspList);
			objs.put("countSumInvestSubject", investRecordService.countSumInvestSubject(investRecordBean));
			obj.put("data", objs);
			msg = "";
			code = "200";
		}
		catch (SQLException e)
		{
			logger.error("查询投标记录列表异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 我的投资详情
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/investrecord/tomyinvest?accountId=&investId=
	 * @param accountId
	 * @param investId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月30日 上午11:13:50
	 */
	@ResponseBody
	@RequestMapping("/tomyinvest")
	public JSONObject toMyInvest(String accountId,String investId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			JSONObject objs = new JSONObject();
			AccountInvest accountInvests=revenueSettlementService.getSettlementIncomeInvestInfoById(investId);
			SubjectBean subjectBean =new SubjectBean();
			subjectBean.setSubjectId(accountInvests.getSubjectId());
			//表的详情
			objs.put("subjectBeans", subjectService.querySubjectById(subjectBean));
			
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
			//投资者记录
			objs.put("listSubjectAccount", sList);
			
			//标已结束 进度条直接显示
			if(Constants.DEVIL_NUM_ONE.equals(accountInvests.getInvestStatus()))
			{
				objs.put("percenter", accountInvests.getSubjectPeriods());
			}
			else
			{
				//上次计算收益时间和投标时间月份差
				int m=DateUtils.GetTwoDatesMonths(accountInvests.getLastProfitTime(), accountInvests.getInvestTime());
				objs.put("percenter", m);
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
			
			
			//天标
			if(Constants.DEVIL_NUM_ZERO.equals(accountInvests.getSubjectTerm()))
			{
				//已投天数
				int d=DateUtils.daysBetween(accountInvests.getCurrentTime(),accountInvests.getInvestTime());
				//天标天数
				int day=Integer.parseInt(accountInvests.getSubjectPeriods());
				//收益
				String p="";
				if(d>=day)
				{
					d=day;
				}
				//计算收益  投标金额*利率/360 *天数
				
				//未使用优惠券
				if(flag==-1)
				{
					p=MoneyUtils.formatFloatNumber((inMoney*rate*day)/(100*365));
					
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
							p=MoneyUtils.formatFloatNumber(four);
						}
						//计息期限>=标天数
						else
						{
							p=MoneyUtils.formatFloatNumber((inMoney*rate*day)/(100*365));
						}
					}
					//使用现金券或者体验金
					else
					{
						//计息期限<标天数
						if(flag==4)
						{
							four=((inMoney+cMoney)*srate*interestDays)/(100*365)+(inMoney*srate*(day-interestDays))/(100*365);
							p=MoneyUtils.formatFloatNumber(four);
						}
						//计息期限>=标天数
						else
						{
							p=MoneyUtils.formatFloatNumber(((inMoney+cMoney)*srate*day)/(100*365));
						}
					}
				}
				//结算时间
				iBean.setEndTime(accountInvests.getEndTime());
				
				
				manageSum =MoneyUtils.formatFloatNumber( Double.parseDouble(p)*ExpenseRate);
				
				p = MoneyUtils.formatFloatNumber( Double.parseDouble(p)-Double.parseDouble(manageSum));
				
				
				profitSum = p;
				
				//期数
				iBean.setRn("1");
				iBean.setSurplusMoney(accountInvests.getInvestMoney());
				iBean.setShowProfit(p);
				rspList.add(iBean);
				//预计总收益
				objs.put("profitSum", profitSum);
				//利息管理费
				objs.put("manageSum", manageSum);
				//已投天数
				objs.put("day", d);
				//天标天数
				objs.put("days", day);
			}
			//月标
			else if(Constants.DEVIL_NUM_ONE.equals(accountInvests.getSubjectTerm()))
			{
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
				
				
				
				//----------------------------------------等额本息（多条记录）----------------------
				if(Constants.DEVIL_NUM_ZERO.equals(accountInvests.getRepeatType()))
				{
					//每次返还本金
					double every=0;
					double profi=0;
					//优惠券每次返还
					double cevery=0;
					for (int i = 0; i < term; i++)
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
											profi=(totals-i*every)*srate/1200;
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
						
						
						manageSum =MoneyUtils.formatFloatNumber( Double.parseDouble(manageSum)+profi*ExpenseRate);
						
						profi =  profi-profi*ExpenseRate;
						
						profitSum = MoneyUtils.formatFloatNumber( Double.parseDouble(profitSum)+profi);
						
						
						iBean.setRn(String.valueOf(i+1));
						iBean.setEndTime(DateUtils.subMonth(accountInvests.getInvestTime(), i+1));
						iBean.setSurplusMoney(MoneyUtils.formatFloatNumber(every));
						iBean.setShowProfit(MoneyUtils.formatFloatNumber(profi));
						rspList.add(iBean);
					}
					//当前时间和投标时间相差月份
					int m=DateUtils.GetTwoDatesMonths(currentTime, accountInvests.getInvestTime());
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
					if(isSetter)
					{
						//已结算月份
						objs.put("day", m);
					}
					else
					{
						objs.put("day", m-1);
					}
					//期限
					objs.put("days", term);
					//收益总额
					objs.put("profitSum", profitSum);
					//管理费总额
					objs.put("manageSum", manageSum);
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
					for (int i = 0; i < term; i++)
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
									iBean.setSurplusMoney(accountInvests.getInvestMoney());
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
						
						manageSum =MoneyUtils.formatFloatNumber( Double.parseDouble(manageSum)+everyP*ExpenseRate);
						
						everyP =  everyP-everyP*ExpenseRate;
						
						profitSum = MoneyUtils.formatFloatNumber( Double.parseDouble(profitSum)+everyP);
						
						iBean.setRn(String.valueOf(i+1));
						iBean.setEndTime(DateUtils.subMonth(accountInvests.getInvestTime(), i+1));
						iBean.setShowProfit(MoneyUtils.formatFloatNumber(everyP));
						rspList.add(iBean);
					}
					//当前时间和投标时间相差月份
					int m=DateUtils.GetTwoDatesMonths(currentTime, accountInvests.getInvestTime());
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
					if(isSetter)
					{
						//已结算月份
						objs.put("day", m);
					}
					else
					{
						objs.put("day", m-1);
					}
					//期限
					objs.put("days", term);
					//收益总额
					objs.put("profitSum", profitSum);
					//管理费总额
					objs.put("manageSum", manageSum);
				}
				//到期还本付息（一条记录）
				else if(Constants.DEVIL_NUM_TWO.equals(accountInvests.getRepeatType()))
				{
					//收益
					double everyP=total*rate*term/1200;
					
					manageSum =MoneyUtils.formatFloatNumber( Double.parseDouble(manageSum)+everyP*ExpenseRate);
					
					everyP =  everyP-everyP*ExpenseRate;
					
					profitSum = MoneyUtils.formatFloatNumber( Double.parseDouble(profitSum)+everyP);
					
					
					iBean.setRn("1");
					iBean.setEndTime(accountInvests.getEndTime());
					iBean.setSurplusMoney(accountInvests.getInvestMoney());
					iBean.setShowProfit(MoneyUtils.formatFloatNumber(everyP));
					
					boolean isSetter=DateUtils.compareDateDay(accountInvests.getCurrentTime(),accountInvests.getEndTime());
					if(isSetter)
					{
						//已结算
						objs.put("day", 1);
					}
					else
					{
						//未结算
						objs.put("day", 0);
					}
					//期限
					objs.put("days", term);
					//收益总额
					objs.put("profitSum", profitSum);
					//管理费总额
					objs.put("manageSum", manageSum);
				}
			}
			objs.put("rspList", rspList);
			objs.put("iBean", accountInvests);
			//用户鱼干
			objs.put("userScore", accountInfoService.iosGetLoginAccountInfo(accountId).getAccountScore());
			//转让所扣鱼干
			objs.put("transferScore", Integer.parseInt(paramService.getParamVal("TRANSFER_COMMON")));
			obj.put("data", objs);
			msg = "";
			code = "200";
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
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
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
	@ResponseBody
	@RequestMapping("/toContract")
	public JSONObject toContract(String accountId,String investId,String subjectId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "查询投资协议异常";
		int code = 300;
		SubjectBean sBean =new SubjectBean();
		sBean.setSubjectId(subjectId);
		InvestRecordBean iBean = new InvestRecordBean();
		iBean.setInvestId(investId);
		AccountInfo aBean =new AccountInfo();
		try
		{
			//sBean=subjectService.querySubjectById(sBean);
			iBean=investRecordService.selectOneInvestRecordById(iBean);
			iBean.setInvestMoney(MoneyUtils.changeFToY(iBean.getInvestMoney()));
			//aBean=accountInfoService.getAccountInfo(accountId);
			sBean=subjectService.querySubjectById(sBean);
			aBean=accountInfoService.getAccountInfo(accountId);
			msg="查询成功";
			code=200;
		}
		catch (SQLException e)
		{
			logger.error("查看合同异常！", e);
		}
		obj.put("sBean", sBean);
		obj.put("iBean", iBean);
		obj.put("aBean", aBean);
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
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
