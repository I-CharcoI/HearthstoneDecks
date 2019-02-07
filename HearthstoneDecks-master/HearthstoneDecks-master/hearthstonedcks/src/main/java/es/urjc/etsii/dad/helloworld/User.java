package es.urjc.etsii.dad.helloworld;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	private String nombre;
	private String correo;
	private String contrasenia;
	private Date fechanac;
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id_user;
	
}
