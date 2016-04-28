package abd.p1.controller;

import abd.p1.bd.UserDAO;
import abd.p1.model.Usuario;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class LogInController {

    private UserDAO dbUser;

    public LogInController() {
        this.dbUser = new UserDAO();
    }

    public Usuario logIn(String user, String pass){
        return dbUser.compareUser(user,pass);
    }
}
