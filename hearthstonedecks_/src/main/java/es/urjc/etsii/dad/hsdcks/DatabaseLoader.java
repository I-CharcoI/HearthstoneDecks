package es.urjc.etsii.dad.hsdcks;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {
	
	@Value("${admin}")
	private String admin;
	
	@Autowired
	UserRepository userRep;
	@Autowired
	CartasRepository cartasRep;
	@Autowired
	AnunciosRepository anunciosRep;
	@Autowired
	MazosRepository mazosRep;
	@Autowired
	NoticiasRepository noticiasRep;
	
	@PostConstruct
	private void initDatabase() {
		//Carga de usuarios
		User userAitor= new User("Aitor","Mantilla","Casanova",admin,"amatillacasanova@gmail.com","admin1","01/04/1997","España","ROLE_USER","ROLE_ADMIN");
		userRep.save(userAitor);
		
		//Cargar Cartas
		cartasRep.save(new Cartas("Abisario","Brujo","Basico",1,"Provocar","Basica","Esbirro",1,3,"/imagenes/ImagenesCartas/Brujo/abisario.jpg"));
		cartasRep.save(new Cartas("Corrupcion","Brujo","Basico",1,"Elige a un esbirro enemigo.Al comienzo de tu turno, lo destruyes","Basica","Hechizo",0,0,"/imagenes/ImagenesCartas/Brujo/corrupcion.jpg"));
		cartasRep.save(new Cartas("Espiral mortal","Brujo","Basico",1,"Inflige 1 de daño a un esbirro.Si eso lo mata, roba una carta","Basica","Hechizo",0,0,"/imagenes/ImagenesCartas/brujo/espiralMortal.jpg"));
		cartasRep.save(new Cartas("Fuego de alma","Brujo","Basico",1,"Inflinge 4 de daño.Descarta una carta aleatoria","Basica","Hechizo",0,0,"/imagenes/ImagenesCartas/brujo/fuegoDeAlma.jpg"));
		cartasRep.save(new Cartas("Sacrificio pactado","Brujo","Basico",0,"Destruye a un demonio. Restaura 5 de salud a tu heroe","Basica","Hechizo",0,0,"/imagenes/ImagenesCartas/brujo/sacrificioPactado.jpg"));
		cartasRep.save(new Cartas("Diablillo de llamas","Brujo","Clasico",1,"Grito de batalla: Inflinge 3 de daño a tu heroe","Comun","Esbirro",3,2,"/imagenes/ImagenesCartas/brujo/diablilloDeLlamas.jpg"));
		cartasRep.save(new Cartas("Fuego demoniaco","Brujo","Clasico",2,"Inflige 2 de daño. Si el objetivo es un demonio amistoso, en lugar de dañarlo le otorga +2/+2","Común","Hechizo",0,0,"/imagenes/ImagenesCartas/brujo/fuegoDemoniaco.jpg"));
		cartasRep.save(new Cartas("Llama de las sombras","Brujo","Clasico",4,"Destruye un esbirro amistoso e inflinge un daño equivalente a su ataque a todos los esbirros enemigos","Poco comun","Hechizo",0,0,"/imagenes/ImagenesCartas/brujo/llamaDeLasSombras.jpg"));
		cartasRep.save(new Cartas("Terror del vacio","Brujo","Clasico",3,"Grito de batalla: Destruye a los esbirros adyacentes y obtiene su ataque y salud","Poco común","Esbirro",3,3,"/imagenes/ImagenesCartas/brujo/terrorDelVacio.jpg"));
		cartasRep.save(new Cartas("Vacio abisal","Brujo","Clasico",8,"Destruye a todos los esbirros","Epica","Hechizo",0,0,"/imagenes/ImagenesCartas/brujo/vacioAbisal.jpg"));
		cartasRep.save(new Cartas("Lord Jaraxxus","Brujo","Clasico",9,"Grito de batalla: Destruye a tu héroe y lo reemplaza con Lord Jaraxxus","Legendaria","Esbirro",3,15,"/imagenes/ImagenesCartas/brujo/lordJaraxxus.jpg"));
		//Cargar los Anuncios
		anunciosRep.save(new Anuncios("Anuncio1", "este es el primer anuncio que hago jajajaja", "20 de febrero"));
		anunciosRep.save(new Anuncios("Anuncio2", "este es el segundo anuncio blablabla blabla blabla blabla bla blabla blabla blabla ", "2 de mayo"));
		//Cargar los Mazos
		mazosRep.save(new Mazos("Mazo1","Pepe",30,("Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario "),(" Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario ")));
		mazosRep.save(new Mazos("Mazo2","Antonia",0,("Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario "),(" Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario ")));
		//Cargar Noticias
		noticiasRep.save(new Noticias("Noticia1", "este es el primera noticia que hago jajajaja", "4 de mayo"));
		noticiasRep.save(new Noticias("Noticia2", "esta es la segunda noticia bla bla bla blablabla blabla blabla bla blabla blabla blabla blabla", "01/01/0001"));
	}
	
}
