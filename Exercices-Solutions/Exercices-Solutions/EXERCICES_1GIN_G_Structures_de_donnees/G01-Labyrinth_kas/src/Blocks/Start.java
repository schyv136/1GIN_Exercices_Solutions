package Blocks;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author fred
 */
public class Start extends Block {

    @Override
    public void draw(int x, int y, Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 40, 40);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, 39, 39);
        g.drawString("START", x + 2, y + 24);
    }

    @Override
    public boolean isWalkable() {  //player can walk on Start block
        return true;
    }

}
