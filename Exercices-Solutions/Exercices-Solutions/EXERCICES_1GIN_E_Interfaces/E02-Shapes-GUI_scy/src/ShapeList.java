
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * ShapeList : ArrayList of alComputable alComputable are always sorted by their surface.
 * ShapeList is Iterable (<=> it can return an Iterator to run through the
 * array)
 */
public class ShapeList implements java.lang.Iterable<Computable> {

    private ArrayList<Computable> alComputable = new ArrayList<Computable>();

    public int getCount() {
        return alComputable.size();
    }

    public Object[] toArray() {
        return alComputable.toArray();
    }

    public Computable get(int i) {
        return alComputable.get(i);
    }
    
    public void sort()
    {
        ArrayList<Computable> helpList =alComputable;
        alComputable=new ArrayList<Computable>();
        for (int i = 0; i < helpList.size(); i++) {
            addSorted(helpList.get(i));
        }
    }
            

    /* ajout non trié */
	public int add(Computable shape) 
	{
		alComputable.add(shape);
		return getCount(); 
	}
    
 /* ajout trié */
        
    public int addSorted(Computable shape) {
        int insertPos = getCount();
        alComputable.add(null); //a new (empty) reference MUST be created!!!
        while (insertPos > 0 && get(insertPos - 1).compareTo(shape) == 1) {
            alComputable.set(insertPos, get(insertPos - 1));
            insertPos--;
        }
        alComputable.set(insertPos, shape);
        return insertPos;
    }

    public String toString() {
        String res = "count=" + getCount() + "\n";
        int i = 0;
        while (i < getCount()) {
            res = res + get(i).toString() + "\n";
            i++;
        }
        return res;
    }

    /* ========================================================================================== */
    //Send back ArrayList's own Iterator (no need to define a new one...)
    @Override
    public Iterator<Computable> iterator() {
        return alComputable.iterator();
    }

}
