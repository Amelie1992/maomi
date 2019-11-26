package com.xed.financing.wxgzh.model.subjectdispersed;

/**
 * 分散标
 * @className:com.xed.financing.wxgzh.model.subjectdispersed.DispersedBean
 * @description:
 * @version:v1.0.0 
 * @date:2017年10月12日 上午10:11:38
 * @author:Peng Gang
 */
public class SubjectDispersedBean
{
	/**
	 * 标的ID
	 */
	private String subjectId;

	/**
	 * 标的编号
	 */
	private String subjectCode;
	/**
	 * 标的名称
	 */
	private String subjectName;

	/**
	 * 标的总金额
	 */
	private String subjectMoney;

	/**
	 * 标的剩余金额
	 */
	private String subjectOverplusMoney;
	
	/**
	 * 起投金额(用户投资金额必须为起投金额的倍数)
	 */
	private String subjectStartingMoney;

	/**
	 * 标的类型(0:新手专享标 1:普通标 2:实物标 3:预发布标 4：高额爆款标)
	 */
	private String subjectType;
	
	/**
	 * 标的期限(月:30天 天:1天)
	 */
	private String subjectTerm;

	/**
	 * 标的期数
	 */
	private Integer subjectPeriods;

	/**
	 * 标的天数
	 */
	private String subjectDays;

	/**
	 * 标的利率
	 */
	private String subjectRate;

	/**
	 * 借款人ID
	 */
	private String userId;

	/**
	 * 还款方式(0:等额本息 1:先息后本 2:到期还本还息)
	 */
	private String repeatType;

	/**
	 * 用途(0:装修 1:教育 2:购房 3:购车 4:生活开销 5:资金周转 6:旅游 7:娱乐 8:医疗 9:其他)
	 */
	private String usedPurpose;

	/**
	 * 描述
	 */
	private String usedRemark;

	/**
	 * 是否可以组团(0:否 1:是)
	 */
	private String isTeam;

	/**
	 * 发布时间
	 */
	private String startTime;

	/**
	 * 生效时间
	 */
	private String effectTime;

	/**
	 * 结束时间
	 */
	private String endTime;

	/**
	 * 满标时间
	 */
	private String fullTime;

	/**
	 * 标的状态(0:筹标中 1:已满标 2:满标复审 3:还款中 4:流标)
	 */
	private String subjectStatus;
	
	/**
	 * 次日发布标后续类型(0:新手专享标 1:稳健普通标 2:兑换实物标 3:次日预发布标 4:高额爆款标)
	 */
	private String nextType;
	
	/**
	 * 专属类型(0:全部 1:PC 2:微信 3:安卓 4:IOS)
	 */
	private String ownType;
	
	/**
	 * 是否限制优惠券(0:无限制 1:限制所有 2:部分限制)
	 */
	private String isLimit;

	/**
	 * 投标ID
	 */
	private String dispersedId;
	
	/**
	 * 用户ID
	 */
	private String accountId;
	
	/**
	 * 投资金额
	 */
	private String money;
	
	/**
	 * 投资时间
	 */
	private String inTime;
	
	/**
	 * 结束时间
	 */
	private String outTime;
	
	/**
	 * 是否生效(0:是 1:否)
	 */
	private String isEffect;
	
	
	/**
	 * 分页查询时从该条起查询
	 */
	private Integer fromNum = 0;

	/**
	 * 分页查询时到该条为止
	 */
	private Integer toNum = 0;

	/**
	 * 每页条数
	 */
	private Integer pagenum = 10;

	/**
	 * rowNum
	 */
	private Integer rn;
	
	/**
	 * 各类型标的数量
	 */
	public String typeCount;
	
	/**
	 * 各类型标的数量的百分比
	 */
	public String typeCountPercentage;
	
	
	/**
	 * 各类型标的金额
	 */
	public String typeMoney;

	/**
	 * 月份差
	 */
	public int mCount;
	
	//借款人信息
	/**
	 * 是否有房(0:无 1:有)
	 */
	private String userName;
	
	/**
	 * 用户性别(0:男 1:女)
	 */
	private String userSex;
	
	/**
	 * 房屋类型(0:有房有贷款 1:有房无贷款 2:非所属市住房)
	 */
	private String houseType;
	
	/**
	 * 车类型(0:无车贷 1:有车贷)
	 */
	private String carType;
	
	/**
	 * 是否有其他贷款0:无 1:有)
	 */
	private String isLoan;
	
	/**
	 * 其他贷款金额 
	 */
	private String loan_money;
	
	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 区
	 */
	private String classify;
	/**
	 * 描述
	 */
	private String remark;
	
	/**
	 * 车品牌
	 */
	private String carBrand;
	
	/**
	 * 车颜色
	 */
	private String carColor;
	
