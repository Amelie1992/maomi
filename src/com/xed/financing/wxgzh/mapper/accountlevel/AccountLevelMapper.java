/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月22日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.accountlevel;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.couponDetail.CouponDetail;
import com.xed.financing.wxgzh.model.couponInfo.CouponInfoBean;

/**
 * 账户信息
 * 
 * @className:com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper
 * @description:
 * @version:v1.0.0
 * @date:2017年3月22日 下午3:40:40
 * @author:ZhangJun
 */
public interface AccountLevelMapper
{
	/**
	 * 
	 * @Description:查询上个月用户的签到次数
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月9日 下午5:43:32
	 */
	public List<AccountInfo> queryAccountLastMonthSigns()throws SQLException;
	
	/**
	 * 
	 * @Description:用户生日送现金券
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月10日 上午11:01:57
	 */
	public List<AccountInvest> accountBirthdayGiveCash()throws SQLException;
	
	/**
	 * 
	 * @Description:根据用户id查询用户等级信息
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月10日 下午3:23:07
	 */
	public AccountInfo queryAccountLevel(AccountInfo accountInfo)throws SQLException;
	
	/**
	 * 
	 * @Description:查询用户资金明细
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月10日 下午5:18:16
	 */
	public AccountCapital queryAccountCapital(AccountCapital accountCapital)throws SQLException;
	
	/**
	 * 
	 * @Description:修改用户等级
	 * @param accountInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月13日 上午9:42:58
	 */
	public void updateAccountVIP(AccountInfo accountInfo)throws SQLException;
	
	/**
	 * 
	 * @Description:月底查询v5以下的用户的投资金额
	 * @param accountCapital
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月13日 下午1:56:22
	 */
	public List<AccountCapital> queryAccountCapitalByLevel()throws SQLException;
	
	/**
	 * 
	 * @Description:月初刷新用户的补签次数
	 * @param map
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月14日 下午3:31:55
	 */
	public void updateRepairSignNumber(Map<Object,Object> map)throws SQLException;
	
	/**
	 * 
	 * @Description:月初刷新用户的特权提现次数
	 * @param map
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月14日 下午6:14:54
	 */
	public void updateWithdrawalsNumber(Map<Object,Object> map)throws SQLException;
	
	/**
	 * 
	 * @Description:查询accountId大于0的用户Id
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月15日 上午11:05:50
	 */
	public List<AccountInfo> queryAccountId()throws SQLException;
	
	/**
	 * 
	 * @Description:添加优惠券详情
	 * @param couponDetail
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月15日 下午3:04:33
	 */
	public void addCouponDetail(CouponDetail couponDetail) throws SQLException;
	
	/**
	 * 
	 * @Description:查询优惠券概述信息
	 * @param couponId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月15日 下午3:20:59
	 */
	public CouponInfoBean selectCouponInfo(String couponId)throws SQLException;
	
	/**
	 * 
	 * @Description:修改优惠券概述信息
	 * @param couponInfoBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月15日 下午3:23:20
	 */
	public void updateCouponInfo(CouponInfoBean couponInfoBean) throws SQLException;
	
	/**
	 * 
	 * @Description:添加优惠券领取信息
	 * @param couponBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月15日 下午4:51:06
	 */
	public void addAdditional(CouponBean couponBean) throws SQLException;
	
	/**
	 * 
	 * @Description:降级修改用户等级和等级状态
	 * @param accountInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月20日 下午3:49:11
	 */
	public void updateAccountLevelAndIsChange(AccountInfo accountInfo)throws SQLException;
	
	/**
	 * 修改卡券融合次数
	 * @Description:
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年12月28日 下午2:02:53
	 */
	public void updateFuseCouponNumber()throws SQLException;
	
	/**
	 * 修改免费提现次数
	 * @Description:
	 * @param map
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年2月5日 上午10:08:14
	 */
	public void updateFreeWithdrawalsNumber(Map<Object,Object> map)throws SQLException;
}
