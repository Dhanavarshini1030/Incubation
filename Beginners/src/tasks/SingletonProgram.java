package tasks;

public class SingletonProgram 
{
	private static final SingletonProgram singleInstance=new SingletonProgram();
	private String term;
	private SingletonProgram()
	{
		
	}
	public static SingletonProgram getInstance() 
	{
		return singleInstance;
	}
	
	public void setString(String term)
	{
		this.term=term;
	}
	
	public String getNumber()
	{
		return term;
	}
	public String toString()
	{
		return term;
	}
	
	
	public static void main(String[] args)
	{
		SingletonProgram object=getInstance();
		SingletonProgram object2=getInstance();
		SingletonProgram singleObject=new SingletonProgram();
		object.setString("Singleton");
		System.out.println(object);
		System.out.println(object2);
		singleObject.setString("Another Object");
		System.out.println(singleObject);
		
	}
	
	
}
