import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Computables : gère une liste de Computable (figures, MyButton, MyTextField...)
 * à l'aide d'une ArrayList.
 *
 * - sort() trie d'après l'ordre interne (Comparable -> surface)
 * - Computables est Iterable : on peut le parcourir avec "for (Computable c : computables)"
 */
public class Computables implements Iterable<Computable>
{
    private ArrayList<Computable> alComputables = new ArrayList<>();

    public void add(Computable computable)
    {
        alComputables.add(computable);
    }

    public Computable get(int i)
    {
        return alComputables.get(i);
    }

    public int size()
    {
        return alComputables.size();
    }

    public Object[] toArray()
    {
        return alComputables.toArray();
    }

    /** Tri d'après l'ordre interne défini par Comparable (surface). */
    public void sort()
    {
        Collections.sort(alComputables);
    }

    /**
     * ArrayList est elle-même Iterable : on renvoie simplement son itérateur
     * (pas besoin d'en définir un nouveau).
     */
    @Override
    public Iterator<Computable> iterator()
    {
        return alComputables.iterator();
    }

    @Override
    public String toString()
    {
        String res = "size=" + size() + "\n";
        for (Computable c : this)          // utilise iterator()
            res = res + c + "\n";
        return res;
    }
}
