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
public class B03_Encryptage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cryptor cr = new Cryptor();
        String encrypt = cr.encryptVigenere("Chiffre de Vigenere", "BAcHeLIER");
        System.out.println("Encrypted: " + encrypt);
        System.out.println("Decrypted: " + cr.decryptVigenere(encrypt, "BACHELIER"));

    }
    
}
