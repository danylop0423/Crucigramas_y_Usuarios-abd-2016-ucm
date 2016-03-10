package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

public class DataAccessor {

   private DataSource ds;
 
   public DataAccessor (DataSource dsource){
		this.ds=dsource;
	}

//INSERT:
 private String generateInsertStatement(String tableName, String[] fields) {
	 String fieldList = String.join(",",fields );
	 String[] marks = new String[fields.length];
	 Arrays.fill(marks, "?");
	 String markList = String.join(",",marks );
	 return "INSERT INTO " + tableName
	 + " (" + fieldList + ") VALUES ("
	 + markList + ")";
 }

 public boolean insertRow(String tableName,String[] fields, Object[] values) {
	
	String sql = generateInsertStatement(tableName, fields);
	try(Connection con = ds.getConnection();
			PreparedStatement pst = con.prepareStatement(sql))
    {
		for (int i = 0; i < values.length; i++) {
			pst.setObject(i + 1, values[i]);
		  }
		int numRows = pst.executeUpdate();
		return (numRows == 1);
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
	     }
 }

 
//UPDATE:
 private String generateUpdateStatement(String tableName, String[] fields, 
		 														String[] condFields) {
	 String fieldMarked = String.join("=?,",fields );
	 fieldMarked += "=?";
    
	 if(condFields == null){
			return  "UPDATE " + tableName + " SET (" + fieldMarked + ")";
		 }
	 
	 String condMarked = String.join("=? AND ",condFields );
		condMarked += "=?";
	 	 
	 return "UPDATE " + tableName 
			 + " SET (" + fieldMarked + ") WHERE ("
			 + condMarked + ")";
	}

 
 public int updateRow(String tableName,String[] fields, Object[] values,
		 				String[] condFields,Object[] condValues) {
		
	 	String sql = generateUpdateStatement(tableName,fields,condFields);
		try(Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql))
	    {
			if(condFields != null){
				int aux=0;
				for (int i=0 ; i < values.length; i++) {
					aux=i;
					pst.setObject(i + 1, values[i]);			  
				   }
			
				for ( int j=aux; j < (condValues.length+aux); j++) {
					pst.setObject(j + 1, condValues[j]);
				   }		
		      }
			int numRows = pst.executeUpdate();
			return numRows;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		     }
 }

//DELETE
 private String generateDeleteStatement(String tableName,String[] condFields) {		
	 if(condFields == null){
		return  "DELETE " + tableName;
	 }
 
	 String condMarked = String.join("=? AND ",condFields );
		condMarked += "=?";
	 	 
	 return "DELETE " + tableName 
			 + "  WHERE ("
			 + condMarked + ")";
	}


public int deleteRow(String tableName,String[] condFields,Object[] condValues) {
		
	   String sql = generateDeleteStatement(tableName,condFields);
		try(Connection con = ds.getConnection();
				PreparedStatement pst = con.prepareStatement(sql))
	    {
			if(condValues != null) {
				for (int i=0 ; i < condValues.length; i++) {
					pst.setObject(i + 1, condValues[i]);			  
				 }
			  }
			int numRows = pst.executeUpdate();
			return numRows;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		     }
  }
 
 
 
}

