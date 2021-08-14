package br.com.blog.services;

import br.com.blog.commons.services.IBaseService;
import br.com.blog.entities.Usuario;
import br.com.blog.repositories.UsuarioRepository;

public interface UsuarioService extends IBaseService<Usuario, Long, UsuarioRepository> {
}
