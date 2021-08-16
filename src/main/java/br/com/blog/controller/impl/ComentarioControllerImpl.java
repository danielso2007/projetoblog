package br.com.blog.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.controller.ComentarioController;
import br.com.blog.dto.ComentarioDTO;
import br.com.blog.entities.Comentario;
import br.com.blog.mapper.ComentarioMapper;
import br.com.blog.repositories.ComentarioRepository;
import br.com.blog.services.ComentarioService;

@RestController
public class ComentarioControllerImpl extends BaseController<Comentario, ComentarioDTO, Long, ComentarioRepository, ComentarioService> implements ComentarioController {

	@Autowired
	ComentarioMapper mapper;

	@Autowired
	protected ComentarioControllerImpl(ComentarioService service) {
		super(service);
	}

	@Override
	public ComentarioDTO toDto(Comentario entity) {
		return null;
	}

	@Override
	public List<ComentarioDTO> toDto(List<Comentario> list) {
		return null;
	}

	@Override
	public Comentario toEntity(ComentarioDTO dto) {
		return null;
	}

}
