package br.com.blog.controller;

import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.ImagemDTO;
import br.com.blog.entities.Imagem;
import br.com.blog.repositories.ImagemRepository;
import br.com.blog.services.ImagemService;

public interface ImagemController extends IBaseController<Imagem, ImagemDTO, Long, ImagemRepository, ImagemService> {

}
