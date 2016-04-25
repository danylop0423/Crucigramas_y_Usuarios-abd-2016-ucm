package abd.p1.view.users.profile;

import abd.p1.controller.ProfileController;
import javax.swing.*;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class UserProfilePanel extends javax.swing.JPanel {

    private ProfileController controller;
    private DefaultListModel<String> hobbiesModel;
    private boolean editable;

    /**
     * Creates new form UserPanel
     */
    public UserProfilePanel() {
        initComponents();
    }

    public UserProfilePanel(ProfileController controller, DefaultListModel model) {
        this.controller = controller;
        this.hobbiesModel = model;

        initComponents();

        nameLabel.setText(controller.getUserName());
        ageLabel.setText(controller.getUserAge() + " años");
        genderLabel.setText("Sexo: " + controller.getUserGender());
        preferenceLabel.setText("Busca: " + controller.getUserPreference());
        descriptionTextArea.setText(controller.getUserDescription());
        jList1.setModel(model);
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;

        avatarButton.setVisible(editable);
        birthDateButton.setVisible(editable);
        deleteHobbyButton.setVisible(editable);
        editHobbyButton.setVisible(editable);
        genderButton.setVisible(editable);
        addHobbyButton.setVisible(editable);
        nameButton.setVisible(editable);
        preferenceButton.setVisible(editable);
        descriptionTextArea.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        avatarPanel1 = new abd.p1.view.users.AvatarPanel();
        nameLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        nameButton = new javax.swing.JButton();
        birthDateButton = new javax.swing.JButton();
        avatarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        addHobbyButton = new javax.swing.JButton();
        deleteHobbyButton = new javax.swing.JButton();
        editHobbyButton = new javax.swing.JButton();
        genderLabel = new javax.swing.JLabel();
        preferenceLabel = new javax.swing.JLabel();
        genderButton = new javax.swing.JButton();
        preferenceButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        javax.swing.GroupLayout avatarPanel1Layout = new javax.swing.GroupLayout(avatarPanel1);
        avatarPanel1.setLayout(avatarPanel1Layout);
        avatarPanel1Layout.setHorizontalGroup(
            avatarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        avatarPanel1Layout.setVerticalGroup(
            avatarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        nameLabel.setText("Nombre");

        ageLabel.setText("Edad");

        nameButton.setText("Cambiar nombre");
        nameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButtonActionPerformed(evt);
            }
        });

        birthDateButton.setText("Cambiar fecha de nacimiento");
        birthDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthDateButtonActionPerformed(evt);
            }
        });

        avatarButton.setText("Cambiar avatar");
        avatarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avatarButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Descripción:");

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        jLabel2.setText("Aficiones:");

        addHobbyButton.setText("Añadir afición");
        addHobbyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHobbyButtonActionPerformed(evt);
            }
        });

        deleteHobbyButton.setText("Eliminar seleccionada");
        deleteHobbyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteHobbyButtonActionPerformed(evt);
            }
        });

        editHobbyButton.setText("Editar seleccionada");
        editHobbyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editHobbyButtonActionPerformed(evt);
            }
        });

        genderLabel.setText("Sexo: Masculino");

        preferenceLabel.setText("Busca: Mujeres");

        genderButton.setText("Cambiar sexo");
        genderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderButtonActionPerformed(evt);
            }
        });

        preferenceButton.setText("Cambiar preferencia");
        preferenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preferenceButtonActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Hechizos", "Artes oscuras", "Pócimas", "Brujería", "Ciudar gatitos" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jScrollPane3.setViewportView(jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(avatarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLabel)
                                    .addComponent(ageLabel)))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(birthDateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(avatarButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteHobbyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(editHobbyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addHobbyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(genderLabel)
                        .addGap(304, 304, 304)
                        .addComponent(genderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(preferenceLabel)
                        .addGap(313, 313, 313)
                        .addComponent(preferenceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameButton)
                        .addGap(18, 18, 18)
                        .addComponent(birthDateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ageLabel))
                    .addComponent(avatarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(avatarButton)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addHobbyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteHobbyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editHobbyButton))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderButton)
                    .addComponent(genderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preferenceButton)
                    .addComponent(preferenceLabel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButtonActionPerformed
        nameLabel.setText(controller.updateName());
    }//GEN-LAST:event_nameButtonActionPerformed

    private void avatarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avatarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_avatarButtonActionPerformed

    private void birthDateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ageLabel.setText(controller.updateBirthDate() + " años");
    }

    private void genderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        genderLabel.setText("Sexo: " + controller.updateGender());

    }

    private void preferenceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        preferenceLabel.setText("Busca: " + controller.updatePreference());
    }


    private void addHobbyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        controller.addNewHobby();
    }

    private void deleteHobbyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedItem = jList1.getSelectedValue();

        if (selectedItem != null && selectedItem != "") {
            controller.removeHobby(selectedItem);
        } else {
            // TODO: Show error message!!
        }
    }

    private void editHobbyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedItem = jList1.getSelectedValue();

        if (selectedItem != null && selectedItem != "") {
            controller.updateHobby(selectedItem);
        } else {
            // TODO: Show error message!!
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHobbyButton;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton avatarButton;
    private abd.p1.view.users.AvatarPanel avatarPanel1;
    private javax.swing.JButton birthDateButton;
    private javax.swing.JButton deleteHobbyButton;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JButton editHobbyButton;
    private javax.swing.JButton genderButton;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton nameButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton preferenceButton;
    private javax.swing.JLabel preferenceLabel;
    // End of variables declaration//GEN-END:variables
}
