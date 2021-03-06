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

import java.util.List;


public class UserDAO {
    private SessionFactory sf;

    public UserDAO(){
        this.sf = HibernateUtils.getSessionFactory();
     }

    public Usuario findById(String email) {
        Session s = sf.openSession();
        Transaction tr = s.beginTransaction();
        Usuario resultado = (Usuario) s.get(Usuario.class, email);
        tr.commit();
        s.close();

        return resultado;
    }

    public List<Usuario> findByName(String name) {
        Session s = sf.openSession();
        Transaction tr = s.beginTransaction();

        List<Usuario> userList =
                s.createQuery("from " + Usuario.class.getName() + " as user where user.nombre like :name")
                    .setString("name", '%' + name + '%')
                    .list();

        tr.commit();
        s.close();

        return userList;
    }

    public List<Usuario> findAll() {
        Session s = sf.openSession();
        Transaction tr = s.beginTransaction();
        List<Usuario> userList = s.createQuery("from " + Usuario.class.getName()).list();
        tr.commit();
        s.close();

        return userList;
    }

    public List<Usuario> findNearest(Double lat, Double lng) {
        Session s = sf.openSession();
        Transaction tr = s.beginTransaction();
        List<Usuario> userList =
                s.createQuery(
                        "from " + Usuario.class.getName() + " as user" +
                        " order by (user.latitud - :lat) * (user.latitud - :lat) + (user.longitud - :lng) * (user.longitud - :lng)"
                ).setDouble("lat", lat)
                .setDouble("lng", lng)
                .setMaxResults(20)
                .list();
        tr.commit();
        s.close();

        return userList;
    }

    public List<Usuario> findNearestByName(String name, Double lat, Double lng) {
        Session s = sf.openSession();
        Transaction tr = s.beginTransaction();
        List<Usuario> userList =
                s.createQuery(
                        "from " + Usuario.class.getName() + " as user" +
                        " where user.nombre like :name" +
                        " order by (user.latitud - :lat) * (user.latitud - :lat) + (user.longitud - :lng) * (user.longitud - :lng)"
                ).setString("name", "%" + name + "%")
                .setDouble("lat", lat)
                .setDouble("lng", lng)
                .setMaxResults(20)
                .list();
        tr.commit();
        s.close();

        return userList;
    }

    public void saveOrUpdate(Usuario user) {
        Session s = sf.openSession();
        Transaction tr = s.beginTransaction();
        s.saveOrUpdate(user);
        tr.commit();
        s.close();
    }
}
