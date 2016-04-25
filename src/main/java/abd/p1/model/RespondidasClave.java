package abd.p1.model;

import java.io.Serializable;

public class RespondidasClave implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Opcion respondida;
	
	public RespondidasClave() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean equals(Object o){
		if (o == this) return true;
		if(o == null) return false;
		if(!(o instanceof RespondidasClave)) return false;
		return(this.usuario==((RespondidasClave)o).usuario  &&
				this.respondida==((RespondidasClave)o).respondida );
	
		 }

	public int hashCode(){
		return super.hashCode();
	}
}
