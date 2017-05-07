package abd.p1.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance (strategy= InheritanceType.JOINED)
public class Mensaje {
	@Id
	@Column(name="id", length=10)
	@GeneratedValue(strategy= GenerationType.IDENTITY)
   private Integer id;
	
	@ManyToOne
   private Usuario emisor;
   
	@ManyToOne
	private Usuario receptor;
   
	@Column(name="fecha" , nullable=true )
	@Temporal(TemporalType.DATE)
	private Date fecha;
   
	@Column(name="leído", nullable=false)
	private boolean leido;

	 public Mensaje(){
		 
	 }
	
   public Mensaje(Integer id, Usuario emisor, Usuario receptor, Date fecha, boolean leido) {
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
public Date getFecha() {
	return fecha;
}

/**
 * @param fecha the fecha to set
 */
public void setFecha(Date fecha) {
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
