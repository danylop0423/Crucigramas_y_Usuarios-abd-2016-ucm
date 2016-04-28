package abd.p1.controller;

import abd.p1.bd.UserDAO;
import abd.p1.model.Usuario;

import javax.swing.*;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public abstract class AbstractProfileController {

    protected DefaultListModel<String> hobbiesModel;
    protected Usuario user;
    protected UserDAO db;

    public AbstractProfileController(DefaultListModel<String> hobbiesModel, Usuario user) {
        this.user = user;
        this.hobbiesModel = hobbiesModel;
        this.db = new UserDAO();
        this.buildLoggedUserHobbiesModel();
    }

    public String getUserName() {
        return user.getNombre();
    }

    public String getUserAge() {
        return String.valueOf(user.calculateAge());
    }

    public String getUserGender() {
        return user.getGenero();
    }

    public String getUserPreference() {
        return user.getGenero_buscado();
    }

    public String getUserDescription() {
        return user.getDescripcion();
    }

    public void buildLoggedUserHobbiesModel() {
        for (String hobby : user.getAficiones()) {
            hobbiesModel.addElement(hobby);
        }
    }

    abstract public String updateName();

    abstract public String updateBirthDate();

    abstract public ImageIcon updateAvatar();

    abstract public String updateGender();

    abstract public String updatePreference();

    abstract public void addNewHobby();

    abstract public void removeHobby(String hobby);

    abstract public void updateHobby(String hobby);

    abstract public void updatePassword(String pass);

    public abstract String calculateDistance();
}
