package methods;

import java.sql.SQLException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import database.DatabaseProcess;
import util.CustomException;

public class StoragePage
{
	DatabaseProcess process=new DatabaseProcess();
	Map<Long,String> userMap=new HashMap<>();
	Map<Long,List<CustomerDetails>> customerInfoMap=new HashMap<>();
	Map<Long,List<AccountDetails>> accountInfoMap=new HashMap<>();
	
	
	/*public void setUserLogin(List<UserTableDetails> userTableList) throws SQLException
	{
		for(UserTableDetails user:userTableList)
		{
		  System.out.println("......");
		  userMap.put(user.getCustomerID(),user.getPassword());
		  System.out.println(userMap);
			
		}
		process.addUserPassword(userTableList);
		//process.createAdminTable();
		
	}*/
	public void create()
	{
		//process.createUserTable();
		//process.createCustomerTable();
		process.createAccountTable();
		process.createTransactionTable();
	}
	
	/*public void setUserDetails(List<CustomerDetails> customerDetails) throws SQLException
	{
		for(CustomerDetails info:customerDetails)
		{
			customerInfoMap.put(info.getCustomerID(), customerDetails);
		}
		process.addNewUserDetail(customerDetails);
	}*/
	public void setAccountDetails(List<AccountDetails> accountDetails) throws CustomException
	{
		for(AccountDetails info:accountDetails)
		{
			accountInfoMap.put(info.getCustomerID(), accountDetails);
		}
		process.addAccountDetails(accountDetails);
	}
	public void setTransactionDetails(List<TransactionDetails> transactionDetails ) throws CustomException
	{
		process.addTransactionDetails(transactionDetails);
	}
	public Map<Long,CustomerDetails> getUserDetails(long customer_ID) throws CustomException
	{
		Map<Long,CustomerDetails> userDetailMap=new HashMap<>();
		userDetailMap=process.getUserDetails(customer_ID);
		return userDetailMap;
	}
	public Map<Long,AccountDetails> getAccountDetails(long customer_ID) throws CustomException
	{
		Map<Long,AccountDetails> accountDetailMap=new HashMap<>();
		accountDetailMap=process.getAccountDetails(customer_ID);
		return accountDetailMap;
	}
	/*public AccountDetails getAccount(long customer_ID)
	{
		
	}*/
	public int getUpdate(long existValue,long updateValue,String existColumn) throws CustomException
	{
		int ans=process.getUpdateColumn(existValue, updateValue, "BALANCE", existColumn, "ACCOUNT_DETAIL");
		return ans;
	}
	public int getUpdatePassword(String update,long customerID) throws CustomException
	{
		int answer=process.getUpdatePassword(update, customerID);
		return answer;
	}
	public void getUpdateUserInfo(Map<String,Object> updateMap,long customerID) throws CustomException
	{
		process.getUpdateUser(updateMap,customerID, "User_Table");
	}
	public void getUpdateUser(Map<String,Object> updateMap,long customerID) throws CustomException
	{
		process.getUpdateUser(updateMap,customerID, "USER_DETAIL");
	}
	
	public void getUpdateAccount(Map<String,Object> updateMap,long accountNumber) throws CustomException
	{
		process.getUpdateAccount(updateMap, accountNumber);
		
	}
	public Map<Long,CustomerDetails> getUserDetailsForAdmin() throws CustomException 
	{
		Map<Long,CustomerDetails> userDetails=new HashMap<>();
		userDetails=process.getUserDetailsForAdmin();
		return userDetails;
	}
	public Map<Long,AccountDetails> getAllAccountDetails() throws CustomException
	{
		Map<Long,AccountDetails> accountDetailMap=new HashMap<>();
		accountDetailMap=process.getAllAccounts();
		return accountDetailMap;
	}
	/*public Map<Long,TransactionDetails> getTransactionDetails(long accNumber) throws CustomException
	{
		Map<Long,TransactionDetails> transactMap=process.getTransactionDetails(accNumber);
		return transactMap;
	}*/
	
	public Map<Long,List<TransactionDetails>> getLimitTransactionDetails(long accNumber) throws CustomException
	{
		Map<Long,List<TransactionDetails>> transactMap=process.getLimitTransactionDetails(accNumber);
		return transactMap;
	}
	
	/*public Map<Long,TransactionDetails> getLimitTransaction(long accNumber) throws SQLException
	{
		Map<Long,TransactionDetails> transactMap=process.getLimitTransaction(accNumber);
		return transactMap;
	}*/
	public Map<Long,AccountDetails> getInActiveAccounts(long customer_ID) throws CustomException
	{
		Map<Long,AccountDetails> accountDetailMap=new HashMap<>();
		accountDetailMap=process.getInActiveAccounts(customer_ID);
		return accountDetailMap;
	}
	public Map<Long,AccountDetails> getActiveAccounts(long customer_ID) throws CustomException
	{
		Map<Long,AccountDetails> accountDetailMap=new HashMap<>();
		accountDetailMap=process.getActiveAccounts(customer_ID);
		return accountDetailMap;
	}
/*	public void addUser(String role) throws SQLException
	{
		process.addUserPassword(role);
	}*/
	public void  addNewUserDetail(List<CustomerDetails> customerDetails) throws CustomException
	{
		process.addNewUserDetail(customerDetails);
		
	}
	public long addNewUser(List<CustomerDetails> CustomerDetails) throws  CustomException
	{
		long id=process.addNewUserInfo(CustomerDetails);
		return id;
	}
	public Map<Long,UserTableDetails> getUserInfo(long id) throws CustomException
	{
		Map<Long,UserTableDetails> userInfo=process.getUserInfo(id);
		return userInfo;
	}
	public Map<Long,CustomerDetails> getAllUserInfo() throws CustomException
	{
		Map<Long,CustomerDetails> userInfo=process.getAllUserInfo();
		return userInfo;
	}
}
