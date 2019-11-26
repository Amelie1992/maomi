package com.xed.financing.wxgzh.model.accountinfo;

/**
 * 账户信息
 * 
 * @className:com.xed.financing.wxgzh.model.accountInfo.AccountInfo
 * @description: 账户信息
 * @version:v1.0.0
 * @date:2017年3月15日 上午10:50:23
 * @author:ZhangJun
 */
public class AccountInfo
{
	/**
	 * 用户ID
	 */
	private String accountId;

	/**
	 * 用户名
	 */
	private String accountName;

	/**
	 * 用户名是否已修改0:未修改 1:已修改
	 */
	private String isChangeName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 交易密码
	 */
	private String dealPassword;

	/**
	 * 手机号
	 */
	private String telephone;

	/**
	 * 用户真实姓名
	 */
	private String realName;

	/**
	 * 身份证号
	 */
	private String idCard;

	/**
	 * 用户性别(0:男 1:女)
	 */
	private String accountSex;

	/**
	 * 用户积分
	 */
	private String accountScore;

	/**
	 * 用户经验值
	 */
	private String accountExp;

	/**
	 * 用户等级
	 */
	private String accountLevel;

	/**
	 * 其他联系人关系
	 */
	private String accountContactType;

	/**
	 * 其他联系人姓名
	 */
	private String accountContactName;

	/**
	 * 其他联系人电话
	 */
	private String accountContactPhone;

	/**
	 * 用户QQ
	 */
	private String accountQQ;

	/**
	 * 用户微信
	 */
	private String accountWX;

	/**
	 * 用户微博
	 */
	private String accountWB;

	/**
	 * 用户邮箱
	 */
	private String accountEmail;

	/**
	 * 邮箱是否验证(0:未验证 1:已验证)
	 */
	private String isEmailValidate;

	/**
	 * 注册时间
	 */
	private String regTime;

	/**
	 * 登录时间
	 */
	private String loginTime;

	/**
	 * 账户状态(0:正常 1:冻结 2:注销)
	 */
	private String status;

	/**
	 * 邀请人手机号
	 */
	private String recommendTelephone;

	/**
	 * 邀请码
	 */
	private String recommendCode;

	/**
	 * 注册方式(0:PC 1:微信 2:安卓 3:IOS)
	 */
	private String regType;

	/**
	 * 新手专享标可投次数
	 */
	private String newSubjectCount;

	/**
	 * 风险测试结果分数
	 */
	private String riskResult;

	/**
	 * 是否风险测试(0:否 1:是)
	 */
	private String isRisk;

	/**
	 * 风险金额
	 */
	private String riskAmount;

	/**
	 * 验证码code
	 */
	private String yzm;

	/**
	 * 用户头像
	 */
	private String accountIcon;

	/**
	 * 个人/公司用户(0:个人 1:公司)
	 */
	private String isCompany;
	/**
	 * 微信唯一标识
	 */
	private String unionid;

	private String isReward;

	/**
	 * 等级ID
	 */
	private String levelId;

	/**
	 * 等级状态(0:正常 1:即将降级)
	 */
	private String isChange;

	/**
	 * 已获得等级礼包
	 */
	private String isRewardLevel;

	/**
	 * 用户签到次数
	 */
	private String signs;

	/**
	 * 补签次数
	 */
	private String repairSignNumber;

	/**
	 * 特权提现次数
	 */
	private String withdrawalsNumber;

	/**
	 * 优惠券融合次数
	 */
	private String fuseCouponNumber;

	/**
	 * 免费提现次数
	 */
	private String freeWithdrawalsNumber;

	/**
	 * 是否有金账户(0:没有,1:有)
	 */
	private String haveGold;

	public String getHaveGold()
	{
		return haveGold;
	}

	public void setHaveGold(String haveGold)
	{
		this.haveGold = haveGold;
	}

	public String getRiskAmount()
	{
		return riskAmount;
	}

	public void setRiskAmount(String riskAmount)
	{
		this.riskAmount = riskAmount;
	}

	public String getFreeWithdrawalsNumber()
	{
		return freeWithdrawalsNumber;
	}

	public void setFreeWithdrawalsNumber(String freeWithdrawalsNumber)
	{
		this.freeWithdrawalsNumber = freeWithdrawalsNumber;
	}

	public String getFuseCouponNumber()
	{
		return fuseCouponNumber;
	}

	public void setFuseCouponNumber(String fuseCouponNumber)
	{
		this.fuseCouponNumber = fuseCouponNumber;
	}

