/**
 * Write a description of class "Hanoi" here.
 * 
 * @author     fred
 * @version    20/11/2011 22:38:28
 */
public class Hanoi
{

	
    /**
	 * The main entry point for executing this program.
	 */
    public static void main(String[] args) 
    {
        hanoi(10, 1, 2);
    }

	/**
	 * Print all steps to resolve the hanoi Problem for
	 * n Disks to be moved from i to j
	 * @param n    number of disks to move
	 * @param i    source pile
	 * @param j    destination pile
	 */
	public static void hanoi(int n, int i, int j)
	{
		if (n>0)
		{	
			hanoi(n-1, i, 6-(i+j));
			System.out.println(i+" --> "+j);
			hanoi(n-1, 6-(i+j), j);		
		}
	}
}