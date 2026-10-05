/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1_5_recursive;

/**
 *
 * @author kas
 */
public class F1_5_Recursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(Calculations.fibonacci(45));
        long stop = System.currentTimeMillis();
        System.out.println("Execution time: "+(stop-start));
    }
    
}
