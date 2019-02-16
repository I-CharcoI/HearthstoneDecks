package es.urjc.etsii.dad.helloworld;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class webController {

	@Autowired
	private AnunNotiRepository repository;
	
	
	
	@PostConstruct
	public void initN() {
		repository.save(new AnunNoti("Noticia1", "este es el primera noticia que hago jajajaja", "Autor: Pepe", "noticia"));
		repository.save(new AnunNoti("Noticia2", "esta es la segunda noticia bla bla bla blablabla blabla blabla bla blabla blabla blabla blabla", "Autor: Antonio","noticia"));
	}
	
	@RequestMapping("/notici")
	public String noticia(Model model) {

		model.addAttribute("noti", repository.findAll());

		return "noticias";
	}
	
	@RequestMapping("/indexx")
	public String notanunindex(Model model) {

		model.addAttribute("noindex", repository.findAll());
		model.addAttribute("anunindex", repository.findAll());

		return "index";
	}
	
	@PostConstruct
	public void initA() {
		repository.save(new AnunNoti("Anuncio1", "este es el primer anuncio que hago jajajaja", "Autor: Pepe", "anuncio"));
		repository.save(new AnunNoti("Anuncio2", "este es el segundo anuncio blablabla blabla blabla blabla bla blabla blabla blabla ", "Autor:Antonio", "anuncio"));
	}

	@RequestMapping("/anunci")
	public String anuncio(Model model) {

		model.addAttribute("anuncio", repository.findAll(anuncio);

		return "anuncios";
	}
	

	
	@GetMapping("/")
	public String indexPrueba() {
		return "index.html";
	}
	@GetMapping("/register")
	public String registerPrueba() {
		return "registrarse.html";
	}
	@GetMapping("/login")
	public String loginPrueba(){
		return "login.html";
	}
	
/*	@PostMapping("/index")
	public String indexPrueba2(Model model,@RequestParam String nombre,@RequestParam String contrasenia) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("contrasenia", contrasenia);
		return "index";
		
	}
*/
	
	@GetMapping("/noticias")
	public String notParticular(Model model) {
		model.addAttribute("tit", "Titulo1");
		return "noticias";
	}
	
	@GetMapping("/anuncios")
	public String anun(Model model) {
		model.addAttribute("anun", "Titulo1");
		return "anuncios";
	}
}
/*	public String showItem(Model ..., long id) {
Item i = repo.findById(id).ortlseThrow(
		()-> new EntityNotFound("id no encontrado" +id));
}
*/