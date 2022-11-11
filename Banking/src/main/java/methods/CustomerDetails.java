package methods;

public class CustomerDetails extends UserTableDetails
{
	//private long customerID;
	
	private long aadharNumber;
	private String PAN;
	
	private String address;
	private String dob;
	
	
	
	/*public void setCustomerID(long id)
	{
		this.customerID=id;
	}*/
	public void setAadharNumber(long aadharNumber)
	{
		this.aadharNumber=aadharNumber;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setDOB(String dob)
	{
		this.dob=dob;
	}
	public void setPAN_Number(String pan)
	{
		this.PAN=pan;
	}
	public String getPAN_Number()
	{
		return PAN;
	}
	
	public long getAadharNumber()
	{
		return aadharNumber;
	}
	public String getAddress()
	{
		return address;
	}
	public String getDOB()
	{
		return dob;
	}
	public String toString()
	{
		return  " AADHAR_NUMBER: "+this.aadharNumber+"  PAN:  "+this.PAN
						+" ADDRESS: "+this.address+" DOB: "+this.dob;
	}
}
