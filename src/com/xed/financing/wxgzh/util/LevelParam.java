/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.LevelParam
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月9日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 等级参数
 * @className:com.xed.financing.wxgzh.util.LevelParam
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月9日 下午4:57:46
 * @author:ZhangJun
 */
public class LevelParam
{
	/**
	 * 累计签到对应VIP得加息券数值
	 */
	public static Map<String, Double> SIGN_INTEREST_RATE = new HashMap<String, Double>();
	
	/**
	 * 投资固定加息
	 */
	public static Map<String, Double> INVEST_INTEREST_RATE = new HashMap<String, Double>();
	
	/**
	 * 生日投资
	 */
	public static Map<Integer, Integer> BIRTHDAY_INVEST_MONEY = new HashMap<Integer, Integer>();
	
	/**
	 * 生日红包
	 */
	public static Map<Integer, Integer> BIRTHDAY_CASH_COUPON = new HashMap<Integer, Integer>();
	
	/**
	 * 升级得现金券
	 */
	public static Map<Integer, Integer> UPGRADE_CASH_COUPON = new HashMap<Integer, Integer>();
	
	/**
	 * 升级得加息券
	 */
	public static Map<Integer, Double> UPGRADE_INCREASE_INTEREST_COUPON = new HashMap<Integer, Double>();
	
	/**
	 * 升级加息券起投金额
	 */
	public static Map<Integer, Integer> UPGRADE_INVESTMENT_MONEY = new HashMap<Integer, Integer>();
	
	/**
	 * 升级加息券计息时间
	 */
	public static Map<Integer, Integer> UPGRADE_INTEREST_TIME= new HashMap<Integer, Integer>();
	
	/**
	 * 特权提现次数
	 */
	public static Map<Integer, Integer> PRIVILEGE_WITHDRAWALS= new HashMap<Integer, Integer>();
	
	/**
	 * 特权提现金额
	 */
	public static Map<Integer, Integer> WITHDRAWALS_MONEY= new HashMap<Integer, Integer>();
	
	
	/**
	 * 特权补签次数
	 */
	public static Map<Integer, Integer> RETROACTIVE_NUMBERS= new HashMap<Integer, Integer>();
	
	/**
	 * 特权补签消耗鱼干数
	 */
	public static Map<String, Integer> RETROACTIVE_DRIED_FISH= new HashMap<String, Integer>();
	
	/**
	 * 等级划分
	 */
	public static Map<Integer, String> GRADE_DIVISION= new HashMap<Integer, String>();
	
	/**
	 * 降级的金额划分
	 */
	public static Map<String, Integer> DOWN_GRADE_DIVISION= new HashMap<String, Integer>();
	
	public static Integer FUSE_COUPON_USE_SCORE = 100;
	
	/**
	 * 免费提现次数
	 */
	public static Map<Integer, Integer> FREE_WITHDRAWALS_NUMBER = new HashMap<Integer, Integer>();
	
	/**
	 * 利息管理费
	 */
	public static Map<String,Double> LEVEL_MANAGEMENT_INTEREST = new HashMap<String, Double>();
	
