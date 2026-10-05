package spellcheckers;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author fred
 */
public class SpellcheckerArrayListBinSearch extends Spellchecker {
    
    private ArrayList<String> words = new ArrayList<>();

    @Override
    public void loadFromFile(String fileName) throws FileNotFoundException, IOException {
        super.loadFromFile(fileName); 
        Collections.sort(words);  //sort
    } 
    
    
    @Override
    public boolean add (String word) {
        return words.add(word);
    }
    
    @Override
    public boolean contains(String s) {
        return Collections.binarySearch(words, s) >= 0; //search witch predefined binary search
    } 
    
}
