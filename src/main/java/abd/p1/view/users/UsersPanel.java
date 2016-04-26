/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view.users;

import abd.p1.controller.EditableProfileController;
import abd.p1.controller.ProfileController;
import abd.p1.controller.UsersController;
import abd.p1.model.Usuario;
import abd.p1.view.users.profile.EditableProfileWindow;
import abd.p1.view.users.profile.ProfileWindow;

import javax.swing.*;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class UsersPanel extends javax.swing.JPanel {
    private DefaultListModel<Usuario> userModel;
    private UsersController controller;

    /**
     * Creates new form UsersPanel
     */
    public UsersPanel(UsersController controller, DefaultListModel userModel) {
        this.controller = controller;
        this.userModel = userModel;
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

        searchPanel1 = new abd.p1.view.users.SearchPanel(controller, userModel);
        jPanel1 = new javax.swing.JPanel();
        updateProfileButton = new javax.swing.JButton();
        showProfileButton = new javax.swing.JButton();

        updateProfileButton.setText("Modificar mi perfil");
        updateProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateProfileButtonActionPerformed(evt);
            }
        });

        jPanel1.add(updateProfileButton);

        showProfileButton.setText("Ver perfil seleccionado");
        showProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showProfileButtonActionPerformed(evt);
            }
        });
        jPanel1.add(showProfileButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultListModel<String> model = new DefaultListModel<>();
        EditableProfileController controller = new EditableProfileController(model, this.controller.getLoggedUser());
        EditableProfileWindow editableProfileW = new EditableProfileWindow(controller, model);
        editableProfileW.setVisible(true);
    }

    private void showProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Usuario selectedUser = searchPanel1.getSelectedListItem();

        if(selectedUser != null) {
            DefaultListModel<String> hobbiesModel = new DefaultListModel<>();
            ProfileController profileController = new ProfileController(hobbiesModel, selectedUser);
            ProfileWindow profileW = new ProfileWindow(profileController, hobbiesModel);
            profileW.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Debe seleccionar un usuario de la lista",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton showProfileButton;
    private javax.swing.JButton updateProfileButton;
    private javax.swing.JPanel jPanel1;
    private abd.p1.view.users.SearchPanel searchPanel1;
    // End of variables declaration//GEN-END:variables
}
