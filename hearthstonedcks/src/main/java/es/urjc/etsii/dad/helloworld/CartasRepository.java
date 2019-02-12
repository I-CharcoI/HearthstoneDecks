package es.urjc.etsii.dad.helloworld;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartasRepository extends JpaRepository<Cartas,Long> {

	List<Cartas> findByNombre(String nombre);
	List<Cartas> findByClase(String clase);
	List<Cartas> findByExpansion(String expansion);
	List<Cartas> findByCoste(int coste);
	List<Cartas> findByRareza(String rareza);
	List<Cartas> findByTipo(String tipo);
}