	/**
	 * 车牌照
	 */
	private String carTag;
	
	/**
	 * 车价格
	 */
	private String carMoney;
	
	/**
	 * 抵押与估价
	 */
	private String carExpectMoney;
	
	/**
	 * 最大里程数
	 */
	private String carMileage;
	
	/**
	 * 是否大修过
	 */
	private String isOverhaul;
	
	/**
	 * 是否二手车(0:否 1:是)
	 */
	private String isSecond;
	
	/**
	 * 车辆年限
	 */
	private String carLimit;

	/**
	 * 借款人年龄
	 */
	private String userAge;
	
	/**
	 * 借款人身份证
	 */
	private String idCard;
	
	/**
	 * 借款人类型(0:个人 1:公司)
	 */
	private String borrowerType;
	
	/**
	 * 手机号码
	 */
	private String telephone;
	
	/**
	 * 用户名称
	 */
	private String accountName;
	
	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserSex()
	{
		return userSex;
	}

	public void setUserSex(String userSex)
	{
		this.userSex = userSex;
	}

	public String getHouseType()
	{
		return houseType;
	}

	public void setHouseType(String houseType)
	{
		this.houseType = houseType;
	}

	public String getCarType()
	{
		return carType;
	}

	public void setCarType(String carType)
	{
		this.carType = carType;
	}

	public String getIsLoan()
	{
		return isLoan;
	}

	public void setIsLoan(String isLoan)
	{
		this.isLoan = isLoan;
	}

	public String getLoan_money()
	{
		return loan_money;
	}

	public void setLoan_money(String loan_money)
	{
		this.loan_money = loan_money;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getClassify()
	{
		return classify;
	}

	public void setClassify(String classify)
	{
		this.classify = classify;
	}

	public String getRemark()
	{
		return remark;
	}

	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public String getCarBrand()
	{
		return carBrand;
	}

	public void setCarBrand(String carBrand)
	{
		this.carBrand = carBrand;
	}

	public String getCarColor()
	{
		return carColor;
	}

	public void setCarColor(String carColor)
	{
		this.carColor = carColor;
	}

	public String getCarTag()
	{
		return carTag;
	}

	public void setCarTag(String carTag)
	{
		this.carTag = carTag;
	}

	public String getCarMoney()
	{
		return carMoney;
	}

	public void setCarMoney(String carMoney)
	{
		this.carMoney = carMoney;
	}

	public String getCarExpectMoney()
	{
		return carExpectMoney;
	}

	public void setCarExpectMoney(String carExpectMoney)
	{
		this.carExpectMoney = carExpectMoney;
	}

	public String getCarMileage()
	{
		return carMileage;
	}

	public void setCarMileage(String carMileage)
	{
		this.carMileage = carMileage;
	}

	public String getIsOverhaul()
	{
		return isOverhaul;
	}

	public void setIsOverhaul(String isOverhaul)
	{
		this.isOverhaul = isOverhaul;
	}

	public String getIsSecond()
	{
		return isSecond;
	}

	public void setIsSecond(String isSecond)
	{
		this.isSecond = isSecond;
	}

	public String getCarLimit()
	{
		return carLimit;
	}

	public void setCarLimit(String carLimit)
	{
		this.carLimit = carLimit;
	}

	public String getUserAge()
	{
		return userAge;
	}

	public void setUserAge(String userAge)
	{
		this.userAge = userAge;
	}

	public String getIdCard()
	{
		return idCard;
	}

	public void setIdCard(String idCard)
	{
		this.idCard = idCard;
	}

	public String getBorrowerType()
	{
		return borrowerType;
	}

	public void setBorrowerType(String borrowerType)
	{
		this.borrowerType = borrowerType;
	}

	public int getmCount()
	{
		return mCount;
	}

	public void setmCount(int mCount)
	{
		this.mCount = mCount;
	}

	public String getTypeCount()
	{
		return typeCount;
	}

	public void setTypeCount(String typeCount)
	{
		this.typeCount = typeCount;
	}

	public String getTypeCountPercentage()
	{
		return typeCountPercentage;
	}

	public void setTypeCountPercentage(String typeCountPercentage)
	{
		this.typeCountPercentage = typeCountPercentage;
	}

	public String getTypeMoney()
	{
		return typeMoney;
	}

	public void setTypeMoney(String typeMoney)
	{
		this.typeMoney = typeMoney;
	}

	public String getSubjectId()
	{
		return subjectId;
	}

	public void setSubjectId(String subjectId)
	{
		this.subjectId = subjectId;
	}

	public String getSubjectCode()
	{
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode)
	{
		this.subjectCode = subjectCode;
	}

	public String getSubjectName()
	{
		return subjectName;
	}

	public void setSubjectName(String subjectName)
	{
		this.subjectName = subjectName;
	}

	public String getSubjectMoney()
	{
		return subjectMoney;
	}

	public void setSubjectMoney(String subjectMoney)
	{
		this.subjectMoney = subjectMoney;
	}

	public String getSubjectOverplusMoney()
	{
		return subjectOverplusMoney;
	}

	public void setSubjectOverplusMoney(String subjectOverplusMoney)
	{
		this.subjectOverplusMoney = subjectOverplusMoney;
	}

	public String getSubjectStartingMoney()
	{
		return subjectStartingMoney;
	}

	public void setSubjectStartingMoney(String subjectStartingMoney)
	{
		this.subjectStartingMoney = subjectStartingMoney;
	}

	public String getSubjectType()
	{
		return subjectType;
	}

	public void setSubjectType(String subjectType)
	{
		this.subjectType = subjectType;
	}

	public String getSubjectTerm()
	{
		return subjectTerm;
	}

	public void setSubjectTerm(String subjectTerm)
	{
		this.subjectTerm = subjectTerm;
	}

	public Integer getSubjectPeriods()
	{
		return subjectPeriods;
	}

	public void setSubjectPeriods(Integer subjectPeriods)
	{
		this.subjectPeriods = subjectPeriods;
	}

	public String getSubjectDays()
	{
		return subjectDays;
	}

	public void setSubjectDays(String subjectDays)
	{
		this.subjectDays = subjectDays;
	}

	public String getSubjectRate()
	{
		return subjectRate;
	}

	public void setSubjectRate(String subjectRate)
	{
		this.subjectRate = subjectRate;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getRepeatType()
	{
		return repeatType;
	}

	public void setRepeatType(String repeatType)
	{
		this.repeatType = repeatType;
	}

	public String getUsedPurpose()
	{
		return usedPurpose;
	}

	public void setUsedPurpose(String usedPurpose)
	{
		this.usedPurpose = usedPurpose;
	}

	public String getUsedRemark()
	{
		return usedRemark;
	}

	public void setUsedRemark(String usedRemark)
	{
		this.usedRemark = usedRemark;
	}

	public String getIsTeam()
	{
		return isTeam;
	}

	public void setIsTeam(String isTeam)
	{
		this.isTeam = isTeam;
	}

	public String getStartTime()
	{
		return startTime;
	}

	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}

	public String getEffectTime()
	{
		return effectTime;
	}

	public void setEffectTime(String effectTime)
	{
		this.effectTime = effectTime;
	}

	public String getEndTime()
	{
		return endTime;
	}

	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}

