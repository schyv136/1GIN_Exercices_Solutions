
import Blocks.BlockMap;
import java.awt.Graphics;

/**
 * Class name:   DrawPanel
 * @version Dec 13, 2012
 * @author  fred
 */
public class DrawPanel extends javax.swing.JPanel {
    
    private BlockMap bm=null;

    public void setBm(BlockMap bm) {
        this.bm = bm;
    }
    
    /** Creates new form DrawPanel */
    public DrawPanel() {
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Draw BlockMap if initialized
        if (bm!=null) 
            bm.draw(g);
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