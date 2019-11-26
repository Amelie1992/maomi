/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.subject.SubjectServiceImpl
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
package com.xed.financing.wxgzh.service.goodsorder.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.accountScore.AccountScoreMapper;
import com.xed.financing.wxgzh.mapper.goodsinfo.GoodsInfoMapper;
import com.xed.financing.wxgzh.mapper.goodsorder.GoodsOrderMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.model.accountscore.AccountScoreBean;
import com.xed.financing.wxgzh.model.goodsinfo.GoodsInfoBean;
import com.xed.financing.wxgzh.model.goodsorder.GoodsOrderBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.goodsorder.GoodsOrderService;
import com.xed.financing.wxgzh.util.Constants;

/**
 * @className:com.xed.financing.wxgzh.service.subject.SubjectServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月16日 上午11:04:46
 * @author:Qian Tao
 */
@Service
public  class GoodsOrderServiceImpl implements GoodsOrderService
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(GoodsOrderServiceImpl.class);
	
	@Resource
	private AccountInfoMapper accountInfoMapper;
	
	@Resource
	private AccountScoreMapper accountScoreMapper;
	
	@Resource
	private GoodsInfoMapper goodsInfoMapper;
	
	@Resource
	private GoodsOrderMapper goodsOrderMapper;
	
	@Resource
	private MessageMapper messageMapper;

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.goodsorder.GoodsOrderService#queryGoodsOrder(com.xed.financing.wxgzh.model.goodsorder.GoodsOrderBean)
	 */
	@Override
	public List<GoodsOrderBean> queryGoodsOrder(GoodsOrderBean goodsOrderBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return this.goodsOrderMapper.queryGoodsOrder(goodsOrderBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.goodsorder.GoodsOrderService#queryGoodsOrderById(com.xed.financing.wxgzh.model.goodsorder.GoodsOrderBean)
	 */
	@Override
	public GoodsOrderBean queryGoodsOrderById(GoodsOrderBean goodsOrderBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return this.goodsOrderMapper.queryGoodsOrderById(goodsOrderBean);
	}
	
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.goodsorder.GoodsOrderService#queryGoodsOrderByAccountId(com.xed.financing.wxgzh.model.goodsorder.GoodsOrderBean)
	 */
	@Override
	public List<GoodsOrderBean> queryGoodsOrderByAccountId(GoodsOrderBean goodsOrderBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return this.goodsOrderMapper.queryGoodsOrderByAccountId(goodsOrderBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.goodsorder.GoodsOrderService#insertGoodsOrderBean(com.xed.financing.wxgzh.model.goodsorder.GoodsOrderBean)
	 */
	@Override
	public void insertGoodsOrderBean(GoodsOrderBean goodsOrderBean) throws SQLException
	{
		// TODO Auto-generated method stub
		this.goodsOrderMapper.insertGoodsOrderBean(goodsOrderBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.goodsorder.GoodsOrderService#updateGoodsOrderBean(com.xed.financing.wxgzh.model.goodsorder.GoodsOrderBean)
	 */
	@Override
	public void updateGoodsOrderBean(GoodsOrderBean goodsOrderBean) throws SQLException
	{
		// TODO Auto-generated method stub
		this.goodsOrderMapper.updateGoodsOrderBean(goodsOrderBean);
	}
	

	@Transactional
	public void convertGoods(GoodsInfoBean goodsInfoBean,GoodsOrderBean goodsOrderBean,AccountInfo accountInfo) 
	{
		try
		{
			//1.修改商品表数量
			//查询商品剩余数量
			goodsInfoBean = goodsInfoMapper.queryGoodsInfoById(goodsInfoBean);
			//判断剩余数量是否和售出数量一致
			if(goodsInfoBean.getRealStock().equals(goodsOrderBean.getGoodsNum())){
				//商品售完后更新状态为下架
				goodsInfoBean.setStatus(Constants.DEVIL_NUM_ONE);
			}
			//更新货物数量
			goodsInfoBean.setRealStock(String.valueOf(Integer.parseInt(goodsInfoBean.getRealStock()) - Integer.parseInt(goodsOrderBean.getGoodsNum())));
			//更新商品信息
			goodsInfoMapper.updateGoodsInfo(goodsInfoBean);
			
			//2.添加订单表信息
			goodsOrderBean.setAccountId(accountInfo.getAccountId());
			//***************修改  修改时间
			goodsOrderBean.setRemark("用户:" + accountInfo.getAccountName() + "支付" + goodsOrderBean.getGoodsMoney() + "鱼干兑换商品" + goodsInfoBean.getGoodsName() + "数量" + goodsOrderBean.getGoodsNum() + "件");
			goodsOrderMapper.insertGoodsOrderBean(goodsOrderBean);
			
			//3.修改个人积分信息  
			accountInfo.setAccountScore(String.valueOf(Integer.valueOf(accountInfo.getAccountScore())-Integer.parseInt(goodsOrderBean.getGoodsMoney())));
			//修改用户积分和经验 传参：用户信息Bean
			accountScoreMapper.changeScoreAndExp(accountInfo);
			
			//4.添加积分明细信息
			AccountScoreBean accountScoreBean = new AccountScoreBean();
			accountScoreBean.setAccountId(accountInfo.getAccountId());
			
			//积分收支(0:收入 1:支出)
			accountScoreBean.setInExpend(Constants.DEVIL_NUM_ONE);
			
			//积分类型(0:签到 1:完善信息 2:投标奖励 3:兑换积分 4:积分抽奖 5:购买积分 6:其他 7:积分退回)
			accountScoreBean.setScoreType(Constants.DEVIL_NUM_THREE);
			accountScoreBean.setScore(String.valueOf(goodsOrderBean.getGoodsMoney()));
			accountScoreBean.setModReason("鱼干商城:支付" + goodsOrderBean.getGoodsMoney() + "鱼干兑换商品" + goodsInfoBean.getGoodsName() + "数量" + goodsOrderBean.getGoodsNum() + "件");
			accountScoreMapper.addAccountScoreInfo(accountScoreBean);
			
			//5.发送消息
			MessageBean messageBean =new MessageBean();
			messageBean.setAccountId(accountInfo.getAccountId());
			messageBean.setMsgTitle("鱼干商城兑换成功");
			messageBean.setMsgContent("您兑换的商品 " + goodsInfoBean.getGoodsName() + "兑换成功！详情可至鱼干兑换记录查看");
			messageMapper.addMessageInfo(messageBean);
		}
		catch (Exception e)
		{
			logger.error("更新消息记录异常");
			throw new RuntimeException();
		}
		
		
		
	}
	
}
