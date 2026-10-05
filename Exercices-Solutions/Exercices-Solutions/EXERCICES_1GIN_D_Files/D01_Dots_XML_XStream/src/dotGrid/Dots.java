package dotGrid;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author fabfr
 */
public class Dots {
    private ArrayList<Dot> alDots = new ArrayList<Dot>();

    public void add(Dot e) {
        alDots.add(e);
    }
    
    public void draw(Graphics g, int cellWidth) {
        for (int i=0; i<alDots.size() ; i++) 
            alDots.get(i).draw(g, cellWidth);
    }
      
}
