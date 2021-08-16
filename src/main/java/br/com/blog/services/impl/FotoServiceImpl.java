package br.com.blog.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.commons.services.impl.BaseService;
import br.com.blog.entities.Foto;
import br.com.blog.repositories.FotoRepository;
import br.com.blog.services.FotoService;

@Service
public class FotoServiceImpl extends BaseService<Foto, Long, FotoRepository> implements FotoService {

	@Autowired
	public FotoServiceImpl(FotoRepository repository) {
		super(repository);
	}

}
