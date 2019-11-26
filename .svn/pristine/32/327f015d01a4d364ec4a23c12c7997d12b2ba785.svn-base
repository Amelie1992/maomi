/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.subject.SubjectController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月16日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.subject;

import java.sql.SQLException;
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

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;
import com.xed.financing.wxgzh.model.message.CompanyMessageBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.model.subjectpic.SubjectPicBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.activityrecord.ActivityRecordService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.investrecord.InvestRecordService;
import com.xed.financing.wxgzh.service.material.MaterialService;
import com.xed.financing.wxgzh.service.message.MessageService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.savings.SavingsService;
import com.xed.financing.wxgzh.service.sendcash.SendCashCouponService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.service.subjectpic.SubjectPicService;
import com.xed.financing.wxgzh.service.usercompany.UserCompanyService;
import com.xed.financing.wxgzh.service.userhouse.UserHouseService;
import com.xed.financing.wxgzh.service.userlevel.UserLevelService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.subject.SubjectController
 * @description:
 * @version:v1.0.0
 * @date:2017年3月16日 上午11:07:24
 * @author:Qian Tao
 */
@Controller
@RequestMapping("/subject")
public class SubjectController
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
	
	@Autowired
	private UserHouseService userHouseService;
	
	@Autowired
	private UserCompanyService userCompanyService;

	@Autowired
	private MaterialService materialService;
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
			
			//新手标判断是否登陆
			if(!StringTools.isNullOrEmpty(((AccountInfo) request.getSession().getAttribute("account"))))
			{
				SubjectBean sBean = new SubjectBean();
				sBean.setAccountId(((AccountInfo) request.getSession().getAttribute("account")).getAccountId());
				//查询该用户投了多少新手专享标
				int counts = subjectService.countNewSubject(sBean);
				int newCounts=Integer.parseInt(accountInfoService.getLoginAccountInfo(request).getNewSubjectCount());
				request.setAttribute("newCount", newCounts-counts);
			}
			//未登陆默认限投次数为2
			else
			{
				request.setAttribute("newCount", 1);
			}
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
		return "subject/subjectlist";
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
			request.setAttribute("guoQingId", paramService.getParamVal("NATIONAL_SUBJECT_ID"));
			request.setAttribute("zhongQiuId", paramService.getParamVal("MID_AUTUMN_SUBJECT_ID"));
		}
		catch (SQLException e)
		{
			logger.error("查询标列表异常", e);
		}

		// 跳转页面
		return "subject/subjectlist";
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
		return "subject/subjectlist";
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
			querySubject = subjectService.queryNextSubject(subjectBean);
			
			SubjectBean sBean = new SubjectBean();
			sBean=subjectService.countNextSubject(sBean);

			//次日标总数和金额
			request.setAttribute("countNextSubject", sBean.getCountNextSubject());
			request.setAttribute("sumMoney", sBean.getSumMoney());
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
	@RequestMapping("/detailsubject")
	public String querySubjectById(HttpServletRequest request, String id,SubjectBean subjectBean,String isHome)
	{
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		
		// 获取页面Id
		if(!StringTools.isNullOrEmpty(id))
		{
			subjectBean.setSubjectId(id);
		}
		List<SubjectBean> listSubjectAccount = null;
		try
		{
			// 查询标详情
			subjectBean = subjectService.querySubjectById(subjectBean);
			//判断借款类型（1:车贷 2:房贷 3:金融贷）
			if ("1".equals(subjectBean.getLoanType()) || subjectBean.getLoanType() == null || "".equals(subjectBean.getLoanType()))
			{
				request.setAttribute("subjectBeans", subjectBean);
			} else if("2".equals(subjectBean.getLoanType())) {
				request.setAttribute("subjectBeans", subjectBean);
				request.setAttribute("userHouseBean", userHouseService.getUserHouseInfo(subjectBean));
			} else if("3".equals(subjectBean.getLoanType())) {
				request.setAttribute("subjectBeans", subjectBean);
				request.setAttribute("userCompanyBean", userCompanyService.getUserCompanyInfo(subjectBean));
			}
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

			// 传至前台
			request.setAttribute("investedMoney", investedMmoney);
			request.setAttribute("listSubjectAccount", sList);
			request.setAttribute("spLst", spLst);

			CapitalBean capitalBean = new CapitalBean();
			
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			// 获取用户余额
			request.setAttribute("balance", (capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
			
			//查完列表初始化bean
			SubjectBean sBean = new SubjectBean();
			sBean.setAccountId(accountId);
			
			//查询该用户投了多少新手专享标
			int counts = subjectService.countNewSubject(sBean);
			int newCounts=Integer.parseInt(accountInfoService.getLoginAccountInfo(request).getNewSubjectCount());
			if(counts>=newCounts && Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()))
			{
				request.setAttribute("count","over");
			}
			request.setAttribute("isHome",isHome);
			
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
					request.setAttribute("str", str);
				}
				
			}
		}
		catch (SQLException e)
		{
			logger.error("查看标详情失败", e);
		}
		return "subject/subjectdetail";
	}

	/**
	 * 跳转投资页面
	 * 
	 * @Description:
	 * @param request
	 * @param id
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月5日 上午9:38:54
	 */
	@RequestMapping("/investnow")
	public String investNow(HttpServletRequest request, String id,CouponBean couponBean,String iMoney)
	{
		SubjectBean subjectBean = new SubjectBean();
		// 获取页面Id
		subjectBean.setSubjectId(id);
		
		// 从session中查询出账户ID
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
		String accountId = accountInfo.getAccountId();
		request.setAttribute("isRisk", accountInfo.getIsRisk());
		
		int countCompanyMoney=Integer.parseInt(paramService.getParamVal("COMPANY_SUBJECT_COUNT"));
		
		//当日限投金额
		int subjectLimitTodayMoney=Integer.parseInt(paramService.getParamVal("SUBJECT_LIMIT_TODAY_MONEY"));
		try
		{
			subjectBean = subjectService.querySubjectById(subjectBean);
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
					request.setAttribute("str", str);
				}
				
			}
			

			// 查询单条记录并传至前台
			request.setAttribute("subjectBean", subjectBean);
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			
			// 获取用户余额
			request.setAttribute("balance", MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
			
			request.setAttribute("iMoney",iMoney);
			
			couponBean.setAccountId(accountId);
			couponBean.setIsUsed("0");
			couponBean.setIsBad("0");
			couponBean.setSubjectType(subjectBean.getSubjectType());
			//是否需要查询活动券
			
			/*if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType())){
				//天标
				if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectTerm()))
				{
					//7天标
					if(subjectBean.getSubjectPeriods()==7 || subjectBean.getSubjectPeriods()==15)
					{
						//需查询活动券
						couponBean.setCouponType(Constants.DEVIL_NUM_FIVE);
					}
				}
				
				//月标
				else if(Constants.DEVIL_NUM_ONE.equals(subjectBean.getSubjectTerm()))
				{
					//1月标
					if(subjectBean.getSubjectPeriods()==1)
					{
						//需查询活动券
						couponBean.setCouponType(Constants.DEVIL_NUM_FIVE);
					}
				}
			}*/
			
			//如果优惠券没有限制  则查询所有  是否限制优惠券(0:无限制 1:限制所有 2:部分限制)
			if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getIsLimit()))
			{
				//flag判断标识 不为空则查询优惠券权限
				couponBean.setFlag(Constants.DEVIL_NUM_TWEVEL);
				couponBean.setSubjectId(subjectBean.getSubjectId());
				
				request.setAttribute("countCoupon",couponService.countNewMyCoupon(couponBean));
			}
			else if(Constants.DEVIL_NUM_ONE.equals(subjectBean.getIsLimit()))
			{
				request.setAttribute("countCoupon","0");
			}
			else if(Constants.DEVIL_NUM_TWO.equals(subjectBean.getIsLimit()))
			{
				//flag判断标识 不为空则查询优惠券权限
				couponBean.setFlag(Constants.DEVIL_NUM_ELEVEN);
				couponBean.setSubjectId(subjectBean.getSubjectId());
				//用户满足权限所拥有的优惠券
				request.setAttribute("countCoupon",couponService.countNewMyCoupon(couponBean));
			}
			
			/*//新手标就只查体验金数量
			if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()))
			{
				couponBean.setCouponType(Constants.DEVIL_NUM_TWO);
				request.setAttribute("countCoupon",couponService.countNewMyCoupon(couponBean));
			}
			//爆款标只查增值券数量
			else if(Constants.DEVIL_NUM_FOUR.equals(subjectBean.getSubjectType()))
			{
				couponBean.setCouponType(Constants.DEVIL_NUM_TWO);
				request.setAttribute("countCoupon",couponService.countNewMyCoupon(couponBean));
			}
			//普通标只查增值券和加息券数量
			else if(Constants.DEVIL_NUM_ONE.equals(subjectBean.getSubjectType()))
			{
				request.setAttribute("countCoupon",couponService.countMyCoupon(couponBean));
			}*/
			couponBean=couponService.queryCouponById(couponBean);
			if(!StringTools.isNullOrEmpty(couponBean))
			{
				//是否使用(0:否 1:是)
				if("1".equals(couponBean.getIsUsed()))
				{
					couponBean=new CouponBean();
				}
			}
			request.setAttribute("couponBeans",couponBean);
			request.setAttribute("countCompanyMoney",countCompanyMoney);
			request.setAttribute("subjectLimitTodayMoney",subjectLimitTodayMoney);
			
			
			//已领取红包
			MessageBean mBean=new MessageBean();
			mBean.setAccountId(accountId);
			mBean.setMsgTitle("2017跨年红包奖励");
			int countredPackage=messageService.countRecordByTitle(mBean);
			request.setAttribute("countredPackage",countredPackage);
			
			//共获得红包
			subjectBean.setAccountId(accountId);
			subjectBean.setActivityBeginTime(Constants.NEW_YEAR_BEGIN_TIME);
			subjectBean.setActivityEndTime(Constants.NEW_YEAR_END_TIME);
			int allRed=subjectService.countInvestBetweenTime(subjectBean);
			if(allRed>=5)
			{
				allRed=5;
			}
			request.setAttribute("noGetRed", allRed-countredPackage);
			
		}
		catch (SQLException e)
		{
			logger.error("查看标详情失败", e);
		}
		return "subject/investnow";
	}

	/**
	 * 检查投标金额
	 * @Description:
	 * @param creditId
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月5日 下午2:09:33
	 */
	@ResponseBody
	@RequestMapping(value="/checkMoney" ,method=RequestMethod.POST)
	public synchronized Map<String,String> checkMoney(String additionalId, String money,String subjectId,String accountId,HttpServletRequest request, HttpServletResponse response)
	{
		// 设置标识
		Map<String,String> map=new HashMap<String, String>();
		map.put("result", "error");
		// 检查账户余额是否足
		try
		{
			int countCompanyMoney=Integer.parseInt(paramService.getParamVal("COMPANY_SUBJECT_COUNT"));
			int activityLimitMoney=Integer.parseInt(paramService.getParamVal("ACTIVITY_LIMIT_MONEY"));
			int newSubjectLimit=Integer.parseInt(paramService.getParamVal("NEW_SUBJECT_LIMIT_MONEY"));
			//当日限投金额
			int subjectLimitTodayMoney=Integer.parseInt(paramService.getParamVal("SUBJECT_LIMIT_TODAY_MONEY"));
			
			SubjectBean subjectBean = new SubjectBean();
			// 获取页面Id
			subjectBean.setSubjectId(subjectId);
			
			// 从session中查询出账户ID
			if(StringTools.isNullOrEmpty(accountId))
			{
				accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			}
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
			
			//查完列表初始化bean
			SubjectBean sBean = new SubjectBean();
			sBean.setAccountId(accountId);
			//查询该用户投了多少新手专享标
			int counts = subjectService.countNewSubject(sBean);
			int newCounts=Integer.parseInt(accountInfoService.iosGetLoginAccountInfo(accountId).getNewSubjectCount());
			
			//未输入本金  
			if(StringTools.isNullOrEmpty(money))
			{
				//但选择了体验金
				if(!StringTools.isNullOrEmpty(couponBean.getCouponType()))
				{
					//超过限投次数
					if(counts>=newCounts && Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()))
					{
						map.put("result", "errorNewSubject");
					}
					else if(couponBean.getCouponType().equals(Constants.DEVIL_NUM_TWO))
					{
						map=doSubject(request, response, money, subjectId, additionalId,accountId, map);
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
							map.put("result", "errorLowStart");
						}
						//投标金额不是起投金额的整数倍
						else if(investMoney%subjectStartingMoney != 0)
						{
							map.put("result", "errorStartFull");
						}
						//判断是否为企业用户 并且是第一次投标
						else if(isCompany.equals(Constants.DEVIL_NUM_ONE) && companySubject==0 && investMoney>countCompanyMoney)
						{
							map.put("result", "errorFirstCompany");
						}
						//如果投新手标  限投次数不足
						else if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()) && counts>=newCounts)
						{
							map.put("result", "errorNewSubject");
						}
						//如果投新手标  限投1W
						else if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()) && investMoney>newSubjectLimit)
						{
							map.put("result", "errorNewSubjectLimit");
						}
						else if((todayInvestMoney+Integer.parseInt(money))>subjectLimitTodayMoney)
						{
							map.put("result", "errorLimitTodayMoney");
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
									map.put("result", "errorCoupon");
								}
								//使用了活动券  投标金额低于 限制金额
								if(Constants.DEVIL_NUM_FIVE.equals(couponBean.getCouponType()))
								{
									if(investMoney<activityLimitMoney)
									{
										map.put("result", "errorLimitMoney");
									}
									else
									{
										// 获取用户余额
										request.setAttribute("balance", capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney());
										map = doSubject(request, response, money, subjectId, additionalId, accountId,map);
									}
								}
								else if(investMoney*100<Double.parseDouble(couponBean.getStartMoney()))
								{
									//投资金额少于优惠券起投金额
									map.put("result", "errorStartMoney");
								}
								//判断优惠券是否适用
								//新手
								else if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()))
								{
									if(Constants.DEVIL_NUM_ZTWO.equals(sType) || Constants.DEVIL_NUM_ONE.equals(sType)|| Constants.DEVIL_NUM_TWO.equals(sType) || Constants.DEVIL_NUM_FIVE.equals(sType))
									{
										map.put("result", "errorCouponType");
									}
									else
									{
										// 获取用户余额
										request.setAttribute("balance", capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney());
										map=doSubject(request, response, money, subjectId, additionalId,accountId, map);
									}
								}
								//精选理财
								else if(Constants.DEVIL_NUM_ONE.equals(subjectBean.getSubjectType()))
								{
									if(Constants.DEVIL_NUM_ZTWO.equals(sType) || Constants.DEVIL_NUM_ZERO.equals(sType)|| Constants.DEVIL_NUM_TWO.equals(sType) || Constants.DEVIL_NUM_FOUR.equals(sType))
									{
										map.put("result", "errorCouponType");
									}
									else
									{
										// 获取用户余额
										request.setAttribute("balance", capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney());
										map=doSubject(request, response, money, subjectId, additionalId,accountId, map);
									}
								}
								//爆款
								else if(Constants.DEVIL_NUM_FOUR.equals(subjectBean.getSubjectType()))
								{
									if(Constants.DEVIL_NUM_ZTWO.equals(sType) || Constants.DEVIL_NUM_ZERO.equals(sType)|| Constants.DEVIL_NUM_ONE.equals(sType) || Constants.DEVIL_NUM_THREE.equals(sType))
									{
										map.put("result", "errorCouponType");
									}
									else
									{
										// 获取用户余额
										request.setAttribute("balance", capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney());
										map=doSubject(request, response, money, subjectId, additionalId, accountId,map);
									}
								}
								
								else
								{
									// 获取用户余额
									request.setAttribute("balance", capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney());
									map=doSubject(request, response, money, subjectId, additionalId, accountId,map);
								}
							}
							else
							{
								// 获取用户余额
								request.setAttribute("balance", capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney());
								map=doSubject(request, response, money, subjectId, additionalId,accountId, map);
							}
						}
					}
					else
					{
						//余额不足
						map.put("result", "errorLow");
					}
				}
				else
				{
					//标余额不足
					map.put("result", "errorSubject");
				}
			}
		
			
			
			//红包/优惠券/体验金列表显示
			request.setAttribute("listCouponBean", queryCoupon(request,subjectBean,accountId));
			
		}
		catch (SQLException e)
		{
			logger.error("sql异常", e);
		}
		catch (Exception e) {
			logger.error("异常", e);
		}
		return map;
	}


	/**
	 * 查询优惠券
	 * @Description:
	 * @param request
	 * @param subjectBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月5日 下午2:34:41
	 */
	private List<CouponBean> queryCoupon(HttpServletRequest request,SubjectBean subjectBean,String accountId)
	{
		List<CouponBean> listCouponBean = null;
		CouponBean couponBean = new CouponBean();
		
		//获取用户id
		couponBean.setAccountId(accountId);
		
		//是否使用(0:否 1:是)
		couponBean.setIsUsed(Constants.DEVIL_NUM_ZERO);
		try
		{
			//如果是新手专享标  只能使用体验金
			/*if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()))
			{
				couponBean.setCouponType(Constants.DEVIL_NUM_TWO);
				// 查询优惠券列表
			
				listCouponBean = couponService.queryCoupon(couponBean);
			}
			else
			{
				// 查询优惠券列表  除体验金
				listCouponBean = couponService.queryCoupons(couponBean);
			}*/
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
			}
		}
		catch (SQLException e)
		{
			logger.error("查询优惠券异常", e);
		}
		return listCouponBean;
	}
	
	/**
	 * 立即投标
	 * 
	 * @Description:
	 * @param id
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月20日 下午4:40:59
	 */
	public  Map<String,String> doSubject(HttpServletRequest request,HttpServletResponse response, String money, String subjectId,String additionalId,String accountId ,Map<String,String> map )
	{
		
		// 设置标识
		String result = "error";
		String flag = "errorflag";
		String resultC="";
		try
		{
			//个人/公司用户(0:个人 1:公司)
			String isCompany=accountInfoService.getAccountInfo(accountId).getIsCompany();
			
			//查询用户资金
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			// 获取用户余额(可提现金额+不可提现)
			request.setAttribute("balance", capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney());
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
					accountInfoBean=accountInfoService.getLoginAccountInfo(request,accountId);
					
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
					}
				}
				/*-----------2018中秋投资活动begin------------*/
				// 结束和开始开关
				if ((DateUtils.compareDateLongs(Constants.FIVE_ZERO_EIGHT_ACTIVITY_END_TIME, paramService.getCurrentTime().getNowDay()))
						&& DateUtils.compareDateLongs(paramService.getCurrentTime().getNowDay(), Constants.FIVE_ZERO_EIGHT_ACTIVITY_BEGIN_TIME))
				{
					AccountInfo accountInfoBean = new AccountInfo();
					accountInfoBean=accountInfoService.getLoginAccountInfo(request,accountId);
					//判断是否有邀请人
					if(!StringTools.isNullOrEmpty(accountInfoBean.getRecommendTelephone()))
					{
						//邀请人信息
						AccountInfo account = accountInfoService.getAccountInfoByPhone(accountInfoBean.getRecommendTelephone());
						
						//判断是否第一次投标
						InvestRecordBean investRecordBean = new InvestRecordBean();
						investRecordBean.setAccountId(accountId);
						
						//判断是否在活动期间注册
						if ((DateUtils.compareDateLongs(Constants.FIVE_ZERO_EIGHT_ACTIVITY_END_TIME, accountInfoBean.getRegTime()))
								&& DateUtils.compareDateLongs(accountInfoBean.getRegTime(),Constants.FIVE_ZERO_EIGHT_ACTIVITY_BEGIN_TIME))
						{
							investRecordBean.setIsDayProfit("0");
							//首次投资大于等于1个月标
							if(investRecordService.countFirstSubject(investRecordBean)==1&&subjectBean.getSubjectPeriods()>=1)
							{
								//投资满5000低于20000
								double im=Double.parseDouble(money);
								if(im>=1000)
								{
									//查询返多少倍
									int btimes=(int) (im/1000);
									if(btimes>100)
									{
										btimes=100;
									}
									//返现金券金额
									String cashMoney=MoneyUtils.formatFloatNumber(btimes*6.6);
									//投资人发送现金券
									sendCashCouponService.sendCashCouponByMoney(accountId, cashMoney);
									MessageBean messageBean = new MessageBean();
									messageBean.setMsgTitle("2018欢乐国庆送豪礼");
									messageBean.setMsgContent("投资"+money+"元，获得现金券奖励："+cashMoney+"元");
									messageBean.setAccountId(accountId);
									messageService.addMessageInfo(messageBean);
									
									//邀请人发送现金券
									sendCashCouponService.sendCashCouponByMoney(account.getAccountId(), cashMoney);
									MessageBean messageBean2 = new MessageBean();
									messageBean2.setMsgTitle("2018欢乐国庆送豪礼");
									messageBean2.setMsgContent("邀请好友："+accountInfoBean.getTelephone()+"投资"+money+"元，获得现金券奖励："+cashMoney+"元");
									messageBean2.setAccountId(account.getAccountId());
									messageService.addMessageInfo(messageBean2);
									
									//记录信息
									sendCashCouponService.sendCashCoupon(accountId, money, cashMoney, accountInfoBean.getTelephone(), accountInfoBean.getRecommendTelephone());
								}
								
								
							}
							
						}
					}
				}
				/*-----------2018暑期投资活动end------------*/
				
				if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()))
				{
					
					/*-----------------春节活动-邀请好友-----------------------*/
					//当前时间
					String nowDate = paramService.getCurrentTime().getNowHours();
					//在两个时间之间
					if((DateUtils.compareDateLongs(nowDate, Constants.SPRING_FESTIVAL_BEGIN_TIME))&&DateUtils.compareDateLongs(Constants.SPRING_FESTIVAL_END_TIME, nowDate)){
						
						//登录人的信息
						AccountInfo accountInfoBean = new AccountInfo();
						accountInfoBean=accountInfoService.getLoginAccountInfo(request);
						
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
			
			
		}
		catch (SQLException e)
		{
			logger.error("SQL投标失败", e);
		}
		return map;
	}
	
	/**
	 * 我的优惠券
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月12日 上午9:52:16
	 */
	@RequestMapping("/querymycoupon")
	public String queryMyCoupon(HttpServletRequest request,SubjectBean subjectBean,String inputMoney)
	{
		List<CouponBean> listCouponBean = null;
		CouponBean couponBean = new CouponBean();
		
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
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
			request.setAttribute("listCouponBean", listCouponBean);
			request.setAttribute("inputMoney", inputMoney);
			request.setAttribute("id", subjectBean.getSubjectId());
		}
		catch (SQLException e)
		{
			logger.error("查询优惠券异常", e);
		}
		return "subject/mycoupon";
	}
	
	/**
	 * 查看供应链金融合同
	 * @Description:
	 * @param request
	 * @param subjectBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月22日 上午10:28:54
	 */
	@RequestMapping("/supplychainfinancecontract")
	public String querySupplyChainFinanceContract(HttpServletRequest request,SubjectBean subjectBean)
	{
		try
		{
			SubjectBean sBean = new SubjectBean();
			sBean=subjectService.querySubjectById(subjectBean);
			//借款人类型(0:个人 1:公司)
			if(Constants.DEVIL_NUM_ONE.equals(sBean.getBorrowerType()))
			{
				String userName=sBean.getUserName();
				sBean.setUserName(userName.substring(0,2)+"XXXX"+userName.substring(userName.length()-2));
			}
			request.setAttribute("sBean", sBean);
		}
		catch (SQLException e)
		{
			logger.error("查询供应链金融合同异常", e);
		}
		return "subject/supplychainfinancecontract";
	}
	
	public String checkMoneys(String additionalId, String money,String subjectId,HttpServletRequest request, HttpServletResponse response)
	{
		// 设置标识
		String result = "error";
		// 检查账户余额是否足
		try
		{
			int countCompanyMoney=Integer.parseInt(paramService.getParamVal("COMPANY_SUBJECT_COUNT"));
			int activityLimitMoney=Integer.parseInt(paramService.getParamVal("ACTIVITY_LIMIT_MONEY"));
			int newSubjectLimit=Integer.parseInt(paramService.getParamVal("NEW_SUBJECT_LIMIT_MONEY"));
			//当日限投金额
			int subjectLimitTodayMoney=Integer.parseInt(paramService.getParamVal("SUBJECT_LIMIT_TODAY_MONEY"));
			
			SubjectBean subjectBean = new SubjectBean();
			// 获取页面Id
			subjectBean.setSubjectId(subjectId);
			
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
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
						result = "success";
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
							result = "errorLowStart";
						}
						//投标金额不是起投金额的整数倍
						else if(investMoney%subjectStartingMoney != 0)
						{
							result = "errorStartFull";
						}
						//判断是否为企业用户 并且是第一次投标
						else if(isCompany.equals(Constants.DEVIL_NUM_ONE) && companySubject==0 && investMoney>countCompanyMoney)
						{
							result = "errorFirstCompany";
						}
						//如果投新手标  限投1W
						else if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectType()) && investMoney>newSubjectLimit)
						{
							result = "errorNewSubjectLimit";
						}
						else if((todayInvestMoney+Integer.parseInt(money))>=subjectLimitTodayMoney)
						{
							result = "errorLimitTodayMoney";
						}
						else
						{
							//使用优惠券
							if(!StringTools.isNullOrEmpty(additionalId))
							{
								
								//优惠券已使用
								if(!Constants.DEVIL_NUM_ZERO.equals(couponBean.getIsUsed()))
								{
									result = "errorCoupon";
								}
								//使用了活动券  投标金额低于 限制金额
								if(Constants.DEVIL_NUM_FIVE.equals(couponBean.getCouponType()))
								{
									if(investMoney<activityLimitMoney)
									{
										result = "errorLimitMoney";
									}
									else
									{
										// 获取用户余额
										request.setAttribute("balance", capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney());
										result = "success";
									}
								}
								else
								{
									// 获取用户余额
									request.setAttribute("balance", capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney());
									result = "success";
								}
							}
							else
							{
								// 获取用户余额
								request.setAttribute("balance", capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney());
								result = "success";
							}
						}
					}
					else
					{
						//余额不足
						result = "errorLow";
					}
				}
				else
				{
					//标余额不足
					result = "errorSubject";
				}
			}
			
		}
		catch (SQLException e)
		{
			logger.error("sql异常", e);
		}
		catch (Exception e) {
			logger.error("异常", e);
		}
		return result;
	}
	
	@RequestMapping("/goPromptBooks")
	public String goPromptBooks(){
		return "subject/promptBooks";
	}
	
	@RequestMapping("/goLegitimate")
	public String goLegitimate(){
		return "subject/legitimate";
	}
}
