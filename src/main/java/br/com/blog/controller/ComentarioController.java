package br.com.blog.controller;

import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.blog.commons.Constants;
import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.ComentarioDTO;
import br.com.blog.entities.Comentario;
import br.com.blog.repositories.ComentarioRepository;
import br.com.blog.services.ComentarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@ExposesResourceFor(Comentario.class)
@RequestMapping(Constants.COMENTARIO)
@Tag(name = "Comentário", description = "Os comentário de um post")
@SecurityRequirement(name = "ProjetoBlogAPI")
public interface ComentarioController extends IBaseController<Comentario, ComentarioDTO, Long, ComentarioRepository, ComentarioService> {

}
