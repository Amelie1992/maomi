/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.material.MaterialMapper
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
package com.xed.financing.wxgzh.mapper.material;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.material.MaterialBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.material.MaterialMapper
 * @description:
 * @version:v1.0.0 
 * @date:2018年9月8日 上午9:56:28
 * @author:QT
 */
public interface MaterialMapper
{
	/**
	 * 判断用户是否有材料表数据
	 * @Description:
	 * @param materialBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月8日 上午10:30:34
	 */
	public Integer countIsExById(String  accountId) throws SQLException;
	
	/**
	 * 添加材料表
	 * @Description:
	 * @param materialBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月8日 上午10:31:00
	 */
	public void addMaterial(MaterialBean materialBean) throws SQLException;
	
	/**
	 * 根据用户id查询材料数量
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月8日 上午10:32:08
	 */
	public Integer queryMaterialCountById(String  accountId) throws SQLException;
	
	/**
	 * 根据用户查询消耗材料明细
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月8日 上午10:32:41
	 */
	public List<MaterialBean> queryMaterialDetailById(MaterialBean materialBean) throws SQLException;
	
	/**
	 * 修改材料表
	 * @Description:
	 * @param materialBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月8日 上午10:33:25
	 */
	public void editMaterialById(MaterialBean materialBean) throws SQLException;
	
	/**
	 * 添加材料明细表
	 * @Description:
	 * @param materialBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月8日 上午10:34:36
	 */
	public void addMaterialDetailById(MaterialBean materialBean) throws SQLException;
	
	/**
	 * 折现
	 * @Description:
	 * @param materialBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月11日 上午11:18:10
	 */
	public void editIsDiscountBy(MaterialBean materialBean) throws SQLException;
}
