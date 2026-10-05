import java.awt.Color;

public abstract class Shape implements Computable,Comparable<Shape>
{
	protected double x;
	protected double y;
	protected Color color;

	public double getX()	{ return x;	}
	public double getY()	{ return y;	}
	public Color getColor()	{ return color;}

	public Shape(double x, double y, Color color)
	{
		this.x=x;
		this.y=y;
		this.color = color;
	}

	public int compareTo(Shape other)
	{
		double diff = getSurface() - other.getSurface();
		if      (diff>0)  return 1;
		else if (diff<0)  return -1;
		else return 0; 
	}
	
	public String toString()
	{
		return "Point("+x+","+y+") ; Color: "+getColor();
	}
}