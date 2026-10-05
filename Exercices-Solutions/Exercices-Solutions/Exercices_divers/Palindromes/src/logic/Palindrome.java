/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author serge
 */
public class Palindrome {

    private String palindrome;

    public Palindrome(String word) throws Exception {

        if (isPalindrome(word)) {
            this.palindrome = word;
        } else {
            throw new Exception("No Palindrome");
        }
    }

    public boolean isPalindrome(String word) {
        return word.toLowerCase().equals(reverse(word));
    }

    public static String reverse(String target) {
        String org = target.toLowerCase();
        String result = "";
        for (int i = 0; i < org.length(); i++) {
            result = org.charAt(i) + result;
        }
        return result;
    }

    public String getPalindrome() {
        return palindrome;
    }

}
