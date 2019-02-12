package es.urjc.etsii.dad.helloworld;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

	List<User>findByCorreo(String correo);
	List<User>finByNick(String nick);
	List<User>findByContrasenia(String contrasenia);
	List<User>findByNickAndContrasenia(String nick, String contrasenia);
	List<User>findByCorreoAndContrasenia(String correo,String contrasenia);
	List<User>findByNickOrCorreo(String nick, String correo);
	
}
