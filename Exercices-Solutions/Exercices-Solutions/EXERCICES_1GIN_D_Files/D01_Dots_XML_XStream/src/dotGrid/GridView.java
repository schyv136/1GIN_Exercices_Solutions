package dotGrid;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author fabfr
 */
public class GridView extends javax.swing.JPanel {

    private Grid grid=new Grid(10, 15);
    
    public GridView() {
        initComponents();
    }  
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (grid!=null) {
            grid.draw(g, getWidth(), getHeight());
            g.setColor(new Color(0,0,0,75));
            g.fillRoundRect(3, getHeight()-23, getWidth()-6, 20, 5, 5);
            g.setColor(new Color(255,255,255));
            g.drawString("Press: (s)ave - (l)oad DOM - (n)ew", 6, getHeight()-10);
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

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

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        Color color;
        int c=(int)(Math.random()*4);
        if      (c==0) color = Color.BLUE;
        else if (c==1) color = Color.RED;
        else if (c==2) color = Color.YELLOW;
        else if (c==3) color = Color.GREEN;
        else           color = Color.BLACK;
        int col=evt.getX()/grid.getCellWidth();
        int row=evt.getY()/grid.getCellWidth();
        if(col<grid.getCols() && row<grid.getRows()) {
            Dot dot = new Dot(col,row,color);
            grid.addDot(dot);
            repaint();            
        }
    }//GEN-LAST:event_formMousePressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        if(evt.getKeyChar()=='n') { //new (clear) grid
                grid.clear();
                repaint();
        }

        if(evt.getKeyChar()=='s') { //save grid as xml
            try {
                grid.saveToXml("dots.txt");
//                grid.saveToJsonFile("dotsJson.txt");
            } catch (IOException ex) {
                Logger.getLogger(GridView.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "file saved as \"dots.txt\" ...");
        }
        
                
        if(evt.getKeyChar()=='l') { 
            try {
                //load grid from xml file (DOM)
                grid.loadFromXmlDom("dots.txt");
                repaint();  
            } catch (IOException ex) {
                Logger.getLogger(GridView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
//        if(evt.getKeyChar()=='L') { 
//            try {
//                //load grid from xml file (DOM)
//                grid.loadFromXmlSax("dots.txt");
//                repaint();  
//            } catch (ParserConfigurationException ex) {
//                Logger.getLogger(GridView.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SAXException ex) {
//                Logger.getLogger(GridView.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException ex) {
//                Logger.getLogger(GridView.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }

//        if(evt.getKeyChar()=='j') { 
//            try {
//                //load grid from xml file (DOM)
//                grid = grid.loadFromJsonFile("dotsJson.txt");
//                repaint();  
//            } catch (IOException ex) {
//                Logger.getLogger(GridView.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }


    }//GEN-LAST:event_formKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
