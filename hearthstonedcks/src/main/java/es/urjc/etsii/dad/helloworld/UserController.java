package es.urjc.etsii.dad.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpSession;
@Controller
public class UserController {

	@Autowired 
	private UserRepository repository;
	
	//Registro de usuario
	@GetMapping( "/registro")
	public String registrarse(Model model, User user, HttpSession usuario) {
		
		//inicializacion de variables del fomulario
		usuario.setAttribute("nombre", user.getNombre());
		usuario.setAttribute("apellido1", user.getApellido1());
		usuario.setAttribute("apellido2", user.getApellido2());
		usuario.setAttribute("nick", user.getNick());
		usuario.setAttribute("correo", user.getCorreo());
		usuario.setAttribute("contrasenia",user.getContrasenia());
		usuario.setAttribute("fechanac", user.getFechanac());
		usuario.setAttribute("pais", user.getPais());
		
		List<User> usuarios= null;
		
		usuarios = repository.findByNick(user.getNick());
		
		if(usuarios.size()> 0) {
			
			model.addAttribute("error","Error, el nick ya lo tiene otro usuario. Pruebe con otro");
			return "registro";
		}
		
		usuarios= repository.findByCorreo(user.getCorreo());
		
		if(usuarios.size()>0) {
			model.addAttribute("error","Error, el correo ya esta asignado a un usuario. Pruebe con otro");
			return "registro";
		}
		
		//Guardar usuario en la base de datos
		repository.save(new User(user.getNombre(),user.getApellido1(),user.getApellido2(),user.getNick(),user.getCorreo(),user.getContrasenia(),user.getFechanac(),user.getPais()));
		return "index";
	}
	
	//Logueo de una cuenta
	@RequestMapping("/iniciar_sesion")
	public String login_user(Model model, User user,HttpSession usuario) {
		List<User> usuarios = repository.findByNick(user.getNick());
		//si la lista de usuarios no esta vacia se recorre
		if(usuarios.size() > 0) {
			//comprobamos que las contraseñas que pasamos son iguales a la base de datos
			for(int i = 0; i< usuarios.size();i++) {
				if(user.getContrasenia().equals(usuarios.get(i).getContrasenia())) {
					usuario.setAttribute("nick", usuarios.get(i).getNick());
					usuario.setAttribute("contrasenia",usuarios.get(i).getContrasenia());
					
					//
					User newUser=repository.findByNick((String)usuario.getAttribute("nick")).get(0);
					usuario.setAttribute("Usuario", newUser);
					
					model.addAttribute("error", "  ");
				}
			}
		}
		return "index";
	}
}
