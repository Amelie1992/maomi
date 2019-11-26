/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.coupon.CouponService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月22日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.coupon;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.coupon.CouponBean;

/**
 * @className:com.xed.financing.wxgzh.service.coupon.CouponService
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月22日 下午4:36:55
 * @author:Qian Tao
 */
public interface CouponService
{
	/**
	 * 查看用户优惠券列表
	 * @Description:
	 * @param couponBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月22日 下午4:24:14
	 */
	public List<CouponBean> queryCoupon(CouponBean couponBean) throws SQLException;
	
	/**
	 * 查询优惠券列表 除体验金
	 * @Description:
	 * @param couponBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月22日 下午4:43:43
	 */
	public List<CouponBean> queryCoupons(CouponBean couponBean) throws SQLException;
	
	/**
	 * 根据红包id查询红包详情
	 * @Description:
	 * @param couponBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月11日 上午10:36:50
	 */
	public CouponBean queryCouponById(CouponBean couponBean) throws SQLException;
	
	/**
	 * 注册成功送体验金
	 * @Description:
	 * @param accountInfo 当前注册用户
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月2日 下午3:28:55
	 */
	public Integer registeredExperienceGold(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 注册成功送2元现金劵
	 * @Description:
	 * @param accountInfo 当前注册用户
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月2日 下午3:28:55
	 */
	public Integer registeredCashCoupon(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 投标成功奖励邀请人
	 * @Description: 根据投标金额分档奖励邀请人加息券
	 * @param accountInfo 投标用户信息
	 * @param money 投标金额
	 * @return 
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月3日 下午2:15:41
	 */
	public Integer inviteersReward(AccountInfo accountInfo,String money)throws SQLException;
	
	/**
	 * 使用现金券
	 * @Description:
	 * @param couDetailId
	 * @param request
	 * @return
	 * @throws RuntimeException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月2日 下午4:36:44
	 */
	public Boolean useCashCoupons(String additionalId,AccountInfo accountInfo)throws RuntimeException;
	
	/**
	 * 查询优惠券数量
	 * @Description:
	 * @param couponInfoBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月12日 下午2:24:09
	 */
	public Integer countNewMyCoupon(CouponBean couponInfoBean)throws SQLException;
	
	/**
	 * 只查增值券和加息券数量
	 * @Description:
	 * @param couponInfoBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月12日 下午2:24:49
	 */
	public Integer countMyCoupon(CouponBean couponInfoBean)throws SQLException;
	
	/**
	 * 查询所有可用优惠券数量
	 * @Description:
	 * @param couponInfoBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月17日 下午4:22:46
	 */
	public Integer countCapitalCoupon(CouponBean couponInfoBean)throws SQLException;
	
	
	/**
	 * 活动注册送体验金
	 * @Description:
	 * @param accountInfo 注册用户
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月25日 上午9:30:31
	 */
	public Integer activityExperienceGold(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月22日 下午6:18:18
	 */
	public Integer activityCashCoupon(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 查询无限期优惠券数量（体验金，加息券，抵扣券）
	 * @Description:
	 * @param couponInfoBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年9月12日 下午4:07:20
	 */
	public Integer queryNoValidityCoupon(CouponBean couponInfoBean)throws SQLException;
	
	/**
	 * 查询用于融合优惠券
	 * @Description:
	 * @param couponBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年12月25日 下午6:21:29
	 */
	public List<CouponBean> queryFuseCouponList(CouponBean couponBean)throws Exception;
	
	
	public String fuseCoupon(String[] couponId,String couponType,HttpServletRequest request)throws Exception;
	
	public String iosFuseCoupon(String couponIds, String couponType, String accountId)throws Exception;
	
	/**
	 * 检查使用是否是注册优惠券
	 * @Description:
	 * @param accountId
	 * @param additionalId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月29日 上午11:12:06
	 */
	public String checkUserCoupon(String accountId, String additionalId)throws SQLException;
	
	/**
	 *  根据id查询用户拥有几张优惠券 
	 * @Description:
	 * @param couponBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年1月19日 下午5:07:42
	 */
	public Integer countIsOwnerById(CouponBean couponBean) throws SQLException;
}
