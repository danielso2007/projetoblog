package br.com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.entities.Foto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

}
