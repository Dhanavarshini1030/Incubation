package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.CustomException;
import util.Evaluate;


public class RegexMethod 
{
	public boolean mobileNumberCheck(String number) throws CustomException
	{
		Evaluate.verify(number);
		String myPattern="^[7-9]{1}[\\d]{9}$";
		boolean answer=Pattern.matches(myPattern, number);
		return answer;
	}
	
	public boolean alphaNumericMatch(String term) throws CustomException
	{
		Evaluate.verify(term);
		String pattern="^\\w*[^_]$";
		boolean answer=Pattern.matches(pattern, term);
		return answer;
	}
	
	public Matcher stringContains(String matchString,String inputString) throws CustomException
	{
		Evaluate.verify(inputString);
		Evaluate.verify(matchString);
		Pattern answer=Pattern.compile(inputString);
		Matcher match=answer.matcher(matchString);
		return match;
	}
	public boolean stringMatchEnd(String inputString,String matchString) throws CustomException
	{
		Evaluate.verify(matchString);
		Evaluate.verify(inputString);
		String pattern="^.*"+inputString+"$";
		boolean answer=Pattern.matches(pattern, matchString);
		return answer;
	}
	public boolean stringMatchStart(String inputString,String matchString) throws CustomException
	{
		Evaluate.verify(matchString);
		Evaluate.verify(inputString);
		String pattern="^"+inputString+".*$";
		boolean answer=Pattern.matches(pattern,matchString);
		return answer;
	}
	public boolean stringExactMatch(String matchString,String inputString) throws CustomException
	{
		Evaluate.verify(matchString);
		Evaluate.verify(inputString);
		boolean answer=Pattern.matches(matchString, inputString);
		return answer;
	}
	
	public boolean listMatch(String inputString,String matchString) throws CustomException
	{
		Evaluate.verify(matchString);
		Evaluate.verify(inputString);
		Pattern answer=Pattern.compile(matchString,Pattern.CASE_INSENSITIVE);
		Matcher match=answer.matcher(inputString);
		boolean check=match.matches();
		return check;
	}
	
	public boolean emailValidation(String inputTerm) throws CustomException
	{
		Evaluate.verify(inputTerm);
		String pattern="^[a-zA-Z0-9._-]*@[a-zA-z0-9]*\\.[a-z]*$";
		boolean answer=Pattern.matches(pattern, inputTerm);
		return answer;
	}
	
	public  List<String> getAdd(String[] str,int num) throws CustomException
	{
		Evaluate.verify(str);
		List<String> arr=getArrayList();
		for(int i=0;i<num;i++)
		{
			arr.add(str[i]);
		}
		return arr;
	}
	
	public List<String> getArrayList()
	{
		List<String> list=new ArrayList<>();
		return list;
	}
	
	public Map<String,Integer> getAddMap(Map<String,Integer> map,String key,Integer value) throws CustomException
	{
		Evaluate.verify(map);
		map.put(key, value);
		return map;
	}
	
	public boolean listCheck(String terms,int from,int to) throws CustomException
	{
		Evaluate.verify(terms);
		/*Evaluate.verify(from);
		Evaluate.verify(to);*/
		String pattern="^[a-zA-Z0-9]{"+from+","+to+"}$";
		boolean answer=Pattern.matches(pattern, terms);
		return answer;	
	}
	
	public Matcher getTags(String line) throws CustomException
	{
		Evaluate.verify(line);
		String pattern="</?\\w*>";
		Pattern answer=Pattern.compile(pattern);
		Matcher match=answer.matcher(line);
		//String term=match.group();
		//int count=match.groupCount();
		return match;
	}

}
