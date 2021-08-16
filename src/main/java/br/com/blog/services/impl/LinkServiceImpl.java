package br.com.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.commons.services.impl.BaseService;
import br.com.blog.entities.Link;
import br.com.blog.repositories.LinkRepository;
import br.com.blog.services.LinkService;

@Service
public class LinkServiceImpl extends BaseService<Link, Long, LinkRepository> implements LinkService {

	@Autowired
	public LinkServiceImpl(LinkRepository repository) {
		super(repository);
	}

}
