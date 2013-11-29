/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import entity.BeverageEntity;
import entity.CocktailEntity;
import entity.DecorationEntity;
import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pojo.CocktailFlavorEnum;
import pojo.CocktailPowerEnum;
import pojo.Deliverable;

/**
 *
 * @author Alexis BRENON <brenon.alexis@gmail.com>
 */
public class cocktailsPanel extends javax.swing.JPanel {

    /**
     * Creates new form cocktailsPanel
     */
    public cocktailsPanel() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        validateButton = new javax.swing.JButton();
        cocktailNameField = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cocktailPhotoField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cocktailFlavorCombo = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        cocktailPowerCombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cocktailRecipeText = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        availableDelivrablesList = new javax.swing.JList();
        removeDeliverableButton = new javax.swing.JButton();
        addDeliverableButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        cocktailDelivrablesList = new javax.swing.JList();
        jSeparator2 = new javax.swing.JSeparator();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nom", "Prix", "Photo (nom)", "Goût", "Puissance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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
        jTable1.setDoubleBuffered(true);
        jTable1.setFillsViewportHeight(true);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Nom :");

        validateButton.setText("Créer");
        validateButton.setEnabled(false);
        validateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateButtonActionPerformed(evt);
            }
        });

        cocktailNameField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                cocktailNameFieldCaretUpdate(evt);
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

        jLabel1.setText("Photo :");

        jLabel3.setText("img/");

        cocktailPhotoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cocktailFormFocusLost(evt);
            }
        });

        jLabel7.setText("Goût :");

        cocktailFlavorCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Puissance :");

        cocktailPowerCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Recette :");

        cocktailRecipeText.setColumns(20);
        cocktailRecipeText.setRows(5);
        cocktailRecipeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cocktailFormFocusLost(evt);
            }
        });
        jScrollPane3.setViewportView(cocktailRecipeText);

        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel2Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0};
        jPanel2.setLayout(jPanel2Layout);

        availableDelivrablesList.setMaximumSize(new java.awt.Dimension(50, 85));
        availableDelivrablesList.setMinimumSize(new java.awt.Dimension(50, 85));
        availableDelivrablesList.setPreferredSize(new java.awt.Dimension(50, 85));
        availableDelivrablesList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cocktailFormFocusLost(evt);
            }
        });
        jScrollPane5.setViewportView(availableDelivrablesList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(jScrollPane5, gridBagConstraints);

        removeDeliverableButton.setText("<<");
        removeDeliverableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDeliverableButtonActionPerformed(evt);
            }
        });
        removeDeliverableButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cocktailFormFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        jPanel2.add(removeDeliverableButton, gridBagConstraints);

        addDeliverableButton.setText(">>");
        addDeliverableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDeliverableButtonActionPerformed(evt);
            }
        });
        addDeliverableButton.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cocktailFormFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel2.add(addDeliverableButton, gridBagConstraints);

        cocktailDelivrablesList.setMaximumSize(new java.awt.Dimension(50, 85));
        cocktailDelivrablesList.setMinimumSize(new java.awt.Dimension(50, 85));
        cocktailDelivrablesList.setPreferredSize(new java.awt.Dimension(50, 85));
        cocktailDelivrablesList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cocktailFormFocusLost(evt);
            }
        });
        jScrollPane6.setViewportView(cocktailDelivrablesList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 7;
        jPanel2.add(jScrollPane6, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cocktailNameField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addComponent(cancelButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(validateButton))
                            .addComponent(cocktailPhotoField)))
                    .addComponent(cocktailFlavorCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cocktailPowerCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(deleteButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cocktailNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(cocktailPhotoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cocktailFlavorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cocktailPowerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(validateButton)
                    .addComponent(cancelButton)
                    .addComponent(deleteButton)))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addDeliverableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDeliverableButtonActionPerformed
        DefaultListModel availibleListModel = (DefaultListModel) availableDelivrablesList.getModel();
        DefaultListModel listModel = (DefaultListModel) cocktailDelivrablesList.getModel();

        Deliverable deliverable = (Deliverable) availableDelivrablesList.getSelectedValue();
        listModel.addElement(deliverable);
        availibleListModel.removeElement(deliverable);
    }//GEN-LAST:event_addDeliverableButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        CocktailEntity entity = new CocktailEntity();
        entity.setName(cocktailNameField.getText());
        entity.setID(cocktailID);

        if (JOptionPane.showConfirmDialog(this,
                "Êtes-vous sûr de vouloir supprimer ce cocktail :\n"
                + entity.getName(),
                "Suppression d'un cocktail",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            TchinTchinAdminFrame.adminFacade.removeCocktail(entity);
            int removedRow = jTable1.getSelectedRow();
            ((DefaultTableModel) jTable1.getModel()).fireTableRowsDeleted(removedRow, removedRow);
            ((DefaultTableModel) jTable1.getModel()).removeRow(removedRow);

            JOptionPane.showMessageDialog(this,
                    "Cocktail supprimé !",
                    "Suppression d'un cocktail",
                    JOptionPane.WARNING_MESSAGE);
            this.cancelButtonActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Le cocktail n'a pas été supprimé !",
                    "Suppression d'un cocktail",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cocktailNameField.setText("");
        cocktailPhotoField.setText(cocktailNameField.getText());
        cocktailFlavorCombo.setSelectedIndex(0);
        cocktailPowerCombo.setSelectedIndex(0);
        cocktailRecipeText.setText("");
        ((DefaultListModel) cocktailDelivrablesList.getModel()).removeAllElements();

        validateButton.setText("Créer");
        validateButton.setEnabled(false);
        cancelButton.setEnabled(false);
        deleteButton.setEnabled(false);

        cocktailID = null;
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cocktailFormFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cocktailFormFocusLost
        if (!cocktailNameField.getText().isEmpty()
                && !cocktailPhotoField.getText().isEmpty()
                && !cocktailRecipeText.getText().isEmpty()
                && cocktailDelivrablesList.getModel().getSize() > 0) {
            cancelButton.setEnabled(true);
            validateButton.setEnabled(true);
        } else {
            validateButton.setEnabled(false);
        }
    }//GEN-LAST:event_cocktailFormFocusLost

    private void validateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateButtonActionPerformed
        CocktailEntity entity = new CocktailEntity();
        entity.setName(cocktailNameField.getText());
        entity.setPhotoURI(cocktailPhotoField.getText());
        entity.setFlavor((CocktailFlavorEnum) cocktailFlavorCombo.getSelectedItem());
        entity.setPower((CocktailPowerEnum) cocktailPowerCombo.getSelectedItem());
        entity.setRecipe(cocktailRecipeText.getText());

        /* Create list of deliverables */
        ArrayList<Deliverable> deliverables = new ArrayList<>();
        DefaultListModel listModel = ((DefaultListModel) cocktailDelivrablesList.getModel());
        for (int i = 0; i < listModel.getSize(); i++) {
            deliverables.add((Deliverable) listModel.get(i));
        }
        entity.setDeliverables(deliverables);

        String dialogTitle;
        String dialogContent;

        /* If we are creating a new cocktail */
        if (cocktailID == null) {
            // Add new one to database
            entity = TchinTchinAdminFrame.adminFacade.addCocktail(entity);
            // Update the table display
            addCocktailToTable(entity);

            dialogTitle = "Création d'un cocktail";
            dialogContent = "Le cocktail a été créé avec succès !";
        } /* We are updating an already present one */ else {
            entity.setID(cocktailID);

            // Update it in database
            TchinTchinAdminFrame.adminFacade.updateCocktail(entity);
            // Update in table
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            int rowToUpdate = jTable1.getSelectedRow();
            tableModel.setValueAt(entity.getName(), rowToUpdate, 1);
            tableModel.setValueAt(entity.getPrice(), rowToUpdate, 2);
            tableModel.setValueAt(entity.getPhotoURI(), rowToUpdate, 3);
            tableModel.setValueAt(entity.getFlavor().toString(), rowToUpdate, 4);
            tableModel.setValueAt(entity.getPower().toString(), rowToUpdate, 5);

            dialogTitle = "Modification d'un cocktail";
            dialogContent = "Le cocktail a été modifiée avec succès !";
        }
        JOptionPane.showMessageDialog(this, dialogContent, dialogTitle, JOptionPane.INFORMATION_MESSAGE);
        this.cancelButtonActionPerformed(evt);
    }//GEN-LAST:event_validateButtonActionPerformed

    private void removeDeliverableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDeliverableButtonActionPerformed
        DefaultListModel availibleListModel = (DefaultListModel) availableDelivrablesList.getModel();
        DefaultListModel listModel = (DefaultListModel) cocktailDelivrablesList.getModel();

        Deliverable deliverable = (Deliverable) cocktailDelivrablesList.getSelectedValue();
        availibleListModel.addElement(deliverable);
        listModel.removeElement(deliverable);
    }//GEN-LAST:event_removeDeliverableButtonActionPerformed

    private void cocktailNameFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_cocktailNameFieldCaretUpdate
        String photo;
        /* Remove spaces */
        photo = cocktailNameField.getText().replace(' ', '_');
        /* Remove accents */
        photo = Normalizer.normalize(photo, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        cocktailPhotoField.setText(photo + ".png");
    }//GEN-LAST:event_cocktailNameFieldCaretUpdate

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        /* Display existing Cocktails */
        Vector<CocktailEntity> cocktails;
        cocktails = (Vector<CocktailEntity>) TchinTchinAdminFrame.adminFacade.getAllCocktails();
        for (int i = 0; i < cocktails.size(); i++) {
            addCocktailToTable(cocktails.get(i));
        }

        DefaultListModel<Object> listModel;
        listModel = (DefaultListModel<Object>) availableDelivrablesList.getModel();
        /* Display available Deliverable */
        /**
         * TODO : Separate the two lists
         */
        ArrayList<BeverageEntity> beverages;
        beverages = (ArrayList<BeverageEntity>) TchinTchinAdminFrame.adminFacade.getAllBeverages();
        for (int i = 0; i < beverages.size(); i++) {
            listModel.addElement(beverages.get(i));
        }
        ArrayList<DecorationEntity> decos;
        decos = (ArrayList<DecorationEntity>) TchinTchinAdminFrame.adminFacade.getAllDecorations();
        for (int i = 0; i < decos.size(); i++) {
            listModel.addElement(decos.get(i));
        }
    }//GEN-LAST:event_formComponentShown
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDeliverableButton;
    private javax.swing.JList availableDelivrablesList;
    private javax.swing.JButton cancelButton;
    private javax.swing.JList cocktailDelivrablesList;
    private javax.swing.JComboBox cocktailFlavorCombo;
    private javax.swing.JTextField cocktailNameField;
    private javax.swing.JTextField cocktailPhotoField;
    private javax.swing.JComboBox cocktailPowerCombo;
    private javax.swing.JTextArea cocktailRecipeText;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton removeDeliverableButton;
    private javax.swing.JButton validateButton;
    // End of variables declaration//GEN-END:variables
    private Long cocktailID;

    private void addCocktailToTable(CocktailEntity entity) {
        DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
        Object[] row = {entity.getID(),
            entity.getName(),
            entity.getPrice(),
            entity.getPhotoURI(),
            entity.getFlavor().toString(),
            entity.getPower().toString()};
        tableModel.addRow(row);
        int rowIdx = tableModel.getRowCount() - 1;
        tableModel.fireTableRowsInserted(rowIdx, rowIdx);
    }

    private void jTable2SelectionChanged() {
        int i = jTable1.getSelectedRow();
        if (i >= 0) {
            TableModel model = jTable1.getModel();
            cocktailID = (Long) model.getValueAt(i, 0);

            CocktailEntity entity = TchinTchinAdminFrame.adminFacade.getCocktailFull(cocktailID);
            cocktailNameField.setText(entity.getName());
            cocktailPhotoField.setText(entity.getPhotoURI());
            cocktailFlavorCombo.setSelectedItem(entity.getFlavor());
            cocktailPowerCombo.setSelectedItem(entity.getPower());
            // Display list of deliverables
            DefaultListModel availibleListModel = (DefaultListModel) availableDelivrablesList.getModel();
            DefaultListModel listModel = (DefaultListModel) cocktailDelivrablesList.getModel();
            ArrayList<Deliverable> deliverables = (ArrayList<Deliverable>) entity.getDeliverables();
            for (i = 0; i < deliverables.size(); i++) {
                int index = availibleListModel.indexOf(deliverables.get(i));
                if (index == -1) {
                    throw new RuntimeException("Cocktail with non-existent deliverable");
                } else {
                    listModel.addElement(availibleListModel.remove(index));
                }
            }
        }
    }
}