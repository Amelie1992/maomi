package com.xed.financing.wxgzh.controller.sorting;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.investrecord.InvestRecordBean;
import com.xed.financing.wxgzh.service.sorting.SortingService;
import com.xed.financing.wxgzh.util.StringTools;

@Controller
@RequestMapping("/sorting")
public class SortingController
{
	@Autowired
	private SortingService sortingService;
	
	private Logger logger = Logger.getLogger(SortingController.class);
	
	/**
	 * 查询总榜
	 * @Description:
	 * @param model
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年10月10日 下午4:52:40
	 */
	@RequestMapping("/querysorting")
	public String queryAll(Model model,HttpServletRequest request,String flag){
		List<InvestRecordBean> rspList = null;
		
		//默认月榜  flag=2  总榜
		if(StringTools.isNullOrEmpty(flag))
		{
			flag = "1";
		}
		
		String isExist="";
		// 从session中查询出账户ID
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		try
		{
			rspList = sortingService.queryInvestRecordBeanlList(flag);
		
			for (InvestRecordBean sBean : rspList)
			{
				//手机号隐藏中间四位
				sBean.setTelephone(sBean.getTelephone().substring(0,3)+"****"+sBean.getTelephone().substring(7));
				
				//获取当前用户是否在榜单
				if(accountId.equals(sBean.getAccountId()))
				{
					isExist=sBean.getRn();
				}
			}
		}
		catch (SQLException e)
		{
			logger.error("查询排行榜异常", e);
		}
		model.addAttribute("isExist", isExist);
		model.addAttribute("rspList", rspList);
		model.addAttribute("flag", flag);
		
		return "sorting/sorting";
	}
	
}
