/**
 * Replace for loops with recursion
 * @author     fred
 * @version    20/11/2011 22:17:23
 */
public class RecursiveForce
{

	/**
	 * Replacement for this loop:
	 * for (int i=1 ; i<=10 ; i++) System.out.println(i);
	 * Call with recuSimpleUp(1);
	 */
	public static void recuSimpleUp(int i)
	{
		if (i<=10)
		{
			System.out.println(i);
			recuSimpleUp(i+1); 
		}
	}

	
	/**
	 * Replacement for this loop:
	 * for (int i=1 ; i<=10 ; i++) System.out.println(i);
	 * Call with recuSimpleUp(10);
	 */
	public static void recuSimpleDown(int i)
	{
		if (i>=1)
		{
			recuSimpleDown(i-1); 
			System.out.println(i);
		}
	}

	/**
	 * Replacement for this loop:
	 * for (int i=1 ; i<=n ; i++) <Instruction bloc>;
	 * Call with recuSimpleDown(n);
	 */
	 /*
	public static void recuSimpleDown(int i)
	{
		if (i>=1)
		{
			recuSimpleDown(i-1); 
			//<Instruction bloc>;
		}
	}
	*/

	/**
	 * Replacement for this loop:
	 * for (int i=0 ; i<=3 ; i++)
		for (int j=0 ; j<=9 ; j++)
			System.out.println(i * 10 + j);
	 * Call with recuDouble(0,0);
	 */
	public static void recuDouble(int i, int j)
	{
		if (i<=3)
		{
			if (j<=9)
			{
				System.out.println(i*10+j);
				recuDouble(i, j+1); 
			}
			else recuDouble(i+1, 0); 
		}
	}


	/**
	 * Replacement for this loop:
	 * for (int i=0 ; i<=n ; i++)
		for (int j=0 ; j<=m ; j++)
			<Instruction bloc>;
	 * Call with recuDouble2(0,0, n, m);
	 */	 
	public static void recuDouble2(int i, int j, int n, int m)
	{
		if (i<=n)
		{
			if (j<=m)
			{
				System.out.print(i*10+j+"  ");
				recuDouble2(i, j+1, n, m); 
			}
			else 
            {
                System.out.println(); //retour à la ligne
				recuDouble2(i+1, 0, n, m);
            } 
		}
	}
	
	
    /**
	 * The main entry point for executing this program.
	 */
    public static void main(String[] args) 
    {
        recuSimpleUp(1);
        recuSimpleDown(10);
        recuDouble2(0,0, 5, 8);
    }



    
}