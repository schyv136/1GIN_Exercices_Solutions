/**
 * Collection of (static)recursive methods
 * 
 * @author     fred
 * @version    20/11/2011 19:48:21
 */
public class RecursiveUtils
{
	/**  Calculate factorial recursively
	 * @param n    positive integer number
	 * @return     n!
	 */
	public static double factorial(int n)
	{
		if (n==0) 	return 1;
		else 		return n * factorial(n-1);
	}


    	/**  EX B15 
	 * Calculate x^n recursively	 
	 * @param x    base number
	 * @param n    exponent (integer)
	 * @return     x power n
	 */
	public static double power(double x, int n)
	{
		if (n==0)     return 1;
	     else if (n>0) return power(x,n-1)*x;
	     else /* n<0*/ return 1/power(x,-n);
	}

	/**  EX B16 
	 * Calculate greatest common divisor of x and y recursively	 
	 * @param x    integer number
	 * @param y    integer number
	 * @return     gcd of x and y
	 */
	public static double gcd(int x, int y)
	{
		if (y==0) return x;
	     else 	return gcd(y,x%y);
	}

	
	/**  EX B17 unknown method 'machin' 
	 * @param x    integer number
	 * @return     ??
	 */
	public static boolean machin(int x)
	{
		if (x==0) return true;
		else return !machin(x-1);
	}

	/**  EX B17 unknown method 'truc' 
	 * @param x    double number
	 * @param y    integer number
	 * @return     ??
	 */
	public static double truc( double x, int y)
	{
		if (y==0) return 1;
		else if (y%2==0) return truc(Math.pow(x,2),y/2);
		else return truc(x,y-1) * x;
	}

	/**  EX B19 calculate square root recursively 
	 *   using Newton algorithm 
	 * @param a    double number
	 * @param n	recursion depth
	 * @return     square root of a
	 */
	public static double newton( double a, int n )
	{
		if (n==0) return a;
		else
		{
			double res = newton(a,n-1);
			return 1.0/2 * (res + a/res);
		}		
	}

    /** Taylor Series **/
    
	/**  
	 * Calculate e^x recursively	 
	 * @param x    base number (double)
	 * @param n    recursion depth (integer)
	 * @return     e^x
	 */
	public static double exp(double x, int n)
	{
		if (n==0)	return 1;
	     else		return exp(x,n-1) + power(x,n)/factorial(n);
	}

	/**   
	 * Calculate cos(x) recursively	 
	 * @param x    angle in radians (double)
	 * @param n    recursion depth (integer)
	 * @return     cos(x)
	 */
	public static double cos(double x, int n)
	{
		if (n==0)	return 1 - power(x,2)/factorial(2);
	     else		return cos(x,n-1) + power(x,4*n)   / factorial(4*n) -
	     						power(x,4*n+2) / factorial(4*n+2);
	}

	/**   
	 * Calculate sin(x) recursively	 
	 * @param x    angle in radians (double)
	 * @param n    recursion depth (integer)
	 * @return     sin(x)
	 */
	public static double sin(double x, int n)
	{
		if (n==0)	return x - power(x,3)/factorial(3);
	     else		return sin(x,n-1) + power(x,4*n+1) / factorial(4*n+1) -
	     						power(x,4*n+3) / factorial(4*n+3);
	}

	/**  
	 * Calculate cos(x) recursively - version 2	 
	 * @param x    angle in radians (double)
	 * @param n    recursion depth (integer)
	 * @return     cos(x)
	 */
	public static double cos2(double x, int n)
	{
		if (n==-1) return 0;
	     else		 return cos2(x,n-1) + power(x,4*n)   / factorial(4*n) -
	     						  power(x,4*n+2) / factorial(4*n+2);
	}

	/**  
	 * Calculate sin(x) recursively - version 2	 
	 * @param x    angle in radians (double)
	 * @param n    recursion depth (integer)
	 * @return     sin(x)
	 */
	public static double sin2(double x, int n)
	{
		if (n==-1) return 0;
	     else		 return sin2(x,n-1) + power(x,4*n+1) / factorial(4*n+1) -
	     						  power(x,4*n+3) / factorial(4*n+3);
	} 
	
}