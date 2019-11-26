/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.intface.crowdfund.CrowdfundInterfaceController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年4月18日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.intface.crowdfund;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.controller.crowdfund.CrowdfundController;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.model.crowdfund.CrowdfundBean;
import com.xed.financing.wxgzh.model.goodpic.GoodPicBean;
import com.xed.financing.wxgzh.service.accountlevel.AccountLevelService;
import com.xed.financing.wxgzh.service.capital.CapitalService;
import com.xed.financing.wxgzh.service.capitaldetail.CapitaldetailService;
import com.xed.financing.wxgzh.service.crowdfund.CrowdfundService;
import com.xed.financing.wxgzh.service.goodpic.GoodPicService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.util.DateUtils;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * 
 * @className:com.xed.financing.wxgzh.controller.intface.crowdfund.CrowdfundInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月18日 下午3:30:20
 * @author:QT
 */
@Controller
@RequestMapping("/ios/crowdfund")
public class CrowdfundInterfaceController
{
	@Autowired
	private CapitaldetailService capitaldetailService;
	
	@Autowired
	private CrowdfundService crowdfundService;
	
	@Autowired
	private CapitalService capitalService;
	
	@Autowired
	private ParamService paramService;
	
	@Autowired
	private GoodPicService goodPicService;
	
	@Autowired
	private AccountLevelService accountLevelService; 
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(CrowdfundController.class);
	
