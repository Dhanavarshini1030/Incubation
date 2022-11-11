package util;
public class CustomException extends Exception
{
	private static final long serialVersionUID = 1L;
	
/* public CustomException(String s)
  {
   super(s);
  }*/
 public CustomException(String s,Exception e)
 {
	 super(s,e);
 }
 
}
