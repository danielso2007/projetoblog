package br.com.blog.controller;

import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.blog.commons.Constants;
import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.LinkDTO;
import br.com.blog.entities.Link;
import br.com.blog.repositories.LinkRepository;
import br.com.blog.services.LinkService;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@ExposesResourceFor(Link.class)
@RequestMapping(Constants.LINK)
@Tag(name = "Link", description = "Os links de um comentário.")
public interface LinkController extends IBaseController<Link, LinkDTO, Long, LinkRepository, LinkService> {

}
