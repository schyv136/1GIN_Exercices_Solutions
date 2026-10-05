package spellcheckers;


import java.util.ArrayList;

/**
 * @author fred
 */
public class SpellcheckerArrayList extends Spellchecker {
    
    private ArrayList<String> words = new ArrayList<>();
    
    @Override
    public boolean add (String word) {
        return words.add(word);
    }
    
    @Override
    public boolean contains(String s) {
        //System.out.println("checking: "+s);
        return words.contains(s);
    } 
    
}
