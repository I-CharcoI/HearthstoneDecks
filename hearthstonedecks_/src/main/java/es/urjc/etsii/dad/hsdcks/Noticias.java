package es.urjc.etsii.dad.hsdcks;
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
	@Override
	public int hashCode() {
		final int primo = 31;
		int result = 1;
		
		result = primo * result +(int) (id_noticia ^(id_noticia >>> 32));
		result = primo * result +((titulo == null) ? 0: titulo.hashCode());
		result = primo * result +((contenido == null) ? 0: contenido.hashCode());
		result = primo * result +((fecha == null) ? 0: fecha.hashCode());
		
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
		
		Noticias otro = (Noticias) obj;
		if(id_noticia != otro.id_noticia) {
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
		if(fecha == null) {
			if(otro.fecha == null) {
				return false;
			}
		}else if (!fecha.equals(otro.fecha)) {
			return false;
		}
		
		return true;
	}
}