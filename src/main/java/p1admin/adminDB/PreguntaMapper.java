package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		// TODO Auto-generated method stub
		return "preguntas";
	}

	@Override
	protected String[] getColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "numero", "pregunta"} ;
	}

	@Override
	protected String[] getKeyColumnNames() {
		// TODO Auto-generated method stub
		return new String[] { "numero"} ;
	}

	@Override
	protected Pregunta buildObjectFromResultSet(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return new Pregunta(rs.getInt("numero"),rs.getString("pregunta"),null);
	}

	@Override
	protected Object[] decomposeKey(Integer key) {
		// TODO Auto-generated method stub
		return new Object[] {key};
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Pregunta buildObjectFromArray(Object[] a) {
		// TODO Auto-generated method stub
		return new Pregunta((Integer)a[0],(String)a[1],(List<Opcion>)a[2]);
	}

	@Override
	protected Object[] decomposeObject(Pregunta o) {
		// TODO Auto-generated method stub
		return new Object[]{o.getId(),o.getEnunciado()};
	}

	@Override
	protected Integer getKey(Pregunta o) {
		// TODO Auto-generated method stub
		return o.getId();
	}

	@Override
	protected void setKey(Pregunta o, Integer auto) {
		o.setId(auto);
	}

	@Override
	protected Integer getAutoIncrement() {
		try(Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(
						        "SELECT MAX(numero) AS numero FROM preguntas "))
		{
		 ResultSet rs = pst.executeQuery();
		 if(rs.next())
		 return rs.getInt("numero");
		 else return  null;
		   }catch (SQLException e) {
			 e.printStackTrace();
		     return null;
		    }
	}
}
