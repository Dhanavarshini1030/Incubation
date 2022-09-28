package tasks;

import java.util.HashMap;
import java.util.Map;

import util.CustomException;
import util.Evaluate;

public class HashTask 
{
	public <K,V> Map<K,V> getHashMap()
	{
		Map<K,V> map=new HashMap<K,V>();
		return map;
	}
	
	public <K,V> int getSize(Map<K, V> map)throws CustomException
	{
		Evaluate.verify(map);
		int num=map.size();
		return num;
	}
	
		public <K,V> boolean getKeyExist(Map<K,V> map,Object key)throws CustomException
	{
		Evaluate.verify(map);
		boolean result=map.containsKey(key);
		return result;
	}
	
	public <K,V> boolean getValueExist(Map<K,V> map,Object value)throws CustomException
	{
		Evaluate.verify(map);
		boolean result=map.containsValue(value);
		return result;
	}
	
	public <K,V> V getValue(Map<K,V> map,Object key)throws CustomException
	{
		Evaluate.verify(map);
		V result=map.get(key);
		return result;
	}
	
	public <K,V> V getNotExistKey(Map<K,V> map,K key,V notExist)throws CustomException
	{
		Evaluate.verify(map);
		map.putIfAbsent(key, notExist);
		V result=map.get(key);
		return result;
	}
	
	public <K,V> Map<K,V> removeKey(Map<K,V> map, K key)throws CustomException
	{
		Evaluate.verify(map);
		map.remove(key);
		return map;
	}
	
	public <K,V> Map<K,V> removeKeyWithValue(Map<K,V> map, K key, V value)throws CustomException
	{
		Evaluate.verify(map);
		map.remove(key, value);
		return map;
	}
	
	public <K,V> Map<K,V> replaceKey(Map<K,V> map, K existingKey, V replaceValue)throws CustomException
	{
		Evaluate.verify(map);
		map.replace(existingKey, replaceValue);
		return map;
	}
	
	public <K,V> Map<K,V> replaceKeyWithValue(Map<K,V> map, K existingKey, V existingValue, V replaceValue)throws CustomException
	{
		Evaluate.verify(map);
		map.replace(existingKey, existingValue, replaceValue);
		return map;
	}
	
	public <K,V> Map<K,V> getMergedMap(Map<K,V> map1, Map<K,V> map2)throws CustomException
	{
		Evaluate.verify(map1);
		Evaluate.verify(map2);
		map2.putAll(map1);
		return map2;
	}
	
	public <K,V> Map<K,V> removeAll(Map<K,V> map)throws CustomException
	{
		Evaluate.verify(map);
		map.clear();
		return map;
	}
	
	
}
