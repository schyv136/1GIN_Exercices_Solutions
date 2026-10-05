
import java.util.concurrent.RecursiveAction;

/**
 * @author fred
 */
public class QuickSortParallel extends RecursiveAction {

    private static final int SEQUENTIAL_THRESHOLD = 100;
    private final int[] tab;
    private final int left;
    private final int right; 

    public QuickSortParallel(int[] tab, int left, int right) {
        this.tab = tab;
        this.left = left;
        this.right = right;
    }

    public QuickSortParallel(int[] data) {
        this(data, 0, data.length - 1);
    }

    @Override
    protected void compute() {
        final int length = right - left;
        if (length < SEQUENTIAL_THRESHOLD) {
            qs(left, right); //compute directly
        } else if (left < right) {
            int p = partition(left, right);
            final QuickSortParallel first = new QuickSortParallel(tab, left, p - 1);
            first.fork();
            final QuickSortParallel second = new QuickSortParallel(tab, p + 1, right);
            second.compute();
            first.join();
        }

    }

    private int partition(int left, int right) {
        int i = left;
        int j = right - 1;
        int pivot = tab[right];
        while (i < j) {
            while (i < right && tab[i] <= pivot) {
                i++;
            }
            while (j > left && tab[j] >= pivot) {
                j--;
            }
            if (i < j) {
                int help = tab[i];
                tab[i] = tab[j];
                tab[j] = help;
            }
        }
        if (tab[i] > pivot) {
            tab[right] = tab[i];
            tab[i] = pivot;
        }
        return i;
    }

    public void qs(int left, int right) {
        if (left < right) {
            int p = partition(left, right);
            qs(left, p - 1);
            qs(p + 1, right);
        }
    }
}