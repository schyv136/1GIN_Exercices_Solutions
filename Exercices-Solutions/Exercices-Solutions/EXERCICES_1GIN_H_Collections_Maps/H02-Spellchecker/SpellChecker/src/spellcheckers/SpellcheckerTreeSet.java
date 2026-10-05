package spellcheckers;


import java.util.TreeSet;

/**
 * @author fred
 */
public class SpellcheckerTreeSet extends Spellchecker {
    
    private TreeSet<String> words = new TreeSet<>();
    
    @Override
    public boolean add (String word) {
        return words.add(word);
    }
    
    @Override
    public boolean contains(String s) {
        return words.contains(s);
    } 
    
}
