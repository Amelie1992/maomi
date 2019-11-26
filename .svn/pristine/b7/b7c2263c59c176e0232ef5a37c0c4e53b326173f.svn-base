package com.xed.financing.wxgzh.service.runinfo;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;

import com.xed.financing.wxgzh.model.runinfo.RunInfoBean;

public interface RunInfoService
{
	/**
	 * 交易总额
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:25:51
	 */
	public String getTotaltransaction(@Param("date")String date)throws SQLException;
	
	/**
	 * 查询虚拟用户投资金额
	 * @Description:
	 * @param date
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年2月22日 下午3:50:58
	 */
	public String queryXuNiUserMoney(@Param("date")String date)throws SQLException;
	
	/**
	 * 累计交易贷款笔数
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:28:00
	 */
	public Integer getAccumulativeTransaction(@Param("date")String date)throws SQLException;
	
	/**
	 * 借贷余额
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:28:55
	 */
	public String getLoanBalance(@Param("date")String date)throws SQLException;
	
	/**
	 * 累计借款人数量(个)
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:29:44
	 */
	public Integer getAccumulativeBorrower (@Param("date")String date)throws SQLException;

	/**
	 * 累计出借人数量(个)
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:30:43
	 */
	public Integer getAccumulativeLenders(@Param("date")String date)throws SQLException;
	
	/**
	 * 借贷余额笔数(个)
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:30:43
	 */
	public Integer getLoanBalanceCount(@Param("date")String date)throws SQLException;
	
	/**
	 * 当前借款人数量(个)
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:30:43
	 */
	public Integer getCurrentBorrowerCount(@Param("date")String date)throws SQLException;
	
	/**
	 * 当前出借人数量(个)
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:30:43
	 */
	public Integer getCurrentLendersCount(@Param("date")String date)throws SQLException;
	
	/**
	 * 关联关系借款余额
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:30:43
	 */
	public String getRelatedLoanBalance(@Param("date")String date)throws SQLException;
	
	/**
	 * 最大单一借款人待还金额占比
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:30:43
	 */
	public String geTheProportionOne(@Param("date")String date)throws SQLException;
	
	/**
	 * 前十借款人待还金额占比
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月11日 上午11:30:43
	 */
	public String geTheProportionTen(@Param("date")String date)throws SQLException;
	
	/**
	 * 借款总额
	 * @Description:
	 * @param date
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年2月23日 上午9:47:15
	 */
	public Integer getLoanBalances(@Param("date")String date)throws SQLException;
	
	/**
	 * 累计注册人数
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月27日 上午10:56:53
	 */
	public String getRegistrationsCount()throws SQLException;
	
	/**
	 * 
	 * @Description:
	 * @param runInfoBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年2月23日 上午11:54:43
	 */
	public Integer addRunInfo(RunInfoBean runInfoBean) throws SQLException;
	
	public Integer getTransactionCount() throws SQLException;
	
	public String getAllProfit() throws SQLException;
}
