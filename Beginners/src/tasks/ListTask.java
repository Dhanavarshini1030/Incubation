package tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.CustomException;//Swami - solved
import util.Evaluate;


public class ListTask
{
	public <T> List<T> getArrayList()
	{
		List<T> list=new ArrayList<>();
		return list;
	}
	
	public <T> int getLength(List<T> list)throws CustomException
	{
		Evaluate.verify(list);
		int len=list.size();
		return len;
	}
	
	public  List<Object> getAll(List<Object> list,Object[] str,int num)throws CustomException
	{
		Evaluate.verify(str);
		for(int i=0;i<num;i++)
		{
			list.add(str[i]);
		}
		return list;
	}
	
	public List<String> getAdd(String[] str,int num,List<String> arr)throws CustomException
	{
		Evaluate.verify(str);	//Swami solved
		for(int i=0;i<num;i++)
		{
			arr.add(str[i]);
		}
		return arr;
	}
	
	public List<Integer> getAddNum(int[] numbers,int num,List<Integer> arr)throws CustomException
	{
		Evaluate.verify(numbers);
		for(int i=0;i<num;i++)
		{
			arr.add(numbers[i]);
		}
		return arr;
	}
	
	public List<Float> getAddFloat(float[] decimals,int num,List<Float> arr)throws CustomException
	{
		Evaluate.verify(decimals);
		for(int i=0;i<num;i++)
		{
			arr.add(decimals[i]);
		}
		return arr;
	}
	
	
	public List<Long> getAddLong(long[] longValues,int num,List<Long> arr)throws CustomException
	{
		Evaluate.verify(longValues);
		for(int i=0;i<num;i++)
		{
			arr.add(longValues[i]);
		}
		return arr;
	}
	
	public int getStrIndex(String search, List<String> list)throws CustomException
	{
		Evaluate.verify(list);
		return list.indexOf(search);//Swami solved
	}
	
	public Iterator<String> getIterator(List<String> list)throws CustomException
	{	
		Evaluate.verify(list);
		return list.iterator();
	}
	
	public String getIndexStr(List<String> list, int index)throws CustomException
	{
		int len=getLength(list);
		if(index>=len)
		{
			throw new CustomException("Enter the Number within "+len);
		}
		return list.get(index);
	}
	
	public int getLastIndex(List<String> list,String search)throws CustomException
	{
		Evaluate.verify(list);
		return list.lastIndexOf(search);//Swami solved
	}
	
	public List<String> getAddStr(String str,int index,List<String> list)throws CustomException
	{
		int len=getLength(list);
		if(index>=len)
		{
			throw new CustomException("Enter the Number within "+len);
		}
		list.add(index, str);
		return list;
	}
	
	public List<String> getSubList(List<String> list,List<String> newList,int from,int to)throws CustomException
	{
		  int len=getLength(list);
		  if((len<=from)||(len<=to))
		  {
		   throw new CustomException("WARNING: Enter the Number within "+len);
		  }
		  newList=list.subList(from, to);
		  return newList;
	}
	
	public List<String> getCombinedList(List<String> list1,List<String> list2,List<String> newList)throws CustomException
	{
		Evaluate.verify(list2);
		Evaluate.verify(list1);
		newList.addAll(list1);
		newList.addAll(list2);
		return newList;
	}
	
	public List<String> getCombinedList2(List<String> list1,List<String> list2,List<String> newList)throws CustomException
	{
		Evaluate.verify(list2);
		Evaluate.verify(list1);
		newList.addAll(list2);
		newList.addAll(list1);
		return newList;
	}
	
	public List<Float> getRemove(List<Float> list, float value)throws CustomException
	{
		Evaluate.verify(list);
		list.remove(value);//Swami   solved
		return list;
	}
	
	public List<Float> getRemoveIndex(List<Float> list,int index)throws CustomException
	{
		int len=getLength(list);
		if(index>=len)
		{
			throw new CustomException("Enter the Number within "+len);
		}
		
		list.remove(index);
		return list;
	}
	
	public List<Long> getRemoveList(List<Long> list,int from,int to)throws CustomException
	{
		int len=getLength(list);
		if((len<=from)||(len<=to))
		{
		   throw new CustomException("WARNING: Enter the Number within "+len);
		}
		List<Long> subList=list.subList(from, to);//Swami solved
		list.removeAll(subList);
		return list;
		
	}
	
	public List<String> getIntersect(List<String> list1, List<String> list2)throws CustomException
	{
		Evaluate.verify(list2);
		Evaluate.verify(list1);
		list1.retainAll(list2);//18
		return list1;
	}
	
	public List<String> getDifferent(List<String> list1, List<String> list2)throws CustomException
	{
		 Evaluate.verify(list2);
		 Evaluate.verify(list1);
		 list1.removeAll(list2);//Swami			solved				
	  	 return list1;	
	}
	
	
	public List<Long> getRemoveAll(List<Long> list)throws CustomException
	{
		Evaluate.verify(list);
		list.clear();
		return list;
	}
	
	public boolean getChecked(List<String> list,String verify)throws CustomException
	{
		Evaluate.verify(list);
		return list.contains(verify);
		
	}
}
