package gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import logic.SierpinskiTriangle;

/**
 * Class name:   DrawPanel
 * @version Nov 6, 2012
 * @author  fred
 */
public class DrawPanel extends javax.swing.JPanel {
    
    private SierpinskiTriangle striangle = null;

    public void setTriangle(SierpinskiTriangle tr) {
        this.striangle = tr;
    } 
    
    /** Creates new form DrawPanel */
    public DrawPanel() {
        initComponents();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
       
        if (striangle != null) 
            striangle.draw(g, new Point2D.Double(0, (double)getHeight()),
                   new Point2D.Double((double)getWidth()/2.0, 0), 
                   new Point2D.Double((double)getWidth(), (double)getHeight()));
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