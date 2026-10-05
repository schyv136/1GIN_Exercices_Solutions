
/**
 *
 * @author SchYv136
 */
public class Cryptor {

   private static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String message, String key) {
        String strEncrypted = "";
        key = key.toUpperCase();
        int keyIndex = 0;
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            int shift = ALPHABET.indexOf(key.charAt(keyIndex)) + 1;
            if (currentChar >= 'A' && currentChar <= 'Z') {
                int code = (ALPHABET.indexOf(currentChar) + shift) % 26;
                strEncrypted = strEncrypted + ALPHABET.charAt(code);
            } else if (currentChar >= 'a' && currentChar <= 'z') {
                int code = (alphabet.indexOf(currentChar) + shift) % 26;
                strEncrypted = strEncrypted + alphabet.charAt(code);
            } else {
                strEncrypted = strEncrypted + currentChar;
            }
            keyIndex = (keyIndex + 1) % key.length();
        }
        return strEncrypted;
    }

    public static String decrypt(String message, String key) {
        String strEncrypted = "";
        key = key.toUpperCase();
        int keyIndex = 0;
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            int shift = ALPHABET.indexOf(key.charAt(keyIndex)) + 1;
            if (currentChar >= 'A' && currentChar <= 'Z') {
                int code = ALPHABET.indexOf(currentChar) - shift;
                if(code<0){code+=26;}
                strEncrypted = strEncrypted + ALPHABET.charAt(code);
            } else if (currentChar >= 'a' && currentChar <= 'z') {
                int code = alphabet.indexOf(currentChar) - shift;
                if(code<0){code+=26;}
                strEncrypted = strEncrypted + alphabet.charAt(code);
            } else {
                strEncrypted = strEncrypted + currentChar;
            }
            keyIndex = (keyIndex + 1) % key.length();
        }
        return strEncrypted;
    }

    public static String encrypt2(String message, String key) {
        String strEncrypted = "";
        key = key.toUpperCase();   // 0,5
        int keyIndex = 0;          // 0,5
        for (int i = 0; i < message.length(); i++) {  // 0,5
            char currentChar = message.charAt(i);
            int shift = (int) key.charAt(keyIndex) - (int) 'A' + 1;
            int code = (int) (currentChar + shift);
            if (currentChar >= 'A' && currentChar <= 'Z') {
                if (code > 90) {
                    code = code - 26;
                }
                strEncrypted = strEncrypted + (char) code;
            } else if (currentChar >= 'a' && currentChar <= 'z') {
                if (code > 122) {
                    code = code - 26;
                }
                strEncrypted = strEncrypted + (char) code;
            } else {
                strEncrypted = strEncrypted + currentChar;
            }

            keyIndex = (keyIndex + 1) % key.length();
        }
        return strEncrypted;
    }


    public static String decrypt2(String message, String key) {
        String strDecrypted = "";
        key = key.toUpperCase();   // 0,5
        int keyIndex = 0;          // 0,5
        for (int i = 0; i < message.length(); i++) {  // 0,5
            char currentChar = message.charAt(i);
            int shift = (int) key.charAt(keyIndex) - (int) 'A' + 1;
            int code = (int) (currentChar - shift);
            if (currentChar >= 'A' && currentChar <= 'Z') {
                if (code < 65) {
                    code = code + 26;
                }
                strDecrypted = strDecrypted + (char) code;
            } else if (currentChar >= 'a' && currentChar <= 'z') {
                if (code < 97) {
                    code = code + 26;
                }
                strDecrypted = strDecrypted + (char) code;
            } else {
                strDecrypted = strDecrypted + currentChar;
            }

            keyIndex = (keyIndex + 1) % key.length();
        }
        return strDecrypted;
    }
}
