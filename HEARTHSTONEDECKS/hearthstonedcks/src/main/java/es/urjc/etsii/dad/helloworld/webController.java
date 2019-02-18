package es.urjc.etsii.dad.helloworld;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webController {
	
boolean inic = false;
	
	@Autowired
	private UserRepository user_repository;
	/**
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
	
	@PostMapping("/index")
	public String indexPrueba2(Model model,@RequestParam String nombre,@RequestParam String contrasenia) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("contrasenia", contrasenia);
		return "index";
		
	}
	**/
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("sinsesion",true);
		model.addAttribute("sesion",false);
		return "index";
	}
	@RequestMapping("/")
	public String init(Model model,HttpSession usu) {
		if(inic == false) {
			model.addAttribute("sinsesion",true);
			model.addAttribute("sesion",false);
			User Aitor = new User("Aitor","Matilla","Casanova","aitor97_","amatillacasanova@gmail.com","pruebausuario1","01/04/1997","España");
			user_repository.save(Aitor);
			
			User Luis = new User("Luis","Notengo","Apellidos","luisito_NTA","usuario@gmail.com","nosoyreal22","14/02/1988","Paraguay");
			user_repository.save(Luis);
			User Kojiro = new User("Kojiro","Hyuga","Narita","soyFictisio_","usuariofalso@gmail.com","nosabiaqueponerxd","09/11/2000","Japon");
			user_repository.save(Kojiro);
			
			inic = true;
		}
		return "index";
	}
	
	
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