/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.subject.SubjectServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月16日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.subject.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper;
import com.xed.financing.wxgzh.mapper.accountaddress.AccountAddressMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.coupon.CouponMapper;
import com.xed.financing.wxgzh.mapper.goldDetails.GoldDetailsMapper;
import com.xed.financing.wxgzh.mapper.goldtransfer.GoldTransferMapper;
import com.xed.financing.wxgzh.mapper.goodsinfo.GoodsInfoMapper;
import com.xed.financing.wxgzh.mapper.goodsorder.GoodsOrderMapper;
import com.xed.financing.wxgzh.mapper.investrecord.InvestRecordMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.mapper.repaymentPlan.RepaymentPlanMapper;
import com.xed.financing.wxgzh.mapper.subject.SubjectMapper;
import com.xed.financing.wxgzh.mapper.userCapital.UserCapitalMapper;
import com.xed.financing.wxgzh.mapper.userCapitalDetail.UserCapitalDetailMapper;
import com.xed.financing.wxgzh.mapper.userMessage.UserMessageMapper;
import com.xed.financing.wxgzh.model.accountaddress.AccountAddressBean;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.golddetails.GoldDetailsBean;
import com.xed.financing.wxgzh.model.goldtransfer.GoldTransferBean;
import com.xed.financing.wxgzh.model.goodsinfo.GoodsInfoBean;
import com.xed.financing.wxgzh.model.goodsorder.GoodsOrderBean;
import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.repaymentplan.RepaymentPlanBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.model.usercapital.UserCapitalBean;
import com.xed.financing.wxgzh.model.usercapitaldetail.UserCapitalDetailBean;
import com.xed.financing.wxgzh.model.usermessage.UserMessageBean;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.service.subject.SubjectServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月16日 上午11:04:46
 * @author:Qian Tao
 */
@Service
public  class SubjectServiceImpl implements SubjectService
{

	/**
	 * 标mapper
	 */
	@Resource
	private SubjectMapper subjectMapper;
	
	/**
	 * 金额mapper
	 */
	@Resource
	private CapitalMapper capitalMapper;
	
	/**
	 * 转让mapper
	 */
	@Resource
	private BondTransferMapper bondTransferMapper;
	
	/**
	 * 投标mapper
	 */
	@Resource
	private InvestRecordMapper investRecordMapper;
	
	/**
	 * 优惠券mapper
	 */
	@Resource
	private CouponMapper couponMapper;
	
	/**
	 * 积分mapper
	 */
	@Resource
	private AccountScoreMapper accountScoreMapper;
	
	/**
	 * 参数配置
	 */
	@Resource
	private ParamMapper paramMapper;
	
	/**
	 * 消息mapper
	 */
	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private AccountInfoMapper accountInfoMapper;
	
	@Resource
	private GoodsInfoMapper goodsInfoMapper;
	
	@Resource
	private GoodsOrderMapper goodsOrderMapper;
	
	@Autowired
	private AccountLevelService accountLevelService;
	
	@Autowired
	private AccountAddressMapper accountAddressMapper;
	
	@Autowired
	private UserCapitalMapper userCapitalMapper;
	
