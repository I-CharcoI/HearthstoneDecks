package es.urjc.etsii.dad.hsdcks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;



@Component
public class UserRepositoryAuthenticationProvider implements AuthenticationProvider {

	@Autowired 
	UserRepository repositorioUsuario;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException{
		User user = repositorioUsuario.findByNick(auth.getName());
		
		if(user==null) {
			throw new BadCredentialsException("Error,El usuario no ha sido encontrado");
		}
		
		String passw =(String)auth.getCredentials();
		//Comprobacion de encriptacion de la contraseña
		if(!new BCryptPasswordEncoder().matches(passw,user.getContrasenia())) {
			throw new BadCredentialsException("Error, la contraseña es erronea");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		for(String rol: user.getRoles()) {
			roles.add(new SimpleGrantedAuthority(rol));
		}
		return new UsernamePasswordAuthenticationToken(user.getNick(),passw,roles);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

	
}
