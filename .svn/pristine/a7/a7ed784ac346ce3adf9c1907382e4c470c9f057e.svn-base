/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.capital.CapitalInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:penggang
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月17日    penggang  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.capital;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.controller.capital.CapitalController;
import com.xed.financing.wxgzh.mapper.autobid.AutoBidMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.autobid.AutobidInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.model.coupon.CouponBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.model.savings.SavingsBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.capitaldetail.CapitaldetailService;
import com.xed.financing.wxgzh.service.coupon.CouponService;
import com.xed.financing.wxgzh.service.message.MessageService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.service.savings.SavingsService;
import com.xed.financing.wxgzh.service.signin.SignInService;
import com.xed.financing.wxgzh.service.subjectpic.SubjectPicService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.intface.capital.CapitalInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月17日 下午4:42:46
 * @author:penggang
 */
@Controller
@RequestMapping("/ios/capital")
public class CapitalInterfaceController
{
	@Autowired
	private CapitalService capitalService;
	
	@Autowired
	private CapitaldetailService capitaldetailService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private SignInService signInService;

	@Autowired
	private CouponService couponService;

	@Autowired
	private AccountInfoService accountInfoService;
	
	@Autowired
	private ParamService paramService;
	
	@Autowired
	private SubjectPicService subjectPicService;
	
	@Autowired
	private SavingsService savingsService;
	
	@Resource
	private AutoBidMapper autobidMapper;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(CapitalController.class);

