package abd.p1.model;

import java.sql.Timestamp;

public class Mensaje {
   private Integer id;
   private Usuario emisor;
   private Usuario receptor;
   private Timestamp fecha;
   private boolean leido;

   public Mensaje(Integer id, Usuario emisor, Usuario receptor, Timestamp fecha, boolean leido) {
	this.id = id;
	this.emisor = emisor;
	this.receptor = receptor;
	this.fecha = fecha;
	this.leido = leido;
}

/**
 * @return the id
 */
public Integer getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(Integer id) {
	this.id = id;
}

/**
 * @return the emisor
 */
public Usuario getEmisor() {
	return emisor;
}

/**
 * @param emisor the emisor to set
 */
public void setEmisor(Usuario emisor) {
	this.emisor = emisor;
}

/**
 * @return the receptor
 */
public Usuario getReceptor() {
	return receptor;
}

/**
 * @param receptor the receptor to set
 */
public void setReceptor(Usuario receptor) {
	this.receptor = receptor;
}

/**
 * @return the fecha
 */
public Timestamp getFecha() {
	return fecha;
}

/**
 * @param fecha the fecha to set
 */
public void setFecha(Timestamp fecha) {
	this.fecha = fecha;
}

/**
 * @return the leido
 */
public boolean isLeido() {
	return leido;
}

/**
 * @param leido the leido to set
 */
public void setLeido(boolean leido) {
	this.leido = leido;
}



}
