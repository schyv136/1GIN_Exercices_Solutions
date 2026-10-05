package logic;

import java.awt.Color;
import java.awt.Graphics;

public class Grass extends Block {

    public void draw(Graphics g, int x, int y, int size) {
        g.setColor(Color.green);
        g.fillRect(x + 1, y, size, size);
    }

    public boolean isWalkable() {
        return true;
    }

    public String toString() {
        return "Grass";
    }
}
