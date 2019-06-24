package es.urjc.etsii.dad.hsdcks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.data.util.Pair;


import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class MazosController {

	@Value("${serviciointerno}")
	private String serviciointernourl;

	@Autowired
	private MazosRepository repository;
	
	@Autowired
	private UserRepository URep;
	

	/**@PostConstruct
	public void init() {
    this.userL = null;
		List<Cartas> cartas = new ArrayList<>();
		
	repository.save(new Mazos("Mazo1","Pepe",30,("Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario "),(" Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario ")));
	
	repository.save(new Mazos("Mazo2","Antonia",0,("Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario "),(" Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario ")));
	
	}
	**/
	@RequestMapping("/mazo")
	public String mazos(Model model,HttpSession session, HttpServletRequest request) {
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
		model.addAttribute("mazoss", repository.findAll());

		return "mazos";
	}
	
	
	
	@RequestMapping("/aniadircartas")
	public String mazo(Model model,HttpSession session) {

		model.addAttribute("carta", repository.findAll());

		return "redirect:/aniadircartas";
	}

/*	@GetMapping(value = "/CRMazos")
	 public Collection<Mazos> mazos() {
		 return repository.findAll();
   }
*/


    

	@PostMapping(value = {"/aniadircartas"})
    public String nuevoMazo2(@RequestParam Map<String, String> allRequestParams,HttpSession session) {
    	 String nombre = allRequestParams.get("nombre");
         String creador = allRequestParams.get("creador");
         Integer votos = Integer.parseInt(allRequestParams.get("votos"));
         String mazo1 = ("1: "+allRequestParams.get("carta1")+", "+
        		 "2: "+allRequestParams.get("carta2")+", " +		
        		 "3: "+allRequestParams.get("carta3")+", "+			
        		 "4: "+allRequestParams.get("carta4")+", "+			
        		 "5: "+allRequestParams.get("carta5"));	
        
         String mazo2 = ("6: "+allRequestParams.get("carta6")+", "+
        		 "7: "+allRequestParams.get("carta7")+", "+
        		 "8: "+allRequestParams.get("carta8")+", "+
        		 "9: "+allRequestParams.get("carta9")+", "+
        		 "10: "+allRequestParams.get("carta10"));
         
    	repository.save(new Mazos(nombre,creador,votos,mazo1,mazo2));

		//String url = "http://localhost:8070/mail/";
		List<User> usuarios = new ArrayList<User>();
    	usuarios=URep.findAll();
    	Iterator it = usuarios.iterator();
    	String url = "http://"+serviciointernourl+":8070/mail/";
    	while (it.hasNext()) {

    		User usuario = (User) it.next();
    		String correo = usuario.getCorreo();
    		String nick = usuario.getNick();
    		Email nuevoEmail = new Email(nick, correo);
    		RestTemplate rest = new RestTemplate();
    		rest.postForEntity(url, nuevoEmail, String.class);
    		
    
		}
		
    	return "redirect:/mazo";
    }
}