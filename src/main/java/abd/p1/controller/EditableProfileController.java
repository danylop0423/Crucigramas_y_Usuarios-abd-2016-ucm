package abd.p1.controller;

import abd.p1.model.Usuario;
import com.toedter.calendar.JDateChooser;

import java.sql.Timestamp;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class EditableProfileController extends AbstractProfileController {

    public EditableProfileController(DefaultListModel<String> hobbiesModel, Usuario user) {
        super(hobbiesModel, user);
    }

    public String updateName() {
        String name = JOptionPane.showInputDialog("Introduce nuevo nombre:");
        if (name != null && !name.trim().isEmpty()) {
            user.setNombre(name);
        }

        return name;
    }

    public String updateBirthDate() {
        JDateChooser dateChooser = new JDateChooser();
        Object[] params = {"Introduce nueva fecha de nacimiento:\n", dateChooser};
        int configOption = JOptionPane.showConfirmDialog(null, params, "", JOptionPane.OK_CANCEL_OPTION);

        if (configOption == JOptionPane.YES_OPTION) {
            user.setFecha_nac(dateChooser.getDate());
        }

        return String.valueOf(user.calculateAge());
    }

    public ImageIcon updateAvatar() {
        String image = JOptionPane.showInputDialog("Selecciona nuevo avatar:");
        if (image != null && !image.trim().isEmpty()) {
            user.setFoto(null);
        }

        return null;
    }

    public String updateGender() {
        String gender = JOptionPane.showInputDialog("Introduce nuevo género:");
        if (gender != null && !gender.trim().isEmpty()) {
            user.setGenero(gender);
        }

        return gender;
    }

    public String updatePreference() {
        String preference = JOptionPane.showInputDialog("Introduce nueva preferencia:");
        if (preference != null && !preference.trim().isEmpty()) {
            user.setGenero_buscado(preference);
        }

        return preference;
    }

    public void addNewHobby() {
        String newHobby = JOptionPane.showInputDialog("Introduce nueva afición:");
        if (newHobby != null && !newHobby.trim().isEmpty()) {
            user.addAficion(newHobby);
            hobbiesModel.addElement(newHobby);
        }
    }

    public void removeHobby(String hobby) {
        user.removeAficion(hobby);
        hobbiesModel.removeElement(hobby);
    }

    public void updateHobby(String hobby) {
        String newHobbyValue = JOptionPane.showInputDialog("Introduce nueva afición:");
        if (newHobbyValue != null && !newHobbyValue.trim().isEmpty()) {
            user.updateAficion(hobby, newHobbyValue);
            hobbiesModel.set(hobbiesModel.indexOf(hobby), newHobbyValue);
        }
    }

    public void saveChanges() {
        db.saveOrUpdate(user);
    }

    public void updatePassword(String pass) {
        user.setPassword(pass);
    }

    public String calculateDistance() {
        return null;
    }
}
