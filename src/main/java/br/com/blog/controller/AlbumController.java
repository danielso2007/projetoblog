package br.com.blog.controller;

import br.com.blog.commons.controller.IBaseController;
import br.com.blog.dto.AlbumDTO;
import br.com.blog.entities.Album;
import br.com.blog.repositories.AlbumRepository;
import br.com.blog.services.AlbumService;

public interface AlbumController extends IBaseController<Album, AlbumDTO, Long, AlbumRepository, AlbumService> {

}
