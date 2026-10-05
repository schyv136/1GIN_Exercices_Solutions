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
public class GrowingTarget extends Target{

    public GrowingTarget() {
        super();
        size = 5;
    }
    
    @Override
    public int getPoints(){
        int points = 50-size;
        
        return points;
    }
    
    @Override
    public void draw(Graphics g){
        g.setColor(Color.orange);
        super.draw(g);
    }
    
    @Override
    public void doStep(int width, int height){
        size += 5;
        if (size >= 50){
            size = 5;
        }
        super.doStep(width, height);
    }
    
}
