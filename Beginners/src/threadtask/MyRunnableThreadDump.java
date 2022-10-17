package threadtask;

public class MyRunnableThreadDump implements Runnable
{
	boolean condition;
	int seconds;
	public MyRunnableThreadDump()
	{
		
	}
	public MyRunnableThreadDump(int time)
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
			System.out.println("The Runnable Thread Name: "+Thread.currentThread().getName());
			System.out.println("Going to Sleep: "+Thread.currentThread().getName());
		try 
		{
		   Thread.sleep(seconds);
		  // Thread.dumpStack();
		}
		catch (InterruptedException e) 
		{
		  e.printStackTrace();
		}
			System.out.println("After Sleep: "+Thread.currentThread().getName());
		}
	}
	
}
