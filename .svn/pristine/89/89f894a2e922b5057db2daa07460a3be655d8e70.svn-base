package com.xed.financing.wxgzh.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 随机数
 * @className:com.xed.financing.wxgzh.util.MathRandom
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月11日 上午11:24:18
 * @author:Peng Gang
 */
public class MathRandom
{
	//奖项随机
	public static Map<Integer, Double> RANDOM_MONEY = new HashMap<Integer, Double>();
	
	static{
		//随机钱概率
		RANDOM_MONEY.put(1, 70.00);
		RANDOM_MONEY.put(2, 30.00);
	}
	/**
	 * 获得两个数之间按比例生成的 数值
	 * @Description:
	 * @param start
	 * @param end
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月18日 上午10:34:55
	 */
	public static Integer getRandom(int start, int end){
		if(start > end){
			return 0;
		}
		double item = Math.floor(Math.random() * 10000);
		double prize1 = RANDOM_MONEY.get(1) * 10000 / 100;
		double prize2 = prize1 + RANDOM_MONEY.get(2) * 10000 / 100;
		
		int index = 0;
		
		//System.out.println("奖项随机数-->" + item);
		if (item >= 0 && item <= prize1)
		{
			index = (int)((Math.random() * (end - start) / 2) + start);
		}
		else if (item >= (prize1 + 1) && item <= prize2)
		{
			index = (int)((Math.random() * (end - start) / 2) + start + (end - start) / 2);
		}		
		return index;
	}
	
	public static void main(String[] args)
	{
		int a;
		int b = 0,c = 0;
		for(int i = 0; i < 100000; i++){
			a = getRandom(150,350);
			if(a < 150 || a >= 350){
				System.out.println(a);
				b++;
			}
		}
		System.out.println("小于概率 : " + b);
	}
	
	/**
	 * 
	 * @Description:
	 * @param length 长度
	 * @param start 最小
	 * @param end  最大
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月11日 上午11:30:14
	 */
	public int[] getMathRandom(int length, int min, int max){
		
		if(max <= min || length < 0){
			return null;
		}
		int[] random = new int[length];
		for(int i = 0; i < length; i++){
			random[i] = (int)(Math.random() * (max - min) + min);
		}
		return random;
	}
	
	/**
	 * 产生和为max的length个随机数
	 * @Description:
	 * @param length
	 * @param max  
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月11日 下午12:06:28
	 */
	public static double[] getRandomMoney(int length, double max){ 
		if(max <= 0 || length < 0){
			return null;
		}
		double[] random = new double[length];
		//跟踪前几个数的和
		double sum = 0;
		double money = max;
		for(int i = 0; i < length - 1; i++){
			random[i] = getHalf(max);
			sum += random[i];
			max = max/2;
		}
		//最后一个单独处理
		random[length - 1] = money - sum;
		
		return random;
	}
	
	/**
	 * 随机获取最大值得一半的随机数
	 * @Description:
	 * @param max
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月11日 上午11:57:20
	 */
	public static double getHalf(double max){
		double random = Math.random() * (max / 2);
		return random;
	}
	
	
}
