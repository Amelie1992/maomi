/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.ActivityParam
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Elias Zheng
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年8月22日    Elias Zheng  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @className:com.xed.financing.wxgzh.util.ActivityParam
 * @description:
 * @version:v1.0.0
 * @date:2017年8月22日 下午2:32:21
 * @author:Elias Zheng
 */
public class ActivityParam
{
	/**
	 * 奖项及概率
	 */
	public static Map<String, Double> ACTIVITY_PRIZE = new HashMap<String, Double>();

	/**
	 * 内容概率
	 */
	public static Map<Integer, Double> GAIN_PRIZE = new HashMap<Integer, Double>();
	
	/**
	 * 内容概率
	 */
	public static Map<String, String> GAIN_CONTENT = new HashMap<String, String>();

	static
	{
		// 奖项概率
		ACTIVITY_PRIZE.put("0", 42.17);		//签到 25
		ACTIVITY_PRIZE.put("1", 50.00);		//投资爆款 20
		ACTIVITY_PRIZE.put("2", 100.00);	//鱼干抽奖
		ACTIVITY_PRIZE.put("3", 15.00);		//鱼干充值 10
		ACTIVITY_PRIZE.put("4", 50.00);		//债权转让 20

		// 内容概率
		GAIN_PRIZE.put(1, 25.00);	//举
		GAIN_PRIZE.put(2, 25.00);	//国
		GAIN_PRIZE.put(3, 25.00);	//欢
		GAIN_PRIZE.put(4, 25.00);	//庆
		
		GAIN_CONTENT.put("1", "举");
		GAIN_CONTENT.put("2", "国");
		GAIN_CONTENT.put("3", "欢");
		GAIN_CONTENT.put("4", "庆");
		
	}
}
