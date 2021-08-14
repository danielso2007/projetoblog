package br.com.blog.controller;

import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.ComentarioDTO;
import br.com.blog.entities.Comentario;
import br.com.blog.repositories.ComentarioRepository;
import br.com.blog.services.ComentarioService;

public interface ComentarioController extends IBaseController<Comentario, ComentarioDTO, Long, ComentarioRepository, ComentarioService> {

}
