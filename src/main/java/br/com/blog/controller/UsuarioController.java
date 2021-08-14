package br.com.blog.controller;

import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.UsuarioDTO;
import br.com.blog.entities.Usuario;
import br.com.blog.repositories.UsuarioRepository;
import br.com.blog.services.UsuarioService;

public interface UsuarioController extends IBaseController<Usuario, UsuarioDTO, Long, UsuarioRepository, UsuarioService> {

}
