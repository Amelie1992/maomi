/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.sendcash.impl.SendCashCouponServiceImpl
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
package com.xed.financing.wxgzh.service.sendcash.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper;
import com.xed.financing.wxgzh.mapper.accountaddress.AccountAddressMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.capitaldetail.CapitaldetailMapper;
import com.xed.financing.wxgzh.mapper.coupon.CouponMapper;
import com.xed.financing.wxgzh.mapper.loginregister.LoginRegisterMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.mapper.subject.SubjectMapper;
import com.xed.financing.wxgzh.model.accountaddress.AccountAddressBean;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.couponDetail.CouponDetail;
import com.xed.financing.wxgzh.model.couponInfo.CouponInfoBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.sendcash.SendCashCouponService;
import com.xed.financing.wxgzh.service.subject.impl.SubjectServiceImpl;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.GetUUID;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;
import com.xed.financing.wxgzh.util.SubjectActivityParam;

/**
 * 
 * 发送随机现金券
 * 
 * @className:com.xed.financing.wxgzh.service.sendcash.impl.SendCashCouponServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年9月21日 下午3:46:58
 * @author:QT
 */
@Service
public class SendCashCouponServiceImpl implements SendCashCouponService
{
	@Resource
	private CapitalMapper capitalMapper;

	@Resource
	private CapitaldetailMapper capitalDetailMapper;

	@Resource
	private SubjectMapper subjectMapper;

	@Resource
	private ParamMapper paramMapper;

	@Resource
	private CouponMapper couponMapper;

	/**
	 * 消息mapper
	 */
	@Resource
	private MessageMapper messageMapper;

	@Resource
	private AccountInfoMapper accountInfoMapper;

	@Resource
	private AccountAddressMapper accountAddressMapper;

	/**
	 * 转让mapper
	 */
	@Resource
	private BondTransferMapper bondTransferMapper;
	
	/**
	 * 积分mapper
	 */
	@Resource
	private AccountScoreMapper accountScoreMapper;
	
	@Resource
	private LoginRegisterMapper loginRegisterMapper;

	private Logger logger = Logger.getLogger(SubjectServiceImpl.class);

	@Override
	public String sendCashCoupon(HttpServletRequest request, SubjectBean subjectBean) throws SQLException
	{
		// 奖励金类型（0现金券，加息券）
		String type = subjectBean.getAwardType();

		// 奖励来源（0投标 1签到 2猫咪宝 ）
		String from = subjectBean.getAwardFrom();

		// 获取1-10000随机数
		double calligraphy = Math.floor(Math.random() * 10001);

		// 根据获取方式获得集字数值范围
		double p1 = 0;
		double p2 = 0;
		// 生成金额
		int money = 0;
		// 奖励来源（0投标 1签到 2猫咪宝 ）
		if (Constants.DEVIL_NUM_ZERO.equals(from))
		{
			if (Constants.DEVIL_NUM_ZERO.equals(type))
			{
				p1 = SubjectActivityParam.GUOQING_SUBJECT.get("1") * 10000 / 100; // 88
				p2 = SubjectActivityParam.GUOQING_SUBJECT.get("2") * 10000 / 100; // 8

				if (calligraphy <= p1)
				{
					// 抽中20-50
					money = StringTools.randomBetween(20, 50);
				}
				else if (calligraphy <= p2)
				{
					// 抽中50-100
					money = StringTools.randomBetween(50, 100);
				}
				else
				{
					// 抽中100-200
					money = StringTools.randomBetween(100, 200);
				}
			}
		}
		else if (Constants.DEVIL_NUM_ONE.equals(from))
		{
			p1 = SubjectActivityParam.GUOQING_SIGNIN_FULL.get("1") * 10000 / 100; // 85
			p2 = SubjectActivityParam.GUOQING_SIGNIN_FULL.get("2") * 10000 / 100; // 10
			if (calligraphy <= p1)
			{
				// 抽中20-30
				money = StringTools.randomBetween(20, 30);
			}
			else if (calligraphy <= p2)
			{
				// 抽中30-40
				money = StringTools.randomBetween(30, 40);
			}
			else
			{
				// 抽中40-50
				money = StringTools.randomBetween(40, 50);
			}
		}

		// ---------------------------------------------------------发送红包------------------------------
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();

		MessageBean messageBean = new MessageBean();
		// --------------------添加获奖记录-----------------

		subjectBean.setAccountId(accountId);
		if (Constants.DEVIL_NUM_ZERO.equals(type))
		{
			subjectBean.setAwardMoney(String.valueOf(money * 100));
			if (Constants.DEVIL_NUM_ZERO.equals(from))
			{
				messageBean.setMsgContent("恭喜您在国庆投资活动中获得" + money
						+ "元现金券奖励,请联系<a href='javascript:void(0)' onclick='goDetails(9)'>猫咪客服</a>领取");
				subjectBean.setRemark("国庆投资活动投标" + subjectBean.getSubjectId() + "获得" + money + "元现金券奖励");
			}
			else if (Constants.DEVIL_NUM_ONE.equals(from))
			{
				messageBean.setMsgContent("恭喜您在国庆8天满签活动中获得" + money
						+ "元现金券奖励,请联系<a href='javascript:void(0)' onclick='goDetails(9)'>猫咪客服</a>领取");
				subjectBean.setRemark("国庆8天满签活动获得" + money + "元现金券奖励");
			}

		}
		else if (Constants.DEVIL_NUM_ONE.equals(type))
		{
			subjectBean.setAwardMoney("2");
			messageBean
					.setMsgContent("恭喜您在中秋投资活动中获得2%加息券奖励,请联系<a href='javascript:void(0)' onclick='goDetails(9)'>猫咪客服</a>领取");
			subjectBean.setRemark("中秋投资活动投标" + subjectBean.getSubjectId() + "获得2%加息券奖励");
		}

		// subjectBean.setAwardType(awardType);

		// subjectBean.setAwardFrom(awardFrom);
		subjectBean.setIsSend(Constants.DEVIL_NUM_ZERO);
		subjectMapper.addAwardRecord(subjectBean);

		// ----------------------添加消息----------------
		messageBean.setAccountId(accountId);
		messageBean.setMsgTitle("国庆投专属标奖励");

		messageMapper.addMessageInfo(messageBean);

		return String.valueOf(money);
	}

