package runner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;

import tasks.RegexMethod;
import util.CustomException;

public class RegexRunner 
{
	Scanner scan=new Scanner(System.in);
	public String[] getString(int count)
	{
		System.out.println("Enter The String: ");
		String[] terms=new String[count];
		for(int i=0;i<count;i++)
		{
		   terms[i]=scan.next();
		}
		return terms;
	}
	public int getCount()
	{
		System.out.println("Enter The Number: ");
		int count=scan.nextInt();
		return count;
	}
	public static void main(String[] args)
	{
		RegexRunner main=new RegexRunner();
		RegexMethod reg=new RegexMethod();
		System.out.println("Enter the Option: ");
		int option=main.scan.nextInt();
		try
		{
		switch(option)
		{
		case 1:
			System.out.println("Enter the number: ");
			String num=main.scan.next();
			System.out.println("The Output is "+reg.mobileNumberCheck(num));
			break;
		
		case 2:
			System.out.println("Enter the String: ");
			String term=main.scan.next();
			System.out.println("The Output is "+reg.alphaNumericMatch(term));
			break;
		case 3:
			System.out.println("Enter the Match String: ");
			String term1=main.scan.next();
			System.out.println("Enter the Input String: ");
			String term2=main.scan.next();
			System.out.println("Enter Your Option: ");
			System.out.println("1-Start, 2-End, 3-Contains, 4-Exact");
			int options=main.scan.nextInt();
			switch(options)
			{
			  case 1:
				  boolean answer=reg.stringMatchStart(term2,term1);
				  if(answer)
				  {
				  System.out.println("It is matched");
				  }
				  else
				  {
					  System.out.println("It is not Matched");
				  }
				  break;
			  case 2:
				  answer=reg.stringMatchEnd(term2,term1);
				  if(answer)
				  {
					  System.out.println("It is Matched");
				  }
				  else
				  {
					  System.out.println("It is not Matched");
				  }
				  break;
			  case 3:
				  Matcher match=reg.stringContains(term1, term2);
					if(match.find())
					{
						System.out.println("It is Match");
					}
					else
					{
						System.out.println("It is Not Match");
					}
					break;
			  case 4:
				  answer=reg.stringExactMatch(term1, term2);
				  if(answer)
				  {
					  System.out.println("It is Matched");
				  }
				  else
				  {
					  System.out.println("It is not Matched");
				  }
				  break;
			  default:
				  System.out.println("Input Invalid");
			}
			break;
		case 4:
			System.out.println("Enter the Match String: ");
			String matchTerm=main.scan.next();
			int count=main.getCount();
			String[] terms=main.getString(count);
			List<String> lists=reg.getAdd(terms, count);
			for(int i =0;i<count;i++)
			{
				String input =lists.get(i);
			    boolean check=reg.listMatch(input, matchTerm);
			    if(!check)
			    {	
			    System.out.println("The String "+input+" is Invalid");
			    }
			}
			break;
		case 5:
			System.out.println("Enter the Mail: ");
			String mail=main.scan.next();
			System.out.println("The Output is "+reg.emailValidation(mail));
			break;
		
		case 6:
			count=main.getCount();
			String[] termString=main.getString(count);
			System.out.println("Enter The range for Starting and Ending:");
			int start=main.scan.nextInt();
			int to=main.scan.nextInt();
			List<String> list=reg.getAdd(termString, count);
			for(int i =0;i<count;i++)
			{
				 String input =list.get(i);
				 boolean check = reg.listCheck(input,start,to);
				 if(!check)
				 {
				   System.out.println("The String "+input+" is Out Of Range");
				 }
			}
			break;
		case 7:
			System.out.println("For List 1");
			int count1=main.getCount();
		    termString=main.getString(count1);
		    List<String> list1=reg.getAdd(termString, count1);
		    System.out.println("For List 2");
			int count2=main.getCount();
		    termString=main.getString(count2);
		    List<String> list2=reg.getAdd(termString, count2);
		    Map<String,Integer> map=new HashMap<String,Integer>();
			for(int i=0;i<count1;i++)
			{
				String word1=list1.get(i);
				for(int j=0;j<count2;j++)
				{
					String word2=list2.get(j);
					boolean checkMatch=reg.stringExactMatch(word1, word2);
					if(checkMatch)
					{
						map=reg.getAddMap(map, word2, i);
					}
				}
			}
			System.out.println("The Result is "+map);
			break;
		case 8:
			main.scan.nextLine();
			System.out.println("Enter The Line with HTML tags:");
			String line=main.scan.nextLine();
			Matcher match=reg.getTags(line);
			//System.out.println(match);
			while(match.find())
			{
				System.out.println(match.group());
			}
			break;
		default: 
			System.out.println("Enter Within 8");	
		}
		}
		catch(CustomException ce)
		{
			System.out.println("The Value is verified as Null");
		}
		
		
		
	}
	
}
