package com.xed.financing.wxgzh.controller.intface.awardrotate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xed.financing.wxgzh.controller.awardrotate.AwardRotateController;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.draw.DrawBean;
import com.xed.financing.wxgzh.service.accountInfo.AccountInfoService;
import com.xed.financing.wxgzh.service.awardrotate.AwardRotateService;
import com.xed.financing.wxgzh.service.draw.DrawService;
import com.xed.financing.wxgzh.util.Constants;
import com.xed.financing.wxgzh.util.DrawParam;
import com.xed.financing.wxgzh.util.JsonUtil;
import com.xed.financing.wxgzh.util.MoneyUtils;

import net.sf.json.JSONObject;

/**
 * 鱼干抽奖
 * @className:com.xed.financing.wxgzh.controller.intface.awardrotate.AwardRotateInterfaceController
 * @description:
 * @version:v1.0.0 
 * @date:2018年4月24日 上午11:20:07
 * @author:zheng shuai
 */
@Controller
@RequestMapping("/ios/awardrotate")
public class AwardRotateInterfaceController
{
	
	@Autowired
	private AwardRotateService awardRotateService;
	
	@Autowired
	private DrawService drawService;
	
	@Autowired
	private AccountInfoService accountInfoService;
	
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(AwardRotateController.class);
	
	/**
	 * 鱼干抽奖中奖纪录
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/awardrotate/gotomyaward?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年4月24日 上午10:04:16
	 */
	@ResponseBody
	@RequestMapping("/gotomyaward")
	public JSONObject goToMyAward(String accountId)
	{
		JSONObject obj = new JSONObject();
		// 设置标识
		String msg = "系统异常";
		String code = "500";
		try
		{
			JSONObject objs = new JSONObject();
			DrawBean drawBean = new DrawBean();
			drawBean.setAccountId(accountId);
			List<DrawBean> drawLst = drawService.queryDraw(drawBean);
			msg = "";
			code = "200";
			objs.put("drawLst", JsonUtil.listToJson(drawLst));
			obj.put("data",objs);
		}
		catch (Exception e)
		{
			logger.error("鱼干查询成功", e);
		}
		obj.put("msg", msg);
		obj.put("code", code);
		return obj;
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
	@RequestMapping("/gotoawardrotate")
	public String toSignIn(HttpServletRequest request, AccountInfo accountInfo,DrawBean drawBean,String accountId)
	{
		try
		{
			accountInfo = awardRotateService.getAccountScore(accountId);
			request.setAttribute("accountInfo", accountInfo);
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

		return "awardRotate/iosAwardRotate";
	}
	
	/**
	 * 5连抽奖+发奖
	 * @Description:
	 * @param request
	 * @param accountInfo
	 * @param usedScore
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年5月11日 上午10:48:00
	 */
	@ResponseBody
	@RequestMapping(value="/getfiveawardit",method=RequestMethod.POST)
	public Map<String, Object> getfiveawardit(HttpServletRequest request, AccountInfo accountInfo,int nums,String accountId)
	{
		//int nums=5;
		if(nums>1)
		{
			nums=5;
		}
		else
		{
			nums=1;
		}
		String usedScore=String.valueOf(DrawParam.DRAW_SCORE);
		String result = "FAIL";
		String score = "";
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try
		{
			accountInfo = awardRotateService.getAccountScore(accountId);
			
			//判断用户积分是否足够(5连抽积分)
			if(Integer.parseInt(accountInfo.getAccountScore()) >= (DrawParam.DRAW_SCORE*nums)){
				List<Double> itemlist=new ArrayList<Double>();
				List<Double> moneylist=new ArrayList<Double>();
				for (int i = 0; i < nums; i++)
				{
					double item = Math.floor(Math.random() * 10000);
					double prize1 = DrawParam.DRAW_PRIZE.get(1) * 10000 / 100;//奖项的概率400
					double prize2 = prize1 + DrawParam.DRAW_PRIZE.get(2) * 10000 / 100;//1200
					double prize3 = prize2 + DrawParam.DRAW_PRIZE.get(3) * 10000 / 100;//1600
					double prize4 = prize3 + DrawParam.DRAW_PRIZE.get(4) * 10000 / 100;//2400
					double prize5 = prize4 + DrawParam.DRAW_PRIZE.get(5) * 10000 / 100;//5800
					double prize6 = prize5 + DrawParam.DRAW_PRIZE.get(6) * 10000 / 100;//7600
					
					System.out.println("奖项随机数-->" + item);
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
					
					int awards =(int) item;
					double money=0;
					if (item == 0) {//未中奖
						awards = 7;
					} else if (item == 5) {//增值券
						awards = 4;
					} else if (item == 6) {//鱼干
						awards = 5;
					} else if (item == 7) {//加息券
						awards = 6;
					}
					
	
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
						score=MoneyUtils.formatFloatNumbers(Integer.parseInt(score)+money, 0);
					}
					// 获奖奖品新手专享标再投机会
					else if (awards == 3)
					{
						// 发放新手专享标再投机会
						money = awardRotateService.updateAccountNewSubjectCount(awards, accountInfo);
					}
					itemlist.add(item);
					moneylist.add(money);
					result="SUCCESS";
					resultMap.put("moneylist", moneylist);
					resultMap.put("itemlist", itemlist);
				}
			}

		}
		catch (Exception e)
		{
			logger.error("鱼干查询成功", e);
		}
		
		
		resultMap.put("result", result);
		resultMap.put("accountScore", score);
		return resultMap;
	}
}
