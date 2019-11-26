/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.goodpic.GoodPicService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月23日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.goodpic;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.goodpic.GoodPicBean;

/**
 * @className:com.xed.financing.wxgzh.service.goodpic.GoodPicService
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月23日 下午7:00:58
 * @author:QT
 */
public interface GoodPicService
{
	/**
	 * 查询多张图片
	 * @Description:
	 * @param goodPicBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月23日 下午6:56:37
	 */
	public List<GoodPicBean> queryGoodPic(GoodPicBean goodPicBean) throws SQLException;
	
	/**
	 * 查询单张图片
	 * @Description:
	 * @param goodPicBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月23日 下午6:56:28
	 */
	public GoodPicBean queryGoodPicById(GoodPicBean goodPicBean) throws SQLException;
}
