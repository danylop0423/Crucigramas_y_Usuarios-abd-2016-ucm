package abd.p1;

import abd.p1.controller.LogInController;
import abd.p1.controller.UsersController;
import abd.p1.model.Usuario;
import abd.p1.view.LoginWindow;
import abd.p1.view.MainWindow;

import java.sql.Timestamp;
import javax.swing.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Ésta es la clase que arranca la aplicación. La ejecución del método main()
 * no reconstruirá la base de datos. La base de datos se supone ya construida
 * por el método CreateDB.main()
 *
 */
public class Main {

    private static SessionFactory buildSessionFactory() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
            return null;
        }
    }


    public static void main(String[] args) {

        SessionFactory sf = null;

        try {
            // sf = buildSessionFactory();

            LogInController controller = new LogInController();
            LoginWindow loginW = new LoginWindow(controller);
            loginW.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sf != null) sf.close();
        }
    }
}
