package es.ucm.abd.practica2.dao;

import es.ucm.abd.practica2.model.Abedemon;

import javax.xml.xquery.XQException;
import java.util.List;

/**
 * Acceso a datos del Abedemon
 *
 * @author Manuel Montenegro (mmontene@ucm.es)
 */
public interface AbedemonDAO {
    List<String> getTypes() throws XQException;
    List<Abedemon> getAbedemonsOf(String type) throws XQException;
    String getAbedemonDescription(String id) throws XQException;
    Integer getDamage(String idAttacker, String idReceiver);
}
