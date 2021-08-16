package br.com.blog.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.controller.FotoController;
import br.com.blog.dto.FotoDTO;
import br.com.blog.entities.Foto;
import br.com.blog.mapper.FotoMapper;
import br.com.blog.repositories.FotoRepository;
import br.com.blog.services.FotoService;

@RestController
public class FotoControllerImpl extends BaseController<Foto, FotoDTO, Long, FotoRepository, FotoService> implements FotoController {

	@Autowired
	FotoMapper mapper;

	@Autowired
	protected FotoControllerImpl(FotoService service) {
		super(service);
	}

	@Override
	public FotoDTO toDto(Foto entity) {
		return mapper.toDTO(entity);
	}

	@Override
	public List<FotoDTO> toDto(List<Foto> list) {
		return list.stream().map(v -> mapper.toDTO(v)).collect(Collectors.toList());
	}

	@Override
	public Foto toEntity(FotoDTO dto) {
		return mapper.toEntity(dto);
	}

}
