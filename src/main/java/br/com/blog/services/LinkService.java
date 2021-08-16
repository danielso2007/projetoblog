package br.com.blog.services;

import br.com.blog.commons.services.IBaseService;
import br.com.blog.entities.Link;
import br.com.blog.repositories.LinkRepository;

public interface LinkService extends IBaseService<Link, Long, LinkRepository> {
}
