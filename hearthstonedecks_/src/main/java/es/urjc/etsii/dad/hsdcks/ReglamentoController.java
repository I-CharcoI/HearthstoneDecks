package es.urjc.etsii.dad.hsdcks;
import java.util.Collection;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
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
	public String noticia(Model model,HttpSession session, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = auth.getName();
		session.setAttribute("nick",currentPrincipalName);
		boolean sinsesion = true;
		if(currentPrincipalName !="anonymousUser") {
			sinsesion = false;
		}
		model.addAttribute("sinsesion",sinsesion);
		model.addAttribute("user",request.isUserInRole("USER"));
		model.addAttribute("nick", currentPrincipalName);
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		

		return "reglamento";
	}
	
}