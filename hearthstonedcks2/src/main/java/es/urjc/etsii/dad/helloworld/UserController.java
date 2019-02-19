package es.urjc.etsii.dad.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
@Controller
public class UserController {

	boolean inic = false;
	
	//variable que nos indicara que el usuario esta logeado
	private User userL;
	@Autowired 
	private UserRepository repository;
	
	
	@PostConstruct
	public void init() {
		this.userL = null;//no hay usuario logueado
	}
	
	@PostMapping("/login")
	public String initSesion(Model model,HttpSession user) {
		if(this.userL==null) {
			//si el usuario no esta logeado va al template login
			return "login";
		}
		else {
			
			model.addAttribute("nick",this.userL.getNick());
			model.addAttribute("sinsesion",false);
			model.addAttribute("sesion",true);
			return "index";
		}
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("sinsesion",true);
		model.addAttribute("sesion",false);
		return "index";
	}
	@RequestMapping("/")
	public String init(Model model,HttpSession usu) throws ParseException {
		if(inic == false) {
			model.addAttribute("sinsesion",true);
			model.addAttribute("sesion",false);
			User Aitor = new User("Aitor","Matilla","Casanova","aitor97_","amatillacasanova@gmail.com","pruebausuario1","01/04/1997","España");
			repository.save(Aitor);
			
			User Luis = new User("Luis","Notengo","Apellidos","luisito_NTA","usuario@gmail.com","nosoyreal22","14/02/1988","Paraguay");
			repository.save(Luis);
			User Kojiro = new User("Kojiro","Hyuga","Narita","soyFictisio_","usuariofalso@gmail.com","nosabiaqueponerxd","09/11/2000","Japon");
			repository.save(Kojiro);
			
			inic = true;
		}
		return "index";
	}
	
}
