/**
 * 
 */
package p1admin.adminDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import p1admin.model.Opcion;
import p1admin.model.Pregunta;

public class OpcionMapper extends AbstractMapper<Opcion, Integer> {
	
	public OpcionMapper(DataSource ds) {
		super(ds);
	}

	@Override
	protected String getTableName() {
		return "respuestas";
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"numero", "n_pregunta", "respuesta"};
	}

	@Override
	protected String[] getKeyColumnNames() {
		return new String[] {"id"};
	}

	@Override
	protected Opcion buildObjectFromResultSet(ResultSet rs) throws SQLException {
		return new Opcion(rs.getInt("id"), null, rs.getInt("numero"), rs.getString("respuesta"));
	}

	@Override
	protected Object[] decomposeKey(Integer key) {
		return new Object[] { key };
	}

	@Override
	protected Opcion buildObjectFromArray(Object[] a) {
		return new Opcion((Integer) a[0], (Pregunta) a[1], (Integer) a[2], (String) a[3]);
	}

	@Override
	protected Object[] decomposeObject(Opcion o) {
		return new Object[] { o.getId(), o.getPreguntaMadre(), o.getNumeroOrden(), o.getTexto() };
	}

	@Override
	protected Integer getKey(Opcion o) {
		return o.getId();
	}

	@Override
	protected void setKey(Opcion o, Integer auto) {
		o.setId(auto);
	}
}
