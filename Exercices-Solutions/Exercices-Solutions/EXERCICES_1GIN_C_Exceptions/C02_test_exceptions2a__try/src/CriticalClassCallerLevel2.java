import java.io.IOException;

public class CriticalClassCallerLevel2
{
	public static void main(String args[])  {
		new CriticalClassCaller().callCriticalMethod();
	}
	
}