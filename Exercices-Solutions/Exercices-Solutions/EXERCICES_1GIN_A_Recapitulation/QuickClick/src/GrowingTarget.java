import java.awt.Color;
import java.awt.Graphics;

/**										//4p
 *	
 * @author fred
 */
public class GrowingTarget extends Target {		
    
    public GrowingTarget() {
        super();
        size = 5;
    }

    @Override
    public int getPoints() {
        return 50-size;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        super.draw(g);
    }

    @Override
    public void doStep(int width, int height) {
        size = size+5;
        if (size>50) size=5;
        super.doStep(width, height);
    }
      
}