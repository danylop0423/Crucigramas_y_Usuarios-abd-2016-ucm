package abd.p1.controller;

import abd.p1.bd.UserDAO;
import abd.p1.model.Usuario;
import java.sql.Timestamp;
import java.util.List;
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
    private UserDAO dbUser;

    public UsersController(DefaultListModel<Usuario> usersModel, Usuario loggedUser) {
        this.loggedUser = loggedUser;
        this.usersModel = usersModel;
        this.dbUser = new UserDAO();
    }

    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public void gatherAllUsers() {
        usersModel.removeAllElements();

        for(Usuario user : dbUser.findAll()) {
           usersModel.addElement(user);
        }
    }

    public void gatherNearestUsers() {
        usersModel.removeAllElements();

        for (Usuario user : dbUser.findNearest(loggedUser.getLatitud(), loggedUser.getLongitud())) {
            usersModel.addElement(user);
        }
    }

    public void filterByName(String name) {
        usersModel.removeAllElements();

        for(Usuario user : dbUser.findByName(name)) {
            usersModel.addElement(user);
        }
    }

    public void filterNearestUsersByName(String name) {
        usersModel.removeAllElements();

        for (Usuario user : dbUser.findNearestByName(name, loggedUser.getLatitud(), loggedUser.getLongitud())) {
            usersModel.addElement(user);
        }
    }
}
