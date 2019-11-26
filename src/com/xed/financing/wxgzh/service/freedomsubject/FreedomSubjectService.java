/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年8月22日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.freedomsubject;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;

/**
 * 猫咪宝service
 * @className:com.xed.financing.wxgzh.service.freedomsubject.FreedomSubjectService
 * @description:
 * @version:v1.0.0 
 * @date:2017年8月22日 上午11:58:16
 * @author:Qian Tao
 */
public interface FreedomSubjectService
{
	/**
	 * 
	 * 查询猫咪宝列表
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 上午11:48:36
	 */
	public List<FreedomSubjectBean> queryFreedomSubject(FreedomSubjectBean freedomSubjectBean) throws SQLException;

	/**
	 * 查询猫咪宝列表数量
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 上午11:49:56
	 */
	public Integer countFreedomSubject(FreedomSubjectBean freedomSubjectBean) throws SQLException;
	
	/**
	 * 查询猫咪宝详情
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 上午11:50:30
	 */
	public FreedomSubjectBean queryFreedomSubjectById(FreedomSubjectBean freedomSubjectBean) throws SQLException;
	
	/**
	 * 
	 * 查询七日年化利率和万分收益
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 上午11:51:11
	 */
	public List<FreedomSubjectBean> querySevenRateAndPromit(FreedomSubjectBean freedomSubjectBean) throws SQLException;

	/**
	 * 
	 * 查询七日年化利率和万份收益数量
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 上午11:54:24
	 */
	public Integer countSevenRateAndPromit(FreedomSubjectBean freedomSubjectBean) throws SQLException;
	
	/**
	 * 查询猫咪宝交易记录
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 上午11:55:22
	 */
	public List<FreedomSubjectBean> queryFreedomRecord(FreedomSubjectBean freedomSubjectBean) throws SQLException;
	
	/**
	 * 
	 * 查询猫咪宝交易记录数量
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 上午11:59:19
	 */
	public Integer countFreedomRecord(FreedomSubjectBean freedomSubjectBean) throws SQLException;
	
	/**
	 * 投猫咪宝
	 * @Description:
	 * @param freedomSubjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 下午4:49:13
	 */
	public void investFreedom(FreedomSubjectBean freedomSubjectBean,String money) throws SQLException;
	
	/**
	 * 转出
	 * @Description:
	 * @param money
	 * @param request
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月28日 下午6:49:55
	 */
	public String transferFreedom(String money,HttpServletRequest request) throws Exception; 
	

	/**
	 * 累计入团
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月28日 下午7:40:00
	 */
	public Integer countFightGroups(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	
	/**
	 * 累计收益
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月28日 下午7:40:43
	 */
	public FreedomSubjectBean countPromit(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	/**
	 * 查询我的猫咪宝
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月28日 下午6:48:03
	 */
	public List<FreedomSubjectBean> queryMyFreedomSubject(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	
	/**
	 * 查询昨日七日年化和收益
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月29日 下午6:14:30
	 */
	public FreedomSubjectBean queryYesterdayRateAndPromitById(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	
	/**
	 * 猫咪宝提现
	 * @Description:
	 * @param request
	 * @param response
	 * @param accountName
	 * @param bankCard
	 * @param money
	 * @param bankName
	 * @param isComp
	 * @param count
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月30日 下午4:33:04
	 */
	public String withdrawMon(HttpServletRequest request, HttpServletResponse response,
			String accountName, String bankCard, String money, String bankName, String isComp, String count,Boolean tq)throws Exception;
	
	/**
	 * 
	 * 查询当天猫咪宝投资量
	 * @Description:
	 * @param freedomSubjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月18日 上午9:55:14
	 */
	public String querySumTodayMoney(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	
}
