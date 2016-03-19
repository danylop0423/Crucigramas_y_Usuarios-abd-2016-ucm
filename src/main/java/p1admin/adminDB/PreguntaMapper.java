package p1admin.adminDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import p1admin.model.Opcion;
import p1admin.model.Pregunta;

public class PreguntaMapper extends AbstractMapper<Pregunta, Integer>{

	public PreguntaMapper(DataSource ds) {
		super(ds);
	}

	@Override
	protected String getTableName() {
		return "preguntas";
	}

	@Override
	protected String[] getColumnNames() {
		return new String[] {"numero", "pregunta"};
	}

	@Override
	protected String[] getKeyColumnNames() {
		return new String[] {"numero"};
	}

	@Override
	protected Pregunta buildObjectFromResultSet(ResultSet rs) throws SQLException {
		return new Pregunta(rs.getInt("numero"), rs.getString("pregunta"), null);
	}

	@Override
	protected Object[] decomposeKey(Integer key) {
		return new Object[] {key};
	}

	@Override
	@SuppressWarnings("unchecked")
	protected Pregunta buildObjectFromArray(Object[] a) {
		return new Pregunta((Integer) a[0], (String) a[1], (List<Opcion>) a[2]);
	}

	@Override
	protected Object[] decomposeObject(Pregunta p) {
		return new Object[] {p.getId(), p.getEnunciado(), p.getOpciones()};
	}

	@Override
	protected Integer getKey(Pregunta o) {
		return o.getId();
	}

	@Override
	protected void setKey(Pregunta o, Integer auto) {
		o.setId(auto);
	}
}
