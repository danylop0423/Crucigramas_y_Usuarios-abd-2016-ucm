/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view.questions;

import abd.p1.controller.QuestionsController;
import abd.p1.model.Pregunta;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class QuestionsPanel extends javax.swing.JPanel {

    private final QuestionsController controller;

    /**
     * Creates new form QuestionsPanel
     */
    public QuestionsPanel() {
        initComponents();
        this.controller = null;
    }

    public QuestionsPanel(DefaultListModel<Pregunta> model, QuestionsController controller) {
        initComponents();
        this.controller = controller;
        questionsList.setModel(model);
        questionsList.setCellRenderer(new QuestionCellRenderer());
        controller.gatherAllQuestions();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        answerButton = new javax.swing.JButton();
        randomAnswerButton = new javax.swing.JButton();
        labelFiltro = new javax.swing.JLabel();
        scrollPreguntas = new javax.swing.JScrollPane();
        questionsList = new javax.swing.JList<>();

        answerButton.setMnemonic('A');
        answerButton.setText("Responder");
        answerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerButtonActionPerformed(evt);
            }
        });
        panelBotones.add(answerButton);

        randomAnswerButton.setMnemonic('E');
        randomAnswerButton.setText("Pregunta aleatoria");
        randomAnswerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomAnswerButtonActionPerformed(evt);
            }
        });
        panelBotones.add(randomAnswerButton);

        labelFiltro.setDisplayedMnemonic('F');
        labelFiltro.setText("Mejor valoradas:");

        scrollPreguntas.setViewportView(questionsList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPreguntas)
                    .addComponent(panelBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFiltro)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPreguntas, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void answerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Pregunta question = questionsList.getSelectedValue();
        if (question != null) {
            controller.answerQuestion(this, question);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Ninguna pregunta seleccionada",
                    "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void randomAnswerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton answerButton;
    private javax.swing.JLabel labelFiltro;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JList<Pregunta> questionsList;
    private javax.swing.JButton randomAnswerButton;
    private javax.swing.JScrollPane scrollPreguntas;
    // End of variables declaration//GEN-END:variables
}