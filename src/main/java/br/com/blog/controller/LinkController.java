package br.com.blog.controller;

import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.LinkDTO;
import br.com.blog.entities.Link;
import br.com.blog.repositories.LinkRepository;
import br.com.blog.services.LinkService;

public interface LinkController extends IBaseController<Link, LinkDTO, Long, LinkRepository, LinkService> {

}
