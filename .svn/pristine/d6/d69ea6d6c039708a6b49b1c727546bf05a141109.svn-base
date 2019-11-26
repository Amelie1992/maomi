/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.bondtransfer.BondTransferService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhangJun
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月17日    ZhangJun  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.bondtransfer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xed.financing.wxgzh.model.creditrecord.CreditRecord;

/**
 * 转让
 * 
 * @className:com.xed.financing.wxgzh.service.bondtransfer.BondTransferService
 * @description:
 * @version:v1.0.0
 * @date:2017年3月17日 下午3:11:42
 * @author:ZhangJun
 */
public interface BondTransferService
{
	/**
	 * 查询全部集合，根据条件排序
	 * 
	 * @Description: 查询出总条数，和总金额，条件排序的集合,转成json发送给前台
	 * @param creditRecord
	 * @param response
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午3:35:38
	 */
	public Boolean getSortingList(CreditRecord creditRecord, HttpServletResponse response) throws Exception;

	/**
	 * 查询全部集合
	 * 
	 * @Description:查询出总条数，和总金额,时间排序的集合
	 * @return 查询出的集合
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午3:37:02
	 */
	public CreditRecord getList(HttpServletRequest request) throws Exception;

	/**
	 * 转让
	 * 
	 * @Description:
	 * @param request
	 * @param response
	 * @param creditId
	 *            转让ID
	 * @return 成功与否
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午3:37:24
	 */
	public Boolean changeTransferBonds(HttpServletRequest request, HttpServletResponse response, String creditId) throws Exception;

	/**
	 * 检查资金余额是否足
	 * 
	 * @Description:
	 * @return
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年3月20日 下午3:42:06
	 */
	public Boolean checkFunds(HttpServletRequest request, HttpServletResponse response, String creditId) throws Exception;
	
	/**
	 * 获得转让记录详情
	 * @Description:
	 * @param creditId
	 * @return
	 * @throws Exception
	 * @version:v1.0
	 * @author:ZhangJun
	 * @date:2017年6月21日 下午6:13:58
	 */
	public CreditRecord getCreditRecordDetail(HttpServletRequest request , String creditId) throws Exception;
	
	
	public Boolean checkTransferStatus(String creditId)throws Exception;

}
