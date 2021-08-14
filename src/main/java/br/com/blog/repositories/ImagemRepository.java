package br.com.blog.repositories;

import org.springframework.stereotype.Repository;

import br.com.blog.entities.Imagem;

@Repository
public interface ImagemRepository extends IBaseRepository<Imagem, Long> {

}
