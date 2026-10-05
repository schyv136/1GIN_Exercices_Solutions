import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CriticalClass
{

	public void criticalMethod()  {
            BufferedReader inputStream = null;
            try {
                inputStream = new BufferedReader( new FileReader("IDoNotExist.txt"));
                inputStream.readLine();
            } catch (IOException ex) {
                System.out.println("Fehler");
            } finally {
                    if (inputStream!=null)
                            try {
                        inputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(CriticalClass.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
	}  

/*
	public void criticalMethod() throws IOException {
    		throw new IOException("Hi, I am an exception!");
	}
*/

}