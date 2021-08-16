package br.com.blog.repositories;

import org.springframework.stereotype.Repository;

import br.com.blog.commons.repositories.IBaseRepository;
import br.com.blog.entities.Comentario;

@Repository
public interface ComentarioRepository extends IBaseRepository<Comentario, Long> {

}
