/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.IncomeUtils
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Elias Zheng
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月21日    Elias Zheng  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @className:com.xed.financing.wxgzh.util.IncomeUtils
 * @description:收益计算方法
 * @version:v1.0.0
 * @date:2017年3月21日 上午10:13:28
 * @author:Elias Zheng
 */
public class CalculateUtils
{

	/**
	 * 计算两个日期之间的天数
	 * 
	 * @Description:
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @throws ParseException
	 * @date:2017年3月21日 上午10:19:49
	 */
	public static Integer CalculateDays(String beginDate, String endDate) throws ParseException
	{
		// 格式化日期
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateBegin = sdFormat.parse(beginDate);
		Date dateEnd = sdFormat.parse(endDate);
		
		//如果结束日期大于开始日期,调换时间
		if(dateEnd.before(dateBegin)){
			Date date = dateBegin;
			dateBegin = dateEnd;
			dateEnd = date;
		}

		// 计算天数
		Calendar can1 = Calendar.getInstance();
		can1.setTime(dateBegin);
		Calendar can2 = Calendar.getInstance();
		can2.setTime(dateEnd);

		// 天数
		int year1 = can1.get(Calendar.YEAR);
		int year2 = can2.get(Calendar.YEAR);
		int days = 0;
		days -= can1.get(Calendar.DAY_OF_YEAR);
		days += can2.get(Calendar.DAY_OF_YEAR);
		for (int i = 0; i < Math.abs(year2 - year1); i++)
		{
			// 获取小的时间当前年的总天数
			days += can1.getActualMaximum(Calendar.DAY_OF_YEAR);
			// 再计算下一年。
			can1.add(Calendar.YEAR, 1);
		}
		return days;
	}

	/**
	 * 
	 * @Description:计算收益(参数:金额[分],利率,开始时间,结束时间)
	 * @param money
	 * @param rate
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @throws ParseException
	 * @date:2017年3月21日 上午10:16:23
	 */
	public static Integer CalculatedIncomes(Double money, double rate, String beginDate, String endDate) throws ParseException
	{
		int days = CalculateDays(beginDate, endDate);
		Double incomes = 0.00d;
		int income = 0;
		Double d_rate = (double) (rate * 100 / 100);
		Double d_days = (double) (days * 100 / 100);
		// 按天计算
		if (days < 30)
		{
			incomes = money * (d_rate / 100 / 12 / 30 * d_days);
		}
		else
		{
			// 计算月份和天数
			int month = days / 30;
			days = days % 30;
			Double d_month = (double) month * 100 / 100;
			d_days = (double) days * 100 / 100;
			incomes = money * ((d_rate / 100 / 12 * d_month) + (d_rate / 100 / 12 / 30 * d_days));
		}
		// 截取incomes小数位并除以100;
		income = Integer.parseInt(String.valueOf(incomes).substring(0, String.valueOf(incomes).indexOf(".")));
		return income;
	}

	/**
	 * 
	 * @Description:计算收益和本金总和(参数:金额[分],利率,开始时间,结束时间)
	 * @param money
	 * @param rate
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @throws ParseException
	 * @date:2017年3月21日 上午10:16:23
	 */
	public static Integer CalculatedMoneyAndIncomes(int money, int rate, String beginDate, String endDate)
			throws ParseException
	{
		int days = CalculateDays(beginDate, endDate);
		Double incomes = 0.00d;
		int income = 0;
		Double d_rate = (double) (rate * 100 / 100);
		Double d_days = (double) (days * 100 / 100);
		Double d_money = (double) (money * 100 / 100);
		// 按天计算
		if (days < 30)
		{
			incomes = d_money * (d_rate / 100 / 12 / 30 * d_days);
		}
		else
		{
			// 计算月份和天数
			int month = days / 30;
			days = days % 30;
			Double d_month = (double) month * 100 / 100;
			d_days = (double) days * 100 / 100;
			incomes = d_money * ((d_rate / 100 / 12 * d_month) + (d_rate / 100 / 12 / 30 * d_days));
		}
		// 截取incomes小数位并除以100;
		income = Integer.parseInt(String.valueOf(incomes).substring(0, String.valueOf(incomes).indexOf(".")));
		return income + money;
	}

	
	//测试用
//	public static void main(String[] args) throws ParseException
//	{
//		int moneyDouble = CalculatedIncomes(7010000, 9, "2016-09-01", "2017-02-01");
//		System.out.println(moneyDouble);
//	}

}
