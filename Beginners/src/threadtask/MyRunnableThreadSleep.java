package threadtask;

public class MyRunnableThreadSleep implements Runnable
{
	public void run()
	{
		System.out.println("Going to Sleep: "+Thread.currentThread().getName());
		try 
		{
			Thread.sleep(15000);
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		System.out.println("After Sleep: "+Thread.currentThread().getName());
	}

}
