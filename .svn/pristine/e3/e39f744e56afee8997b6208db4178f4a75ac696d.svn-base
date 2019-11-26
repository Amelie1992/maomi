package com.xed.financing.wxgzh.service.runinfo.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.runinfo.RunInfoMapper;
import com.xed.financing.wxgzh.model.runinfo.RunInfoBean;
import com.xed.financing.wxgzh.service.runinfo.RunInfoService;

@Service
public class RunInfoServiceImpl implements RunInfoService
{

	@Autowired
	private RunInfoMapper runInfoMapper;
	
	@Override
	public String getTotaltransaction(String date) throws SQLException
	{
		return runInfoMapper.getTotaltransaction(date);
	}

	@Override
	public Integer getAccumulativeTransaction(String date) throws SQLException
	{
		return runInfoMapper.getAccumulativeTransaction(date);
	}

	@Override
	public String getLoanBalance(String date) throws SQLException
	{
		return runInfoMapper.getLoanBalance(date);
	}

	@Override
	public Integer getAccumulativeBorrower(String date) throws SQLException
	{
		return runInfoMapper.getAccumulativeBorrower(date);
	}

	@Override
	public Integer getAccumulativeLenders(String date) throws SQLException
	{
		return runInfoMapper.getAccumulativeLenders(date);
	}

	@Override
	public Integer getLoanBalanceCount(String date) throws SQLException
	{
		return runInfoMapper.getLoanBalanceCount(date);
	}

	@Override
	public Integer getCurrentBorrowerCount(String date) throws SQLException
	{
		return runInfoMapper.getCurrentBorrowerCount(date);
	}

	@Override
	public Integer getCurrentLendersCount(String date) throws SQLException
	{
		return runInfoMapper.getCurrentLendersCount(date);
	}

	@Override
	public String getRelatedLoanBalance(String date) throws SQLException
	{
		return runInfoMapper.getRelatedLoanBalance(date);
	}

	@Override
	public String geTheProportionOne(String date) throws SQLException
	{
		return runInfoMapper.geTheProportionOne(date);
	}

	@Override
	public String geTheProportionTen(String date) throws SQLException
	{
		return runInfoMapper.geTheProportionTen(date);
	}

	@Override
	public String queryXuNiUserMoney(String date) throws SQLException {
		// TODO Auto-generated method stub
		return runInfoMapper.queryXuNiUserMoney(date);
	}

	@Override
	public Integer getLoanBalances(String date) throws SQLException
	{
		return runInfoMapper.getLoanBalances(date);
	}

	@Override
	public Integer addRunInfo(RunInfoBean runInfoBean) throws SQLException
	{
		return runInfoMapper.addRunInfo(runInfoBean);
	}

	@Override
	public String getRegistrationsCount() throws SQLException
	{
		return runInfoMapper.getRegistrationsCount();
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.runinfo.RunInfoService#getTransactionCount()
	 */
	@Override
	public Integer getTransactionCount() throws SQLException
	{
		// TODO Auto-generated method stub
		return runInfoMapper.getTransactionCount();
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.runinfo.RunInfoService#getAllProfit()
	 */
	@Override
	public String getAllProfit() throws SQLException
	{
		// TODO Auto-generated method stub
		return runInfoMapper.getAllProfit();
	}

}
