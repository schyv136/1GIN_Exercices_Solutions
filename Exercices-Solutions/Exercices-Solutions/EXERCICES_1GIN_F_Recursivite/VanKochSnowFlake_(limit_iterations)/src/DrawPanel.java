
import java.awt.Color;
import java.awt.Graphics;

/**
 * Class name:   DrawPanel
 * @version Dec 7, 2013
 * @author  fred
 */
public class DrawPanel extends javax.swing.JPanel {
    
    private VanKochSnowFlake curve = null;

    public void setCurve(VanKochSnowFlake curve) {
        this.curve = curve;
    }

    
    /** Creates new form DrawPanel */
    public DrawPanel() {
        initComponents();
    }
    
    @Override
    public void paintComponent(Graphics g) {
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, getWidth(), getHeight());
       
       if (curve != null) 
           curve.draw(g, getWidth(), getHeight(), Color.yellow);
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
