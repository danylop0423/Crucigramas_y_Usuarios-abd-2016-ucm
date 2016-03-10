package p1admin.model;

import java.sql.Timestamp;

public class Msj_texto extends Mensaje {
	/**
	 * @param id
	 * @param emisor
	 * @param receptor
	 * @param fecha
	 * @param leido
	 */
	private String texto;
	public Msj_texto(Integer id, Usuario emisor, Usuario receptor, Timestamp fecha, boolean leido) {
		super(id, emisor, receptor, fecha, leido);
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
