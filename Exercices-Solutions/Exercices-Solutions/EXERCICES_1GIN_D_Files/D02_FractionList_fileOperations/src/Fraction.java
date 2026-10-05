
import java.io.Serializable;

public class Fraction implements Serializable {

    protected int numerator;
    protected int denominator;

    public Fraction(int pNumerator, int pDenominator) {
        setFraction(pNumerator, pDenominator);
    }

    public Fraction(double decimal) {
        double pDecimal = decimal;
        int d = 1;
        while ((int) pDecimal != pDecimal) {
            pDecimal = pDecimal * 10;
            d = d * 10;
        }
        setFraction((int) pDecimal, d);
        simplify();
    }

    public final void setNumerator(int pNumerator) {
        numerator = pNumerator;
    }

    public final void setDenominator(int pDenominator) {
        if (pDenominator != 0) {
            denominator = pDenominator;
        } else {
            throw new IllegalArgumentException("Invalid Fraction : Denominator must not be zero");
        }
    }

    public final void setFraction(int pNumerator, int pDenominator) {
        setNumerator(pNumerator);
        setDenominator(pDenominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        if (denominator != 1) {
            return numerator + " / " + denominator + "  (" + getDecimal() + ")";
        } else {
            return numerator + "  (" + getDecimal() + ")";
        }
    }

    public double getDecimal() {
        return (double) numerator / denominator;
    }

    public boolean isNegative() {
        return getDecimal() < 0;
    }

    public int gcd(int pA, int pB) {
        int a = Math.abs(pA);
        int b = Math.abs(pB);
        int help;
        while (a % b != 0) {
            help = a % b;
            a = b;
            b = help;
        }
        return b;
    }

    public int lcm(int pA, int pB) {
        return Math.abs(pA * pB) / gcd(pA, pB);
    }

    public void simplify() {
        int g = gcd(numerator, denominator);
        numerator = numerator / g;
        denominator = denominator / g;
    }

    public void add(Fraction pFract) {
        numerator = numerator * pFract.denominator + denominator * pFract.numerator;
        denominator = denominator * pFract.denominator;
        simplify();
    }

    public void subtract(Fraction pFract) {
        numerator = numerator * pFract.denominator - denominator * pFract.numerator;
        denominator = denominator * pFract.denominator;
        simplify();
    }

    public void multiply(Fraction pFract) {
        numerator = numerator * pFract.numerator;
        denominator = denominator * pFract.denominator;
        simplify();
    }

    public void divide(Fraction pFract) {
        if (pFract.getDecimal() != 0) {
            numerator = numerator * pFract.denominator;
            denominator = denominator * pFract.numerator;
            simplify();
        } else //throw new ArithmeticException("Invalid Operation : Division by zero");
        {
            throw new DivisionByZeroException("Invalid Operation : Division by zero");
        }
    }

}
