package es.urjc.etsii.dad.helloworld;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AnunciosController {

	@Autowired
	private AnunciosRepository repository;
	
	@PostConstruct
	public void init() {
		repository.save(new Anuncios("Este es el primer anuncio","Este anuncio es de prueba en teoria se debe de inicializar el primero mas ejecutar la web","10/02/2019"));
		
	}
}
