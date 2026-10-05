package shapes;

import java.awt.Color;

public class Circle extends Shape
{
	private double radius;

	public Circle(double x, double y, Color color, double radius)
	{
		super(x,y,color);
		this.radius=radius;
	}

	public double getRadius()	{return radius;	}

        @Override
	public String toFileString()
	{
		return "Circle " + super.toFileString() + " " + radius;
	}

        @Override
	public String toString()
	{
		return "Circle ; " + super.toString() + " ; " +
			  "Radius="+radius;
	}

        @Override
	public double getPerimeter()
	{
		return 2*Math.PI*radius;
	}
	
        @Override
	public double getSurface()
	{
		return Math.PI*radius*radius;
	}	
}