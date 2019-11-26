/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.signin.SignInBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月13日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.proposalrecord;

/**
 * 意见反馈
 * @className:com.xed.financing.wxgzh.model.proposalrecord.ProposalRecordBean
 * @description:
 * @version:v1.0.0 
 * @date:2017年6月17日 上午10:04:52
 * @author:Elias Zheng
 */
public class ProposalRecordBean
{
	/**
	 * 反馈ID
	 */
	private String proposalId;
	
	/**
	 * 用户ID
	 */
	private String accountId;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 电话
	 */
	private String telephone;

	/**
	 * 意见
	 */
	private String proposalContent;

	/**
	 * 是否已讨论(0:未阅读 1:已阅读 2:已讨论)
	 */
	private String isInvestigation;

	/**
	 * 是否采纳(0:未采纳 1:已采纳)
	 */
	private String isAdopt;
	
	/**
	 * 奖励内容
	 */
	private String rewardContent;

	/**
	 * 奖励是否发放(0:未发放 1:已发放)
	 */
	private String isReward;

	/**
	 * 反馈时间
	 */
	private String addTime;

	public String getProposalId()
	{
		return proposalId;
	}

	public void setProposalId(String proposalId)
	{
		this.proposalId = proposalId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getProposalContent()
	{
		return proposalContent;
	}

	public void setProposalContent(String proposalContent)
	{
		this.proposalContent = proposalContent;
	}

	public String getIsInvestigation()
	{
		return isInvestigation;
	}

	public void setIsInvestigation(String isInvestigation)
	{
		this.isInvestigation = isInvestigation;
	}

	public String getIsAdopt()
	{
		return isAdopt;
	}

	public void setIsAdopt(String isAdopt)
	{
		this.isAdopt = isAdopt;
	}

	public String getRewardContent()
	{
		return rewardContent;
	}

	public void setRewardContent(String rewardContent)
	{
		this.rewardContent = rewardContent;
	}

	public String getIsReward()
	{
		return isReward;
	}

	public void setIsReward(String isReward)
	{
		this.isReward = isReward;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	/**
	 * @param proposalId
	 * @param accountId
	 * @param name
	 * @param telephone
	 * @param proposalContent
	 * @param isInvestigation
	 * @param isAdopt
	 * @param rewardContent
	 * @param isReward
	 * @param addTime
	 */
	public ProposalRecordBean(String proposalId, String accountId, String name, String telephone,
			String proposalContent, String isInvestigation, String isAdopt, String rewardContent, String isReward,
			String addTime)
	{
		super();
		this.proposalId = proposalId;
		this.accountId = accountId;
		this.name = name;
		this.telephone = telephone;
		this.proposalContent = proposalContent;
		this.isInvestigation = isInvestigation;
		this.isAdopt = isAdopt;
		this.rewardContent = rewardContent;
		this.isReward = isReward;
		this.addTime = addTime;
	}

	/**
	 * 
	 */
	public ProposalRecordBean()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString()
	{
		return "ProposalRecordBean [proposalId=" + proposalId + ", accountId=" + accountId + ", name=" + name
				+ ", telephone=" + telephone + ", proposalContent=" + proposalContent + ", isInvestigation="
				+ isInvestigation + ", isAdopt=" + isAdopt + ", rewardContent=" + rewardContent + ", isReward="
				+ isReward + ", addTime=" + addTime + "]";
	}
	
}