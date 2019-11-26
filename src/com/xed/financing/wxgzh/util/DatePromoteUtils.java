/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.util.DatePromoteUtils
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年6月8日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @className:com.xed.financing.wxgzh.util.DatePromoteUtils
 * @description:
 * @version:v1.0.0 
 * @date:2017年6月8日 下午4:02:46
 * @author:Qian Tao
 */
public class DatePromoteUtils
{
	public static void main(String[] args)
	{
		int a=getDaysByperiods("2017-02-02", "2017-03-03");
		System.out.println(a);
	}
	/**
	 * 短时间格式字符串转换为时间 yyyy-MM-dd
	 * @Description:
	 * @param strDate
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月8日 下午4:24:58
	 */
	public static Date strToDate(String strDate)
	{
		if (strDate == null)
		{
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
	
	
	/**
	 * 入参形式2017-05-12 15:58:45  || 2017-05-12
	 * 返回当月天数
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月8日 下午4:15:45
	 */
	public static int getDaysByMonth(String str)
	{
		Date d = strToDate(str);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		int month =gc.get(Calendar.MONTH)+1;
		int days;  
        int FebDay = 28;  
        //闰年 二月为29天
        if (((year % 100 == 0) && year % 400 == 0) || ((year % 100 != 0) && year % 4 == 0))
        {
        	FebDay=29;
        }
        switch (month)  
        {  
            case 1:  
            case 3:  
            case 5:  
            case 7:  
            case 8:  
            case 10:  
            case 12:  
                days = 31;  
                break;  
            case 4:  
            case 6:  
            case 9:  
            case 11:  
                days = 30;  
                break;  
            case 2:  
                days = FebDay;  
                break;  
            default:  
                days = 0;  
                break;  
        }  
        return days;  
	}
	
	/**
	 * 
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月8日 下午4:35:14
	 */
	public static String getDateByperiods(String str,int num)
	{
		/*Date d = strToDate(str);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		//入参年月日
		int year = gc.get(Calendar.YEAR);
		int month =gc.get(Calendar.MONTH)+1;
		int days = gc.get(Calendar.DAY_OF_MONTH);  */
		
		//返回年月日
		
		Date d = strToDate(str);
		GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DAY_OF_MONTH,-1);
        cal.add(Calendar.MONTH, num);
        
        Date date4 = cal.getTime();
        
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        sdf.format(date4);
	    return sdf.format(date4);
	}
	
	/**
	 * 返回str2和str两个日期之间的天数
	 * @Description:
	 * @param str
	 * @param str2
	 * @param num
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月9日 上午10:26:39
	 */
	public static int getDaysByperiods(String str,String str2)
	{
		/*Date d = strToDate(str);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		//入参年月日
		int year = gc.get(Calendar.YEAR);
		int month =gc.get(Calendar.MONTH)+1;
		int days = gc.get(Calendar.DAY_OF_MONTH);  */
		
		//返回年月日
		
		Date d1 = strToDate(str);
		Date d2 = strToDate(str2);
		GregorianCalendar cal = (GregorianCalendar) Calendar.getInstance();
        cal.setTime(d1);
        long time1 = cal.getTimeInMillis();      
        cal.setTime(d2);
        long time2 = cal.getTimeInMillis(); 
        long between_days=(time2-time1)/(1000*3600*24);       
	    return Integer.parseInt(String.valueOf(between_days));
	}
	
	/**
	 * 判断是否润年
	 * 
	 * @param ddate
	 * @return
	 */
	public static boolean isLeapYear(String ddate)
	{

		/**
		 * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
		 * 3.能被4整除同时能被100整除则不是闰年
		 */
		Date d = strToDate(ddate);
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(d);
		int year = gc.get(Calendar.YEAR);
		if ((year % 400) == 0)
			return true;
		else if ((year % 4) == 0)
		{
			if ((year % 100) == 0)
				return false;
			else
				return true;
		}
		else
			return false;
	}
}
