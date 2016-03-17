package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;


public abstract class AbstractMapper<T, K> {
	protected DataSource ds;
	protected DataAccessor da;
	public AbstractMapper(DataSource ds) {
		this.ds = ds;
		this.da = new DataAccessor(ds);
	}
	
	/**
	 * Devuelve el nombre de la tabla correspondiente al mapper concreto
	 */
	protected abstract String getTableName();

	/**
	 * Devuelve un array con los nombres de las columnas de la tabla
	 */
	protected abstract String[] getColumnNames();

	/**
	 * Devuelve un String con el nombre de las columnas clave de la tabla
	 */
	protected abstract String[] getKeyColumnNames();

	/**
	 * Construye un objeto mapeado a partir del ResultSet pasado como parámetro.
	 * Esta función es la que establece la correspondencia desde el mundo
	 * relacional al mundo orientado a objetos.
	 */
	protected abstract T buildObjectFromResultSet(ResultSet rs) throws SQLException;


	/**
	 * Descompone una clave K en array de objeto
	 */
	protected abstract Object[] decomposeKey(K key);

	
	/**
	 * Contruye un objeto T a partir de un array de objetos
	 */
	protected abstract T buidObjectFromArray(Object[]  a );
	

	/**
	 * obtiene un array de object a partir de un T
	 */
	protected abstract Object[] decomposeObject(T o);

	
	/**
	 * Obtiene las claves K de un objeto T
	 */
	protected abstract K getKey(T o);
	
	
	/**
	 * Cambia el valor de la clave Autogenerada de T
	 */
	protected abstract void setKey(T o,Integer auto);
	
	
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
				+ " WHERE " + this.getKeyColumnNames() + " = ?";
		
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

 public boolean InsertRow(T obj){
	 String tableName=this.getTableName();
	 String[] fields=this.getColumnNames();
	 Object[] values=this.decomposeObject(obj);
	  return da.insertRow(tableName,fields,values);	 
 }
/*
 public int UpdateRow(T obj){
	 String[] columnCondNames = getKeyColumnNames();
	 Object[] condDec = decomposeKey(id);
	 String tableName=this.getTableName();
	 String[] fields=this.getColumnNames();
	 Object[] values=this.decomposeObject(obj);
	 QueryCondition[]
	  return da.updateRow(tableName, fields, values, condFields, condValues);	 
 }
*/

}
