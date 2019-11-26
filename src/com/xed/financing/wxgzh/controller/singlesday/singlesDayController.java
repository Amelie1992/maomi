/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.singlesday.singlesDayController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月3日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.singlesday;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xed.financing.wxgzh.model.accountaddress.AccountAddressBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.city.CityBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountaddress.AccountAddressService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.city.CityService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.sendcash.SendCashCouponService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.IphoneParam;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.StringTools;
import com.xed.financing.wxgzh.util.ViewJsonUtil;

/**
 * 双十一活动
 * @className:com.xed.financing.wxgzh.controller.singlesday.singlesDayController
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月3日 上午9:22:39
 * @author:QT
 */
@Controller
@RequestMapping("/singlesday")
public class singlesDayController
{
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Autowired
	private SendCashCouponService sendCashCouponService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ParamService paramService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private AccountAddressService accountAddressService;
	
	@Autowired
	private CapitalService capitalService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(singlesDayController.class);
	
	/**
	 * 跳转双十一活动页面
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月2日 上午9:30:37
	 */
	@RequestMapping("/s/gosinglesday")
	public String goSinglesDay(HttpServletRequest request)
	{
		try
		{
			AccountInfo accountInfo=(AccountInfo) request.getSession().getAttribute("account");
			//猫咪宝投资1W还需保持多少天
			int days=11;
			//用户已登录
			if(!StringTools.isNullOrEmpty(accountInfo))
			{
				accountInfo=accountInfoService.getAccountInfo(accountInfo.getAccountId());
				//所有用户初始值为0
				days=11-Integer.parseInt(accountInfo.getIsReward());
				
				SubjectBean subjectBean=new SubjectBean();
				//活动开始时间
				String elevenBeginTime=paramService.getParamVal("ACTIVITY_START_TIME");
				//活动结束时间
				String elevenEndTime=paramService.getParamVal("ACTIVITY_END_TIME");
				subjectBean.setActivityBeginTime(elevenBeginTime);
				subjectBean.setActivityEndTime(elevenEndTime);
				subjectBean.setAccountId(accountInfo.getAccountId());
				//奖励金类型（0现金券 1加息券）
				subjectBean.setAwardType(Constants.DEVIL_NUM_ONE);
				//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标）
				subjectBean.setAwardFrom(Constants.DEVIL_NUM_TWO);
				//投资方式（0首次投资 1累计投资 2满足等额）
				subjectBean.setInvestType("1");
				subjectBean.setSetMoney("1000000");
				subjectBean.setChooseFlag("1");
				request.setAttribute("isReceive", subjectService.countIsGetAward(subjectBean));
			}
			request.setAttribute("days", days);
		}
		catch (SQLException e)
		{
			logger.error("跳转双十一活动页异常！", e);
		}
		
		return "activity/singlesday";
	}
	
