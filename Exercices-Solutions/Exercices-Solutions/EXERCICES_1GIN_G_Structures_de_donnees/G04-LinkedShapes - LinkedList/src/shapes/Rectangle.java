package shapes;

import java.awt.Color;

public class Rectangle extends Shape {

    private double height;
    private double width;

    public Rectangle(double x, double y, Color color, double width, double height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toFileString() {
        return "Rectangle " + super.toFileString() + " "
                + width + " " + height;
    }

    @Override
    public String toString() {
        return "Rectangle ; " + super.toString() + " ; "
                + "Width=" + width + " ; Height=" + height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getSurface() {
        return width * height;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj)
                && obj instanceof Rectangle
                && this.width == ((Rectangle) obj).width
                && this.height == ((Rectangle) obj).height;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        return hash;
    }
}