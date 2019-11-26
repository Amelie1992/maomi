/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.crowdfund.impl.CrowdfundServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月20日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.crowdfund.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.crowdfund.CrowdfundMapper;
import com.xed.financing.wxgzh.mapper.goldDetails.GoldDetailsMapper;
import com.xed.financing.wxgzh.mapper.goldtransfer.GoldTransferMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.mapper.profitreturn.ProfitReturnMapper;
import com.xed.financing.wxgzh.mapper.revenueSettlement.RevenueSettlementMapper;
import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean;
import com.xed.financing.wxgzh.model.golddetails.GoldDetailsBean;
import com.xed.financing.wxgzh.model.goldtransfer.GoldTransferBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.profitreturn.ProfitReturnBean;
import com.xed.financing.wxgzh.service.crowdfund.CrowdfundService;
import com.xed.financing.wxgzh.service.fuiou.FuiouService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * @className:com.xed.financing.wxgzh.service.crowdfund.impl.CrowdfundServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月20日 下午4:26:05
 * @author:QT
 */
@Service
public class CrowdfundServiceImpl implements CrowdfundService
{
	
	@Resource
	private CrowdfundMapper crowdfundMapper;
	
	@Resource
	private CapitalMapper capitalMapper;
	
	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private BondTransferMapper bondTransferMapper;
	
	@Resource
	private RevenueSettlementMapper revenueSettlementMapper;
	
	@Resource
	private GoldDetailsMapper goldDetailsMapper;
	
	@Resource
	private GoldTransferMapper goldTransferMapper;
	
	@Resource
	private	ParamMapper paramMapper;
	
	@Resource
	private ProfitReturnMapper profitReturnMapper;
	
	@Resource
	private AccountInfoMapper accountInfoMapper;
	
	@Autowired
	private FuiouService fuiouService;
	
