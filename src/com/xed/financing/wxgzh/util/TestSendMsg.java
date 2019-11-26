package com.xed.financing.wxgzh.util;

public class TestSendMsg
{
	 public static void main(String[] args) {
	        String mobileNumber = "18105181539";//接收验证码的手机号码
	        try {
	            String str = MobileMessageSend.sendMsg(mobileNumber);
	            if("success".equals(str)){
	                System.out.println("发送成功！");
	            }else{
	                System.out.println("发送失败！");
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	        }
//		 String mobileNumber = "18105181539";//手机号码
//	        String code = "61719";//验证码
//	        try {
//	            String str = MobileMessageCheck.checkMsg(mobileNumber,code);
//	            if("success".equals(str)){
//	                System.out.println("验证成功！");
//	            }else{
//	                System.out.println("验证失败！");
//	            }
//	        } catch (Exception e) {
//	            // TODO: handle exception
//	            e.printStackTrace();
//	        }
	    }
}
