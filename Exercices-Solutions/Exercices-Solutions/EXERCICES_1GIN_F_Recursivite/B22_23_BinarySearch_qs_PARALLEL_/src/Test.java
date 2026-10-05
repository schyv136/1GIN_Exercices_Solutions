
import java.util.concurrent.ForkJoinPool;

public class Test
{
    
    public static void main(String[] args) 
    {
        RecursiveTabOperations recuTab = new RecursiveTabOperations();

        int n = 2000000;
        System.out.println("n = "+n);
        
        recuTab.fill(n, -10, 10);
        //recuTab.printAll();
        System.out.println("Quicksort Sort... ");
        long start = System.currentTimeMillis();
        recuTab.qs(0,n-1);
        long stop = System.currentTimeMillis();
        //recuTab.printAll();
        System.out.println("Quicksort Sort Time = "+(stop-start)/1000.0+"s");

        recuTab.fill(n, -10, 10);
        //recuTab.printAll();
        System.out.println("Quicksort Sort parallel... ");
        start = System.currentTimeMillis();
        QuickSortParallel qsp =new QuickSortParallel(recuTab.getTab());
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(qsp);
        //qsp.compute();  //do not call compute directly -> use ForkJoinPool instead!
         stop = System.currentTimeMillis();
        //recuTab.printAll();
        System.out.println("Quicksort Sort Time = "+(stop-start)/1000.0+"s");
     
        /*
        recuTab.fill(n, -1000, 1000);
        //recuTab.printAll();
        System.out.println("Selection Sort... ");
        start = System.currentTimeMillis();
        recuTab.selSort();
        stop = System.currentTimeMillis();
        System.out.println("Selection Time = "+(stop-start)/1000.0+"s");
        */
    }
}