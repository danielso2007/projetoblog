package br.com.blog.controller;

import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.blog.commons.Constants;
import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.AlbumDTO;
import br.com.blog.entities.Album;
import br.com.blog.repositories.AlbumRepository;
import br.com.blog.services.AlbumService;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@ExposesResourceFor(Album.class)
@RequestMapping(Constants.ALBUM)
@Tag(name = "Álbum", description = "Os álbuns de um usuário.")
public interface AlbumController extends IBaseController<Album, AlbumDTO, Long, AlbumRepository, AlbumService> {

}
