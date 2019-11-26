package com.xed.financing.wxgzh.controller.intface.autobid;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xed.financing.wxgzh.mapper.accountlevel.AccountLevelMapper;
import com.xed.financing.wxgzh.mapper.autobid.AutoBidMapper;
import com.xed.financing.wxgzh.mapper.capital.CapitalMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.autobid.AutobidInfo;
import com.xed.financing.wxgzh.model.capital.CapitalBean;
import com.xed.financing.wxgzh.service.autobid.AutobidService;
import com.xed.financing.wxgzh.util.JsonUtil;


@Controller
@RequestMapping("/ios/autobid")
public class AutobidInterfaceController {
	
	private Logger logger=Logger.getLogger(AutobidInterfaceController.class);
	
	@Resource
	private AutoBidMapper autoBidMapper;
	
	@Resource
	private AccountLevelMapper accountLevelMapper;
	
	@Autowired
	private AutobidService autobidService;
	
	@Resource
	private CapitalMapper capitalMapper;

	/**
	 * 去自动投标页
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/autobid/toAutoBid?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2018年4月23日 上午10:43:45
	 */
	@RequestMapping("/toAutoBid")
	@ResponseBody
	public JSONObject toautobid(String accountId){
		JSONObject obj = new JSONObject();
		JSONObject objs = new JSONObject();
		String msg="前往自动投标页异常";
		String code="300";
		AccountInfo accountInfo=new AccountInfo();
		try 
		{
			//获取用户最新的一条自动投资记录
			AutobidInfo autobid = autoBidMapper.getAccountAutobid(accountId);
			if (autobid == null)
			{
				autobid = new AutobidInfo("", "", "", "", "", "", "", "");
			}
			accountInfo.setAccountId(accountId);
			//查询用户等级
			String accountLevel = accountLevelMapper.queryAccountLevel(accountInfo).getAccountLevel();
			//查询用户余额
			CapitalBean capitalBean= new CapitalBean();
			capitalBean.setAccountId(accountId);
			CapitalBean cap = capitalMapper.queryCapitalById(capitalBean);
			objs.put("cap", cap.getWithdrawMoney()+cap.getNoWithdrawMoney());
			objs.put("autobidBean", autobid);
			objs.put("accountLevel", accountLevel);
			obj.put("data", objs);
			msg="前往自动投标页成功";
			code="200";
		} catch (Exception e) {
			logger.error("前往自动投标页异常", e);
		}
		obj.put("msg", msg);
		obj.put("code",code);
		return obj;
	}
	
	/**
	 * 预约用户自动投标
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/autobid/addAutoBid?accountId=&money=&lowerLimit=&upperLimit=
	 * @return
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2018年4月23日 下午2:17:56
	 */
	@RequestMapping("/addAutoBid")
	@ResponseBody
	public JSONObject addAutobid(String accountId,String money,String lowerLimit,String upperLimit){
		Map<String,Object> map=new HashMap<String, Object>();
		JSONObject obj = new JSONObject();
		String msg="预约用户自动投标异常";
		String code="300";
		try 
		{
			AutobidInfo autobidInfo=new AutobidInfo();
			autobidInfo.setMoney(money);
			autobidInfo.setLowerLimit(lowerLimit);
			autobidInfo.setUpperLimit(upperLimit);
			//添加自动投标记录
			autobidService.addAutobid(accountId, autobidInfo, map);
			if("haveBid".equals(map.get("result"))){
				msg="已有未取消预约";
				code="301";
			}else if("notEnough".equals(map.get("result"))){
				msg="账户金额不足";
				code="302";
			}else if("success".equals(map.get("result"))){
				msg="预约用户自动投标成功";
				code="200";
			}
		} catch (Exception e) {
			logger.error("预约自动投标异常", e);
		}
		obj.put("msg", msg);
		obj.put("code",code);
		return obj;
	}
	
	/**
	 * 取消自动投标
	 * @Description:http://127.0.0.1:8080/xed_financing_wxgzh/ios/autobid/cancelAutoBid?accountId=
	 * @param accountId
	 * @return
	 * @version:v1.0
	 * @author:Zhouweinan
	 * @date:2018年4月23日 下午5:26:34
	 */
	@RequestMapping("/cancelAutoBid")
	@ResponseBody
	public JSONObject cancelAutobid(String accountId){
		Map<String,Object> map=new HashMap<String, Object>();
		JSONObject obj = new JSONObject();
		String msg="取消自动投标异常";
		String code="300";
		try 
		{
			autobidService.cancelAutobid(accountId, map);
			if("isCancel".equals(map.get("result"))){
				msg="勿重复取消";
				code="301";
			}else if("notEnough".equals(map.get("result"))){
				msg="数据异常";
				code="302";
			}else if("success".equals(map.get("result"))){
				msg="取消自动投标成功";
				code="200";
			}
		} catch (Exception e) {
			logger.error("取消自动投标异常", e);
		}
		obj.put("msg", msg);
		obj.put("code",code);
		return obj;
	}
	
}
