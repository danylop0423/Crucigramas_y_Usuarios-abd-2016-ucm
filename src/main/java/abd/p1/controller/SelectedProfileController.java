package abd.p1.controller;

import abd.p1.Tools;
import abd.p1.model.Usuario;

import javax.swing.*;
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

    public String calculateDistance() {
        Double distance = Tools.calculateDistnaceBetweenPoints(
                loggedUser.getLatitud(),
                loggedUser.getLongitud(),
                user.getLatitud(),
                user.getLongitud()
        );

        Long rDistance = Math.round(distance);
        String mDistance = String.valueOf(rDistance);
        String kmDistance = String.valueOf(rDistance / 1000);

        return rDistance > 1000 ? kmDistance + "km" : mDistance + "m";
    }
}
