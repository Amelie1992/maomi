/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.manager.dao.category.CategoryDAO
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
package com.xed.financing.wxgzh.mapper.category;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.category.CategoryBean;

/**
 * 查询推荐码
 * @className:com.xed.financing.wxgzh.mapper.category.CategoryMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年12月11日 下午2:35:28
 * @author:Peng Gang
 */
public interface CategoryMapper
{
	/**
	 * 查询所有推荐码
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月11日 下午2:41:29
	 */
	public List<CategoryBean> queryInviteCodeList() throws SQLException;
}
