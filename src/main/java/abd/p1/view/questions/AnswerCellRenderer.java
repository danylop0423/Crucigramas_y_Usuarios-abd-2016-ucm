/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view.questions;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import abd.p1.model.Opcion;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class AnswerCellRenderer extends JLabel implements ListCellRenderer<Opcion> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Opcion> list, Opcion value, int index, boolean isSelected, boolean cellHasFocus) {
        String text = value.getTexto();
        int order = value.getNumeroOrden();

        this.setText(order + ". " + text);

        if (isSelected) {
                this.setBackground(Color.DARK_GRAY);
        } else {
                this.setBackground(Color.WHITE);
        }

        return this;
    }

}
