/**
 * Copyright (C) 2016 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.manager.web.util.Constants
 * @description:
 * 
 * @version:v1.0.0 
 * @author:GuoXiaoHu
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-8-4    GuoXiaoHu  v1.0.0        create
 *
 *
 */
package com.xed.financing.wxgzh.util;

/**
 * 常量类
 * 
 * @className:com.xed.financing.manager.web.util.Constants
 * @description:
 * @version:v1.0.0
 * @date:2016-8-4 上午9:29:29
 * @author:GuoXiaoHu
 */
public class Constants
{
	/**
	 * 默认显示每页条数
	 */
	public static int PAGE_SIZE = 10;

	public static String LOGIN_FROMNUM = "1";
	public static String LOGIN_TONUM = "10";

	public static int INT_NUMBER_0 = 0;

	/**
	 * 空
	 */
	public static int EMPTY = 0;

	/**
	 * 服务器地址
	 */
	public static String SERVER_URL = "SERVER_URL";

	public static String UPLOAD_URL = "UPLOAD_URL";
	
	/**
	 * 后台图片文件上传地址
	 */
	public static String MGR_UPLOAD_URL = "MGR_UPLOAD_URL";

	/**
	 * 参数配置状态可用
	 */
	public static String PARAM_STATUS_ENABLE = "0";

	/**
	 * 参数配置状态不可用
	 */
	public static String PARAM_STATUS_DISABLE = "1";

	public static String PARAM_STATUS_TWO = "2";

	/**
	 * 产品详情页面列表展示数量
	 */
	public static String PRODUCT_SIZE = "PRODUCT_SIZE";

	/**
	 * 字符集 UTF-8
	 */
	public static String UTF8 = "UTF-8";
	
	/**
	 * 重置密码
	 */
	public static String RESET_PASSWORD="A123456b";

	/**
	 * DWZ成功状态
	 */
	public static String DWZ_STATUS_SUCCESS = "200";

	/**
	 * DWZ错误状态
	 */
	public static String DWZ_STATUS_ERROR = "300";
	/**
	 * DWZ错误状态
	 */
	public static String DWZ_STATUS_ERRORS = "305";

	/**
	 * DWZ超时状态
	 */
	public static String DWZ_STATUS_TIMEOUT = "301";

	/**
	 * DWZ成功状态
	 */
	public static String DWZ_STATUS_VERIFICATION = "400";

	/**
	 * DWZ回调类型 关闭窗口
	 */
	public static String DWZ_CALLBACKTYPE_CLOSECURRENT = "closeCurrent";

	/**
	 * DWZ回调类型 跳转
	 */
	public static String DWZ_CALLBACKTYPE_FORWARD = "forward";

	/**
	 * DWZ回调类型确认是否跳转
	 */
	public static String DWZ_CALLBACKTYPE_FORWARDCONFIRM = "forwardConfirm";

	public static String[] button =
	{ "添加", "删除", "修改", "导入", "导出", "打印", "操作权限", "冻结", "解冻", "商户审核", "重置密码",
			"退款", "下架", "置为无效", "取消订单", "修改", "配送", "未结算", "发送" };

	/**
	 * 逗号
	 */
	public static String SYMBOL_COMMA = ",";

	public static String PARAMETER_SERVER_UPLOAD = "SERVER_URL";

	/**
	 * 操作按钮值
	 * 
	 */
	public static String MENU_PERMISS = "MENU_PERMISS";

	/**
	 * 短信失效时间
	 */
	public static String SMS_TIMEOUT = "SMS_TIMEOUT";

	/**
	 * 斜杠
	 */
	public static String SYMBOL_SLASH = "/";

	/**
	 * 图片key
	 */
	public static String KEY_IMG = "img";
	public static String KEY_WAPPROMOTION = "pn";
	/**
	 * 状态可用
	 */
	public static String STATUS_ENABLE = "0";

	/**
	 * 状态不可用
	 */
	public static String STATUS_DISABLE = "1";

	/**
	 * 默认id
	 */
	public static int DEFAULT_ID = 0;

