import java.io.IOException;

public class CriticalClassCaller
{
	public void callCriticalMethod() {
   			System.out.println("callCriticalMethod: before call");
			new CriticalClass().criticalMethod();
			System.out.println("callCriticalMethod: after call");
    			System.out.println("callCriticalMethod: end");
	}

}