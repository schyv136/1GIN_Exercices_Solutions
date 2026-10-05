import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

/**
 * Class name:   van Koch Curve & SnowFlake
 * @version Dec 7, 2013
 * @author  fredfaber
 */
public class VanKochSnowFlake {    
    
    private int iterations = 1;
    private boolean antialiasing = true;
    private boolean mirrored  = false;

    public boolean isMirrored() { return mirrored;    }
    public void    setMirrored(boolean mirrored) { this.mirrored = mirrored;    }
    
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
    
    private Point2D drawCurve(Graphics2D g, Point2D p, double length, double angle, int n) 
    {
        if (n>0) {           
           p  = drawCurve(g, p, length/3, angle ,   n-1);
           p  = drawCurve(g, p, length/3, angle-60, n-1);
           p  = drawCurve(g, p, length/3, angle+60, n-1);
           p  = drawCurve(g, p, length/3, angle,    n-1);
        }
        else
           p = drawVector(g, p, length, angle);
        return p;
    }
    
    public void draw(Graphics g, int width, int height, Color color) {
        g.setColor(color);
        Graphics2D g2 = (Graphics2D)g;
        if (antialiasing)
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        else
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
        
        Point2D p = new Point2D.Double(width/2, height-5);
        drawSnowFlake(g2, p, width*0.8,  -120);        
    }
    
    public void drawSnowFlake(Graphics2D g, Point2D p, double length, double angle) {        
        p = drawCurve(g, p, length, angle    , iterations);
        p = drawCurve(g, p, length, angle+120, iterations);
        p = drawCurve(g, p, length, angle+240, iterations);
        
        if (mirrored) {
            p = drawCurve(g, p, length, angle+60 , iterations);
            p = drawCurve(g, p, length, angle-60 , iterations);
                drawCurve(g, p, length, angle-180, iterations);
        }
    }
    
    
}