	/**
	 * 查询众筹集合
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月20日 下午4:42:54
	 */
	@ResponseBody
	@RequestMapping("/querycrowfund")
	public JSONObject queryCrowfundList(HttpServletRequest request,CrowdfundBean crowdfundBean)
	{
		JSONObject obj = new JSONObject();
		String msg="";
		int code=300;
		try
		{
			//查询集合
			List<CrowdfundBean> rspList=crowdfundService.queryCrowfundList(crowdfundBean);
			JSONObject objs = new JSONObject();
			objs.put("rspList", JsonUtil.listToJson(rspList));
			obj.put("data",objs);
			code=200;
		}
		catch (SQLException e)
		{
			logger.error("查询众筹集合异常！",e);
			msg="查询众筹列表异常";
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 查询详情
	 * @Description:
	 * @param request
	 * @param crowdfundBean
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月20日 下午4:47:38
	 */
	@ResponseBody
	@RequestMapping("/detailcrowfund")
	public JSONObject queryCrowfundById(String crowdId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		String msg="";
		int code=300;
		try
		{
			CrowdfundBean crowdfundBean = new CrowdfundBean();
			crowdfundBean.setCrowdId(crowdId);
			crowdfundBean=crowdfundService.queryCrowfundById(crowdfundBean);
			//查询众筹数量
			int counts=crowdfundService.countCrowdfundingRecordById(crowdfundBean);
			int per=100*counts/(Integer.parseInt(crowdfundBean.getMaxEach()));
			
			objs.put("cBean", crowdfundBean);
			//进度
			objs.put("per", per);
			//加入笔数
			objs.put("counts", counts);
			
			//已筹金额
			objs.put("aMoney", counts*(Integer.parseInt(crowdfundBean.getEachMoney())));
			//奖品数量
			objs.put("cwinng", (int) Math.floor(counts*Double.parseDouble(crowdfundBean.getEachMoney())/Double.parseDouble(crowdfundBean.getCrowdGrade())));
			
			//------------------公益--------------
			//利率
			//double rate=Double.parseDouble(crowdfundBean.getCrowdRate())/100;
			//活动周期单份收益
			//double profit=rate*Double.parseDouble(crowdfundBean.getEachMoney())*Double.parseDouble(crowdfundBean.getActivityDay())/365;
			//奖品理论发放数量（带小数）
			//double stocks=profit*counts/Double.parseDouble(crowdfundBean.getSaleMoney());
			//double minEach = Double.parseDouble(crowdfundBean.getMinEach());
			//向下取整  获得实际数量  奖品数量 (投资记录数量/最小份数=最小商品数)
			//int rewardStock=(int) Math.floor(stocks);
			//int rewardStock=(int) Math.floor(counts/minEach);
			//公益金额
			//double welfareMoney=(stocks-rewardStock)*Double.parseDouble(crowdfundBean.getSaleMoney());
			
			//爱心公益金额
			double welfareMoney=0.0;
			objs.put("welfareMoney", welfareMoney);
			
			//查询图片
			GoodPicBean goodPicBean=new GoodPicBean();
			goodPicBean.setPicType("1");
			goodPicBean.setGoodsId(crowdfundBean.getGoodsId());
			objs.put("gList", goodPicService.queryGoodPic(goodPicBean));
			obj.put("data",objs);
			code=200;
		}
		catch (SQLException e)
		{
			logger.error("查询众筹详情异常！",e);
			msg="查询众筹详情异常";
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 跳转购买众筹页面
	 * @Description:
	 * @param request
	 * @param crowdfundBean
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月23日 下午12:43:47
	 */
	@ResponseBody
	@RequestMapping("/investcrowfund")
	public JSONObject toBuyCrowdfund(String accountId,String crowdId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		String msg="";
		int code=300;
		try
		{
			// 从session中查询出账户ID
			CrowdfundBean crowdfundBean=new CrowdfundBean();
			crowdfundBean.setCrowdId(crowdId);
			crowdfundBean=crowdfundService.queryCrowfundById(crowdfundBean);
			//查询众筹数量
			int counts=crowdfundService.countCrowdfundingRecordById(crowdfundBean);
			//剩余可投份数
			objs.put("hasEach",Integer.parseInt(crowdfundBean.getMaxEach())-counts);
			objs.put("cBean",crowdfundBean);
			
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			// 获取用户余额
			objs.put("balance", MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
			code=200;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg="跳转众筹购买页面异常";
		}
		obj.put("data",objs);
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 购买众筹
	 * @Description:
	 * @param request
	 * @param crowdfundBean
	 * @param nums
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月20日 下午4:58:45
	 */
	@ResponseBody
	@RequestMapping("/buycrowfund")
	public JSONObject buyCrowfund(String accountId,String crowdId,int nums)
	{
		// 设置标识
		JSONObject obj = new JSONObject();
		String msg="";
		int code=300;
		//传入crowd_id
		try
		{
			CrowdfundBean crowdfundBean=new CrowdfundBean();
			crowdfundBean.setCrowdId(crowdId);
			crowdfundBean=crowdfundService.queryCrowfundById(crowdfundBean);
			//众筹总笔数
			int maxNum=Integer.parseInt(crowdfundBean.getMaxEach());
			//众筹已经投了多少笔
			int counts=crowdfundService.countCrowdfundingRecordById(crowdfundBean);
			//单笔众筹价格
			int perMoney=Integer.parseInt(crowdfundBean.getEachMoney());
			//众筹开始时间
			String beginTime = crowdfundBean.getBeginDate();
			//众筹集资结束时间
			String groupDate = crowdfundBean.getGroupDate();
			//系统当前时间
			String nowDate=paramService.getCurrentTime().getNowDay();
			
			//查询用户资金
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			
			double balance=capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney();
			
			if(DateUtils.compareDatesThan(nowDate,groupDate ))
			{
				//众筹已结束
				code=302;
				msg="众筹已结束";
			}
			else if(DateUtils.compareDatesThan(beginTime,nowDate))
			{
				//众筹未开始
				code=301;
				msg="众筹未开始";
			}
			else if(nums>(maxNum-counts))
			{
				//达到购买上限
				code=303;
				msg="达到购买上限";
			}
			else if(balance<(nums*perMoney))
			{
				//余额不足
				code=304;
				msg="余额不足";
			}
			else
			{
				//立即众筹
				crowdfundService.addCrowdfundingRecord(crowdfundBean,accountId,nums,"");
				//判断是否可以升级
				accountLevelService.updateVIP(accountId);
				code=200;
				msg="购买成功";
			}
		}
		catch (Exception e)
		{
			logger.error("购买众筹异常", e);
			msg="购买异常";
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 
	 * 查询我的众筹列表
	 * @Description:
	 * @param request
	 * @param crowdfundBean
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月23日 下午3:01:35
	 */
	@ResponseBody
	@RequestMapping("/querymycrowfund")
	public JSONObject queryMyCrowfundList(String accountId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		String msg="";
		int code=300;
		try
		{
			// 从session中查询出账户ID
			CrowdfundBean crowdfundBean=new CrowdfundBean();
			crowdfundBean.setAccountId(accountId);
			//查询集合
			List<CrowdfundBean> rspList=crowdfundService.queryMyCrowdfund(crowdfundBean);
			objs.put("rspList", rspList);
			code=200;
		}
		catch (SQLException e)
		{
			logger.error("查询众筹集合异常！",e);
			msg="查询我的众筹异常";
		}
		obj.put("data", objs);
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 我的众筹详情
	 * @Description:
	 * @param request
	 * @param crowdfundBean
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月23日 下午3:41:52
	 */
	@ResponseBody
	@RequestMapping("/detailmycrowfund")
	public JSONObject detailMyCrowfund(String accountId,String crowdId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		String msg="";
		int code=300;
		try
		{
			CrowdfundBean crowdfundBean=new CrowdfundBean();
			crowdfundBean.setCrowdId(crowdId);
			crowdfundBean=crowdfundService.queryCrowfundById(crowdfundBean);
			objs.put("cBean", crowdfundBean);
			
			
			//查询开奖号码
			List<String> numList=new ArrayList<String>();
			List<CrowdfundBean> rspList1=crowdfundService.queryIsWinningBy(crowdfundBean);
			for (CrowdfundBean cBean : rspList1)
			{
				numList.add(cBean.getCrowdNum());
			}
			//开奖号码
			objs.put("numList", numList);
			
			//用户有没有抽到中奖号码
			crowdfundBean.setAccountId(accountId);
			List<CrowdfundBean> rspList2=crowdfundService.queryIsWinningBy(crowdfundBean);
			objs.put("rspList2", rspList2);
			
			//众筹记录
			List<CrowdfundBean> rspList=crowdfundService.selCrowdfundingRecord(crowdfundBean);
			for (CrowdfundBean cBean2 : rspList)
			{
				cBean2.setEachMoney(crowdfundBean.getEachMoney());
			}
			objs.put("rspList", rspList);
			
			//查询图片
			GoodPicBean goodPicBean=new GoodPicBean();
			goodPicBean.setPicType("1");
			goodPicBean.setGoodsId(crowdfundBean.getGoodsId());
			objs.put("gList", goodPicService.queryGoodPic(goodPicBean));
			code=200;
		}
		catch (SQLException e)
		{
			logger.error("查询众筹集合异常！",e);
			msg="查询我的众筹详情异常";
		}
		obj.put("data", objs);
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 跳转规则页面
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月24日 下午4:39:37
	 */
	@ResponseBody
	@RequestMapping("/crowdrule")
	public JSONObject goRule(String crowdId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		String msg="";
		int code=300;
		try
		{
			CrowdfundBean crowdfundBean = new CrowdfundBean();
			crowdfundBean.setCrowdId(crowdId);
			crowdfundBean=crowdfundService.queryCrowfundById(crowdfundBean);
			objs.put("cBean", crowdfundBean);
			
			String crowdMoney = crowdfundBean.getCrowdMoney();
			String crowdGrade = crowdfundBean.getCrowdGrade();
			//最大发送数量
			int num = Integer.parseInt(crowdMoney) / Integer.parseInt(crowdGrade);
			objs.put("num", num);
			code=200;
		}
		catch (SQLException e)
		{
			logger.error("跳转规则页面异常", e);
			msg="跳转规则页异常";
		}
		obj.put("data", objs);
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
	
	/**
	 * 跳转加入记录
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月24日 下午4:40:26
	 */
	@ResponseBody
	@RequestMapping("/crowdrecord")
	public JSONObject goRecord(String crowdId)
	{
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		String msg="";
		int code=300;
		try
		{
			CrowdfundBean crowdfundBean=new CrowdfundBean();
			crowdfundBean.setCrowdId(crowdId);
			List<CrowdfundBean> rspList=crowdfundService.selCrowdfundingRecord(crowdfundBean);
			for (CrowdfundBean cBean : rspList)
			{
				cBean.setTelephone(cBean.getTelephone().substring(0,3)+"****"+cBean.getTelephone().substring(7));
			}
			objs.put("rspList", rspList);
			objs.put("cBean", crowdfundService.queryCrowfundById(crowdfundBean));
			code=200;
		}
		catch (SQLException e)
		{
			logger.error("跳转众筹记录异常", e);
			msg="查询众筹记录异常";
		}
		obj.put("data", objs);
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
	}
}
