package br.com.blog.repositories;

import org.springframework.stereotype.Repository;

import br.com.blog.commons.repositories.IBaseRepository;
import br.com.blog.entities.Perfil;
import br.com.blog.enumerator.Roles;

@Repository
public interface PerfilRepository extends IBaseRepository<Perfil, Long> {

	Perfil findByRole(Roles user);

}
