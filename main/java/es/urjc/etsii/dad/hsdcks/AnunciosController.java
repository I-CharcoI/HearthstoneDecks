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
public class AnunciosController {

	@Autowired
	private AnunciosRepository repository;
/**	
	@PostConstruct
	public void init() {
		this.userL = null;
		repository.save(new Anuncios("Anuncio1", "este es el primer anuncio que hago jajajaja", "20 de febrero"));
		repository.save(new Anuncios("Anuncio2", "este es el segundo anuncio blablabla blabla blabla blabla bla blabla blabla blabla ", "2 de mayo"));
	}
**/
	@RequestMapping("/anunci")
	public String anuncio(Model model,HttpServletRequest request,HttpSession session) {
		//recuperamos la autenticacion del usurio
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
				model.addAttribute("anuncio", repository.findAll());
				CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
				model.addAttribute("token", token.getToken());
		return "anuncios";
	}
	
	 @GetMapping("/publicar")
	 public Collection<Anuncios> anuncios(Model model,HttpServletRequest request) {
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
		 return repository.findAll();
    }
	 @PostMapping("/publicar")
	 public String nuevoAnuncio(@RequestParam Map<String, String> allRequestParams,Model model,HttpServletRequest request ) {
		 CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
			model.addAttribute("token", token.getToken());
			String titulo = allRequestParams.get("titulo");
	         String contenido = allRequestParams.get("contenido");
	         String fechaAnuncio = allRequestParams.get("fechaAnuncio");
			repository.save(new Anuncios(titulo,contenido,fechaAnuncio));
			return "anunci";
	 }

   /** @PostMapping(value = {"/anuncio"})
    public String nuevoAnuncio( @RequestParam Map<String, String> allRequestParams,HttpServletRequest request,Model model) {
    	
    	String titulo = allRequestParams.get("titulo");
         String contenido = allRequestParams.get("contenido");
         String fechaAnuncio = allRequestParams.get("fechaAnuncio");
         CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
    	repository.save(new Anuncios(titulo,contenido,fechaAnuncio));
        
    	return "redirect:/anunci";
    }
	**/
/*	public String showItem(Model ..., long id) {
		Item i = repo.findById(id).ortlseThrow(
				()-> new EntityNotFound("id no encontrado" +id));
	}
*/
}