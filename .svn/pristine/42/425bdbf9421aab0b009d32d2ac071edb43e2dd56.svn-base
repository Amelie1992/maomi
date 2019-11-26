/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.playRecord.PlayRecordMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年5月27日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.playRecord;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.playRecord.PlayRecordBean;


/**
 * @className:com.xed.financing.wxgzh.mapper.playRecord.PlayRecordMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月27日 上午9:45:36
 * @author:Qian Tao
 */
public interface PlayRecordMapper
{
	/**
	 * 添加游戏记录
	 * @Description:
	 * @param playRecord
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年9月8日 下午2:29:23
	 */
	public Integer addPlayRecord(PlayRecordBean playRecord)throws SQLException;
	
	/**
	 * 查询游戏记录
	 * @Description:
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月19日 上午10:55:34
	 */
	public List<PlayRecordBean> queryPlayRecordBeanList() throws SQLException;
	
	/**
	 * 查询用户最高分
	 * @Description:
	 * @param playRecordBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月20日 上午9:16:09
	 */
	public PlayRecordBean selPlayRecordBean(PlayRecordBean playRecordBean)throws SQLException;
	
}
