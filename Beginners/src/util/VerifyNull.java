package util;

public class VerifyNull 
{
	public Object verify(Object term) throws Custom
	 {
	  if(term==null)
	  {
	   throw new Custom("This is verified as Null");
	  }
	  return term;
	 }

}
