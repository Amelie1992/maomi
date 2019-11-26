/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.signin.SignInController
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
package com.xed.financing.wxgzh.controller.awardrotate;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.draw.DrawBean;
import com.xed.financing.wxgzh.service.activityrecord.ActivityRecordService;
import com.xed.financing.wxgzh.service.awardrotate.AwardRotateService;
import com.xed.financing.wxgzh.service.draw.DrawService;
import com.xed.financing.wxgzh.service.param.ParamService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DrawParam;

/**
 * 鱼干抽奖
 * @className:com.xed.financing.wxgzh.controller.awardrotate.AwardRotateController
 * @description:
 * @version:v1.0.0 
 * @date:2017年6月20日 上午10:50:34
 * @author:Elias Zheng
 */
@Controller
@RequestMapping("/awardrotate")
public class AwardRotateController
{
	@Autowired
	private AwardRotateService awardRotateService;

	@Autowired
	private DrawService drawService;
	
	@Autowired
	private ActivityRecordService activityRecordService;

	@Autowired
	private ParamService paramService;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AwardRotateController.class);

	/**
	 * 进入鱼干抽奖页面
	 * 
	 * @Description:
	 * @param request
	 * @param accountInfo
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月26日 下午4:19:21
	 */
	@RequestMapping("/gotoawardrotate")
	public String toSignIn(HttpServletRequest request, AccountInfo accountInfo,DrawBean drawBean)
	{
		// 获取当前用户
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		try
		{
			accountInfo = awardRotateService.getAccountScore(accountId);

			// 抽奖所需鱼干
			request.setAttribute("score", DrawParam.DRAW_SCORE);
			// 用户鱼干信息
			request.setAttribute("accountScore", accountInfo.getAccountScore());

			// 查询获奖记录信息
			drawBean.setIsAward(Constants.DEVIL_NUM_ZERO);
			List<DrawBean> drawLst = drawService.queryDrawList(drawBean);
			DrawBean drawBean_;						//list插入对象
			Random rad = new Random();				//随机数生成器
			int position;							//插入位置
			int name;								//奖品名称
			String content = "";					//奖品内容
			if(drawLst != null && drawLst.size() > 0){
				int num = 0;
				int count = 0;
				//额外添加记录 不满10条增加2条,满10条增加6条
				if(drawLst.size() <= 5){
					count = 1;
				}else if(5 < drawLst.size() && drawLst.size() < 10){
					count = 2;
				}else{
					count = 5;
				}
				while (num < count) {
					drawBean_ = new DrawBean();
					position = rad.nextInt(drawLst.size());
					drawBean_.setTelephone(DrawParam.DRAW_DATA_TEL[rad.nextInt(10)] + "****" + rad.nextInt(10) + rad.nextInt(10) + rad.nextInt(10) + rad.nextInt(10));
					name = rad.nextInt(4);
					if(name == 0){
						content = DrawParam.DRAW_DATA_0[rad.nextInt(2)];
					}else if(name == 1){
						content = DrawParam.DRAW_DATA_1[rad.nextInt(2)];
					}else if(name == 2){
						content = DrawParam.DRAW_DATA_2[rad.nextInt(2)];
					}else if(name == 3){
						content = DrawParam.DRAW_DATA_3[rad.nextInt(2)];
					}
					drawBean_.setDrawContent(DrawParam.DRAW_DATA_NAME[name] + ":" + content);
					drawLst.add(position, drawBean_);
					num++;
				}
			}
			request.setAttribute("drawList", drawLst);
		}
		catch (Exception e)
		{
			logger.error("鱼干查询成功", e);
		}

		return "awardRotate/awardRotate";
	}

	/**
	 * 计算抽奖结果
	 * 
	 * @Description:
	 * @param request
	 * @param accountInfo
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月26日 下午4:19:44
	 */
	/*@RequestMapping("/getitem")*/
	@ResponseBody
	@RequestMapping(value="/getitem",method=RequestMethod.POST)
	public Map<String, Object> getItem(HttpServletRequest request, AccountInfo accountInfo, String usedScore)
	{
		String result = "FAIL";
		String score = "";
		
		double item = Math.floor(Math.random() * 10000);
		double prize1 = DrawParam.DRAW_PRIZE.get(1) * 10000 / 100;//奖项的概率400
		double prize2 = prize1 + DrawParam.DRAW_PRIZE.get(2) * 10000 / 100;//1200
		double prize3 = prize2 + DrawParam.DRAW_PRIZE.get(3) * 10000 / 100;//1600
		double prize4 = prize3 + DrawParam.DRAW_PRIZE.get(4) * 10000 / 100;//2400
		double prize5 = prize4 + DrawParam.DRAW_PRIZE.get(5) * 10000 / 100;//5800
		double prize6 = prize5 + DrawParam.DRAW_PRIZE.get(6) * 10000 / 100;//7600
		
		System.out.println("奖项随机数-->" + item);
		
		// 获取当前用户
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		try
		{
			accountInfo = awardRotateService.getAccountScore(accountId);
			
			//判断用户积分是否足够
			if(Integer.parseInt(accountInfo.getAccountScore()) >= DrawParam.DRAW_SCORE){
				if (item >= 0 && item <= prize1)
				{
					item = 1;
				}
				else if (item >= (prize1 + 1) && item <= prize2)
				{
					item = 2;
				}
				else if (item >= (prize2 + 1) && item <= prize3)
				{
					item = 3;
				}
				else if (item >= (prize3 + 1) && item <= prize4)
				{
					item = 4;
				}
				else if (item >= (prize4 + 1) && item <= prize5)
				{
					item = 6;
				}
				else if (item >= (prize5 + 1) && item <= prize6)
				{
					item = 7;
				}
				else
				{
					item = 0;
				}
				
				// 扣除抽奖鱼干
				AccountScoreBean accountScoreBean = new AccountScoreBean();
				accountScoreBean.setAccountId(accountInfo.getAccountId());
				accountScoreBean.setScore(usedScore);
				accountScoreBean.setInExpend(Constants.DEVIL_NUM_ONE);
				accountScoreBean.setScoreType(Constants.DEVIL_NUM_FOUR);
				accountScoreBean.setModReason("鱼干抽奖花费鱼干:" + usedScore);
				
				// 更新用户剩余鱼干
				accountInfo.setAccountScore(String.valueOf(Integer.parseInt(accountInfo.getAccountScore())
						- Integer.parseInt(usedScore)));
				
				score = awardRotateService.useAccountScore(accountInfo, accountScoreBean);
				
				result="SUCCESS";
				
				System.out.println("奖项结果数-->" + item);
			}

		}
		catch (Exception e)
		{
			logger.error("鱼干查询成功", e);
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("item", item);
		resultMap.put("result", result);
		resultMap.put("accountScore", score);
		return resultMap;
	}
	
	/**
	 * 计算抽奖结果
	 * 
	 * @Description:
	 * @param request
	 * @param accountInfo
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月26日 下午4:19:44
	 */
	/*@RequestMapping("/grantrewards")*/
	@ResponseBody
	@RequestMapping(value="/grantrewards",method=RequestMethod.POST)
	public Map<String, Object> grantRewards(HttpServletRequest request, Integer awards)
	{
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();

		Map<String, Object> resultMap = new HashMap<String, Object>();

		double money = 0.0;
		try
		{
			// 用户信息
			AccountInfo accountInfo = awardRotateService.getAccountScore(accountId);

			// 获得奖励鱼干
			AccountScoreBean accountScoreInfo = new AccountScoreBean();
			accountScoreInfo.setAccountId(accountInfo.getAccountId());
			accountScoreInfo.setInExpend(Constants.DEVIL_NUM_ZERO);
			accountScoreInfo.setScoreType(Constants.DEVIL_NUM_FOUR);

			// 优惠券奖品
			if (awards == 1 || awards == 2 || awards == 4 || awards == 6)
			{
				// 发放优惠券
				money = awardRotateService.grantRewards(awards, accountInfo,Constants.AWARD_ROTATE_VALUE);
			}
			// 获奖奖品为鱼干
			else if (awards == 5)
			{
				// 发放鱼干
				money = awardRotateService.updateAccountScore(awards, accountInfo, accountScoreInfo,Constants.AWARD_ROTATE_VALUE);
			}
			// 获奖奖品新手专享标再投机会
			else if (awards == 3)
			{
				// 发放新手专享标再投机会
				money = awardRotateService.updateAccountNewSubjectCount(awards, accountInfo);
			}
			resultMap.put("result", "SUCCESS");
			resultMap.put("money", money);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMap.put("result", "FAIL");
		}
		return resultMap;
	}
	
	/**
	 * 进入鱼干抽奖页面
	 * 
	 * @Description:
	 * @param request
	 * @param accountInfo
	 * @return
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年5月26日 下午4:19:21
	 */
	@RequestMapping("/gotomyaward")
	public String goToMyAward(HttpServletRequest request, AccountInfo accountInfo,DrawBean drawBean)
	{
		// 获取当前用户
		String accountId = ((AccountInfo) request.getSession().getAttribute("account")).getAccountId();
		try
		{
			
			drawBean.setAccountId(accountId);
			List<DrawBean> drawLst = drawService.queryDraw(drawBean);
			
			request.setAttribute("drawLst", drawLst);

		}
		catch (Exception e)
		{
			logger.error("鱼干查询成功", e);
		}

		return "awardRotate/myAward";
	}
	
	/*@RequestMapping("/getActivity")*/
	@ResponseBody
	@RequestMapping(value="/getActivity",method=RequestMethod.POST)
	public void getActivity(HttpServletRequest request, HttpServletResponse response)
	{
		//常见标识
		String result = "{\"result\":\"error\"}";
		response.setContentType("application/json");
		PrintWriter out;
		try
		{
			
			//----------------------------------七夕集字活动--------------------------------------------
			String result2 = activityRecordService.activityCalligraphy(request, "2");
			if(!"".equals(result2)){
				result = "{\"result\":\"success\", \"jizi\":\""+result2+"\"}";
			}
			//----------------------------------------------------------------------------------------
			// 传递标识
			out = response.getWriter();
			out.write(result);
		}
		catch (Exception e)
		{
			logger.error("活动异常", e);
		}
	}
}