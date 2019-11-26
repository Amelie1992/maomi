/**
 * Copyright (C) 2017 FZJT Co.Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.capitaldetail.impl.CapitaldetailServiceImpl
 * @description:资金记录表实现类
 * 
 * @version:v1.0.0 
 * @author:WangLin
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月16日    WangLin  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.capitaldetail.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.capitaldetail.CapitaldetailMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.service.capitaldetail.CapitaldetailService;

/**
 * @className:com.xed.financing.wxgzh.service.capitaldetail.impl.CapitaldetailServiceImpl
 * @description:资金记录表实现类
 * @version:v1.0.0
 * @date:2017年3月16日 下午3:09:30
 * @author:WangLin
 */
@Service
@Transactional
public class CapitaldetailServiceImpl implements CapitaldetailService
{
			
	@Resource
	private CapitaldetailMapper mapper;

	/**
	 * 查询所有交易记录
	 */
	@Override
	public List<CapitalDetail> getAll(CapitalDetail capitalDetail) throws SQLException
	{
		List<CapitalDetail> getAllList = mapper.getAll(capitalDetail);
		return getAllList;
	}
	
	/**
	 * 查询用户累计收益金额(元)
	 */
	@Override
	public String selAccumulatedIncomeById(CapitalDetail detail) throws SQLException
	{
		return mapper.selAccumulatedIncomeById(detail);
	}
	
	/**
	 * 查询用户累计收益金额(元)
	 */
	@Override
	public String selAccumulatedIncomeMonthById(CapitalDetail detail) throws SQLException
	{
		return mapper.selAccumulatedIncomeMonthById(detail);
	}

	/**
	 * 根据id查询
	 */
	@Override
	public CapitalDetail getById(Integer id) throws SQLException
	{
		CapitalDetail capitalDetail = mapper.getById(id);
		return capitalDetail;
	}

	@Override
	public List<CapitalDetail> getTypeQuret(String type,HttpServletRequest request) throws SQLException
	{
		CapitalDetail detail = new CapitalDetail();
		detail.setType(type);
		String accountId = ((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
		detail.setAccountId(accountId);
		List<CapitalDetail> getTypeList = mapper.getTypeQuery(detail);
		return getTypeList;
	}
	
	@Override
	public List<CapitalDetail> iosGetTypeQuret(String type,String accountId) throws SQLException
	{
		CapitalDetail detail = new CapitalDetail();
		detail.setType(type);
		detail.setAccountId(accountId);
		List<CapitalDetail> getTypeList = mapper.getTypeQuery(detail);
		return getTypeList;
	}

	@Override
	public Integer queryUserDraw(String accountId) throws SQLException
	{
		// TODO Auto-generated method stub
		return mapper.queryUserDraw(accountId);
	}

	@Override
	public List<CapitalDetail> getAllByType(CapitalDetail capitalDetail) throws SQLException
	{
		// TODO Auto-generated method stub
		return mapper.getAllByType(capitalDetail);
	}

	@Override
	public List<CapitalDetail> queryDetailByType(CapitalDetail capitalDetail) throws SQLException
	{
		// TODO Auto-generated method stub
		return mapper.queryDetailByType(capitalDetail);
	}

	@Override
	public String countSumFreedomSubjectMoney(CapitalDetail capitalDetail)
			throws SQLException {
		// TODO Auto-generated method stub
		return mapper.countSumFreedomSubjectMoney(capitalDetail);
	}

}
