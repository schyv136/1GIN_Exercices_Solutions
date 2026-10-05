package AllFigures;

/**
 *
 * @author fred
 */

import java.util.*;     //Needed to import class "ArrayList"
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.io.*;
// traîtement de fichier texte
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Figures
{
    protected ArrayList<Figure> list = new ArrayList<>();

    public void add(Figure f)
    {
        list.add(f);
    }

    public void draw(Graphics g)
    {
        for (Figure f : list) f.draw(g);
    }


    public Figure clickedFigureAt(Point p)
    {
       Figure result=null;
       for (Figure f : list)
       {
          if (f.isInside(p)) result = f;
       }
       return result;
    }


    public void delete(Figure f)
    {
        if (f!=null) list.remove(f); //remove the REFERENCE to f from the ArrayList
    }    // Figure f still exists in memory until the is no more reference to it


    public void toTop(Figure f)
    {
        if (f!=null)
        {
            //int i=list.indexOf(f);
            list.remove(f); //remove the REFERENCE to f from the ArrayList
            list.add(f);    //add new Link to the end of the list => the topmost figure
            
        }
    }


    public void toBottom(Figure f)
    {
        if (f!=null)
        {
            list.remove(f); //remove the REFERENCE to f from the ArrayList
            list.add(0, f); //add new Link to the start of the list => the figure at the bottom
        }
    }



    public void forward(Figure f)
    {
        /* int i=list.indexOf(f);
           if (f!=null && i < list.size()-1)
              Collections.swap(list, i , i+1);
         */       
        if (f!=null)
        {
            int i=list.indexOf(f);
            if (i < list.size()-1) //if f isn't the last element in the list
               {
                list.remove(f);  //remove the REFERENCE to f from the ArrayList
                list.add(i+1,f); //add to the next pos in the list
               }
        }

    }

    
    public void backward(Figure f)
    {
        /*
        int i=list.indexOf(f);
        if (f!=null && i>0)
              Collections.swap(list, i , i-1);
         */       
        if (f!=null)
        {
            int i=list.indexOf(f);
            if (i > 0) //if f isn't the first element in the list
               {
                list.remove(f);  //remove the REFERENCE to f from the ArrayList
                list.add(i-1,f);  //add to the previous pos in the list
               }
        }

    }    

    public void deleteAll()
    {
        list.clear();
    }

    public void saveToFile(String fileName)
    {
      try 
       {
        FileOutputStream   f_out   = new FileOutputStream(fileName);
          try (ObjectOutputStream obj_out = new ObjectOutputStream (f_out)) {
              obj_out.writeObject(list);
          }
       }
      catch (IOException e) 
       { System.err.println("Error saving file : "+fileName+" / "+e.getMessage()); }
    }
    
    
    public void loadFromFile(String fileName)
    {
      try 
       {
        list.clear();    //supprimer la bibliothèque actuelle (si fichier ouvert avec succès)
        FileInputStream   f_in = new FileInputStream(fileName);
          try (ObjectInputStream obj_in = new ObjectInputStream (f_in)) {
              list = (ArrayList)obj_in.readObject();
          }
       }
      catch (IOException | ClassNotFoundException e)
       { System.err.println("Error reading file : "+fileName+" / "+e.getMessage()); }
    }



    public void saveToTxtFile(String fileName) throws IOException
    {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Figure f : list)
              {
                fw.write(f.toString()+"\n");
                //System.out.println("wrote : "+f.toString());
              }
        }
    }
    
    
    public void loadFromTxtFile(String fileName) throws IOException
    {
        try (FileReader fr = new FileReader(fileName)) {
            Scanner sc = new Scanner(fr);

            list.clear(); //supprimer la bibliothèque actuelle (si fichier ouvert avec succès)
            while (sc.hasNext()) 
            {
                String type = sc.next();
                Point p1 = new Point(sc.nextInt(),sc.nextInt());
                //System.out.println("read P1: "+p1.x+" "+p1.y);
                Point p2 = new Point(sc.nextInt(),sc.nextInt());
                //System.out.println("read P2: "+p2.x+" "+p2.y);
                Color bc = Color.getColor("",sc.nextInt()); //Gebastels fir d'Faarwen richteg erem ze kréien!!
                Color fc = Color.getColor("",sc.nextInt());
                //System.out.println("read Colors: "+bc+" "+fc);

                
                if (type.equals("Rectangle") )
                      list.add(new Rectangle(p1,p2,bc,fc));
                if (type.equals("Ellipse") )
                      list.add(new Ellipse(p1,p2,bc,fc));
                if (type.equals("Line") )
                      list.add(new Line(p1,p2,bc));
            }
        }
    }

    
}
