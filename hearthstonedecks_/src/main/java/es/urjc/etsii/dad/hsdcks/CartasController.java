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
public class CartasController {

	@Autowired
	private CartasRepository repository;
	
	@PostConstruct
	public void init() {

	repository.save(new Cartas("Abisario","Brujo","Basico",1,"Provocar","Basica","Esbirro",1,3,"\"C:\\Users\\Any\\Documents\\3º\\distribuidos\\HearthstoneDecks-master\\HearthstoneDecks-master\\hearthstonedcks\\src\\main\\java\\es\\urjc\\etsii\\dad\\helloworld\\abisario.jpg\""));
	repository.save(new Cartas("Corrupcion","Brujo","Basico",1,"Elige a un esbirro enemigo.Al comienzo de tu turno, lo destruyes","Basica","Hechizo",0,0,"\"/ImagenesCartas/Brujo/corrupcion.jpg\""));
	repository.save(new Cartas("Espiral mortal","Brujo","Basico",1,"Inflige 1 de daño a un esbirro.Si eso lo mata, roba una carta","Basica","Hechizo",0,0,"/ImagenesCartas/brujo/espiralMortal.jpg"));
	repository.save(new Cartas("Fuego de alma","Brujo","Basico",1,"Inflinge 4 de daño.Descarta una carta aleatoria","Basica","Hechizo",0,0,"/ImagenesCartas/brujo/fuegoDeAlma.jpg"));
	repository.save(new Cartas("Sacrificio pactado","Brujo","Basico",0,"Destruye a un demonio. Restaura 5 de salud a tu héroe","Basica","Hechizo",0,0,"/ImagenesCartas/brujo/sacrificioPactado.jpg"));
	repository.save(new Cartas("Diablillo de llamas","Brujo","Clasico",1,"Grito de batalla: Inflinge 3 de daño a tu héroe","Común","Esbirro",3,2,"/ImagenesCartas/brujo/diablilloDeLlamas.jpg"));
	repository.save(new Cartas("Fuego demoníaco","Brujo","Clasico",2,"Inflige 2 de daño. Si el objetivo es un demonio amistoso, en lugar de dañarlo le otorga +2/+2","Común","Hechizo",0,0,"/ImagenesCartas/brujo/fuegoDemoniaco.jpg"));
	repository.save(new Cartas("Llama de las sombras","Brujo","Clasico",4,"Destruye un esbirro amistoso e inflinge un daño equivalente a su ataque a todos los esbirros enemigos","Poco común","Hechizo",0,0,"/ImagenesCartas/brujo/llamaDeLasSombras.jpg"));
	repository.save(new Cartas("Terror del vacio","Brujo","Clasico",3,"Grito de batalla: Destruye a los esbirros adyacentes y obtiene su ataque y salud","Poco común","Esbirro",3,3,"/ImagenesCartas/brujo/terrorDelVacio.jpg"));
	repository.save(new Cartas("Vacío abisal","Brujo","Clasico",8,"Destruye a todos los esbirros","Épica","Hechizo",0,0,"/ImagenesCartas/brujo/vacioAbisal.jpg"));
	repository.save(new Cartas("Lord Jaraxxus","Brujo","Clasico",9,"Grito de batalla: Destruye a tu héroe y lo reemplaza con Lord Jaraxxus","Legendaria","Esbirro",3,15,"/ImagenesCartas/brujo/lordJaraxxus.jpg"));



	}

	@RequestMapping("/carta")
	public String anuncio(Model model,HttpSession session) {

		model.addAttribute("carta", repository.findAll());

		return "cartas";
	}
	
	@RequestMapping("/crmazo")
	public String crmazos(Model model,HttpSession session) {

		model.addAttribute("carta", repository.findAll());

		return "crearMazo";
	}
	
	 @GetMapping(value = "/cartas")
	 public Collection<Cartas> cartas() {
		 return repository.findAll();
    }
	
	 @PostMapping(value = {"/cartas"})
	    public String nuevaCarta(@RequestParam Map<String, String> allRequestParams,HttpSession session) {
	    	 String nombre = allRequestParams.get("nombre");
	         String clase = allRequestParams.get("clase");
	         String expansion = allRequestParams.get("expansion");
	         Integer coste = Integer.parseInt(allRequestParams.get("coste"));
	         String efecto = allRequestParams.get("efecto");
	         String rareza = allRequestParams.get("rareza");
	         String tipoCarta = allRequestParams.get("tipoCarta");
	         Integer ataque = Integer.parseInt(allRequestParams.get("ataque"));
	         Integer vida = Integer.parseInt(allRequestParams.get("vida"));
	         String imagen = allRequestParams.get("imagen");
	         
	    	repository.save(new Cartas(nombre,clase,expansion,coste,efecto,rareza,tipoCarta,ataque,vida,imagen));
	        
	    	return "redirect:/carta";
	    }

	@RequestMapping("/CRMazos")
	public String mazo(Model model,HttpSession session) {

		model.addAttribute("cartass", repository.findAll());

		return "CRMazo";
	}
}