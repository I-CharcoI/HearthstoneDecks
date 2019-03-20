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
public class NoticiasController {

	@Autowired
	private NoticiasRepository repository;
	
	
	/**@PostConstruct
	public void init() {
		this.userL = null;
		repository.save(new Noticias("Noticia1", "este es el primera noticia que hago jajajaja", "4 de mayo"));
		repository.save(new Noticias("Noticia2", "esta es la segunda noticia bla bla bla blablabla blabla blabla bla blabla blabla blabla blabla", "01/01/0001"));
	}
	**/
	@RequestMapping("/notici")
	public String noticia(Model model,HttpServletRequest request,HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = auth.getName();
		session.setAttribute("nick",currentPrincipalName);
		boolean sinsesion = true;
		if(currentPrincipalName !="anonymousUser") {
			sinsesion = false;
		}
		model.addAttribute("sinsesion",sinsesion);
		model.addAttribute("user",request.isUserInRole("USER"));
		model.addAttribute("admin",request.isUserInRole("ADMIN"));
		model.addAttribute("nick", currentPrincipalName);
		model.addAttribute("noti", repository.findAll());
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		

		return "noticias";
	}
	 @GetMapping("/publicarN")
	 public Collection<Noticias> noticias(Model model,HttpServletRequest request) {
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
		 return repository.findAll();
    }

    @PostMapping("/publicarN")
    public String nuevaNoticia(Model model,@RequestParam Map<String, String> allRequestParams,HttpSession session,HttpServletRequest request) {
    	 String titulo = allRequestParams.get("titulo");
         String contenido = allRequestParams.get("contenido");
         String fechaNoticia = allRequestParams.get("fechaNoticia");
    	CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		repository.save(new Noticias(titulo,contenido,fechaNoticia));
    	return "noticias";
    }
	@RequestMapping("/indexx")
	public String notindex(Model model,HttpSession session) {

		model.addAttribute("noindex", repository.findAll());

		return "index";
	}
	

}