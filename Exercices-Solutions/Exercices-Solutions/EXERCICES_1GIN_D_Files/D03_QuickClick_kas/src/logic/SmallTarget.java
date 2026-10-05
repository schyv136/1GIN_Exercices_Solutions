/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author kas
 */
public class SmallTarget extends Target{

    public SmallTarget() {
        super();
        size = 20;
    }
    
    @Override
    public int getPoints(){
        int points = 20;
        
        return points;
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.green);
        super.draw(g);
        
    }
}
