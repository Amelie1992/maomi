/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.analysis.AnalysisMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年6月8日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.analysis;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.analysis.AnalysisBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.analysis.AnalysisMapper
 * @description:
 * @version:v1.0.0 
 * @date:2018年6月8日 上午10:54:23
 * @author:QT
 */
public interface AnalysisMapper
{
	/**
	 * 添加用户分析
	 * @Description:
	 * @param analysisBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年6月8日 上午10:50:02
	 */
	public void addAccountAnalysis(AnalysisBean analysisBean) throws SQLException;
}
