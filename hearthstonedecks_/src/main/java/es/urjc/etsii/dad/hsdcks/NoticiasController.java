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
public class NoticiasController {

	@Autowired
	private NoticiasRepository repository;
	private User userL;
	
	@PostConstruct
	public void init() {
		this.userL = null;
		repository.save(new Noticias("Noticia1", "este es el primera noticia que hago jajajaja", "4 de mayo"));
		repository.save(new Noticias("Noticia2", "esta es la segunda noticia bla bla bla blablabla blabla blabla bla blabla blabla blabla blabla", "01/01/0001"));
	}
	
	@RequestMapping("/notici")
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
		model.addAttribute("noti", repository.findAll());

		return "noticias";
	}
	 @GetMapping(value = "/noticia")
	 public Collection<Noticias> noticias() {
		 return repository.findAll();
    }

    @PostMapping(value = {"/noticia"})
    public String nuevaNoticia(@RequestParam Map<String, String> allRequestParams,HttpSession session) {
    	 String titulo = allRequestParams.get("titulo");
         String contenido = allRequestParams.get("contenido");
         String fechaNoticia = allRequestParams.get("fechaNoticia");
    	repository.save(new Noticias(titulo,contenido,fechaNoticia));
        
    	return "redirect:/notici";
    }
	@RequestMapping("/indexx")
	public String notindex(Model model,HttpSession session) {

		model.addAttribute("noindex", repository.findAll());

		return "index";
	}
	

}