	public String getRecommendCode()
	{
		return recommendCode;
	}

	public void setRecommendCode(String recommendCode)
	{
		this.recommendCode = recommendCode;
	}

	public String getRepairSignNumber()
	{
		return repairSignNumber;
	}

	public void setRepairSignNumber(String repairSignNumber)
	{
		this.repairSignNumber = repairSignNumber;
	}

	public String getWithdrawalsNumber()
	{
		return withdrawalsNumber;
	}

	public void setWithdrawalsNumber(String withdrawalsNumber)
	{
		this.withdrawalsNumber = withdrawalsNumber;
	}

	public String getSigns()
	{
		return signs;
	}

	public void setSigns(String signs)
	{
		this.signs = signs;
	}

	public String getLevelId()
	{
		return levelId;
	}

	public void setLevelId(String levelId)
	{
		this.levelId = levelId;
	}

	public String getIsChange()
	{
		return isChange;
	}

	public void setIsChange(String isChange)
	{
		this.isChange = isChange;
	}

	public String getIsRewardLevel()
	{
		return isRewardLevel;
	}

	public void setIsRewardLevel(String isRewardLevel)
	{
		this.isRewardLevel = isRewardLevel;
	}

	public String getUnionid()
	{
		return unionid;
	}

	public void setUnionid(String unionid)
	{
		this.unionid = unionid;
	}

	public String getIsReward()
	{
		return isReward;
	}

	public void setIsReward(String isReward)
	{
		this.isReward = isReward;
	}

	public String getIsCompany()
	{
		return isCompany;
	}

	public void setIsCompany(String isCompany)
	{
		this.isCompany = isCompany;
	}

	public String getAccountIcon()
	{
		return accountIcon;
	}

