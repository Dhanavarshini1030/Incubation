package methods;

public class TransactionDetails 
{
	private long time;
	private long transactionID;
	private long accountNumber;
	private long customerID;
	private String creditDebit;
	private long processingAmount;
	private long currentBalance;
	private long transactionAccount;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setTime(long time)
	{
		this.time=time;
	}
	public void setTransactionID(long transactionID)
	{
		this.transactionID=transactionID;
	}
	public void setAccountNumber(long accountNumber)
	{
		this.accountNumber=accountNumber;
	}
	public void setCreditDebit(String creditDebit)
	{
		this.creditDebit=creditDebit;
	}
	public void setCustomerID(long customerID)
	{
		this.customerID=customerID;
	}	
	public void setCurrentBalance(long balance)
	{
		this.currentBalance=balance;
	}	
	
	public void setProcessingAmount(long processingAmount)
	{
		this.processingAmount=processingAmount;
	}
	

	public void setTransactionAccount(long transactionAccount)
	{
		this.transactionAccount=transactionAccount;
	}
	public long getTime()
	{
		return time;
	}
	public long getAccountNumber()
	{
		return accountNumber;
	}
	public String getCreditDebit()
	{
		return creditDebit;
	}
	public long getCustomerID()
	{
		return customerID;
	}
	public long getTransactionAccount()
	{
		return transactionAccount;
	}
	public long getProcessingAmount()
	{
		return processingAmount;
	}
	
	public long getTransactionID()
	{
		return transactionID;
	}
	public long getCurrentBalance()
	{
		return currentBalance;
	}
	
	public String toString()
	{
		return "ACCOUNT NUMBER: "+this.accountNumber+" TIME: "+this.time+" TRANSACTION_ID: "+this.transactionID+
				" CUSTOMER ID: "+this.customerID+"CREDIT/DEBIT: "+this.creditDebit+
				" PROCESSING AMOUNT: "+this.processingAmount+" CURRENT_BALANCE: "+this.currentBalance+" TRANSACTION_ACCOUNT: "+this.transactionAccount;
	}
}
