package runner;

import java.util.InputMismatchException;

import java.util.Iterator;

import java.util.List;

import java.util.Scanner;

import tasks.ListTask;

import util.Custom;

public class ListRunner
{
	Scanner scan=new Scanner(System.in);
	public String[] getString(int num) 
	{
	System.out.println("Enter the values: ");
	String[] str=new String[num];
	for(int i=0;i<num;i++)
	{
		str[i]=scan.next();
	}
	return str;
	}
	
	public int[] getNumArr(int num) 
	{
	System.out.println("Enter the values: ");
	int[] str=new int[num];
	for(int i=0;i<num;i++)
	{
		str[i]=scan.nextInt();
	}
	return str;
	}
	
	public float[] getFloatArr(int num) 
	{
	System.out.println("Enter the values: ");
	float[] str=new float[num];
	for(int i=0;i<num;i++)
	{
		str[i]=scan.nextFloat();
	}
	return str;
	}
	
	public Object[] getObjArr(Object obj, Object obj2) 
	{
	Object[] str=new Object[2];
	str[0]=obj;
	str[1]=obj2;
	return str;
	}
	
	public Object[] getObject(int num)
	{
		Object[] str=new Object[num];
		System.out.println("Enter the values: ");
		
		for(int i=0;i<num;i++)
		{
			str[i]=scan.next();
		}
		return str;
		
	}
	
	public long[] getLongArr(int num) 
	{
	System.out.println("Enter the values: ");
	long[] str=new long[num];
	for(int i=0;i<num;i++)
	{
		str[i]=scan.nextLong();
	}
	return str;
	}
		
	public <T> void getArrLen(List<T> term,int num)
	{
	  System.out.println("The Final String:"+term);
  	  System.out.println("The Length: "+num);
	}

