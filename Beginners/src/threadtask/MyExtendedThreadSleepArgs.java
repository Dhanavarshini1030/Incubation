package threadtask;

public class MyExtendedThreadSleepArgs extends Thread
{
	int seconds;
	public MyExtendedThreadSleepArgs()
	{
		
	}
	public MyExtendedThreadSleepArgs(int time)
	{
		this.seconds=time;
	}
	public void run()
	{
	  System.out.println("Going to Sleep: "+getName());
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
