/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.accountscore.AccountScoreBean
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
package com.xed.financing.wxgzh.model.accountscore;

/**
 * 用户积分明细
 * 
 * @className:com.xed.financing.wxgzh.model.accountscore.AccountScoreBean
 * @description:
 * @version:v1.0.0
 * @date:2017年4月7日 上午11:13:04
 * @author:ZhangJun
 */
public class AccountScoreBean
{
	/**
	 * 积分ID
	 */
	private String scoreId;

	/**
	 * 用户ID
	 */
	private String accountId;

	/**
	 * 变更积分
	 */
	private String score;

	/**
	 * 积分收支(0:收入 1:支出)
	 */
	private String inExpend;

	/**
	 * 积分类型(0:签到 1:完善信息 2:投标奖励 3:兑换积分 4:积分抽奖 5:购买积分 6:其他 7:积分退回 8:特权补签)
	 */
	private String scoreType;

	/**
	 * 变更时间
	 */
	private String modTime;

	/**
	 * 变更原因
	 */
	private String modReason;

	public String getScoreId()
	{
		return scoreId;
	}

	public void setScoreId(String scoreId)
	{
		this.scoreId = scoreId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getScore()
	{
		return score;
	}

	public void setScore(String score)
	{
		this.score = score;
	}

	public String getInExpend()
	{
		return inExpend;
	}

	public void setInExpend(String inExpend)
	{
		this.inExpend = inExpend;
	}

	public String getScoreType()
	{
		return scoreType;
	}

	public void setScoreType(String scoreType)
	{
		this.scoreType = scoreType;
	}

	public String getModTime()
	{
		return modTime;
	}

	public void setModTime(String modTime)
	{
		this.modTime = modTime;
	}

	public String getModReason()
	{
		return modReason;
	}

	public void setModReason(String modReason)
	{
		this.modReason = modReason;
	}

	public AccountScoreBean()
	{
		super();

	}

	public AccountScoreBean(String scoreId, String accountId, String score, String inExpend, String scoreType,
			String modTime, String modReason)
	{
		super();
		this.scoreId = scoreId;
		this.accountId = accountId;
		this.score = score;
		this.inExpend = inExpend;
		this.scoreType = scoreType;
		this.modTime = modTime;
		this.modReason = modReason;
	}

}
