/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.material.MaterialService
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
package com.xed.financing.wxgzh.service.material;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.material.MaterialBean;

/**
 * 活动材料接口
 * @className:com.xed.financing.wxgzh.service.material.MaterialService
 * @description:
 * @version:v1.0.0 
 * @date:2018年9月8日 上午10:36:24
 * @author:QT
 */
public interface MaterialService
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
	 * 发送月饼
	 * @Description:
	 * @param count
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月8日 下午1:50:52
	 */
	public void sendMoon(int count,String type,String accountId,String money,String recommedPhone)throws SQLException;
	
	/**
	 * 兑换月饼
	 * @Description:
	 * @param count (扣除完当前所剩余的月饼)
	 * @param type
	 * @param accountId
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月8日 下午4:56:21
	 */
	public void convertMoon(String count,String material,String type,String accountId)throws SQLException;
	
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
