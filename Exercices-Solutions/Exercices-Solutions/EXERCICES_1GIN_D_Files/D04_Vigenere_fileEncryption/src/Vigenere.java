
import java.io.*;

/**
 * Sauvegarde et retourne un texte encrypté selon l'algorithme de Vigenère
 *
 * @author fabfr297
 * @version 10/10/2011 09:33:28
 */
public class Vigenere {

    /**
     * Le texte encrypté - le mot de passe n'est pas sauvegardé
     */
    private String encryptedText = "";

    /**
     * Retourne le texte encrypté 'tel quel'
     *
     * @return la valeur de l'attribut
     */
    public String getEncryptedText() {
        return encryptedText;
    }

    /**
     * Encrypte un texte selon l'algorithme de Vigenère et le mémorise dans
     * l'attribut encryptedText La clé est supposée consister uniquement de
     * lettres alphabétiques et elle est convertie en majuscules. Le déplacement
     * de codes des caractères est de 0 pour 'A' , 1 pour 'B' etc.
     *
     * @param text le texte à encrypter
     * @param key la clé à employer lors de l'encryptage
     */
    public void encryptText(String text, String key) {
        if (key.length() != 0) {
            key = key.toUpperCase();
            int keyIndex = 0;
            encryptedText = "";
            for (int i = 0; i < text.length(); i++) {
                char c = (char) ((int) text.charAt(i) + ((int) key.charAt(keyIndex) - 65));
                encryptedText = encryptedText + c;
                keyIndex = (keyIndex + 1) % key.length();
            }
        } else //clé vide provoque par défaut une exception StringIndexOutOfBoundsException
        {
            throw new EmptyEncryptionKeyException();
        }
    }

    /**
     * Décrypte le texte mémorisé selon l'algorithme de Vigenère
     *
     * @param key la clé à employer lors du décryptage
     * @return le texte décrypté
     */
    public String decryptText(String key) {
        String decryptedText = "";
        if (key.length() != 0) {
            key = key.toUpperCase();
            int keyIndex = 0;
            for (int i = 0; i < encryptedText.length(); i++) {
                char c = (char) ((int) encryptedText.charAt(i) - ((int) key.charAt(keyIndex) - 65));
                decryptedText = decryptedText + c;
                keyIndex = (keyIndex + 1) % key.length();
            }
        } else //clé vide provoque par défaut une exception StringIndexOutOfBoundsException
        {
            throw new EmptyEncryptionKeyException();
        }

        return decryptedText;
    }

    public void encryptFile(String fileName, String key, String fileName2) throws FileNotFoundException, IOException {
        if (fileName.equals(fileName2)) {
            throw new IllegalArgumentException("Encrypted file must have another name than the original file.");
        } else if (key.length() != 0) {
            
            // try-with-resources multiple (avec 2 fichiers)             
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName2))) {
                int keyIndex = 0;
                int b = 0;
                while (b != -1) {
                    b = in.read();
                    if (b != -1) {
                        int b2 = b + ((int) key.charAt(keyIndex));
                        keyIndex = (keyIndex + 1) % key.length();
                        out.write(b2);
                    }
                }
            }
            
        } else //clé vide provoque par défaut une exception StringIndexOutOfBoundsException
        {
            throw new EmptyEncryptionKeyException();
        }
    }

    public void decryptFile(String fileName, String key, String fileName2) throws FileNotFoundException, IOException {
        if (fileName.equals(fileName2)) {
            throw new IllegalArgumentException("Decrypted file must have another name than the encrypted file.");
        } else if (key.length() != 0) {
            
            // try-with-resources multiple (avec 2 fichiers) 
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName2))) {
                int keyIndex = 0;
                int b = 0;
                while (b != -1) {
                    b = in.read();
                    if (b != -1) {
                        int b2 = b - ((int) key.charAt(keyIndex));
                        keyIndex = (keyIndex + 1) % key.length();
                        out.write(b2);
                    }
                }
            }

        } else //clé vide provoque par défaut une exception StringIndexOutOfBoundsException
        {
            throw new EmptyEncryptionKeyException();
        }
    }
}