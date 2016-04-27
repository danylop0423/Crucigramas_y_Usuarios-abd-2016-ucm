package abd.p1.controller;

import abd.p1.model.Usuario;
import java.sql.Timestamp;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class UsersController {

    private final DefaultListModel<Usuario> usersModel;
    private Usuario loggedUser;

    public UsersController(DefaultListModel<Usuario> usersModel, Usuario loggedUser) {
        this.loggedUser = loggedUser;
        this.usersModel = usersModel;
    }

    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public void gatherAllUsers() {
        // Debug code, must call dao
        Usuario u1 = new Usuario("", "", "David", "", "", new Timestamp(647418600000L), null, "", new String[]{"Hechizos", "Pócimas", "Deportes extremos"}, "", "");
        Usuario u2 = new Usuario("", "", "Clara", "", "", new Timestamp(716767200000L), null, "", new String[]{"Brujería", "Moda", "Leer"}, "", "");
        Usuario u3 = new Usuario("", "", "Miguel", "", "", new Timestamp(697590000000L), null, "", new String[]{"Cocinar", "Botánica", "Pócimas", "Cuidar gatitos"}, "", "");

        usersModel.addElement(u1);
        usersModel.addElement(u2);
        usersModel.addElement(u3);
    }
}
