
import java.awt.Color;
import java.awt.Graphics;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yvons
 */
public class LargeTarget extends Target {

    public LargeTarget() {
        super();
        size=40;
    }
    @Override
    public int getPoints()
    {
        return 10;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.YELLOW);
        super.draw(g); 
    }
    
}
