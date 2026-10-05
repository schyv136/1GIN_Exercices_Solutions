import java.io.*;

public class CriticalClass
{

	public void criticalMethod() throws IOException {
     		BufferedReader inputStream = 
           		new BufferedReader( new FileReader("IDoNotExist.txt"));   //=> try...
    			inputStream.readLine();
	}  

/*
	public void criticalMethod() throws IOException {
    		throw new IOException("Hi, I am an exception!");
	}
*/

}