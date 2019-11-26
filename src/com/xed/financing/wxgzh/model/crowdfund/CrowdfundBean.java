/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月20日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.crowdfund;

/**
 * 众筹bean
 * @className:com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月20日 下午1:56:13
 * @author:QT
 */
public class CrowdfundBean
{
	/**
	 * id
	 */
	private String crowdId;
	
	/**
	 * 众筹名称
	 */
	private String crowdName;
	
	/**
	 * 众筹金额
	 */
	private String crowdMoney;
	
	/**
	 * 众筹利率
	 */
	private String crowdRate;
	
	/**
	 * 每份金额
	 */
	private String eachMoney;
	
	/**
	 * 最小份数
	 */
	private String minEach;
	
	/**
	 * 最大份数
	 */
	private String maxEach;
	
	/**
	 * 档位
	 */
	private String crowdGrade;
	/**
	 * 添加时间
	 */
	private String addDate;
	
	/**
	 * 众筹开始拼团时间
	 */
	private String beginDate;
	
	/**
	 * 众筹拼团结束时间
	 */
	private String groupDate;
	
	/**
	 * 众筹活动结束时间
	 */
	private String endDate;
	
	/**
	 * 活动周期（天）
	 */
	private String activityDay;
	
	/**
	 * 商品id
	 */
	private String goodsId;
	
	/**
	 * 众筹状态（0未开始 1拼团开始  2拼团满标 3拼团时间结束 4拼团失败 5众筹结束 ）
	 */
	private String crowdStatus;
	
	/**
	 * 描述
	 */
	private String remark;
	
	/**
	 * 记录id
	 */
	private String recordId;
	
	/**
	 * 用户id
	 */
	private String accountId;
	
	/**
	 * 参与众筹时间
	 */
	private String crowdDate;
	
	/**
	 * 中奖编号
	 */
	private String crowdNum;
	
	/**
	 * 是否中奖(0:否 1:是)
	 */
	private String isWinning;
	
	/**
	 * 是否发奖(0:否 1:是)  
	 */
	private String isReward;
	
	/**
	 * 发奖时间
	 */
	private String rewardDate;
	
	/**
	 * 众筹数量
	 */
	private String crowdfundCount;
	
	private String crowdGoldInvestMoney;
	/*
	 * --------------------------商品信息---------------------------
	 */
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	
	/**
	 * 商品原价
	 */
	private String goodsMoney;
	
	/**
	 * 商品现价
	 */
	private String saleMoney;
	
	/**
	 * 添加时间
	 */
	private String addTime;
	
	/**
	 * 修改时间
	 */
	private String modTime;
	
	/**
	 * 库存
	 */
	private String goodsStock;
	
	/**
	 * 实际库存
	 */
	private String realStock;
	
	/**
	 * 规格
	 */
	private String goodsSpecs;
	
	/**
	 * 所属用途(0:积分兑换 1:积分抽奖 2:爆款投标  3众筹)  
	 */
	private String addType;
	
	/**
	 * 状态(0上架 1下架)     
	 */
	private String status;
	
	/*
	 * --------------------------商品图片---------------------------
	 */
	
	/**
	 * 图片id
	 */
	private String picId;
	
	/**
	 * 图片名字
	 */
	private String picName;
	
	/**
	 * 图片路径
	 */
	private String picUrl;
	
	/**
	 * 图片类型(0:商品图片)  
	 */
	private String picType;
	
	/**
	 * 上传时间
	 */
	private String uploadTime;
	
	/**
	 * 已投众筹/总份数
	 */
	private int percent;
	
	/**
	 * 剩余天数
	 */
	private String overDay;
	
	/**
	 * 已投份额
	 */
	private String per;
	
	/**
	 * 手机号码
	 */
	private String telephone;
	
	/**
	 * 分页标识
	 */
	private String limit;
	
	public String getCrowdGoldInvestMoney()
	{
		return crowdGoldInvestMoney;
	}

	public void setCrowdGoldInvestMoney(String crowdGoldInvestMoney)
	{
		this.crowdGoldInvestMoney = crowdGoldInvestMoney;
	}

	public String getCrowdGrade()
	{
		return crowdGrade;
	}

	public void setCrowdGrade(String crowdGrade)
	{
		this.crowdGrade = crowdGrade;
	}

	public String getLimit()
	{
		return limit;
	}

