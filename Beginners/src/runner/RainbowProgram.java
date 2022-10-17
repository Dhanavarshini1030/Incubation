package runner;

import tasks.Rainbow;

public class RainbowProgram 
{
	public static void main(String[] args)
	{
	 Rainbow colour[]=Rainbow.values();
	 for(Rainbow rain :colour)
	 {
		System.out.println("Color code of "+rain+" is "+rain.getValue());
		System.out.println(rain.ordinal());
   	 }
	}
	
	
	

}
