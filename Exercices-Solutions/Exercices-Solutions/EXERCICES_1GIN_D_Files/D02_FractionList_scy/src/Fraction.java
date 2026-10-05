
import java.io.Serializable;

/**
 * La classe Fraction sert à effectuer des opérations 
 * standard entre fractions
 * 
 * @author	Fred Faber
 * @version	17/08/2011
 */
public class Fraction implements Serializable
{

    /** 
     * Les attributs de la fraction: 
     * numérateur et dénominateur de la fraction
     */
    protected int numerator;
    protected int denominator;

    /**
	* Constructeur de la classe Fraction
	* @param pNumerator	 	le numérateur de la nouvelle fraction
	* @param pDenominator	le dénominateur de la nouvelle fraction
	*/
    public Fraction(int pNumerator, int pDenominator) 
    {
        setFraction(pNumerator,pDenominator);
    }

	/**
	 * Constructeur de la classe Fraction à partir d'un
	 * nombre décimal
	 * @param pDecimal    le nombre décimal
	 */
	public Fraction(double pDecimal)
	{
		int d=1;
		while ( (int)pDecimal != pDecimal )
		{
			pDecimal = pDecimal * 10;
			d = d * 10;
		}
		setFraction((int)pDecimal, d);
		simplify(); 
	}

    public final void setNumerator(int pNumerator) 
    {
        numerator   = pNumerator;
    }

    public final void setDenominator(int pDenominator) 
    {
        if (pDenominator!=0) 
        	  denominator = pDenominator;
        else 
            throw new IllegalArgumentException("Invalid Fraction : Denominator must not be zero");
    }

    /**
     * Réinitialisation: Attribuer une nouvelle valeur à la fraction
     * @param pNumerator      la nouvelle valeur pour le numérateur
     * @param pDenominator    la nouvelle valeur pour le dénominateur 
     */
    public final void setFraction(int pNumerator, int pDenominator) 
    {
        setNumerator  (pNumerator);
        setDenominator(pDenominator);
    }

    public int getNumerator() 
    {
        return numerator;
    }

    public int getDenominator() 
    {
        return denominator;
    }
    
    /**
	 * Retourner une représentation textuelle de la fraction.
	 * @return	le texte représentant la fraction
	 */
    public String toString() 
    {
        if (denominator != 1)
        	return numerator +" / "+denominator +"  ("+getDecimal()+")";
        else 
        	return numerator                    +"  ("+getDecimal()+")";
    }
    
    /**
	 * Retourner la valeur de la fraction comme nombre décimal
	 * attention à la conversion forcée en double!
	 *
	 * @return   le nombre décimal correspondant à la fraction
	 */
    public double getDecimal() 
    {
        	return (double)numerator / denominator;
    }
    
	/**
	 * Verifier si la fraction représente un nombre négatif ou non.
	 * 
	 */
	public boolean isNegative()
	{
		return getDecimal() < 0;
	}

    /**
	 * Calcul du PGCD (plus grand commun diviseur) 
	 * de deux nombres entiers par l'algorithme d'Euclide
	 * 
	 * @param pA  premier nombre
	 * @param pB  second nombre
	 * @return  le PGCD de a et b
	 */
    public int gcd(int pA, int pB) 
    {
    	   //Version 2 (division euclidienne)
        int a = Math.abs(pA);
        int b = Math.abs(pB);
        int help;
        while (a%b != 0)
        {
        	help = a % b;
        	a = b;
        	b = help;
        }
        return b;
    }

    /**
	 * Calcul du PPCM (plus petit commun multiple)
	 * de deux nombres entiers
	 * @param pA  premier nombre
	 * @param pB  deuxième nombre
	 * @return  le PPCM de a et b
	 */
    public int lcm(int pA, int pB) 
    {
        return Math.abs(pA*pB)/gcd(pA,pB);
    }

    /** Simplifier la fraction */
    public void simplify() 
    {
        	int g=gcd(numerator,denominator);
        	numerator   = numerator   / g;
        	denominator = denominator / g;
    }

    /**
	 * Additionner une fraction donnée à la fraction actuelle
	 * @param pFract	 la fraction à ajouter
	 */
    public void add(Fraction pFract) 
    {
        numerator   = numerator*pFract.denominator + denominator*pFract.numerator;
        denominator = denominator * pFract.denominator;
        simplify();
    }

    /**
	 * Soustraire une fraction donnée de la fraction actuelle
	 * @param pFract	 la fraction à soustraire
	 */
    public void subtract(Fraction pFract) 
    {
        numerator   = numerator   * pFract.denominator - denominator*pFract.numerator;
        denominator = denominator * pFract.denominator;
        simplify();
    }

    /**
	 * Multiplier la fraction actuelle par une fraction donnée
	 * @param pFract	 la fraction à multiplier
	 */
    public void multiply(Fraction pFract) 
    {
        numerator   = numerator   * pFract.numerator;
        denominator = denominator * pFract.denominator;
        simplify();
    }

    /**
	 * Diviser la fraction actuelle par une fraction donnée 
	 * @param pFract	 la fraction par laquelle il faut diviser
	 */
    public void divide(Fraction pFract) 
    {
        if (pFract.getDecimal()!=0)
        {
        	numerator   = numerator   * pFract.denominator;
        	denominator = denominator * pFract.numerator;
        	simplify();
        }
        else 
            //throw new ArithmeticException("Invalid Operation : Division by zero");
            throw new DivisionByZeroException("Invalid Operation : Division by zero"); //Les constructeurs ne sont pas hérités!
    }

}