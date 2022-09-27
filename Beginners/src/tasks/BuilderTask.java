package tasks;

import util.CustomException;
import util.Evaluate;

public class BuilderTask
{ 
	 
  public StringBuilder getAppend(String str)
  {
	  StringBuilder build=getBuilder();
	  build.append(str);
	  return build;
  }
  public StringBuilder getBuilder()
  {   
	  StringBuilder build=new StringBuilder();
	  return build;
  }
   public int getLen(StringBuilder sb)throws CustomException
  {
	  Evaluate.verify(sb);
	  int len=sb.length();
	  return len;
  }
 public StringBuilder getAppendArr(String[] words,StringBuilder sb,String toInsert)throws CustomException
 {
	 Evaluate.verify(words);
	 Evaluate.verify(sb);
	 for(String str:words)
	 {
		 sb=sb.append(toInsert);
		 sb=sb.append(str);
	 }
	 return sb;
 }
  
  public StringBuilder getDelete(StringBuilder term,String toDelete, int num)throws CustomException
  {   
	  Evaluate.verify(term);
	  Evaluate.verify(toDelete);
	  int number=term.indexOf(toDelete);
	  term=term.delete(0,number+1);
	 /* int len2,len3=0;
	  for(len2=0;len2<num;len2++)
	  {
		  len3=term.indexOf(toDelete, len2);
		  len2=len3;
		 /* term=term.deleteCharAt(len2);
		  term=term.insert(len2, replace);		  
	  }
	  term=term.delete(len2, len3);*/
	  return term;
   }
  public StringBuilder getInsert(StringBuilder term,String join,String search)throws CustomException
  {
	  Evaluate.verify(term);
	  Evaluate.verify(search);
	  int num=term.indexOf(search);
	  term=term.insert(num,search);
	  term=term.insert(num+1, join);
	  return term;
  }
 public StringBuilder getReplace(StringBuilder term, String separator, String replace)throws CustomException
  {   
	  Evaluate.verify(term);
	  Evaluate.verify(replace);
	  Evaluate.verify(separator);
	  int len1,len3;
	  len1=term.lastIndexOf(separator);
	  for(int len2=0;len2<len1;len2++)
	  {
		  len3=term.indexOf(separator, len2);
		  len2=len3;
		  term=term.deleteCharAt(len2);
		  term=term.insert(len2, replace);		  
	  }
	  return term;
  }
  public StringBuilder getReverse(StringBuilder term)throws CustomException
  {
	  Evaluate.verify(term);
	  term=term.reverse();
	  return term;
  }
  public StringBuilder getRemoved(StringBuilder term,int from,int to)throws CustomException
  {
	  int len=getLen(term);
	  if((from>=len)||(to>=len))
	  {
	   throw new CustomException("WARNING: Enter the Number within "+len);
	  }
	  term=term.delete(from, to);
	  return term;
  }
  public StringBuilder getReplaced(String str,StringBuilder term,int from,int to)throws CustomException
  {
	  int len=getLen(term);
	  if((from>=len)||(to>=len))
	  {
	   throw new CustomException("WARNING: Enter the Number within "+len);
	  }
	  term=term.replace(from, to, str);
	  return term;
  }
  public int getFirstIndex(StringBuilder term,String separator)throws CustomException
  {
	  Evaluate.verify(term);
	  Evaluate.verify(separator);
	  int len=term.indexOf(separator);
	  return len;
  }
  public int getLastIndex(StringBuilder term,String separator)throws CustomException
  {
	  Evaluate.verify(term);
	  Evaluate.verify(separator);
	  int len=term.lastIndexOf(separator);
	  return len;
  }
}
