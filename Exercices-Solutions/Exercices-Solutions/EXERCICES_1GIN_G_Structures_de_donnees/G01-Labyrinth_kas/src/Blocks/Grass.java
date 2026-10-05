package Blocks;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author fred
 */
public class Grass extends Block {

    @Override
    public void draw(int x, int y, Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 40, 40);
    }

    @Override
    public boolean isWalkable() {  //player can walk on grass
        return true;
    }

}
