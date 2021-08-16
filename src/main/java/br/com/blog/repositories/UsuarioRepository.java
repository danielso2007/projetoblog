package br.com.blog.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.blog.commons.repositories.IBaseRepository;
import br.com.blog.entities.Usuario;

@Repository
public interface UsuarioRepository extends IBaseRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	long countByEmail(String email);
	
}
