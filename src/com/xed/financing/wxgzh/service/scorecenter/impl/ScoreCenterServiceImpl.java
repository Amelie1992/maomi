/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.revenueSettlement.impl.RevenueSettlementServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月26日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.scorecenter.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.service.scorecenter.ScoreCenterService;

/**
 * 鱼干中心
 * @className:com.xed.financing.wxgzh.service.scorecenter.impl.ScoreCenterServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年6月9日 上午10:57:31
 * @author:Elias Zheng
 */
@Service
@Transactional
public class ScoreCenterServiceImpl implements ScoreCenterService
{

	@Resource
	private AccountScoreMapper accountScoreMapper;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(ScoreCenterServiceImpl.class);

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.scorecenter.ScoreCenterService#queryAccountScore(com.xed.financing.wxgzh.model.accountscore.AccountScoreBean)
	 */
	@Override
	public List<AccountScoreBean> queryAccountScore(AccountScoreBean accountScoreBean) throws Exception
	{
		// TODO Auto-generated method stub
		return accountScoreMapper.queryAccountScore(accountScoreBean);
	}
}
