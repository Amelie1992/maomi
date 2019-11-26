/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.goodpic.GoodPicServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月23日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.goodpic.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.goodpic.GoodPicMapper;
import com.xed.financing.wxgzh.model.goodpic.GoodPicBean;
import com.xed.financing.wxgzh.service.goodpic.GoodPicService;

/**
 * @className:com.xed.financing.wxgzh.service.goodpic.GoodPicServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月23日 下午7:02:06
 * @author:QT
 */
@Service
public class GoodPicServiceImpl implements GoodPicService
{
	@Autowired
	private GoodPicMapper goodPicMapper;
	
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.goodpic.GoodPicService#queryGoodPic(com.xed.financing.wxgzh.model.goodpic.GoodPicBean)
	 */
	@Override
	public List<GoodPicBean> queryGoodPic(GoodPicBean goodPicBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return goodPicMapper.queryGoodPic(goodPicBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.goodpic.GoodPicService#queryGoodPicById(com.xed.financing.wxgzh.model.goodpic.GoodPicBean)
	 */
	@Override
	public GoodPicBean queryGoodPicById(GoodPicBean goodPicBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return goodPicMapper.queryGoodPicById(goodPicBean);
	}

}
