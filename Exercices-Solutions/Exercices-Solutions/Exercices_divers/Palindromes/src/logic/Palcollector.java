/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author serge
 */
public class Palcollector {

    private ArrayList<Palindrome> alPalindrome = new ArrayList<>();

    public ArrayList<Palindrome> getAlPalindrome() {
        return alPalindrome;
    }

    public void load(String fileName) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while ((line = in.readLine()) != null) {   
                try {
                    Palindrome p = new Palindrome(line);
                    alPalindrome.add(p);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void save(String fileName) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < alPalindrome.size(); i++) {
                out.println(alPalindrome.get(i).getPalindrome());
            }
        }
    }
}
