/**
 * Copyright (C) 2018 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.material.impl.MaterialServiceImpl
 * @description:
 * 
 * @version:v1.0.0 
 * @author:QT
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2018年9月8日    	QT  		v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.service.material.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xed.financing.wxgzh.mapper.draw.DrawMapper;
import com.xed.financing.wxgzh.mapper.material.MaterialMapper;
import com.xed.financing.wxgzh.mapper.message.MessageMapper;
import com.xed.financing.wxgzh.model.draw.DrawBean;
import com.xed.financing.wxgzh.model.material.MaterialBean;
import com.xed.financing.wxgzh.model.message.MessageBean;
import com.xed.financing.wxgzh.service.material.MaterialService;

/**
 * @className:com.xed.financing.wxgzh.service.material.impl.MaterialServiceImpl
 * @description:
 * @version:v1.0.0 
 * @date:2018年9月8日 上午10:37:52
 * @author:QT
 */
@Service
public class MaterialServiceImpl implements MaterialService
{

	@Resource
	private MaterialMapper materialMapper;
	
	@Resource
	private MessageMapper messageMapper;
	
	@Resource
	private DrawMapper drawMapper;
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(MaterialServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.material.MaterialService#countIsExById(java.lang.String)
	 */
	@Override
	public Integer countIsExById(String accountId) throws SQLException
	{
		// TODO Auto-generated method stub
		return materialMapper.countIsExById(accountId);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.material.MaterialService#addMaterial(com.xed.financing.wxgzh.model.material.MaterialBean)
	 */
	@Override
	public void addMaterial(MaterialBean materialBean) throws SQLException
	{
		// TODO Auto-generated method stub
		materialMapper.addMaterial(materialBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.material.MaterialService#queryMaterialCountById(java.lang.String)
	 */
	@Override
	public Integer queryMaterialCountById(String accountId) throws SQLException
	{
		// TODO Auto-generated method stub
		return materialMapper.queryMaterialCountById(accountId);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.material.MaterialService#queryMaterialDetailById(java.lang.String)
	 */
	@Override
	public List<MaterialBean> queryMaterialDetailById(MaterialBean materialBean) throws SQLException
	{
		// TODO Auto-generated method stub
		return materialMapper.queryMaterialDetailById(materialBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.material.MaterialService#editMaterialById(com.xed.financing.wxgzh.model.material.MaterialBean)
	 */
	@Override
	public void editMaterialById(MaterialBean materialBean) throws SQLException
	{
		// TODO Auto-generated method stub
		materialMapper.editMaterialById(materialBean);
	}

	/* (non-Javadoc)
	 * @see com.xed.financing.wxgzh.service.material.MaterialService#addMaterialDetailById(com.xed.financing.wxgzh.model.material.MaterialBean)
	 */
	@Override
	public void addMaterialDetailById(MaterialBean materialBean) throws SQLException
	{
		// TODO Auto-generated method stub
		materialMapper.addMaterialDetailById(materialBean);
	}

	@Override
	public void sendMoon(int count, String type,String accountId,String money,String recommedPhone) throws SQLException
	{
		//判断月饼材料表是否添加数据
		if(materialMapper.countIsExById(accountId)==0)
		{
			MaterialBean materialBean=new MaterialBean();
			materialBean.setAccountId(accountId);
			materialBean.setMaterialCount("0");
			materialMapper.addMaterial(materialBean);
		}
		//先查询用户当前月饼数量
		int countMoon=materialMapper.queryMaterialCountById(accountId);
		MaterialBean mBean=new MaterialBean();
		mBean.setMaterialCount(String.valueOf(count+countMoon));
		mBean.setAccountId(accountId);
		//修改月饼数量
		materialMapper.editMaterialById(mBean);
		
		MessageBean messageBean =new MessageBean();
		//添加月饼明细
		mBean.setMaterial(String.valueOf(count));
		//收支(0:收入 1:支出)      
		mBean.setInExpend("0");
		//类型（1投资获取 2满签获取 3抽奖获取 4邀请好友投资获取 5兑换10现金券 6兑换100现金券 7兑换300月饼 8兑换小米空气净化器 9兑换小米8 64G 10兑换iphone8 64G 11兑换iphoneX 256G）
		mBean.setMaterialType(type);
		if("1".equals(type))
		{
			mBean.setRemark("投资"+money+"元获取"+count+"个月饼");
			messageBean.setMsgContent("投资"+money+"元获取"+count+"个月饼");
		}
		else if("2".equals(type))
		{
			mBean.setRemark("满签获取"+count+"个月饼");
			messageBean.setMsgContent("满签获取"+count+"个月饼");
		}
		else if("3".equals(type))
		{
			mBean.setRemark("抽奖获取"+count+"个月饼");
			messageBean.setMsgContent("抽奖获取"+count+"个月饼");
		}
		else if("4".equals(type))
		{
			mBean.setRemark("邀请好友"+recommedPhone+"投资"+money+"获取"+count+"个月饼");
			messageBean.setMsgContent("邀请好友"+recommedPhone+"投资"+money+"获取"+count+"个月饼");
		}
		materialMapper.addMaterialDetailById(mBean);	
		
		//添加消息
		
		messageBean.setAccountId(accountId);
		messageBean.setMsgTitle("月饼奖励到账");
		messageMapper.addMessageInfo(messageBean);
		
		if("3".equals(type))
		{
			// 记录获奖信息
			DrawBean drawBean = new DrawBean();
			drawBean.setAccountId(accountId);
			drawBean.setDrawRank("月饼奖励");
			drawBean.setDrawContent("月饼:1个"); 
			drawMapper.addDraw(drawBean);
		}
		
	}

	@Override
	public void convertMoon(String count,String material,String type, String accountId) throws SQLException
	{
		MaterialBean mBean=new MaterialBean();
		mBean.setMaterialCount(count);
		mBean.setAccountId(accountId);
		//修改月饼数量
		materialMapper.editMaterialById(mBean);
		
		//添加月饼明细
		mBean.setMaterial(String.valueOf(material));
		//收支(0:收入 1:支出)      
		mBean.setInExpend("1");
		//类型（1投资获取 2满签获取 3抽奖获取 4邀请好友投资获取 5兑换10现金券 6兑换100现金券 7兑换300月饼 8兑换小米空气净化器 9兑换小米8 64G 10兑换iphone8 64G 11兑换iphoneX 256G）
		mBean.setMaterialType(type);
		//5兑换10现金券 
		if("5".equals(type))
		{
			mBean.setRemark("兑换10元现金券");
		}
		//兑换100现金券
		else if("6".equals(type))
		{
			mBean.setRemark("兑换100元现金券");
		}
		//兑换300月饼
		else if("7".equals(type))
		{
			mBean.setRemark("兑换价值300元月饼一盒");
		}
		//兑换小米空气净化器
		else if("8".equals(type))
		{
			mBean.setRemark("兑换价值900元小米空气净化器一台");
		}
		//兑换小米8 64G
		else if("9".equals(type))
		{
			mBean.setRemark("兑换小米8  64G一部");
		}
		//兑换iphone8 64G
		else if("10".equals(type))
		{
			mBean.setRemark("兑换 iPhone 8 64G一部");
		}
		//兑换iphoneX 256G
		else if("11".equals(type))
		{
			mBean.setRemark("兑换iPhone X 256G一部");
		}
		materialMapper.addMaterialDetailById(mBean);	
		
		//添加消息
		MessageBean messageBean =new MessageBean();
		messageBean.setAccountId(accountId);
		messageBean.setMsgTitle("月饼兑换成功");
		if("5".equals(type))
		{
			messageBean.setMsgContent("成功兑换10元现金券，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
		}
		//兑换100现金券
		else if("6".equals(type))
		{
			messageBean.setMsgContent("成功兑换100元现金券，请至<a href='javascript:void(0)' onclick='goDetails(2)'>我的优惠券</a>查看。");
		}
		//兑换300月饼
		else if("7".equals(type))
		{
			messageBean.setMsgContent("成功兑换价值300元月饼一盒，奖励将在活动结束后的3-10个工作日内寄出");
		}
		//兑换小米空气净化器
		else if("8".equals(type))
		{
			messageBean.setMsgContent("成功兑换价值900元小米空气净化器一台，奖励将在活动结束后的3-10个工作日内寄出。");
		}
		//兑换小米8 64G
		else if("9".equals(type))
		{
			messageBean.setMsgContent("成功兑换小米8  64G一部，奖励将在活动结束后的3-10个工作日内寄出。");
		}
		//兑换iphone8 64G
		else if("10".equals(type))
		{
			messageBean.setMsgContent("成功兑换 iPhone 8 64G一部，奖励将在活动结束后的3-10个工作日内寄出。");
		}
		//兑换iphoneX 256G
		else if("11".equals(type))
		{
			messageBean.setMsgContent("成功兑换iPhone X 256G一部，奖励将在活动结束后的3-10个工作日内寄出。");
		}
		messageMapper.addMessageInfo(messageBean);
	}

	@Override
	public void editIsDiscountBy(MaterialBean materialBean) throws SQLException
	{
		// TODO Auto-generated method stub
		materialMapper.editIsDiscountBy(materialBean);
	}

}
