import java.awt.Color;
public class Triangle extends Shape
{
	protected double side1;
	protected double side2;
	protected double side3;
	
	public Triangle(double x, double y, Color color, double side1, double side2, double side3)
	{
		super(x,y,color);
		this.side1=side1;
		this.side2=side2;
		this.side3=side3;
	}

	public double getSide1()	{return side1;	}
	public double getSide2()	{return side2;	}
	public double getSide3()	{return side3;	}

	public String toString()
	{
		return "Triangle ; " + super.toString() + " ; " +
			  "Side1="+side1 + " ; Side2="+side2 + " ; Side3="+side3;
	}
	
	public double getPerimeter()
	{
		return side1 + side2 + side3;
	}
	
	public double getSurface()
	{
		//Heron Formula:
		double s = getPerimeter() / 2; //half-sum
		return Math.sqrt(s * (s-side1) * (s-side2) * (s-side3));
	}	

}