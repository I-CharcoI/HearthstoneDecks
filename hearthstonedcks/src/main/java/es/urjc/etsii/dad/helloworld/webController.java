package es.urjc.etsii.dad.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class webController {

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
}
