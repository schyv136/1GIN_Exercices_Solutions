package shapes;

import java.io.*;
import java.util.Scanner;

/**
 * ShapeList : Linked List of Shapes
 */
public class ShapeList {

    private Shape first = null;

    public int getCount() {
        int c = 0;
        for (Shape s = first; s != null; s = s.next) {
            c++;
        }
        return c;
    }

    public Shape get(int i) {
        int c = 0;
        Shape s = first;
        while (s != null && c != i) {
            s = s.next;
            c++;
        }
        return s;
    }

    public void add(Shape s) {
        if (first == null) {
            first = s;
        } else {
            Shape current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = s;
        }
    }

    
    /*
     * This implementation of 'remove' uses 'equals' to compare Shapes 
     * ==> 'equals' MUST BE OVERRIDDEN in 'Shape' and all of it's subclasses
     * ==> if 'equals' is overriden, 'hashcode' MUST be overridden, too!
     */
    public void remove(Shape s) {
        if (first != null) {
            if (s != null) {
                if (first.equals(s)) {  // ==> equals & hashcode must be overridden
                    first = first.next;
                } else {
                    Shape current = first;
                    while (current.next != null && !current.next.equals(s)) {
                        current = current.next;
                    }
                    if (current.next != null) {
                        current.next = current.next.next;
                    }
                }
            }
        }
    }

    public void remove(int i) {
        if (i >= 0 && i < getCount()) {
            if (i == 0) {
                first = first.next;
            } else {
                get(i - 1).next = get(i).next;
            }
        }
    }

    public void clear() {
        first = null;
    }

    @Override
    public String toString() {
        int count = getCount();
        String res = "count=" + count + "\n";
        int i = 0;
        while (i < count) {
            res = res + get(i).toString() + "\n";
            i++;
        }
        return res;
    }

    /* ========================================================================================== */
    public void saveToFile(String fileName) throws FileNotFoundException, IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (Shape s = first; s != null; s = s.next) {
                out.println(s.toFileString());
                System.out.println("wrote : " + s.toFileString());
            }
        }
        System.out.println("saved file closed");
    }

    public void loadFromFile(String fileName) throws FileNotFoundException, IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            clear();
            String line = "";
            while (line != null) {
                line = in.readLine(); //->IOException
                if (line != null) {
                    add(Shape.newFromString(line));
                }
            }
        }
    }

    //**** Just for fun : 2 alternative Versions for loadFromFile ****************
    public void loadFromFile1(String fileName) throws IOException //using FileReader.read() -> one char
    {
        try (FileReader fr = new FileReader(fileName)) {
            clear();
            while (fr.ready()) {
                String s = "";
                char c = '-';
                while (fr.ready() && ((c = (char) fr.read()) != '\n')) {
                    s = s + c; //<=> readln(fr,s)
                }
                add(Shape.newFromString(s));
            }
        }
    }

    public void loadFromFile2(String fileName) throws IOException //using Scanner()
    {
        try (FileReader fr = new FileReader(fileName)) {
            Scanner sc = new Scanner(fr);

            clear();
            while (sc.hasNext()) {
                String s = sc.nextLine();
                add(Shape.newFromString(s));
            }
        }
    }
}