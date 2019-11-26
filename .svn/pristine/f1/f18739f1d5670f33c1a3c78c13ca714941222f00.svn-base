/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.revenueSettlement.RevenueSettlementMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月26日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.revenueSettlement;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.creditrecord.CreditRecord;
import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;

/**
 * 收益结算
 * 
 * @className:com.xed.financing.wxgzh.mapper.revenueSettlement.RevenueSettlementMapper
 * @description:
 * @version:v1.0.0
 * @date:2017年4月26日 上午10:30:12
 * @author:ZhangJun
 */
public interface RevenueSettlementMapper
{

	/**
	 * 查询当天结算收益的投标信息
	 * 
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月13日 下午4:05:58
	 */
	public List<AccountInvest> getSettlementIncomeInvestInfo() throws SQLException;

	/**
	 * 修改投资记录 月结
	 * 
	 * @Description:
	 * @param accountInvest
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月14日 下午3:01:18
	 */
	public Integer updateInvestInfoByMonth(AccountInvest accountInvest) throws SQLException;

	/**
	 * 修改投资记录 日结
	 * 
	 * @Description:
	 * @param accountInvest
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月14日 下午3:16:56
	 */
	public Integer updateInvestInfoByDay(AccountInvest accountInvest) throws SQLException;

	/**
	 * 通过用户ID查找用户账户资金
	 * 
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月26日 上午11:47:01
	 */
	public AccountCapital getBalances(String accountId) throws SQLException;

	/**
	 * 更改账户金额
	 * 
	 * @Description:
	 * @param accountCapital
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月26日 上午11:49:18
	 */
	public Boolean changeFunds(AccountCapital accountCapital) throws SQLException;

	/**
	 * 添加资金明细
	 * 
	 * @Description:
	 * @param capitalDetail
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月26日 下午2:34:53
	 */
	public void addCapital(CapitalDetail capitalDetail) throws SQLException;

	/**
	 * 修改转让记录 撤销
	 * 
	 * @Description:
	 * @param investId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月14日 下午5:25:13
	 */
	public Integer updateTransferStatus(String investId) throws SQLException;

	/**
	 * 获得转让记录
	 * 
	 * @Description: 并把投资记录查出来，未撤销的、标的状态为正常的、转让中的
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月15日 下午4:31:13
	 */
	public List<CreditRecord> getCreditRecords() throws SQLException;

	/**
	 * 修改转让记录
	 * 
	 * @Description: 转让债权记录更新转让金额、垫付金额和利率修正金额
	 * @param creditRecord
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月16日 下午6:03:34
	 */
	public Integer updateCreditRecord(CreditRecord creditRecord) throws SQLException;

	/**
	 * 获得当前时间
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月17日 上午9:25:28
	 */
	public String getNow() throws SQLException;

	
	/**
	 * 查询使用当天为投标7天，并且使用3000体验金的
	 * @Description:
	 * @param couponId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月24日 下午9:43:18
	 */
	/*public List<AccountInvest> selActivitySettlementIncomeInvestInfo(String couponId) throws SQLException;*/
	
	
	//------------------------------------猫咪宝-------------------------------------------------
	
	/**
	 * 获取前天发放收益的猫咪宝投资记录（用于合并）
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月24日 下午5:05:11
	 */
	public List<FreedomSubjectBean> getSettlementFreedom()throws SQLException;
	
	/**
	 * 获得前天之前未合并的猫咪宝投资记录
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月24日 下午8:10:43
	 */
	public FreedomSubjectBean getNoMerge(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	
	/**
	 * 修改猫咪宝投资记录 为已合并
	 * @Description:
	 * @param freedomSubjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月24日 下午8:25:39
	 */
	public void updateMergeFreedom(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	
	
	/**
	 * 修改猫咪投资记录 修改投资金额
	 * @Description:
	 * @param freedomSubjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月24日 下午8:37:12
	 */
	public void updateMergeMoneys(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	
	/**
	 * 获取昨天之前未合并的记录    根据标ID查询前天的利率
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月25日 上午11:02:04
	 */
	public List<FreedomSubjectBean> getBeforeLastDayNoMerge()throws SQLException;
	
	/**
	 * 添加猫咪宝收益结算记录
	 * @Description:
	 * @param freedomSubjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月25日 上午11:53:16
	 */
	public void addFreedomProfit(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	
	
	
	/**
	 * 查询除了爆款标其他的当日结束的标
	 * 
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月26日 上午10:34:12
	 */
	/*
	 * public List<SubjectBean> queryEndOthersSubjects() throws SQLException;
	 *//**
	 * 根据标的ID，查出投标信息，除去以转让的债权
	 * 
	 * @Description:
	 * @param subjectId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月26日 上午11:24:10
	 */
	/*
	 * public List<AccountInvest> selectInvestBySubjectId(String subjectId)
	 * throws SQLException;
	 *//**
	 * 查询爆款标到期的投标记录
	 * 
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月26日 下午5:04:20
	 */
	/*
	 * public List<AccountInvest> queryEndGoodsInvest() throws SQLException;
	 *//**
	 * 根据投标信息查询所属标的信息
	 * 
	 * @Description:
	 * @param accountInvest
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月26日 下午5:07:42
	 */
	/*
	 * public SubjectBean selectSubjectInfoByInvestInfo(AccountInvest
	 * accountInvest) throws SQLException;
	 */

	/**
	 * 修改投标的状态
	 * 
	 * @Description:
	 * @param accountInvest
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月26日 下午3:13:37
	 */
	/*
	 * public Boolean updateInvestStatus(AccountInvest accountInvest) throws
	 * SQLException;
	 *//**
	 * 修改标的状态
	 * 
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月26日 下午3:17:15
	 */
	/*
	 * public Boolean updateSubjectStatus(SubjectBean subjectBean) throws
	 * SQLException;
	 */
	/**
	 * 通过investId查询当天结算收益的投标信息
	 * @Description:
	 * @param investId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年9月26日 下午2:13:27
	 */
	public AccountInvest getSettlementIncomeInvestInfoById(String investId) throws SQLException;
	
	/**
	 * 判读是否结算猫咪宝收益
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年12月25日 下午4:33:33
	 */
	public Integer checkFreedomProfit(FreedomSubjectBean freedomSubjectBean)throws SQLException;
}
