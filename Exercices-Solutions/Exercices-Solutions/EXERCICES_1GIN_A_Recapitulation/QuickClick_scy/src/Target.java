
import java.awt.Color;
import java.awt.Graphics;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yvons
 */
public abstract class Target {
    //les coordonnées du centre de la cible
    protected int x;
    protected int y;
    //la largeur d'un côté de la cible
    protected int size;
    //définissent les pas du déplacement en horizontale et en verticale. 
    private int xStep;
    private int yStep;

    public Target() {
        //initialisation des coordonnées avec des valeurs au hasard entre 30 et 300
        x=Randomizer.getInt(30, 300);
        y=Randomizer.getInt(30, 300);
        
        xStep=Randomizer.getInt(-5, 5);
        yStep=Randomizer.getInt(-5, 5);
    }
    
    public abstract int getPoints();
    
    
    public void draw(Graphics g)
    {
        g.drawRect(x-size/2, y-size/2, size, size);
        g.fillRect(x-size/2, y-size/2, size, size);
        g.setColor(Color.black);
        g.drawString(getPoints()+"", x-10, y);
    }
    public void doStep(int width, int height)
    {
        if      (xStep > 0 && x+size/2+xStep>=width)  xStep=-xStep;
        else if (xStep < 0 && x-size/2+xStep<=0)      xStep=-xStep;
        if      (yStep > 0 && y+size/2+yStep>=height) yStep=-yStep;
        else if (yStep < 0 && y-size/2+yStep<=0)      yStep=-yStep;
        
        x+=xStep;
        y+=yStep;
        
    }
    public boolean isInside(int pX, int pY)
    {
        return (pX>=x-size/2 && pX<=x+this.size/2 && pY>=y-size/2 && pY<=y+size/2);
    }
}
