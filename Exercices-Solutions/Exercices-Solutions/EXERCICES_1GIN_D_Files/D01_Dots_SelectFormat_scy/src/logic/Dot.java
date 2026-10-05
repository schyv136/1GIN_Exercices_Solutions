package logic;


import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yvonschubert
 */
public class Dot implements Serializable {
    private int x;
    private int y;
    private Color color;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Color getColor() {
        return this.color;
    }

    public Dot(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public Dot (int x, int y, String colorString)
    {
        this.x=x;
        this.y=y;
        this.color=getColorFromString(colorString);
    }
    public String getColorString()
    {
        if      (color.equals(Color.BLUE))    return "blue";
        else if (color.equals(Color.RED))     return "red";
        else if (color.equals(Color.YELLOW))  return "yellow";
        else if (color.equals(Color.GREEN))   return "green";
        else                                  return "unknown";
    }
    
    public Color getColorFromString(String colorString)
    {
        if      (colorString.equals("blue"))   return Color.BLUE;
        else if (colorString.equals("red"))    return Color.RED;
        else if (colorString.equals("yellow")) return Color.YELLOW;
        else if (colorString.equals("green"))  return Color.GREEN;
        else                                   return Color.BLACK;
    }
    
    
    public String toCsv() {
        return x + "," + y + "," + getColorString();
    }
    
    public void draw(Graphics g,int cellWidth)
    {
        g.setColor(color);
        g.drawOval(x*cellWidth+2, y*cellWidth+2, cellWidth-4, cellWidth-4);
        g.fillOval(x*cellWidth+2, y*cellWidth+2, cellWidth-4, cellWidth-4);
    }       
    
}
