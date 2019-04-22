package es.urjc.etsii.dad.hsdcks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


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
	@ManyToOne
	private User autor;
	
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
	
	@Override
	public int hashCode() {
		final int primo = 31;
		int result = 1;
		
		result = primo * result +(int) (id_anuncio ^(id_anuncio >>> 32));
		result = primo * result +((titulo == null) ? 0: titulo.hashCode());
		result = primo * result +((contenido == null) ? 0: contenido.hashCode());
		result = primo * result +((fechaAnuncio == null) ? 0: fechaAnuncio.hashCode());
		result = primo * result +((autor == null) ? 0: autor.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Anuncios otro = (Anuncios) obj;
		if(id_anuncio != otro.id_anuncio) {
			return false;
		}
		if(titulo == null) {
			if(otro.titulo == null) {
				return false;
			}
		}else if (!titulo.equals(otro.titulo)) {
			return false;
		}
		if(contenido == null) {
			if(otro.contenido == null) {
				return false;
			}
		}else if (!contenido.equals(otro.contenido)) {
			return false;
		}
		if(fechaAnuncio == null) {
			if(otro.fechaAnuncio == null) {
				return false;
			}
		}else if (!fechaAnuncio.equals(otro.fechaAnuncio)) {
			return false;
		}
		if(autor == null) {
			if(otro.autor == null) {
				return false;
			}
		}else if (!autor.equals(otro.autor)) {
			return false;
		}
		return true;
	}
}