package es.urjc.etsii.dad.helloworld;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	@Column(unique=true,nullable=false)
	private String nick;
	
	private String pais;
	
	@Lob
	private String correo;
	
	@Lob
	private String contrasenia;
	
	private String fechanac;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id_user;
	
	// un usuario tiene N anuncios, un anuncio solo tiene un usuario
	@OneToMany
	private List<Anuncios> anuncios;
	
	public User() {
		
	}
	public User(String nombre,String apellido1,String apellido2,String nick,String pais,String correo,String contrasenia,String fechanac) {
		this.nombre = nombre;
		this.apellido1= apellido1;
		this.apellido2= apellido2;
		this.nick = nick;
		this.pais = pais;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.fechanac = fechanac;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public String getNick() {
		return nick;
	}
	public String getPais() {
		return pais;
	}
	public String getCorreo() {
		return correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public String getFechanac() {
		return fechanac;
	}
	public long getId() {
		return id_user;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}
}
