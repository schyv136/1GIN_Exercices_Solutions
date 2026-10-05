import simpleLinkedList.SimpleLinkedList;
import java.util.Iterator;
import shapes.*;
//imports for file saving
import java.io.*;
import java.util.Scanner; //used in loadFromFile2


/**
 * ShapeList : Linked List of Shapes 
 * Shapes are always sorted by their surface.
 * ShapeList is Iterable (<=> it can return an Iterator to run through the array) 
 */
public class ShapeList implements java.lang.Iterable<Shape>
{
	private SimpleLinkedList<Shape> shapes = new SimpleLinkedList<Shape>();
        //private java.util.LinkedList<Shape> shapes = new java.util.LinkedList<Shape>();
        //private java.util.ArrayList<Shape> shapes = new java.util.ArrayList<Shape>();

	public int getCount() 
	{
		return shapes.size();
	} 

	public Shape get(int i) 
	{ 
		return shapes.get(i);
	}
	
	/* ajout non trié */
	public int add(Shape shape) 
	{
		shapes.add(shape);
                return getCount(); 
	}

        /**
         * trier la liste (selon la surface des figures)
         * fonctionne seulement pour collections! (qui implémentent Collection)
         */
        /*
        public void sort()
        {
            java.util.Collections.sort(shapes);
        }
        */


	
	/* ajout trié */
        /*
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
         */


	/**
	 * effacer tout
	 */
	public void clear()
	{
		shapes.clear();
	}

        @Override
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

 	 
	/* ========================================================================================== */
	
    public void saveToFile(String fileName) throws IOException {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Shape s : shapes) {
                fw.write(s.toFileString() + "\n");
                System.out.println("wrote : " + s.toFileString());
            }
        }
    }

    public void loadFromFile(String fileName) throws IOException //using FileReader.read() -> one char
    {

        try (FileReader fr = new FileReader(fileName)) {
            shapes.clear();
            while (fr.ready()) {
                String s = "";
                char c = '-';
                while (fr.ready() && ((c = (char) fr.read()) != '\n')) {
                    s = s + c; //<=> readln(fr,s)
                }
                shapes.add(Shape.newFromString(s));
            }
        }
    }

    public void loadFromFile2(String fileName) throws IOException //using Scanner()
    {
        try (FileReader fr = new FileReader(fileName)) {
            Scanner sc = new Scanner(fr);

            shapes.clear();
            while (sc.hasNext()) {
                String s = sc.nextLine();
                shapes.add(Shape.newFromString(s));
            }
        }
    }
		
	

}