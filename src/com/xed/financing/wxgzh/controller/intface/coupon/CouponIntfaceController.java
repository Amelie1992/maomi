/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.coupon.CouponIntfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月23日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.coupon;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

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
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.intface.coupon.CouponIntfaceController
 * @description:
 * @version:v1.0.0
 * @date:2018年4月23日 下午5:09:16
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/ios/coupon")
public class CouponIntfaceController
{
	private Logger logger = Logger.getLogger(CouponIntfaceController.class);

	@Autowired
	private CouponService couponService;

	@Autowired
	private ParamService paramService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	
	/**
	 * 优惠券列表
	 * 
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/coupon/querycoupon?accountId=&isUsed=&isBad&couponType=
	 * @param accountId
	 * @param isUsed
	 * @param isBad
	 * @param couponType
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年4月24日 上午11:44:27
	 */
	@ResponseBody
	@RequestMapping("/querycoupon")
	public JSONObject querycoupon(String accountId, String isUsed, String isBad, String couponType)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		// 跳转页面
		try
		{
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountId);
			couponBean.setIsUsed(isUsed);
			couponBean.setIsBad(isBad);
			couponBean.setCouponType(couponType);

			if (StringTools.isNullOrEmpty(couponBean.getCouponType()))
			{
				couponBean.setCouponType("-1");
			}
			// 查询标使用类型
			// 查询优惠券列表
			List<CouponBean> listCouponBean = couponService.queryCoupon(couponBean);
			for (int i = 0; i < listCouponBean.size(); i++)
			{
				String cType = listCouponBean.get(i).getCouponType();
				// 如果不是加息券的话金额分转元
				if (!"1".equals(cType))
				{
					// 获取体验金，红包金额 分转元
					listCouponBean.get(i).setCouponMoney(MoneyUtils.changeFToY(listCouponBean.get(i).getCouponMoney()));
				}
				String StartMoney = MoneyUtils.changeFToY(listCouponBean.get(i).getStartMoney());
				StartMoney = StartMoney.substring(0, StartMoney.indexOf("."));
				listCouponBean.get(i).setStartMoney(StartMoney);
			}
			JSONObject objs = new JSONObject();

			objs.put("listCouponBean", listCouponBean);
			objs.put("couponBean", couponBean);
			obj.put("data", objs);
			
			msg = "";
			code = "200";
		}
		catch (Exception e)
		{
			logger.error("获取用户优惠券信息异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

	/**
	 * 使用优惠券
	 * @Description: http://127.0.0.1:8080/xed_financing_wxgzh/ios/coupon/useCashCoupons?accountId=&additionalId=
	 * @param accountId
	 * @param additionalId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年4月24日 下午2:12:16
	 */
	@ResponseBody
	@RequestMapping("/useCashCoupons")
	public JSONObject useCashCoupons(String accountId, String additionalId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		// 跳转页面
		try
		{
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setAccountId(accountId);
			
			//用户没有投资
			String couponId = paramService.getParamVal(Constants.REGISTER_COUPON_ID);
			
			String getcouponId = couponService.checkUserCoupon(accountInfo.getAccountId(), additionalId);
			
			if(!StringTools.isNullOrEmpty(getcouponId) && getcouponId.equals(couponId)  && accountInfoService.countInvestSubject(accountInfo) == 0){
				msg = "未投资";
				code = "202";
			}else{
				if(couponService.useCashCoupons(additionalId, accountInfo)){
					msg = "使用成功";
					code = "200";
				}
			}
		}
		catch (Exception e)
		{
			logger.error("使用现金券异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 合成优惠券
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/coupon/fuseCoupon?accountId=&couponIds=&couponType=
	 * @param couponIds
	 * @param couponType
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月23日 下午1:23:05
	 */
	@ResponseBody
	@RequestMapping("/fuseCoupon")
	public JSONObject fuseCoupon(String couponIds,String couponType,String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			code = couponService.iosFuseCoupon(couponIds, couponType, accountId);
			if ("200".equals(code))
			{
				msg = "";
			} else if ("301".equals(code)) {
				msg = "可融合次数不足";
			} else if ("302".equals(code)) {
				msg = "优惠券个数不正确";
			} else if ("303".equals(code)) {
				msg = "鱼干数量不足";
			} else if ("304".equals(code)) {
				msg = "有已使用或已过期的优惠券!";
			}
			
		}
		catch (Exception e)
		{
			logger.error("融合优惠券异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}

}
