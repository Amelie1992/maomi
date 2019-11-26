/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper
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
package com.xed.financing.wxgzh.mapper.bondtransfer;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.accountcapital.AccountCapital;
import com.xed.financing.wxgzh.model.accountinvest.AccountInvest;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.creditrecord.CreditRecord;
import com.xed.financing.wxgzh.model.subject.SubjectBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper
 * @description:
 * @version:v1.0.0
 * @date:2017年3月17日 下午2:01:08
 * @author:ZhangJun
 */
public interface BondTransferMapper
{
	/**
	 * 查询全部集合，根据条件排序
	 * 
	 * @Description:查询全部集合，根据条件排序
	 * @param record
	 * @return 全部集合
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月17日 下午2:04:33
	 */
	public List<CreditRecord> getSortingList(CreditRecord record) throws SQLException;
	
	
	/**
	 * 查询排序债权集合(已承接)
	 * @Description:
	 * @param record
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月14日 下午4:03:34
	 */
	public List<CreditRecord> getSortingListTransfer(CreditRecord record) throws SQLException;

	/**
	 * 查询转让债权总数量
	 * 
	 * @Description:查询转让债权总数量
	 * @return 转让债权总数量
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月17日 下午3:20:41
	 */
	public Integer getBondCount() throws SQLException;

	/**
	 * 查询转让债权总金额
	 * 
	 * @Description:查询转让债权总金额
	 * @return 转让债权总金额
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月17日 下午3:22:30
	 */
	public Integer getBondMoneySUM() throws SQLException;

	/**
	 * 根据债权转让条目ID查询转让人ID 和 投标ID
	 * 
	 * @Description:
	 * @param creditRecord
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午2:08:15
	 */
	public CreditRecord getCreditRecordByCreditId(String creditId) throws SQLException;

	/**
	 * 根据投标ID更改投标状态，改为以转让债权
	 * 
	 * @Description:
	 * @param investId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午2:13:08
	 */
	public Boolean updateInvestStatus(String investId) throws SQLException;

	/**
	 * 修改投标金额，年化收益，月化收益
	 * @Description:
	 * @param accountInvest
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月29日 下午4:40:59
	 */
	public Boolean updateInvestIncome(AccountInvest accountInvest) throws SQLException;
	
	
	/**
	 * 根据投标ID查询投标信息
	 * 
	 * @Description:
	 * @param investId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午2:13:00
	 */
	public AccountInvest getInvestByID(String investId) throws SQLException;

	/**
	 * 添加投标信息
	 * 
	 * @Description:添加投标信息
	 * @param accountInvest
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午2:12:42
	 */
	public void addInvest(AccountInvest accountInvest) throws SQLException;

	/**
	 * 添加交易记录
	 * 
	 * @Description:添加交易记录
	 * @param capitalDetail
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午2:12:27
	 */
	public void addCapital(CapitalDetail capitalDetail) throws SQLException;

	/**
	 * 更改账户资金
	 * 
	 * @Description:更改账户资金
	 * @param accountCapital
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午2:12:18
	 */
	public Boolean changeFunds(AccountCapital accountCapital) throws SQLException;

	/**
	 * 检查余额
	 * 
	 * @Description:
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午4:37:12
	 */
	public AccountCapital getBalances(String accountId) throws SQLException;

	/**
	 * 查询债权转让金额
	 * 
	 * @Description: 根据转让ID查询转让金额
	 * @param creditId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午4:43:11
	 */
	public Integer getBondAmount(String creditId) throws SQLException;

	/**
	 * 查询标的详情
	 * 
	 * @Description:
	 * @param subjectId
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月21日 上午10:27:16
	 */
	public SubjectBean getSubjectInfo(String subjectId) throws SQLException;
	
	/**
	 * 
	 * @Description:
	 * @param creditRecord
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月21日 下午3:46:35
	 */
	public Integer changeCreditRecord (CreditRecord creditRecord) throws SQLException;
	
	/**
	 * 获得转让记录详情
	 * @Description:
	 * @param creditId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月21日 下午6:13:00
	 */
	public CreditRecord getCreditRecordDetail(String creditId)throws SQLException;
	
	/**
	 * 
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月18日 上午9:54:31
	 */
	public Integer checkTransferStatus(String creditId)throws SQLException;
	
}
