package runner;

import tasks.POJOProgram;

public class SimpleProgramRunner {
//6
	public static void main(String[] args) 
	{
		int num=5;
		String str="Output";
		POJOProgram simple= new POJOProgram(num,str);
		System.out.println(simple);
	}
}
