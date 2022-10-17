package runner;

import java.util.Scanner;

import tasks.POJOProgram;

public class POJORunner 
{//7
	Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args)
	{
		POJOProgram program=new POJOProgram();
		POJORunner run=new POJORunner();
		System.out.println("Enter the Integer Value: ");
		int num=run.scan.nextInt();
		System.out.println("Enter the String Value: ");
		String str=run.scan.next();
		program.setNumber(num);
		program.setTerm(str);
		System.out.println("The Integer is "+program.getNumber());
		System.out.println("The String is "+program.getTerm());
		System.out.println(program);
		
		
	}
	
}