	public void setLimit(String limit)
	{
		this.limit = limit;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getPer()
	{
		return per;
	}

	public void setPer(String per)
	{
		this.per = per;
	}

	public String getOverDay()
	{
		return overDay;
	}

	public void setOverDay(String overDay)
	{
		this.overDay = overDay;
	}

	public int getPercent()
	{
		return percent;
	}

	public void setPercent(int percent)
	{
		this.percent = percent;
	}

	public String getCrowdfundCount()
	{
		return crowdfundCount;
	}

	public void setCrowdfundCount(String crowdfundCount)
	{
		this.crowdfundCount = crowdfundCount;
	}

	public String getCrowdNum()
	{
		return crowdNum;
	}

	public void setCrowdNum(String crowdNum)
	{
		this.crowdNum = crowdNum;
	}

	public String getCrowdName()
	{
		return crowdName;
	}

	public void setCrowdName(String crowdName)
	{
		this.crowdName = crowdName;
	}

	public String getCrowdId()
	{
		return crowdId;
	}

	public void setCrowdId(String crowdId)
	{
		this.crowdId = crowdId;
	}

	public String getCrowdMoney()
	{
		return crowdMoney;
	}

	public void setCrowdMoney(String crowdMoney)
	{
		this.crowdMoney = crowdMoney;
	}

	public String getCrowdRate()
	{
		return crowdRate;
	}

	public void setCrowdRate(String crowdRate)
	{
		this.crowdRate = crowdRate;
	}

	public String getEachMoney()
	{
		return eachMoney;
	}

	public void setEachMoney(String eachMoney)
	{
		this.eachMoney = eachMoney;
	}

	public String getMinEach()
	{
		return minEach;
	}

	public void setMinEach(String minEach)
	{
		this.minEach = minEach;
	}

	public String getMaxEach()
	{
		return maxEach;
	}

	public void setMaxEach(String maxEach)
	{
		this.maxEach = maxEach;
	}

	public String getAddDate()
	{
		return addDate;
	}

	public void setAddDate(String addDate)
	{
		this.addDate = addDate;
	}

	public String getBeginDate()
	{
		return beginDate;
	}

	public void setBeginDate(String beginDate)
	{
		this.beginDate = beginDate;
	}

	public String getGroupDate()
	{
		return groupDate;
	}

	public void setGroupDate(String groupDate)
	{
		this.groupDate = groupDate;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public String getActivityDay()
	{
		return activityDay;
	}

	public void setActivityDay(String activityDay)
	{
		this.activityDay = activityDay;
	}

	public String getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(String goodsId)
	{
		this.goodsId = goodsId;
	}

	public String getCrowdStatus()
	{
		return crowdStatus;
	}

	public void setCrowdStatus(String crowdStatus)
	{
		this.crowdStatus = crowdStatus;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getRecordId()
	{
		return recordId;
	}

	public void setRecordId(String recordId)
	{
		this.recordId = recordId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getCrowdDate()
	{
		return crowdDate;
	}

	public void setCrowdDate(String crowdDate)
	{
		this.crowdDate = crowdDate;
	}

	public String getIsWinning()
	{
		return isWinning;
	}

	public void setIsWinning(String isWinning)
	{
		this.isWinning = isWinning;
	}

	public String getIsReward()
	{
		return isReward;
	}

	public void setIsReward(String isReward)
	{
		this.isReward = isReward;
	}

	public String getRewardDate()
	{
		return rewardDate;
	}

	public void setRewardDate(String rewardDate)
	{
		this.rewardDate = rewardDate;
	}

	public String getGoodsName()
	{
		return goodsName;
	}

	public void setGoodsName(String goodsName)
	{
		this.goodsName = goodsName;
	}

	public String getGoodsMoney()
	{
		return goodsMoney;
	}

	public void setGoodsMoney(String goodsMoney)
	{
		this.goodsMoney = goodsMoney;
	}

	public String getSaleMoney()
	{
		return saleMoney;
	}

	public void setSaleMoney(String saleMoney)
	{
		this.saleMoney = saleMoney;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	public String getModTime()
	{
		return modTime;
	}

	public void setModTime(String modTime)
	{
		this.modTime = modTime;
	}

	public String getGoodsStock()
	{
		return goodsStock;
	}

	public void setGoodsStock(String goodsStock)
	{
		this.goodsStock = goodsStock;
	}

	public String getRealStock()
	{
		return realStock;
	}

	public void setRealStock(String realStock)
	{
		this.realStock = realStock;
	}

	public String getGoodsSpecs()
	{
		return goodsSpecs;
	}

	public void setGoodsSpecs(String goodsSpecs)
	{
		this.goodsSpecs = goodsSpecs;
	}

	public String getAddType()
	{
		return addType;
	}

	public void setAddType(String addType)
	{
		this.addType = addType;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getPicId()
	{
		return picId;
	}

	public void setPicId(String picId)
	{
		this.picId = picId;
	}

	public String getPicName()
	{
		return picName;
	}

	public void setPicName(String picName)
	{
		this.picName = picName;
	}

	public String getPicUrl()
	{
		return picUrl;
	}

	public void setPicUrl(String picUrl)
	{
		this.picUrl = picUrl;
	}

	public String getPicType()
	{
		return picType;
	}

	public void setPicType(String picType)
	{
		this.picType = picType;
	}

	public String getUploadTime()
	{
		return uploadTime;
	}

	public void setUploadTime(String uploadTime)
	{
		this.uploadTime = uploadTime;
	}

	public CrowdfundBean()
	{
		super();
	}

	public CrowdfundBean(String crowdId, String accountId, String crowdNum,String crowdGoldInvestMoney)
	{
		super();
		this.crowdId = crowdId;
		this.accountId = accountId;
		this.crowdNum = crowdNum;
		this.crowdGoldInvestMoney=crowdGoldInvestMoney;
	}
	
}
