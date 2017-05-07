package abd.p1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@IdClass(RespondidasClave.class)
@Entity
public class Respondidas {
	  
	@ManyToOne
	@Id
	private Usuario usuario;
	
	@Column(name="relevancia", length=2, nullable= false)
	private Integer relevancia;
	
	@Id
	@ManyToOne
	private Opcion respondida;
	
	public Respondidas() {
		}
	
	public Respondidas(Usuario usuario, Integer relevancia, Opcion resp) {
		this.usuario = usuario;
		this.relevancia = relevancia;
		this.setRespondida(resp);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getRelevancia() {
		return relevancia;
	}

	public void setRelevancia(Integer relevancia) {
		this.relevancia = relevancia;
	}

	public Opcion getRespondida() {
		return respondida;
	}

	public void setRespondida(Opcion respondida) {
		this.respondida = respondida;
	}

		
}
