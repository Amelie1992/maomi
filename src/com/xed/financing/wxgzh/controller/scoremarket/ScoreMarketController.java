/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.subject.SubjectController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月16日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.scoremarket;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xed.financing.wxgzh.model.accountaddress.AccountAddressBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.goodsinfo.GoodsInfoBean;
import com.xed.financing.wxgzh.model.goodsorder.GoodsOrderBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountaddress.AccountAddressService;
import com.xed.financing.wxgzh.service.goodsinfo.GoodsInfoService;
import com.xed.financing.wxgzh.service.goodsorder.GoodsOrderService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 
 * @className:com.xed.financing.wxgzh.controller.scoremarket.ScoreMarketController
 * @description:
 * @version:v1.0.0
 * @date:2017年4月17日 下午2:49:25
 * @author:Elias Zheng
 */
@Controller
@RequestMapping("/scoremarket")
public class ScoreMarketController
{
	@Autowired
	private GoodsInfoService goodsInfoService;

	@Autowired
	private GoodsOrderService goodsOrderService;

	@Autowired
	private AccountInfoService accountInfoService;

	@Autowired
	private AccountAddressService accountAddressService;

	@Autowired
	private ParamService paramService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(ScoreMarketController.class);

	/**
	 * 查询积分商城
	 * 
	 * @Description:
	 * @param request
	 * @param type
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月17日 下午2:50:16
	 */
	@RequestMapping("/queryscoremarket")
	public String queryScoreMarket(GoodsInfoBean goodsInfoBean, HttpServletRequest request)
	{
		/*// 积分兑换商品类型为0
		goodsInfoBean.setAddType(Constants.DEVIL_NUM_ZERO);

		List<GoodsInfoBean> queryGoodsInfoList = null;*/

		/*try
		{
			// 查询积分商品列表
			queryGoodsInfoList = goodsInfoService.queryGoodsInfo(goodsInfoBean);

			// 集合传入页面
			request.setAttribute("goodsInfoList", queryGoodsInfoList);

			// 查询用户积分
			request.setAttribute("accountScore", accountInfoService.getLoginAccountInfo(request).getAccountScore());

		}
		catch (SQLException e)
		{
			logger.error("查询积分商品列表异常", e);
		}*/

		// 跳转页面
		return "scoremarket/scoremarketlist";
	}

	/**
	 * 查询兑换记录
	 * 
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月17日 下午3:55:31
	 */
	@RequestMapping("/queryscoreconvertrecord")
	public String queryScoreConvertRecord(GoodsOrderBean goodsOrderBean, HttpServletRequest request)
	{

		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();

		goodsOrderBean.setAccountId(accountId);
		goodsOrderBean.setOrderType(Constants.DEVIL_NUM_ZERO);

		List<GoodsOrderBean> queryGoodsOrderList = null;

		try
		{
			// 查询商品订单列表
			queryGoodsOrderList = goodsOrderService.queryGoodsOrderByAccountId(goodsOrderBean);

			// 集合传入页面
			request.setAttribute("goodsOrderList", queryGoodsOrderList);

		}
		catch (SQLException e)
		{
			logger.error("查询用户积分兑换列表异常", e);
		}

		// 跳转页面
		return "scoremarket/scoreconvertrecord";
	}

	/**
	 * 进入兑换详情页面
	 * 
	 * @Description:
	 * @param goodsInfoBean
	 * @param request
	 * @param goodsId
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月18日 下午5:37:19
	 */
	@RequestMapping("/gotoconvert")
	public String queryGoToConvert(GoodsInfoBean goodsInfoBean, AccountAddressBean accountAddressBean,
			HttpServletRequest request, String goodsId)
	{
		// 积分兑换商品类型为0
		goodsInfoBean.setGoodsId(goodsId);
		goodsInfoBean.setAddType(Constants.DEVIL_NUM_ZERO);

		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		// 用户默认地址类型为1
		accountAddressBean.setAccountId(accountId);
		accountAddressBean.setIsDefault(Constants.DEVIL_NUM_ONE);

		try
		{

			// 详情传入页面
			request.setAttribute("goodsInfo", goodsInfoService.queryGoodsInfoById(goodsInfoBean));

			// 查询用户积分
			request.setAttribute("accountScore", accountInfoService.getLoginAccountInfo(request).getAccountScore());

			// 查询用户地址
			request.setAttribute("accountAddress",
					accountAddressService.queryAccountAddressDefaultById(accountAddressBean));

		}
		catch (SQLException e)
		{
			logger.error("查询积分商品详情异常", e);
		}

		// 跳转页面
		return "scoremarket/scoreconvert";
	}

	/**
	 * 进入兑换详情页面
	 * 
	 * @Description:
	 * @param goodsInfoBean
	 * @param request
	 * @param goodsId
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月18日 下午5:37:19
	 */
	@RequestMapping("/convertgoods")
	public String convertGoods(GoodsInfoBean goodsInfoBean, GoodsOrderBean goodsOrderBean,AccountInfo accountInfo,
			AccountAddressBean accountAddressBean, HttpServletRequest request)
	{
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		
		// 用户默认地址类型为1
		accountAddressBean.setAccountId(accountId);
		accountAddressBean.setIsDefault(Constants.DEVIL_NUM_ONE);

		// 积分兑换商品类型为0
		goodsInfoBean.setAddType(Constants.DEVIL_NUM_ZERO);

		List<GoodsInfoBean> queryGoodsInfoList = null;

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
			
			//操作积分兑换
			goodsOrderService.convertGoods(goodsInfoBean,goodsOrderBean,accountInfo);

			// 查询积分商品列表
			queryGoodsInfoList = goodsInfoService.queryGoodsInfo(goodsInfoBean);

			// 集合传入页面
			request.setAttribute("goodsInfoList", queryGoodsInfoList);

			// 查询用户积分
			request.setAttribute("accountScore", accountInfoService.getLoginAccountInfo(request).getAccountScore());

		}
		catch (SQLException e)
		{
			logger.error("查询积分商品列表异常", e);
		}

		// 跳转页面
		return "scoremarket/scoremarketlist";
	}

}