	/**
	 * 默排序
	 */
	public static int DEFAULT_ORDERFLAG = 20;

	/**
	 * 立即
	 */
	public static int TYPE_IMMEDIATELY = 1;

	/**
	 * 定时
	 */
	public static int TYPE_TIME = 2;

	/**
	 * 定时
	 */
	public static int SEND_INIT = 1;

	/**
	 * 定时
	 */
	public static int SEND_MEDIUM = 2;

	/**
	 * 价格
	 */
	public static String KEY_PRICE = "PRICE";

	/**
	 * 字符串1
	 */
	public static String STRING_NUMBER_1 = "1";

	/**
	 * 字符串0
	 */
	public static String STRING_NUMBER_0 = "0";

	/**
	 * 江苏省
	 */
	public static String AREA_S_JIANGSU = "320000";

	/**
	 * 南京
	 */
	public static String AREA_C_NANJING = "320100";

	/**
	 * 北京
	 */
	public static String AREA_S_BEIJING = "110000";

	/**
	 * 北京市
	 */
	public static String AREA_C_BEIJING = "110100";

	/**
	 * 登录验证码
	 */
	public static String SMS_LOGIN_VERIFY_CODE = "4";

	/**
	 * 内容标示
	 */
	public static String FLAG_PUSHCONTENT = "#content#";

	/**
	 * ios
	 */
	public static String PLATFORM_IOS = "1";

	/**
	 * Android
	 */
	public static String PLATFORM_ANDROID = "2";

	/**
	 * all
	 */
	public static String PLATFORM_ALL = "3";

	/**
	 * 操作类型增加
	 */
	public static String OPERATE_TYPE_ADD = "add";

	/**
	 * 操作类型修改
	 */
	public static String OPERATE_TYPE_EDIT = "edit";

	/**
	 * 操作类型删除
	 */
	public static String OPERATE_TYPE_DEL = "del";

	/**
	 * 操作类型刷新
	 */
	public static String OPERATE_TYPE_REFRESH = "refresh";

	/**
	 * 操作类型 验证
	 */
	public static String OPERATE_TYPE_VERIFICATION = "verification";

	/**
	 * 轮播图片数
	 */
	public static String APPHOME_TURN_IMG_DEFAULT = "5";

	/**
	 * 轮播图片数
	 */
	public static String APPHOME_TURN_IMG_MAX = "APPHOME_TURN_IMG_MAX";

	/**
	 * PC轮播图片数
	 */
	public static String PCHOME_TURN_IMG_MAX = "PCHOME_TURN_IMG_MAX";

	/**
	 * 搜索关键字
	 */
	public static String HOT_SEARCH_MAX = "HOT_SEARCH_MAX";

	/**
	 * 楼层内容类型-活动
	 */
	public static String FLAGTYPE_ACTIVITY = "1";

	/**
	 * 楼层内容类型-商品
	 */
	public static String FLAGTYPE_PRODUCT = "3";

	/**
	 * PC首页查询关键字配置个数
	 */
	public static String PCHOME_HOT_SEARCH_MAX = "PCHOME_HOT_SEARCH_MAX";

	/**
	 * PC首页查询关键字配置个数
	 */
	public static String PCHOME_CAROUSEL_ADDR = "PCHOME_CAROUSEL_ADDR";

	/**
	 * 轮播图片Key
	 */
	public static String KEY_TURNIMG = "turnimg";

	/**
	 * 热搜关键词Key
	 */
	public static String KEY_HOTSEARCH = "hotsearch";

	/**
	 * APP预加载页图片配置个数
	 */
	public static String APP_PRELOAD_IMG_MAX = "APP_PRELOAD_IMG_MAX";

	/**
	 * 预加载图片Key
	 */
	public static String KEY_PRELOAD = "preloadimg";

	/**
	 * 图片大小KEY
	 */
	public static String KEY_FILESIZE = "filesize";

	/**
	 * 图片宽度key
	 */
	public static String KEY_IMGWIDTH = "imgwidth";

