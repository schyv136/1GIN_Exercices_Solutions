package shapes;

import java.awt.Color;

public class Square extends Shape {

    private double side;

    public Square(double x, double y, Color color, double side) {
        super(x, y, color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public String toFileString() {
        return "Square " + super.toFileString() + " " + side;
    }

    @Override
    public String toString() {
        return "Square ; " + super.toString() + " ; "
                + "Side=" + side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public double getSurface() {
        return side * side;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj)
                && obj instanceof Square
                && this.side == ((Square) obj).side;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.side) ^ (Double.doubleToLongBits(this.side) >>> 32));
        return hash;
    }
}