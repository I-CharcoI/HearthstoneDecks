package es.urjc.etsii.dad.helloworld;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class Anuncios {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id_anuncio;
	
	
	private String titulo;
	@Lob
	private String contenido;
	
	private String fechaAnuncio;
	//Un anuncio tiene un usuario,un usuario tiene N anuncios
	//@ManyToOne
	//private User usuario;
	
public Anuncios() {
		
	}
	
	public Anuncios(String titulo,String contenido,String fechaAnuncio) {
		super();
		this.titulo = titulo;
		this.contenido= contenido;
		this.fechaAnuncio = fechaAnuncio;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getContenido() {
		return contenido;
	}
	
	public String getFechaAnuncio() {
		return fechaAnuncio;
	}
	
	//public User getUsuario() {
	//	return usuario;
	//}
	//devuelve el nombre del usuario
	//public String nombUser() {
		//return usuario.getNick();
	//}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public void setFechaAnuncios(String fechaCreacion) {
		this.fechaAnuncio = fechaCreacion;
	}
	//public void setUser(User usuario) {
	//	this.usuario = usuario;
	//}
	
	@Override
	public String toString() {
		return "   "+getTitulo()+"   "+getFechaAnuncio()+"  "+getContenido();
	}
}