/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.BeverageEntity;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Alexis BRENON <brenon.alexis@gmail.com>
 */
public class beveragePanel extends javax.swing.JPanel {

    /**
     * Creates new form beveragePanel
     */
    public beveragePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        beverageNameField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        beveragePriceSpinner = new javax.swing.JSpinner();
        beverageAlcoholicLabel = new javax.swing.JLabel();
        beverageAlcoholicSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        beverageStockSpinner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        beverageVolumeSpinner = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        validateButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        jSplitPane1.setDividerSize(5);

        jPanel2.setLayout(new java.awt.GridLayout(5, 2, 10, 5));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setLabelFor(beverageNameField);
        jLabel2.setText("Désignation :");
        jPanel2.add(jLabel2);

        beverageNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                beverageFormFocusLost(evt);
            }
        });
        jPanel2.add(beverageNameField);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setLabelFor(beveragePriceSpinner);
        jLabel5.setText("Prix :");
        jPanel2.add(jLabel5);

        beveragePriceSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), null, Float.valueOf(1.0f)));
        beveragePriceSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                beverageFormFocusLost(evt);
            }
        });
        jPanel2.add(beveragePriceSpinner);

        beverageAlcoholicLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        beverageAlcoholicLabel.setLabelFor(beverageAlcoholicSpinner);
        beverageAlcoholicLabel.setText("Degré d'alcool :");
        jPanel2.add(beverageAlcoholicLabel);

        beverageAlcoholicSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        beverageAlcoholicSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                beverageFormFocusLost(evt);
            }
        });
        jPanel2.add(beverageAlcoholicSpinner);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setLabelFor(beverageStockSpinner);
        jLabel4.setText("Stock :");
        jPanel2.add(jLabel4);

        beverageStockSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        beverageStockSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                beverageFormFocusLost(evt);
            }
        });
        jPanel2.add(beverageStockSpinner);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setLabelFor(beverageVolumeSpinner);
        jLabel3.setText("Volume (cL) :");
        jPanel2.add(jLabel3);

        beverageVolumeSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(75), Integer.valueOf(0), null, Integer.valueOf(1)));
        beverageVolumeSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                beverageFormFocusLost(evt);
            }
        });
        jPanel2.add(beverageVolumeSpinner);

        jPanel3.setLayout(new java.awt.BorderLayout());

        cancelButton.setText("Annuler");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel3.add(cancelButton, java.awt.BorderLayout.EAST);

        deleteButton.setText("Supprimer");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel3.add(deleteButton, java.awt.BorderLayout.WEST);

        validateButton.setText("Créer");
        validateButton.setEnabled(false);
        validateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateButtonActionPerformed(evt);
            }
        });
        jPanel3.add(validateButton, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jSplitPane1.setRightComponent(jScrollPane1);

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Désignation", "Prix", "Stock", "Volume", "Degré d'alcool"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFillsViewportHeight(true);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable2KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jSplitPane1.setLeftComponent(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        List<BeverageEntity> beverages;
        beverages = TchinTchinAdminFrame.adminFacade.getAllBeverages();
        if (beverages != null) {
            for (int i = 0; i < beverages.size(); i++) {
                BeverageEntity entity = beverages.get(i);
                addBeverageToTable(entity);
            }
        }
    }//GEN-LAST:event_formComponentAdded

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        jTable2SelectionChanged();
    }//GEN-LAST:event_jTable2MouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        beverageNameField.setText("");
        beveragePriceSpinner.setValue(0.0);
        beverageStockSpinner.setValue(0);
        beverageVolumeSpinner.setValue(75);
        beverageAlcoholicSpinner.setValue(0);

        validateButton.setText("Créer");
        validateButton.setEnabled(false);
        cancelButton.setEnabled(false);
        deleteButton.setEnabled(false);

        beverageID = null;
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void validateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateButtonActionPerformed
        BeverageEntity entity = new BeverageEntity();
        entity.setName(beverageNameField.getText());
        entity.setPrice((Float) beveragePriceSpinner.getValue());
        entity.setQuantity((Integer) beverageStockSpinner.getValue());
        entity.setCapacity((Integer) beverageVolumeSpinner.getValue());
        entity.setAlcoholicDegree((Integer) beverageAlcoholicSpinner.getValue());

        String dialogTitle;
        String dialogContent;

        /* If we are creating a new beverage */
        if (beverageID == null) {
            // Add new beverage to database
            entity = TchinTchinAdminFrame.adminFacade.addBeverage(entity);
            // Update the table display
            addBeverageToTable(entity);

            dialogTitle = "Création d'une boisson";
            dialogContent = "La boisson a été créée avec succès !";
        } /* We are updating an already present beverage */ else {
            entity.setID(beverageID);

            // Update beverage in database
            TchinTchinAdminFrame.adminFacade.updateBeverage(entity);
            // Update beverage in table
            DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
            int rowToUpdate = jTable2.getSelectedRow();
            tableModel.setValueAt(entity.getName(), rowToUpdate, 1);
            tableModel.setValueAt(entity.getPrice(), rowToUpdate, 2);
            tableModel.setValueAt(entity.getQuantity(), rowToUpdate, 3);
            tableModel.setValueAt(entity.getCapacity(), rowToUpdate, 4);
            tableModel.setValueAt(entity.getAlcoholicDegree(), rowToUpdate, 5);

            dialogTitle = "Modification d'une boisson";
            dialogContent = "La boisson a été modifiée avec succès !";
        }
        JOptionPane.showMessageDialog(this, dialogContent, dialogTitle, JOptionPane.INFORMATION_MESSAGE);
        this.cancelButtonActionPerformed(evt);
    }//GEN-LAST:event_validateButtonActionPerformed

    private void beverageFormFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_beverageFormFocusLost
        if (!beverageNameField.getText().isEmpty()
                && beveragePriceSpinner.getValue() != null
                && beverageStockSpinner.getValue() != null
                && beverageVolumeSpinner.getValue() != null
                && beverageAlcoholicSpinner.getValue() != null) {
            cancelButton.setEnabled(true);
            validateButton.setEnabled(true);
        } else {
            validateButton.setEnabled(false);
        }
    }//GEN-LAST:event_beverageFormFocusLost

    private void jTable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyTyped
        jTable2SelectionChanged();
    }//GEN-LAST:event_jTable2KeyTyped

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        BeverageEntity entity = new BeverageEntity();
        entity.setName(beverageNameField.getText());
        entity.setPrice((Float) beveragePriceSpinner.getValue());
        entity.setQuantity((Integer) beverageStockSpinner.getValue());
        entity.setCapacity((Integer) beverageVolumeSpinner.getValue());
        entity.setAlcoholicDegree((Integer) beverageAlcoholicSpinner.getValue());

        entity.setID(beverageID);

        if (JOptionPane.showConfirmDialog(this,
                "Êtes-vous sûr de vouloir supprimer cette boisson :\n"
                + entity.getName(),
                "Suppression d'une boisson",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {


            TchinTchinAdminFrame.adminFacade.removeBeverage(entity);
            int removedRow = jTable2.getSelectedRow();
            ((DefaultTableModel) jTable2.getModel()).fireTableRowsDeleted(removedRow, removedRow);
            ((DefaultTableModel) jTable2.getModel()).removeRow(removedRow);

            JOptionPane.showMessageDialog(this,
                    "Boisson supprimée !",
                    "Suppression d'une boisson",
                    JOptionPane.WARNING_MESSAGE);
            this.cancelButtonActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this,
                    "La boisson n'a pas été supprimée !",
                    "Suppression d'une boisson",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel beverageAlcoholicLabel;
    private javax.swing.JSpinner beverageAlcoholicSpinner;
    private javax.swing.JTextField beverageNameField;
    private javax.swing.JSpinner beveragePriceSpinner;
    private javax.swing.JSpinner beverageStockSpinner;
    private javax.swing.JSpinner beverageVolumeSpinner;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton validateButton;
    // End of variables declaration//GEN-END:variables
    private Long beverageID;

    private void addBeverageToTable(BeverageEntity entity) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        Object[] row = {entity.getID(),
            entity.getName(),
            entity.getPrice(),
            entity.getQuantity(),
            entity.getCapacity(),
            entity.getAlcoholicDegree()};
        tableModel.addRow(row);
        int rowIdx = tableModel.getRowCount() - 1;
        tableModel.fireTableRowsInserted(rowIdx, rowIdx);
    }

    private void jTable2SelectionChanged() {
        int i = jTable2.getSelectedRow();
        if (i >= 0) {
            TableModel model = jTable2.getModel();
            beverageNameField.setText((String) model.getValueAt(i, 1));
            beveragePriceSpinner.setValue((Float) model.getValueAt(i, 2));
            beverageStockSpinner.setValue((Integer) model.getValueAt(i, 3));
            beverageVolumeSpinner.setValue((Integer) model.getValueAt(i, 4));
            beverageAlcoholicSpinner.setValue((Integer) model.getValueAt(i, 5));

            validateButton.setText("Modifier");
            validateButton.setEnabled(true);
            cancelButton.setEnabled(true);
            deleteButton.setEnabled(true);

            beverageID = (Long) model.getValueAt(i, 0);
        }
    }
}
