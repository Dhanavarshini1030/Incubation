package util;

 public class Evaluate 
{
	public static Object verify(Object term) throws CustomException
	 {
	  if(term==null)
	  {
	   throw new CustomException("This is verified as Null");
	  }
	  return term;
	 }

}
