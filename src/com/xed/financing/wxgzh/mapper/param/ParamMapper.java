/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.param.ParamMapper
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月21日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.mapper.param;

import com.xed.financing.wxgzh.model.param.ParamBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.param.ParamMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月21日 下午3:31:18
 * @author:Qian Tao
 */
public interface ParamMapper
{
	/**
	 * 根据K调用参数表值
	 * @Description:
	 * @param key
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月21日 下午3:36:20
	 */
	public String getParamVal(String key);
	
	/**
	 * 获取当前时间
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月2日 下午4:19:50
	 */
	public ParamBean getCurrentTime();
	
	/**
	 * 刷新accessToken
	 * @Description:
	 * @param accessToken
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月12日 上午11:02:59
	 */
	public Integer refurbishAccessToken(String accessToken);
	
	/**
	 * 刷新accessToken_exprise_in
	 * @Description:
	 * @param accessToken
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月12日 上午11:02:59
	 */
	public Integer refurbishAccessTokenExpriseInTime(String exprise_in_time);
	
	/**
	 * 刷新accessToken
	 * @Description:
	 * @param accessToken
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月12日 上午11:02:59
	 */
	public Integer refurbishJsapiTicket(String accessToken);
	
	/**
	 * 刷新accessToken_exprise_in
	 * @Description:
	 * @param accessToken
	 * @return
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月12日 上午11:02:59
	 */
	public Integer refurbishJsapiTicketExpriseInTime(String exprise_in_time);
}
