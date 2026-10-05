
import java.io.*;
import java.util.ArrayList;

public class FractionList {

    private ArrayList<Fraction> fractionList = new ArrayList<>();

    public void add(Fraction f) {
        fractionList.add(f);
    }

    public void addRandomFractions(int n, int min, int max) {
        int i = 0;
        while (i < n) {
            try {
                int num = getRandom(min, max);
                int den = getRandom(min, max);

                Fraction fraction = new Fraction(num, den);
                fractionList.add(fraction);
                i++;
            } catch (IllegalArgumentException e) {
                //System.out.println(e.getMessage());
            }
        }
    }

    private int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
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
        for (int j = 0; j < fractionList.size(); j++) {
            System.out.println(j + ": " + fractionList.get(j));
        }
    }

//************************************ Text File ***************************************
    public void saveToTextFile(String fileName) throws FileNotFoundException, IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < size(); i++) {
                out.println(get(i).numerator + ";" + get(i).denominator);
            }
        }
//   System.out.println("saved file closed");
    }

    public void loadFromTextFile(String fileName) throws FileNotFoundException, IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            fractionList = new ArrayList<>();
            String line;
            while ((line = in.readLine()) != null) {
                //Or use spilt
                int p = line.indexOf(";");
                int num = Integer.valueOf(line.substring(0, p));
                int den = Integer.valueOf(line.substring(p + 1));
                fractionList.add(new Fraction(num, den));
            }
        }
    }

//************************************ Binary Data File ***************************************
    public void saveToBinaryFile(String fileName) throws FileNotFoundException, IOException {
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (int i = 0; i < size(); i++) {
                out.writeInt(get(i).getNumerator());
                out.writeInt(get(i).getDenominator());
            }
        }
    }

    public void loadFromBinaryFile(String fileName) throws FileNotFoundException, IOException {
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            while (in.available() > 0) {
                int num = in.readInt();
                int den = in.readInt();
                fractionList.add(new Fraction(num, den));
            }
        }
    }

    public void loadFromBinaryFileAlternative(String fileName) throws FileNotFoundException, IOException {
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            fractionList = new ArrayList<>();
            /// eof = Entd Of File
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
    public void saveToObjectFile(String fileName) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(fractionList);
        }
    }

    public void loadFromObjectFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            fractionList = (ArrayList<Fraction>) in.readObject();  //causes 'Unchecked' Warning! 
        }
    }

}
