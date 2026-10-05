import java.util.Iterator;

public class ShapeTest
{

    public static void main(String[] args) 
    {
        Triangle  t = new Triangle (100,100, java.awt.Color.red , 40,50,30); 
        Rectangle r = new Rectangle(200,200, java.awt.Color.blue, 50,60); 
        Circle    c = new Circle   (300,300, java.awt.Color.pink, 10);
        Square    s = new Square   (400,400, java.awt.Color.cyan, 25);
        ShapeList shapeList = new ShapeList();
        shapeList.add(t);
        shapeList.add(r);
        shapeList.add(s);
        shapeList.add(c);
        System.out.println(shapeList);

    System.out.println("\n/* use plain for loop */"); 
     for (int i=0 ; i<4 ; i++)
        	System.out.println("Surface of shape "+i+"="+shapeList.get(i).getSurface());
        	
	System.out.println("\n/* Use Iterator */");
	Iterator<Shape> shapeIterator = shapeList.iterator();  
	while (shapeIterator.hasNext()) 
	{  
 		Shape sh = shapeIterator.next();  
 		System.out.println("Surface of shape ="+sh.getSurface()); 
	}  	

	System.out.println("\n/* Use for each (implicit) Iterator */");
	for (Shape sh : shapeList) 
		System.out.println("Surface of shape ="+sh.getSurface()); 
	
    	System.out.println("\n/* Use Iterator to remove all */");
	shapeIterator = shapeList.iterator();  
	while (shapeIterator.hasNext()) 
	{  
		shapeIterator.next(); 
 		shapeIterator.remove();  
	}  	
     System.out.println(shapeList);

    }
}