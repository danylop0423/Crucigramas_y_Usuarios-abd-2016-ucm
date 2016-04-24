package abd.p1.model;

import java.io.Serializable;

public class RespondidasClave implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Opcion respondida;
	
	public RespondidasClave() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean equals(RespondidasClave res){
		return this.usuario.equals(res.usuario) && this.respondida.equals(res.respondida);	
		 }

	public int hashCode(){
		return super.hashCode();
	}
}
