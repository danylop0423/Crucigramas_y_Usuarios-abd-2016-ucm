package es.ucm.abd.practica2.dao;

import es.ucm.abd.practica2.model.Abedemon;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Element;
import javax.xml.namespace.QName;
import javax.xml.xquery.*;

/**
 * Implementación concreta del DAO que hace llamadas a eXist.
 *
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public class AbedemonDAOImpl implements AbedemonDAO {

    private final XQDataSource ds;

    public AbedemonDAOImpl(XQDataSource ds) {
        this.ds = ds;
    }


    /**
     * Obtiene los tipos de especies disponibles en la BD.
     *
     * @return Lista de tipos de especies (sin duplicados)
     */
    @Override
    public List<String> getTypes() throws XQException {
        InputStream is = getClass().getResourceAsStream("Abedemon1.xquery");

        XQConnection con = ds.getConnection();
        XQPreparedExpression exp = con.prepareExpression(is);
        XQResultSequence rs = exp.executeQuery();

        ArrayList<String> types = new ArrayList<>();

        while (rs.next()) {
            types.add(rs.getItemAsString(null));
        }

        return types;
    }

    /**
     * Obtiene las especies de abedemon de un determinado.
     *
     * @param type Tipo a buscar
     * @return Especies encontradas del tipo pasado como parámetro.
     */
    @Override
    public List<Abedemon> getAbedemonsOf(String type) throws XQException {
        InputStream is = getClass().getResourceAsStream("Abedemon2.xquery");

        XQConnection con = ds.getConnection();
        XQPreparedExpression exp = con.prepareExpression(is);

        exp.bindString(new QName("tipo"), type, null);

        XQResultSequence rs = exp.executeQuery();

        ArrayList<Abedemon> abedemons = new ArrayList<>();

        while (rs.next()) {
            Element elem = (Element) rs.getObject();
            abedemons.add(new Abedemon(
                    elem.getAttribute("id"),
                    elem.getAttribute("nombre"),
                    Integer.parseInt(elem.getAttribute("num-ataques"))
            ));
        }

        return abedemons;
    }

    /**
     * Obtiene la descripción de una especie de abedemon.
     *
     * @param id ID de la especie a describir
     * @return Código XHTML con la descripción de la especie
     */
    @Override
    public String getAbedemonDescription(String id) throws XQException {
        InputStream is = getClass().getResourceAsStream("Abedemon3.xquery");

        XQConnection con = ds.getConnection();
        XQPreparedExpression exp = con.prepareExpression(is);

        exp.bindString(new QName("id"), id, null);

        XQResultSequence rs = exp.executeQuery();

        rs.next();

        return rs.getItemAsString(null);
    }

    /**
     * Obtiene el daño máximo recibido por un abedemon de una especie dada al
     * ser atacado por otro.
     *
     * @param idAttacker ID de la especie del atacante.
     * @param idReceiver ID de la especie que recibe el daño.
     * @return Máximo daño que puede infligir el atacante.
     */
    @Override
    public Integer getDamage(String idAttacker, String idReceiver) {
        // TODO: Implementar (parte opcional)
        System.err.println("getDamage() not implemented yet");
        return null;
    }
}
