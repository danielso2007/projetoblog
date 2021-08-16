package br.com.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.commons.services.impl.BaseService;
import br.com.blog.entities.Comentario;
import br.com.blog.repositories.ComentarioRepository;
import br.com.blog.services.ComentarioService;

@Service
public class ComentarioServiceImpl extends BaseService<Comentario, Long, ComentarioRepository> implements ComentarioService {

	@Autowired
	public ComentarioServiceImpl(ComentarioRepository repository) {
		super(repository);
	}

}
