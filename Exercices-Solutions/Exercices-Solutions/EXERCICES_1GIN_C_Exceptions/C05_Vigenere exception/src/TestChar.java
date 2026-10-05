/**
 * Write a description of class "TestChar" here.
 * 
 * @author     fred
 * @version    10/10/2011 15:06:09
 */
public class TestChar
{

    /**
	 * The main entry point for executing this program.
	 */
    public static void main(String[] args) 
    {
    		//Conversion et reconversion de caractères (Unicode)
		System.out.println((int)'A');
		System.out.println((int)'B');
		System.out.println((int)'a');
		System.out.println((int)'€');
		System.out.println((int)'$');
		System.out.println((int)'ß');
		System.out.println((int)'ç');
		System.out.println((char)65);
		System.out.println((char)97);
		System.out.println((char)255);
		System.out.println((char)8364);
		System.out.println((char)8365);
		System.out.println((int)(char)65);
		System.out.println((int)(char)8366);
    }
}