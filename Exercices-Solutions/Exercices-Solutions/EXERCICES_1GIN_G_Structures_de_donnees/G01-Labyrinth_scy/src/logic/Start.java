package logic;

import java.awt.Color;
import java.awt.Graphics;

public class Start extends Block {

    public void draw(Graphics g, int x, int y, int size) {
        g.setColor(Color.green);
        g.fillRect(x + 1, y, size - 1, size - 1);

        g.setColor(Color.black);
        g.drawRect(x + 1, y, size - 1, size - 1);

        int[] txtCenter = txtCenterCal("Start", x, y, size, g);

        g.drawString("Start", txtCenter[0], txtCenter[1]);
    }

    public boolean isWalkable() {
        return true;
    }

    public String toString() {
        return "Start";
    }
}
