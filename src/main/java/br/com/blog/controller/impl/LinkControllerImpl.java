package br.com.blog.controller.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.controller.LinkController;
import br.com.blog.dto.LinkDTO;
import br.com.blog.entities.Link;
import br.com.blog.mapper.LinkMapper;
import br.com.blog.repositories.LinkRepository;
import br.com.blog.services.LinkService;

@RestController
public class LinkControllerImpl extends BaseController<Link, LinkDTO, Long, LinkRepository, LinkService> implements LinkController {

	@Autowired
	LinkMapper mapper;

	@Autowired
	protected LinkControllerImpl(LinkService service) {
		super(service);
	}

	@Override
	public LinkDTO toDto(Link entity) {
		return mapper.toDTO(entity);
	}

	@Override
	public List<LinkDTO> toDto(List<Link> list) {
		return list.stream().map(v -> mapper.toDTO(v)).collect(Collectors.toList());
	}

	@Override
	public Link toEntity(LinkDTO dto) {
		return mapper.toEntity(dto);
	}

}
