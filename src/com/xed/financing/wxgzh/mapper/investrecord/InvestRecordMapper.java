/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.investrecord.InvestRecordMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月23日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.investrecord;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.investrecord.InvestRecordMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月23日 下午4:57:07
 * @author:Qian Tao
 */
public interface InvestRecordMapper
{
	/**
	 * 查询投资记录  我的投标
	 * @Description:
	 * @param investRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月23日 下午4:57:59
	 */
	public List<InvestRecordBean> queryInvestRecord(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 查询投资记录 债权转让
	 * @Description:
	 * @param investRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月23日 下午4:58:45
	 */
	public List<InvestRecordBean> queryCreditRecord(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 查看投标信息
	 * @Description:
	 * @param investRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月24日 下午5:56:48
	 */
	public InvestRecordBean queryInvestRecordById(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 债权转让---修改转让人记录状态
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月24日 下午5:15:33
	 */
	public void updateInvestStatus(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 修改转让表状态  取消转让 
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月19日 上午10:03:28
	 */
	public void updateCreditStauts(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 债权转让---添加转让信息
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月24日 下午5:16:20
	 */
	public void addCreditRecord(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 加急转让
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月27日 下午2:06:46
	 */
	public void updateCreditStatus(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 添加满标后投标表满标时间
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月10日 上午11:17:12
	 */
	public void updateSubjectFullTime(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 投资记录变更为已转让
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月13日 下午2:34:47
	 */
	public void updateInvestInfo(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 添加承接人投标记录
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月13日 下午4:04:24
	 */
	public void addInvestTransfer(InvestRecordBean investRecordBean) throws SQLException;
	
	
	
	/**
	 * 查看投标信息(查询单条记录)
	 * @Description:
	 * @param investRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月21日 上午9:49:26
	 */
	public InvestRecordBean selectOneInvestRecordById(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 
	 * 判断用户是否第一次投标
	 * @Description:
	 * @param investRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月2日 上午9:58:20
	 */
	public Integer countFirstSubject(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 用户代收本金
	 * @Description:
	 * @param investRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年9月21日 下午1:42:12
	 */
	public String countSumInvestSubject(InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 查询iphone订单
	 * @Description:
	 * @param investId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月6日 下午6:07:48
	 */
	public InvestRecordBean queryIphoneById(@Param("investId") String investId) throws SQLException;
}
