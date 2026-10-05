package logic;

import java.awt.Color;
import java.awt.Graphics;

public class Water extends Block {

    public void draw(Graphics g, int x, int y, int size) {
        g.setColor(Color.blue);
        g.fillRect(x, y, size, size);
    }

    public boolean isWalkable() { //player cannot walk on water :-)
        return false;
    }

    public String toString() {
        return "Water";
    }
}
