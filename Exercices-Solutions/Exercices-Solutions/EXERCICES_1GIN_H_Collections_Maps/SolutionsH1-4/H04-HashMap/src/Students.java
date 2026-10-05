
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author fred
 */
public class Students {
    
    private HashMap<String,Student> studentsMap = new HashMap<>();
    //private TreeMap<String,Student> studentsMap = new TreeMap<>();

    /**
     * Ajoute un étudiant, en prenant le code Untis comme clé
     * @param student
     * @return 
     */
    public Student add(Student student) {
        return studentsMap.put(student.getUntis(), student);
    }

    public int size() {
        return studentsMap.size();
    }

    public Student get(String untis) {
        return studentsMap.get(untis);
    }

    public Student remove(String untis) {
        return studentsMap.remove(untis);
    }

    public void clear() {
        studentsMap.clear();
    }

    /** pour l'affichage des données dans une JList
     */
    public Object[] toArray() {
        return studentsMap.values().toArray();
    }
    
    /**
     * Afficher toutes les donées sous forme dans la fenêtre debug
     */
    public void printAll() {
        for (Student student : studentsMap.values()) {
            System.out.println(student);            
        }
    }

    Object[] findAllByGrade(String grade) {
        ArrayList<Student> al = new ArrayList<>();
        for (Student student : studentsMap.values()) {
            if (student.getGrade().equals(grade))
                al.add(student);
        }
        return al.toArray();
    }
    
    
}
