/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f1_5_recursive;

import java.util.HashMap;

/**
 *
 * @author kas
 */
public class Calculations {

    //Exercice F1
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return power(x, n - 1) * x;
        } else /* n<0*/ {
            return 1 / power(x, -n);
        }
    }

    //Exercice F2
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
    
     /**
     * EX F3 unknown method 'machin'
     *
     * @param x integer number
     * @return ??
     */
    public static boolean machin(int x) {
        if (x == 0) {
            return true;
        } else {
            return !machin(x - 1);
        }
    }

    /**
     * EX F3 unknown method 'truc'
     *
     * @param x double number
     * @param y integer number
     * @return ??
     */
    public static double truc(double x, int y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            return truc(Math.pow(x, 2), y / 2);
        } else {
            return truc(x, y - 1) * x;
        }
    }

    //Exercice F4
    public static long fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    //Exercice F5
    public static double newton(double a, int n) {
        if (n == 0) {
            return a;
        } else {
            double res = newton(a, n - 1);
            return 0.5 * (res + (a / res));
        }
    }

    /**
     * Calculate factorial recursively
     *
     * @param n positive integer number
     * @return n!
     */
    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    /**
     * Exercice F6: Taylor Series *
     */
    /**
     * Calculate e^x recursively
     *
     * @param x base number (double)
     * @param n recursion depth (integer)
     * @return e^x
     */
    public static double exp(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return exp(x, n - 1) + power(x, n) / factorial(n);
        }
    }

    /**
     * Calculate cos(x) recursively
     *
     * @param x angle in radians (double)
     * @param n recursion depth (integer)
     * @return cos(x)
     */
    public static double cos(double x, int n) {
        if (n == 0) {
            return 1 - power(x, 2) / factorial(2);
        } else {
            return cos(x, n - 1) + power(x, 4 * n) / factorial(4 * n)
                    - power(x, 4 * n + 2) / factorial(4 * n + 2);
        }
    }

    /**
     * Calculate sin(x) recursively
     *
     * @param x angle in radians (double)
     * @param n recursion depth (integer)
     * @return sin(x)
     */
    public static double sin(double x, int n) {
        if (n == 0) {
            return x - power(x, 3) / factorial(3);
        } else {
            return sin(x, n - 1) + power(x, 4 * n + 1) / factorial(4 * n + 1)
                    - power(x, 4 * n + 3) / factorial(4 * n + 3);
        }
    }

    /**
     * Calculate cos(x) recursively - version 2
     *
     * @param x angle in radians (double)
     * @param n recursion depth (integer)
     * @return cos(x)
     */
    public static double cos2(double x, int n) {
        if (n < 0) {
            return 0;
        } else {
            return cos2(x, n - 1) + power(x, 4 * n) / factorial(4 * n)
                    - power(x, 4 * n + 2) / factorial(4 * n + 2);
        }
    }

    /**
     * Calculate sin(x) recursively - version 2
     *
     * @param x angle in radians (double)
     * @param n recursion depth (integer)
     * @return sin(x)
     */
    public static double sin2(double x, int n) {
        if (n < 0) {
            return 0;
        } else {
            return sin2(x, n - 1) + power(x, 4 * n + 1) / factorial(4 * n + 1)
                    - power(x, 4 * n + 3) / factorial(4 * n + 3);
        }
    }

}
