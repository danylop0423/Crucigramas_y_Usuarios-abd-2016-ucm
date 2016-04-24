package abd.p1.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Msj_solicitud extends Mensaje {
	
	public Msj_solicitud(){ }
	
	public Msj_solicitud(Integer id, Usuario emisor, Usuario receptor, Date fecha, boolean leido) {
		super(id, emisor, receptor, fecha, leido);
		
	}
	/**
	 * @return the xdefecto
	 */
	
	

}
