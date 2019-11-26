/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.RedPackageUtil
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年12月19日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.util.HashMap;
import java.util.Map;

import com.xed.financing.wxgzh.model.draw.DrawPrizeBean;

/**
 * 
 * 随机红包参数配置
 * @className:com.xed.financing.wxgzh.util.RedPackageUtil
 * @description:
 * @version:v1.0.0 
 * @date:2017年12月19日 下午3:07:28
 * @author:QT
 */
public class RedPackageUtil
{
	/**
	 * 积分抽奖优惠券有效期
	 */
	public static String DRAW_COUPON_VALIDITY = "30";

	/**
	 * 积分抽奖提现券有效期(前期)
	 */
	public static String DRAW_COUPON_VALIDITY_CASH = "-1";
	
	/**
	 * 奖项名称
	 */
	public static String REDPACKAGE_CONTENT[] = new String[]
	{"现金券", "加息券","鱼干","小黄米","SK-II神仙水" };

	/**
	 * 奖项及概率
	 */
	public static Map<Integer, Double> REDPACKAGE_PRIZE = new HashMap<Integer, Double>();

	/**
	 * 加息券概率
	 */
	public static Map<Integer, DrawPrizeBean> REDPACKAGE_PRIZE_6 = new HashMap<Integer, DrawPrizeBean>();

	/**
	 * 现金券概率
	 */
	public static Map<Integer, DrawPrizeBean> REDPACKAGE_PRIZE_2 = new HashMap<Integer, DrawPrizeBean>();

	/**
	 * 鱼干概率
	 */
	public static Map<Integer, DrawPrizeBean> REDPACKAGE_PRIZE_5 = new HashMap<Integer, DrawPrizeBean>();


	static
	{
		// 奖项概率
		REDPACKAGE_PRIZE.put(1, 20.00);    	//现金券
		REDPACKAGE_PRIZE.put(2, 34.00);	   	//加息券
		REDPACKAGE_PRIZE.put(3, 35.00);		//鱼干
		REDPACKAGE_PRIZE.put(4, 10.00);		//小黄米
		REDPACKAGE_PRIZE.put(5, 1.00);		//SK-II神仙水
		/*
		REDPACKAGE_PRIZE.put(1, 20.00);    	//现金券
		REDPACKAGE_PRIZE.put(2, 20.00);	   	//加息券
		REDPACKAGE_PRIZE.put(3, 20.00);		//鱼干
		REDPACKAGE_PRIZE.put(4, 20.00);		//小黄米
		REDPACKAGE_PRIZE.put(5, 20.00);		//SK-II神仙水
		*/	
		// 加息券概率
		REDPACKAGE_PRIZE_6.put(1, new DrawPrizeBean(0.50, 25.000));
		REDPACKAGE_PRIZE_6.put(2, new DrawPrizeBean(0.60, 22.000));
		REDPACKAGE_PRIZE_6.put(3, new DrawPrizeBean(0.70, 18.000));
		REDPACKAGE_PRIZE_6.put(4, new DrawPrizeBean(0.80, 15.000));
		REDPACKAGE_PRIZE_6.put(5, new DrawPrizeBean(0.90, 12.300));
		REDPACKAGE_PRIZE_6.put(6, new DrawPrizeBean(1.00, 6.000));
		REDPACKAGE_PRIZE_6.put(7, new DrawPrizeBean(1.20, 1.000));
		REDPACKAGE_PRIZE_6.put(8, new DrawPrizeBean(1.50, 0.500));
		REDPACKAGE_PRIZE_6.put(9, new DrawPrizeBean(1.80, 0.170));
		REDPACKAGE_PRIZE_6.put(10, new DrawPrizeBean(2.00, 0.030));

		// 现金券概率
		REDPACKAGE_PRIZE_2.put(1, new DrawPrizeBean(1.88, 40.000));         
		REDPACKAGE_PRIZE_2.put(2, new DrawPrizeBean(3.88, 30.000));
		REDPACKAGE_PRIZE_2.put(3, new DrawPrizeBean(5.88, 20.000));
		REDPACKAGE_PRIZE_2.put(4, new DrawPrizeBean(8.88, 10.000));
		
		// 鱼干概率
		REDPACKAGE_PRIZE_5.put(1, new DrawPrizeBean(20.00, 25.000));
		REDPACKAGE_PRIZE_5.put(2, new DrawPrizeBean(25.00, 20.000));
		REDPACKAGE_PRIZE_5.put(3, new DrawPrizeBean(30.00, 18.000));
		REDPACKAGE_PRIZE_5.put(4, new DrawPrizeBean(35.00, 15.000));
		REDPACKAGE_PRIZE_5.put(5, new DrawPrizeBean(40.00, 10.000));
		REDPACKAGE_PRIZE_5.put(6, new DrawPrizeBean(66.00, 8.000));
		REDPACKAGE_PRIZE_5.put(7, new DrawPrizeBean(80.00, 2.000));
		REDPACKAGE_PRIZE_5.put(8, new DrawPrizeBean(88.00, 1.000));
		REDPACKAGE_PRIZE_5.put(9, new DrawPrizeBean(90.00, 0.800));
		REDPACKAGE_PRIZE_5.put(10, new DrawPrizeBean(100.00, 0.200));

	}
}
