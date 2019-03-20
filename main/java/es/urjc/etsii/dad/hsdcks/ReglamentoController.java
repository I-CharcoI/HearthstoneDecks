package es.urjc.etsii.dad.hsdcks;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReglamentoController {

	@Autowired
	private NoticiasRepository repository;
	private User userL;
	/*
	@PostConstruct
	public void init() {
		//this.userL = null;
		
	}
	*/
	@RequestMapping("/reglas")
	public String noticia(Model model,HttpSession session) {
		if(userL ==null) {
			model.addAttribute("sinsesion",true);
			model.addAttribute("sesion",false);
		
		}
		else {
			model.addAttribute("sinsesion",false);
			model.addAttribute("sesion", true);
			model.addAttribute("nick",userL.getNick());
			
		}
		return "reglamento";
	}
	
}