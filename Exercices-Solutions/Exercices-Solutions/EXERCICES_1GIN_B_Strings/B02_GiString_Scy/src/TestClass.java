/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yvonschubert
 */
public class TestClass {
    
    public static void main(String[] args) {
        String someText="Ich bin ein Nerd.";
        String modifiedText=GiString.delete(someText,8,12);
        System.out.println(modifiedText);
        System.out.println(GiString.insert(modifiedText, " kein", 7));
        
        String random="bla bla bla";
        System.out.println("Count="+GiString.count(random, "bla"));
        
        String text="SCHUBERT";
        System.out.println(""+GiString.reverse(text));
        
        System.out.println("Salut: (palindrome?): "+GiString.palindromeWord("Salut"));
        System.out.println("RADAR: (palindrome?): "+GiString.palindromeWord("RADAR"));
        System.out.println("racecar: (palindrome?): "+GiString.palindromeWord("racecar"));
        System.out.println("RAD AR: (palindrome?): "+GiString.palindromeWord("RAD AR"));
        System.out.println("Radar: (palindrome?): "+GiString.palindromeWord("Radar"));
        
        System.out.println(GiString.removeNonAlphabetic("D,Z?,F+g.o<>0!"));
        
        System.out.println("Step on no pets ! (palindrome?): "+GiString.palindromeSentence("Step on no pets !")); 
        System.out.println("Panic in a Titanic, I nap. (palindrome?): "+GiString.palindromeSentence("Panic in a Titanic, I nap.")); 
        System.out.println("A man, a plan, a canal -- Panama! (palindrome?): "+GiString.palindromeSentence("A man, a plan, a canal -- Panama!")); 
        System.out.println("La mère Gide digère mal. (palindrome?): "+GiString.palindromeSentence("La mère Gide digère mal.")); 
        System.out.println("Engage le jeu que je le gagne. (palindrome?): "+GiString.palindromeSentence("Engage le jeu que je le gagne.")); 
        
        System.out.println(GiString.extract("Jim-Bob Walton#John Deere#Jack Daniels#Joe Cartwright", "#", 2));
        System.out.println(GiString.extract("Jim-Bob Walton#John Deere#Jack Daniels#Joe Cartwright", "#", 4));
        System.out.println(GiString.extract("Jim-Bob Walton#John Deere#Jack Daniels#Joe Cartwright", "#", 6));
        System.out.println(GiString.extract("Jim-Bob Walton#John Deere#Jack Daniels#Joe Cartwright", " ", 3) );
        
        System.out.println(GiString.extractAll("Jim-Bob Walton#John Deere#Jack Daniels#Joe Cartwright", "#"));
        System.out.println(GiString.extractAll("Jim-Bob Walton#John Deere#Jack Daniels#Joe Cartwright", " ").toString());
    }
    
}
