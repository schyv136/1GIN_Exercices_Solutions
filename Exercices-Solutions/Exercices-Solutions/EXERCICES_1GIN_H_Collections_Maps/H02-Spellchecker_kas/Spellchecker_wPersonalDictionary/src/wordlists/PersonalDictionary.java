package wordlists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author fred
 */
public class PersonalDictionary {
    private ArrayList<String> alWords = new ArrayList<>();
    
    private boolean changed=false; //true if list was changed since last load or save

    public boolean isChanged() {
        return changed;
    }

    public boolean contains(Object o) {
        return alWords.contains(o);
    }

    public Object[] toArray() {
        return alWords.toArray();
    }

    public boolean add(String e) {
        changed=true;
        return alWords.add(e);
        
    }

    public void clear() {
        alWords.clear();
        changed=true;
    }
    
    public void loadFromFile(String fileName) throws IOException {
        clear();
        try(BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String line="";
            while((line=in.readLine())!=null) {
                add(line);
            }
        }
        changed=false;
    }
    
    public void saveToFile(String fileName) throws IOException {
        try(PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < alWords.size(); i++) {
                out.println(alWords.get(i));                
            }
        }
        changed=false;
    }

}
