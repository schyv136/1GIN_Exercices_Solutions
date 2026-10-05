import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * ShapeList : array of Shapes 
 * All shapes are grouped in the first continous block inside the shapes array.
 * There is no 'count' variable. The end of the shapes list is marked by the first null value.
 * Shapes are always sorted by their surface.
 * ShapeList is Iterable (<=> it can return an Iterator to run through the array) 
 */
public class ShapeList implements java.lang.Iterable<Shape>
{
	protected static final int MAXCOUNT=100;
	protected Shape[] shapes = new Shape[MAXCOUNT];

	public int getCount() 
	{
		int count=0;
		while (shapes[count]!=null) count++;
		return count;
	} 

	public Shape get(int i) 
	{ 
		if (shapes[i]==null) 
		     throw new java.lang.ArrayIndexOutOfBoundsException(
		     	"ERROR: Index out of Bounds - Array only contains "+getCount()+" shapes!");
		return shapes[i]; 
	}
	
	/* ajout à la fin
	public int add(Shape shape) 
	{
		if (count<MAXCOUNT) 
		{
			shapes[count] = shape;
			count++;
		}
		else throw new java.lang.ArrayIndexOutOfBoundsException("ERROR: No space left in Shape Array");
		return count-1; 
	}
	*/

	/* ajout trié */
	public int add(Shape shape) 
	{
		int insertPos=getCount();
		if (insertPos<MAXCOUNT) 
		{
			while(insertPos>0 && shapes[insertPos-1].compareTo(shape) == 1) 
			{
				shapes[insertPos]=shapes[insertPos-1];
				insertPos--;
			}
			shapes[insertPos] = shape;
		}
		else throw new java.lang.ArrayIndexOutOfBoundsException("ERROR: No space left in Shape Array");
		return insertPos; 
	}


	public String toString()
	{
		String res="count="+getCount()+"\n";
		int i=0;
		while ( shapes[i]!=null )
		{
			res = res + shapes[i].toString()+"\n";
			i++;
		}			
		return res;		
	}

	/* ========================================================================================== */
	
	
	@Override  
 	public Iterator<Shape> iterator() {  
  		return new ShapeListIterator(shapes);  
 	}  
 	
}