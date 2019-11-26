/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.subject.HotSubjectController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月24日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.subject;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xed.financing.wxgzh.model.accountaddress.AccountAddressBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.goodsinfo.GoodsInfoBean;
import com.xed.financing.wxgzh.model.goodsorder.GoodsOrderBean;
import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;
import com.xed.financing.wxgzh.model.subject.SubjectBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountaddress.AccountAddressService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.goodsorder.GoodsOrderService;
import com.xed.financing.wxgzh.service.investrecord.InvestRecordService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.subject.SubjectService;
import com.xed.financing.wxgzh.service.userlevel.UserLevelService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 爆款标controller
 * @className:com.xed.financing.wxgzh.controller.subject.HotSubjectController
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月24日 上午10:21:28
 * @author:Qian Tao
 */
@Controller 
@RequestMapping("/hotsubject")
public class HotSubjectController
{
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private CapitalService capitalService;
	
	@Autowired
	private GoodsOrderService goodsOrderService;

	@Autowired
	private AccountInfoService accountInfoService;

	@Autowired
	private AccountAddressService accountAddressService;

	@Autowired
	private ParamService paramService;
	
	@Autowired
	private UserLevelService userLevelService;
	
	@Autowired
	private InvestRecordService investRecordService;
	
	@Autowired
	private CouponService couponService;


	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(HotSubjectController.class);

	/**
	 * 
	 * 查询列表
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月16日 上午11:09:39
	 */
	@RequestMapping("/s/queryhotsubject")
	public String querySubject(HttpServletRequest request, String type)
	{
		SubjectBean subjectBean = new SubjectBean();
		//如果没有传type  默认进新手专享
		if (StringTools.isNullOrEmpty(type))
		{
			type = "2";
		}
		subjectBean.setSubjectType(type);
		List<SubjectBean> querySubject = null;
		try
		{
			querySubject = subjectService.queryHotSubject(subjectBean);
			
			// 集合传入页面
			request.setAttribute("hotsubjectList", querySubject);	
			request.setAttribute("types", type);
		}
		catch (SQLException e)
		{
			logger.error("查询标列表异常", e);
		}

		// 跳转页面
		return "hotsubject/hotsubjectlist";
	}
	
	/**
	 * 爆款详情
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月24日 上午11:29:01
	 */
	@RequestMapping("/detailhotdetail")
	public String queryHotSubjectById(HttpServletRequest request,SubjectBean subjectBean,AccountAddressBean accountAddressBean)
	{
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		// 用户默认地址类型为1
		accountAddressBean.setAccountId(accountId);
		accountAddressBean.setIsDefault(Constants.DEVIL_NUM_ONE);
		try
		{
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			
			//查询用户金额
			capitalBean = capitalService.queryCapitalById(capitalBean);
			
			
			// 查询用户地址
			request.setAttribute("accountAddress",accountAddressService.queryAccountAddressDefaultById(accountAddressBean));
			request.setAttribute("availableBalance", capitalBean.getAvailableBalance());
			request.setAttribute("subjectInfo", subjectService.queryHotSubjectById(subjectBean));
		}
		catch (SQLException e)
		{
			logger.error("查询爆款详情异常", e);
		}
		return "hotsubject/hotsubjectdetail";
	}
	
	/**
	 * 兑换爆款标商品
	 * @Description:
	 * @param subjectBean
	 * @param goodsInfoBean
	 * @param goodsOrderBean
	 * @param accountInfo
	 * @param accountAddressBean
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月25日 上午11:33:10
	 */
	@RequestMapping("/hotsubjectgoods")
	public String convertGoods(SubjectBean subjectBean, GoodsInfoBean goodsInfoBean,GoodsOrderBean goodsOrderBean,AccountInfo accountInfo,
			AccountAddressBean accountAddressBean, HttpServletRequest request)
	{
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		
		// 用户默认地址类型为1
		accountAddressBean.setAccountId(accountId);
		accountAddressBean.setIsDefault(Constants.DEVIL_NUM_ONE);
		List<SubjectBean> queryGoodsInfoList = null;

		String money = goodsInfoBean.getGoodsMoney();
		try
		{
			accountInfo = accountInfoService.getLoginAccountInfo(request);
			
			//查询用户地址是否有默认,没有则新增
			accountAddressBean = accountAddressService.queryAccountAddressDefaultById(accountAddressBean);
			if(StringTools.isNullOrEmpty(accountAddressBean)){
				accountAddressBean = new AccountAddressBean();
				accountAddressBean.setAccountId(accountInfo.getAccountId());
				accountAddressBean.setUserName(goodsOrderBean.getOrderUserName());
				accountAddressBean.setUserTelephone(goodsOrderBean.getOrderUserTelephone());
				accountAddressBean.setUserAddress(goodsOrderBean.getOrderUserAddr());
				accountAddressBean.setIsDefault(Constants.DEVIL_NUM_ONE);
				accountAddressService.insertAccountAddress(accountAddressBean);
			}
			
			//爆款商品兑换
			subjectService.convertHotGoods(subjectBean,goodsInfoBean,goodsOrderBean,accountInfo);
			
			//兑换（投标）成功后查询赠送积分后是否可以升级
			//userLevelService.changeUserLevel(request);
			
			AccountInfo accountInfoBean = new AccountInfo();
			accountInfoBean=accountInfoService.getLoginAccountInfo(request);
					
			//判断是否有邀请人
			if(!StringTools.isNullOrEmpty(accountInfoBean.getRecommendTelephone()))
			{
				//判断是否第一次投标
				InvestRecordBean investRecordBean = new InvestRecordBean();
				investRecordBean.setAccountId(accountId);
				if(investRecordService.countFirstSubject(investRecordBean)==1)
				{
					//给邀请人发送优惠券
					couponService.inviteersReward(accountInfoBean, money);
				}
			}
			
			// 查询积分商品列表
			queryGoodsInfoList = subjectService.queryHotSubject(subjectBean);

			// 集合传入页面 返回首页数据
			request.setAttribute("hotsubjectList", queryGoodsInfoList);
		}
		catch (SQLException e)
		{
			logger.error("查询积分商品列表异常", e);
		}
		return "hotsubject/hotsubjectlist";
	}
}
