package com.xed.financing.wxgzh.service.usercompany.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.usercompany.UserCompanyMapper;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.model.usercompany.UserCompanyBean;
import com.xed.financing.wxgzh.service.usercompany.UserCompanyService;

@Service
public class UserCompanyServiceImpl implements UserCompanyService
{
	@Resource
	private UserCompanyMapper userCompanyMapper;

	@Override
	public UserCompanyBean getUserCompanyInfo(SubjectBean subjectBean) throws SQLException
	{
		UserCompanyBean userCompanyBean = new UserCompanyBean();
		userCompanyBean.setUserId(subjectBean.getUserId());
		return userCompanyMapper.getUserCompanyInfo(userCompanyBean);
	}

}
