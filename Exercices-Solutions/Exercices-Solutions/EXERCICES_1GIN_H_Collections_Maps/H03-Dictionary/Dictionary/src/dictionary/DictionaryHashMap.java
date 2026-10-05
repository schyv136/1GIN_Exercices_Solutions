package dictionary;

import java.util.HashMap;

/**
 * Dictionary based on two hashmaps (bi-directional)
 * 
 * @author fred
 */
public class DictionaryHashMap extends Dictionary{

    private HashMap<String, String> map = new HashMap<>();
    private HashMap<String, String> mapReverse = new HashMap<>();
        
    @Override
    public void clear() {
        map.       clear();
        mapReverse.clear();
    }

    @Override
    public void add(String lang1, String lang2) {
        map.       put(lang1, lang2);
        mapReverse.put(lang2, lang1);
    }

    @Override
    public Object[] toArray() {
        String[] result = new String[map.size()];
        int i=0;
        for (String key: map.keySet()) {
            result[i++] = key+" : "+map.get(key);
        }
        return result;
    }

    @Override
    public String translate(String lang1) {
        return map.get(lang1);
    }

    @Override
    public String translateReverse(String lang2) {
        return mapReverse.get(lang2);
    }

    @Override
    public void delete(String lang1) {
        String s=map.remove(lang1);
        if (s!=null) mapReverse.remove(s);
    }
    
}
