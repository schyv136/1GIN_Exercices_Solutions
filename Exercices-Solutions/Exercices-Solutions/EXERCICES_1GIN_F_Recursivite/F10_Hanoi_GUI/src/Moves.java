
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author FabFr297
 */
public class Moves {
    private ArrayList<Move> alMoves = new ArrayList<>();
    int currentMove = 0;

    public int size() {
        return alMoves.size();
    }

    public int getCurrentMove() {
        return currentMove;
    }

    public Object[] toArray() {
        return alMoves.toArray();
    }

    public Move getNext() {
        if (currentMove<size())
            return alMoves.get(currentMove++);
        else
            return null;
    }
    
    public void reset() {
        currentMove=0;
    }

    public boolean add(Move e) {
        return alMoves.add(e);
    }

    public void clear() {
        alMoves.clear();
    }
}
