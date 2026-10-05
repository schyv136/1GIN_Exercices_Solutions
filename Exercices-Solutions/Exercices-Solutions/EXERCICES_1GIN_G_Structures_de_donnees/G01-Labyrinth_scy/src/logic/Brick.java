package logic;

import java.awt.Color;
import java.awt.Graphics;

public class Brick extends Block {

    public void draw(Graphics g, int x, int y, int size) {
        g.setColor(Color.gray);
        g.fillRect(x, y, size, size);

        g.setColor(Color.black);
        g.drawRect(x, y, size, size);
        g.drawLine(x, y, x + size, y + size);
        g.drawLine(x, y + size, x + size, y);
    }

    public boolean isWalkable() {
        return false;
    }

    public String toString() {
        return "Brick";
    }
}
