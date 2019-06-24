package es.urjc.etsii.dad.hsdcks;

import java.util.List;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

@CacheConfig(cacheNames="BDHSD")
public interface UserRepository extends JpaRepository<User,Long>,CrudRepository<User,Long> {

	@Cacheable
	User findByNick(String nick);
	@Cacheable
	List<User> findByCorreo(String correo);
	@Cacheable
	User findByNickAndContrasenia(String nick,String contrasenia);
	
}