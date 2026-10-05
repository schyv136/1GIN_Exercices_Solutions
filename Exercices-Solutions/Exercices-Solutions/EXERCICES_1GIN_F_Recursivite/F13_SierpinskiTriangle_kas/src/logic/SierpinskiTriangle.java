/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

/**
 *
 * @author kas
 */
public class SierpinskiTriangle {

    private int depth;

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void drawTriangle(Graphics g, Point2D p1, Point2D p2, Point2D p3,
            int depth) {

        int xPoints[] = new int[3];
        int yPoints[] = new int[3];

        xPoints[0] = (int) Math.round(p1.getX());
        xPoints[1] = (int) Math.round(p2.getX());
        xPoints[2] = (int) Math.round(p3.getX());
        yPoints[0] = (int) Math.round(p1.getY());
        yPoints[1] = (int) Math.round(p2.getY());
        yPoints[2] = (int) Math.round(p3.getY());

        g.setColor(Color.blue);
        
        if (depth <= 0) {
            g.fillPolygon(xPoints, yPoints, 3);
        } else {
            drawTriangle(g,
                    p1,
                    new Point2D.Double((p1.getX() + p2.getX()) / 2.0, 
                            (p1.getY() + p2.getY()) / 2.0),
                    new Point2D.Double((p1.getX() + p3.getX()) / 2.0, 
                            p1.getY()),
                    depth - 1);
            drawTriangle(g,
                    new Point2D.Double((p1.getX() + p2.getX()) / 2.0, 
                            (p1.getY() + p2.getY()) / 2.0),
                    p2,
                    new Point2D.Double((p2.getX() + p3.getX()) / 2.0, 
                            (p1.getY() + p2.getY()) / 2.0),
                    depth - 1);
            drawTriangle(g,
                    new Point2D.Double((p1.getX() + p3.getX()) / 2.0, 
                            p1.getY()),
                    new Point2D.Double((p2.getX() + p3.getX()) / 2.0, 
                            (p2.getY() + p3.getY()) / 2.0),
                    p3,
                    depth - 1);
        }
    }

    public void draw(Graphics g, Point2D p1, Point2D p2, Point2D p3) {
        drawTriangle(g, p1, p2, p3, depth);
    }
}
