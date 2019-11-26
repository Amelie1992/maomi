/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月7日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.accountScore;

import java.util.List;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月7日 上午11:28:59
 * @author:ZhangJun
 */
public interface AccountScoreMapper
{
	
	/**
	 *  查询用户经验和积分 
	 * @Description:
	 * @param accountId
	 * @return 返回查找出的用户经验，积分，ID
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月7日 下午1:59:54
	 */
	public AccountInfo findScoreAndExp(String accountId);
	
	
	/**
	 * 修改用户经验和积分
	 * @Description: 
	 * @param accountInfo 用户ID，修改后的经验，积分
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月7日 下午2:00:33
	 */
	public Integer changeScoreAndExp(AccountInfo accountInfo);
	
	
	/**
	 * 添加积分变更明细
	 * @Description:
	 * @param accountScoreBean
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月7日 下午2:01:16
	 */
	public Integer addAccountScoreInfo(AccountScoreBean accountScoreBean);
	
	/**
	 * 查询用户积分明细
	 * @Description:
	 * @param accountScoreBean
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年4月7日 下午2:01:16
	 */
	public List<AccountScoreBean> queryAccountScore(AccountScoreBean accountScoreBean);
	
}
