import java.io.IOException;

public class CriticalClassCaller
{
	public void callCriticalMethod()  {
   		try {
			new CriticalClass().criticalMethod();
    		}
    		catch (IOException e) {
                        System.out.println("Fehler!");
    			e.printStackTrace();
    		}
	}

}