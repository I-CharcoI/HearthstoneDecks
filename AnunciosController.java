package es.urjc.etsii.dad.hsdcks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
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
public class AnunciosController {
 private User userL;
	@Autowired
	private AnunciosRepository repository;
	
	@PostConstruct
	public void init() {
		this.userL = null;
		repository.save(new Anuncios("Anuncio1", "este es el primer anuncio que hago jajajaja", "20 de febrero"));
		repository.save(new Anuncios("Anuncio2", "este es el segundo anuncio blablabla blabla blabla blabla bla blabla blabla blabla ", "2 de mayo"));
	}

	@RequestMapping("/anunci")
	public String anuncio(Model model,HttpSession session) {
		if(userL ==null) {
			model.addAttribute("sinsesion",true);
			model.addAttribute("sesion",false);
		
		}
		else {
			model.addAttribute("sinsesion",false);
			model.addAttribute("sesion", true);
			model.addAttribute("nick",userL.getNick());
			
		}
		model.addAttribute("anuncio", repository.findAll());

		return "anuncios";
	}
	
	 @GetMapping(value = "/anuncio")
	 public Collection<Anuncios> anuncios() {
		 return repository.findAll();
    }

    @PostMapping(value = {"/anuncio"})
    public String nuevoAnuncio( @RequestParam Map<String, String> allRequestParams) {
    	 String titulo = allRequestParams.get("titulo");
         String contenido = allRequestParams.get("contenido");
         String fechaAnuncio = allRequestParams.get("fechaAnuncio");
    	repository.save(new Anuncios(titulo,contenido,fechaAnuncio));
    	
    	int numeroPuerto = 5555;
		String email = "anahj97@gmail.com";
		
		try {
			Socket socket = new Socket(InetAddress.getLocalHost(),numeroPuerto);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
			
			pw.println(email);
			
			br.close();
			pw.close();
			socket.close();
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	return "redirect:/anunci";
    }
	
/*	public String showItem(Model ..., long id) {
		Item i = repo.findById(id).ortlseThrow(
				()-> new EntityNotFound("id no encontrado" +id));
	}
*/
    
   
}