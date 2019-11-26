package com.xed.financing.wxgzh.model.runinfo;

public class RunInfoBean
{


	/**
	 * 时间 
	 */
	private String date;
	
	/**
	 * 累计交易(贷款)总额
	 */
	private String totaltransaction;
	
	/**
	 * 累计交易(借贷)笔数(个)
	 */
	private Integer accumulativeTransaction;
	
	/**
	 * 借贷余额
	 */
	private String loanBalance;
	
	/**
	 * 累计借款人数量(个)
	 */
	private Integer accumulativeBorrower;
	
	/**
	 * 累计出借人数量(个)
	 */
	private Integer accumulativeLenders;
	
	/**
	 * 借贷余额笔数(个)
	 */
	private Integer loanBalanceCount;
	
	/**
	 * 当前借款人数量(个)
	 */
	private Integer currentBorrowerCount;
	
	/**
	 * 当前出借人数量(个)
	 */
	private Integer currentLendersCount;
	
	/**
	 * 关联关系借款余额
	 */
	private Integer relatedLoanBalance;
	
	/**
	 * 最大单一借款人待还金额
	 */
	private String theProportionOne;
	
	/**
	 * 前十借款人待还金额
	 */
	private String theProportionTen;
	
	/**
	 * 借款总额
	 */
	private Integer loanBalances;
	
	/**
	 * 累计注册人数
	 */
	private String registrations;
	
	/**
	 * 累计接待笔数
	 */
	private Integer transactionCount;
	
	/**
	 * 累计收益
	 */
	private String allProfit;

	
	public RunInfoBean(String date, String totaltransaction, Integer accumulativeTransaction, String loanBalance,
			Integer accumulativeBorrower, Integer accumulativeLenders, Integer loanBalanceCount,
			Integer currentBorrowerCount, Integer currentLendersCount, Integer relatedLoanBalance,
			String theProportionOne, String theProportionTen, Integer loanBalances, String registrations,
			Integer transactionCount, String allProfit)
	{
		super();
		this.date = date;
		this.totaltransaction = totaltransaction;
		this.accumulativeTransaction = accumulativeTransaction;
		this.loanBalance = loanBalance;
		this.accumulativeBorrower = accumulativeBorrower;
		this.accumulativeLenders = accumulativeLenders;
		this.loanBalanceCount = loanBalanceCount;
		this.currentBorrowerCount = currentBorrowerCount;
		this.currentLendersCount = currentLendersCount;
		this.relatedLoanBalance = relatedLoanBalance;
		this.theProportionOne = theProportionOne;
		this.theProportionTen = theProportionTen;
		this.loanBalances = loanBalances;
		this.registrations = registrations;
		this.transactionCount = transactionCount;
		this.allProfit = allProfit;
	}

	
	public Integer getTransactionCount()
	{
		return transactionCount;
	}


	public void setTransactionCount(Integer transactionCount)
	{
		this.transactionCount = transactionCount;
	}


	public String getAllProfit()
	{
		return allProfit;
	}


	public void setAllProfit(String allProfit)
	{
		this.allProfit = allProfit;
	}


	public String getRegistrations()
	{
		return registrations;
	}


	public void setRegistrations(String registrations)
	{
		this.registrations = registrations;
	}


	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getTotaltransaction()
	{
		return totaltransaction;
	}

	public void setTotaltransaction(String totaltransaction)
	{
		this.totaltransaction = totaltransaction;
	}

	public Integer getAccumulativeTransaction()
	{
		return accumulativeTransaction;
	}

	public void setAccumulativeTransaction(Integer accumulativeTransaction)
	{
		this.accumulativeTransaction = accumulativeTransaction;
	}

	public String getLoanBalance()
	{
		return loanBalance;
	}

	public void setLoanBalance(String loanBalance)
	{
		this.loanBalance = loanBalance;
	}

	public Integer getAccumulativeBorrower()
	{
		return accumulativeBorrower;
	}

	public void setAccumulativeBorrower(Integer accumulativeBorrower)
	{
		this.accumulativeBorrower = accumulativeBorrower;
	}

	public Integer getAccumulativeLenders()
	{
		return accumulativeLenders;
	}

	public void setAccumulativeLenders(Integer accumulativeLenders)
	{
		this.accumulativeLenders = accumulativeLenders;
	}

	public Integer getLoanBalanceCount()
	{
		return loanBalanceCount;
	}

	public void setLoanBalanceCount(Integer loanBalanceCount)
	{
		this.loanBalanceCount = loanBalanceCount;
	}

	public Integer getCurrentBorrowerCount()
	{
		return currentBorrowerCount;
	}

	public void setCurrentBorrowerCount(Integer currentBorrowerCount)
	{
		this.currentBorrowerCount = currentBorrowerCount;
	}

	public Integer getCurrentLendersCount()
	{
		return currentLendersCount;
	}

	public void setCurrentLendersCount(Integer currentLendersCount)
	{
		this.currentLendersCount = currentLendersCount;
	}

	public Integer getRelatedLoanBalance()
	{
		return relatedLoanBalance;
	}

	public void setRelatedLoanBalance(Integer relatedLoanBalance)
	{
		this.relatedLoanBalance = relatedLoanBalance;
	}

	public String getTheProportionOne()
	{
		return theProportionOne;
	}

	public void setTheProportionOne(String theProportionOne)
	{
		this.theProportionOne = theProportionOne;
	}

	public String getTheProportionTen()
	{
		return theProportionTen;
	}

	public void setTheProportionTen(String theProportionTen)
	{
		this.theProportionTen = theProportionTen;
	}

	public Integer getLoanBalances()
	{
		return loanBalances;
	}

	public void setLoanBalances(Integer loanBalances)
	{
		this.loanBalances = loanBalances;
	}

	@Override
	public String toString()
	{
		return "RunInfoBean [date=" + date + ", totaltransaction=" + totaltransaction + ", accumulativeTransaction="
				+ accumulativeTransaction + ", loanBalance=" + loanBalance + ", accumulativeBorrower="
				+ accumulativeBorrower + ", accumulativeLenders=" + accumulativeLenders + ", loanBalanceCount="
				+ loanBalanceCount + ", currentBorrowerCount=" + currentBorrowerCount + ", currentLendersCount="
				+ currentLendersCount + ", relatedLoanBalance=" + relatedLoanBalance + ", theProportionOne="
				+ theProportionOne + ", theProportionTen=" + theProportionTen + "]";
	}


	
}
