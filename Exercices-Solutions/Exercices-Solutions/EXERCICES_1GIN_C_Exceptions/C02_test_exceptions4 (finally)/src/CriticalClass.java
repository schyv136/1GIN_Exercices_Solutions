import java.io.*;

public class CriticalClass
{
	public void criticalMethod() {
   		try {
			System.out.println("criticalMethod: before division");
                        int a = 10/0;
                        System.out.println("criticalMethod: after division");
   		}
   	/* 
    		catch (RuntimeException e) {
    			System.out.println(e);
    			//e.printStackTrace();
    		}
    	 */
    		finally {
    			System.out.println("criticalMethod: finally");
    		}
    		System.out.println("criticalMethod: end");
	}  

/*
	public void criticalMethod() throws ArithmeticException {
    		throw new RunTimeException("Hi, I am a runtime exception!");
	}
*/

}