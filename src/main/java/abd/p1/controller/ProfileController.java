package abd.p1.controller;

import abd.p1.model.Usuario;
import org.apache.commons.lang3.NotImplementedException;

import java.sql.Timestamp;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class ProfileController {

    protected DefaultListModel<String> hobbiesModel;
    protected Usuario user;

    public ProfileController(DefaultListModel<String> hobbiesModel, Usuario user) {
        this.user = user;
        this.hobbiesModel = hobbiesModel;
        this.gatherUserHobbies();
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

    public void gatherUserHobbies() {
        for (String hobby : user.getAficiones()) {
            hobbiesModel.addElement(hobby);
        }
    }

    public String updateName() {
        return null;
    }

    public String updateBirthDate() {
        return null;
    }

    public ImageIcon updateAvatar() {
        return null;
    }

    public String updateGender() {
        return null;
    }

    public String updatePreference() {
        return null;
    }

    public void addNewHobby() {
    }

    public void removeHobby(String hobby) {
    }

    public void updateHobby(String hobby) {
    }

}
