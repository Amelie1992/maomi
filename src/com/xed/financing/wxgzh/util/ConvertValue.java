/**
 * Copyright (C) 2016 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.manager.web.util.ConvertValue
 * @description:
 * 
 * @version:v1.0.0 
 * @author:ZhengQing
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-10-19   ZhengQing   v1.0.0      create
 *
 *
 */
package com.xed.financing.wxgzh.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 标识为表名_字段名(皆使用大写)
 * 
 * @className:com.xed.financing.manager.web.util.ConvertValue
 * @description:数据库相关字段转译
 * @version:v1.0.0
 * @date:2016-10-19 上午9:36:22
 * @author:ZhengQing
 */
public class ConvertValue
{
	/**
	 * 商家表商铺类型
	 */
	public static Map<String, String> CISSHOPACCOUNT_SHOPTYPE = new HashMap<String, String>();

	/**
	 * 商家表审核状态
	 */
	public static Map<String, String> CISSHOPACCOUNTAPPLY_APPLYSTATUS = new HashMap<String, String>();

	/**
	 * 求购审核状态
	 */
	public static Map<String, String> MISNEWSASKBUYAPPLY_STATUS = new HashMap<String, String>();

	/**
	 * 商品审核状态
	 */
	public static Map<String, String> CISGOODSSPUAPPLY_STATUS = new HashMap<String, String>();

	/**
	 * 订单表订单类型
	 */
	public static Map<String, String> AQUATICORDERUSERINFO_ORDERTYPE = new HashMap<String, String>();

	/**
	 * 订单表订单状态
	 */
	public static Map<String, String> AQUATICORDERUSERINFO_ORDERSTATUS = new HashMap<String, String>();

	/**
	 * 订单表订单状态(退款订单用)[页面显示不一样所以数据不一样]
	 */
	public static Map<String, String> AQUATICORDERUSERINFO1_ORDERSTATUS = new HashMap<String, String>();

	/**
	 * 订单表订单支付类型
	 */
	public static Map<String, String> AQUATICORDERUSERINFO_ORDERONLINE = new HashMap<String, String>();

	/**
	 * 订单表仲裁状态
	 */
	public static Map<String, String> AQUATICREFUNDAPPLYINFO_ISARBITRA = new HashMap<String, String>();

	/**
	 * 退款表退款状态
	 */
	public static Map<String, String> AQUATICREFUNDRECORDINFO_CSSTATUS = new HashMap<String, String>();

	/**
	 * 实名用户表审核状态
	 */
	public static Map<String, String> CRMACCOUNTMEMBERAPPLY_APPSTATUS = new HashMap<String, String>();

	/**
	 * 用户表帐户状态
	 */
	public static Map<String, String> CRMACCOUNTMEMBER_STATUS = new HashMap<String, String>();

	/**
	 * 发票表发票类型
	 */
	public static Map<String, String> AQUATICORDERBILLINFO_BILLTYPE = new HashMap<String, String>();

	/**
	 * 发票表发票寄送状态
	 */
	public static Map<String, String> AQUATICORDERBILLINFO_ISOPEN = new HashMap<String, String>();

	/**
	 * 商品SPU表商品状态
	 */
	public static Map<String, String> CISGOODSSPU_SPUSTATUS = new HashMap<String, String>();

	/**
	 * 导入终端号状态
	 */
	public static Map<String, String> BASEPOSNUM_ISBIND = new HashMap<String, String>();
	
	public static Map<String, String> BASEPOSNUM_COMPANYNAME = new HashMap<String, String>();
	
	/**
	 * 终端号对照解绑
	 */
	public static Map<String, String> BASEPOSBIND_AUDITSTATUS = new HashMap<String, String>();
	
	public static Map<String, String> BASEPOSBIND_COMPANYNAME = new HashMap<String, String>();
	
	/***
	 *异常订单 
	 */
	public static Map<String, String> DELAYED_RESULTSTATUS = new HashMap<String, String>();
	
	public static Map<String, String> DELAYED_POSTYPE = new HashMap<String, String>();
	
	/**
	 * 资费相关
	 */
	public static Map<String, String> BASEPOSRATE_ISRATE = new HashMap<String, String>();
	
	public static Map<String, String> BASEPOSRATE_ISPAYRATE = new HashMap<String, String>();
	
