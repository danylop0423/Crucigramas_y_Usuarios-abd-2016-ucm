/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.p1.bd;

/**
 *
 * @author dany
*/
import abd.p1.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.List;


public class UserDAO {
    private SessionFactory factory;

    public UserDAO(){
        factory= buildSessionFactory();
     }

    public Usuario findById(String email) {
        Usuario u = new Usuario();

        Session s = factory.openSession();
        Transaction tr = s.beginTransaction();
        Usuario resultado = (Usuario) s.get(Usuario.class, email);
        tr.commit();
        s.close();

        return resultado;
    }

    public List<Usuario> findAll() {
        Session s = factory.openSession();
        Transaction tr = s.beginTransaction();
        List<Usuario> userList = s.createQuery("from " + Usuario.class.getName()).list();
        tr.commit();
        s.close();

        return userList;
    }

    public void saveOrUpdate(Usuario user) {
        Session s = factory.openSession();
        Transaction tr = s.beginTransaction();
        s.saveOrUpdate(user);
        tr.commit();
        s.close();
    }

//-----------------------------------------------
	private static SessionFactory buildSessionFactory() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			return new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(registry);
			return null;
		}
	}
//**************************************************

}
