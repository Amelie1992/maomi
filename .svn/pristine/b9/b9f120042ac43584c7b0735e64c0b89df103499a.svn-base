/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.coupon.impl.CouponServiceImpl
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
package com.xed.financing.wxgzh.service.coupon.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper;
import com.xed.financing.wxgzh.mapper.accountlevel.AccountLevelMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.coupon.CouponMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.couponDetail.CouponDetail;
import com.xed.financing.wxgzh.model.couponInfo.CouponInfoBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.GetUUID;
import com.xed.financing.wxgzh.util.LevelParam;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * @className:com.xed.financing.wxgzh.service.coupon.impl.CouponServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年3月22日 下午4:37:29
 * @author:Qian Tao
 */
@Service
public class CouponServiceImpl implements CouponService
{

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(CouponServiceImpl.class);

	@Resource
	private MessageMapper messageMapper;

	@Resource
	private AccountInfoMapper accountInfoMapper;

	@Resource
	private ParamMapper paramMapper;

	@Resource
	private CouponMapper couponMapper;
	
	@Resource
	public BondTransferMapper bondTransferMapper;
	
	@Resource
	public AccountLevelMapper accountLevelMapper;

	@Resource
	public AccountScoreMapper accountScoreMapper;
	
	@Override
	public List<CouponBean> queryCoupon(CouponBean couponBean) throws SQLException
	{
		return couponMapper.queryCoupon(couponBean);
	}

	@Override
	public CouponBean queryCouponById(CouponBean couponBean) throws SQLException
	{
		return couponMapper.queryCouponById(couponBean);
	}

