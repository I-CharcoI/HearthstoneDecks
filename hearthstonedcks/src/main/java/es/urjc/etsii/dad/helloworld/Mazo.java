package es.urjc.etsii.dad.helloworld;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Mazo {

	private String nombre;
	private String clase;
	private int votos;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id_mazo;
	
	//Un mazo tiene N cartas(maximo 2 de cada carta) y n cartas estan en N mazos
	@ManyToMany(mappedBy="mazo")
	private List<Cartas> cartas;
	
	public Mazo() {
		
	}
	public Mazo(String nombre,String clase) {
		this.nombre= nombre;
		this.clase= clase;
		this.votos= 0;
	}
	
}
