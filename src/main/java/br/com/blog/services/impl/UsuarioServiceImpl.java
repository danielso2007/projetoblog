package br.com.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.blog.commons.services.impl.BaseService;
import br.com.blog.entities.Usuario;
import br.com.blog.repositories.UsuarioRepository;
import br.com.blog.services.UsuarioService;

public class UsuarioServiceImpl extends BaseService<Usuario, Long, UsuarioRepository> implements UsuarioService {

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		super(repository);
	}

}
