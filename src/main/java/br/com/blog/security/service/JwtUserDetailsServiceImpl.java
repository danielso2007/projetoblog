package br.com.blog.security.service;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.blog.entities.Usuario;
import br.com.blog.security.jwt.JwtUserFactory;
import br.com.blog.services.UsuarioService;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

	private static final Log logger = LogFactory.getLog(JwtUserDetailsServiceImpl.class);

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> user = usuarioService.findByEmail(email);
		if (user.isEmpty()) {
			String msg = String.format("Nenhum usuário encontrado com username '%s'", email);
			logger.error(msg);
			throw new UsernameNotFoundException(msg);
		} else {
			return JwtUserFactory.create(user.get());
		}
	}

}
