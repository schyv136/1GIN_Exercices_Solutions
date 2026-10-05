import java.awt.Color;
import java.util.Iterator;

public class ShapeTest
{

    public static void main(String[] args) 
    {
        ShapeList shapeList = new ShapeList();
        Triangle  t = new Triangle (100,100, java.awt.Color.red , 40,50,30); 
        Rectangle r = new Rectangle(200,200, java.awt.Color.blue, 50,60); 
        Circle    c = new Circle   (300,300, java.awt.Color.pink, 110);
        Square    s = new Square   (400,400, java.awt.Color.cyan, 120);
        shapeList.add(t);
        shapeList.add(r);
        shapeList.add(s);
        shapeList.add(c);
        System.out.println(shapeList);

     /* use plain for loop */
     for (int i=0 ; i<shapeList.getCount() ; i++)
        	System.out.println("Surface of shape "+i+"="+shapeList.get(i).getSurface());
        	
	/* Use Iterator */
	Iterator<Shape> shapeIterator = shapeList.iterator();  
	while (shapeIterator.hasNext())  
	{  
 		Shape sh = shapeIterator.next();  
 		System.out.println("Surface of shape ="+sh.getSurface()); 
	}  	

	/* Use for each (implicit) Iterator */
	for (Shape sh : shapeList) 
		System.out.println("Surface of shape ="+sh.getSurface()); 
	
    	/* Use Iterator to remove all */
	shapeIterator = shapeList.iterator();  
	while (shapeIterator.hasNext()) 
	{  
 		shapeIterator.next();
 		shapeIterator.remove();  
	}  	
     System.out.println(shapeList);

    }
}