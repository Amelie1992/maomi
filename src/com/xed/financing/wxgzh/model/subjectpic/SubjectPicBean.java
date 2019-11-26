/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.model.subject.SubjectBean
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月16日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.model.subjectpic;

/**
 * 标的图片
 * @className:com.xed.financing.wxgzh.model.subjectpic.SubjectPicBean
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月12日 上午9:01:51
 * @author:Elias Zheng
 */
public class SubjectPicBean
{
	/**
	 * 图片ID
	 */
	private String picId;
	
	/**
	 * 标的ID
	 */
	private String subjectId;
	
	/**
	 * 图片名称
	 */
	private String picName;
	
	/**
	 * 图片路径
	 */
	private String picUrl;
	
	/**
	 * 图片类型
	 */
	private int picType;
	
	/**
	 * 上传时间
	 */
	private String uploadTime;
	
	/**
	 * 修改时间
	 */
	private String modTime;
	
	/**
	 * 图片说明
	 */
	private String remark;

	public String getPicId()
	{
		return picId;
	}

	public void setPicId(String picId)
	{
		this.picId = picId;
	}

	public String getSubjectId()
	{
		return subjectId;
	}

	public void setSubjectId(String subjectId)
	{
		this.subjectId = subjectId;
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

	public int getPicType()
	{
		return picType;
	}

	public void setPicType(int picType)
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

	public String getModTime()
	{
		return modTime;
	}

	public void setModTime(String modTime)
	{
		this.modTime = modTime;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	@Override
	public String toString()
	{
		return "SubjectPicBean [picId=" + picId + ", subjectId=" + subjectId + ", picName=" + picName + ", picUrl="
				+ picUrl + ", picType=" + picType + ", uploadTime=" + uploadTime + ", modTime=" + modTime + ", remark="
				+ remark + "]";
	}

	/**
	 * @param picId
	 * @param subjectId
	 * @param picName
	 * @param picUrl
	 * @param picType
	 * @param uploadTime
	 * @param modTime
	 * @param remark
	 */
	public SubjectPicBean(String picId, String subjectId, String picName, String picUrl, int picType,
			String uploadTime, String modTime, String remark)
	{
		super();
		this.picId = picId;
		this.subjectId = subjectId;
		this.picName = picName;
		this.picUrl = picUrl;
		this.picType = picType;
		this.uploadTime = uploadTime;
		this.modTime = modTime;
		this.remark = remark;
	}

	/**
	 * 
	 */
	public SubjectPicBean()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param picId
	 * @param subjectId
	 * @param picName
	 * @param picUrl
	 * @param picType
	 * @param uploadTime
	 * @param modTime
	 * @param remark
	 */
	public SubjectPicBean(String subjectId)
	{
		super();
		this.subjectId = subjectId;
	}
	
}