	@Override
	@Transactional
	public String sendActivityCoupon(String accountId, SubjectBean subjectBean, String money)
	{
		String result = "";
		try
		{
			// 活动开始时间
			String elevenBeginTime = paramMapper.getParamVal("ACTIVITY_START_TIME");

			// 活动结束时间
			String elevenEndTime = paramMapper.getParamVal("ACTIVITY_END_TIME");

			// 当前时间
			String nowDate = subjectBean.getCurrentTime();

			// 投资金额
			int imoney;

			String subjectTerm = subjectBean.getSubjectTerm();
			int subjectperiod = subjectBean.getSubjectPeriods();
			CouponDetail couponDetail = new CouponDetail();
			if (StringTools.isNullOrEmpty(money))
			{
				imoney = 0;
			}
			else
			{
				imoney = Integer.parseInt(money);
			}

			// 结束和开始开关
			if ((DateUtils.compareDateLongs(elevenEndTime, nowDate))
					&& DateUtils.compareDateLongs(nowDate, elevenBeginTime))
			{

				subjectBean.setAccountId(accountId);
				// 奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标 4参与活动）
				subjectBean.setAwardFrom(Constants.DEVIL_NUM_FOUR);

				// 判断是否送过活动期间
				subjectBean.setSubjectType("-1");
				subjectBean.setInvestType("2");
				subjectBean.setSetMoney("100000");
				subjectBean.setChooseFlag("1");
				subjectBean.setActivityBeginTime(elevenBeginTime);
				subjectBean.setActivityEndTime(elevenEndTime);

				// 奖励金类型（0现金券 1加息券）
				subjectBean.setAwardType(Constants.DEVIL_NUM_ONE);
				// 是否发送（0未发送 1已发送）
				subjectBean.setIsSend(Constants.DEVIL_NUM_ONE);

				// 赠送加息券
				if (imoney >= 1000 && Constants.DEVIL_NUM_ONE.equals(subjectTerm))
				{
					// 奖励金额
					subjectBean.setAwardMoney("1");
					int jone = subjectMapper.countIsGetAward(subjectBean);
					// 奖励金额
					subjectBean.setAwardMoney("2");
					int jtwo = subjectMapper.countIsGetAward(subjectBean);

					// 投资三个月标送 计息15天 有效期30 新手标不可用的 1%加息券
					if (subjectperiod == 3 && jone == 0)
					{
						// 有效期30天
						couponDetail.setValidityDays("30");
						// 计息15天
						couponDetail.setInterestDays("1");
						couponDetail.setInterestType("1");
						couponDetail.setCouponType("1");
						couponDetail.setCouponMoney("1");
						couponDetail.setSubjectType("5");
						subjectBean.setAwardMoney("1");
						sendNow(accountId, couponDetail, "DecemberOne", subjectBean);
					}
					else if (subjectperiod == 4 && jtwo == 0)
					{
						// 有效期30天
						couponDetail.setValidityDays("30");
						// 计息15天
						couponDetail.setInterestDays("1");
						couponDetail.setInterestType("1");
						couponDetail.setCouponType("1");
						couponDetail.setCouponMoney("2");
						couponDetail.setSubjectType("5");
						subjectBean.setAwardMoney("2");

						sendNow(accountId, couponDetail, "DecemberTwo", subjectBean);
					}

				}
			}
		}
		catch (Exception e)
		{
			logger.error("发放优惠券奖励异常");
			throw new RuntimeException();
		}
		return result;
	}

