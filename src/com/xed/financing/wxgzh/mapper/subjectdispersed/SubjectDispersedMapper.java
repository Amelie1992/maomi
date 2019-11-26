
package com.xed.financing.wxgzh.mapper.subjectdispersed;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.subjectdispersed.SubjectDispersedBean;

/**
 * 
 * @className:com.xed.financing.wxgzh.mapper.subjectdispersed.DispersedMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月12日 上午10:53:38
 * @author:Peng Gang
 */
public interface SubjectDispersedMapper
{
	/**
	 * 查询所有筹标的总数
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月12日 上午10:56:37
	 */
	public Integer queryiIsStatus() throws SQLException;
	
	/**
	 * 查询各类标的总数、投资金额
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月12日 上午11:00:49
	 */
	public SubjectDispersedBean querySubjectOnTypesAndMonry(SubjectDispersedBean subjectDispersedBean) throws SQLException;
	
	/**
	 * 根据类型查询分散标集合
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月12日 上午11:51:58
	 */
	public List<SubjectDispersedBean> queryDispersedSubjectList(SubjectDispersedBean subjectDispersedBean) throws SQLException;
	
	/**
	 * 查看分散标详情
	 * @Description:
	 * @param subjectDispersedBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月12日 下午5:59:42
	 */
	public SubjectDispersedBean queryDispersedSubjectListById(SubjectDispersedBean subjectDispersedBean) throws SQLException;
	
	/**
	 * 
	 * 查询分散标投资记录
	 * @Description:
	 * @param subjectDispersedBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月13日 下午3:45:45
	 */
	public List<SubjectDispersedBean> queryFreedomInvest(SubjectDispersedBean subjectDispersedBean) throws SQLException;
	
	/**
	 * 根据标id查询投资总金额
	 * @Description:
	 * @param subjectDispersedBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月13日 下午6:40:29
	 */
	public String countInvestMoneyById(SubjectDispersedBean subjectDispersedBean) throws SQLException;
}
