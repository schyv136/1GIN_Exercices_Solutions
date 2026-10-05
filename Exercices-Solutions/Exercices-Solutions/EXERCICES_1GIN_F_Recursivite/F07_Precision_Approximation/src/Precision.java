/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author scy
 */
public class Precision {
    
   

    //methods from previous exercises
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return x * power(x, n - 1);
        } else {
            return 1 / power(x, -n);
        }
    }

    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static double newton(double a, int n) {
        if (n == 0) {
            return a;
        } else {
            double u_n = newton(a, n - 1);
            return 0.5 * (u_n + a / u_n);
        }
    }
    
    //*********************************************************************
    //exponential convergence
    //iterative precision Newton
    public static double newton_i(double a, double precision) {
        double current = newton(a, 0);
        double next = newton(a, 1);
        double delta = current - next;
        int n = 1;
        while (delta > precision) {
            current = next;
            next = newton(a, n + 1);
            delta = current - next;
            n++;
        }
        return next;
    }
    //Recursive precision newton
    public static double newton_pr(double a, double precision, double current) {
        double next = 0.5 * (current + a / current);
        if (current-next < precision) {
            return next;
        } else {
            return newton_pr(a, precision, next);
        }
    }
    //help function to avoid third parameter
    public static double newton_p(double a, double precision)
    {
        return newton_pr(a, precision, a);
    }
    
    //methods from previous exercise
    public static double exp(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return power(x, n) / factorial(n) + exp(x, n - 1);
        }
    }
    
    

    public static void main(String[] args) {
        System.out.println("e^2=" + exp(2.0, 100));
        System.out.println("sqrt(3)" + newton(3, 100));
        System.out.println("sqrt(2)" + newton_i(2, 0.001));
        System.out.println("sqrt(2)" + newton_p(2, 0.001));
        System.out.println("sqrt(3)" + newton_p(3, 0.0000001));
    }

}
