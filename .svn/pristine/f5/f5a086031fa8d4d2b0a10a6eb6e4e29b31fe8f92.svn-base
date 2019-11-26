/**
 * Copyright (C) 2017 FZJT Co.Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.capitaldetail.CapitalDetailController
 * @description:资金明细表控制器
 * 
 * @version:v1.0.0 
 * @author:WangLin
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月16日    WangLin  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.capitaldetail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.capitaldetail.CapitalDetail;
import com.xed.financing.wxgzh.service.capitaldetail.CapitaldetailService;
import com.xed.financing.wxgzh.util.JsonUtil;

/**
 * @className:com.xed.financing.wxgzh.controller.capitaldetail.CapitalDetailController
 * @description:资金明细表控制器
 * @version:v1.0.0
 * @date:2017年3月16日 下午3:22:56
 * @author:WangLin
 */
@Controller
@RequestMapping("/capitaldetail")
public class CapitalDetailController
{
	@Autowired
	private CapitaldetailService capitaldetailService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(CapitalDetailController.class);

	/**
	 * 
	 * @Description:获取所有记录
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月16日 下午3:40:46
	 */
	@RequestMapping("/getAllCapitaldetail")
	public String getAllCapitaldetail(HttpServletRequest request)
	{
		List<CapitalDetail> getAll;
		try
		{
			CapitalDetail capitalDetail =new CapitalDetail();
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			capitalDetail.setAccountId(accountId);
			getAll = capitaldetailService.getAll(capitalDetail);
			request.setAttribute("capitalDetailList", getAll);
		}
		catch (SQLException e)
		{
			logger.error("查询资金记录列表异常", e);
		}
		
		return "capitalDetailInfo/dealRecordl";
	}
	
	/**
	 * 
	 * @Description:ajax异步提交
	 * @param type
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月20日 下午4:45:06
	 */
	/*@RequestMapping("/getTypeQurey")*/
	@ResponseBody
	@RequestMapping(value="/getTypeQurey",method=RequestMethod.POST)
	public void getTypeQurey(String type, HttpServletRequest request, HttpServletResponse response)
	{
		List<CapitalDetail> typeList=null;
		try
		{
			typeList = capitaldetailService.getTypeQuret(type,request);
			request.setAttribute("capitalDetailList", typeList);
			PrintWriter write;
			write = response.getWriter();
			String data = JsonUtil.listToJson(typeList);
			write.print(data);
			write.flush();
			write.close();
		}
		catch (SQLException e1)
		{
			logger.error("获取查询类型异常", e1);
		}catch (IOException e)
		{
			logger.error("获取查询类型IO异常", e);
		}

	}

}
