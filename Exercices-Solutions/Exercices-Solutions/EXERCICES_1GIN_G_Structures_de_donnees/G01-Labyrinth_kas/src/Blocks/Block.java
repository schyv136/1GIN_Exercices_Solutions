package Blocks;

import java.awt.Graphics;

/**
 * @author fred
 */
public abstract class Block {
    private boolean marked = false;  //used during way finding
    
    public abstract void draw(int x, int y, Graphics g) ;
            
    //returns true only for Start, End, Grass blocs
    //simplifies tests and avoids use of instanceof
    public abstract boolean isWalkable(); 

    //used during way finding
    public boolean isMarked() {
        return marked;
    }

    public void mark() {
        marked = true;
    }
    
    public void unmark() {
        marked = false;
    }    
    
}