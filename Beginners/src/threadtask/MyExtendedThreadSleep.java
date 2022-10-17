package threadtask;

public class MyExtendedThreadSleep extends Thread
{
	public void run()
	{
	  System.out.println("Going to Sleep: "+getName());
	  try 
	  {
	    	Thread.sleep(30000);
	  }
	  catch (InterruptedException e) 
	  {
		    e.printStackTrace();
	  }
	  System.out.println("After Sleeping: "+getName());
	}
	
}
