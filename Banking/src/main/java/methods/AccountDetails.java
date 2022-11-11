package methods;

public class AccountDetails 
{
	
	private long customer_ID;
	private long accountNumber;
	private String ifsc;
	private double balance;
	private String accountType;
	private String branch;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setCustomerID(long id)
	{
		this.customer_ID=id;
	}
	public void setAccountNumber(long accountNumber)
	{
		this.accountNumber=accountNumber;
	}
	public void setIFSC(String ifsc)
	{
		this.ifsc=ifsc;
	}
	public void setBalance(double balance)
	{
		this.balance=balance;
	}
	public void setAccountType(String accountType)
	{
		this.accountType=accountType;
	}
	public void setBranch(String branch)
	{
		this.branch=branch;
	}
	public long getCustomerID()
	{
		return customer_ID;
	}
	public long getAccountNumber()
	{
		return accountNumber;
	}
	public String getIFSC()
	{
		return ifsc;
	}
	public double getBalance()
	{
		return balance;
	}
	public String getAccountType()
	{
		return accountType;
	}
	public String getBranch()
	{
		return branch;
	}
	public String toString()
	{
		return "ACCOUNT_NUMBER: "+this.accountNumber+" CUSTOMER_ID: "+this.customer_ID+" IFSC: "+this.ifsc+
				" ACCOUNT_TYPE: "+this.accountType+" BALANCE: "+this.balance+" BRANCH: "+this.branch
				+" STATUS: "+this.status;
	}
}
