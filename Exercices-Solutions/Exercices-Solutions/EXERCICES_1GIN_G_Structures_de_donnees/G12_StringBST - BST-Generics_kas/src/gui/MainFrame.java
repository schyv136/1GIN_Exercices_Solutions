package gui;

import binarySearchTree.BST;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
 * MainFrame.java
 * Created on Jan 3, 2012, 9:42:35 AM
 * @author Faber Fred
 */
public class MainFrame extends javax.swing.JFrame{
    
    private BST<String> tree = null;
    
    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        tree = new BST<>(); 
        stringBstViewPanel.setTree(tree);
        repaint();
    }
    
    public void updateView() {
        stringBstList.setListData(tree.toArray());
        if (tree.getMode()==BST.PREORDER)  preorderRadioButton.setSelected(true);
        if (tree.getMode()==BST.INORDER)   inorderRadioButton.setSelected(true);
        if (tree.getMode()==BST.POSTORDER) postorderRadioButton.setSelected(true);
        repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        clearButton = new javax.swing.JButton();
        stringBstViewPanel = new binarySearchTree.BSTView();
        jButton2 = new javax.swing.JButton();
        dataTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stringBstList = new javax.swing.JList();
        preorderRadioButton = new javax.swing.JRadioButton();
        inorderRadioButton = new javax.swing.JRadioButton();
        postorderRadioButton = new javax.swing.JRadioButton();
        loadButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        containsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("String BST");

        clearButton.setText("clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout stringBstViewPanelLayout = new javax.swing.GroupLayout(stringBstViewPanel);
        stringBstViewPanel.setLayout(stringBstViewPanelLayout);
        stringBstViewPanelLayout.setHorizontalGroup(
            stringBstViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );
        stringBstViewPanelLayout.setVerticalGroup(
            stringBstViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton2.setText("remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        dataTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataTextFieldActionPerformed(evt);
            }
        });

        addButton.setText("add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(stringBstList);

        buttonGroup1.add(preorderRadioButton);
        preorderRadioButton.setText("preorder");
        preorderRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preorderRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(inorderRadioButton);
        inorderRadioButton.setText("inorder");
        inorderRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inorderRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(postorderRadioButton);
        postorderRadioButton.setText("postorder");
        postorderRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postorderRadioButtonActionPerformed(evt);
            }
        });

        loadButton.setText("load");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        saveButton.setText("save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        containsButton.setText("contains ?");
        containsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                containsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(preorderRadioButton)
                        .addComponent(inorderRadioButton)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clearButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(containsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(loadButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(postorderRadioButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stringBstViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preorderRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inorderRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postorderRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadButton)
                .addContainerGap())
            .addComponent(stringBstViewPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        tree.clear();
        /* some demo data:
        tree.add("Jang");
        tree.add("Pol");
        tree.add("Pier");
        tree.add("Marc");
        tree.add("Anna");
        tree.add("Mario");
        tree.add("Boris");
        tree.add("Sam");
        tree.add("Claudio");
        */
        updateView();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tree.remove(dataTextField.getText());
        //tree.remove((int)(Math.random()*tree.size()));
        updateView();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void dataTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataTextFieldActionPerformed
        tree.add(dataTextField.getText());
        dataTextField.selectAll();
        updateView();
    }//GEN-LAST:event_dataTextFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        tree.add(dataTextField.getText());
        dataTextField.selectAll();
        dataTextField.requestFocus();
        updateView();
    }//GEN-LAST:event_addButtonActionPerformed

    private void preorderRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preorderRadioButtonActionPerformed
        tree.setMode(BST.PREORDER);
        updateView();
    }//GEN-LAST:event_preorderRadioButtonActionPerformed

    private void inorderRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inorderRadioButtonActionPerformed
        tree.setMode(BST.INORDER);
        updateView();
    }//GEN-LAST:event_inorderRadioButtonActionPerformed

    private void postorderRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postorderRadioButtonActionPerformed
        tree.setMode(BST.POSTORDER);
        updateView();
    }//GEN-LAST:event_postorderRadioButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            tree.saveToObjectFile("BSTData.obj");
        } catch (IOException ex)           {  
            System.err.println(ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
       try {
            tree.loadFromObjectFile("BSTData.obj");
        } catch (IOException ex)           {  
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        updateView();
    }//GEN-LAST:event_loadButtonActionPerformed

    private void containsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_containsButtonActionPerformed
        String needle = dataTextField.getText();
        if (tree.contains(needle)) 
            JOptionPane.showMessageDialog(this, "Yes, \'"+needle+"\' has been found inside the tree.");
        else
            JOptionPane.showMessageDialog(this, "No, \'"+needle+"\' was not found inside the tree.");
    }//GEN-LAST:event_containsButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearButton;
    private javax.swing.JButton containsButton;
    private javax.swing.JTextField dataTextField;
    private javax.swing.JRadioButton inorderRadioButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JRadioButton postorderRadioButton;
    private javax.swing.JRadioButton preorderRadioButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JList stringBstList;
    private binarySearchTree.BSTView stringBstViewPanel;
    // End of variables declaration//GEN-END:variables


}