/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author kas
 */
public class Targets {
    private int score;
    private ArrayList<Target> alTargets = new ArrayList<>();

    public Targets() {
        for (int i = 0; i < 20; i++){
                int type = Randomizer.getInt(0, 2);
                switch(type){
                    case 0:
                        alTargets.add(i, new SmallTarget());
                        break;
                    case 1:
                        alTargets.add(i, new LargeTarget());
                        break;
                    case 2:
                        alTargets.add(i, new GrowingTarget());
                        break;
                }
            
        }
    }
    
    public void draw(Graphics g){
        for (int i = 0; i < alTargets.size(); i++) {
            alTargets.get(i).draw(g);
        }
        g.setColor(Color.RED);
        g.drawString("SCORE: " +score, 5, 15);
        
    }
    
    public void doStep(int width, int height){
        for (int i = 0; i < alTargets.size(); i++) {
            alTargets.get(i).doStep(width, height);
        }
    }
    
    public int shoot (int pX, int pY){
        for (int i = 0; i < alTargets.size(); i++) {
            if(alTargets.get(i).isInside(pX, pY)){
                score += alTargets.get(i).getPoints();
                int type = Randomizer.getInt(0, 2);
                switch(type){
                    case 0:
                        alTargets.set(i, new SmallTarget());
                        break;
                    case 1:
                        alTargets.set(i, new LargeTarget());
                        break;
                    case 2:
                        alTargets.set(i, new GrowingTarget());
                        break;
                }
                        
            }
            
        }
        
        return score;
    }
}