	/**
	 * 图片高度key
	 */
	public static String KEY_IMGHEIGHT = "imgheight";

	/**
	 * 图片格式key
	 */
	public static String KEY_IMGSUFFIX = "imgsuffix";

	/**
	 * 图片尺寸验证浮动值
	 */
	public static String KEY_IMGFLOATVAL = "imgfloatval";

	/**
	 * 图片尺寸验证浮动值
	 */
	public static String KEY_REPORTSALEMAX = "reportsalemax";

	/**
	 * 图片尺寸验证浮动值
	 */
	public static String KEY_REPORTPRICEMAX = "reportpricemax";

	/**
	 * 图片格式key
	 */
	public static String SMS_STATUS_SUCEESS = "0";

	/**
	 * 操作类型
	 */
	public static String OP_ADD = "1";

	/**
	 * 操作类型
	 */
	public static String OP_EDIT = "2";

	/**
	 * 操作类型
	 */
	public static String OP_DEL = "3";

	/**
	 * 操作类型
	 */
	public static String OP_LOGIN = "4";

	/**
	 * 操作类型
	 */
	public static String OP_LOGOUT = "5";

	/**
	 * 操作类型
	 */
	public static String OP_RELEASE = "6";

	/**
	 * 日志模块父类id
	 */
	public static String LOG_SUPER_MODULE_ID = "0";

	/**
	 * 短信发送最多次数
	 */
	public static String SMS_DAY_MAX = "1";

	/**
	 * 短信发送过于频繁
	 */
	public static String SMS_FREQUENTLY = "2";

	/**
	 * 短信发送过于频繁
	 */
	public static String MAJOR_SHOW = "0";

	/**
	 * 短信发送重试
	 */
	public static String SMS_RETRY = "3";

	public static String PROP_USERNAME = "jdbc.username";

	public static String PROP_PASSWORD = "jdbc.password";

	/**
	 * 1结果成功
	 */
	public static int RESULT_SUCCESS = 1;

	/**
	 * 轮播图片数
	 */
	public static String PCHOME_CAROUSEL_MAX = "PCHOME_CAROUSEL_MAX";

	/**
	 * PC首页类别菜单配置个数
	 */
	public static String PCHOME_TYPE_MAX = "PCHOME_TYPE_MAX";

	/**
	 * 楼层内容类型-商品
	 */
	public static String FLAGTYPE_GOODS = "1";

	/**
	 * PC首页选择最大SKU个数
	 */
	public static String PCHOME_CHOOSE_SKU_MAX = "PCHOME_CHOOSE_SKU_MAX";

	/**
	 * PC首页定时发布晚于当前时间的分钟数
	 */
	public static String PCHOME_AFTER_TIME = "PCHOME_AFTER_TIME";

	/**
	 * 商品上架
	 */
	public static String GOODS_ONSALE = "0";

	public static String PASSWORD = "123456";

	public static String STRING_PROVINCE = "320000";

	public static String STRING_CITY = "320100";

	// ===============================================================
	// ===============================================================
	// ===============================================================
	// ======================新增加的常量请在该内容下方添加=====================
	// ===============================================================
	// ===============================================================
	// ===============================================================

	/**
	 * 查询分页数量
	 */
	public static String MAP_RESULT_TOTAL = "total";

	/**
	 * 查询分页列表
	 */
	public static String MAP_RESULT_ROWS = "rows";

	/**
	 * 最大的配送范围(便于搜索查询)
	 */
	public static String DELIVER_DISTANCE_MAX = "shop_distance";

	/**
	 * 最低的配送范围
	 */
	public static String DELIVER_DISTANCE_MIN = "delivery_distance";

	/**
	 * 魔鬼数字-2
	 */
	public static String DEVIL_NUM_ZTWO = "-2";
	/**
	 * 魔鬼数字-1
	 */
	public static String DEVIL_NUM_ZONE = "-1";

	/**
	 * 魔鬼数字0
	 */
	public static String DEVIL_NUM_ZERO = "0";

