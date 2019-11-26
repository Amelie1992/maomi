/**
 * Copyright (C) 2017 FZJT Co.Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.capitaldetail.impl.CapitaldetailService
 * @description:资金记录Service层
 * 
 * @version:v1.0.0 
 * @author:WangLin
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月16日    WangLin  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.capitaldetail;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;

/**
 * @className:com.xed.financing.wxgzh.service.capitaldetail.impl.CapitaldetailService
 * @description:资金记录Service层
 * @version:v1.0.0 
 * @date:2017年3月16日 下午3:09:45
 * @author:WangLin
 */
public interface CapitaldetailService
{
	/**
	 * 
	 * @Description:查询列表
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月16日 下午3:12:06
	 */
	List<CapitalDetail> getAll(CapitalDetail capitalDetail) throws SQLException;
	
	/**
	 * 
	 * @Description:根据id查询
	 * @param id
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月16日 下午3:12:18
	 */
	CapitalDetail getById(Integer id) throws SQLException;
	
	/**
	 *  查询用户累计收益金额(元)
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月20日 下午3:54:34
	 */
	String selAccumulatedIncomeById(CapitalDetail detail) throws SQLException;
	
	/**
	 *  查询用户当月收益金额(元)
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年7月20日 下午3:54:34
	 */
	String selAccumulatedIncomeMonthById(CapitalDetail detail) throws SQLException;
	
	/**
	 * 根据类型查集合
	 * 
	 * @Description:根据类型查集合
	 * @param type
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月16日 下午6:32:38
	 */
	List<CapitalDetail> getTypeQuret(String type,HttpServletRequest request) throws SQLException;
	
	List<CapitalDetail> iosGetTypeQuret(String type,String accountId) throws SQLException;

	Integer queryUserDraw(String accountId)throws SQLException;
	
	/**
	 * 查询列表
	 * 
	 * @Description:查询所有列表
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月16日 上午11:21:35
	 */
	public List<CapitalDetail> getAllByType(CapitalDetail capitalDetail) throws SQLException;
	
	/**
	 * 查询记录
	 * @Description:
	 * @param capitalDetail
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年9月4日 下午3:44:06
	 */
	public List<CapitalDetail> queryDetailByType(CapitalDetail capitalDetail) throws SQLException;
	
	/**
	 * 猫咪宝投资总金额
	 * @param capitalDetail
	 * @return
	 * @throws SQLException
	 */
	public String countSumFreedomSubjectMoney(CapitalDetail capitalDetail) throws SQLException;
}
