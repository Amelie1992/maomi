/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.material.MaterialBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年9月8日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.material;

/**
 * 活动材料bean
 * @className:com.xed.financing.wxgzh.model.material.MaterialBean
 * @description:
 * @version:v1.0.0 
 * @date:2018年9月8日 上午9:48:35
 * @author:QT
 */
public class MaterialBean
{
	/**
	 * 材料主键
	 */
	private String materialId;
	
	/**
	 * 用户id
	 */
	private String accountId;     
	
	/**
	 * 拥有材料数量
	 */
	private String materialCount; 
	
	/**
	 * 材料明细主键
	 */
	private String materialDetailId;   
	
	/**
	 * 消耗材料
	 */
	private String material;  
	
	/**
	 *  收支(0:收入 1:支出)        
	 */
	private String inExpend;                                                                                                                                                                                                          
	
	/**
	 * 是否折现(0否  1是)
	 */
	private String isDiscount;
	
	/**
	 * 类型（1投资获取 2满签获取 3抽奖获取 4邀请好友投资获取 5兑换10现金券 6兑换100现金券 7兑换300月饼 8兑换小米空气净化器 9兑换小米8 64G 10兑换iphone8 64G 11兑换iphoneX 256G）  
	 */
	private String materialType;      
	
	/**
	 * 添加时间     
	 */
	private String addTime;                                                                                                                                                                                                                            
	
	/**
	 * 说明 
	 */
	private String remark;

	public String getMaterialId()
	{
		return materialId;
	}

	public void setMaterialId(String materialId)
	{
		this.materialId = materialId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getMaterialCount()
	{
		return materialCount;
	}

	public void setMaterialCount(String materialCount)
	{
		this.materialCount = materialCount;
	}

	public String getMaterialDetailId()
	{
		return materialDetailId;
	}

	public void setMaterialDetailId(String materialDetailId)
	{
		this.materialDetailId = materialDetailId;
	}

	public String getMaterial()
	{
		return material;
	}

	public void setMaterial(String material)
	{
		this.material = material;
	}

	public String getInExpend()
	{
		return inExpend;
	}

	public void setInExpend(String inExpend)
	{
		this.inExpend = inExpend;
	}

	public String getIsDiscount()
	{
		return isDiscount;
	}

	public void setIsDiscount(String isDiscount)
	{
		this.isDiscount = isDiscount;
	}

	public String getMaterialType()
	{
		return materialType;
	}

	public void setMaterialType(String materialType)
	{
		this.materialType = materialType;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}     
	
	
}
