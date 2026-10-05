
public class TestVigenere {

    public static void main(String[] args) {
        Vigenere vigenere = new Vigenere();

        try {
            vigenere.encryptText("Ceci est un test!", "SECRETKEY");
            System.out.println(vigenere.getEncryptedText());

            System.out.println(vigenere.decryptText("SECRETKEY"));

            //vigenere.encryptText("Ceci est un autre test!", "");
            //System.out.println(vigenere.getEncryptedText());  

            vigenere.encryptFile("original.jar", "Ceci est la clé secrète!", "encrypted.jar");
            vigenere.decryptFile("encrypted.jar", "Ceci est la clé secrète!", "decrypted.jar");

            vigenere.encryptFile("original.txt", "ABC", "encrypted.txt");
            vigenere.decryptFile("encrypted.txt", "ABC", "decrypted.txt");

            long start = System.nanoTime();
            vigenere.encryptFile_Direct("original.pdf", "Ceci est la clé secrète!", "encrypted.pdf");
            vigenere.decryptFile_Direct("encrypted.pdf", "Ceci est la clé secrète!", "decrypted.pdf");
            long diff = System.nanoTime()-start;
            System.out.println("En- & DecryptionTime -  Direct  -: "+diff/1000000000.0+"s");
            
            start = System.nanoTime();
            vigenere.encryptFile("original.pdf", "Ceci est la clé secrète!", "encrypted.pdf");
            vigenere.decryptFile("encrypted.pdf", "Ceci est la clé secrète!", "decrypted.pdf");
            diff = System.nanoTime()-start;
            System.out.println("En- & DecryptionTime - Buffered -: "+diff/1000000000.0+"s");
            
        } catch (EmptyEncryptionKeyException ek) {
            System.err.println(ek.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());   //polymorph...
        }
    }
}