package main;

import bst.StringBST;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
/*
 * MainFrame.java
 * @author Faber Fred & Scy
 */
public class MainFrame extends javax.swing.JFrame implements PropertyChangeListener {
    
    private StringBST tree = null;
    
    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        tree = new StringBST(); 
        tree.addPropertyChangeListener(this);      //this (controller) is an Observer
        tree.addPropertyChangeListener(stringBSTViewPanel); //View Panel is an Observer
        stringBSTViewPanel.setTree(tree);
        
        
        //some demo data:
        tree.add("Jang");
        tree.add("Pol");
        tree.add("Pier");
        tree.add("Marc");
        tree.add("Anna");
        tree.add("Mario");
        tree.add("Boris");
        tree.add("Sam");
        tree.add("Claudio");
    }
    
     public void propertyChange(PropertyChangeEvent arg0) {
        stringBstList.setListData(tree.toArray());
        if (tree.getMode()==StringBST.PREORDER)  preorderRadioButton.setSelected(true);
        if (tree.getMode()==StringBST.INORDER)   inorderRadioButton.setSelected(true);
        if (tree.getMode()==StringBST.POSTORDER) postorderRadioButton.setSelected(true);
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        clearButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
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
        stringBSTViewPanel = new bst.StringBSTView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("String BST");

        clearButton.setText("clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        removeButton.setText("remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
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

        javax.swing.GroupLayout stringBSTViewPanelLayout = new javax.swing.GroupLayout(stringBSTViewPanel);
        stringBSTViewPanel.setLayout(stringBSTViewPanelLayout);
        stringBSTViewPanelLayout.setHorizontalGroup(
            stringBSTViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        stringBSTViewPanelLayout.setVerticalGroup(
            stringBSTViewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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
                            .addComponent(removeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(containsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(loadButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(postorderRadioButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stringBSTViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(removeButton)
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
            .addComponent(jScrollPane1)
            .addComponent(stringBSTViewPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        tree.clear();
       
    }//GEN-LAST:event_clearButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        if(dataTextField.getText().isEmpty()){
            tree.remove((String)stringBstList.getSelectedValue());
        }
        else{
            tree.remove(dataTextField.getText());
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void dataTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataTextFieldActionPerformed
        tree.add(dataTextField.getText());
        dataTextField.selectAll();
    }//GEN-LAST:event_dataTextFieldActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        tree.add(dataTextField.getText());
        dataTextField.selectAll();
        dataTextField.requestFocus();
    }//GEN-LAST:event_addButtonActionPerformed

    private void preorderRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preorderRadioButtonActionPerformed
        tree.setMode(StringBST.PREORDER);
    }//GEN-LAST:event_preorderRadioButtonActionPerformed

    private void inorderRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inorderRadioButtonActionPerformed
        tree.setMode(StringBST.INORDER);
    }//GEN-LAST:event_inorderRadioButtonActionPerformed

    private void postorderRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_postorderRadioButtonActionPerformed
        tree.setMode(StringBST.POSTORDER);
    }//GEN-LAST:event_postorderRadioButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            tree.saveToFile("BSTData.txt");
        } catch (IOException ex)           {  
            System.err.println(ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
       try {
            tree.loadFromFile("BSTData.txt");
        }catch(FileNotFoundException ex){
           System.err.println(ex);
       } 
       catch (IOException ex)           {  
            System.err.println(ex);
        }
       
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadButton;
    private javax.swing.JRadioButton postorderRadioButton;
    private javax.swing.JRadioButton preorderRadioButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private bst.StringBSTView stringBSTViewPanel;
    private javax.swing.JList stringBstList;
    // End of variables declaration//GEN-END:variables


}