	/**
	 * 魔鬼数字1
	 */
	public static String DEVIL_NUM_ONE = "1";

	/**
	 * 魔鬼数字2
	 */
	public static String DEVIL_NUM_TWO = "2";

	/**
	 * 魔鬼数字3
	 */
	public static String DEVIL_NUM_THREE = "3";

	/**
	 * 魔鬼数字4
	 */
	public static String DEVIL_NUM_FOUR = "4";
	/**
	 * 魔鬼数字5
	 */
	public static String DEVIL_NUM_FIVE = "5";
	/**
	 * 魔鬼数字6
	 */
	public static String DEVIL_NUM_SIX = "6";

	/**
	 * 魔鬼数字7
	 */
	public static String DEVIL_NUM_SEVEN = "7";

	/**
	 * 魔鬼数字8
	 */
	public static String DEVIL_NUM_EIGHT = "8";

	/**
	 * 魔鬼数字9
	 */
	public static String DEVIL_NUM_NINE = "9";
	
	/**
	 * 魔鬼数字10
	 */
	public static String DEVIL_NUM_TEN = "10";
	
	/**
	 * 魔鬼数字11
	 */
	public static String DEVIL_NUM_ELEVEN = "11";
	
	/**
	 * 魔鬼数字12
	 */
	public static String DEVIL_NUM_TWEVEL = "12";

	/**
	 * 魔鬼数字15
	 */
	public static String DEVIL_NUM_FIFTEEN = "15";
	
	/**
	 * 魔鬼数字18
	 */
	public static String DEVIL_NUM_EIGHTTEN = "18";
	
	/**
	 * 魔鬼数字20
	 */
	public static String DEVIL_NUM_TWENTY = "20";
	/**
	 * 魔鬼数字19
	 */
	public static String DEVIL_NUM_NINETEEN = "19";

	/**
	 * 魔鬼数字25
	 */
	public static String DEVIL_NUM_TWENTY_FIVE = "25";
	
	/**
	 * 魔鬼数字30
	 */
	public static String DEVIL_NUM_THIRTH = "30";

	/**
	 * 魔鬼数字40
	 */
	public static String DEVIL_NUM_FORTY = "40";
	
	/**
	 * 魔鬼数字50
	 */
	public static String DEVIL_NUM_FIFTY = "50";
	
	/**
	 * 魔鬼数字60
	 */
	public static String DEVIL_NUM_SIXTY = "60";

	/**
	 * 魔鬼数字70
	 */
	public static String DEVIL_NUM_SEVENTY = "70";

	/**
	 * 魔鬼数字80
	 */
	public static String DEVIL_NUM_EIGHTY = "80";

	/**
	 * 魔鬼数字90
	 */
	public static String DEVIL_NUM_NINETY = "90";

	/**
	 * 魔鬼数字100
	 */
	public static String DEVIL_NUM_HUNDRED_ONE = "100";

	/**
	 * 魔鬼数字200
	 */
	public static String DEVIL_NUM_HUNDRED_TWO = "200";

	/**
	 * 魔鬼数字300
	 */
	public static String DEVIL_NUM_HUNDRED_THREE = "300";

	/**
	 * 魔鬼数字400
	 */
	public static String DEVIL_NUM_HUNDRED_FOUR = "400";
	
	/**
	 * 魔鬼数字500
	 */
	public static String DEVIL_NUM_HUNDRED_FIVE = "500";

	/**
	 * 魔鬼数字600
	 */
	public static String DEVIL_NUM_HUNDRED_SIX = "600";

	/**
	 * 魔鬼数字700
	 */
	public static String DEVIL_NUM_HUNDRED_SEVEN = "700";

	/**
	 * 魔鬼数字800
	 */
	public static String DEVIL_NUM_HUNDRED_EIGHT = "800";

	/**
	 * 魔鬼数字900
	 */
	public static String DEVIL_NUM_HUNDRED_NINE = "900";

	/**
	 * 魔鬼数字1000
	 */
	public static String DEVIL_NUM_THOUSAND_ONE = "1000";

