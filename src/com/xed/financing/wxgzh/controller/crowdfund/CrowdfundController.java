/**
................ * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.crowdfund.CrowdfundController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年11月20日       QT          v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.crowdfund;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
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
import com.xed.financing.wxgzh.util.MoneyUtils;
import com.xed.financing.wxgzh.util.StringTools;

/**
 * 
 * 众筹控制层
 * @className:com.xed.financing.wxgzh.controller.crowdfund.CrowdfundController
 * @description:
 * @version:v1.0.0 
 * @date:2017年11月20日 下午4:40:15
 * @author:QT
 */
@Controller
@RequestMapping("/crowdfund")
public class CrowdfundController
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
	@RequestMapping("/s/querycrowfund")
	public String queryCrowfundList(HttpServletRequest request,CrowdfundBean crowdfundBean)
	{
		try
		{
			//查询集合
			List<CrowdfundBean> rspList=crowdfundService.queryCrowfundList(crowdfundBean);
			
			request.setAttribute("rspList", rspList);
			
		}
		catch (SQLException e)
		{
			logger.error("查询众筹集合异常！",e);
		}
		return "crowdfund/crowdfundlist";
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
	@RequestMapping("/s/detailcrowfund")
	public String queryCrowfundById(String crowdId, HttpServletRequest request)
	{
		try
		{
			CrowdfundBean crowdfundBean = new CrowdfundBean();
			crowdfundBean.setCrowdId(crowdId);
			crowdfundBean=crowdfundService.queryCrowfundById(crowdfundBean);
			//查询众筹数量
			int counts=crowdfundService.countCrowdfundingRecordById(crowdfundBean);
			int per=100*counts/(Integer.parseInt(crowdfundBean.getMaxEach()));
			
			request.setAttribute("cBean", crowdfundBean);
			request.setAttribute("per", per);
			request.setAttribute("counts", counts);
			//已筹金额
			request.setAttribute("aMoney", counts*(Integer.parseInt(crowdfundBean.getEachMoney())));
			//中奖记录
			//request.setAttribute("cwinng", crowdfundService.countIsWinning(crowdfundBean));
			request.setAttribute("cwinng", (int) Math.floor(counts*Double.parseDouble(crowdfundBean.getEachMoney())/Double.parseDouble(crowdfundBean.getCrowdGrade())));
			
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
			double welfareMoney=0.0;
			request.setAttribute("welfareMoney", welfareMoney);
			
			//查询图片
			GoodPicBean goodPicBean=new GoodPicBean();
			goodPicBean.setPicType("1");
			goodPicBean.setGoodsId(crowdfundBean.getGoodsId());
			request.setAttribute("gList", goodPicService.queryGoodPic(goodPicBean));
		}
		catch (SQLException e)
		{
			logger.error("查询众筹详情异常！",e);
		}
		return "crowdfund/crowdfunddetail";
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
	@RequestMapping("/investcrowfund")
	public String toBuyCrowdfund(HttpServletRequest request,CrowdfundBean crowdfundBean)
	{
		try
		{
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			crowdfundBean=crowdfundService.queryCrowfundById(crowdfundBean);
			//查询众筹数量
			int counts=crowdfundService.countCrowdfundingRecordById(crowdfundBean);
			request.setAttribute("hasEach",Integer.parseInt(crowdfundBean.getMaxEach())-counts);
			request.setAttribute("cBean",crowdfundBean);
			
			CapitalBean capitalBean = new CapitalBean();
			capitalBean.setAccountId(accountId);
			capitalBean = capitalService.queryCapitalById(capitalBean);
			// 获取用户余额
			request.setAttribute("balance", MoneyUtils.formatFloatNumber(capitalBean.getWithdrawMoney()+capitalBean.getNoWithdrawMoney()));
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crowdfund/crowdfundinvest";
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
	@RequestMapping("/buycrowfund")
	public synchronized void buyCrowfund(HttpServletRequest request,HttpServletResponse response,String crowdId,String nums,String accountId,String telephone)
	{
		// 设置标识
		String result = "{\"result\":\"error\"}";
		response.setContentType("application/json");
		//传入crowd_id
		CrowdfundBean crowdfundBean=new CrowdfundBean();
		int num=Integer.parseInt(nums);
		try
		{
			if(StringTools.isNullOrEmpty(accountId))
			{
				accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
				telephone = ((AccountInfo) request.getSession().getAttribute("account")).getTelephone();
			}
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
				result = "{\"result\":\"overactivity\"}";
			}
			else if(DateUtils.compareDatesThan(beginTime,nowDate))
			{
				//众筹未开始
				result = "{\"result\":\"nostarted\"}";
			}
			else if(num>(maxNum-counts))
			{
				//达到购买上限
				result = "{\"result\":\"overlimit\"}";
			}
			else if(balance<(num*perMoney))
			{
				//余额不足
				result = "{\"result\":\"overmoney\"}";
			}
			else
			{
				//立即众筹
				crowdfundService.addCrowdfundingRecord(crowdfundBean,accountId,num,telephone);
				//判断是否可以升级
				accountLevelService.updateVIP(accountId);
				result = "{\"result\":\"success\"}";
			}
			PrintWriter out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("购买众筹异常", e);
			result = "{\"result\":\"syserror\"}";
		}
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
	@RequestMapping("/querymycrowfund")
	public String queryMyCrowfundList(HttpServletRequest request,CrowdfundBean crowdfundBean)
	{
		try
		{
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			crowdfundBean.setAccountId(accountId);
			//查询集合
			List<CrowdfundBean> rspList=crowdfundService.queryMyCrowdfund(crowdfundBean);
			
			request.setAttribute("rspList", rspList);
			
		}
		catch (SQLException e)
		{
			logger.error("查询众筹集合异常！",e);
		}
		return "crowdfund/mycrowdfundlist";
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
	@RequestMapping("/detailmycrowfund")
	public String detailMyCrowfund(HttpServletRequest request,CrowdfundBean crowdfundBean)
	{
		try
		{
			crowdfundBean=crowdfundService.queryCrowfundById(crowdfundBean);
			request.setAttribute("cBean", crowdfundBean);
			// 从session中查询出账户ID
			String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
			
			
			//查询开奖号码
			List<String> numList=new ArrayList<String>();
			List<CrowdfundBean> rspList1=crowdfundService.queryIsWinningBy(crowdfundBean);
			for (CrowdfundBean cBean : rspList1)
			{
				numList.add(cBean.getCrowdNum());
			}
			System.out.println(numList);
			request.setAttribute("numList", numList);
			
			//用户有没有抽到中奖号码
			crowdfundBean.setAccountId(accountId);
			List<CrowdfundBean> rspList2=crowdfundService.queryIsWinningBy(crowdfundBean);
			request.setAttribute("rspList2", rspList2);
			
			//众筹记录
			List<CrowdfundBean> rspList=crowdfundService.selCrowdfundingRecord(crowdfundBean);
			for (CrowdfundBean cBean2 : rspList)
			{
				cBean2.setEachMoney(crowdfundBean.getEachMoney());
			}
			request.setAttribute("rspList", rspList);
			
			//查询图片
			GoodPicBean goodPicBean=new GoodPicBean();
			goodPicBean.setPicType("1");
			goodPicBean.setGoodsId(crowdfundBean.getGoodsId());
			request.setAttribute("gList", goodPicService.queryGoodPic(goodPicBean));
		}
		catch (SQLException e)
		{
			logger.error("查询众筹集合异常！",e);
		}
		return "crowdfund/mycrowdfunddetail";
	}
	
	/**
	 * 跳转规则页面
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月24日 下午4:39:37
	 */
	@RequestMapping("/crowdrule")
	public String goRule(HttpServletRequest request,String crowdId)
	{
		try
		{
			CrowdfundBean crowdfundBean = new CrowdfundBean();
			crowdfundBean.setCrowdId(crowdId);
			crowdfundBean=crowdfundService.queryCrowfundById(crowdfundBean);
			request.setAttribute("cBean", crowdfundBean);
			
			String crowdMoney = crowdfundBean.getCrowdMoney();
			String crowdGrade = crowdfundBean.getCrowdGrade();
			//最大发送数量
			int num = Integer.parseInt(crowdMoney) / Integer.parseInt(crowdGrade);
			request.setAttribute("num", num);
			
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crowdfund/crowdfundrule";
	}
	
	/**
	 * 跳转加入记录
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月24日 下午4:40:26
	 */
	@RequestMapping("/crowdrecord")
	public String goRecord(HttpServletRequest request,CrowdfundBean crowdfundBean)
	{
		try
		{
			List<CrowdfundBean> rspList=crowdfundService.selCrowdfundingRecord(crowdfundBean);
			for (CrowdfundBean cBean : rspList)
			{
				cBean.setTelephone(cBean.getTelephone().substring(0,3)+"****"+cBean.getTelephone().substring(7));
			}
			request.setAttribute("rspList", rspList);
			
			request.setAttribute("cBean", crowdfundService.queryCrowfundById(crowdfundBean));
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "crowdfund/crowdfundrecord";
	}
}
