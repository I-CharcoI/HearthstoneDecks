package es.urjc.etsii.dad.helloworld;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUser;
	
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	@Column(unique= true)
	private String nick;
	private String correo;
	private String contrasenia;
	private String fechanac;
	private String pais;
	
	@OneToMany(mappedBy="autor")
	private List<Anuncios> anuncios;
	
	@OneToMany(mappedBy="usuario")
	private List<Mazos> mazo;
	
	public User() {
		
	}
	
	public User(String nombre,String apellido1,String apellido2,String nick,String correo,String contrasenia,String fechanac,String pais) {
		
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nick = nick;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.fechanac = fechanac;
		this.pais = pais;
	}
	
	public long getId() {
		return idUser;
	}
	
	public void setId(long id) {
		idUser = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nomb) {
		this.nombre = nomb;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	public void setApellido1(String ap) {
		apellido1 = ap;
	}
	public String getApellido2() {
		return apellido2;
	}
	
	public void setApellido2(String ap) {
		apellido2 = ap;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String ni) {
		nick = ni;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String corr) {
		this.correo = corr;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void setContrasenia(String con) {
		this.contrasenia = con;
	}
	
	public String getFechanac() {
		return fechanac;
	}
	
	public void setFechanac(String fech) {
		this.fechanac = fech;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String toString() {
		return "Usuario [id: "+idUser+" ,nombre: "+nombre+" ,primer apellido: "+apellido1+" , segundo apellido: "+apellido2+" ,nick: "+nick+" ,correo: "+correo+" ,contraseña: "+contrasenia+" ,fecha de nacimiento: "+fechanac+" ,pais: "+pais+" ]";
	}
}