	/**
	 * 发送优惠券
	 * @Description:
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月2日 下午2:19:58
	 */
	@ResponseBody
	@RequestMapping(value="/sendcoupon",method=RequestMethod.POST)
	public void sendCoupon(HttpServletRequest request,HttpServletResponse response)
	{
		String result = "{\"result\":\"error\"}";
		response.setContentType("application/json");
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		
		try
		{
			int isReward=Integer.parseInt(accountInfoService.getAccountInfo(accountId).getIsReward());
			//未获得资格
			if(isReward<11){
				result = "{\"result\":\"noreward\"}";
			}
			else
			{
				//-------------------------判断是否领取过----------------------------------
				SubjectBean subjectBean=new SubjectBean();
				//活动开始时间
				String elevenBeginTime=paramService.getParamVal("ACTIVITY_START_TIME");
				//活动结束时间
				String elevenEndTime=paramService.getParamVal("ACTIVITY_END_TIME");
				subjectBean.setActivityBeginTime(elevenBeginTime);
				subjectBean.setActivityEndTime(elevenEndTime);
				subjectBean.setAccountId(accountId);
				//奖励金类型（0现金券 1加息券）
				subjectBean.setAwardType(Constants.DEVIL_NUM_ONE);
				//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标）
				subjectBean.setAwardFrom(Constants.DEVIL_NUM_TWO);
				//投资方式（0首次投资 1累计投资 2满足等额）
				subjectBean.setInvestType("1");
				subjectBean.setSetMoney("1000000");
				subjectBean.setChooseFlag("1");
				int isReceive=subjectService.countIsGetAward(subjectBean);
				if(isReceive>=1)
				{
					result = "{\"result\":\"isHave\"}";
				}
				else
				{
					//发送有效期1个月计息1个月的1%加息券
					sendCashCouponService.sendElevenFreedomCoupon(accountId);
					result = "{\"result\":\"success\"}";
				}
			}
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping("/s/buyiphone")
	public String buyIphone(HttpServletRequest request,AccountAddressBean accountAddressBean)
	{
		try
		{
			//判断活动是否开始
			//活动开始时间
			String elevenBeginTime=paramService.getParamVal("ACTIVITY_START_TIME");
			
			//活动结束时间
			String elevenEndTime=paramService.getParamVal("ACTIVITY_END_TIME");
			
			//当前时间
			String nowDate=paramService.getCurrentTime().getNowDay();
			
			int num=3;
			String switchs="off";
			//结束和开始开关
			if((DateUtils.compareDateLongs(elevenEndTime, nowDate))&&DateUtils.compareDateLongs(nowDate,elevenBeginTime))
			{
				num=3-accountAddressService.countAccountAddress(accountAddressBean);
				if(num<=0)
				{
					switchs="over";
				}
				else
				{
					switchs="on";
				}
			}
			else if(DateUtils.compareDateLongs(nowDate,elevenEndTime))
			{
				switchs="out";
			}
			// 获得省份信息
			List<CityBean> provinceList = cityService.queryCityBySubCode("-1");
			request.setAttribute("provinceList", provinceList);
			
			request.setAttribute("num",num);
			request.setAttribute("switchs",switchs);
			request.setAttribute("goodId",accountAddressBean.getGoodId());
		}
		catch (Exception e)
		{
			logger.error("跳转投资兑换手机页面异常", e);
		}
		return "activity/buyiphone";
	}
	/**
	 * 兑换手机
	 * @Description:
	 * @param request
	 * @param response
	 * @param goodId
	 * @param color
	 * @param type
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月3日 下午5:38:56
	 */
	@ResponseBody
	@RequestMapping(value="/getiphone",method=RequestMethod.POST)
	public void getIphone(HttpServletRequest request,HttpServletResponse response,AccountAddressBean accountAddressBean,String goodId,String color,String packages)
	{
		String result = "{\"result\":\"error\"}";
		response.setContentType("application/json");
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		
		PrintWriter out;
		try
		{
			//判断库存是否还有
			accountAddressBean.setGoodId(goodId);
			int num=3-accountAddressService.countAccountAddress(accountAddressBean);
			
			//金额bean
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			
			//用户余额
			double balance = capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney();
			
			//获取套餐的金额和期限
			Map<Integer,Integer> gpMap=switchMoney(goodId, packages);
			int inputMoney=gpMap.get(1);
			int periods=gpMap.get(2);
			int packs=gpMap.get(3);
			if(num<=0)
			{
				//库存不足
				result = "{\"result\":\"errornum\"}";
			}
			else if(inputMoney>=balance)
			{
				//判断用户余额是否足够
				result = "{\"result\":\"errorMoney\"}";
			}
			else
			{
				//套餐违规
				if(inputMoney==0 || periods==0 ||packs==0)
				{
					result = "{\"result\":\"errorsys\"}";
				}
				else
				{
					if(isColorError(goodId, color)==0)
					{
						result = "{\"result\":\"errorsys\"}";
					}
					else
					{
						//兑换手机
						sendCashCouponService.buyIphone(accountAddressBean,accountId,inputMoney,periods,color,packs);
						result = "{\"result\":\"success\"}";
					}
					
				}
				
			}
			out = response.getWriter();
			out.write(result);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 转换套餐金额
	 * @Description:
	 * @param goodId
	 * @param packages
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月3日 下午5:43:00
	 */
	public Map<Integer,Integer> switchMoney(String goodId,String packages)
	{
		int money=0;
		int periods=0;
		int packs=0;
		//iphone8 64g
		if(Constants.DEVIL_NUM_ONE.equals(goodId))
		{
			
			if(Constants.DEVIL_NUM_ONE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("1").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("1").split(",")[1]);
				packs=1;
			}
			else if(Constants.DEVIL_NUM_TWO.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("2").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("2").split(",")[1]);
				packs=2;
			}
			else if(Constants.DEVIL_NUM_THREE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("3").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("3").split(",")[1]);
				packs=3;
			}
			else if(Constants.DEVIL_NUM_FOUR.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("4").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("4").split(",")[1]);
				packs=4;
			}
		}
		//iphone8 256g
		else if(Constants.DEVIL_NUM_TWO.equals(goodId))
		{
			if(Constants.DEVIL_NUM_ONE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("5").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("5").split(",")[1]);
				packs=5;
			}
			else if(Constants.DEVIL_NUM_TWO.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("6").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("6").split(",")[1]);
				packs=6;
			}
			else if(Constants.DEVIL_NUM_THREE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("7").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("7").split(",")[1]);
				packs=7;
			}
			else if(Constants.DEVIL_NUM_FOUR.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("8").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("8").split(",")[1]);
				packs=8;
			}
		}
		//iphone8plus 64g
		else if(Constants.DEVIL_NUM_THREE.equals(goodId))
		{
			if(Constants.DEVIL_NUM_ONE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("9").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("9").split(",")[1]);
				packs=9;
			}
			else if(Constants.DEVIL_NUM_TWO.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("10").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("10").split(",")[1]);
				packs=10;
			}
			else if(Constants.DEVIL_NUM_THREE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("11").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("11").split(",")[1]);
				packs=11;
			}
			else if(Constants.DEVIL_NUM_FOUR.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("12").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("12").split(",")[1]);
				packs=12;
			}
		}
		//iphone8plus 256g
		else if(Constants.DEVIL_NUM_FOUR.equals(goodId))
		{
			if(Constants.DEVIL_NUM_ONE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("13").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("13").split(",")[1]);
				packs=13;
			}
			else if(Constants.DEVIL_NUM_TWO.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("14").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("14").split(",")[1]);
				packs=14;
			}
			else if(Constants.DEVIL_NUM_THREE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("15").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("15").split(",")[1]);
				packs=15;
			}
			else if(Constants.DEVIL_NUM_FOUR.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("16").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("16").split(",")[1]);
				packs=16;
			}
		}
		//iphone8X 64g
		else if(Constants.DEVIL_NUM_FIVE.equals(goodId))
		{
			if(Constants.DEVIL_NUM_ONE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("17").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("17").split(",")[1]);
				packs=17;
			}
			else if(Constants.DEVIL_NUM_TWO.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("18").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("18").split(",")[1]);
				packs=18;
			}
			else if(Constants.DEVIL_NUM_THREE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("19").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("19").split(",")[1]);
				packs=19;
			}
			else if(Constants.DEVIL_NUM_FOUR.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("20").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("20").split(",")[1]);
				packs=20;
			}
		}
		//iphoneX 256g
		else if(Constants.DEVIL_NUM_SIX.equals(goodId))
		{
			if(Constants.DEVIL_NUM_ONE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("21").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("21").split(",")[1]);
				packs=21;
			}
			else if(Constants.DEVIL_NUM_TWO.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("22").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("22").split(",")[1]);
				packs=22;
			}
			else if(Constants.DEVIL_NUM_THREE.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("23").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("23").split(",")[1]);
				packs=23;
			}
			else if(Constants.DEVIL_NUM_FOUR.equals(packages))
			{
				money=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("24").split(",")[0]);
				periods=Integer.parseInt(IphoneParam.IPHONE_PACKAGE.get("24").split(",")[1]);
				packs=24;
			}
		}
		Map<Integer,Integer> s=new HashMap<Integer, Integer>();
		s.put(1, money);
		s.put(2, periods);
		s.put(3, packs);
		return s;
	}
	
	/**
	 * 查询市
	 * @Description:
	 * @param model
	 * @param accountAddressBean
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月6日 上午10:49:08
	 */
	@RequestMapping("/querysecondcity")
	public ModelAndView querySecondCity(Model model,@ModelAttribute AccountAddressBean accountAddressBean)
	{
		CityBean cityBean = new CityBean();
		cityBean.setSubCityCode(accountAddressBean.getSupCityCode());
		List<CityBean> secondCityList1 = null;
		try
		{
			secondCityList1=cityService.queryCity(cityBean);
		}
		catch (SQLException e)
		{
			logger.error("查询二级市异常！",e);
		}
		return ViewJsonUtil.promptMessage(true, "", JsonUtil.listToJson(secondCityList1));
	}
	
	/**
	 * 查询区
	 * @Description:
	 * @param model
	 * @param accountAddressBean
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月6日 上午10:49:08
	 */
	@RequestMapping("/querythirdcity")
	public ModelAndView queryThirdCity(Model model,@ModelAttribute AccountAddressBean accountAddressBean)
	{
		CityBean cityBean = new CityBean();
		cityBean.setSubCityCode(accountAddressBean.getSupCityCode());
		List<CityBean> thirdCityList1 = null;
		try
		{
			thirdCityList1=cityService.queryCity(cityBean);
		}
		catch (SQLException e)
		{
			logger.error("查询二级市异常！",e);
		}
		return ViewJsonUtil.promptMessage(true, "", JsonUtil.listToJson(thirdCityList1));
	}
	
	/**
	 * 判断颜色是否违规
	 * @Description:
	 * @param goodId
	 * @param color
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月8日 上午11:58:06
	 */
	public int isColorError(String goodId,String color )
	{
		//默认正常
		int flag=1;
		try
		{
			int c=Integer.parseInt(color);
			int g=Integer.parseInt(goodId);
			if(g==1||g==2||g==3||g==4)
			{
				if(c!=1&&c!=2&&c!=3)
				{
					flag=0;
				}
			}
			else if(g==5||g==6)
			{
				if(c!=1&&c!=2)
				{
					flag=0;
				}
			}
			else
			{
				flag=0;
			}
		}
		catch(Exception e)
		{
			flag=0;
		}
		return flag;
	}
}
