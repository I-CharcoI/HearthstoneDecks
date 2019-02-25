package es.urjc.etsii.dad.hsdcks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
@Controller
public class UserController {

	//variable que nos indicara que el usuario esta logeado
	private User userL;
	@Autowired 
	private UserRepository repository;
	
	
	@PostConstruct
	public void init() {
		this.userL = null;//no hay usuario logueado
		User Aitor = new User("Aitor","Matilla","Casanova","aitor97_","amatillacasanova@gmail.com","pruebausuario1","01/04/1997","España");
		repository.save(Aitor);
		
		User Luis = new User("Luis","Notengo","Apellidos","luisito_NTA","usuario@gmail.com","nosoyreal22","14/02/1988","Paraguay");
		repository.save(Luis);
		User Kojiro = new User("Kojiro","Hyuga","Narita","soyFictisio_","usuariofalso@gmail.com","nosabiaqueponerxd","09/11/2000","Japon");
		repository.save(Kojiro);
	}
	
	/**@PostMapping(value="/login")
	public String initSesion(Model model,HttpSession user) {
		if(this.userL==null) {
			//si el usuario no esta logeado va al template login
			model.addAttribute("error","Error,el usuario no esta en la base de datos.Registrese en el enlace de abajo");
			return "login";
		}
		else {
			
			model.addAttribute("nick",this.userL.getNick());
			model.addAttribute("sinsesion",false);
			model.addAttribute("sesion",true);
			return "index";
		}
	}
	
	@GetMapping("/register")
	public String registerUser(Model model,User usu,HttpSession user) {
		userL = usu;
		repository.save(userL);
		model.addAttribute("sinsesion",true);
		model.addAttribute("sesion",false);
		return "index";
		
	}
	
	@PostMapping("/logearse")
	public String logearse(Model model, HttpSession user, User usu) {
		User usAcc = this.repository.findByNickAndContrasenia(usu.getNick(),usu.getContrasenia());
		if(usAcc==null) {
			model.addAttribute("error","Error,el usuario no existe.Registrese en el enlace de abajo.");
			return "login";
		}
		else {
			this.userL = usAcc;
			model.addAttribute("nick",this.userL.getNick());
			model.addAttribute("sinsesion",false);
			model.addAttribute("sesion",true);
			return "index";
		}
	}
	@GetMapping("/cerrarSesion")
	public String cerrarS(Model model, HttpSession usu) {
		if(this.userL !=null) {
			model.addAttribute("sinsesion",true);
			model.addAttribute("sesion",false);
			return "index";
		}
		return "index";
	}
	**/
	@RequestMapping("/")
	public String inicioPag(Model model,HttpSession session) {
		if(userL ==null) {
			model.addAttribute("sinsesion",true);
			model.addAttribute("sesion",false);
			return "index";
		}
		else {
			model.addAttribute("sinsesion",false);
			model.addAttribute("sesion", true);
			model.addAttribute("nick",userL.getNick());
			return "index";
		}
	}
	
	@PostMapping("/register")
	public String registerUser(Model model,User usu,HttpSession user) {
		userL = usu;
		repository.save(userL);
		model.addAttribute("sinsesion",true);
		model.addAttribute("sesion",false);
		return "index";
		
	}
	
	
	@GetMapping("/login")
	public String inicioSesion(Model model, HttpSession session) {
		if(userL==null) {
			model.addAttribute("problema", " ");
			return "login";
		}
		else {
			model.addAttribute("nick",userL.getNick());
			return "login_correcto";
		}
	}
	
	@PostMapping("/logearse")
	public String logearse(Model model,HttpSession session, User usuario) {
		User usIntenta = this.repository.findByNickAndContrasenia(usuario.getNick(),usuario.getContrasenia());
		if(usIntenta == null) {
			model.addAttribute("problema","Error,el usuario no existe");
			return "login";
		}
		else {
			this.userL = usIntenta;
			model.addAttribute("nick",userL.getNick());
			return "login_correcto";
		}
	}
	@GetMapping("/deslogueo")
	public String cerrarS(Model model,HttpSession session) {
		if(userL != null) {
			userL= null;
			model.addAttribute("sinsesion",true);
			model.addAttribute("sesion",false);
			return "index";
			
		}
		userL= null;
		model.addAttribute("sinsesion",true);
		model.addAttribute("sesion",false);
		return "index";
	}
}
