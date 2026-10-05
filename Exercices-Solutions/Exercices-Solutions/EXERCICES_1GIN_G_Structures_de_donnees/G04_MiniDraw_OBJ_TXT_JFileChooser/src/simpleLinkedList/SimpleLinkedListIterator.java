package simpleLinkedList;

import java.util.Iterator;

public class SimpleLinkedListIterator<E> implements Iterator
{
	private Node next     = null;  //-> the next element to be returned by next()

 	public SimpleLinkedListIterator(Node first) {
  		next = first;
 	}  

	/**
	 * Return the next item in the list (and move on to the next item)
	 * traversing the whole list works only once... for each newly created iterator
	 * @return the next Item
	 */
        @Override
	public Object next()
	{
  		if (!hasNext()) 
  			throw new java.util.NoSuchElementException("ERROR: No such Element in list");
		else 
		    {
                        Node current  = next;
                        next     = next.next;
                        return current.o;
                    }
	}

	/**
	 * Are there more items in the list?
	 * @return true <=> yes there are more elements
	 */
        @Override
	public boolean hasNext()
	{
		return next != null;
	}

	/**
	 * Delete the last item returned by next() - optional -
	 */
        @Override
	public void remove() //optional - not realized
	{
            throw new UnsupportedOperationException();
	}


}