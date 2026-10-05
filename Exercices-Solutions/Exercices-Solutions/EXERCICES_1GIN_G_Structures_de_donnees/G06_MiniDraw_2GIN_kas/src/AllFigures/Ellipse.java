package AllFigures;

/**
 *
 * @author fred
 */
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class Ellipse extends Figure {

    public Ellipse(int x1, int y1, int x2, int y2, Color pborderColor, Color pfillColor) {
        super(x1, y1, x2, y2, pborderColor, pfillColor);
    }

    public Ellipse(Point pP1, Point pP2, Color pborderColor, Color pfillColor) {
        super(pP1, pP2, pborderColor, pfillColor);
    }

    public Ellipse(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    public Ellipse(Point pP1, Point pP2) {
        super(pP1, pP2);
    }

    public void draw(Graphics g) {
        int left, top;
        if (p1.x < p2.x) {
            left = p1.x;
        } else {
            left = p2.x;
        }
        if (p1.y < p2.y) {
            top = p1.y;
        } else {
            top = p2.y;
        }
        g.setColor(fillColor);  // draw fill color first to avoid rounding gaps...
        g.fillOval(left, top, getWidth(), getHeight());
        g.setColor(borderColor);
        g.drawOval(left, top, getWidth(), getHeight());
    }

    public boolean isInside(Point p) {
        //return isInsideBounds(p);
        int minX, maxX, minY, maxY;
        if (p1.x < p2.x) {
            minX = p1.x;
            maxX = p2.x;
        } else {
            minX = p2.x;
            maxX = p1.x;
        }
        if (p1.y < p2.y) {
            minY = p1.y;
            maxY = p2.y;
        } else {
            minY = p2.y;
            maxY = p1.y;
        }

        double a = (maxX - minX) / 2.0;
        double b = (maxY - minY) / 2.0;
        return ((Math.pow(p.x - minX - a, 2) / Math.pow(a, 2))
                + (Math.pow(p.y - minY - b, 2) / Math.pow(b, 2)) <= 1);
    }

}
