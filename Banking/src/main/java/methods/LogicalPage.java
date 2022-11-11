package methods;

import java.util.List;
import database.DatabaseProcess;
import util.CustomException;

public class LogicalPage 
{
	DatabaseProcess process=new DatabaseProcess();
	TransactionDetails transaction=new TransactionDetails();
	public long getMillis()
	{
		long millis=System.currentTimeMillis();
		return millis;
	}
	public boolean checkUser(long id,String password) throws CustomException
	{
		String passwordForCheck=process.getParticularDetail(id,"User_Table","CUSTOMER_ID","Password");
			if(password.equals(passwordForCheck))
		{
			return true;
		}
		return false;
	}
	public String getRole(long id) throws CustomException
	{
		String role=process.getParticularDetail(id,"User_Table","CUSTOMER_ID","Role");
		return role;
	}
	public boolean checkStatus(long value,String field,String table) throws CustomException
	{
		String status=process.getStatus(value,field,table);
		if(status.equals("ACTIVE"))
		{
		   return true;
		}
	  return false;
	}
	public long getId(long value) throws CustomException
    {
    	long id=process.getId(value, "ACCOUNT_NUMBER","ACCOUNT_DETAIL");
    	return id;
    }
	public long getAccountBalance(long balance) throws CustomException
	{
		long balanceAmount=process.getAccountBalance(balance);
		int minimumBalance=3000;
		if(balanceAmount>minimumBalance)
		{
			return balanceAmount;
		}
		else
		{
			return 0;
		}
	}
	public long creditProcess(long balance,long creditAmount)
	{
		long currentBalance=balance+creditAmount;
		return currentBalance;
	}
	public long debitProcess(long balance,long debitAmount)
	{
		long currentBalance=balance-debitAmount;
		return currentBalance;
	}
	public boolean checkDebitAmount(long debit,long balance)
	{
		if(debit<balance)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean  isExistOrNot(long id,String searchingColumn,String table,String existingColumn,long accNum) throws CustomException
	{
		List<Object> result=process.getDetails(id, searchingColumn, table, existingColumn);
		boolean ans=result.contains(accNum);
		return ans;
	}
	/*public Map<Long,TransactionDetails> getTransactionDetails(long accNumber) throws SQLException
	{
		Map<Long,TransactionDetails> transactMap=process.getTransactionDetails(accNumber);
		return transactMap;
	}
	
	public Map<Long,List<TransactionDetails>> getLimitTransactionDetails(long accNumber) throws SQLException
	{
		Map<Long,List<TransactionDetails>> transactMap=process.getLimitTransactionDetails(accNumber);
		return transactMap;
	}
	
	public Map<Long,TransactionDetails> getLimitTransaction(long accNumber) throws SQLException
	{
		Map<Long,TransactionDetails> transactMap=process.getLimitTransaction(accNumber);
		return transactMap;
	}
	public Map<Long,AccountDetails> getInActiveAccounts(long customer_ID) throws SQLException
	{
		Map<Long,AccountDetails> accountDetailMap=new HashMap<>();
		accountDetailMap=process.getInActiveAccounts(customer_ID);
		return accountDetailMap;
	}
	public Map<Long,AccountDetails> getActiveAccounts(long customer_ID) throws SQLException
	{
		Map<Long,AccountDetails> accountDetailMap=new HashMap<>();
		accountDetailMap=process.getActiveAccounts(customer_ID);
		return accountDetailMap;
	}
	public void addUser() throws SQLException
	{
		process.addUserPassword();
	}*/
	
	
}
