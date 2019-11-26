/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.coupon.CouponController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月22日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.proposalrecord;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.proposalrecord.ProposalRecordBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.proposalrecord.ProposalRecordService;
import com.xed.financing.wxgzh.util.Constants;

/**
 * 意见反馈
 * @className:com.xed.financing.wxgzh.controller.proposalrecord.ProposalRecordController
 * @description:
 * @version:v1.0.0 
 * @date:2017年6月17日 上午10:49:22
 * @author:Elias Zheng
 */
@Controller
@RequestMapping("/proposalrecord")
public class ProposalRecordController
{
	@Autowired
	private ProposalRecordService proposalRecordService;
	
	@Autowired
	private AccountInfoService accountInfoService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(ProposalRecordController.class);
	
	/**
	 * 进入意见反馈中心
	 * @Description:
	 * @param request
	 * @param couponBean
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月17日 上午10:50:27
	 */
	@RequestMapping("/s/goproposalcenter")
	public String goProposalCenter(HttpServletRequest request, ProposalRecordBean proposalRecordBean)
	{
		return "proposalrecord/proposalCenter";
	}
	
	/**
	 * 进入意见反馈奖励公告
	 * @Description:
	 * @param request
	 * @param couponBean
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月17日 上午10:50:27
	 */
	@RequestMapping("/s/goproposalreward")
	public String goProposalReward(HttpServletRequest request, ProposalRecordBean proposalRecordBean)
	{
		List<ProposalRecordBean> proList;
		try
		{
			//奖励是否发放(0:未发放 1:已发放)
			proposalRecordBean.setIsReward(Constants.DEVIL_NUM_ONE);
			
			proList = proposalRecordService.queryProposalList(proposalRecordBean);
			request.setAttribute("proList", proList);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "proposalrecord/proposalReward";
	}
	
	/**
	 * 进入意见反馈说明
	 * @Description:
	 * @param request
	 * @param couponBean
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月17日 上午10:50:27
	 */
	@RequestMapping("/s/goproposalexplain")
	public String goProposalExplain(HttpServletRequest request)
	{
		return "proposalrecord/proposalExplain";
	}

	/**
	 * 进入意见反馈页面
	 * @Description:
	 * @param request
	 * @param couponBean
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年6月17日 上午10:50:27
	 */
	@RequestMapping("/s/goproposalrecord")
	public String goProposalRecord(HttpServletRequest request, ProposalRecordBean proposalRecordBean)
	{
		AccountInfo accountInfo;
		try
		{
			// 从session中查询出账户ID
			if(request.getSession().getAttribute("account") != null){
				String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
				accountInfo = accountInfoService.getAccountInfo(accountId);
				request.setAttribute("accountInfo", accountInfo);
			}
		}
		catch (SQLException e)
		{
			logger.error("进入意见反馈页面异常", e);
		}
		return "proposalrecord/proposalRecord";
	}

	@RequestMapping("/s/recordproposal")
	public String recordProposal(HttpServletRequest request, ProposalRecordBean proposalRecordBean)
	{ 
		try
		{
			proposalRecordService.addProposal(proposalRecordBean);
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("添加反馈信息异常",e);
		}
		return "redirect:/proposalrecord/s/goproposalcenter";
	}

}
