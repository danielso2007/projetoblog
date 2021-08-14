package br.com.blog.repositories;

import org.springframework.stereotype.Repository;

import br.com.blog.commons.repositories.IBaseRepository;
import br.com.blog.commons.repositories.IBaseRepository;
import br.com.blog.entities.Foto;

@Repository
public interface FotoRepository extends IBaseRepository<Foto, Long> {

}
