package br.com.blog.controller;

import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.FotoDTO;
import br.com.blog.entities.Foto;
import br.com.blog.repositories.FotoRepository;
import br.com.blog.services.FotoService;

public interface FotoController extends IBaseController<Foto, FotoDTO, Long, FotoRepository, FotoService> {

}
