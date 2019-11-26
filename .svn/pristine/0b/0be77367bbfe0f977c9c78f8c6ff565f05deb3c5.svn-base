package com.xed.financing.wxgzh.controller.intface.accountlevel;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.util.LevelParam;

@Controller
@RequestMapping("/ios/accountCenter")
public class AccountCenterInterfaceController
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AccountCenterInterfaceController.class);
	
	@Autowired
	private CapitalService capitalService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	@RequestMapping("/queryAccountLevel")
	public String queryAccountLevel(HttpServletRequest request, CapitalBean capitalBean,String accountId){
		// 获取的数据格式化保留两位小数
		DecimalFormat df = new DecimalFormat("0.00");
		capitalBean = new CapitalBean();
		CapitalBean accountBean = new CapitalBean();
		try
		{
			// 获取页面用户登录信息
			AccountInfo accountInfo = accountInfoService.iosGetLoginAccountInfo(accountId);
			// 获取账户id
			capitalBean.setAccountId(accountInfo.getAccountId());

			// 调用查询方法
			capitalBean = capitalService.queryCapitalById(capitalBean);
			accountBean = capitalService.queryAccountInfo(capitalBean);

			// 获取投资金额
			Double investmentMoney = capitalBean.getInvestmentMoney();

			// 获取用户名
			String accountName = accountBean.getAccountName();

			// 获取用户会员等级
			Integer accountLevel = Integer.parseInt(accountBean.getAccountLevel());
			
			Double investMoney2=0.0;
			//百分比
			String s2="";
			if(accountLevel==10){
				 s2="100";
			}else{
				String investMoney=LevelParam.GRADE_DIVISION.get(accountLevel+1);
				String[] s=investMoney.split(",");
				//差的钱
				investMoney2=(Double.valueOf(s[0])/100)-investmentMoney;
				s2=String.valueOf(investmentMoney/(Double.valueOf(s[0])/100)*100);
				s2 = s2.substring(0, s2.indexOf("."));
			}
			
			// 存入request供页面查询
			request.setAttribute("investMoney2", df.format(investMoney2));
			request.setAttribute("accountLevel", String.valueOf(accountLevel));
			request.setAttribute("accountName", accountName);
			request.setAttribute("s2", s2);
		}
		catch (Exception e)
		{
			logger.error("查询等级中心信息总览失败", e);
		}
		return "accountlevel/accountCenter";
	}
	
}
