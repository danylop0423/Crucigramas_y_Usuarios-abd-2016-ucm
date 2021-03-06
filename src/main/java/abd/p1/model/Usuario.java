package abd.p1.model;



import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "usuarios")
public class Usuario {
	@Id
	@Column(name="email", length=50)
	private String email;

	@Column(name="password" , length=10, nullable= false )
	private String password;

	@Column(name="nombre" , length=50, nullable= false )
	private String nombre;

	@Column(name="genero" , length=20, nullable= false )
	@Enumerated(EnumType.STRING)
	private GeneroEnum genero;
	
	@Column(name="genero_buscado" , length=20, nullable= false )
	@Enumerated(EnumType.STRING)
	private GeneroEnum genero_buscado;

	@Column(name="fecha_nacimiento" , nullable=true )
	@Temporal(TemporalType.DATE)
	private Date fecha_nac;

	@Lob
	private byte[ ] foto;

	@Column(name="descripcion" , length=146, nullable= false )
	private String descripcion;

	@Column(name="latitud" , nullable= true )
	private Double latitud;

	@Column(name="longitud" , nullable= true )
	private Double longitud;


	//private List<Mensaje> mensajes;
	@OneToMany(mappedBy="usuario")
	private List<Respondidas> respondidas;

	@ManyToMany
	private List<Usuario> amigos;


	@ElementCollection (fetch=FetchType.EAGER)
	private List<String> aficiones;

	public Usuario(){
		//mensajes=new ArrayList<>();
		respondidas=new ArrayList<>();
		amigos= new ArrayList<>();
		aficiones=	new ArrayList<>();

	}

	public Usuario(String email, String password, String nombre, String genero, String genero_buscado,
				   Date fecha_nac, byte[] foto, String descripcion, String[] aficiones, Double latitud, Double longitud) {
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		if(genero=="MASCULINO" || genero=="masculino")
			this.genero = GeneroEnum.MASCULINO;
		if(genero=="FEMENINO" || genero=="femenino")
			this.genero = GeneroEnum.FEMENINO;
		this.fecha_nac = fecha_nac;
		this.foto = foto;
		this.descripcion = descripcion;
		this.latitud = latitud;
		this.longitud = longitud;
		//this.mensajes= new ArrayList<>();
		this.respondidas=new ArrayList<>();
		this.amigos =new ArrayList<>();
		this.aficiones = new ArrayList<>();

		if (aficiones != null) {
			Collections.addAll(this.aficiones, aficiones);
		}
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
		return genero.toString();
	}

	public void setGenero(String genero) {
		if(genero=="MASCULINO" || genero=="masculino")
		this.genero = GeneroEnum.MASCULINO;
	    if(genero=="FEMENINO" || genero=="femenino")
		this.genero = GeneroEnum.FEMENINO;
	    else
	    this.genero = GeneroEnum.FEMENINO;	
	}

	public String getGenero_buscado() {
		return genero_buscado.toString();
	}

	public void setGenero_buscado(String genero_buscado) {
		if(genero_buscado=="MASCULINO" || genero_buscado=="masculino")
			this.genero_buscado = GeneroEnum.MASCULINO;
		    if(genero_buscado=="FEMENINO" || genero_buscado=="femenino")
			this.genero_buscado = GeneroEnum.FEMENINO;
		    else
		    this.genero_buscado = GeneroEnum.FEMENINO;
	}

	public Date getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(Date fecha_nac) {
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

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
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

	/*
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
*/

	public List<Respondidas> getRespondidas() {
		return respondidas;
	}

	public void addRespondida(Respondidas m) {
		respondidas.add(m);
	}

	public void removeRespondidas(Respondidas m) {
		respondidas.remove(m);
	}

	public int getNumRespondidas() {
		return respondidas.size();
	}

//--------------------------------------
	public List<String> getAficiones() {
		return aficiones;
	}

	public void addAficion(String a) {
		aficiones.add(a);
	}

	public void removeAficion(String a) {
		aficiones.remove(a);
	}

	public void updateAficion(String a, String value) {
		aficiones.set(aficiones.indexOf(a), value);
	}

	public int getNumAficiones() {
		return aficiones.size();
	}

    public int calculateAge() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY");
        Date now = new Date(System.currentTimeMillis());

        return fecha_nac != null ? Integer.parseInt(dateFormat.format((Date) now)) - Integer.parseInt(dateFormat.format((Date) fecha_nac)) : 0;
    }

    public void setAficiones(List<String> afic) {
       aficiones= afic;
    }

	public double calculateDistnace(double lat, double lng) {
		final int R = 6371000;

		Double latDistance = Math.toRadians(lat - getLatitud());
		Double lonDistance = Math.toRadians(lng - getLongitud());

		Double a = Math.pow(Math.sin(latDistance / 2), 2) + Math.cos(Math.toRadians(lat))
				* Math.cos(Math.toRadians(getLatitud())) * Math.pow(Math.sin(lonDistance / 2), 2);

		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		Double distance = Math.pow(R * c, 2);

		return Math.sqrt(distance);
	}
}
