package br.com.blog.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.dto.AlbumDTO;
import br.com.blog.entities.Album;
import br.com.blog.mapper.AlbumMapper;
import br.com.blog.repositories.AlbumRepository;
import br.com.blog.services.AlbumService;

public class AlbumControllerImpl extends BaseController<Album, AlbumDTO, Long, AlbumRepository, AlbumService> {

	@Autowired
	AlbumMapper mapper;

	@Autowired
	protected AlbumControllerImpl(AlbumService service) {
		super(service);
	}

	@Override
	public AlbumDTO toDto(Album entity) {
		return null;
	}

	@Override
	public List<AlbumDTO> toDto(List<Album> list) {
		return null;
	}

	@Override
	public Album toEntity(AlbumDTO dto) {
		return null;
	}

}
