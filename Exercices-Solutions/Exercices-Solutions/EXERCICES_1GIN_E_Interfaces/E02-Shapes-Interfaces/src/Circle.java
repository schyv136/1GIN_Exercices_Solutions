import java.awt.Color;

public class Circle extends Shape
{
	protected double radius;

	public Circle(double x, double y, Color color, double radius)
	{
		super(x,y,color);
		this.radius=radius;
	}

	public double getRadius()	{return radius;	}

	public String toString()
	{
		return "Circle ; " + super.toString() + " ; " +
			  "Radius="+radius;
	}

	public double getPerimeter()
	{
		return 2*Math.PI*radius;
	}
	
	public double getSurface()
	{
		return Math.PI*radius*radius;
	}	
}