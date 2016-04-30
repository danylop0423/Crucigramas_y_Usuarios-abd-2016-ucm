package abd.p1;

import abd.p1.controller.LogInController;
import abd.p1.bd.HibernateUtils;
import abd.p1.view.LoginWindow;

/**
 * Ésta es la clase que arranca la aplicación. La ejecución del método main()
 * no reconstruirá la base de datos. La base de datos se supone ya construida
 * por el método CreateDB.main()
 *
 */
public class Main {

    public static void main(String[] args) {

        try {
            LogInController controller = new LogInController();
            LoginWindow loginW = new LoginWindow(controller);
            loginW.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
            HibernateUtils.getSessionFactory().close();
        }
    }
}
