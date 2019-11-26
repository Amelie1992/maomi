/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.revenueSettlement.RevenueSettlementService
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
package com.xed.financing.wxgzh.service.scorecenter;

import java.util.List;

import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;


/**
 * 鱼干中心
 * @className:com.xed.financing.wxgzh.service.scorecenter.ScoreCenterService
 * @description:
 * @version:v1.0.0 
 * @date:2017年6月9日 上午10:57:19
 * @author:Elias Zheng
 */
public interface ScoreCenterService
{
	/**
	 * 查询鱼干明细
	 * @Description:
	 * @param accountScoreBean
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月9日 上午10:58:10
	 */
	public List<AccountScoreBean> queryAccountScore(AccountScoreBean accountScoreBean) throws Exception;
}
