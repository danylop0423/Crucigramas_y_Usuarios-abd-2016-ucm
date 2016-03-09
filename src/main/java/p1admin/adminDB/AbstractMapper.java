package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class AbstractMapper<T, K> {
	protected DataSource ds;

	/**
	 * Devuelve el nombre de la tabla correspondiente al mapper concreto
	 */
	protected abstract String getTableName();

	/**
	 * Devuelve un array con los nombres de las columnas de la tabla
	 */
	protected abstract String[] getColumnNames();

	/**
	 * Devuelve un String con el nombre de la columna clave de la tabla
	 */
	protected abstract String getKeyColumnName();

	/**
	 * Construye un objeto mapeado a partir del ResultSet pasado como parámetro.
	 * Esta función es la que establece la correspondencia desde el mundo
	 * relacional al mundo orientado a objetos.
	 */
	protected abstract T buildObjectFromResultSet(ResultSet rs) throws SQLException;

	public AbstractMapper(DataSource ds) {
		this.ds = ds;
	}

	/**
	 * Obtiene un objeto de la BD a partir de su clave.
	 * 
	 * @param id Clave del objeto a buscar
	 * @return El objeto recuperado de la BD, o null si el objeto no se ha encontrado
	 */
	public T findById(K id) {
		String[] columnNames = this.getColumnNames();
		
		String sql = "SELECT " + String.join(", ", columnNames)
				+ " FROM " + this.getTableName()
				+ " WHERE " + this.getKeyColumnName() + " = ?";
		
		System.out.println(sql);
		
		try (Connection con = ds.getConnection(); PreparedStatement st = con.prepareStatement(sql)) {
			st.setObject(1, id);
			
			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					return this.buildObjectFromResultSet(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null;
	}
}
