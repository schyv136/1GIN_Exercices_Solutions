
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *											//17 pts
 * @author fred
 */
public class TargetList {			
    
    private ArrayList<Target> targets = new ArrayList<>();		//1p

   
    public TargetList() {					//5p
        for (int i=0 ; i<20 ; i++) {
            int type= Randomizer.getInt(0, 2);
            if (type==0)  targets.add(new SmallTarget());
            if (type==1)  targets.add(new LargeTarget());
            if (type==2)  targets.add(new GrowingTarget());
        }           
    }
    
    
    public void draw(Graphics g) {				//1.5p
        Font f= g.getFont();
        g.setFont(g.getFont().deriveFont(Font.PLAIN, (float)12.0));        
        for (int i=0 ; i<targets.size() ; i++) 
            targets.get(i).draw(g);
        g.setFont(f);
    }
 
    
    public void doStep(int width, int height) {	//1.5p
        for (int i=0 ; i<targets.size() ; i++) 
            targets.get(i).doStep(width, height);
    }
 
    public int shoot(int pX, int pY) {			//8p
        int result =0;
        int hit=0;
        for (int i=0 ; i<targets.size() ; i++) {            
            if (targets.get(i).isInside(pX,pY)) {
                hit++;
                result += targets.get(i).getPoints();  //+= si plusieurs cibles
                int type= Randomizer.getInt(0, 2);
                if (type==0)  targets.set(i,new SmallTarget());
                if (type==1)  targets.set(i,new LargeTarget());
                if (type==2)  targets.set(i,new GrowingTarget());
            }
        }
        if (hit==0) {
            result -= 10; //lose 10 points if no hit
            new Sound().beep(300,100);
        }
        else
            new Sound().beep(result*100,20);  //sound freq. depends on result...
                                             //many points -> higher sound
        
        return result;         
    }
  
}