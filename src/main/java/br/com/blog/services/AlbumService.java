package br.com.blog.services;

import br.com.blog.commons.services.IBaseService;
import br.com.blog.entities.Album;
import br.com.blog.repositories.AlbumRepository;

public interface AlbumService extends IBaseService<Album, Long, AlbumRepository> {
}
