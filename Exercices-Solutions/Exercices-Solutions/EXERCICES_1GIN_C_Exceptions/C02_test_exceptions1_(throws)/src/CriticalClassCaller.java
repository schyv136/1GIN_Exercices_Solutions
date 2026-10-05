import java.io.IOException;

public class CriticalClassCaller
{
	public void callCriticalMethod() throws IOException {
		new CriticalClass().criticalMethod();
	}

}