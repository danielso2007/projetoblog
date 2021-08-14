package br.com.blog.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.blog.commons.controller.impl.BaseController;
import br.com.blog.dto.LinkDTO;
import br.com.blog.entities.Link;
import br.com.blog.mapper.LinkMapper;
import br.com.blog.repositories.LinkRepository;
import br.com.blog.services.LinkService;

public class LinkControllerImpl extends BaseController<Link, LinkDTO, Long, LinkRepository, LinkService> {

	@Autowired
	LinkMapper mapper;

	@Autowired
	protected LinkControllerImpl(LinkService service) {
		super(service);
	}

	@Override
	public LinkDTO toDto(Link entity) {
		return null;
	}

	@Override
	public List<LinkDTO> toDto(List<Link> list) {
		return null;
	}

	@Override
	public Link toEntity(LinkDTO dto) {
		return null;
	}

}
