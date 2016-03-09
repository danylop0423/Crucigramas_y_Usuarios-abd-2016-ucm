package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import javax.sql.DataSource;


/**
 * Created by labrador on 7/03/16.
 */
public class DataAccessor {
    private DataSource ds;

    public DataAccessor(DataSource dataSource) {
        this.ds = dataSource;
    }

    public boolean insertRow(String tableName, String[] fields, Object[] values) {
        String sql = this.generateInsertStatement(tableName, fields);

        try(Connection con = ds.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
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
    
    public int updateRows(String tableName, String[] fields, String[] value ) {
	  return -1;	
	}

    public String generateInsertStatement(String tableName, String[] fields) {
        String fieldList = String.join(",", fields);
        String[] marks = new String[fields.length];

        Arrays.fill(marks, "?");

        String markList = String.join(",", marks);

        return "INSERT INTO " + tableName
                + " (" + fieldList + ") VALUES ("
                + markList + ")";
    }

    public String generateUpdateStatement(String tableName, String[] fields, String[] condition) {
        String fieldList = String.join("= ?,", fields);
        fieldList += "=?"; //add by dany
        String conditionList = String.join("= ? AND", condition);
        conditionList += "=?";
        return "UPDATE " + tableName
                + " SET " + fieldList
                + " WHERE " + conditionList;
    }

    public String generateDeleteStatement(String tableName, String[] condition) {
        String conditionList = String.join("= ? AND", condition);

        return "DELETE FROM " + tableName
                + " WHERE " + conditionList;
    }
}

