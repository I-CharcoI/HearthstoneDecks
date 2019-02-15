package hearthstonedecks;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mazo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String creador;
	private String nombre;
	private ArrayList<Carta> cartas;
	private int votos;
	
	public Mazo(String creador,String nombre,ArrayList<Carta> cartas) {
		this.creador=creador;
		this.nombre=nombre;
		this.votos=0;
	}
	public String getCreador() {
		return this.creador;
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
	
}
