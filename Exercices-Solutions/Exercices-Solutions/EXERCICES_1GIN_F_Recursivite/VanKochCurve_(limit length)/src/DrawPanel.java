
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

/**
 * Class name:   DrawPanel
 * @version Dec 7, 2013
 * @author  fred
 */
public class DrawPanel extends javax.swing.JPanel {
    
    

    
    /** Creates new form DrawPanel */
    public DrawPanel() {
        initComponents();
    }
    
    @Override
    public void paintComponent(Graphics g) {
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, getWidth(), getHeight());
       
       VanKochCurve curve = new VanKochCurve();        
       curve.draw( g, new Point2D.Double(0,            getHeight()), getWidth(), 0,    Color.YELLOW);
       curve.draw( g, new Point2D.Double(getWidth()-1, getHeight()), getHeight(), -90, Color.YELLOW);
       curve.draw( g, new Point2D.Double(getWidth()-1, 0          ), getWidth(), 180,  Color.YELLOW);
       curve.draw( g, new Point2D.Double(0           , 0          ), getHeight(),90,   Color.YELLOW);

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
