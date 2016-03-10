package p1admin.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String email;
	private String password;
	private String nombre;
	private String genero;
	private String genero_buscado;
	private Timestamp fecha_nac; 
	private byte[ ] foto;
	private String descripcion;
	private String latitud;
	private String longitud;
	private List<Mensaje> mensajes;
	private List<Usuario> amigos;
	private List<String> aficiones;

	
	public Usuario(String email, String password, String nombre, String genero, String genero_buscado,
			Timestamp fecha_nac, byte[] foto, String descripcion, String latitud, String longitud) {
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.genero = genero;
		this.genero_buscado = genero_buscado;
		this.fecha_nac = fecha_nac;
		this.foto = foto;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.mensajes= new ArrayList<>();
		this.amigos =new ArrayList<>();
		this.aficiones = new ArrayList<>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGenero_buscado() {
		return genero_buscado;
	}

	public void setGenero_buscado(String genero_buscado) {
		this.genero_buscado = genero_buscado;
	}

	public Timestamp getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Timestamp fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	
	
	
	public List<Usuario> getAmigos() {
		return amigos;
	}
	
	public void addAmigo(Usuario u) {
		amigos.add(u);
	}
	
	public void removeAmigo(Usuario u) {
		amigos.remove(u);
	}
	
	public int getNumAmigo() {
		return amigos.size();
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}
	
	public void addMensaje(Mensaje m) {
		mensajes.add(m);
	}
	
	public void removeMensaje(Mensaje m) {
		mensajes.remove(m);
	}
	
	public int getNumMensajes() {
		return mensajes.size();
	}

	public List<String> getAficiones() {
		return aficiones;
	}
	
	public void addAficion(String a) {
		aficiones.add(a);
	}
	
	public void removeAficion(String a) {
		aficiones.remove(a);
	}
	
	public int getNumAficiones() {
		return aficiones.size();
	}

	
}
