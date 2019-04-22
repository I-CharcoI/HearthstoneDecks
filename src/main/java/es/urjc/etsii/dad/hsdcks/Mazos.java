package es.urjc.etsii.dad.hsdcks;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Mazos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
	
	
	private String nombre;
	
	private int votos;
	private String creador;
	private String mazo1;
	private String mazo2;
	@ManyToMany(mappedBy="mazo")
	private List<Cartas> cartas;
	
	@ManyToOne
	private User usuario;
	
	public Mazos() {}
	
	public Mazos(String nombre,String creador,int votos,String mazo1,String mazo2) {
		this.creador=creador;
		this.nombre=nombre;
		this.votos=votos;
		this.mazo1=mazo1;
		this.mazo2=mazo2;
	}
	

	public String getCreador() {
		return creador;
	}
	public void setCreador(String creador){
		this.creador=creador;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getVotos() {
		return this.votos;
	}
	public void setVotos(int votos) {
		this.votos=votos;
	}
	public List<Cartas> getCartas() {
		return cartas;
	}
	public void setCartas(List<Cartas> cartas) {
		this.cartas = cartas;
	}
	@Override
	public int hashCode() {
		final int primo = 31;
		int result = 1;
		
		result = primo * result +(int) (id ^(id >>> 32));
		result = primo * result +((nombre == null) ? 0: nombre.hashCode());
		result = primo * result +(votos ^(votos >>> 32));
		result = primo * result +((creador == null) ? 0: creador.hashCode());
		result = primo * result +((mazo1 == null) ? 0: mazo1.hashCode());
		result = primo * result +((mazo1 == null) ? 0: mazo1.hashCode());
		result = primo * result +((usuario == null) ? 0: usuario.hashCode());
		result = primo * result +((cartas==null) ? 0: cartas.hashCode());
		
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
		
		Mazos otro = (Mazos) obj;
		if(id != otro.id) {
			return false;
		}
		if(votos != otro.votos) {
			return false;
		}
		if(nombre == null) {
			if(otro.nombre == null) {
				return false;
			}
		}else if (!nombre.equals(otro.nombre)) {
			return false;
		}
		if(creador== null) {
			if(otro.creador == null) {
				return false;
			}
		}else if (!creador.equals(otro.creador)) {
			return false;
		}
		if(mazo1 == null) {
			if(otro.mazo1 == null) {
				return false;
			}
		}else if (!mazo1.equals(otro.mazo1)) {
			return false;
		}
		if(mazo2 == null) {
			if(otro.mazo2 == null) {
				return false;
			}
		}else if (!mazo2.equals(otro.mazo2)) {
			return false;
		}
		if(usuario == null) {
			if(otro.usuario == null) {
				return false;
			}
		}else if (!usuario.equals(otro.usuario)) {
			return false;
		}
		if(cartas == null) {
			if(otro.cartas == null) {
				return false;
			}
		}else if (!cartas.equals(otro.cartas)) {
			return false;
		}
		return true;
	}
}