	/**
	 * 
	 * @Description:
	 * @param request
	 * @param capitalBean
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月28日 下午5:27:18
	 */
	@ResponseBody
	@RequestMapping("/querycapital")
	public JSONObject  queryCapital(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 总资产
		double totalAsset;
		// 可用余额
		double availableBalance;
		// 投资金额
		double investmentMoney;
		// 用户积分
		String accountScore;
		// 用户经验值
		String accountExp;
		// 用户会员等级
		String accountLevel;
		// 获取的数据格式化保留两位小数
		DecimalFormat df = new DecimalFormat("0.00");

		CapitalBean capitalBean = new CapitalBean();
		CapitalBean accountBean = new CapitalBean();

		MessageBean messageBean = new MessageBean();

		try
		{
			// 获取账户id
			capitalBean.setAccountId(accountId);

			// 提取公共方法
			capitalBean = capitalService.queryCapitalById(capitalBean);
			accountBean = capitalService.queryAccountInfo(capitalBean);

			// 获取投资金额
			investmentMoney = capitalBean.getInvestmentMoney();

			// 获取冻结金额
			double freezeMoney = capitalBean.getFreezeMoney();

			// 获取可提现金额
			double withdrawMoney = capitalBean.getWithdrawMoney();

			// 获取不可提现金额
			double noWithdrawMoney = capitalBean.getNoWithdrawMoney();

			// 猫咪宝金额
			double freedomMoney = capitalBean.getFreedomMoney();

			// 获取提现中金额
			double nowWithdrawMoney = capitalBean.getNowWithdrawMoney();
			
			//总投资金额
			double usedMoney = investmentMoney + freedomMoney;

			// 获取总资产
			totalAsset = investmentMoney + freezeMoney + withdrawMoney + noWithdrawMoney + freedomMoney
					+ nowWithdrawMoney;

			// 获取可用余额
			availableBalance = noWithdrawMoney + withdrawMoney;

			// 获取用户名
			String accountName = accountBean.getAccountName();

			// 获取用户手机号
			String telePhone = accountBean.getTelePhone();

			// 手机号加密
			telePhone = telePhone.substring(0, 3) + "****" + telePhone.substring(7);

			CapitalDetail detail = new CapitalDetail();
			detail.setAccountId(accountId);
			
			// 投标收益
			detail.setType("4");
			String monthInvestProfit = capitaldetailService.selAccumulatedIncomeMonthById(detail);
			String totalInvestProfit = capitaldetailService.selAccumulatedIncomeById(detail);

			// 累计猫咪宝收益(元)
			detail.setType("14");
			String monthFreedomProfit = capitaldetailService.selAccumulatedIncomeMonthById(detail);
			String totalFreedomProfit = capitaldetailService.selAccumulatedIncomeById(detail);

			// 累计充值总额(元)
			detail.setType("0");
			String totalRecharge = capitaldetailService.selAccumulatedIncomeById(detail);

			// 累计提现总额(元)
			detail.setType("5");
			String totalCashWithdrawal = capitaldetailService.selAccumulatedIncomeById(detail);
			
			//当月总收益
			String monthProfit = MoneyUtils.formatFloatNumber(Double.parseDouble(monthInvestProfit) + Double.parseDouble(monthFreedomProfit));

			/**
			 * 用户等级暂且与数据库同步。后期另做更改
			 */

			// 获取用户积分
			accountScore = accountBean.getAccountScore();

			// 获取用户会员等级
			accountLevel = accountBean.getAccountLevel();

			// 获取用户经验值
			accountExp = accountBean.getAccountExp();

			messageBean.setAccountId(accountId);

			// 判断是否签到
			Integer isSignIn = signInService.checkSignIn(accountId);

			// 可用优惠券数量
			CouponBean couponBean = new CouponBean();
			couponBean.setIsUsed(Constants.DEVIL_NUM_ZERO);
			couponBean.setAccountId(accountId);
			couponBean.setIsBad(Constants.DEVIL_NUM_ZERO);
			
			//获取用户猫咪储蓄金额
			SavingsBean savingsBean = new SavingsBean();
			savingsBean.setAccountId(accountId);
			SavingsBean sBean = savingsService.findAllMonetById(savingsBean);
			
			String savingsMoney = sBean.getSavingsMoney();
			
			double sMoney = Double.parseDouble(savingsMoney) / 100;
			if(sMoney >= 100){
				sMoney = 100;
			}
			
			AutobidInfo autobidInfo = autobidMapper.getAccountAutobid(accountId);
			
			obj.put("msg", "");
			obj.put("code", 200);
			JSONObject objs = new JSONObject();
			
			//0未签到  1已签到
			objs.put("isSign", isSignIn);
			
			//自动投标  autobidInfo==null || autobidInfo.status!=1  未设置
			if(StringTools.isNullOrEmpty(autobidInfo))
			{
				objs.put("autobidInfo","");
			}
			else
			{
				objs.put("autobidInfo",JsonUtil.beanToJson(autobidInfo));
			}
			
			
			//猫咪储蓄金额
			objs.put("sMoney", df.format(sMoney));
			
			//猫咪储蓄提取总金额
			detail.setType("19");
			objs.put("stotalMoney", capitaldetailService.selAccumulatedIncomeById(detail));
			//总资产
			objs.put("totalAsset", df.format(totalAsset));
			
			//投资金额
			objs.put("investmentMoney", df.format(investmentMoney));
			
			//可用余额
			objs.put("availableBalance", df.format(availableBalance));
			
			//用户名
			objs.put("accountName", accountName);
			
			//我的鱼干
			objs.put("accountScore", accountScore);
			
			//等级
			objs.put("accountLevel", accountLevel);
			
			//未读消息 >0
			objs.put("noReadMessage", messageService.countNoRead(messageBean));
			
			//优惠券张数
			objs.put("myCoupon", couponService.countCapitalCoupon(couponBean));
			
			//accountBean.accountIcon 用于查询头像
			objs.put("accountBean", accountInfoService.getAccountInfo(accountId));
			
			//当月收益
			objs.put("monthProfit", monthProfit);
			
			//累计投标收益
			objs.put("totalInvestProfit", totalInvestProfit);
			
			//累计猫咪宝收益
			objs.put("totalFreedomProfit", totalFreedomProfit);
			
			//累计充值金额
			objs.put("totalRecharge", totalRecharge);
			
			//累计提现金额
			objs.put("totalCashWithdrawal", totalCashWithdrawal);
			
			obj.put("data",objs);
		}
		catch (SQLException e)
		{
			logger.error("查询个人中心金额总览失败", e);
		}
		
		
		return obj;
	}
	
	/**
	 * 资金明细
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年4月23日 上午11:25:00
	 */
	@ResponseBody
	@RequestMapping("/getAllCapitaldetail")
	public JSONObject getAllCapitaldetail(String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		String msg="";
		int code=300;
		List<CapitalDetail> getAll;
		try
		{
			CapitalDetail capitalDetail =new CapitalDetail();
			// 从session中查询出账户ID
			capitalDetail.setAccountId(accountId);
			getAll = capitaldetailService.getAll(capitalDetail);
			objs.put("capitalDetailList", getAll);
			code=200;
		}
		catch (SQLException e)
		{
			logger.error("查询资金记录列表异常", e);
			msg="查询资金明细页面异常";
		}
		obj.put("data",objs);
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 根据交易类型查看自己明细明细
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/capital/getTypeQurey?accountId=&type=
	 * @param type
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年5月25日 上午10:19:49
	 */
	@ResponseBody
	@RequestMapping("/getTypeQurey")
	public JSONObject getTypeQurey(String type,String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		List<CapitalDetail> typeList=null;
		try
		{
			typeList = capitaldetailService.iosGetTypeQuret(type,accountId);
			JSONObject objs = new JSONObject();
			objs.put("capitalDetailList", typeList);
			msg = "";
			code = "200";
			obj.put("data", objs);
		}
		catch (SQLException e1)
		{
			e1.printStackTrace();
			logger.error("获取查询类型异常", e1);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
}
