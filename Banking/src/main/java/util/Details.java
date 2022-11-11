package util;

import java.util.List;
import java.util.Map;

import methods.AccountDetails;
import methods.CustomerDetails;
import methods.UserTableDetails;

public interface Details 
{
	public void setUserLogin(List<UserTableDetails> userTable);
	public void setUserDetails(List<CustomerDetails> customerDetails);
	public void setAccountDetails(List<AccountDetails> accountDetails);
	public Map<Long,?> getUserDetails();
	public Map<Long,?> getAccountDetails();
	public Map<Long,?> getUserLogin();
}
