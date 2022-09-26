package tasks.inherit;

public class Car
{
	int yearOfMake;
	String engineNumber,type;
	public Car()
	{
		
	}
	public Car(String s)
	{
	 System.out.println(s);	
	}
	public void setYear(int year)
	{
		yearOfMake=year;
	}
	public void setEngNum(String engNum)
	{
		engineNumber=engNum;
	}
	public void setCarType( String carType)
	{
		type=carType;
	}
	public int getYear()
	{
		return yearOfMake;
	}
	public String getEngNum()
	{
		return engineNumber;
	}
	public String getType()
	{
		return type;
	}
	public void maintainance()
	{
		System.out.println("Car under Maintainance.");
	}
}

	   