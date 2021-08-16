package br.com.blog.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.blog.entities.Perfil;
import br.com.blog.entities.Usuario;

public class JwtUserFactory {

	private JwtUserFactory() {
	}
	
	public static JwtUser create(Usuario user) {
		return new JwtUser(user.getId(), user.getNome(), user.getEmail(), user.getSenha(), user.isEnabled(), mapToGrantedAuthorities(user.getPerfis()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Perfil> list) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		list.forEach(perfil -> authorities.add(new SimpleGrantedAuthority(perfil.toString())));
		return authorities;
	}
	
}
