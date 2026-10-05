package logic;

import java.awt.Point;

public class Node {
    protected Point point;

    protected int g;
    protected int h;
    protected int f;

    protected Node parent;

    public Node(Point point, Point start, Point end) {
        this.point = point;
        this.g = distance(start, point);
        this.h = distance(end, point);
        this.f = h + g;
    }
    
    public void setFCost(Point start)
    {
        this.g = distance(start, point);
        this.f = h + g;
    }

    public int distance(Point start, Point end) {
        return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
    }
    
    public boolean isEqual(Node n)
    {
        return this.point.x==n.point.x && this.point.y==n.point.y;
    }
}