	public void setAccountIcon(String accountIcon)
	{
		this.accountIcon = accountIcon;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getIdCard()
	{
		return idCard;
	}

	public void setIdCard(String idCard)
	{
		this.idCard = idCard;
	}

	public String getAccountScore()
	{
		return accountScore;
	}

	public void setAccountScore(String accountScore)
	{
		this.accountScore = accountScore;
	}

	public String getAccountExp()
	{
		return accountExp;
	}

	public void setAccountExp(String accountExp)
	{
		this.accountExp = accountExp;
	}

	public String getAccountLevel()
	{
		return accountLevel;
	}

	public void setAccountLevel(String accountLevel)
	{
		this.accountLevel = accountLevel;
	}

	public String getAccountQQ()
	{
		return accountQQ;
	}

	public void setAccountQQ(String accountQQ)
	{
		this.accountQQ = accountQQ;
	}

	public String getAccountWX()
	{
		return accountWX;
	}

	public void setAccountWX(String accountWX)
	{
		this.accountWX = accountWX;
	}

	public String getAccountWB()
	{
		return accountWB;
	}

	public void setAccountWB(String accountWB)
	{
		this.accountWB = accountWB;
	}

	public String getAccountEmail()
	{
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail)
	{
		this.accountEmail = accountEmail;
	}

	public String getRegTime()
	{
		return regTime;
	}

	public void setRegTime(String regTime)
	{
		this.regTime = regTime;
	}

	public String getLoginTime()
	{
		return loginTime;
	}

	public void setLoginTime(String loginTime)
	{
		this.loginTime = loginTime;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getRecommendTelephone()
	{
		return recommendTelephone;
	}

	public void setRecommendTelephone(String recommendTelephone)
	{
		this.recommendTelephone = recommendTelephone;
	}

	public String getIsChangeName()
	{
		return isChangeName;
	}

	public void setIsChangeName(String isChangeName)
	{
		this.isChangeName = isChangeName;
	}

	public String getYzm()
	{
		return yzm;
	}

	public String getDealPassword()
	{
		return dealPassword;
	}

	public void setDealPassword(String dealPassword)
	{
		this.dealPassword = dealPassword;
	}

	public String getIsEmailValidate()
	{
		return isEmailValidate;
	}

	public void setIsEmailValidate(String isEmailValidate)
	{
		this.isEmailValidate = isEmailValidate;
	}

	public void setYzm(String yzm)
	{
		this.yzm = yzm;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public AccountInfo()
	{
		super();
	}

	public String getAccountSex()
	{
		return accountSex;
	}

	public void setAccountSex(String accountSex)
	{
		this.accountSex = accountSex;
	}

	public String getAccountContactType()
	{
		return accountContactType;
	}

	public void setAccountContactType(String accountContactType)
	{
		this.accountContactType = accountContactType;
	}

	public String getAccountContactName()
	{
		return accountContactName;
	}

	public void setAccountContactName(String accountContactName)
	{
		this.accountContactName = accountContactName;
	}

	public String getAccountContactPhone()
	{
		return accountContactPhone;
	}

	public void setAccountContactPhone(String accountContactPhone)
	{
		this.accountContactPhone = accountContactPhone;
	}

	public String getRegType()
	{
		return regType;
	}

	public void setRegType(String regType)
	{
		this.regType = regType;
	}

	public String getNewSubjectCount()
	{
		return newSubjectCount;
	}

	public void setNewSubjectCount(String newSubjectCount)
	{
		this.newSubjectCount = newSubjectCount;
	}

	public String getRiskResult()
	{
		return riskResult;
	}

	public void setRiskResult(String riskResult)
	{
		this.riskResult = riskResult;
	}

	public String getIsRisk()
	{
		return isRisk;
	}

	public void setIsRisk(String isRisk)
	{
		this.isRisk = isRisk;
	}

	@Override
	public String toString()
	{
		return "AccountInfo [accountId=" + accountId + ", accountName=" + accountName + ", isChangeName="
				+ isChangeName + ", password=" + password + ", dealPassword=" + dealPassword + ", telephone="
				+ telephone + ", realName=" + realName + ", idCard=" + idCard + ", accountSex=" + accountSex
				+ ", accountScore=" + accountScore + ", accountExp=" + accountExp + ", accountLevel=" + accountLevel
				+ ", accountContactType=" + accountContactType + ", accountContactName=" + accountContactName
				+ ", accountContactPhone=" + accountContactPhone + ", accountQQ=" + accountQQ + ", accountWX="
				+ accountWX + ", accountWB=" + accountWB + ", accountEmail=" + accountEmail + ", isEmailValidate="
				+ isEmailValidate + ", regTime=" + regTime + ", loginTime=" + loginTime + ", status=" + status
				+ ", recommendTelephone=" + recommendTelephone + ", regType=" + regType + ", newSubjectCount="
				+ newSubjectCount + ", riskResult=" + riskResult + ", isRisk=" + isRisk + ", yzm=" + yzm
				+ ", accountIcon=" + accountIcon + "]";
	}

	/**
	 * @param accountId
	 * @param accountName
	 * @param isChangeName
	 * @param password
	 * @param dealPassword
	 * @param telephone
	 * @param realName
	 * @param idCard
	 * @param accountSex
	 * @param accountScore
	 * @param accountExp
	 * @param accountLevel
	 * @param accountContactType
	 * @param accountContactName
	 * @param accountContactPhone
	 * @param accountQQ
	 * @param accountWX
	 * @param accountWB
	 * @param accountEmail
	 * @param isEmailValidate
	 * @param regTime
	 * @param loginTime
	 * @param status
	 * @param recommendTelephone
	 * @param regType
	 * @param newSubjectCount
	 * @param riskResult
	 * @param isRisk
	 * @param yzm
	 * @param accountIcon
	 */
	public AccountInfo(String accountId, String accountName, String isChangeName, String password, String dealPassword,
			String telephone, String realName, String idCard, String accountSex, String accountScore,
			String accountExp, String accountLevel, String accountContactType, String accountContactName,
			String accountContactPhone, String accountQQ, String accountWX, String accountWB, String accountEmail,
			String isEmailValidate, String regTime, String loginTime, String status, String recommendTelephone,
			String regType, String newSubjectCount, String riskResult, String isRisk, String yzm, String accountIcon)
	{
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.isChangeName = isChangeName;
		this.password = password;
		this.dealPassword = dealPassword;
		this.telephone = telephone;
		this.realName = realName;
		this.idCard = idCard;
		this.accountSex = accountSex;
		this.accountScore = accountScore;
		this.accountExp = accountExp;
		this.accountLevel = accountLevel;
		this.accountContactType = accountContactType;
		this.accountContactName = accountContactName;
		this.accountContactPhone = accountContactPhone;
		this.accountQQ = accountQQ;
		this.accountWX = accountWX;
		this.accountWB = accountWB;
		this.accountEmail = accountEmail;
		this.isEmailValidate = isEmailValidate;
		this.regTime = regTime;
		this.loginTime = loginTime;
		this.status = status;
		this.recommendTelephone = recommendTelephone;
		this.regType = regType;
		this.newSubjectCount = newSubjectCount;
		this.riskResult = riskResult;
		this.isRisk = isRisk;
		this.yzm = yzm;
		this.accountIcon = accountIcon;
	}

}
