package logic;

/**
 *
 * @author fred
 */
public class HighScore {

    private int score;
    private String name;

    public HighScore( String name, int score ) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " : "+score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

}