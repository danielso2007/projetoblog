package br.com.blog.repositories;

import org.springframework.stereotype.Repository;

import br.com.blog.entities.Usuario;

@Repository
public interface UsuarioRepository extends IBaseRepository<Usuario, Long> {

}
