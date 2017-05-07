package abd.p1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Msj_texto extends Mensaje {
	/**
	 * @param id
	 * @param emisor
	 * @param receptor
	 * @param fecha
	 * @param leido
	 */
	@Column(name="texto", length= 146, nullable=false)
	private String texto;
	
	public Msj_texto(){ }
	
	public Msj_texto(Integer id, Usuario emisor, Usuario receptor, Date fecha, boolean leido, String txt) {
		super(id, emisor, receptor, fecha, leido);
		this.texto=txt;
	}
	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

}
