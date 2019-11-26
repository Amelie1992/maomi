/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.datasplit.DataSplitService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月22日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.datasplit;

import java.util.List;

import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;

/**
 * @className:com.xed.financing.wxgzh.service.datasplit.DataSplitService
 * @description:
 * @version:v1.0.0
 * @date:2017年3月22日 下午4:36:55
 * @author:Qian Tao
 */
public interface DataSplitService
{
	/**
	 * 获取猫咪宝当前所有投资人的投资时间和投资总金额
	 * 
	 * @Description:
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月13日 下午2:13:30
	 */
	public List<FreedomSubjectBean> getFreedomInvestInfo() throws Exception;

	/**
	 * 删除投资用户的分团记录
	 * 
	 * @Description:
	 * @param freedomSubjectBeans
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月13日 下午2:25:02
	 */
	public void deleteDispersedRecord(List<FreedomSubjectBean> freedomSubjectBeans) throws Exception;

	/**
	 * 添加分团记录
	 * 
	 * @Description:
	 * @param freedomSubjectBeans
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年10月13日 下午3:11:51
	 */
	public void addInvestRecord(List<FreedomSubjectBean> freedomSubjectBeans) throws Exception;
	
	
}
