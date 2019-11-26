package com.xed.financing.wxgzh.mapper.userCapital;

import com.xed.financing.wxgzh.model.usercapital.UserCapitalBean;

/**
 * 
 * @className:com.xed.financing.wxgzh.mapper.userCapital.UserCapitalMapper
 * @description:
 * @version:v1.0.0 
 * @date:2018年5月7日 上午10:59:21
 * @author:zheng shuai
 */
public interface UserCapitalMapper
{
	
	/**
	 * 获取用户号码
	 * @Description:
	 * @param userId
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年5月8日 下午2:12:17
	 */
	public String getUserTelephone(String userId);
	
	/**
	 * 根据userId查询借款人资金
	 * @Description:
	 * @param userPhone
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月7日 下午4:53:45
	 */
	public UserCapitalBean queryUserCapital(String userPhone);
	
	/**
	 * 根据userId修改余额
	 * @Description:
	 * @param userCapitalBean
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月7日 下午5:03:18
	 */
	public void updateUserCapital(UserCapitalBean userCapitalBean);
}
