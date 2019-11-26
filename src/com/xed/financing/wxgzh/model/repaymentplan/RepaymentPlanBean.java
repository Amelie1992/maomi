/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.repaymentplan.RepaymentPlan
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年5月4日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.repaymentplan;

/**
 * 还款计划表
 * @className:com.xed.financing.wxgzh.model.repaymentplan.RepaymentPlan
 * @description:
 * @version:v1.0.0
 * @date:2018年5月4日 下午3:32:07
 * @author:ZhangJun
 */
public class RepaymentPlanBean
{

	/**
	 * 还款记录ID
	 */
	private String actualId;

	/**
	 * 借款ID
	 */
	private String subjectId;

	/**
	 * 应还本金
	 */
	private String backPrincipal;

	/**
	 * 应还利息
	 */
	private String backInterest;

	/**
	 * 违约金
	 */
	private String liquidatedDamages;

	/**
	 * 预计回款金额
	 */
	private String backMoney;

	/**
	 * 实际回款金额
	 */
	private String actualMoney;

	/**
	 * 待还金额
	 */
	private String pendingMoney;

	/**
	 * 预计回款时间
	 */
	private String backTime;

	/**
	 * 实际回款时间
	 */
	private String actualTime;

	/**
	 * 还款状态(1:待还,2: 未还清,3:已还,4:逾期未还,5:逾期已还,6:提前还款)
	 */
	private String repaymentStatus;

	/**
	 * 逾期费用
	 */
	private String overdueCost;

	/**
	 * 说明
	 */
	private String remark;

	public String getActualId()
	{
		return actualId;
	}

	public void setActualId(String actualId)
	{
		this.actualId = actualId;
	}

	public String getSubjectId()
	{
		return subjectId;
	}

	public void setSubjectId(String subjectId)
	{
		this.subjectId = subjectId;
	}

	public String getBackPrincipal()
	{
		return backPrincipal;
	}

	public void setBackPrincipal(String backPrincipal)
	{
		this.backPrincipal = backPrincipal;
	}

	public String getBackInterest()
	{
		return backInterest;
	}

	public void setBackInterest(String backInterest)
	{
		this.backInterest = backInterest;
	}

	public String getLiquidatedDamages()
	{
		return liquidatedDamages;
	}

	public void setLiquidatedDamages(String liquidatedDamages)
	{
		this.liquidatedDamages = liquidatedDamages;
	}

	public String getBackMoney()
	{
		return backMoney;
	}

	public void setBackMoney(String backMoney)
	{
		this.backMoney = backMoney;
	}

	public String getActualMoney()
	{
		return actualMoney;
	}

	public void setActualMoney(String actualMoney)
	{
		this.actualMoney = actualMoney;
	}

	public String getPendingMoney()
	{
		return pendingMoney;
	}

	public void setPendingMoney(String pendingMoney)
	{
		this.pendingMoney = pendingMoney;
	}

	public String getBackTime()
	{
		return backTime;
	}

	public void setBackTime(String backTime)
	{
		this.backTime = backTime;
	}

	public String getActualTime()
	{
		return actualTime;
	}

	public void setActualTime(String actualTime)
	{
		this.actualTime = actualTime;
	}

	public String getRepaymentStatus()
	{
		return repaymentStatus;
	}

	public void setRepaymentStatus(String repaymentStatus)
	{
		this.repaymentStatus = repaymentStatus;
	}

	public String getOverdueCost()
	{
		return overdueCost;
	}

	public void setOverdueCost(String overdueCost)
	{
		this.overdueCost = overdueCost;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public RepaymentPlanBean()
	{
		super();
	}

	public RepaymentPlanBean(String actualId, String subjectId, String backPrincipal, String backInterest,
			String liquidatedDamages, String backMoney, String actualMoney, String pendingMoney, String backTime,
			String actualTime, String repaymentStatus, String overdueCost, String remark)
	{
		super();
		this.actualId = actualId;
		this.subjectId = subjectId;
		this.backPrincipal = backPrincipal;
		this.backInterest = backInterest;
		this.liquidatedDamages = liquidatedDamages;
		this.backMoney = backMoney;
		this.actualMoney = actualMoney;
		this.pendingMoney = pendingMoney;
		this.backTime = backTime;
		this.actualTime = actualTime;
		this.repaymentStatus = repaymentStatus;
		this.overdueCost = overdueCost;
		this.remark = remark;
	}

}
