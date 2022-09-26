package tasks;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.List;

import util.Custom;

import util.VerifyNull;


public class ListTask
{
	VerifyNull check=new VerifyNull();
	public <T> List<T> getArrayList()
	{
		List<T> list=new ArrayList<>();
		return list;
	}
	
	public <T> int getLength(List<T> list)throws Custom
	{
		check.verify(list);
		int len=list.size();
		return len;
	}
	
	public List<Object> getObject(Object obj,List<Object> list)
	{
		list.add(obj);
		return list;
	}
	
	public  List<Object> getAll(List<Object> list,Object[] str,int num)
	{
		for(int i=0;i<num;i++)
		{
			list.add(str[i]);
		}
		return list;
	}
	
	public List<String> getAdd(String[] str,int num,List<String> arr)throws Custom
	{
		check.verify(str);
		for(int i=0;i<num;i++)
		{
			arr.add(str[i]);
		}
		return arr;
	}
	
	public List<Integer> getAddNum(int[] str,int num,List<Integer> arr)throws Custom
	{
		check.verify(str);
		for(int i=0;i<num;i++)
		{
			arr.add(str[i]);
		}
		return arr;
	}
	
	public List<Float> getAddFloat(float[] str,int num,List<Float> arr)throws Custom
	{
		check.verify(str);
		for(int i=0;i<num;i++)
		{
			arr.add(str[i]);
		}
		return arr;
	}
	
	
	public List<Long> getAddLong(long[] str,int num,List<Long> arr)throws Custom
	{
		check.verify(str);
		for(int i=0;i<num;i++)
		{
			arr.add(str[i]);
		}
		return arr;
	}
	
	public int getStrIndex(String search, List<String> list)throws Custom
	{
		check.verify(list);
		if(!list.contains(search))
		{
			throw new Custom("This ArrayList didn't have this String");
		}
		return list.indexOf(search);
	}
	
	public Iterator<String> getIterator(List<String> list)throws Custom
	{	
		check.verify(list);
		return list.iterator();
	}
	
	public String getIndexStr(List<String> list, int index)throws Custom
	{
		int len=getLength(list);
		if(index>=len)
		{
			throw new Custom("Enter the Number within "+len);
		}
		return list.get(index);
	}
	
	public int getFirstIndex(List<String> list,String search)throws Custom
	{ 
		//check.verify(search);
		check.verify(list);
		if(!list.contains(search))
		{
			throw new Custom("This ArrayList didn't have this String");
		}
		return list.indexOf(search);
	}
	
	public int getLastIndex(List<String> list,String search)throws Custom
	{
		//check.verify(search);
		check.verify(list);
		if(!list.contains(search))
		{
			throw new Custom("This ArrayList didn't have this String");
		}
		return list.lastIndexOf(search);
	}
	
	public List<String> getAddStr(String str,int index,List<String> list)throws Custom
	{
		int len=getLength(list);
		if(index>=len)
		{
			throw new Custom("Enter the Number within "+len);
		}
		list.add(index, str);
		return list;
	}
	
	public List<String> getSubList(List<String> list,List<String> newList,int from,int to)throws Custom
	{
		  int len=getLength(list);
		  if((len<=from)||(len<=to))
		  {
		   throw new Custom("WARNING: Enter the Number within "+len);
		  }
		  newList=list.subList(from, to);
		  return newList;
	}
	
	public List<String> getCombinedList(List<String> list1,List<String> list2,List<String> newList)throws Custom
	{
		check.verify(list2);
		check.verify(list1);
		newList.addAll(list1);
		newList.addAll(list2);
		return newList;
	}
	
	public List<String> getCombinedList2(List<String> list1,List<String> list2,List<String> newList)throws Custom
	{
		check.verify(list2);
		check.verify(list1);
		newList.addAll(list2);
		newList.addAll(list1);
		return newList;
	}
	
	public List<Float> getRemoved(List<Float> list, float value)throws Custom
	{
		check.verify(list);
		if(!list.contains(value))
		{
			throw new Custom("This ArrayList didn't have this Value");
		}
		list.remove(value);
		return list;
	}
	
	public List<Float> getRemoveIndex(List<Float> list,int index)throws Custom
	{
		int len=getLength(list);
		if(index>=len)
		{
			throw new Custom("Enter the Number within "+len);
		}
		
		list.remove(index);
		return list;
	}
	
	public List<Long> getRemoveList(List<Long> list,int from,int to)throws Custom
	{
		int len=getLength(list);
		if((len<=from)||(len<=to))
		{
		   throw new Custom("WARNING: Enter the Number within "+len);
		}
		List<Long> subList=getArrayList();
		subList=list.subList(from, to);
		list.removeAll(subList);
		return list;
		
	}
	
	public List<String> getIntersect(List<String> list1, List<String> list2)throws Custom
	{
		check.verify(list2);
		check.verify(list1);
		list1.retainAll(list2);
		return list1;
	}
	
	public List<String> getDifferent(List<String> list1, List<String> list2)throws Custom
	{
		 check.verify(list2);
		 check.verify(list1);
		 list2.retainAll(list1);							//A-(A INTERSECT B)
	  	 list1.removeAll(list2);
	  	 return list1;	
	}
	
	
	public List<Long> getRemoveAll(List<Long> list)throws Custom
	{
		check.verify(list);
		//list.removeAll(list);
		list.clear();
		return list;
	}
	
	public boolean getChecked(List<String> list,String verify)throws Custom
	{
		//check.verify(verify);
		check.verify(list);
		return list.contains(verify);
		
	}
}
