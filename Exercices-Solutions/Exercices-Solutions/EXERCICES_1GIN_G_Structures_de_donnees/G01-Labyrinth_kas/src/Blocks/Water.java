package Blocks;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author fred
 */
public class Water extends Block {

    @Override
    public void draw(int x, int y, Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 40, 40);
    }

    @Override
    public boolean isWalkable() {  //player cannot walk on water :-)
        return false;
    }

}
