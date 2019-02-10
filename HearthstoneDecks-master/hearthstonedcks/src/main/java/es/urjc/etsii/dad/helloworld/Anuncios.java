package es.urjc.etsii.dad.helloworld;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Anuncios {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id_anuncio;
	
	private String titulo;
	private String contenido;
	private String fechaCreacion;
	//Un anuncio tiene un usuario,un usuario tiene N anuncios
	@ManyToOne
	private User usuario;
	
	public Anuncios() {
		
	}
	
	public Anuncios(String titulo,String contenido,String fechaCreacion) {
		this.titulo = titulo;
		this.contenido= contenido;
		this.fechaCreacion = fechaCreacion;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	
	public User getUsuario() {
		return usuario;
	}
	//devuelve el nombre del usuario
	public String nombUser() {
		return usuario.getNick();
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setUser(User usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "["+nombUser()+"]"+"   "+getTitulo()+"   "+getFechaCreacion()+"  "+getContenido();
	}
}
