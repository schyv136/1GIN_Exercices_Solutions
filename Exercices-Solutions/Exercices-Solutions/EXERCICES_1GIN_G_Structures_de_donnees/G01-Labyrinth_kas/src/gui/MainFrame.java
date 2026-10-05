package gui;

import Blocks.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Class name: MainFrame
 *
 * @version Dec 5, 2012
 * @author fred
 */
public class MainFrame extends javax.swing.JFrame {

    private BlockMap bm = null;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        bm = new BlockMap(20);  //create new BlockMap
        drawPanel1.setBm(bm);    //send the Blockmap to the drawPanel
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        upButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        downButton = new javax.swing.JButton();
        resetPlayerButton = new javax.swing.JButton();
        brickRadioButton = new javax.swing.JRadioButton();
        grassRadioButton = new javax.swing.JRadioButton();
        waterRadioButton = new javax.swing.JRadioButton();
        startRadioButton = new javax.swing.JRadioButton();
        endRadioButton = new javax.swing.JRadioButton();
        deleteRadioButton = new javax.swing.JRadioButton();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        drawPanel1 = new gui.DrawPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("The Labyrinth");
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        upButton.setText("Up");
        upButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upButtonActionPerformed(evt);
            }
        });

        leftButton.setText("Left");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        rightButton.setText("Right");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        downButton.setText("Down");
        downButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downButtonActionPerformed(evt);
            }
        });

        resetPlayerButton.setText("Reset Player");
        resetPlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPlayerButtonActionPerformed(evt);
            }
        });

        buttonGroup.add(brickRadioButton);
        brickRadioButton.setSelected(true);
        brickRadioButton.setText("Brick");

        buttonGroup.add(grassRadioButton);
        grassRadioButton.setText("Grass");

        buttonGroup.add(waterRadioButton);
        waterRadioButton.setText("Water");

        buttonGroup.add(startRadioButton);
        startRadioButton.setText("Start");

        buttonGroup.add(endRadioButton);
        endRadioButton.setText("End");

        buttonGroup.add(deleteRadioButton);
        deleteRadioButton.setText("<delete Blocks>");

        saveButton.setText("Save Map");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        loadButton.setText("Load Map");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(downButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resetPlayerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(endRadioButton)
                            .addComponent(brickRadioButton)
                            .addComponent(grassRadioButton)
                            .addComponent(waterRadioButton)
                            .addComponent(startRadioButton)
                            .addComponent(deleteRadioButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(leftButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rightButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(upButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leftButton)
                    .addComponent(rightButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downButton)
                .addGap(29, 29, 29)
                .addComponent(resetPlayerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(brickRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grassRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(waterRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteRadioButton)
                .addGap(18, 18, 18)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadButton)
                .addContainerGap(431, Short.MAX_VALUE))
        );

        drawPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawPanel1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout drawPanel1Layout = new javax.swing.GroupLayout(drawPanel1);
        drawPanel1.setLayout(drawPanel1Layout);
        drawPanel1Layout.setHorizontalGroup(
            drawPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        drawPanel1Layout.setVerticalGroup(
            drawPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(drawPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void upButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upButtonActionPerformed
        bm.movePlayer(BlockMap.MOVE_UP);
        repaint();
    }//GEN-LAST:event_upButtonActionPerformed

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        bm.movePlayer(BlockMap.MOVE_RIGHT);
        repaint();
    }//GEN-LAST:event_rightButtonActionPerformed

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        bm.movePlayer(BlockMap.MOVE_LEFT);
        repaint();
    }//GEN-LAST:event_leftButtonActionPerformed

    private void downButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downButtonActionPerformed
        bm.movePlayer(BlockMap.MOVE_DOWN);
        repaint();
    }//GEN-LAST:event_downButtonActionPerformed

    private void resetPlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPlayerButtonActionPerformed
        bm.resetPlayer();
        repaint();
    }//GEN-LAST:event_resetPlayerButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            bm.saveToFile("Current.map");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        try {
            bm.loadFromFile("Current.map");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint(); //don't forget...
    }//GEN-LAST:event_loadButtonActionPerformed


    private void drawPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawPanelMousePressed
        if (deleteRadioButton.isSelected()) //delete Block @ clicked position
        {
            bm.deleteBlock(evt.getX() / 40, evt.getY() / 40);
        } else {                                  // add new Block @ clicked position
            Block newBlock = null;
            if (brickRadioButton.isSelected()) {
                newBlock = new Brick();
            }
            if (grassRadioButton.isSelected()) {
                newBlock = new Grass();
            }
            if (waterRadioButton.isSelected()) {
                newBlock = new Water();
            }
            if (startRadioButton.isSelected()) {
                if (bm.hasStart()) {
                    JOptionPane.showMessageDialog(this, "This map already has a Start block!");
                } else {
                    newBlock = new Start();
                }
            }
            if (endRadioButton.isSelected()) {
                newBlock = new End();
            }
            bm.addBlock(evt.getX() / 40, evt.getY() / 40, newBlock);
        }
        repaint();
    }//GEN-LAST:event_drawPanelMousePressed

    private void drawPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawPanel1MousePressed
        if (deleteRadioButton.isSelected()) //delete Block @ clicked position
        {
            bm.deleteBlock(evt.getX() / 40, evt.getY() / 40);
        } else {                                  // add new Block @ clicked position
            Block newBlock = null;
            if (brickRadioButton.isSelected()) {
                newBlock = new Brick();
            }
            if (grassRadioButton.isSelected()) {
                newBlock = new Grass();
            }
            if (waterRadioButton.isSelected()) {
                newBlock = new Water();
            }
            if (startRadioButton.isSelected()) {
                if (bm.hasStart()) {
                    JOptionPane.showMessageDialog(this, "This map already has a Start block!");
                } else {
                    newBlock = new Start();
                }
            }
            if (endRadioButton.isSelected()) {
                newBlock = new End();
            }
            bm.addBlock(evt.getX() / 40, evt.getY() / 40, newBlock);
        }
        repaint();
    }//GEN-LAST:event_drawPanel1MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton brickRadioButton;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JRadioButton deleteRadioButton;
    private javax.swing.JButton downButton;
    private gui.DrawPanel drawPanel1;
    private javax.swing.JRadioButton endRadioButton;
    private javax.swing.JRadioButton grassRadioButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton leftButton;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton resetPlayerButton;
    private javax.swing.JButton rightButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JRadioButton startRadioButton;
    private javax.swing.JButton upButton;
    private javax.swing.JRadioButton waterRadioButton;
    // End of variables declaration//GEN-END:variables

}
