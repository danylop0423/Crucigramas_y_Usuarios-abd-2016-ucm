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


public class UserDAO {
    private SessionFactory factory;

    public UserDAO(){
        factory= buildSessionFactory();
     }

 public Usuario findUserById(String t1) {
    // TODO Auto-generated method stub
    //hace lo que sea necesario y además:
       Usuario u= new Usuario();

        Session s=factory.openSession();
        Transaction tr=s.beginTransaction();
        Usuario resultado=(Usuario) s.get(Usuario.class,t1);
        tr.commit();
        s.close();

        if (resultado != null){
              return resultado;
             }else
           return null;
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
