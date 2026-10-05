import java.awt.Color;
import java.awt.Graphics;

/**										//4p
 *
 * @author fred
 */
public class SmallTarget extends Target {			

    public SmallTarget() {
        super();
        size = 20;
    }

    @Override
    public int getPoints() {
        return 20;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.GREEN);
        super.draw(g);
    }

}