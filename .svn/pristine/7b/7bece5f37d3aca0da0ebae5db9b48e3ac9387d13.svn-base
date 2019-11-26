/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.crowdfund.CrowdfundMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月20日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.crowdfund;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean;

/**
 * 
 * 众筹接口
 * @className:com.xed.financing.wxgzh.mapper.crowdfund.CrowdfundMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月20日 下午2:50:59
 * @author:QT
 */
public interface CrowdfundMapper
{
	/**
	 * 查询众筹集合 
	 * @Description:
	 * @param crowdfundBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月20日 下午4:02:41
	 */
	public List<CrowdfundBean> queryCrowfundList(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 
	 * 查询众筹数量
	 * @Description:
	 * @param crowdfundBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月20日 下午4:03:24
	 */
	public Integer countCrowfund(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 
	 * 查看众筹详情
	 * @Description:
	 * @param crowdfundBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月20日 下午4:03:55
	 */
	public CrowdfundBean queryCrowfundById(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 
	 * 添加众筹记录
	 * @Description:
	 * @param crowdfundBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月20日 下午4:04:36
	 */
	public void addCrowdfundingRecord(List<CrowdfundBean> crowdfundBean) throws SQLException;
	
	/**
	 * 查询用户投了几次众筹
	 * @Description:
	 * @param crowdfundBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月20日 下午4:05:08
	 */
	public Integer countCrowdfundingRecordById(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 修改众筹
	 * @Description:
	 * @param crowdfundBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月21日 上午10:30:30
	 */
	public void editCrowdfundingById(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 定时器筛选
	 * @Description:
	 * @param crowdfundBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月21日 下午5:01:06
	 */
	public List<CrowdfundBean> queryCrowfundListByStatus(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 用户置为已中奖
	 * @Description:
	 * @param crowdfundBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月22日 上午9:53:58
	 */
	public void editCrowdfundingRecord(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 通过众筹ID获取该笔众筹的众筹人对应的数量
	 * @Description:
	 * @param crowdId
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月22日 下午3:25:17
	 */
	public List<CrowdfundBean> findCrowdfundCount(String crowdId)throws SQLException;
	
	
	/**
	 * 查询众筹记录列表
	 * @Description:
	 * @param crowdfundBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月22日 下午4:03:51
	 */
	public List<CrowdfundBean> selCrowdfundingRecord(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 查询众筹中奖记录
	 * @Description:
	 * @param crowdfundBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月22日 下午4:03:51
	 */
	public List<CrowdfundBean> queryIsWinningBy(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 查询中奖数量
	 * @Description:
	 * @param crowdfundBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月23日 上午11:45:22
	 */
	public Integer countIsWinning(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 我的众筹列表
	 * @Description:
	 * @param crowdfundBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月23日 下午3:25:36
	 */
	public List<CrowdfundBean> queryMyCrowdfund(CrowdfundBean crowdfundBean) throws SQLException;
	
	/**
	 * 获取中奖人
	 * @Description:
	 * @param winning
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年11月24日 下午4:47:34
	 */
	public List<CrowdfundBean> getWinningUser(Map<String,Object> winning)throws SQLException;
	
}
