
public class TestArray {

    int[][] a = new int[2][3];

    public static void main(String[] args) {
        TestArray ta = new TestArray();
        for (int i = 0; i < ta.a.length; i++) {
            for (int j = 0; j < ta.a[i].length; j++) {
                System.out.println("a[" + i + "," + j + "]=" + ta.a[i][j]);
            }
        }


        int[][] tab = new int[5][];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = new int[i + 1];
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = (int) (Math.random() * 100);
            }
        }
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.println("tab[" + i + "," + j + "]=" + tab[i][j]);
            }
        }
    }
}