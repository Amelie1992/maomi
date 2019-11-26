package com.xed.financing.wxgzh.service.category.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.category.CategoryMapper;
import com.xed.financing.wxgzh.model.category.CategoryBean;
import com.xed.financing.wxgzh.service.category.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public List<CategoryBean> queryInviteCodeList() throws SQLException
	{
		return categoryMapper.queryInviteCodeList();
	}

}
