package es.urjc.etsii.dad.hsdcks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled= true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserRepositoryAuthenticationProvider userrepository;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//Paginas publicas
		http.authorizeRequests().antMatchers("/").permitAll();
		http.authorizeRequests().antMatchers("/notici").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/reglas").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/logearse").permitAll();
		http.authorizeRequests().antMatchers("/anunci").permitAll();
		http.authorizeRequests().antMatchers("/mazos").permitAll();
		
		//paginas privadas
		//La parte de deslogeo solo sea visible para los usuarios logeados
		http.authorizeRequests().antMatchers("/deslogueo").hasAnyRole("USER");
		//Crear un mazo solo lo puede hacer los usuarios logeados
		http.authorizeRequests().antMatchers("/crmazo").hasAnyRole("USER");
		//Crear noticias si eres admin
		http.authorizeRequests().antMatchers("/publicarN.html").hasAnyRole("ADMIN");
		//Publicar una nueva carta lo relaiza solamente el admin
		http.authorizeRequests().antMatchers("/nuevaCarta.html").hasAnyRole("ADMIN");
		//Publicar un anuncio lo realiza un usuario logeado
		http.authorizeRequests().antMatchers("/publicar.html").hasAnyRole("USER");
		//falta perfil.
		
		//Formularios login
		http.formLogin().loginPage("/logearse");
		http.formLogin().usernameParameter("nick");
		http.formLogin().passwordParameter("contrasenia");
		http.formLogin().defaultSuccessUrl("/");
		http.formLogin().failureUrl("/login_incorrecto");
		
		//Deslogeo
		http.logout().logoutUrl("/deslogueo");
		http.logout().logoutSuccessUrl("/deslogeo_correcto");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(userrepository);
	}

}
