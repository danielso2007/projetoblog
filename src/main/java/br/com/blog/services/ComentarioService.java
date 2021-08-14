package br.com.blog.services;

import br.com.blog.commons.services.IBaseService;
import br.com.blog.entities.Comentario;
import br.com.blog.repositories.ComentarioRepository;

public interface ComentarioService extends IBaseService<Comentario, Long, ComentarioRepository> {
}
