package abd.p1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Msj_invitacion extends Mensaje {
	
	@ManyToOne
	private Pregunta pregunta;
	
	public Msj_invitacion() { }
	
	public Msj_invitacion(Integer id, Usuario emisor, Usuario receptor, Date fecha, boolean leido) {
		super(id, emisor, receptor, fecha, leido);
		pregunta=null;
	}

	

	/**
	 * @return the pregunta
	 */
	public Pregunta getPregunta() {
		return pregunta;
	}

	/**
	 * @param pregunta the pregunta to set
	 */
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	
}
