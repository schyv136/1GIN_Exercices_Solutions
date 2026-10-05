
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fred
 */
public class Test {

    //************************************ MAIN ***************************************
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of fractions : ");
        int n = input.nextInt();

        FractionList fl = new FractionList();
        fl.addRandomFractions(n, -100, 100);
        fl.printAll();

        try {
            fl.saveToBinaryFile("fractions.dat");
            fl.saveToTextFile("fractions.txt");
            fl.saveToObjectFile("fractions.obj");
        } catch (IOException ex) {
            System.err.println("SAVE : " + ex);
        }

        try {
            fl.loadFromBinaryFile("fractions.dat");
            fl.loadFromTextFile("fractions.txt");
            fl.loadFromObjectFile("fractions.obj");
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("LOAD : " + ex);
        }

        fl.printAll();
    }

}
