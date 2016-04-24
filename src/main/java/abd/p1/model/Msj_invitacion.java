package abd.p1.model;

import java.sql.Timestamp;

public class Msj_invitacion extends Mensaje {
	private String xdefecto;
	private Pregunta pregunta;
	
	public Msj_invitacion(Integer id, Usuario emisor, Usuario receptor, Timestamp fecha, boolean leido) {
		super(id, emisor, receptor, fecha, leido);
		
	}

	/**
	 * @return the xdefecto
	 */
	public String getXdefecto() {
		return xdefecto;
	}

	/**
	 * @param xdefecto the xdefecto to set
	 */
	public void setXdefecto(String xdefecto) {
		this.xdefecto = xdefecto;
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
