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
    
    private int iterations = 1;
    private boolean antialiasing = false;
    
    public double getIterations()                   { return iterations;          }    
    public void   setIterations(int iterations)     { this.iterations = iterations;       }

    public boolean isAntialiasing()                   { return antialiasing;    }
    public void setAntialiasing(boolean antialiasing) { this.antialiasing = antialiasing;    }
    
     
    private Point2D drawVector(Graphics2D g, Point2D p, double length, double angle) {
        //Dessiner le vecteur
        Point2D pEnd=new Point2D.Float();
        pEnd.setLocation( p.getX() + length*Math.cos(Math.toRadians(angle)), 
                          p.getY() + length*Math.sin(Math.toRadians(angle)));
        g.drawLine( (int)Math.round(p.getX()),      (int)Math.round(p.getY()),
                    (int)Math.round(pEnd.getX()),   (int)Math.round(pEnd.getY()));
        return pEnd;
    }
    
    private Point2D draw_Recursion(Graphics2D g, Point2D p, double length, double angle, int n) 
    {
        if (n>0) {           
           p  = draw_Recursion(g, p, length/3, angle ,   n-1);
           p  = draw_Recursion(g, p, length/3, angle-60, n-1);
           p  = draw_Recursion(g, p, length/3, angle+60, n-1);
           p  = draw_Recursion(g, p, length/3, angle,    n-1);
        }
        else
        {
            p = drawVector(g, p, length, angle);
        }
        return p;
    }
    
    public void draw(Graphics g, int width, int height, Color color) {
        g.setColor(color);
        Graphics2D g2 = (Graphics2D)g;
        if (antialiasing)
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        else
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
        draw_Recursion(g2, new Point2D.Double(1,        height-2), width-3,  0  , iterations) ;
        draw_Recursion(g2, new Point2D.Double(width-2,  height-2), height-3, -90, iterations) ;
        draw_Recursion(g2, new Point2D.Double(width-2,  1       ), width-3,  180, iterations) ;
        draw_Recursion(g2, new Point2D.Double(1,        1       ), height-3, 90 , iterations) ;              
    }
        
}
