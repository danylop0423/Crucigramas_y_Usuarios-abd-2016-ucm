package abd.p1.model;

import java.sql.Timestamp;

public class Msj_solicitud extends Mensaje {
	private String xdefecto;

	public Msj_solicitud(Integer id, Usuario emisor, Usuario receptor, Timestamp fecha, boolean leido) {
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



}
