import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorRemoveTest {

        public static void main(String[] args) {
                char alphabet = 'a';
                ArrayList list = new ArrayList();
                while (alphabet != 'z') {
                        list.add(alphabet++);
                }

			System.out.println("\nbefore removal : \n");
               for (Object o : list) {
                        System.out.print(o + " ");
                }

                
                Iterator it = list.iterator();
                while (it.hasNext()) {
                        if (it.next().equals('f')) it.remove();
                }

			System.out.println("\nafter removal : \n");
               for (Object o : list) {
                        System.out.print(o + " ");
                }

        }
}