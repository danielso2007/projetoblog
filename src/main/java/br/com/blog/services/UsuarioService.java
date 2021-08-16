package br.com.blog.services;

import java.util.Optional;

import br.com.blog.commons.services.IBaseService;
import br.com.blog.dto.UsuarioDTO;
import br.com.blog.entities.Usuario;
import br.com.blog.repositories.UsuarioRepository;

public interface UsuarioService extends IBaseService<Usuario, Long, UsuarioRepository> {

	Optional<Usuario> findByEmail(String email);

	void criarNovoUsuario(UsuarioDTO usuarioDTO);
}
