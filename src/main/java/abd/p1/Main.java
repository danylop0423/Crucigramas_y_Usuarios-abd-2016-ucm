package abd.p1;

import abd.p1.controller.UsersController;
import abd.p1.model.Usuario;
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

            // Mostrar ventana de login y comprobar validez del usuario y contraseña.
            // Si son validos, mostrar ventana principal.
            //LoginWindow loginW = new LoginWindow(new JFrame(), false);
            //loginW.setVisible(true);

            Usuario logedUser = new Usuario(
                    "",
                    "",
                    "Labrador",
                    "Masculino",
                    "Mujeres",
                    new Timestamp(647418600000L),
                    null,
                    "Soy malote a más no poder.\nBusco gente similar para hacer maldades.",
                    new String[]{"Hechizos", "Artes oscuras", "Pócimas", "Brujeria", "Cuidar gatitos"},
                    "",
                    ""
            );

            DefaultListModel<Usuario> model = new DefaultListModel<>();
            UsersController controller = new UsersController(model, logedUser);

            MainWindow mainW = new MainWindow(controller, model);
            mainW.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sf != null) sf.close();
        }
    }

}
