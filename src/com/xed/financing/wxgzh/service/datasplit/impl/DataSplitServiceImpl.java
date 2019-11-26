/**
 * Copyright (C) 2017 FZJT Co. Ltd.
 *
 *
 * @className:com.xed.financing.wxgzh.service.datasplit.impl.DataSplitServiceImpl
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
package com.xed.financing.wxgzh.service.datasplit.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.datasplit.DataSplitMapper;
import com.xed.financing.wxgzh.model.freedomsubject.FreedomSubjectBean;
import com.xed.financing.wxgzh.model.subjectdispersed.SubjectDispersedBean;
import com.xed.financing.wxgzh.service.datasplit.DataSplitService;
import com.xed.financing.wxgzh.util.MoneyUtils;

/**
 * @className:com.xed.financing.wxgzh.service.datasplit.impl.DataSplitServiceImpl
 * @description:
 * @version:v1.0.0
 * @date:2017年3月22日 下午4:37:29
 * @author:Qian Tao
 */
@Service
public class DataSplitServiceImpl implements DataSplitService
{
	@Resource
	private DataSplitMapper dataSplitMapper;

	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(DataSplitServiceImpl.class);

	@Override
	public List<FreedomSubjectBean> getFreedomInvestInfo() throws Exception
	{
		
		return dataSplitMapper.getFreedomInvestInfo();
	}

	@Override
	public void deleteDispersedRecord(List<FreedomSubjectBean> freedomSubjectBeans) throws Exception
	{
		dataSplitMapper.deleteDispersedRecord(freedomSubjectBeans);
	}

	@Override
	@Transactional
	public void addInvestRecord(List<FreedomSubjectBean> freedomSubjectBeans) throws Exception
	{
		try{
			// 查询所有未满标的分散标
			List<SubjectDispersedBean> subjectDispersedBeans = dataSplitMapper.getSubjectDispersed();
			
			// 遍历用户
			for (FreedomSubjectBean freedomSubjectBean : freedomSubjectBeans)
			{
				// 总金额
				String totalAmount = freedomSubjectBean.getFreedomMoney();
				// 剩余金额
				String residualAmount = totalAmount;
				// 每笔分投
				String eachThrow = MoneyUtils.formatFloatNumber(Double.parseDouble(totalAmount)/subjectDispersedBeans.size());
				eachThrow = eachThrow.substring(0, eachThrow.indexOf("."));
				
				for (int i = 0; i < subjectDispersedBeans.size(); i++)
				{
					// 判断是否为最后一标
					if(i+1==subjectDispersedBeans.size()){
						eachThrow = residualAmount;
					}
					// 设置投标金额
					subjectDispersedBeans.get(i).setMoney(eachThrow);
					// 设置投标时间
					subjectDispersedBeans.get(i).setInTime(freedomSubjectBean.getFreedomDate());
					// 设置用户ID
					subjectDispersedBeans.get(i).setAccountId(freedomSubjectBean.getAccountId());
					
					
					// 添加投标
					dataSplitMapper.addSubjectDispersed(subjectDispersedBeans.get(i));
					
					// 操作剩余金额
					residualAmount = MoneyUtils.formatFloatNumber(Double.parseDouble(residualAmount)-Double.parseDouble(eachThrow));
					residualAmount = residualAmount.substring(0, residualAmount.indexOf("."));
				}
				
			}
		
		}
		catch (Exception e)
		{
			logger.error("拆分分散标投资记录异常");
			throw new RuntimeException();
		}
		
	}

}
