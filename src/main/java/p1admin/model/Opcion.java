package p1admin.model;

public class Opcion {
	private Integer Id;
	private Pregunta preguntaMadre;
	private int numeroOrden;
	private String texto;
	
	public Opcion() {
	}
		
	public Opcion(Integer id, Pregunta preguntaMadre, int numeroOrden, String texto) {
		this.Id = id;
		this.preguntaMadre = preguntaMadre;
		this.numeroOrden = numeroOrden;
		this.texto = texto;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}

	public Pregunta getPreguntaMadre() {
		return preguntaMadre;
	}

	public void setPreguntaMadre(Pregunta preguntaMadre) {
		this.preguntaMadre = preguntaMadre;
	}

	public int getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + numeroOrden + ") " + texto;
	}
}
