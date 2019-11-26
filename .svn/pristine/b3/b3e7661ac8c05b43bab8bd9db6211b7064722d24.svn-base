package com.xed.financing.wxgzh.util;
import java.math.BigDecimal;
import java.text.NumberFormat;


/**
 * 
 * @className:com.xtwl.orders.interfaces.util.MoneyUtils
 * @description:金额转换工具
 * @version:v1.0.0 
 * @date:2015-4-3 上午9:28:25
 * @author:XiaoHuayin
 */
public class MoneyUtils
{
	
	  /**金额为分的格式 */    
    public static final String CURRENCY_FEN_REGEX = "\\-?[0-9]+"; 
    
    /**
     * 
     * @Description:将元转化为分(1->100)
     * @param amount
     * @return
     * @version:v1.0
     * @author:XiaoHuayin
     * @date:2015-4-3 上午9:31:15
     */
    public static String changeYToF(String amount){    
        String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额    
        int index = currency.indexOf(".");    
        int length = currency.length();    
        Long amLong = 0l;    
        if(index == -1){    
            amLong = Long.valueOf(currency+"00");    
        }else if(length - index >= 3){    
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));    
        }else if(length - index == 2){    
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);    
        }else{    
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");    
        }    
        return amLong.toString();    
    }  
    
    /**
     * 
     * @Description:将小数型元转化为分(1.00->100)
     * @param amount
     * @return
     * @version:v1.0
     * @author:XiaoHuayin
     * @date:2015-4-3 上午9:31:15
     */
    public static String changeDYToDF(Double amount){    
    	//乘以100计算分
    	/*amount = amount * 100;
    	BigDecimal bd = new BigDecimal(amount); 
    	//String str = bd.toPlainString();
    	
    	//截取分后面小数位
    	amount = bd.doubleValue();*/
    	
    	amount = amount * 100;
    	NumberFormat nf = NumberFormat.getInstance();
    	nf.setGroupingUsed(false); 
    	return nf.format(amount);
    }  

    /**
     * 
     * @Description:将分转化为元(1->0.01)
     * @param amount
     * @return
     * @throws Exception
     * @version:v1.0
     * @author:XiaoHuayin
     * @date:2015-4-3 上午9:29:58
     */
    public static String changeFToY(String amount)
    {  
    	if(StringTools.isNullOrEmpty(amount))
    	{
    		amount="0";
    	}
    	 int sz = amount.length();  
	       for (int i = 0; i < sz; i++) {  
	           if (Character.isDigit(amount.charAt(i)) == false) {  
	        	   return   amount= new BigDecimal(amount).divide(new BigDecimal(100)).setScale(4).toString();  
	           }  
	       }  
	       return amount= new BigDecimal(amount).divide(new BigDecimal(100)).setScale(2).toString();  
    }  
    
    /**
     * 
     * @Description:去除double  小数点后面的数字，返回Integer(99.99->99)
     * @param d
     * @return
     * @version:v1.0
     * @author:ZhangJun
     * @date:2017年3月21日 下午2:14:33
     */
    public static Integer removeDecimalPoint(Double d){
    	String s = formatFloatNumber(d).substring(0, formatFloatNumber(d).indexOf("."));
    	return Integer.valueOf(s);
    }
    
    /**
     * 两个String相减 a-b
     * @Description:
     * @param a
     * @param b
     * @return
     * @version:v1.0
     * @author:Qian Tao
     * @date:2017年4月11日 上午11:05:31
     */
    public static String minString(String a,String b){
    	double c=Double.parseDouble(a)-Double.parseDouble(b);
    	return formatFloatNumber(c);
    }
    
    /**
     * 将Double类型转为String
     * @Description:
     * @param value
     * @return
     * @version:v1.0
     * @author:ZhangJun
     * @date:2017年6月28日 上午9:35:47
     */
    public static String formatFloatNumber(Double value) {
        if(value != null){
            if(value.doubleValue() != 0.00){
                java.text.DecimalFormat df = new java.text.DecimalFormat("#######0.00");
                return df.format(value.doubleValue());
            }else{
                return "0.00";
            }
        }
        return "";
    }
    
    /**
     * 将Double类型转为String,保留多少为  最多两位
     * @Description:
     * @param value
     * @return
     * @version:v1.0
     * @author:ZhangJun
     * @date:2017年6月28日 上午9:35:47
     */
    public static String formatFloatNumbers(Double value,int i) {
        if(value != null){
            if(value.doubleValue() != 0.00){
            	if(i==0)
            	{
            		 java.text.DecimalFormat df = new java.text.DecimalFormat("#######0");
            		 return df.format(value.doubleValue());
            	}
            	else if(i==1)
            	{
           		 	java.text.DecimalFormat df = new java.text.DecimalFormat("#######0.0");
           		 	return df.format(value.doubleValue());
            	}
            	else if(i>=2)
            	{
           		 	java.text.DecimalFormat df = new java.text.DecimalFormat("#######0.00");
           		 	return df.format(value.doubleValue());
            	}
               
                
            }else{
                return "0.00";
            }
        }
        return "";
    }
    
    /**
     * double 转String  保留两位  不四舍五入
     * @Description:
     * @param value
     * @return
     * @version:v1.0
     * @author:QT
     * @date:2018年6月11日 上午11:27:40
     */
    public static String doubleToString(Double value,int i) {
        if(value != null){
            if(value.doubleValue() != 0.00){
                //java.text.DecimalFormat df = new java.text.DecimalFormat("#######0.00");
                BigDecimal df = new BigDecimal(value).setScale(i,BigDecimal.ROUND_DOWN);  
                return df.toPlainString();
            }else{
                return "0.00";
            }
        }
        return "";
    }
    public static void main(String[] args)
	{
		System.out.println(doubleToString(0.50556654,4));
	}	
}
