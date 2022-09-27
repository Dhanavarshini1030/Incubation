package tasks;

import util.CustomException;
import util.Evaluate;

public class StringTask
{
  public int getLength(String term)throws CustomException
 {
  Evaluate.verify(term);
  int length=term.length();
  return length;
 }
 public char[] getChar(String term)throws CustomException
 {
  Evaluate.verify(term);
  char letters[]= term.toCharArray();
  return letters;
 }
 public char getPenultimateLetter(String term, int length)throws CustomException
 {
   Evaluate.verify(term);
   int index=(length-2);
   char letter=term.charAt(index);
   return letter;
 }
 public int getCount(String term,char letter)throws CustomException
 {
  int length=getLength(term);
  int count=0;
  for (int i=0;i<length;i++)
  {
   if(term.charAt(i)==letter)
   {
    count++;
   }
  }
  return count;
 }
 public int getPosition(String term,char letter)throws CustomException
 {
  Evaluate.verify(term);
  int position=term.lastIndexOf(letter);
  return position;
 }
 public String getSubString(String term,int index)throws CustomException
 {
  
  int len=getLength(term);
  if(index>len)
  {
   throw new CustomException("Enter the Number below "+len);
  }
  int number=len-index;
  String subSet=term.substring(number);
  return subSet;
 }
 public String getFirstSet(String term,int index)throws CustomException
 {
  int len=getLength(term);
  if(index>len)
  {
   throw new CustomException("Enter the Number below "+len);
  }
  int initial=0;
  String subSet=term.substring(initial,index);
  return subSet;
 }
 public String replaceInitially(String term, String letter)throws CustomException
 {
  int len=getLength(term);
  int length=getLength(letter);
  if(length>len)
  {
   throw new CustomException("Enter the letter within "+len);
  }
  String phrase=getFirstSet(term,length);
  String word=term.replace(phrase,letter);
  return word;
 }
 public boolean wordStarts(String term, String word)throws CustomException
 {
  Evaluate.verify(term);
  boolean answer=term.startsWith(word);
  return answer;
 }
 public boolean wordEnds(String term, String word)throws CustomException
 {
  Evaluate.verify(term);
  boolean answer=term.endsWith(word);
  return answer;
 }
 public String getUpper(String term)throws CustomException
 {
  Evaluate.verify(term);
  String upper=term.toUpperCase();
  return upper;
 }
 public String getLower(String term)throws CustomException
 {
  Evaluate.verify(term);
  String lower=term.toLowerCase();
  return lower;
 }
 public boolean checksEqualSensitive(String term1, String term2)throws CustomException
 {
  Evaluate.verify(term1);
  boolean outcome= term1.equals(term2);
  return outcome;
 }
 public boolean checksEqualInSensitive(String term1, String term2)throws CustomException
 {
  Evaluate.verify(term1);
  boolean outcome= term1.equalsIgnoreCase(term2);
  return outcome;
 }
 public String getReverse(String term)throws CustomException
 {
  char termChar[]=getChar(term);
  int length=termChar.length;
  int j=length-1;
  for (int i=0;i<j;i++,j--)
  {
    char temp=termChar[j];
    termChar[j]=termChar[i];
    termChar[i]=temp;
   }
  String abc=new String(termChar); 
    return abc;
 }
 
 public String getFullLine(String term)throws CustomException
 {
  Evaluate.verify(term);
  String whole="";
 String[] words=term.split(" ");
  for(String word:words)
  {
    whole=whole+word;
  }
  return whole;
 }
 public String getStringReplace(String[] term)throws CustomException
 {
  Evaluate.verify(term);
  String str=String.join("-",term);
  return str;
  
 }
 public String[] getStringArray(String term)throws CustomException
 {
  Evaluate.verify(term);
  String[] words= term.split(" ");
  return words;
 }
 public String getTrimmed(String term)throws CustomException
 {
  Evaluate.verify(term);
  String sentence= term.trim();
  return sentence;
 }
}
