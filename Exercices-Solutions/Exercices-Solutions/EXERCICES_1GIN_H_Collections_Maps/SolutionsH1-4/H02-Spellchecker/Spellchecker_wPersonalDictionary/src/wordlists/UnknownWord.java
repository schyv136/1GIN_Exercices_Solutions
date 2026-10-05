package wordlists;

/**
 * @author fred
 */
public class UnknownWord {
    
    protected String word;
    protected int index;  

    public UnknownWord(String word, int index) {
        this.word = word;
        this.index = index;
    }
    
    public String getWord() {
        return word;
    }
    
    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return word + " (" + index + ')';
    }
 
    
}
