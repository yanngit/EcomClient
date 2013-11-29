/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.DecorationEntity;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Alexis BRENON <brenon.alexis@gmail.com>
 */
public class decorationPanel extends javax.swing.JPanel {

    /**
     * Creates new form beveragePanel
     */
    public decorationPanel() {
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
        jLabel2 = new javax.swing.JLabel();
        decorationPriceSpinner = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        decorationStockSpinner = new javax.swing.JSpinner();
        validateButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        decorationNameField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setDividerSize(5);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setLabelFor(decorationNameField);
        jLabel2.setText("Désignation :");

        decorationPriceSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), null, Float.valueOf(0.0f)));
        decorationPriceSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                decorationFormFocusLost(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setLabelFor(decorationStockSpinner);
        jLabel4.setText("Stock :");

        decorationStockSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        decorationStockSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                decorationFormFocusLost(evt);
            }
        });

        validateButton.setText("Créer");
        validateButton.setEnabled(false);
        validateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateButtonActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setLabelFor(decorationPriceSpinner);
        jLabel5.setText("Prix :");

        decorationNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                decorationFormFocusLost(evt);
            }
        });

        cancelButton.setText("Annuler");
        cancelButton.setEnabled(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Supprimer");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(deleteButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(decorationStockSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(decorationPriceSpinner)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(validateButton))
                    .addComponent(decorationNameField)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(decorationNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(decorationPriceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(decorationStockSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 152, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(validateButton)
                    .addComponent(cancelButton)
                    .addComponent(deleteButton)))
        );

        jScrollPane1.setViewportView(jPanel1);

        jSplitPane1.setRightComponent(jScrollPane1);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(150, 75));

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Désignation", "Prix", "Volume"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFillsViewportHeight(true);
        jTable2.setMinimumSize(new java.awt.Dimension(150, 75));
        jTable2.setPreferredSize(new java.awt.Dimension(150, 75));
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
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        List<DecorationEntity> decos;
        decos = TchinTchinAdminFrame.adminFacade.getAllDecorations();
        if (decos != null) {
            for (int i = 0; i < decos.size(); i++) {
                DecorationEntity entity = decos.get(i);
                addDecoToTable(entity);
            }
        }
    }//GEN-LAST:event_formComponentAdded

    private void decorationFormFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_decorationFormFocusLost
        if (!decorationNameField.getText().isEmpty()
                && decorationPriceSpinner.getValue() != null
                && decorationStockSpinner.getValue() != null) {
            cancelButton.setEnabled(true);
            validateButton.setEnabled(true);
        } else {
            validateButton.setEnabled(false);
        }
    }//GEN-LAST:event_decorationFormFocusLost

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        jTable2SelectionChanged();
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyTyped
        jTable2SelectionChanged();
    }//GEN-LAST:event_jTable2KeyTyped

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        decorationNameField.setText("");
        decorationPriceSpinner.setValue(0.0);
        decorationStockSpinner.setValue(0);

        validateButton.setText("Créer");
        validateButton.setEnabled(false);
        cancelButton.setEnabled(false);
        deleteButton.setEnabled(false);

        decoID = null;
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void validateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateButtonActionPerformed
        DecorationEntity entity = new DecorationEntity();
        entity.setName(decorationNameField.getText());
        entity.setPrice((Float) decorationPriceSpinner.getValue());
        entity.setQuantity((Integer) decorationStockSpinner.getValue());

        String dialogTitle;
        String dialogContent;

        /* If we are creating a new beverage */
        if (decoID == null) {
            // Add new beverage to database
            entity = TchinTchinAdminFrame.adminFacade.addDecoration(entity);
            // Update the table display
            addDecoToTable(entity);

            dialogTitle = "Création d'une décoration";
            dialogContent = "La décoration a été créée avec succès !";
        } /* We are updating an already present beverage */ else {
            entity.setID(decoID);

            // Update beverage in database
            TchinTchinAdminFrame.adminFacade.updateDecoration(entity);
            // Update beverage in table
            DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
            int rowToUpdate = jTable2.getSelectedRow();
            tableModel.setValueAt(entity.getName(), rowToUpdate, 1);
            tableModel.setValueAt(entity.getPrice(), rowToUpdate, 2);
            tableModel.setValueAt(entity.getQuantity(), rowToUpdate, 3);

            dialogTitle = "Modification d'une décoration";
            dialogContent = "La décoration a été modifiée avec succès !";
        }
        JOptionPane.showMessageDialog(this, dialogContent, dialogTitle, JOptionPane.INFORMATION_MESSAGE);
        this.cancelButtonActionPerformed(evt);
    }//GEN-LAST:event_validateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        DecorationEntity entity = new DecorationEntity();
        entity.setName(decorationNameField.getText());
        entity.setPrice((Float) decorationPriceSpinner.getValue());
        entity.setQuantity((Integer) decorationStockSpinner.getValue());
        entity.setID(decoID);

        if (JOptionPane.showConfirmDialog(this,
                "Êtes-vous sûr de vouloir supprimer cette décoration :\n"
                + entity.getName(),
                "Suppression d'une décoration",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {


            TchinTchinAdminFrame.adminFacade.removeDecoration(entity);
            int removedRow = jTable2.getSelectedRow();
            ((DefaultTableModel) jTable2.getModel()).fireTableRowsDeleted(removedRow, removedRow);
            ((DefaultTableModel) jTable2.getModel()).removeRow(removedRow);

            JOptionPane.showMessageDialog(this,
                    "Décoration supprimée !",
                    "Suppression d'une décoration",
                    JOptionPane.WARNING_MESSAGE);
            this.cancelButtonActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this,
                    "La décoration n'a pas été supprimée !",
                    "Suppression d'une décoration",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField decorationNameField;
    private javax.swing.JSpinner decorationPriceSpinner;
    private javax.swing.JSpinner decorationStockSpinner;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton validateButton;
    // End of variables declaration//GEN-END:variables
    private Long decoID;

    private void addDecoToTable(DecorationEntity entity) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable2.getModel();
        Object[] row = {entity.getID(),
            entity.getName(),
            entity.getPrice(),
            entity.getQuantity()};
        tableModel.addRow(row);
        int rowIdx = tableModel.getRowCount() - 1;
        tableModel.fireTableRowsInserted(rowIdx, rowIdx);
    }

    private void jTable2SelectionChanged() {
        int i = jTable2.getSelectedRow();
        if (i >= 0) {
            TableModel model = jTable2.getModel();
            decorationNameField.setText((String) model.getValueAt(i, 1));
            decorationPriceSpinner.setValue((Float) model.getValueAt(i, 2));
            decorationStockSpinner.setValue((Integer) model.getValueAt(i, 3));

            validateButton.setText("Modifier");
            validateButton.setEnabled(true);
            cancelButton.setEnabled(true);
            deleteButton.setEnabled(true);

            decoID = (Long) model.getValueAt(i, 0);
        }
    }
}
