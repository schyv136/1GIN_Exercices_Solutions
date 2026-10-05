/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d04_encryptage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kas
 */
public class D04_Encryptage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String key = "BAcHeLIER";
        Cryptor cr = new Cryptor();
        String encrypt = cr.encryptVigenere("Chiffre de Vigenere", "BAcHeLIER");
        System.out.println("Encrypted: " + encrypt);
        try {
            cr.savceToBinaryFile("encrypt.dat", encrypt);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            System.out.println("Decrypted: " + cr.loadFromBinaryFile("encrypt.dat", key));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
