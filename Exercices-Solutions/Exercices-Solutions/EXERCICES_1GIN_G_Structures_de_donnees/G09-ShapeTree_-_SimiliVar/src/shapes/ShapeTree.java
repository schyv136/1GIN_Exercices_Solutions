package shapes;

import binarySearchTree.BST;
import java.io.*;
import java.util.Iterator;
import java.util.Scanner;


/**
 * ShapeTree : Tree of Shapes 
 * Shapes are always sorted by their surface.
 * ShapeTree is Iterable (<=> it can return an Iterator to run through the array) 
 */
public class ShapeTree implements java.lang.Iterable<Shape>
{
	private BST shapes = new BST();
        //private java.util.LinkedList<Shape> shapes = new java.util.LinkedList<Shape>();
        //private java.util.ArrayList<Shape>  shapes = new java.util.ArrayList<Shape>();

	public int getCount() 
	{
		return shapes.size();
	} 

	/* ajout non trié */
	public int add(Shape shape) 
	{
		shapes.add(shape);
                return getCount(); 
	}

  
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
		for (Object o : shapes) {            
                    //System.out.println(i+" > "+o);
                    res = res + o.toString()+"\n";
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
            for (Object o : shapes) {
                Shape s = (Shape) o;
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