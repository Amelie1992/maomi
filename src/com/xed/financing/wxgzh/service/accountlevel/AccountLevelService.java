package com.xed.financing.wxgzh.service.accountlevel;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;


public interface AccountLevelService
{
	/**
	 * 
	 * @Description:查询上个月用户的签到次数
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月9日 下午5:43:32
	 */
	public void queryAccountLastMonthSigns()throws SQLException;
	
	/**
	 * 
	 * @Description:用户生日送现金券
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月10日 上午11:01:57
	 */
	public void accountBirthdayGiveCash()throws SQLException;
	
	/**
	 * 
	 * @Description:用户升级享受的特权叠加
	 * @param oldVIP
	 * @param newVIP
	 * @param accountId
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月10日 下午5:38:07
	 */
	public void  upgradeprivilege(int oldVIP,int newVIP,String accountId)throws SQLException; 
	
	/**
	 * 
	 * @Description:判断用户是否可以升级VIP等级
	 * @param accountId
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月10日 下午5:45:03
	 */
	public void  updateVIP(String accountId)throws SQLException;
	
	/**
	 * 
	 * @Description:月底查询用户投资金额是否满足降级条件
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月13日 上午11:53:10
	 */
	public void  accountDowngrade()throws SQLException;
	
	/**
	 * 
	 * @Description:月初刷新用户特权（补签次数和特权提现次数）
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月14日 下午3:37:50
	 */
	public void refeshPower()throws SQLException;
	
	/**
	 * 
	 * @Description:根据用户的VIP等级在投标时固定加息
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月17日 上午10:25:54
	 */
	public Double LevelIncreaseInterest(String accountId)throws SQLException;

	/**
	 * 根据用户的VIP等级在投标时固定收取利息管理费
	 * @Description:
	 * @param accountId
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年2月26日 下午4:18:27
	 */
	public Double LevelInterestManagement(String accountId) throws SQLException;
	
	/**
	 * 
	 * @Description:等级上线扫描一次根据用户投资金额刷新用户等级
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2017年11月15日 上午10:39:22
	 */
	/*public void refeshLevelOnlyOneTime()throws SQLException;*/
	
	
	/**
	 * 获取用户等级信息
	 * @Description:
	 * @param accountInfo
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月29日 上午11:00:11
	 */
	public AccountInfo queryAccountLevel(AccountInfo accountInfo) throws SQLException;
	
	/**
	 * 修改用户等级，降级，特权次数
	 * @Description:
	 * @param accountInfo
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月29日 下午3:00:12
	 */
	public void updateAccountVIP(AccountInfo accountInfo)throws SQLException;
}