	/**
	 * 魔鬼数字2000
	 */
	public static String DEVIL_NUM_THOUSAND_TWO = "2000";

	/**
	 * 魔鬼数字3000
	 */
	public static String DEVIL_NUM_THOUSAND_THREE = "3000";

	/**
	 * 魔鬼数字4000
	 */
	public static String DEVIL_NUM_THOUSAND_FOUR = "4000";
	
	/**
	 * 魔鬼数字5000
	 */
	public static String DEVIL_NUM_THOUSAND_FIVE = "5000";

	/**
	 * 魔鬼数字6000
	 */
	public static String DEVIL_NUM_THOUSAND_SIX = "6000";

	/**
	 * 魔鬼数字7000
	 */
	public static String DEVIL_NUM_THOUSAND_SEVEN = "7000";

	/**
	 * 魔鬼数字8000
	 */
	public static String DEVIL_NUM_THOUSAND_EIGHT = "8000";

	/**
	 * 魔鬼数字9000
	 */
	public static String DEVIL_NUM_THOUSAND_NINE = "9000";

	/**
	 * 魔鬼数字10000
	 */
	public static String DEVIL_NUM_THOUSAND_TEN = "10000";

	/**
	 * 魔鬼数字20000
	 */
	public static String DEVIL_NUM_THOUSAND_TWENTY = "20000";

	/**
	 * 魔鬼数字30000
	 */
	public static String DEVIL_NUM_THOUSAND_THIRTY = "30000";

	/**
	 * 魔鬼数字40000
	 */
	public static String DEVIL_NUM_THOUSAND_FORTY = "40000";
	
	/**
	 * 魔鬼数字50000
	 */
	public static String DEVIL_NUM_THOUSAND_FIFTY = "50000";

	/**
	 * 魔鬼数字60000
	 */
	public static String DEVIL_NUM_THOUSAND_SIXTY = "60000";

	/**
	 * 魔鬼数字70000
	 */
	public static String DEVIL_NUM_THOUSAND_SEVENTY = "70000";

	/**
	 * 魔鬼数字80000
	 */
	public static String DEVIL_NUM_THOUSAND_EIGHTY = "80000";

	/**
	 * 魔鬼数字90000
	 */
	public static String DEVIL_NUM_THOUSAND_NINETY = "90000";

	/**
	 * 电话号码前三位
	 */
	public static int TEL_BEFORE_THREE = 3;

	/**
	 * 电话号码后四位
	 */
	public static int TEL_BEHIND_FOUR = 7;

	/**
	 * 开始位置
	 */
	public static int START_INDEX = 0;

	/**
	 * 图片验证码key
	 */
	public static String IMG_CODE_KEY = "RANDOMVALIDATECODEKEY";

	/**
	 * 图片验证码key
	 */
	public static String ACCOUNT_SESSION_NAME = "account";

	/**
	 * 顶级
	 */
	public static String LEVEL_SUPER = "-1";
	
	/**
	 * 导出求购
	 */
	public static String EXPORT_BUY = "goodsBuy";
	
	/**
	 * 导出商品
	 */
	public static String EXPORT_GOODS = "goods";
	
	/**
	 * 导出订单
	 */
	public static String EXPORT_ORDER = "orderMgr";
	
	/**
	 * 导出退款订单
	 */
	public static String EXPORT_REFUND = "refundOrder";
	
	/**
	 * 导出线下退款
	 */
	public static String EXPORT_OFFLINE = "offlineRefund";
	
	/**
	 * 导出重复付款
	 */
	public static String EXPORT_REPEAT = "refundRepeat";
	
	/**
	 * 导出商户资质
	 */
	public static String EXPORT_SHOP_CHECK = "shopCheck";
	
	/**
	 * 导出实名认证
	 */
	public static String EXPORT_USER_APPLY = "userApply";
	
	/**
	 * 导出卖家用户
	 */
	public static String EXPORT_SHOP = "shop";
	
	/**
	 * 导出买家用户
	 */
	public static String EXPORT_USER = "user";
	
