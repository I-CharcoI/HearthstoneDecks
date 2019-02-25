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
	
}