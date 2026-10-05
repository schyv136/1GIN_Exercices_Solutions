import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

/**
 * Class name:   van Koch Curve
 * @version Dec 7, 2013
 * @author  fredfaber
 */
public class VanKochCurve {    
    
    private double length = 110;
    
    public double getLength()                    { return length;          }    
    public void   setLength(double length)       { this.length = length;       }
    
     
    private Point2D drawVector(Graphics2D g, Point2D p, double length, double angle) {
        //Coloriser
//        if      (length>10)    g.setColor(new Color(75, 50, 25)); 
//        else if (length>5)     g.setColor(Color.RED);
//        else if (length>3)     g.setColor(Color.YELLOW);
//        else if (length>1.5)   g.setColor(Color.GREEN);
//                          else g.setColor(new Color(0,100,0));
        //Donner une épaisseur aux branches
        //g.setStroke(new BasicStroke((float)length/10+1));// trunc(Long/10)+1;
        
        //Dessiner le vecteur
        Point2D pEnd=new Point2D.Float();
        pEnd.setLocation( p.getX() + length*Math.cos(Math.toRadians(angle)), 
                          p.getY() + length*Math.sin(Math.toRadians(angle)));
        g.drawLine( (int)Math.round(p.getX()),      (int)Math.round(p.getY()),
                    (int)Math.round(pEnd.getX()),   (int)Math.round(pEnd.getY()));
        return pEnd;
    }
    
    private Point2D draw_Recursion(Graphics2D g, Point2D p, double length, double angle) 
    {
        if (length>2) {           
           p  = draw_Recursion(g, p, length/3, angle);
           p  = draw_Recursion(g, p, length/3, angle-60);
           p  = draw_Recursion(g, p, length/3, angle+60);
           p  = draw_Recursion(g, p, length/3, angle);
       }
        else
        {
            p = drawVector(g, p, length, angle);
        }
        return p;
    }
    
    public void draw(Graphics g, Point2D p, int length, double angle, Color color) {
        g.setColor(color);
        Graphics2D g2 = (Graphics2D)g;
        //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        draw_Recursion(g2, p, length, angle) ;
    }
        
}
