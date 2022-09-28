package runner;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import util.CustomException;
import tasks.HashTask;

public class HashRunner 
{
	Scanner scan=new Scanner(System.in);
	public int getNum()
	{
		System.out.println("Enter Number: ");
		int num=scan.nextInt();
		return num;
	}
	
	
	public Map<String,String> getAddStr(Map<String,String> map,int num)
	{
		for(int i=0;i<num;i++)
  	    {
  	      System.out.println("Enter key(String) and value(String):");
		  String key=scan.next();
		  String value=scan.next();
		  map.put(key, value);
  	    }
		return map;
	}
	
	public Map<Integer,Integer> getAddInt(Map<Integer,Integer> map,int num)
	{
		for(int i=0;i<num;i++)
  	    {
  	      System.out.println("Enter key(Integer) and value(Integer):");
		  Integer key=scan.nextInt();
		  Integer value=scan.nextInt();
		  map.put(key, value);
		  System.out.println(" 	");
  	    }
		return map;
	}
	
	public Map<String,Integer> getAddStrInt(Map<String,Integer> map,int num)
	{
		for(int i=0;i<num;i++)
  	    {
		  System.out.println("Enter key(String) and value(Integer):");
		  String key=scan.next();
	   	  Integer value=scan.nextInt();
		  map.put(key, value);
		  System.out.println(" 	");
  	    }
		return map;
	}
	
	public <K,V> Map<K,V> getAddKV(Map<K,V> map,int num)
	{
		for(int i=0;i<num;i++)
  	    {
  	      System.out.println("Enter key and value:");
		  K key=(K) scan.next();
		  V value=(V) scan.next();
		  map.put(key, value);
		  System.out.println(" 	");
  	    }
		return map;
	}
	
	public Map<String,Object> getAddObj(Map<String,Object> map, int num)
	{
		HashTask taskHash=new HashTask();
		for(int i=0;i<num;i++)
		{
		  System.out.println("Enter key and value:");
		  String key=scan.next();
		  map.put(key,taskHash);
		  System.out.println(" 	");
	  	}	
		return map;
	}
	
	public <K,V> void getHashLen(Map<K, V> hash, int len)
	{
		System.out.println("The Size of the HashMap is "+len);
  	    System.out.println("The HashMap is "+hash);
  	}

