public class RecursiveTabOperations
{

	private int tab[];

 	
 	public void fill(int n, int min, int max)
	{
		tab = new int[n];
		for (int i=0 ; i<tab.length ; i++)
		{
			tab[i] = (int)(Math.random()*(max-min+1)) + min;
		}
	}

	public String toString()
	{
		String res="";
		for (int i=0 ; i<tab.length-1 ; i++)
		{
			res = res + String.valueOf(tab[i]) + ", ";
			if ((i+1)%20==0) res=res+"\n";
		}
		if (tab.length>0) res=res+String.valueOf(tab[tab.length-1]) + "\n";
		return res;
	}

	public void printAll()
	{
		for (int i=0 ; i<tab.length-1 ; i++)
		{
			System.out.print(tab[i]+", ");
			if ((i+1)%20==0) System.out.println();
		}
		if (tab.length>0) System.out.println(tab[tab.length-1]);
	}

	public void selSort()
	{
		int pmin;
		for (int i=0 ; i<tab.length-1 ; i++)
		{
			pmin=i;
			for (int j=i+1 ; j<tab.length ; j++)
			{
				if (tab[j]<tab[pmin]) pmin=j;
			}
			if (i!=pmin)
			{
				int help  = tab[pmin];
				tab[pmin] = tab[i];
				tab[i]    = help;
			}			
		}
	}

	
	/**
	 * return the position of n inside the array tab
	 * linear iterative search
	 * @param n 	the number to look for
	 * @return 	the position of the value in th array or -1 if not found
	 */
	public int linearSearch_i(int n) //iterative
	{
		int res=-1;
		int i=0;
		while (i<tab.length && res==-1)
		{
			if (tab[i]==n) res=i;
			i++;
		}		
		return res;
	}
	

	/**
	 * return the position of n inside the array tab
	 * linear recursive search
	 * @param n 	the number to look for
	 * @param pos	the first position to check for the value n
	 * @return 	the position of the value in th array or -1 if not found
	 */
	public int linearSearch_r(int n, int pos) //recursive
	{
		if (pos >= tab.length) return -1;
		else if (tab[pos]==n) return pos;
		else return linearSearch_r(n, pos+1);
	}

	/**
	 * return the position of n inside the array tab
	 * binary recursive search
	 * @param n 		the number to look for
	 * @param left		the left limit of the interval to check for the value n
	 * @param right	the right limit of the interval to check for the value n
	 * @return 		the position of the value in th array or -1 if not found
	 */
	public int binarySearch(int n, int left, int right)
	{
		int mid = (left+right)/2;
		if (tab[mid]==n) return mid;
		else if (left>right) return -1;
		else if (tab[mid]<n) return binarySearch(n, mid+1, right);
		else  /*tab[mid]>n*/ return binarySearch(n, left,  mid-1);
	}

	private int partition (int left, int right)
	{
		int i = left;
		int j = right-1;
		int pivot = tab[right];
		while (i<j) 
		{
			while (i<right && tab[i]<=pivot) i++;
			while (j>left  && tab[j]> pivot) j--;
			if (i<j)
			{
				int help = tab[i];
				tab[i]   = tab[j];
				tab[j]   = help;
			}
		}
		tab[right] = tab[i];
		tab[i]     = pivot;
		return i;		
	}

	public void qs(int left, int right)
	{
		if (left<right)
		{
			int p = partition (left, right);
			qs(left , p-1);
			qs(p+1  , right);
		}
	}
 
}