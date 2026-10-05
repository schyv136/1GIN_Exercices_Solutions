package shapes;

import java.awt.Color;
import java.io.Serializable;

public abstract class Shape implements Serializable, Computable, Comparable<Shape>
{
    
	private double x;
	private double y;
	private Color color;

	public double getX()	{ return x;	}
	public double getY()	{ return y;	}
	public Color getColor()	{ return color;}

	public Shape(double x, double y, Color color)
	{
		this.x=x;
		this.y=y;
		this.color = color;
	}


        public static Shape newFromString(String s)
        {
		String[] str = s.split(" ");
                String type = str[0]; 
                Double x = Double.valueOf(str[1]);
                Double y = Double.valueOf(str[2]);
                Color c = Color.getColor("",Integer.valueOf(str[3])); //Gebastels fir d'Faarwen richteg erem ze kréien!!
               
                if (type.equals("Rectangle") )
                     return(new Rectangle(x,y,c, Double.valueOf(str[4]), 
                                                 Double.valueOf(str[5])));
                else if (type.equals("Circle") )
                     return(new Circle   (x,y,c, Double.valueOf(str[4])));
                else if (type.equals("Square") )
                     return(new Square   (x,y,c, Double.valueOf(str[4])));
                else //if (type.equals("Triangle") )
                     return(new Triangle (x,y,c, Double.valueOf(str[4]), 
                         Double.valueOf(str[5]), Double.valueOf(str[6])));
	}
        
        
        @Override
	public int compareTo(Shape other)
	{
		double diff = getSurface() - other.getSurface();
		if      (diff>0)  return 1;
		else if (diff<0)  return -1;
		else return 0; 
	}
	
        public String toFileString()
        {
            return x+" "+y+" "+getColor().getRGB();  //must use getRGB if you want to save this in a text file!
        }

        @Override
	public String toString()
	{
		return "Point("+x+","+y+") ; Color: "+getColor()+ " ; Surface: "+getSurface();
	}
}