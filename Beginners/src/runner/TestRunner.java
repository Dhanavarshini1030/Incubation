package runner;

import java.util.Scanner;

import java.util.InputMismatchException;

import util.Custom;

import tasks.StringTask;

public class TestRunner
{ 
  static Scanner scan= new Scanner(System.in);
  public String getString()
  {
    System.out.println("Enter String:");
    String word=scan.next();
    return word;
  }
  public String getLine()
  {
	System.out.println("Enter A Line: ");
	String line=scan.nextLine();
	String newLine=scan.nextLine();
    return newLine;
  }  
  public static void main(String[] args) 
  {
   String word="";
   if(args.length>0)
   {
    word=args[0];
   }
   else
   {
    System.out.println("Provide any String to Process the Program");
   }
   StringTask task= new StringTask();
   TestRunner linkStr= new TestRunner();
   int answer;
   try
   {
    do
    {
     System.out.println("Enter your Choice(1 to 20):");
     int option=scan.nextInt();
     switch(option)
     {
      case 1:
        
        int length=task.getLength(word);
        System.out.println("The String Length: "+length);
        break;
      case 2:
        System.out.println("...To Find Character Array...");
        String word1=linkStr.getString();
        char character[];
        length=task.getLength(word1);
        character=task.getChar(word1);
        System.out.println("Characters Of The Array: "); 
        for(int i=0;i<length;i++)
        {
	  System.out.println(character[i]);
        }
        break;
      case 3:
        System.out.println("...To Find Penultimate Letter...");
        word1=linkStr.getString();
        length=task.getLength(word1);
        char letter=task.getPenultimateLetter(word1,length);
        System.out.println("Penultimate Letter: "+letter);
        break;
      case 4:
        System.out.println("...To Find Occurance of the Letter...");
        word1=linkStr.getString();
        System.out.println("Enter The Letter to know the Occurance:");
        char letter1= scan.next().charAt(0);
        int count= task.getCount(word1,letter1);
        System.out.println("Occurance: "+count);
        break;
      case 5:
        System.out.println("...To Find GrealinkStr Position...");
        word1=linkStr.getString();
        System.out.println("Enter The Letter to know their GrealinkStr Position:");
        char variable= scan.next().charAt(0);
        int position= task.getPosition(word1,variable);
        System.out.println("The GrealinkStr Position Of this Letter :"+position);
        break;
      case 6:
        System.out.println("...To Print last n Digits...");
        word1=linkStr.getString();
        System.out.println("Enter the number to print last n Digits: ");
        int number=scan.nextInt();
        String last;
        last=task.getSubString(word1,number);
        System.out.println("The Required String is "+last);
        break;
      case 7:
        System.out.println("...To Print first n Digits...");
        word1=linkStr.getString();
        System.out.println("Enter the number to print first n Digits: ");
        int integer=scan.nextInt();
        String first=task.getFirstSet(word1,integer);
        System.out.println("The Required String is "+first);
        break;
      case 8:
        System.out.println("...To Replace Initially...");
        word1=linkStr.getString();
        System.out.println("Enter Letters to replace initially: ");
        String term=scan.next();
        String replace=task.replaceInitially(word1,term);
        System.out.println("After Replacement: "+replace);
        break;
      case 9:
        System.out.println("...Checks Starts...");
        word1=linkStr.getString();
        System.out.println("Enter letters to check whether your string is Starts with this :");
        String start=scan.next();
        boolean result=task.wordStarts(word1,start);
        if (result==true)
        {
          System.out.println("Your String is STARTS with "+start);
        }
        else
        {
          System.out.println("Your String is NOT STARTS with "+start);
        }
        break;
      case 10:
        System.out.println("...Checks Ends...");
        word1=linkStr.getString();
        System.out.println("Enter letters to check whether your string is Ends with this :");
        String end=scan.next();
        boolean outcome=task.wordEnds(word1,end);
        if (outcome==true)
        {
          System.out.println("Your String is ENDS with "+end);
        }
        else
        {
          System.out.println("Your String is NOT ENDS with "+end);
        }
        break;  
      case 11:
        System.out.println("...Converts Uppercase...");
        word1=linkStr.getString();
        String upper=task.getUpper(word1);
        System.out.println("The UpperCase of your String is "+upper);
        break;
      case 12:
        System.out.println("...Converts Lowercase...");
        word1=linkStr.getString();
        String lower=task.getLower(word1);
        System.out.println("The LowerCase of your String is "+lower);
        break;
      case 13:
        System.out.println("...Reverse The String...");
        word1=linkStr.getString();
        String termReverse=task.getReverse(word1);
        System.out.println("The Reverse of the String is "+ termReverse);
        break;
      case 14:
        String line1=linkStr.getLine();
        System.out.println("The Required Line is "+line1);
        break;
      case 15:
        System.out.println("...Sentence without Space...");
        line1=linkStr.getLine();
        String fullLine= task.getFullLine(line1);
        System.out.println("The Required String: "+fullLine);
        break;  
      case 16:
        System.out.println("...To Get String Arrays...");
        line1=linkStr.getLine();
        String[] strToArr= task.getStringArray(line1);
        System.out.println("The String Arrays are ");
        for(String s:strToArr)
        {
         System.out.print(s+" ");
        }
        System.out.println(" ");
        break;
      case 17:
        System.out.println("...Sentence with -...");
        System.out.println("Enter n number to get Strings:");
        int count1=scan.nextInt();
        String[] words= new String[count1];
        for(int i=0;i<count1;i++)
        {
         words[i]=linkStr.getString();
        }
        String wordChain=task.getStringReplace(words);
        System.out.println("The Required Sentence is "+wordChain);
        break;
      case 18:
        System.out.println("...Checks Equal(Case Sensitive)...");
        word1=linkStr.getString();
        System.out.println("Enter Another String: ");
        String phrase2=scan.next();
        boolean outresult= task.checksEqualSensitive(word1,phrase2);
        if (outresult==true)
        {
          System.out.println("Both Strings are Equal. ");
        }
        else
        {
         System.out.println("Both Strings are Not Equal. ");
        }
        break;
      case 19:
        System.out.println("...Checks Equal(Case InSensitive)...");
        word1=linkStr.getString();
        System.out.println("Enter Another String: ");
        String string2=scan.next();
        boolean output= task.checksEqualInSensitive(word1,string2);
        if (output==true)
        {
         System.out.println("Both Strings are Equal. ");
        }
        else
        {
         System.out.println("Both Strings are Not Equal. ");
        }
        break; 
      case 20:
        System.out.println("...Ignore Spaces in Starting and Ending...");
        System.out.println("Enter Line(with spaces on starting or ending or both): ");
    	String sentence3 =linkStr.getLine();
        String trimmedLine=task.getTrimmed(sentence3);
        System.out.println("The Trimmed Line:"+trimmedLine);
        break;
        
        
        
    	  
    	  
      default:
        System.out.println("'Enter the Digits within 1 to 20'");
      }
      System.out.println("Do you want to Continue?");
      System.out.println("Kindly Enter yes(1) or No(2)");
      answer=scan.nextInt();
     }while(answer==1);
    }
    catch(Custom ex)
    {
     System.out.println(ex.getMessage());     
    }
    catch(InputMismatchException me)
    {
     System.out.println("Kindly Enter The Integer");
    }
   }
}

