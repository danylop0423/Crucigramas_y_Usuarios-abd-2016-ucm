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

    private final DefaultListModel<Usuario> model;
    private Usuario logedUser;

    public UsersController(DefaultListModel<Usuario> model, Usuario logedUser) {
        this.model = model;
        this.logedUser = logedUser;
    }

    public String getUserName() {
        return logedUser.getNombre();
    }

    public String getUserAge() {
        return String.valueOf(logedUser.calculateAge());
    }

    public String getUserGender() {
        return logedUser.getGenero();
    }

    public String getUserPreference() {
        return logedUser.getGenero_buscado();
    }

    public String getUserDescription() {
        return logedUser.getDescripcion();
    }

    public String updateName() {
        String name = JOptionPane.showInputDialog("Introduce nuevo nombre:");
        if (name != null && !name.trim().isEmpty()) {
            logedUser.setNombre(name);
        }

        return name;
    }

    public String updateBirthDate() {
        String date = JOptionPane.showInputDialog("Introduce nueva fecha de nacimiento:");
        if (date != null && !date.trim().isEmpty()) {
            logedUser.setFecha_nac(new Timestamp(Long.parseLong(date)));
        }

        return String.valueOf(logedUser.calculateAge());
    }

    public ImageIcon updateAvatar() {
        String image = JOptionPane.showInputDialog("Selecciona nuevo avatar:");
        if (image != null && !image.trim().isEmpty()) {
            logedUser.setFoto(null);
        }

        return null;
    }

    public String updateGender() {
        String gender = JOptionPane.showInputDialog("Introduce nuevo género:");
        if (gender != null && !gender.trim().isEmpty()) {
            logedUser.setGenero(gender);
        }

        return gender;
    }

    public String updatePreference() {
        String preference = JOptionPane.showInputDialog("Introduce nueva preferencia:");
        if (preference != null && !preference.trim().isEmpty()) {
            logedUser.setGenero_buscado(preference);
        }

        return preference;
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
