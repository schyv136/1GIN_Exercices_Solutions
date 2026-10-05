/**
 * Write a description of class "TestChar" here.
 * 
 * @author     fred
 * @version    01/10/2012 15:06:09
 */
public class TestChar
{

    /**
	 * The main entry point for executing this program.
	 */
    public static void main(String[] args) 
    {
	/*
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
			for (int i=0 ; i<1024 ; i++) {
		   		if (i!=12)	
					System.out.print(i+":"+(char)i+" | ");		
			}
		*/
		
		String s="ABCD efgh,IJKL.MNOP-QRST_UVWX+YZ";
		String secret = Crypter.encryptShiftByNPure(s, 3);
		System.out.println(secret);
		String clear  = Crypter.decryptShiftByNPure(secret,3);
		System.out.println(clear);
		System.out.println();
		
		s="Dest ass en Test, mat engem Komma an mat e puer Accent'en: éèàüäö";
		secret = Crypter.encryptShiftByN(s, 1);
		System.out.println(secret);
		clear  = Crypter.decryptShiftByN(secret,1);
		System.out.println(clear);
		System.out.println();
				
		s="Dest ass en Test, mat engem Komma an mat e puer Accent'en: éèàüäö";
		secret = Crypter.encryptVigenere(s,     "Voici la clé!");
		System.out.println(secret);
		clear  = Crypter.decryptVigenere(secret,"Voici la clé!");
		System.out.println(clear);		
    }
}