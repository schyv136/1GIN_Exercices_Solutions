package dotGrid;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author fabfr
 */
public class Dot {
    
    private int x;
    private int y;
    private Color color;

    public Color getColor() {        return color;    }
    //public void setColor(Color color) {        this.color = color;    }
    public int getY() {        return y;    }
    //public void setY(int y) {        this.y = y;    }
    public int getX() {        return x;    }
    //public void setX(int x) {        this.x = x;    }
    
    
    public Dot(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Dot(int x, int y, String colorString) {
        this.x = x;
        this.y = y;
        this.color = getColorFromString(colorString);
    }

    
    public String getColorString() {
        if      (color.equals(Color.BLUE))    return "blue";
        else if (color.equals(Color.RED))     return "red";
        else if (color.equals(Color.YELLOW))  return "yellow";
        else if (color.equals(Color.GREEN))   return "green";
        else                                  return "unknown";
    }
    
    public Color getColorFromString(String colorString) {
        if      (colorString.equals("blue"))   return Color.BLUE;
        else if (colorString.equals("red"))    return Color.RED;
        else if (colorString.equals("yellow")) return Color.YELLOW;
        else if (colorString.equals("green"))  return Color.GREEN;
        else                                   return Color.BLACK;
    }
    
    public void draw(Graphics g, int cellWidth) {
        g.setColor(color);
        g.fillOval(x*cellWidth+2, y*cellWidth+2, cellWidth-4, cellWidth-4);
    }
    
}
