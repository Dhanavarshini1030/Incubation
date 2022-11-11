package methods;

public class UserTableDetails 
{
	private long customerID;
	private String password;
	private String role;
	private String customerName;
	private long mobileNumber;
	private String email;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setCustomerName(String name)
	{
		this.customerName=name;
	}
	public void setMobileNumber(long mobile)
	{
		this.mobileNumber=mobile;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public long getMobileNumber()
	{
		return mobileNumber;
	}
	public String getEmail()
	{
		return email;
	}
	
	public void setCustomerID(long customerID) 
	{
		this.customerID = customerID;
	}
	
	public long getCustomerID() 
	{
		return customerID;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = customerName+"@zoho";
	}
	public String toString()
	{
		return customerID+"@zoho";
	}
	
}
