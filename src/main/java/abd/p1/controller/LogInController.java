package abd.p1.controller;

import abd.p1.bd.UserDAO;
import abd.p1.model.Usuario;

import javax.swing.*;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class LogInController {

    private UserDAO dbUser;

    public LogInController() {
        this.dbUser = new UserDAO();
    }

    public Usuario logIn(String email, String pass) {
        Usuario loggedUser = dbUser.findById(email);

        if (loggedUser == null) {
            JOptionPane.showMessageDialog(null,
                    "Usuario no registrado",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        } else if (!loggedUser.getPassword().equals(pass)) {
            JOptionPane.showMessageDialog(null,
                    "Contraseña incorrecta",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            return loggedUser;
        }

        return  null;
    }
}
