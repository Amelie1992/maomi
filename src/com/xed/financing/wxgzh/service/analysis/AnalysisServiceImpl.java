/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.analysis.AnalysisServiceImpl
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
package com.xed.financing.wxgzh.service.analysis;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.analysis.AnalysisMapper;
import com.xed.financing.wxgzh.model.analysis.AnalysisBean;

/**
 * @className:com.xed.financing.wxgzh.service.analysis.AnalysisServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2018年6月8日 上午10:57:28
 * @author:QT
 */
@Service
public class AnalysisServiceImpl implements AnalysisService
{
	@Autowired
	private AnalysisMapper analysisMapper;

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.analysis.AnalysisService#addAccountAnalysis(com.xed.financing.wxgzh.model.analysis.AnalysisBean)
	 */
	@Override
	public void addAccountAnalysis(AnalysisBean analysisBean) throws SQLException
	{
		analysisMapper.addAccountAnalysis(analysisBean);
	}

}
