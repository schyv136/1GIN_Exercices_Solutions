package logic;


import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author yvonschubert
 */
public class Dots {
    private ArrayList<Dot> alDots=new ArrayList<>();
    
    public void add(Dot e)
    {
        alDots.add(e);
    }
    public void draw(Graphics g, int cellWidth)
    {
        for (Dot dot : alDots) {
            dot.draw(g, cellWidth);
        }
    }
    
    public void setArrayList(ArrayList<Dot> pAlDots)
    {
        alDots=pAlDots;
    }
    
    public ArrayList<Dot> getArrayList()
    {
        return alDots;
    }
}
