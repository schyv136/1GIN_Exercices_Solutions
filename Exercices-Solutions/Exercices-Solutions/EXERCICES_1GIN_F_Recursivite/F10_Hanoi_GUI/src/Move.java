/**
 * @author FabFr297
 */
public class Move {
    private byte from;
    private byte to;

    public Move(byte from, byte to) {
        this.from = from;
        this.to = to;
    }

    public byte getFrom() {
        return from;
    }

    public byte getTo() {
        return to;
    }

    @Override
    public String toString() {
        return from + " ==> " + to;
    }    
}
