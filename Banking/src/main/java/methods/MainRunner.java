package methods;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.CustomException;

public class MainRunner 
{
	Scanner scan=new Scanner(System.in);
		 
	public static void main(String[] args) 
	{
		
		MainRunner runner= new MainRunner();
		UserTableDetails user=new UserTableDetails();
		CustomerDetails customer=new CustomerDetails();
		AccountDetails account=new AccountDetails();
		TransactionDetails transaction=new TransactionDetails();
	    StoragePage store=new StoragePage();
		LogicalPage logic=new LogicalPage();
		AdminTableDetails admin=new AdminTableDetails();
		System.out.println("Enter your choice: ");
		System.out.println("1 for Login as User and 2 for Login as Admin");
		int option=runner.scan.nextInt();
		try
		{
		 switch(option)
		 {
		  case 1:
			 	
			  System.out.println("Enter CUSTOMER_ID");
			  long id=runner.scan.nextLong();
		      user.setCustomerID(id);
			  System.out.println("Enter PASSWORD:");
			  String password=runner.scan.next();
			  user.setPassword(password);
			  boolean userDetail=logic.checkUser(id, password);
			  int wish;
			  if(userDetail)
			  {
				boolean status=logic.checkStatus(id,"CUSTOMER_ID","User_Table");
				if(status)
				{
			     do
			     {
			       System.out.println("Enter 1 to view Profile and 2 to view Accounts and 3 for more options");
			       int choice=runner.scan.nextInt();
			       switch(choice)
			       {
			         case 1:
			        	 Map<Long,CustomerDetails> userDetailMap=store.getUserDetails(id);
			    	      System.out.println(userDetailMap);
			    	      break;
			         case 2:
			    	      Map<Long,AccountDetails>accountDetailMap=store.getAccountDetails(id);
			    	      for(Map.Entry<Long,AccountDetails> ent: accountDetailMap.entrySet())
					      {
			    	    	  System.out.println("CUSTOMER_ID "+ent.getKey() +"  DETAILS:"+ ent.getValue());
					      }
			    	      // System.out.println(accountDetailMap);
			    	      break;
			         case 3:
			        	  List<TransactionDetails> transactionInfo=new ArrayList<>();
			        	  
			        	  TransactionDetails newTransaction=new TransactionDetails();
			      	    
			        	  System.out.println("WELCOME FOR TRANSACTION");
			        	  System.out.println("For Transaction Enter the following Details:");
			        	  long time=logic.getMillis();
			        	  transaction.setTime(time);
			        	  newTransaction.setTime(time);
			        	  System.out.println("Enter AccountNumber:");
			        	  long accountNum=runner.scan.nextLong();
			        	  
			        	  boolean accountExistOrNot=logic.isExistOrNot(id, "ACCOUNT_NUMBER","ACCOUNT_DETAIL","CUSTOMER_ID",accountNum);
			        	  if(accountExistOrNot)
			        	  {
			        		boolean accStatus=logic.checkStatus(accountNum, "ACCOUNT_NUMBER","ACCOUNT_DETAIL");
			        		if(accStatus)
			        		{
			        		  transaction.setAccountNumber(accountNum);
			        		  newTransaction.setTransactionAccount(accountNum);
			        		  long balance=logic.getAccountBalance(accountNum);
			        		  transaction.setCustomerID(id);
			        		  String table="ACCOUNT_DETAIL";
			        		  String column="BALANCE";
			        		  System.out.println("YOUR CURRENT BALANCE: "+balance);
			        		  System.out.println("Enter 1 for CREDIT ,2 for DEBIT and 3 to show last 5 Transaction");
			        		  int transactionMode=runner.scan.nextInt();
			        		  Map<Long,TransactionDetails> transactMap;//=new HashMap<>();
			        		  switch(transactionMode)
			        		  {
			    		  		case 1:
			    		  			String creditDebit="Credit";
			    		  			transaction.setCreditDebit(creditDebit);
			    		  			String debit="debit";
			    		  			newTransaction.setCreditDebit(debit);
			    		  			System.out.println("Enter Amount to be Credited:");
			    		  			long creditAmount=runner.scan.nextLong();
			    		  			transaction.setProcessingAmount(creditAmount);
			    		  			newTransaction.setProcessingAmount(creditAmount);
			    		  			System.out.println("Enter Transaction Account: ");
			    		  			long transactionAccount=runner.scan.nextLong();
			    		  			transaction.setTransactionAccount(transactionAccount);
			    		  			newTransaction.setAccountNumber(transactionAccount);
			    		  			long transBalance=logic.getAccountBalance(transactionAccount);
			    		  			
			    		  			long currentBalance=logic.creditProcess(balance, creditAmount);
			    		  			long transCurrentBal=logic.debitProcess(transBalance, creditAmount);
			    		  			newTransaction.setCurrentBalance(transCurrentBal);
			    		  			transaction.setCurrentBalance(currentBalance);
			    		  			
			    		  			System.out.println("Your Balance is "+currentBalance);
			    		  			int answer=store.getUpdate(accountNum, currentBalance, "ACCOUNT_NUMBER");
			    		  			int ans=store.getUpdate(transactionAccount, transCurrentBal, "ACCOUNT_NUMBER");
			    		  			transactionInfo.add(transaction);
			    		  			transactionInfo.add(newTransaction);
			    		  			store.setTransactionDetails(transactionInfo);
			    		  			//store.setTransactionDetails(transactionInfo1);
			    		  			if(answer==1)
			    		  			{
			    		  				System.out.println("UPDATE TO YOUR ACCOUNT");
			    		  				System.out.println("YOUR UPDATED TRANSACTION DETAILS: ");
			    		  				/*transactMap=store.getTransactionDetails(accountNum);
			    		  				System.out.println(transactMap);
			    		  			///	transactMap=store.getTransactionDetails(transactionAccount);
			    		  				System.out.println(transactMap);*/
			    		  				
			    		  			}
			    		  			else
			    		  			{
			    		  				System.out.println("UNSUCCESSFULL");
			    		  			}
			    		  			break;
			    		  		case 2:
			    		  			creditDebit="Debit";
			    		  			transaction.setCreditDebit(creditDebit);
			    		  			System.out.println("Enter Amount to be Dedited:");
			    		  			long debitAmount=runner.scan.nextLong();
			    		  			if(logic.checkDebitAmount(debitAmount, balance))
			    		  			{
			    		  				transaction.setProcessingAmount(debitAmount);
			    		  				System.out.println("Enter Transaction Account: ");
			    		  				transactionAccount=runner.scan.nextLong();
			    		  				transaction.setTransactionAccount(transactionAccount);
			    		  				long currentDebitBalance=logic.debitProcess(balance, debitAmount);
			    		  				transaction.setCustomerID(currentDebitBalance);
			    		  				System.out.println("Your Balance is "+currentDebitBalance);
			    		  				answer=store.getUpdate(accountNum, currentDebitBalance, "ACCOUNT_NUMBER");
			    		  				transactionInfo.add(transaction);
			    		  				store.setTransactionDetails(transactionInfo);
			    		  				if(answer==1)
			    		  				{
			    		  					System.out.println("UPDATE TO YOUR ACCOUNT");
			    		  					//transactMap=store.getTransactionDetails(accountNum);
			    		  				}
			    		  				else
			    		  				{
			    		  					System.out.println("UNSUCCESSFULL");
			    		  				}
			    		  			 }
			    		  			 else
			    		  			 {
			    		  				 System.out.println("You have not enough amount to debit");
			    		  				 System.out.println("You are unable to access this account due to low balance.");
			    		  			 }
			    		  		   	 break;
			    		  		 case 3:
			    		  			 System.out.println("Your Last 5 Transactions are as Follow: ");
			    		  			 Map<Long,List<TransactionDetails>> transactLimit=store.getLimitTransactionDetails(accountNum);
			    		  			 System.out.println(transactLimit);
			    		  			 break;
			        		  	}
			        	   }
			        		else
			        		{
			        			System.out.println("YOUR ACCOUNT IS INACTIVE");
			        		}
			        	  }
			        	  
			        	   else
			        	   {
			        		   System.out.println("You doesn't have this Account");
			        	   }
			        	  break;
			    	  default:
			    		  System.out.println("ENTER VALID INPUT ");
			      }
			       System.out.println("1 to continue and 2 to break");
			       wish=runner.scan.nextInt();
			     }while(wish==1);
			    }
		      else
			  {
				  System.out.println("YOUR USER ID IS INACTIVE");
			  }
			  }
			  else
			  {
				  System.out.println("INCORRECT PASSWORD..... ENTER CORRECTLY");
			  }
			 break;
		  case 2:
			  System.out.println("ADMIN PAGE");
			  System.out.println("Enter ADMIN_ID");
			  long admin_ID=runner.scan.nextLong();
		      System.out.println("Enter PASSWORD:");
			  String adminPassword=runner.scan.next();
			  boolean userDetailListForAdmin=logic.checkUser(admin_ID, adminPassword);		
			  System.out.println(userDetailListForAdmin);
			  int admin_wish = 0;
			  if(userDetailListForAdmin)
			  {
			    do
			    {
			      System.out.println("Enter 1 to view Profile, 2 to view Accounts, 3 for Add and 4 for Update");
			      int choice=runner.scan.nextInt();
			      switch(choice)
			      {
			      case 1:
			    	  /*for(Map.Entry<Long,CustomerDetails> ent: userDetailListForAdmin.entrySet())
					  {
						  System.out.println("CUSTOMER_ID "+ent.getKey() +"  DETAILS:"+ ent.getValue());
					  }
			    	  break;*/
			      case 2:
			    	  Map<Long,AccountDetails> accountDetailMap=store.getAllAccountDetails();
				      for(Map.Entry<Long,AccountDetails> ent: accountDetailMap.entrySet())
					  {
						  System.out.println("ACCOUNT NUMBER "+ent.getKey() +"  DETAILS:"+ ent.getValue());
					  }
			    	  //System.out.println(accountDetailMap);
			         break;
			      case 3:
			    	 System.out.println("Enter 1 for Add Customer Detail ,2 for Add Account, 3 for Add UserID and 4 for Add Admin"); 
			    	 int preference=runner.scan.nextInt();
			         if(preference==1)
			    	 {
			        	 List<CustomerDetails> customerInfo=new ArrayList<>();
						  System.out.println("Enter the Number: ");
						  int count=runner.scan.nextInt();
						  for(int i=0;i<count;i++)
						  {
							  System.out.println("Enter The CustomerID:");
							  long customerID=runner.scan.nextLong();
							  customer.setCustomerID(customerID);
							  System.out.println("Enter The Aadhar Number:");
							  long aadhar=runner.scan.nextLong();
							  customer.setAadharNumber(aadhar);
							  System.out.println("Enter The Address:");
							  runner.scan.nextLine();
							  String address=runner.scan.nextLine();
							  customer.setAddress(address);
							  runner.scan.nextLine();
							  
							  System.out.println("Enter The Pan:");
							  String pan=runner.scan.nextLine();
							  customer.setPAN_Number(pan);
							  runner.scan.nextLine();
							  
							   System.out.println("Enter The DOB:");
							  String dob=runner.scan.nextLine();
							  customer.setDOB(dob);
							  customerInfo.add(customer);
							  //store.setUserDetails(customerInfo);
						  }
					 }
			         else if(preference==2)
			         {
			        	  List<AccountDetails> accountInfo=new ArrayList<>();
						  System.out.println("Enter the Number: ");
						  int count=runner.scan.nextInt();
						  for(int i=0;i<count;i++)
						  {
							  System.out.println("Enter The CustomerID:");
							  long customerID=runner.scan.nextLong();
							  account.setCustomerID(customerID);
							  System.out.println("Enter The Account Number:");
							  long account_Number=runner.scan.nextLong();
							  account.setAccountNumber(account_Number);
							  System.out.println("Enter The IFSC:");
							  String ifsc=runner.scan.next();
							  account.setIFSC(ifsc);
							  System.out.println("Enter The Account Type:");
							  runner.scan.nextLine();
							  String type=runner.scan.nextLine();
							  account.setAccountType(type);
							  System.out.println("Enter The Balance:");
							  double balance=runner.scan.nextDouble();
							  account.setBalance(balance);
							  System.out.println("Enter The Branch:");
							  String branch=runner.scan.next();
							  account.setBranch(branch);
							  accountInfo.add(account);
							  store.setAccountDetails(accountInfo); 
						  }
			         }
			         else if(preference==3)
			         {
			        	 List<UserTableDetails> userTable=new ArrayList<>();
						  
			        	 System.out.println("Enter Password: ");
			        	 String addUserPassword=runner.scan.next();
			        	 user.setPassword(addUserPassword);
			        	 userTable.add(user);
			        	 //store.setUserLogin(userTable);
			         }
			        /* else
			         {
			        	 List<AdminTableDetails> adminTable=new ArrayList<>();
						 
			        	 System.out.println("Enter Password: ");
			        	 String addAdminPassword=runner.scan.next();
			        	 admin.setPassword(addAdminPassword);
			        	 adminTable.add(admin);
			        	 adminProcess.setAdminLogin(adminTable);
			         }*/
			         break;
			      case 4:;
			      	System.out.println("UPDATING SECTION: ");
			      	System.out.println("Enter CustomerID: ");
			      	long userID=runner.scan.nextLong();
			      	boolean status=logic.checkStatus(userID,"CUSTOMER_ID","User_Table");
					if(status)
					{
			      	System.out.println("ENTER 1 TO UPDATE USER DETAILS AND 2 TO UPDATE ACCOUNT DETAILS");
			      	int update=runner.scan.nextInt();
			      	Map<String,Object> updateMap=new HashMap<>();
			      	if(update==1)
			      	{
			      		System.out.println("Enter the Number of Fields to be Updated: ");
			      		int count=runner.scan.nextInt();
			      		for(int i=0;i<count;i++)
			      		{
			      		   System.out.println("Enter the Field: ");
			      		   String field=runner.scan.next();
			      		   System.out.println("Enter The Value: ");
			      		   runner.scan.nextLine();
			      		   Object value=runner.scan.nextLine();
			      		   updateMap.put(field, value);
			      		   store.getUpdateUser(updateMap, userID);
			      		}
			      	}
			      	else
			      	{
			      		System.out.println("Enter ACCOUNT NUMBER: ");
			      		long accNum=runner.scan.nextLong();
			      		System.out.println("Enter the Number of Fields to be Updated: ");
			      		int count=runner.scan.nextInt();
			      		for(int i=0;i<count;i++)
			      		{
			      		   System.out.println("Enter the Field: ");
			      		   String field=runner.scan.next();
			      		   System.out.println("Enter The Value: ");
			      		   runner.scan.nextLine();
			      		   Object value=runner.scan.nextLine();
			      		   updateMap.put(field, value);
			      		   store.getUpdateAccount(updateMap,accNum);
			      		}
			      	}
			       }
			      else
			      {
			    	  System.out.println("Check Your Customer ID");
			      }
			       System.out.println("1 to continue and 2 to break");
			       admin_wish=runner.scan.nextInt();
			     }
			    }while(admin_wish==1);
			  }
		      else
			  {
				  System.out.println("INCORRECT PASSWORD");
			  }
			  break;
			
			  
		  case 100:
			 // store.create();
			  List<UserTableDetails> listUser=new ArrayList<>();
			  UserTableDetails custom=new UserTableDetails();
			  System.out.println("Enter The Customer Name:");
			  String customerName=runner.scan.next();
			  custom.setCustomerName(customerName);
			  System.out.println("Enter The Email:");
			  String email=runner.scan.next();
			  custom.setEmail(email);
			  
			  System.out.println("Enter The Mobile Number:");
			  long mobile=runner.scan.nextLong();
			  custom.setMobileNumber(mobile);
			  custom.setRole("Customer");
			  custom.setPassword(customerName);
			  custom.setStatus("ACTIVE");
			  listUser.add(custom);
			  //store.addNewUser(listUser);
			  break;
		 default:
			 System.out.println("Enter Valid Number");
	}
		}catch(InputMismatchException ex)
		{ 
			System.out.println("ENTER PROPER VALUE");
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}

}
