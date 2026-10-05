
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * Class name:   FractalTreePanel
 * @version Nov 6, 2012
 * @author  fred
 */
public class FractalTreePanel extends javax.swing.JPanel {

    private double length = 110;
    private double f1 = 0.75;
    private double f2 = 0.75;
    private double diffAngle = 40;

    public double getLength()                    { return length;          }
    public double getF1()                        { return f1;              }
    public double getF2()                        { return f2;              }
    public double getDiffAngle()                 { return diffAngle;       }
    
    public void   setLength(double length)       { this.length = length;       }
    public void   setF1(double f1)               { this.f1 = f1;               }
    public void   setF2(double f2)               { this.f2 = f2;               }
    public void   setDiffAngle(double diffAngle) { this.diffAngle = diffAngle; }
    
    /** Creates new form FractalTreePanel */
    public FractalTreePanel() {
        initComponents();
    }
    
    private Point2D drawVector(Graphics2D g, Point2D p, double length, double angle) {
        //Coloriser
        if      (length>10)    g.setColor(new Color(75, 50, 25)); 
        else if (length>5)     g.setColor(Color.RED);
        else if (length>3)     g.setColor(Color.YELLOW);
        else if (length>1.5)   g.setColor(Color.GREEN);
                          else g.setColor(new Color(0,100,0));
        //Donner une épaisseur aux branches
        g.setStroke(new BasicStroke((float)length/10+1));// trunc(Long/10)+1;
        //Dessiner le vecteur
        Point2D pEnd=new Point2D.Float();
        pEnd.setLocation( p.getX() + length*Math.cos(Math.toRadians(angle)), 
                          p.getY() + length*Math.sin(Math.toRadians(angle)));
        g.drawLine( (int)Math.round(p.getX()),      (int)Math.round(p.getY()),
                    (int)Math.round(pEnd.getX()),   (int)Math.round(pEnd.getY()));
        return pEnd;
    }
    
    private void drawFractalTree(Graphics2D g, Point2D p, double length, double angle,
                                 double f1, double f2, double diffAngle) 
    {
        if (length>1) {
           p = drawVector(g, p, length, angle);
           drawFractalTree    (g, p, length*f1, angle-diffAngle, f1,f2,diffAngle);
           drawFractalTree    (g, p, length*f2, angle+diffAngle, f1,f2,diffAngle);
       }
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
       //drawFractalTree((Graphics2D)g, new Point2D.Double(getWidth()/2, getHeight()), 
       //         Math.min(getWidth(), getHeight())/5, 270,  0.75,  0.75,  40.0) ;
        
       drawFractalTree((Graphics2D)g, new Point2D.Double(getWidth()/2, getHeight()), 
                        length, 270, f1,  f2,  diffAngle) ;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
