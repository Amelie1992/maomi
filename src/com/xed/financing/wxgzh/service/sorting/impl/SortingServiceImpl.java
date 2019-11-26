package com.xed.financing.wxgzh.service.sorting.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.sorting.SortingMapper;
import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;
import com.xed.financing.wxgzh.service.sorting.SortingService;

@Service
public class SortingServiceImpl implements SortingService
{
	@Autowired
	private SortingMapper sortingMapper;

	@Override
	public List<InvestRecordBean> queryInvestRecordBeanlList(String flag) throws SQLException
	{
		List<InvestRecordBean> accountCapitalList = sortingMapper.queryInvestRecordBeanlList(flag);
		return accountCapitalList;
	}

	

}