	/**
	 * 导出用户发票
	 */
	public static String EXPORT_BILL = "bill";
	
	/**
	 * 导出用户反馈
	 */
	public static String EXPORT_ = "feedBack";
	
	/**
	 * 导出结算
	 */
	public static String EXPORT_SETTLE = "settle";
	
	/**
	 * 导出时每页记录数
	 */
	public static Integer EXPORT_PAGE_COUNT = 10000;
    
    /**
     * 用户等级：0
     */
    public static String USERLEVEL_ZEOR = "USERLEVEL_ZEOR";
    
    /**
     * 用户等级：1
     */
    public static String USERLEVEL_ONE ="USERLEVEL_ONE";
    
    /**
     * 用户等级：2
     */
    public static String USERLEVEL_TWO ="USERLEVEL_TWO";
    
    /**
     * 用户等级：3
     */
    public static String USERLEVEL_THREE ="USERLEVEL_THREE";
    
    /**
     * 用户等级：4
     */
    public static String USERLEVEL_FOUR ="USERLEVEL_FOUR";
    
    /**
     * 用户等级：5
     */
    public static String USERLEVEL_FIVES ="USERLEVEL_FIVES";
    
    /**
     * 用户等级：6
     */
    public static String USERLEVEL_SIX ="USERLEVEL_SIX";
    
    /**
     * 用户等级：7
     */
    public static String USERLEVEL_SEVEN ="USERLEVEL_SEVEN";
    
    /**
     * 用户等级：8
     */
    public static String USERLEVEL_EIGHT ="USERLEVEL_EIGHT";
    
    /**
     * 用户等级：9
     */
    public static String USERLEVEL_NINE ="USERLEVEL_NINE";
    
    /**
     * 用户等级：10
     */
    public static String USERLEVEL_TEN = "USERLEVEL_TEN";
    
    /**
     * 每日签到奖励积分
     */
    public static String DAILY_POINTS = "DAILY_POINTS";
    
    /**
     * 签到累计7日额外积分
     */
    public static String EXTRA_POINTS_SEVENS = "EXTRA_POINTS_SEVENS";
    
    /**
     * 签到累计20日额外积分
     */
    public static String EXTRA_POINTS_TWENTY = "EXTRA_POINTS_TWENTY";
    
    /**
     * 签到满签额外奖励
     */
    public static String EXTRA_POINTS_ALLDAY = "EXTRA_POINTS_ALLDAY";
    
    /**
     * 积分充值比率
     */
    public static String SCORE_RATIO="SCORE_RATIO";
    
    /**
     * 债权承接奖励积分比率
     */
    public static String TAKE_POINTS="TAKE_POINTS";
    
    /**
     * 注册成功送体验金ID
     */
    public static String REGISTERED_EXPERIENCE_GOLD = "REGISTERED_EXPERIENCE_GOLD";
    
    /**
     * 注册成功体验金期限(-1为不限期)
     */
    public static String EXPERIENCE_PERIOD = "EXPERIENCE_PERIOD";
    
    /**
     * 活动体验金
     */
    public static String ACTIVITY_EXPERIENCE_GOLD = "ACTIVITY_EXPERIENCE_GOLD";
    
    /**
     * 活动体验金到期时间
     */
    public static String ACTIVITY_TIME = "ACTIVITY_TIME";
    
    /**
     * 抽奖奖励时间
     */
    public static String AWARD_TIME = "180";
    
    /**
     * 完善积分赠送积分值
     */
    public static String PERFECT_INFO_GIFT_POINTS = "PERFECT_INFO_GIFT_POINTS";
    
    /**
     * 集字活动现金券ID
     */
    public static String ACTIVITY_CASHCOUPON = "ACTIVITY_CASHCOUPON";
    
    /**
     * 集字活动获得字体截至日期
     */
    public static String ACTIVITY_CASHCOUPON_END_TIME = "ACTIVITY_CASHCOUPON_END_TIME";
    
