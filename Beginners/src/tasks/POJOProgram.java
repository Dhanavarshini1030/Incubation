package tasks;

public class POJOProgram 
{
	private int number;
	private String term;
	
	public POJOProgram()
	{
		System.out.println("Default Constructor");
	}
	
	public POJOProgram(int num,String term)
	{
		this.number=num;
		this.term=term;
	}
	
	public void setNumber(int numValue)
	{
		number=numValue;
	}
	
	public void setTerm(String termValue)
	{
		term=termValue;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public String getTerm()
	{
		return term;
	}
	
	public String toString()
	{
		return this.number+" "+this.term; 
	}
	
	}
