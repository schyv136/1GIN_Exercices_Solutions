package spellcheckers;


import binarySearchTree.BST;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author fred
 */
public class SpellcheckerBST extends Spellchecker {
    
    private BST<String> words = new BST<>();
    
    @Override
    public boolean add (String word) {
        return words.add(word);
    }
    
    @Override
    public boolean contains(String s) {
        return words.contains(s);
    }

    /**
     * Our BST adds strings in the order they are entered.
     * If the words are sorted in the file, the BST degenerates to a linked list
     * leading to a very bad insertion and search performance.
     * (if it does not lead to a StackOverflow while reading the file...)
     * Solution:
     * ==> the words in the file are first added to an ArrayList, then shuffled 
     *     the shuffled list is added to the BST.
     * 
     * @param fileName
     * @throws FileNotFoundException
     * @throws IOException 
     */
    @Override
    public void loadFromFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList <String> alBuffer = new ArrayList<>();
        //read all the words into an ArrayList
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = in.readLine())!=null)
                alBuffer.add(line);
        }
        //shuffle the words in the ArrayList
        for (int i =0 ; i<5*alBuffer.size() ; i++) {
            int i1 = (int)(Math.random()*alBuffer.size());
            int i2 = (int)(Math.random()*alBuffer.size());
            alBuffer.set(i1, alBuffer.set(i2, alBuffer.get(i1))); //exchange
        }
        //add the (shuffled) words from the ArrayList to the tree
        for (int i=0; i<alBuffer.size() ; i++) {
            words.add(alBuffer.get(i));
        }
        
        System.out.println("depth:"+words.getDepth()+" - size:"+words.size());        
    }
    
    
    
}
