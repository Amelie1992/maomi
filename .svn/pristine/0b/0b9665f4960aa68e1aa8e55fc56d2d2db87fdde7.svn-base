/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.investrecord.InvestRecordService
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
package com.xed.financing.wxgzh.service.investrecord;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;

/**
 * @className:com.xed.financing.wxgzh.service.investrecord.InvestRecordService
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月23日 下午4:59:56
 * @author:Qian Tao
 */
public interface InvestRecordService
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
	 * 债权转让
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月24日 下午5:15:33
	 */
	public void transferBond(HttpServletRequest request,String investId,String investMoney) throws SQLException;
	
	/**
	 * 加急
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月6日 下午9:55:56
	 */
	public void fastTransfer(HttpServletRequest request,InvestRecordBean investRecordBean) throws SQLException;
	
	/**
	 * 平台接盘
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月7日 上午10:12:57
	 */
	public void sysTransfer(InvestRecordBean investRecordBean) throws SQLException;
	
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
	 * 取消转让
	 * @Description:
	 * @param investRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月19日 上午10:06:10
	 */
	public void cancelTransfer(HttpServletRequest request,InvestRecordBean investRecordBean) throws SQLException;

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
	 * 查询投资转让详情
	 * @Description:
	 * @param investRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月10日 上午11:14:18
	 */
	public InvestRecordBean queryInvestRecordById(InvestRecordBean investRecordBean) throws SQLException;
	
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
	public InvestRecordBean queryIphoneById(String investId) throws SQLException;
}