	@Transactional
	public void sendNow(String accountId, CouponDetail couponDetail, String type, SubjectBean subjectBean)
	{
		try
		{
			// 获取优惠券主键
			String couponId = null;
			String msg = "";
			String content = "";
			// 加息券
			if (Constants.DEVIL_NUM_ONE.equals(couponDetail.getCouponType()))
			{
				couponId = paramMapper.getParamVal(Constants.ACTIVITY_SEND_JAIXI);
				couponDetail.setCouponCode(GetUUID.getUUID("JX"));
				msg = "猫咪财富奖励加息券";
				content = "恭喜你获得" + couponDetail.getCouponMoney()
						+ "%加息券,详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
			}
			// 金额券
			else
			{
				couponId = paramMapper.getParamVal(Constants.ACTIVITY_SEND_CRASH);
				couponDetail.setCouponCode(GetUUID.getUUID("JE"));
				msg = "猫咪财富奖励现金券";
				content = "恭喜你获得" + couponDetail.getCouponMoney()
						+ "元现金券,详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
			}

			// 新增优惠券
			couponDetail.setCouponId(couponId);

			couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
			couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
			couponMapper.addCouponDetail(couponDetail);

			// 修改优惠券概述的数量
			CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo(couponId);
			couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
			couponMapper.updateCouponInfo(couponInfoBean);

			MessageBean outMessageBean = new MessageBean();
			outMessageBean.setAccountId(accountId);
			outMessageBean.setMsgTitle(msg);
			outMessageBean.setMsgContent(content);
			messageMapper.addMessageInfo(outMessageBean);

			// 发送优惠券
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountId);
			couponBean.setCouDetailId(couponDetail.getCouDetailId());
			couponBean.setOutTime(couponDetail.getValidityDays());
			couponMapper.addAdditional(couponBean);

			// 添加获奖记录

			String remark = "";
			if (type.equals("DecemberOne"))
			{
				remark = "2017年12月活动（12.01-12.31）参与投资3月标单笔满足1000元，获得有效期一个月计息期限为15天的1%加息券";
			}
			else if (type.equals("DecemberTwo"))
			{
				remark = "2017年12月活动（12.01-12.31）参与投资4个月标单笔满足1000元获得有效期一个月计息期限为15天的2%加息券";
			}

			subjectBean.setRemark(remark);
			subjectMapper.addAwardRecord(subjectBean);
		}
		catch (Exception e)
		{
			logger.error("发放优惠券奖励异常");
			throw new RuntimeException();
		}
	}

	/**
	 * 判断是否为羊毛党
	 * 
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月30日 上午10:35:53
	 */
	public Integer isWoolMan(String accountId)
	{
		int flag = 0;
		AccountInfo accountInfo = new AccountInfo();
		try
		{
			accountInfo.setAccountId(accountId);
			flag = accountInfoMapper.countWoolMan(accountInfo);
		}
		catch (SQLException e)
		{
			logger.error("查询是否为羊毛党异常", e);
		}
		return flag;
	}

	@Override
	public void sendElevenFreedomCoupon(String accountId) throws SQLException
	{
		try
		{
			// 活动开始时间
			String elevenBeginTime = paramMapper.getParamVal("ACTIVITY_START_TIME");

			// 活动结束时间
			String elevenEndTime = paramMapper.getParamVal("ACTIVITY_END_TIME");

			CouponDetail couponDetail = new CouponDetail();

			SubjectBean subjectBean = new SubjectBean();
			subjectBean.setActivityBeginTime(elevenBeginTime);
			subjectBean.setActivityEndTime(elevenEndTime);
			subjectBean.setAccountId(accountId);
			// 奖励金类型（0现金券 1加息券）
			subjectBean.setAwardType(Constants.DEVIL_NUM_ONE);
			// 奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标）
			subjectBean.setAwardFrom(Constants.DEVIL_NUM_TWO);
			// 投资方式（0首次投资 1累计投资 2满足等额）
			subjectBean.setInvestType("1");
			subjectBean.setSetMoney("1000000");

			// 发送有效期30天计息期限为1个月 1%加息券
			couponDetail.setValidityDays("30");
			couponDetail.setInterestDays("1");
			couponDetail.setInterestType("1");
			couponDetail.setCouponType("1");
			couponDetail.setCouponMoney("1");
			sendNow(accountId, couponDetail, "mm1", subjectBean);
		}
		catch (Exception e)
		{
			logger.error("发放双十一猫咪宝优惠券奖励异常");
			throw new RuntimeException();
		}
	}

	@Override
	public void buyIphone(AccountAddressBean accountAddressBean, String accountId, int yMoney, int periods,
			String color, int packs) throws SQLException
	{
		// --------------修改金额------------------------------------
		AccountCapital accountCapital = new AccountCapital();
		accountCapital.setAccountId(accountId);

		// 查询bean
		CapitalBean capitalBean = new CapitalBean();
		capitalBean.setAccountId(accountId);
		// 查询用户总金额
		capitalBean = capitalMapper.queryCapitalById(capitalBean);
		// 用户投资总金额
		double iMoney = capitalBean.getInvestmentMoney();

		accountCapital.setInvestmentMoney(MoneyUtils.formatFloatNumber((iMoney + yMoney) * 100));
		accountCapital.setFreezeMoney(MoneyUtils.formatFloatNumber(capitalBean.getFreezeMoney() * 100));
		// 用户可使用金额（可提现金额+不可提现金额）
		double wMoney = capitalBean.getWithdrawMoney();
		double nwMoney = capitalBean.getNoWithdrawMoney();

		// 不可提现金额大于等于用户投标本金
		if (nwMoney >= yMoney)
		{
			accountCapital.setNoWithdrawMoney(MoneyUtils.formatFloatNumber((nwMoney - yMoney) * 100));
		}
		// 不可提现金额不够扣 不可提现金额置为0 可提现金额减去
		else
		{
			accountCapital.setNoWithdrawMoney(Constants.DEVIL_NUM_ZERO);
			accountCapital.setWithdrawMoney(MoneyUtils.formatFloatNumber((nwMoney + wMoney - yMoney) * 100));
		}
		capitalMapper.editAccountCapitalById(accountCapital);

		// -----------------------------------添加投资记录----------------------------
		SubjectBean subjectBean = new SubjectBean();
		subjectBean.setAccountId(accountId);
		subjectBean.setSubjectId(Constants.ACTIVITY_SEND_IPHONE);
		// 投标状态(0:正常 1:标的正常结束 2:已转让债权)
		subjectBean.setInvestStatus(Constants.DEVIL_NUM_ZERO);
		subjectBean.setAccountId(accountId);
		subjectBean.setIsDayProfit(Constants.DEVIL_NUM_ZERO);

		subjectBean.setEndTime("1");
		subjectBean.setSubjectPeriods(periods);
		subjectBean.setRepeatType("2");
		subjectBean.setNextProfitTime("2");
		subjectBean.setInvestMoney(MoneyUtils.changeYToF(String.valueOf(yMoney)));
		subjectBean.setSubjectRate("0");
		subjectMapper.addSubjectInvest(subjectBean);

		// --------------------------------------添加订单----------------------------
		accountAddressBean.setAccountId(accountId);
		accountAddressBean.setInvestId(subjectBean.getInvestId());
		accountAddressBean.setIsDefault("0");
		accountAddressBean.setIsSend("0");
		accountAddressBean.setColor(color);
		accountAddressBean.setPackages(String.valueOf(packs));
		accountAddressBean.setRemark("投资" + yMoney + "元" + periods + "个月换购"
				+ isPhone(accountAddressBean.getGoodId(), color) + "套餐");
		accountAddressMapper.insertAccountAddress(accountAddressBean);

		// -------------------------------资金明细-----------------------
		CapitalDetail capitalDetail = new CapitalDetail();
		capitalDetail.setAccountId(accountId);
		capitalDetail.setMoney(MoneyUtils.changeYToF(String.valueOf(yMoney)));

		// 交易类型(0:储蓄卡充值 1:微信充值 2:信用卡充值 3:投资投标 4:投资投标收益 5:提现)
		capitalDetail.setType(Constants.DEVIL_NUM_THREE);

		// 金额收支(0:收入 1:支出)
		capitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
		capitalDetail.setRemark("投资" + yMoney + "元" + periods + "个月换购" + isPhone(accountAddressBean.getGoodId(), color)
				+ "套餐");
		bondTransferMapper.addCapital(capitalDetail);

		// -------------------------------消息记录-----------------------
		MessageBean messageBean = new MessageBean();
		messageBean.setAccountId(accountId);
		messageBean.setMsgTitle("投资享iphone活动");
		messageBean.setMsgContent("您成功参与投资" + yMoney + "元" + periods + "个月享"
				+ isPhone(accountAddressBean.getGoodId(), color)
				+ "套餐活动！,详情可至<a href='javascript:void(0)' onclick='goDetails(3)'>我的投资</a>查看");
		messageMapper.addMessageInfo(messageBean);
	}

	private String isPhone(String goodId, String color)
	{
		String iphone = "iphone";
		if ("1".equals(goodId))
		{
			if ("1".equals(color))
			{
				iphone = "深空灰iphone8 64G";
			}
			else if ("2".equals(color))
			{
				iphone = "银色iphone8 64G";
			}
			else if ("3".equals(color))
			{
				iphone = "金色iphone8 64G";
			}
		}
		else if ("2".equals(goodId))
		{
			if ("1".equals(color))
			{
				iphone = "深空灰iphone8 256G";
			}
			else if ("2".equals(color))
			{
				iphone = "银色iphone8 256G";
			}
			else if ("3".equals(color))
			{
				iphone = "金色iphone8 256G";
			}
		}
		else if ("3".equals(goodId))
		{
			if ("1".equals(color))
			{
				iphone = "深空灰iphone8plus 64G";
			}
			else if ("2".equals(color))
			{
				iphone = "银色iphone8plus 64G";
			}
			else if ("3".equals(color))
			{
				iphone = "金色iphone8plus 64G";
			}
		}
		else if ("4".equals(goodId))
		{
			if ("1".equals(color))
			{
				iphone = "深空灰iphone8plus 256G";
			}
			else if ("2".equals(color))
			{
				iphone = "银色iphone8plus 256G";
			}
			else if ("3".equals(color))
			{
				iphone = "金色iphone8plus 256G";
			}
		}
		else if ("5".equals(goodId))
		{
			if ("1".equals(color))
			{
				iphone = "深空灰iphoneX 64G";
			}
			else if ("2".equals(color))
			{
				iphone = "银色iphoneX 64G";
			}
		}
		else if ("6".equals(goodId))
		{
			if ("1".equals(color))
			{
				iphone = "深空灰iphoneX 256G";
			}
			else if ("2".equals(color))
			{
				iphone = "银色iphoneX 256G";
			}
		}
		return iphone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xed.financing.wxgzh.service.sendcash.SendCashCouponService#sendCash
	 * (java.lang.String)
	 */
	@Override
	public void sendCash(String accountId, String money) throws SQLException
	{
		// TODO Auto-generated method stub
		// 修改用户明细表
		CapitalDetail capitalDetail = new CapitalDetail();
		capitalDetail.setAccountId(accountId);
		capitalDetail.setMoney(money);
		capitalDetail.setType("17");
		capitalDetail.setInExpend(Constants.DEVIL_NUM_ZERO);
		capitalDetail.setRemark("受邀用户绑定银行卡奖励");
		capitalDetailMapper.addCapital(capitalDetail);

		// 修改用户金额表
		CapitalBean capitalBean = new CapitalBean();
		capitalBean.setAccountId(accountId);
		capitalBean = capitalMapper.queryCapitalById(capitalBean);
		capitalBean.setWithdrawMoney(capitalBean.getWithdrawMoney() + 10000);
		capitalMapper.editCapitalById(capitalBean);

		// 发送消息
		MessageBean messageBean = new MessageBean();
		messageBean.setAccountId(accountId);
		messageBean.setMsgTitle("受邀好友绑定银行卡奖励");
		messageBean.setMsgTitle("您邀请的好友于本平台首次注册并绑定银行卡,10元现金奖励已发放至您的可用余额,请注意查看");
		messageMapper.addMessageInfo(messageBean);
	}

	@Override
	public String sendNewYearAward(String accountId, String money) throws SQLException
	{
		String result = "";
		// 当前时间
		String nowDate = paramMapper.getCurrentTime().getNowHours();

		// 投资金额
		int imoney;
		if (StringTools.isNullOrEmpty(money))
		{
			imoney = 0;
		}
		else
		{
			imoney = Integer.parseInt(money);
		}
		// 结束和开始开关
		if ((DateUtils.compareDateLongs(Constants.NEW_YEAR_END_TIME, nowDate))
				&& DateUtils.compareDateLongs(nowDate, Constants.NEW_YEAR_BEGIN_TIME))
		{
			if (imoney >= 2000)
			{
				// 判断领了多少次红包
				SubjectBean subjectBean = new SubjectBean();
				subjectBean.setAccountId(accountId);
				subjectBean.setActivityBeginTime(Constants.NEW_YEAR_BEGIN_TIME);
				subjectBean.setActivityEndTime(Constants.NEW_YEAR_END_TIME);
				int c = subjectMapper.countInvestBetweenTime(subjectBean);
				if (c <= 5)
				{
					result = "redpackage";
				}
			}
		}
		return result;
	}

	@Override
	public String sendGift(String accountId, SubjectBean subjectBean, String money, String type) throws SQLException
	{
		String result = "";
		try
		{
			// 活动开始时间
			String elevenBeginTime = "";
			String giftName = "";
			String giftId = "";

			// 获取当前时间 判断活动的时间
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date = formatter.format(System.currentTimeMillis());
			if (date.equals(Constants.CHRISTMAS))
			{
				elevenBeginTime = Constants.CHRISTMAS;
				giftName = Constants.GIFT_OIL;
				giftId = Constants.GIFT_OIL_ID;
			}
			else if (date.equals(Constants.YUANDAN))
			{
				elevenBeginTime = Constants.YUANDAN;
				giftName = Constants.GLUTINOUSRIC;
				giftId = Constants.GLUTINOUSRICE_ID;
			}
			else
			{
				return "sendfail";
			}

			// 活动结束时间
			// String
			// elevenEndTime=paramMapper.getParamVal("ACTIVITY_END_TIME");

			// 当前时间
			String nowDate = subjectBean.getCurrentTime();

			// 投资金额
			int imoney;

			String subjectTerm = subjectBean.getSubjectTerm();
			// CouponDetail couponDetail = new CouponDetail();
			if (StringTools.isNullOrEmpty(money))
			{
				imoney = 0;
			}
			else
			{
				imoney = Integer.parseInt(money);
			}
			int typemoney = 0;
			// 结束和开始开关
			if (DateUtils.compareDateLongs(nowDate, elevenBeginTime)
					&& DateUtils.compareDateLongs(elevenBeginTime, nowDate))
			{

				subjectBean.setAccountId(accountId);
				// 奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标 4参与活动）
				subjectBean.setAwardFrom(Constants.DEVIL_NUM_FOUR);

				// 判断是否送过活动期间
				// subjectBean.setSubjectType("-1");
				subjectBean.setInvestType("3");
				// 档次类型 (0 15000档 1 5000档)
				// 月标
				if (Constants.DEVIL_NUM_ZERO.equals(type))
				{
					subjectBean.setSetMoney("1500000");
					typemoney = 15000;
				}
				else if (Constants.DEVIL_NUM_ONE.equals(type))
				{
					subjectBean.setSetMoney("500000");
					typemoney = 5000;
				}

				// 活动日期
				subjectBean.setAddTime(elevenBeginTime);
				// 查看用户是否第一次活动内投资
				int count = subjectMapper.countChristmas(subjectBean);
				if (count > 0)
				{
					return "sendfail";
				}

				// subjectBean.setSetMoney("100000");
				// subjectBean.setChooseFlag("1");
				subjectBean.setActivityBeginTime(elevenBeginTime);
				// subjectBean.setActivityEndTime(elevenEndTime);

				// 奖励金类型（0现金券 1加息券 2实物奖励 3实物奖励）
				subjectBean.setAwardType(Constants.DEVIL_NUM_THREE);
				// 是否发送（0未发送 1已发送）
				subjectBean.setIsSend(Constants.DEVIL_NUM_ZERO);

				// 赠送赠送实物
				if (imoney >= typemoney && Constants.DEVIL_NUM_ONE.equals(subjectTerm))
				{
					// sendNow(accountId,
					// couponDetail,"DecemberTwo",subjectBean);
					// 获取优惠券主键
					String msg = "活动奖励";
					String content = "恭喜您获得" + giftName + ",请前往个人中心填写收货地址，我们将在1-3个工作日内寄出。";

					MessageBean outMessageBean = new MessageBean();
					outMessageBean.setAccountId(accountId);
					outMessageBean.setMsgTitle(msg);
					outMessageBean.setMsgContent(content);
					messageMapper.addMessageInfo(outMessageBean);

					// 添加获奖记录

					String remark = "";
					if (Constants.DEVIL_NUM_ZERO.equals(type))
					{
						remark = "" + nowDate + " 参与投资1个月标单笔满足15000元，获得" + giftName;
					}
					else if (Constants.DEVIL_NUM_ONE.equals(type))
					{
						remark = "" + nowDate + " 参与投资3个月标单笔满足5000元，获得" + giftName;
					}

					// subjectBean.setAwardName(giftName);
					subjectBean.setGoodsId(giftId);
					subjectBean.setRemark(remark);
					subjectMapper.addAwardRecord(subjectBean);

					result = "sendgift";
				}
			}
		}
		catch (Exception e)
		{
			result = "sendfail";
			logger.error("发放优惠券奖励异常");
			throw new RuntimeException();
		}
		return result;
	}

	/**
	 * 设置查询条件
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月2日 下午2:23:05
	 */
	public SubjectBean setSelectCondition(String accountId, String awardFrom, String awardtype, String subjectType, 
			String investType, String conditionMoney, String chooseFlag, String beginTime, String endTime){
		SubjectBean subjectBean = new SubjectBean();
		subjectBean.setAccountId(accountId);
		
		//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标 4参与活动 5春节活动）
		subjectBean.setAwardFrom(awardFrom);
		//奖励金类型  0现金券 1加息券 2红包实物奖励 3实物奖励 4鱼干 5新手再投次数
		subjectBean.setAwardType(awardtype);
		//设置标类型（-1所有 0新手标，1精选理财 4爆款 ）
		subjectBean.setSubjectType(subjectType);
		//投资方式（0首次投资 1累计投资 2满足等额 3大于等额）
		subjectBean.setInvestType(investType);
		//设置条件金额
		subjectBean.setSetMoney(conditionMoney);
		//设置选择模式 加入时间选择
		subjectBean.setChooseFlag(chooseFlag);
		//设置活动开始时间
		subjectBean.setActivityBeginTime(beginTime);
		//设置活动结束时间
		subjectBean.setActivityEndTime(endTime);
		return subjectBean;
	}
	
	
	@Override
	public void sendSpringFestival(String accountId, String money) throws SQLException
	{
		// 投资金额
		int imoney;
		if (StringTools.isNullOrEmpty(money))
		{
			imoney = 0;
		} else
		{
			imoney = Integer.parseInt(money);
		}
		
		if (imoney >= 500 && imoney < 3000)
		{
			//设置查询条件
			SubjectBean subjectBean = setSelectCondition(accountId, "5", "1", "-1", "2", "50000", "1", Constants.SPRING_FESTIVAL_BEGIN_TIME, Constants.SPRING_FESTIVAL_END_TIME);
			
			//查询用户投资次数
			if(subjectMapper.countIsGetAward(subjectBean) < Constants.SPRING_FESTIVAL_COUNT){
				
				CouponDetail couponDetail = setCouponDetail(Constants.SPRING_FESTIVAL_VALIDITYDAYS, "1", "1", "1", "1", "5");
				// 发送有效期 ----天计息期限为1个月 1%加息券
				// 获取优惠券主键
				String couponId = paramMapper.getParamVal(Constants.ACTIVITY_SEND_JAIXI);
				couponDetail.setCouponCode(GetUUID.getUUID("JX"));
				//发送优惠券
				addCashCoupon(accountId, couponDetail, couponId);				
				
				//添加消息
				String msg = "猫咪财富奖励加息券";
				String content = "恭喜您参与春节投资活动获得" + couponDetail.getCouponMoney()
						+ "%加息券,详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
				addMessage(msg, content, accountId);
				
				//添加award表信息
				String remark = "春节活动（2.15-2.21）参与投资单笔满足500元，获得有效期180天计息期限为1个月的1%加息券,请去活动页领取。";
				addAward(accountId, Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_ONE, "500", remark, couponDetail.getCouponMoney());
				
			}	
		}
		else if (imoney >= 3000 && imoney < 5000)
		{
			//设置查询条件
			SubjectBean subjectBean = setSelectCondition(accountId, "5", "5", "-1", "2", "300000", "1", Constants.SPRING_FESTIVAL_BEGIN_TIME, Constants.SPRING_FESTIVAL_END_TIME);
			
			//查询用户投资次数
			if(subjectMapper.countIsGetAward(subjectBean) < Constants.SPRING_FESTIVAL_COUNT){
				// 用户信息
				AccountInfo accountInfo = accountInfoMapper.getLoginAccountInfo(accountId);
				//更新用户新手专享标再投机会
				accountInfo.setNewSubjectCount(String.valueOf(Integer.parseInt(accountInfo.getNewSubjectCount()) + Constants.SPRING_FESTIVAL_NEWSUBJECT_COUNT));
				accountInfoMapper.bindInfo(accountInfo);		
				
				//添加消息
				String msg = "猫咪财富奖励新手投标次数";
				String content = "恭喜您参与春节投资活动获得2次新手投标次数,详情可至<a href='javascript:void(0)' onclick='goDetails(3)'>我要投资</a>查看。";
				addMessage(msg, content, accountId);
				
				//添加award表信息
				String remark = "春节活动（2.15-2.21）参与投资单笔满足3000元，获得2次新手标再投机会。";
				addAward(accountId, Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_FIVE, "3000", remark, "1");
			}
			

		}
		else if (imoney >= 5000 && imoney < 10000)
		{
			//设置查询条件
			SubjectBean subjectBean = setSelectCondition(accountId, "5", "4", "-1", "2", "500000", "1", Constants.SPRING_FESTIVAL_BEGIN_TIME, Constants.SPRING_FESTIVAL_END_TIME);
			
			//查询用户投资次数
			if(subjectMapper.countIsGetAward(subjectBean) < Constants.SPRING_FESTIVAL_COUNT){
				
				/*===添加鱼干===*/
				AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(accountId);
				accountInfo.setAccountExp(String.valueOf(Integer.valueOf(accountInfo.getAccountExp())+ Constants.SPRING_FESTIVAL_AWARDCOUNT1));
				accountInfo.setAccountScore(String.valueOf(Integer.valueOf(accountInfo.getAccountScore())+ Constants.SPRING_FESTIVAL_AWARDCOUNT1));
				accountScoreMapper.changeScoreAndExp(accountInfo);
				
				/*===添加鱼干明细===*/
				AccountScoreBean accountScoreBean = new AccountScoreBean();
				accountScoreBean.setAccountId(accountId);
				//积分收支(0:收入 1:支出)
				accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
				//积分类型(0:签到 1:完善信息 2:投标奖励 3:兑换积分 4:积分抽奖 5:购买积分 6:其他 7:积分退回)
				accountScoreBean.setScoreType(Constants.DEVIL_NUM_SIX);
				accountScoreBean.setScore("" + Constants.SPRING_FESTIVAL_AWARDCOUNT1);
				accountScoreBean.setModReason("投标"+MoneyUtils.changeFToY("" + imoney)+"元获取" + Constants.SPRING_FESTIVAL_AWARDCOUNT1 + "鱼干");
				accountScoreMapper.addAccountScoreInfo(accountScoreBean);
				/*===添加鱼干结束===*/
				
				//添加消息
				String msg = "猫咪财富奖励鱼干";
				String content = "恭喜您参与春节投资活动获得" + Constants.SPRING_FESTIVAL_AWARDCOUNT1 + "鱼干,详情可至<a href='javascript:void(0)' onclick='goDetails(5)'>我的鱼干</a>查看。";
				addMessage(msg, content, accountId);
				
				//添加award表信息
				String remark = "春节活动（2.15-2.21）参与投资单笔满足5000元，获得" + Constants.SPRING_FESTIVAL_AWARDCOUNT1 + "鱼干。";
				addAward(accountId, Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_FOUR, "5000", remark, "500");
			}

		}
		else if (imoney >= 10000)
		{
			//设置查询条件
			SubjectBean subjectBean = setSelectCondition(accountId, "5", "4", "-1", "2", "1000000", "1", Constants.SPRING_FESTIVAL_BEGIN_TIME, Constants.SPRING_FESTIVAL_END_TIME);
			
			//查询用户投资次数
			if(subjectMapper.countIsGetAward(subjectBean) < Constants.SPRING_FESTIVAL_COUNT){
				
				/*===添加鱼干===*/
				AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(accountId);
				accountInfo.setAccountExp(String.valueOf(Integer.valueOf(accountInfo.getAccountExp())+ Constants.SPRING_FESTIVAL_AWARDCOUNT2));
				accountInfo.setAccountScore(String.valueOf(Integer.valueOf(accountInfo.getAccountScore())+ Constants.SPRING_FESTIVAL_AWARDCOUNT2));
				accountScoreMapper.changeScoreAndExp(accountInfo);
				
				/*===添加鱼干明细===*/
				AccountScoreBean accountScoreBean = new AccountScoreBean();
				accountScoreBean.setAccountId(accountId);
				//积分收支(0:收入 1:支出)
				accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
				//积分类型(0:签到 1:完善信息 2:投标奖励 3:兑换积分 4:积分抽奖 5:购买积分 6:其他 7:积分退回)
				accountScoreBean.setScoreType(Constants.DEVIL_NUM_SIX);
				accountScoreBean.setScore("" + Constants.SPRING_FESTIVAL_AWARDCOUNT2);
				accountScoreBean.setModReason("投标"+MoneyUtils.changeFToY("" + imoney)+"元获取" + Constants.SPRING_FESTIVAL_AWARDCOUNT2 + "鱼干");
				accountScoreMapper.addAccountScoreInfo(accountScoreBean);
				/*===添加鱼干结束===*/
				
				//添加消息
				String msg = "猫咪财富奖励鱼干";
				String content = "恭喜您参与春节投资活动获得" + Constants.SPRING_FESTIVAL_AWARDCOUNT2 + "鱼干,详情可至<a href='javascript:void(0)' onclick='goDetails(5)'>我的鱼干</a>查看。";
				addMessage(msg, content, accountId);
				
				//添加award表信息
				String remark = "春节活动（2.15-2.21）参与投资单笔满足10000元，获得" + Constants.SPRING_FESTIVAL_AWARDCOUNT2 + "鱼干。";			
				addAward(accountId, Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_FOUR, "10000", remark, "1200");
			}
		}
	}


	
	@Override
	public void sendSpringFriends(String accountIdlogin, String accountIdfriend, String money) throws SQLException
	{
		//accountIdlogin 登录人id   accountIdfriend 邀请人id
		
		// 投资金额
		int imoney;
		if (StringTools.isNullOrEmpty(money)){
			imoney = 0;
		} else{
			imoney = Integer.parseInt(money);
		}
		
		sendSpring(accountIdlogin, accountIdfriend, imoney);
	}
	
	//春节活动专用
	public void sendSpring(String accountIdlogin, String accountIdfriend, int imoney)throws SQLException{
		String couponMoney = "";//加息券的金额
		String umoney = "";//档次
		String xjmoney = "";//现金券金额
		if(imoney >= 500 && imoney < 1000){
			couponMoney = "2";
			umoney = "500";
			xjmoney = "1000";
		}else if(imoney >= 1000){
			couponMoney = "3";
			umoney = "1000";
			xjmoney = "2000";
		}
		
		/*---------------给邀请人发加息劵-----------------------------*/
		// 有效期 ----天计息期限为1个月   %加息券
		CouponDetail couponDetail = setCouponDetail(Constants.SPRING_FESTIVAL_VALIDITYDAYS, "1", "1", "1", couponMoney, "5");

		// 获取优惠券主键
		String couponId = paramMapper.getParamVal(Constants.ACTIVITY_SEND_JAIXI);
		couponDetail.setCouponCode(GetUUID.getUUID("JX"));
		//发送优惠券
		addCashCoupon(accountIdfriend, couponDetail, couponId);
		
		//添加消息
		String msg = "猫咪财富奖励加息券";
		String content = "您邀请的好友参与春节投资活动，投资满" + umoney + "元，获得" + couponDetail.getCouponMoney()
				+ "%加息券,详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
		addMessage(msg, content, accountIdfriend);
		
		//添加award表信息
		String remark = "邀请好友参与春节活动（2.15-2.21）参与投资新手标满足" + umoney + "元，获得有效期180天计息期限为1个月的" + couponDetail.getCouponMoney() +"%加息券,"
				+ "详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
		addAward(accountIdfriend, Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_ONE, umoney, remark, couponDetail.getCouponMoney());	
		
		//如果是满足1000元档   另外增加新手投标机会
		if(couponMoney.equals("3")){
			// 用户信息
			AccountInfo accountInfo = accountInfoMapper.getLoginAccountInfo(accountIdfriend);
			//更新用户新手专享标再投机会
			accountInfo.setNewSubjectCount(String.valueOf(Integer.parseInt(accountInfo.getNewSubjectCount()) + 1));
			accountInfoMapper.bindInfo(accountInfo);		
			
			//添加消息
			//MessageBean outMessageBean1 = new MessageBean();
			msg = "猫咪财富奖励新手投标次数";
			content = "您邀请的好友参与春节投资新手标活动，满足" + umoney + "元，您获得1次新手投标次数,详情可至<a href='javascript:void(0)' onclick='goDetails(3)'>我要投资</a>查看。";
			addMessage(msg, content, accountIdfriend);
				
			remark = "邀请的好友参与春节活动（2.15-2.21）参与投资新手标满足" + umoney + "元，获得1次新手标再投机会。";
			//添加award表信息
			addAward(accountIdfriend, Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_FIVE, umoney, remark, "1");
		}
		
		/*---------------给邀请人发加息劵结束-----------------------------*/
		
		/*---------------给用户发现金卷----------------------------------*/
		couponDetail = setCouponDetail(Constants.SPRING_FESTIVAL_VALIDITYDAYS, "-1", "-1", "3", xjmoney, "-1");
		// 发送有效期 ----天 10元现金券

		// 获取优惠券主键
		couponId = paramMapper.getParamVal(Constants.ACTIVITY_SEND_CRASH);
		couponDetail.setCouponCode(GetUUID.getUUID("XJ"));
		addCashCoupon(accountIdlogin, couponDetail, couponId);
		
		//添加消息
		msg = "猫咪财富奖励现金券";
		content = "恭喜您参与春节新手投资新手标活动，获得" + MoneyUtils.changeFToY(couponDetail.getCouponMoney())
				+ "元现金券,详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
		addMessage(msg, content, accountIdlogin);

		//添加award信息.
		remark = "参与春节活动（2.15-2.21）投资新手标满足" + umoney + "元，获得" + MoneyUtils.changeFToY(couponDetail.getCouponMoney()) +"元现金券,请去我的优惠券查看。";
		addAward(accountIdlogin, Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_ZERO, umoney, remark, couponDetail.getCouponMoney());	

		/*---------------给用户发现金卷结束----------------------------------*/
		
		/*---------------如果邀请人邀请的好友> 5个人，先发一张3%加息劵，每多一人，发送1张0.6%加息劵----------------------------------*/
		//查询邀请好友数量
		//限定注册时间范围
		String regBegin = Constants.SPRING_FESTIVAL_BEGIN_TIME;
		String regEnd = Constants.SPRING_FESTIVAL_END_TIME;
		
		//邀请好友数量
		int friends = loginRegisterMapper.getFriendsCount(accountIdlogin, regBegin, regEnd);
		
		if(friends >= 5){
			
			String[] friendsAccountId = new String[friends];
			int index = 0;//记录 friendsAccountId 数量
			
			List<AccountInfo> list = loginRegisterMapper.getFriendsList(accountIdlogin, regBegin, regEnd);
			for(AccountInfo info : list){
				SubjectBean subBean = new SubjectBean();
				subBean.setAccountId(info.getAccountId());
				//查询该用户投了多少新手专享标
				int counts = subjectMapper.countNewSubject(subBean);
				if(counts > 0){
					//如果用户投资了新手标，则下标+ 1,并且记录在friendsAccountId里
					friendsAccountId[index] = info.getAccountId();
					index++;
				}
			}
			
			/*------------------邀请人送3%加息券, 所有被邀请人送5元现金券----------------*/
			if(index == 5){
				
				for(int i = 0; i < index; i++){
					couponDetail = setCouponDetail(Constants.SPRING_FESTIVAL_VALIDITYDAYS, "-1", "-1", "3", "500", "-1");

					// 获取优惠券主键
					couponId = paramMapper.getParamVal(Constants.ACTIVITY_SEND_CRASH);
					couponDetail.setCouponCode(GetUUID.getUUID("XJ"));
					addCashCoupon(friendsAccountId[i], couponDetail, couponId);
	
					//添加消息
					msg = "猫咪财富奖励现金券";
					content = "您的推荐人邀请多名好友共同参与春节投资活动，获得" + MoneyUtils.changeFToY(couponDetail.getCouponMoney())
							+ "元现金券,详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
					addMessage(msg, content, friendsAccountId[i]);

					//添加award信息.
					remark = "推荐人邀请多名好友参与春节活动（2.15-2.21）投资活动，获得" + MoneyUtils.changeFToY(couponDetail.getCouponMoney()) +"元现金券,请去我的优惠券查看。";
					addAward(friendsAccountId[i], Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_ZERO, umoney, remark, couponDetail.getCouponMoney());	
				}
				/*===---------------所有被邀请人送5元现金券  结束-----------===*/
				
				/*===------------给邀请人发3%加息劵-----------------------===*/
				couponDetail = setCouponDetail(Constants.SPRING_FESTIVAL_VALIDITYDAYS, "1", "1", "1", "3", "5");

				// 获取优惠券主键
				couponId = paramMapper.getParamVal(Constants.ACTIVITY_SEND_JAIXI);
				couponDetail.setCouponCode(GetUUID.getUUID("JX"));
				addCashCoupon(accountIdfriend, couponDetail, couponId);
				
				//添加消息
				msg = "猫咪财富奖励加息券";
				content = "您邀请多名好友参与春节投资活动，获得" + couponDetail.getCouponMoney()
						+ "%加息券,详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
				addMessage(msg, content, accountIdfriend);

				//添加award信息.
				remark = "邀请多名好友参与春节投资活动，获得有效期180天计息期限为1个月的" + couponDetail.getCouponMoney() +"%加息券,"
						+ "详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
				addAward(accountIdfriend, Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_ONE, umoney, remark, couponDetail.getCouponMoney());	
			}else if(index > 5){
				/*-----------邀请人送0.6%加息券-----------------*/
				couponDetail = setCouponDetail(Constants.SPRING_FESTIVAL_VALIDITYDAYS, "1", "1", "1", "0.6", "5");

				// 获取优惠券主键
				couponId = paramMapper.getParamVal(Constants.ACTIVITY_SEND_JAIXI);
				couponDetail.setCouponCode(GetUUID.getUUID("JX"));
				//发送优惠券
				addCashCoupon(accountIdfriend, couponDetail, couponId);
				
				//添加消息
				msg = "猫咪财富奖励加息券";
				content = "邀请多名好友参与春节投资活动，获得" + couponDetail.getCouponMoney()
						+ "%加息券,详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
				addMessage(msg, content, accountIdfriend);
				
				//添加award表信息
				remark = "邀请好友参与春节活动（2.15-2.21）投资新手标满足,获得有效期180天计息期限为1个月的" + couponDetail.getCouponMoney() +"%加息券,"
						+ "详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
				addAward(accountIdfriend, Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_ONE, umoney, remark, couponDetail.getCouponMoney());	
				/*-----------邀请人送0.6%加息券 结束----------------*/
				
				/*-----------被邀请人发5元现金券-----------------*/
				couponDetail = setCouponDetail(Constants.SPRING_FESTIVAL_VALIDITYDAYS, "-1", "-1", "3", "500", "-1");

				// 获取优惠券主键
				couponId = paramMapper.getParamVal(Constants.ACTIVITY_SEND_CRASH);
				couponDetail.setCouponCode(GetUUID.getUUID("XJ"));
				addCashCoupon(accountIdlogin, couponDetail, couponId);

				//添加消息
				msg = "猫咪财富奖励现金券";
				content = "您的推荐人邀请多名好友共同参与春节投资活动，获得" + MoneyUtils.changeFToY(couponDetail.getCouponMoney())
						+ "元现金券,详情可至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。";
				addMessage(msg, content, accountIdlogin);

				//添加award信息.
				remark = "推荐人邀请多名好友参与春节活动（2.15-2.21）投资活动，获得" + MoneyUtils.changeFToY(couponDetail.getCouponMoney()) +"元现金券,请去我的优惠券查看。";
				addAward(accountIdlogin, Constants.DEVIL_NUM_FIVE, Constants.DEVIL_NUM_ZERO, umoney, remark, couponDetail.getCouponMoney());	
				
				/*-----------被邀请人发5元现金券 结束---------- --*/
			}
		}
	}
	

	
	@Transactional
	public void addCashCoupon(String accountId, CouponDetail couponDetail, String couponId){

		try
		{
			// 新增优惠券
			couponDetail.setCouponId(couponId);
			//是否被领取 (0 未领取)
			couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
			//是否上架（1 上架）
			couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
			couponMapper.addCouponDetail(couponDetail);
	
			// 修改优惠券概述的数量
			CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo(couponId);
			couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
			couponMapper.updateCouponInfo(couponInfoBean);
			
			// 发送优惠券
			CouponBean couponBean = new CouponBean();
			couponBean.setAccountId(accountId);
			couponBean.setCouDetailId(couponDetail.getCouDetailId());
			couponBean.setOutTime(couponDetail.getValidityDays());
			couponMapper.addAdditional(couponBean);
		}
		catch (SQLException e)
		{
			logger.debug("发送优惠券异常");
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void addMessage(String msg, String content, String accountId){
		//添加消息
		MessageBean outMessageBean = new MessageBean();
		outMessageBean.setAccountId(accountId);
		outMessageBean.setMsgTitle(msg);
		outMessageBean.setMsgContent(content);
		try
		{
			messageMapper.addMessageInfo(outMessageBean);
		}
		catch (SQLException e)
		{
			logger.debug("发送优惠券添加message消息表异常");
			e.printStackTrace();
		}

	}
	
	@Transactional
	public void addAward(String accountId, String awardFrom, String awarType, String umoney, String remark, String awardMoney){
		SubjectBean sBean = new SubjectBean();
		sBean.setAccountId(accountId);
		// 奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标 4参与活动 5春节活动） 
		sBean.setAwardFrom(awardFrom);
		// 奖励金类型奖励金类型（0现金券 1加息券 2红包实物奖励 3实物奖励 4鱼干 5新手再投次数）  
		sBean.setAwardType(awarType);
		//档次
		sBean.setSetMoney(MoneyUtils.changeYToF(umoney));	
		// 是否发送（0未发送 1已发送）
		sBean.setIsSend(Constants.DEVIL_NUM_ZERO);
		//标类型(-1 所有表)
		sBean.setSubjectType("-1");
		//投资方式（0首次投资 1累计投资 2满足等额 3大于等额）
		sBean.setInvestType("2");
		//是否发送
		sBean.setIsSend("0");
		// 添加获奖记录
		sBean.setRemark(remark);
		//添加奖励金额
		sBean.setAwardMoney(awardMoney);
		try
		{
			subjectMapper.addAwardRecord(sBean);
		}
		catch (SQLException e)
		{
			logger.debug("发送优惠券添加award消息表异常");
			e.printStackTrace();
		}
	}
	
	@Transactional
	public String addAwardReturn(String accountId, String awardFrom, String awarType, String umoney, String remark, String awardMoney,AccountInfo investAccount){
		SubjectBean sBean = new SubjectBean();
		sBean.setAccountId(investAccount.getAccountId());
		sBean.setLinkAccountId(accountId);
		// 奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标 4参与活动 5春节活动） 
		sBean.setAwardFrom(awardFrom);
		// 奖励金类型奖励金类型（0现金券 1加息券 2红包实物奖励 3实物奖励 4鱼干 5新手再投次数）  
		sBean.setAwardType(awarType);
		//档次
		sBean.setSetMoney(MoneyUtils.changeYToF(umoney));	
		// 是否发送（0未发送 1已发送）
		sBean.setIsSend(Constants.DEVIL_NUM_ZERO);
		//标类型(-1 所有表)
		sBean.setSubjectType("-1");
		//投资方式（0首次投资 1累计投资 2满足等额 3大于等额）
		sBean.setInvestType("2");
		//是否发送
		sBean.setIsSend("0");
		// 添加获奖记录
		sBean.setRemark(remark);
		//添加奖励金额
		sBean.setAwardMoney(awardMoney);
		try
		{
			subjectMapper.addAwardRecord(sBean);
		}
		catch (SQLException e)
		{
			logger.debug("发送优惠券添加award消息表异常");
			e.printStackTrace();
		}
		return sBean.getAwardId();
	}
	
	/**
	 * 设置优惠券类型
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月2日 下午3:04:03
	 */
	public CouponDetail setCouponDetail(String validityDays, String interestDays, String interestType, String couponType, String couponMoney, String subjectType){
		CouponDetail couponDetail = new CouponDetail();
		// 发送有效期 ----天
		couponDetail.setValidityDays(validityDays);
		//计息期限
		couponDetail.setInterestDays(interestDays);
		couponDetail.setInterestType(interestType);
		//券类型(0:增值券 1:加息券 2:体验金 3:现金券 4:提现券 5.活动券)
		couponDetail.setCouponType(couponType);
		//优惠券金额
		couponDetail.setCouponMoney(couponMoney);
		//使用标类型
		couponDetail.setSubjectType(subjectType);
		return couponDetail;
	}

	@Override
	public String sendCashCoupon(AccountInfo accountInfo,AccountInfo invvestAccount,String money,String awardType) throws SQLException
	{
		String awardId="";
		//投资本金的18%作为现金券
		double awardmoney=Double.parseDouble(money)*12;
		if(awardmoney>1000000)
		{
			awardmoney=1000000;
		}
		String wMoney=MoneyUtils.formatFloatNumbers(awardmoney,0);
		String rk="暑期送清凉-邀请好友超级返 用户"+invvestAccount.getTelephone()+"投资"+money+"元,好友"+accountInfo.getTelephone()+"获得"+awardmoney/100+"元现金券";
		awardId=addAwardReturn(accountInfo.getAccountId(),"7",awardType,money,rk,wMoney,invvestAccount);
		String remark="暑期送清凉-邀请好友超级返活动中您的好友"+invvestAccount.getTelephone()+"投资"+money+"元,您获得"+awardmoney/100+"元现金券";
		addMessage("暑期送清凉活动奖励",remark, accountInfo.getAccountId());
		return awardId;
	}

	@Override
	public void sendCashCoupon(String accountId,String investMoney,String couponMoney,String telephone,String recommendTelephone) throws SQLException
	{
		// TODO Auto-generated method stub
		SubjectBean subjectBean=new SubjectBean();
		subjectBean.setAccountId(accountId);
		subjectBean.setAwardType("3");
		//奖励来源（0投标 1签到 2猫咪宝 3邀请好友投标 4参与活动 5春节活动 6理财节 7暑期活动2018 8国庆活动）
		subjectBean.setAwardFrom("8");
		//标类型（-1所有 0新手标，1精选理财 4爆款 ）
		subjectBean.setSubjectType("-1");
		//投资方式（0首次投资 1累计投资 2满足等额 3大于等额）
		subjectBean.setInvestType("0");
		subjectBean.setChooseFlag("1");
		subjectBean.setActivityBeginTime(Constants.FIVE_ZERO_EIGHT_ACTIVITY_BEGIN_TIME_HOUR);
		subjectBean.setActivityEndTime(Constants.FIVE_ZERO_EIGHT_ACTIVITY_END_TIME_HOUR);
		subjectBean.setAwardMoney(MoneyUtils.changeYToF(couponMoney));
		
		subjectBean.setSetMoney("100000");
		subjectBean.setRemark("2018国庆活动---"+recommendTelephone+"邀请用户"+telephone+"投资"+investMoney+"元分别获得现金券"+couponMoney+"元");
		subjectBean.setIsSend("1");
		subjectBean.setAwardType("0");
		subjectMapper.addAwardRecord(subjectBean);
		
	}

	@Override
	public void sendCashCouponByMoney(String accountId, String couponMoney) throws SQLException
	{
		CouponDetail couponDetail=new CouponDetail();
		couponDetail.setCouponType("3");
		String couponId = paramMapper.getParamVal(Constants.ACTIVITY_SEND_CRASH);
		couponDetail.setCouponCode(GetUUID.getUUID("ZQ"));
		couponDetail.setCouponId(couponId);
		couponDetail.setCouponMoney(MoneyUtils.changeYToF(couponMoney));
		couponDetail.setIsReceive(Constants.DEVIL_NUM_ONE);
		couponDetail.setIsShow(Constants.DEVIL_NUM_ONE);
		couponDetail.setValidityDays("-1");
		couponDetail.setInterestDays("-1");
		couponDetail.setInterestType("-1");
		couponDetail.setSubjectType("-1");
		couponMapper.addCouponDetail(couponDetail);

		// 修改优惠券概述的数量
		CouponInfoBean couponInfoBean = couponMapper.selectCouponInfo(couponId);
		couponInfoBean.setCouponQuantity(String.valueOf(Integer.valueOf(couponInfoBean.getCouponQuantity()) + 1));
		couponMapper.updateCouponInfo(couponInfoBean);
	
	
		CouponBean couponBean = new CouponBean();
		couponBean.setAccountId(accountId);
		couponBean.setCouDetailId(couponDetail.getCouDetailId());
		couponBean.setOutTime(couponDetail.getValidityDays());
		couponMapper.addAdditional(couponBean);
	}
}