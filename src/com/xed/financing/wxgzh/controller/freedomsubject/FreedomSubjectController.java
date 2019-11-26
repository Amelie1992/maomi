package com.xed.financing.wxgzh.controller.freedomsubject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.city.CityBean;
import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountbankcard.AccountBankcardService;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.capitaldetail.CapitaldetailService;
import com.xed.financing.wxgzh.service.city.CityService;
import com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.subjectdispersed.SubjectDispersedService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;


@Controller
@RequestMapping("/freedomsubject")
public class FreedomSubjectController
{
	@Autowired
	private FreedomSubjectService freedomSubjectService;
	
	@Autowired
	private CapitalService capitalService;
	
	@Autowired
	private ParamService paramService;
	
	@Autowired
	private AccountBankcardService accountBankcardService;

	@Autowired
	private CapitaldetailService capitaldetailService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private SubjectDispersedService subjectDispersedService;
	
	@Autowired
	private AccountLevelService accountLevelService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(FreedomSubjectController.class);
	
	/**
	 * 
	 * 跳转猫咪宝列表
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 下午2:15:59
	 */
	@RequestMapping("/s/queryfreedomsubject")
	public String queryFreedomSubject(HttpServletRequest request,FreedomSubjectBean freedomSubjectBean)
	{
		try
		{
			List<FreedomSubjectBean> rspList = null;
			rspList=freedomSubjectService.queryFreedomSubject(freedomSubjectBean);
			request.setAttribute("types","6");
			request.setAttribute("rspList",rspList);
		}
		catch (SQLException e)
		{
			logger.error("查询猫咪宝列表异常", e);
		}
		
		return "freedomsubject/freedomsubjectlist";
	}