    /**
     * 集字活动获得字体开始日期
     */
    public static String ACTIVITY_CASHCOUPON_BEGIN_TIME = "ACTIVITY_CASHCOUPON_BEGIN_TIME";
    
    /**
     * 活动赠送加息券
     */
    public static String ACTIVITY_SEND_JAIXI = "ACTIVITY_SEND_JAIXI";
    
    /**
     * 活动赠送现金券 
     */
    public static String ACTIVITY_SEND_CRASH = "ACTIVITY_SEND_CRASH";
    
    /**
     * 活动赠送的2元现金券
     */
    public static String ACTIVITY_SEND_MONEY = "ACTIVITY_SEND_MONEY";
    
    /**
     * 推荐码2元现金券
     */
    public static String ACTIVITY_RECOMMED_CRASH = "ACTIVITY_RECOMMED_CRASH";
    
    /**
     * 注册推荐码8.8元现金券
     */
    public static String REGISTER_COUPON_ID = "REGISTER_COUPON_ID";
    
    /**
     * 双十一送手机活动标
     */
    public static String ACTIVITY_SEND_IPHONE = "-1";
    
    /**
     * 等级特权签到送加息券
     */
    public static String LEVEL_POWER_SIGN_SEND_INTEREST = "LEVEL_POWER_SIGN_SEND_INTEREST";
    
    /**
     * 等级特权生日送现金券
     */
    public static String LEVEL_POWER_BIRTHDAY_SEND_CASH="LEVEL_POWER_BIRTHDAY_SEND_CASH";
    
    /**
     * 等级特权升级送现金券
     */
    public static String LEVEL_POWER_UPGRADE_SEND_CASH="LEVEL_POWER_UPGRADE_SEND_CASH";
    
    /**
     * 等级特权升级送加息券
     */
    public static String LEVEL_POWER_UPGRADE_SEND_INTEREST="LEVEL_POWER_UPGRADE_SEND_INTEREST";
    
    /**
     * 双十二送iphonex活动
     */
    public static String TWELVE_ACTIVITY_IPHONEX="-2";
    
    /**
     * 双十二活动 投资2W元iphoneX购机价格(分)
     */
    public static String TWELVE_ACTIVITY_BUY_TWO = "778800";
    
    /**
     * 双十二活动 投资3W元iphoneX购机价格(分)
     */
    public static String TWELVE_ACTIVITY_BUY_THREE = "758800";
    
    /**
     * 双十二活动 投资2W元iphoneX购机价格(元)
     */
    public static String TWELVE_ACTIVITY_BUY_TWO_YUAN = "7788";
    
    /**
     * 双十二活动 投资3W元iphoneX购机价格(元)
     */
    public static String TWELVE_ACTIVITY_BUY_THREE_YUAM = "7588";
    
    /**
     * 双十二活动 投资2W元iphoneX购机(元)
     */
    public static String TWELVE_ACTIVITY_INVEST_TWO = "20000";
    
    /**
     * 双十二活动 投资3W元iphoneX购机(元)
     */
    public static String TWELVE_ACTIVITY_INVEST_THREE = "30000";
    
    /**
     * 双十二活动 iphoneX数量 10
     */
    public static int TWELVE_ACTIVITY_IPHONEX_COUNT = 10;

    
    /**
     * 圣诞送食用油
     */
    public static String GIFT_OIL = "东方秀黑葵花籽食用油一桶";
    
    /**
     * 圣诞开启时间
     */
    public static String CHRISTMAS = "2017-12-25";
    
    /**
     * 食用油ID
     */
    public static String GIFT_OIL_ID = "5";
    
    /**
     * 元旦送食用油
     */
    public static String GLUTINOUSRIC = "五谷杂粮优质糯米一袋";
    
    /**
     * 元旦开启时间
     */
    public static String YUANDAN = "2018-01-01";
    
    /**
     * 元旦送糯米ID
     */
    public static String GLUTINOUSRICE_ID = "7";
    
    /**
     * 元旦跨年投资门槛
     */
    public static String YUANDAN_KUANIAN_MONEY="200000";
    
