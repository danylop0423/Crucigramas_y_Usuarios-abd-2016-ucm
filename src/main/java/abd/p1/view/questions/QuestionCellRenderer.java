/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view.questions;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import abd.p1.model.Pregunta;

/**
 *
 * @author labrador
 */
public class QuestionCellRenderer extends QuestionRowPanel implements ListCellRenderer<Pregunta> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Pregunta> list, Pregunta value, int index, boolean isSelected, boolean cellHasFocus) {
        this.setElement(value);

        if (isSelected) {
            this.setBackground(Color.DARK_GRAY);
        } else {
            this.setBackground(Color.WHITE);
        }

        return this;
    }
}
