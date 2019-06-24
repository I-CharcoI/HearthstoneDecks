package es.urjc.etsii.dad.hsdcks;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;

@CacheConfig(cacheNames="BDHSD")
public interface NoticiasRepository extends JpaRepository<Noticias,Long>{

}