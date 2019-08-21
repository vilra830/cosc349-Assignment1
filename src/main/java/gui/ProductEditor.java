package gui;

import dao.DAO;
import dao.DAOException;
import dao.DAOInterface;
import dao.ProductDBManager;
//import dao.ProductDBManager;
import java.math.BigDecimal;
import domain.Product;
import helpers.SimpleListModel;
import javax.swing.JOptionPane;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.exception.ConstraintsViolatedException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** A GUI class that allows use to input product details.Also, shows categories
 * that have been previously entered into the system. 
 *
 * @author Rhea VIllafuerte
 */
public class ProductEditor extends javax.swing.JDialog {

    /**
     * Creates new form productEditor
     */
    
    private final DAOInterface dao;// = new ProductDBManager();
        Product product = new Product();
        private SimpleListModel helper = new SimpleListModel();


    public ProductEditor(java.awt.Frame parent, boolean modal , DAOInterface dao) {
        super(parent, modal);
        this.dao = dao;
        initComponents();
        categoryBox.setEditable(true);
        
        helper.updateItems(dao.getCategories());
        categoryBox.setModel(helper);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtID = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        category = new javax.swing.JLabel();
        categoryBox = new javax.swing.JComboBox<>();
        price = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        stockQuantity = new javax.swing.JLabel();
        stockQuantityField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtID.setText("    ID:");

        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        name.setText("Name:");

        jLabel3.setText("Description:");

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        category.setText("Category");

        price.setText("Price");

        stockQuantity.setText("Stock Quantity");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("                 PRODUCT EDITOR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameField)
                    .addComponent(jScrollPane1)
                    .addComponent(categoryBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(priceField)
                    .addComponent(stockQuantityField)
                    .addComponent(idField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(category)
                .addContainerGap(471, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(price)
                .addContainerGap(471, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stockQuantity)
                .addContainerGap(471, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(category))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stockQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
      try {
          
          if (evt.getSource() == saveButton){
           String productName = nameField.getText();
           String productID = idField.getText();
           String productDescription = descriptionField.getText();
           String productCategory = (String) categoryBox.getSelectedItem();
           BigDecimal productPrice = new BigDecimal(priceField.getText());
           BigDecimal productQuantity = new BigDecimal(stockQuantityField.getText());

           
           product.setProductID(productID);
           product.setProductName(productName);
           product.setProductDescription(productDescription);
           product.setProductCategory(productCategory);
           product.setStockQuantity(productQuantity);
           product.setPriceList(productPrice);
           
           
           new Validator().assertValid(product);
                 
           dao.saveProduct(this.product);
           dispose();
           
       } 
      
             }catch (ConstraintsViolatedException ex) {
                   // get the violated constraints from the exception
                   ConstraintViolation[] violations = ex.getConstraintViolations();
                   // create a nice error message for the user
                   String msg = "Please fix the following input problems:";
                   for (ConstraintViolation cv : violations) {
                       msg += "\n •" + cv.getMessage();
                   }// display the message to the user                   
                   JOptionPane.showMessageDialog(this, msg, "Input Error",JOptionPane.ERROR_MESSAGE);
                   }catch (NumberFormatException nfe) {
                       JOptionPane.showMessageDialog(this,"You have entered a price or quantity that is not a valid number.","Input Error", JOptionPane.ERROR_MESSAGE);
                   }catch (DAOException ex) {
                       JOptionPane.showMessageDialog(this, ex.getMessage(), "Warning", JOptionPane.INFORMATION_MESSAGE);
                   }
               
               
       
       
    }//GEN-LAST:event_saveButtonActionPerformed

 

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
      dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel category;
    private javax.swing.JComboBox<String> categoryBox;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel price;
    private javax.swing.JTextField priceField;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel stockQuantity;
    private javax.swing.JTextField stockQuantityField;
    private javax.swing.JLabel txtID;
    // End of variables declaration//GEN-END:variables

    
}
