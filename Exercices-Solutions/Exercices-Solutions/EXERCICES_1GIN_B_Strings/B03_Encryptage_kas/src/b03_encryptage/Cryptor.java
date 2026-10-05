/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b03_encryptage;

/**
 *
 * @author kas
 */
public class Cryptor {

    private String capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String smalls = "abcdefghijklmnopqrstuvwxyz";
    private char capShifted[] = new char[26];
    private char smaShifted[] = new char[26];

    public void shiftByN(int N) {
        int idx = N;
        for (int i = 0; i < 26; i++) {
            capShifted[i] = capitals.charAt(idx);
            smaShifted[i] = smalls.charAt(idx);
            idx++;
            if ((idx) > 25) {
                idx = 0;
            }
        }
    }

    public String encrypt(String message) {
        String strEncrypted = "";
        int pos = 0;
        
        for (int i = 0; i < message.length(); i++) {
            if (message.substring(i, i + 1).equals(" ")) {
                strEncrypted = strEncrypted + " ";
            } else if (capitals.indexOf(message.charAt(i)) >= 0) {
                pos = capitals.indexOf(message.charAt(i));
                strEncrypted = strEncrypted + capShifted[pos];
            } else if (smalls.indexOf(message.charAt(i)) >= 0) {
                pos = smalls.indexOf(message.charAt(i));
                strEncrypted = strEncrypted + smaShifted[pos];
            }
        }

        return strEncrypted;
    }
    
    
    public String decrypt(String message){
        String strDecrypted = "";
        int pos = 0;
        String strCapitalsShifted = new String(capShifted);
        String strSmallsShifted = new String(smaShifted);
        
        for (int i = 0; i < message.length(); i++) {
            if (message.substring(i, i + 1).equals(" ")) {
                strDecrypted = strDecrypted + " ";
            } else if (strCapitalsShifted.indexOf(message.charAt(i)) >= 0) {
                pos = strCapitalsShifted.indexOf(message.charAt(i));
                strDecrypted = strDecrypted + capitals.charAt(pos);
            } else if (strSmallsShifted.indexOf(message.charAt(i)) >= 0) {
                pos = strSmallsShifted.indexOf(message.charAt(i));
                strDecrypted = strDecrypted + smalls.charAt(pos);
            }
        }
        
        return strDecrypted;
    }

    public String encryptAscii(String message, int shift){
        String strEncrypted = "";
        
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (currentChar >='A' && currentChar <='Z'){
                int code = (int)(currentChar + shift);
                if (code > 90){
                    code  = code - 26;
                }
                strEncrypted = strEncrypted + (char)code;
            } else if (currentChar >='a' && currentChar <='z'){
                int code = (int)(currentChar + shift);
                if (code > 122){
                    code  = code - 26;
                }
                strEncrypted = strEncrypted + (char)code;
            } else {
                strEncrypted = strEncrypted + currentChar;
            }
        }        
        return strEncrypted;
    }

    public String decryptAscii(String message, int shift){
        String strDecrypted = "";
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (currentChar >='A' && currentChar <='Z'){
                int code = (int)(currentChar - shift);
                if (code < 65){
                    code  = code + 26;
                }
                strDecrypted = strDecrypted + (char)code;
            } else if (currentChar >='a' && currentChar <='z'){
                int code = (int)(currentChar - shift);
                if (code < 97){
                    code  = code + 26;
                }
                strDecrypted = strDecrypted + (char)code;
            } else {
                strDecrypted = strDecrypted + currentChar;
            }
        }        
        return strDecrypted;
    }

    public String encryptVigenere(String message, String key){
        String strEncrypted = "";
        key = key.toUpperCase();   // 0,5
        int keyIndex = 0;          // 0,5
        for (int i = 0; i < message.length(); i++) {  // 0,5
            char currentChar = message.charAt(i);
            int shift = (int)key.charAt(keyIndex)-(int)'A'+1;
            int code = (int)(currentChar + shift);
            if (currentChar >='A' && currentChar <='Z'){
                if (code > 90){
                    code  = code - 26;
                }
                strEncrypted = strEncrypted + (char)code;
            }
            else if (currentChar >='a' && currentChar <='z'){
                if (code > 122){
                    code  = code - 26;
                }
                strEncrypted = strEncrypted + (char)code;
            }
            else{
                strEncrypted = strEncrypted + currentChar;
            }
            
            keyIndex = (keyIndex + 1) % key.length();
        }
        return strEncrypted;
    }

    public String decryptVigenere(String message, String key){
       String strEncrypted = "";
        key = key.toUpperCase();   // 0,5
        int keyIndex = 0;          // 0,5
        for (int i = 0; i < message.length(); i++) {  // 0,5
            char currentChar = message.charAt(i);
            int shift = (int)key.charAt(keyIndex)-(int)'A'+1;
            int code = (int)(currentChar - shift);
            if (currentChar >='A' && currentChar <='Z'){
                if (code < 65){
                    code  = code + 26;
                }
                strEncrypted = strEncrypted + (char)code;
            }
            else if (currentChar >='a' && currentChar <='z'){
                if (code < 97){
                    code  = code + 26;
                }
                strEncrypted = strEncrypted + (char)code;
            }
            else{
                strEncrypted = strEncrypted + currentChar;
            }
            
            keyIndex = (keyIndex + 1) % key.length();
        }
        return strEncrypted;
    }
    
    
}
