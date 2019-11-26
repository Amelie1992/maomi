/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.bondtransfer.BondTransferController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月17日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.bondtransfer;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.creditrecord.CreditRecord;
import com.xed.financing.wxgzh.service.activityrecord.ActivityRecordService;
import com.xed.financing.wxgzh.service.bondtransfer.BondTransferService;

/**
 * 债权转让控制器
 * 
 * @className:com.xed.financing.wxgzh.controller.bondtransfer.BondTransferController
 * @description:
 * @version:v1.0.0
 * @date:2017年3月17日 下午4:02:43
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/bondTransfer")
public class BondTransferController
{
	@Autowired
	private BondTransferService bondTransferService;

	@Autowired
	private ActivityRecordService activityRecordService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(BondTransferController.class);

	/**
	 * 在债权转让页面看到债权转让记录
	 * @Description:获取所有记录
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:WangLin
	 * @date:2017年3月16日 下午3:40:46
	 */
	@RequestMapping("/getBondTransfer")
	public String getBondTransfer(HttpServletRequest request)
	{
		CreditRecord record;
		try
		{
			record = bondTransferService.getList(request);
			request.setAttribute("record", record);
		}
		catch (Exception e)
		{
			logger.error("查询所有债权列表异常", e);
		}
		return "bondtransfer/bondtransferlist";
	}

	/**
	 * 按条件排序，查看债权转让信息
	 * 
	 * @Description:
	 * @param creditMoney
	 * @param creditRate
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月18日 下午2:26:02
	 */
	/*@RequestMapping("/getSortingList")*/
	@ResponseBody
	@RequestMapping(value="/getSortingList",method=RequestMethod.POST)
	public void getSortingList(String creditMoney, String creditRate,String creditTime, HttpServletRequest request,
			HttpServletResponse response)
	{
		// 将收到的值存到Bean中
		CreditRecord record = new CreditRecord();
		record.setCreditMoney(creditMoney);
		record.setCreditRate(creditRate);
		record.setCreditTime(creditTime);
		// 通过条件排序后将返回的集合转成json返回给客户端
		try
		{
			bondTransferService.getSortingList(record, response);
		}
		catch (Exception e)
		{
			logger.error("查询排序债权列表异常", e);
		}
	}

	/**
	 * 获得详情
	 * @Description:
	 * @param creditId
	 * @param request
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月21日 下午6:15:25
	 */
	@RequestMapping("/getbondtransferdetail")
	public String getBondtransferDetail(String creditId,HttpServletRequest request,HttpServletResponse response){
		CreditRecord record;
		try
		{
			record = bondTransferService.getCreditRecordDetail(request,creditId);
			request.setAttribute("cBena", record);
		}
		catch (Exception e)
		{
			logger.error("获得详情异常", e);
		}
		return "bondtransfer/bondtransferdetail";
	}
	
	
	
	/**
	 * 债权转让
	 * @Description:
	 * @param creditId
	 * @param request
	 * @param response
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月21日 上午9:10:21
	 */
	/*@RequestMapping("/transferBonds")*/
	@ResponseBody
	@RequestMapping(value="/transferBonds",method=RequestMethod.POST)
	public void transferBonds(String creditId, HttpServletRequest request, HttpServletResponse response)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		response.setContentType("application/json");
		
		try
		{
			// 检查账户余额是否足
			Boolean falg = bondTransferService.checkFunds(request, response, creditId);
			if (falg)
			{
				if(bondTransferService.checkTransferStatus(creditId)){
					Boolean falg2 = bondTransferService.changeTransferBonds(request, response, creditId);
					if(falg2){
						//转让成功
						result = "{\"result\":\"success\"}";
						
						
						
						
						//----------------------------------七夕集字活动--------------------------------------------
						String result2 = activityRecordService.activityCalligraphy(request, "4");
						if(!"".equals(result2)){
							result = "{\"result\":\"success\", \"jizi\":\""+result2+"\"}";
						}
						//----------------------------------------------------------------------------------------
						
						
						
						
					}else{
						//转让失败
						result = "{\"result\":\"error\"}";
					}
				}else{
					
					//无法转让，标已承接，标已结束
					result = "{\"result\":\"unable\"}";
				}
			}else{
				//余额不足 
				result = "{\"result\":\"insufficient\"}";
			}
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (SQLException e)
		{
			logger.error("sql异常", e);
		}
		catch (Exception e) {
			logger.error("异常", e);
		}
		
		
	}

	
	
	
}
