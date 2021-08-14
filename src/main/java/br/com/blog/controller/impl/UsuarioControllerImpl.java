package br.com.blog.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.dto.UsuarioDTO;
import br.com.blog.entities.Usuario;
import br.com.blog.mapper.UsuarioMapper;
import br.com.blog.repositories.UsuarioRepository;
import br.com.blog.services.UsuarioService;

public class UsuarioControllerImpl extends BaseController<Usuario, UsuarioDTO, Long, UsuarioRepository, UsuarioService> {

	@Autowired
	UsuarioMapper mapper;

	@Autowired
	protected UsuarioControllerImpl(UsuarioService service) {
		super(service);
	}

	@Override
	public UsuarioDTO toDto(Usuario entity) {
		return null;
	}

	@Override
	public List<UsuarioDTO> toDto(List<Usuario> list) {
		return null;
	}

	@Override
	public Usuario toEntity(UsuarioDTO dto) {
		return null;
	}

}
