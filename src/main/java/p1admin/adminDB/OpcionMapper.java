package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
		return new String[] {"id", "numero", "n_pregunta", "respuesta"};
	}

	@Override
	protected String[] getKeyColumnNames() {
		return new String[] {"id"};
	}

	@Override
	protected Opcion buildObjectFromResultSet(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return new Opcion(rs.getInt("id"),rs.getInt("respuestas.numero"),null,
				          rs.getString("respuesta"));
	}

	@Override
	protected Object[] decomposeKey(Integer key) {
		// TODO Auto-generated method stub
		return new Object[]{key};
	}

	@Override
	protected Opcion buildObjectFromArray(Object[] a) {
		// TODO Auto-generated method stub
		return new Opcion((Integer)a[0], (int)a[1], (Pregunta)a[2], (String)a[3]);
	}

	@Override
	protected Object[] decomposeObject(Opcion o) {
		// TODO Auto-generated method stub
		return new Object[]{o.getId(),o.getNumeroOrden(),o.getPreguntaMadre().getId(),
									o.getTexto()};
	}

	@Override
	protected Integer getKey(Opcion o) {
		// TODO Auto-generated method stub
		return o.getId();
	}

	@Override
	protected void setKey(Opcion o, Integer auto) {
		// TODO Auto-generated method stub
		o.setId(auto);
	}

	@Override
	protected Integer getAutoIncrement() {
		try(Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(
						        "SELECT MAX(id) AS id FROM respuestas "))
		{
		 ResultSet rs = pst.executeQuery();
		 if(rs.next())
		 return rs.getInt("id");
		 else return  null;
		   }catch (SQLException e) {
			 e.printStackTrace();
		     return null;
		    }

	 }

}