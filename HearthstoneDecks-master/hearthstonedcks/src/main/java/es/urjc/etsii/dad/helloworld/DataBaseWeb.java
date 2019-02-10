package es.urjc.etsii.dad.helloworld;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class DataBaseWeb {

	@Autowired
	private CartasRepository cartas_repository;
	
	@PostConstruct
	private void init() {
		//introducir cartas en la BBDD 
		cartas_repository.save(new Cartas("Corsario Velasangre","Neutral","Clasico",1,"Grito de batalla","Poco Comun","Esbirro",1,2));
		cartas_repository.save(new Cartas("Diablillo de llamas","Brujo","Clasico",1,"Grito de batalla","Comun","Esbirro",3,2));
		cartas_repository.save(new Cartas("Bendicion de sabiduria","Paladin","Clasico",1,"Elige a un esbirro. Cada vez que ataca, roba una carta.","Comun","Hechizo",0,0));
		cartas_repository.save(new Cartas("Celadora de la Luz","Neutral","Clasico",1,"Obtiene +2 p. de ataque cada vez que se sana a un personaje.","Poco Comun","Esbirro",1,2));
		cartas_repository.save(new Cartas("Colera de las bestias","Cazador","Clasico",1,"Otorga +2 p. de ataque e Inmune a una bestia amistosa este turno.","Epica","Hechizo",0,0));
		cartas_repository.save(new Cartas("Choque de tierra","Chaman","Clasico",1,"Silencio","Comun","Hechizo",0,0));
		
		cartas_repository.save(new Cartas("Embate","Guerrero","Clasico",2,"Inflige 2 p. de daño a un esbirro. Si sobrevive, roba una carta.","Comun","Hechizo",0,0));
		cartas_repository.save(new Cartas("Asaltante Velasangre","Neutral","Clasico",2,"Grito de batalla","Comun","Esbirro",2,3));
		cartas_repository.save(new Cartas("Hacha Tronaforjado","Chaman","Clasico",2,"Sobrecarga","Comun","Arma",2,3));
		cartas_repository.save(new Cartas("Aprendiza de hechicera","Mago","Clasico",2,"Tus hechizos cuestan (1) cristal menos.","Comun","Esbirro",3,2));
		cartas_repository.save(new Cartas("Dragon feerico","Neutral","Clasico",2,"No puede ser objetivo de hechizos ni de poderes de héroe.","Comun","Esbirro",3,2));
		
		//cartas_repository.save(new Cartas());
		//cartas_repository.save(new Cartas());
		//cartas_repository.save(new Cartas());
		//cartas_repository.save(new Cartas());
		//cartas_repository.save(new Cartas());
		//cartas_repository.save(new Cartas());
		//cartas_repository.save(new Cartas());
		//cartas_repository.save(new Cartas());
		
		
	}
	
}
