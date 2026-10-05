public class ShapeListIterator implements java.util.Iterator<Shape>
{
	protected Shape[] shapes;               //the shape list to iterate through (init by constructor)
	protected int     current      = 0;     //-> always points to the NEXT element in the list
	protected boolean removeAllowed= false; //call to remove() only allowed after a call to next()

 	public ShapeListIterator(Shape[] shapes) {  
  		this.shapes =  shapes;  
 	}  

	/**
	 * Return the next item in the list (and move on to the next item)
	 * traversing the whole list works only once... for each newly created iterator
	 * @return the current Item
	 */
	public Shape next()
	{
  		if (!hasNext()) 
  			throw new java.util.NoSuchElementException("ERROR: No such Element in list");
		else 
		{
			removeAllowed = true;
			return shapes[current++];
		}
	}

	/**
	 * Are there more items in the list?
	 * @return true <=> yes there are more elements
	 */
	public boolean hasNext()
	{
		return shapes[current] != null;
	}

	/**
	 * Delete the last item returned by next() - optional -
	 */
	public void remove()
	{		
		if (removeAllowed) 
		{
			int i=current-1; //current always points to the NEXT element
					// the last element returned by next() is found at pos current-1
			while ( i<shapes.length && shapes[i+1]!=null )
			{
				shapes[i] = shapes[i+1];
				i++;
			}					
			if (i<shapes.length) shapes[i]=null;
			current--; //the element referenced by current has also been shifted left by 1 pos.			
		}
		else throw new java.lang.IllegalStateException("ERROR in Iterator: each call to remove() must be preceded by a call to next()");
		
		removeAllowed = false; //allowed only after another call to next()
	}


}