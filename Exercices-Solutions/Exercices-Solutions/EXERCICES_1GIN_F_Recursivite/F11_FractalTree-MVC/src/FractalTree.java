import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * Class name:   FractalTreePanel
 * @version Nov 6, 2012
 * @author  fred
 */
public class FractalTree {
    
    
    private double length = 110;
    private double f1 = 0.75;
    private double f2 = 0.75;
    private double diffAngle = 40;

    public double getLength()                    { return length;          }
    public double getF1()                        { return f1;              }
    public double getF2()                        { return f2;              }
    public double getDiffAngle()                 { return diffAngle;       }
    
    public void   setLength(double length)       { this.length = length;       }
    public void   setF1(double f1)               { this.f1 = f1;               }
    public void   setF2(double f2)               { this.f2 = f2;               }
    public void   setDiffAngle(double diffAngle) { this.diffAngle = diffAngle; }
    
     
    private Point2D drawVector(Graphics2D g, Point2D p, double length, double angle) {
        //Coloriser
        if      (length>10)    g.setColor(new Color(75, 50, 25)); 
        else if (length>5)     g.setColor(Color.RED);
        else if (length>3)     g.setColor(Color.YELLOW);
        else if (length>1.5)   g.setColor(Color.GREEN);
                          else g.setColor(new Color(0,100,0));
        //Donner une épaisseur aux branches
        g.setStroke(new BasicStroke((float)length/10+1));// trunc(Long/10)+1;
        //Dessiner le vecteur
        Point2D pEnd=new Point2D.Float();
        pEnd.setLocation( p.getX() + length*Math.cos(Math.toRadians(angle)), 
                          p.getY() + length*Math.sin(Math.toRadians(angle)));
        g.drawLine( (int)Math.round(p.getX()),      (int)Math.round(p.getY()),
                    (int)Math.round(pEnd.getX()),   (int)Math.round(pEnd.getY()));
        return pEnd;
    }
    
    private void drawFractalTree(Graphics2D g, Point2D p, double length, double angle) 
    {
        if (length>1) {
           p = drawVector(g, p, length, angle);
           drawFractalTree    (g, p, length*f1, angle-diffAngle);
           drawFractalTree    (g, p, length*f2, angle+diffAngle);
       }
    }
    
    public void draw(Graphics g, Point2D p) {
        drawFractalTree((Graphics2D)g, p, length, 270) ;
    }
        
}