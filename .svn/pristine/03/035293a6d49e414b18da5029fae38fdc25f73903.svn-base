/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.coupon.CouponController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月22日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.coupon;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.coupon.CouponController
 * @description:
 * @version:v1.0.0
 * @date:2017年3月22日 下午4:42:52
 * @author:Qian Tao
 */
@Controller
@RequestMapping("/coupon")
public class CouponController
{
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	@Autowired
	private ParamService paramService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(CouponController.class);

	/**
	 * 查询我的优惠券
	 * 
	 * @Description:
	 * @param request
	 * @param type
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月22日 下午5:10:09
	 */
	@RequestMapping("/querycoupon")
	public String queryCoupon(HttpServletRequest request, CouponBean couponBean)
	{
		try
		{
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			couponBean.setAccountId(accountId);
			List<CouponBean> listCouponBean = null;

			if (StringTools.isNullOrEmpty(couponBean.getCouponType()))
			{
				couponBean.setCouponType("-1");
			}
			//查询标使用类型
			// 查询优惠券列表
			listCouponBean = couponService.queryCoupon(couponBean);
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
			request.setAttribute("couponBean", couponBean);
		}
		catch (SQLException e)
		{
			logger.error("查询优惠券列表失败", e);
		}
		return "coupon/couponlist";
	}

	/*@RequestMapping("/useCashCoupons")*/
	@ResponseBody
	@RequestMapping(value="/useCashCoupons",method=RequestMethod.POST)
	public void useCashCoupons(String additionalId,HttpServletRequest request, HttpServletResponse response)
	{
		// 创建标识
		String result = "{\"result\":\"error\"}";
		
		try
		{
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			
			//用户没有投资
			String couponId = paramService.getParamVal(Constants.REGISTER_COUPON_ID);
			String getcouponId = couponService.checkUserCoupon(accountInfo.getAccountId(), additionalId);
			
			//有没有到领取时间
			CouponBean couponBean=new CouponBean();
			couponBean.setAccountId(accountInfo.getAccountId());
			couponBean.setAdditionalId(additionalId);
			String cId =couponService.queryCouponById(couponBean).getCouponId();
			String cIds=paramService.getParamVal("ACTIVITY_CASH_COUPON_COUPON_ID");
			String endTime=paramService.getParamVal("ACTIVITY_CASH_COUPON_TIME");
			String nowTime=paramService.getCurrentTime().getNowHours();
			//现金券必须投资后使用
			if(!StringTools.isNullOrEmpty(getcouponId) && getcouponId.equals(couponId)  && accountInfoService.countInvestSubject(accountInfo) == 0){
				result = "{\"result\":\"noinvest\"}";
			}
			//现金券必须满足时间后使用
			else if(cId.equals(cIds) && !DateUtils.compareDateDay(nowTime, endTime))
			{
				result = "{\"result\":\"noTime\"}";
			}
			else{
				if(couponService.useCashCoupons(additionalId, accountInfo)){
					result = "{\"result\":\"success\"}";
				}
			}
			
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("现金券使用失败", e);
		}
	}

	/**
	 * 跳转优惠券融合
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年12月25日 下午2:49:32
	 */
	@RequestMapping("/toFuseCoupon")
	public String toFuseCoupon(HttpServletRequest request)
	{
		try
		{
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountId);
			// 增值券0,加息券1
			couponBean.setCouponType("1");
			couponBean.setCouponMoney("1");
			List<CouponBean> jxList = couponService.queryFuseCouponList(couponBean);
			for (int i = 0; i < jxList.size(); i++)
			{
				String cType = jxList.get(i).getCouponType();
				// 如果不是加息券的话金额分转元
				if (!"1".equals(cType))
				{
					// 获取体验金，红包金额 分转元
					jxList.get(i).setCouponMoney(MoneyUtils.changeFToY(jxList.get(i).getCouponMoney()));
				}
				String StartMoney =  MoneyUtils.changeFToY(jxList.get(i).getStartMoney());
				StartMoney = StartMoney.substring(0, StartMoney.indexOf("."));
				jxList.get(i).setStartMoney(StartMoney);
			}
			request.setAttribute("jxList", jxList);
			couponBean.setCouponType("0");
			couponBean.setCouponMoney("20000");
			List<CouponBean> zzList = couponService.queryFuseCouponList(couponBean);
			for (int i = 0; i < zzList.size(); i++)
			{
				String cType = zzList.get(i).getCouponType();
				// 如果不是加息券的话金额分转元
				if (!"1".equals(cType))
				{
					// 获取体验金，红包金额 分转元
					zzList.get(i).setCouponMoney(MoneyUtils.changeFToY(zzList.get(i).getCouponMoney()));
				}
				String StartMoney =  MoneyUtils.changeFToY(zzList.get(i).getStartMoney());
				StartMoney = StartMoney.substring(0, StartMoney.indexOf("."));
				zzList.get(i).setStartMoney(StartMoney);
			}
			request.setAttribute("zzList", zzList);
		}
		catch (Exception e)
		{
			logger.error("跳转优惠券融合异常", e);
		}
		return "coupon/fuseCoupon";
	}
	
	
	/**
	 * 切换融合优惠券
	 * @Description:
	 * @param couponsType
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年12月25日 下午3:22:02
	 */
	@ResponseBody
	@RequestMapping(value="/changeFuseCoupon",method=RequestMethod.POST)
	public Map<String, Object> changeFuseCoupon(String couponsType,HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try
		{
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountId);
			//增值券0,加息券1
			couponBean.setCouponType(couponsType);
			List<CouponBean> cList = couponService.queryFuseCouponList(couponBean);
			resultMap.put("cList", cList);
		}
		catch (Exception e)
		{
			logger.error("切换融合优惠券异常", e);
		}
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping(value="/fuseCoupon",method=RequestMethod.POST)
	public Map<String, Object> fuseCoupon(@RequestParam(value = "couponId[]")String[] couponId,String couponType,HttpServletRequest request, HttpServletResponse response)
	{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try
		{
			// 从session中查询出账户ID
			resultMap.put("result",couponService.fuseCoupon(couponId,couponType,request));
		}
		catch (Exception e)
		{
			logger.error("融合优惠券异常", e);
		}
		return resultMap;
	}
	
}
