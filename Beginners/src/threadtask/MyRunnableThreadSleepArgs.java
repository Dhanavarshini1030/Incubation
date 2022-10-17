package threadtask;

public class MyRunnableThreadSleepArgs implements Runnable
{
	int seconds;
	public MyRunnableThreadSleepArgs()
	{
		
	}
	public MyRunnableThreadSleepArgs(int time)
	{
		this.seconds=time;
	}
	public void run()
	{
		System.out.println("Going to Sleep: "+Thread.currentThread().getName());
		try 
		{
			Thread.sleep(seconds);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		System.out.println("After Sleep: "+Thread.currentThread().getName());
	}
}
	

