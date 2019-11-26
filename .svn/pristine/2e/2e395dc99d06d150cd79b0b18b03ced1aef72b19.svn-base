/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.mapper.subject.SubjectMapper
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
package com.xed.financing.wxgzh.mapper.subject;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xed.financing.wxgzh.model.subject.SubjectBean;

/**
 * @className:com.xed.financing.wxgzh.mapper.subject.SubjectMapper
 * @description:
 * @version:v1.0.0 
 * @date:2017年3月16日 上午11:00:53
 * @author:Qian Tao
 */
public interface SubjectMapper
{
	
	/**
	 * 
	 * 查询首页标的数据
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月24日 上午9:43:21
	 */
	public List<SubjectBean> queryFontPageSubject(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 
	 * 查询首页次日标的数据
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月24日 上午9:43:21
	 */
	public List<SubjectBean> queryFontNextSubject(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 首页实物标
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年5月24日 下午12:02:00
	 */
	public List<SubjectBean> queryFontHotSubject(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 
	 * @Description: 根据类型查询标的列表
	 * @param subjectBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月16日 上午11:03:13
	 */
	public List<SubjectBean> querySubject(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * (ios)根据类型分页查询标的列表
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:zheng shuai
	 * @date:2018年6月13日 下午1:59:55
	 */
	public List<SubjectBean> querySubjectLimit(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查看次日发布标列表
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月28日 下午5:09:49
	 */
	public List<SubjectBean> queryNextSubject(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查看标的详情
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月16日 下午3:49:32
	 */
	public SubjectBean querySubjectById(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 修改标信息
	 * @Description:
	 * @param subjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月20日 下午6:15:48
	 */
	public void updateSubjectInfo(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 添加投标信息
	 * @Description:
	 * @param subjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年3月20日 下午6:18:17
	 */
	public void addSubjectInvest(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查询单个标投资者记录
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月2日 下午3:08:40
	 */
	public List<SubjectBean> querySubjectAccount(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查询已投资金额
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月2日 下午3:55:57
	 */
	public SubjectBean queryInvestMoney(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 投标判断新手专享标（只可投两次）
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月10日 下午2:51:41
	 */
	public Integer countNewSubject(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 公司类型投标次数（第一次限投500）
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年7月13日 上午10:21:45
	 */
	public Integer countCompanySubject(SubjectBean subjectBean) throws SQLException;

	public List<SubjectBean> querySubjectByQuartz(Map<String, String> map)throws SQLException;
	
	/**
	 * 查询爆款标总列表
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月24日 上午10:17:24
	 */
	public List<SubjectBean> queryHotSubject(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查询爆款标详情
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月24日 上午10:17:40
	 */
	public SubjectBean queryHotSubjectById(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 更新爆款标商品数量
	 * @Description:
	 * @param subjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年4月25日 上午10:09:55
	 */
	public void updateHotSubjectGoodsStock(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查询次日发布标总数和总金额
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年6月23日 上午10:48:27
	 */
	public SubjectBean countNextSubject(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查询优惠券权限
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Qian Tao
	 * @date:2017年9月11日 下午5:44:29
	 */
	public List<SubjectBean> querySubjectCoupon(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 添加获奖记录
	 * @Description:
	 * @param subjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年9月22日 上午11:20:02
	 */
	public void addAwardRecord(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 获得奖励次数
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年9月22日 下午1:49:26
	 */
	public Integer countIsGetAward(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查询用户国庆中间记录
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年9月26日 下午4:29:47
	 */
	public SubjectBean queryAwardById(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 
	 * 双十一  查询用户在时间戳内投了多少钱的数量
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月26日 下午3:39:38
	 */
	public Integer countElevenSubject(SubjectBean subjectBean) throws SQLException;
	
	
	/**
	 * 
	 * 双十一活动期间累计投资金额  投资笔数
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年10月26日 下午3:40:40
	 */
	public SubjectBean querySumElevenMoney(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查询当天投资总额
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年11月15日 上午10:40:26
	 */
	public Integer queryTodayInvestAllMoney(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 
	 * 根据subjectId查询投资数量
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年12月7日 上午9:39:51
	 */
	public Integer countTwelveActivity(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查询圣诞节活动用户是否第一次满足条件投资
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:Peng Gang
	 * @date:2017年12月18日 下午4:33:04
	 */
	public Integer countChristmas(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 跨年活动  查询活动时间内达标的次数 
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2017年12月21日 上午10:23:48
	 */
	public Integer countInvestBetweenTime(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 富豪排行榜（查询前7名）
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年5月11日 上午9:51:41
	 */
	public List<SubjectBean> rich(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 人脉排行榜（查询前7名）
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:duanjy
	 * @date:2018年5月11日 上午9:53:07
	 */
	public List<SubjectBean> connection(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 修改中奖记录
	 * @Description:
	 * @param subjectBean
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年7月2日 下午5:02:56
	 */
	public void updateAward(SubjectBean subjectBean) throws SQLException;
	
	/**
	 * 查询中奖纪录
	 * @Description:
	 * @param subjectBean
	 * @return
	 * @throws SQLException
	 * @version:v1.0
	 * @author:QT
	 * @date:2018年7月4日 下午2:06:09
	 */
	public List<SubjectBean> queryAwardList(SubjectBean subjectBean) throws SQLException;
}
