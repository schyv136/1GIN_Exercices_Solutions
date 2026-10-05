import java.awt.Graphics;

/**
 * @author     fred
 * @version    20/11/2011 22:38:28
 */
public class Hanoi {
    private Moves moves = new Moves();
    private Tower[] arTowers = new Tower[3];

    private int  numberOfDisks;
    private byte from;
    private byte to;

    public Hanoi(int numberOfDisks, int from, int to) {
        this.numberOfDisks = numberOfDisks;
        this.from = (byte)from;
        this.to = (byte)to;
        if (numberOfDisks<=0 || numberOfDisks>64 || 
            from==to || from<1 || from>3 || to<1 || to>3) 
               throw new IllegalArgumentException("Hanoi: Invalid Arguments");
        
        //init Towers
        for (int i = 0; i < arTowers.length; i++) 
            arTowers[i] = new Tower(numberOfDisks);            
        //place Disks on Tower 'from'
        for (byte i = (byte)numberOfDisks; i >= 1 ; i--)
            arTowers[from-1].addDisk(i);    
    }

    public int getTo() {
        return to;
    }

    public int getFrom() {
        return from;
    }

    public int getNumberOfDisks() {
        return numberOfDisks;
    }

    /**
     * The main entry point for executing this program.
     */
    public void calculateMoves() {
        moves = new Moves();
        hanoi( numberOfDisks, from, to );
    }

	/**
	 * Print all steps to resolve the hanoi Problem for
	 * n Disks to be moved from i to j
	 * @param n    number of disks to move
	 * @param i    source pile
	 * @param j    destination pile
	 */
	public void hanoi(int n, byte i, byte j)
	{
		if (n>0)
		{	
			hanoi( n-1, i, (byte)(6-(i+j)));
			moves.add(new Move(i,j));
			hanoi( n-1, (byte)(6-(i+j)), j);		
		}
	}

    public int numberOfMoves() {
        return moves.size();
    }

    public int getCurrentMove() {
        return moves.getCurrentMove();
    }

    public Object[] toArray() {
        return moves.toArray();
    }

    public boolean makeNextMove() {
        Move move = moves.getNext();   
        if (move == null)
            return false;
        else {
            //System.out.println(move);
            arTowers[move.getTo()-1].addDisk( arTowers[move.getFrom()-1].removeDisk() );
            return true;
        }        
    }
    
    public void draw(Graphics g, int width, int height) {
        for (int i = 0; i < arTowers.length; i++) {
            arTowers[i].draw(g, i*width/3, width/3, height);            
        }
    }
    
}