/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.controller.noviceGuidelines.NoviceGuidelinesController
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年5月5日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.controller.noviceGuidelines;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className:com.xed.financing.wxgzh.controller.noviceGuidelines.NoviceGuidelinesController
 * @description:
 * @version:v1.0.0 
 * @date:2017年5月5日 下午2:37:32
 * @author:ZhangJun
 */
@Controller
@RequestMapping("/noviceGuidelines/s")
public class NoviceGuidelinesController
{
	/**
	 * 去新手指南页面
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月5日 下午3:09:56
	 */
	@RequestMapping("/noviceGuidelines")
	public String noviceGuidelines(HttpServletRequest request){
		return "noviceGuidelines/noviceGuidelines";
	}
	
	/**
	 * 投标指南
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月5日 下午3:13:33
	 */
	@RequestMapping("/tenderGuide")
	public String tenderGuide(HttpServletRequest request){
		return "noviceGuidelines/tenderGuide";
	}
	
	/**
	 * 新手标
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月5日 下午3:14:21
	 */
	@RequestMapping("/noviceMark")
	public String noviceMark(HttpServletRequest request){
		return "noviceGuidelines/noviceMark";
	}
	
	/**
	 * 自动投标
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月5日 下午3:27:51
	 */
	@RequestMapping("/automaticBidding")
	public String automaticBidding(HttpServletRequest request){
		return "noviceGuidelines/automaticBidding";
	}
	
	/**
	 * 普通标
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月5日 下午3:28:24
	 */
	@RequestMapping("/commonStandard")
	public String commonStandard(HttpServletRequest request){
		return "noviceGuidelines/commonStandard";
	}
	
	/**
	 * 爆款标
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月5日 下午3:29:00
	 */
	@RequestMapping("/explosionStandard")
	public String explosionStandard(HttpServletRequest request){
		return "noviceGuidelines/explosionStandard";
	}
	
	
	/**
	 * 债权转让
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月5日 下午4:24:27
	 */
	@RequestMapping("/transferClaims")
	public String transferClaims(HttpServletRequest request){
		return "noviceGuidelines/transferClaims";
	}
	
	/**
	 * 积分商城
	 * @Description:
	 * @param request
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年5月5日 下午4:24:36
	 */
	@RequestMapping("/pointsMall")
	public String pointsMall(HttpServletRequest request){
		return "noviceGuidelines/pointsMall";
	}
}
