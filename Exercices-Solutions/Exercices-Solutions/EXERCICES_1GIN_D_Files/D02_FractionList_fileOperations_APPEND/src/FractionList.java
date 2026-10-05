import java.io.*;
import java.util.ArrayList; 

// Unchecked warning is caused by reading ArrayList from Object File
// -> suppress it (there's no really good solutions to this)
// Only way to avoid it would be to use untyped ArrayList everywhere... 
@SuppressWarnings("unchecked")   

public class FractionList
{
	private ArrayList<Fraction> fractionList = new ArrayList<>();


    public void add(Fraction f) {
        fractionList.add(f);
    }
    
    public void addRandomFractions(int n, int min, int max) {
        int i=0;
        while ( i<n ) {
            try
            {
                //Initialisation par des entiers entre -5 et 5
                int num= (int) (Math.random()*(max-min+1)) + min;
                int den= (int) (Math.random()*(max-min+1)) + min;
                
                Fraction fraction = new Fraction(num,den);
                fractionList.add(fraction); //n'est plus exécuté lors d'une exception!
                i++; //n'est pas incrémenté lors d'une exception (Et oui, c'est plus recommandable qu'une boucle for!)
            }
            catch (IllegalArgumentException e) 
            {
                //System.out.println(e.getMessage()); //polymorphe...
                //ignore it - another one will be creted automatically...
            }
       } //end while   
    }
    
    public int size() {
        return fractionList.size();
    }
    
    public Fraction get(int i) {
        return fractionList.get(i);                
    }
    
    public Object[] toArray() {
        return fractionList.toArray();
    }
    
    public void printAll() {
        for (int j=0; j<fractionList.size() ; j++) 
            System.out.println(j + ": " + fractionList.get(j));        
    }

    
//************************************ Text File ***************************************
// to append to a text file just add 'true' as 'append Parameter'     
    
    public void saveToTextFile(String fileName) throws FileNotFoundException, IOException {
        try ( PrintWriter out = new PrintWriter ( new FileWriter(fileName,true) )) {
                for (int i=0 ; i<size() ; i++) {
                        out.println(get(i).numerator+";"+get(i).denominator);
                } 
        }
      System.out.println("saved file closed");
    }

    public void loadFromTextFile(String fileName) throws FileNotFoundException, IOException {
        try (BufferedReader in = new BufferedReader( new FileReader(fileName) )) {
            fractionList = new ArrayList<>(); //remove current fractions - AFTER file is successfully opened        
            String line;
            while ((line = in.readLine()) != null) { //<<-- combined read&assign&test
                        int p= line.indexOf(";");
                        int num = Integer.valueOf(line.substring(0,p));
                        int den = Integer.valueOf(line.substring(p+1));
                        fractionList.add(new Fraction(num, den));                    
            }             
        }   
    }
    
  
//************************************ Binary Data File ***************************************
// to append to a binary data file just add 'true' as 'append Parameter'        

    //VERSION 2: IO- and FNFound-Exceptions have to be caught in calling method
    public void saveToBinaryFile(String fileName) throws FileNotFoundException, IOException {
        try (DataOutputStream out = new DataOutputStream(
                                          new BufferedOutputStream( new FileOutputStream(fileName,true)))) {
                for (int i=0 ; i<size() ; i++) {
                        out.writeInt(get(i).getNumerator());
                        out.writeInt(get(i).getDenominator());
                } //for
        }
    }
    
    //VERSION 2: IO- and FNFound-Exceptions have to be caught in calling method
    public void loadFromBinaryFile(String fileName) throws FileNotFoundException, IOException {
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            fractionList = new ArrayList<>(); //remove current fractions - AFTER file is successfully opened
            boolean eof = false;
            while (!eof) {
                try {
                    int num = in.readInt();
                    int den = in.readInt();
                    fractionList.add(new Fraction(num, den));
                } catch (EOFException e) {
                    //EOF found : normally exiting loop 
                    eof = true;
                }
            }
        }
    }  
    
   
 //************************************ Binary Object File ***************************************
// to append to an object file the first time, (and only the first time) 
// the file has to be written the normal way ==> the Object file header is written
// to the start of the file.
// After this, the header must NOT be written! ==> use a custom Stream definition
// LastButNotLeast: The object have to be written one by one, NOT the whole list !!
// (otherwise, the file size will grow (lists will be appended, but only the first list will be read)
    
    public void saveToObjectFile(String fileName) throws IOException
    {
        if (!(new File(fileName).exists())) //new file write WITH header
        {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
                for (int i = 0; i < fractionList.size(); i++) {
                    out.writeObject(fractionList.get(i));
                }
                
            }
        } else //file exists => write WITHOUT header
        {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName, true)) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset(); //Reset will disregard the state of any objects already written to the stream.
                }
            };) {
                for (int i = 0; i < fractionList.size(); i++) {
                    out.writeObject(fractionList.get(i));
                }
            }
        }

    }
            
    public void loadFromObjectFile(String fileName) throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            fractionList = new ArrayList<>();
            boolean eof = false;
            while (!eof) {
                try {
                    add((Fraction) in.readObject());
                } catch (EOFException e) { //EOF found : normally exiting loop 
                    eof = true;
                } catch (ClassNotFoundException e) {
                    System.err.println("Error reading Object File: " + e);
                }
            }
        }    
    }
    
}