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
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class UserDAO {
    public boolean compareUser(String t1, String t2) {
		// TODO Auto-generated method stub
		//hace lo que sea necesario y además:
		
                           boolean flag =false;
                           Usuario u= new Usuario();
		
		SessionFactory factory= buildSessionFactory();
		Session s=factory.openSession();
		
		
		Query query = s.createQuery("SELECT a.email, a.password " + "FROM Usuario AS a");
		List<Object[]> resultados = query.list();
		for(Object[] p : resultados) {
		  u.setEmail((String) p[0]);
		  u.setPassword((String) p[1]);
		}
		 s.close();
		if ((t1.equals(u.getEmail())) && (t2.equals(u.getPassword()))) flag=true; 
		return flag;
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
