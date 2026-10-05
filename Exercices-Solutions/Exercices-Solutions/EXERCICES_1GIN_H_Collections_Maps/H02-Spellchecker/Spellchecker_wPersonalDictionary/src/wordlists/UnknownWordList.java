package wordlists;


import java.util.ArrayList;

/**
 *
 * @author fred
 */
public class UnknownWordList {
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

    public void removeAll(String word) {
        int i = words.size()-1;
        while(i>0) {
            if(words.get(i).getWord().equals(word))
                words.remove(i);
            i--;
        }
    }
    
    
    
    
}
