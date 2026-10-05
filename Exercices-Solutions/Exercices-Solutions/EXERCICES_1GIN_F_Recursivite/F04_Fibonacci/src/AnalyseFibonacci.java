import java.util.Scanner;
/**
 * Write a description of class "AnalyseFibonacci" here.
 * 
 * @author     fred
 * @version    20/11/2011 21:14:10
 */
public class AnalyseFibonacci
{

	/**
	 * Calculate n-th Fibonacci number recursively
	 * @param n    recursion depth / Fibonacci index
	 * @return     n-th Fibonacci number
	 */
	public static long fibo_r(int n)
	{
		if (n<=2) return 1;
		else	  return fibo_r(n-1) + fibo_r(n-2);
	}

	
	/**
	 * Calculate n-th Fibonacci number iteratively
	 * @param n    Fibonacci index
	 * @return     n-th Fibonacci number
	 */
	public static long fibo_i(int n)
	{
		if (n<=2) return 1;
		else
		{
			long xOld   = 1;
			long xOlder = 1;
			long xNew   = 2;
			for (int i=3 ; i<=n ; i++)
			{
				xNew   = xOld + xOlder;
				xOlder = xOld;
				xOld   = xNew; 
			}
			return xNew;
		}
	}

	/**
	 * Calculate number of recursive calls for fibo_r iteratively
	 * @param n    Fibonacci index
	 * @return     number of recursive calls
	 */
	public static long nar(int n)
	{
		return ( fibo_i(n)-1 )*2;
		
	}

	/**
	 * The main entry point for executing this program.
	 */
    public static void main(String[] args) 
    {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter a number for n : ");
        int n= sc.nextInt();
        
	long start = System.currentTimeMillis();
        long res = fibo_i(n);
        long stop = System.currentTimeMillis();
        System.out.println("fibo_i("+n+") = "+res);
        System.out.println("Time = "+(stop-start)/1000.0+"s");
        
        //System.out.println("Number of recursive calls : "+nar(n));
	start = System.currentTimeMillis();
        res = fibo_r(n);
        stop = System.currentTimeMillis();
        System.out.println("fibo_r("+n+") = "+res);
        System.out.println("Time = "+(stop-start)/1000.0+"s");
    }


}