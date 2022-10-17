package runner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import tasks.ProgramTask;
import util.CustomException;

public class FileAndDirectory 
{
	Scanner scan= new Scanner(System.in);
	Logger logg=Logger.getLogger("");
	
	public String[] getTerm(int num)
	{
		System.out.println("Enter The Lines: ");
		String[] term=new String[num];
		for(int i=0;i<num;i++)
		{
			term[i]=scan.nextLine();
		}
		return term;
	}
	
	/*public String[] getZone(int num)
	{
		String[] zone=new String[num];
		for(int i=0;i<num+1;i++)
		{
		System.out.println("Enter The Zone: ");
        zone[i]=scan.nextLine();
		}
    	return zone;
	}*/
	
	public Properties addKeyValue(Properties prop,int num)
	{
		for(int i=0;i<num;i++)
  	    {
  	      System.out.println("Enter key(String) and value(String):");
		  String key=scan.next();
		  String value=scan.next();
		  prop.setProperty(key, value);		  
  	    }
		return prop;
	}
	
	public int getNumber()
	{
		 System.out.println("Enter Number: ");
		 int num=scan.nextInt();
		  return num; 
	}
	
	public static void main(String[] args) 
	{
		ProgramTask program=new ProgramTask("Hai");
		FileAndDirectory link=new FileAndDirectory();
		int answer;
		BufferedWriter writer = null;
		FileWriter myFile= null;
		try
		{
		 do
	     {
		   System.out.println("Enter your Choice:");
		   int option=link.scan.nextInt();
		   switch(option)
		   {
		    case 1:
		    	System.out.println("Enter File Name to be created(with .txt): ");
		    	String name=link.scan.next();
		    	int num=link.getNumber();
				link.scan.nextLine();
				String[] term=link.getTerm(num);
			    writer=program.getWriteFile(name,term);
				System.out.println("File Created");
				break;
			   
		    case 2:
		    	System.out.println("Enter Property File Name to be created(with .txt): ");
		    	name=link.scan.next();
		    	Properties prop=program.getProperty();
			    num=link.getNumber();
			    prop=link.addKeyValue(prop, num);
			    program.getFileProperty(name, prop);
			    break;
		    case 3:
		        System.out.println("Enter Property File Name to be loaded(with .txt): ");
		    	name=link.scan.next();
		    	Properties newProp=program.getNewProperty(name);
		    	System.out.println(newProp);
		    	break;
		    case 4:
		    	System.out.println("Enter 1 for Files and 2 for Properties:");
		    	int opt=link.scan.nextInt();
		    	if(opt==1)
		    	{
		    	System.out.println("Enter Directory: ");
		    	String dirName=link.scan.next();
		    	System.out.println("Enter FileName: ");
		    	String fileName=link.scan.next();
		    	num=link.getNumber();
				link.scan.nextLine();
				term=link.getTerm(num);
				boolean create=program.createDirectory(dirName);
				String directoryName=dirName+"/"+fileName;
				writer=program.getWriteFile(directoryName, term);
				}
		    	else
		    	{
				System.out.println("Enter Directory with Property FileName: ");
		        String fileName1=link.scan.next();
		        System.out.println("Enter Property FileName: ");
		    	String propFileName=link.scan.next();
		    	Properties prop1=program.getProperty();
			    num=link.getNumber();
			    prop1=link.addKeyValue(prop1, num);
			    boolean myFile1=program.createDirectory(fileName1);
			    String properFileName=fileName1+"/"+ propFileName;
			    if(myFile1)
				{
			     program.getFileProperty(properFileName, prop1);
				}
			    System.out.println("Enter Directory with Property FileName: ");
		        String propName1=link.scan.next();
		        System.out.println("Enter Property FileName: ");
		    	String propertyFileName=link.scan.next();
		    	String propertyReadFile=propName1+"/"+ propertyFileName;
			    
		    	Properties newProp1=program.getNewProperty(propertyReadFile);
		    	System.out.println(newProp1);
		    	}
		    	break;
		    case 5:
		    	System.out.println(program);//swami resolved
		    	break;
		   /*7 case 9:
		    	Rainbow clr[]=Rainbow.values();
		    	for(Rainbow r:clr)
		    	{
		    		System.out.println("Color code of "+r+" is "+r.value);
		    	}
		    	break;
		   /*case 10://singleton
			   SingletonProgram instance=single.getInstance();
			   
			   
			   
			   /*ProgramTask instance=program.getObj();
			   instance.setNumber(5);
			   System.out.println(instance.getNumber());
			   ProgramTask instance2=program.getObj();
			  System.out.println(instance.hashCode());
			   System.out.println(instance2.hashCode());
			   System.out.println(program.hashCode());
			   System.out.println(instance2.getNumber());*/
			   // break;  
		   case 11:
		    	System.out.println("Date and Time: "+program.getTime());
		    	System.out.println("The MilliSeconds: "+program.getMilliSeconds());
		    	//int count=link.getNumber();
		    	//String[] zone=link.getZone(count);
		    	System.out.println("Enter The Zone: ");
		        String zone=link.scan.next();
				System.out.println("The Zone Time is "+program.getZoneID(zone));
				System.out.println("Enter Your Choice whether current date(1) or Zone Time(2): ");
		        int choice=link.scan.nextInt();
		        if(choice==1)
		        {
		        	System.out.println("The month "+program.getMonthName());
			    	System.out.println("The Weekday "+program.getWeek());
			    	System.out.println("The Year "+program.getYear());
			    }
		        else
		        {
		        	System.out.println("The month "+program.getZonedMonth(zone));
			    	System.out.println("The Weekday "+program.getZonedWeek(zone));
			    	System.out.println("The Year "+program.getZonedYear(zone));
			    }
		    	break;
		   case 12:
			   // link.logg.log(Level.INFO,"Date and Time: "+program.getDate());
			    link.logg.info("Print Using Logger."); 
			    link.logg.log(Level.INFO,"The MilliSeconds: "+program.getMilliSeconds());
			    link.logg.log(Level.INFO,"The month "+program.getMonthName());
			    link.logg.log(Level.INFO,"The Weekday "+program.getWeek());
			    link.logg.log(Level.INFO,"The Year "+program.getYear());
			    break;
				
		   default:
		    	  System.out.println("Invalid");
		     }
		     System.out.println("Do you want to Continue?");
		     System.out.println("Kindly Enter yes(1) or No(2)");
		     answer=link.scan.nextInt();
		   }while(answer==1);
		}
		catch(CustomException ce)
		{
			System.out.println("The Value is Null");
		}
		catch(DateTimeException dt)
		{
			System.out.println("Check your Input");
		}
		catch(InputMismatchException in)
		{
			link.logg.log(Level.WARNING,"invalid", in);
			//System.out.println("Kindly Enter The Value in Correct Datatype");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				writer.close();
				myFile.close();
				//myRead.close();
			}
			catch (IOException e) 
			{
			    link.logg.log(Level.WARNING,"Resource", e);
			}
		}
	}

}
