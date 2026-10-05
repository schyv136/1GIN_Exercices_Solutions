import java.util.ArrayList;
import java.util.Scanner;

public class TestFraction {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of fractions : ");
        int n = input.nextInt();

        ArrayList<Fraction> fractionList = new ArrayList<Fraction>();

        int errCount = 0;

        int i = 0;
        while (i < n) {
            try {
                //Initialisation par des entiers entre -5 et 5
                int num = (int) (Math.random() * (11)) - 5; //(int) (Math.random()*(max-min+1))+min | max=5, min=-5
                int den = (int) (Math.random() * (11)) - 5;

                Fraction fraction = new Fraction(num, den); //lance une exception si le dénominateur est zero
                fractionList.add(fraction); //n'est plus exécuté lors d'une exception!
                i++; //n'est pas incrémenté lors d'une exception (Et oui, c'est plus recommandable qu'une boucle for!)
            } catch (Exception e) {
                //System.out.println(e.getMessage()); //polymorph...
                errCount++;
            }
        } //end while

        //Affichage de la liste
        for (int j = 0; j < fractionList.size(); j++) {
            System.out.println(j + ": " + fractionList.get(j));
        }

        //Affichage des erreurs survenues
        System.out.println("Errors: " + errCount);
    }
}