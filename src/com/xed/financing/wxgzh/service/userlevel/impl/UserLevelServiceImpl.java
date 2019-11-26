package com.xed.financing.wxgzh.service.userlevel.impl;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xed.financing.wxgzh.mapper.accountInfo.AccountInfoMapper;
import com.xed.financing.wxgzh.mapper.param.ParamMapper;
import com.xed.financing.wxgzh.mapper.userlevel.UserLevelMapper;
import com.xed.financing.wxgzh.model.accountinfo.AccountInfo;
import com.xed.financing.wxgzh.service.userlevel.UserLevelService;
import com.xed.financing.wxgzh.util.Constants;

@Service
public class UserLevelServiceImpl implements UserLevelService
{
	/**
	 * 日志
	 */
	private Logger logger = Logger.getLogger(UserLevelServiceImpl.class);

	@Resource
	private UserLevelMapper userLevelMapper;

	@Resource
	private AccountInfoMapper accountInfoMapper;

	@Resource
	private ParamMapper paramMapper;

	@Override
	@Transactional
	public Integer changeUserLevel(HttpServletRequest request) throws SQLException
	{
		try
		{
			// 获取登录用户信息
			AccountInfo account = (AccountInfo) request.getSession().getAttribute("account");
			AccountInfo info = accountInfoMapper.getLoginAccountInfo(account.getAccountId());

			// 获取经验，等级经验
			Integer exp = Integer.valueOf(info.getAccountExp());
			Integer zeor = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_ZEOR));
			Integer one = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_ONE));
			Integer two = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_TWO));
			Integer three = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_THREE));
			Integer four = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_FOUR));
			Integer fives = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_FIVES));
			Integer six = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_SIX));
			/*Integer seven = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_SEVEN));
			Integer eight = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_EIGHT));
			Integer nine = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_NINE));*/
			/*Integer ten = Integer.valueOf(paramMapper.getParamVal(Constants.USERLEVEL_TEN));*/
			// 判断经验等级，设置
			if (exp <= zeor)
			{
				info.setAccountLevel(Constants.DEVIL_NUM_ZERO);
			}
			else if (exp <= one)
			{
				info.setAccountLevel(Constants.DEVIL_NUM_ONE);
			}
			else if (exp <= two)
			{
				info.setAccountLevel(Constants.DEVIL_NUM_TWO);
			}
			else if (exp <= three)
			{
				info.setAccountLevel(Constants.DEVIL_NUM_THREE);
			}
			else if (exp <= four)
			{
				info.setAccountLevel(Constants.DEVIL_NUM_FOUR);
			}
			else if (exp <= fives)
			{
				info.setAccountLevel(Constants.DEVIL_NUM_FIVE);
			}
			else if (exp <= six)
			{
				info.setAccountLevel(Constants.DEVIL_NUM_SIX);
			}
			else
			{
				info.setAccountLevel(Constants.DEVIL_NUM_SEVEN);
			}
			/*else if (exp <= eight)
			{
				info.setAccountLevel(Constants.DEVIL_NUM_EIGHT);
			}
			else if (exp <= nine)
			{
				info.setAccountLevel(Constants.DEVIL_NUM_NINE);
			}
			else
			{
				info.setAccountLevel(Constants.DEVIL_NUM_TEN);
			}*/

			// 修改用户等级
			Integer result = userLevelMapper.changeUserLevel(info);
			return result;
		}
		catch (Exception e)
		{
			logger.error("变更用户等级异常");
			throw new RuntimeException();
		}

	}

}