	@Override
	@Transactional
	public Integer registeredExperienceGold(AccountInfo accountInfo)
	{
		try
		{
			String couponId = paramMapper.getParamVal(Constants.REGISTERED_EXPERIENCE_GOLD);

			// 新增优惠券
			CouponDetail couponDetail = new CouponDetail();
			couponDetail.setCouponId(couponId);
			couponDetail.setCouponCode(GetUUID.getUUID("TY"));
			couponDetail.setCouponMoney("88800");
			couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
			couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
			couponDetail.setValidityDays(paramMapper.getParamVal(Constants.EXPERIENCE_PERIOD));
			couponDetail.setInterestDays("30");
			couponDetail.setInterestType("0");
			couponDetail.setSubjectType("-1");
			couponMapper.addCouponDetail(couponDetail);

			// 修改优惠券概述的数量
			CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo(couponId);
			couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
			couponMapper.updateCouponInfo(couponInfoBean);

			// 发送消息
			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountInfo.getAccountId());
			outMessageBean.setMsgTitle("注册送体验金");
			outMessageBean.setMsgContent("注册成功," + (Integer.valueOf(couponDetail.getCouponMoney()) / 100.0)
					+ "元体验金已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
			messageMapper.addMessageInfo(outMessageBean);

			// 绑定体验金
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountInfo.getAccountId());
			couponBean.setCouDetailId(couponDetail.getCouDetailId());
			couponBean.setOutTime(paramMapper.getParamVal(Constants.EXPERIENCE_PERIOD));
			return couponMapper.addAdditional(couponBean);
		}
		catch (Exception e)
		{
			logger.error("注册送体验金异常");
			throw new RuntimeException();
		}

	}
	
	@Override
	@Transactional
	public Integer registeredCashCoupon(AccountInfo accountInfo)
	{
		try
		{
			String couponId = paramMapper.getParamVal(Constants.REGISTER_COUPON_ID);
			String money = paramMapper.getParamVal(Constants.ACTIVITY_SEND_MONEY);

			// 新增优惠券
			CouponDetail couponDetail = new CouponDetail();
			couponDetail.setCouponId(couponId);
			couponDetail.setCouponCode(GetUUID.getUUID("ZCXJJ"));
			couponDetail.setCouponMoney(money);
			couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
			couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
			couponDetail.setValidityDays(Constants.DEVIL_NUM_ZONE);
			couponDetail.setInterestDays("-1");
			couponDetail.setInterestType("-1");
			couponDetail.setSubjectType("-2");
			couponDetail.setStartMoney("-100");
			couponMapper.addRegisterCoupom(couponDetail);

			// 修改优惠券概述的数量
			CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo(couponId);
			couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
			couponMapper.updateCouponInfo(couponInfoBean);

			// 发送消息
			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountInfo.getAccountId());
			outMessageBean.setMsgTitle("邀请码注册送" + Double.parseDouble(money)/100.0 + "元现金券");
			outMessageBean.setMsgContent("注册成功," + (Integer.valueOf(couponDetail.getCouponMoney()) / 100.0)
					+ "元现金券已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
			messageMapper.addMessageInfo(outMessageBean);

			// 绑定体验金
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountInfo.getAccountId());
			couponBean.setCouDetailId(couponDetail.getCouDetailId());
			couponBean.setOutTime(paramMapper.getParamVal(Constants.EXPERIENCE_PERIOD));
			return couponMapper.addAdditional(couponBean);
		}
		catch (Exception e)
		{
			logger.error("注册送2元现金劵异常");
			throw new RuntimeException();
		}

	}

	@Override
	@Transactional
	public Integer inviteersReward(AccountInfo accountInfo, String money)
	{

		// 获得邀请人信息
		AccountInfo inviteAccount = null;
		// 查询出加息券利率档次
		String rate = null;
		try
		{

			inviteAccount = accountInfoMapper.getAccountInfoByPhone(accountInfo.getRecommendTelephone());
			rate = couponMapper.interestRateCoupon(Integer.valueOf(money));
			// 根据利率查询出加息券概述，修改加息券概述数量
			CouponInfoBean couponInfoBean = couponMapper.selectCouponInfoByRate();
			couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
			couponMapper.updateCouponInfo(couponInfoBean);

			// 添加加息券详情
			CouponDetail couponDetail = new CouponDetail();
			couponDetail.setCouponId(couponInfoBean.getCouponId());
			couponDetail.setCouponCode(GetUUID.getUUID("IF"));
			couponDetail.setCouponMoney(rate);
			couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
			couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
			couponDetail.setValidityDays("180");
			couponDetail.setInterestDays("-1");
			couponDetail.setInterestType("-1");
			couponDetail.setSubjectType("-1");
			couponMapper.addCouponDetail(couponDetail);

			// 发送消息
			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(inviteAccount.getAccountId());
			outMessageBean.setMsgTitle("邀请好友投标成功");
			outMessageBean.setMsgContent("您邀请的好友投标成功,加息券已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
			messageMapper.addMessageInfo(outMessageBean);

			// 绑定加息券
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(inviteAccount.getAccountId());
			couponBean.setCouDetailId(couponDetail.getCouDetailId());
			couponBean.setOutTime("180");
			return couponMapper.addAdditional(couponBean);
		}
		catch (Exception e)
		{
			logger.error("邀请好友投标成功，送加息券异常");
			throw new RuntimeException();
		}

	}

	@Override
	public List<CouponBean> queryCoupons(CouponBean couponBean) throws SQLException
	{
		return couponMapper.queryCoupons(couponBean);
	}

	/**
	 * 使用现金券
	 */
	@Override
	@Transactional
	public Boolean useCashCoupons(String additionalId, AccountInfo accountInfo) throws RuntimeException
	{
		Boolean falg = false;
		try
		{
			// ------------获得信息---------------------------
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountInfo.getAccountId());
			couponBean.setAdditionalId(additionalId);
			CouponBean coupon =  couponMapper.queryCouponById(couponBean);
			String couponMoney = coupon.getCouponMoney();
			
			//--------------修改用户资金------------------------
			AccountCapital accountCapital = bondTransferMapper.getBalances(accountInfo.getAccountId());
			Double withdrawMoney = Double.parseDouble(accountCapital.getWithdrawMoney()) + Integer.parseInt(couponMoney);
			accountCapital.setWithdrawMoney(String.valueOf(withdrawMoney));
			bondTransferMapper.changeFunds(accountCapital);
			
			//-------------------修改现金券状态------------------------------
			coupon.setSubjectId("");
			couponMapper.updateCouponStatus(coupon);
			
			//------------------------添加资金明细-----------------------------
			CapitalDetail outInvestMent = new CapitalDetail();
			outInvestMent.setAccountId(accountInfo.getAccountId());
			outInvestMent.setMoney(couponMoney);
			outInvestMent.setType(Constants.DEVIL_NUM_TEN);
			outInvestMent.setInExpend(Constants.DEVIL_NUM_ZERO);
			outInvestMent.setRemark("现金券使用成功：资金添加"+(Double.parseDouble(couponMoney)/100));
			bondTransferMapper.addCapital(outInvestMent);
			//-----------------------添加消息--------------------------------
			MessageBean outMessageBean =new MessageBean();
			outMessageBean.setAccountId(accountInfo.getAccountId());
			outMessageBean.setMsgTitle("现金券使用成功");
			outMessageBean.setMsgContent("您的现金券使用成功,"+(Double.parseDouble(couponMoney)/100)+"元已充值至您的账户");
			messageMapper.addMessageInfo(outMessageBean);
			falg = true;
		}
		catch (Exception e)
		{
			logger.error("使用现金券成功");
			throw new RuntimeException();
		}

		return falg;
	}

	@Override
	public Integer countNewMyCoupon(CouponBean couponInfoBean) throws SQLException
	{
		return couponMapper.countNewMyCoupon(couponInfoBean);
	}

	@Override
	public Integer countMyCoupon(CouponBean couponInfoBean) throws SQLException
	{
		return couponMapper.countMyCoupon(couponInfoBean);
	}

	@Override
	public Integer countCapitalCoupon(CouponBean couponInfoBean) throws SQLException
	{
		return couponMapper.countCapitalCoupon(couponInfoBean);
	}

	@Override
	@Transactional
	public Integer activityExperienceGold(AccountInfo accountInfo) throws SQLException
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String nowDate = sdf.format(date);
			
			if(!DateUtils.compareDateLong("2017-08-06 23:59:59", nowDate)){
				return 0;
			}
			String couponId = paramMapper.getParamVal(Constants.ACTIVITY_EXPERIENCE_GOLD);

			// 新增优惠券
			CouponDetail couponDetail = new CouponDetail();
			couponDetail.setCouponId(couponId);
			couponDetail.setCouponCode(GetUUID.getUUID("HD"));
			couponDetail.setCouponMoney("300000");
			couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
			couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
			couponDetail.setValidityDays("0");
			couponDetail.setInterestDays("1");
			couponDetail.setInterestType("1");
			couponDetail.setSubjectType("-1");
			couponMapper.addCouponDetail(couponDetail);

			// 修改优惠券概述的数量
			CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo(couponId);
			couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
			couponMapper.updateCouponInfo(couponInfoBean);

			// 发送消息
			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountInfo.getAccountId());
			outMessageBean.setMsgTitle("三伏天活动");
			outMessageBean.setMsgContent("注册成功,三伏天发高温费啦！" + (Integer.valueOf(couponDetail.getCouponMoney()) / 100.0)
					+ "元体验金已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
			messageMapper.addMessageInfo(outMessageBean);

			// 绑定体验金
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountInfo.getAccountId());
			couponBean.setCouDetailId(couponDetail.getCouDetailId());
			couponBean.setOutTime("-2");
			return couponMapper.addAdditional(couponBean);
		}
		catch (Exception e)
		{
			logger.error("注册送体验金异常");
			throw new RuntimeException();
		}
	}

	@Override
	@Transactional
	public Integer activityCashCoupon(AccountInfo accountInfo) throws SQLException
	{
		try
		{
			/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String nowDate = sdf.format(date);
			
			if(!DateUtils.compareDateLong("2017-08-06 23:59:59", nowDate)){
				return 0;
			}*/
			String couponId = paramMapper.getParamVal(Constants.ACTIVITY_CASHCOUPON);

			// 新增优惠券
			CouponDetail couponDetail = new CouponDetail();
			couponDetail.setCouponId(couponId);
			couponDetail.setCouponCode(GetUUID.getUUID("HD"));
			couponDetail.setCouponMoney("2800");
			couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
			couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
			couponDetail.setValidityDays("30");
			couponDetail.setInterestDays("1");
			couponDetail.setInterestType("1");
			couponDetail.setSubjectType("-1");
			couponMapper.addCouponDetail(couponDetail);

			// 修改优惠券概述的数量
			CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo(couponId);
			couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
			couponMapper.updateCouponInfo(couponInfoBean);

			// 发送消息
			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountInfo.getAccountId());
			outMessageBean.setMsgTitle("国庆集字活动");
			outMessageBean.setMsgContent("恭喜集字成功！" + (Integer.valueOf(couponDetail.getCouponMoney()) / 100.0)
					+ "元现金券已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
			messageMapper.addMessageInfo(outMessageBean);

			// 绑定体验金
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountInfo.getAccountId());
			couponBean.setCouDetailId(couponDetail.getCouDetailId());
			couponBean.setOutTime("30");
			return couponMapper.addAdditional(couponBean);
		}
		catch (Exception e)
		{
			logger.error("国庆集字兑换异常");
			throw new RuntimeException();
		}
	}

	@Override
	public Integer queryNoValidityCoupon(CouponBean couponInfoBean) throws SQLException
	{
		return couponMapper.queryNoValidityCoupon(couponInfoBean);
	}

	@Override
	public List<CouponBean> queryFuseCouponList(CouponBean couponBean) throws Exception
	{
		return couponMapper.queryFuseCouponList(couponBean);
	}

	@Override
	@Transactional
	public String fuseCoupon(String[] couponId, String couponType, HttpServletRequest request) throws Exception
	{
		String result = "success";
		try
		{
			AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("account");
			AccountInfo account = accountLevelMapper.queryAccountLevel(accountInfo);
			
			
			//检查融合次数
			if(Integer.parseInt(account.getFuseCouponNumber())==0){
				result = "notEnoughNumber";
			}else
			//检查融合个数
			if(couponId.length<5 || couponId.length>10){
				result = "notEnoughCount";
			}else
			//检查鱼干
			if(Integer.parseInt(account.getAccountScore())<LevelParam.FUSE_COUPON_USE_SCORE){
				result = "notEnoughScore";
			}
			//检查拥有,未使用,类型一致
			else{
				//增值券0,加息券1
				Map<Object, Object> map=new HashMap<Object,Object>();
				map.put("couponType", couponType);
				map.put("couponId", couponId);
				map.put("accountId", accountInfo.getAccountId());
				Integer count = couponMapper.checkCoupon(map);
				if(count!=couponId.length){
					result = "notAgree";
				}else{
					//融合
					List<CouponBean> counpons = couponMapper.getFuseCoupons(map);
						//计算总额
					String money = "0";
						
					for (int i = 0; i < counpons.size(); i++)
					{
						money = MoneyUtils.formatFloatNumber(Double.parseDouble(money)+Double.parseDouble(counpons.get(i).getCouponMoney()));
					}
					money = MoneyUtils.formatFloatNumber(Double.parseDouble(money) * 0.9);
					if("0".equals(couponType) && Double.parseDouble(money)>=100000){
						money = "100000";
					}else
					if("1".equals(couponType) && Double.parseDouble(money)>=2){
						money = "2";
					}else if("0".equals(couponType)){
						money = money.substring(0, money.indexOf("."));
					}
					String coupon ="";
						//发放优惠券
					if("0".equals(couponType)){
						coupon =paramMapper.getParamVal(Constants.FUSE_COUPON_ID_ZZQ);
					}else{
						coupon =paramMapper.getParamVal(Constants.FUSE_COUPON_ID_JXQ);
					}
					 

					// 新增优惠券
					CouponDetail couponDetail = new CouponDetail();
					couponDetail.setCouponId(coupon);
					couponDetail.setCouponCode(GetUUID.getUUID("RH"));
					couponDetail.setCouponMoney(money);
					couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
					couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
					couponDetail.setValidityDays("30");
					couponDetail.setInterestDays("1");
					couponDetail.setInterestType("1");
					couponDetail.setSubjectType("-1");
					couponMapper.addCouponDetail(couponDetail);

					// 修改优惠券概述的数量
					CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo(coupon);
					couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
					couponMapper.updateCouponInfo(couponInfoBean);

					// 发送消息
					MessageBean outMessageBean = new MessageBean();
					outMessageBean.setAccountId(accountInfo.getAccountId());
					outMessageBean.setMsgTitle("优惠券融合成功");
					if("0".equals(couponType)){
						outMessageBean.setMsgContent("优惠券融合成功!" + (Integer.valueOf(couponDetail.getCouponMoney()) / 100.0)
								+ "元增值券已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
					}else{
						outMessageBean.setMsgContent("优惠券融合成功!" + couponDetail.getCouponMoney()
								+ "%加息券已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
					}
					
					messageMapper.addMessageInfo(outMessageBean);

					// 绑定优惠券
					CouponBean couponBean = new CouponBean();
					couponBean.setAccountId(accountInfo.getAccountId());
					couponBean.setCouDetailId(couponDetail.getCouDetailId());
					couponBean.setOutTime("30");
					couponMapper.addAdditional(couponBean);
						//融合优惠券
					couponMapper.fuseCoupon(map);
						//减次数
					account.setFuseCouponNumber(String.valueOf(Integer.parseInt(account.getFuseCouponNumber())-1));
					accountLevelMapper.updateAccountVIP(account);
						//减鱼干
					account.setAccountScore(String.valueOf(Integer.parseInt(account.getAccountScore())-LevelParam.FUSE_COUPON_USE_SCORE));
					accountScoreMapper.changeScoreAndExp(account);
					
					// 创建鱼干明细
					AccountScoreBean accountScoreBean = new AccountScoreBean();
					accountScoreBean.setAccountId(accountInfo.getAccountId());
					accountScoreBean.setInExpend(Constants.DEVIL_NUM_ONE);
					accountScoreBean.setScoreType("11");
					accountScoreBean.setModReason("优惠券融合,扣除"+LevelParam.FUSE_COUPON_USE_SCORE+"鱼干");
							
					// 鱼干明细输入鱼干数量
					accountScoreBean.setScore(String.valueOf(LevelParam.FUSE_COUPON_USE_SCORE));
					// 添加用户鱼干明细
					accountScoreMapper.addAccountScoreInfo(accountScoreBean);
					
				}
				
			}
			
		}
		catch (Exception e)
		{
			logger.error("优惠券融合异常");
			throw new RuntimeException();
		}
		return result;
	}
	
	
	@Override
	@Transactional
	public String iosFuseCoupon(String couponIds, String couponType, String accountId) throws Exception
	{
		String[] couponId = couponIds.split(",");
		String result = "200";
		try
		{
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setAccountId(accountId);
			AccountInfo account = accountLevelMapper.queryAccountLevel(accountInfo);
			
			
			//检查融合次数
			if(Integer.parseInt(account.getFuseCouponNumber())==0){
				//可融合次数不足
				result = "301";
			}else
			//检查融合个数
			if(couponId.length<5 || couponId.length>10){
				//优惠券个数不正确
				result = "302";
			}else
			//检查鱼干
			if(Integer.parseInt(account.getAccountScore())<LevelParam.FUSE_COUPON_USE_SCORE){
				//鱼干数量不足
				result = "303";
			}
			//检查拥有,未使用,类型一致
			else{
				//增值券0,加息券1
				Map<Object, Object> map=new HashMap<Object,Object>();
				map.put("couponType", couponType);
				map.put("couponId", couponId);
				map.put("accountId", accountInfo.getAccountId());
				Integer count = couponMapper.checkCoupon(map);
				if(count!=couponId.length){
					//有已使用或已过期的优惠券!
					result = "304";
				}else{
					//融合
					List<CouponBean> counpons = couponMapper.getFuseCoupons(map);
						//计算总额
					String money = "0";
						
					for (int i = 0; i < counpons.size(); i++)
					{
						money = MoneyUtils.formatFloatNumber(Double.parseDouble(money)+Double.parseDouble(counpons.get(i).getCouponMoney()));
					}
					money = MoneyUtils.formatFloatNumber(Double.parseDouble(money) * 0.9);
					if("0".equals(couponType) && Double.parseDouble(money)>=100000){
						money = "100000";
					}else
					if("1".equals(couponType) && Double.parseDouble(money)>=2){
						money = "2";
					}else if("0".equals(couponType)){
						money = money.substring(0, money.indexOf("."));
					}
					String coupon ="";
						//发放优惠券
					if("0".equals(couponType)){
						coupon =paramMapper.getParamVal(Constants.FUSE_COUPON_ID_ZZQ);
					}else{
						coupon =paramMapper.getParamVal(Constants.FUSE_COUPON_ID_JXQ);
					}
					 

					// 新增优惠券
					CouponDetail couponDetail = new CouponDetail();
					couponDetail.setCouponId(coupon);
					couponDetail.setCouponCode(GetUUID.getUUID("RH"));
					couponDetail.setCouponMoney(money);
					couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
					couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
					couponDetail.setValidityDays("30");
					couponDetail.setInterestDays("1");
					couponDetail.setInterestType("1");
					couponDetail.setSubjectType("-1");
					couponMapper.addCouponDetail(couponDetail);

					// 修改优惠券概述的数量
					CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo(coupon);
					couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
					couponMapper.updateCouponInfo(couponInfoBean);

					// 发送消息
					MessageBean outMessageBean = new MessageBean();
					outMessageBean.setAccountId(accountInfo.getAccountId());
					outMessageBean.setMsgTitle("优惠券融合成功");
					if("0".equals(couponType)){
						outMessageBean.setMsgContent("优惠券融合成功!" + (Integer.valueOf(couponDetail.getCouponMoney()) / 100.0)
								+ "元增值券已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
					}else{
						outMessageBean.setMsgContent("优惠券融合成功!" + couponDetail.getCouponMoney()
								+ "%加息券已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
					}
					
					messageMapper.addMessageInfo(outMessageBean);

					// 绑定优惠券
					CouponBean couponBean = new CouponBean();
					couponBean.setAccountId(accountInfo.getAccountId());
					couponBean.setCouDetailId(couponDetail.getCouDetailId());
					couponBean.setOutTime("30");
					couponMapper.addAdditional(couponBean);
						//融合优惠券
					couponMapper.fuseCoupon(map);
						//减次数
					account.setFuseCouponNumber(String.valueOf(Integer.parseInt(account.getFuseCouponNumber())-1));
					accountLevelMapper.updateAccountVIP(account);
						//减鱼干
					account.setAccountScore(String.valueOf(Integer.parseInt(account.getAccountScore())-LevelParam.FUSE_COUPON_USE_SCORE));
					accountScoreMapper.changeScoreAndExp(account);
					
					// 创建鱼干明细
					AccountScoreBean accountScoreBean = new AccountScoreBean();
					accountScoreBean.setAccountId(accountInfo.getAccountId());
					accountScoreBean.setInExpend(Constants.DEVIL_NUM_ONE);
					accountScoreBean.setScoreType("11");
					accountScoreBean.setModReason("优惠券融合,扣除"+LevelParam.FUSE_COUPON_USE_SCORE+"鱼干");
							
					// 鱼干明细输入鱼干数量
					accountScoreBean.setScore(String.valueOf(LevelParam.FUSE_COUPON_USE_SCORE));
					// 添加用户鱼干明细
					accountScoreMapper.addAccountScoreInfo(accountScoreBean);
					
				}
				
			}
			
		}
		catch (Exception e)
		{
			logger.error("优惠券融合异常");
			throw new RuntimeException();
		}
		return result;
	}

	@Override
	public String checkUserCoupon(String accountId, String additionalId) throws SQLException
	{
		return couponMapper.checkUserCoupon(accountId, additionalId);
	}

	@Override
	public Integer countIsOwnerById(CouponBean couponBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return couponMapper.countIsOwnerById(couponBean);
	}
	
}
