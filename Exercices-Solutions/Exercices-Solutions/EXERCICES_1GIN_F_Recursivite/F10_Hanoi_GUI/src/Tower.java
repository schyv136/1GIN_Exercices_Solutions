
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author fred
 */
public class Tower {
    private ArrayList<Byte> alDisks = new ArrayList<>();
    private int maxDisks;

    public Tower(int maxDisks) {
        this.maxDisks = maxDisks;
    }
    
    public void addDisk(byte disk) {
        alDisks.add(disk);        
    }
    
    public byte removeDisk() {
        return alDisks.remove(alDisks.size()-1);        
    }
    
    public void draw(Graphics g, int left, int width, int height) {
        int diskHeight = height / (maxDisks+1);
        int smallestDiskWidth = width / (maxDisks+1);
        //draw Tower
        g.setColor(Color.LIGHT_GRAY);
        //draw base
        g.fillRect(left+2, height-diskHeight/2, width-4, diskHeight/2-2);
        //draw Needle
        g.fillRect(left+width/2-smallestDiskWidth/4, 2, smallestDiskWidth/2, height-4);
        
        //draw Disks
        for (int i = 0; i < alDisks.size(); i++) {
            byte disk = alDisks.get(i);
            g.setColor(new Color(255-256/maxDisks*disk,0,0,180));
            g.fillRect(left + width/2 - smallestDiskWidth*disk/2, 
                       height-(i+1)*diskHeight-diskHeight/2, 
                       smallestDiskWidth*disk , diskHeight);
            
        }        
    }
}
