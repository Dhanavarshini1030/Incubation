package tasks;
import util.Custom;
import util.VerifyNull;

public class StringTask
{
  VerifyNull check=new VerifyNull();
 public int getLength(String term)throws Custom
 {
  check.verify(term);
  int length=term.length();
  return length;
 }
 public char[] getChar(String term)throws Custom
 {
  check.verify(term);
  char letters[]= term.toCharArray();
  return letters;
 }
 public char getPenultimateLetter(String term, int length)throws Custom
 {
   check.verify(term);
   int index=(length-2);
   char letter=term.charAt(index);
   return letter;
 }
 public int getCount(String term,char letter)throws Custom
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
 public int getPosition(String term,char letter)throws Custom
 {
  check.verify(term);
  int position=term.lastIndexOf(letter);
  return position;
 }
 public String getSubString(String term,int index)throws Custom
 {
  
  int len=getLength(term);
  if(index>len)
  {
   throw new Custom("Enter the Number below "+len);
  }
  int number=len-index;
  String subSet=term.substring(number);
  return subSet;
 }
 public String getFirstSet(String term,int index)throws Custom
 {
  int len=getLength(term);
  if(index>len)
  {
   throw new Custom("Enter the Number below "+len);
  }
  int initial=0;
  String subSet=term.substring(initial,index);
  return subSet;
 }
 public String replaceInitially(String term, String letter)throws Custom
 {
  int len=getLength(term);
  int length=getLength(letter);
  if(length>len)
  {
   throw new Custom("Enter the letter within "+len);
  }
  String phrase=getFirstSet(term,length);
  String word=term.replace(phrase,letter);
  return word;
 }
 public boolean wordStarts(String term, String word)throws Custom
 {
  check.verify(term);
  boolean answer=term.startsWith(word);
  return answer;
 }
 public boolean wordEnds(String term, String word)throws Custom
 {
  check.verify(term);
  boolean answer=term.endsWith(word);
  return answer;
 }
 public String getUpper(String term)throws Custom
 {
  check.verify(term);
  String upper=term.toUpperCase();
  return upper;
 }
 public String getLower(String term)throws Custom
 {
  check.verify(term);
  String lower=term.toLowerCase();
  return lower;
 }
 public boolean checksEqualSensitive(String term1, String term2)throws Custom
 {
  check.verify(term1);
  boolean outcome= term1.equals(term2);
  return outcome;
 }
 public boolean checksEqualInSensitive(String term1, String term2)throws Custom
 {
  check.verify(term1);
  boolean outcome= term1.equalsIgnoreCase(term2);
  return outcome;
 }
 public String getReverse(String term)throws Custom
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
 
 public String getFullLine(String term)throws Custom
 {
  check.verify(term);
  String whole="";
 String[] words=term.split(" ");
  for(String word:words)
  {
    whole=whole+word;
  }
  return whole;
 }
 public String getStringReplace(String[] term)throws Custom
 {
  check.verify(term);
  String str=String.join("-",term);
  return str;
  
 }
 public String[] getStringArray(String term)throws Custom
 {
  check.verify(term);
  String[] words= term.split(" ");
  return words;
 }
 public String getTrimmed(String term)throws Custom
 {
  check.verify(term);
  String sentence= term.trim();
  return sentence;
 }
}
