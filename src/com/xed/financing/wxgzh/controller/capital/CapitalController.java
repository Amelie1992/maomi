/**
 * Copyright (C) 2017 FZJT Co.Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.capital.CapitalController
 * @description:个人中心金额总览
 * 
 * @version:v1.0.0 
 * @author:WangLin
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月28日    WangLin  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.capital;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.capital.CapitalController
 * @description:个人中心金额总览
 * @version:v1.0.0
 * @date:2017年3月28日 下午4:09:05
 * @author:WangLin
 */
@Controller
@RequestMapping("/capital")
public class CapitalController
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
	@RequestMapping("/querycapital")
	public String queryCapital(HttpServletRequest request, CapitalBean capitalBean, HttpServletResponse response)
	{
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

		capitalBean = new CapitalBean();
		CapitalBean accountBean = new CapitalBean();

		MessageBean messageBean = new MessageBean();

		try
		{
			// 获取页面用户登录信息
			AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute("account");
			if (null == accountInfo)
			{
				// 用户不存在，就去登录页
				return "loginregister/login";
			}
			// 获取账户id
			capitalBean.setAccountId(accountInfo.getAccountId());

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
			detail.setAccountId(accountInfo.getAccountId());
			
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

			messageBean.setAccountId(accountInfo.getAccountId());

			// 判断是否签到
			Integer isSignIn = signInService.checkSignIn(accountInfo.getAccountId());
			request.setAttribute("isSign", isSignIn);

			// 可用优惠券数量
			CouponBean couponBean = new CouponBean();
			couponBean.setIsUsed(Constants.DEVIL_NUM_ZERO);
			couponBean.setAccountId(accountInfo.getAccountId());
			couponBean.setIsBad(Constants.DEVIL_NUM_ZERO);
			
			//获取用户猫咪储蓄金额
			SavingsBean savingsBean = new SavingsBean();
			savingsBean.setAccountId(accountInfo.getAccountId());
			SavingsBean sBean = savingsService.findAllMonetById(savingsBean);
			
			String savingsMoney = sBean.getSavingsMoney();
			
			double sMoney = Double.parseDouble(savingsMoney) / 100;
			if(sMoney >= 100){
				sMoney = 100;
			}
			
			AutobidInfo autobidInfo = autobidMapper.getAccountAutobid(accountInfo.getAccountId());
			
			
			request.setAttribute("autobidInfo", autobidInfo);

			// 存入request供页面查询
			request.setAttribute("sMoney", df.format(sMoney));
			//猫咪储蓄提取总金额
			detail.setType("19");
			request.setAttribute("stotalMoney", capitaldetailService.selAccumulatedIncomeById(detail));
			request.setAttribute("totalAsset", df.format(totalAsset));
			request.setAttribute("freedomMoney", df.format(freedomMoney));
			request.setAttribute("nowWithdrawMoney", df.format(nowWithdrawMoney));
			request.setAttribute("investmentMoney", df.format(investmentMoney));
			request.setAttribute("availableBalance", df.format(availableBalance));
			request.setAttribute("freezeMoney", df.format(freezeMoney));
			request.setAttribute("accountName", accountName);
			request.setAttribute("telePhone", telePhone);
			request.setAttribute("accountScore", accountScore);
			request.setAttribute("accountLevel", accountLevel);
			request.setAttribute("accountExp", accountExp);
			request.setAttribute("noReadMessage", messageService.countNoRead(messageBean));
			request.setAttribute("myCoupon", couponService.countCapitalCoupon(couponBean));

			request.setAttribute("accountBean", accountInfoService.getAccountInfo(accountInfo.getAccountId()));
			
			request.setAttribute("usedMoney", usedMoney);
			
			request.setAttribute("monthProfit", monthProfit);
			request.setAttribute("totalInvestProfit", totalInvestProfit);
			request.setAttribute("totalFreedomProfit", totalFreedomProfit);
			request.setAttribute("totalRecharge", totalRecharge);
			request.setAttribute("totalCashWithdrawal", totalCashWithdrawal);

		}
		catch (SQLException e)
		{
			logger.error("查询个人中心金额总览失败", e);
		}
		//如果是从标分享的页面进入，就跳转到标列表页面
		String lastPath = (String)request.getSession().getAttribute("lastPath");
		try {
			if(!StringTools.isNullOrEmpty(lastPath) && lastPath.contains("subject") && lastPath.contains("type=0")){
				request.getSession().removeAttribute("lastPath");				
					//跳转新手标
					String NEWSUBJECT_URL = paramService.getParamVal("NEWSUBJECT_URL");
					response.sendRedirect(NEWSUBJECT_URL);
				
			}else if(!StringTools.isNullOrEmpty(lastPath) && lastPath.contains("subject") && lastPath.contains("type=1")){	
				request.getSession().removeAttribute("lastPath");			
					//跳转普通标
					String SUBJECT_URL = paramService.getParamVal("SUBJECT_URL");
					response.sendRedirect(SUBJECT_URL);
				
			}else if(!StringTools.isNullOrEmpty(lastPath) && lastPath.contains("subject") && lastPath.contains("type=4")){	
				request.getSession().removeAttribute("lastPath");				
					//跳转爆款标
					String HIHGSUBJECT_URL = paramService.getParamVal("HIHGSUBJECT_URL");
					response.sendRedirect(HIHGSUBJECT_URL);
				
			}else if(!StringTools.isNullOrEmpty(lastPath) && lastPath.contains("crowdfund")){	
				request.getSession().removeAttribute("lastPath");
				
					//跳转众筹
					String CROWDFUND_URL = paramService.getParamVal("CROWDFUND_URL");
					response.sendRedirect(CROWDFUND_URL);
				
			}else if(!StringTools.isNullOrEmpty(lastPath) && (lastPath.contains("awardrotate") || lastPath.contains("loginregister") || lastPath.contains("sorting"))){	
				request.getSession().removeAttribute("lastPath");
				
					//跳转首页
					String FONTPAGE_URL = paramService.getParamVal("FONTPAGE_URL");
					response.sendRedirect(FONTPAGE_URL);
				
			}else if(!StringTools.isNullOrEmpty(lastPath) && lastPath.contains("freedomsubject")){
				request.getSession().removeAttribute("lastPath");
					//跳转猫咪宝
					String FREEDOMSUBJECT_URL = paramService.getParamVal("FREEDOMSUBJECT_URL");
					response.sendRedirect(FREEDOMSUBJECT_URL);
				
			}else if(!StringTools.isNullOrEmpty(lastPath) && lastPath.contains("toSavings")){
				request.getSession().removeAttribute("lastPath");
				//跳转猫咪宝
				String SAVINGS_URL = paramService.getParamVal("SAVINGS_URL");
				response.sendRedirect(SAVINGS_URL);
			}
			else if(!StringTools.isNullOrEmpty(lastPath)){
				request.getSession().removeAttribute("lastPath");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "loginregister/myCenter";
	}
}
