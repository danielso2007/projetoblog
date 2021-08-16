package br.com.blog.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.controller.AlbumController;
import br.com.blog.dto.AlbumDTO;
import br.com.blog.entities.Album;
import br.com.blog.mapper.AlbumMapper;
import br.com.blog.repositories.AlbumRepository;
import br.com.blog.services.AlbumService;

@RestController
public class AlbumControllerImpl extends BaseController<Album, AlbumDTO, Long, AlbumRepository, AlbumService> implements AlbumController {

	@Autowired
	AlbumMapper mapper;

	@Autowired
	protected AlbumControllerImpl(AlbumService service) {
		super(service);
	}

	@Override
	public AlbumDTO toDto(Album entity) {
		return mapper.toDTO(entity);
	}

	@Override
	public List<AlbumDTO> toDto(List<Album> list) {
		return list.stream().map(v -> mapper.toDTO(v)).collect(Collectors.toList());
	}

	@Override
	public Album toEntity(AlbumDTO dto) {
		return mapper.toEntity(dto);
	}

}
