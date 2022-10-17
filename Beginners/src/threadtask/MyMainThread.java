package threadtask;

import java.util.Scanner;

public class MyMainThread {

	Scanner scan=new Scanner(System.in);
	public void getThreadValue(String str,Thread obj)
	{
		System.out.println(str);
		System.out.println("Name: "+obj.getName());
		System.out.println("Priority: "+obj.getPriority());
		System.out.println("State: "+obj.getState());
	}
	public String[] getThreadNames(int num)
	{
		String[] threadName=new String[num];
		for(int i=0;i<num;i++)
		{
			System.out.println("Enter The Thread Name"+i+":");
		    threadName[i]=scan.next();
		}
		return threadName;
	}
	public void startThread(Thread obj,String threadName)
	{
		obj.setName(threadName);
		obj.start();
	}
	
	public int getSeconds()
	{
		System.out.println("Enter MilliSeconds to Sleep: ");
		int time=scan.nextInt();
		return time;
	}
	public static void main(String[] args) 
	{
		MyMainThread main=new MyMainThread();
		System.out.println("Enter the Option: ");
		int option=main.scan.nextInt();
		switch(option)
		{
		case 1:
			MyExtendedThread threadObj=new MyExtendedThread();
			String before="Before Calling";
			main.getThreadValue(before,threadObj);
			threadObj.start();
			String after="After Calling";
			main.getThreadValue(after,threadObj);
			break;
		case 2:
			MyRunnableThread obj= new MyRunnableThread();
			Thread runObj=new Thread(obj);
		    before="Before Calling";
			main.getThreadValue(before,runObj);
			runObj.start();
			after="After Calling";
			main.getThreadValue(after,runObj);
			break;
		case 3:
			MyExtendedThread extendedThread=new MyExtendedThread();
			before="Before calling Extended Thread: ";
			main.getThreadValue(before,extendedThread);
			extendedThread.setName("Extended Thread");
			extendedThread.start();
			after="After Calling";
			main.getThreadValue(after,extendedThread);
			MyRunnableThread runnable=new MyRunnableThread();
			Thread runnableThread=new Thread(runnable);
			before="Before calling Runnable Thread: ";
			main.getThreadValue(before,runnableThread);
			runnableThread.setName("Runnable Thread");
			runnableThread.start();
			after="After Calling";
			main.getThreadValue(after,runnableThread);
			break;
			
		case 4:
			MyExtendedThreadSleep threadObject1=new MyExtendedThreadSleep();
			MyExtendedThreadSleep threadObject2=new MyExtendedThreadSleep();
			MyExtendedThreadSleep threadObject3=new MyExtendedThreadSleep();
			
			MyRunnableThreadSleep runnableObj1=new MyRunnableThreadSleep();
			Thread runnableThreadObj1=new Thread(runnableObj1);
			MyRunnableThreadSleep runnableObj2=new MyRunnableThreadSleep();
			Thread runnableThreadObj2=new Thread(runnableObj2);
			MyRunnableThreadSleep runnableObj3=new MyRunnableThreadSleep();
			Thread runnableThreadObj3=new Thread(runnableObj3);
			
			Thread[] threads={threadObject1,threadObject2,threadObject3};
			Thread[] runnableThreads={runnableThreadObj1,runnableThreadObj2,runnableThreadObj3};
			
			String[] threadName=main.getThreadNames(3);
			String[] runThreadName=main.getThreadNames(3);
			
			for(int i=0;i<3;i++)
			{
				main.startThread(threads[i],threadName[i]);
			}
			
			for(int i=0;i<3;i++)
			{
				main.startThread(runnableThreads[i],runThreadName[i]);
			}
			break;
		
		case 5:
			System.out.println("Enter Seconds for Thread: ");
			MyExtendedThreadSleepArgs threadObj1=new MyExtendedThreadSleepArgs (main.getSeconds());
			MyExtendedThreadSleepArgs  threadObj2=new MyExtendedThreadSleepArgs (main.getSeconds());
			MyExtendedThreadSleepArgs  threadObj3=new MyExtendedThreadSleepArgs (main.getSeconds());
		
			System.out.println("Enter Seconds for Runnable: ");
			MyRunnableThreadSleepArgs runnable1=new MyRunnableThreadSleepArgs(main.getSeconds());
			Thread runnableThread1=new Thread(runnable1);
			MyRunnableThreadSleepArgs runnable2=new MyRunnableThreadSleepArgs(main.getSeconds());
			Thread runnableThread2=new Thread(runnable2);
			MyRunnableThreadSleepArgs runnable3=new MyRunnableThreadSleepArgs(main.getSeconds());
			Thread runnableThread3=new Thread(runnable3);
			
			Thread[] threadSleep={threadObj1,threadObj2,threadObj3};
			Thread[] runnableThreadSleep={runnableThread1,runnableThread2,runnableThread3};
			
			String[] threadNameSleep=main.getThreadNames(3);
			String[] runThreadNameSleep=main.getThreadNames(3);
			
			for(int i=0;i<3;i++)
			{
				main.startThread(threadSleep[i],threadNameSleep[i]);
			}
			
			for(int i=0;i<3;i++)
			{
				main.startThread(runnableThreadSleep[i],runThreadNameSleep[i]);
			}
			
			break;
		
		case 6:
			MyExtendedThreadDump threadDump1=new MyExtendedThreadDump (main.getSeconds());
			MyExtendedThreadDump threadDump2=new MyExtendedThreadDump (main.getSeconds());
			MyExtendedThreadDump threadDump3=new MyExtendedThreadDump (main.getSeconds());
			
			MyRunnableThreadDump runnableDump1=new MyRunnableThreadDump(main.getSeconds());
			Thread runnableThreadDump1=new Thread(runnableDump1);
			MyRunnableThreadDump runnableDump2=new MyRunnableThreadDump(main.getSeconds());
			Thread runnableThreadDump2=new Thread(runnableDump2);
			MyRunnableThreadDump runnableDump3=new MyRunnableThreadDump(main.getSeconds());
			Thread runnableThreadDump3=new Thread(runnableDump3);
			
			Thread[] threadDump={threadDump1,threadDump2,threadDump3};
			Thread[] runnableThreadDump={runnableThreadDump1,runnableThreadDump2,runnableThreadDump3};
			
			String[] threadNameDump=main.getThreadNames(3);
			String[] runThreadNameDump=main.getThreadNames(3);
			
			threadDump1.setVariable(true);
			threadDump2.setVariable(true);
			threadDump3.setVariable(true);
			
			runnableDump1.setVariable(true);
			runnableDump2.setVariable(true);
			runnableDump3.setVariable(true);
			
			for(int i=0;i<3;i++)
			{
				main.startThread(threadDump[i],threadNameDump[i]);
			}
			
			for(int i=0;i<3;i++)
			{
				main.startThread(runnableThreadDump[i],runThreadNameDump[i]);
			}
			break;
			
		case 7:
			System.out.println("For Threads: ");
			MyExtendedThreadDump threadDump4=new MyExtendedThreadDump (main.getSeconds());
			MyExtendedThreadDump threadDump5=new MyExtendedThreadDump (main.getSeconds());
			MyExtendedThreadDump threadDump6=new MyExtendedThreadDump (main.getSeconds());
			
			System.out.println("For Runnable Threads: ");
			MyRunnableThreadDump runnableDump4=new MyRunnableThreadDump(main.getSeconds());
			Thread runnableThreadDump4=new Thread(runnableDump4);
			MyRunnableThreadDump runnableDump5=new MyRunnableThreadDump(main.getSeconds());
			Thread runnableThreadDump5=new Thread(runnableDump5);
			MyRunnableThreadDump runnableDump6=new MyRunnableThreadDump(main.getSeconds());
			Thread runnableThreadDump6=new Thread(runnableDump6);
			
			Thread[] threadDumps={threadDump4,threadDump5,threadDump6};
			Thread[] runnableThreadDumps={runnableThreadDump4,runnableThreadDump5,runnableThreadDump6};
			
			String[] threadNameDumps=main.getThreadNames(3);
			String[] runThreadNameDumps=main.getThreadNames(3);
		
			threadDump4.setVariable(true);
			threadDump5.setVariable(true);
			threadDump6.setVariable(true);
			
			runnableDump4.setVariable(true);
			runnableDump5.setVariable(true);
			runnableDump6.setVariable(true);
			
			for(int i=0;i<3;i++)
			{
				main.startThread(threadDumps[i],threadNameDumps[i]);
			}
			
			for(int i=0;i<3;i++)
			{
				main.startThread(runnableThreadDumps[i],runThreadNameDumps[i]);
			}
			try 
			{
				Thread.sleep(15000);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			threadDump4.setVariable(false);
			threadDump5.setVariable(false);
			threadDump6.setVariable(false);
			
			try 
			{
				Thread.sleep(150);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			runnableDump4.setVariable(false);
			runnableDump5.setVariable(false);
			runnableDump6.setVariable(false);
			
			System.out.println(threadDump4.isAlive());
			System.out.println(threadDump5.isAlive());
			System.out.println(threadDump6.isAlive());
			System.out.println(runnableThreadDump4.isAlive());
			System.out.println(runnableThreadDump5.isAlive());
			System.out.println(runnableThreadDump6.isAlive());
			
			System.out.println("Task Completed");
			
			break;
			}
	}

}
