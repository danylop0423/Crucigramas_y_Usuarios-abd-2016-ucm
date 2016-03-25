package p1admin.adminDB;

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
	protected abstract T buildObjectFromArray(Object[]  a );
	

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
	 * Devuelve el entero autogenerado como clave y organiza los
	 *  arrays correspondiente
	 */
	protected abstract Integer getAutoIncrement();

	/**
	 * Inserta una fila en la BD a partir de el objeto T con el que tiene correspondecia
	 * @param obj
	 * @return
	 */
	public boolean InsertRow(T obj){
		 String tableName=this.getTableName();
		 String[] fields=this.getColumnNames();
		 Object[] values=this.decomposeObject(obj);
		  boolean res= da.insertRow(tableName,fields,values);
		  if(res){
		    Integer auto=this.getAutoIncrement();
		     if(auto != null){
			    this.setKey(obj, auto);  
		       }
		    return res;
		   }else
			  return res;	 
	  }
	
	/**
	 * Actualiza una fila de la BD con los valores del objeto T con el que tiene 
	 * Correspondencia y usando su clave K para encontrar dicha fila
	 * @param obj
	 * @param key
	 * @return
	 */
	 public int UpdateRow(T obj,K key){
		 Object[] keyDec =this.decomposeKey(key);
		 String[] keyCols= this.getKeyColumnNames();
		 
		 QueryCondition[] conditions = new QueryCondition[keyCols.length];
		 for(int i=0; i<conditions.length;i++)
		 {
			 conditions[i]=new QueryCondition(keyCols[i],QueryOperator.EQ,keyDec[i]);
		 }
		 String[] fields=this.getColumnNames();
		 Object[] values=this.decomposeObject(obj);
		 return da.updateRow(this.getTableName(), fields, values, conditions);	 
	 }

     
	 /**
	  * Borra una fila de la BD con  clave K , de un objeto T correspondiente que para 
	  * este caso no hace falta explícitamente
	  * @param key
	  * @return
	  */
	 public int  DeleteRow(K key){
		 Object[] keyDec =this.decomposeKey(key);
		 String[] keyCols= this.getKeyColumnNames();
		 
		 QueryCondition[] conditions = new QueryCondition[keyCols.length];
		 for(int i=0; i<conditions.length;i++)
		 {
			 conditions[i]=new QueryCondition(keyCols[i],QueryOperator.EQ,keyDec[i]);
		 }
		 
		 return da.deleteRow(this.getTableName(), conditions);	 
    	 
      }

}
