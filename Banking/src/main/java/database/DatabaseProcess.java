package database;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import methods.AccountDetails;
import methods.CustomerDetails;
import methods.TransactionDetails;
import methods.UserTableDetails;
import util.CustomException;

public class DatabaseProcess
{
	public void createUserTable()
	{
		String query="create table User_Table(CUSTOMER_ID integer(5) NOT NULL AUTO_INCREMENT,Password varchar(25) NOT NULL,NAME varchar(30) NOT NULL,"
				+ "EMAIL varchar(50) NOT NULL,MOBILE_NUMBER bigint(10) NOT NULL,Role varchar(10) NOT NULL,PRIMARY KEY (CUSTOMER_ID))";
		getExecute(query);
	}
	public void createAdminTable()
	{
		String query="create table Admin_Table(ADMIN_ID integer(5) NOT NULL AUTO_INCREMENT,Password varchar(20) NOT NULL,STATUS varchar(10) NOT NULL,PRIMARY KEY (ADMIN_ID))";
		getExecute(query);
	}
	
	public void createCustomerTable()
	{
		String table="create table USER_DETAIL"+"(CUSTOMER_ID INTEGER(5) NOT NULL ,AADHAR_NUMBER bigint(12) NOT NULL UNIQUE ,"
				+ "PAN varchar(15) NOT NULL UNIQUE,"
				+ "ADDRESS varchar(250) NOT NULL,DOB varchar(25) NOT NULL,"
		           +"PRIMARY KEY(CUSTOMER_ID),FOREIGN KEY(CUSTOMER_ID) REFERENCES User_Table(CUSTOMER_ID))";
		getExecute(table);
	}
	public void createAccountTable()
	{
		String table="create table ACCOUNT_DETAIL"+"(CUSTOMER_ID integer(5) NOT NULL,"
				+"ACCOUNT_NUMBER bigint(20) NOT NULL,ACCOUNT_TYPE varchar(50) NOT NULL,BALANCE bigint(10) NOT NULL," 
				+"BRANCH varchar(50) NOT NULL,IFSC varchar(15) NOT NULL,STATUS varchar(10),"
				+"PRIMARY KEY(ACCOUNT_NUMBER),FOREIGN KEY(CUSTOMER_ID) REFERENCES USER_DETAIL(CUSTOMER_ID))";
		getExecute(table);		
	}
	public void createTransactionTable()
	{
		String table="create table TRANSACTION_DETAIL(TIME bigint(20) NOT NULL,TRANSACTION_ID integer(7) NOT NULL AUTO_INCREMENT,"
				+ "ACCOUNT_NUMBER bigint(20) NOT NULL,CUSTOMER_ID integer(5) NOT NULL,DEBIT_CREDIT varchar(10) NOT NULL,"
				+ "PROCESSING_AMOUNT bigint(10) NOT NULL,CURRENT_BALANCE bigint(10) NOT NULL,"
				+ "TRANSACTION_ACCOUNT bigint(15) NOT NULL,PRIMARY KEY(TRANSACTION_ID),"
				+ "FOREIGN KEY(ACCOUNT_NUMBER) REFERENCES  ACCOUNT_DETAIL(ACCOUNT_NUMBER))";
		getExecute(table);
	}
	