	public String getFullTime()
	{
		return fullTime;
	}

	public void setFullTime(String fullTime)
	{
		this.fullTime = fullTime;
	}

	public String getSubjectStatus()
	{
		return subjectStatus;
	}

	public void setSubjectStatus(String subjectStatus)
	{
		this.subjectStatus = subjectStatus;
	}

	public String getNextType()
	{
		return nextType;
	}

	public void setNextType(String nextType)
	{
		this.nextType = nextType;
	}

	public String getOwnType()
	{
		return ownType;
	}

	public void setOwnType(String ownType)
	{
		this.ownType = ownType;
	}

	public String getIsLimit()
	{
		return isLimit;
	}

	public void setIsLimit(String isLimit)
	{
		this.isLimit = isLimit;
	}

	public String getDispersedId()
	{
		return dispersedId;
	}

	public void setDispersedId(String dispersedId)
	{
		this.dispersedId = dispersedId;
	}

	public String getAccountId()
	{
		return accountId;
	}

	public void setAccountId(String accountId)
	{
		this.accountId = accountId;
	}

	public String getMoney()
	{
		return money;
	}

	public void setMoney(String money)
	{
		this.money = money;
	}

	public String getInTime()
	{
		return inTime;
	}

	public void setInTime(String inTime)
	{
		this.inTime = inTime;
	}

	public String getOutTime()
	{
		return outTime;
	}

	public void setOutTime(String outTime)
	{
		this.outTime = outTime;
	}

	public String getIsEffect()
	{
		return isEffect;
	}

	public void setIsEffect(String isEffect)
	{
		this.isEffect = isEffect;
	}

	public Integer getFromNum()
	{
		return fromNum;
	}

	public void setFromNum(Integer fromNum)
	{
		this.fromNum = fromNum;
	}

	public Integer getToNum()
	{
		return toNum;
	}

	public void setToNum(Integer toNum)
	{
		this.toNum = toNum;
	}

	public Integer getPagenum()
	{
		return pagenum;
	}

	public void setPagenum(Integer pagenum)
	{
		this.pagenum = pagenum;
	}

	public Integer getRn()
	{
		return rn;
	}

	public void setRn(Integer rn)
	{
		this.rn = rn;
	}
	
	
}
