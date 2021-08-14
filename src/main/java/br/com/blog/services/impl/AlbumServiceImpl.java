package br.com.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.blog.commons.services.impl.BaseService;
import br.com.blog.entities.Album;
import br.com.blog.repositories.AlbumRepository;
import br.com.blog.services.AlbumService;

public class AlbumServiceImpl extends BaseService<Album, Long, AlbumRepository> implements AlbumService {

	@Autowired
	public AlbumServiceImpl(AlbumRepository repository) {
		super(repository);
	}

}