	/**
	 * 
	 * 跳转猫咪宝详情
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 下午2:30:58
	 */
	@RequestMapping("/s/detailfreedomsubject")
	public String toDetailFreedomSubject(HttpServletRequest request,FreedomSubjectBean freedomSubjectBean)
	{
		try
		{
			freedomSubjectBean=freedomSubjectService.queryFreedomSubjectById(freedomSubjectBean);
			request.setAttribute("fBean", freedomSubjectBean);
			
			//详情显示4条数据
			freedomSubjectBean.setFlag("1");
			List<FreedomSubjectBean> rspList1=null;
			rspList1=freedomSubjectService.querySevenRateAndPromit(freedomSubjectBean);
			request.setAttribute("rspList", rspList1);
			
			//传入echart图 七条数据
			freedomSubjectBean.setFlag("3");
			List<FreedomSubjectBean> rspList=null;
			rspList=freedomSubjectService.querySevenRateAndPromit(freedomSubjectBean);
			StringBuffer dates = new StringBuffer();  
			StringBuffer rates = new StringBuffer();  
			
			for(FreedomSubjectBean fBean:rspList)
			{
				rates.append(fBean.getFreedomRate()+",");
				dates.append(fBean.getFreedomDate()+",");
			}
			rates.deleteCharAt(rates.length()-1);
			dates.deleteCharAt(dates.length()-1);
			request.setAttribute("rates",rates);
			request.setAttribute("dates",dates);
			request.setAttribute("fightGroup",freedomSubjectService.countFightGroups(freedomSubjectBean));
			
			request.setAttribute("count",subjectDispersedService.queryiIsStatus());
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "freedomsubject/freedomsubjectdetail";
	}
	
	/**
	 * 跳转投团记录
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年9月4日 下午3:18:10
	 */
	@RequestMapping("/toDetailFreedomRecord")
	public String toDetailFreedomSubject(HttpServletRequest request,String freedomSubjectId)
	{
		CapitalDetail capitalDetail =new CapitalDetail();
		try
		{
			capitalDetail.setType(Constants.DEVIL_NUM_TWEVEL);
			List<CapitalDetail> rspList = null;
			rspList=capitaldetailService.queryDetailByType(capitalDetail);
			request.setAttribute("rspList", rspList);
			request.setAttribute("freedomSubjectId", freedomSubjectId);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "freedomsubject/freedomsubjectrecord";
	}
	
	/**
	 * 跳转猫咪宝常见问题页面
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月28日 下午2:30:07
	 */
	@RequestMapping("/tohelp")
	public String toDetailFreedomSubjectHelp(HttpServletRequest request,FreedomSubjectBean freedomSubjectBean)
	{
		try
		{
			freedomSubjectBean=freedomSubjectService.queryFreedomSubjectById(freedomSubjectBean);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("fBean", freedomSubjectBean);
		return "freedomsubject/freedomsubjecthelp";
	}
	/**
	 * 跳转转出
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月24日 下午4:51:58
	 */
	@RequestMapping("/turnout")
	public String toTurnOut(HttpServletRequest request,FreedomSubjectBean freedomSubjectBean)
	{
		try
		{
			queryCapital(request);
			freedomSubjectBean=freedomSubjectService.queryFreedomSubjectById(freedomSubjectBean);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("fBean", freedomSubjectBean);
		return "freedomsubject/turnout";
	}
	
	/**
	 * 跳转转入
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月24日 下午4:52:10
	 */
	@RequestMapping("/turnin")
	public String toTurnIn(HttpServletRequest request,FreedomSubjectBean freedomSubjectBean,String type)
	{
		try
		{
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			queryCapital(request);
			freedomSubjectBean=freedomSubjectService.queryFreedomSubjectById(freedomSubjectBean);
			freedomSubjectBean.setFlag("1");
			List<FreedomSubjectBean> rspList=null;
			rspList=freedomSubjectService.querySevenRateAndPromit(freedomSubjectBean);
			request.setAttribute("rspList", rspList);
			StringBuffer dates = new StringBuffer();  
			StringBuffer rates = new StringBuffer();  
			
			for(FreedomSubjectBean fBean:rspList)
			{
				rates.append(fBean.getFreedomRate()+",");
				dates.append(fBean.getFreedomDate()+",");
			}
			rates.deleteCharAt(rates.length()-1);
			dates.deleteCharAt(dates.length()-1);
			//当日限投金额
			double todayLimitMoney=Double.parseDouble(paramService.getParamVal("FREEDOM_SUBJECT_LIMIT_MONEY"));
			//当日已投金额
			freedomSubjectBean.setAccountId(accountId);
			request.setAttribute("todayLimitMoney",todayLimitMoney);
			request.setAttribute("todayAllMoney",MoneyUtils.formatFloatNumber(Double.parseDouble(freedomSubjectService.querySumTodayMoney(freedomSubjectBean))));
			request.setAttribute("rates",rates);
			request.setAttribute("dates",dates);
			request.setAttribute("type", type);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("fBean", freedomSubjectBean);
		
		return "freedomsubject/turnin";
	}
	
	/**
	 * 投资猫咪宝(转入)
	 * @Description:
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 下午2:50:47
	 */
	//@RequestMapping("/checkMoney")
	@RequestMapping(value="/checkMoney",method=RequestMethod.POST)
	public void investFreedomSubject(HttpServletRequest request,HttpServletResponse response,FreedomSubjectBean freedomSubjectBean,String money)
	{
		String result="{\"result\":\"error\"}";
		response.setContentType("application/json");
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		try
		{
			
			//金额bean
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			
			//用户余额
			double balance = capitalBean.getAvailableBalance();
			
			freedomSubjectBean = freedomSubjectService.queryFreedomSubjectById(freedomSubjectBean);
			freedomSubjectBean.setAccountId(accountId);
			
			//单笔限投金额
			double freedomRestrictMoney = Double.parseDouble(freedomSubjectBean.getFreedomRestrictMoney());
			
			//当日限投金额
			double todayLimitMoney=Double.parseDouble(paramService.getParamVal("FREEDOM_SUBJECT_LIMIT_MONEY"));
			//当日已投金额
			double todayAllMoney=Double.parseDouble(freedomSubjectService.querySumTodayMoney(freedomSubjectBean));
			
			//起投金额
			double freedomOriginMoney = Double.parseDouble(freedomSubjectBean.getFreedomOriginMoney());
			
			//剩余金额
			double freedomSurplusMoney =Double.parseDouble(freedomSubjectBean.getFreedomSurplusMoney());
			
			
			double inputMoney =Double.parseDouble(money);
			//输入金额为空
			if(StringTools.isNullOrEmpty(money))
			{
				result = "{\"result\":\"errornull\"}";
			}
			//不为空的情况
			else
			{
				
				if(balance>=inputMoney)
				{
					//如果投资金额大于剩余金额
					if(freedomSurplusMoney<inputMoney)
					{
						result = "{\"result\":\"errorsurplus\"}";
					}
					//金额低于起投金额
					else if(inputMoney<freedomOriginMoney)
					{
						result = "{\"result\":\"errorstart\"}";
					}
					//单笔限投5000
					else if(inputMoney>freedomRestrictMoney)
					{
						result = "{\"result\":\"errorend\"}";
					}
					else if((inputMoney+todayAllMoney)>todayLimitMoney)
					{
						result = "{\"result\":\"errorlimittoday\"}";
					}
					else
					{
						freedomSubjectService.investFreedom(freedomSubjectBean,money);
						result = "{\"result\":\"success\"}";
					}
				}
				//余额不足
				else
				{
					result = "{\"result\":\"errormoney\"}";
				}
			}
			PrintWriter out = response.getWriter();
			out.write(result);
			
		}
		catch (SQLException e)
		{
			logger.error("猫咪宝投标异常", e);
		}
		catch (IOException e)
		{
			logger.error("猫咪宝投标异常", e);
		}
	} 
	
	/**
	 * 
	 * 跳转我的猫咪宝
	 * @Description:
	 * @param request
	 * @param freedomSubjectBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月25日 下午1:48:57
	 */
	@RequestMapping("/toMyFreedom")
	public String toMyFreedomSubject(HttpServletRequest request,FreedomSubjectBean freedomSubjectBean)
	{
		try
		{
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			
			//查询资金
			queryCapital(request);
			
			//默认猫咪宝列表就一条数据
			freedomSubjectBean.setAccountId(accountId);
			request.setAttribute("rspList",freedomSubjectService.queryMyFreedomSubject(freedomSubjectBean));
			
			//累计收益
			request.setAttribute("sumPromitMoney",freedomSubjectService.countPromit(freedomSubjectBean).getSumPromitMoney());
			
			//昨日收益
			freedomSubjectBean.setFlag("1");
			request.setAttribute("yesertdayPromitMoney",freedomSubjectService.countPromit(freedomSubjectBean).getSumPromitMoney());

			request.setAttribute("fightGroup",freedomSubjectService.countFightGroups(freedomSubjectBean));
//			freedomSubjectBean.setFlag("1");
//			List<FreedomSubjectBean> rspList=null;
//			rspList=freedomSubjectService.querySevenRateAndPromit(freedomSubjectBean);
//			request.setAttribute("rspList", rspList);
//			StringBuffer dates = new StringBuffer();  
//			StringBuffer rates = new StringBuffer();  
//			
//			for(FreedomSubjectBean fBean:rspList)
//			{
//				rates.append(fBean.getFreedomRate()+",");
//				dates.append(fBean.getFreedomDate()+",");
//			}
//			rates.deleteCharAt(rates.length()-1);
//			dates.deleteCharAt(dates.length()-1);
//			request.setAttribute("rates",rates);
//			request.setAttribute("dates",dates);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		request.setAttribute("fBean", freedomSubjectBean);
		return "freedomsubject/myfreeedomsubject";
	}
	
	/**
	 * 跳转明细页面
	 * @Description:
	 * @param request
	 * @param type
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月28日 下午8:02:15
	 */
	@RequestMapping("/tocapitaldetail")
	public String toCapitalDetail(HttpServletRequest request,String type)
	{
		
		try
		{
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			CapitalDetail capitalDetail =new CapitalDetail();
			if(StringTools.isNullOrEmpty(type))
			{
				//0则查询猫咪宝明细
				type="0";
			}
			capitalDetail.setType(type);
			capitalDetail.setAccountId(accountId);
			List<CapitalDetail> cList = null;
			cList=capitaldetailService.getAllByType(capitalDetail);
			request.setAttribute("cList",cList);
			request.setAttribute("type", type);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "freedomsubject/FreedomDealRecordl";
	}
	
	/**
	 * 
	 * 转出到可用余额
	 * @Description:
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 下午6:27:29
	 */
	//@RequestMapping("/transferfreedom")
	@RequestMapping(value="/transferfreedom",method=RequestMethod.POST)
	public void transferFreedom(HttpServletRequest request,HttpServletResponse response,FreedomSubjectBean freedomSubjectBean,String money)
	{
		String result="{\"result\":\"error\"}";
		response.setContentType("application/json");
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		try
		{
			//金额bean
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			
			freedomSubjectBean = freedomSubjectService.queryFreedomSubjectById(freedomSubjectBean);
			freedomSubjectBean.setAccountId(accountId);
			
			//起投金额
			double freedomOriginMoney = Double.parseDouble(freedomSubjectBean.getFreedomOriginMoney());
			
			double inputMoney =Double.parseDouble(money);
			
			//输入金额为空
			if(StringTools.isNullOrEmpty(money))
			{
				result = "{\"result\":\"errornull\"}";
			}
			//不为空的情况
			else
			{
				//转出金额小于1元
				if(inputMoney<freedomOriginMoney)
				{
					result = "{\"result\":\"errorstart\"}";
				}
				else
				{
					result=freedomSubjectService.transferFreedom(money, request);
				}
			}
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转提现
	 * @Description:
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月24日 下午4:32:29
	 */
	@RequestMapping("/recharge")
	public String rechargeInfo(HttpServletRequest request, HttpServletResponse response,String inputMoney)
	{
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
		CapitalBean capitalBean = new CapitalBean();
		AccountBankcardBean bankcardBean;
		AccountInfo acc = new AccountInfo();
		Integer count = 0;
		capitalBean.setAccountId(((AccountInfo) request.getSession().getAttribute("account")).getAccountId());
		try
		{
			count = capitaldetailService.queryUserDraw(capitalBean.getAccountId());
			acc = accountInfoService.getLoginAccountInfo(request);
			bankcardBean = accountBankcardService.getAccountBankcardByAccountId(accountInfo.getAccountId());
			// 判断是否实名认证 是否绑定过银行卡
			if (accountInfo.getRealName() == null || "".equals(accountInfo.getRealName()))
			{
				// 未实名认证
				return "pay/certification";
			}
			else if (bankcardBean == null)
			{
				// 未绑定银行卡
				List<CityBean> provinceList = cityService.queryCityBySubCode("-1");
				request.setAttribute("provinceList", provinceList);
				return "pay/bankCard";
			}
			else
			{
				AccountInfo account= accountLevelService.queryAccountLevel(accountInfo);
				
				capitalBean = capitalService.queryCapitalById(capitalBean);
				request.setAttribute("withdrawalsNumber", account.getWithdrawalsNumber());
				request.setAttribute("bankcardBean", bankcardBean);
				request.setAttribute("count", count);
				request.setAttribute("isComp", acc.getIsCompany());
				//猫咪宝提现金额
				request.setAttribute("inputMoney", inputMoney);
			}
		}
		catch (SQLException e)
		{
			logger.error("提现模块，查询个人账户异常", e);
		}
		request.setAttribute("capitalBean", capitalBean);
		return "freedomsubject/Withdrawals";
	}
	
	/**
	 * 查看更多
	 * @Description:
	 * @param request
	 * @param freedomSubjectBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月29日 下午5:06:32
	 */
	@RequestMapping("/s/moreprofit")
	public String queryMoreProfit(HttpServletRequest request,FreedomSubjectBean freedomSubjectBean)
	{
		try
		{
			//flag 1查询七条数据  2查询30条数据
			freedomSubjectBean.setFlag("2");
			List<FreedomSubjectBean> rspList=null;
			rspList=freedomSubjectService.querySevenRateAndPromit(freedomSubjectBean);
			request.setAttribute("rspList", rspList);
			
			FreedomSubjectBean fBean = new FreedomSubjectBean();
			fBean.setFlag("2");
			fBean=freedomSubjectService.queryYesterdayRateAndPromitById(freedomSubjectBean);
			request.setAttribute("fBean", fBean);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return "freedomsubject/moreprofit";
	}
	
	/**
	 * 查询金额
	 * @Description:
	 * @param request
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月25日 下午1:46:13
	 */
	private void queryCapital(HttpServletRequest request)
	{
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		//金额bean
		CapitalBean capitalBean = new CapitalBean();
		capitalBean.setAccountId(accountId);
		try
		{
			capitalBean = capitalService.queryCapitalById(capitalBean);
			
			//考虑科学计数法
			AccountCapital accountCapital=new AccountCapital();
			accountCapital.setFreedomMoney(MoneyUtils.formatFloatNumber(capitalBean.getFreedomMoney()));
			accountCapital.setInvestmentMoney(MoneyUtils.formatFloatNumber(capitalBean.getInvestmentMoney()));
			accountCapital.setFreezeMoney(MoneyUtils.formatFloatNumber(capitalBean.getFreezeMoney()));
			accountCapital.setWithdrawMoney(MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()));
			accountCapital.setNoWithdrawMoney(MoneyUtils.formatFloatNumber(capitalBean.getNoWithdrawMoney()));
			accountCapital.setNowWithdrawMoney(MoneyUtils.formatFloatNumber(capitalBean.getNowWithdrawMoney()));
			accountCapital.setAvailableBalance((MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney())));
			request.setAttribute("capitalBean",accountCapital);
		}
		catch (SQLException e)
		{
			logger.error("跳转转出异常！", e);
		}
	}
	
	
	/**
	 * 猫咪宝提现到银行卡
	 * @Description:
	 * @param request
	 * @param response
	 * @param accountName
	 * @param bankCard
	 * @param money
	 * @param bankName
	 * @param isComp
	 * @param count
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月30日 下午4:31:26
	 */
	/*@RequestMapping("/withdrawMon")*/
	@ResponseBody
	@RequestMapping(value="/withdrawMon",method=RequestMethod.POST)
	public Map<String, Object> withdrawMon(HttpServletRequest request, HttpServletResponse response,
			String accountName, String bankCard, String money, String bankName, String isComp, String count,Boolean tq)
	{
		Map<String, Object> resutMap = new HashMap<String, Object>();
		try
		{
			String code = freedomSubjectService.withdrawMon(request, response, accountName, bankCard, money, bankName, isComp, count,tq);
			resutMap.put("code", code);
		}
		catch (Exception e)
		{
			logger.error("猫咪宝提现模块异常", e);
		}
		return resutMap;
	}
	
}