	public static <T> void main(String[] args) 
	{
		ListTask task=new ListTask();
		ListRunner linkArr=new ListRunner();
		int answer;
		   try
		   {
			   do
			   {
			     System.out.println("Enter your Choice(1 to 20):");
			     int option=linkArr.scan.nextInt();
			     switch(option)
			     {
			      case 1:
			    	  List<T> list=task.getArrayList();
			    	  int len=task.getLength(list);
			    	  System.out.println("The Length of ArrayList is "+len);
			    	  break;
			      case 2:
			    	  System.out.println("Enter the number: ");
			    	  int num=linkArr.scan.nextInt();
			    	  String[] str=linkArr.getString(num);
			    	  List<String> list2=task.getArrayList();
			    	  list2=task.getArrayList();
			    	  list2=task.getAdd(str, num, list2);
			    	  len=task.getLength(list2);
			    	  linkArr.getArrLen(list2, len);
			    	  break;
			      case 3:
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  int[] num3=linkArr.getNumArr(num);
			    	  List<Integer> list3=task.getArrayList();
			    	  list3=task.getArrayList();
			    	  list3=task.getAddNum(num3, num, list3);
			    	  len=task.getLength(list3);
			    	  linkArr.getArrLen(list3, len);
			    	  break;	
			      case 4:
			    	  List<Object> list4=task.getArrayList();
			    	  ListTask task1=new ListTask();
			    	  list4=task.getObject(task1, list4);
			    	  System.out.println("The Custom Object is "+list4);
			    	  break;
			    	  
			     case 5:
			    	  List<Object> list5=task.getArrayList();
			    	  System.out.println("Enter the number to String: ");
			    	  num=linkArr.scan.nextInt();
			    	  Object[] str5=linkArr.getObject(num);
			    	  list5=task.getAll(list5,str5, num);
			    	  System.out.println("Enter the number to Integer: ");
			    	  num=linkArr.scan.nextInt();
			    	  Object[] num5=linkArr.getObject(num);
			    	  list5= task.getAll(list5, num5, num);
			    	  Object[] obj=linkArr.getObjArr(task, linkArr);
			    	  list5=task.getAll(list5, obj,2);
			    	  len=task.getLength(list5);
			    	  linkArr.getArrLen(list5, len);
			    	  break;
			    	 
			    	  
			      case 6:
			    	  List<String> list6=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  str=linkArr.getString(num);
			    	  list6=task.getArrayList();
			    	  list6=task.getAdd(str, num, list6);
			    	  System.out.println("Enter The String to find their Index: ");
			    	  String search=linkArr.scan.next();
			    	  int index=task.getStrIndex(search, list6);
			    	  System.out.println("The Index of the Respective String is "+index);
			    	  len=task.getLength(list6);
			    	  linkArr.getArrLen(list6, len);
			    	  break;	
			    	  
			      case 7:
			    	  List<String> list7=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  str=linkArr.getString(num);
			    	  list7=task.getArrayList();
			    	  list7=task.getAdd(str, num, list7);
			    	  len=task.getLength(list7);
			    	  linkArr.getArrLen(list7, len);
			    	  Iterator<String> iterat=task.getIterator(list7);
			    	  System.out.println("Listing using Iterator");
			    	  for(int i=0;i<len;i++)
			    	  {
			    		  System.out.println(iterat.next());
			    	  }
			    	  break;
			    	  
			      case 8:
			    	  List<String> list8=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  str=linkArr.getString(num);
			    	  list8=task.getArrayList();
			    	  list8=task.getAdd(str, num, list8);
			    	  System.out.println("Enter The Index to find String: ");
			    	  index=linkArr.scan.nextInt();
			    	  search=task.getIndexStr(list8, index);
			    	  System.out.println("The Required String is "+search);
			    	  len=task.getLength(list8);
			    	  linkArr.getArrLen(list8, len);
			    	  break;
			    	  
			      case 9:
			    	  List<String> list9=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  System.out.println("Enter the Strings with Duplicates.");
			    	  str=linkArr.getString(num);
			    	  list9=task.getArrayList();
			    	  list9=task.getAdd(str, num, list9);
			    	  System.out.println("Enter the String to find First and Last Index:");
			    	  search=linkArr.scan.next();
			    	  int firstIndex=task.getFirstIndex(list9, search);
			    	  int lastIndex=task.getLastIndex(list9, search);
			    	  System.out.println("The First Index of "+search+" is "+firstIndex);
			    	  System.out.println("The Last Index of "+search+" is "+lastIndex);
			    	  len=task.getLength(list9);
			    	  linkArr.getArrLen(list9, len);
			    	  break;
			    	 
			      case 10:
			    	  List<String> texts=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  str=linkArr.getString(num);
			    	  texts=task.getArrayList();
			    	  texts=task.getAdd(str, num, texts);
			    	  System.out.println("Enter The Index to Add: ");
			    	  index=linkArr.scan.nextInt();
			    	  System.out.println("Enter the String: ");
			    	  String word=linkArr.scan.next();
			    	  texts=task.getAddStr(word, index, texts);
			    	  System.out.println("The List after Adding.");
			    	  len=task.getLength(texts);
			    	  linkArr.getArrLen(texts, len);
			    	  break;
			    	  
			      case 11:
			    	  List<String> text1=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  str=linkArr.getString(num);
			    	  text1=task.getArrayList();
			    	  text1=task.getAdd(str, num, text1);
			    	  List<String> newText1=task.getArrayList();
			    	  System.out.println("Enter the Starting Index: ");
			    	  int from=linkArr.scan.nextInt();
			    	  System.out.println("Enter the Ending Index: ");
			    	  int to=linkArr.scan.nextInt();
			    	  newText1=task.getSubList(text1, newText1, from, to);
			    	  System.out.println("The New List is "+newText1);
			    	  System.out.println("The Length of New List is "+task.getLength(newText1));
			    	  len=task.getLength(text1);
			    	  linkArr.getArrLen(text1, len);
			    	  break;
			    	  
			      case 12:
			    	  List<String> text2=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  str=linkArr.getString(num);
			    	  text2=task.getArrayList();
			    	  text2=task.getAdd(str, num, text2);
			    	  System.out.println("Second Array List:");
			    	  List<String> newText2=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  int num1=linkArr.scan.nextInt();
			    	  String[] str1=linkArr.getString(num1);
			    	  newText2=task.getArrayList();
			    	  newText2=task.getAdd(str1, num1, newText2);
			    	  List<String> newText3=task.getArrayList();
			    	  newText3=task.getCombinedList(text2, newText2, newText3);
			    	  System.out.println("The First List is "+text2);
			    	  System.out.println("The Length of First List is "+num);
			    	  System.out.println("The Second List is "+newText2);
			    	  System.out.println("The Length of Second List is "+num1);
			    	  System.out.println("The New List is "+newText3);
			    	  System.out.println("The Length of New List is "+task.getLength(newText3));
			    	  break;
			    
			      case 13:
			    	  List<String> text3=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  str=linkArr.getString(num);
			    	  text3=task.getArrayList();
			    	  text3=task.getAdd(str, num, text3);
			    	  System.out.println("Second Array List:");
			    	  newText3=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num1=linkArr.scan.nextInt();
			    	  str1=linkArr.getString(num1);
			    	  newText2=task.getArrayList();
			    	  newText2=task.getAdd(str1, num1, newText2);
			    	  newText3=task.getArrayList();
			    	  newText3=task.getCombinedList2(text3, newText2, newText3);
			    	  System.out.println("The First List is "+text3);
			    	  System.out.println("The Length of First List is "+num);
			    	  System.out.println("The Second List is "+newText2);
			    	  System.out.println("The Length of Second List is "+num1);
			    	  System.out.println("The New List is "+newText3);
			    	  System.out.println("The Length of New List is "+task.getLength(newText3));
			    	  break;
			    
			      case 14:
			    	  List<Float> text4=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  float[] array=linkArr.getFloatArr(num);
			    	  text4=task.getArrayList();
			    	  text4=task.getAddFloat(array, num, text4);
			    	  System.out.println("Enter The Value to be Removed: ");
			    	  float value=linkArr.scan.nextFloat();
			    	  text4=task.getRemoved(text4, value);
			    	  len=task.getLength(text4);
			    	  linkArr.getArrLen(text4, len);
			    	  break;
			    	  
			      case 15:
			    	  List<Float> text5=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  array=linkArr.getFloatArr(num);
			    	  text5=task.getArrayList();
			    	  text5=task.getAddFloat(array, num, text5);
			    	  System.out.println("Enter The Index to be Removed: ");
			    	  int value1=linkArr.scan.nextInt();
			    	  text4=task.getRemoveIndex(text5, value1);
			    	  len=task.getLength(text5);
			    	  linkArr.getArrLen(text5, len);
			    	  break;
			      
			     case 16:
			    	  List<Long> text6=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  long[] array6=linkArr.getLongArr(num);
			    	  text6=task.getArrayList();
			    	  text6=task.getAddLong(array6, num, text6);
			    	  len=task.getLength(text6);
			    	  linkArr.getArrLen(text6, len);
			    	  System.out.println("Enter Index to Delete from ");
			    	  int from6=linkArr.scan.nextInt();
			    	  System.out.println("Enter Index to Delete to ");
			    	  int to6=linkArr.scan.nextInt();
			    	  text6=task.getRemoveList(text6, from6, to6);
			    	  len=task.getLength(text6);
			    	  linkArr.getArrLen(text6, len);
			    	  break;
			        
			     case 17:
			    	  List<String> text7=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  String[] array2=linkArr.getString(num);
			    	  text7=task.getArrayList();
			    	  text7=task.getAdd(array2, num, text7);
			    	  List<String> newText7=task.getArrayList();
			    	  System.out.println("List2");
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  String[] array7=linkArr.getString(num);
			    	  newText7=task.getArrayList();
			    	  newText7=task.getAdd(array7, num, newText7);
			    	  newText7=task.getDifferent(text7, newText7);
			    	  System.out.println("Remove the element which are in list2: "+newText7);
			    	  System.out.println("Size "+task.getLength(newText7));
			    	  break;
			    	
			    	 
			     case 18:
			    	  List<String> text8=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  String[] array1=linkArr.getString(num);
			    	  text8=task.getArrayList();
			    	  text8=task.getAdd(array1, num, text8);
			    	  List<String> newText8=task.getArrayList();
			    	  System.out.println("List2");
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  String[] array8=linkArr.getString(num);
			    	  newText8=task.getArrayList();
			    	  newText8=task.getAdd(array8, num, newText8);
			    	  newText8=task.getIntersect(text8, newText8);
			    	  System.out.println("Remove the element which are not in list2: "+newText8);
			    	  System.out.println("Size "+task.getLength(newText8));
			    	  break;
			    	
			      case 19:
			    	  List<Long> text9=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  long[] array9=linkArr.getLongArr(num);
			    	  text9=task.getArrayList();
			    	  text9=task.getAddLong(array9, num, text9);
			    	  len=task.getLength(text9);
			    	  linkArr.getArrLen(text9, len);
			    	  text9=task.getRemoveAll(text9);
			    	  System.out.println("After Remove all Values");
			    	  System.out.println("The Result List is "+text9);
			    	  System.out.println("The Size of Result List is "+task.getLength(text9));
			    	  break;
			    	  
			      case 20:
			    	  List<String> listArr=task.getArrayList();
			    	  System.out.println("Enter the number: ");
			    	  num=linkArr.scan.nextInt();
			    	  str=linkArr.getString(num);
			    	  listArr=task.getArrayList();
			    	  listArr=task.getAdd(str, num, listArr);
			    	  System.out.println("Enter the String to Check: ");
			    	  String check=linkArr.scan.next();
			    	  boolean ans=task.getChecked(listArr, check);
			    	  if(ans)
			    	  {
			    		  System.out.println("The Given String is present in this ArrayList"); 
			    	  }
			    	  else
			    	  {
			    		  System.out.println("The Given String is not present in this ArrayList");
			    	  }
			    	  len=task.getLength(listArr);
			    	  linkArr.getArrLen(listArr, len);
			    	  break;
			    	 
			    /*  case 100:
			    	  //List<String> list5 = task.getAdd(null, num1, text8);
			    	  task.getAdd(null, 0, null);
			    	  task.getIndexStr(null, 0);*/
			      default:
			    	  System.out.println("Enter The Digits inbetween 1 to 20.");
			     }
			     System.out.println("Do you want to Continue?");
			     System.out.println("Kindly Enter yes(1) or No(2)");
			     answer=linkArr.scan.nextInt();
			   }while(answer==1);
	}
    catch(Custom te)
    {
     System.out.println(te.getMessage());     
    }
    catch(InputMismatchException me)
    {
     System.out.println("Kindly Enter Value in Correct Type");
    }
	}
}

			     
		
		
	
