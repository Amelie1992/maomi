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
package com.xed.financing.wxgzh.service.goodsinfo.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.goodsinfo.GoodsInfoMapper;
import com.xed.financing.wxgzh.model.goodsinfo.GoodsInfoBean;
import com.xed.financing.wxgzh.service.goodsinfo.GoodsInfoService;

/**
 * @className:com.xed.financing.wxgzh.service.subject.SubjectServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月16日 上午11:04:46
 * @author:Qian Tao
 */
@Service
@Transactional
public  class GoodsInfoServiceImpl implements GoodsInfoService
{
	
	@Resource
	private GoodsInfoMapper goodsInfoMapper;

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.goodsinfo.GoodsInfoService#queryGoodsInfo(com.xed.financing.wxgzh.model.goodsinfo.GoodsInfoBean)
	 */
	@Override
	public List<GoodsInfoBean> queryGoodsInfo(GoodsInfoBean goodsInfoBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return this.goodsInfoMapper.queryGoodsInfo(goodsInfoBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.goodsinfo.GoodsInfoService#queryGoodsInfoById(com.xed.financing.wxgzh.model.goodsinfo.GoodsInfoBean)
	 */
	@Override
	public GoodsInfoBean queryGoodsInfoById(GoodsInfoBean goodsInfoBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return this.goodsInfoMapper.queryGoodsInfoById(goodsInfoBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.goodsinfo.GoodsInfoService#updateGoodsInfo(com.xed.financing.wxgzh.model.goodsinfo.GoodsInfoBean)
	 */
	@Override
	public void updateGoodsInfo(GoodsInfoBean goodsInfoBean) throws SQLException
	{
		// TODO Auto-generated method stub
		this.goodsInfoMapper.updateGoodsInfo(goodsInfoBean);
	}
	
}
