/*
 */
package dictionary;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author fred
 */
public abstract class Dictionary {

    public abstract void clear();

    public abstract void add(String lang1, String lang2);

    public abstract Object[] toArray();

    public abstract String translate(String lang1);

    public abstract String translateReverse(String lang2);

    public abstract void delete(String lang1);

// ----------------------------------------------------------------- 
    
    
    public void loadFromFile(String fileName) throws FileNotFoundException, IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
            clear();
            String line;
            while ((line = in.readLine()) != null) {
                String lang1 = line.substring(0, line.indexOf(";"));
                String lang2 = line.substring(line.indexOf(";") + 1);
                add(lang1, lang2);
            }
        }
    }
    
}