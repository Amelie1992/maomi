/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.material.MaterialController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年9月8日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.material;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.material.MaterialBean;
import com.xed.financing.wxgzh.service.material.MaterialService;
import com.xed.financing.wxgzh.service.sendcash.SendCashCouponService;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * @className:com.xed.financing.wxgzh.controller.material.MaterialController
 * @description:
 * @version:v1.0.0 
 * @date:2018年9月8日 上午10:43:02
 * @author:QT
 */
@Controller
@RequestMapping("/material")
public class MaterialController
{
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private SendCashCouponService sendCashCouponService;
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(MaterialController.class);
	
	/**
	 * 2018中秋活动页
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月11日 上午11:58:58
	 */
	@RequestMapping("/s/tomaterial")
	public String toMaterial(HttpServletRequest request)
	{
		//从session中查询出账户ID
		AccountInfo accountInfo = (AccountInfo)request.getSession().getAttribute("account");
		//月饼初始数量
		int mcount=0;
		try
		{
			//登录状态
			if(!StringTools.isNullOrEmpty(accountInfo))
			{
				String accountId=accountInfo.getAccountId();
				//判断月饼材料表是否添加数据
				if(materialService.countIsExById(accountId)==0)
				{
					MaterialBean materialBean=new MaterialBean();
					materialBean.setAccountId(accountId);
					materialBean.setMaterialCount("0");
					materialService.addMaterial(materialBean);
				}
				
				//查询月饼拥有数量
				mcount=materialService.queryMaterialCountById(accountId);
			}
			
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			logger.error("2018中秋活动页面异常", e);
		}
		request.setAttribute("mcount", mcount);
		return "activity/midMoon";
	}
	
	/**
	 * 2018中秋活动页兑奖页
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月11日 上午11:58:58
	 */
	@RequestMapping("/tomaterialdetail")
	public String toMaterialDetail(HttpServletRequest request)
	{
		//从session中查询出账户ID
		String accountId= ((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
		//月饼消耗明细
		List<MaterialBean> rspList=null;
		try
		{
			MaterialBean materialBean=new MaterialBean();
			materialBean.setAccountId(accountId);
			//收支(0:收入 1:支出)  
			materialBean.setInExpend("1");
			rspList=materialService.queryMaterialDetailById(materialBean);
			request.setAttribute("rspList", rspList);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "activity/midMoondetail";
	}
	/**
	 * 兑换月饼
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月8日 下午4:12:06
	 */
	@ResponseBody
	@RequestMapping(value="/convertmoon" ,method=RequestMethod.POST)
	public Map<String,String> convertMoon(HttpServletRequest request,String type)
	{
		Map<String,String> map=new HashMap<String, String>();
		String result="error";
		String accountId=((AccountInfo)request.getSession().getAttribute("account")).getAccountId();
		int mooncount=0;
		try
		{
			//判断用户有没有月饼表数据
			if(!StringTools.isNullOrEmpty(materialService.queryMaterialCountById(accountId)))
			{
				//查询用户月饼数量
				mooncount=materialService.queryMaterialCountById(accountId);
				//5兑换10现金券 
				if("5".equals(type))
				{
					if(mooncount>=1)
					{
						materialService.convertMoon(String.valueOf(mooncount-1),"1", "5", accountId);
						//发送10现金券
						sendCashCouponService.sendCashCouponByMoney(accountId, "10");
						result="success";
					}
					else
					{
						result="lowmoon";
					}
				}
				//兑换100现金券
				else if("6".equals(type))
				{
					if(mooncount>=3)
					{
						materialService.convertMoon(String.valueOf(mooncount-3),"3", "6", accountId);
						//发送100现金券
						sendCashCouponService.sendCashCouponByMoney(accountId, "100");
						result="success";
					}
					else
					{
						result="lowmoon";
					}
				}
				//兑换300月饼
				else if("7".equals(type))
				{
					if(mooncount>=5)
					{
						materialService.convertMoon(String.valueOf(mooncount-5),"5", "7", accountId);
						result="success";
					}
					else
					{
						result="lowmoon";
					}
				}
				//兑换小米空气净化器
				else if("8".equals(type))
				{
					if(mooncount>=10)
					{
						materialService.convertMoon(String.valueOf(mooncount-10),"10", "8", accountId);
						result="success";
					}
					else
					{
						result="lowmoon";
					}
				}
				//兑换小米8 64G
				else if("9".equals(type))
				{
					if(mooncount>=20)
					{
						materialService.convertMoon(String.valueOf(mooncount-20),"20", "9", accountId);
						result="success";
					}
					else
					{
						result="lowmoon";
					}
				}
				//兑换iphone8 64G
				else if("10".equals(type))
				{
					if(mooncount>=30)
					{
						materialService.convertMoon(String.valueOf(mooncount-30),"30", "10", accountId);
						result="success";
					}
					else
					{
						result="lowmoon";
					}
				}
				//兑换iphoneX 256G
				else if("11".equals(type))
				{
					if(mooncount>=45)
					{
						materialService.convertMoon(String.valueOf(mooncount-45),"45", "11", accountId);
						result="success";
					}
					else
					{
						result="lowmoon";
					}
				}
			}
			else
			{
				//未获取过月饼
				result="lowmoon";
			}
			
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("result", result);
		return map;
	}
	
	/**
	 * 折现
	 * @Description:
	 * @param request
	 * @param materialDetailId
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年9月11日 下午1:47:37
	 */
	@ResponseBody
	@RequestMapping(value="/discountmoon" ,method=RequestMethod.POST)
	public Map<String,String> discountNow(HttpServletRequest request,String materialDetailId)
	{
		Map<String,String> map=new HashMap<String, String>();
		String result="error";
		MaterialBean materialBean=new MaterialBean();
		try
		{
			//是否折现(0否  1是)                 
			materialBean.setIsDiscount("1");
			materialBean.setMaterialDetailId(materialDetailId);
			materialService.editIsDiscountBy(materialBean);
			result="success";
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("result", result);
		return map;
	}
}
