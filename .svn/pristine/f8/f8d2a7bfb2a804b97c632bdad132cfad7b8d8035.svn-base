/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.bondtransfer.BondTransferService
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
package com.xed.financing.wxgzh.service.awardrotate;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;

/**
 * 积分抽奖
 * @className:com.xed.financing.wxgzh.service.awardrotate.AwardRotateService
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月26日 下午2:37:00
 * @author:Elias Zheng
 */
public interface AwardRotateService
{
	/**
	 * 获取用户信息
	 * @Description:
	 * @param accountBean
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月26日 下午2:42:28
	 */
	public AccountInfo getAccountScore(String accountId) throws Exception;
	
	/**
	 * 抽奖鱼干消耗
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月26日 下午2:43:34
	 */
	public String useAccountScore(AccountInfo accountInfo,AccountScoreBean accountScoreBean) throws Exception;

	/**
	 * 发放鱼干奖励
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月26日 下午2:43:34
	 */
	public double updateAccountScore(Integer reward,AccountInfo accountInfo, AccountScoreBean accountScoreInfo,String flag) throws Exception;
	
	/**
	 * 发放新手专享标再投奖励
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月26日 下午2:43:34
	 */
	public double updateAccountNewSubjectCount(Integer reward,AccountInfo accountInfo) throws Exception;

	/**
	 * 发放优惠券奖励
	 * @Description:
	 * @param reward
	 * @param accountInfo
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月26日 下午2:58:21
	 */
	public double grantRewards(Integer reward,AccountInfo accountInfo,String flag) throws Exception;
	
	/**
	 * 添加用户积分记录
	 * @Description:
	 * @param accountScoreBean
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月26日 下午5:50:32
	 */
	public void addScoreRecord(AccountScoreBean accountScoreBean) throws Exception;

}
