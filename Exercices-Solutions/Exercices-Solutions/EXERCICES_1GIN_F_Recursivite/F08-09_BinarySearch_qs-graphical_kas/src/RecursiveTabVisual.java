import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class RecursiveTabVisual extends JPanel
{
	private int tab[];  //contains the data to be sorted
    //position of colored stripes (indices) while sorting
    private int activeIndex0 = -1;
    private int activeIndex1 = -1;
    private int activeIndex2 = -1;
    private int activeIndex3 = -1;

    
    //true <=> quick execution of algorithms (i.e. only show outer loops)
    static private boolean fastForward = false;
        
    private int n=0;    //number of values to be sorted
    private int min=0;  //smallest possible value in array
 	private int max=0;  //biggest  possible value in array
        
    
    //enable quick execution 
    //(only works if sorting is started in a different thread than mainFrame)
    static public void fastForward() {
            fastForward = true;
    }
 	
 	public void fill(int n, int min, int max)
	{
               tab = new int[n];
		for (int i=0 ; i<tab.length ; i++)
		{
			tab[i] = (int)(Math.random()*(max-min+1)) + min;
		}     
                this.n   = n;
                this.min = min;
                this.max = max;
                this.paintImmediately(0,0,getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<
      	}

        @Override
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

	public void selSort()
	{
        fastForward = false;
		int pmin;
		for (int i=0 ; i<tab.length-1 ; i++)
		{
			pmin=i;
			for (int j=i+1 ; j<tab.length ; j++)
			{
				if (tab[j]<tab[pmin]) pmin=j;
                                activeIndex1 = i;
                                activeIndex2 = j;                                
                                activeIndex3 = pmin;
                                if (!fastForward) this.paintImmediately(0,0,getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<
			}
            if (i!=pmin)
                        {
                                int help  = tab[pmin];
                                tab[pmin] = tab[i];
                                tab[i]    = help;

                        }	
            activeIndex1 = i;
            activeIndex2 = -1;                
            activeIndex3 = -1;
            this.paintImmediately(0,0,getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<
        }
        activeIndex1 = -1;
        activeIndex2 = -1;                
        activeIndex3 = -1;
        this.paintImmediately(0,0,getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<
        fastForward = false;
    }

	public void bubbleSort()
	{
        fastForward = false;
		for (int i=0 ; i<tab.length ; i++)
		{
			for (int j=0 ; j<tab.length-i-1 ; j++)    
			{
                activeIndex1 = tab.length-i-1;
                activeIndex2 = j; 
                activeIndex3 = j+1;         
                
                if (!fastForward) this.paintImmediately(0, 0, getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<
				if (tab[j]>tab[j+1]){
                    int help = tab[j+1];
                    tab[j+1] = tab[j];
                    tab[j]   = help;
                }
                activeIndex1 = tab.length-i-1;
                activeIndex2 = j; 
                activeIndex3 = j+1;
                if (!fastForward) this.paintImmediately(0, 0, getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<
			}
            activeIndex1 = tab.length-i-1;;
            activeIndex2 = -1;                
            activeIndex3 = -1;                
            this.paintImmediately(0,0,getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<
        }
        activeIndex1 = -1;
        activeIndex2 = -1; 
        activeIndex3 = -1;                
        this.paintImmediately(0,0,getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<
        fastForward = false;
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
                activeIndex0 = left;
		activeIndex1 = right;
		while (i<j) 
		{
			while (i<right && tab[i]<=pivot) i++;
			while (j>left  && tab[j]>=pivot) j--;
			if (i<j)
			{
				int help = tab[i];
				tab[i]   = tab[j];
				tab[j]   = help;
			}
                        activeIndex2 = i;
                        activeIndex3 = j;
                        if (!fastForward) this.paintImmediately(0,0,getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<

		}
		if(tab[i]>pivot) 
                {
                    tab[right] = tab[i];
                    tab[i]     = pivot;                
                }
                activeIndex2 = i;
                activeIndex3 = j;
                if (!fastForward) this.paintImmediately(0,0,getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<
                activeIndex0 = -1;
                activeIndex1 = -1;
                activeIndex2 = -1;
                activeIndex3 = -1;
                
                return i;	
	}

	public void qs(int left, int right)
	{
            fastForward = false;
            qs1(left, right);
            activeIndex0 = -1;            
            activeIndex1 = -1;
            activeIndex2 = -1;                
            activeIndex3 = -1;
            this.paintImmediately(0,0,getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<

        }
        
    public void qs1(int left, int right)
	{
        activeIndex0 = left;
        activeIndex1 = right;
        activeIndex2 = -1;                
        activeIndex3 = -1;
        this.paintImmediately(0,0,getWidth(), getHeight()); //<<<<<<<<<<<<<<<<<<
        if (left<right)
		{
			int p = partition (left, right);
			qs1(left , p-1);
			qs1(p+1  , right);
		}
	}

  

   private void paintGraph(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        g.setColor(Color.WHITE);
        g.clearRect(0, 0, w, h);
        
        if (n>0) {
            int cellWidth = Math.max(1, w/n);
            double vertZoom = (double)h/(max-min);

            for (int i=0 ; i<n ; i++) {
                g.setColor(Color.BLUE);
                if (activeIndex0>=0 && i == activeIndex0) g.setColor(Color.BLACK);
                if (activeIndex1>=0 && i == activeIndex1) g.setColor(Color.BLACK);
                if (activeIndex2>=0 && i == activeIndex2) g.setColor(Color.ORANGE);
                if (activeIndex3>=0 && i == activeIndex3) g.setColor(Color.RED);

                int valHeight = (int)((tab[i]-min)*vertZoom);
                g.fillRect(i*cellWidth, h-valHeight, cellWidth, valHeight);
            }
        }
   }
        
    @Override
    protected void paintComponent(final Graphics  g) {
        if (tab!=null)
            paintGraph(g);
        /*
         * try {
            Thread.sleep(4);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
        * */
    } 
}