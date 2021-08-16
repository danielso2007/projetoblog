package br.com.blog.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.controller.ImagemController;
import br.com.blog.dto.ImagemDTO;
import br.com.blog.entities.Imagem;
import br.com.blog.mapper.ImagemMapper;
import br.com.blog.repositories.ImagemRepository;
import br.com.blog.services.ImagemService;

@RestController
public class ImagemControllerImpl extends BaseController<Imagem, ImagemDTO, Long, ImagemRepository, ImagemService> implements ImagemController {

	@Autowired
	ImagemMapper mapper;

	@Autowired
	protected ImagemControllerImpl(ImagemService service) {
		super(service);
	}

	@Override
	public ImagemDTO toDto(Imagem entity) {
		return mapper.toDTO(entity);
	}

	@Override
	public List<ImagemDTO> toDto(List<Imagem> list) {
		return list.stream().map(v -> mapper.toDTO(v)).collect(Collectors.toList());
	}

	@Override
	public Imagem toEntity(ImagemDTO dto) {
		return mapper.toEntity(dto);
	}

}
