package spellcheckers;


import java.util.LinkedList;

/**
 * @author fred
 */
public class SpellcheckerLinkedList extends Spellchecker {
    
    private LinkedList<String> words = new LinkedList<>();
    
    @Override
    public boolean add (String word) {
        return words.add(word);
    }
    
    @Override
    public boolean contains(String s) {
        return words.contains(s);
    } 
    
}
