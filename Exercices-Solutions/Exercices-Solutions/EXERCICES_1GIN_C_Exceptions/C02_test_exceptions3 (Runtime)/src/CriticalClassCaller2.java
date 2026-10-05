import java.io.IOException;

public class CriticalClassCaller2
{
	public void callCriticalMethod2() {
   		//try {
			System.out.println("callCriticalMethod2: before call");
			new CriticalClassCaller().callCriticalMethod();
			System.out.println("callCriticalMethod2: after call");
    		//}
    		//catch (RuntimeException e) {
    		//	System.out.println(e);
    		//	//e.printStackTrace();
    		//}
    		//finally {
    		//	System.out.println("callCriticalMethod2: finally");
    		//}
    		System.out.println("callCriticalMethod2: end");
	}

	public static void main(String args[])  {
   		try {
		     System.out.println("main: before call");
		     new CriticalClassCaller2().callCriticalMethod2();
		     System.out.println("main: after call");
    		
    		}
    		catch (RuntimeException e) {
    			System.out.println(e);
    			//e.printStackTrace();
    		}
    		
    		//finally {
    		//	System.out.println("main: finally");
    		//}
		System.out.println("main: end");
	}
}