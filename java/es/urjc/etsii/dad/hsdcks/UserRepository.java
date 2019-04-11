package es.urjc.etsii.dad.hsdcks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User,Long>,CrudRepository<User,Long> {

	User findByNick(String nick);
	List<User> findByCorreo(String correo);
	User findByNickAndContrasenia(String nick,String contrasenia);
	
}