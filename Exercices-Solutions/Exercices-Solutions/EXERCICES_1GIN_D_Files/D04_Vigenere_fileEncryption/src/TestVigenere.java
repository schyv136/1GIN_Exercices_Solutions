
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

        } catch (EmptyEncryptionKeyException ek) {
            System.err.println(ek.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());   //polymorph...
        }
    }
}