	public static <K,V> void main(String[] args) 
	{
		HashTask taskHash=new HashTask();
		HashRunner linkHash=new HashRunner();
		int answer;
		   try
		   {
			   do
			   {
			     System.out.println("Enter your Choice(1 to 20):");
			     int option=linkHash.scan.nextInt();
			     switch(option)
			     {
			      case 1:
			    	  Map<K,V> hash=taskHash.getHashMap();
			    	  int len=taskHash.getSize(hash);
			    	  linkHash.getHashLen(hash, len);
			    	  break;
			    	  
			      case 2:
			    	  Map<String, String> hash2=taskHash.getHashMap();
			    	  int num=linkHash.getNum();
			    	  hash2=linkHash.getAddStr(hash2, num);
			    	  len=taskHash.getSize(hash2);
			    	  linkHash.getHashLen(hash2, len);
			    	  break;
			    	
			      case 3:
			    	  Map<Integer, Integer> hash3=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  hash3=linkHash.getAddInt(hash3, num);
			    	  len=taskHash.getSize(hash3);
			    	  linkHash.getHashLen(hash3, len);
			    	  break;
			    	  
			      case 4:
			    	  Map<String, Integer> hash4=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  hash4=linkHash.getAddStrInt(hash4, num);
				      len=taskHash.getSize(hash4);
			    	  linkHash.getHashLen(hash4, len);
			    	  break;
			    	  
			      case 5:
			    	  Map<String, Object> hash5=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  hash5=linkHash.getAddObj(hash5, num);
			    	  len=taskHash.getSize(hash5);
			    	  linkHash.getHashLen(hash5, len);
			    	  break;
			    	
			      case 6:
			    	  Map<String, String> hash6=taskHash.getHashMap();
			    	  System.out.println("Enter Key and Value: ");
			    	  String key=linkHash.scan.next();
			    	  String value=linkHash.scan.next();
			    	    hash6.put(key,value);
			    	  System.out.println("Enter Key: ");
			    	  key=linkHash.scan.next();
			    	  value=null;
			    	    hash6.put(key,value);
			    	  System.out.println("Enter Key and Value: ");
				      key=linkHash.scan.next();
			    	  value=linkHash.scan.next();
			    	    hash6.put(key,value);
			    	  len=taskHash.getSize(hash6);
			    	  linkHash.getHashLen(hash6, len);
			    	  break;
			    	  
			     case 7:
			    	  Map<String, String> hash7=taskHash.getHashMap();
			    	  System.out.println("Enter Key and Value: ");
			    	  key=linkHash.scan.next();
			    	  value=linkHash.scan.next();
			    	    hash7.put(key,value);
			    	  System.out.println("Enter  Value: ");
			    	  key=null;
			    	  value=linkHash.scan.next();
			    	    hash7.put(key,value);
			    	  System.out.println("Enter Key and Value: ");
				      key=linkHash.scan.next();
			    	  value=linkHash.scan.next();
			    	    hash7.put(key,value);
			    	  len=taskHash.getSize(hash7);
			    	  linkHash.getHashLen(hash7, len);
			    	  break;
			    	  
			      case 8:
			    	  Map<K,V> hash8=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  hash8=linkHash.getAddKV(hash8, num);
					  System.out.println("Enter Key you want to check: ");
			    	  Object search=linkHash.scan.next();
			    	  boolean result=taskHash.getKeyExist(hash8, search);
			    	  if(result)
			    	  {
			    		  System.out.println("The Key is Existed.");
			    	  }
			    	  else
			    	  {
			    		  System.out.println("The Key is Not Existed.");
			    	  }			    	
			    	  len=taskHash.getSize(hash8);
			    	  linkHash.getHashLen(hash8, len);
			    	  break;
			    	  
			      case 9:
			    	  Map<K,V> hash9=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  hash9=linkHash.getAddKV(hash9, num);
					  System.out.println("Enter Value you want to check: ");
			    	  Object search9=linkHash.scan.next();
			    	  boolean result9=taskHash.getValueExist(hash9, search9);
			    	  if(result9)
			    	  {
			    		  System.out.println("The Value is Existed.");
			    	  }
			    	  else
			    	  {
			    		  System.out.println("The Value is Not Existed.");
			    	  }			    	
			    	  len=taskHash.getSize(hash9);
			    	  linkHash.getHashLen(hash9, len);
			    	  break;
			    	  
			      case 10:
			    	  Map<K,V> map=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  for(int i=0;i<num;i++)
			    	    {
			    	      System.out.println("Enter key and value:");
			  		      K key1=(K) linkHash.scan.next();
			  		      V value1=(V) linkHash.scan.next();
			  		      map.put(key1, value1);
			  		      System.out.println(" 	");
			    	    }
			  		  for(int i=0;i<num;i++)
			    	  {
			  			System.out.println("Enter Key and its Replaced Value: ");
			  		    K key1=(K) linkHash.scan.next();
			  		    V values=(V) linkHash.scan.next();
						taskHash.replaceKey(map, key1, values);
			    	  }
			    		  
			    	  
					  len=taskHash.getSize(map);
			    	  linkHash.getHashLen(map, len);
			    	  break;
			    	  
			    	  
			      case 11:
			    	  Map<K,V> map1=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  map1=linkHash.getAddKV(map1, num);
					  System.out.println("Enter Key you want to get Value: ");
			    	  Object getValue=linkHash.scan.next();
			    	  V ans=taskHash.getValue(map1, getValue);
			    	  System.out.println("The Required Value is "+ans);
			    	  len=taskHash.getSize(map1);
			    	  linkHash.getHashLen(map1, len);
			    	  break;
			    	  
			      case 12:
			    	  Map<K,V> map2=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  map2=linkHash.getAddKV(map2, num);
					  System.out.println("Enter Key you want to get Value: ");
			    	  getValue=linkHash.scan.next();
			    	  ans=taskHash.getValue(map2, getValue);
			    	  System.out.println("The Required Value is "+ans);
			    	  len=taskHash.getSize(map2);
			    	  linkHash.getHashLen(map2, len);
			    	  break;
			    	  
			      case 13:
			    	  Map<K,V> map3=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  map3=linkHash.getAddKV(map3, num);
					  int lenBeforeAdd=taskHash.getSize(map3);
			    	  System.out.println("Enter Value to be Display when the key is not Existed: ");
			    	  V valueDisp=(V) linkHash.scan.next();
			    	  System.out.println("Enter Key you want to get Value: ");
			    	  K getKey=(K) linkHash.scan.next();
			    	  V v=taskHash.getNotExistKey(map3, getKey, valueDisp);
			    	  System.out.println("The Required Value is "+v);
			    	  len=taskHash.getSize(map3);
			    	  System.out.println("The Size of HashMap before Adding: "+lenBeforeAdd);
			    	  linkHash.getHashLen(map3, len);
			    	  break;
			    	  
			      case 14:
			    	  Map<K,V> map4=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  map4=linkHash.getAddKV(map4, num);
					  lenBeforeAdd=taskHash.getSize(map4);
			    	  System.out.println("Enter Key you want to Remove: ");
			    	  K removeKey=(K) linkHash.scan.next();
			    	  map4=taskHash.removeKey(map4, removeKey);
			    	  len=taskHash.getSize(map4);
			    	  System.out.println("The Size of HashMap before Adding: "+lenBeforeAdd);
			    	  linkHash.getHashLen(map4, len);
			    	  break;
			    	  
			      case 15:
			    	  Map<K,V> map5=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  map5=linkHash.getAddKV(map5, num);
					  lenBeforeAdd=taskHash.getSize(map5);
			    	  len=taskHash.getSize(map5);
			    	  linkHash.getHashLen(map5, len);
			    	  System.out.println("Enter Key you want to Remove: ");
			    	  K removeKey5=(K) linkHash.scan.next();
			    	  System.out.println("Enter Value which matches the key: ");
			    	  V removeValue5=(V) linkHash.scan.next();
			    	  map5=taskHash.removeKeyWithValue(map5, removeKey5, removeValue5);
			    	  len=taskHash.getSize(map5);
			    	  System.out.println("The Size of HashMap before Removing: "+lenBeforeAdd);
			    	  linkHash.getHashLen(map5, len);
			    	  break;
			    	  
			      case 16:
			    	  Map<K,V> map6=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  map6=linkHash.getAddKV(map6, num);
					  lenBeforeAdd=taskHash.getSize(map6);
			    	  len=taskHash.getSize(map6);
			    	  linkHash.getHashLen(map6, len);
			    	  System.out.println("Enter Key you want to Replace: ");
			    	  K existingKey=(K) linkHash.scan.next();
			    	  System.out.println("Enter Value to that Key: ");
			    	  V replaceValue=(V) linkHash.scan.next();
			    	  map4=taskHash.replaceKey(map6, existingKey, replaceValue);
			    	  len=taskHash.getSize(map6);
			    	  System.out.println("The Size of HashMap before Replace: "+lenBeforeAdd);
			    	  linkHash.getHashLen(map6, len);
			    	  break;
			    	
			      case 17:
			    	  Map<K,V> map7=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  map7=linkHash.getAddKV(map7, num);
					  lenBeforeAdd=taskHash.getSize(map7);
			    	  len=taskHash.getSize(map7);
			    	  linkHash.getHashLen(map7, len);
			    	  System.out.println("Enter Key you want to Replace: ");
			    	  K existingKey7=(K) linkHash.scan.next();
			    	  System.out.println("Enter Value which matches the key: ");
			    	  V existingValue7=(V) linkHash.scan.next();
			    	  System.out.println("Enter Value to that Key: ");
			    	  V replaceValue7=(V) linkHash.scan.next();
			    	  map7=taskHash.replaceKeyWithValue(map7, existingKey7, existingValue7, replaceValue7);
			    	  len=taskHash.getSize(map7);
			    	  System.out.println("The Size of HashMap before Adding: "+lenBeforeAdd);
			    	  linkHash.getHashLen(map7, len);
			    	  break;
			    	  
			      case 18:
			    	  Map<K,V> map8=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  map8=linkHash.getAddKV(map8, num);
					  lenBeforeAdd=taskHash.getSize(map8);
			    	  len=taskHash.getSize(map8);
			    	  linkHash.getHashLen(map8, len);
			    	  Map<K,V> hashMap2=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  hashMap2=linkHash.getAddKV(hashMap2, num);
					  lenBeforeAdd=taskHash.getSize(hashMap2);
			    	  len=taskHash.getSize(hashMap2);
			    	  linkHash.getHashLen(hashMap2, len);
			    	  hashMap2=taskHash.getMergedMap(map8, hashMap2);
			    	  System.out.println("After Merging");
			    	  len=taskHash.getSize(hashMap2);
			    	  linkHash.getHashLen(hashMap2, len);
			    	  break;
			    	 
			      case 19:
			    	  Map<K,V> map9=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  map9=linkHash.getAddKV(map9, num);
					  for(Map.Entry<K, V> ent: map9.entrySet())
					  {
						  System.out.println("Key: "+ent.getKey() +"  Value:"+ ent.getValue());
					  }
			    	  break;
			    	  
			    	  
			      case 20:
			    	  Map<K,V> hashMap=taskHash.getHashMap();
			    	  num=linkHash.getNum();
			    	  hashMap=linkHash.getAddKV(hashMap, num);
					  len=taskHash.getSize(hashMap);
			    	  linkHash.getHashLen(hashMap, len);
			    	  hashMap=taskHash.removeAll(hashMap);
			    	  System.out.println("After Clearing All:");
			    	  len=taskHash.getSize(hashMap);
			    	  linkHash.getHashLen(hashMap, len);
			    	  break;
			      default:
			    	  System.out.println("Enter The Digits inbetween 1 to 20.");
			     }
			     System.out.println("Do you want to Continue?");
			     System.out.println("Kindly Enter yes(1) or No(2)");
			     answer=linkHash.scan.nextInt();
			   }while(answer==1);
	}
    catch(CustomException te)
    {
     System.out.println(te.getMessage());     
    }
    catch(InputMismatchException me)
    {
     System.out.println("Kindly Enter Value in Correct Type");
    }
	}
}
