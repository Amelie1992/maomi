package com.xed.financing.wxgzh.mapper.savings;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.savings.SavingsBean;


/**
 * 猫咪储蓄
 * @className:com.xed.financing.wxgzh.mapper.savings.SavingsMapper
 * @description:
 * @version:v1.0.0 
 * @date:2018年1月8日 上午10:50:16
 * @author:Peng Gang
 */
public interface SavingsMapper
{
	/** 
	 * 查询当前用户  猫咪储蓄 总额
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 上午11:44:23
	 */
	public SavingsBean findAllMonetById(SavingsBean savingsBean)throws SQLException;
	
	
	
	/**
	 * 添加猫咪储蓄记录
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午1:46:27
	 */
	public Integer addSavingsRecord(SavingsBean savingsBean)throws SQLException;
	
	/**
	 * 更改赠送人
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午1:52:37
	 */
	public Integer updateGiveAccountId(SavingsBean savingsBean)throws SQLException;
	
	/**
	 * 更改提现后的状态
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午2:01:38
	 */
	public Integer updateWithdrawalsType(SavingsBean savingsBean)throws SQLException;
	
	/**
	 * 更改使用后的状态
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午2:08:20
	 */
	public Integer updateUseType(SavingsBean savingsBean)throws SQLException;
	
	/**
	 * 查询最近的一条记录
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午3:20:51
	 */
	public SavingsBean findSavingsNearest(SavingsBean savingsBean)throws SQLException;
	
	/**
	 * 查询未使用的
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月9日 下午5:58:34
	 */
	public List<SavingsBean> findNotUsed(SavingsBean savingsBean)throws SQLException;
	
	/**
	 * 查询
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月9日 下午5:58:34
	 */
	public List<SavingsBean> findSavingsOther(SavingsBean savingsBean)throws SQLException;
	
	/**
	 * 查询红包信息
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月10日 上午11:51:47
	 */
	public SavingsBean findSavingsInfo(SavingsBean savingsBean)throws SQLException;
	
	/**
	 * 更改 未使用红包过期 状态
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月15日 上午10:12:12
	 */
	public Integer updateSavingsValidaty() throws SQLException;
	
	/**
	 * 查询注册用户有赠送的储蓄红包
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:penggang
	 * @date:2018年1月24日 下午3:19:28
	 */
	public Integer findGivedRedp(String accountId) throws SQLException;
	
	/**
	 * 查询
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月9日 下午5:58:34
	 */
	public List<SavingsBean> findGivedRedpList(String accountId)throws SQLException;
	
	/**
	 * 更改赠送人 未注册的
	 * @Description:
	 * @param savingsBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2018年1月8日 下午1:52:37
	 */
	public Integer updateGiveAccountIdno(SavingsBean savingsBean)throws SQLException;
	
}
