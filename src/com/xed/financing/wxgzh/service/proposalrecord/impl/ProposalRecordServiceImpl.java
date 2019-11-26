/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.payentry.impl.PayEntryInfoServiceImpl
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
package com.xed.financing.wxgzh.service.proposalrecord.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.proposalrecord.ProposalRecordMapper;
import com.xed.financing.wxgzh.model.proposalrecord.ProposalRecordBean;
import com.xed.financing.wxgzh.service.proposalrecord.ProposalRecordService;

/**
 * 意见反馈
 * @className:com.xed.financing.wxgzh.service.proposalrecord.impl.ProposalRecordServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年6月17日 上午10:47:56
 * @author:Elias Zheng
 */
@Service
public class ProposalRecordServiceImpl implements ProposalRecordService
{

	@Autowired
	private ProposalRecordMapper proposalRecordMapper;
	

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.proposalrecord.ProposalRecordService#queryProposalList(com.xed.financing.wxgzh.model.proposalrecord.ProposalRecordBean)
	 */
	@Override
	public List<ProposalRecordBean> queryProposalList(ProposalRecordBean proposalRecordBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return proposalRecordMapper.queryProposalList(proposalRecordBean);
	}


	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.proposalrecord.ProposalRecordService#addProposal(com.xed.financing.wxgzh.model.proposalrecord.ProposalRecordBean)
	 */
	@Override
	public void addProposal(ProposalRecordBean proposalRecordBean) throws SQLException
	{
		// TODO Auto-generated method stub
		proposalRecordMapper.addProposal(proposalRecordBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.proposalrecord.ProposalRecordService#updateProposal(com.xed.financing.wxgzh.model.proposalrecord.ProposalRecordBean)
	 */
	@Override
	public void updateProposal(ProposalRecordBean proposalRecordBean) throws SQLException
	{
		// TODO Auto-generated method stub
		proposalRecordMapper.updateProposal(proposalRecordBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.proposalrecord.ProposalRecordService#deleteProposal(com.xed.financing.wxgzh.model.proposalrecord.ProposalRecordBean)
	 */
	@Override
	public void deleteProposal(ProposalRecordBean proposalRecordBean) throws SQLException
	{
		// TODO Auto-generated method stub
		proposalRecordMapper.deleteProposal(proposalRecordBean);
	}
	
}
