/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.datasplit.DataSplitMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月22日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.datasplit;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;
import com.xed.financing.wxgzh.model.subjectdispersed.SubjectDispersedBean;


/**
 * @className:com.xed.financing.wxgzh.mapper.datasplit.DataSplitMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月22日 下午4:23:31
 * @author:Qian Tao
 */
public interface DataSplitMapper
{
	/**
	 * 获取猫咪宝当前所有投资人的投资时间和投资总金额
	 * 
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月13日 下午2:15:54
	 */
	public List<FreedomSubjectBean> getFreedomInvestInfo()throws SQLException;
	
	/**
	 * 删除投资用户的分团记录
	 * 
	 * @Description:
	 * @param freedomSubjectBeans
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月13日 下午3:28:35
	 */
	public void deleteDispersedRecord(List<FreedomSubjectBean> freedomSubjectBeans) throws SQLException;
	
	/**
	 * 查询所有未满标的分散标
	 * 
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月13日 下午3:29:01
	 */
	public List<SubjectDispersedBean> getSubjectDispersed() throws SQLException;
	
	/**
	 * 添加分散标投资记录
	 * 
	 * @Description:
	 * @param subjectDispersedBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月13日 下午4:01:43
	 */
	public void addSubjectDispersed(SubjectDispersedBean subjectDispersedBean) throws SQLException;
	
}
