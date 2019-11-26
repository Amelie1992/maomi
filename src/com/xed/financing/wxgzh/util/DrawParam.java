/**
 * Copyright (C) 2016 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.manager.web.util.Constants
 * @description:
 * 
 * @version:v1.0.0 
 * @author:GuoXiaoHu
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-8-4    GuoXiaoHu  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.util.HashMap;
import java.util.Map;

import com.xed.financing.wxgzh.model.draw.DrawPrizeBean;

/**
 * 积分抽奖相关参数配置
 * 
 * @className:com.xed.financing.wxgzh.util.DrawParam
 * @description:
 * @version:v1.0.0
 * @date:2017年6月10日 上午11:58:38
 * @author:Elias Zheng
 */
public class DrawParam
{

	/**
	 * 积分抽奖所需积分
	 */
	public static int DRAW_SCORE = 15;

	/**
	 * 积分抽奖优惠券有效期
	 */
	public static String DRAW_COUPON_VALIDITY = "180";

	/**
	 * 积分抽奖提现券有效期(前期)
	 */
	public static String DRAW_COUPON_VALIDITY_CASH = "-1";

	/**
	 * 奖项名称
	 */
	public static String DRAW_CONTENT[] = new String[]
	{ "", "免费提现券", "现金券", "新手专享标再投机会", "增值券", "鱼干", "加息券", "未中奖" };

	/**
	 * 奖项及概率
	 */
	public static Map<Integer, Double> DRAW_PRIZE = new HashMap<Integer, Double>();

	/**
	 * 加息券概率
	 */
	public static Map<Integer, DrawPrizeBean> DRAW_PRIZE_6 = new HashMap<Integer, DrawPrizeBean>();

	/**
	 * 现金券概率
	 */
	public static Map<Integer, DrawPrizeBean> DRAW_PRIZE_2 = new HashMap<Integer, DrawPrizeBean>();

	/**
	 * 理财金概率
	 */
	public static Map<Integer, DrawPrizeBean> DRAW_PRIZE_4 = new HashMap<Integer, DrawPrizeBean>();

	/**
	 * 鱼干概率
	 */
	public static Map<Integer, DrawPrizeBean> DRAW_PRIZE_5 = new HashMap<Integer, DrawPrizeBean>();

	/**
	 * 随机生成获奖信息
	 */
	public static String DRAW_DATA_NAME[] = new String[]
	{ "现金券", "增值券", "鱼干", "加息券"};

	public static String DRAW_DATA_TEL[] = new String[]
	{ "138", "139", "137", "158", "181", "182", "135", "189", "186", "155" };

	public static String DRAW_DATA_0[] = new String[]
	{ "288.88元", "888.88元" };

	public static String DRAW_DATA_1[] = new String[]
	{ "8000元", "5000元" };

	public static String DRAW_DATA_2[] = new String[]
	{ "200", "500" };

	public static String DRAW_DATA_3[] = new String[]
	{ "2%", "1.8%" };

