package com.xed.financing.wxgzh.mapper.userhouse;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.userhouse.UserHouseBean;

public interface UserHouseMapper
{
	/**
	 * 获取借还人房屋信息
	 * @Description:
	 * @param userHouseBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年7月20日 上午9:20:49
	 */
	public UserHouseBean getUserHouseInfo(UserHouseBean userHouseBean)throws SQLException;
}