	static{
		//累计投资送加息券
		SIGN_INTEREST_RATE.put("0", 0.0);
		SIGN_INTEREST_RATE.put("1", 0.0);
		SIGN_INTEREST_RATE.put("2", 0.07);
		SIGN_INTEREST_RATE.put("3", 0.07);
		SIGN_INTEREST_RATE.put("4", 0.08);
		SIGN_INTEREST_RATE.put("5", 0.08);
		SIGN_INTEREST_RATE.put("6", 0.09);
		SIGN_INTEREST_RATE.put("7", 0.1);
		SIGN_INTEREST_RATE.put("8", 0.1);
		SIGN_INTEREST_RATE.put("9", 0.12);
		SIGN_INTEREST_RATE.put("10", 0.12);
		
		
		//投资固定加息
		INVEST_INTEREST_RATE.put("0", 0.0);
		INVEST_INTEREST_RATE.put("1", 0.0);
		INVEST_INTEREST_RATE.put("2", 0.0);
		INVEST_INTEREST_RATE.put("3", 0.1);
		INVEST_INTEREST_RATE.put("4", 0.3);
		INVEST_INTEREST_RATE.put("5", 0.4);
		INVEST_INTEREST_RATE.put("6", 0.5);
		INVEST_INTEREST_RATE.put("7", 0.6);
		INVEST_INTEREST_RATE.put("8", 0.7);
		INVEST_INTEREST_RATE.put("9", 0.8);
		INVEST_INTEREST_RATE.put("10", 1.0);
		
		
		//生日特权起投金额
		BIRTHDAY_INVEST_MONEY.put(0, 0);
		BIRTHDAY_INVEST_MONEY.put(1, 500000);
		BIRTHDAY_INVEST_MONEY.put(2, 800000);
		BIRTHDAY_INVEST_MONEY.put(3, 1000000);
		BIRTHDAY_INVEST_MONEY.put(4, 1200000);
		BIRTHDAY_INVEST_MONEY.put(5, 2000000);
		BIRTHDAY_INVEST_MONEY.put(6, 3000000);
		BIRTHDAY_INVEST_MONEY.put(7, 4000000);
		BIRTHDAY_INVEST_MONEY.put(8, 5000000);
		BIRTHDAY_INVEST_MONEY.put(9, 6000000);
		BIRTHDAY_INVEST_MONEY.put(10, 7000000);
		
		//生日特权奖励现金红包
		BIRTHDAY_CASH_COUPON.put(0, 0);
		BIRTHDAY_CASH_COUPON.put(1, 2800);
		BIRTHDAY_CASH_COUPON.put(2, 5800);
		BIRTHDAY_CASH_COUPON.put(3, 8800);
		BIRTHDAY_CASH_COUPON.put(4, 10800);
		BIRTHDAY_CASH_COUPON.put(5, 18800);
		BIRTHDAY_CASH_COUPON.put(6, 28800);
		BIRTHDAY_CASH_COUPON.put(7, 38800);
		BIRTHDAY_CASH_COUPON.put(8, 48800);
		BIRTHDAY_CASH_COUPON.put(9, 58800);
		BIRTHDAY_CASH_COUPON.put(10, 68800);
		
		//升级得现金券
		UPGRADE_CASH_COUPON.put(1, 1000);
		UPGRADE_CASH_COUPON.put(2, 3000);
		UPGRADE_CASH_COUPON.put(3, 4000);
		UPGRADE_CASH_COUPON.put(4, 5000);
		UPGRADE_CASH_COUPON.put(5, 6000);
		UPGRADE_CASH_COUPON.put(6, 8000);
		UPGRADE_CASH_COUPON.put(7, 10000);
		UPGRADE_CASH_COUPON.put(8, 12000);
		UPGRADE_CASH_COUPON.put(9, 12000);
		UPGRADE_CASH_COUPON.put(10, 15000);
		
		//升级得加息券
		UPGRADE_INCREASE_INTEREST_COUPON.put(1, 1.0);
		UPGRADE_INCREASE_INTEREST_COUPON.put(2, 1.2);
		UPGRADE_INCREASE_INTEREST_COUPON.put(3, 1.4);
		UPGRADE_INCREASE_INTEREST_COUPON.put(4, 1.6);
		UPGRADE_INCREASE_INTEREST_COUPON.put(5, 1.8);
		UPGRADE_INCREASE_INTEREST_COUPON.put(6, 2.0);
		UPGRADE_INCREASE_INTEREST_COUPON.put(7, 2.3);
		UPGRADE_INCREASE_INTEREST_COUPON.put(8, 2.6);
		UPGRADE_INCREASE_INTEREST_COUPON.put(9, 3.0);
		UPGRADE_INCREASE_INTEREST_COUPON.put(10, 3.5);
		
		//升级加息券起投金额
		UPGRADE_INVESTMENT_MONEY.put(1, 1000000);
		UPGRADE_INVESTMENT_MONEY.put(2, 1000000);
		UPGRADE_INVESTMENT_MONEY.put(3, 1000000);
		UPGRADE_INVESTMENT_MONEY.put(4, 2000000);
		UPGRADE_INVESTMENT_MONEY.put(5, 2000000);
		UPGRADE_INVESTMENT_MONEY.put(6, 3000000);
		UPGRADE_INVESTMENT_MONEY.put(7, 3000000);
		UPGRADE_INVESTMENT_MONEY.put(8, 5000000);
		UPGRADE_INVESTMENT_MONEY.put(9, 5000000);
		UPGRADE_INVESTMENT_MONEY.put(10, 8000000);
		
		//升级加息券计息时间
		UPGRADE_INTEREST_TIME.put(1, 1);
		UPGRADE_INTEREST_TIME.put(2, 1);
		UPGRADE_INTEREST_TIME.put(3, 1);
		UPGRADE_INTEREST_TIME.put(4, 1);
		UPGRADE_INTEREST_TIME.put(5, 1);
		UPGRADE_INTEREST_TIME.put(6, 2);
		UPGRADE_INTEREST_TIME.put(7, 2);
		UPGRADE_INTEREST_TIME.put(8, 3);
		UPGRADE_INTEREST_TIME.put(9, 3);
		UPGRADE_INTEREST_TIME.put(10, 3);
		
		//特权提现次数
		PRIVILEGE_WITHDRAWALS.put(0, 0);
		PRIVILEGE_WITHDRAWALS.put(1, 0);
		PRIVILEGE_WITHDRAWALS.put(2, 0);
		PRIVILEGE_WITHDRAWALS.put(3, 0);
		PRIVILEGE_WITHDRAWALS.put(4, 1);
		PRIVILEGE_WITHDRAWALS.put(5, 1);
		PRIVILEGE_WITHDRAWALS.put(6, 2);
		PRIVILEGE_WITHDRAWALS.put(7, 2);
		PRIVILEGE_WITHDRAWALS.put(8, 3);
		PRIVILEGE_WITHDRAWALS.put(9, 3);
		PRIVILEGE_WITHDRAWALS.put(10, 3);
		
		//特权提现金额
		WITHDRAWALS_MONEY.put(0,0);
		WITHDRAWALS_MONEY.put(1,0);
		WITHDRAWALS_MONEY.put(2,0);
		WITHDRAWALS_MONEY.put(3,0);
		WITHDRAWALS_MONEY.put(4,50000);
		WITHDRAWALS_MONEY.put(5,50000);
		WITHDRAWALS_MONEY.put(6,150000);
		WITHDRAWALS_MONEY.put(7,150000);
		WITHDRAWALS_MONEY.put(8,300000);
		WITHDRAWALS_MONEY.put(9,300000);
		WITHDRAWALS_MONEY.put(10,300000);
		
		//特权补签次数
		RETROACTIVE_NUMBERS.put(0, 0);
		RETROACTIVE_NUMBERS.put(1, 0);
		RETROACTIVE_NUMBERS.put(2, 0);
		RETROACTIVE_NUMBERS.put(3, 1);
		RETROACTIVE_NUMBERS.put(4, 1);
		RETROACTIVE_NUMBERS.put(5, 1);
		RETROACTIVE_NUMBERS.put(6, 2);
		RETROACTIVE_NUMBERS.put(7, 2);
		RETROACTIVE_NUMBERS.put(8, 2);
		RETROACTIVE_NUMBERS.put(9, 3);
		RETROACTIVE_NUMBERS.put(10, 3);
		
		//特权补签消耗鱼干数
		RETROACTIVE_DRIED_FISH.put("0", 0);
		RETROACTIVE_DRIED_FISH.put("1", 0);
		RETROACTIVE_DRIED_FISH.put("2", 0);
		RETROACTIVE_DRIED_FISH.put("3", 30);
		RETROACTIVE_DRIED_FISH.put("4", 25);
		RETROACTIVE_DRIED_FISH.put("5", 20);
		RETROACTIVE_DRIED_FISH.put("6", 20);
		RETROACTIVE_DRIED_FISH.put("7", 15);
		RETROACTIVE_DRIED_FISH.put("8", 10);
		RETROACTIVE_DRIED_FISH.put("9", 10);
		RETROACTIVE_DRIED_FISH.put("10", 5);
		
		//等级划分
		GRADE_DIVISION.put(0, "-1,5000000");
		GRADE_DIVISION.put(1, "5000000,10000000");
		GRADE_DIVISION.put(2, "10000000,30000000");
		GRADE_DIVISION.put(3, "30000000,50000000");
		GRADE_DIVISION.put(4, "50000000,80000000");
		GRADE_DIVISION.put(5, "80000000,120000000");
		GRADE_DIVISION.put(6, "120000000,160000000");
		GRADE_DIVISION.put(7, "160000000,200000000");
		GRADE_DIVISION.put(8, "200000000,250000000");
		GRADE_DIVISION.put(9, "250000000,300000000");
		GRADE_DIVISION.put(10, "300000000");
		
		//降级的金额划分
		DOWN_GRADE_DIVISION.put("1", 2500000);
		DOWN_GRADE_DIVISION.put("2", 5000000);
		DOWN_GRADE_DIVISION.put("3", 15000000);
		DOWN_GRADE_DIVISION.put("4", 25000000);
		DOWN_GRADE_DIVISION.put("5", 40000000);
		DOWN_GRADE_DIVISION.put("6", 60000000);
		DOWN_GRADE_DIVISION.put("7", 80000000);
		DOWN_GRADE_DIVISION.put("8", 100000000);
		DOWN_GRADE_DIVISION.put("9", 125000000);
		DOWN_GRADE_DIVISION.put("10", 150000000);
		
		
		//免费提现次数
		
		FREE_WITHDRAWALS_NUMBER.put(0, 0);
		FREE_WITHDRAWALS_NUMBER.put(1, 0);
		FREE_WITHDRAWALS_NUMBER.put(2, 1);
		FREE_WITHDRAWALS_NUMBER.put(3, 1);
		FREE_WITHDRAWALS_NUMBER.put(4, 1);
		FREE_WITHDRAWALS_NUMBER.put(5, 3);
		FREE_WITHDRAWALS_NUMBER.put(6, 3);
		FREE_WITHDRAWALS_NUMBER.put(7, 3);
		FREE_WITHDRAWALS_NUMBER.put(8, 3);
		FREE_WITHDRAWALS_NUMBER.put(9, 3);
		FREE_WITHDRAWALS_NUMBER.put(10, 3);
		
		
		//利息管理费
		LEVEL_MANAGEMENT_INTEREST.put("0", 5.0);
		LEVEL_MANAGEMENT_INTEREST.put("1", 5.0);
		LEVEL_MANAGEMENT_INTEREST.put("2", 3.0);
		LEVEL_MANAGEMENT_INTEREST.put("3", 3.0);
		LEVEL_MANAGEMENT_INTEREST.put("4", 3.0);
		LEVEL_MANAGEMENT_INTEREST.put("5", 0.0);
		LEVEL_MANAGEMENT_INTEREST.put("6", 0.0);
		LEVEL_MANAGEMENT_INTEREST.put("7", 0.0);
		LEVEL_MANAGEMENT_INTEREST.put("8", 0.0);
		LEVEL_MANAGEMENT_INTEREST.put("9", 0.0);
		LEVEL_MANAGEMENT_INTEREST.put("10", 0.0);
		
	}
	
}
