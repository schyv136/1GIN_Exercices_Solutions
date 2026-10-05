package shapes;

import java.awt.Color;
import java.io.Serializable;

public abstract class Shape implements Serializable, Computable, Comparable<Shape> {

    private double x;
    private double y;
    private Color color;
    protected Shape next = null;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public Shape(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.next = null;
    }

    public static Shape newFromString(String s) {
        String[] str = s.split(" ");
        String type = str[0];
        Double x = Double.valueOf(str[1]);
        Double y = Double.valueOf(str[2]);
        Color c = Color.getColor("", Integer.valueOf(str[3])); //Gebastels fir d'Faarwen richteg erem ze kréien!!

        if (type.equals("Rectangle")) {
            return (new Rectangle(x, y, c, Double.valueOf(str[4]),
                    Double.valueOf(str[5])));
        } else if (type.equals("Circle")) {
            return (new Circle(x, y, c, Double.valueOf(str[4])));
        } else if (type.equals("Square")) {
            return (new Square(x, y, c, Double.valueOf(str[4])));
        } else //if (type.equals("Triangle") )
        {
            return (new Triangle(x, y, c, Double.valueOf(str[4]),
                    Double.valueOf(str[5]), Double.valueOf(str[6])));
        }
    }

    @Override
    public int compareTo(Shape other) {
        double diff = getSurface() - other.getSurface();
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toFileString() {
        return x + " " + y + " " + getColor().getRGB();  //must use getRGB if you want to save this in a text file!
    }

    @Override
    public String toString() {
        return "Point(" + x + "," + y + ") ; Color: " + getColor();
    }

    /*
     * Rule: 
     * equals returns true  ==> hashcodes must be identical
     * BUT identical being hashcodes does not necessarily imply that objects are equal!
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 97 * hash + (this.color != null ? this.color.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Shape other = (Shape) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (this.color != other.color && (this.color == null || !this.color.equals(other.color))) {
            return false;
        }
        return true;
    }
}