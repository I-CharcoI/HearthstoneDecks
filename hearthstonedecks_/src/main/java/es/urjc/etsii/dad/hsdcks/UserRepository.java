package es.urjc.etsii.dad.hsdcks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

	List<User> findByNick(String nick);
	List<User> findByCorreo(String correo);
	User findByNickAndContrasenia(String nick,String contrasenia);
	
}