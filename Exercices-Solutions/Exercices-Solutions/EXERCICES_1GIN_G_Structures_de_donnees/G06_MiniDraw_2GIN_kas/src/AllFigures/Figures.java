package AllFigures;

/**
 *
 * @author fred
 */
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Point;

public class Figures {

    protected ArrayList<Figure> list = new ArrayList<>();

    public void add(Figure f) {
        list.add(f);
    }

    public void draw(Graphics g) {
        for (Figure f : list) {
            f.draw(g);
        }
    }

    public Figure clickedFigureAt(Point p) {
        Figure result = null;
        for (Figure f : list) {
            if (f.isInside(p)) {
                result = f;
            }
        }
        return result;
    }

    public void delete(Figure f) {
        if (f != null) {
            list.remove(f); //remove the REFERENCE to f from the Vector
        }
    }    // Figure f still exists in memory until the is no more reference to it

    public void toTop(Figure f) {
        if (f != null) {
            //int i=list.indexOf(f);
            list.remove(f); //remove the REFERENCE to f from the Vector
            list.add(f);    //add new Link to the end of the list => the topmost figure

        }
    }

    public void toBottom(Figure f) {
        if (f != null) {
            list.remove(f); //remove the REFERENCE to f from the Vector
            list.add(0, f); //add new Link to the start of the list => the figure at the bottom
        }
    }

    public void forward(Figure f) {
        /* int i=list.indexOf(f);
           if (f!=null && i < list.size()-1)
              Collections.swap(list, i , i+1);
         */
        if (f != null) {
            int i = list.indexOf(f);
            if (i < list.size() - 1) //if f isn't the last element in the list
            {
                list.remove(f);  //remove the REFERENCE to f from the Vector
                list.add(i + 1, f); //add to the next pos in the list
            }
        }

    }

    public void backward(Figure f) {
        /*
        int i=list.indexOf(f);
        if (f!=null && i>0)
              Collections.swap(list, i , i-1);
         */
        if (f != null) {
            int i = list.indexOf(f);
            if (i > 0) //if f isn't the first element in the list
            {
                list.remove(f);  //remove the REFERENCE to f from the Vector
                list.add(i - 1, f);  //add to the previous pos in the list
            }
        }
    }

    public void deleteAll() {
        list.clear();
    }

    public void saveToFile(String fileName) {
    }

    public void loadFromFile(String fileName) {
    }

}
