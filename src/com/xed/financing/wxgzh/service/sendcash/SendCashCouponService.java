/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.sendcash.SendCashCouponService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年9月21日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.sendcash;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.xed.financing.wxgzh.model.accountaddress.AccountAddressBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.subject.SubjectBean;

/**
 * @className:com.xed.financing.wxgzh.service.sendcash.SendCashCouponService
 * @description:
 * @version:v1.0.0 
 * @date:2017年9月21日 下午3:44:01
 * @author:QT
 */
public interface SendCashCouponService
{
	/**
	 * 发送现金券  提示语
	 * @Description:
	 * @param request
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月26日 上午9:47:00
	 */
	public String sendCashCoupon(HttpServletRequest request,SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 发送优惠券
	 * 需传入  优惠券金额（如果不是加息券  金额需为分）有效期  计息期限  优惠券类型
	 * @Description:
	 * @param accountId
	 * @param couponDetail
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月26日 上午10:27:49
	 */
	public String sendActivityCoupon(String accountId,SubjectBean subjectBean,String money) throws SQLException;
	
	/**
	 * 双十一发送加息券
	 * @Description:
	 * @param accountId
	 * @param subjectBean
	 * @param money
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月2日 下午2:44:47
	 */
	public void sendElevenFreedomCoupon(String accountId) throws SQLException;
	
	/**
	 * 兑换手机
	 * @Description:
	 * @param accountId
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月3日 下午4:54:41
	 */
	public void buyIphone(AccountAddressBean accountAddressBean,String accountId,int money,int periods,String color,int packs) throws SQLException;
	
	/**
	 * 发放现金奖励(直接发放至余额)
	 * 
	 *
	 */
	public void sendCash(String accountId,String money) throws SQLException;
	
	/**
	 * 判断2017跨年奖励是否满足
	 * @Description:
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年12月21日 上午9:42:22
	 */
	public String sendNewYearAward(String accountId,String money) throws SQLException;
	
	/**
	 *  双旦活动，赠送食用油 
	 * @Description:(用户ID,标,金额,礼物类型)
	 * @return 标识
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月18日 下午1:47:21
	 */
	public String sendGift(String accountId,SubjectBean subjectBean,String money, String type) throws SQLException;
	
	/**
	 * 春节活动 投资
	 * @Description:
	 * @param accountId
	 * @param money
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年1月31日 上午10:18:17
	 */
	public void sendSpringFestival(String accountId, String money) throws SQLException;
	
	/**
	 * 春节 邀请好友送加息卷
	 * @Description:
	 * @param accountId
	 * @param money
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月1日 上午9:16:25
	 */
	public void sendSpringFriends(String accountIdlogin, String accountIdfriend, String money) throws SQLException;
	
	/**
	 * 518理财节  邀请好友超级返
	 * @Description:
	 * @param accountInfo  推荐人信息
	 * @param telephone  投资人手机号
	 * @param money
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年5月8日 上午11:47:19
	 */
	public String sendCashCoupon(AccountInfo accountInfo,AccountInfo investAccount,String money,String awardType)throws SQLException;
	
	/**
	 * 518理财节 全民投资拿大奖
	 * @Description:
	 * @param accountInfo  推荐人信息
	 * @param telephone  投资人手机号
	 * @param money
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年5月8日 上午11:47:19
	 */
	public void sendCashCoupon(String accountId,String investMoney,String couponMoney,String telephone,String recommendTelephone)throws SQLException;
	
	/**
	 * 发送现金券
	 * @Description:
	 * @param accountId
	 * @param couponMoney
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月8日 下午5:18:14
	 */
	public void sendCashCouponByMoney(String accountId,String couponMoney)throws SQLException;

}
