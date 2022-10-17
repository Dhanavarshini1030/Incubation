package runner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class POJOProgramReflection
{
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		try 
		{
		 	Class<?> cls=Class.forName("reference.POJOProgram");
			
			Constructor<?> con1=cls.getConstructor();
			Object obj=con1.newInstance();
			Method setMeth=cls.getMethod("setTerm",String.class);
			setMeth.invoke(obj, "qwrerty");
			Method getMeth=cls.getMethod("getTerm");
			System.out.println(getMeth.invoke(obj));
			
			Constructor<?> con2=cls.getConstructor(int.class,String.class);
			Object obj2=con2.newInstance(30,"october");
			Method meth3=cls.getMethod("getNumber");
			System.out.println(meth3.invoke(obj2));
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
