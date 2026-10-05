import java.io.IOException;

public class CriticalClassCaller
{
	public void callCriticalMethod() {
   		try {
   			System.out.println("callCriticalMethod: before call");
			new CriticalClass().criticalMethod();
			System.out.println("callCriticalMethod: after call");
    		}
    	/*
    		catch (RuntimeException e) {
    			System.out.println(e);
    			//e.printStackTrace();
    		}
    	*/
    		finally {
    			System.out.println("callCriticalMethod: finally");
    		}
     	System.out.println("callCriticalMethod: end");
	}

}