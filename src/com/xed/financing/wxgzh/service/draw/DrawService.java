/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.bondtransfer.BondTransferService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月17日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.draw;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.draw.DrawBean;

/**
 * 积分抽奖
 * @className:com.xed.financing.wxgzh.service.awardrotate.AwardRotateService
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月26日 下午2:37:00
 * @author:Elias Zheng
 */
public interface DrawService
{
	/**
	 * 查询获奖记录集合
	 * @Description:
	 * @param drawBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月27日 上午9:21:51
	 */
	public List<DrawBean> queryDrawList(DrawBean drawBean) throws SQLException;
	
	/**
	 * 查询获奖记录
	 * @Description:
	 * @param drawBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月27日 上午9:21:51
	 */
	public List<DrawBean> queryDraw(DrawBean drawBean) throws SQLException;
	
	/**
	 * 添加获奖记录
	 * @Description:
	 * @param drawBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月27日 上午9:21:51
	 */
	public void addDraw(DrawBean drawBean) throws SQLException;
	
	/**
	 * 删除获奖记录
	 * @Description:
	 * @param drawBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月27日 上午9:21:51
	 */
	public void deleteDraw(DrawBean drawBean) throws SQLException;

}
