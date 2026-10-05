/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d04_encryptage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author kas
 */
public class Cryptor {

    public String encryptVigenere(String message, String key) {
        String keyUpper = key.toUpperCase();
        String strEncrypted = "";
        int keyIdx = 0;
        int shift = 0;
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (currentChar >= 'A' && currentChar <= 'Z') {
                shift = (int) keyUpper.charAt(keyIdx) - 64;
//                keyIdx++;
//                if (keyIdx >= keyUpper.length()){
//                    keyIdx = 0;
//                }
                keyIdx = (keyIdx + 1) % keyUpper.length();
                int code = (int) (currentChar + shift);
                if (code > 90) {
                    code = code - 26;
                }
                strEncrypted = strEncrypted + (char) code;

            } else if (currentChar >= 'a' && currentChar <= 'z') {
                shift = (int) keyUpper.charAt(keyIdx) - 64;
//                keyIdx++;
//                if (keyIdx >= keyUpper.length()){
//                    keyIdx = 0;
//                }
                keyIdx = (keyIdx + 1) % keyUpper.length();

                int code = (int) (currentChar + shift);
                if (code > 122) {
                    code = code - 26;
                }
                strEncrypted = strEncrypted + (char) code;
            } else {
                strEncrypted = strEncrypted + currentChar;
            }
        }
        return strEncrypted;
    }

    public String decryptVigenere(String message, String key) {
        String keyUpper = key.toUpperCase();
        String strDecrypted = "";
        int keyIdx = 0;
        int shift = 0;
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'Z') {
                shift = (int) keyUpper.charAt(keyIdx) - 64;
                keyIdx++;
                if (keyIdx >= keyUpper.length()) {
                    keyIdx = 0;
                }
                int code = (int) (currentChar - shift);
                if (code < 65) {
                    code = code + 26;
                }
                strDecrypted = strDecrypted + (char) code;

            } else if (currentChar >= 'a' && currentChar <= 'z') {
                shift = (int) keyUpper.charAt(keyIdx) - 64;
                keyIdx++;
                if (keyIdx >= keyUpper.length()) {
                    keyIdx = 0;
                }
                int code = (int) (currentChar - shift);
                if (code < 97) {
                    code = code + 26;
                }
                strDecrypted = strDecrypted + (char) code;

            } else {
                strDecrypted = strDecrypted + currentChar;
            }
        }
        return strDecrypted;
    }

    public String loadFromBinaryFile(String fileName, String key)
            throws FileNotFoundException, IOException {
        String message = "";
        try (DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))) {

            boolean eof = false;
            while (!eof) {
                try {
                    message = in.readUTF();
                } catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return decryptVigenere(message, key);
    }

    public void savceToBinaryFile(String fileName, String message)
            throws FileNotFoundException, IOException {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)))) {

            out.writeUTF(message);
            out.flush();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
