package abd.p1.controller;

import abd.p1.model.Usuario;
import java.sql.Timestamp;
import javax.swing.DefaultListModel;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class UsersController {

    private final DefaultListModel<Usuario> model;

    public UsersController(DefaultListModel<Usuario> model) {
        this.model = model;
    }

    public void gatherAllUsers() {
        // Debug code, must call dao
        Usuario u1 = new Usuario("", "", "David", "", "", new Timestamp(647418600000L), null, "", "", "");
        Usuario u2 = new Usuario("", "", "Clara", "", "", new Timestamp(716767200000L), null, "", "", "");
        Usuario u3 = new Usuario("", "", "Miguel", "", "", new Timestamp(697590000000L), null, "", "", "");

        model.addElement(u1);
        model.addElement(u2);
        model.addElement(u3);
    }
}
