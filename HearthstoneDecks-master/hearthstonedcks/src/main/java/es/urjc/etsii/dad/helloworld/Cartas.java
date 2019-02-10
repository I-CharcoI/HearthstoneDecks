package es.urjc.etsii.dad.helloworld;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Cartas {

	private String nombre;
	private String clase;
	private String expansion;
	private int coste;
	private String efecto;
	private String rareza;
	private String tipo;//Esbirro,Hechizo,Arma
	private int ataque;
	private int vida;
	private int num_copias;//en duda, porque el mazo como maximo tiene dos copias de una misma carta
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id_carta;
	
	//Una carta esta en N mazos, un mazo tiene N cartas
	@ManyToMany
	private List<Mazo> mazo;
	
	public Cartas() {
		
	}
	public Cartas(String nombre,String clase,String expansion,int coste,String efecto,String rareza,String tipo, int ataque,int vida) {
		this.nombre= nombre;
		this.clase= clase;
		this.coste= coste;
		this.efecto= efecto;
		this.rareza= rareza;
		this.expansion= expansion;
		this.tipo = tipo;
		if(tipo=="Hechizo") {
			this.ataque = 0;
			this.vida= 0;
		} 
		else {
			this.ataque = ataque;
			this.vida= vida;
		}
	} 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public int getCoste() {
		return coste;
	}
	public void setCoste(int coste) {
		this.coste = coste;
	}
	public String getEfecto() {
		return efecto;
	}
	public void setEfecto(String efecto) {
		this.efecto= efecto;
	}
	public String getRareza() {
		return rareza;
	}
	public void setRareza(String rareza) {
		this.rareza = rareza;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		if(this.tipo=="Hechizo") {
			this.ataque= 0;
		}
		else {
			this.ataque=ataque;
		}
	}
	public String getExpansion() {
		return expansion;
	}
	public void setExpansion(String expansion) {
		this.expansion = expansion;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		if(this.tipo=="Hechizo") {
			this.vida= 0;
		}
		else {
			this.vida= vida;
		}
	}
	public long getId() {
		return id_carta;
	}
}
