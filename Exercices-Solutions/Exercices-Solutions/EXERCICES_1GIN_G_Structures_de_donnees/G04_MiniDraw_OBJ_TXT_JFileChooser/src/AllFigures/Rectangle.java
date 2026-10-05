package AllFigures;

/**
 *
 * @author fred
 */
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Figure
{

    public Rectangle(int x1,int y1,int x2,int y2, Color pborderColor, Color pfillColor)
    {
        super(x1,y1,x2,y2,pborderColor,pfillColor);
    }

    public Rectangle(Point pP1, Point pP2,  Color pborderColor, Color pfillColor)
    {
        super(pP1,pP2,pborderColor,pfillColor);
    }

    public Rectangle(int x1, int y1, int x2, int y2)
    {
        super(x1,y1,x2,y2);
    }

    public Rectangle(Point pP1, Point pP2)
    {
        super(pP1,pP2);
    }

    public void draw(Graphics g)
    {
        int left,top;
        if (p1.x <p2.x) left=p1.x; else left=p2.x;
        if (p1.y <p2.y) top =p1.y; else top =p2.y;
        g.setColor(borderColor);
        g.drawRect(left, top, getWidth(), getHeight());
        g.setColor(fillColor);
        g.fillRect(left+1, top+1, getWidth()-1, getHeight()-1);
    }

    public boolean isInside(Point p)
    {
        return isInsideBounds(p);
    }

    @Override
    public String toString()
    {
       return "Rectangle "+super.toString();
    }

}
