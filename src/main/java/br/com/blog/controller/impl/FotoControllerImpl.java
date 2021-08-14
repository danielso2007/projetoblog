package br.com.blog.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.dto.FotoDTO;
import br.com.blog.entities.Foto;
import br.com.blog.mapper.FotoMapper;
import br.com.blog.repositories.FotoRepository;
import br.com.blog.services.FotoService;

public class FotoControllerImpl extends BaseController<Foto, FotoDTO, Long, FotoRepository, FotoService> {

	@Autowired
	FotoMapper mapper;

	@Autowired
	protected FotoControllerImpl(FotoService service) {
		super(service);
	}

	@Override
	public FotoDTO toDto(Foto entity) {
		return null;
	}

	@Override
	public List<FotoDTO> toDto(List<Foto> list) {
		return null;
	}

	@Override
	public Foto toEntity(FotoDTO dto) {
		return null;
	}

}
