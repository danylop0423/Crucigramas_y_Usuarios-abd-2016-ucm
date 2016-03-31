/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.view.users;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import p1admin.model.Usuario;

/**
 *
 * @author labrador
 */
public class UserCellRenderer extends UserRowPanel implements ListCellRenderer<Usuario> {

    @Override
    public Component getListCellRendererComponent(JList<? extends Usuario> list, Usuario value, int index, boolean isSelected, boolean cellHasFocus) {
        //this.setName(value.getNombre());
        //this.setAge(value.calculateAge());
        //this.setOpaque(true);
        
        if (isSelected) {
            this.setBackground(Color.DARK_GRAY);
        } else {
            this.setBackground(Color.WHITE);
        }
        
        return this;
    }
}
