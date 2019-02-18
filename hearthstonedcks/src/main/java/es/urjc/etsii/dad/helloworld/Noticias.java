package es.urjc.etsii.dad.helloworld;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Noticias {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id_noticia;
	
	@Lob
	private String titulo;
	
	@Lob
	private String contenido;
	
	private String fecha;
	
	public Noticias() {
		
	}
	public Noticias(String titulo,String contenido,String fecha) {
		this.titulo = titulo;
		this.contenido = contenido;
		this.fecha = fecha;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getContenido() {
		return contenido;
	}
	public String getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		return "   "+getTitulo()+"   "+getFecha()+"  "+getContenido();
	}
}