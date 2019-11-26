/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.manager.model.category.CategoryBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月24日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.category;

import java.io.Serializable;

/**
 * 数据字典
 * @className:com.xed.financing.manager.model.category.CategoryBean
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月24日 下午2:49:49
 * @author:QT
 */
public class CategoryBean implements Serializable
{
	/**
	 * 数据字典id
	 */
	private String categoryId;

	/**
	 * 数据字典key
	 */
	private String categoryKey;

	/**
	 * 数据字典类别
	 */
	private String categoryType;

	/**
	 * 数据字典名称
	 */
	private String categoryName;

	/**
	 * 上级数据字典
	 */
	private String supCategoryType;

	/**
	 * 状态
	 */
	private String status;
	
	/**
	 * 添加时间
	 */
	private String addTime;
	
	/**
	 * 修改时间
	 */
	private String updateTime;
	
	/**
	 * zTree
	 */
	private String id;
	
	private String pId;
 
	private String name;
	
	private String type;
	
	/**
	 * 分页
	 */
	private Integer fromNum = 0;

	private Integer toNum = 0;
	
	private Integer pagenum=10;
	
	private String beginTime;
	
	private String endTime;

	public String getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(String categoryId)
	{
		this.categoryId = categoryId;
	}

	public String getCategoryKey()
	{
		return categoryKey;
	}

	public void setCategoryKey(String categoryKey)
	{
		this.categoryKey = categoryKey;
	}

	public String getCategoryType()
	{
		return categoryType;
	}

	public void setCategoryType(String categoryType)
	{
		this.categoryType = categoryType;
	}

	public String getCategoryName()
	{
		return categoryName;
	}

	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}

	public String getSupCategoryType()
	{
		return supCategoryType;
	}

	public void setSupCategoryType(String supCategoryType)
	{
		this.supCategoryType = supCategoryType;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	public String getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(String updateTime)
	{
		this.updateTime = updateTime;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getpId()
	{
		return pId;
	}

	public void setpId(String pId)
	{
		this.pId = pId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Integer getFromNum()
	{
		return fromNum;
	}

	public void setFromNum(Integer fromNum)
	{
		this.fromNum = fromNum;
	}

	public Integer getToNum()
	{
		return toNum;
	}

	public void setToNum(Integer toNum)
	{
		this.toNum = toNum;
	}

	public Integer getPagenum()
	{
		return pagenum;
	}

	public void setPagenum(Integer pagenum)
	{
		this.pagenum = pagenum;
	}

	public String getBeginTime()
	{
		return beginTime;
	}

	public void setBeginTime(String beginTime)
	{
		this.beginTime = beginTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}
	
}
