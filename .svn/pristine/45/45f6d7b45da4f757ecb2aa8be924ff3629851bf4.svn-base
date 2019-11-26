/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.pay.PayExportInfoService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年5月26日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.pay;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.pay.PayExportInfoBean;

/**
 * @className:com.xed.financing.wxgzh.service.pay.PayExportInfoService
 * @description:
 * @version:v1.0.0
 * @date:2017年5月26日 下午1:58:08
 * @author:Qian Tao
 */
public interface PayExportInfoService
{
	/**
	 * 保存
	 * 
	 * @Description:
	 * @param payExportInfoBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月26日 下午1:55:05
	 */
	public int savePayExport(PayExportInfoBean payExportInfoBean) throws SQLException;

	/**
	 * 修改错误代码
	 * 
	 * @Description:
	 * @param payExportInfoBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月27日 上午11:09:07
	 */
	public boolean updatePayExportStatus(PayExportInfoBean payExportInfoBean) throws SQLException;

	/**
	 * 
	 * @Description:查找
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:WangJun
	 * @date:2017年5月27日 下午3:47:42
	 */
	public List<PayExportInfoBean> queryPayExportAll() throws SQLException;

	public String queryAccountId(PayExportInfoBean payExportInfoBean) throws SQLException;
	
	public Boolean toPayExport(String telephones,String amt)throws Exception;
}
