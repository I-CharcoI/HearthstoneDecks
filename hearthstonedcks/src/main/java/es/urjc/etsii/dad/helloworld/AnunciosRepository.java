package es.urjc.etsii.dad.helloworld;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnunciosRepository extends JpaRepository<Anuncios,Long>{

	Page<Anuncios>findByTitulo(String titulo,Pageable page);
	Page<Anuncios>findByContenido(String contenido,Pageable page);
	Page<Anuncios>findByFechaCreacion(String fechaAnuncio,Pageable page);
	
}
