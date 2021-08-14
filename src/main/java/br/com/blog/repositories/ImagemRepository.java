package br.com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.entities.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {

}
