package Blocks;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author fred
 */
public class Brick extends Block {
    
    
    @Override
    public void draw(int x, int y, Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, 40, 40);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 39, 39);
        g.drawLine(x, y,    x+39, y+39);
        g.drawLine(x, y+39, x+39, y);
    }

    @Override
    public boolean isWalkable() {  //player cannot walk on brick walls
        return false;
    }
    
    
}