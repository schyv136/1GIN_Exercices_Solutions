package main;


import bst.StringBST;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StringBSTTest {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        StringBST tree = new StringBST();

        tree.add("Jang");
        tree.add("Pol");
        tree.add("Pier");
        tree.add("Marc");
        tree.add("Anna");
        tree.add("Mario");
        tree.add("Boris");
        tree.add("Sam");
        tree.add("Claudio");

        tree.setMode(StringBST.PREORDER);
        System.out.println(tree);

        System.out.println("Pier is in tree? " + tree.contains("Pier"));
        System.out.println("Jang is in tree? " + tree.contains("Jang"));
        System.out.println("Jos  is in tree? " + tree.contains("Jos"));


        System.out.println("saving...");
        tree.saveToFile("Names.txt");
        System.out.println("clearing...");

        tree.clear();

        tree.setMode(StringBST.PREORDER);
        System.out.println(tree);

        System.out.println("loading...");
        tree.loadFromFile("Names.txt");

        tree.setMode(StringBST.INORDER);
        System.out.println("contents :");
        System.out.println(tree);

        System.out.println("\n/************ remove Pol ************/");
        System.out.println("* Removed: " + tree.remove("Pol"));
        System.out.println(tree);

        System.out.println("\n/************ remove Jos ************/");
        System.out.println("* Removed: " + tree.remove("Jos"));
        System.out.println(tree);

        System.out.println("\n/************ remove Jang ************/");
        System.out.println("* Removed: " + tree.remove("Jang"));
        System.out.println(tree);
        
    }
}