	/*public void addUserPassword(List<UserTableDetails> user) throws CustomException	//mainRunner
	{
		String query="insert into User_Table(Password,NAME,EMAIL,MOBILE_NUMBER,STATUS) values(?,?,?,?,?)";
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			for( UserTableDetails link:user)
			{
			 stmnt.setString(1,link.getPassword());
			 stmnt.setString(2,link.getCustomerName());
			 stmnt.setString(3,link.getEmail());
			 stmnt.setLong(4,link.getMobileNumber());
			 stmnt.setString(5,link.getStatus());
			 stmnt.execute();
			 }
		} catch (SQLException e)
		{
			throw new CustomException("KINDLY VERIFY YOUR SQL");
		
		}
	}*/
	
		
	public void addNewUserDetail(List<CustomerDetails> customerDetails) throws CustomException
	{
		String query="insert into USER_DETAIL(CUSTOMER_ID,AADHAR_NUMBER,PAN,ADDRESS,DOB) values(?,?,?,?,?)";
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			for( CustomerDetails link:customerDetails)
			{
			 stmnt.setLong(1,link.getCustomerID());
			 stmnt.setLong(2,link.getAadharNumber());
			 stmnt.setString(3,link.getPAN_Number());
			 stmnt.setString(4,link.getAddress());
			 stmnt.setString(5,link.getDOB());
			 stmnt.execute();
			 }
		} catch (SQLException e) 
		{
			 throw new CustomException("SQL ERROR",e); 
		}          
	}
	public long addNewUserInfo(List<CustomerDetails> customerDetails) throws CustomException
	{
		String query="insert into User_Table(Password,NAME,EMAIL,MOBILE_NUMBER,Role,STATUS) values(?,?,?,?,?,?)";
		long id=0;
		
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);)
		{
			for( CustomerDetails link:customerDetails)
			{
			 stmnt.setString(1,link.getPassword());
			 stmnt.setString(2,link.getCustomerName());
			 stmnt.setString(3,link.getEmail());
			 stmnt.setLong(4,link.getMobileNumber());
			 stmnt.setString(5,link.getRole());
			 stmnt.setString(6,link.getStatus());
			 stmnt.execute();
			 }
			//CustomerDetails customer=new CustomerDetails();
			try(ResultSet rs=stmnt.getGeneratedKeys();)
			{
				while(rs.next())
				{	
					id=rs.getLong(1);
				 	for(CustomerDetails link:customerDetails)
				 	{
				 		link.setCustomerID(rs.getLong(1));
				 	}
					addNewUserDetail(customerDetails);
				}
			 }
		} catch (SQLException e) 
		{
			 throw new CustomException("SQL ERROR",e);
		}
		return id;
	}
	public void addAccountDetails(List<AccountDetails> accountDetails) throws CustomException
	{
		String query="insert into ACCOUNT_DETAIL(CUSTOMER_ID ,ACCOUNT_NUMBER ,ACCOUNT_TYPE,BALANCE,BRANCH,IFSC,STATUS)"
				+ "values(?,?,?,?,?,?,?)";
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			for( AccountDetails link:accountDetails)
			{
			 stmnt.setLong(1,link.getCustomerID());
			 stmnt.setLong(2,link.getAccountNumber());
			 stmnt.setString(3,link.getAccountType());
			 stmnt.setDouble(4,link.getBalance());
			 stmnt.setString(5,link.getBranch());
			 stmnt.setString(6,link.getIFSC());
			 stmnt.setString(7, link.getStatus());
			 stmnt.execute();
			 }
		} catch (SQLException e) {
			 throw new CustomException("SQL ERROR",e);
		}          
	}
	
	public void addTransactionDetails(List<TransactionDetails> transaction) throws CustomException
	{
		String query="insert into TRANSACTION_DETAIL(TIME,ACCOUNT_NUMBER,CUSTOMER_ID,DEBIT_CREDIT,PROCESSING_AMOUNT,CURRENT_BALANCE,TRANSACTION_ACCOUNT)"
				+ "values(?,?,?,?,?,?,?)";
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			for( TransactionDetails link:transaction)
			{
			 stmnt.setLong(1,link.getTime());
			 stmnt.setLong(2,link.getAccountNumber());
			 stmnt.setLong(3,link.getCustomerID());
			 stmnt.setString(4,link.getCreditDebit());
			 stmnt.setLong(5,link.getProcessingAmount());
			 stmnt.setDouble(6,link.getCurrentBalance());
			 stmnt.setLong(7,link.getTransactionAccount());
			 //stmnt.setString(8,link.getStatus());
			 stmnt.execute();
			 }
		} catch (SQLException e) {
			throw new CustomException("SQL ERROR",e);
		}          
	}
	
	/*public Map<Long,TransactionDetails> getTransactionDetails(long accNumber) throws CustomException
	{
		String query="select * from TRANSACTION_DETAIL where ACCOUNT_NUMBER = ?";
		Map<Long,TransactionDetails> transactDetailMap=new HashMap<>();
		
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setLong(1, accNumber);
			try(ResultSet result=stmnt.executeQuery();)
			{
				
			while(result.next())
			 {
				TransactionDetails transaction = getTransact(result);
				transactDetailMap.put(transaction.getAccountNumber(), transaction);
			 }
			}
		} catch (SQLException e) {
			throw new CustomException("SQL ERROR",e);
		}
		return transactDetailMap;
	}*/
	
	public Map<Long,List<TransactionDetails>> getLimitTransactionDetails(long accNumber) throws CustomException
	{
		String query="select * from TRANSACTION_DETAIL where ACCOUNT_NUMBER = ?";
		Map<Long,List<TransactionDetails>> transactDetailMap=new HashMap<>();
		List<TransactionDetails> transactList=new ArrayList<>();
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setLong(1, accNumber);
			try(ResultSet result=stmnt.executeQuery();)
			{
			while(result.next())
			 {
				TransactionDetails transaction = getTransact(result);
				transactList.add(transaction);
				transactDetailMap.put(transaction.getAccountNumber(), transactList);
			 }
			}
		} catch (SQLException e) {
			throw new CustomException("SQL ERROR",e);
		}
		return transactDetailMap;
	}
	
	/*public Map<Long,TransactionDetails> getLimitTransaction(long accNumber) throws SQLException
	{
		String query="select * from TRANSACTION_DETAIL where ACCOUNT_NUMBER = ? limit 5";
		Map<Long,TransactionDetails> transactDetail=new HashMap<>();
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setLong(1, accNumber);
			try(ResultSet result=stmnt.executeQuery();)
			{
				TransactionDetails transaction=new TransactionDetails() ;
			while(result.next())
			 {
				transaction = getTransact(result);
				
			 }
			transactDetail.put(transaction.getAccountNumber(), transaction);
			}
		}
		return transactDetail;
	}
*/

	private TransactionDetails getTransact(ResultSet result) throws CustomException
	{
		TransactionDetails transaction=new TransactionDetails();
		
		try
		{
		transaction.setTime(result.getLong("TIME"));
		transaction.setTransactionID(result.getLong("TRANSACTION_ID"));
		transaction.setAccountNumber(result.getLong("ACCOUNT_NUMBER"));
		transaction.setCustomerID(result.getLong("CUSTOMER_ID"));
		transaction.setCreditDebit(result.getString("DEBIT_CREDIT"));
		transaction.setProcessingAmount(result.getLong("PROCESSING_AMOUNT"));
		transaction.setCurrentBalance(result.getLong("CURRENT_BALANCE"));
		transaction.setTransactionAccount(result.getLong("TRANSACTION_ACCOUNT"));
		//transaction.setStatus(result.getString("STATUS"));
		}catch(SQLException e)
		{
			throw new CustomException("SQL ERROR",e);
		}
		
		return transaction;
	}
	
	public long getAccountBalance(long accNumber) throws CustomException
	{
		String query="select BALANCE from ACCOUNT_DETAIL where ACCOUNT_NUMBER= "+accNumber+"";
		long balance = 0;
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);
				ResultSet result=stmnt.executeQuery();)
		{
				while(result.next())
				{
					balance=result.getLong("BALANCE");
				}
		}catch(SQLException e)
		{
			throw new CustomException("SQL ERROR",e);
		}
		return balance;
	}
	public Map<Long,CustomerDetails> getAllUserInfo() throws CustomException
	{
		String query="select * from User_Table INNER JOIN USER_DETAIL ON User_Table.CUSTOMER_ID=USER_DETAIL.CUSTOMER_ID";
		Map<Long,CustomerDetails> userDetailMap=new HashMap<>();
		
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			try(ResultSet result=stmnt.executeQuery();)
			{
			while(result.next())
			 {
				CustomerDetails users=new CustomerDetails();
				users.setCustomerID(result.getLong("CUSTOMER_ID"));
				users.setCustomerName(result.getString("NAME"));
				users.setEmail(result.getString("EMAIL"));
				users.setMobileNumber(result.getLong("MOBILE_NUMBER"));
				users.setAadharNumber(result.getLong("AADHAR_NUMBER"));
				users.setAddress(result.getString("ADDRESS"));
				users.setDOB(result.getString("DOB"));
				users.setPAN_Number(result.getString("PAN"));
			
				userDetailMap.put(result.getLong("CUSTOMER_ID"), users);
			 }
			}
		}catch(SQLException e)
		{
			throw new CustomException("SQL ERROR",e);
		}
		return userDetailMap;
	}
	public Map<Long,UserTableDetails> getUserInfo(long id) throws CustomException
	{
		String query="select * from User_Table where CUSTOMER_ID ="+id+"";
		Map<Long,UserTableDetails> userDetailMap=new HashMap<>();
		
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			try(ResultSet result=stmnt.executeQuery();)
			{
			while(result.next())
			 {
				UserTableDetails users=new UserTableDetails();
				users.setCustomerID(result.getLong("CUSTOMER_ID"));
				users.setCustomerName(result.getString("NAME"));
				users.setEmail(result.getString("EMAIL"));
				users.setMobileNumber(result.getLong("MOBILE_NUMBER"));
				
				userDetailMap.put(result.getLong("CUSTOMER_ID"), users);
			 }
			}
		}catch(SQLException e)
		{
			throw new CustomException("SQL ERROR",e);
		}
		return userDetailMap;
	}
	
	
	public Map<Long,CustomerDetails> getUserDetails(long id) throws CustomException
	{
		String query="select * from USER_DETAIL where CUSTOMER_ID=?";
		Map<Long,CustomerDetails> userDetailMap=new HashMap<>();
		
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setLong(1, id);
			try(ResultSet result=stmnt.executeQuery();)
			{
			while(result.next())
			 {
				CustomerDetails users=new CustomerDetails();
				users.setCustomerID(result.getLong("CUSTOMER_ID"));
				users.setAadharNumber(result.getLong("AADHAR_NUMBER"));
				users.setPAN_Number(result.getString("PAN"));
				users.setDOB(result.getString("DOB"));
				users.setAddress(result.getString("ADDRESS"));
				userDetailMap.put(result.getLong("CUSTOMER_ID"), users);
			 }
			}
		}catch(SQLException e)
		{
			throw new CustomException("SQL ERROR",e);
		}
		return userDetailMap;
	}
	public String getStatus(long value,String field,String table) throws CustomException
	{
		String query="select STATUS from "+table+" where "+field+"="+value+"";
		String status=null;
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);
			ResultSet result=stmnt.executeQuery();)
			{
				while(result.next())
				{
					status=result.getString("STATUS");
				}
			}catch(SQLException e)
		{
				throw new CustomException("SQL ERROR",e);
		}
		return status;
	}
	public long getId(long value,String field,String table) throws CustomException
	{
		String query="select CUSTOMER_ID from "+table+" where "+field+"="+value+"";
		long id=0;
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);
			ResultSet result=stmnt.executeQuery();)
			{
				while(result.next())
				{
					id=result.getLong("CUSTOMER_ID");
				}
			}catch(SQLException e)
		{
				throw new CustomException("SQL ERROR",e);	
		}
		return id;
	}


	public List<Object>  getDetails(long id,String searchingColumn,String table,String existingColumn) throws CustomException
	{
		String query="select "+searchingColumn+" from "+table+" where "+existingColumn+"=?";
		List<Object> ans=new ArrayList<>();
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setLong(1, id);
			try(ResultSet result=stmnt.executeQuery();)
		    {
				while(result.next())
				{
					ans.add(result.getLong(searchingColumn));
				}
		    }
		}catch(SQLException e)
		{
			throw new CustomException("SQL ERROR",e);	
		}
		return ans;
	}

	public int getUpdateColumn(long existValue,long updateValue,String updateColumn,String existColumn,String table) throws CustomException
	{
		String query="update "+table+" set "+updateColumn+"="+updateValue+" where "+existColumn+" = "+existValue+"";
		int ans;
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			ans=stmnt.executeUpdate();
		}catch(SQLException e)
		{
			throw new CustomException("SQL ERROR",e);
		}
		return ans;		
	}
	public int getUpdatePassword(String updateValue,long customerID) throws CustomException
	{
		String query="update User_Table set Password = '"+updateValue+"' where CUSTOMER_ID = "+customerID+"";
		int ans;
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			ans=stmnt.executeUpdate();
		}catch(SQLException e)
		{
			throw new CustomException("SQL ERROR",e);
		}
		return ans;		
	}
	
	public void getUpdateUser(Map<String,Object> updateMap,long customerID,String table) throws CustomException
	{
		for(Map.Entry<String,Object> ent: updateMap.entrySet())
		  {
			String query="update "+table+" set "+ent.getKey()+" = '"+ent.getValue()+"' where CUSTOMER_ID = "+customerID+" ";
			try(Connection connect=DatabaseConnection.getConnection();
					PreparedStatement stmnt=connect.prepareStatement(query);)
			{
				stmnt.executeUpdate();
			}catch(SQLException e)
			{
				throw new CustomException("SQL ERROR",e);
			}
		  }
	 }
	
	public void getUpdateAccount(Map<String,Object> updateMap,long accountNumber) throws CustomException
	{
		for(Map.Entry<String,Object> ent: updateMap.entrySet())
		  {
			String query="update ACCOUNT_DETAIL set "+ent.getKey()+" = '"+ent.getValue()+"' where ACCOUNT_NUMBER = "+accountNumber+" ";
			try(Connection connect=DatabaseConnection.getConnection();
					PreparedStatement stmnt=connect.prepareStatement(query);)
			{
				stmnt.executeUpdate();
			}catch(SQLException e)
			{
				throw new CustomException("SQL ERROR",e);
			}
		  }
	 }
	
	public Map<Long,CustomerDetails> getUserDetailsForAdmin() throws CustomException
	{
		String query="select * from USER_DETAIL ";
		Map<Long,CustomerDetails> map=new HashMap<>();
		
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);
				ResultSet result=stmnt.executeQuery();)
		{
			while(result.next())
			{
				CustomerDetails users=new CustomerDetails();
				users.setCustomerID(result.getLong(1));
				users.setAadharNumber(result.getLong(2));
				users.setPAN_Number(result.getString(3));
				users.setAddress(result.getString(4));
				users.setDOB(result.getString(5));
				map.put(users.getCustomerID(), users);
			}
		}catch(SQLException e)
		{
			throw new CustomException("SQL ERROR",e);
		}
		return map;
	}
	
	public Map<Long,AccountDetails> getAccountDetails(long id) throws CustomException
	{
		String query="select * from ACCOUNT_DETAIL where CUSTOMER_ID=? ";
		//Map<Long,Map<Long,AccountDetails>> accountMap=new HashMap<>(); 
		Map<Long,AccountDetails> accountsMap=new HashMap<>();
		 
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setLong(1, id);
			try(ResultSet result=stmnt.executeQuery();)
			{
			  accountResult(accountsMap, result);
			  //accountMap.put(id, accountsMap);
			 }
		}catch(SQLException e)
		{
			throw new CustomException("SQL ERROR",e);
		}
		return accountsMap;
	}
	
	private void accountResult(Map<Long, AccountDetails> accountsMap, ResultSet result) throws CustomException 
	{
		try {
		while(result.next())
		  {
			      AccountDetails account=new AccountDetails();
			      account.setCustomerID(result.getLong("CUSTOMER_ID"));
				  account.setAccountNumber(result.getLong("ACCOUNT_NUMBER"));
				  account.setAccountType(result.getString("ACCOUNT_TYPE"));
				  account.setBalance(result.getDouble("BALANCE"));
				  account.setBranch(result.getString("BRANCH"));
				  account.setIFSC(result.getString("IFSC"));
				  account.setStatus(result.getString("STATUS"));
				  accountsMap.put(account.getAccountNumber(), account);
				 // accountMap.put(result.getLong(1), accountsMap);
		  }
		  }catch(SQLException e)
		  {
			  throw new CustomException("SQL ERROR",e);
		  }
	}

	public Map<Long,AccountDetails> getInActiveAccounts(long id) throws CustomException
	{
		String query="select * from ACCOUNT_DETAIL where CUSTOMER_ID=? AND STATUS LIKE 'IN%'";
		//Map<Long,Map<Long,AccountDetails>> accountMap=new HashMap<>(); 
		Map<Long,AccountDetails> accountsMap=new HashMap<>();
		 
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setLong(1, id);
			try(ResultSet result=stmnt.executeQuery();)
			{
			  accountResult(accountsMap, result);
			 }
		}catch(SQLException e)
		  {
			  throw new CustomException("SQL ERROR",e);
		  }
		return accountsMap;
	}

	public Map<Long,AccountDetails> getActiveAccounts(long id) throws CustomException
	{
		String query="select * from ACCOUNT_DETAIL where CUSTOMER_ID=? AND STATUS NOT LIKE 'IN%'";
		//Map<Long,Map<Long,AccountDetails>> accountMap=new HashMap<>(); 
		Map<Long,AccountDetails> accountsMap=new HashMap<>();
		 
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setLong(1, id);
			try(ResultSet result=stmnt.executeQuery();)
			{
			  accountResult(accountsMap, result);
			 }
		}catch(SQLException e)
		  {
			  throw new CustomException("SQL ERROR",e);
		  }
		return accountsMap;
	}

	public Map<Long,AccountDetails> getAllAccounts() throws CustomException
	{
		String query="select * from ACCOUNT_DETAIL ";
		Map<Long,AccountDetails> accountsMap=new HashMap<>(); 
		   
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);
				ResultSet result=stmnt.executeQuery();)
		{
			  while(result.next())
			  {
				  AccountDetails account=new AccountDetails();
				  account.setCustomerID(result.getLong(1));
				  account.setAccountNumber(result.getLong(2));
				  account.setAccountType(result.getString(3));
				  account.setBalance(result.getDouble(4));
				  account.setBranch(result.getString(5));
				  account.setIFSC(result.getString(6));
				  account.setStatus(result.getString(7));
				  accountsMap.put(account.getAccountNumber(), account);
				  
			  }
			     // accountsMap.put(accounts.getCustomerID(), accountMap);
		}catch(SQLException e)
		  {
			  throw new CustomException("SQL ERROR",e);
		  }
		return accountsMap;
	}
	
	public String getParticularDetail(long id,String table,String column,String search) throws CustomException
	{
		String query="select "+search+" from "+table+" where "+column+"=?";
		//String password=null;
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			stmnt.setLong(1,id);
			try(ResultSet result=stmnt.executeQuery();)
			{
				
				while(result.next())
				{
					search=result.getString(search);
				}
			}
		}catch(SQLException e)
		  {
			  throw new CustomException("SQL ERROR",e);
		  }
		return search;
	}
	
	
	public void getExecute(String query)
	{
		try(Connection connect=DatabaseConnection.getConnection();
				PreparedStatement stmnt=connect.prepareStatement(query);)
		{
			 stmnt.execute(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
