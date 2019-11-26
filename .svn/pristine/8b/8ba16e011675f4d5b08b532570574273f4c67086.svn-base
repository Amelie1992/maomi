/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.accountInfo.impl.AccountInfoServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月23日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.activityrecord.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.activityrecord.ActivityRecordMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.activityrecord.ActivityRecordBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.activityrecord.ActivityRecordService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.util.ActivityParam;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;

/**
 * @className:com.xed.financing.wxgzh.service.accountInfo.impl.AccountInfoServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年3月23日 上午11:35:35
 * @author:ZhangJun
 */
@Service
public class ActivityRecordServiceImpl implements ActivityRecordService
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(ActivityRecordServiceImpl.class);

	@Resource
	private ActivityRecordMapper activityRecordMapper;

	@Resource
	private MessageMapper messageMapper;
	
	@Autowired
	private CouponService couponService;  
	
	@Resource
	private ParamMapper paramMapper;

	@Override
	@Transactional
	public String activityCalligraphy(HttpServletRequest request, String gainType) throws SQLException
	{
		// 结果
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String nowDate = sdf.format(date);
		
		//结束和开始开关
		if((!DateUtils.compareDateLong(paramMapper.getParamVal(Constants.ACTIVITY_CASHCOUPON_END_TIME), nowDate))||DateUtils.compareDateLong(paramMapper.getParamVal(Constants.ACTIVITY_CASHCOUPON_BEGIN_TIME), nowDate)){
			return result;
		}

		// 获取1-10000随机数
		double calligraphy = Math.floor(Math.random() * 10000);
		// 根据获取方式获得集字数值范围
		double range = ActivityParam.ACTIVITY_PRIZE.get(gainType) * 10000 / 100;

		double nextRange = 5000 + range / 2;

		double lastRange = 5000 - range / 2;

		/*
		 * System.out.println("中奖数字:" + calligraphy);
		 * System.out.println("中奖范围:"+lastRange+"-" + nextRange);
		 */
		/*
		 * System.out.println("中奖范围:1-" + range);
		 * 
		 * // 是否抽中字 if (range >= calligraphy)
		 */
		if (lastRange <= calligraphy && nextRange >= calligraphy)
		{
			double prize1 = ActivityParam.GAIN_PRIZE.get(1) * 10000 / 100;
			double prize2 = prize1 + ActivityParam.GAIN_PRIZE.get(2) * 10000 / 100;
			double prize3 = prize2 + ActivityParam.GAIN_PRIZE.get(3) * 10000 / 100;
			/*
			 * double prize4 = prize3 + ActivityParam.GAIN_PRIZE.get(4) * 10000
			 * / 100;
			 */

			if (calligraphy <= prize1)
			{
				result = "1";
			}
			else if (calligraphy <= prize2)
			{
				result = "2";
			}
			else if (calligraphy <= prize3)
			{
				result = "3";
			}
			else
			{
				result = "4";
			}

			// 发送“字”
			try
			{
				AccountInfo account = (AccountInfo) request.getSession().getAttribute("account");
				ActivityRecordBean activityRecordBean = new ActivityRecordBean();
				activityRecordBean.setAccountId(account.getAccountId());
				activityRecordBean.setGainType(gainType);
				activityRecordBean.setGainContent(ActivityParam.GAIN_CONTENT.get(result));
				activityRecordBean.setGainCode(result);
				// 添加
				activityRecordMapper.addActivityRecord(activityRecordBean);

				MessageBean messageBean = new MessageBean();
				messageBean.setAccountId(account.getAccountId());
				messageBean.setMsgTitle("国庆集字活动");
				messageBean.setMsgContent("恭喜您在国庆集字活动中获得\"" + activityRecordBean.getGainContent() + "\"字,集齐可兑换现金券奖励!");
				messageMapper.addMessageInfo(messageBean);
			}
			catch (Exception e)
			{
				logger.error("活动集字获取异常", e);
			}
		}
		return result;
	}

	@Override
	public Integer countNotConvertible(ActivityRecordBean activityRecordBean) throws SQLException
	{
		return activityRecordMapper.countNotConvertible(activityRecordBean);
	}

	@Override
	@Transactional
	public String exchangeCalligraphy(HttpServletRequest request) throws Exception
	{
		String result = "error";
		AccountInfo account = (AccountInfo) request.getSession().getAttribute("account");
		try
		{
			ActivityRecordBean activityRecordBean = new ActivityRecordBean();
			activityRecordBean.setAccountId(account.getAccountId());

			// 检查是否存在4个字未兑换的
			activityRecordBean.setGainCode("1");
			ActivityRecordBean activityRecordBean1 = activityRecordMapper.getOneNotConvertible(activityRecordBean);

			activityRecordBean.setGainCode("2");
			ActivityRecordBean activityRecordBean2 = activityRecordMapper.getOneNotConvertible(activityRecordBean);

			activityRecordBean.setGainCode("3");
			ActivityRecordBean activityRecordBean3 = activityRecordMapper.getOneNotConvertible(activityRecordBean);

			activityRecordBean.setGainCode("4");
			ActivityRecordBean activityRecordBean4 = activityRecordMapper.getOneNotConvertible(activityRecordBean);

			if (activityRecordBean1 != null && activityRecordBean2 != null && activityRecordBean3 != null
					&& activityRecordBean4 != null)
			{
				//修改已兑换
				activityRecordMapper.exchangeCalligraphy(activityRecordBean1);
				activityRecordMapper.exchangeCalligraphy(activityRecordBean2);
				activityRecordMapper.exchangeCalligraphy(activityRecordBean3);
				activityRecordMapper.exchangeCalligraphy(activityRecordBean4);
				
				//兑换现金券
				couponService.activityCashCoupon(account);
				
				
				result = "success";
			}else{
				result = "lack";
			}
			
		}
		catch (Exception e)
		{
			logger.error("活动集字兑换异常", e);
			throw new RuntimeException();
		}
		return result;
	}

}
