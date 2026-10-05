
import java.util.ArrayList;
import java.io.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yvonschubert
 */
public class FractionList {
    
    private ArrayList<Fraction> alFraction=new ArrayList<>();

    public void add(Fraction f) {
        alFraction.add(f);
    }

    public void addRandomFractions(int n, int min, int max) {
        int i = 0;
        while (i < n) {
            try {
                int num = getRandom(min, max);
                int den = getRandom(min, max);

                Fraction fraction = new Fraction(num, den);
                alFraction.add(fraction);
                i++;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public int size() {
        return alFraction.size();
    }

    public Fraction get(int i) {
        return alFraction.get(i);
    }

    public Object[] toArray() {
        return alFraction.toArray();
    }

    public void printAll() {
        for (int j = 0; j < alFraction.size(); j++) {
            System.out.println(j + ": " + alFraction.get(j));
        }
    }

//************************************ Binary Data File ***************************************
    public void saveToDataFile(String filename) throws FileNotFoundException, IOException
    {
        try(DataOutputStream out=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename))))
        {
            for(int i=0;i<size();i++)
            {
                out.writeInt(alFraction.get(i).getNumerator());
                out.writeInt(alFraction.get(i).getDenominator());
            }
            
        }
    }
    
    public void loadFromDataFile(String filename) throws FileNotFoundException, IOException
    {
        try(DataInputStream in=new DataInputStream(new BufferedInputStream(new FileInputStream(filename))))
        {
            alFraction = new ArrayList<>();
            /// eof = Entd Of File
            boolean eof = false;
            while (!eof) {
                try {
                    int num = in.readInt();
                    int den = in.readInt();
                    alFraction.add(new Fraction(num, den));
                } catch (EOFException e) {
                    //EOF found : normally exiting loop 
                    eof = true;
                }
            }
        }
    }
    
    //************************************ Text File ***************************************
    public void saveToTextFile(String filename) throws FileNotFoundException, IOException
    {
        try(PrintWriter out=new PrintWriter(new FileWriter(filename)))
        {
            for(int i=0;i<size();i++)
            {
                out.println(alFraction.get(i).getNumerator()+";"+alFraction.get(i).getDenominator());
            }
            
        }
    }
    
    public void loadFromTextFile(String filename) throws FileNotFoundException, IOException
    {
        try(BufferedReader in=new BufferedReader(new FileReader(filename)))
        {
            alFraction=new ArrayList<>();
            String line;
            while((line=in.readLine())!=null)
            {
                int p = line.indexOf(";");
                int num = Integer.valueOf(line.substring(0, p));
                int den = Integer.valueOf(line.substring(p + 1));
                
                //or with split method
                String lineArray []=line.split(";");
                int numSplit=Integer.valueOf(lineArray[0]);
                int denSplit=Integer.valueOf(lineArray[1]);
                System.out.println(numSplit+";"+denSplit);
               
                alFraction.add(new Fraction(num, den));
            }
        }
    }
    
    //************************************ Binary Object File ***************************************
    public void saveToObjectFile(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(alFraction);
        }
    }

    public void loadFromObjectFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            alFraction = (ArrayList<Fraction>) in.readObject();  //causes 'Unchecked' Warning! 
        }
    }
    
}
