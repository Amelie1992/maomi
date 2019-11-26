/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.subject.SubjectService
 * @description:
 * 
 * @version:v1.0.0 
 * @author:Qian Tao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2017年3月16日    Qian Tao  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.goodsorder;

import java.sql.SQLException;
import java.util.List;

import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.goodsinfo.GoodsInfoBean;
import com.xed.financing.wxgzh.model.goodsorder.GoodsOrderBean;

/**
 * 
 * @className:com.xed.financing.wxgzh.service.goodsinfo.GoodsInfoService
 * @description:
 * @version:v1.0.0 
 * @date:2017年4月12日 下午6:11:34
 * @author:Elias Zheng
 */
public interface GoodsOrderService
{
	/**
	 * 查询订单列表
	 * @Description:
	 * @param goodsOrderBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月12日 下午5:21:57
	 */
	public List<GoodsOrderBean> queryGoodsOrder(GoodsOrderBean goodsOrderBean) throws SQLException;
	
	/**
	 * 查询订单详情
	 * @Description:
	 * @param goodsOrderBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月12日 下午5:23:42
	 */
	public GoodsOrderBean queryGoodsOrderById(GoodsOrderBean goodsOrderBean) throws SQLException;
	
	/**
	 * 查询单个用户订单详情
	 * @Description:
	 * @param goodsOrderBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月12日 下午5:23:42
	 */
	public List<GoodsOrderBean> queryGoodsOrderByAccountId(GoodsOrderBean goodsOrderBean) throws SQLException;
	
	/**
	 * 新增订单信息
	 * @Description:
	 * @param goodsOrderBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月12日 下午5:24:20
	 */
	public void insertGoodsOrderBean(GoodsOrderBean goodsOrderBean) throws SQLException;
	
	/**
	 * 修改订单信息
	 * @Description:
	 * @param goodsOrderBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月12日 下午5:24:47
	 */
	public void updateGoodsOrderBean(GoodsOrderBean goodsOrderBean) throws SQLException;
	
	/**
	 * 操作积分兑换商品
	 * @Description:
	 * @param goodsInfoBean
	 * @param goodsOrderBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Elias Zheng
	 * @date:2017年4月20日 下午5:22:16
	 */
	public void convertGoods(GoodsInfoBean goodsInfoBean,GoodsOrderBean goodsOrderBean,AccountInfo accountInfo) throws SQLException;
}
