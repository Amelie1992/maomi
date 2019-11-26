package com.xed.financing.wxgzh.service.subjectdispersed.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.subjectdispersed.SubjectDispersedMapper;
import com.xed.financing.wxgzh.model.subjectdispersed.SubjectDispersedBean;
import com.xed.financing.wxgzh.service.subjectdispersed.SubjectDispersedService;

@Service
public class SubjectDispersedServiceImpl implements SubjectDispersedService
{
	@Autowired
	private SubjectDispersedMapper subjectDispersedMapper;
	
	@Override
	public Integer queryiIsStatus() throws SQLException
	{
		int count = subjectDispersedMapper.queryiIsStatus();
		return count;
	}

	@Override
	public SubjectDispersedBean querySubjectOnTypesAndMonry(SubjectDispersedBean subjectDispersedBean) throws SQLException
	{
		return subjectDispersedMapper.querySubjectOnTypesAndMonry(subjectDispersedBean);
	}

	@Override
	public List<SubjectDispersedBean> queryDispersedSubjectList(SubjectDispersedBean subjectDispersedBean)
			throws SQLException
	{
		// TODO Auto-generated method stub
		return subjectDispersedMapper.queryDispersedSubjectList(subjectDispersedBean);
	}

	@Override
	public SubjectDispersedBean queryDispersedSubjectListById(SubjectDispersedBean subjectDispersedBean)
			throws SQLException
	{
		return subjectDispersedMapper.queryDispersedSubjectListById(subjectDispersedBean);
	}

	@Override
	public List<SubjectDispersedBean> queryFreedomInvest(SubjectDispersedBean subjectDispersedBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return subjectDispersedMapper.queryFreedomInvest(subjectDispersedBean);
	}

	@Override
	public String countInvestMoneyById(SubjectDispersedBean subjectDispersedBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return subjectDispersedMapper.countInvestMoneyById(subjectDispersedBean);
	}

}
