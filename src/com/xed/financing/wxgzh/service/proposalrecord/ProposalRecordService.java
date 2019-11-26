/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.payentry.PayEntryInfoService
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
package com.xed.financing.wxgzh.service.proposalrecord;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.proposalrecord.ProposalRecordBean;

/**
 *意见反馈
 * @className:com.xed.financing.wxgzh.service.proposalrecord.ProposalRecordService
 * @description:
 * @version:v1.0.0 
 * @date:2017年6月17日 上午10:47:30
 * @author:Elias Zheng
 */
public interface ProposalRecordService
{
	/**
	 * 查询意见反馈
	 * @Description:
	 * @param proposalRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月19日 上午10:35:03
	 */
	public List<ProposalRecordBean> queryProposalList(ProposalRecordBean proposalRecordBean) throws SQLException;
	
	/**
	 * 添加意见反馈
	 * @Description:
	 * @param proposalRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月17日 上午10:29:11
	 */
	public void addProposal(ProposalRecordBean proposalRecordBean) throws SQLException;
	
	/**
	 * 修改意见反馈
	 * @Description:
	 * @param proposalRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月17日 上午10:29:22
	 */
	public void updateProposal(ProposalRecordBean proposalRecordBean) throws SQLException;
	
	/**
	 * 删除意见反馈
	 * @Description:
	 * @param proposalRecordBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月17日 上午10:29:28
	 */
	public void deleteProposal(ProposalRecordBean proposalRecordBean) throws SQLException;
}
