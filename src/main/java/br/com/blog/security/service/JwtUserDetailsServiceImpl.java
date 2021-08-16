package br.com.blog.security.service;

import java.util.Optional;

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

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> user = usuarioService.findByEmail(email);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("Nenhum usuário encontrado");
		} else {
			return JwtUserFactory.create(user.get());
		}
	}

}
