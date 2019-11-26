package com.xed.financing.wxgzh.controller.intface.subject;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.alibaba.fastjson.JSONObject;
import com.xed.financing.wxgzh.controller.subject.SubjectController;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;
import com.xed.financing.wxgzh.model.message.CompanyMessageBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.savings.SavingsBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.model.subjectpic.SubjectPicBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.activityrecord.ActivityRecordService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.investrecord.InvestRecordService;
import com.xed.financing.wxgzh.service.message.MessageService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.savings.SavingsService;
import com.xed.financing.wxgzh.service.sendcash.SendCashCouponService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.service.subjectpic.SubjectPicService;
import com.xed.financing.wxgzh.service.userlevel.UserLevelService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

@Controller
@RequestMapping("/ios/subject")
public class SubjectInterfaceController
{
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SubjectPicService subjectPicService;

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
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ActivityRecordService activityRecordService;
	
	@Autowired
	private SendCashCouponService sendCashCouponService;
	
	@Autowired
	private AccountLevelService accountLevelService;
	
	@Autowired
	private SavingsService savingsService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(SubjectController.class);

	/**
	 * 查询标集合
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/subject/querynewsubject?accountId=&flag=&subjectType=&fromNum=
	 * @param accountId
	 * @param flag
	 * @param subjectType
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月22日 上午9:52:50
	 */
	@ResponseBody
	@RequestMapping("/querynewsubject")
	public JSONObject queryNewSubject(String accountId,String flag,String subjectType,Integer fromNum )
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		
		SubjectBean subjectBean = new SubjectBean();
		subjectBean.setSubjectType(subjectType);
		
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
			subjectBean.setFromNum(fromNum);
			querySubject = subjectService.querySubjectLimit(subjectBean);
			JSONObject objs = new JSONObject();
			
