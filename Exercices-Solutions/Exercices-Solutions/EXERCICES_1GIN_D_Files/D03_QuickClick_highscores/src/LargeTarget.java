import java.awt.Color;
import java.awt.Graphics;

/**										//2p
 *					
 * @author fred
 */
public class LargeTarget extends Target {		

    public LargeTarget() {
        super();
        size = 40;
    }

    @Override
    public int getPoints() {
        return 10;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        super.draw(g);
    }
 
}