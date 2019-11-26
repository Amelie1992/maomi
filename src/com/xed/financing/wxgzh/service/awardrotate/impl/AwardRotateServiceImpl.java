/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.bondtransfer.impl.BondTransferServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月17日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.awardrotate.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.coupon.CouponMapper;
import com.xed.financing.wxgzh.mapper.draw.DrawMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.couponDetail.CouponDetail;
import com.xed.financing.wxgzh.model.couponInfo.CouponInfoBean;
import com.xed.financing.wxgzh.model.draw.DrawBean;
import com.xed.financing.wxgzh.model.draw.DrawPrizeBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.awardrotate.AwardRotateService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DrawParam;
import com.xed.financing.wxgzh.util.GetUUID;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * @className:com.xed.financing.wxgzh.service.bondtransfer.impl.BondTransferServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年3月17日 下午3:47:47
 * @author:ZhangJun
 */
@Service
public class AwardRotateServiceImpl implements AwardRotateService
{

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AwardRotateServiceImpl.class);

	@Resource
	public BondTransferMapper mapper;

	@Resource
	private MessageMapper messageMapper;

	@Resource
	private AccountInfoMapper accountInfoMapper;

	@Resource
	private AccountScoreMapper accountScoreMapper;

	@Resource
	private CouponMapper couponMapper;

	@Resource
	private DrawMapper drawMapper;

	@Resource
	private ParamMapper paramMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xed.financing.wxgzh.service.awardrotate.AwardRotateService#getAccountInfo
	 * (com.xed.financing.wxgzh.model.accountinfo.AccountInfo)
	 */
	@Override
	public AccountInfo getAccountScore(String accountId) throws Exception
	{
		// TODO Auto-generated method stub
		return accountInfoMapper.getLoginAccountInfo(accountId);
	}
	

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.awardrotate.AwardRotateService#useAccountScore(com.xed.financing.wxgzh.model.accountinfo.AccountInfo, com.xed.financing.wxgzh.model.accountscore.AccountScoreBean, com.xed.financing.wxgzh.model.accountscore.AccountScoreBean)
	 */
	@Override
	public String useAccountScore(AccountInfo accountInfo,
			AccountScoreBean accountScoreBean) throws Exception
	{
		// TODO Auto-generated method stub
		
		// 扣除抽奖鱼干添加鱼干变更明细
		accountScoreMapper.addAccountScoreInfo(accountScoreBean);
		
		// 扣除用户现有鱼干
		accountScoreMapper.changeScoreAndExp(accountInfo);
		
		return accountInfo.getAccountScore();
	}
	
	/*
	 * (non-Javadoc) 获奖奖品为新手专享标投标机会
	 * 
	 * @see com.xed.financing.wxgzh.service.awardrotate.AwardRotateService#
	 * updateAccountScore(com.xed.financing.wxgzh.model.accountinfo.AccountInfo)
	 */
	@Override
	@Transactional
	public double updateAccountNewSubjectCount(Integer reward, AccountInfo accountInfo) throws Exception
	{
		// TODO Auto-generated method stub
		try
		{

			//更新用户新手专享标再投机会
			accountInfo.setNewSubjectCount(String.valueOf(Integer.parseInt(accountInfo.getNewSubjectCount()) + 1));
			accountInfoMapper.bindInfo(accountInfo);

			// 记录获奖信息
			DrawBean drawBean = new DrawBean();
			drawBean.setAccountId(accountInfo.getAccountId());
			drawBean.setDrawRank(DrawParam.DRAW_CONTENT[reward]);
			drawBean.setDrawContent(DrawParam.DRAW_CONTENT[reward]); 
			drawMapper.addDraw(drawBean);

			// 发送消息
			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountInfo.getAccountId());
			outMessageBean.setMsgTitle("用户抽奖奖励发放成功");
			outMessageBean.setMsgContent("用户抽奖奖励(新手专享标再投一次机会)已发放,您现在可以多一次投资新手专享标的机会。");
			messageMapper.addMessageInfo(outMessageBean);

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			logger.error("更新新手专享标再投机会异常");
			throw new RuntimeException();
		}
		return 1;
	}

	/*
	 * (non-Javadoc) 获奖奖品为鱼干时奖励
	 * 
	 * @see com.xed.financing.wxgzh.service.awardrotate.AwardRotateService#
	 * updateAccountScore(com.xed.financing.wxgzh.model.accountinfo.AccountInfo)
	 */
	@Override
	@Transactional
	public double updateAccountScore(Integer reward, AccountInfo accountInfo, AccountScoreBean accountScoreInfo,String flag) throws Exception
	{
		// TODO Auto-generated method stub
		String score;
		double money;
		try
		{
			money = getCouponMoney(reward);
			score = String.valueOf((int)money);
			
			accountScoreInfo.setScore(score);
			if(flag.equals(Constants.AWARD_ROTATE_VALUE))
			{
				accountScoreInfo.setModReason("鱼干抽奖获得鱼干奖励:" + score + "鱼干");
			}
			else if(flag.equals(Constants.RED_PACKAGE_VALUE))
			{
				accountScoreInfo.setModReason("2017跨年红包获得鱼干奖励:" + score + "鱼干");
			}
			
			
			accountInfo.setAccountScore(String.valueOf(Integer.parseInt(accountInfo.getAccountScore()) + Integer.parseInt(score)));

			// 奖励新增鱼干明细
			accountScoreMapper.addAccountScoreInfo(accountScoreInfo);
			
			// 更新用户剩余鱼干
			accountScoreMapper.changeScoreAndExp(accountInfo);

			// 记录获奖信息
			DrawBean drawBean = new DrawBean();
			drawBean.setAccountId(accountInfo.getAccountId());
			drawBean.setDrawRank(DrawParam.DRAW_CONTENT[reward]);
			drawBean.setDrawContent(DrawParam.DRAW_CONTENT[reward] + ":" + score);
			drawMapper.addDraw(drawBean);

			// 发送消息
			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountInfo.getAccountId());
			if(flag.equals(Constants.AWARD_ROTATE_VALUE))
			{
				outMessageBean.setMsgTitle("用户抽奖奖励发放成功");
				outMessageBean.setMsgContent("用户抽奖奖励(" + DrawParam.DRAW_CONTENT[reward] + ":" + score + ")已到账,请至<a href='javascript:void(0)' onclick='goDetails(4)'>鱼干中心</a>查看。");
			}
			else if(flag.equals(Constants.RED_PACKAGE_VALUE))
			{
				outMessageBean.setMsgTitle("2017跨年红包奖励");
				outMessageBean.setMsgContent("2017跨年红包奖励(" + DrawParam.DRAW_CONTENT[reward] + ":" + score + ")已到账,请至<a href='javascript:void(0)' onclick='goDetails(4)'>鱼干中心</a>查看。");
			}
		
			messageMapper.addMessageInfo(outMessageBean);

		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			logger.error("更新鱼干记录异常");
			throw new RuntimeException();
		}
		return money;
	}

	/*
	 * (non-Javadoc) 获奖奖品为优惠券时奖励
	 * 
	 * @see
	 * com.xed.financing.wxgzh.service.awardrotate.AwardRotateService#grantRewards
	 * (java.lang.Integer,
	 * com.xed.financing.wxgzh.model.accountinfo.AccountInfo)
	 */
	@Override
	@Transactional
	public double grantRewards(Integer reward, AccountInfo accountInfo,String flag)
	{
		// TODO Auto-generated method stub
		String couponId = "CIScoreDrawPrizes0" + reward;
		String couponMoney = "";
		String drawContent = "";
		double money = getCouponMoney(reward);
		try
		{
			//加息券无需换算成分
			if(reward != 6){
				couponMoney = MoneyUtils.changeDYToDF(money);
			}else{
				couponMoney = String.valueOf(money);
			}
			
			CouponInfoBean couponInfoBean = new CouponInfoBean();
			couponInfoBean.setCouponId(couponId);

			// 根据利率查询出加息券概述，修改优惠券概述数量
			couponInfoBean = couponMapper.selectCouponInfoByParam(couponInfoBean);
			couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
			couponMapper.updateCouponInfo(couponInfoBean);

			// 添加优惠券详情
			CouponDetail couponDetail = new CouponDetail();
			couponDetail.setCouponId(couponInfoBean.getCouponId());
			couponDetail.setCouponCode(GetUUID.getUUID("AR"));
			couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
			couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
			couponDetail.setCouponMoney(couponMoney);
			if(reward == 1){
				couponDetail.setValidityDays(DrawParam.DRAW_COUPON_VALIDITY_CASH);
			}else{
				couponDetail.setValidityDays(DrawParam.DRAW_COUPON_VALIDITY);
			}
			couponDetail.setInterestDays("-1");
			couponDetail.setInterestType("-1");
			couponDetail.setSubjectType("-1");
			couponMapper.addCouponDetail(couponDetail);

			// 绑定优惠券
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountInfo.getAccountId());
			couponBean.setCouDetailId(couponDetail.getCouDetailId());
			if(reward == 1)
			{
				couponBean.setOutTime(DrawParam.DRAW_COUPON_VALIDITY_CASH);
			}else{
				
				couponBean.setOutTime(DrawParam.DRAW_COUPON_VALIDITY);
			}
			couponMapper.addAdditional(couponBean);

			// 记录获奖信息
			DrawBean drawBean = new DrawBean();
			drawBean.setAccountId(accountInfo.getAccountId());
			drawBean.setDrawRank(DrawParam.DRAW_CONTENT[reward]);
			
			if(reward == 1){
				drawContent = DrawParam.DRAW_CONTENT[reward];
			}else if(reward == 2 || reward == 4){
				drawContent = DrawParam.DRAW_CONTENT[reward] + ":" + money + "元";
			}else if(reward == 6){
				drawContent = DrawParam.DRAW_CONTENT[reward] + ":" + money + "%";
			}
			drawBean.setDrawContent(drawContent);
			drawMapper.addDraw(drawBean);

			// 发送消息
			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountInfo.getAccountId());
			if(flag.equals(Constants.AWARD_ROTATE_VALUE))
			{
				outMessageBean.setMsgTitle("用户抽奖奖励发放成功");
				outMessageBean.setMsgContent("用户抽奖奖励("+ drawContent +")发放成功,奖励已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
			}
			else if(flag.equals(Constants.RED_PACKAGE_VALUE))
			{
				outMessageBean.setMsgTitle("2017跨年红包奖励");
				outMessageBean.setMsgContent("2017跨年红包奖励("+ drawContent +")发放成功,奖励已到账，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
			}
			
			messageMapper.addMessageInfo(outMessageBean);
		}
		catch (Exception e)
		{
			logger.error("鱼干抽奖获取优惠券异常");
			throw new RuntimeException();
		}
		return money;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xed.financing.wxgzh.service.awardrotate.AwardRotateService#addScoreRecord
	 * (com.xed.financing.wxgzh.model.accountscore.AccountScoreBean)
	 */
	@Override
	public void addScoreRecord(AccountScoreBean accountScoreBean) throws Exception
	{
		// TODO Auto-generated method stub
		accountScoreMapper.addAccountScoreInfo(accountScoreBean);
	}

	// 返回奖项内容
	private Double getCouponMoney(Integer reward)
	{
		double item = Math.floor(Math.random() * 10000);
		Map<Integer, DrawPrizeBean> DRAW_PRIZE = new HashMap<Integer, DrawPrizeBean>();
		if(reward == 2){
			DRAW_PRIZE = DrawParam.DRAW_PRIZE_2;
		}else if(reward == 4){
			DRAW_PRIZE = DrawParam.DRAW_PRIZE_4;
		}else if(reward == 5){
			DRAW_PRIZE = DrawParam.DRAW_PRIZE_5;
		}else if(reward == 6){
			DRAW_PRIZE = DrawParam.DRAW_PRIZE_6;
		}
		
		// 随机数计算金额
		switch (reward)
		{
		case 1:
			item = 0;
			break;
		case 2:
		case 4:
		case 5:
		case 6:
			double prize1 = DRAW_PRIZE.get(1).getDrawProb() * 10000 / 100;
			double prize2 = prize1 + DRAW_PRIZE.get(2).getDrawProb() * 10000 / 100;
			double prize3 = prize2 + DRAW_PRIZE.get(3).getDrawProb() * 10000 / 100;
			double prize4 = prize3 + DRAW_PRIZE.get(4).getDrawProb() * 10000 / 100;
			double prize5 = prize4 + DRAW_PRIZE.get(5).getDrawProb() * 10000 / 100;
			double prize6 = prize5 + DRAW_PRIZE.get(6).getDrawProb() * 10000 / 100;
			double prize7 = prize6 + DRAW_PRIZE.get(7).getDrawProb() * 10000 / 100;
			double prize8 = prize7 + DRAW_PRIZE.get(8).getDrawProb() * 10000 / 100;
			double prize9 = prize8 + DRAW_PRIZE.get(9).getDrawProb() * 10000 / 100;
			System.out.println("奖品随机数-->" + item);
			if (item >= 0 && item <= prize1)
			{
				item = DRAW_PRIZE.get(1).getDrawMoney();
			}
			else if (item >= (prize1 + 1) && item <= prize2)
			{
				item = DRAW_PRIZE.get(2).getDrawMoney();
			}
			else if (item >= (prize2 + 1) && item <= prize3)
			{
				item = DRAW_PRIZE.get(3).getDrawMoney();
			}
			else if (item >= (prize3 + 1) && item <= prize4)
			{
				item = DRAW_PRIZE.get(4).getDrawMoney();
			}
			else if (item >= (prize4 + 1) && item <= prize5)
			{
				item = DRAW_PRIZE.get(5).getDrawMoney();
			}
			else if (item >= (prize5 + 1) && item <= prize6)
			{
				item = DRAW_PRIZE.get(6).getDrawMoney();
			}
			else if (item >= (prize6 + 1) && item <= prize7)
			{
				item = DRAW_PRIZE.get(7).getDrawMoney();
			}
			else if (item >= (prize7 + 1) && item <= prize8)
			{
				item = DRAW_PRIZE.get(8).getDrawMoney();
			}
			else if (item >= (prize8 + 1) && item <= prize9)
			{
				item = DRAW_PRIZE.get(9).getDrawMoney();
			}
			else
			{
				item = DRAW_PRIZE.get(10).getDrawMoney();
			}
			break;
		}
		System.out.println("奖品随机金额-->" + item);
		return item;
	}

}
