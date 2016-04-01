package abd.p1.model;

import java.util.ArrayList;
import java.util.List;

public class Respondidas {
	private Usuario usuario;
	private Integer relevancia;
	private List<Opcion> respondidas;

	public Respondidas(Usuario usuario, Integer relevancia) {
		this.usuario = usuario;
		this.relevancia = relevancia;
		this.respondidas = new ArrayList<>();
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

	public List<Opcion> getRespondidas() {
		return respondidas;
	}

	public void addRespondida(Opcion o) {
		respondidas.add(o);
	}

	public void removeRespondida(Opcion o) {
		respondidas.remove(o);
	}

	public int getNumRespondidas() {
		return respondidas.size();
	}

}
