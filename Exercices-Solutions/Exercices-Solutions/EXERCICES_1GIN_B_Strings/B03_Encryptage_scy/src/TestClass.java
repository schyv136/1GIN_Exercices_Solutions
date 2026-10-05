/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SchYv136
 */
public class TestClass {

    public static void main(String[] args) {
        String s = "ABCD efgh,IJKL.MNOP-QRST_UVWX+YZ";
        String secret = Cryptor.encrypt(s, "Secret");
        System.out.println(secret);
        String clear = Cryptor.decrypt(secret, "Secret");
    }

}
