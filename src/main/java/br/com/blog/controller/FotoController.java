package br.com.blog.controller;

import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.blog.commons.Constants;
import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.FotoDTO;
import br.com.blog.entities.Foto;
import br.com.blog.repositories.FotoRepository;
import br.com.blog.services.FotoService;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@ExposesResourceFor(Foto.class)
@RequestMapping(Constants.FOTO)
@Tag(name = "Foto", description = "As foto de um álbum de um usuário.")
public interface FotoController extends IBaseController<Foto, FotoDTO, Long, FotoRepository, FotoService> {

}
