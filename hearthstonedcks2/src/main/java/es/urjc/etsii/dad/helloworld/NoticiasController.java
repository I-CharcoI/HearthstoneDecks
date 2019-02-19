package es.urjc.etsii.dad.helloworld;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticiasController {

	@Autowired
	private NoticiasRepository repository;
	
	
	@PostConstruct
	public void init() {
		repository.save(new Noticias("Noticia1", "este es el primera noticia que hago jajajaja", "Autor: Pepe"));
		repository.save(new Noticias("Noticia2", "esta es la segunda noticia bla bla bla blablabla blabla blabla bla blabla blabla blabla blabla", "Autor: Antonio"));
	}
	
	@RequestMapping("/notici")
	public String noticia(Model model) {

		model.addAttribute("noti", repository.findAll());

		return "noticias";
	}
	
	@RequestMapping("/indexx")
	public String notindex(Model model) {

		model.addAttribute("noindex", repository.findAll());

		return "index";
	}
	

}