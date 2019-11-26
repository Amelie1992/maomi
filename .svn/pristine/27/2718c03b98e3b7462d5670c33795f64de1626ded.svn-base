/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.withdrawrecord.WithdrawRecordService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Elias Zheng
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年9月8日    Elias Zheng  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.withdrawrecord;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xed.financing.wxgzh.model.withdrawrecord.WithdrawRecordBean;

/**
 * @className:com.xed.financing.wxgzh.service.withdrawrecord.WithdrawRecordService
 * @description:
 * @version:v1.0.0 
 * @date:2017年9月8日 下午3:29:44
 * @author:Elias Zheng
 */
public interface WithdrawRecordService
{
	/**
	 * 查询集合
	 * @Description:
	 * @param withdrawRecordBean
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年9月8日 上午10:23:54
	 */
	public List<WithdrawRecordBean> queryWithdrawRecords(WithdrawRecordBean withdrawRecordBean) throws Exception;
	
	/**
	 * 查询某一记录
	 * @Description:
	 * @param withdrawRecordBean
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年9月8日 上午10:24:00
	 */
	public WithdrawRecordBean queryWithdrawRecord(WithdrawRecordBean withdrawRecordBean) throws Exception;
	
	/**
	 * 新增记录
	 * @Description:
	 * @param withdrawRecordBean
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年9月8日 上午10:24:07
	 */
	public void addWithdrawRecord(WithdrawRecordBean withdrawRecordBean) throws Exception;
	
	/**
	 * 更新记录
	 * @Description:
	 * @param withdrawRecordBean
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年9月8日 上午10:24:15
	 */
	public void updateWithdrawRecord(WithdrawRecordBean withdrawRecordBean) throws Exception;
	
	/**
	 * 删除记录
	 * @Description:
	 * @param withdrawRecordBean
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年9月8日 上午10:24:20
	 */
	public void deleteWithdrawRecord(WithdrawRecordBean withdrawRecordBean) throws Exception;
	
	
	/**
	 * 操作猫咪宝定时器
	 * @Description:
	 * @throws Exception
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年9月8日 下午6:01:52
	 */
	public void doWithdrawTiming() throws Exception;
	
	/**
	 * 提现
	 * @Description:
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2018年6月19日 下午2:03:23
	 */
	public String withdrawMon(HttpServletRequest request, HttpServletResponse response,
			String accountName, String bankCard, Double money, String bankName, String isComp, String count,Boolean tq,Boolean txq)throws Exception;
	
	/**
	 * 提现(ios)
	 * @Description:
	 * @param accountName
	 * @param bankCard
	 * @param money
	 * @param bankName
	 * @param isComp
	 * @param count
	 * @param tq
	 * @param txq
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年7月3日 上午10:52:10
	 */
	public String iosWithdrawMon(String accountId,String accountName, String bankCard, Double money, 
			String bankName, String isComp, String count,Boolean tq,Boolean txq)throws Exception;
}
