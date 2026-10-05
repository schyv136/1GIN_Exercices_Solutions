
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

// Unchecked warning is caused by reading ArrayList from Object File
// -> suppress it (there's no really good solutions to this)
// Only way to avoid it would be to use untyped ArrayList everywhere... 
@SuppressWarnings("unchecked")

public class FractionList implements Cloneable {

    private ArrayList<Fraction> alFractions = new ArrayList<>();

    public void add(Fraction f) {
        alFractions.add(f);
    }

    public void addRandomFractions(int n, int min, int max) {
        int i = 0;
        while (i < n) {
            try {
                //Initialisation par des entiers entre -5 et 5
                int num = (int) (Math.random() * (max - min + 1)) + min;
                int den = (int) (Math.random() * (max - min + 1)) + min;

                Fraction fraction = new Fraction(num, den);
                alFractions.add(fraction); //n'est plus exécuté lors d'une exception!
                i++; //n'est pas incrémenté lors d'une exception (Et oui, c'est plus recommandable qu'une boucle for!)
            } catch (IllegalArgumentException e) {
                //System.out.println(e.getMessage()); //polymorphe...
                //ignore it - another one will be creted automatically...
            }
        } //end while   
    }

    public int size() {
        return alFractions.size();
    }

    public Fraction get(int i) {
        return alFractions.get(i);
    }

    public Object[] toArray() {
        return alFractions.toArray();
    }

    public void printAll() {
        for (Fraction f : alFractions) {
            System.out.println(alFractions.indexOf(f) + ": " + f);
        }
    }

//************************************ sort ***************************************
    public void sort() {
        Collections.sort(alFractions); //fractions implement Comparable
    }

//************************************ Text File ***************************************
    public void saveToTextFile(String fileName) throws FileNotFoundException, IOException {
        PrintWriter out = null; // not initialized yet
        try {
            out = new PrintWriter(new FileWriter(fileName));
            for (Fraction f : alFractions) {
                out.println(f.numerator + ";" + f.denominator);
            } //for
        } finally {
            if (out != null) {
                out.close(); // that's why 'out' has to be known outside the first try block
                System.out.println("saved file closed");
            }
        }

    }

    public void loadFromTextFile(String fileName) throws FileNotFoundException, IOException {
        try ( BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            alFractions = new ArrayList<>(); //remove current fractions
            String line;
            while ((line = in.readLine()) != null) {
                int p = line.indexOf(";");
                int num = Integer.valueOf(line.substring(0, p));
                int den = Integer.valueOf(line.substring(p + 1));
                alFractions.add(new Fraction(num, den));
            }
        }
    }

//************************************ Binary Data File ***************************************
    //VERSION 2: IO- and FNFound-Exceptions have to be caught in calling method
    public void saveToBinaryFile(String fileName) throws FileNotFoundException, IOException {
        try ( DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (Fraction f : alFractions) {
                out.writeInt(f.getNumerator());
                out.writeInt(f.getDenominator());
            } //for
        }
        System.out.println("saved file closed");
    }

    //VERSION 2: IO- and FNFound-Exceptions have to be caught in calling method
    public void loadFromBinaryFile(String fileName) throws FileNotFoundException, IOException {
        try ( DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream(fileName)))) {
            alFractions = new ArrayList<>(); //remove current fractions
            boolean eof = false;
            while (!eof) {
                try {
                    int num = in.readInt();
                    int den = in.readInt();
                    alFractions.add(new Fraction(num, den));
                } catch (EOFException e) {
                    //EOF found : normally exiting loop 
                    eof = true;
                }
            }
        }
    }

    //************************************ Binary Object File ***************************************
    public void saveToObjectFile(String fileName) throws IOException {
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(alFractions);
        }
        System.out.println("saved file closed");
    }

    public void loadFromObjectFile(String fileName) throws IOException {
        try ( ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            alFractions = (ArrayList<Fraction>) in.readObject();  //causes 'Unchecked' Warning! 
        } catch (ClassNotFoundException e) {
            System.out.println("Error reading Object File: " + e);
        }
    }

    //******************************  clone()  *********************************
    //ajouter d'abord "implements Cloneable" à la classe
    /*  using inherited clone method -> shallow copy  
     @Override
     public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
        System.err.println(ex);
        }
            return null;
        }
     */
 /*better clone method -> deep copy     */
    @Override
    public Object clone() {
        FractionList result = null;
        if (alFractions != null) {
            result = new FractionList();
        }
        for (Fraction f : alFractions) {
            result.add((Fraction) f.clone());
        }
        return result;
    }
  
    public void iterate() {
        // At the beginning itr(cursor) will point to
        // index just before the first element in al
        Iterator<Fraction> itr = alFractions.iterator();

        // Checking the next element  where
        // condition holds true till there is single element
        // in the List using hasnext() method
        while (itr.hasNext()) {
            //  Moving cursor to next element
            Fraction frac = itr.next();

            // Getting elements one by one
            System.out.println(frac+"");
        }
    }
}
