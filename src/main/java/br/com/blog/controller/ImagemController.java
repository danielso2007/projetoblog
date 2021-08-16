package br.com.blog.controller;

import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.blog.commons.Constants;
import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.ImagemDTO;
import br.com.blog.entities.Imagem;
import br.com.blog.repositories.ImagemRepository;
import br.com.blog.services.ImagemService;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@ExposesResourceFor(Imagem.class)
@RequestMapping(Constants.IMAGEM)
@Tag(name = "Imagens", description = "As imagens de um post")
public interface ImagemController extends IBaseController<Imagem, ImagemDTO, Long, ImagemRepository, ImagemService> {

}
