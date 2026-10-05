
import java.awt.Graphics;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yvons
 */
public class Targets {
    private ArrayList<Target> alTargets=new ArrayList();

    public Targets() {
        for(int i=0;i<20;i++)
        {
            alTargets.add(getNewTarget());
        }
    }
    
    public Target getNewTarget()
    {
        Target newTarget=new SmallTarget();
        int targetType=(int)(Math.random()*3);
        switch (targetType) {
            case 1: 
                newTarget=new LargeTarget();break;
            case 2: 
                newTarget=new GrowingTarget();break;
        }
        return newTarget;
    }
    
    public void draw(Graphics g)
    {
        for (Target target : alTargets) {
            target.draw(g);
        }
    }
    public void doStep(int width, int height)
    {
        for (Target target : alTargets) {
            target.doStep(width, height);
        }
    }
    public int shoot(int pX,int pY)
    {
        int sumScore=0;
        for(int i=0;i<alTargets.size();i++)
        {
            if(alTargets.get(i).isInside(pX, pY))
            {
                sumScore+=alTargets.get(i).getPoints();
                alTargets.set(i, getNewTarget());
            }
        }
        return sumScore;
    }
    
}
