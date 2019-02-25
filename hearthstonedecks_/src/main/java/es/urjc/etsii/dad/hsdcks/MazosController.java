package es.urjc.etsii.dad.hsdcks;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MazosController {

	private User user;
	@Autowired
	private MazosRepository repository;
	
	@PostConstruct
	public void init() {

	repository.save(new Mazos("Mazo1","Pepe",30));
	repository.save(new Mazos("Mazo2","Antonia",0));
	repository.save(new Mazos("Mazo3","Carla",50));
	repository.save(new Mazos("Mazo4","Jesus",72));
	repository.save(new Mazos("Mazo5","Adolfo",5));
	}
	
	
	@RequestMapping("/mazo")
	public String anuncio(Model model) {

		model.addAttribute("mazoss", repository.findAll());

		return "mazos";
	}
}