	static
	{
		// 奖项概率
		DRAW_PRIZE.put(1, 4.00); // 免费提现券
		DRAW_PRIZE.put(2, 8.00); // 现金券
		DRAW_PRIZE.put(3, 4.00); // 新手标再投机会
		DRAW_PRIZE.put(4, 8.00); // 增值券
		DRAW_PRIZE.put(5, 34.00); // 鱼干
		DRAW_PRIZE.put(6, 24.00); // 加息券
		//DRAW_PRIZE.put(8, 4.00); // 月饼
		DRAW_PRIZE.put(7, 18.00); // 未中奖
		
		
		// 加息券概率
		DRAW_PRIZE_6.put(1, new DrawPrizeBean(0.10, 25.000));
		DRAW_PRIZE_6.put(2, new DrawPrizeBean(0.20, 26.000));
		DRAW_PRIZE_6.put(3, new DrawPrizeBean(0.30, 20.000));
		DRAW_PRIZE_6.put(4, new DrawPrizeBean(0.50, 15.000));
		DRAW_PRIZE_6.put(5, new DrawPrizeBean(0.80, 8.300));
		DRAW_PRIZE_6.put(6, new DrawPrizeBean(1.00, 4.000));
		DRAW_PRIZE_6.put(7, new DrawPrizeBean(1.20, 1.000));
		DRAW_PRIZE_6.put(8, new DrawPrizeBean(0.10, 0.500));
		DRAW_PRIZE_6.put(9, new DrawPrizeBean(0.20, 0.170));
		DRAW_PRIZE_6.put(10, new DrawPrizeBean(0.30, 0.030));
		// DRAW_PRIZE_6.put(8, new DrawPrizeBean(1.50, 0.500));
		// DRAW_PRIZE_6.put(9, new DrawPrizeBean(1.80, 0.170));
		// DRAW_PRIZE_6.put(10, new DrawPrizeBean(2.00, 0.030));

		// 现金券概率
		DRAW_PRIZE_2.put(1, new DrawPrizeBean(0.10, 25.000));
		DRAW_PRIZE_2.put(2, new DrawPrizeBean(0.50, 22.000));
		DRAW_PRIZE_2.put(3, new DrawPrizeBean(0.88, 18.000));
		DRAW_PRIZE_2.put(4, new DrawPrizeBean(1.88, 15.000));
		DRAW_PRIZE_2.put(5, new DrawPrizeBean(5.88, 12.020));
		DRAW_PRIZE_2.put(6, new DrawPrizeBean(8.88, 6.008));
		DRAW_PRIZE_2.put(7, new DrawPrizeBean(18.88, 2.240));
		DRAW_PRIZE_2.put(8, new DrawPrizeBean(88.88, 0.200));
		DRAW_PRIZE_2.put(9, new DrawPrizeBean(288.88, 0.030));
		DRAW_PRIZE_2.put(10, new DrawPrizeBean(888.88, 0.002));

		// 增值券概率
		DRAW_PRIZE_4.put(1, new DrawPrizeBean(20.00, 25.080));
		DRAW_PRIZE_4.put(2, new DrawPrizeBean(50.00, 20.500));
		DRAW_PRIZE_4.put(3, new DrawPrizeBean(80.00, 21.000));
		DRAW_PRIZE_4.put(4, new DrawPrizeBean(100.00, 15.000));
		DRAW_PRIZE_4.put(5, new DrawPrizeBean(200.00, 10.420));
		DRAW_PRIZE_4.put(6, new DrawPrizeBean(500.00, 5.000));
		DRAW_PRIZE_4.put(7, new DrawPrizeBean(1000.00, 2.000));
		DRAW_PRIZE_4.put(8, new DrawPrizeBean(2000.00, 1.000));
		DRAW_PRIZE_4.put(9, new DrawPrizeBean(20.00, 0.50));
		DRAW_PRIZE_4.put(10, new DrawPrizeBean(50.00, 0.080));
		// DRAW_PRIZE_4.put(9, new DrawPrizeBean(5000.00, 0.500));
		// DRAW_PRIZE_4.put(10, new DrawPrizeBean(8000.00, 0.080));

		// 鱼干概率
		DRAW_PRIZE_5.put(1, new DrawPrizeBean(1.00, 25.000));
		DRAW_PRIZE_5.put(2, new DrawPrizeBean(2.00, 20.000));
		DRAW_PRIZE_5.put(3, new DrawPrizeBean(5.00, 18.200));
		DRAW_PRIZE_5.put(4, new DrawPrizeBean(10.00, 15.000));
		DRAW_PRIZE_5.put(5, new DrawPrizeBean(20.00, 10.000));
		DRAW_PRIZE_5.put(6, new DrawPrizeBean(50.00, 8.000));
		DRAW_PRIZE_5.put(7, new DrawPrizeBean(80.00, 2.000));
		DRAW_PRIZE_5.put(8, new DrawPrizeBean(100.00, 1.000));
		DRAW_PRIZE_5.put(9, new DrawPrizeBean(200.00, 0.800));
		//DRAW_PRIZE_5.put(10, new DrawPrizeBean(500.00, 0.200));

	}
}
