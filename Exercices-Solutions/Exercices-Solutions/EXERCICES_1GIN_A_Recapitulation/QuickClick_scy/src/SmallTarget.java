
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
public class SmallTarget extends Target {

    public SmallTarget() {
        super();
        size=20;
    }
    @Override
    public int getPoints()
    {
        return 20;
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.GREEN);
        super.draw(g); 
    }
}
