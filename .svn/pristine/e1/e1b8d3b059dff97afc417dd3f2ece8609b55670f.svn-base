package com.xed.financing.wxgzh.service.userhouse.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.userhouse.UserHouseMapper;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.model.userhouse.UserHouseBean;
import com.xed.financing.wxgzh.service.userhouse.UserHouseService;

@Service
public class UserHouseServiceImpl implements UserHouseService
{
	@Resource
	private UserHouseMapper userHouseMapper;

	@Override
	public UserHouseBean getUserHouseInfo(SubjectBean subjectBean) throws SQLException
	{
		UserHouseBean userHouseBean = new UserHouseBean();
		userHouseBean.setUserId(subjectBean.getUserId());
		return userHouseMapper.getUserHouseInfo(userHouseBean);
	}
	
}
