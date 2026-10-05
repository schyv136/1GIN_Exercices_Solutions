
import java.awt.Color;
import java.awt.Graphics;

/**												//17p
 * @author fred
 */
public abstract class Target {  					

    protected int x;		
    protected int y;
    protected int size;
    private int xStep;
    private int yStep;

    public Target() {							//3p
        x = Randomizer.getInt(30, 300);
        y = Randomizer.getInt(30, 300);
        xStep = Randomizer.getInt(-5, 5);
        yStep = Randomizer.getInt(-5, 5);        
    }
    
    public abstract int getPoints();				//1p
    
    public void draw(Graphics g) {					//3p
        g.fillRect(x-size/2, y-size/2, size, size);
        g.setColor(Color.BLACK);
        g.drawString(getPoints()+"", x-7, y+5);
    }
    
    public void doStep(int width, int height) {		//7p
        if      (xStep > 0 && x+size/2+xStep>=width)  xStep=-xStep;
        else if (xStep < 0 && x-size/2+xStep<=0)      xStep=-xStep;
        if      (yStep > 0 && y+size/2+yStep>=height) yStep=-yStep;
        else if (yStep < 0 && y-size/2+yStep<=0)      yStep=-yStep;
        x += xStep;
        y += yStep;
    }

    public boolean isInside(int pX, int pY) {		//3p
        return (pX >= x-size/2  &&  pX <= x+size/2 &&
                pY >= y-size/2  &&  pY <= y+size/2);
    }    
      
}