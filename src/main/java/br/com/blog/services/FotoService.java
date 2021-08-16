package br.com.blog.services;

import br.com.blog.commons.services.IBaseService;
import br.com.blog.entities.Foto;
import br.com.blog.repositories.FotoRepository;

public interface FotoService extends IBaseService<Foto, Long, FotoRepository> {
}
