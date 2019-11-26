/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.bondtransfer.impl.BondTransferServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月17日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.draw.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.draw.DrawMapper;
import com.xed.financing.wxgzh.model.draw.DrawBean;
import com.xed.financing.wxgzh.service.draw.DrawService;

/**
 * @className:com.xed.financing.wxgzh.service.bondtransfer.impl.BondTransferServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年3月17日 下午3:47:47
 * @author:ZhangJun
 */
@Service
public class DrawServiceImpl implements DrawService
{

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(DrawServiceImpl.class);

	@Resource
	private DrawMapper drawMapper;

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.draw.DrawService#queryDrawList(com.xed.financing.wxgzh.model.draw.DrawBean)
	 */
	@Override
	public List<DrawBean> queryDrawList(DrawBean drawBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return drawMapper.queryDrawList(drawBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.draw.DrawService#queryDraw(com.xed.financing.wxgzh.model.draw.DrawBean)
	 */
	@Override
	public List<DrawBean> queryDraw(DrawBean drawBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return drawMapper.queryDraw(drawBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.draw.DrawService#addDraw(com.xed.financing.wxgzh.model.draw.DrawBean)
	 */
	@Override
	public void addDraw(DrawBean drawBean) throws SQLException
	{
		// TODO Auto-generated method stub
		drawMapper.addDraw(drawBean);
		logger.info("添加抽奖记录成功");
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.draw.DrawService#deleteDraw(com.xed.financing.wxgzh.model.draw.DrawBean)
	 */
	@Override
	public void deleteDraw(DrawBean drawBean) throws SQLException
	{
		// TODO Auto-generated method stub
		drawMapper.deleteDraw(drawBean);
		logger.info("删除抽奖记录成功");
	}
}
