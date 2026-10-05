package logic;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;

public abstract class Block {
    
    private boolean marked = false;  //used during way finding
     
    public abstract void draw(Graphics g, int x, int y, int size);

    public int[] txtCenterCal(String txt, int SquareX, int SquareY, int size, Graphics g) {
        // calculate font size based on the size of the Square
        int fontSize = (int) (size * 0.4);
        // set font and font metrics
        Font font = new Font("Arial", Font.PLAIN, fontSize);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();

        // calculate text width and height
        int textWidth = fm.stringWidth(txt);
        int textHeight = fm.getHeight();

        // calculate x and y coordinates to center text
        int x = SquareX + (size - textWidth) / 2;
        int y = SquareY + (size - textHeight) / 2 + fm.getAscent();

        return new int[] { x, y };
    }

    public abstract boolean isWalkable();

    public String toString() {
        return "Block";
    }
    
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
