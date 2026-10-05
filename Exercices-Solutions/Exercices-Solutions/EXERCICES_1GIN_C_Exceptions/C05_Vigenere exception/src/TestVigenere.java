public class TestVigenere
{

    public static void main(String[] args) 
    {
        Vigenere vigenere = new Vigenere();

        try 
        {
                vigenere.encryptText("Ceci est un test!", "SECRETKEY");
        	System.out.println(vigenere.getEncryptedText());

        	System.out.println(vigenere.decryptText("SECRETKEY")); 

        	vigenere.encryptText("Ceci est un autre test!", "");
        	System.out.println(vigenere.getEncryptedText());        
        }
        catch (EmptyEncryptionKeyException ek)
        {
        	System.out.println(ek.getMessage());
        }
        catch (Exception e)
        {
        	System.out.println(e.getMessage());   //polymorph...
        }
    }
}