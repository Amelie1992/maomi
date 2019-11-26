/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.coupon.CouponMapper
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
package com.xed.financing.wxgzh.mapper.coupon;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.couponDetail.CouponDetail;
import com.xed.financing.wxgzh.model.couponInfo.CouponInfoBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.coupon.CouponMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月22日 下午4:23:31
 * @author:Qian Tao
 */
public interface CouponMapper
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
	 * 查看用户优惠券列表 除体验金
	 * @Description:
	 * @param couponBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月22日 下午4:24:14
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
	 * 标记优惠券已使用
	 * @Description:
	 * @param couponBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月11日 下午3:54:10
	 */
	public void updateCouponStatus(CouponBean couponBean) throws SQLException;
	
	/**
	 * 修改优惠券概述信息
	 * @Description: 数量
	 * @param couponInfoBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月3日 上午10:12:32
	 */
	public void updateCouponInfo(CouponInfoBean couponInfoBean) throws SQLException;
	
	/**
	 * 添加优惠券详情
	 * @Description:
	 * @param couponDetail
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月3日 上午10:12:36
	 */
	public void addCouponDetail(CouponDetail couponDetail) throws SQLException;
	
	/**
	 * 添加优惠券领取信息
	 * @Description:
	 * @param couponBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月3日 上午10:12:39
	 */
	public Integer addAdditional(CouponBean couponBean) throws SQLException;
	
	/**
	 * 查询优惠券概述信息
	 * @Description:
	 * @param couponId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月3日 上午10:29:57
	 */
	public CouponInfoBean selectCouponInfo(String couponId)throws SQLException;
	
	/**
	 * 按照投标金额确认加息券利率
	 * @Description:
	 * @param money
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月3日 下午4:35:55
	 */
	public String interestRateCoupon(Integer money)throws SQLException;

	/**
	 * 
	 * @Description:
	 * @param rate
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月3日 下午4:42:58
	 */
	public CouponInfoBean selectCouponInfoByRate()throws SQLException;
	
	/**
	 * 
	 * @Description:
	 * @param rate
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月3日 下午4:42:58
	 */
	public CouponInfoBean selectCouponInfoByParam(CouponInfoBean couponInfoBean)throws SQLException;
	
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
	public List<CouponBean> queryFuseCouponList(CouponBean couponBean)throws SQLException;

	
	/**
	 * 检查优惠券是否使用，类型一致
	 * @Description:
	 * @param map
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年12月27日 上午10:26:49
	 */
	public Integer checkCoupon(Map<Object,Object> map)throws SQLException;
	
	/**
	 * 查询用于融合的优惠券
	 * @Description:
	 * @param map
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年12月27日 上午11:48:37
	 */
	public List<CouponBean> getFuseCoupons(Map<Object,Object> map)throws SQLException;
	
	/**
	 * 融合优惠券，修改为已使用
	 * @Description:
	 * @param map
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年12月27日 下午3:21:40
	 */
	public Integer fuseCoupon(Map<Object,Object> map)throws SQLException;
	
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
	public String checkUserCoupon(@Param("accountId") String accountId, @Param("additionalId") String additionalId)throws SQLException;
	
	/**
	 * 添加优惠券详情
	 * @Description:
	 * @param couponDetail
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月3日 上午10:12:36
	 */
	public void addRegisterCoupom(CouponDetail couponDetail) throws SQLException;
	
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
	
	/**
	 * 查询用户未使用优惠券数量，按找类型查询
	 * @Description:
	 * @param couponBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年2月23日 上午10:42:08
	 */
	public Integer countNotUsedByType(CouponBean couponBean) throws SQLException;
	
	/**
	 * 查找一张未使用的优惠券，按照类型查询
	 * @Description:
	 * @param couponBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年2月23日 下午3:29:07
	 */
	public CouponBean selectNotUsedByType(CouponBean couponBean) throws SQLException;
}
