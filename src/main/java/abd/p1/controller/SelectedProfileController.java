package abd.p1.controller;

import abd.p1.model.Usuario;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Labrador <davidlab@ucm.es>
 */
public class SelectedProfileController extends EditableProfileController {

    private Usuario loggedUser;
    private DefaultListModel<String> mutualHobbiesModel;

    public SelectedProfileController(DefaultListModel<String> hobbiesModel, DefaultListModel<String> mutualHobbiesModel, Usuario loggedUser, Usuario selectedUsser) {
        super(hobbiesModel, selectedUsser);
        this.mutualHobbiesModel = mutualHobbiesModel;
        this.loggedUser = loggedUser;
        this.calculateMutualHobbies();
    }

    private void calculateMutualHobbies() {
        List<String> selectedUserHobbies = loggedUser.getAficiones();

        for (String hobby : user.getAficiones()) {
            if (selectedUserHobbies.contains(hobby)) {
                mutualHobbiesModel.addElement(hobby);
            }
        }
    }
}
