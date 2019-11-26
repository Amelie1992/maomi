/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.withdraw.WithdrawController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年4月13日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.withdraw;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xed.financing.wxgzh.mapper.bondtransfer.BondTransferMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.mapper.coupon.CouponMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.model.accountbankcard.AccountBankcardBean;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.accountbankcard.AccountBankcardService;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.capitaldetail.CapitaldetailService;
import com.xed.financing.wxgzh.service.withdrawrecord.WithdrawRecordService;

/**
 * 账户提现控制器
 * 
 * @className:com.xed.financing.wxgzh.controller.withdraw.WithdrawController
 * @description: 账户提现
 * @version:v1.0.0
 * @date:2017年4月13日 上午10:19:46
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/ios/withdraw")
public class WithdrawInterfaceController
{

	@Autowired
	private CapitalService capitalService;

	@Autowired
	private AccountInfoService accountInfoService;

	@Autowired
	private AccountBankcardService accountBankcardService;

	@Autowired
	private CapitaldetailService capitaldetailService;
	
	@Autowired
	private AccountLevelService accountLevelService;
	
	@Resource
	private BondTransferMapper bondTransferMapper;

	@Resource
	public CapitalMapper capMapper;

	@Resource
	private CouponMapper couponMapper;
	
	@Resource
	private ParamMapper paramMapper;

	@Resource
	public MessageMapper messageMapper;
	
	@Resource
	public WithdrawRecordService withdrawRecordService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(WithdrawInterfaceController.class);

	/**
	 * 去提现
	 * @Description:/ios/withdraw/rechargeInfo?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月11日 上午11:09:36
	 */
	@ResponseBody
	@RequestMapping("/rechargeInfo")
	public JSONObject rechargeInfo(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		CapitalBean capitalBean = new CapitalBean();
		AccountBankcardBean bankcardBean;
		Integer count = 0;
		try
		{
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			capitalBean.setAccountId(accountInfo.getAccountId());
			count = capitaldetailService.queryUserDraw(capitalBean.getAccountId());
			bankcardBean = accountBankcardService.getAccountBankcardByAccountId(accountInfo.getAccountId());
			AccountInfo account= accountLevelService.queryAccountLevel(accountInfo);
			//提现券数量
			CouponBean coupon = new CouponBean();
			coupon.setAccountId(accountInfo.getAccountId());
			coupon.setCouponType("4");
			Integer couponCount = couponMapper.countNotUsedByType(coupon);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			JSONObject objs = new JSONObject();
			//特权提现次数
			objs.put("withdrawalsNumber", account.getWithdrawalsNumber());
			//免费提现次数
			objs.put("freeWithdrawalsNumber", account.getFreeWithdrawalsNumber());
			//用户银行卡信息
			objs.put("bankcardBean", bankcardBean);
			//用户提现次数
			objs.put("count", count);
			//提现券数量
			objs.put("couponCount", couponCount);
			//用户类型(0:个人 1:公司 2:虚拟 3:羊毛党)
			objs.put("isComp", accountInfo.getIsCompany());
			//用户资金信息
			objs.put("capitalBean", capitalBean);
			msg = "";
			code = "200";
			obj.put("data", objs);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			logger.error("提现模块，查询个人账户异常", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 先判断可提现金额，再执行提现
	 * @Description:/ios/withdraw/withdrawMon?accountId=&money=&bankCard=&bankName=&isComp=&count=&tq=&txq=
	 * @param accountId	用户id
	 * @param money	提现金额
	 * @param bankCard	银行卡号
	 * @param bankName	银行名称
	 * @param isComp	用户类型(0:个人 1:公司 2:虚拟 3:羊毛党)
	 * @param count	用户提现次数
	 * @param tq	是否使用特权提现
	 * @param txq	是否使用提现券
	 * @return
	 * @throws IOException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年7月3日 上午11:41:45
	 */
	@ResponseBody
	@RequestMapping("/withdrawMon")
	public Map<String, Object> queryMoney(String accountId,Double money, String bankCard,
			String bankName, String isComp, String count, Boolean tq, Boolean txq) throws IOException
	{
		Map<String, Object> obj = new HashMap<String, Object>();
		Map<String, Object> objs = new HashMap<String, Object>();
		Map<String, Object> resutMap = new HashMap<String, Object>();
		Date date = new Date();
		Integer hours = date.getHours();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		CapitalBean capitalBean = new CapitalBean();
		try
		{
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			if (capitalBean.getAvailableBalance() < money)
			{
				msg = "提现金额大于可提现金额";
				code = "400";
			} else {
				try
				{
						resutMap.put("code",withdrawRecordService.iosWithdrawMon(accountId, null, bankCard, money, bankName, isComp, count, tq, txq) );
						if ("200".equals(resutMap.get("code"))) 
						{
							if (tq)
							{
								code = "201";
								msg = "特权提现申请成功!提现金额将于当日到账,请关注到账时间!";
							} else if(hours == 14) {
								code = "200";
								msg = "提现申请成功!每日14至15点之前申请提现,提现金额将于当日到账,请关注到账时间!";
							} else {
								code = "202";
								msg = "提现申请成功!每日15点之后申请提现,提现金额将于次日到账,请关注到账时间!";
							}
						} else if("overtop".equals(resutMap.get("code"))) {
							code = "300";
							msg = "超出特权提现限额!";
						} else if("notEnough".equals(resutMap.get("code"))) {
							code = "301";
							msg = "特权提现次数不足!";
						} else {
							code = "302";
							msg = "违规操作!";
						}
				}
				catch (Exception e) {
					logger.error("提现模块，执行提现异常", e);
					e.printStackTrace();
				} finally {
					obj.put("msg", msg);
					obj.put("code", code);
				}
			}
		}
		catch (SQLException e) {
			logger.error("提现模块，查询用户总余额异常", e);
			e.printStackTrace();
		} finally {
			obj.put("msg", msg);
			obj.put("code", code);
		}
		return obj;
	}
	
}
