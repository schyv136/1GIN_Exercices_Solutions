package AllFigures;


/**
 *
 * @author fred
 */

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;  //to enable ArrayList saving in class Figures

public abstract class Figure implements Serializable
{
    
    /**
     * bounding points of the figure
     */
    Point p1,p2;
    Color borderColor,fillColor;
        
    public Figure(int x1, int y1, int x2, int y2, 
                  Color pborderColor, Color pfillColor)
    {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
        borderColor = pborderColor;
        fillColor   = pfillColor;
    }

    public Figure(Point pP1, Point pP2,  Color pborderColor, Color pfillColor)
    {
        p1 = new Point(pP1);
        p2 = new Point(pP2);
        borderColor = pborderColor;
        fillColor   = pfillColor;
    }
    
    public Figure(int x1, int y1, int x2, int y2)
    {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
        borderColor = Color.RED;
        fillColor   = Color.ORANGE;
    }

    public Figure(Point pP1, Point pP2)
    {
        p1 = new Point(pP1);
        p2 = new Point(pP2);
        borderColor = Color.RED;
        fillColor   = Color.ORANGE;
    }
    
    public int getX1() {return p1.x;}
    public int getY1() {return p1.y;}
    public int getX2() {return p2.x;}
    public int getY2() {return p2.y;}

    public int getWidth()  {return Math.abs(p2.x-p1.x);}
    public int getHeight() {return Math.abs(p2.y-p1.y);}
    
    public Point getP1()     {return p1;}
    public Point getP2()     {return p2;}

    public Point getCenter() {return new Point((p2.x+p1.x)/2 , (p2.y+p1.y)/2);}
    
    public abstract void draw(Graphics g);
    
    public abstract boolean isInside(Point pClick);

    public boolean isInsideBounds(Point pClick)
    {
        int minX  = Math.min(p1.x, p2.x);
        int maxX  = Math.max(p1.x, p2.x);
        int minY  = Math.min(p1.y, p2.y);
        int maxY  = Math.max(p1.y, p2.y);        
        return ( minX-2<=pClick.x && pClick.x<=maxX+2  &&  minY-2<=pClick.y && pClick.y<=maxY+2 );
    }
    
    
    public void shiftBy(int x, int y)
    {
        p1.x = p1.x + x;
        p1.y = p1.y + y;
        p2.x = p2.x + x;
        p2.y = p2.y + y;
    }

    public String toString()
    {
     return p1.x+" "+p1.y+" "+p2.x+" "+p2.y+" "+borderColor.getRGB()+" "+fillColor.getRGB();  //must use getRGB if you want to save this in a text file!
    }

}
