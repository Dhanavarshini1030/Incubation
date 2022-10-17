
package runner;

import java.util.InputMismatchException;
import java.util.Scanner;

import tasks.BuilderTask;
import util.CustomException;

public class BuilderRunner 
{
	static Scanner scan=new Scanner(System.in);
	public String getString()
	{
		System.out.println("Enter the String:");
		String term=scan.nextLine();
		return term;
	}
	public String[] getStr(int num)
	{   
		String[] word=new String[num];
		for(int i=0;i<num;i++)
		{
		System.out.println("Enter the String:");
		word[i]=scan.next();
		}
		return word;
	}
	public String getSeparator()
	{
		System.out.println("Enter The Separator: ");
		System.out.println("(Note: For Space, kindly Enter 'space'.)");
		String separator=scan.next();
		String str="space";
		if(separator.equals(str))
		{
			separator=" ";
		}
		return separator;
	}
	
	public void getWordLen(StringBuilder term,int num)
	{
	  System.out.println("The Final String:"+term);
  	  System.out.println("The Length: "+num);
	}

	public static void main(String[] args) 
	{
		   BuilderRunner linkSb=new BuilderRunner();
		   BuilderTask builder=new BuilderTask();
		   int answer;
		   try
		   {
			   do
			   {
			     System.out.println("Enter your Choice(1 to 10):");
			     int option=scan.nextInt();
			     scan.nextLine();
			     switch(option)
			     {
			      case 1:
			         System.out.println("Length of StringBuilder without String.");
			         StringBuilder sb1=builder.getBuilder();
			    	 int len1=builder.getLen(sb1);
			         System.out.println(len1);
			         String term1=linkSb.getString();
			         len1=term1.length();
			         System.out.println("The Final String: "+term1);
			   	     System.out.println("The Length: "+len1);
			         break;
			         
			      case 2:
			    	  String term2=linkSb.getString();
			    	  StringBuilder sb2=builder.getAppend(term2);
			    	  int len2=builder.getLen(sb2);
				      System.out.println("The Length of String: "+len2);
				      System.out.println("Enter the number: ");
			    	  int num=scan.nextInt();
			    	  String[] words=linkSb.getStr(num);
			    	  System.out.println("Enter the Character to Insert: ");
				      String toInsert=scan.next();
				      sb2=builder.getAppendArr(words, sb2, toInsert);
			    	  len2=builder.getLen(sb2);
			    	  System.out.println("The Final String is "+sb2);
			    	  System.out.println("The Length is "+len2);
			    	  break;
			      
			     case 3:
			    	  System.out.println("Enter 2 Strings with Separator");
			    	  String term3=linkSb.getString();
			    	  StringBuilder sb3=builder.getAppend(term3);
			    	  int len3=builder.getLen(sb3);
				      System.out.println("The Length of String: "+len3);
				      String word3=linkSb.getString();
				      String separator=linkSb.getSeparator();
				      StringBuilder result3=builder.getInsert(sb3, word3, separator);
			    	  len3=builder.getLen(result3);
			    	  linkSb.getWordLen(result3, len3);
			    	  break;
			    	  
			      case 4:
			    	  System.out.println("Enter 2 Strings with Separator");
			    	  String term4=linkSb.getString();
			    	  StringBuilder sb4=builder.getAppend(term4);
			    	  int len4=builder.getLen(sb4);
				      System.out.println("The Length of String: "+len4);
				      System.out.println("Enter the Number of String to be Delete: ");
				      int deleteStr=scan.nextInt();
				      String toDelete=linkSb.getSeparator();
				      StringBuilder result4=builder.getDelete(sb4, toDelete, deleteStr);
				      len4=builder.getLen(sb4);
				      linkSb.getWordLen(result4, len4);
				      break;
			    	  
			    case 5:
			    	  System.out.println("Enter 3 Strings with Separator");
			    	  String term5=linkSb.getString();
			    	  StringBuilder sb5=builder.getAppend(term5);
				      int len5=builder.getLen(sb5);
				      System.out.println("The Length of String: "+len5);
				      separator=linkSb.getSeparator();
				      System.out.println("Enter the Character to Insert: ");
				      String replacer=scan.next();
				      StringBuilder result5=builder.getReplace(sb5, separator, replacer);
				      len5=builder.getLen(result5);
				      linkSb.getWordLen(result5, len5);
				      break;
			    	  
				      
			      case 6:
			    	  System.out.println("Enter 3 Strings with Space");
			    	  String term6=linkSb.getString();
			    	  StringBuilder sb6=builder.getAppend(term6);
				      int len6=builder.getLen(sb6);
				      System.out.println("The Length of String: "+len6);
				      StringBuilder result6=builder.getReverse(sb6);
				      len6=builder.getLen(result6);
				      linkSb.getWordLen(result6, len6);
				      break;
			    	  
			      case 7:
			    	  System.out.println("Enter the String within 10 letters");
			    	  String term7=linkSb.getString();
			    	  StringBuilder sb7=builder.getAppend(term7);
				      int len7=builder.getLen(sb7);
				      System.out.println("The Length of String: "+len7);
				      System.out.println("Enter 2 numbers to delete(from and to): ");
			    	  int from=scan.nextInt();
			    	  int to=scan.nextInt();
			    	  StringBuilder result7=builder.getRemoved(sb7, from, to);
			    	  len7=builder.getLen(result7);			    	  
			    	  linkSb.getWordLen(result7, len7);
			    	  break;
			    	  
			      case 8:
			    	  System.out.println("Enter the String within 10 letters");
			    	  String term8=linkSb.getString();
			    	  StringBuilder sb8=builder.getAppend(term8);
				      int len8=builder.getLen(sb8);
				      System.out.println("The Length of String: "+len8);
				      System.out.println("Enter 2 numbers to delete(from and to): ");
			    	  int from1=scan.nextInt();
			    	  int to1=scan.nextInt();
			    	  System.out.println("Enter The String to Replace: ");
			    	  String word8=scan.next();
			    	  StringBuilder result8=builder.getReplaced(word8, sb8, from1, to1);
			    	  len8=builder.getLen(result8);			    	  
			    	  linkSb.getWordLen(result8, len8);
			    	  break;
			    	  
			      case 9:
			    	  System.out.println("Enter 3 Strings with Separator between each strings..");
			    	  String term9=linkSb.getString();
			    	  StringBuilder sb9=builder.getAppend(term9);
				      int len9=builder.getLen(sb9);
				      separator=linkSb.getSeparator();
				      System.out.println("The Length of String: "+len9);
				      int index=builder.getFirstIndex(sb9, separator);
				      System.out.println("The First Index of # is "+index);
				      break;
				      
			      case 10:
			    	  System.out.println("Enter 3 Strings with Separator between each strings..");
			    	  String term=linkSb.getString();
			    	  StringBuilder sb=builder.getAppend(term);
			    	  separator=linkSb.getSeparator();
				      int len=builder.getLen(sb);
				      System.out.println("The Length of String: "+len);
				      int ind=builder.getLastIndex(sb, separator);
				      System.out.println("The Last Index of # is "+ind);
				      break;
			      
			      default:
			    	  System.out.println("Enter The Digits inbetween 1 to 10.");
			     }
			     System.out.println("Do you want to Continue?");
			     System.out.println("Kindly Enter yes(1) or No(2)");
			     answer=scan.nextInt();
			   }while(answer==1);
	}
    catch(CustomException te)
    {
     System.out.println(te.getMessage());     
    }
    catch(InputMismatchException me)
    {
     System.out.println("Kindly Enter The Integer");
    }
	}
}
