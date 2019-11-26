/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.subject.SubjectServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月16日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.subjectpic.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.subjectpic.SubjectPicMapper;
import com.xed.financing.wxgzh.model.subjectpic.SubjectPicBean;
import com.xed.financing.wxgzh.service.subjectpic.SubjectPicService;

/**
 * @className:com.xed.financing.wxgzh.service.subject.SubjectServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月16日 上午11:04:46
 * @author:Qian Tao
 */
@Service
public  class SubjectPicServiceImpl implements SubjectPicService
{

	/**
	 * 标mapper
	 */
	@Resource
	private SubjectPicMapper subjectPicMapper;

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.subjectpic.SubjectPicService#querySubjectPic(com.xed.financing.wxgzh.model.subjectpic.SubjectPicBean)
	 */
	@Override
	public List<SubjectPicBean> querySubjectPic(SubjectPicBean subjectPicBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return subjectPicMapper.querySubjectPic(subjectPicBean);
	}

	@Override
	public SubjectPicBean getSubjectPic(SubjectPicBean subjectPicBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return subjectPicMapper.getSubjectPic(subjectPicBean);
	}

	@Override
	public void deleteSubjectPic(SubjectPicBean subjectPicBean) throws SQLException
	{
		// TODO Auto-generated method stub
		subjectPicMapper.deleteSubjectPic(subjectPicBean);
	}

	@Override
	public void insertSubjectPic(List<SubjectPicBean> subjectPicBean) throws SQLException
	{
		// TODO Auto-generated method stub
		subjectPicMapper.insertSubjectPic(subjectPicBean);
	}
	
} 
