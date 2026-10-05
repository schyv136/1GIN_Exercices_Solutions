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
public class Calculations {

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return power(x, n - 1) * x;
        } else /* n<0*/ {
            return 1 / power(x, -n);
        }
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n < 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static double newton(double a, int n) {
        if (n == 0) {
            return a;
        } else {
            double res = newton(a, n-1);
            return 0.5*(res + (a/res));
        }
    }

}
