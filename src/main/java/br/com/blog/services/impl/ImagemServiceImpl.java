package br.com.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.blog.commons.services.impl.BaseService;
import br.com.blog.entities.Imagem;
import br.com.blog.repositories.ImagemRepository;
import br.com.blog.services.ImagemService;

public class ImagemServiceImpl extends BaseService<Imagem, Long, ImagemRepository> implements ImagemService {

	@Autowired
	public ImagemServiceImpl(ImagemRepository repository) {
		super(repository);
	}

}
