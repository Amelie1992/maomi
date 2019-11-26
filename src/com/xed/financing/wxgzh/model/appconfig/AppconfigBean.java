/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.appconfig.AppconfigBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:penggang
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月17日    penggang  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.appconfig;

/**
 * @className:com.xed.financing.wxgzh.model.appconfig.AppconfigBean
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月17日 上午10:58:10
 * @author:penggang
 */
public class AppconfigBean
{
	/**
	 * app图片key
	 */
	private String picId;   
	
	/**
	 * 图片路径
	 */
	private String picUrl;      
	
	/**
	 * 图片标识(0:显示, 1:隐藏)       
	 */
	private String picFlag;     
	
	/**
	 * 图片链接
	 */
	private String picLink; 
	
	/**
	 * 显示标记(0:显示, 1:隐藏)            
	 */
	private String showFlag;  
	
	/**
	 * 添加时间
	 */
	private String addTime;  
	
	/**
	 * 描述
	 */
	private String remarks;

	public String getPicId()
	{
		return picId;
	}

	public void setPicId(String picId)
	{
		this.picId = picId;
	}

	public String getPicUrl()
	{
		return picUrl;
	}

	public void setPicUrl(String picUrl)
	{
		this.picUrl = picUrl;
	}

	public String getPicFlag()
	{
		return picFlag;
	}

	public void setPicFlag(String picFlag)
	{
		this.picFlag = picFlag;
	}

	public String getPicLink()
	{
		return picLink;
	}

	public void setPicLink(String picLink)
	{
		this.picLink = picLink;
	}

	public String getShowFlag()
	{
		return showFlag;
	}

	public void setShowFlag(String showFlag)
	{
		this.showFlag = showFlag;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	public String getRemarks()
	{
		return remarks;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}
	
}
