package dictionary;

/**
 * @author fred
 */
public class Node {
    
    protected String lang1;
    protected String lang2;
    protected Node left;
    protected Node right;
    
    public Node(String lang1, String lang2) {
        this.lang1 = lang1;
        this.lang2 = lang2;
        left  = null;
        right = null;
    }

    /* uniquement nécessaire si on accède d'un autre paquet
    public String getLang1() {
        return lang1;
    }

    public String getLang2() {
        return lang2;
    }
    */
    
    @Override
    public String toString() {
        return lang1 + " : " + lang2;
    }
}
