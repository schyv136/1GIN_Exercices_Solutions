import java.util.Iterator;
import java.util.ArrayList;


/**
 * ShapeList : ArrayList of Shapes 
 * Shapes are always sorted by their surface.
 * ShapeList is Iterable (<=> it can return an Iterator to run through the array) 
 */
public class ShapeList implements java.lang.Iterable<Shape>
{
	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	public int getCount() 
	{
		return shapes.size();
	} 

	public Shape get(int i) 
	{ 
		return shapes.get(i); 
	}
	
	/* ajout non trié */
	/*
	public int add(Shape shape) 
	{
		shapes.add(shape);
		return getCount(); 
	}
	*/
	
	/* ajout trié */
	public int add(Shape shape) 
	{
		int insertPos=getCount();
		shapes.add(null); //a new (empty) reference MUST be created!!!
		while(insertPos>0 && get(insertPos-1).compareTo(shape) == 1) 
			{
				shapes.set(insertPos,get(insertPos-1));
				insertPos--;
			}
		shapes.set(insertPos, shape);
		return insertPos; 
	}


	public String toString()
	{
		String res="count="+getCount()+"\n";
		int i=0;
		while ( i<getCount() )
		{
			res = res + get(i).toString()+"\n";
			i++;
		}			
		return res;		
	}

	/* ========================================================================================== */
	
	//Send back ArrayList's own Iterator (no need to define a new one...)
	@Override  
 	public Iterator<Shape> iterator() {  
  		return shapes.iterator();  
 	}  
	
}