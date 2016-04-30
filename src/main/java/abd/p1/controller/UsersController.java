package abd.p1.controller;

import abd.p1.bd.UserDAO;
import abd.p1.model.Usuario;

import javax.swing.DefaultListModel;

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

    public void filterByName(String name) {
        usersModel.removeAllElements();

        for(Usuario user : dbUser.findByName(name)) {
            usersModel.addElement(user);
        }
    }
}
