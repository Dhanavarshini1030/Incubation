package threadtask;

public class MyExtendedThreadDump extends Thread
{
	
	boolean condition;
	int seconds;
	public MyExtendedThreadDump()
	{
		
	}
	public MyExtendedThreadDump(int time)
	{
		this.seconds=time;
	}
	public void setVariable(boolean condition)
	{
		this.condition=condition;
	}
	public void run()
	{
		while(condition)
		{
			System.out.println("The Thread Name: "+getName());
			System.out.println("Going to Sleep: "+getName());
			//go();
			 
		try 
		{
		   Thread.sleep(seconds);
		}
		catch (InterruptedException e) 
		{
		e.printStackTrace();
		}
		 System.out.println("After Sleeping: "+getName());
		}
		
	}
	/*public synchronized void go()
	{
		System.out.println("ghhkjk");
		int a=5;
		int b=6;
		int c=a+b;
		System.out.println(c);
		dump();
	}
	public void dump()
	{
		System.out.println("qqwreyt");
	}*/
	
}
