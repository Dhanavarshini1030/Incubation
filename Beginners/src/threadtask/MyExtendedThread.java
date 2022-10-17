package threadtask;

public class MyExtendedThread extends Thread
{
	public void run()
	{
		try 
		  {
		    	Thread.sleep(30000);
		  }
		  catch (InterruptedException e) 
		  {
			    e.printStackTrace();
		  }
		/*System.out.println("After Calling: ");
		System.out.println("Name "+getName());
		System.out.println("Priority "+getPriority());
		System.out.println("State "+getState());*/
		
		
	}
}
