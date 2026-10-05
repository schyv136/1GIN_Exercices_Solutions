
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *											//17 pts
 * @author fred
 */
public class TargetList {			
    
    private ArrayList<Target> targets = new ArrayList<Target>();		//1p

   
    public TargetList() {					//5p
        for (int i=0 ; i<20 ; i++) {
            int type= Randomizer.getInt(0, 2);
            if (type==0)  targets.add(new SmallTarget());
            if (type==1)  targets.add(new LargeTarget());
            if (type==2)  targets.add(new GrowingTarget());
        }           
    }
    
    
    public void draw(Graphics g) {				//1.5p
        for (int i=0 ; i<targets.size() ; i++) 
            targets.get(i).draw(g);
    }
 
    
    public void doStep(int width, int height) {	//1.5p
        for (int i=0 ; i<targets.size() ; i++) 
            targets.get(i).doStep(width, height);
    }
 
    public int shoot(int pX, int pY) {			//8p
        int result =0;
        for (int i=0 ; i<targets.size() ; i++) 
            if (targets.get(i).isInside(pX,pY)) {
                result += targets.get(i).getPoints();  //+= si plusieurs cibles
                int type= Randomizer.getInt(0, 2);
                if (type==0)  targets.set(i,new SmallTarget());
                if (type==1)  targets.set(i,new LargeTarget());
                if (type==2)  targets.set(i,new GrowingTarget());
            }
        return result;         
    }
  
}