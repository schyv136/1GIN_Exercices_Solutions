
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 */

/**
 *
 * @author fred
 */
public class Test {
       //************************************ MAIN ***************************************

    //test this class
    public static void main(String[] args) throws CloneNotSupportedException
    {
	/* */
        Scanner input = new Scanner(System.in);
	System.out.print("Enter the number of fractions : ");
	int n = input.nextInt();
		
        FractionList fl = new FractionList();
        fl.addRandomFractions(n, -100, 100);
        //fl.printAll();
       
       /* try {
          //fl.saveToBinaryFile  ("fractions.dat");
            fl.saveToTextFile    ("fractions.txt");
          //fl.saveToObjectFile  ("fractions.obj");
        } catch (FileNotFoundException ex) {
             System.err.println("SAVE : "+ex);
        } catch (IOException ex) {
             System.err.println("SAVE : "+ex);
        }
        
            
        try {
          //fl.loadFromBinaryFile("fractions.dat");
            fl.loadFromTextFile  ("fractions.txt");
          //fl.loadFromObjectFile("fractions.obj");
        } catch (FileNotFoundException ex) {
             System.err.println("LOAD : "+ex);
        } catch (IOException ex) {
             System.err.println("LOAD : "+ex);
        }                
        */ 
        /*
         System.out.println("Sorted list :");
         fl.sort();
         fl.printAll();    
         Object o = new Comparable() {

            @Override
            public int compareTo(Object o) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
           
         */
        
               
        System.out.println("-> Test Cloneable Fraction:");
        Fraction f1 = new Fraction(10,6);
        Fraction f2 = (Fraction)f1.clone();
        System.out.println("fraction1 =" + f1.toString());
        System.out.println("fraction2 =" + f2.toString());
        //f1.add(new Fraction(2,5));
        f1.simplify();
        //f1=new Fraction(1,2);
        System.out.println("fraction1 =" + f1.toString());
        System.out.println("fraction2 =" + f2.toString());
        //==> modification has no effect on clone (good!)
        
        /*    */
        System.out.println("-> Test Cloneable FractionList:");
        FractionList fl2 = (FractionList)fl.clone();
        fl2.iterate();
       

        System.out.println("Sorted original list :");
        //modifications done AFTER cloning!
        fl.sort();
        fl.add(new Fraction (100,1));
        //modified original
        
        //cloned copy 
        System.out.println("Cloned list :");
        fl2.printAll();
        //-> using default clone method has been changed too ==> both point to the same list!
        //-> make a better one!
   
	}
    
}
