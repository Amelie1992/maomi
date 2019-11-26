package com.xed.financing.wxgzh.model.goodsinfo;

/**
 * 商品信息
 * @className:com.xed.financing.wxgzh.model.goodsinfo.GoodsInfo
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月12日 下午3:58:30
 * @author:Elias Zheng
 */
public class GoodsInfoBean
{
	/**
	 * 商品ID
	 */
	private String goodsId;
	
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
	 * 剩余库存
	 */
	private String realStock;
	
	/**
	 * 商品规格
	 */
	private String goodsSpecs;
	
	/**
	 * 说明
	 */
	private String remark;
	
	/**
	 * 所属用途(0:积分兑换 1:积分抽奖 2:爆款投标 )
	 */
	private String addType;
	
	/**
	 * 商品图片
	 */
	private String goodsPic;
	
	/**
	 * 状态
	 */
	private String status;

	public String getGoodsId()
	{
		return goodsId;
	}

	public void setGoodsId(String goodsId)
	{
		this.goodsId = goodsId;
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

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getAddType()
	{
		return addType;
	}

	public void setAddType(String addType)
	{
		this.addType = addType;
	}

	public String getGoodsPic()
	{
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic)
	{
		this.goodsPic = goodsPic;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "GoodsInfo [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsMoney=" + goodsMoney
				+ ", saleMoney=" + saleMoney + ", addTime=" + addTime + ", modTime=" + modTime + ", goodsStock="
				+ goodsStock + ", realStock=" + realStock + ", goodsSpecs=" + goodsSpecs + ", remark=" + remark
				+ ", addType=" + addType + ", goodsPic=" + goodsPic + ", status=" + status + "]";
	}

	/**
	 * @param goodsId
	 * @param goodsName
	 * @param goodsMoney
	 * @param saleMoney
	 * @param addTime
	 * @param modTime
	 * @param goodsStock
	 * @param realStock
	 * @param goodsSpecs
	 * @param remark
	 * @param addType
	 * @param goodsPic
	 * @param status
	 */
	public GoodsInfoBean(String goodsId, String goodsName, String goodsMoney, String saleMoney, String addTime,
			String modTime, String goodsStock, String realStock, String goodsSpecs, String remark, String addType,
			String goodsPic, String status)
	{
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsMoney = goodsMoney;
		this.saleMoney = saleMoney;
		this.addTime = addTime;
		this.modTime = modTime;
		this.goodsStock = goodsStock;
		this.realStock = realStock;
		this.goodsSpecs = goodsSpecs;
		this.remark = remark;
		this.addType = addType;
		this.goodsPic = goodsPic;
		this.status = status;
	}

	/**
	 * 
	 */
	public GoodsInfoBean()
	{
		super();
	}

}
