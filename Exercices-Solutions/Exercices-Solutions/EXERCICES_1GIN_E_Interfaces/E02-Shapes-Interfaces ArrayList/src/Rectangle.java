import java.awt.Color;

public class Rectangle extends Shape
{
	private double height;
	private double width;

	public Rectangle(double x, double y, Color color, double width, double height)
	{
		super(x,y,color);
		this.width=width;
		this.height=height;
	}

	public double getHeight()	{return height;}
	public double getWidth()		{return width;	}

	public String toString()
	{
		return "Rectangle ; " + super.toString() + " ; " +
			  "Height="+height + " ; Width="+width;
	}
	
	public double getPerimeter()
	{
		return 2 * (width+height);
	}
	
	public double getSurface()
	{
		return width * height;
	}	
}