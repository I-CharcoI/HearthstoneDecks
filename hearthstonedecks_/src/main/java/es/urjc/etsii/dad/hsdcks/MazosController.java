package es.urjc.etsii.dad.hsdcks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.springframework.data.util.Pair;
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
public class MazosController {

	private User user;

	@Autowired
	private MazosRepository repository;

	@PostConstruct
	public void init() {

		List<Cartas> cartas = new ArrayList<>();
		
	repository.save(new Mazos("Mazo1","Pepe",30,("Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario "),(" Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario ")));
	
	repository.save(new Mazos("Mazo2","Antonia",0,("Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario "),(" Abisario "+" Abisario "+" Abisario "+" Abisario "+" Abisario ")));
	
	}
	
	@RequestMapping("/mazo")
	public String mazos(Model model,HttpSession session) {

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
        
    	return "redirect:/mazo";
    }
}