package es.urjc.etsii.dad.hsdcks;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cartas {
	
	@Id
	private String nombre;
	
	private String clase;
	private String expansion;
	private int coste;
	private String efecto;
	private String rareza;
	private String tipoCarta;
	private int ataque;
	private int vida;
	private String imagen;
	
	//Una carta esta en N mazos, un mazo tiene N cartas
	@ManyToMany
	private List<Mazos> mazo;
	//constructor
	public Cartas() {}
	
	public Cartas(String nombre, String clase, String expansion, int coste, String efecto, String rareza, String tipoCarta, int ataque, int vida, String imagen){
		this.nombre=nombre;
		this.clase=clase;
		this.expansion=expansion;
		this.coste=coste;
		this.efecto=efecto;
		this.rareza=rareza;
		this.tipoCarta=tipoCarta;
		this.ataque=ataque;
		this.vida=vida;
		this.setImagen(imagen);
		
		
	}
	
	//getters y setters
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getClase() {
		return this.clase;
	}
	public void setClase(String clase) {
		this.clase=clase;
	}
	
	public String getExpansion() {
		return this.expansion;
	}
	public void setExpansion(String expansion) {
		this.expansion=expansion;
	}
	
	public int getCoste() {
		return this.coste;
	}
	public void setCoste(int coste) {
		this.coste=coste;
	}
	
	public String getEfecto() {
		return this.efecto;
	}
	public void setEfecto(String efecto) {
		this.efecto=efecto;
	}
	
	public String getRareza() {
		return this.rareza;
	}
	public void setRareza(String rareza) {
		this.rareza=rareza;
	}
	
	public String getTipoCarta() {
		return this.tipoCarta;
	}
	public void setTipoCarta(String tipoCarta) {
		this.tipoCarta=tipoCarta;
	}
	
	public int getAtaque() {
		return this.ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque=ataque;
	}
	
	public int getVida() {
		return this.vida;
	}
	public void setVida(int vida) {
		this.vida=vida;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	@Override
	public int hashCode() {
		final int primo = 31;
		int result = 1;
		
		//result = primo * result +(int) (nombre ^(nombre >>> 32));
		result = primo * result +((nombre == null) ? 0: nombre.hashCode());
		result = primo * result +((clase == null) ? 0: clase.hashCode());
		result = primo * result +((expansion == null) ? 0: expansion.hashCode());
		result = primo * result +(coste ^(coste >>> 32));
		result = primo * result +((efecto == null) ? 0: efecto.hashCode());
		result = primo * result +((rareza == null) ? 0: rareza.hashCode());
		result = primo * result +((tipoCarta == null) ? 0: tipoCarta.hashCode());
		result = primo * result +((imagen == null) ? 0: imagen.hashCode());
		result = primo * result +(vida ^(vida >>> 32));
		result = primo * result +(ataque ^(ataque >>> 32));
		result = primo * result +((mazo == null) ? 0: mazo.hashCode());
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
		
		Cartas otro = (Cartas) obj;
		if(coste != otro.coste) {
			return false;
		}
		if(vida != otro.vida) {
			return false;
		}
		if(ataque !=otro.ataque) {
			return false;
		}
		if(nombre == null) {
			if(otro.nombre == null) {
				return false;
			}
		}else if (!nombre.equals(otro.nombre)) {
			return false;
		}
		if(clase == null) {
			if(otro.clase == null) {
				return false;
			}
		}else if (!clase.equals(otro.clase)) {
			return false;
		}
		if(expansion == null) {
			if(otro.expansion == null) {
				return false;
			}
		}else if (!expansion.equals(otro.expansion)) {
			return false;
		}
		if(efecto == null) {
			if(otro.efecto == null) {
				return false;
			}
		}else if (!efecto.equals(otro.efecto)) {
			return false;
		}
		if(rareza == null) {
			if(otro.rareza == null) {
				return false;
			}
		}else if (!rareza.equals(otro.rareza)) {
			return false;
		}
		if(tipoCarta == null) {
			if(otro.tipoCarta == null) {
				return false;
			}
		}else if (!tipoCarta.equals(otro.tipoCarta)) {
			return false;
		}
		if(imagen == null) {
			if(otro.imagen == null) {
				return false;
			}
		}else if (!imagen.equals(otro.imagen)) {
			return false;
		}
		if(mazo == null) {
			if(otro.mazo == null) {
				return false;
			}
		}else if (!mazo.equals(otro.mazo)) {
			return false;
		}
		return true;
	}
	
}