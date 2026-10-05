package spellcheckers;


import java.util.ArrayList;

/**
 *
 * @author fred
 */
public class UnknownWords {
    private ArrayList<UnknownWord> words = new ArrayList<>();

    public Object[] toArray() {
        return words.toArray();
    }

    public UnknownWord get(int index) {
        return words.get(index);
    }

    public boolean add(UnknownWord e) {
        return words.add(e);
    }
    
    public boolean add(String s, int i) {
        return words.add(new UnknownWord(s, i));
    }

    public void clear() {
        words.clear();
    }
    
}
