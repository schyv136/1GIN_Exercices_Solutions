
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
public class GrowingTarget extends Target {

    public GrowingTarget() {
        super();
        size=5;
    }
    @Override
    public int getPoints()
    {
        return 50-this.size;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.ORANGE);
        super.draw(g);  
    }
    public void doStep(int width, int height)
    {
        this.size+=5;
        if(this.size>50)
        {
            this.size=5;
        }
        super.doStep(width, height);
    }
    
}
