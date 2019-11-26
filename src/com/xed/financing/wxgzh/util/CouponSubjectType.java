/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.CouponSubjectType
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月30日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @className:com.xed.financing.wxgzh.util.CouponSubjectType
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月30日 上午10:10:32
 * @author:QT
 */
public class CouponSubjectType
{
	/**
	 * 奖项及概率
	 */
	public static Map<String, String> COUPON_SUBJECT_TYPE = new HashMap<String, String>();

	static
	{
		// 奖项概率
		COUPON_SUBJECT_TYPE.put("-2", "-2");		//全部不使用
		COUPON_SUBJECT_TYPE.put("-1", "-1");    	//全部适用
		COUPON_SUBJECT_TYPE.put("0", "0");			//仅限新手标
		COUPON_SUBJECT_TYPE.put("1", "1");			//仅限精选理财
		COUPON_SUBJECT_TYPE.put("2", "2");			//仅限爆款标
		COUPON_SUBJECT_TYPE.put("3", "3");			//新手、精选理财
		COUPON_SUBJECT_TYPE.put("4", "4");			//新手、爆款
		COUPON_SUBJECT_TYPE.put("5", "5");			//精选理财、爆款
	}
}
