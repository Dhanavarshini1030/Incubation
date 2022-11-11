package control;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import methods.AccountDetails;
import methods.CustomerDetails;
import methods.LogicalPage;
import methods.StoragePage;
import methods.TransactionDetails;
import methods.UserTableDetails;
import util.CustomException;

public class ControlServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		LogicalPage logic=new LogicalPage();
		StoragePage store=new StoragePage();
		String value=req.getParameter("button");
		RequestDispatcher request;
		res.setContentType("text/jsp");
		Map<Long, CustomerDetails> userDetail;
		Map<Long, UserTableDetails> userInfo;
		switch(value)
		  {
			case "login":
				HttpSession session=req.getSession(true);
				
				try {
				String user=req.getParameter("customerID");
				long customerID=Long.parseLong(user);
				String pass=req.getParameter("password");
				session.setAttribute("customerID", customerID);
				
				
				boolean answer=logic.checkUser(customerID, pass);
				   
				if(answer)
				{
					String role=logic.getRole(customerID);
					if(role.equals("Customer"))
					{
					   request=req.getRequestDispatcher("jsp/CustomerMenu.jsp");
				   	   request.forward(req, res);
					}
					else
					{
						request=req.getRequestDispatcher("jsp/AdminMenu.jsp");
					   	request.forward(req, res);
					}
				}
				else
				{
					req.getSession().setAttribute("error", "Verify Your Entry");
					res.sendRedirect("jsp/Login.jsp");
					/*request=req.getRequestDispatcher("jsp/Login.jsp");
					request.forward(req, res);*/
				}
				}catch(CustomException e)
				{
					req.setAttribute("Error", e.getCause());
				}/*catch(NumberFormatException ex)
				{
					req.getSession().setAttribute("error","Enter ID in Proper Format");
					res.sendRedirect("jsp/Login.jsp");
				}*/
				break;
			case "adminHome":
				request=req.getRequestDispatcher("jsp/AdminMain.jsp");
				request.forward(req, res);
				break;
			case "viewCustomer":
				try
				{
				Map<Long,CustomerDetails> userDetails=store.getAllUserInfo();
				req.setAttribute("UserDetails", userDetails);
				
				request=req.getRequestDispatcher("jsp/ViewCustomer.jsp");
				request.forward(req, res);
				}
				catch(CustomException e)
				{
					req.setAttribute("Error", e.getCause());
					request=req.getRequestDispatcher("jsp/ViewCustomer.jsp");
					request.forward(req, res);
				}
				break;
			case "viewAccounts":
				try {
				Map<Long,AccountDetails> allAccountDetail=store.getAllAccountDetails();
				req.setAttribute("allAccountDetail", allAccountDetail);
				
				request=req.getRequestDispatcher("jsp/ViewAllAccounts.jsp");
				request.forward(req, res);
				}catch(CustomException e)
				{
					req.setAttribute("Error", e.getCause());
					request=req.getRequestDispatcher("jsp/ViewAllAccounts.jsp");
					request.forward(req, res);
				}
				break;
			case "changePassword":
				request=req.getRequestDispatcher("jsp/ChangePassword.jsp");
				request.forward(req, res);
				break;
			case "Change":
				session=req.getSession(false);
				long customerId=(long) session.getAttribute("customerID");
				
				String currentPassword=req.getParameter("existingPassword");
				String newPassword=req.getParameter("newPassword");
				String reEnterPassword=req.getParameter("reEnterPassword");
				try
				{
				boolean check=logic.checkUser(customerId, currentPassword);
				if(check)
				{
					if(newPassword.equals(reEnterPassword))
					{
						int result=store.getUpdatePassword(newPassword, customerId);
						if(result==1)
						{
							req.setAttribute("Message","Your New Password is Successfully Updated.");
							request=req.getRequestDispatcher("jsp/ChangePassword.jsp");
							request.forward(req, res);
						}
						else
						{
							req.setAttribute("Message","Kindly, Check Your Password. Update Failure");
							request=req.getRequestDispatcher("jsp/ChangePassword.jsp");
							request.forward(req, res);
						}
					  }
					  else
					  {
						    req.setAttribute("Message","Kindly, Check Your Password.");
							request=req.getRequestDispatcher("jsp/ChangePassword.jsp");
							request.forward(req, res);
					  }
				  }
				else
				{
					 req.setAttribute("Message","Kindly,Check your Current Password.");
					 request=req.getRequestDispatcher("jsp/ChangePassword.jsp");
					 request.forward(req, res);
				}
				}catch(CustomException e)
				  {
					 req.setAttribute("Error",e.getCause());
				  }
				break;
			case "customerHome":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				 try {  
				Map<Long,AccountDetails> accountDetail=store.getActiveAccounts(customerId);
				req.setAttribute("accountDetail", accountDetail);
				   
				request=req.getRequestDispatcher("jsp/CustomerMain.jsp");
				request.forward(req, res);
				 }catch(CustomException e)
				 {
					 
					request=req.getRequestDispatcher("jsp/CustomerMain.jsp");
					request.forward(req, res);
				 }
				 
				break;
			case "viewProfile":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				try
				{
				Map<Long,CustomerDetails> userDetail1=store.getUserDetails(customerId);
				req.setAttribute("userDetail",userDetail1);
				Map<Long,UserTableDetails> userInfo1=store.getUserInfo(customerId);
				req.setAttribute("userInfo", userInfo1);
				request=req.getRequestDispatcher("jsp/ViewProfile.jsp");
				request.forward(req, res);
				}
				catch(CustomException e)
				{
					req.setAttribute("Error", e.getCause());
					request=req.getRequestDispatcher("jsp/ViewProfile.jsp");
					request.forward(req, res);
				}
				break;
			case "viewAccount":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				try
				{
				Map<Long,AccountDetails> accounts=store.getAccountDetails(customerId);
				req.setAttribute("accounts", accounts);
				
				request=req.getRequestDispatcher("jsp/ViewAccount.jsp");
				request.forward(req, res);
				}catch(CustomException e)
				{
					request=req.getRequestDispatcher("jsp/ViewAccount.jsp");
					request.forward(req, res);
				}
				
				break;
			case "transfer":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				try {
				Map<Long,AccountDetails> accountForTransfer=store.getActiveAccounts(customerId);
				req.setAttribute("account", accountForTransfer);
				request=req.getRequestDispatcher("jsp/Transfer.jsp");
				request.forward(req, res);
				}catch(CustomException e)
				{
					req.setAttribute("Error", e.getCause());
					request=req.getRequestDispatcher("jsp/Transfer.jsp");
					request.forward(req, res);
				}
				break;
			case "finishTransaction":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				List<TransactionDetails> transactionInfo=new ArrayList<>();
				Map<Long, AccountDetails> accountForTransfer;
			try
				{
				TransactionDetails transaction=new TransactionDetails();
	        	TransactionDetails newTransaction=new TransactionDetails();
	        	long time=logic.getMillis();
	        	transaction.setTime(time);
	        	newTransaction.setTime(time);
	        	
	        	String accNumb=req.getParameter("accNum");
	        	long accNumber=Long.parseLong(accNumb);
	        	transaction.setAccountNumber(accNumber);
	        	//transaction.setAccountNumber(145245);
	        	
	        	newTransaction.setTransactionAccount(accNumber);
	        	
	        	String transAcc=req.getParameter("transAccount");
	        	long transAccNum=Long.parseLong(transAcc);
	        	transaction.setTransactionAccount(transAccNum);
	        	newTransaction.setAccountNumber(transAccNum);
	        	
	        	transaction.setCustomerID(customerId);
	        	long transAccID=logic.getId(transAccNum);
	        	newTransaction.setCustomerID(transAccID);
	        	//String mode=req.getParameter("Debit");
	        	transaction.setCreditDebit("Debit");
	        	newTransaction.setCreditDebit("Credit");
	        	
	        	String amount=req.getParameter("transAmount");
	        	long transAmnt=Long.parseLong(amount);
	        	transaction.setProcessingAmount(transAmnt);
	        	newTransaction.setProcessingAmount(transAmnt);
	        	
	        	long transBalance=logic.getAccountBalance(transAccNum);
	        	long balance=logic.getAccountBalance(accNumber);
	        	long maximumTransAmnt=balance-3000;
      		    if((balance!=0)&&(transAmnt<=maximumTransAmnt))
      		    {
      		    	long currentBalance=logic.debitProcess(balance, transAmnt);
      		    	long transCurrentBal=logic.creditProcess(transBalance, transAmnt);
      		    	newTransaction.setCurrentBalance(transCurrentBal);
      		    	transaction.setCurrentBalance(currentBalance);
	  			
      		    	int answers=store.getUpdate(accNumber, currentBalance, "ACCOUNT_NUMBER");
      		    	int ans=store.getUpdate(transAccNum, transCurrentBal, "ACCOUNT_NUMBER");
      		    	transactionInfo.add(transaction);
      		    	transactionInfo.add(newTransaction);
      		    	store.setTransactionDetails(transactionInfo);
	  			
      		    	req.setAttribute("message","Successfully Transferred...");
	  			
      		    	accountForTransfer=store.getActiveAccounts(customerId);
      		    	req.setAttribute("account", accountForTransfer);
				
      		    	request=req.getRequestDispatcher("jsp/Transfer.jsp");
      		    	request.forward(req, res);
      		    }
      		    else
      		    {
      		    	req.setAttribute("message","Due to Minimum Balance, "
      		    			+ "you are unable to continue your Transaction on this Account");
      		    	
      		    	accountForTransfer=store.getActiveAccounts(customerId);
      		    	req.setAttribute("account", accountForTransfer);
      		    	request=req.getRequestDispatcher("jsp/Transfer.jsp");
    				request.forward(req, res);
      		    }
				}
				catch(CustomException e)
				{
					req.setAttribute("Error", e.getCause());
					try {
						accountForTransfer=store.getActiveAccounts(customerId);
						req.setAttribute("account", accountForTransfer);
	      		    	
					} catch (CustomException e1) {
						e1.printStackTrace();
					}
					request=req.getRequestDispatcher("jsp/Transfer.jsp");
    				request.forward(req, res);
				}
				/*catch(NumberFormatException e)
				{
					req.setAttribute("Error","should contain Numbers Only");
					request=req.getRequestDispatcher("jsp/Transfer.jsp");
					request.forward(req, res);
				}*/
	  			break;
	  			
			case "update":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				Map<String,Object> info=new HashMap<>();
				try
				{
				
				info.put("EMAIL",req.getParameter("email"));
				info.put("MOBILE_NUMBER",req.getParameter("mobile"));
				store.getUpdateUserInfo(info, customerId);
				Map<String,Object> map=new HashMap<>();
				map.put("ADDRESS",req.getParameter("address"));
				store.getUpdateUser(map, customerId);
				
				req.setAttribute("message","Successfully Updated.");
				
				userDetail=store.getUserDetails(customerId);
				req.setAttribute("userDetail",userDetail);
				userInfo=store.getUserInfo(customerId);
				req.setAttribute("userInfo", userInfo);
				request=req.getRequestDispatcher("jsp/ViewProfile.jsp");
				request.forward(req, res);
				}catch(CustomException e)
				{
					req.setAttribute("Error",e.getCause());
					request=req.getRequestDispatcher("jsp/ViewProfile.jsp");
					request.forward(req, res);
				}
				break;
			
			case "withdraw":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				try {
				Map<Long,AccountDetails> activeAccount=store.getActiveAccounts(customerId);
				req.setAttribute("account", activeAccount);
				
				request=req.getRequestDispatcher("jsp/Withdraw.jsp");
				request.forward(req, res);
				}catch(CustomException e)
				{
					req.setAttribute("Error",e.getCause());
					request=req.getRequestDispatcher("jsp/Withdraw.jsp");
					request.forward(req, res);
				}
				break;
			case "deposit":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				try {
				Map<Long,AccountDetails> activeAcc=store.getActiveAccounts(customerId);
				req.setAttribute("account", activeAcc);
				
				request=req.getRequestDispatcher("jsp/Deposit.jsp");
				request.forward(req, res);
				}catch(CustomException e)
				{
					req.setAttribute("Error",e.getCause());
					request=req.getRequestDispatcher("jsp/Deposit.jsp");
					request.forward(req, res);
				}
				break;
			case "statement":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				try {
				Map<Long,AccountDetails> accountActive=store.getActiveAccounts(customerId);
				req.setAttribute("account", accountActive);
				request=req.getRequestDispatcher("jsp/Statement.jsp");
				request.forward(req, res);
				}catch(CustomException e)
				{
					req.setAttribute("Error",e.getCause());
					request=req.getRequestDispatcher("jsp/Statement.jsp");
					request.forward(req, res);
				}
				break;
			case "Get Statement":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				
				try
				{
				Map<Long,AccountDetails> accountMap=store.getActiveAccounts(customerId);
				req.setAttribute("account", accountMap);
				String account=req.getParameter("accountNum");
				long accNum=Long.parseLong(account);
				
				Map<Long,List<TransactionDetails>> transactMap=store.getLimitTransactionDetails(accNum);
	  			
				req.setAttribute("transaction", transactMap);
				
	  			req.setAttribute("Message","There is No Transaction in Your Account");
				request=req.getRequestDispatcher("jsp/Statement.jsp");
				request.forward(req, res);
				}
				catch(CustomException e)
				{
					req.setAttribute("Error",e.getCause());
					Map<Long, AccountDetails> accountMap;
					try {
						accountMap = store.getActiveAccounts(customerId);
						req.setAttribute("account", accountMap);
					} catch (CustomException e1) {
						e1.printStackTrace();
					}
					request=req.getRequestDispatcher("jsp/Statement.jsp");
					request.forward(req, res);
				}
				break;
			case "Request To Active":
				session=req.getSession(false);
				customerId=(long) session.getAttribute("customerID");
				try {
				Map<Long,AccountDetails> inActiveAccounts=store.getInActiveAccounts(customerId);
				req.setAttribute("account", inActiveAccounts);
				
				request=req.getRequestDispatcher("jsp/RequestToActive.jsp");
				request.forward(req, res);
				}catch(CustomException e)
				{
					req.setAttribute("Error",e.getCause());
					request=req.getRequestDispatcher("jsp/RequestToActive.jsp");
					request.forward(req, res);
				}
				
				break;
			case "addAccount":
				try
				{
				Map<Long,CustomerDetails> allUserInfo=store.getAllUserInfo();
				req.setAttribute("info",allUserInfo);
				request=req.getRequestDispatcher("jsp/AddAccount.jsp");
				request.forward(req, res);
				}catch(CustomException e)
				{
					req.setAttribute("Error", e.getCause());
					request=req.getRequestDispatcher("jsp/AddAccount.jsp");
					request.forward(req, res);
				}
				break;
			case "accountEntered":
				AccountDetails accountInfo=new AccountDetails();
				List<AccountDetails> accountList=new ArrayList<>();
				try
				{
				long id=Long.parseLong(req.getParameter("id"));
				accountInfo.setCustomerID(id);
				long accountNumber=Long.parseLong(req.getParameter("accNum"));
				accountInfo.setAccountNumber(accountNumber);
			
				accountInfo.setAccountType(req.getParameter("accType"));
				accountInfo.setBranch(req.getParameter("branch"));
				accountInfo.setIFSC(req.getParameter("ifscCode"));
				long accBalance=Long.parseLong(req.getParameter("balance"));
				accountInfo.setBalance(accBalance);
				accountInfo.setStatus("ACTIVE");
				accountList.add(accountInfo);
				store.setAccountDetails(accountList);
				
				Map<Long, AccountDetails> allAccountDetail = store.getAllAccountDetails();
				req.setAttribute("allAccountDetail", allAccountDetail);
				req.setAttribute("Message","Account Entered");
				request=req.getRequestDispatcher("jsp/ViewAllAccounts.jsp");
				request.forward(req, res);
				}
				catch(CustomException e)
				{
					req.setAttribute("Message",e.getCause());
					Map<Long, CustomerDetails> allUserInfo;
					try {
						allUserInfo = store.getAllUserInfo();
						req.setAttribute("info",allUserInfo);
					} catch (CustomException e1) {
						e1.printStackTrace();
					}
					request=req.getRequestDispatcher("jsp/AddAccount.jsp");
					request.forward(req, res);
				}/*catch(NumberFormatException e)
				{
					req.setAttribute("Message","Kindly Verify your Entry");
					request=req.getRequestDispatcher("jsp/Transfer.jsp");
					request.forward(req, res);
				}*/
				
				break;
				
			case "addDetails":
				List<CustomerDetails> customerList=new ArrayList<>();
				try
				{
				CustomerDetails customer=new CustomerDetails();
				customer.setCustomerName(req.getParameter("name"));
				customer.setPassword(req.getParameter("name"));
				customer.setEmail(req.getParameter("email"));
				String mobile=req.getParameter("mobileNumber");
				customer.setMobileNumber(Long.parseLong(mobile));
				customer.setRole("Customer");
				customer.setStatus("ACTIVE");
				
				String aadhar=req.getParameter("aadharNumber");
				customer.setAadharNumber(Long.parseLong(aadhar));
				customer.setAddress(req.getParameter("address"));
				customer.setDOB(req.getParameter("dob"));
				customer.setPAN_Number(req.getParameter("panNum"));
				customerList.add(customer);
				long cusID=store.addNewUser(customerList);
				
				req.setAttribute("id",cusID);
				request=req.getRequestDispatcher("jsp/AddAccount.jsp");
				request.forward(req, res);
				}
				catch(CustomException e)
				{
					req.setAttribute("Message",e.getCause());
					request=req.getRequestDispatcher("jsp/AddProfile.jsp");
					request.forward(req, res);
				}/*catch(NumberFormatException e)
				{
					req.setAttribute("Message","Kindly Verify your Details");
					request=req.getRequestDispatcher("jsp/Transfer.jsp");
					request.forward(req, res);
				}*/
				
				break;
			case "addProfile":
				request=req.getRequestDispatcher("jsp/AddProfile.jsp");
				request.forward(req, res);
				break;
			case "logOut":
				res.sendRedirect("jsp/Login.jsp");
				break;
		}
		
	}
}