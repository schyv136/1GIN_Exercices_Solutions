package binarySearchTree;
import java.util.ArrayList;

public class BSTIterator<E> implements java.util.Iterator
{
	private int next     = 0;  //-> the next element to be returned by next()
        private ArrayList<E> list = null; 

 	public BSTIterator(Node n) {
            list = new ArrayList<E>();
            linearize(n, list);
            //for (E e : list) System.out.println(e);
            next = 0;                
 	}  

        
        /**
         * Copy object elements from tree to linear list
         * Les éléments sont copiés 'en ordre'
         * @param n the n of the tree
         * @param list the list of elements
         */
        private void linearize(Node n, ArrayList<E> list) {
           if (n != null) {
               linearize(n.left, list);
               list.add((E)n.e);
               linearize(n.right, list);
           } 
        }
        
        
	/**
	 * Return the next item in the list (and move on to the next item)
	 * traversing the whole list works only once... for each newly created iterator
	 * @return the next Item
	 */
        @Override
	public E next()
	{
  		if (!hasNext()) 
  			throw new java.util.NoSuchElementException("ERROR: No such element in tree");
		else 
		    {
                        int current = next;
                        next++;
                        return list.get(current);
                    }
	}

	/**
	 * Are there more items in the list?
	 * @return true <=> yes there are more elements
	 */
        @Override
	public boolean hasNext()
	{
		return next < list.size();
	}

	/**
	 * Delete the last item returned by next() - optional -
	 */
        @Override
	public void remove() //optional - not realized
	{
            throw new java.lang.UnsupportedOperationException();
	}


}