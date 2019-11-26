/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.playRecord.impl.PlayRecordServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年5月27日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.playRecord.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.playRecord.PlayRecordMapper;
import com.xed.financing.wxgzh.model.playRecord.PlayRecordBean;
import com.xed.financing.wxgzh.service.playRecord.PlayRecordService;

/**
 * @className:com.xed.financing.wxgzh.service.playRecord.impl.PlayRecordServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月27日 上午9:49:30
 * @author:Qian Tao
 */
@Service
public class PlayRecordServiceImpl implements PlayRecordService
{

	@Resource
	private PlayRecordMapper playRecordMapper;

	@Override
	public Integer addPlayRecord(PlayRecordBean playRecord) throws Exception
	{
		
		return playRecordMapper.addPlayRecord(playRecord);
	}

	@Override
	public List<PlayRecordBean> queryPlayRecordBeanList() throws Exception
	{
		List<PlayRecordBean> beans = playRecordMapper.queryPlayRecordBeanList();
		String telephone = "";
		for (PlayRecordBean playRecordBean : beans)
		{
			telephone = playRecordBean.getTelephone();
			telephone = telephone.substring(0,3)+"****"+telephone.substring(7,telephone.length());
			playRecordBean.setTelephone(telephone);
		}
		return beans;
	}

	@Override
	public PlayRecordBean selPlayRecordBean(PlayRecordBean playRecordBean) throws Exception
	{
		return playRecordMapper.selPlayRecordBean(playRecordBean);
	}
	

}
