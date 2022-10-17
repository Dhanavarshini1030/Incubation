package threadtask;

public class MyRunnableThread implements Runnable
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
		System.out.println("Name: "+Thread.currentThread().getName());
		System.out.println("Priority: "+Thread.currentThread().getPriority());
		System.out.println("State: "+Thread.currentThread().getState());*/
		
		
	}
}
