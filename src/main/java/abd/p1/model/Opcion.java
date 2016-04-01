package abd.p1.model;

public class Opcion {
	private Integer id;
	private Pregunta preguntaMadre;
	private int numeroOrden;
	private String texto;

	public Opcion() {
	}

	public Opcion(Integer i,int num,Pregunta preg,String txt) {
		// TODO Auto-generated constructor stub
		id=i;
		preguntaMadre=preg;
		numeroOrden=num;
		texto=txt;
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
