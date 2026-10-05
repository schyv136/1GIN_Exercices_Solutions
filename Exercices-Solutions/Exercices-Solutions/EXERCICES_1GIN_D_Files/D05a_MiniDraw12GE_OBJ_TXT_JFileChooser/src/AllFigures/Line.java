package AllFigures;

/**
 *
 * @author fred
 */
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class Line extends Figure
{

    public Line(int x1,int y1,int x2,int y2, Color pborderColor, Color pfillColor)
    {
        super(x1,y1,x2,y2,pborderColor,pfillColor);
    }

    public Line(int x1,int y1,int x2,int y2, Color pborderColor)
    {
        super(x1,y1,x2,y2,pborderColor,pborderColor);
    }

    public Line(Point pP1, Point pP2, Color pborderColor, Color pfillColor)
    {
        super(pP1,pP2,pborderColor,pfillColor);
    }

    public Line(Point pP1, Point pP2, Color pborderColor)
    {
        super(pP1,pP2,pborderColor,pborderColor);
    }

    public Line(int x1, int y1, int x2, int y2)
    {
        super(x1,y1,x2,y2);
    }

    public Line(Point pP1, Point pP2)
    {
        super(pP1,pP2);
    }

    public void draw(Graphics g)
    {
        g.setColor(borderColor);
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    public boolean isInside(Point p)
    {
     if ((p1.x==p2.x) || (p1.y==p2.y))
           return isInsideBounds(p);
     else {
            // Equation de la droite : Y=AX+B ; Calcul de A et B 
            double a = (double)(p2.y      - p1.y)      / (p2.x-p1.x); //type cast ==> decimal division!!
            double b = (double)(p2.x*p1.y - p1.x*p2.y) / (p2.x-p1.x);
            // Calcul de la distance (X,Y) du point à la droite (P1,P2) 
            double dist = Math.abs((a*p.x - p.y + b) / Math.sqrt(Math.pow(a,2) + 1));
            return isInsideBounds(p) && (dist<=2); // 2 pixels tolerance
          }
    }

    @Override
    public String toString()
    {
       return "Line "+super.toString();
    }

}