	private Logger logger = Logger.getLogger(CrowdfundServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.crowdfund.CrowdfundService#queryCrowfundList(com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean)
	 */
	@Override
	public List<CrowdfundBean> queryCrowfundList(CrowdfundBean crowdfundBean) throws SQLException
	{
		return crowdfundMapper.queryCrowfundList(crowdfundBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.crowdfund.CrowdfundService#countCrowfund(com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean)
	 */
	@Override
	public Integer countCrowfund(CrowdfundBean crowdfundBean) throws SQLException
	{
		return crowdfundMapper.countCrowfund(crowdfundBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.crowdfund.CrowdfundService#queryCrowfundById(com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean)
	 */
	@Override
	public CrowdfundBean queryCrowfundById(CrowdfundBean crowdfundBean) throws SQLException
	{
		return crowdfundMapper.queryCrowfundById(crowdfundBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.crowdfund.CrowdfundService#addCrowdfundingRecord(com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean)
	 */
	@Override
	@Transactional
	public void addCrowdfundingRecord(CrowdfundBean crowdfundBean,String accountId,int nums,String telephone)
	{
		try
		{
			//用户花费金额
			double inputMoney=nums*Integer.parseInt(crowdfundBean.getEachMoney());
			
			//单笔众筹金额（分）
			double eachMoney=Double.parseDouble(crowdfundBean.getEachMoney())*100;
			
			//众筹已经投了多少笔
			int counts=crowdfundMapper.countCrowdfundingRecordById(crowdfundBean);
			
			//众筹总笔数
			int maxNum=Integer.parseInt(crowdfundBean.getMaxEach());
			
			//金账户使用金额（分）
			double crowdGoldInvestMoney=0;
			
			//------------------------------判断是否满标 如果满标 状态crowdStatus置为2---------------------------------
			if(nums>=(maxNum-counts))
			{
				//（0未开始 1拼团开始  2拼团满标 3拼团时间结束 4拼团失败 5众筹结束 ）
				crowdfundBean.setCrowdStatus(Constants.DEVIL_NUM_TWO);
				crowdfundMapper.editCrowdfundingById(crowdfundBean);
			}
			//------------------------------扣除资金.---------------------------------
			crowdGoldInvestMoney=editCapitalInfo(inputMoney, accountId,telephone);
			
			//------------------------------添加记录---------------------------------
			String num="";
			List<CrowdfundBean> listBean=new ArrayList<CrowdfundBean>();
			//判断使用金账户金额购买了几笔
			int per=0;
			//单笔众筹使用金账户金额
			double overplusGold=0;
			//塞入编号
			for (int i = 0; i < nums; i++)
			{
				per=(int) (crowdGoldInvestMoney/eachMoney);
				overplusGold=crowdGoldInvestMoney%eachMoney;
				
				//编号按照最大的自增
				int c=crowdfundMapper.countCrowdfundingRecordById(crowdfundBean);
				num=String.valueOf(c+1+i);
				
				if(per>0)
				{
					listBean.add(new CrowdfundBean(crowdfundBean.getCrowdId(), accountId, num,MoneyUtils.changeYToF(crowdfundBean.getEachMoney())));
					crowdGoldInvestMoney=crowdGoldInvestMoney-eachMoney;
				}
				else if(overplusGold>0)
				{
					listBean.add(new CrowdfundBean(crowdfundBean.getCrowdId(), accountId, num,MoneyUtils.formatFloatNumbers(overplusGold, 0)));
					crowdGoldInvestMoney=0;
				}
				else
				{
					listBean.add(new CrowdfundBean(crowdfundBean.getCrowdId(), accountId, num,"0"));
				}
				
			}
			crowdfundMapper.addCrowdfundingRecord(listBean);
			
			
			
			//------------------------------资金明细---------------------------------
			CapitalDetail capitalDetail = new CapitalDetail();
			capitalDetail.setAccountId(accountId);
			capitalDetail.setMoney(MoneyUtils.formatFloatNumber(inputMoney*100));
			
			//(0:储蓄卡充值 1:微信充值 2:信用卡充值 3:投资投标 4:投资投标收益 5:提现 6:债权转出 7:债权承接,8:退款 9:投资本金结算 10:活动获取 11:购买鱼干 12猫咪宝转入 13猫咪宝转出 14:猫咪宝收益 15:猫咪宝提现 16:工资发放 17:邀请好友奖励 18众筹)
			capitalDetail.setType(Constants.DEVIL_NUM_EIGHTTEN);
			
			//金额收支(0:收入 1:支出)
			capitalDetail.setInExpend(Constants.DEVIL_NUM_ONE);
			
			capitalDetail.setRemark("众筹编号："+crowdfundBean.getCrowdId()+"投了"+nums+"笔共花费"+inputMoney+"元");
			bondTransferMapper.addCapital(capitalDetail);
			
			//------------------------------添加消息---------------------------------
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(accountId);
			messageBean.setMsgTitle("参与众筹成功");
			messageBean.setMsgContent("成功参与众筹编号："+crowdfundBean.getCrowdId()+"，用户总计选择"+nums+"笔共花费"+inputMoney+"元");
			messageMapper.addMessageInfo(messageBean);
		}
		catch(Exception e)
		{
			logger.error("投众筹异常");
			throw new RuntimeException();
		}
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.crowdfund.CrowdfundService#countCrowdfundingRecordById(com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean)
	 */
	@Override
	public Integer countCrowdfundingRecordById(CrowdfundBean crowdfundBean) throws SQLException
	{
		return crowdfundMapper.countCrowdfundingRecordById(crowdfundBean);
	}

	private double editCapitalInfo(double yMoney,String accountId,String telephone)throws SQLException
	{
		String investMoney=MoneyUtils.formatFloatNumbers(yMoney,0);
		//修改入参bean
		AccountCapital accountCapital=new AccountCapital();
		accountCapital.setAccountId(accountId);
		
		//查询bean
		CapitalBean capitalBean = new CapitalBean();
		capitalBean.setAccountId(accountId);
		//查询用户总金额
		capitalBean = capitalMapper.queryCapitalById(capitalBean);
		//用户投资总金额
		double iMoney = capitalBean.getInvestmentMoney(); 
		
		accountCapital.setInvestmentMoney(MoneyUtils.formatFloatNumber((iMoney+yMoney)*100));
		accountCapital.setFreezeMoney(MoneyUtils.formatFloatNumber(capitalBean.getFreezeMoney()*100));
		//用户可使用金额（可提现金额+金账户金额）
		double wMoney = capitalBean.getWithdrawMoney();
		double nwMoney = capitalBean.getNoWithdrawMoney();
		Map<String, String> repayMap =new HashMap<String, String>();
		String companyInfo=paramMapper.getParamVal("JZH_SHOP");
		//金账户使用金额(分)
		double crowdGoldInvestMoney=0;
		//可提现金额大于等于用户投标本金
		if(wMoney>=yMoney)
		{
			accountCapital.setWithdrawMoney(MoneyUtils.formatFloatNumbers((wMoney-yMoney)*100,0));
			
		}
		//可提现金额不够扣  可提现金额置为0 金账户金额减去
		else
		{
			accountCapital.setWithdrawMoney(Constants.DEVIL_NUM_ZERO);
			accountCapital.setNoWithdrawMoney(MoneyUtils.formatFloatNumbers((nwMoney+wMoney-yMoney)*100,0));
			crowdGoldInvestMoney=(yMoney-wMoney)*100;
			//XXX 用户转账给公司账户
			//repayMap=InterfaceUtil.shopToCust(telephone, companyInfo, MoneyUtils.formatFloatNumbers((yMoney-wMoney)*100,0));
			//addGoldTransfer(repayMap, telephone, companyInfo);
			//commonInvest(repayMap, MoneyUtils.formatFloatNumbers((yMoney-wMoney),0), companyInfo, telephone,investMoney);
		}
		capitalMapper.editAccountCapitalById(accountCapital);
		return crowdGoldInvestMoney;
	}

	@Override
	public List<CrowdfundBean> queryCrowfundListByStatus(CrowdfundBean crowdfundBean) throws SQLException
	{
		return crowdfundMapper.queryCrowfundListByStatus(crowdfundBean);
	}

	@Override
	public Integer startCrowdfund() throws SQLException
	{
		List<CrowdfundBean> rspList=null;
		CrowdfundBean crowdfundBean=new CrowdfundBean();
		//----------------查询是否上架的众筹------------------
		//众筹状态（0未开始 1拼团开始 2拼团满标 3拼团时间结束 4拼团失败 5众筹结束 ）
		crowdfundBean.setCrowdStatus(Constants.DEVIL_NUM_ZERO);
		crowdfundBean.setBeginDate("1");
		rspList=crowdfundMapper.queryCrowfundListByStatus(crowdfundBean);
		if(rspList!=null && rspList.size()>0)
		{
			for (CrowdfundBean cBean : rspList)
			{
				cBean.setCrowdStatus(Constants.DEVIL_NUM_ONE);
				crowdfundMapper.editCrowdfundingById(cBean);
			}
		}
		return rspList.size();
	}

	@Override
	@Transactional
	public void froupCrowdfund() throws SQLException
	{
		try
		{
			List<CrowdfundBean> rspList=null;
			CrowdfundBean crowdfundBean=new CrowdfundBean();
			//----------------查询是否上架的众筹------------------
			//众筹状态众筹状态（0未开始 1拼团开始 2拼团满标 3拼团结束 4拼团失败 5拼团成功 6众筹结束 ）
			//crowdfundBean.setCrowdStatus("3");
			crowdfundBean.setGroupDate("1");
			rspList=crowdfundMapper.queryCrowfundListByStatus(crowdfundBean);
			if(rspList!=null && rspList.size()>0)
			{
				for (CrowdfundBean cBean : rspList)
				{
					//计算活动周期收益
					//查询该众筹投了几次
					int count=crowdfundMapper.countCrowdfundingRecordById(cBean);
					cBean=crowdfundMapper.queryCrowfundById(cBean);
					//利率
					//double rate=Double.parseDouble(cBean.getCrowdRate())/100;
					//活动周期单份收益
					//double profit=rate*Double.parseDouble(cBean.getEachMoney())*Double.parseDouble(cBean.getActivityDay())/365;
					//奖品理论发放数量（带小数）
					//double stocks=profit*count/Double.parseDouble(cBean.getSaleMoney());
					double crowdMoney = Double.parseDouble(cBean.getCrowdMoney());
					double maxEach = Double.parseDouble(cBean.getMaxEach());
					double minEach = Double.parseDouble(cBean.getMinEach());
					
					//众筹失败   
					if(count < minEach)
					{
						//修改状态	
						cBean.setCrowdStatus(Constants.DEVIL_NUM_FOUR);
						crowdfundMapper.editCrowdfundingById(cBean);
						cBean.setIsWinning("2");
						crowdfundMapper.editCrowdfundingRecord(cBean);
					}
					//众筹成功
					else
					{
						//修改状态	
						cBean.setCrowdStatus(Constants.DEVIL_NUM_FIVE);
						crowdfundMapper.editCrowdfundingById(cBean);
						//修改所有未中奖
						cBean.setIsWinning("0");
						crowdfundMapper.editCrowdfundingRecord(cBean);
						//向下取整  获得实际数量  奖品数量    投资数量*单份金额/档位=商品最小数量
						int rewardStock=(int) Math.floor(count*Double.parseDouble(cBean.getEachMoney())/Double.parseDouble(cBean.getCrowdGrade()));
						//公益金额 公益金额暂定为0
						//double welfareMoney=(stocks-rewardStock)*Double.parseDouble(cBean.getGoodsMoney());
						double welfareMoney=0.0;
						int a;
						//生成中奖号码 
						List<String> arr= new ArrayList<String>();
						for (int i = 0; i < rewardStock; i++)
						{
							a=new Random().nextInt(count)+1;
							if(arr.contains(String.valueOf(a))){
								i--;
								continue;
							}
							arr.add(String.valueOf(a));
						}
						for (int i = 0; i < arr.size(); i++)
						{
							//修改状态  arr[i]即为中奖号
							cBean.setIsWinning("1");
							cBean.setCrowdNum(String.valueOf(arr.get(i)));
							crowdfundMapper.editCrowdfundingRecord(cBean);
						}
						Map<String, Object> winning = new HashMap<String, Object>();
						winning.put("arr", arr);
						winning.put("crowdId", cBean.getCrowdId());
						List<CrowdfundBean> winningUser =  crowdfundMapper.getWinningUser(winning);
						for (int i = 0; i < winningUser.size(); i++)
						{
							// 发送消息
							MessageBean outMessageBean = new MessageBean();
							outMessageBean.setAccountId(winningUser.get(i).getAccountId());
							outMessageBean.setMsgTitle("众筹中奖通知");
							outMessageBean.setMsgContent("恭喜您参与"+cBean.getCrowdName()+"中奖啦，将获得"+cBean.getGoodsName()+" "+winningUser.get(i).getCrowdfundCount()+"份，记得去<a href='javascript:void(0)' onclick='goDetails(10)'>收货地址</a>填写您的地址，以免耽误您领取奖励时间");
							messageMapper.addMessageInfo(outMessageBean);
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException();
		}
		
	}

	@Override
	@Transactional
	public void endCrowdfund() throws Exception
	{
		try
		{
			List<CrowdfundBean> rspList=null;
			CrowdfundBean crowdfundBean=new CrowdfundBean();
			//----------------查询是否上架的众筹------------------
			//众筹状态众筹状态（0未开始 1拼团开始 2拼团满标 3拼团结束 4拼团失败 5拼团成功 6众筹结束 ）
			//crowdfundBean.setCrowdStatus("3");
			crowdfundBean.setEndDate("1");
			rspList=crowdfundMapper.queryCrowfundListByStatus(crowdfundBean);
			if(rspList!=null && rspList.size()>0)
			{
				for (CrowdfundBean cBean : rspList)
				{
					// 查询该众筹，众筹人和对应的份数
					List<CrowdfundBean> users = crowdfundMapper.findCrowdfundCount(cBean.getCrowdId());
					
					for (CrowdfundBean user : users)
					{
						//获取每一笔众筹筹团结束前的天数
						user.setCrowdId(cBean.getCrowdId());
						List<CrowdfundBean> userRecord = crowdfundMapper.selCrowdfundingRecord(user);
						Integer countDay = 0;
						for (int i = 0; i < userRecord.size(); i++)
						{
							countDay += DateUtils.daysBetween(cBean.getGroupDate(),userRecord.get(i).getCrowdDate());
						}
						//计算筹团结束前的收益 = 利率 * 每份金额 / 365 * 天数
						Double comes = countDay * Integer.parseInt(cBean.getEachMoney()) * Double.parseDouble(cBean.getCrowdRate())/100/365.0;
						
						//判断是拼团成功还是失败
						//失败的返回所有收益 和本金
						/*if("4".equals(cBean.getCrowdStatus()))
						{*/
							//众筹期间收益 = 每份金额 * 利率 / 365 * 份数 * 天数
							comes += Integer.parseInt(cBean.getEachMoney()) * Double.parseDouble(cBean.getCrowdRate())/100 / 365.0 * Integer.parseInt(user.getCrowdfundCount()) * Integer.parseInt(cBean.getActivityDay());
						/*}*/
						String incomeAmount = MoneyUtils.formatFloatNumber(comes);
						incomeAmount = incomeAmount.substring(0, incomeAmount.indexOf("."));
						
						// 返还本金
						String returnPrincipal = MoneyUtils.formatFloatNumber(Integer.parseInt(cBean.getEachMoney()) * Integer.parseInt(user.getCrowdfundCount()) * 1.0);
						returnPrincipal = returnPrincipal.substring(0, returnPrincipal.indexOf("."));
						
						AccountCapital accountCapital = revenueSettlementMapper.getBalances(user.getAccountId());
						
						// 等额本息 归还本金、增加收益
						Integer investmentMoney = Integer.parseInt(accountCapital.getInvestmentMoney())
								- Integer.parseInt(returnPrincipal);
						accountCapital.setInvestmentMoney(String.valueOf(investmentMoney));
						Integer noWithdrawMoney = Integer.parseInt(accountCapital.getNoWithdrawMoney())
								+ Integer.parseInt(returnPrincipal) + Integer.parseInt(incomeAmount);
						accountCapital.setNoWithdrawMoney(String.valueOf(noWithdrawMoney));
						
						// 修改金额
						revenueSettlementMapper.changeFunds(accountCapital);
						
						// 收益返还
						ProfitReturnBean profitReturnBean = new ProfitReturnBean();
						profitReturnBean.setAccountId(user.getAccountId());
						profitReturnBean.setAccountPhone(user.getTelephone());
						profitReturnBean.setCrowdfundingId(cBean.getCrowdId());
						profitReturnBean.setType("2");
						profitReturnBean.setProfitMoney(String.valueOf(Integer.parseInt(returnPrincipal) + Integer.parseInt(incomeAmount)));
						
						profitReturnMapper.addProfitReturn(profitReturnBean);
						
						
						/*String shopNo = paramMapper.getParamVal("JZH_SHOP");
						AccountInfo account = accountInfoMapper.getLoginAccountInfo(user.getAccountId());
						//投资人-->商户[转账-利息管理费]
						Map<String, String> managementMap =InterfaceUtil.shopToCust(shopNo, account.getTelephone(), String.valueOf(Integer.parseInt(returnPrincipal) + Integer.parseInt(incomeAmount)));
						fuiouService.addGoldTransfer(managementMap, account.getTelephone(), shopNo);
						if("0000".equals(managementMap.get("resp_code"))){
							//投资人-->商户[金账户明细]
							GoldDetailsBean goldDetail = new GoldDetailsBean();
							goldDetail.setInCustNo(account.getTelephone());
							goldDetail.setOutCustNo(shopNo);
							goldDetail.setMoney(String.valueOf(Integer.parseInt(returnPrincipal) + Integer.parseInt(incomeAmount)));
							goldDetail.setTransferType("0");
							goldDetail.setPurpose("12");
							goldDetail.setRemark("投资人:"+account.getTelephone()+",众筹结束,返还本金:"+(Integer.parseInt(returnPrincipal)/100.0)+"元,收益:"+(Integer.parseInt(incomeAmount)/100.0)+"元");
							goldDetailsMapper.addGoldDetail(goldDetail);
						}*/

						// --------------------------------------------------资金明细----------------------------------------------------------------------
						
						// 资金明细：投资金额-
						CapitalDetail investMent = new CapitalDetail();
						investMent.setAccountId(user.getAccountId());
						investMent.setMoney(returnPrincipal);
						investMent.setType(Constants.DEVIL_NUM_NINE);
						investMent.setInExpend(Constants.DEVIL_NUM_ONE);
						investMent.setRemark("支出投资金额：" + Double.parseDouble(returnPrincipal) / 100+"元");
						revenueSettlementMapper.addCapital(investMent);
						// 资金明细：本金+
						CapitalDetail principal = new CapitalDetail();
						principal.setAccountId(user.getAccountId());
						principal.setMoney(returnPrincipal);
						principal.setType(Constants.DEVIL_NUM_NINE);
						principal.setInExpend(Constants.DEVIL_NUM_ZERO);
						principal.setRemark("收入本金：" + Double.parseDouble(returnPrincipal) / 100+"元");
						revenueSettlementMapper.addCapital(principal);
						// 资金明细：收益+
						CapitalDetail income = new CapitalDetail();
						income.setAccountId(user.getAccountId());
						income.setMoney(incomeAmount);
						income.setType(Constants.DEVIL_NUM_FOUR);
						income.setInExpend(Constants.DEVIL_NUM_ZERO);
						income.setRemark("收入收益：" + Double.parseDouble(incomeAmount) / 100+"元");
						revenueSettlementMapper.addCapital(income);

						// 发送消息
						MessageBean outMessageBean = new MessageBean();
						outMessageBean.setAccountId(user.getAccountId());
						outMessageBean.setMsgTitle("众筹到期");
						outMessageBean.setMsgContent("您参与众筹："+cBean.getCrowdName()+"已结束，返还本金"+ Double.parseDouble(returnPrincipal) / 100+"元，收益："+ Double.parseDouble(incomeAmount) / 100+"元已发放至您账户！详情请在我的<a href='javascript:void(0)' onclick='goDetails(1)'>资金明细</a>中查看。");
						messageMapper.addMessageInfo(outMessageBean);
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	 /**
	 * @Description:
	 * @param args
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月23日 上午10:55:30
	 */
	public static void main(String[] args)
	{
		/*String[] colors = {"blue","red","green","yellow","orange","black"};
		int index=Arrays.binarySearch(colors, "rang");*/
		int a ;
		List<String> arr= new ArrayList<String>();
		for (int i = 0; i < 5; i++)
		{
			a=new Random().nextInt(20)+1;
			if(arr.contains(String.valueOf(a))){
				i--;
				continue;
			}
			arr.add(String.valueOf(a));
		}
		for (int i = 0; i < arr.size(); i++)
		{
			System.out.print(arr.get(i)+",");
		}
	}

	@Override
	public List<CrowdfundBean> queryIsWinningBy(CrowdfundBean crowdfundBean) throws SQLException
	{
		return crowdfundMapper.queryIsWinningBy(crowdfundBean);
	}

	@Override
	public Integer countIsWinning(CrowdfundBean crowdfundBean) throws SQLException
	{
		return crowdfundMapper.countIsWinning(crowdfundBean);
	}

	@Override
	public List<CrowdfundBean> queryMyCrowdfund(CrowdfundBean crowdfundBean) throws SQLException
	{
		return crowdfundMapper.queryMyCrowdfund(crowdfundBean);
	}

	@Override
	public List<CrowdfundBean> selCrowdfundingRecord(CrowdfundBean crowdfundBean) throws SQLException
	{
		return crowdfundMapper.selCrowdfundingRecord(crowdfundBean);
	}
	
	//添加金账户明细
	private void commonInvest(Map<String, String> repayMap,String investMoney,String companyInfo,String telephone,String allMoney) throws SQLException
	{
		//金账户转账成功
		if("0000".equals(repayMap.get("resp_code")))
		{
			//金账户明细
			GoldDetailsBean goldDetailsBean = new GoldDetailsBean();
			goldDetailsBean.setInCustNo(companyInfo);
			goldDetailsBean.setOutCustNo(telephone);
			goldDetailsBean.setMoney(MoneyUtils.changeYToF(investMoney));
			//转账类型(0:公司-投资人 1:投资人-公司 2:公司-借款人 3:借款人-公司 4:借款人-投资人 5:投资人-借款人 )  
			goldDetailsBean.setTransferType("1");
			goldDetailsBean.setPurpose("1");
			goldDetailsBean.setRemark("投资人:"+telephone+"向公司账户:"+companyInfo+"众筹"+allMoney+"元,金账户扣除"+investMoney+"元,可用余额扣除"+(Integer.parseInt(allMoney)-Integer.parseInt(investMoney)));
			goldDetailsMapper.addGoldDetail(goldDetailsBean);
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
}