    /**
     * 小黄米
     */
    public static String XIAOHUANMI_GOODS="6";
    
    /**
     * SKII神仙水
     */
    public static String SHENXIANSHUI_GOODS="3";
    
    /**
     * 抽奖标识
     */
    public static String AWARD_ROTATE_VALUE="1";
    
    /**
     * 随机红包标识
     */
    public static String RED_PACKAGE_VALUE="2";
    
    /**
     * 2017跨年活动开始时间
     */
    public static String NEW_YEAR_BEGIN_TIME="2017-12-31 22:00:00";

    /**
     * 2017跨年活动结束时间
     */
    public static String NEW_YEAR_END_TIME="2017-12-31 23:59:59";
    
    
    public static String FUSE_COUPON_ID_ZZQ="FUSE_COUPON_ID_ZZQ";
    
    public static String FUSE_COUPON_ID_JXQ="FUSE_COUPON_ID_JXQ";
    
    /**
     * 猫咪储蓄劵有效期（天）
     */
    public static String SAVINGSVALIDITY = "30";
    
    /**
     * 春节活动开始时间
     */
    public static String SPRING_FESTIVAL_BEGIN_TIME = "2018-02-15 00:00:00";
    
    /**
     * 春节活动结束时间
     */
    public static String SPRING_FESTIVAL_END_TIME = "2018-02-21 23:59:59";
    
    /**
     * 春节活动单个项目领奖次数
     */
    public static int SPRING_FESTIVAL_COUNT = 3;
    
    /**
     * 春节奖励新手标次数
     */
    public static int SPRING_FESTIVAL_NEWSUBJECT_COUNT = 2;
    
    /**
     * 春节 送500鱼干
     */
    public static int SPRING_FESTIVAL_AWARDCOUNT1 = 500;
    
    /**
     * 春节 送1200鱼干
     */
    public static int SPRING_FESTIVAL_AWARDCOUNT2 = 1200;
    
    /**
     * 春节 送优惠价有效期
     */
    public static String SPRING_FESTIVAL_VALIDITYDAYS = "180";
    
    /**
     * 默认风险金 100W
     */
    public static String DEFAULTRISKAMOUNT = "1000000";
    
    /**
     * 京东E卡100元
     */
    public static String JINGDONGEKA100="11";
    
    /**
     * 京东E卡200元
     */
    public static String JINGDONGEKA200="10";
    
    /**
     * 泰国游团票
     */
    public static String TAIGUOYOU="12";
    
    /**
     * 越南游团票
     */
    public static String YUENANYOU="13";
    
    /**
     * 国庆活动开始时间
     */
    public static String FIVE_ZERO_EIGHT_ACTIVITY_BEGIN_TIME="2018-10-01";
    
    /**
     * 国庆活动结束时间
     */
    public static String FIVE_ZERO_EIGHT_ACTIVITY_END_TIME="2018-10-12";
    
    /**
     * 国庆活动开始时间 精确到秒
     */
    public static String FIVE_ZERO_EIGHT_ACTIVITY_BEGIN_TIME_HOUR="2018-10-01 00:00:00";
    
    /**
     * 国庆活动结束时间 精确到秒
     */
    public static String FIVE_ZERO_EIGHT_ACTIVITY_END_TIME_HOUR="2018-10-12 23:59:59";
    
    /**
     * 暑期活动投资拿奖上限
     */
    public static int FIVE_ZERO_EIGHT_ACTIVITY_INVEST_LIMIT=2;
    
    /**
     * 2018中秋满签天数
     */
    public static int MID_MOON_FULL_SIGN_DAYS=8;
    
    /**
     * 双十二活动开始时间 精确到秒
     */
    public static String TWELVE_AND_TWELVE_ACTIVITY_BEGIN_TIME_HOUR="2018-12-04 00:00:00";
    
    /**
     * 双十二活动结束时间 精确到秒
     */
    public static String TWELVE_AND_TWELVE_ACTIVITY_END_TIME_HOUR="2018-12-12 23:59:59";
}
