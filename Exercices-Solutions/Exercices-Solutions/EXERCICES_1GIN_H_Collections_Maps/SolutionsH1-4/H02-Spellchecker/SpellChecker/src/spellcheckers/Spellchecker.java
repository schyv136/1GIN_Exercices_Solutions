package spellcheckers;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author fred
 */
public abstract class Spellchecker {
    
    public abstract boolean add (String word) ;
    
    public abstract boolean contains(String s) ;
    
        
    public void loadFromFile(String fileName) throws FileNotFoundException, IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line = in.readLine())!=null)
                add(line);
        }
    }

    //test if character is a sentence delimiter
    protected static final String SEPARATORS=".¿?!\"\n";
    public boolean isSeparator(char c) {
        return (SEPARATORS.indexOf(c)!=-1);
    }
    //test if the character is another symbol
    protected static final String SYMBOLS=",:;-_<>+*=''`$£€@0123456789";
    public boolean isSymbol(char c) {
        return (SYMBOLS.indexOf(c)!=-1);
    }
    //test if the character is a space or a line feed character
    protected boolean isSpace(char c) {
        return (c==' ' || c=='\n'|| c=='\r');
    }
    
        
    /**
     * Analyses the text an adds unknown words to a list.
     * The main Problem here was to deal with the Problem of words in the 
     * beginning of a sentence that have to be written in upper case.
     * This needed a lot of tedious fiddling :-)
     * Below you find a much simpler version ignoring this problem
     * @param text  the text to analyse
     * @return      a list of the Words not found in the 'dictionary'
     */
    public UnknownWords analyseText(String text) {
        UnknownWords result = new UnknownWords();
        int index=0;
        String currentWord="";
        boolean newSentence = true; //The first word of a sentence has to be in upper case.
        boolean insideWord  = true; //true while scanning a word, used for newSentence
        for (int i = 0; i<text.length(); i++) {
            char c = text.charAt(i);
            //System.out.println(" new Sentence: "+newSentence+")");
                    
            if (i==text.length() || isSeparator(c)||isSymbol(c)||isSpace(c)) {
                if (currentWord.length()>0){
                    if ((!newSentence && !contains(currentWord)) ||  
                         (newSentence && !contains(currentWord) && !contains(currentWord.toLowerCase())) ||
                         (newSentence && currentWord.equals(currentWord.toLowerCase())))   
                        result.add(currentWord, index);                                      
                } 
                index=i+1;
                currentWord ="";  
//                if (isSeparator(c)) newSentence=true;  //set
//                if (insideWord && (isSymbol(c)||isSpace(c))) newSentence=false; //reset     
                newSentence = (newSentence || isSeparator(c)) && !(insideWord && (isSymbol(c)||isSpace(c)));     
                insideWord=false;
            }
            else {
                insideWord=true;
                currentWord+=c;                
            }
        }
        return result;
    }
    
    /**
     * Analyses the text an adds unknown words to a list.
     * The main Problem with words in the 
     * beginning of a sentence has not been dealt with.
     * 
     * @param text  the text to analyse
     * @return      a list of the Words not found in the 'dictionary'
     */
    public UnknownWords analyseText_Simple(String text) {
        UnknownWords result = new UnknownWords();
        int index=0;
        String currentWord="";
        for (int i = 0; i<text.length(); i++) {
            char c = text.charAt(i);                    
            if (i==text.length() || isSeparator(c)||isSymbol(c)||isSpace(c)) {
                if (currentWord.length()>0 && !contains(currentWord))
                        result.add(currentWord, index);
                index=i+1;
                currentWord ="";   
            }
            else 
                currentWord+=c;                
        }
        return result;
    }    
    
}
