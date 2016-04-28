package abd.p1.controller;

import abd.p1.bd.UserDAO;
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
    private UserDAO dbUser;
    
    public UsersController(DefaultListModel<Usuario> usersModel, Usuario loggedUser) {
        this.loggedUser = loggedUser;
        this.usersModel = usersModel;
        dbUser=new UserDAO();
    }

    public Usuario getLoggedUser() {
        return loggedUser;
    }

    public void gatherAllUsers() {
        // Debug code, must call dao
        Usuario u1 = new Usuario("", "", "David", "", "", new Timestamp(647418600000L), null, "", new String[]{"Hechizos", "Pócimas", "Deportes extremos"}, 40.6366752, -4.0257766);
        Usuario u2 = new Usuario("", "", "Clara", "", "", new Timestamp(716767200000L), null, "", new String[]{"Brujería", "Moda", "Leer"}, 40.4721338, -3.6905272);
        Usuario u3 = new Usuario("", "", "Miguel", "", "", new Timestamp(697590000000L), null, "", new String[]{"Cocinar", "Botánica", "Pócimas", "Cuidar gatitos"}, 40.6344825, -4.0232617);

        usersModel.addElement(u1);
        usersModel.addElement(u2);
        usersModel.addElement(u3);
    }
    
    public boolean compareUsers(String user, String pass){
      Usuario u=dbUser.compareUser(user,pass);  
       if(u != null){
           this.loggedUser=u; 
           return true;
       }
       else 
           return false;
    }
}
