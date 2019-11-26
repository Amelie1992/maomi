/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.freesubject.FreedomSubjectMapper
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
package com.xed.financing.wxgzh.mapper.freesubject;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.freesubject.FreedomSubjectMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年8月22日 上午11:47:13
 * @author:Qian Tao
 */
public interface FreedomSubjectMapper
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
	 * @date:2017年8月22日 上午11:56:25
	 */
	public Integer countFreedomRecord(FreedomSubjectBean freedomSubjectBean) throws SQLException;
	
	/**
	 * 修改猫咪宝额度
	 * @Description:
	 * @param freedomSubjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 下午5:42:28
	 */
	public void updateFreedomSubject(FreedomSubjectBean freedomSubjectBean) throws SQLException;
	
	/**
	 * 
	 * 添加猫咪宝记录
	 * @Description:
	 * @param freedomSubjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年8月22日 下午6:06:10
	 */
	public void addFreedomSubject(FreedomSubjectBean freedomSubjectBean) throws SQLException;
	
	
	/**
	 * 获取用户未合并的猫咪宝投资记录
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月25日 下午5:36:49
	 */
	public List<FreedomSubjectBean> getNoMergeFreedomSubject(String accountId)throws SQLException;
	
	
	/**
	 * 删除投标记录（金额清空 软删除）
	 * @Description:
	 * @param freedomSubjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月25日 下午6:14:54
	 */
	public void updateRecordToDelete(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	
	
	/**
	 * 修改投标记录 (减少金额)
	 * @Description:
	 * @param freedomSubjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月25日 下午6:16:19
	 */
	public void updateRecordToReduce(FreedomSubjectBean freedomSubjectBean)throws SQLException;
	
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
