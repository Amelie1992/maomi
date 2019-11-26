/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月22日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.activityrecord;

import java.sql.SQLException;

import com.xed.financing.wxgzh.model.activityrecord.ActivityRecordBean;


/**
 *  活动记录
 * @className:com.xed.financing.wxgzh.mapper.activityrecord.ActivityRecordMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月10日 下午2:41:21
 * @author:WangJun
 */
public interface ActivityRecordMapper
{

	/**
	 * 获得未兑换的个数（按照编码分类）
	 * @Description:
	 * @param activityRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月22日 下午4:46:49
	 */
	public Integer countNotConvertible(ActivityRecordBean activityRecordBean) throws SQLException;
	
	/**
	 * 获得一个未兑换的字
	 * @Description:
	 * @param activityRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月22日 下午4:48:13
	 */
	public ActivityRecordBean getOneNotConvertible(ActivityRecordBean activityRecordBean) throws SQLException;
	
	
	/**
	 * 兑换集字
	 * @Description:
	 * @param activityRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月22日 下午4:54:50
	 */
	public Integer exchangeCalligraphy(ActivityRecordBean activityRecordBean) throws SQLException;


	/**
	 * 添加活动"字"
	 * @Description:
	 * @param activityRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年8月22日 下午4:59:02
	 */
	public Integer addActivityRecord(ActivityRecordBean activityRecordBean) throws SQLException;
	
}
