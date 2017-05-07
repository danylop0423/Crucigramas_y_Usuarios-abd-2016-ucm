package abd.p1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "respuestas")
public class Opcion {
	
	@Id
	@Column(name="numero", length=10)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	//@Column(name="n_pregunta", length=10, nullable= false)
	@ManyToOne
	private Pregunta preguntaMadre;
	
	@Column(name="numeroR", length=10, nullable= false)
	private int numeroOrden;
	
	@Column(name="respuesta" , length=146, nullable= false )
	private String texto;
	
	
	public Opcion() {
		
	}

	public Opcion(Integer i,int num,Pregunta preg,String txt) {
		// TODO Auto-generated constructor stub
		id=i;
		preguntaMadre=preg;
		numeroOrden=num;
		texto=txt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Pregunta getPreguntaMadre() {
		return preguntaMadre;
	}

	public void setPreguntaMadre(Pregunta preguntaMadre) {
		this.preguntaMadre = preguntaMadre;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + numeroOrden + ") " + texto;
	}

//------------------------------------	

}