			if ("0".equals(subjectType))
			{
				SubjectBean sBean = new SubjectBean();
				sBean.setAccountId(accountId);
				if (accountId == null || "".equals(accountId))
				{
					objs.put("newCount", "");
				} else {
					//查询该用户投了多少新手专享标
					int counts = subjectService.countNewSubject(sBean);
					int newCounts=Integer.parseInt(accountInfoService.iosGetLoginAccountInfo(accountId).getNewSubjectCount());
					//新手标可投次数
					objs.put("newCount", newCounts-counts);
				}
			}
			//标的集合
			objs.put("subjectList", querySubject);
			//标的类型
			objs.put("types", subjectBean.getSubjectType());
			//排序方式
			objs.put("flag", flag);
			msg = "";
			code = "200";
			obj.put("data", objs);
		}
		catch (SQLException e)
		{
			logger.error("查询标列表异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 查询次日标
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/subject/querynextsubject?flag=
	 * @param flag
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月22日 上午10:05:30
	 */
	@ResponseBody
	@RequestMapping("/querynextsubject")
	public JSONObject queryNexrSubject(String flag)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		
		SubjectBean subjectBean = new SubjectBean();
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
			querySubject = subjectService.queryNextSubject(subjectBean);
			
			SubjectBean sBean = new SubjectBean();
			sBean=subjectService.countNextSubject(sBean);

			JSONObject objs = new JSONObject();
			//次日标总和
			objs.put("countNextSubject", sBean.getCountNextSubject());
			//次日发布标总金额
			objs.put("sumMoney", sBean.getSumMoney());
			//标的集合
			objs.put("subjectList", querySubject);
			//标的类型
			objs.put("types", subjectBean.getSubjectType());
			//排序方式
			objs.put("flag", flag);
			obj.put("data", objs);
			msg = "";
			code = "200";
		}
		catch (SQLException e)
		{
			logger.error("查询标列表异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 表详情
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/subject/detailsubject?accountId=&subjectId=
	 * @param accountId
	 * @param subjectId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月22日 上午10:31:16
	 */
	@ResponseBody
	@RequestMapping("/detailsubject")
	public JSONObject querySubjectById(String accountId,String subjectId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		
		SubjectBean subjectBean = new SubjectBean();
		// 获取页面Id
		if(!StringTools.isNullOrEmpty(subjectId))
		{
			subjectBean.setSubjectId(subjectId);
		}
		List<SubjectBean> listSubjectAccount = null;
		try
		{
			// 查询标详情
			subjectBean = subjectService.querySubjectById(subjectBean);

			// 根据标ID查询投资者记录
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
			// 查询已投资金额
			String investedMmoney = subjectService.queryInvestMoney(subjectBean).getInvestMoney();
			
			//查询标的图片
			List<SubjectPicBean> spLst = subjectPicService.querySubjectPic(new SubjectPicBean(subjectBean.getSubjectId()));

			JSONObject objs = new JSONObject();
			objs.put("investedMoney", investedMmoney);
			objs.put("subjectBeans", subjectBean);
			objs.put("listSubjectAccount", sList);
			objs.put("spLst", spLst);

			CapitalBean capitalBean = new CapitalBean();
			
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			// 用户余额
			objs.put("balance", (capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
			
			//查完列表初始化bean
			SubjectBean sBean = new SubjectBean();
			sBean.setAccountId(accountId);
			
			//查询该用户投了多少新手专享标
			int counts = subjectService.countNewSubject(sBean);
			int newCounts=Integer.parseInt(accountInfoService.iosGetLoginAccountInfo(accountId).getNewSubjectCount());
			if(counts>=newCounts && Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()))
			{
				//判断新手标是否还有可投资次数
				objs.put("count", "over");
			}
			if(Constants.DEVIL_NUM_TWO.equals(subjectBean.getIsLimit()))
			{
				StringBuffer str=new StringBuffer();
				List<SubjectBean> couponAuthList=subjectService.querySubjectCoupon(subjectBean);
				if(couponAuthList.size()>0)
				{
					for (int i = 0; i < couponAuthList.size(); i++)
					{
						//计息期限(0:天 1:月 2:年)
						int type=Integer.parseInt(couponAuthList.get(i).getInterestType());
						int day=Integer.parseInt(couponAuthList.get(i).getInterestDays());
						if(type==0)
						{
							str.append(day+"天,");
						}
						else if(type==1)
						{
							str.append(day+"月,");
						}
						else if(type==2)
						{
							str.append(day+"年,");
						}
					}
					str.deleteCharAt(str.length()-1);
					//优惠券计息期限
					objs.put("str", str);
				}
				
			}
			msg = "";
			code = "200";
			obj.put("data", objs);
		}
		catch (SQLException e)
		{
			logger.error("查看标详情失败", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 跳转投资页面
	 * @Description:
	 * @param request
	 * @param id
	 * @param couponBean
	 * @param iMoney
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年6月5日 下午5:37:07
	 */
	@ResponseBody
	@RequestMapping("/investnow")
	public JSONObject investNow(String accountId,String subjectId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "访问失败";
		String code = "300";
		SubjectBean subjectBean = new SubjectBean();
		CouponBean couponBean=new CouponBean();
		// 获取页面Id
		subjectBean.setSubjectId(subjectId);
		try
		{
		// 从session中查询出账户ID
		AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
		obj.put("isRisk", accountInfo.getIsRisk());
		obj.put("accountInfo", accountInfo);
		int countCompanyMoney=Integer.parseInt(paramService.getParamVal("COMPANY_SUBJECT_COUNT"));
		
		//当日限投金额
		int subjectLimitTodayMoney=Integer.parseInt(paramService.getParamVal("SUBJECT_LIMIT_TODAY_MONEY"));
		subjectBean = subjectService.querySubjectById(subjectBean);
		obj.put("subjectBean", subjectBean);
		StringBuffer str=new StringBuffer();
			if(Constants.DEVIL_NUM_TWO.equals(subjectBean.getIsLimit()))
			{
				List<SubjectBean> couponAuthList=subjectService.querySubjectCoupon(subjectBean);
				if(couponAuthList.size()>0)
				{
					for (int i = 0; i < couponAuthList.size(); i++)
					{
						//计息期限(0:天 1:月 2:年)
						int type=Integer.parseInt(couponAuthList.get(i).getInterestType());
						int day=Integer.parseInt(couponAuthList.get(i).getInterestDays());
						if(type==0)
						{
							str.append(day+"天,");
						}
						else if(type==1)
						{
							str.append(day+"月,");
						}
						else if(type==2)
						{
							str.append(day+"年,");
						}
					}
					str.deleteCharAt(str.length()-1);
				}
			}
			obj.put("str", str);
			

			// 查询单条记录并传至前台
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			
			// 获取用户余额
			obj.put("balance", MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
			
			
			couponBean.setAccountId(accountId);
			couponBean.setIsUsed("0");
			couponBean.setIsBad("0");
			couponBean.setSubjectType(subjectBean.getSubjectType());
			
			//如果优惠券没有限制  则查询所有  是否限制优惠券(0:无限制 1:限制所有 2:部分限制)
			if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getIsLimit()))
			{
				//flag判断标识 不为空则查询优惠券权限
				couponBean.setFlag(Constants.DEVIL_NUM_TWEVEL);
				couponBean.setSubjectId(subjectBean.getSubjectId());
				
				obj.put("countCoupon",couponService.countNewMyCoupon(couponBean));
			}
			else if(Constants.DEVIL_NUM_ONE.equals(subjectBean.getIsLimit()))
			{
				obj.put("countCoupon","0");
			}
			else if(Constants.DEVIL_NUM_TWO.equals(subjectBean.getIsLimit()))
			{
				//flag判断标识 不为空则查询优惠券权限
				couponBean.setFlag(Constants.DEVIL_NUM_ELEVEN);
				couponBean.setSubjectId(subjectBean.getSubjectId());
				//用户满足权限所拥有的优惠券
				obj.put("countCoupon",couponService.countNewMyCoupon(couponBean));
			}
			
			//obj.put("couponBeans",couponService.queryCouponById(couponBean));
			//obj.put("countCompanyMoney",countCompanyMoney);
			//obj.put("subjectLimitTodayMoney",subjectLimitTodayMoney);
			
			msg = "";
			code = "200";
		}
		catch (SQLException e)
		{
			logger.error("查看标详情失败", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	/**
	 * 投标
	 * @Description:
	 * @param additionalId
	 * @param money
	 * @param subjectId
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年6月5日 下午4:23:14
	 */
	@ResponseBody
	@RequestMapping(value="/checkMoney")
	public synchronized Map<String,String> checkMoney(String additionalId, String money,String subjectId,String accountId)
	{
		// 设置标识
		Map<String,String> obj=new HashMap<String, String>();
		obj.put("result", "error");
		// 检查账户余额是否足
		try
		{
			int countCompanyMoney=Integer.parseInt(paramService.getParamVal("COMPANY_SUBJECT_COUNT"));
			int newSubjectLimit=Integer.parseInt(paramService.getParamVal("NEW_SUBJECT_LIMIT_MONEY"));
			//当日限投金额
			int subjectLimitTodayMoney=Integer.parseInt(paramService.getParamVal("SUBJECT_LIMIT_TODAY_MONEY"));
			
			SubjectBean subjectBean = new SubjectBean();
			// 获取页面Id
			subjectBean.setSubjectId(subjectId);
			
			//个人/公司用户(0:个人 1:公司)
			String isCompany=accountInfoService.getAccountInfo(accountId).getIsCompany();
			
			subjectBean.setAccountId(accountId);
			int companySubject = subjectService.countCompanySubject(subjectBean);
			//当天投资金额
			int todayInvestMoney=subjectService.queryTodayInvestAllMoney(subjectBean);
			subjectBean = subjectService.querySubjectById(subjectBean);
			
			//金额bean
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			
			//优惠券bean
			CouponBean couponBean = new CouponBean();
			
			//获取用户id
			couponBean.setAccountId(accountId);
			
			couponBean.setAdditionalId(additionalId);
			
			//查询优惠券详情
			couponBean=couponService.queryCouponById(couponBean);

			//用户余额
			double balance = capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney();
			
			
			double investMoney =0;
			//投标金额
			if(!StringTools.isNullOrEmpty(money))
			{
				investMoney = Double.parseDouble(money);
			}
			double subjectStartingMoney= Double.parseDouble(subjectBean.getSubjectStartingMoney());
			
			double subjectOverplusMoney=Double.parseDouble(subjectBean.getSubjectOverplusMoney());
			
			//未输入本金  
			if(StringTools.isNullOrEmpty(money))
			{
				//但选择了体验金
				if(!StringTools.isNullOrEmpty(couponBean.getCouponType()))
				{
					if(couponBean.getCouponType().equals(Constants.DEVIL_NUM_TWO))
					{
						obj=doSubject(money, subjectId, additionalId,accountId, obj);
					}
				}
			}
			else
			{
				if(investMoney<=subjectOverplusMoney)
				{
					//用户余额大于投标金额
					if(balance>=investMoney)
					{
						//投标金额低于起投金额
						if(investMoney<subjectStartingMoney)
						{
							obj.put("result", "errorLowStart");
						}
						//投标金额不是起投金额的整数倍
						else if(investMoney%subjectStartingMoney != 0)
						{
							obj.put("result", "errorStartFull");
						}
						//判断是否为企业用户 并且是第一次投标
						else if(isCompany.equals(Constants.DEVIL_NUM_ONE) && companySubject==0 && investMoney>countCompanyMoney)
						{
							obj.put("result", "errorFirstCompany");
						}
						//如果投新手标  限投1W
						else if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()) && investMoney>newSubjectLimit)
						{
							obj.put("result", "errorNewSubjectLimit");
						}
						else if((todayInvestMoney+Integer.parseInt(money))>subjectLimitTodayMoney)
						{
							obj.put("result", "errorLimitTodayMoney");
						}
						else
						{
							//使用优惠券
							if(!StringTools.isNullOrEmpty(additionalId))
							{
								String sType=couponBean.getSubjectType();
								//优惠券已使用
								if(!Constants.DEVIL_NUM_ZERO.equals(couponBean.getIsUsed()))
								{
									obj.put("result", "errorCoupon");
								}
								//使用了活动券  投标金额低于 限制金额
								if(investMoney*100<Double.parseDouble(couponBean.getStartMoney()))
								{
									//投资金额少于优惠券起投金额
									obj.put("result", "errorStartMoney");
								}
								//判断优惠券是否适用
								//新手
								else if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()))
								{
									if(Constants.DEVIL_NUM_ZTWO.equals(sType) || Constants.DEVIL_NUM_ONE.equals(sType)|| Constants.DEVIL_NUM_TWO.equals(sType) || Constants.DEVIL_NUM_FIVE.equals(sType))
									{
										obj.put("result", "errorCouponType");
									}
									else
									{
										// 获取用户余额
										obj.put("balance", MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
										obj=doSubject (money, subjectId, additionalId,accountId, obj);
									}
								}
								//精选理财
								else if(Constants.DEVIL_NUM_ONE.equals(subjectBean.getSubjectType()))
								{
									if(Constants.DEVIL_NUM_ZTWO.equals(sType) || Constants.DEVIL_NUM_ZERO.equals(sType)|| Constants.DEVIL_NUM_TWO.equals(sType) || Constants.DEVIL_NUM_FOUR.equals(sType))
									{
										obj.put("result", "errorCouponType");
									}
									else
									{
										// 获取用户余额
										obj.put("balance", MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
										obj=doSubject( money, subjectId, additionalId,accountId, obj);
									}
								}
								//爆款
								else if(Constants.DEVIL_NUM_FOUR.equals(subjectBean.getSubjectType()))
								{
									if(Constants.DEVIL_NUM_ZTWO.equals(sType) || Constants.DEVIL_NUM_ZERO.equals(sType)|| Constants.DEVIL_NUM_ONE.equals(sType) || Constants.DEVIL_NUM_THREE.equals(sType))
									{
										obj.put("result", "errorCouponType");
									}
									else
									{
										// 获取用户余额
										obj.put("balance", MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
										obj=doSubject( money, subjectId, additionalId, accountId,obj);
									}
								}
								
								else
								{
									// 获取用户余额
									obj.put("balance", MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
									obj=doSubject(money, subjectId, additionalId, accountId,obj);
								}
							}
							else
							{
								// 获取用户余额
								obj.put("balance", MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
								obj=doSubject(money, subjectId, additionalId,accountId, obj);
							}
						}
					}
					else
					{
						//余额不足
						obj.put("result", "errorLow");
					}
				}
				else
				{
					//标余额不足
					obj.put("result", "errorSubject");
				}
			}
			
			//红包/优惠券/体验金列表显示
			//request.setAttribute("listCouponBean", queryCoupon(request,subjectBean,accountId));
			
		}
		catch (SQLException e)
		{
			logger.error("sql异常", e);
		}
		catch (Exception e) {
			logger.error("异常", e);
		}
		return obj;
	}
	
	/**
	 * 校验成功后投资 操作
	 * @Description:
	 * @param money
	 * @param subjectId
	 * @param additionalId
	 * @param accountId
	 * @param map
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年6月5日 下午4:08:41
	 */
	public  Map<String,String> doSubject( String money, String subjectId,String additionalId,String accountId ,Map<String,String> map )
	{
		
		// 设置标识
		String result = "error";
		String flag = "errorflag";
		String resultC="";
		String savingsMoney="";
		String savingsId="";
		try
		{
			//个人/公司用户(0:个人 1:公司)
			String isCompany=accountInfoService.getAccountInfo(accountId).getIsCompany();
			
			//查询用户资金
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			if(StringTools.isNullOrEmpty(money))
			{
				money ="0";
			}
			if((capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney())>=Double.parseDouble(money))
			{
				subjectService.findSubject( money, subjectId,additionalId,"0",accountId);
				//投入了本金  后台已增加完积分  判断积分是否足够升级
				if(Integer.parseInt(money)>0)
				{
					AccountInfo accountInfoBean = new AccountInfo();
					accountInfoBean=accountInfoService.iosGetLoginAccountInfo(accountId);
					
					//如果是企业用户
					if(isCompany.equals(Constants.DEVIL_NUM_ONE) )
					{
						SubjectBean subjectBean =new SubjectBean();
						subjectBean.setAccountId(accountId);
						//企业用户投标次数
						int companySubject = subjectService.countCompanySubject(subjectBean);
						//投标记录在721行已经插入 所以判断是否第一次投标必须用1判断
						if(companySubject==1)
						{
							flag = "isflag";
							
							//公司首次投标奖励金额
							String firstreward=paramService.getParamVal("COMPANY_FIRST_REWARD");
							String contents="企业用户首次投标，将获得"+firstreward+"元奖励金，自动转入到您绑定的银行卡，将在1~3个工作日到账";
							CompanyMessageBean companyMessageBean = new CompanyMessageBean();
							companyMessageBean.setAccountId(accountId);
							companyMessageBean.setMsgContent(contents);
							//通知类型（0首次充值奖励，1首次投标奖励）
							companyMessageBean.setMsgType(Constants.DEVIL_NUM_ONE);
							//是否发送（0未发送，1已发送）
							companyMessageBean.setIsSend(Constants.DEVIL_NUM_ZERO);
								
							//添加企业用户消息通知
							messageService.addCompanyMessage(companyMessageBean);
							
							MessageBean messageBean =new MessageBean();
							messageBean.setAccountId(accountId);
							messageBean.setMsgTitle("企业用户首次投标奖励");
							messageBean.setMsgContent(contents);
							
							//添加系统消息
							messageService.addMessageInfo(messageBean);
						}
					}
					
					//判断是否有邀请人
					if(!StringTools.isNullOrEmpty(accountInfoBean.getRecommendTelephone()))
					{
						//邀请人信息
						AccountInfo account = accountInfoService.getAccountInfoByPhone(accountInfoBean.getRecommendTelephone());
						
						//判断是否第一次投标
						InvestRecordBean investRecordBean = new InvestRecordBean();
						investRecordBean.setAccountId(accountId);
						if(investRecordService.countFirstSubject(investRecordBean)==1)
						{
							if(accountInfoService.checkIdCard(account) == 1){//判断是否新用户
								//给邀请人发送首次投资奖励
								accountInfoService.sendRecommendReward(account, 1, money);
							}
							
						}else if(investRecordService.countFirstSubject(investRecordBean)==2){
							if(accountInfoService.checkIdCard(account) == 1){	//判断是否新用户
								//给邀请人发送第二次投资奖励
								accountInfoService.sendRecommendReward(account, 2, money);
							}
						}
						
						//------------------------518理财节    发送投资奖励  投资本金的18%-------------------------------
						//XXX 判断是否在活动期间注册
						// 结束和开始开关
						/*if ((DateUtils.compareDateLongs("2018-05-31", accountInfoBean.getRegTime()))
								&& DateUtils.compareDateLongs(accountInfoBean.getRegTime(),Constants.FIVE_ZERO_EIGHT_ACTIVITY_BEGIN_TIME))
						{
							investRecordBean.setIsDayProfit("0");
							//首次投资月标
							if(investRecordService.countFirstSubject(investRecordBean)==1)
							{
								sendCashCouponService.sendCashCoupon(account, accountInfoBean.getTelephone(), money);
							}
							
						}*/
						//------------------------518理财节    发送投资奖励  投资本金的18%-------------------------------
					}
					//改变等级
					accountLevelService.updateVIP(accountId);
				}
				
				SubjectBean subjectBean = new SubjectBean();
				subjectBean.setSubjectId(subjectId);
				//查看标的详情
				subjectBean = subjectService.querySubjectById(subjectBean);
				
				//跨年活动
				//String resultA=sendCashCouponService.sendNewYearAward(accountId, money);
				
				//猫咪红包储蓄  体验金投资除外
				if(Double.parseDouble(money) > 0){
					if(Constants.DEVIL_NUM_ONE.equals(subjectBean.getSubjectTerm())){
						Integer multiple = subjectBean.getSubjectPeriods();
						resultC = savingsService.addSavingsRecord(accountId, money, "0", multiple);
						if("addsuccess".equals(resultC))
						{
							SavingsBean savingsBean = new SavingsBean();
							savingsBean.setAccountId(accountId);
							SavingsBean sBean = savingsService.findSavingsNearest(savingsBean);
							savingsMoney=sBean.getSavingsMoney();
							savingsId=sBean.getSavingsId();
						}
					}
				}
				/*-----------518理财节投资活动------------*/
				// 结束和开始开关
				/*if ((DateUtils.compareDateLongs("2018-05-31", paramService.getCurrentTime().getNowDay()))
						&& DateUtils.compareDateLongs(paramService.getCurrentTime().getNowDay(), Constants.FIVE_ZERO_EIGHT_ACTIVITY_BEGIN_TIME))
				{
					//不是天标且投资满6800
					if(!subjectBean.getSubjectTerm().equals("0")&&Double.parseDouble(money)>=6800)
					{
						sendCashCouponService.sendCashCoupon(accountId, money);
					}
				}*/
				
				/*-----------518理财节投资活动------------*/
				
				if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()))
				{
					
					/*-----------------春节活动-邀请好友-----------------------*/
					//当前时间
					String nowDate = paramService.getCurrentTime().getNowHours();
					//在两个时间之间
					if((DateUtils.compareDateLongs(nowDate, Constants.SPRING_FESTIVAL_BEGIN_TIME))&&DateUtils.compareDateLongs(Constants.SPRING_FESTIVAL_END_TIME, nowDate)){
						
						//登录人的信息
						AccountInfo accountInfoBean = new AccountInfo();
						accountInfoBean=accountInfoService.iosGetLoginAccountInfo(accountId);
						
						//判断是否有邀请人
						if((Double.parseDouble(money) > 0) && !StringTools.isNullOrEmpty(accountInfoBean.getRecommendTelephone())){
							//邀请人信息
							AccountInfo account = accountInfoService.getAccountInfoByPhone(accountInfoBean.getRecommendTelephone());
							
							//判断是否新用户(春节活动内注册) 
							if((DateUtils.compareDateLongs(accountInfoBean.getRegTime(), Constants.SPRING_FESTIVAL_BEGIN_TIME)) && 
								DateUtils.compareDateLongs(Constants.SPRING_FESTIVAL_END_TIME, accountInfoBean.getRegTime())){
								
								//判断是否第一次投标
								InvestRecordBean investRecordBean = new InvestRecordBean();
								investRecordBean.setAccountId(accountId);
								
								//并且第一次投资
								if(investRecordService.countFirstSubject(investRecordBean)==1)
								{
									//春节邀请好友
									sendCashCouponService.sendSpringFriends(accountId, account.getAccountId(), money);
								}
							}
	
						}
						
					}
					/*-----------------春节活动-邀请好友结束-----------------------*/
					
					result = "querynewsubject";
				}
				else if(Constants.DEVIL_NUM_ONE.equals(subjectBean.getSubjectType())) 
				{
					/*-----------------春节活动-投资-----------------------*/
					//当前时间
					String nowDate = paramService.getCurrentTime().getNowHours();
					//在两个时间之间
					if((DateUtils.compareDateLongs(nowDate, Constants.SPRING_FESTIVAL_BEGIN_TIME))&&DateUtils.compareDateLongs(Constants.SPRING_FESTIVAL_END_TIME, nowDate)){
						sendCashCouponService.sendSpringFestival(accountId, money);
					}
					/*-----------------春节活动-投资结束-----------------------*/
					
					result = "querysubject";
				}
				else if(Constants.DEVIL_NUM_FOUR.equals(subjectBean.getSubjectType())) 
				{
					/*-----------------春节活动-投资-----------------------*/
					//当前时间
					String nowDate = paramService.getCurrentTime().getNowHours();
					//在两个时间之间
					if((DateUtils.compareDateLongs(nowDate, Constants.SPRING_FESTIVAL_BEGIN_TIME))&&DateUtils.compareDateLongs(Constants.SPRING_FESTIVAL_END_TIME, nowDate)){
						sendCashCouponService.sendSpringFestival(accountId, money);
					}
					/*-----------------春节活动-投资结束-----------------------*/
					result ="queryhighsubject";
				}
			}
			else
			{
				result = "errorLowMoney";
			}
			map.put("resultC", resultC);
			map.put("result", result);
			map.put("flag", flag);
			map.put("savingsMoney", savingsMoney);
			map.put("savingsId", savingsId);
			
		}
		catch (SQLException e)
		{
			logger.error("SQL投标失败", e);
		}
		return map;
	}
	
	/**
	 * 查询我的优惠券
	 * @Description: /ios/subject/querymycoupon
	 * @param request
	 * @param subjectBean
	 * @param inputMoney
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年6月5日 下午4:09:27
	 */
	@ResponseBody
	@RequestMapping("/querymycoupon")
	public JSONObject queryMyCoupon(String accountId,String subjectId,String inputMoney)
	{
		JSONObject obj = new JSONObject();
		List<CouponBean> listCouponBean = null;
		CouponBean couponBean = new CouponBean();
		
		SubjectBean subjectBean=new SubjectBean();
		subjectBean.setSubjectId(subjectId);
		//获取用户id
		couponBean.setAccountId(accountId);
		
		//是否使用(0:否 1:是)
		couponBean.setIsUsed(Constants.DEVIL_NUM_ZERO);
		couponBean.setIsBad("0");
		try
		{
			
			subjectBean = subjectService.querySubjectById(subjectBean);
			
			//flag判断标识 不为空则查询优惠券权限
			//(0:无限制 1:限制所有 2:部分限制)
			if(Constants.DEVIL_NUM_TWO.equals(subjectBean.getIsLimit()))
			{
				couponBean.setFlag(Constants.DEVIL_NUM_ELEVEN);
				couponBean.setSubjectId(subjectBean.getSubjectId());
			}
			else if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getIsLimit()))
			{
				couponBean.setFlag(Constants.DEVIL_NUM_TWEVEL);
				couponBean.setSubjectId(subjectBean.getSubjectId());
			}
			//查询标使用类型
			couponBean.setSubjectType(subjectBean.getSubjectType());
			// 查询优惠券列表
			listCouponBean = couponService.queryCoupons(couponBean);
			
			
			for (int i = 0; i < listCouponBean.size(); i++)
			{
				String cType = listCouponBean.get(i).getCouponType();
				
				// 如果不是加息券的话金额分转元
			 	if (!"1".equals(cType))
				{
					// 获取体验金，红包金额 分转元
					listCouponBean.get(i).setCouponMoney(MoneyUtils.changeFToY(listCouponBean.get(i).getCouponMoney()));
				}
			 	String StartMoney =  MoneyUtils.changeFToY(listCouponBean.get(i).getStartMoney());
				StartMoney = StartMoney.substring(0, StartMoney.indexOf("."));
				listCouponBean.get(i).setStartMoney(StartMoney);
			}
			obj.put("listCouponBean", listCouponBean);
			obj.put("inputMoney",inputMoney );
			obj.put("subjectId", subjectBean.getSubjectId());
			obj.put("msg", "");
			obj.put("code", 200);
		}
		catch (SQLException e)
		{
			logger.error("查询优惠券异常", e);
			obj.put("msg", "查询我的优惠券失败");
			obj.put("code", 300);
		}
		return obj;
	}
}
