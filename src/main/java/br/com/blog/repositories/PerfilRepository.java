package br.com.blog.repositories;

import org.springframework.stereotype.Repository;

import br.com.blog.entities.Perfil;

@Repository
public interface PerfilRepository extends IBaseRepository<Perfil, Long> {

}
