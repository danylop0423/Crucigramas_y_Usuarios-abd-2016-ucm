/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view.users;

import abd.p1.model.Usuario;
import java.awt.Color;
import java.awt.Component;
import javax.swing.*;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class UserCellRenderer extends UserRowPanel implements ListCellRenderer<Usuario> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Usuario> list, Usuario value, int index, boolean isSelected, boolean cellHasFocus) {
        this.setName(value.getNombre());
        this.setAge(value.calculateAge());
        this.setIcon(new ImageIcon(value.getFoto()));
        this.setOpaque(true);

        if (isSelected) {
            this.setBackground(Color.LIGHT_GRAY);
        } else {
            this.setBackground(Color.WHITE);
        }

        return this;
    }
}
