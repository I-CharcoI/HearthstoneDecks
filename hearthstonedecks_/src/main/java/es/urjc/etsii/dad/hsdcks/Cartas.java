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
	
	
}