package es.urjc.etsii.dad.helloworld;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

	List<User> findByNick(String nick);
	List<User> findByCorreo(String correo);
	List<User> findByContrasenia(String contrasenia);
	
}