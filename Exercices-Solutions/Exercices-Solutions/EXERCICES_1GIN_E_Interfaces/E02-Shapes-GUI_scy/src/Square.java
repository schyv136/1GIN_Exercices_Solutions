import java.awt.Color;

public class Square extends Shape
{
	private double side;
	
	public Square(double x, double y, Color color, double side)
	{
		super(x,y,color);
		this.side=side;
	}

	public double getSide()	{return side;	}
	
	public String toString()
	{
		return "Square ; [Surface="+ getSurface() + "] - " + super.toString() + " ; " +
			  "Side="+side;
	}
	
	public double getPerimeter()
	{
		return 4 * side;
	}
	
	public double getSurface()
	{
		return side * side;
	}	

}