package com.xed.financing.wxgzh.service.sorting;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;

/**
 * 
 * @className:com.xed.financing.wxgzh.service.sorting.SortingService
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月10日 下午3:39:44
 * @author:Peng Gang
 */
public interface SortingService
{
	/**
	 * 排行榜 
	 * @Description:0:总榜  1：月榜
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月10日 下午3:40:34
	 */
	public List<InvestRecordBean> queryInvestRecordBeanlList(String flag) throws SQLException;

}