	@Autowired
	private GoldDetailsMapper goldDetailsMapper;
	@Autowired
	private UserCapitalDetailMapper userCapitalDetailMapper;
	@Autowired
	private UserMessageMapper userMessageMapper;
	@Autowired
	private RepaymentPlanMapper repaymentPlanMapper;
	@Autowired
	private GoldTransferMapper goldTransferMapper;
	private Logger logger = Logger.getLogger(SubjectServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.subject.SubjectService#querySubject(com.xed.financing.wxgzh.model.subject.SubjectBean)
	 */
	@Override
	public List<SubjectBean> querySubject(SubjectBean subjectBean) throws SQLException
	{
		return subjectMapper.querySubject(subjectBean);
	}
	
	@Override
	public List<SubjectBean> querySubjectLimit(SubjectBean subjectBean) throws SQLException
	{
		return subjectMapper.querySubjectLimit(subjectBean);
	}
	
	@Override
	public SubjectBean querySubjectById(SubjectBean subjectBean) throws SQLException
	{
		return subjectMapper.querySubjectById(subjectBean);
	}
	@Override
	@Transactional
	public void findSubject(String money,String id,String additionalId,String type,String accountId) 
	{
		try
		{
			//获取用户id
			String telephone= accountInfoMapper.getLoginAccountInfo(accountId).getTelephone();
			SubjectBean subjectBean = new SubjectBean();
			subjectBean.setSubjectId(id);
			
			//用户输入的投标金额
			double inputMoney = Double.parseDouble(money);
			
			//查看标的详情
			subjectBean = subjectMapper.querySubjectById(subjectBean);
			String goldMoney="0";
			//用户投入了本金  标的信息
			if(inputMoney>0)
			{
				//修改标表的信息
				subjectBean = editSubjectInfo(accountId,money,id,subjectBean);
				goldMoney=editCapitalInfo(money,subjectBean,accountId,telephone);
			}
			
			//添加投标表记录 返回（本金+优惠金额）
			double yMoney=addInvestInfo(inputMoney,additionalId,subjectBean,accountId,type,goldMoney);
			
			
			//添加资金明细
			addCapitalDetail(accountId,money,yMoney,additionalId);
			
			//如果投标投入了本金 则获取积分奖励  添加积分明细
			if(inputMoney>0)
			{
				//投标获取积分比率
				double ratioScore=Double.parseDouble(paramMapper.getParamVal("SUBJECT_SCORE"));
				double dscore=inputMoney*ratioScore;
				int rScore =0;
				if((dscore*10)%10==0)
				{
					rScore =(int)dscore;
				}
				else
				{
					rScore =(int)dscore+1;
				}
				AccountInfo accountInfo = accountScoreMapper.findScoreAndExp(accountId);
				accountInfo.setAccountExp(String.valueOf(Integer.valueOf(accountInfo.getAccountExp())+rScore));
				accountInfo.setAccountScore(String.valueOf(Integer.valueOf(accountInfo.getAccountScore())+rScore));
				//修改用户积分和经验 传参：用户信息Bean
				accountScoreMapper.changeScoreAndExp(accountInfo);
				
				//添加积分明细
				addScoreInfo(accountId, inputMoney);
	
			}
			
			//投标完成需要添加消息
			addMessageInfo(accountId, inputMoney, yMoney,additionalId);
			
			//XXX 金账户明细  借款人消息 借款人明细
		}
		catch (Exception e)
		{
 			logger.error("投标异常");
			throw new RuntimeException();
		}
		
	}
	@Override
	public List<SubjectBean> querySubjectAccount(SubjectBean subjectBean) throws SQLException
	{
		return subjectMapper.querySubjectAccount(subjectBean);
	}
	@Override
	public SubjectBean queryInvestMoney(SubjectBean subjectBean) throws SQLException
	{
		return subjectMapper.queryInvestMoney(subjectBean);
	}
	@Override
	public Integer countNewSubject(SubjectBean subjectBean) throws SQLException
	{
		return subjectMapper.countNewSubject(subjectBean);
	}

	/**
	 * 修改标的信息
	 * @Description:
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月12日 上午9:54:10
	 */
	private SubjectBean editSubjectInfo(String accountId,String money,String subjectId,SubjectBean subjectBean)throws SQLException
	{
			//投标标投标金额塞入
			subjectBean.setInvestMoney(MoneyUtils.changeYToF(money));
			
			//获取标的余额
			double overPlusMoney=Double.parseDouble(subjectBean.getSubjectOverplusMoney());
			
			//如果标余额大于0  可以投标                    
			if(overPlusMoney > 0)
			{
				//投标后的标余额
				double overMoney=overPlusMoney-Double.parseDouble(money);
				subjectBean.setSubjectOverplusMoney(MoneyUtils.changeDYToDF(overMoney));
				subjectBean.setEffectTime("");
				//标余额为0  表示满标
				if(overMoney == 0)
				{
					
					//标的状态(0:筹标中 1:已满标 2:满标复审 3:还款中 4:流标)
					subjectBean.setSubjectStatus(Constants.DEVIL_NUM_ONE);
					
					//天标
					if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectTerm()))
					{
						subjectBean.setFullTime("0");
					}
					
					//月标
					else if(Constants.DEVIL_NUM_ONE.equals(subjectBean.getSubjectTerm()))
					{
						subjectBean.setFullTime("1");
					}
					
					//年标
					else if(Constants.DEVIL_NUM_TWO.equals(subjectBean.getSubjectTerm()))
					{
						subjectBean.setFullTime("2");
					}
					
					//XXX 添加还款计划
					addRepaymentPlan(subjectBean);
					//XXX  借款人消息 mm_user_message  借款人资金明细
					//FullInvest(money, subjectBean);
				}
				
				//修改标的信息
				subjectMapper.updateSubjectInfo(subjectBean);
			}
		return subjectBean;
	}
	
	/**
	 * 添加投标记录
	 * @Description:
	 * @param inputMoney
	 * @param additionalId
	 * @param subjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月12日 上午10:57:23
	 */
	private double addInvestInfo(double inputMoney,String additionalId,SubjectBean subjectBean,String accountId,String type,String goldMoney) throws SQLException
	{
			double yMoney = inputMoney;
			//标的利率
			String subjectRate = subjectBean.getSubjectRate();
			Double vipRate = accountLevelService.LevelIncreaseInterest(accountId);
			subjectRate = String.valueOf(Double.parseDouble(subjectRate)+vipRate);
			subjectBean.setVipRate(String.valueOf(vipRate));
			subjectBean.setSubjectRate(String.valueOf(subjectRate));
			
			Double manageRate = accountLevelService.LevelInterestManagement(accountId);
			subjectBean.setExpenseRate(String.valueOf(manageRate));
			
			//利率百分比转成小数
			double subjectRateD = Double.parseDouble(subjectRate)/100;
			
			//用加息券后优惠利率
			double subjectRateY = subjectRateD;
			
			CouponBean couponBean = new CouponBean();
			//判断前端有没有选择优惠券
			if(!StringTools.isNullOrEmpty(additionalId))
			{
				
				couponBean.setAdditionalId(additionalId);
				couponBean.setAccountId(accountId);
				couponBean=couponMapper.queryCouponById(couponBean);
			
				//券类型(0:红包 1:加息券 2:体验金) 使用的现金抵扣
				if(!Constants.DEVIL_NUM_ONE.equals(couponBean.getCouponType()))
				{
					//加上现金红包 计算收益
					yMoney = inputMoney + Double.parseDouble(MoneyUtils.changeFToY(couponBean.getCouponMoney()));
					subjectBean.setRealMoney(couponBean.getCouponMoney());
				}
				else
				{
					//增加加息券利率
					subjectRateY = subjectRateD + Double.parseDouble(couponBean.getCouponMoney())/100;
					
					subjectBean.setSubjectRate(String.valueOf(subjectRateY*100));
				}
				couponBean.setSubjectId(subjectBean.getSubjectId());
				
			}
			
			//计算年化收益
			double yearMoney = yMoney*subjectRateY;
			subjectBean.setYearProfit(MoneyUtils.formatFloatNumber(yearMoney*100));
			
			//计算月化收益
			double monthMoney =yearMoney/12;
			subjectBean.setMonthProfit(MoneyUtils.formatFloatNumber(monthMoney*100));
			
			//投标状态(0:正常 1:标的正常结束 2:已转让债权)
			subjectBean.setInvestStatus(Constants.DEVIL_NUM_ZERO);
			subjectBean.setAccountId(accountId);
			subjectBean.setGoldInvestMoney(goldMoney);
			//天标 则按天收益
			if(subjectBean.getSubjectTerm().equals(Constants.DEVIL_NUM_ZERO))
			{
				subjectBean.setIsDayProfit(Constants.DEVIL_NUM_ONE);
			}
			else
			{
				subjectBean.setIsDayProfit(Constants.DEVIL_NUM_ZERO);
			}
			
			subjectBean.setEndTime(subjectBean.getSubjectTerm());
			//还款方式(0:等额本息 1:先息后本 2:到期还本还息)
			if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getRepeatType()) || Constants.DEVIL_NUM_ONE.equals(subjectBean.getRepeatType()))
			{
				subjectBean.setNextProfitTime("01");
			}
			else if(Constants.DEVIL_NUM_TWO.equals(subjectBean.getRepeatType()))
			{
				subjectBean.setNextProfitTime("2");
			}
			
			subjectMapper.addSubjectInvest(subjectBean);
			
			//不是投正常投标  投的标需要在award标里面插入一条记录
			if(!Constants.DEVIL_NUM_ZERO.equals(type))
			{
				//-----------------------------添加一条购买记录----------------------------------
				AccountAddressBean accountAddressBean=new AccountAddressBean();
				String color="";
				accountAddressBean.setAccountId(accountId);
				//investId直接塞成-2
				accountAddressBean.setInvestId(subjectBean.getInvestId());
				accountAddressBean.setIsDefault("0");
				accountAddressBean.setIsSend("0");
				accountAddressBean.setColor(type);
				accountAddressBean.setPackages("5");
				if(Constants.DEVIL_NUM_ONE.equals(type))
				{
					color="深空灰色";
				}
				else
				{
					color="银色";
				}
				accountAddressBean.setRemark("投资"+yMoney+"元3个月换购"+color+"iphoneX");
				accountAddressMapper.insertAccountAddress(accountAddressBean);
			}
			//如果使用优惠券  红包记录表增加investId
			if(!StringTools.isNullOrEmpty(additionalId))
			{
				couponBean.setInvestId(subjectBean.getInvestId());
				//标记优惠券已使用  并增加investId
				couponMapper.updateCouponStatus(couponBean);
			}
			
			//subjectBean =subjectMapper.querySubjectById(subjectBean);
			//标余额为0  表示满标
			if(Double.parseDouble(subjectBean.getSubjectOverplusMoney())==0)
			{
				InvestRecordBean investRecordBean = new InvestRecordBean();
				investRecordBean.setSubjectId(subjectBean.getSubjectId());
				investRecordBean.setSubjectPeriods(String.valueOf(subjectBean.getSubjectPeriods()));
				//满标的话需要将投标表满标时间
				//XXX 修改满标时间  结束时间  下一次收益时间
				//天标
				if(Constants.DEVIL_NUM_ZERO.equals(subjectBean.getSubjectTerm()))
				{
					investRecordBean.setFullTime("0");
				}
				
				//月标
				else if(Constants.DEVIL_NUM_ONE.equals(subjectBean.getSubjectTerm()))
				{
					investRecordBean.setFullTime("1");
				}
				
				//年标
				else if(Constants.DEVIL_NUM_TWO.equals(subjectBean.getSubjectTerm()))
				{
					investRecordBean.setFullTime("2");
				}
				investRecordMapper.updateSubjectFullTime(investRecordBean);
			}
			return yMoney;
		}
	
		/**
		 * 
		 * 修改用户金额
		 * @Description:
		 * @throws SQLException
		 * @version:v1.0
		 * @author:Qian Tao
		 * @date:2017年4月12日 上午11:00:00
		 */
		private String editCapitalInfo(String money,SubjectBean subjectBean,String accountId,String telephone)throws SQLException
		{
			//修改入参bean
			AccountCapital accountCapital=new AccountCapital();
			accountCapital.setAccountId(accountId);
			
			//查询bean
 			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			double yMoney = Double.parseDouble(money);
			//查询用户总金额
			capitalBean = capitalMapper.queryCapitalById(capitalBean);
			//用户投资总金额
			double iMoney = capitalBean.getInvestmentMoney(); 
			
			accountCapital.setInvestmentMoney(MoneyUtils.formatFloatNumber((iMoney+yMoney)*100));
			accountCapital.setFreezeMoney(MoneyUtils.formatFloatNumber(capitalBean.getFreezeMoney()*100));
			//用户可使用金额（可提现金额+金账户金额）
			double wMoney = capitalBean.getWithdrawMoney();
			double nwMoney = capitalBean.getNoWithdrawMoney();
			//金账户使用金额(分)
			String goldMoney="0";
			//可提现金额大于等于用户投标本金
			if(wMoney>=yMoney)
			{
				accountCapital.setWithdrawMoney(MoneyUtils.formatFloatNumbers((wMoney-yMoney)*100,0));
			}
			//可提现金额不为0且不够扣  可提现金额置为0 不可提现金额减去
			else
			{
				accountCapital.setWithdrawMoney(Constants.DEVIL_NUM_ZERO);
				accountCapital.setNoWithdrawMoney(MoneyUtils.formatFloatNumbers((nwMoney+wMoney-yMoney)*100,0));
				goldMoney=MoneyUtils.formatFloatNumbers((yMoney-wMoney)*100,0);
			}
			capitalMapper.editAccountCapitalById(accountCapital);
			return goldMoney;
		}
		
		/**
		 * 添加资金明细
		 * @Description:
		 * @param accountId
		 * @param yMoney
		 * @param id
		 * @param additionalId
		 * @throws SQLException
		 * @version:v1.0
		 * @author:Qian Tao
		 * @date:2017年4月12日 上午11:21:35
		 */
		private void addCapitalDetail(String accountId,String money,double yMoney,String additionalId)throws SQLException
		{
			CapitalDetail capitalDetail = new CapitalDetail();
			capitalDetail.setAccountId(accountId);
			capitalDetail.setMoney(MoneyUtils.changeYToF(money));
			
			//交易类型(0:储蓄卡充值 1:微信充值 2:信用卡充值 3:投资投标 4:投资投标收益 5:提现) 
			capitalDetail.setType(Constants.DEVIL_NUM_THREE);
			
			//金额收支(0:收入 1:支出)
			capitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
			double youMoney= 0.0;
			//是否使用优惠
			if(!StringTools.isNullOrEmpty(additionalId))
			{
				CouponBean couponBean = new CouponBean();
				couponBean.setAdditionalId(additionalId);
				couponBean.setAccountId(accountId);
				couponBean=couponMapper.queryCouponById(couponBean);
			
				//券类型(0:红包 1:加息券 2:体验金) 使用的现金抵扣
				if(!Constants.DEVIL_NUM_ONE.equals(couponBean.getCouponType()))
				{
					youMoney=Double.parseDouble(couponBean.getCouponMoney())/100;
					capitalDetail.setRemark("投标"+MoneyUtils.formatFloatNumber(yMoney)+"元(本金:"+money+"+优惠:"+youMoney+"元)");
				}
				else
				{
					capitalDetail.setRemark("投标"+MoneyUtils.formatFloatNumber(yMoney)+"元(本金:"+money+"+优惠利率:"+couponBean.getCouponMoney()+"%)");
				}
			}
			else
			{
				capitalDetail.setRemark("投标"+money+"元,暂未使用优惠券");
			}
			bondTransferMapper.addCapital(capitalDetail);
		}
		
		/**
		 * 添加积分明细
		 * @Description:
		 * @param accountId
		 * @throws SQLException
		 * @version:v1.0
		 * @author:Qian Tao
		 * @date:2017年4月18日 下午3:10:39
		 */
		private void addScoreInfo(String accountId,double money)throws SQLException
		{
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountId);
			
			//积分收支(0:收入 1:支出)
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ZERO);
			
			//积分类型(0:签到 1:完善信息 2:投标奖励 3:兑换积分 4:积分抽奖 5:购买积分 6:其他 7:积分退回)
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_TWO);
			double ratioScore=Double.parseDouble(paramMapper.getParamVal("SUBJECT_SCORE"));
			double dscore=money*ratioScore;
			int rScore =0;
			if((dscore*10)%10==0)
			{
				rScore =(int)dscore;
			}
			else
			{
				rScore =(int)dscore+1;
			}
			accountScoreBean.setScore(String.valueOf(rScore));
			accountScoreBean.setModReason("投标"+MoneyUtils.formatFloatNumber(money)+"元获取"+rScore+"鱼干");
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);
		}
		
		/**
		 * 添加消息
		 * @Description:
		 * @param accountId
		 * @param money
		 * @throws SQLException
		 * @version:v1.0
		 * @author:Qian Tao
		 * @date:2017年4月18日 下午3:48:06
		 */
		private void addMessageInfo(String accountId,double inputMoney,double allMoney,String additionalId)throws SQLException
		{
			//奖励积分
			int rScore =0;
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(accountId);
			messageBean.setMsgTitle("投标成功");
			if(inputMoney>0)
			{
				double ratioScore=Double.parseDouble(paramMapper.getParamVal("SUBJECT_SCORE"));
				double dscore=inputMoney*ratioScore;
				
				if((dscore*10)%10==0)
				{
					rScore =(int)dscore;
				}
				else
				{
					rScore =(int)dscore+1;
				}
			}
			if(!StringTools.isNullOrEmpty(additionalId))
			{
				CouponBean couponBean = new CouponBean();
				couponBean.setAdditionalId(additionalId);
				couponBean.setAccountId(accountId);
				couponBean=couponMapper.queryCouponById(couponBean);
				
				//加息券
				if(Constants.DEVIL_NUM_ONE.equals(couponBean.getCouponType()))
				{
					messageBean.setMsgContent("您的"+allMoney+"元(本金"+inputMoney+"+加息券"+(couponBean.getCouponMoney())+"%)投标成功！奖励鱼干"+rScore+"已到账,详情可至<a href='javascript:void(0)' onclick='goDetails(3)'>我的投资</a>查看");
				}
				else if(Constants.DEVIL_NUM_ZERO.equals(couponBean.getCouponType()))
				{
					messageBean.setMsgContent("您的"+allMoney+"元(本金"+inputMoney+"+增值券"+(allMoney-inputMoney)+"元)投标成功！奖励鱼干"+rScore+"已到账,详情可至<a href='javascript:void(0)' onclick='goDetails(3)'>我的投资</a>查看");
				}
				else if(Constants.DEVIL_NUM_TWO.equals(couponBean.getCouponType()))
				{
					messageBean.setMsgContent("您的"+allMoney+"元(本金"+inputMoney+"+体验金"+(allMoney-inputMoney)+"元)投标成功！奖励鱼干"+rScore+"已到账,详情可至<a href='javascript:void(0)' onclick='goDetails(3)'>我的投资</a>查看");
				}
			}
			else
			{
				messageBean.setMsgContent("您的"+allMoney+"元投标成功！奖励鱼干"+rScore+"已到账,详情可至<a href='javascript:void(0)' onclick='goDetails(3)'>我的投资</a>查看");
			}
			messageMapper.addMessageInfo(messageBean);
		}
		@Override
		public List<SubjectBean> queryHotSubject(SubjectBean subjectBean) throws SQLException
		{
			return subjectMapper.queryHotSubject(subjectBean);
		}
		@Override
		public SubjectBean queryHotSubjectById(SubjectBean subjectBean) throws SQLException
		{
			return subjectMapper.queryHotSubjectById(subjectBean);
		}
		@Override
		@Transactional
		public void convertHotGoods(SubjectBean subjectBean,GoodsInfoBean goodsInfoBean,GoodsOrderBean goodsOrderBean,AccountInfo accountInfo) 
		{
			try
			{
				double inputMoney =Integer.parseInt(goodsOrderBean.getGoodsMoney());
				
				subjectBean = subjectMapper.queryHotSubjectById(subjectBean);
				subjectBean.setSubjectRate("0");
				//0.修改标的信息
				subjectBean = editSubjectInfo(accountInfo.getAccountId(),goodsOrderBean.getGoodsMoney(),subjectBean.getSubjectId(),subjectBean);
				
				//1.修改商品表数量
				//查询商品剩余数量
				goodsInfoBean = goodsInfoMapper.queryGoodsInfoById(goodsInfoBean);
				//判断剩余数量是否和售出数量一致
				if(goodsInfoBean.getRealStock().equals(goodsOrderBean.getGoodsNum())){
					//商品售完后更新状态为下架
					goodsInfoBean.setStatus(Constants.DEVIL_NUM_ONE);
				}
				
				//更新货物数量
				String realStock=String.valueOf(Integer.parseInt(goodsInfoBean.getRealStock()) - Integer.parseInt(goodsOrderBean.getGoodsNum()));
				goodsInfoBean.setRealStock(realStock);
				//更新商品信息
				goodsInfoMapper.updateGoodsInfo(goodsInfoBean);
				
				
				//2  爆款商品表库存也需要相应减少
				subjectBean.setRealStock(String.valueOf(Integer.parseInt(subjectBean.getRealStock()) - Integer.parseInt(goodsOrderBean.getGoodsNum())));
				subjectMapper.updateHotSubjectGoodsStock(subjectBean);
				
				//3.添加订单表信息  *****************subjectName没取到
				goodsOrderBean.setAccountId(accountInfo.getAccountId());
				goodsOrderBean.setRemark("用户:" + accountInfo.getAccountName() +"使用"+goodsOrderBean.getGoodsMoney()+"元投爆款标：" + subjectBean.getSubjectName() + "，成功兑换"+goodsOrderBean.getGoodsNum()+"件" + goodsInfoBean.getGoodsName());
				//爆款标金额元转分
				goodsOrderBean.setGoodsMoney(MoneyUtils.changeYToF(goodsOrderBean.getGoodsMoney()));
				goodsOrderMapper.insertGoodsOrderBean(goodsOrderBean);
				
				//3.修改个人积分信息  ********************增加积分  考虑等级增长问题
				
				//投标获取积分比率
				double ratioScore=Double.parseDouble(paramMapper.getParamVal("SUBJECT_SCORE"));
				int rScore =(int)(inputMoney*ratioScore);
				AccountInfo userBean = accountScoreMapper.findScoreAndExp(accountInfo.getAccountId());
				userBean.setAccountExp(String.valueOf(Integer.valueOf(accountInfo.getAccountExp())+rScore));
				userBean.setAccountScore(String.valueOf(Integer.valueOf(accountInfo.getAccountScore())+rScore));
				//修改用户积分和经验 传参：用户信息Bean
				accountScoreMapper.changeScoreAndExp(userBean);
				
				//添加积分明细
				addScoreInfo(accountInfo.getAccountId(), inputMoney);
				
				//5.发送消息 *************subjectName没有取到
				MessageBean messageBean =new MessageBean();
				messageBean.setAccountId(accountInfo.getAccountId());
				messageBean.setMsgTitle("爆款标兑换成功");
				messageBean.setMsgContent("您投的"+subjectBean.getSubjectName()+"爆款标兑换 " +goodsOrderBean.getGoodsNum()+"件"+ goodsInfoBean.getGoodsName() + "兑换成功！");
				messageMapper.addMessageInfo(messageBean);
				
				//6 资金总表变动
				editCapitalInfo(String.valueOf(inputMoney), subjectBean, accountInfo.getAccountId(),accountInfo.getTelephone());
				
				//7 资金明细表
				addCapitalDetail(accountInfo.getAccountId(), String.valueOf(inputMoney), inputMoney, null);
				
				//8 投资记录表插入数据 因为是兑换实物  所以投标了满标时间就有了
				subjectBean.setInvestStatus(Constants.DEVIL_NUM_ZERO);
				subjectBean.setAccountId(accountInfo.getAccountId());
				subjectBean.setInvestMoney(goodsOrderBean.getGoodsMoney());
				subjectBean.setFullTime("1");
				subjectMapper.addSubjectInvest(subjectBean);
			}
			catch (Exception e)
			{
	 			logger.error("爆款实物兑换异常");
				throw new RuntimeException();
			}
		}
		@Override
		public List<SubjectBean> queryFontPageSubject(SubjectBean subjectBean) throws SQLException
		{
			return subjectMapper.queryFontPageSubject(subjectBean);
		}
		@Override
		public List<SubjectBean> queryFontHotSubject(SubjectBean subjectBean) throws SQLException
		{
			return subjectMapper.queryFontHotSubject(subjectBean);
		}
		@Override
		public SubjectBean countNextSubject(SubjectBean subjectBean) throws SQLException
		{
			return subjectMapper.countNextSubject(subjectBean);
		}
		@Override
		public List<SubjectBean> queryNextSubject(SubjectBean subjectBean) throws SQLException
		{
			return subjectMapper.queryNextSubject(subjectBean);
		}
		
		@Override
		public List<SubjectBean> queryFontNextSubject(SubjectBean subjectBean) throws SQLException
		{	
			return subjectMapper.queryFontNextSubject(subjectBean);
		}
		@Override
		public Integer countCompanySubject(SubjectBean subjectBean) throws SQLException
		{
			return subjectMapper.countCompanySubject(subjectBean);
		}
		@Override
		public List<SubjectBean> querySubjectCoupon(SubjectBean subjectBean) throws SQLException
		{
			return subjectMapper.querySubjectCoupon(subjectBean);
		}
		@Override
		public Integer countIsGetAward(SubjectBean subjectBean) throws SQLException
		{
			return subjectMapper.countIsGetAward(subjectBean);
		}
		@Override
		public void addAwardRecord(SubjectBean subjectBean) throws SQLException
		{
			// TODO Auto-generated method stub
			subjectMapper.addAwardRecord(subjectBean);
		}
		@Override
		public SubjectBean queryAwardById(SubjectBean subjectBean) throws SQLException
		{
			// TODO Auto-generated method stub
			return subjectMapper.queryAwardById(subjectBean);
		}
		@Override
		public Integer countElevenSubject(SubjectBean subjectBean) throws SQLException
		{
			// TODO Auto-generated method stub
			return subjectMapper.countElevenSubject(subjectBean);
		}
		@Override
		public SubjectBean querySumElevenMoney(SubjectBean subjectBean) throws SQLException
		{
			// TODO Auto-generated method stub
			return subjectMapper.querySumElevenMoney(subjectBean);
		}
		@Override
		public Integer queryTodayInvestAllMoney(SubjectBean subjectBean) throws SQLException
		{
			// TODO Auto-generated method stub
			return subjectMapper.queryTodayInvestAllMoney(subjectBean);
		}
		@Override
		public Integer countTwelveActivity(SubjectBean subjectBean) throws SQLException
		{
			// TODO Auto-generated method stub
			return subjectMapper.countTwelveActivity(subjectBean);
		}
		@Override
		public Integer countInvestBetweenTime(SubjectBean subjectBean) throws SQLException
		{
			// TODO Auto-generated method stub
			return subjectMapper.countInvestBetweenTime(subjectBean);
		}
		
		//正常投资  金账户转账成功后
		private void commonInvest(Map<String, String> repayMap,String investMoney,SubjectBean subjectBean,String telephone,String transferType,String allMoney) throws SQLException
		{
			//金账户转账成功
			if("0000".equals(repayMap.get("resp_code")))
			{
				//修改借款人金账户金额
				UserCapitalBean userCapital = userCapitalMapper.queryUserCapital(subjectBean.getTelephone());
				String userBalance = userCapital.getBalance();
				//修改账户信息
				userBalance = String.valueOf(Integer.parseInt(userBalance)+(Integer.parseInt(investMoney)*100));
				userCapital.setBalance(String.valueOf(userBalance));
				userCapitalMapper.updateUserCapital(userCapital);
				//金账户明细
				GoldDetailsBean goldDetailsBean = new GoldDetailsBean();
				goldDetailsBean.setInCustNo(subjectBean.getTelephone());
				goldDetailsBean.setOutCustNo(telephone);
				goldDetailsBean.setMoney(MoneyUtils.changeYToF(investMoney));
				goldDetailsBean.setTransferType(transferType);
				goldDetailsBean.setPurpose("1");
				if("2".equals(transferType))
				{
					goldDetailsBean.setOutCustNo(paramMapper.getParamVal("JZH_SHOP"));
					goldDetailsBean.setRemark("投资人:"+telephone+"向借款人:"+subjectBean.getTelephone()+"转账"+investMoney+"元，由商户:"+paramMapper.getParamVal("JZH_SHOP")+"垫付");
					
					//借款人资金明细   如果是可用余额不够 吊两次接口  但是借款人只需一条资金明细
					UserCapitalDetailBean userCapitalDetailBean = new UserCapitalDetailBean();
					userCapitalDetailBean.setUserId(subjectBean.getUserId());
					userCapitalDetailBean.setMoney(MoneyUtils.changeYToF(allMoney));
					userCapitalDetailBean.setType("1");
					userCapitalDetailBean.setInExpend("0");
					userCapitalDetailBean.setRemark("投资人"+telephone+"借款"+allMoney+"元，由商户:"+paramMapper.getParamVal("JZH_SHOP")+"垫付:"+(Integer.parseInt(allMoney)-Integer.parseInt(investMoney))+"元");
					userCapitalDetailBean.setIsShow("1");
					userCapitalDetailMapper.addUserCapitalDetail(userCapitalDetailBean);
				}
				else
				{
					goldDetailsBean.setRemark("投资人:"+telephone+"向借款人:"+subjectBean.getTelephone()+"转账"+investMoney+"元");
				}
				goldDetailsMapper.addGoldDetail(goldDetailsBean);
				
				
			}
		}
		
		//最后一笔投资满标后操作
		private void FullInvest(String investMoney,SubjectBean subjectBean) throws SQLException
		{
			//借款人资金明细
			UserCapitalDetailBean userCapitalDetailBean = new UserCapitalDetailBean();
			userCapitalDetailBean.setUserId(subjectBean.getUserId());
			userCapitalDetailBean.setMoney(MoneyUtils.changeYToF(investMoney));
			userCapitalDetailBean.setType("2");
			userCapitalDetailBean.setInExpend("0");
			userCapitalDetailBean.setRemark("成功获得借款"+subjectBean.getSubjectMoney()+"元");
			userCapitalDetailBean.setIsShow("0");
			userCapitalDetailMapper.addUserCapitalDetail(userCapitalDetailBean);
			
			//借款人消息表
			UserMessageBean userMessageBean=new UserMessageBean();
			userMessageBean.setUserId((subjectBean.getUserId()));
			userMessageBean.setMsgTitle("借款成功");
			userMessageBean.setMsgContent("您发起的"+subjectBean.getSubjectMoney()+"元现已筹借成功，借款编号："+subjectBean.getSubjectCode());
			userMessageMapper.addUserMessage(userMessageBean);
		}
		
		//添加还款计划
		private void addRepaymentPlan(SubjectBean subjectBean)throws SQLException
		{
			String nowTime=paramMapper.getCurrentTime().getNowHours();
			//借款金额(分)=借款金额(元)*100
			String loanMoney=MoneyUtils.formatFloatNumber(Double.valueOf(subjectBean.getSubjectMoney())*100);
			loanMoney = loanMoney.substring(0, loanMoney.indexOf("."));
			
			//标的期限
			Integer loanPeriods=Integer.valueOf(subjectBean.getSubjectPeriods());
			
			//借款利率=借款利率(%)/100
			String loanRate=String.valueOf(Double.valueOf(subjectBean.getRepaymentRate())/100);
			
			//借款申请id
			RepaymentPlanBean repaymentPlanBean=new RepaymentPlanBean();
			repaymentPlanBean.setSubjectId(subjectBean.getSubjectId());
			
			if(!("2".equals(subjectBean.getRepeatType()))){
				//应还本金(分)=借款金额/标的期限
				String backPrincipal= "0.0";
				if("0".equals(subjectBean.getRepeatType())){
					backPrincipal= MoneyUtils.formatFloatNumber((Double.parseDouble(loanMoney))/(loanPeriods));
				}
				backPrincipal =  backPrincipal.substring(0, backPrincipal.indexOf("."));
				
				//剩余金额(分)
				String surplus = loanMoney;
				
				//应还利息 =剩余金额*贷款利率
				String interest = MoneyUtils.formatFloatNumber(Double.parseDouble(loanMoney)*Double.parseDouble(loanRate)/12);
				interest = interest.substring(0, interest.indexOf("."));
				
				for (int i = 0; i < loanPeriods; i++)
				{
					//应还时间
					String backTime=DateUtils.GetSysDate("yyyy-MM-dd HH:mm:ss", nowTime, 0, i+1, -1);
					repaymentPlanBean.setBackTime(backTime);
					
					//最后一期
					if(i+1==loanPeriods){
						//应还本金=剩余本金
						backPrincipal = surplus;
					}
					
					//应还利息
					repaymentPlanBean.setBackInterest(interest);
					
					//应还总额=应还本金+应还利息
					repaymentPlanBean.setBackMoney(String.valueOf(Integer.parseInt(backPrincipal)+Integer.parseInt(interest)));
					
					//待还总额=应还总额
					repaymentPlanBean.setPendingMoney(String.valueOf(Integer.parseInt(backPrincipal)+Integer.parseInt(interest)));
					
					//应还本金
					repaymentPlanBean.setBackPrincipal(backPrincipal);
					
					//执行回款记录添加方法
					repaymentPlanMapper.addRepayPlanRecord(repaymentPlanBean);
					
					//剩余金额=剩余金额-应还本金
					surplus = String.valueOf(Integer.parseInt(surplus)-Integer.parseInt(backPrincipal));
					
				}
				
			}else{
				//到期还本付息
				
				//期限为天
				if("0".equals(subjectBean.getSubjectTerm())){
					//应还时间
					String backTime=DateUtils.GetSysDate("yyyy-MM-dd HH:mm:ss", nowTime, 0, 0, loanPeriods-1);
					repaymentPlanBean.setBackTime(backTime);
					
				}else{
					
					//应还时间
					String backTime=DateUtils.GetSysDate("yyyy-MM-dd HH:mm:ss", nowTime, 0, loanPeriods, -1);
					repaymentPlanBean.setBackTime(backTime);
					
				}

				//应还本金
				repaymentPlanBean.setBackPrincipal(loanMoney);
				
				//应还利息(分)=借款金额*贷款利率
				double backInterest=Double.parseDouble(loanMoney)*Double.parseDouble(loanRate)*loanPeriods/365;
				repaymentPlanBean.setBackInterest(MoneyUtils.formatFloatNumber(backInterest));
				
				//应还总额=应还本金+应还利息
				double backMoney=Double.parseDouble(loanMoney)+backInterest;
				repaymentPlanBean.setBackMoney(MoneyUtils.formatFloatNumber(backMoney));
				
				//待还总额=应还总额
				repaymentPlanBean.setPendingMoney(MoneyUtils.formatFloatNumber(backMoney));
				
				//执行回款记录添加方法
				repaymentPlanMapper.addRepayPlanRecord(repaymentPlanBean);
			}
		}
		
		//添加接口调用明细
		private void addGoldTransfer(Map<String, String> repayMap,String outCustNo,String inCustNo)throws SQLException
		{
			GoldTransferBean goldTransferBean=new GoldTransferBean();
			goldTransferBean.setMchntCd(repayMap.get("mchnt_cd"));
			goldTransferBean.setMchntTxnSsn(repayMap.get("mchnt_txn_ssn"));
			goldTransferBean.setSignature(repayMap.toString());
			goldTransferBean.setInCustNo(inCustNo);
			goldTransferBean.setOutCustNo(outCustNo);
			goldTransferBean.setRespCode(repayMap.get("resp_code"));
			goldTransferMapper.addGoldTransfer(goldTransferBean);
		}
		@Override
		public List<SubjectBean> rich(SubjectBean subjectBean) throws SQLException
		{
			// TODO Auto-generated method stub
			return subjectMapper.rich(subjectBean);
		}
		@Override
		public List<SubjectBean> connection(SubjectBean subjectBean) throws SQLException
		{
			// TODO Auto-generated method stub
			return subjectMapper.connection(subjectBean);
		}

		@Override
		public void updateAward(SubjectBean subjectBean) throws SQLException
		{
			// TODO Auto-generated method stub
			subjectMapper.updateAward(subjectBean);
		}

		@Override
		public List<SubjectBean> queryAwardList(SubjectBean subjectBean) throws SQLException
		{
			return subjectMapper.queryAwardList(subjectBean);
		}
} 
