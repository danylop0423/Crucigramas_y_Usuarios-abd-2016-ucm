package p1admin.adminDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
		return new Pregunta(rs.getInt("preguntas.numero"),rs.getString("pregunta"),
																			new ArrayList<>());
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


//-----------	Métodos Adhoc ---------------------
	
/**
  Compone preguntas con sus opciones a partir de un resutSet generado por la consulta 
  pasada como parametro
 */
	
	public List<Pregunta> ComposeQuestions(String sql,OpcionMapper om){
		List<Pregunta> questions=new ArrayList<Pregunta>();    
		try (Connection con = ds.getConnection();
	   			 PreparedStatement st = con.prepareStatement(sql)) {
	   			   					
	   			   try (ResultSet rs = st.executeQuery()) {
	   				   int last=0;
	   				   Pregunta pregunta=null;
	   				   while (rs.next()) {
	   					    if(rs.getInt("preguntas.numero") != last ){ 
	   						   if(pregunta!=null) questions.add(pregunta); 
	   					       pregunta=this.buildObjectFromResultSet(rs); 
	   					      }  
	   					    if(rs.getInt("preguntas.numero") == rs.getInt("n_pregunta") ){ 
	   					      Opcion opcion=om.buildObjectFromResultSet(rs);
	   					      pregunta.addOpcion(opcion);  
	   					     }
	   					    last=rs.getInt("preguntas.numero");	 
	   				      }
	   				      if(pregunta!=null) questions.add(pregunta); 
	   			     }
	   			     return questions;
	   		    } catch (SQLException e) {
	   			    e.printStackTrace();   		
	   		        return null;
	   		       }  
	 }
	
/**
 * 	
 * Devuelve todas las Preguntas de la BD
 */
	public List<Pregunta> getQuestions() {	
		OpcionMapper om=new OpcionMapper(ds);
		String sql="SELECT * FROM " + this.getTableName()+" LEFT JOIN "+
		         om.getTableName() +" ON (" + this.getTableName()+
		         ".numero="+om.getTableName()+".n_pregunta)";
        return this.ComposeQuestions(sql, om);
	}		

	
/**
 * Devuelve todas las preguntas que contienen como substring el texto pasado
 * como parámetro
 */
	public List<Pregunta> getQuestionsFiltered(String text) {	
		OpcionMapper om=new OpcionMapper(ds);
		char comillas= '"';
		String aux = comillas +"%"+text+"%"+comillas;
		String sql="SELECT * FROM " + this.getTableName()+" LEFT JOIN "+
		         om.getTableName() +" ON (" + this.getTableName()+
		         ".numero="+om.getTableName()+".n_pregunta) " +
		         " WHERE pregunta LIKE " + aux;
        return this.ComposeQuestions(sql, om);
	}		

}