	public static Map<String, String> BASEPOSRATE_ISSUPPORT = new HashMap<String, String>();
	
	/**
	 * 警戒额度
	 */
	public static Map<String, String> BASEPOSLIMIT_STATUS = new HashMap<String, String>();
	
	static
	{
		// 商铺类型值
		CISSHOPACCOUNT_SHOPTYPE.put("-1", "未知");
		CISSHOPACCOUNT_SHOPTYPE.put("1", "个人");
		CISSHOPACCOUNT_SHOPTYPE.put("2", "企业");

		// 商铺审核状态
		CISSHOPACCOUNTAPPLY_APPLYSTATUS.put("-1", "待提交");
		CISSHOPACCOUNTAPPLY_APPLYSTATUS.put("0", "已审核");
		CISSHOPACCOUNTAPPLY_APPLYSTATUS.put("1", "待审核");
		CISSHOPACCOUNTAPPLY_APPLYSTATUS.put("2", "已驳回");
		CISSHOPACCOUNTAPPLY_APPLYSTATUS.put("3", "取消申请");

		// 求购审核状态
		MISNEWSASKBUYAPPLY_STATUS.put("-1", "待提交");
		MISNEWSASKBUYAPPLY_STATUS.put("0", "已审核");
		MISNEWSASKBUYAPPLY_STATUS.put("1", "待审核");
		MISNEWSASKBUYAPPLY_STATUS.put("2", "审核中");
		MISNEWSASKBUYAPPLY_STATUS.put("3", "已驳回");
		MISNEWSASKBUYAPPLY_STATUS.put("4", "失效");

		// 商品审核状态
		CISGOODSSPUAPPLY_STATUS.put("-1", "草稿");
		CISGOODSSPUAPPLY_STATUS.put("1", "待审核");
		CISGOODSSPUAPPLY_STATUS.put("2", "待审核");
		CISGOODSSPUAPPLY_STATUS.put("3", "已驳回");
		CISGOODSSPUAPPLY_STATUS.put("4", "已驳回");
		CISGOODSSPUAPPLY_STATUS.put("5", "已审核");

		// 订单表类型
		AQUATICORDERUSERINFO_ORDERTYPE.put("0", "普通订单");
		AQUATICORDERUSERINFO_ORDERTYPE.put("1", "面对面订单");

		// 订单表订单状态
		AQUATICORDERUSERINFO_ORDERSTATUS.put("0", "待确认");
		AQUATICORDERUSERINFO_ORDERSTATUS.put("1", "待付款");
		AQUATICORDERUSERINFO_ORDERSTATUS.put("2", "付款中");
		AQUATICORDERUSERINFO_ORDERSTATUS.put("3", "待发货");
		AQUATICORDERUSERINFO_ORDERSTATUS.put("4", "待收货");
		AQUATICORDERUSERINFO_ORDERSTATUS.put("5", "交易完成");
		AQUATICORDERUSERINFO_ORDERSTATUS.put("6", "交易关闭");

		// 订单表订单状态
		AQUATICORDERUSERINFO1_ORDERSTATUS.put("0", "待确认");
		AQUATICORDERUSERINFO1_ORDERSTATUS.put("1", "待付款");
		AQUATICORDERUSERINFO1_ORDERSTATUS.put("2", "付款中");
		AQUATICORDERUSERINFO1_ORDERSTATUS.put("3", "已支付/待发货");
		AQUATICORDERUSERINFO1_ORDERSTATUS.put("4", "已发货/待收货");
		AQUATICORDERUSERINFO1_ORDERSTATUS.put("5", "交易完成");
		AQUATICORDERUSERINFO1_ORDERSTATUS.put("6", "交易关闭");

		// 订单表支付类型
		AQUATICORDERUSERINFO_ORDERONLINE.put("1", "线上订单");
		AQUATICORDERUSERINFO_ORDERONLINE.put("2", "线下订单");

		// 订单表订单表仲裁状态
		AQUATICREFUNDAPPLYINFO_ISARBITRA.put("0", "无需调解");
		AQUATICREFUNDAPPLYINFO_ISARBITRA.put("1", "未调解");
		AQUATICREFUNDAPPLYINFO_ISARBITRA.put("2", "已调解");
		AQUATICREFUNDAPPLYINFO_ISARBITRA.put("3", "调解关闭");

		// 退款表退款状态
		AQUATICREFUNDRECORDINFO_CSSTATUS.put("0", "未联系");
		AQUATICREFUNDRECORDINFO_CSSTATUS.put("1", "已联系");
		AQUATICREFUNDRECORDINFO_CSSTATUS.put("2", "已打款");

		// 实名用户表审核状态
		CRMACCOUNTMEMBERAPPLY_APPSTATUS.put("0", "已审核");
		CRMACCOUNTMEMBERAPPLY_APPSTATUS.put("1", "待审核");
		CRMACCOUNTMEMBERAPPLY_APPSTATUS.put("2", "待审核");
		CRMACCOUNTMEMBERAPPLY_APPSTATUS.put("3", "已驳回");
		CRMACCOUNTMEMBERAPPLY_APPSTATUS.put("4", "已驳回");

		// 用户表帐户状态
		CRMACCOUNTMEMBER_STATUS.put("0", "有效");
		CRMACCOUNTMEMBER_STATUS.put("3", "无效");

		// 发票表发票类型
		AQUATICORDERBILLINFO_BILLTYPE.put("0", "增值发票");
		AQUATICORDERBILLINFO_BILLTYPE.put("1", "普通发票");

		// 发票表发票寄送状态
		AQUATICORDERBILLINFO_ISOPEN.put("0", "已寄出");
		AQUATICORDERBILLINFO_ISOPEN.put("1", "未寄出");

		// 商品SPU表商品状态
		CISGOODSSPU_SPUSTATUS.put("-1", "草稿");
		CISGOODSSPU_SPUSTATUS.put("1", "待处理");
		CISGOODSSPU_SPUSTATUS.put("2", "待上架");
		CISGOODSSPU_SPUSTATUS.put("3", "上架");
		CISGOODSSPU_SPUSTATUS.put("4", "下架");
		CISGOODSSPU_SPUSTATUS.put("5", "运维冻结");
		
		// 导入终端号状态
		BASEPOSNUM_ISBIND.put("0", "未绑定");
		BASEPOSNUM_ISBIND.put("1", "已绑定");
		BASEPOSNUM_COMPANYNAME.put("0","中汇");
		BASEPOSNUM_COMPANYNAME.put("1","拉卡拉");
		
		//终端号对照解绑
		BASEPOSBIND_AUDITSTATUS.put("1", "待审核");
		BASEPOSBIND_AUDITSTATUS.put("2", "已绑定");
		BASEPOSBIND_AUDITSTATUS.put("3", "驳回");
		BASEPOSBIND_AUDITSTATUS.put("4", "待审核");
		BASEPOSBIND_AUDITSTATUS.put("5", "已解绑");
		BASEPOSBIND_AUDITSTATUS.put("6", "驳回");
		
		BASEPOSBIND_COMPANYNAME.put("0","中汇");
		BASEPOSBIND_COMPANYNAME.put("1","拉卡拉");
		
		//异常订单-公司名称（根据postype 判断）
		DELAYED_POSTYPE.put("0","中汇");
		DELAYED_POSTYPE.put("1","拉卡拉");
		
		//异常订单-公司名称（根据resultStatus 判断）
		DELAYED_RESULTSTATUS.put("0","未审核");
		DELAYED_RESULTSTATUS.put("1","已审核-系统");
		DELAYED_RESULTSTATUS.put("2","已审核-中汇");
		DELAYED_RESULTSTATUS.put("3","已审核-拉卡拉");
		DELAYED_RESULTSTATUS.put("4","关闭");
		
		
		//资费相关
		BASEPOSRATE_ISRATE.put("0", "是");
		BASEPOSRATE_ISRATE.put("1", "否");
		
		BASEPOSRATE_ISPAYRATE.put("0", "是");
		BASEPOSRATE_ISPAYRATE.put("1", "否");
		
		BASEPOSRATE_ISSUPPORT.put("0", "是");
		BASEPOSRATE_ISSUPPORT.put("1", "否");
		
		//额度警戒
		BASEPOSLIMIT_STATUS.put("0", "未超过");
		BASEPOSLIMIT_STATUS.put("1", "已超过");
	}
}
